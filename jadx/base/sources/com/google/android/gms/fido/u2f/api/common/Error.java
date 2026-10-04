package com.google.android.gms.fido.u2f.api.common;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Error {

    @NonNull
    @VisibleForTesting
    public static final String JSON_ERROR_CODE = "errorCode";

    @NonNull
    @VisibleForTesting
    public static final String JSON_ERROR_MESSAGE = "errorMessage";
    private final ErrorCode zza;
    private final String zzb;

    public Error(@NonNull ErrorCode errorCode) {
        this.zza = errorCode;
        this.zzb = null;
    }

    @NonNull
    public ErrorCode getErrorCode() {
        return this.zza;
    }

    @NonNull
    public String getErrorMessage() {
        return this.zzb;
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", this.zza.getCode());
            String str = this.zzb;
            if (str == null) {
                return jSONObject;
            }
            jSONObject.put("errorMessage", str);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public String toString() {
        if (this.zzb == null) {
            Locale locale = Locale.ENGLISH;
            return AbstractC0541b.m767i(this.zza.getCode(), "{errorCode: ", "}");
        }
        Locale locale2 = Locale.ENGLISH;
        return AbstractC11014a.m12321f("{errorCode: ", this.zza.getCode(), ", errorMessage: ", this.zzb, "}");
    }

    public Error(@NonNull ErrorCode errorCode, @NonNull String str) {
        this.zza = errorCode;
        this.zzb = str;
    }
}
