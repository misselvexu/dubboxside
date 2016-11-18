/**
 * Copyright 2016 VOPEN.XYZ.
 */
package xyz.vopen.passport.serial;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.google.common.collect.Lists;
import xyz.vopen.passport.beans.Authorizer;
import xyz.vopen.passport.domain.AccessPermissionDomain;
import xyz.vopen.passport.domain.AuthorizerDomain;

import java.util.Collection;
import java.util.List;

/**
 * 自定义序列化.
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @SuppressWarnings("rawtypes")
    @Override
    public Collection<Class> getSerializableClasses () {
        List<Class> classes = Lists.newLinkedList();
        classes.add(Authorizer.class);
        classes.add(AccessPermissionDomain.class);
        classes.add(AuthorizerDomain.class);

        return classes;
    }

}
