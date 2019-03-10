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
public class ClientPlayerDisconnectPacket implements Packet {

    @Getter
    private UUID uuid;

    private ClientPlayerDisconnectPacket() {
    }

    public ClientPlayerDisconnectPacket(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.uuid = in.readUUID();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeUUID(this.uuid);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}