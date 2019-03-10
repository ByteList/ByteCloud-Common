package de.bytelist.bytecloud.common.packet.client.player;

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
public class ClientPlayerConnectPacket implements Packet {

    @Getter
    private UUID uuid;
    @Getter
    private String name;

    private ClientPlayerConnectPacket() {
    }

    public ClientPlayerConnectPacket(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.uuid = in.readUUID();
        this.name = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeUUID(this.uuid);
        out.writeString(this.name);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}