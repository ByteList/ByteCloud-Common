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
public class PingPacket implements Packet {

    @Getter
    private String id;

    public PingPacket(String id) {
        this.id = id;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.id = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.id);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
