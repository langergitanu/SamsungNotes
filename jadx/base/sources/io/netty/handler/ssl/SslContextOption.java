package io.netty.handler.ssl;

import io.netty.util.AbstractConstant;
import io.netty.util.ConstantPool;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SslContextOption<T> extends AbstractConstant<SslContextOption<T>> {
    private static final ConstantPool<SslContextOption<Object>> pool = new ConstantPool<SslContextOption<Object>>() { // from class: io.netty.handler.ssl.SslContextOption.1
        @Override // io.netty.util.ConstantPool
        public SslContextOption<Object> newConstant(int i, String str) {
            return new SslContextOption<>(i, str);
        }
    };

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> SslContextOption<T> valueOf(String str) {
        return (SslContextOption) pool.valueOf(str);
    }

    public void validate(T t) {
        ObjectUtil.checkNotNull(t, "value");
    }

    private SslContextOption(int i, String str) {
        super(i, str);
    }

    public static <T> SslContextOption<T> valueOf(Class<?> cls, String str) {
        return (SslContextOption) pool.valueOf(cls, str);
    }

    public SslContextOption(String str) {
        this(pool.nextId(), str);
    }
}
