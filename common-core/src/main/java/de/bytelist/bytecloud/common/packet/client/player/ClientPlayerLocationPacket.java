package de.bytelist.bytecloud.common.packet.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import de.bytelist.bytecloud.common.CloudLocation;
import lombok.Getter;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by ByteList on 03.03.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class ClientPlayerLocationPacket implements Packet {

    @Getter
    private UUID uuid;
    @Getter
    private CloudLocation location;
    @Getter
    private boolean teleportOnJoinEnabled;
    @Getter
    private String serverId;

    private ClientPlayerLocationPacket() {
    }

    public ClientPlayerLocationPacket(UUID uuid, CloudLocation location, boolean teleportOnJoin, String serverId) {
        this.uuid = uuid;
        this.location = location;
        this.teleportOnJoinEnabled = teleportOnJoin;
        this.serverId = serverId;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.uuid = in.readUUID();
        this.location = CloudLocation.fromCoordinatesString(in.readString());
        this.teleportOnJoinEnabled = in.readBoolean();
        this.serverId = in.readString();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeUUID(this.uuid);
        out.writeString(this.location.toCoordinatesString());
        out.writeBoolean(this.teleportOnJoinEnabled);
        out.writeString(this.serverId);
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}