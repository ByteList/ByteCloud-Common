package de.bytelist.bytecloud.common.packet.cloud;

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
public class CloudServerStartedPacket implements Packet {

    @Getter
    private String serverId;
    @Getter
    private int port;

    public CloudServerStartedPacket() {}

    public CloudServerStartedPacket(String serverId, int port) {
        this.serverId = serverId;
        this.port = port;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.port = in.readInt();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeInt(this.port);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
