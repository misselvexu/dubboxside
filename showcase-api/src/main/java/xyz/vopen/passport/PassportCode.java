package xyz.vopen.passport;

/**
 * 返回结果定义.
 *
 * @author Elve.xu
 */
public enum PassportCode {

    /**
     * 失败
     */
    FAIL(500, "fail"),
    /**
     * 成功
     */
    SUCCESS(200, "成功"),;


    private final int code;
    private final String msg;

    /**
     * default cont
     */
    PassportCode (int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 校验状态代码是否是已知的代码
     *
     * @param code 代码
     * @return return true if code is right otherwise return false
     */
    public static boolean validate (Integer code) {
        PassportCode[] codes = PassportCode.values();
        for (PassportCode temp : codes) {
            if (code == temp.code()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 转换 code
     *
     * @param code code 编码
     * @return return MemberCode instance
     */
    public static PassportCode parseCode (int code) {
        PassportCode[] codes = PassportCode.values();
        for (PassportCode temp : codes) {
            if (code == temp.code()) {
                return temp;
            }
        }
        throw new IllegalArgumentException("无效错误码:" + code + " ,@see PassportCode");
    }

    /**
     * 批量判断 code
     *
     * @param code  input code
     * @param codes except code
     * @return is true
     */
    public static Boolean assertCode (int code, PassportCode... codes) {
        try {
            if (codes != null && codes.length > 0) {
                PassportCode input = PassportCode.parseCode(code);
                for (PassportCode temp : codes) {
                    if (input.equals(temp)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * get code
     *
     * @return return code
     */
    public int code () {
        return code;
    }

    /**
     * get message
     *
     * @return return message desc
     */
    public String msg () {
        return msg;
    }

}