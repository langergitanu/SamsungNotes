package com.google.android.gms.drive.metadata.internal;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.UserMetadata;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes5.dex */
public final class zzu extends zzm<UserMetadata> {
    public zzu(String str, int i) {
        super(str, Arrays.asList(zza(str, "permissionId"), zza(str, "displayName"), zza(str, IDToken.PICTURE), zza(str, "isAuthenticatedUser"), zza(str, HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS)), Collections.EMPTY_LIST, GmsVersion.VERSION_MANCHEGO);
    }

    private static String zza(String str, String str2) {
        StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(AbstractC4539a.m3194d(1, str), str2));
        sb.append(str);
        sb.append(Extension.DOT);
        sb.append(str2);
        return sb.toString();
    }

    private final String zzh(String str) {
        return zza(getName(), str);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    public final boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.hasColumn(zzh("permissionId")) && !dataHolder.hasNull(zzh("permissionId"), i, i2);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    public final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        String string = dataHolder.getString(zzh("permissionId"), i, i2);
        if (string != null) {
            return new UserMetadata(string, dataHolder.getString(zzh("displayName"), i, i2), dataHolder.getString(zzh(IDToken.PICTURE), i, i2), dataHolder.getBoolean(zzh("isAuthenticatedUser"), i, i2), dataHolder.getString(zzh(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS), i, i2));
        }
        return null;
    }
}
