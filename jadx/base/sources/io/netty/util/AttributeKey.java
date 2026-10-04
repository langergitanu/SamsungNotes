package io.netty.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() { // from class: io.netty.util.AttributeKey.1
        @Override // io.netty.util.ConstantPool
        public AttributeKey<Object> newConstant(int i, String str) {
            return new AttributeKey<>(i, str);
        }
    };

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> AttributeKey<T> newInstance(String str) {
        return (AttributeKey) pool.newInstance(str);
    }

    public static <T> AttributeKey<T> valueOf(String str) {
        return (AttributeKey) pool.valueOf(str);
    }

    private AttributeKey(int i, String str) {
        super(i, str);
    }

    public static <T> AttributeKey<T> valueOf(Class<?> cls, String str) {
        return (AttributeKey) pool.valueOf(cls, str);
    }
}
