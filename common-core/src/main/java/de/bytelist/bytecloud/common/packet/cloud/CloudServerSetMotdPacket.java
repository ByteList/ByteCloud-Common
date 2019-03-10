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
public class CloudServerSetMotdPacket implements Packet {

    @Getter
    private String serverId;
    @Getter
    private String motd;

    public CloudServerSetMotdPacket() {}

    public CloudServerSetMotdPacket(String serverId, String motd) {
        this.serverId = serverId;
        this.motd = motd;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.motd = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeString(this.motd);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}
