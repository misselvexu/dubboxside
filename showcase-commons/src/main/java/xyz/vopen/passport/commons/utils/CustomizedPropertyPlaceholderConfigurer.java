package xyz.vopen.passport.commons.utils;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Map;
import java.util.Properties;

/**
 * 自定义PropertyPlaceholderConfigure返回properties内容.
 *
 * @author Elve.xu
 * @version 1.2
 */
public class CustomizedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static Map<String, Object> ctxPropertiesMap = Maps.newHashMap();

    @SuppressWarnings("unchecked")
    public static <T> T getContextProperty (String name, Class<T> clazz) {
        Object o = ctxPropertiesMap.get(name);
        if (o != null) {
            return (T) o;
        }
        return null;
    }

    public static Object getContextProperty (String name) {
        return ctxPropertiesMap.get(name);
    }

    @Override
    protected void processProperties (ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        logger.info("start to load properties file");
        long start = System.currentTimeMillis();
        super.processProperties(beanFactoryToProcess, props);
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
            logger.info("read properties, key = [" + key + "], value = [" + value + "]");
        }
        logger.info("loaded !, Times : " + (System.currentTimeMillis() - start) + "ms");
    }

}