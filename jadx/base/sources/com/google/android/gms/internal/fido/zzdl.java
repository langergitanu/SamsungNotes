package com.google.android.gms.internal.fido;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdl extends IOException {
    public zzdl(String str) {
        super(str);
    }

    public zzdl(String str, Throwable th) {
        super("Error in decoding CborValue from bytes", th);
    }
}
