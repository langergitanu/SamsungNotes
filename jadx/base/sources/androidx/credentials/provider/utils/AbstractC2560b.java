package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.os.Bundle;
import android.service.credentials.Action;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;
import android.service.credentials.CreateEntry;
import android.service.credentials.CredentialEntry;

/* JADX INFO: renamed from: androidx.credentials.provider.utils.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2560b {
    /* JADX INFO: renamed from: A */
    public static /* synthetic */ void m2094A() {
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ void m2097D() {
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ Action m2100c(Slice slice) {
        return new Action(slice);
    }

    /* JADX INFO: renamed from: d */
    public static /* bridge */ /* synthetic */ BeginGetCredentialOption m2101d(Object obj) {
        return (BeginGetCredentialOption) obj;
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ BeginGetCredentialOption m2102e(String str, String str2) {
        return new BeginGetCredentialOption(str, str2, Bundle.EMPTY);
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ BeginGetCredentialOption m2103f(String str, String str2, Bundle bundle) {
        return new BeginGetCredentialOption(str, str2, bundle);
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ BeginGetCredentialRequest.Builder m2104g() {
        return new BeginGetCredentialRequest.Builder();
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ BeginGetCredentialResponse.Builder m2107j() {
        return new BeginGetCredentialResponse.Builder();
    }

    /* JADX INFO: renamed from: m */
    public static /* bridge */ /* synthetic */ CreateEntry m2110m(Object obj) {
        return (CreateEntry) obj;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ CredentialEntry m2111n(BeginGetCredentialOption beginGetCredentialOption, Slice slice) {
        return new CredentialEntry(beginGetCredentialOption, slice);
    }

    /* JADX INFO: renamed from: o */
    public static /* bridge */ /* synthetic */ CredentialEntry m2112o(Object obj) {
        return (CredentialEntry) obj;
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ void m2117t() {
    }
}
