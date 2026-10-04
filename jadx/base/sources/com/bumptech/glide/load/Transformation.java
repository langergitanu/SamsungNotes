package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface Transformation<T> extends Key {
    @NonNull
    Resource<T> transform(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2);
}
