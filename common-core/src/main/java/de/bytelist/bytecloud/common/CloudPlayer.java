package de.bytelist.bytecloud.common;

import de.bytelist.bytecloud.common.server.CloudServer;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by nemmerich on 11.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public class CloudPlayer {

    @Getter
    private final UUID uuid;
    @Getter
    private final String name;
    @Getter @Setter
    private CloudServer currentServer;
    @Getter@Setter
    private CloudLocation location;
    @Getter@Setter
    private boolean teleportOnJoinEnabled;

    public CloudPlayer(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

}
