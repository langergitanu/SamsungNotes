package androidx.collection;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0017J\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0016J\u001d\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0018\u0010'\u001a\u00020\u00132\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0016J\u001f\u0010)\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0004H\u0016J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001f\u0010-\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J%\u0010-\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u001d\u00101\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u000203H\u0016J\u0015\u00104\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u00065"}, m13886d2 = {"Landroidx/collection/SparseArrayCompat;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "(I)V", "garbage", "", "isEmpty", "getIsEmpty", "()Z", "keys", "", "size", "values", "", "", "[Ljava/lang/Object;", RtspHeaders.Values.APPEND, "", "key", "value", "(ILjava/lang/Object;)V", "clear", "clone", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", OpenSessionApi.ITEM_LIMIT_DELETE, "get", "(I)Ljava/lang/Object;", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "keyAt", "index", "put", "putAll", "other", "putIfAbsent", "remove", "removeAt", "removeAtRange", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "oldValue", "newValue", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "toString", "", "valueAt", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSparseArrayCompat.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArrayCompat.jvm.kt\nandroidx/collection/SparseArrayCompat\n+ 2 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n1#1,273:1\n275#2,9:274\n288#2,5:283\n296#2,5:288\n304#2,8:293\n320#2,9:301\n353#2,40:310\n396#2,2:350\n353#2,47:352\n403#2,3:399\n353#2,40:402\n407#2:442\n412#2,4:443\n419#2:447\n423#2,4:448\n431#2,8:452\n443#2,5:460\n451#2,4:465\n459#2,9:469\n472#2:478\n477#2:479\n459#2,9:480\n482#2,8:489\n493#2,17:497\n513#2,21:514\n*S KotlinDebug\n*F\n+ 1 SparseArrayCompat.jvm.kt\nandroidx/collection/SparseArrayCompat\n*L\n130#1:274,9\n135#1:283,5\n144#1:288,5\n152#1:293,8\n163#1:301,9\n169#1:310,40\n176#1:350,2\n176#1:352,47\n186#1:399,3\n186#1:402,40\n186#1:442\n191#1:443,4\n205#1:447\n212#1:448,4\n218#1:452,8\n224#1:460,5\n234#1:465,4\n246#1:469,9\n249#1:478\n252#1:479\n252#1:480,9\n257#1:489,8\n263#1:497,17\n271#1:514,21\n*E\n"})
public class SparseArrayCompat<E> implements Cloneable {

    @JvmField
    public /* synthetic */ boolean garbage;

    @JvmField
    public /* synthetic */ int[] keys;

    @JvmField
    public /* synthetic */ int size;

    @JvmField
    public /* synthetic */ Object[] values;

    @JvmOverloads
    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public void append(int key, E value) {
        int i = this.size;
        if (i != 0 && key <= this.keys[i - 1]) {
            put(key, value);
            return;
        }
        if (this.garbage && i >= this.keys.length) {
            SparseArrayCompatKt.m1150gc(this);
        }
        int i2 = this.size;
        if (i2 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i2 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        this.keys[i2] = key;
        this.values[i2] = value;
        this.size = i2 + 1;
    }

    public void clear() {
        int i = this.size;
        Object[] objArr = this.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public boolean containsKey(int key) {
        return indexOfKey(key) >= 0;
    }

    public boolean containsValue(E value) {
        if (this.garbage) {
            SparseArrayCompatKt.m1150gc(this);
        }
        int i = this.size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                i2 = -1;
                break;
            }
            if (this.values[i2] == value) {
                break;
            }
            i2++;
        }
        return i2 >= 0;
    }

    @Deprecated(message = "Alias for remove(int).", replaceWith = @ReplaceWith(expression = "remove(key)", imports = {}))
    public void delete(int key) {
        remove(key);
    }

    @Nullable
    public E get(int key) {
        return (E) SparseArrayCompatKt.commonGet(this, key);
    }

    @JvmName(name = "getIsEmpty")
    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int key) {
        if (this.garbage) {
            SparseArrayCompatKt.m1150gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, key);
    }

    public int indexOfValue(E value) {
        if (this.garbage) {
            SparseArrayCompatKt.m1150gc(this);
        }
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.values[i2] == value) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int index) {
        if (this.garbage) {
            SparseArrayCompatKt.m1150gc(this);
        }
        return this.keys[index];
    }

    public void put(int key, E value) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = value;
            return;
        }
        int i = ~iBinarySearch;
        if (i < this.size && this.values[i] == SparseArrayCompatKt.DELETED) {
            this.keys[i] = key;
            this.values[i] = value;
            return;
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.m1150gc(this);
            i = ~ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        }
        int i2 = this.size;
        if (i2 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i2 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        int i4 = this.size;
        if (i4 - i != 0) {
            int[] iArr = this.keys;
            int i5 = i + 1;
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i5, i, i4);
            Object[] objArr = this.values;
            ArraysKt.copyInto(objArr, objArr, i5, i, this.size);
        }
        this.keys[i] = key;
        this.values[i] = value;
        this.size++;
    }

    public void putAll(@NotNull SparseArrayCompat<? extends E> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = other.keyAt(i);
            E eValueAt = other.valueAt(i);
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = eValueAt;
            } else {
                int i2 = ~iBinarySearch;
                if (i2 >= this.size || this.values[i2] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.m1150gc(this);
                        i2 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
                    }
                    int i4 = this.size;
                    if (i4 >= this.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i4 + 1);
                        int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
                        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
                        this.keys = iArrCopyOf;
                        Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
                        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
                        this.values = objArrCopyOf;
                    }
                    int i5 = this.size;
                    if (i5 - i2 != 0) {
                        int[] iArr = this.keys;
                        int i6 = i2 + 1;
                        ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i6, i2, i5);
                        Object[] objArr = this.values;
                        ArraysKt.copyInto(objArr, objArr, i6, i2, this.size);
                    }
                    this.keys[i2] = iKeyAt;
                    this.values[i2] = eValueAt;
                    this.size++;
                } else {
                    this.keys[i2] = iKeyAt;
                    this.values[i2] = eValueAt;
                }
            }
        }
    }

    @Nullable
    public E putIfAbsent(int key, E value) {
        E e = (E) SparseArrayCompatKt.commonGet(this, key);
        if (e == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, key);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = value;
                return e;
            }
            int i = ~iBinarySearch;
            if (i < this.size && this.values[i] == SparseArrayCompatKt.DELETED) {
                this.keys[i] = key;
                this.values[i] = value;
                return e;
            }
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.m1150gc(this);
                i = ~ContainerHelpersKt.binarySearch(this.keys, this.size, key);
            }
            int i2 = this.size;
            if (i2 >= this.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i2 + 1);
                int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
                Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
                this.keys = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
                this.values = objArrCopyOf;
            }
            int i4 = this.size;
            if (i4 - i != 0) {
                int[] iArr = this.keys;
                int i5 = i + 1;
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i5, i, i4);
                Object[] objArr = this.values;
                ArraysKt.copyInto(objArr, objArr, i5, i, this.size);
            }
            this.keys[i] = key;
            this.values[i] = value;
            this.size++;
        }
        return e;
    }

    public void remove(int key) {
        SparseArrayCompatKt.commonRemove(this, key);
    }

    public void removeAt(int index) {
        if (this.values[index] != SparseArrayCompatKt.DELETED) {
            this.values[index] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int index, int size) {
        int iMin = Math.min(size, index + size);
        while (index < iMin) {
            removeAt(index);
            index++;
        }
    }

    @Nullable
    public E replace(int key, E value) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = value;
        return e;
    }

    public void setValueAt(int index, E value) {
        if (this.garbage) {
            SparseArrayCompatKt.m1150gc(this);
        }
        this.values[index] = value;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.m1150gc(this);
        }
        return this.size;
    }

    @NotNull
    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(keyAt(i2));
            sb.append('=');
            E eValueAt = valueAt(i2);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC0541b.m766h('}', "buffer.toString()", sb);
    }

    public E valueAt(int index) {
        if (this.garbage) {
            SparseArrayCompatKt.m1150gc(this);
        }
        return (E) this.values[index];
    }

    @JvmOverloads
    public SparseArrayCompat(int i) {
        if (i == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i);
            this.keys = new int[iIdealIntArraySize];
            this.values = new Object[iIdealIntArraySize];
        }
    }

    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m15210clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public E get(int key, E defaultValue) {
        return (E) SparseArrayCompatKt.commonGet(this, key, defaultValue);
    }

    public boolean remove(int key, @Nullable Object value) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0 || !Intrinsics.areEqual(value, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(int key, E oldValue, E newValue) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0 || !Intrinsics.areEqual(this.values[iIndexOfKey], oldValue)) {
            return false;
        }
        this.values[iIndexOfKey] = newValue;
        return true;
    }

    public /* synthetic */ SparseArrayCompat(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
