package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.SearchResult;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.converter.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0567d {
    /* JADX INFO: renamed from: d */
    public static /* synthetic */ AppSearchManager.SearchContext.Builder m970d(String str) {
        return new AppSearchManager.SearchContext.Builder(str);
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ SearchResult.MatchInfo m972f(Object obj) {
        return (SearchResult.MatchInfo) obj;
    }

    /* JADX INFO: renamed from: n */
    public static /* bridge */ /* synthetic */ boolean m980n(Object obj) {
        return obj instanceof AppSearchSchema.DoublePropertyConfig;
    }

    /* JADX INFO: renamed from: s */
    public static /* bridge */ /* synthetic */ boolean m985s(Object obj) {
        return obj instanceof AppSearchSchema.BooleanPropertyConfig;
    }

    /* JADX INFO: renamed from: t */
    public static /* bridge */ /* synthetic */ boolean m986t(Object obj) {
        return obj instanceof AppSearchSchema.BytesPropertyConfig;
    }

    /* JADX INFO: renamed from: u */
    public static /* bridge */ /* synthetic */ boolean m987u(Object obj) {
        return obj instanceof AppSearchSchema.DocumentPropertyConfig;
    }

    /* JADX INFO: renamed from: v */
    public static /* synthetic */ void m988v() {
    }
}
