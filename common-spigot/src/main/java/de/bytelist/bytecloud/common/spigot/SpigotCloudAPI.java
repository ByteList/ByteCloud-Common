package de.bytelist.bytecloud.common.spigot;

import de.bytelist.bytecloud.common.CloudAPI;
import de.bytelist.bytecloud.common.CloudPlayer;
import de.bytelist.bytecloud.common.ServerState;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by ByteList on 03.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public interface SpigotCloudAPI extends CloudAPI {

    public String getCurrentServerId();

    public void changeServerState(ServerState serverState);

    public void setMotd(String motd);

    public void shutdown();

    @Override
    public CloudPlayer<Player> getPlayer(UUID uuid);

    @Override
    public CloudPlayer<Player> getPlayer(String name);
}
