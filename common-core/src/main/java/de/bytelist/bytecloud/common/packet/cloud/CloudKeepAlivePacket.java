package de.bytelist.bytecloud.common.packet.cloud;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import lombok.Getter;

import java.io.IOException;

/**
 * Created by ByteList on 17.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class CloudKeepAlivePacket implements Packet {

    @Getter
    private long pingId;

    public CloudKeepAlivePacket() {
    }

    public CloudKeepAlivePacket(long pingId) {
        this.pingId = pingId;
    }

    @Override
    public void read(NetInput in) throws IOException {
    }

    @Override
    public void write(NetOutput out) throws IOException {
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}