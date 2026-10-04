package io.opentelemetry.api.common;

import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import io.opentelemetry.api.internal.ImmutableKeyValuePairs;
import java.util.ArrayList;
import java.util.Comparator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
final class ArrayBackedAttributes extends ImmutableKeyValuePairs<AttributeKey<?>, Object> implements Attributes {
    private static final Comparator<AttributeKey<?>> KEY_COMPARATOR_FOR_CONSTRUCTION = Comparator.comparing(new C11419a(18));
    static final Attributes EMPTY = Attributes.builder().build();

    private ArrayBackedAttributes(Object[] objArr, Comparator<AttributeKey<?>> comparator) {
        super(objArr, comparator);
    }

    public static Attributes sortAndFilterToAttributes(Object... objArr) {
        for (int i = 0; i < objArr.length; i += 2) {
            AttributeKey attributeKey = (AttributeKey) objArr[i];
            if (attributeKey != null && attributeKey.getKey().isEmpty()) {
                objArr[i] = null;
            }
        }
        return new ArrayBackedAttributes(objArr, KEY_COMPARATOR_FOR_CONSTRUCTION);
    }

    @Override // io.opentelemetry.api.common.Attributes
    @Nullable
    public <T> T get(AttributeKey<T> attributeKey) {
        return (T) get(attributeKey);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public AttributesBuilder toBuilder() {
        return new ArrayBackedAttributesBuilder(new ArrayList(data()));
    }

    public ArrayBackedAttributes(Object[] objArr) {
        super(objArr);
    }
}
