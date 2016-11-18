/**
 * Copyright 2016 VOPEN.XYZ.
 */
package xyz.vopen.passport.domain;

/**
 * 授权返回值
 *
 *
 */
public class AuthorizerDomain {

    /**
     * 执行返回结果
     */
    private int resultCode;

    /**
     * 用户唯一标识
     */
    private int accountId;

    public int getResultCode () {
        return resultCode;
    }

    public void setResultCode (int resultCode) {
        this.resultCode = resultCode;
    }

    public int getAccountId () {
        return accountId;
    }

    public void setAccountId (int accountId) {
        this.accountId = accountId;
    }

}
