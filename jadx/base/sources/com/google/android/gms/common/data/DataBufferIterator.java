package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {

    @NonNull
    protected final DataBuffer<T> zaa;
    protected int zab = -1;

    public DataBufferIterator(@NonNull DataBuffer<T> dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zab < this.zaa.getCount() + (-1);
    }

    @Override // java.util.Iterator
    @NonNull
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(AbstractC4539a.m3197g(46, this.zab, "Cannot advance the iterator beyond "));
        }
        DataBuffer<T> dataBuffer = this.zaa;
        int i = this.zab + 1;
        this.zab = i;
        return dataBuffer.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
