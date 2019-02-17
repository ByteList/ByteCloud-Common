package de.bytelist.bytecloud.common;

import com.github.steveice10.packetlib.Session;

/**
 * Created by ByteList on 09.08.2017.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public interface Executable {

    public Session getSession();

    public void setSession(Session session);

    public boolean startServer(String sender);

    public boolean stopServer(String sender);

    public void onStart();
}
