package de.bytelist.bytecloud.common;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by nemmerich on 11.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public class CloudPlayer<T> {

    @Getter
    private final T player;
    @Getter
    private final UUID uuid;
    @Getter
    private final String name;
    @Getter @Setter
    private CloudServer currentServer;

    public CloudPlayer(T player, UUID uuid, String name) {
        this.player = player;
        this.uuid = uuid;
        this.name = name;
    }
}
