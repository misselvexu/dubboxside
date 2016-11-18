package xyz.vopen.passport.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.pyw.commons.core.serial.DomainSerializable;
import xyz.vopen.passport.PassportCode;

/**
 * 结果构建类<br>
 * <p/>
 * How to use:
 * <code>
 * <li>Result result = Result.newBuilder().result(Result.Code.SUCCESS).data(data).build();
 * <li>Result.newBuilder().result(Result.Code.SUCCESS ,data).build();
 * </code>
 *
 * @author Elve.xu
 * @version 1.1
 */
public final class Result<T> extends DomainSerializable {

    private static final long serialVersionUID = 64655331555509136L;

    /**
     * 结果状态码
     */
    @JSONField(serialize = true)
    private Integer code;

    /**
     * 消息描述
     */
    @JSONField(serialize = true)
    private String msg;

    /**
     * 数据结果
     */
    private T data;

    public Result () {
    }

    /**
     * Builder
     *
     * @param builder builder
     */
    private Result (Builder<T> builder) {
        this.code = builder.resultCode;
        this.msg = builder.resultMsg;
        this.data = builder.data;
    }

    public static <T> Builder<T> newBuilder () {
        return new Builder<T>();
    }

    @Override
    public String toString () {
        return JSON.toJSONString(this);
    }

    /**
     * 获取编码
     *
     * @return return code
     */
    public Integer getCode () {
        return code;
    }

    /**
     * set code
     *
     * @param code code
     */
    public void setCode (Integer code) {
        this.code = code;
    }

    /**
     * 获取 Message
     *
     * @return return message
     */
    public String getMsg () {
        return msg;
    }

    /**
     * set message
     *
     * @param msg message
     */
    public void setMsg (String msg) {
        this.msg = msg;
    }

    /**
     * 获取数据(泛型)
     *
     * @return 返回数据
     */
    public T getData () {
        return data;
    }

    /**
     * set data
     *
     * @param data data
     */
    public void setData (T data) {
        this.data = data;
    }

    /**
     * 直接转化成JSON字符串
     *
     * @return JSON字符串
     */
    public String string () {
        return toString();
    }

    /**
     * 直接转化成JSON字符串
     *
     * @return JSON字符串
     */
    public String json () {
        return toJson();
    }

    /**
     * inner builder
     */
    public static final class Builder<T> {

        private Integer resultCode;
        private String resultMsg;
        private T data;

        /**
         * build builder with Code
         *
         * @param resultCode result code
         * @return builder
         */
        public Builder<T> result (PassportCode resultCode) {
            this.resultCode = resultCode.code();
            this.resultMsg = resultCode.msg();
            return this;
        }

        public Builder<T> result (PassportCode resultCode, T data) {
            this.resultCode = resultCode.code();
            this.resultMsg = resultCode.msg();
            this.data = data;
            return this;
        }

        /**
         * build builder with Code
         *
         * @param code result code
         * @return builder
         */
        public Builder<T> result (Integer code, String msg) {
            return result(code, msg, null);
        }

        /**
         * build builder with Code
         *
         * @param code result code
         * @return builder
         */
        public Builder<T> result (Integer code, String msg, T data) {
            if (!PassportCode.validate(code)) {
                throw new IllegalArgumentException("无效错误码:" + code + " ,@see Result.Code");
            }
            this.resultCode = code;
            this.resultMsg = msg;
            this.data = data;
            return this;
        }

        /**
         * set data
         *
         * @param data data
         * @return return this
         */
        public Builder<T> data (T data) {
            this.data = data;
            return this;
        }

        /**
         * build result Object
         *
         * @return object instance
         */
        public Result<T> build () {
            return new Result<T>(this);
        }

        /**
         * 直接输出JSON String
         *
         * @return result -> json String
         */
        public String string () {
            return new Result<T>(this).toString();
        }

        /**
         * 直接输出JSON
         *
         * @return json
         */
        public String json () {
            return new Result<T>(this).toJson();
        }

    }
}