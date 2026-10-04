package com.bumptech.glide.load.resource;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SimpleResource<T> implements Resource<T> {
    protected final T data;

    public SimpleResource(@NonNull T t) {
        this.data = (T) Preconditions.checkNotNull(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        return this.data;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<T> getResourceClass() {
        return (Class<T>) this.data.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
