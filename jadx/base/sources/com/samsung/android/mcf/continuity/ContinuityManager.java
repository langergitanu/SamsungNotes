package com.samsung.android.mcf.continuity;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityIntentHelper;
import com.samsung.android.mcf.continuity.common.VersionUtil;
import com.samsung.android.mcf.continuity.impl.ContinuityAdapterImpl;
import com.samsung.android.mcf.continuity.impl.ContinuityIntentHelperImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityManager {
    @NonNull
    public static ContinuityAdapter getContinuityAdapter(@NonNull Context context) {
        return ContinuityAdapterImpl.getInstance();
    }

    @NonNull
    public static ContinuityIntentHelper getContinuityIntentHelper(@NonNull Context context) {
        return ContinuityIntentHelperImpl.getInstance();
    }

    public static int getSDKVersionCode() {
        return VersionUtil.getSDKVersionCode();
    }

    public static long getServiceVersionCode(@NonNull Context context) {
        return VersionUtil.getServiceVersionCode(context);
    }
}
