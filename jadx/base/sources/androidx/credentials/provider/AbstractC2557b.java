package androidx.credentials.provider;

import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.credentials.CredentialOption;
import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.GetCredentialRequest;

/* JADX INFO: renamed from: androidx.credentials.provider.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2557b {
    /* JADX INFO: renamed from: B */
    public static /* synthetic */ void m2052B() {
    }

    /* JADX INFO: renamed from: C */
    public static /* synthetic */ void m2053C() {
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ void m2054D() {
    }

    /* JADX INFO: renamed from: c */
    public static /* bridge */ /* synthetic */ CredentialOption m2057c(Object obj) {
        return (CredentialOption) obj;
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ android.service.credentials.BeginCreateCredentialRequest m2060f(String str, Bundle bundle, android.service.credentials.CallingAppInfo callingAppInfo) {
        return new android.service.credentials.BeginCreateCredentialRequest(str, bundle, callingAppInfo);
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ BeginCreateCredentialResponse.Builder m2061g() {
        return new BeginCreateCredentialResponse.Builder();
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ android.service.credentials.CallingAppInfo m2065k(String str, SigningInfo signingInfo, String str2) {
        return new android.service.credentials.CallingAppInfo(str, signingInfo, str2);
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ android.service.credentials.CreateEntry m2066l(Slice slice) {
        return new android.service.credentials.CreateEntry(slice);
    }

    /* JADX INFO: renamed from: m */
    public static /* bridge */ /* synthetic */ GetCredentialRequest m2067m(Object obj) {
        return (GetCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ android.service.credentials.RemoteEntry m2068n(Slice slice) {
        return new android.service.credentials.RemoteEntry(slice);
    }

    /* JADX INFO: renamed from: p */
    public static /* bridge */ /* synthetic */ Class m2070p() {
        return android.service.credentials.BeginGetCredentialRequest.class;
    }

    /* JADX INFO: renamed from: w */
    public static /* synthetic */ void m2077w() {
    }
}
