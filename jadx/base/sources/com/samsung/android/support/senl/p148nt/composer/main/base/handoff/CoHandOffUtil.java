package com.samsung.android.support.senl.p148nt.composer.main.base.handoff;

import android.app.Activity;
import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoHandOffUtil {
    private static final String TAG = Logger.createTag("CoHandOffUtil");

    public static void checkAvailableToUpdateStateFromHandoff(final Activity activity) {
        if (!SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, false)) {
            Logger.m11003i(TAG, "showDialogDisableSyncTurnOn#");
            HandoffUtils.getInstance().showDialogDisableSyncTurnOn(new WeakReference<>(activity), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.handoff.CoHandOffUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m11003i(CoHandOffUtil.TAG, "checkAvailableToUpdateStateFromHandoff# pending release ");
                    CoHandOffUtil.checkAvailableToUpdateStateFromHandoff(activity);
                }
            }, null);
            return;
        }
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (!companion.isDataCallNotLimitedForApp()) {
            Logger.m11003i(TAG, "showConnectToNetwork#");
            HandoffUtils.getInstance().showConnectToNetwork();
        } else if (companion.isWiFiSyncOnlyAndNotWiFiConnected(activity)) {
            Logger.m11003i(TAG, "showWiFiSyncOnlyAndNotWiFiConnected#");
            HandoffUtils.getInstance().showWiFiSyncOnlyAndNotWiFiConnected(new WeakReference<>(activity));
        }
    }

    public static Intent getIntent(Activity activity, String str, String str2) {
        if (ComposerAccessHandler.getComposerActivityClass() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(Constants.ACTION_HANDOFF);
        intent.setClass(activity, ComposerAccessHandler.getComposerActivityClass());
        intent.putExtra("sdoc_uuid", str);
        intent.putExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING, str2);
        return intent;
    }
}
