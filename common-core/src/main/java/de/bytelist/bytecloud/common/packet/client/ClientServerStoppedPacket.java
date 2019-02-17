package de.bytelist.bytecloud.common.packet.client;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import lombok.Getter;

import java.io.IOException;

/**
 * Created by ByteList on 11.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class ClientServerStoppedPacket implements Packet {

    @Getter
    private String serverId, reason;

    public ClientServerStoppedPacket() {}

    public ClientServerStoppedPacket(String serverId, String reason) {
        this.serverId = serverId;
        this.reason = reason;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.reason = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeString(this.reason);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
