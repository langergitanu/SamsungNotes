package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"EmptyIntIntMap", "Landroidx/collection/MutableIntIntMap;", "emptyIntIntMap", "Landroidx/collection/IntIntMap;", "intIntMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntIntMapOf", "collection"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class IntIntMapKt {

    @NotNull
    private static final MutableIntIntMap EmptyIntIntMap = new MutableIntIntMap(0);

    @NotNull
    public static final IntIntMap emptyIntIntMap() {
        return EmptyIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf() {
        return EmptyIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf() {
        return new MutableIntIntMap(0, 1, null);
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i4, int i5) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i4, int i5) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i4, int i5, int i6, int i7) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        mutableIntIntMap.set(i6, i7);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i4, int i5, int i6, int i7) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        mutableIntIntMap.set(i6, i7);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        mutableIntIntMap.set(i6, i7);
        mutableIntIntMap.set(i8, i9);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        mutableIntIntMap.set(i6, i7);
        mutableIntIntMap.set(i8, i9);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        mutableIntIntMap.set(i6, i7);
        mutableIntIntMap.set(i8, i9);
        mutableIntIntMap.set(i10, i11);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i4, i5);
        mutableIntIntMap.set(i6, i7);
        mutableIntIntMap.set(i8, i9);
        mutableIntIntMap.set(i10, i11);
        return mutableIntIntMap;
    }
}
