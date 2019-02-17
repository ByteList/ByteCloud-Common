package de.bytelist.bytecloud.common;

import lombok.Getter;

/**
 * Created by ByteList on 17.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class CloudSoftware {
    @Getter
    private static ICloudSoftware instance;

    public static void setInstance(ICloudSoftware software) {
        if(instance != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton CloudSoftware instance");
        }
        instance = software;
    }

    public interface ICloudSoftware {

        public Executable getExecutable(String serverId);
    }
}
