package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ReflectiveChannelFactory<T extends Channel> implements ChannelFactory<T> {
    private final Constructor<? extends T> constructor;

    public ReflectiveChannelFactory(Class<? extends T> cls) {
        ObjectUtil.checkNotNull(cls, "clazz");
        try {
            this.constructor = cls.getConstructor(null);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + StringUtil.simpleClassName((Class<?>) cls) + " does not have a public non-arg constructor", e);
        }
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        try {
            return this.constructor.newInstance(null);
        } catch (Throwable th) {
            throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), th);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ReflectiveChannelFactory.class) + PropertyUtils.MAPPED_DELIM + StringUtil.simpleClassName((Class<?>) this.constructor.getDeclaringClass()) + ".class)";
    }
}
