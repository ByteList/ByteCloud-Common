package de.bytelist.bytecloud.common;

import lombok.Getter;

import java.util.UUID;

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

        public IServer getIServer(String serverId);

        public void connectPlayer(CloudPlayer cloudPlayer);

        public void disconnectPlayer(UUID uuid);

        public void kickPlayer(UUID uuid, String reason);

        public void setCurrentServer(UUID uuid, String serverId);

        public void startTempServer(String serverGroup, UUID sender);

        public void startPermServer(String server, UUID sender);

        public void stopServer(String serverId, UUID sender);
    }
}
