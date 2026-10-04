package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzag {
    private final String zza = ",\n  ";

    private zzag(String str) {
    }

    public static zzag zza(String str) {
        return new zzag(",\n  ");
    }

    public static final CharSequence zzd(@CheckForNull Object obj) {
        obj.getClass();
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final Appendable zzb(Appendable appendable, Iterator it) throws IOException {
        if (it.hasNext()) {
            appendable.append(zzd(it.next()));
            while (it.hasNext()) {
                appendable.append(this.zza);
                appendable.append(zzd(it.next()));
            }
        }
        return appendable;
    }
}
