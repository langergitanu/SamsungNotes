package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.util.IBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidBroadcaster implements IBroadcaster {

    @NonNull
    private final Context mContext;

    public AndroidBroadcaster(@NonNull Context context) {
        if (context == null) {
            throw new NullPointerException("mContext is marked non-null but is null");
        }
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.java.util.IBroadcaster
    public void sendBroadcast(@NonNull String str, @Nullable PropertyBag propertyBag) {
        if (str == null) {
            throw new NullPointerException("broadcastId is marked non-null but is null");
        }
        Intent intent = new Intent();
        intent.setAction(str);
        if (propertyBag != null) {
            for (String str2 : propertyBag.keySet()) {
                intent.putExtra(str2, (Parcelable[]) propertyBag.get(str2));
            }
        }
        this.mContext.sendBroadcast(intent);
    }
}
