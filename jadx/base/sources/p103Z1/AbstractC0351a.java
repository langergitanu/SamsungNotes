package p103Z1;

import android.os.Parcelable;
import android.os.SharedMemory;
import dalvik.system.DelegateLastClassLoader;

/* JADX INFO: renamed from: Z1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC0351a {
    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ SharedMemory m678f(Parcelable parcelable) {
        return (SharedMemory) parcelable;
    }

    /* JADX INFO: renamed from: g */
    public static /* bridge */ /* synthetic */ SharedMemory m679g(Object obj) {
        return (SharedMemory) obj;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ DelegateLastClassLoader m680h(ClassLoader classLoader, String str) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ Class m681i() {
        return SharedMemory.class;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ void m683k() {
    }
}
