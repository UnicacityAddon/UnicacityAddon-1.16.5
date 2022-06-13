package com.rettichlp.UnicacityAddon.base.logger;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum LoggerType {
    INFO("[%DATETIME%] [INF]: user: " + AbstractionLayer.getPlayer().getName() + ", message: %MESSAGE%"),
    WARNUNG("[%DATETIME%] [WRN]: user: " + AbstractionLayer.getPlayer().getName() + ", message: %MESSAGE%, at: %CLASS%"),
    ERROR("[%DATETIME%] [ERR]: user: " + AbstractionLayer.getPlayer().getName() + ", message: %MESSAGE%, at: %CLASS%"),
    COMMAND("[%DATETIME%] [CMD]: user: " + AbstractionLayer.getPlayer().getName() + ", success: %SUCCESS%, command: %COMMAND%");

    private final String pattern;

    LoggerType(String pattern) {
        this.pattern = pattern;
    }

    public String get() {
        return pattern.replace("%DATETIME%", getDateTime());
    }

    private CharSequence getDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}