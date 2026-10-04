package androidx.credentials;

import android.credentials.ClearCredentialStateException;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialRequest;
import android.credentials.CredentialOption;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialRequest;
import android.os.Bundle;

/* JADX INFO: renamed from: androidx.credentials.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2512a {
    /* JADX INFO: renamed from: B */
    public static /* synthetic */ void m1938B() {
    }

    /* JADX INFO: renamed from: C */
    public static /* synthetic */ void m1939C() {
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ void m1940D() {
    }

    /* JADX INFO: renamed from: a */
    public static /* bridge */ /* synthetic */ ClearCredentialStateException m1941a(Throwable th) {
        return (ClearCredentialStateException) th;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ android.credentials.ClearCredentialStateRequest m1942b(Bundle bundle) {
        return new android.credentials.ClearCredentialStateRequest(bundle);
    }

    /* JADX INFO: renamed from: c */
    public static /* bridge */ /* synthetic */ CreateCredentialException m1943c(Throwable th) {
        return (CreateCredentialException) th;
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ CreateCredentialRequest.Builder m1946f(String str, Bundle bundle, Bundle bundle2) {
        return new CreateCredentialRequest.Builder(str, bundle, bundle2);
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ android.credentials.CreateCredentialResponse m1948h(Object obj) {
        return (android.credentials.CreateCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ android.credentials.CredentialManager m1949i(Object obj) {
        return (android.credentials.CredentialManager) obj;
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ CredentialOption.Builder m1950j(String str, Bundle bundle, Bundle bundle2) {
        return new CredentialOption.Builder(str, bundle, bundle2);
    }

    /* JADX INFO: renamed from: k */
    public static /* bridge */ /* synthetic */ GetCredentialException m1951k(Throwable th) {
        return (GetCredentialException) th;
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ GetCredentialRequest.Builder m1952l(Bundle bundle) {
        return new GetCredentialRequest.Builder(bundle);
    }

    /* JADX INFO: renamed from: m */
    public static /* bridge */ /* synthetic */ android.credentials.GetCredentialResponse m1953m(Object obj) {
        return (android.credentials.GetCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: o */
    public static /* bridge */ /* synthetic */ android.credentials.PrepareGetCredentialResponse m1955o(Object obj) {
        return (android.credentials.PrepareGetCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: s */
    public static /* synthetic */ void m1959s() {
    }
}
