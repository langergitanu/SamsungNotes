package com.samsung.android.mcf.continuity.interfaces;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.mcf.continuity.common.Utils;
import com.samsung.android.mcf.continuity.interfaces.ContinuityDeviceState;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNearbyMyDeviceWrapper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ContinuityBundleFactory {

    @VisibleForTesting
    public static final String KEY_BT_MAC = "KEY_BT_MAC";

    @VisibleForTesting
    public static final String KEY_BT_STATE = "KEY_BT_STATE";

    @VisibleForTesting
    public static final String KEY_CALL_STATE = "KEY_CALL_STATE";

    @VisibleForTesting
    public static final String KEY_CMC_STATE = "KEY_CMC_STATE";

    @VisibleForTesting
    public static final String KEY_CUR_CONTINUITY_DEVICE_STATE = "KEY_CUR_CONTINUITY_DEVICE_STATE";

    @VisibleForTesting
    public static final String KEY_DEVICE_TYPE = "KEY_DEVICE_TYPE";

    @VisibleForTesting
    public static final String KEY_DISPLAY_NAME = "KEY_DISPLAY_NAME";

    @VisibleForTesting
    public static final String KEY_IP = "KEY_IP";

    @VisibleForTesting
    public static final String KEY_MODEL_NAME = "KEY_MODEL_NAME";

    @VisibleForTesting
    public static final String KEY_NETWORK_ROLE = "KEY_NETWORK_ROLE";

    @VisibleForTesting
    public static final String KEY_NETWORK_TOPOLOGY = "KEY_NETWORK_TOPOLOGY";

    @VisibleForTesting
    public static final String KEY_NETWORK_TYPE = "KEY_NETWORK_TYPE";

    @VisibleForTesting
    public static final String KEY_PORT = "KEY_PORT";

    @VisibleForTesting
    public static final String KEY_PREV_CONTINUITY_DEVICE_STATE = "KEY_PREV_CONTINUITY_DEVICE_STATE";

    @VisibleForTesting
    public static final String KEY_SCREEN_STATE = "KEY_SCREEN_STATE";

    @VisibleForTesting
    public static final String KEY_WIFI_STATE = "KEY_WIFI_STATE";

    @NonNull
    @VisibleForTesting
    public static ContinuityDeviceState continuityDeviceStateFromBundle(@NonNull Bundle bundle) {
        return new ContinuityDeviceState.Builder().setScreenState(bundle.getInt(KEY_SCREEN_STATE, 400)).setCallState(bundle.getInt(KEY_CALL_STATE, 500)).setBtState(bundle.getInt(KEY_BT_STATE, 600)).setWifiState(bundle.getInt(KEY_WIFI_STATE, 700)).setCmcState(bundle.getInt(KEY_CMC_STATE, 800)).build();
    }

    @NonNull
    @VisibleForTesting
    public static Bundle continuityDeviceStateToBundle(@NonNull ContinuityDeviceState continuityDeviceState) {
        Bundle bundleCreateBundle = Utils.createBundle();
        bundleCreateBundle.putInt(KEY_SCREEN_STATE, continuityDeviceState.getScreenState());
        bundleCreateBundle.putInt(KEY_CALL_STATE, continuityDeviceState.getCallState());
        bundleCreateBundle.putInt(KEY_BT_STATE, continuityDeviceState.getBtState());
        bundleCreateBundle.putInt(KEY_WIFI_STATE, continuityDeviceState.getWifiState());
        bundleCreateBundle.putInt(KEY_CMC_STATE, continuityDeviceState.getCmcState());
        return bundleCreateBundle;
    }

    @NonNull
    public static ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapperFromBundle(@NonNull Bundle bundle) {
        ContinuityNearbyMyDeviceWrapper.Builder port = new ContinuityNearbyMyDeviceWrapper.Builder().setBtMac(bundle.getString("KEY_BT_MAC")).setDisplayName(bundle.getString(KEY_DISPLAY_NAME)).setDeviceType(bundle.getInt(KEY_DEVICE_TYPE, 0)).setModelName(bundle.getString(KEY_MODEL_NAME)).setIp(bundle.getString(KEY_IP)).setPort(bundle.getInt("KEY_PORT", -1));
        Parcelable parcelable = bundle.getParcelable(KEY_PREV_CONTINUITY_DEVICE_STATE);
        if (parcelable instanceof Bundle) {
            port.setPrevContinuityDeviceState(continuityDeviceStateFromBundle((Bundle) parcelable));
        }
        Parcelable parcelable2 = bundle.getParcelable(KEY_CUR_CONTINUITY_DEVICE_STATE);
        if (parcelable2 instanceof Bundle) {
            port.setCurContinuityDeviceState(continuityDeviceStateFromBundle((Bundle) parcelable2));
        }
        return port.build();
    }

    @NonNull
    public static Bundle continuityNearbyMyDeviceWrapperToBundle(@NonNull ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper) {
        Bundle bundleCreateBundle = Utils.createBundle();
        bundleCreateBundle.putString("KEY_BT_MAC", continuityNearbyMyDeviceWrapper.getBtMac());
        bundleCreateBundle.putString(KEY_DISPLAY_NAME, continuityNearbyMyDeviceWrapper.getDisplayName());
        bundleCreateBundle.putInt(KEY_DEVICE_TYPE, continuityNearbyMyDeviceWrapper.getDeviceType());
        bundleCreateBundle.putString(KEY_MODEL_NAME, continuityNearbyMyDeviceWrapper.getModelName());
        bundleCreateBundle.putString(KEY_IP, continuityNearbyMyDeviceWrapper.getIp());
        bundleCreateBundle.putInt("KEY_PORT", continuityNearbyMyDeviceWrapper.getPort());
        ContinuityDeviceState prevContinuityDeviceState = continuityNearbyMyDeviceWrapper.getPrevContinuityDeviceState();
        if (prevContinuityDeviceState != null) {
            bundleCreateBundle.putParcelable(KEY_PREV_CONTINUITY_DEVICE_STATE, continuityDeviceStateToBundle(prevContinuityDeviceState));
        }
        ContinuityDeviceState curContinuityDeviceState = continuityNearbyMyDeviceWrapper.getCurContinuityDeviceState();
        if (curContinuityDeviceState != null) {
            bundleCreateBundle.putParcelable(KEY_CUR_CONTINUITY_DEVICE_STATE, continuityDeviceStateToBundle(curContinuityDeviceState));
        }
        return bundleCreateBundle;
    }

    @NonNull
    public static ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapperFromBundle(@NonNull Bundle bundle) {
        return ContinuityNetworkPolicyWrapper.createInstance(bundle.getInt(KEY_NETWORK_TYPE), bundle.getInt(KEY_NETWORK_TOPOLOGY), bundle.getInt(KEY_NETWORK_ROLE));
    }

    @NonNull
    public static Bundle continuityNetworkPolicyWrapperToBundle(@NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        Bundle bundleCreateBundle = Utils.createBundle();
        bundleCreateBundle.putInt(KEY_NETWORK_TYPE, continuityNetworkPolicyWrapper.getType());
        bundleCreateBundle.putInt(KEY_NETWORK_TOPOLOGY, continuityNetworkPolicyWrapper.getTopology());
        bundleCreateBundle.putInt(KEY_NETWORK_ROLE, continuityNetworkPolicyWrapper.getRole());
        return bundleCreateBundle;
    }
}
