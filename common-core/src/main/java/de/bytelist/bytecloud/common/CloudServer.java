package de.bytelist.bytecloud.common;

import java.util.List;

/**
 * Created by nemmerich on 11.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public interface CloudServer {

    public String getServerId();

    public String getServerGroup();

    public boolean isServerPermanent();

    public ServerState getServerState();

    public int getSlots();

    public List<CloudPlayer> getPlayers();

    public String getMotd();
}
