package de.bytelist.bytecloud.common.packet;

import com.github.steveice10.packetlib.packet.Packet;
import de.bytelist.bytecloud.common.packet.client.ClientKeepAlivePacket;
import de.bytelist.bytecloud.common.packet.client.player.*;
import de.bytelist.bytecloud.common.packet.client.server.*;
import de.bytelist.bytecloud.common.packet.cloud.CloudKeepAlivePacket;
import de.bytelist.bytecloud.common.packet.cloud.player.*;
import de.bytelist.bytecloud.common.packet.cloud.server.*;
import lombok.Getter;

import java.util.function.BiConsumer;

/**
 * Created by ByteList on 17.02.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public enum PacketInfo {

    UNKNOWN_PACKET(UnknownPacket.class),

    /*
     *  Client
     */
    CLIENT_KEEP_ALIVE_PACKET(ClientKeepAlivePacket.class),

    CLIENT_PLAYER_CONNECT_PACKET(ClientPlayerConnectPacket.class),
    CLIENT_PLAYER_DISCONNECT_PACKET(ClientPlayerDisconnectPacket.class),
    CLIENT_PLAYER_KICK_PACKET(ClientPlayerKickPacket.class),
    CLIENT_PLAYER_LOCATION_PACKET(ClientPlayerLocationPacket.class),
    CLIENT_PLAYER_SERVER_SWITCH_PACKET(ClientPlayerServerSwitchPacket.class),

    CLIENT_SERVER_CHANGE_STATE_PACKET(ClientServerChangeStatePacket.class),
    CLIENT_SERVER_SET_MOTD_PACKET(ClientServerSetMotdPacket.class),
    CLIENT_SERVER_START_PACKET(ClientServerStartPacket.class),
    CLIENT_SERVER_STARTED_PACKET(ClientServerStartedPacket.class),
    CLIENT_SERVER_STOP_PACKET(ClientServerStopPacket.class),
    CLIENT_SERVER_STOPPED_PACKET(ClientServerStoppedPacket.class),

    /*
     *  Cloud
     */
    CLOUD_KEEP_ALIVE_PACKET(CloudKeepAlivePacket.class),

    CLOUD_PLAYER_CONNECT_PACKET(CloudPlayerConnectPacket.class),
    CLOUD_PLAYER_DISCONNECT_PACKET(CloudPlayerDisconnectPacket.class),
    CLOUD_PLAYER_KICK_PACKET(CloudPlayerKickPacket.class),
    CLOUD_PLAYER_LOCATION_PACKET(CloudPlayerLocationPacket.class),
    CLOUD_PLAYER_MESSAGE_PACKET(CloudPlayerMessagePacket.class),
    CLOUD_PLAYER_MOVE_TO_SERVER_PACKET(CloudPlayerMoveToServerPacket.class),
    CLOUD_PLAYER_SERVER_SWITCH_PACKET(CloudPlayerServerSwitchPacket.class),
    CLOUD_PLAYER_TELEPORT_PACKET(CloudPlayerTeleportPacket.class),

    CLOUD_SERVER_CHANGED_STATE_PACKET(CloudServerChangedStatePacket.class),
    CLOUD_SERVER_STARTED_PACKET(CloudServerStartedPacket.class),
    CLOUD_SERVER_STOPPED_PACKET(CloudServerStoppedPacket.class),
    CLOUD_SERVER_GROUP_INFO_PACKET(CloudServerGroupInfoPacket.class),
    CLOUD_SERVER_SET_MOTD_PACKET(CloudServerSetMotdPacket.class),



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
