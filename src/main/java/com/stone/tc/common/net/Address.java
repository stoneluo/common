package com.stone.tc.common.net;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.net.InetSocketAddress;

/**
 * @author shifeng.luo
 * @version created on 2018/6/9 下午1:53
 */
public class Address {
    private String ip;
    private int port;

    public Address() {
    }

    public Address(InetSocketAddress socketAddress) {
        Preconditions.checkNotNull(socketAddress);
        this.ip = socketAddress.getAddress().getHostAddress();
        this.port = socketAddress.getPort();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Address)) {
            return false;
        }

        Address address = (Address) object;
        return address.ip.equals(this.ip) && this.port == address.port;
    }

    @Override
    public int hashCode() {
        return ip == null ? port : ip.hashCode() + port;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
