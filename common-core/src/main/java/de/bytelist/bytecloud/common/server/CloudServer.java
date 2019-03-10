package de.bytelist.bytecloud.common.server;

import de.bytelist.bytecloud.common.Cloud;
import de.bytelist.bytecloud.common.CloudPlayer;
import de.bytelist.bytecloud.common.ServerState;
import de.bytelist.bytecloud.common.packet.cloud.CloudServerStartedPacket;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by nemmerich on 11.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public class CloudServer{

    @Getter
    private String serverId;
    @Getter
    private CloudServerGroup serverGroup;
    @Getter
    private boolean serverPermanent, running;
    @Getter @Setter
    private ServerState serverState;
    @Getter
    private int slots;
    @Getter
    private String motd, stopServerReason;

    private List<CloudPlayer> cloudPlayers = new ArrayList<>();

    public CloudServer(CloudServerStartedPacket cloudServerStartedPacket) {
        this.serverId = cloudServerStartedPacket.getServerId();
        this.serverGroup = Cloud.getInstance().getCloudAPI().getServerGroup(cloudServerStartedPacket.getServerGroup());
        this.serverPermanent = cloudServerStartedPacket.isServerPermanent();
        this.serverState = ServerState.STARTING;
        this.slots = cloudServerStartedPacket.getSlots();
        this.motd = cloudServerStartedPacket.getMotd();
        this.running = true;
    }

    public Collection<CloudPlayer> getPlayers() {
        return Collections.unmodifiableCollection(this.cloudPlayers);
    }

    public void addPlayer(CloudPlayer cloudPlayer) {
        this.cloudPlayers.add(cloudPlayer);
    }

    public void removePlayer(CloudPlayer cloudPlayer) {
        this.cloudPlayers.remove(cloudPlayer);
    }

    public void syncStop(String reason) {
        this.running = false;
        this.stopServerReason = reason;
        this.cloudPlayers.clear();
        this.motd = reason;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }
}
