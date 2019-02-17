package de.bytelist.bytecloud.common.packet.cloud;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import lombok.Getter;

import java.io.IOException;

/**
 * Created by nemmerich on 17.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public class CloudServerInfoPacket implements Packet {

    @Getter
    private String serverId, serverGroup, motd, serverState;
    @Getter
    private boolean serverPermanent;
    @Getter
    private int slots;
    @Getter
    private String players;

    public CloudServerInfoPacket() {}

    public CloudServerInfoPacket(String serverId, String serverGroup, String motd, String serverState, boolean serverPermanent, int slots, String players) {
        this.serverId = serverId;
        this.serverGroup = serverGroup;
        this.motd = motd;
        this.serverState = serverState;
        this.serverPermanent = serverPermanent;
        this.slots = slots;
        this.players = players;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.serverId = in.readString();
        this.serverGroup = in.readString();
        this.serverPermanent = in.readBoolean();
        this.serverState = in.readString();
        this.slots = in.readInt();
        this.players = in.readString();
        this.motd = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.serverId);
        out.writeString(this.serverGroup);
        out.writeBoolean(this.serverPermanent);
        out.writeString(this.serverState);
        out.writeInt(this.slots);
        out.writeString(this.players);
        out.writeString(this.motd);

    }

    @Override
    public boolean isPriority() {
        return false;
    }
}