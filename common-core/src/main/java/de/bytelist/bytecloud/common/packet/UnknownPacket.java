package de.bytelist.bytecloud.common.packet;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

import java.io.IOException;

/**
 * Created by nemmerich on 17.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public class UnknownPacket implements Packet {

    public UnknownPacket() {}

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