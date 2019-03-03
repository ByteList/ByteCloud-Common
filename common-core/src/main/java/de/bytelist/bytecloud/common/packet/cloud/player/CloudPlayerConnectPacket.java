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
public class CloudPlayerConnectPacket implements Packet {

    @Getter
    private String name;
    @Getter
    private UUID uuid;

    public CloudPlayerConnectPacket() {
    }

    public CloudPlayerConnectPacket(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.name = in.readString();
        this.uuid = in.readUUID();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.name);
        out.writeUUID(this.uuid);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}