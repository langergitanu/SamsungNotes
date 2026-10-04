package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.util.SparseIntArray;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncNotificationTypeStrings {
    private static final SparseIntArray mResIdMapTipCardTitle = new SparseIntArray();
    private static final SparseIntArray mResIdMapTipCardBody = new SparseIntArray();
    private static SyncNotificationTypeStrings mInstance = null;

    private SyncNotificationTypeStrings() {
        SparseIntArray sparseIntArray = mResIdMapTipCardTitle;
        sparseIntArray.put(14, C8003R.string.sync_notification_cloud_server_storage_exceeds_title);
        sparseIntArray.put(5, C8003R.string.sync_notification_not_enough_cloud_storage_title);
        sparseIntArray.put(12, C8003R.string.sync_notification_not_enough_cloud_storage_in_settings_title);
        sparseIntArray.put(8, C8003R.string.sync_notification_not_enough_cloud_storage_in_settings_title);
        sparseIntArray.put(10, C8003R.string.sync_notification_can_not_sync_notes_title);
        if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
            SparseIntArray sparseIntArray2 = mResIdMapTipCardBody;
            sparseIntArray2.put(14, C8003R.string.sync_notification_cloud_server_storage_exceeds_body_jp);
            sparseIntArray2.put(5, C8003R.string.sync_notification_not_enough_cloud_storage_body_pre_jp);
            sparseIntArray2.put(12, C8003R.string.sync_notification_not_enough_cloud_storage_in_settings_body_jp);
            sparseIntArray2.put(10, C8003R.string.sync_notification_can_not_sync_notes_body_jp);
        } else if (CommonUtils.hasSaSetting(BaseUtils.getApplicationContext())) {
            SparseIntArray sparseIntArray3 = mResIdMapTipCardBody;
            sparseIntArray3.put(14, C8003R.string.sync_notification_cloud_server_storage_exceeds_body_na);
            sparseIntArray3.put(5, C8003R.string.sync_notification_not_enough_cloud_storage_body_pre_na);
            sparseIntArray3.put(10, C8003R.string.sync_notification_can_not_sync_notes_body);
        } else {
            SparseIntArray sparseIntArray4 = mResIdMapTipCardBody;
            sparseIntArray4.put(14, C8003R.string.sync_notification_cloud_server_storage_exceeds_body);
            sparseIntArray4.put(5, C8003R.string.sync_notification_not_enough_cloud_storage_body_pre);
            sparseIntArray4.put(12, C8003R.string.sync_notification_not_enough_cloud_storage_in_settings_body);
            sparseIntArray4.put(10, C8003R.string.sync_notification_can_not_sync_notes_body);
        }
        mResIdMapTipCardBody.put(8, C8003R.string.sync_notification_fail_to_sync_not_enough_device_storage_body);
    }

    public static synchronized SyncNotificationTypeStrings getInstance() {
        SyncNotificationTypeStrings syncNotificationTypeStrings;
        syncNotificationTypeStrings = mInstance;
        if (syncNotificationTypeStrings == null) {
            syncNotificationTypeStrings = new SyncNotificationTypeStrings();
            mInstance = syncNotificationTypeStrings;
        }
        return syncNotificationTypeStrings;
    }

    public static int getResIdTipCardBody(int i) {
        return mResIdMapTipCardBody.get(i);
    }

    public static int getResIdTipCardTitle(int i) {
        return mResIdMapTipCardTitle.get(i);
    }
}
