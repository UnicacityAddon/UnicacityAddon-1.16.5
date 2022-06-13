package com.rettichlp.UnicacityAddon.base.logger;

import java.util.List;

public class LoggerAPI {

    public static void info(String message) {
        uploadLog(LoggerType.INFO.get().replace("%MESSAGE%", message));
    }

    public static void warning(String message, Class<?> clazz) {
        uploadLog(LoggerType.WARNUNG.get()
                .replace("%MESSAGE%", message)
                .replace("%CLASS%", clazz.getName()));
    }

    public static void error(String message, Class<?> clazz) {
        uploadLog(LoggerType.ERROR.get()
                .replace("%MESSAGE%", message)
                .replace("%CLASS%", clazz.getName()));
    }

    public static void command(String label, List<String> args, boolean success) {
        uploadLog(LoggerType.COMMAND.get()
                .replace("%SUCCESS%", "" + success)
                .replace("%COMMAND%", "/" + label + " " + args));
    }

    private static void uploadLog(String s) {
        System.out.println(s);
    }
}

