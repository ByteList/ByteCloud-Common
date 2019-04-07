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
public class ClientServerStartPacket implements Packet {

    @Getter
    private String serverGroup;
    @Getter
    private String permanentServer;
    @Getter
    private UUID sender;

    private ClientServerStartPacket() {
    }

    public ClientServerStartPacket(String server, boolean isGroup, UUID sender) {
        if(isGroup) {
            this.serverGroup = server;
            this.permanentServer = "{null}";
        } else {
            this.serverGroup = "{null}";
            this.permanentServer = server;
        }

        this.sender = sender;
    }


    @Override
    public void read(NetInput in) throws IOException {
        this.serverGroup = in.readString();
        this.permanentServer = in.readString();
        this.sender = in.readUUID();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverGroup);
        out.writeString(this.permanentServer);
        out.writeUUID(this.sender);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}