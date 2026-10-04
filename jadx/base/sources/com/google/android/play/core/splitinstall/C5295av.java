package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5167ap;
import com.google.android.play.core.internal.C5203by;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.splitcompat.C5271p;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.av */
/* JADX INFO: loaded from: classes5.dex */
final class C5295av {

    /* JADX INFO: renamed from: b */
    private static final C5157af f3104b = new C5157af("SplitInstallService");

    /* JADX INFO: renamed from: c */
    private static final Intent f3105c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    /* JADX INFO: renamed from: a */
    @Nullable
    C5167ap<InterfaceC5199bu> f3106a;

    /* JADX INFO: renamed from: d */
    private final String f3107d;

    public C5295av(Context context) {
        this.f3107d = context.getPackageName();
        if (C5203by.m3973a(context)) {
            this.f3106a = new C5167ap<>(C5271p.m4096a(context), f3104b, "SplitInstallService", f3105c, C5277ad.f3077a);
        }
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ Bundle m4109b() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10800);
        return bundle;
    }

    /* JADX INFO: renamed from: d */
    private static <T> Task<T> m4112d() {
        f3104b.m3877b("onError(%d)", -14);
        return Tasks.m4184a((Exception) new SplitInstallException(-14));
    }

    /* JADX INFO: renamed from: a */
    public final Task<List<SplitInstallSessionState>> m4113a() {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "getSessionStates", new Object[0]);
        this.f3106a.m3897a(new C5284ak(this, c5345iM3195e, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: b */
    public final Task<Void> m4117b(int i) {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "cancelInstall(%d)", new Object[]{Integer.valueOf(i)});
        this.f3106a.m3897a(new C5285al(this, c5345iM3195e, i, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: c */
    public final Task<Void> m4119c(List<String> list) {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "deferredLanguageInstall(%s)", new Object[]{list});
        this.f3106a.m3897a(new C5281ah(this, c5345iM3195e, list, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: d */
    public final Task<Void> m4120d(List<String> list) {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "deferredLanguageUninstall(%s)", new Object[]{list});
        this.f3106a.m3897a(new C5282ai(this, c5345iM3195e, list, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: a */
    public final Task<SplitInstallSessionState> m4114a(int i) {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "getSessionState(%d)", new Object[]{Integer.valueOf(i)});
        this.f3106a.m3897a(new C5283aj(this, c5345iM3195e, i, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: b */
    public final Task<Void> m4118b(List<String> list) {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "deferredInstall(%s)", new Object[]{list});
        this.f3106a.m3897a(new C5280ag(this, c5345iM3195e, list, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: a */
    public final Task<Integer> m4115a(Collection<String> collection, Collection<String> collection2) {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "startInstall(%s,%s)", new Object[]{collection, collection2});
        this.f3106a.m3897a(new C5278ae(this, c5345iM3195e, collection, collection2, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public static /* synthetic */ ArrayList m4110b(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            String str = (String) collection.get(i);
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final Task<Void> m4116a(List<String> list) {
        if (this.f3106a == null) {
            return m4112d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3104b, "deferredUninstall(%s)", new Object[]{list});
        this.f3106a.m3897a(new C5279af(this, c5345iM3195e, list, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ ArrayList m4108a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }
}
