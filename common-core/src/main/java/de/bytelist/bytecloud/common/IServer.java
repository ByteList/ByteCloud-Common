package de.bytelist.bytecloud.common;

/**
 * Created by nemmerich on 10.03.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public interface IServer extends Executable {

    public void setServerState(ServerState serverState);

    public void setMotd(String motd);

    public void addPlayer(CloudPlayer cloudPlayer);
}
