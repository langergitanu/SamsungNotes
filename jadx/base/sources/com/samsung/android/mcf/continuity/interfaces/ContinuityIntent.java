package com.samsung.android.mcf.continuity.interfaces;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.common.Utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ContinuityIntent {

    @VisibleForTesting
    public static final String KEY_MESSAGE_BYTE_ARRAY = "KEY_MESSAGE_BYTE_ARRAY";

    @VisibleForTesting
    public static final String KEY_NEARBY_MY_DEVICE_BUNDLE = "KEY_NEARBY_MY_DEVICE_BUNDLE";

    @VisibleForTesting
    public static final String KEY_NETWORK_POLICY_BUNDLE = "KEY_NETWORK_POLICY_BUNDLE";

    @NonNull
    public static Intent createIntent(@NonNull String str, @NonNull String str2, @NonNull ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper, @Nullable ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper, @Nullable byte[] bArr) {
        Intent intentCreateIntent = Utils.createIntent();
        intentCreateIntent.setAction(str2);
        intentCreateIntent.setPackage(str);
        intentCreateIntent.putExtra(KEY_NEARBY_MY_DEVICE_BUNDLE, ContinuityBundleFactory.continuityNearbyMyDeviceWrapperToBundle(continuityNearbyMyDeviceWrapper));
        if (continuityNetworkPolicyWrapper != null) {
            intentCreateIntent.putExtra("KEY_NETWORK_POLICY_BUNDLE", ContinuityBundleFactory.continuityNetworkPolicyWrapperToBundle(continuityNetworkPolicyWrapper));
        }
        if (bArr != null) {
            intentCreateIntent.putExtra(KEY_MESSAGE_BYTE_ARRAY, bArr);
        }
        return intentCreateIntent;
    }

    @Nullable
    public static ContinuityNearbyMyDevice getContinuityNearbyMyDevice(@NonNull Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra(KEY_NEARBY_MY_DEVICE_BUNDLE);
        if (bundleExtra == null) {
            return null;
        }
        return ContinuityBundleFactory.continuityNearbyMyDeviceWrapperFromBundle(bundleExtra);
    }

    @Nullable
    public static ContinuityNetworkPolicy getContinuityNetworkPolicy(@NonNull Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("KEY_NETWORK_POLICY_BUNDLE");
        if (bundleExtra == null) {
            return null;
        }
        return ContinuityBundleFactory.continuityNetworkPolicyWrapperFromBundle(bundleExtra);
    }

    @Nullable
    public static byte[] getMessage(@NonNull Intent intent) {
        return intent.getByteArrayExtra(KEY_MESSAGE_BYTE_ARRAY);
    }
}
