package com.rettichlp.UnicacityAddon.base.reflection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionUtils {

    public static List<Method> getMethodsAnnotatedWith(Class<?> annotationClass, String subPackage) {
        List<Method> methods = new ArrayList<>();
        getClassesInPackage(subPackage).forEach(clazz -> Arrays.stream(clazz.getMethods()).forEach(method -> {
            if (method.isAnnotationPresent((Class<? extends Annotation>) annotationClass)) methods.add(method);
        }));
        return methods;
    }

    public static List<Class<?>> getClassesAnnotatedWith(Class<?> annotation, String subPackage) {
        return getClassesInPackage(subPackage).stream().filter(clazz -> clazz.isAnnotationPresent((Class<? extends Annotation>) annotation)).collect(Collectors.toList());
    }

    private static Set<Class<?>> getClassesInPackage(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines().filter(line -> line.endsWith(".class")).map(line -> getClass(line, packageName)).collect(Collectors.toSet());
    }

    private static Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}