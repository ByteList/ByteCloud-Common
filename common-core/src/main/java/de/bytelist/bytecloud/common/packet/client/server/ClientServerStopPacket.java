package de.bytelist.bytecloud.common.packet.client.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import lombok.Getter;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by ByteList on 05.04.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class ClientServerStopPacket implements Packet {

    @Getter
    private String serverId;
    @Getter
    private UUID sender;

    public ClientServerStopPacket() {}

    public ClientServerStopPacket(String serverId, UUID sender) {
        this.serverId = serverId;
        this.sender = sender;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.sender = in.readUUID();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeUUID(this.sender);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}