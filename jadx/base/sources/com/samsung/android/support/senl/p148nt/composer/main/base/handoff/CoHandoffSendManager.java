package com.samsung.android.support.senl.p148nt.composer.main.base.handoff;

import android.app.Activity;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffContentObserver;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoHandoffSendManager {
    private static final String TAG = Logger.createTag("CoHandoffSendManager");
    private static CoHandoffSendManager mInstance;
    private String mLastSendUuid;
    private boolean mManualSave = false;
    private SendSuccessContentObserver mSendSuccessContentObserver;
    private String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SendSuccessContentObserver extends HandoffContentObserver {
        public /* synthetic */ SendSuccessContentObserver(CoHandoffSendManager coHandoffSendManager, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffContentObserver
        public void onDataSent() {
            super.onDataSent();
            Logger.m11003i(CoHandoffSendManager.TAG, "SendSuccessContentObserver, onDataSent");
            ComposerManager.getInstance().requestViewMode(CoHandoffSendManager.this.mLastSendUuid);
            final Activity composerActivity = ComposerManager.getInstance().getComposerActivity(CoHandoffSendManager.this.mLastSendUuid);
            if (composerActivity != null) {
                new Handler(composerActivity.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.handoff.CoHandoffSendManager.SendSuccessContentObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CoHandOffUtil.checkAvailableToUpdateStateFromHandoff(composerActivity);
                    }
                });
            }
        }

        private SendSuccessContentObserver() {
        }
    }

    public static CoHandoffSendManager getInstance() {
        if (mInstance == null) {
            mInstance = new CoHandoffSendManager();
        }
        return mInstance;
    }

    private void registerHandoffContentObserverOnlyOneTime() {
        if (this.mSendSuccessContentObserver == null) {
            Logger.m10999d(TAG, "registerHandoffContentObserverOnlyOneTime#");
            this.mSendSuccessContentObserver = new SendSuccessContentObserver(this, 0);
            HandoffUtils.getInstance().registerContentObserverForSendingSuccess(this.mSendSuccessContentObserver);
        }
    }

    public void clear(String str) {
        String str2 = this.mUuid;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        this.mUuid = null;
        this.mManualSave = false;
        HandoffUtils.getInstance().disableHandoff();
        Logger.m11003i(TAG, "clear#");
    }

    public void disable(String str) {
        String str2 = this.mUuid;
        if (str2 != null && !str2.equals(str)) {
            Logger.m11003i(TAG, "disable# uuid is not matched");
        } else {
            HandoffUtils.getInstance().disableHandoff();
            Logger.m11003i(TAG, "disable#");
        }
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void send(String str, CoHandOffData coHandOffData) {
        String str2 = this.mUuid;
        if (str2 == null || !str2.equals(str)) {
            Logger.m11003i(TAG, "send# uuid is not matched");
            return;
        }
        if (this.mManualSave) {
            Logger.m11003i(TAG, "send# fail: manual save mode");
            return;
        }
        this.mLastSendUuid = str;
        registerHandoffContentObserverOnlyOneTime();
        JSONObject jsonObject = coHandOffData.getJsonObject();
        try {
            jsonObject.put("sdoc_uuid", this.mUuid);
            jsonObject.put(HandoffConstant.KEY_ACTIVITY_TYPE, "Composer");
        } catch (JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
        HandoffUtils.getInstance().enableHandoff(jsonObject);
        Logger.m11003i(TAG, "send#");
    }

    public CoHandoffSendManager setUuid(String str, boolean z) {
        String str2 = this.mUuid;
        if (str2 != null && !str2.equals(str)) {
            HandoffUtils.getInstance().disableHandoff();
            Logger.m11003i(TAG, "setUuid# disable handoff");
        } else if (this.mManualSave != z && z) {
            Logger.m11003i(TAG, "setUuid# disable handoff in manual save mode");
            HandoffUtils.getInstance().disableHandoff();
        }
        this.mManualSave = z;
        this.mUuid = str;
        return this;
    }

    public void unregisterHandoffContentObserver(Fragment fragment) {
        if (this.mSendSuccessContentObserver == null || ComposerManager.getInstance().isRunningComposer(fragment)) {
            return;
        }
        Logger.m10999d(TAG, "unregisterHandoffContentObserver#");
        HandoffUtils.getInstance().unregisterContentObserver(this.mSendSuccessContentObserver);
        this.mSendSuccessContentObserver = null;
    }
}
