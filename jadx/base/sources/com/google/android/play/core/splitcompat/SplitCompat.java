package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.play.core.internal.C5170as;
import com.google.android.play.core.internal.C5171at;
import com.google.android.play.core.internal.C5173av;
import com.google.android.play.core.internal.C5193bo;
import com.google.android.play.core.internal.C5214ci;
import com.google.android.play.core.internal.InterfaceC5172au;
import com.google.android.play.core.splitinstall.C5314o;
import com.google.android.play.core.splitinstall.C5315p;
import com.google.android.play.core.splitinstall.EnumC5310l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public class SplitCompat {

    /* JADX INFO: renamed from: a */
    private static final AtomicReference<SplitCompat> f3026a = new AtomicReference<>(null);

    /* JADX INFO: renamed from: b */
    private final C5258c f3027b;

    /* JADX INFO: renamed from: c */
    private final Set<String> f3028c = new HashSet();

    /* JADX INFO: renamed from: d */
    private final C5256a f3029d;

    private SplitCompat(Context context) {
        try {
            C5258c c5258c = new C5258c(context);
            this.f3027b = c5258c;
            this.f3029d = new C5256a(c5258c);
        } catch (PackageManager.NameNotFoundException e) {
            throw new C5193bo(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public final Set<String> m4061c() {
        HashSet hashSet;
        synchronized (this.f3028c) {
            hashSet = new HashSet(this.f3028c);
        }
        return hashSet;
    }

    public static boolean install(@NonNull Context context) {
        return m4057a(context, false);
    }

    public static boolean installActivity(@NonNull Context context) {
        if (m4060b()) {
            return false;
        }
        SplitCompat splitCompat = f3026a.get();
        if (splitCompat != null) {
            return splitCompat.f3029d.m4063a(context, splitCompat.m4061c());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4055a() {
        return f3026a.get() != null;
    }

    /* JADX INFO: renamed from: b */
    private final synchronized void m4059b(Context context, boolean z) {
        ZipFile zipFile;
        try {
            if (z) {
                this.f3027b.m4076a();
            } else {
                C5271p.m4098a().execute(new RunnableC5269n(this));
            }
            String packageName = context.getPackageName();
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(packageName, 0).splitNames;
                List<String> arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
                Set<C5272q> setM4082d = this.f3027b.m4082d();
                HashSet hashSet = new HashSet();
                Iterator<C5272q> it = setM4082d.iterator();
                while (it.hasNext()) {
                    String strM4100b = it.next().m4100b();
                    if (arrayList.contains(strM4100b)) {
                        if (z) {
                            this.f3027b.m4086f(strM4100b);
                        } else {
                            hashSet.add(strM4100b);
                        }
                        it.remove();
                    }
                }
                if (!hashSet.isEmpty()) {
                    C5271p.m4098a().execute(new RunnableC5270o(this, hashSet));
                }
                HashSet hashSet2 = new HashSet();
                Iterator<C5272q> it2 = setM4082d.iterator();
                while (it2.hasNext()) {
                    String strM4100b2 = it2.next().m4100b();
                    if (!C5315p.m4145b(strM4100b2)) {
                        hashSet2.add(strM4100b2);
                    }
                }
                for (String str : arrayList) {
                    if (!C5315p.m4145b(str)) {
                        hashSet2.add(str);
                    }
                }
                HashSet<C5272q> hashSet3 = new HashSet(setM4082d.size());
                for (C5272q c5272q : setM4082d) {
                    if (!C5315p.m4144a(c5272q.m4100b())) {
                        String strM4100b3 = c5272q.m4100b();
                        if (hashSet2.contains(C5315p.m4144a(strM4100b3) ? "" : strM4100b3.split("\\.config\\.", 2)[0])) {
                        }
                    }
                    hashSet3.add(c5272q);
                }
                C5266k c5266k = new C5266k(this.f3027b);
                InterfaceC5172au interfaceC5172auM3910a = C5173av.m3910a();
                ClassLoader classLoader = context.getClassLoader();
                if (z) {
                    interfaceC5172auM3910a.mo3908a(classLoader, c5266k.m4093a());
                } else {
                    Iterator it3 = hashSet3.iterator();
                    while (it3.hasNext()) {
                        Set<File> setM4094a = c5266k.m4094a((C5272q) it3.next());
                        if (setM4094a == null) {
                            it3.remove();
                        } else {
                            interfaceC5172auM3910a.mo3908a(classLoader, setM4094a);
                        }
                    }
                }
                HashSet hashSet4 = new HashSet();
                for (C5272q c5272q2 : hashSet3) {
                    try {
                        zipFile = new ZipFile(c5272q2.m4099a());
                    } catch (IOException e) {
                        e = e;
                        zipFile = null;
                    }
                    try {
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        zipFile.close();
                        if (entry == null || interfaceC5172auM3910a.mo3909a(classLoader, this.f3027b.m4081c(c5272q2.m4100b()), c5272q2.m4099a(), z)) {
                            hashSet4.add(c5272q2.m4099a());
                        } else {
                            String strValueOf = String.valueOf(c5272q2.m4099a());
                            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                            sb.append("split was not installed ");
                            sb.append(strValueOf);
                            Log.w("SplitCompat", sb.toString());
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e3) {
                                C5214ci.m3978a(e, e3);
                            }
                        }
                        throw e;
                    }
                }
                C5256a.m4062b(context, hashSet4);
                HashSet hashSet5 = new HashSet();
                for (C5272q c5272q3 : hashSet3) {
                    if (hashSet4.contains(c5272q3.m4099a())) {
                        String strM4100b4 = c5272q3.m4100b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strM4100b4).length() + 30);
                        sb2.append("Split '");
                        sb2.append(strM4100b4);
                        sb2.append("' installation emulated");
                        Log.d("SplitCompat", sb2.toString());
                        hashSet5.add(c5272q3.m4100b());
                    } else {
                        String strM4100b5 = c5272q3.m4100b();
                        StringBuilder sb3 = new StringBuilder(String.valueOf(strM4100b5).length() + 35);
                        sb3.append("Split '");
                        sb3.append(strM4100b5);
                        sb3.append("' installation not emulated.");
                        Log.d("SplitCompat", sb3.toString());
                    }
                }
                synchronized (this.f3028c) {
                    this.f3028c.addAll(hashSet5);
                }
            } catch (PackageManager.NameNotFoundException e5) {
                throw new IOException("Cannot load data for application '" + packageName + "'", e5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4056a(Context context) {
        return m4057a(context, true);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m4060b() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4057a(Context context, boolean z) {
        boolean z2;
        Context context2;
        if (m4060b()) {
            return false;
        }
        AtomicReference<SplitCompat> atomicReference = f3026a;
        SplitCompat splitCompat = new SplitCompat(context);
        while (true) {
            if (atomicReference.compareAndSet(null, splitCompat)) {
                z2 = true;
                break;
            }
            if (atomicReference.get() != null) {
                z2 = false;
                break;
            }
        }
        SplitCompat splitCompat2 = f3026a.get();
        if (z2) {
            context2 = context;
            EnumC5310l.f3133a.m4140a(new C5170as(context2, C5271p.m4098a(), new C5171at(context, splitCompat2.f3027b, new C5173av(), null), splitCompat2.f3027b, new C5271p()));
            C5314o.m4143a(new C5267l(splitCompat2));
            C5271p.m4098a().execute(new RunnableC5268m(context2));
        } else {
            context2 = context;
        }
        try {
            splitCompat2.m4059b(context2, z);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }
}
