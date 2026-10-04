package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.play.core.splitcompat.C5258c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.internal.at */
/* JADX INFO: loaded from: classes5.dex */
public final class C5171at {

    /* JADX INFO: renamed from: a */
    private final C5258c f2963a;

    /* JADX INFO: renamed from: b */
    private final Context f2964b;

    /* JADX INFO: renamed from: c */
    private final C5173av f2965c;

    public C5171at(Context context, C5258c c5258c, C5173av c5173av, byte[] bArr) {
        this.f2963a = c5258c;
        this.f2965c = c5173av;
        this.f2964b = context;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static X509Certificate m3905a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        android.util.Log.e("SplitCompat", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b1, code lost:
    
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r8).length() + 32);
        r5.append("Downloaded split ");
        r5.append(r8);
        r5.append(" is not signed.");
        r0 = r5.toString();
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m3906a() {
        Signature[] signatureArr;
        try {
            File fileM4080c = this.f2963a.m4080c();
            ArrayList<X509Certificate> arrayList = null;
            try {
                signatureArr = this.f2964b.getPackageManager().getPackageInfo(this.f2964b.getPackageName(), 64).signatures;
            } catch (PackageManager.NameNotFoundException unused) {
                signatureArr = null;
            }
            if (signatureArr != null) {
                arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    X509Certificate x509CertificateM3905a = m3905a(signature);
                    if (x509CertificateM3905a != null) {
                        arrayList.add(x509CertificateM3905a);
                    }
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                Log.e("SplitCompat", "No app certificates found.");
                return false;
            }
            File[] fileArrListFiles = fileM4080c.listFiles();
            Arrays.sort(fileArrListFiles);
            int length = fileArrListFiles.length;
            loop1: while (true) {
                length--;
                if (length < 0) {
                    return true;
                }
                File file = fileArrListFiles[length];
                try {
                    String absolutePath = file.getAbsolutePath();
                    try {
                        X509Certificate[][] x509CertificateArrM4000a = C5224h.m4000a(absolutePath);
                        if (x509CertificateArrM4000a == null || x509CertificateArrM4000a.length == 0 || x509CertificateArrM4000a[0].length == 0) {
                            break;
                        }
                        if (arrayList.isEmpty()) {
                            String string = "No certificates found for app.";
                            break;
                        }
                        for (X509Certificate x509Certificate : arrayList) {
                            for (X509Certificate[] x509CertificateArr : x509CertificateArrM4000a) {
                                int i = x509CertificateArr[0].equals(x509Certificate) ? 0 : i + 1;
                            }
                            Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
                        }
                        try {
                            file.renameTo(this.f2963a.m4073a(file));
                        } catch (IOException e) {
                            Log.e("SplitCompat", "Cannot write verified split.", e);
                            return false;
                        }
                    } catch (Exception e2) {
                        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 32);
                        sb.append("Downloaded split ");
                        sb.append(absolutePath);
                        sb.append(" is not signed.");
                        Log.e("SplitCompat", sb.toString(), e2);
                    }
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Split verification error.", e3);
                    return false;
                }
            }
            Log.e("SplitCompat", "Split verification failure.");
            return false;
        } catch (IOException e5) {
            Log.e("SplitCompat", "Cannot access directory for unverified splits.", e5);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3907a(List<Intent> list) {
        Iterator<Intent> it = list.iterator();
        while (it.hasNext()) {
            if (!this.f2963a.m4078b(it.next().getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
