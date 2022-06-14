package com.rettichlp.UnicacityAddon.base.reflection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionUtils {

    private String inPackage;

    public ReflectionUtils(String inPackage) {
        this.inPackage = inPackage;
    }

    public List<Class> getClassesAnnotatedWith(Class<?> annotation) {
        return getAllClasses().stream().filter(aClass -> {
            Arrays.stream(aClass.getAnnotations()).filter(annotation1 -> annotation1.annotationType().equals(annotation));
            return true;
        }).collect(Collectors.toList());
    }

    public List<Method> getMethodsAnnotatedWith(Class<?> annotation) {
        List<Method> methods = new ArrayList<>();
        getAllClasses().forEach(clazz -> Arrays.asList(clazz.getMethods()).forEach(method -> {
            if (Arrays.asList(method.getAnnotations()).contains(annotation))
                methods.add(method);
        }));
        return methods;
    }

    private Set<Class> getAllClasses() {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(inPackage.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines().filter(line -> line.endsWith(".class")).map(line -> getClass(line, inPackage)).collect(Collectors.toSet());
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.getCause().printStackTrace();
        }
        return null;
    }
}
