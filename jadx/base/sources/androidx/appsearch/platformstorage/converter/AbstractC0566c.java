package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.AppSearchSchema;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.converter.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0566c {
    /* JADX INFO: renamed from: b */
    public static /* synthetic */ AppSearchSchema.Builder m954b(String str) {
        return new AppSearchSchema.Builder(str);
    }

    /* JADX INFO: renamed from: e */
    public static /* bridge */ /* synthetic */ AppSearchSchema.LongPropertyConfig m957e(Object obj) {
        return (AppSearchSchema.LongPropertyConfig) obj;
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ AppSearchSchema.PropertyConfig m958f(Object obj) {
        return (AppSearchSchema.PropertyConfig) obj;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ void m963k() {
    }

    /* JADX INFO: renamed from: m */
    public static /* bridge */ /* synthetic */ boolean m965m(Object obj) {
        return obj instanceof AppSearchSchema.LongPropertyConfig;
    }

    /* JADX INFO: renamed from: n */
    public static /* bridge */ /* synthetic */ boolean m966n(Object obj) {
        return obj instanceof AppSearchSchema.StringPropertyConfig;
    }
}
