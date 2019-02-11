package de.bytelist.bytecloud.common;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by ByteList on 20.07.2018.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public interface CloudAPI {

    public Collection<String> getServers();

    public String getUniqueServerId(String server);

    public String getRandomLobbyId();

    public String getRandomLobbyId(String excludedLobby);

    public void movePlayerToLobby(UUID uuid);

    public void movePlayerToServer(UUID uuid, String serverId);

    public void kickPlayer(String playerName, String reason);

    public String getServerIdFromPlayer(UUID uuid);

    public UUID getUniqueIdFromName(String name);

    public CloudPlayer getPlayer(UUID uuid);

    public CloudPlayer getPlayer(String name);

}
