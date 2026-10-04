package com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog;

import android.util.SparseIntArray;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NetworkConnectionFailedType {
    public static final int INCORRECT_TYPE = -1;
    private static final String TAG = "NT$NetworkConnectionFailedType";
    private static final SparseIntArray mResIdMapTitle = new SparseIntArray();
    private static final SparseIntArray mResIdMapBody = new SparseIntArray();
    private static final SparseIntArray mResIdMapToast = new SparseIntArray();
    private static NetworkConnectionFailedType mInstance = null;

    private NetworkConnectionFailedType() {
        SystemPropertiesCompat.Companion companion = SystemPropertiesCompat.INSTANCE;
        if (companion.getInstance().isChinaModel()) {
            mResIdMapTitle.put(100, C8003R.string.sync_network_dialog_wifi_not_available_title_chn);
        } else {
            mResIdMapTitle.put(100, C8003R.string.sync_network_dialog_wifi_not_available_title);
        }
        SparseIntArray sparseIntArray = mResIdMapTitle;
        sparseIntArray.put(101, C8003R.string.sync_network_dialog_flight_mode_title);
        sparseIntArray.put(102, C8003R.string.sync_network_dialog_mobile_data_turned_off_title);
        sparseIntArray.put(103, C8003R.string.sync_network_dialog_data_roaming_is_off_title);
        sparseIntArray.put(104, C8003R.string.sync_network_dialog_data_reached_to_limit_title);
        sparseIntArray.put(2, C8003R.string.sync_network_dialog_roam_data_warning_title);
        sparseIntArray.put(3, C8003R.string.sync_network_dialog_mobile_data_warning_title);
        if (companion.getInstance().isChinaModel()) {
            SparseIntArray sparseIntArray2 = mResIdMapBody;
            sparseIntArray2.put(100, C8003R.string.sync_network_dialog_wifi_not_available_body_chn);
            sparseIntArray2.put(101, C8003R.string.sync_network_dialog_flight_mode_body_chn);
            sparseIntArray2.put(102, C8003R.string.sync_network_dialog_mobile_data_turned_off_body_chn);
            sparseIntArray2.put(103, C8003R.string.sync_network_dialog_data_roaming_is_off_body_chn);
            sparseIntArray2.put(3, C8003R.string.sync_network_dialog_mobile_data_warning_body_chn);
            mResIdMapToast.put(99, C8003R.string.sync_network_toast_wifi_connection_failed_chn);
        } else {
            SparseIntArray sparseIntArray3 = mResIdMapBody;
            sparseIntArray3.put(100, C8003R.string.sync_network_dialog_wifi_not_available_body);
            sparseIntArray3.put(101, DeviceUtils.isTabletModel() ? C8003R.string.sync_network_dialog_flight_mode_body_tablet : C8003R.string.sync_network_dialog_flight_mode_body);
            sparseIntArray3.put(102, C8003R.string.sync_network_dialog_mobile_data_turned_off_body);
            sparseIntArray3.put(103, C8003R.string.sync_network_dialog_data_roaming_is_off_body);
            sparseIntArray3.put(3, DeviceUtils.isTabletModel() ? C8003R.string.sync_network_dialog_mobile_data_warning_body_tablet : C8003R.string.sync_network_dialog_mobile_data_warning_body);
            mResIdMapToast.put(99, C8003R.string.sync_network_toast_wifi_connection_failed);
        }
        SparseIntArray sparseIntArray4 = mResIdMapBody;
        sparseIntArray4.put(104, C8003R.string.sync_network_dialog_data_reached_to_limit_body);
        sparseIntArray4.put(2, C8003R.string.sync_network_dialog_roam_data_warning_body);
        SparseIntArray sparseIntArray5 = mResIdMapToast;
        sparseIntArray5.put(101, C8003R.string.sync_network_toast_flight_mode);
        sparseIntArray5.put(102, C8003R.string.sync_network_toast_mobile_data_turned_off);
        sparseIntArray5.put(103, C8003R.string.sync_network_toast_roaming_is_off);
    }

    public static NetworkConnectionFailedType getInstance() {
        NetworkConnectionFailedType networkConnectionFailedType = mInstance;
        if (networkConnectionFailedType != null) {
            return networkConnectionFailedType;
        }
        NetworkConnectionFailedType networkConnectionFailedType2 = new NetworkConnectionFailedType();
        mInstance = networkConnectionFailedType2;
        return networkConnectionFailedType2;
    }

    public static int getResIdBody(int i) {
        return mResIdMapBody.get(i);
    }

    public static int getResIdTitle(int i) {
        return mResIdMapTitle.get(i);
    }

    public static int getResIdToast(int i) {
        return mResIdMapToast.get(i);
    }
}
