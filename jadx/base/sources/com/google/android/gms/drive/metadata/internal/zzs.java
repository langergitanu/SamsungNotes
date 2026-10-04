package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes5.dex */
public final class zzs extends com.google.android.gms.drive.metadata.zzb<String> {
    public zzs(String str, int i) {
        super(str, Collections.singleton(str), Collections.EMPTY_SET, GmsVersion.VERSION_JARLSBERG);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    public final /* synthetic */ void zza(Bundle bundle, Object obj) {
        bundle.putStringArrayList(getName(), new ArrayList<>((Collection) obj));
    }

    @Override // com.google.android.gms.drive.metadata.zza
    @Nullable
    public final /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }

    @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
    @Nullable
    /* JADX INFO: renamed from: zzd */
    public final Collection<String> zzc(DataHolder dataHolder, int i, int i2) {
        try {
            String string = dataHolder.getString(getName(), i, i2);
            if (string == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(string);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                arrayList.add(jSONArray.getString(i4));
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (JSONException e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }
}
