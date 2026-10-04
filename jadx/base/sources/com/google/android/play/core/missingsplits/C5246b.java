package com.google.android.play.core.missingsplits;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.internal.C5157af;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.google.android.play.core.missingsplits.b */
/* JADX INFO: loaded from: classes5.dex */
final class C5246b implements MissingSplitsManager {

    /* JADX INFO: renamed from: a */
    private static final C5157af f3006a = new C5157af("MissingSplitsManagerImpl");

    /* JADX INFO: renamed from: b */
    private final Context f3007b;

    /* JADX INFO: renamed from: c */
    private final Runtime f3008c;

    /* JADX INFO: renamed from: d */
    private final C5245a f3009d;

    /* JADX INFO: renamed from: e */
    private final AtomicReference<Boolean> f3010e;

    public C5246b(Context context, Runtime runtime, C5245a c5245a, AtomicReference<Boolean> atomicReference) {
        this.f3007b = context;
        this.f3008c = runtime;
        this.f3009d = c5245a;
        this.f3010e = atomicReference;
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: a */
    private final boolean m4045a() {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.f3007b.getPackageManager().getApplicationInfo(this.f3007b.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                if (Boolean.TRUE.equals(bundle.get("com.android.vending.splits.required"))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            f3006a.m3879d("App '%s' is not found in the PackageManager", this.f3007b.getPackageName());
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private final Set<String> m4047b() {
        String[] strArr;
        try {
            PackageInfo packageInfo = this.f3007b.getPackageManager().getPackageInfo(this.f3007b.getPackageName(), 0);
            HashSet hashSet = new HashSet();
            if (packageInfo != null && (strArr = packageInfo.splitNames) != null) {
                Collections.addAll(hashSet, strArr);
            }
            return hashSet;
        } catch (PackageManager.NameNotFoundException unused) {
            f3006a.m3879d("App '%s' is not found in PackageManager", this.f3007b.getPackageName());
            return Collections.EMPTY_SET;
        }
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: c */
    private final List<ActivityManager.AppTask> m4048c() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.f3007b.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).getAppTasks();
        return appTasks != null ? appTasks : Collections.EMPTY_LIST;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean disableAppIfMissingRequiredSplits() {
        boolean zBooleanValue;
        boolean z;
        Class<?> cls;
        boolean z2;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Set hashSet;
        String[] strArr;
        synchronized (this.f3010e) {
            if (this.f3010e.get() == null) {
                AtomicReference<Boolean> atomicReference = this.f3010e;
                try {
                    applicationInfo = this.f3007b.getPackageManager().getApplicationInfo(this.f3007b.getPackageName(), 128);
                } catch (PackageManager.NameNotFoundException unused) {
                    f3006a.m3879d("App '%s' is not found in the PackageManager", this.f3007b.getPackageName());
                }
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                    z2 = false;
                    atomicReference.set(Boolean.valueOf(z2));
                    zBooleanValue = this.f3010e.get().booleanValue();
                } else if (Boolean.TRUE.equals(bundle.get("com.android.vending.splits.required"))) {
                    try {
                        PackageInfo packageInfo = this.f3007b.getPackageManager().getPackageInfo(this.f3007b.getPackageName(), 0);
                        hashSet = new HashSet();
                        if (packageInfo != null && (strArr = packageInfo.splitNames) != null) {
                            Collections.addAll(hashSet, strArr);
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        f3006a.m3879d("App '%s' is not found in PackageManager", this.f3007b.getPackageName());
                        hashSet = Collections.EMPTY_SET;
                    }
                    if (hashSet.isEmpty() || (hashSet.size() == 1 && hashSet.contains(""))) {
                        z2 = true;
                    }
                    atomicReference.set(Boolean.valueOf(z2));
                    zBooleanValue = this.f3010e.get().booleanValue();
                }
            } else {
                zBooleanValue = this.f3010e.get().booleanValue();
            }
        }
        if (!zBooleanValue) {
            if (this.f3009d.m4042a()) {
                this.f3009d.m4044c();
                this.f3008c.exit(0);
            }
            return false;
        }
        Iterator<ActivityManager.AppTask> it = m4048c().iterator();
        while (true) {
            if (it.hasNext()) {
                ActivityManager.AppTask next = it.next();
                if (next.getTaskInfo() != null && next.getTaskInfo().baseIntent != null && next.getTaskInfo().baseIntent.getComponent() != null) {
                    if (PlayCoreMissingSplitsActivity.class.getName().equals(next.getTaskInfo().baseIntent.getComponent().getClassName())) {
                        break;
                    }
                }
            } else {
                Iterator<ActivityManager.AppTask> it2 = m4048c().iterator();
                loop1: while (it2.hasNext()) {
                    ActivityManager.RecentTaskInfo taskInfo = it2.next().getTaskInfo();
                    if (taskInfo != null && taskInfo.baseIntent != null && taskInfo.baseIntent.getComponent() != null) {
                        ComponentName component = taskInfo.baseIntent.getComponent();
                        String className = component.getClassName();
                        try {
                            cls = Class.forName(className);
                        } catch (ClassNotFoundException unused3) {
                            f3006a.m3879d("ClassNotFoundException when scanning class hierarchy of '%s'", className);
                            try {
                            } catch (PackageManager.NameNotFoundException unused4) {
                                continue;
                            }
                            if (this.f3007b.getPackageManager().getActivityInfo(component, 0) != null) {
                            }
                        }
                        while (cls != null) {
                            if (cls.equals(Activity.class)) {
                                z = true;
                                break;
                            }
                            Class<? super Object> superclass = cls.getSuperclass();
                            cls = superclass != cls ? superclass : null;
                        }
                    }
                }
                z = false;
                this.f3009d.m4043b();
                Iterator<ActivityManager.AppTask> it3 = m4048c().iterator();
                while (it3.hasNext()) {
                    it3.next().finishAndRemoveTask();
                }
                if (z) {
                    this.f3007b.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f3007b, (Class<?>) PlayCoreMissingSplitsActivity.class), 1, 1);
                    this.f3007b.startActivity(new Intent(this.f3007b, (Class<?>) PlayCoreMissingSplitsActivity.class).addFlags(884998144));
                }
                this.f3008c.exit(0);
            }
        }
        return true;
    }

    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    public final boolean isMissingRequiredSplits() {
        boolean zBooleanValue;
        synchronized (this.f3010e) {
            try {
                if (this.f3010e.get() == null) {
                    AtomicReference<Boolean> atomicReference = this.f3010e;
                    boolean z = false;
                    if (m4045a() && m4046a(m4047b())) {
                        z = true;
                    }
                    atomicReference.set(Boolean.valueOf(z));
                }
                zBooleanValue = this.f3010e.get().booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4046a(Set<String> set) {
        if (set.isEmpty()) {
            return true;
        }
        return set.size() == 1 && set.contains("");
    }
}
