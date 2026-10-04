package androidx.credentials;

import android.credentials.ClearCredentialStateException;
import android.credentials.CreateCredentialException;
import android.credentials.GetCredentialException;
import android.os.Bundle;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;

/* JADX INFO: renamed from: androidx.credentials.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2513b {
    /* JADX INFO: renamed from: A */
    public static /* bridge */ /* synthetic */ Class m1967A() {
        return GetCredentialException.class;
    }

    /* JADX INFO: renamed from: B */
    public static /* synthetic */ void m1968B() {
    }

    /* JADX INFO: renamed from: C */
    public static /* bridge */ /* synthetic */ Class m1969C() {
        return android.service.credentials.GetCredentialRequest.class;
    }

    /* JADX INFO: renamed from: D */
    public static /* bridge */ /* synthetic */ Class m1970D() {
        return android.service.credentials.CreateCredentialRequest.class;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ ClearCredentialStateException m1971a(String str, String str2) {
        return new ClearCredentialStateException(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public static /* bridge */ /* synthetic */ CreateCredentialException m1972b(Object obj) {
        return (CreateCredentialException) obj;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ CreateCredentialException m1973c(String str, String str2) {
        return new CreateCredentialException(str, str2);
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ android.credentials.CreateCredentialResponse m1974d(Bundle bundle) {
        return new android.credentials.CreateCredentialResponse(bundle);
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ android.credentials.Credential m1975e(Bundle bundle, String str) {
        return new android.credentials.Credential(str, bundle);
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ GetCredentialException m1976f(Object obj) {
        return (GetCredentialException) obj;
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ GetCredentialException m1977g(String str, String str2) {
        return new GetCredentialException(str, str2);
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ android.credentials.GetCredentialResponse m1978h(android.credentials.Credential credential) {
        return new android.credentials.GetCredentialResponse(credential);
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ BeginGetCredentialRequest m1980j(Object obj) {
        return (BeginGetCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: k */
    public static /* bridge */ /* synthetic */ BeginGetCredentialResponse m1981k(Object obj) {
        return (BeginGetCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: m */
    public static /* bridge */ /* synthetic */ android.service.credentials.CreateCredentialRequest m1983m(Object obj) {
        return (android.service.credentials.CreateCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: n */
    public static /* bridge */ /* synthetic */ Class m1984n() {
        return android.credentials.GetCredentialResponse.class;
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ void m1987q() {
    }

    /* JADX INFO: renamed from: t */
    public static /* bridge */ /* synthetic */ Class m1990t() {
        return android.credentials.CreateCredentialResponse.class;
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ void m1991u() {
    }

    /* JADX INFO: renamed from: w */
    public static /* bridge */ /* synthetic */ Class m1993w() {
        return BeginGetCredentialResponse.class;
    }

    /* JADX INFO: renamed from: x */
    public static /* synthetic */ void m1994x() {
    }

    /* JADX INFO: renamed from: y */
    public static /* bridge */ /* synthetic */ Class m1995y() {
        return CreateCredentialException.class;
    }

    /* JADX INFO: renamed from: z */
    public static /* synthetic */ void m1996z() {
    }
}
