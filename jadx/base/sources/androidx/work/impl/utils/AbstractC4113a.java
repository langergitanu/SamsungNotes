package androidx.work.impl.utils;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.os.IBinder;
import android.view.Display;
import android.view.SurfaceControlViewHost;
import android.view.WindowInsetsAnimation$Callback;

/* JADX INFO: renamed from: androidx.work.impl.utils.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC4113a {
    /* JADX INFO: renamed from: B */
    public static /* bridge */ /* synthetic */ boolean m2444B(Object obj) {
        return obj instanceof WindowInsetsAnimation$Callback;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ ResourcesLoader m2449c() {
        return new ResourcesLoader();
    }

    /* JADX INFO: renamed from: g */
    public static /* bridge */ /* synthetic */ SurfaceControlViewHost.SurfacePackage m2453g(Object obj) {
        return (SurfaceControlViewHost.SurfacePackage) obj;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ SurfaceControlViewHost m2454h(Context context, Display display, IBinder iBinder) {
        return new SurfaceControlViewHost(context, display, iBinder);
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ WindowInsetsAnimation$Callback m2455i(Object obj) {
        return (WindowInsetsAnimation$Callback) obj;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ void m2457k() {
    }
}
