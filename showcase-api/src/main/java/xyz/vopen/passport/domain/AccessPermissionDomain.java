/**
 * Copyright 2016 VOPEN.XYZ.
 */
package xyz.vopen.passport.domain;

/**
 * 授权数据返回值
 *
 *
 * @author Elve.xu
 */
public class AccessPermissionDomain {

    /**
     * 请求者
     */
    private String requester;

    private String name;

    private int state;

    public String getRequester () {
        return requester;
    }

    public void setRequester (String requester) {
        this.requester = requester;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getState () {
        return state;
    }

    public void setState (int state) {
        this.state = state;
    }
}
