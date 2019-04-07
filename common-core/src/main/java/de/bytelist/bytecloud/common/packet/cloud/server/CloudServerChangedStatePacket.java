package de.bytelist.bytecloud.common.packet.cloud.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import de.bytelist.bytecloud.common.ServerState;
import lombok.Getter;

import java.io.IOException;

/**
 * Created by ByteList on 11.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class CloudServerChangedStatePacket implements Packet {

    @Getter
    private String serverId;
    @Getter
    private ServerState old, state;

    public CloudServerChangedStatePacket() {}

    public CloudServerChangedStatePacket(String serverId, ServerState old, ServerState state) {
        this.serverId = serverId;
        this.old = old;
        this.state = state;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.old = ServerState.valueOf(in.readString());
        this.state = ServerState.valueOf(in.readString());
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeString(this.old.name());
        out.writeString(this.state.name());
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
