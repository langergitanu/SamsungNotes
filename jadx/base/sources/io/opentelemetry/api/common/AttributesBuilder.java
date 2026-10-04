package io.opentelemetry.api.common;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface AttributesBuilder {
    Attributes build();

    <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i);

    <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t);

    default AttributesBuilder put(String str, String str2) {
        return put(AttributeKey.stringKey(str), str2);
    }

    AttributesBuilder putAll(Attributes attributes);

    default AttributesBuilder put(String str, long j) {
        return put(AttributeKey.longKey(str), Long.valueOf(j));
    }

    default AttributesBuilder put(String str, double d) {
        return put(AttributeKey.doubleKey(str), Double.valueOf(d));
    }

    default AttributesBuilder put(String str, boolean z) {
        return put(AttributeKey.booleanKey(str), Boolean.valueOf(z));
    }

    default AttributesBuilder put(String str, String... strArr) {
        return strArr == null ? this : put(AttributeKey.stringArrayKey(str), Arrays.asList(strArr));
    }

    default <T> AttributesBuilder put(AttributeKey<List<T>> attributeKey, T... tArr) {
        return tArr == null ? this : put(attributeKey, Arrays.asList(tArr));
    }

    default AttributesBuilder put(String str, long... jArr) {
        return jArr == null ? this : put(AttributeKey.longArrayKey(str), ArrayBackedAttributesBuilder.toList(jArr));
    }

    default AttributesBuilder put(String str, double... dArr) {
        return dArr == null ? this : put(AttributeKey.doubleArrayKey(str), ArrayBackedAttributesBuilder.toList(dArr));
    }

    default AttributesBuilder put(String str, boolean... zArr) {
        return zArr == null ? this : put(AttributeKey.booleanArrayKey(str), ArrayBackedAttributesBuilder.toList(zArr));
    }

    default <T> AttributesBuilder remove(AttributeKey<T> attributeKey) {
        return this;
    }

    default AttributesBuilder removeIf(Predicate<AttributeKey<?>> predicate) {
        return this;
    }
}
