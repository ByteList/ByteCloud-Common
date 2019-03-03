package de.bytelist.bytecloud.common.server;

import de.bytelist.bytecloud.common.packet.cloud.CloudServerGroupInfoPacket;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by ByteList on 03.03.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class CloudServerGroup {

    @Getter
    private String groupName;
    @Getter
    private String prefix;
    @Getter
    private int maxServers;
    @Getter
    private int slotsPerServer;

    private List<CloudServer> cloudServers = new ArrayList<>();

    public CloudServerGroup(CloudServerGroupInfoPacket cloudServerGroupInfoPacket) {
        this.groupName = cloudServerGroupInfoPacket.getGroupName();
        this.prefix = cloudServerGroupInfoPacket.getPrefix();
        this.maxServers = cloudServerGroupInfoPacket.getMaxServers();
        this.slotsPerServer = cloudServerGroupInfoPacket.getSlotsPerServer();
    }


    public Collection<CloudServer> getServers() {
        return Collections.unmodifiableCollection(this.cloudServers);
    }

    public void addServer(CloudServer cloudServer) {
        this.cloudServers.add(cloudServer);
    }

    public void removeServer(CloudServer cloudServer) {
        this.cloudServers.remove(cloudServer);
    }
}
