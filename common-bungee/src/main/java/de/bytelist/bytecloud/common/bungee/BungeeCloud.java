package de.bytelist.bytecloud.common.bungee;

import de.bytelist.bytecloud.common.Cloud;

/**
 * Created by ByteList on 03.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public final class BungeeCloud {

    public static BungeeCloudPlugin getInstance() {
        return (BungeeCloudPlugin) Cloud.getInstance();
    }

}
