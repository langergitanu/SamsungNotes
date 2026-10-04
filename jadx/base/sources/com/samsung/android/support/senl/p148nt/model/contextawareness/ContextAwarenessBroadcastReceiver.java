package com.samsung.android.support.senl.p148nt.model.contextawareness;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.IContextAwarenessParam;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = CALogger.createTag("ContextAwarenessBroadcastReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG)).execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.contextawareness.ContextAwarenessBroadcastReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra(Constants.IntentExtraName.SUBSCRIBE_ID, -1);
                DataLogger.m12302d(ContextAwarenessBroadcastReceiver.TAG, "onReceive action/subscribeId " + action + "/" + intExtra);
                if (Constants.BroadcastAction.ACTION_DRAW_SUGGESTION.equals(action)) {
                    ContextAwarenessController.getInstance().postContextAwarenessTask(new ContextAwarenessParam.ContextAwarenessParamBuilder().setType(IContextAwarenessParam.Type.DRAW_SUGGESTION).setIntent(intent).build());
                } else if (Constants.BroadcastAction.ACTION_EXECUTE_ACTION.equals(action)) {
                    ContextAwarenessController.getInstance().postContextAwarenessTask(new ContextAwarenessParam.ContextAwarenessParamBuilder().setType(IContextAwarenessParam.Type.ATTACH_CONTENT).setIntent(intent).build());
                } else {
                    DataLogger.m12302d(ContextAwarenessBroadcastReceiver.TAG, "onReceive invalid action");
                }
            }
        });
    }
}
