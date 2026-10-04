package com.samsung.android.sdk.smp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.DebugDataManager;
import com.samsung.android.sdk.smp.display.DisplayResultHandler;
import com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl;
import com.samsung.android.sdk.smp.marketing.UserActionLauncher;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpReceiver extends BroadcastReceiver {
    private static final String TAG = "SmpReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (context == null) {
                SmpLog.m6494e(TAG, "context is null");
                return;
            }
            if (intent == null) {
                SmpLog.m6494e(TAG, "intent is null");
                return;
            }
            SmpLog.m6498i(TAG, "onReceive");
            if (Constants.ACTION_TASK_ALARM.equals(intent.getAction())) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    STask sTaskFromBundle = STask.fromBundle(extras);
                    if (sTaskFromBundle instanceof SMarketingTask) {
                        DebugDataManager.addFeedback(context, sTaskFromBundle.getData(), ((SMarketingTask) sTaskFromBundle).getMid(), false);
                    }
                    STaskDispatcher.dispatchOnService(context, sTaskFromBundle);
                    return;
                }
                return;
            }
            if (Constants.ACTION_MARKETING_CLICK.equals(intent.getAction())) {
                UserActionLauncher.onClick(context, intent);
                return;
            }
            if (!Constants.ACTION_MARKETING_BUTTON_1_CLICK.equals(intent.getAction()) && !Constants.ACTION_MARKETING_BUTTON_2_CLICK.equals(intent.getAction()) && !Constants.ACTION_MARKETING_BUTTON_3_CLICK.equals(intent.getAction())) {
                if (Constants.ACTION_MARKETING_CLEAR.equals(intent.getAction())) {
                    UserActionLauncher.onClear(context, intent);
                    return;
                } else if (Constants.ACTION_HANDLE_POPUP_DISPLAY_RESULT.equals(intent.getAction())) {
                    DisplayResultHandler.handlePopupDisplayResult(context, intent.getExtras());
                    return;
                } else {
                    if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                        SmpInterfaceImpl.bootCompleted(context);
                        return;
                    }
                    return;
                }
            }
            UserActionLauncher.onClickNotificationButton(context, intent);
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "Exception SmpReceiver->onReceive " + e.getErrorMessage());
        }
    }
}
