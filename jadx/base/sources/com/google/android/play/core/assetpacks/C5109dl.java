package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.play.core.internal.C5157af;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dl */
/* JADX INFO: loaded from: classes5.dex */
final class C5109dl {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2827a = new C5157af("PackageStateCache");

    /* JADX INFO: renamed from: b */
    private final Context f2828b;

    /* JADX INFO: renamed from: c */
    private int f2829c = -1;

    public C5109dl(Context context) {
        this.f2828b = context;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized int m3800a() {
        if (this.f2829c == -1) {
            try {
                this.f2829c = this.f2828b.getPackageManager().getPackageInfo(this.f2828b.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                f2827a.m3877b("The current version of the app could not be retrieved", new Object[0]);
            }
        }
        return this.f2829c;
    }
}
