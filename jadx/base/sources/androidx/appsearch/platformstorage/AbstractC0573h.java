package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.PackageIdentifier;
import android.app.appsearch.RemoveByDocumentIdRequest;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0573h {
    /* JADX INFO: renamed from: D */
    public static /* synthetic */ void m1052D() {
    }

    /* JADX INFO: renamed from: b */
    public static /* bridge */ /* synthetic */ AppSearchResult m1054b(Object obj) {
        return (AppSearchResult) obj;
    }

    /* JADX INFO: renamed from: c */
    public static /* bridge */ /* synthetic */ AppSearchSchema m1055c(Object obj) {
        return (AppSearchSchema) obj;
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ GenericDocument.Builder m1058f(String str, String str2, String str3) {
        return new GenericDocument.Builder(str, str2, str3);
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ PackageIdentifier m1061i(Object obj) {
        return (PackageIdentifier) obj;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ RemoveByDocumentIdRequest.Builder m1063k(String str) {
        return new RemoveByDocumentIdRequest.Builder(str);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ void m1067o() {
    }
}
