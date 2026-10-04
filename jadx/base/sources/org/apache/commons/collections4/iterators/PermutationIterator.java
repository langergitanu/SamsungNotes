package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PermutationIterator<E> implements Iterator<List<E>> {
    private final boolean[] direction;
    private final int[] keys;
    private List<E> nextPermutation;
    private final Map<Integer, E> objectMap;

    public PermutationIterator(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "collection");
        this.keys = new int[collection.size()];
        boolean[] zArr = new boolean[collection.size()];
        this.direction = zArr;
        Arrays.fill(zArr, false);
        this.objectMap = new HashMap();
        Iterator<? extends E> it = collection.iterator();
        int i = 1;
        while (it.hasNext()) {
            this.objectMap.put(Integer.valueOf(i), it.next());
            this.keys[i - 1] = i;
            i++;
        }
        this.nextPermutation = new ArrayList(collection);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextPermutation != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.Iterator
    public List<E> next() {
        int[] iArr;
        int i;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = 0;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            iArr = this.keys;
            if (i4 >= iArr.length) {
                break;
            }
            boolean z = this.direction[i4];
            if (((z && i4 < iArr.length - 1 && iArr[i4] > iArr[i4 + 1]) || (!z && i4 > 0 && iArr[i4] > iArr[i4 - 1])) && (i = iArr[i4]) > i5) {
                i6 = i4;
                i5 = i;
            }
            i4++;
        }
        if (i5 == -1) {
            List<E> list = this.nextPermutation;
            this.nextPermutation = null;
            return list;
        }
        boolean[] zArr = this.direction;
        boolean z2 = zArr[i6];
        int i7 = z2 ? 1 : -1;
        int i8 = iArr[i6];
        int i9 = i7 + i6;
        iArr[i6] = iArr[i9];
        iArr[i9] = i8;
        zArr[i6] = zArr[i9];
        zArr[i9] = z2;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int[] iArr2 = this.keys;
            if (i2 >= iArr2.length) {
                List<E> list2 = this.nextPermutation;
                this.nextPermutation = arrayList;
                return list2;
            }
            int i10 = iArr2[i2];
            if (i10 > i5) {
                this.direction[i2] = !r4[i2];
            }
            arrayList.add(this.objectMap.get(Integer.valueOf(i10)));
            i2++;
        }
    }
}
