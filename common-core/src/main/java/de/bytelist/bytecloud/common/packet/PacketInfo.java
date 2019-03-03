package de.bytelist.bytecloud.common.packet;

import com.github.steveice10.packetlib.packet.Packet;
import de.bytelist.bytecloud.common.packet.client.ClientKeepAlivePacket;
import de.bytelist.bytecloud.common.packet.client.ClientServerStartedPacket;
import de.bytelist.bytecloud.common.packet.client.ClientServerStoppedPacket;
import de.bytelist.bytecloud.common.packet.cloud.*;
import de.bytelist.bytecloud.common.packet.cloud.player.*;
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
    CLOUD_SERVER_CHANGED_STATE_PACKET(CloudServerChangedStatePacket.class),
    CLOUD_SERVER_STARTED_PACKET(CloudServerStartedPacket.class),
    CLOUD_SERVER_STOPPED_PACKET(CloudServerStoppedPacket.class),
    CLOUD_SERVER_GROUP_INFO_PACKET(CloudServerGroupInfoPacket.class),

    CLOUD_PLAYER_CONNECT_PACKET(CloudPlayerConnectPacket.class),
    CLOUD_PLAYER_DISCONNECT_PACKET(CloudPlayerDisconnectPacket.class),
    CLOUD_PLAYER_KICK_PACKET(CloudPlayerKickPacket.class),
    CLOUD_PLAYER_MESSAGE_PACKET(CloudPlayerMessagePacket.class),
    CLOUD_PLAYER_SERVER_SWITCH_PACKET(CloudPlayerServerSwitchPacket.class),


    ;


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
