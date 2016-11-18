/**
 * Copyright 2016 VOPEN.XYZ.
 */
package xyz.vopen.passport.beans;

import com.pyw.commons.core.serial.DomainSerializable;

/**
 * 授权请求结果.
 *
 * @author Elve.xu
 */
public class Authorizer extends DomainSerializable {
    private static final long serialVersionUID = 1L;

    /**
     * 结果码
     */
    private Integer resultCode;

    /**
     * 结果描述
     */
    private String resultMsg;

    /**
     * 用户唯一标识
     */
    private String accountId;

    public Integer getResultCode () {
        return resultCode;
    }

    public void setResultCode (Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg () {
        return resultMsg;
    }

    public void setResultMsg (String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getAccountId () {
        return accountId;
    }

    public void setAccountId (String accountId) {
        this.accountId = accountId;
    }

}
