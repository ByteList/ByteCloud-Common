package de.bytelist.bytecloud.common.packet.cloud.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import lombok.Getter;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by ByteList on 03.03.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class CloudPlayerKickPacket implements Packet {

    @Getter
    private UUID uuid;
    @Getter
    private String reason;

    private CloudPlayerKickPacket() {
    }

    public CloudPlayerKickPacket(UUID uuid, String reason) {
        this.uuid = uuid;
        this.reason = reason;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.uuid = in.readUUID();
        this.reason = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeUUID(this.uuid);
        out.writeString(this.reason);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}