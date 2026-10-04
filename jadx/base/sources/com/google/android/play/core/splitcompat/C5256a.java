package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.play.core.internal.C5195bq;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.a */
/* JADX INFO: loaded from: classes5.dex */
final class C5256a {

    /* JADX INFO: renamed from: a */
    private final C5258c f3030a;

    public C5256a(C5258c c5258c) {
        this.f3030a = c5258c;
    }

    /* JADX INFO: renamed from: b */
    public static final synchronized void m4062b(Context context, Set<File> set) {
        AssetManager assets = context.getAssets();
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) C5195bq.m3937a(assets, "addAssetPath", Integer.class, (Class<String>) String.class, it.next().getPath())).intValue();
            StringBuilder sb = new StringBuilder(39);
            sb.append("addAssetPath completed with ");
            sb.append(iIntValue);
            Log.d("SplitCompat", sb.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized boolean m4063a(Context context, Set<String> set) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
        } catch (Exception e) {
            e = e;
            threadPolicy = null;
        }
        try {
            StrictMode.allowThreadDiskReads();
            StrictMode.allowThreadDiskWrites();
        } catch (Exception e2) {
            e = e2;
            Log.i("SplitCompat", "Unable to set up strict mode.", e);
        }
        try {
            try {
                HashSet hashSet = new HashSet();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    hashSet.add(this.f3030a.m4078b(it.next()));
                }
                m4062b(context, hashSet);
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
            } catch (Exception e3) {
                Log.e("SplitCompat", "Error installing additional splits", e3);
                if (threadPolicy == null) {
                    return false;
                }
                StrictMode.setThreadPolicy(threadPolicy);
                return false;
            }
        } catch (Throwable th) {
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
            }
            throw th;
        }
        return true;
    }
}
