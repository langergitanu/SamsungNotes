package com.samsung.android.app.notes.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KnoxRestrictionsReceiver extends BroadcastReceiver {
    private static final String TAG = "KnoxRestrictionsReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            MainCoeditLogger.m7251e(TAG, "onReceive context is null");
            return;
        }
        if (intent == null) {
            MainCoeditLogger.m7251e(TAG, "onReceive intent is null");
            return;
        }
        PolicyManager.updateKnoxRestrictions();
        if (!PolicyManager.isEdmPolicyAiEnabled() && AiActionStatus.isAiFeatureEnable()) {
            AiActionStatus.setAiFeatureEnable(false, false);
        }
        if (PolicyManager.isEdmPolicyAiDrawingEnabled() || !AiActionStatus.isDrawingAssistEnabled()) {
            return;
        }
        AiActionStatus.enableDrawingAssist(false);
    }
}
