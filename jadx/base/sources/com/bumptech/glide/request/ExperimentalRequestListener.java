package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements RequestListener<ResourceT> {
    public abstract boolean onResourceReady(ResourceT resourcet, Object obj, Target<ResourceT> target, DataSource dataSource, boolean z, boolean z2);

    public void onRequestStarted(Object obj) {
    }
}
