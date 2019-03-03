package de.bytelist.bytecloud.common;

import de.bytelist.bytecloud.common.server.CloudServer;
import de.bytelist.bytecloud.common.server.CloudServerGroup;

import java.util.Collection;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by ByteList on 20.07.2018.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public interface CloudAPI {

    public Logger getLogger();

    public Collection<CloudServerGroup> getServerGroups();

    public Collection<CloudServer> getServers();

    public Collection<CloudPlayer> getPlayers();

    public CloudServerGroup getServerGroup(String name);

    public CloudServer getServer(String serverId);

    public CloudPlayer getPlayer(UUID uuid);

    public CloudPlayer getPlayer(String name);

    public String getUniqueServerId(String server);

    public String getRandomLobbyId();

    public String getRandomLobbyId(String excludedLobby);

    public void movePlayerToLobby(UUID uuid);

    public void movePlayerToServer(UUID uuid, String serverId);

    public void kickPlayer(UUID uuid, String reason);

    public String getServerIdFromPlayer(UUID uuid);

    public UUID getUniqueIdFromName(String name);

}
