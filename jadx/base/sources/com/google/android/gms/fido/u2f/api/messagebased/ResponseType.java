package com.google.android.gms.fido.u2f.api.messagebased;

import androidx.annotation.NonNull;
import com.google.android.gms.fido.u2f.api.messagebased.RequestType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public enum ResponseType {
    REGISTER("u2f_register_response"),
    SIGN("u2f_sign_response");

    private final String zzb;

    ResponseType(String str) {
        this.zzb = str;
    }

    @NonNull
    public static ResponseType getResponseTypeForRequestType(@NonNull RequestType requestType) throws RequestType.UnsupportedRequestTypeException {
        if (requestType == null) {
            throw new RequestType.UnsupportedRequestTypeException(null);
        }
        int iOrdinal = requestType.ordinal();
        if (iOrdinal == 0) {
            return REGISTER;
        }
        if (iOrdinal == 1) {
            return SIGN;
        }
        throw new RequestType.UnsupportedRequestTypeException(requestType.toString());
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.zzb;
    }
}
