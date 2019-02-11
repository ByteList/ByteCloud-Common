package de.bytelist.bytecloud.common.bungee;


import de.bytelist.bytecloud.common.CloudAPI;
import de.bytelist.bytecloud.common.CloudPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

/**
 * Created by ByteList on 20.07.2018.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public interface BungeeCloudAPI extends CloudAPI {

    @Override
    public CloudPlayer<ProxiedPlayer> getPlayer(UUID uuid);

    @Override
    public CloudPlayer<ProxiedPlayer> getPlayer(String name);
}
