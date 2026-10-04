package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.glance.AbstractC2821a;
import com.google.android.meet.addons.annotations.PublicApi;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public class AddonException extends RuntimeException {
    private final Code zza;
    private final Optional zzb;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Code {
        UNKNOWN(0),
        MEET_VERSION_UNSUPPORTED(1),
        SDK_VERSION_UNSUPPORTED(2),
        PARTICIPANT_INELIGIBLE(3),
        ADDON_SESSION_IN_PROGRESS_WITH_DIFFERENT_APPLICATION(4),
        SECURITY_POLICY_EXCEPTION(5),
        OPERATION_UNSUPPORTED(6),
        ONGOING_RECORDING(7),
        ADDON_NOT_INSTALLED(8);

        Code(int i) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AddonException(@Nullable String str, Code code, Optional optional) {
        if (str == null && code.equals(Code.UNKNOWN)) {
            str = null;
        } else if (!code.equals(Code.UNKNOWN)) {
            str = str == null ? code.name() : AbstractC2821a.m2221l(str, " [", code.name(), "]");
        }
        super(str);
        this.zza = code;
        this.zzb = optional;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof AddonException) {
            AddonException addonException = (AddonException) obj;
            if (this.zza == addonException.zza) {
                if (getMessage() == null && addonException.getMessage() == null) {
                    return true;
                }
                return getMessage() != null && getMessage().equals(addonException.getMessage());
            }
        }
        return false;
    }

    @NonNull
    public Code getCode() {
        return this.zza;
    }

    @NonNull
    public Optional<AddonExceptionMetadata> getMetadata() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hash(this.zza, getMessage());
    }
}
