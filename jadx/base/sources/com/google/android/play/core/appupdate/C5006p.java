package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5167ap;
import com.google.android.play.core.internal.C5203by;
import com.google.android.play.core.internal.InterfaceC5230n;
import com.google.android.play.core.splitcompat.C5271p;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.p */
/* JADX INFO: loaded from: classes5.dex */
final class C5006p {

    /* JADX INFO: renamed from: b */
    private static final C5157af f2448b = new C5157af("AppUpdateService");

    /* JADX INFO: renamed from: c */
    private static final Intent f2449c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* JADX INFO: renamed from: a */
    @Nullable
    C5167ap<InterfaceC5230n> f2450a;

    /* JADX INFO: renamed from: d */
    private final String f2451d;

    /* JADX INFO: renamed from: e */
    private final Context f2452e;

    /* JADX INFO: renamed from: f */
    private final C5008r f2453f;

    public C5006p(Context context, C5008r c5008r) {
        this.f2451d = context.getPackageName();
        this.f2452e = context;
        this.f2453f = c5008r;
        if (C5203by.m3973a(context)) {
            this.f2450a = new C5167ap<>(C5271p.m4096a(context), f2448b, "AppUpdateService", f2449c, C5000j.f2436a);
        }
    }

    /* JADX INFO: renamed from: c */
    private static <T> Task<T> m3604c() {
        f2448b.m3877b("onError(%d)", -9);
        return Tasks.m4184a((Exception) new InstallException(-9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public static Bundle m3605d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10800);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ Bundle m3599a(C5006p c5006p, String str) {
        Integer numValueOf;
        Bundle bundle = new Bundle();
        bundle.putAll(m3605d());
        bundle.putString("package.name", str);
        try {
            numValueOf = Integer.valueOf(c5006p.f2452e.getPackageManager().getPackageInfo(c5006p.f2452e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f2448b.m3877b("The current version of the app could not be retrieved", new Object[0]);
            numValueOf = null;
        }
        if (numValueOf != null) {
            bundle.putInt("app.version.code", numValueOf.intValue());
        }
        return bundle;
    }

    /* JADX INFO: renamed from: b */
    public final Task<Void> m3607b(String str) {
        if (this.f2450a == null) {
            return m3604c();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2448b, "completeUpdate(%s)", new Object[]{str});
        this.f2450a.m3897a(new C5002l(this, c5345iM3195e, c5345iM3195e, str));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: a */
    public final Task<AppUpdateInfo> m3606a(String str) {
        if (this.f2450a == null) {
            return m3604c();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2448b, "requestUpdateInfo(%s)", new Object[]{str});
        this.f2450a.m3897a(new C5001k(this, c5345iM3195e, str, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }
}
