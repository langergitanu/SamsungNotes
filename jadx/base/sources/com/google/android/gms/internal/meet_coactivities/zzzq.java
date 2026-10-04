package com.google.android.gms.internal.meet_coactivities;

import androidx.collection.AbstractC0622a;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Immutable
public abstract class zzzq {
    private static final BitSet zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;

    static {
        BitSet bitSet = new BitSet(127);
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            bitSet.set(c);
        }
        for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
            bitSet.set(c2);
        }
        zza = bitSet;
    }

    public /* synthetic */ zzzq(String str, boolean z, Object obj, zzzp zzzpVar) {
        String str2 = (String) Preconditions.checkNotNull(str, "name");
        this.zzb = str2;
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        Preconditions.checkNotNull(lowerCase, "name");
        Preconditions.checkArgument(!lowerCase.isEmpty(), "token must have at least 1 tchar");
        if (lowerCase.equals("connection")) {
            zzzv.zzc.logp(Level.WARNING, "io.grpc.Metadata$Key", "validateName", "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
        }
        int i = 0;
        while (i < lowerCase.length()) {
            char cCharAt = lowerCase.charAt(i);
            if (!z || cCharAt != ':') {
                Preconditions.checkArgument(zza.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, (Object) lowerCase);
            } else if (i == 0) {
                i = 0;
            } else {
                cCharAt = ':';
                Preconditions.checkArgument(zza.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, (Object) lowerCase);
            }
            i++;
        }
        this.zzc = lowerCase;
        this.zzd = lowerCase.getBytes(Charsets.US_ASCII);
    }

    public static zzzq zzc(String str, zzzo zzzoVar) {
        return new zzzn(str, false, zzzoVar, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzc.equals(((zzzq) obj).zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        return AbstractC0622a.m1170p(this.zzc, "'}", new StringBuilder("Key{name='"));
    }

    public abstract Object zza(byte[] bArr);

    public abstract byte[] zzb(Object obj);

    @VisibleForTesting
    public final byte[] zzd() {
        return this.zzd;
    }
}
