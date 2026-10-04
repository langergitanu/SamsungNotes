package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.ReportSystemUsageRequest;
import android.app.appsearch.ReportUsageRequest;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.converter.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0565b {
    /* JADX INFO: renamed from: B */
    public static /* synthetic */ void m924B() {
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ void m926D() {
    }

    /* JADX INFO: renamed from: e */
    public static /* bridge */ /* synthetic */ AppSearchSchema.DocumentPropertyConfig m931e(Object obj) {
        return (AppSearchSchema.DocumentPropertyConfig) obj;
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ AppSearchSchema.StringPropertyConfig m932f(Object obj) {
        return (AppSearchSchema.StringPropertyConfig) obj;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ GetByDocumentIdRequest.Builder m934h(String str) {
        return new GetByDocumentIdRequest.Builder(str);
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ PutDocumentsRequest.Builder m935i() {
        return new PutDocumentsRequest.Builder();
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ ReportSystemUsageRequest.Builder m939m(String str, String str2, String str3, String str4) {
        return new ReportSystemUsageRequest.Builder(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ ReportUsageRequest.Builder m942p(String str, String str2) {
        return new ReportUsageRequest.Builder(str, str2);
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ void m947u() {
    }
}
