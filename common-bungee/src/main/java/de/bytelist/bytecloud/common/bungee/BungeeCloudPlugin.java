package de.bytelist.bytecloud.common.bungee;

import de.bytelist.bytecloud.common.CloudPermissionCheck;
import de.bytelist.bytecloud.common.CloudPlugin;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * Created by ByteList on 03.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public interface BungeeCloudPlugin extends CloudPlugin {

    public BungeeCloudAPI getCloudAPI();

    public  String getForcedJoinServerId();

    @Override
    public CloudPermissionCheck<ProxiedPlayer> getPermissionCheck();

}
