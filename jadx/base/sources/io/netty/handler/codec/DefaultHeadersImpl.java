package io.netty.handler.codec;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.util.HashingStrategy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultHeadersImpl<K, V> extends DefaultHeaders<K, V, DefaultHeadersImpl<K, V>> {
    public DefaultHeadersImpl(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, DefaultHeaders.NameValidator<K> nameValidator) {
        super(hashingStrategy, valueConverter, nameValidator);
    }

    public DefaultHeadersImpl(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, DefaultHeaders.NameValidator<K> nameValidator, int i, DefaultHeaders.ValueValidator<V> valueValidator) {
        super(hashingStrategy, valueConverter, nameValidator, i, valueValidator);
    }
}
