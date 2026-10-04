package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C5157af;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.p */
/* JADX INFO: loaded from: classes5.dex */
public final class C5315p {

    /* JADX INFO: renamed from: a */
    private static final C5157af f3138a = new C5157af("SplitInstallInfoProvider");

    /* JADX INFO: renamed from: b */
    private final Context f3139b;

    /* JADX INFO: renamed from: c */
    private final String f3140c;

    public C5315p(Context context) {
        this.f3139b = context;
        this.f3140c = context.getPackageName();
    }

    /* JADX INFO: renamed from: d */
    private final Set<String> m4146d() {
        HashSet hashSet = new HashSet();
        Bundle bundleM4147e = m4147e();
        if (bundleM4147e != null) {
            String string = bundleM4147e.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                f3138a.m3875a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        String[] strArr = null;
        try {
            PackageInfo packageInfo = this.f3139b.getPackageManager().getPackageInfo(this.f3140c, 0);
            if (packageInfo != null) {
                strArr = packageInfo.splitNames;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            f3138a.m3879d("App is not found in PackageManager", new Object[0]);
        }
        if (strArr != null) {
            f3138a.m3875a("Adding splits from package manager: %s", Arrays.toString(strArr));
            Collections.addAll(hashSet, strArr);
        } else {
            f3138a.m3875a("No splits are found or app cannot be found in package manager.", new Object[0]);
        }
        InterfaceC5313n interfaceC5313nM4142a = C5314o.m4142a();
        if (interfaceC5313nM4142a != null) {
            hashSet.addAll(interfaceC5313nM4142a.mo4095a());
        }
        return hashSet;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    private final Bundle m4147e() {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.f3139b.getPackageManager().getApplicationInfo(this.f3140c, 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle;
            }
            f3138a.m3875a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f3138a.m3879d("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final Set<String> m4148a() {
        HashSet hashSet = new HashSet();
        for (String str : m4146d()) {
            if (!m4145b(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public final Set<String> m4149b() {
        C5306h c5306hM4150c = m4150c();
        if (c5306hM4150c == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> setM4146d = m4146d();
        setM4146d.add("");
        Set<String> setM4148a = m4148a();
        setM4148a.add("");
        for (Map.Entry<String, Set<String>> entry : c5306hM4150c.m4137a(setM4148a).entrySet()) {
            if (setM4146d.containsAll(entry.getValue())) {
                hashSet.add(entry.getKey());
            }
        }
        return hashSet;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public final C5306h m4150c() {
        Bundle bundleM4147e = m4147e();
        if (bundleM4147e == null) {
            f3138a.m3879d("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = bundleM4147e.getInt("com.android.vending.splits");
        if (i == 0) {
            f3138a.m3879d("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            C5306h c5306hM4126a = new C5299az(this.f3139b.getResources().getXml(i)).m4126a();
            if (c5306hM4126a == null) {
                f3138a.m3879d("Can't parse languages metadata.", new Object[0]);
            }
            return c5306hM4126a;
        } catch (Resources.NotFoundException unused) {
            f3138a.m3879d("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }

    public C5315p(Context context, String str) {
        this.f3139b = context;
        this.f3140c = str;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4144a(String str) {
        return str.startsWith("config.");
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4145b(String str) {
        return m4144a(str) || str.contains(".config.");
    }
}
