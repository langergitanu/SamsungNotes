package com.google.android.material.motion;

import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.PackageIdentifier;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;

/* JADX INFO: renamed from: com.google.android.material.motion.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC4744a {
    /* JADX INFO: renamed from: b */
    public static /* synthetic */ AppSearchManager.SearchContext.Builder m3462b() {
        return new AppSearchManager.SearchContext.Builder("app-search-db");
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ AppSearchSchema.Builder m3463c() {
        return new AppSearchSchema.Builder("shortcut-type");
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ AppSearchSchema.BytesPropertyConfig.Builder m3464d() {
        return new AppSearchSchema.BytesPropertyConfig.Builder("icon");
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ AppSearchSchema.LongPropertyConfig.Builder m3465e() {
        return new AppSearchSchema.LongPropertyConfig.Builder(SearchIndexablesContract.BaseColumns.COLUMN_ICON_RESID);
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m3467g() {
        return new AppSearchSchema.StringPropertyConfig.Builder("flags");
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ PackageIdentifier m3469i(byte[] bArr) {
        return new PackageIdentifier("com.samsung.android.smartsuggestions", bArr);
    }

    /* JADX INFO: renamed from: y */
    public static /* synthetic */ AppSearchSchema.StringPropertyConfig.Builder m3485y() {
        return new AppSearchSchema.StringPropertyConfig.Builder("disabledReason");
    }
}
