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
    @Getter
    private String serverGroup;
    @Getter
    private boolean serverPermanent;
    @Getter
    private int slots;
    @Getter
    private String motd;

    private CloudServerStartedPacket() {}

    public CloudServerStartedPacket(String serverId, int port, String serverGroup, boolean serverPermanent, int slots, String motd) {
        this.serverId = serverId;
        this.port = port;
        this.serverGroup = serverGroup;
        this.serverPermanent = serverPermanent;
        this.slots = slots;
        this.motd = motd;
    }


    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.port = in.readInt();
        this.serverGroup = in.readString();
        this.serverPermanent = in.readBoolean();
        this.slots = in.readInt();
        this.motd = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeInt(this.port);
        out.writeString(this.serverGroup);
        out.writeBoolean(this.serverPermanent);
        out.writeInt(this.slots);
        out.writeString(this.motd);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
