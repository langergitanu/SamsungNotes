package androidx.collection;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B!\b\u0016\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00028\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\u0002H!\"\n\b\u0002\u0010!*\u0004\u0018\u00018\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u0002H!H\u0082\b¢\u0006\u0002\u0010\u001fJ\b\u0010\"\u001a\u00020\u0007H\u0016J\u001d\u0010#\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0007H\u0002J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0001¢\u0006\u0004\b*\u0010'J\b\u0010+\u001a\u00020\u0012H\u0016J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ \u00100\u001a\u00020\u00102\u0016\u0010\u0004\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000H\u0016J\u001f\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001d\u00102\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00103J\u0015\u00104\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ%\u00105\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u00012\u0006\u00107\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001d\u00109\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010:J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010;\u001a\u00020<H\u0016J\u0015\u0010=\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, m13886d2 = {"Landroidx/collection/SimpleArrayMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "(Landroidx/collection/SimpleArrayMap;)V", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "", "(I)V", "array", "", "[Ljava/lang/Object;", "hashes", "", "size", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "ensureCapacity", "minimumCapacity", "equals", "other", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefaultInternal", "T", "hashCode", "indexOf", "hash", "(Ljava/lang/Object;I)I", "indexOfKey", "(Ljava/lang/Object;)I", "indexOfNull", "indexOfValue", "__restricted$indexOfValue", "isEmpty", "keyAt", "index", "(I)Ljava/lang/Object;", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "toString", "", "valueAt", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSimpleArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n+ 2 RuntimeHelpers.kt\nandroidx/collection/internal/RuntimeHelpersKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,770:1\n298#1,5:771\n298#1,5:776\n46#2,5:781\n46#2,5:786\n46#2,5:791\n46#2,5:797\n1#3:796\n*S KotlinDebug\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n*L\n277#1:771,5\n292#1:776,5\n314#1:781,5\n330#1:786,5\n347#1:791,5\n516#1:797,5\n*E\n"})
public class SimpleArrayMap<K, V> {

    @NotNull
    private Object[] array;

    @NotNull
    private int[] hashes;
    private int size;

    @JvmOverloads
    public SimpleArrayMap() {
        this(0, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object key, T defaultValue) {
        int iIndexOfKey = indexOfKey(key);
        return iIndexOfKey >= 0 ? (T) this.array[(iIndexOfKey << 1) + 1] : defaultValue;
    }

    private final int indexOf(K key, int hash) {
        int i = this.size;
        if (i == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i, hash);
        if (iBinarySearch < 0 || Intrinsics.areEqual(key, this.array[iBinarySearch << 1])) {
            return iBinarySearch;
        }
        int i2 = iBinarySearch + 1;
        while (i2 < i && this.hashes[i2] == hash) {
            if (Intrinsics.areEqual(key, this.array[i2 << 1])) {
                return i2;
            }
            i2++;
        }
        for (int i4 = iBinarySearch - 1; i4 >= 0 && this.hashes[i4] == hash; i4--) {
            if (Intrinsics.areEqual(key, this.array[i4 << 1])) {
                return i4;
            }
        }
        return ~i2;
    }

    private final int indexOfNull() {
        int i = this.size;
        if (i == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i, 0);
        if (iBinarySearch < 0 || this.array[iBinarySearch << 1] == null) {
            return iBinarySearch;
        }
        int i2 = iBinarySearch + 1;
        while (i2 < i && this.hashes[i2] == 0) {
            if (this.array[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i4 = iBinarySearch - 1; i4 >= 0 && this.hashes[i4] == 0; i4--) {
            if (this.array[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i2;
    }

    @JvmName(name = "__restricted$indexOfValue")
    public final int __restricted$indexOfValue(V value) {
        int i = this.size * 2;
        Object[] objArr = this.array;
        if (value == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i; i4 += 2) {
            if (Intrinsics.areEqual(value, objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K key) {
        return indexOfKey(key) >= 0;
    }

    public boolean containsValue(V value) {
        return __restricted$indexOfValue(value) >= 0;
    }

    public void ensureCapacity(int minimumCapacity) {
        int i = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < minimumCapacity) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, minimumCapacity);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, minimumCapacity * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
        }
        if (this.size != i) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        try {
            if (other instanceof SimpleArrayMap) {
                if (getSize() != ((SimpleArrayMap) other).getSize()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) other;
                int i = this.size;
                for (int i2 = 0; i2 < i; i2++) {
                    K kKeyAt = keyAt(i2);
                    V vValueAt = valueAt(i2);
                    Object obj = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(vValueAt, obj)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(other instanceof Map) || getSize() != ((Map) other).size()) {
                return false;
            }
            int i4 = this.size;
            for (int i5 = 0; i5 < i4; i5++) {
                K kKeyAt2 = keyAt(i5);
                V vValueAt2 = valueAt(i5);
                Object obj2 = ((Map) other).get(kKeyAt2);
                if (vValueAt2 == null) {
                    if (obj2 != null || !((Map) other).containsKey(kKeyAt2)) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(vValueAt2, obj2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Nullable
    public V get(K key) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey >= 0) {
            return (V) this.array[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(@Nullable Object key, V defaultValue) {
        int iIndexOfKey = indexOfKey(key);
        return iIndexOfKey >= 0 ? (V) this.array[(iIndexOfKey << 1) + 1] : defaultValue;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i = this.size;
        int i2 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i4];
            i4++;
            i2 += 2;
        }
        return iHashCode;
    }

    public int indexOfKey(K key) {
        return key == null ? indexOfNull() : indexOf(key, key.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int index) {
        boolean z = false;
        if (index >= 0 && index < this.size) {
            z = true;
        }
        if (!z) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        return (K) this.array[index << 1];
    }

    @Nullable
    public V put(K key, V value) {
        int i = this.size;
        int iHashCode = key != null ? key.hashCode() : 0;
        int iIndexOf = key != null ? indexOf(key, iHashCode) : indexOfNull();
        if (iIndexOf >= 0) {
            int i2 = (iIndexOf << 1) + 1;
            Object[] objArr = this.array;
            V v = (V) objArr[i2];
            objArr[i2] = value;
            return v;
        }
        int i4 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i >= iArr.length) {
            int i5 = 8;
            if (i >= 8) {
                i5 = (i >> 1) + i;
            } else if (i < 4) {
                i5 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i5 << 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
            if (i != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i) {
            int[] iArr2 = this.hashes;
            int i6 = i4 + 1;
            ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr2, i6, i4, i);
            Object[] objArr2 = this.array;
            ArraysKt.copyInto(objArr2, objArr2, i6 << 1, i4 << 1, this.size << 1);
        }
        int i7 = this.size;
        if (i == i7) {
            int[] iArr3 = this.hashes;
            if (i4 < iArr3.length) {
                iArr3[i4] = iHashCode;
                Object[] objArr3 = this.array;
                int i8 = i4 << 1;
                objArr3[i8] = key;
                objArr3[i8 + 1] = value;
                this.size = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NotNull SimpleArrayMap<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        int i = map.size;
        ensureCapacity(this.size + i);
        if (this.size != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(map.keyAt(i2), map.valueAt(i2));
            }
        } else if (i > 0) {
            ArraysKt___ArraysJvmKt.copyInto(map.hashes, this.hashes, 0, 0, i);
            ArraysKt.copyInto(map.array, this.array, 0, 0, i << 1);
            this.size = i;
        }
    }

    @Nullable
    public V putIfAbsent(K key, V value) {
        V v = get(key);
        return v == null ? put(key, value) : v;
    }

    @Nullable
    public V remove(K key) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public V removeAt(int index) {
        if (index < 0 || index >= this.size) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        Object[] objArr = this.array;
        int i = index << 1;
        V v = (V) objArr[i + 1];
        int i2 = this.size;
        if (i2 <= 1) {
            clear();
            return v;
        }
        int i4 = i2 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (index < i4) {
                int i5 = index + 1;
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, index, i5, i2);
                Object[] objArr2 = this.array;
                ArraysKt.copyInto(objArr2, objArr2, i, i5 << 1, i2 << 1);
            }
            Object[] objArr3 = this.array;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i7 << 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
            if (i2 != this.size) {
                throw new ConcurrentModificationException();
            }
            if (index > 0) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, this.hashes, 0, 0, index);
                ArraysKt.copyInto(objArr, this.array, 0, 0, i);
            }
            if (index < i4) {
                int i8 = index + 1;
                ArraysKt___ArraysJvmKt.copyInto(iArr, this.hashes, index, i8, i2);
                ArraysKt.copyInto(objArr, this.array, i, i8 << 1, i2 << 1);
            }
        }
        if (i2 != this.size) {
            throw new ConcurrentModificationException();
        }
        this.size = i4;
        return v;
    }

    @Nullable
    public V replace(K key, V value) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, value);
        }
        return null;
    }

    public V setValueAt(int index, V value) {
        boolean z = false;
        if (index >= 0 && index < this.size) {
            z = true;
        }
        if (!z) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        int i = (index << 1) + 1;
        Object[] objArr = this.array;
        V v = (V) objArr[i];
        objArr[i] = value;
        return v;
    }

    /* JADX INFO: renamed from: size, reason: from getter */
    public int getSize() {
        return this.size;
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(SQLKeyword.COMMA);
            }
            K kKeyAt = keyAt(i2);
            if (kKeyAt != sb) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vValueAt = valueAt(i2);
            if (vValueAt != sb) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC0541b.m766h('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public V valueAt(int index) {
        boolean z = false;
        if (index >= 0 && index < this.size) {
            z = true;
        }
        if (!z) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        return (V) this.array[(index << 1) + 1];
    }

    @JvmOverloads
    public SimpleArrayMap(int i) {
        this.hashes = i == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[i];
        this.array = i == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i << 1];
    }

    public boolean remove(K key, V value) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0 || !Intrinsics.areEqual(value, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0 || !Intrinsics.areEqual(oldValue, valueAt(iIndexOfKey))) {
            return false;
        }
        setValueAt(iIndexOfKey, newValue);
        return true;
    }

    public /* synthetic */ SimpleArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public SimpleArrayMap(@Nullable SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
