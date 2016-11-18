package xyz.vopen.passport.commons.utils;

/**
 * Application properties Holder <br/>
 * <pre>
 *     useage :
 *      <code>
 *     PropertiesHolder.getValue(String key ,Class clazz , String defaultValue);
 *      </code>
 * </pre>
 * Created by ive on 03/11/2016.
 */
public final class PropertiesHolder {

    /**
     * 根据 Key 获取应用程序中的配置
     *
     * @param key          properties key
     * @param defaultValue default value
     * @return return value if exist ,otherwise return <code>defaultValue</code>
     */
    public static String getStringValue (String key, String defaultValue) {

        Object value = CustomizedPropertyPlaceholderConfigurer.getContextProperty(key);
        if (value != null) {
            return value.toString();
        }
        return defaultValue;
    }


    /**
     * 根据 Key 获取应用程序中的配置
     *
     * @param key          properties key
     * @param defaultValue default value
     * @return return value if exist ,otherwise return <code>defaultValue</code>
     */
    public static Boolean getBooleanValue (String key, Boolean defaultValue) {
        Object value = CustomizedPropertyPlaceholderConfigurer.getContextProperty(key);
        if (value != null) {
            return Boolean.valueOf(value.toString());
        }
        return defaultValue;
    }

    /**
     * 根据 Key 获取应用程序中的配置
     *
     * @param key          properties key
     * @param defaultValue default value
     * @return return value if exist ,otherwise return <code>defaultValue</code>
     */
    public static Integer getIntegerValue (String key, Integer defaultValue) {
        Object value = CustomizedPropertyPlaceholderConfigurer.getContextProperty(key);
        if (value != null) {
            return Integer.valueOf(value.toString());
        }
        return defaultValue;
    }

    /**
     * 根据 Key 获取应用程序中的配置
     *
     * @param key          properties key
     * @param defaultValue default value
     * @return return value if exist ,otherwise return <code>defaultValue</code>
     */
    public static Double getIntegerValue (String key, Double defaultValue) {
        Object value = CustomizedPropertyPlaceholderConfigurer.getContextProperty(key);
        if (value != null) {
            return Double.valueOf(value.toString());
        }
        return defaultValue;
    }

    /**
     * 根据 Key 获取应用程序中的配置
     *
     * @param key          properties key
     * @param defaultValue default value
     * @return return value if exist ,otherwise return <code>defaultValue</code>
     */
    public static Float getFloatValue (String key, Float defaultValue) {
        Object value = CustomizedPropertyPlaceholderConfigurer.getContextProperty(key);
        if (value != null) {
            return Float.valueOf(value.toString());
        }
        return defaultValue;
    }

}
