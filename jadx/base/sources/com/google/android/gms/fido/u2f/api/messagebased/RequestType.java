package com.google.android.gms.fido.u2f.api.messagebased;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public enum RequestType {
    REGISTER("u2f_register_request"),
    SIGN("u2f_sign_request");

    private final String zzb;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnsupportedRequestTypeException extends Exception {
        public UnsupportedRequestTypeException(@NonNull String str) {
            super("Unsupported request type ".concat(String.valueOf(str)));
        }
    }

    RequestType(String str) {
        this.zzb = str;
    }

    @NonNull
    public static RequestType fromString(@NonNull String str) throws UnsupportedRequestTypeException {
        for (RequestType requestType : values()) {
            if (str.equals(requestType.zzb)) {
                return requestType;
            }
        }
        throw new UnsupportedRequestTypeException(str);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.zzb;
    }
}
