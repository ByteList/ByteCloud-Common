package de.bytelist.bytecloud.common.packet.cloud.player;

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
public class CloudPlayerTeleportPacket implements Packet {

    @Getter
    private UUID uuid;
    @Getter
    private CloudLocation location;

    private CloudPlayerTeleportPacket() {
    }

    public CloudPlayerTeleportPacket(UUID uuid, CloudLocation location) {
        this.uuid = uuid;
        this.location = location;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.uuid = in.readUUID();
        this.location = CloudLocation.fromCoordinatesString(in.readString());
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeUUID(this.uuid);
        out.writeString(this.location.toCoordinatesString());
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}