package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.google.android.play.core.internal.C5157af;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.missingsplits.a */
/* JADX INFO: loaded from: classes5.dex */
final class C5245a {

    /* JADX INFO: renamed from: a */
    private static final C5157af f3003a = new C5157af("MissingSplitsAppComponentsHelper");

    /* JADX INFO: renamed from: b */
    private final Context f3004b;

    /* JADX INFO: renamed from: c */
    private final PackageManager f3005c;

    public C5245a(Context context, PackageManager packageManager) {
        this.f3004b = context;
        this.f3005c = packageManager;
    }

    /* JADX INFO: renamed from: a */
    private final void m4040a(List<ComponentInfo> list, int i) {
        for (ComponentInfo componentInfo : list) {
            this.f3005c.setComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name), i, 1);
        }
    }

    /* JADX INFO: renamed from: d */
    private final List<ComponentInfo> m4041d() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.f3005c.getPackageInfo(this.f3004b.getPackageName(), 526);
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                Collections.addAll(arrayList, providerInfoArr);
            }
            ActivityInfo[] activityInfoArr = packageInfo.receivers;
            if (activityInfoArr != null) {
                Collections.addAll(arrayList, activityInfoArr);
            }
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                Collections.addAll(arrayList, serviceInfoArr);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            f3003a.m3879d("Failed to resolve own package : %s", e);
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4043b() {
        f3003a.m3878c("Disabling all non-activity components", new Object[0]);
        m4040a(m4041d(), 2);
    }

    /* JADX INFO: renamed from: c */
    public final void m4044c() {
        f3003a.m3878c("Resetting enabled state of all non-activity components", new Object[0]);
        m4040a(m4041d(), 0);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4042a() {
        for (ComponentInfo componentInfo : m4041d()) {
            if (this.f3005c.getComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name)) != 2) {
                f3003a.m3875a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f3003a.m3875a("All non-activity components are disabled", new Object[0]);
        return true;
    }
}
