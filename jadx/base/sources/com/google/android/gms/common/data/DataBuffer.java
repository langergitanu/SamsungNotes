package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface DataBuffer<T> extends Iterable<T>, Releasable, Closeable {
    void close();

    T get(int i);

    int getCount();

    @Nullable
    @KeepForSdk
    Bundle getMetadata();

    @Deprecated
    boolean isClosed();

    @Override // java.lang.Iterable
    @NonNull
    Iterator<T> iterator();

    void release();

    @NonNull
    Iterator<T> singleRefIterator();
}
