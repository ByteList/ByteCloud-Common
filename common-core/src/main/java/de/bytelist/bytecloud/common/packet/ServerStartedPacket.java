package de.bytelist.bytecloud.common.packet;

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
public class ServerStartedPacket implements Packet {

    public static final String PACKET_NAME = "ServerStartedPacket";

    @Getter
    private String serverId;

    public ServerStartedPacket() {}

    public ServerStartedPacket(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
