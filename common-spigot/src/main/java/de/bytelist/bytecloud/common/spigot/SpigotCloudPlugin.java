package de.bytelist.bytecloud.common.spigot;

import de.bytelist.bytecloud.common.CloudPermissionCheck;
import de.bytelist.bytecloud.common.CloudPlugin;
import org.bukkit.entity.Player;

/**
 * Created by ByteList on 03.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public interface SpigotCloudPlugin extends CloudPlugin {

    @Override
    public SpigotCloudAPI getCloudAPI();

    @Override
    public CloudPermissionCheck<Player> getPermissionCheck();

}
