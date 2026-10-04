package com.samsung.android.mcf.continuity.impl;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.mcf.continuity.api.ContinuityIntentHelper;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.interfaces.ContinuityIntent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityIntentHelperImpl implements ContinuityIntentHelper {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SingletonHolder {
        private static final ContinuityIntentHelperImpl INSTANCE = new ContinuityIntentHelperImpl();

        private SingletonHolder() {
        }
    }

    @NonNull
    public static ContinuityIntentHelperImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityIntentHelper
    @Nullable
    public ContinuityNearbyMyDevice getContinuityNearbyMyDevice(@NonNull Intent intent) {
        return ContinuityIntent.getContinuityNearbyMyDevice(intent);
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityIntentHelper
    @Nullable
    public ContinuityNetworkPolicy getContinuityNetworkPolicy(@NonNull Intent intent) {
        return ContinuityIntent.getContinuityNetworkPolicy(intent);
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityIntentHelper
    @Nullable
    public byte[] getMessage(@NonNull Intent intent) {
        return ContinuityIntent.getMessage(intent);
    }
}
