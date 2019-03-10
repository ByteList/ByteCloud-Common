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
public class CloudServerGroupInfoPacket implements Packet {

    @Getter
    private String groupName;
    @Getter
    private String prefix;
    @Getter
    private int maxServers;
    @Getter
    private int slotsPerServer;

    private CloudServerGroupInfoPacket() {}

    public CloudServerGroupInfoPacket(String groupName, String prefix, int maxServers, int slotsPerServer) {
        this.groupName = groupName;
        this.prefix = prefix;
        this.maxServers = maxServers;
        this.slotsPerServer = slotsPerServer;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.groupName = in.readString();
        this.prefix = in.readString();
        this.maxServers = in.readInt();
        this.slotsPerServer = in.readInt();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.groupName);
        out.writeString(this.prefix);
        out.writeInt(this.maxServers);
        out.writeInt(this.slotsPerServer);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
