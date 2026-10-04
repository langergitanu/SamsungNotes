package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.y */
/* JADX INFO: loaded from: classes5.dex */
public final class C5335y {

    /* JADX INFO: renamed from: a */
    private final Context f3215a;

    public C5335y(Context context) {
        this.f3215a = context;
    }

    /* JADX INFO: renamed from: a */
    public final C5319t m4181a() {
        return C5319t.m4153a(this.f3215a);
    }

    /* JADX INFO: renamed from: b */
    public final Context m4182b() {
        return this.f3215a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static File m4180a(Context context) {
        String string;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || (string = bundle.getString("local_testing_dir")) == null) {
                return null;
            }
            return new File(context.getExternalFilesDir(null), string);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
