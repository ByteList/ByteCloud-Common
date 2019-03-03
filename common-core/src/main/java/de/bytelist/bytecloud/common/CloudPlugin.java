package de.bytelist.bytecloud.common;

/**
 * Created by nemmerich on 07.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public interface CloudPlugin {

    public String getServerId();

    public String getVersion();

    public CloudAPI getCloudAPI();

    public CloudPermissionCheck getPermissionCheck();

}
