package de.bytelist.bytecloud.common;

/**
 * Created by nemmerich on 07.02.2019.
 * <p>
 * Copyright by nemmerich - https://bytelist.de/
 */
public interface CloudPermissionCheck<T> {

    public boolean hasPermission(String permission, T checker);

    public String getNoPermissionMessage();

}
