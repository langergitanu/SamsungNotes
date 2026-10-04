package androidx.collection;

import androidx.annotation.IntRange;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.p217ml.model.AbstractDataIndexer;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u0018\u0010\b\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u0018\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0001J\u0018\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u0003J\u001a\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001b\u0010\u001b\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0010\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u0003R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, m13886d2 = {"Landroidx/collection/MutableIntList;", "Landroidx/collection/IntList;", "initialCapacity", "", "(I)V", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "getCapacity", "()I", "add", "", "element", "", "index", "addAll", "elements", "", "clear", "ensureCapacity", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, AbstractDataIndexer.SORT_PARAM, "sortDescending", "trim", "minCapacity", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntList.kt\nandroidx/collection/MutableIntList\n+ 2 IntList.kt\nandroidx/collection/IntList\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,958:1\n546#1:959\n68#2:960\n250#2,6:963\n68#2:969\n68#2:970\n68#2:971\n68#2:978\n68#2:979\n13600#3,2:961\n1663#3,6:972\n*S KotlinDebug\n*F\n+ 1 IntList.kt\nandroidx/collection/MutableIntList\n*L\n683#1:959\n744#1:960\n763#1:963,6\n774#1:969\n778#1:970\n822#1:971\n838#1:978\n854#1:979\n754#1:961,2\n824#1:972,6\n*E\n"})
public final class MutableIntList extends IntList {
    public MutableIntList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableIntList._size;
        }
        mutableIntList.trim(i);
    }

    public final boolean add(int element) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i = this._size;
        iArr[i] = element;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int index, @NotNull int[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (index < 0 || index > (i = this._size)) {
            StringBuilder sbM778t = AbstractC0541b.m778t(index, "Index ", " must be in 0..");
            sbM778t.append(this._size);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i + elements.length);
        int[] iArr = this.content;
        int i2 = this._size;
        if (index != i2) {
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, elements.length + index, index, i2);
        }
        ArraysKt___ArraysJvmKt.copyInto$default(elements, iArr, index, 0, 0, 12, (Object) null);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        int[] iArr = this.content;
        if (iArr.length < capacity) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(capacity, (iArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.content = iArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(int element) {
        remove(element);
    }

    public final void plusAssign(@NotNull IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(int element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(@NotNull int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        for (int i2 : elements) {
            remove(i2);
        }
        return i != this._size;
    }

    public final int removeAt(@IntRange(from = 0) int index) {
        int i;
        if (index < 0 || index >= (i = this._size)) {
            StringBuilder sbM778t = AbstractC0541b.m778t(index, "Index ", " must be in 0..");
            sbM778t.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        int[] iArr = this.content;
        int i2 = iArr[index];
        if (index != i - 1) {
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, index, index + 1, i);
        }
        this._size--;
        return i2;
    }

    public final void removeRange(@IntRange(from = 0) int start, @IntRange(from = 0) int end) {
        int i;
        if (start < 0 || start > (i = this._size) || end < 0 || end > i) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(start, end, "Start (", ") and end (", ") must be in 0..");
            sbM1173s.append(this._size);
            throw new IndexOutOfBoundsException(sbM1173s.toString());
        }
        if (end < start) {
            throw new IllegalArgumentException(AbstractC0622a.m1168n("Start (", start, ") is more than end (", end, PropertyUtils.MAPPED_DELIM2));
        }
        if (end != start) {
            if (end < i) {
                int[] iArr = this.content;
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, start, end, i);
            }
            this._size -= end - start;
        }
    }

    public final boolean retainAll(@NotNull int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        int[] iArr = this.content;
        int i2 = i - 1;
        while (true) {
            int i4 = 0;
            int i5 = -1;
            if (-1 >= i2) {
                break;
            }
            int i6 = iArr[i2];
            int length = elements.length;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (elements[i4] == i6) {
                    i5 = i4;
                    break;
                }
                i4++;
            }
            if (i5 < 0) {
                removeAt(i2);
            }
            i2--;
        }
        return i != this._size;
    }

    public final int set(@IntRange(from = 0) int index, int element) {
        if (index < 0 || index >= this._size) {
            StringBuilder sbM778t = AbstractC0541b.m778t(index, "set index ", " must be between 0 .. ");
            sbM778t.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        int[] iArr = this.content;
        int i = iArr[index];
        iArr[index] = element;
        return i;
    }

    public final void sort() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        ArraysKt___ArraysJvmKt.sort(this.content, 0, i);
    }

    public final void sortDescending() {
        int i = this._size;
        if (i == 0) {
            return;
        }
        ArraysKt___ArraysKt.sortDescending(this.content, 0, i);
    }

    public final void trim(int minCapacity) {
        int iMax = Math.max(minCapacity, this._size);
        int[] iArr = this.content;
        if (iArr.length > iMax) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.content = iArrCopyOf;
        }
    }

    public /* synthetic */ MutableIntList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final void minusAssign(@NotNull int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (int i : elements) {
            remove(i);
        }
    }

    public final void plusAssign(@NotNull int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableIntList(int i) {
        super(i, null);
    }

    public final void plusAssign(int element) {
        add(element);
    }

    public final void add(@IntRange(from = 0) int index, int element) {
        int i;
        if (index >= 0 && index <= (i = this._size)) {
            ensureCapacity(i + 1);
            int[] iArr = this.content;
            int i2 = this._size;
            if (index != i2) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, index + 1, index, i2);
            }
            iArr[index] = element;
            this._size++;
            return;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(index, "Index ", " must be in 0..");
        sbM778t.append(this._size);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public final void minusAssign(@NotNull IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int[] iArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(iArr[i2]);
        }
    }

    public final boolean removeAll(@NotNull IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        int i2 = elements._size - 1;
        if (i2 >= 0) {
            int i4 = 0;
            while (true) {
                remove(elements.get(i4));
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
        }
        return i != this._size;
    }

    public final boolean retainAll(@NotNull IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        int[] iArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!elements.contains(iArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int index, @NotNull IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (index >= 0 && index <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            int[] iArr = this.content;
            int i = this._size;
            if (index != i) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, elements._size + index, index, i);
            }
            ArraysKt___ArraysJvmKt.copyInto(elements.content, iArr, index, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(index, "Index ", " must be in 0..");
        sbM778t.append(this._size);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public final boolean addAll(@NotNull IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(@NotNull int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return addAll(this._size, elements);
    }
}
