package de.bytelist.bytecloud.common.spigot;

import de.bytelist.bytecloud.common.Cloud;
import lombok.Getter;

/**
 * Created by ByteList on 03.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public final class SpigotCloud {

    public static SpigotCloudPlugin getInstance() {
        return (SpigotCloudPlugin) Cloud.getInstance();
    }

}
