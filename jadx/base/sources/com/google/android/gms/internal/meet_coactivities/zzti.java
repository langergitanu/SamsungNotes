package com.google.android.gms.internal.meet_coactivities;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class zzti extends IOException {
    private boolean zza;

    public zzti(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public static zzth zza() {
        return new zzth("Protocol message tag had invalid wire type.");
    }

    public static zzti zzb() {
        return new zzti("Protocol message end-group tag did not match expected tag.");
    }

    public static zzti zzc() {
        return new zzti("Protocol message contained an invalid tag (zero).");
    }

    public static zzti zzd() {
        return new zzti("Protocol message had invalid UTF-8.");
    }

    public static zzti zze() {
        return new zzti("CodedInputStream encountered a malformed varint.");
    }

    public static zzti zzf() {
        return new zzti("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzti zzg() {
        return new zzti("Failed to parse the message.");
    }

    public static zzti zzh() {
        return new zzti("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static zzti zzi() {
        return new zzti("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final void zzj() {
        this.zza = true;
    }

    public final boolean zzk() {
        return this.zza;
    }

    public zzti(String str) {
        super(str);
    }
}
