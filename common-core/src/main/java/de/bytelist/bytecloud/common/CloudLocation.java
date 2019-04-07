package de.bytelist.bytecloud.common;

import lombok.Getter;

/**
 * Created by ByteList on 07.04.2019.
 * <p>
 * Copyright by ByteList - https://bytelist.de/
 */
public class CloudLocation {

    @Getter
    private final String world;
    @Getter
    private final double x, y, z;
    @Getter
    private final float yaw, pitch;

    public CloudLocation(String world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    @Override
    public String toString() {
        return "CloudLocation[world="+this.world+", x="+this.x+", y="+this.y+", z="+this.z+", yaw="+this.yaw+", pitch="+this.pitch+"]";
    }

    public String toCoordinatesString() {
        return this.world+","+this.x+","+this.y+","+this.z+","+this.yaw+","+this.pitch;
    }

    public static CloudLocation fromCoordinatesString(String coordinatesString) {
        String[] coords = coordinatesString.split(",");
        return new CloudLocation(coords[0], Double.valueOf(coords[1]), Double.valueOf(coords[2]), Double.valueOf(coords[3]),
                Float.valueOf(coords[4]), Float.valueOf(coords[5]));
    }
}
