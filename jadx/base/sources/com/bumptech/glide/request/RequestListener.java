package com.bumptech.glide.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface RequestListener<R> {
    boolean onLoadFailed(@Nullable GlideException glideException, @Nullable Object obj, @NonNull Target<R> target, boolean z);

    boolean onResourceReady(@NonNull R r, @NonNull Object obj, Target<R> target, @NonNull DataSource dataSource, boolean z);
}
