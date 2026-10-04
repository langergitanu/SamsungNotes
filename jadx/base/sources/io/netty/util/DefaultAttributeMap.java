package io.netty.util;

import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultAttributeMap implements AttributeMap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, DefaultAttribute[]> ATTRIBUTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, DefaultAttribute[].class, NativeAuthConstants.GrantType.ATTRIBUTES);
    private static final DefaultAttribute[] EMPTY_ATTRIBUTES = new DefaultAttribute[0];
    private volatile DefaultAttribute[] attributes = EMPTY_ATTRIBUTES;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private static final AtomicReferenceFieldUpdater<DefaultAttribute, DefaultAttributeMap> MAP_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttribute.class, DefaultAttributeMap.class, "attributeMap");
        private static final long serialVersionUID = -2661411462200283011L;
        private volatile DefaultAttributeMap attributeMap;
        private final AttributeKey<T> key;

        public DefaultAttribute(DefaultAttributeMap defaultAttributeMap, AttributeKey<T> attributeKey) {
            this.attributeMap = defaultAttributeMap;
            this.key = attributeKey;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRemoved() {
            return this.attributeMap == null;
        }

        @Override // io.netty.util.Attribute
        public T getAndRemove() {
            boolean z;
            DefaultAttributeMap defaultAttributeMap = this.attributeMap;
            if (defaultAttributeMap == null) {
                z = false;
                break;
            }
            AtomicReferenceFieldUpdater<DefaultAttribute, DefaultAttributeMap> atomicReferenceFieldUpdater = MAP_UPDATER;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, defaultAttributeMap, null)) {
                if (atomicReferenceFieldUpdater.get(this) != defaultAttributeMap) {
                    z = false;
                    break;
                }
            }
            z = true;
            T andSet = getAndSet(null);
            if (z) {
                defaultAttributeMap.removeAttributeIfMatch(this.key, this);
            }
            return andSet;
        }

        @Override // io.netty.util.Attribute
        public AttributeKey<T> key() {
            return this.key;
        }

        @Override // io.netty.util.Attribute
        public void remove() {
            boolean z;
            DefaultAttributeMap defaultAttributeMap = this.attributeMap;
            if (defaultAttributeMap == null) {
                z = false;
                break;
            }
            AtomicReferenceFieldUpdater<DefaultAttribute, DefaultAttributeMap> atomicReferenceFieldUpdater = MAP_UPDATER;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, defaultAttributeMap, null)) {
                if (atomicReferenceFieldUpdater.get(this) != defaultAttributeMap) {
                    z = false;
                    break;
                }
            }
            z = true;
            set(null);
            if (z) {
                defaultAttributeMap.removeAttributeIfMatch(this.key, this);
            }
        }

        @Override // io.netty.util.Attribute
        public T setIfAbsent(T t) {
            T t2;
            do {
                t2 = null;
                if (compareAndSet(null, t)) {
                    break;
                }
                t2 = get();
            } while (t2 == null);
            return t2;
        }
    }

    private static void orderedCopyOnInsert(DefaultAttribute[] defaultAttributeArr, int i, DefaultAttribute[] defaultAttributeArr2, DefaultAttribute defaultAttribute) {
        int iMo13776id = defaultAttribute.key.mo13776id();
        int i2 = i - 1;
        while (i2 >= 0 && defaultAttributeArr[i2].key.mo13776id() >= iMo13776id) {
            defaultAttributeArr2[i2 + 1] = defaultAttributeArr[i2];
            i2--;
        }
        int i4 = i2 + 1;
        defaultAttributeArr2[i4] = defaultAttribute;
        if (i4 > 0) {
            System.arraycopy(defaultAttributeArr, 0, defaultAttributeArr2, 0, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void removeAttributeIfMatch(AttributeKey<T> attributeKey, DefaultAttribute<T> defaultAttribute) {
        while (true) {
            DefaultAttribute<T>[] defaultAttributeArr = this.attributes;
            int iSearchAttributeByKey = searchAttributeByKey(defaultAttributeArr, attributeKey);
            if (iSearchAttributeByKey >= 0 && defaultAttributeArr[iSearchAttributeByKey] == defaultAttribute) {
                int length = defaultAttributeArr.length;
                int i = length - 1;
                DefaultAttribute[] defaultAttributeArr2 = i == 0 ? EMPTY_ATTRIBUTES : new DefaultAttribute[i];
                System.arraycopy(defaultAttributeArr, 0, defaultAttributeArr2, 0, iSearchAttributeByKey);
                int i2 = (length - iSearchAttributeByKey) - 1;
                if (i2 > 0) {
                    System.arraycopy(defaultAttributeArr, iSearchAttributeByKey + 1, defaultAttributeArr2, iSearchAttributeByKey, i2);
                }
                AtomicReferenceFieldUpdater<DefaultAttributeMap, DefaultAttribute[]> atomicReferenceFieldUpdater = ATTRIBUTES_UPDATER;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, defaultAttributeArr, defaultAttributeArr2)) {
                    if (atomicReferenceFieldUpdater.get(this) != defaultAttributeArr) {
                        break;
                    }
                }
                return;
            }
            return;
        }
    }

    private static int searchAttributeByKey(DefaultAttribute[] defaultAttributeArr, AttributeKey<?> attributeKey) {
        int length = defaultAttributeArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            AttributeKey<?> attributeKey2 = defaultAttributeArr[i2].key;
            if (attributeKey2 == attributeKey) {
                return i2;
            }
            if (attributeKey2.mo13776id() < attributeKey.mo13776id()) {
                i = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return -(i + 1);
    }

    @Override // io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        DefaultAttribute[] defaultAttributeArr;
        ObjectUtil.checkNotNull(attributeKey, "key");
        DefaultAttribute defaultAttribute = null;
        while (true) {
            DefaultAttribute[] defaultAttributeArr2 = this.attributes;
            int iSearchAttributeByKey = searchAttributeByKey(defaultAttributeArr2, attributeKey);
            if (iSearchAttributeByKey >= 0) {
                DefaultAttribute defaultAttribute2 = defaultAttributeArr2[iSearchAttributeByKey];
                if (!defaultAttribute2.isRemoved()) {
                    return defaultAttribute2;
                }
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                defaultAttributeArr = (DefaultAttribute[]) Arrays.copyOf(defaultAttributeArr2, defaultAttributeArr2.length);
                defaultAttributeArr[iSearchAttributeByKey] = defaultAttribute;
            } else {
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                int length = defaultAttributeArr2.length;
                defaultAttributeArr = new DefaultAttribute[length + 1];
                orderedCopyOnInsert(defaultAttributeArr2, length, defaultAttributeArr, defaultAttribute);
            }
            AtomicReferenceFieldUpdater<DefaultAttributeMap, DefaultAttribute[]> atomicReferenceFieldUpdater = ATTRIBUTES_UPDATER;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, defaultAttributeArr2, defaultAttributeArr)) {
                if (atomicReferenceFieldUpdater.get(this) != defaultAttributeArr2) {
                    break;
                }
            }
            return defaultAttribute;
        }
    }

    @Override // io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        ObjectUtil.checkNotNull(attributeKey, "key");
        return searchAttributeByKey(this.attributes, attributeKey) >= 0;
    }
}
