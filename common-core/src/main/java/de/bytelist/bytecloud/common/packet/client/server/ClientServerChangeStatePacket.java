package de.bytelist.bytecloud.common.packet.client.server;

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
public class ClientServerChangeStatePacket implements Packet {

    @Getter
    private String serverId;
    @Getter
    private ServerState state;

    public ClientServerChangeStatePacket() {}

    public ClientServerChangeStatePacket(String serverId, ServerState state) {
        this.serverId = serverId;
        this.state = state;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.state = ServerState.valueOf(in.readString());
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeString(this.state.name());
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
