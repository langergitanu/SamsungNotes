package com.vladsch.flexmark.util.format;

import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.Seg;
import com.vladsch.flexmark.util.sequence.builder.tree.BasedOffsetTracker;
import com.vladsch.flexmark.util.sequence.builder.tree.OffsetInfo;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentOffsetTree;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TrackedOffsetList implements List<TrackedOffset> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static TrackedOffsetList EMPTY_LIST = new TrackedOffsetList(BasedSequence.NULL, Collections.EMPTY_LIST);

    @NotNull
    private final BasedSequence myBaseSeq;

    @NotNull
    private final BasedOffsetTracker myBasedOffsetTracker;

    @NotNull
    private final List<TrackedOffset> myTrackedOffsets;

    private TrackedOffsetList(@NotNull BasedSequence basedSequence, @NotNull List<TrackedOffset> list) {
        this.myBaseSeq = basedSequence;
        ArrayList<TrackedOffset> arrayList = new ArrayList(list);
        this.myTrackedOffsets = arrayList;
        arrayList.sort(Comparator.comparing(new C11419a(14)));
        ArrayList arrayList2 = new ArrayList(list.size());
        for (TrackedOffset trackedOffset : arrayList) {
            arrayList2.add(Seg.segOf(trackedOffset.getOffset(), trackedOffset.getOffset() + 1));
        }
        this.myBasedOffsetTracker = BasedOffsetTracker.create(basedSequence, SegmentOffsetTree.build((Iterable<Seg>) arrayList2, (CharSequence) ""));
    }

    @NotNull
    public static TrackedOffsetList create(@NotNull BasedSequence basedSequence, @NotNull List<TrackedOffset> list) {
        return list instanceof TrackedOffsetList ? (TrackedOffsetList) list : new TrackedOffsetList(basedSequence, list);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends TrackedOffset> collection) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.myTrackedOffsets.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<?> collection) {
        return this.myTrackedOffsets.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.myTrackedOffsets.equals(obj);
    }

    @NotNull
    public BasedSequence getBaseSeq() {
        return this.myBaseSeq;
    }

    @NotNull
    public BasedOffsetTracker getBasedOffsetTracker() {
        return this.myBasedOffsetTracker;
    }

    @NotNull
    public List<TrackedOffset> getTrackedOffsets() {
        return this.myTrackedOffsets;
    }

    @NotNull
    public TrackedOffsetList getUnresolvedOffsets() {
        ArrayList arrayList = new ArrayList();
        for (TrackedOffset trackedOffset : this.myTrackedOffsets) {
            if (!trackedOffset.isResolved()) {
                arrayList.add(trackedOffset);
            }
        }
        return arrayList.isEmpty() ? EMPTY_LIST : new TrackedOffsetList(this.myBaseSeq, arrayList);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.myTrackedOffsets.hashCode();
    }

    public boolean haveUnresolved() {
        Iterator<TrackedOffset> it = this.myTrackedOffsets.iterator();
        while (it.hasNext()) {
            if (!it.next().isResolved()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.myTrackedOffsets.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.myTrackedOffsets.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<TrackedOffset> iterator() {
        return this.myTrackedOffsets.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.myTrackedOffsets.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<TrackedOffset> listIterator() {
        return this.myTrackedOffsets.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<?> collection) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<TrackedOffset> unaryOperator) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<?> collection) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.myTrackedOffsets.size();
    }

    @Override // java.util.List
    public void sort(Comparator<? super TrackedOffset> comparator) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Spliterator<TrackedOffset> spliterator() {
        return this.myTrackedOffsets.spliterator();
    }

    @Override // java.util.List
    @NotNull
    public List<TrackedOffset> subList(int i, int i2) {
        return this.myTrackedOffsets.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return this.myTrackedOffsets.toArray();
    }

    @NotNull
    public static TrackedOffsetList create(@NotNull BasedSequence basedSequence, @NotNull int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(TrackedOffset.track(i));
        }
        return new TrackedOffsetList(basedSequence, arrayList);
    }

    @Override // java.util.List
    public boolean addAll(int i, @NotNull Collection<? extends TrackedOffset> collection) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public TrackedOffset get(int i) {
        return this.myTrackedOffsets.get(i);
    }

    @NotNull
    public TrackedOffsetList getTrackedOffsets(int i, int i2) {
        int i4;
        int i5 = 0;
        OffsetInfo offsetInfo = this.myBasedOffsetTracker.getOffsetInfo(i, i == i2);
        OffsetInfo offsetInfo2 = this.myBasedOffsetTracker.getOffsetInfo(i2, true);
        int i6 = offsetInfo.pos;
        int i7 = offsetInfo2.pos;
        if (i6 < 0 && i7 >= 0) {
            i4 = i7 + 1;
        } else {
            if (i6 < 0 || i7 < 0) {
                return EMPTY_LIST;
            }
            i4 = i7 + 1;
            i5 = i6;
        }
        int iMin = Math.min(this.myBasedOffsetTracker.size(), i4);
        if (i5 >= iMin) {
            return EMPTY_LIST;
        }
        if (this.myTrackedOffsets.get(i5).getOffset() < i) {
            i5++;
        }
        if (this.myTrackedOffsets.get(iMin - 1).getOffset() > i2) {
            iMin--;
        }
        return i5 >= iMin ? EMPTY_LIST : new TrackedOffsetList(this.myBaseSeq, this.myTrackedOffsets.subList(i5, iMin));
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<TrackedOffset> listIterator(int i) {
        return this.myTrackedOffsets.listIterator(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public TrackedOffset remove(int i) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List
    public TrackedOffset set(int i, TrackedOffset trackedOffset) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        return (T[]) this.myTrackedOffsets.toArray(tArr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(TrackedOffset trackedOffset) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }

    @Override // java.util.List
    public void add(int i, TrackedOffset trackedOffset) {
        throw new IllegalStateException("Not supported. Immutable list.");
    }
}
