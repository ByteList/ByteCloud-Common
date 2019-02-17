package de.bytelist.bytecloud.common.packet;

import com.github.steveice10.packetlib.packet.Packet;
import de.bytelist.bytecloud.common.packet.client.ClientKeepAlivePacket;
import de.bytelist.bytecloud.common.packet.client.ClientServerStartedPacket;
import de.bytelist.bytecloud.common.packet.client.ClientServerStoppedPacket;
import de.bytelist.bytecloud.common.packet.cloud.CloudServerInfoPacket;
import de.bytelist.bytecloud.common.packet.cloud.CloudServerStartedPacket;
import de.bytelist.bytecloud.common.packet.cloud.CloudServerStoppedPacket;
import de.bytelist.bytecloud.common.packet.cloud.CloudKeepAlivePacket;
import lombok.Getter;

import java.util.function.BiConsumer;

/**
 * Created by ByteList on 17.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public enum PacketInfo {

    UNKNOWN_PACKET(UnknownPacket.class),


    CLIENT_KEEP_ALIVE_PACKET(ClientKeepAlivePacket.class),
    CLIENT_SERVER_STARTED_PACKET(ClientServerStartedPacket.class),
    CLIENT_SERVER_STOPPED_PACKET(ClientServerStoppedPacket.class),


    CLOUD_KEEP_ALIVE_PACKET(CloudKeepAlivePacket.class),
    CLOUD_SERVER_STARTED_PACKET(CloudServerStartedPacket.class),
    CLOUD_SERVER_STOPPED_PACKET(CloudServerStoppedPacket.class),
    CLOUD_SERVER_INFO_PACKET(CloudServerInfoPacket.class);


    @Getter
    private final String packetName;
    @Getter
    private final Class<? extends Packet> packet;

    PacketInfo(Class<? extends Packet> packet) {
        this.packetName = packet.getSimpleName();
        this.packet = packet;
    }

    public static void forEach(BiConsumer<String, Class<? extends Packet>> consumer) {
        for (PacketInfo packetInfo : values()) {
            consumer.accept(packetInfo.packetName, packetInfo.packet);
        }
    }

    public static PacketInfo fromName(String name) {
        for (PacketInfo packetInfo : values()) {
            if(packetInfo.getPacketName().equals(name)) {
                return packetInfo;
            }
        }
        return UNKNOWN_PACKET;
    }

    public static PacketInfo fromClass(Class<? extends Packet> packet) {
        for (PacketInfo packetInfo : values()) {
            if(packetInfo.getPacketName().equals(packet.getSimpleName())) {
                return packetInfo;
            }
        }
        return UNKNOWN_PACKET;
    }
}
