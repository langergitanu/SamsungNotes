package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T zac;

    public SingleRefDataBufferIterator(@NonNull DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    @NonNull
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(AbstractC4539a.m3197g(46, this.zab, "Cannot advance the iterator beyond "));
        }
        int i = this.zab + 1;
        this.zab = i;
        if (i == 0) {
            T t = (T) Preconditions.checkNotNull(this.zaa.get(0));
            this.zac = t;
            if (!(t instanceof DataBufferRef)) {
                String strValueOf = String.valueOf(t.getClass());
                throw new IllegalStateException(AbstractC2322a.m1626p(new StringBuilder(strValueOf.length() + 44), "DataBuffer reference of type ", strValueOf, " is not movable"));
            }
        } else {
            ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
        }
        return this.zac;
    }
}
