package de.bytelist.bytecloud.common.packet;

import io.netty.buffer.ByteBuf;

/**
 * Created by nemmerich on 11.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public interface Packet {

    public void read(ByteBuf in);

    public void write(ByteBuf out);
}
