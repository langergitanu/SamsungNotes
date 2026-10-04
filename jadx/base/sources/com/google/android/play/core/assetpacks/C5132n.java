package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.n */
/* JADX INFO: loaded from: classes5.dex */
final class C5132n {

    /* JADX INFO: renamed from: a */
    private final Context f2903a;

    public C5132n(Context context) {
        this.f2903a = context;
    }

    /* JADX INFO: renamed from: a */
    public final Context m3847a() {
        return this.f2903a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static String m3846a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("local_testing_dir");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
