package de.bytelist.bytecloud.common;

import lombok.Getter;

/**
 * Created by nemmerich on 07.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public final class Cloud {

    public static final String PREFIX = "§bCloud §8\u00BB ";

    @Getter
    private static CloudPlugin instance;

    public static void setInstance(CloudPlugin plugin) {
        if(instance != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton Cloud instance");
        }
        instance = plugin;
    }
}
