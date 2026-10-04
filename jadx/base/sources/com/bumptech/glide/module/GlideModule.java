package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface GlideModule extends RegistersComponents, AppliesOptions {
    @Override // com.bumptech.glide.module.AppliesOptions
    /* synthetic */ void applyOptions(Context context, GlideBuilder glideBuilder);

    @Override // com.bumptech.glide.module.RegistersComponents
    /* synthetic */ void registerComponents(Context context, Glide glide, Registry registry);
}
