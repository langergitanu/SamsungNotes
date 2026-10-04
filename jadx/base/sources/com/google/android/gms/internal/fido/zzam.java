package com.google.android.gms.internal.fido;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzam {
    private final String zza;
    private final zzak zzb;
    private zzak zzc;

    public /* synthetic */ zzam(String str, zzal zzalVar) {
        zzak zzakVar = new zzak(null);
        this.zzb = zzakVar;
        this.zzc = zzakVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzak zzakVar = this.zzb.zzc;
        String str = "";
        while (zzakVar != null) {
            Object obj = zzakVar.zzb;
            sb.append(str);
            String str2 = zzakVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzakVar = zzakVar.zzc;
            str = SQLKeyword.COMMA;
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzam zza(String str, int i) {
        String strValueOf = String.valueOf(i);
        zzai zzaiVar = new zzai(null);
        this.zzc.zzc = zzaiVar;
        this.zzc = zzaiVar;
        zzaiVar.zzb = strValueOf;
        zzaiVar.zza = "errorCode";
        return this;
    }

    public final zzam zzb(String str, @CheckForNull Object obj) {
        zzak zzakVar = new zzak(null);
        this.zzc.zzc = zzakVar;
        this.zzc = zzakVar;
        zzakVar.zzb = obj;
        zzakVar.zza = str;
        return this;
    }
}
