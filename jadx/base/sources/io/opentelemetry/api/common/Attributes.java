package io.opentelemetry.api.common;

import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public interface Attributes {
    static AttributesBuilder builder() {
        return new ArrayBackedAttributesBuilder();
    }

    static Attributes empty() {
        return ArrayBackedAttributes.EMPTY;
    }

    /* JADX INFO: renamed from: of */
    static <T> Attributes m13783of(AttributeKey<T> attributeKey, T t) {
        return (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) ? empty() : new ArrayBackedAttributes(new Object[]{attributeKey, t});
    }

    Map<AttributeKey<?>, Object> asMap();

    void forEach(BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer);

    @Nullable
    <T> T get(AttributeKey<T> attributeKey);

    boolean isEmpty();

    int size();

    AttributesBuilder toBuilder();

    /* JADX INFO: renamed from: of */
    static <T, U> Attributes m13784of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u) {
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t != null) {
            if (attributeKey2 != null && !attributeKey2.getKey().isEmpty() && u != null) {
                if (attributeKey.getKey().equals(attributeKey2.getKey())) {
                    return m13783of(attributeKey2, u);
                }
                if (attributeKey.getKey().compareTo(attributeKey2.getKey()) > 0) {
                    return new ArrayBackedAttributes(new Object[]{attributeKey2, u, attributeKey, t});
                }
                return new ArrayBackedAttributes(new Object[]{attributeKey, t, attributeKey2, u});
            }
            return m13783of(attributeKey, t);
        }
        return m13783of(attributeKey2, u);
    }

    /* JADX INFO: renamed from: of */
    static <T, U, V> Attributes m13785of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v);
    }

    /* JADX INFO: renamed from: of */
    static <T, U, V, W> Attributes m13786of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w);
    }

    /* JADX INFO: renamed from: of */
    static <T, U, V, W, X> Attributes m13787of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w, AttributeKey<X> attributeKey5, X x) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w, attributeKey5, x);
    }

    /* JADX INFO: renamed from: of */
    static <T, U, V, W, X, Y> Attributes m13788of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w, AttributeKey<X> attributeKey5, X x, AttributeKey<Y> attributeKey6, Y y2) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w, attributeKey5, x, attributeKey6, y2);
    }
}
