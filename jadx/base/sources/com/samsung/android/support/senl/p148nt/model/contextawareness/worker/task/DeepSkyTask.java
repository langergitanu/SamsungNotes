package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessBroadcastReceiver;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class DeepSkyTask implements Runnable {
    protected final ContextAwarenessParam mParam;

    public DeepSkyTask(@NonNull ContextAwarenessParam contextAwarenessParam) {
        this.mParam = contextAwarenessParam;
    }

    public PendingIntent createPendingIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ContextAwarenessBroadcastReceiver.class));
        intent.setAction(Constants.BroadcastAction.ACTION_DRAW_SUGGESTION);
        intent.putExtra(Constants.IntentExtraName.SUBSCRIBE_ID, this.mParam.getSubscribeId());
        intent.addFlags(268435456);
        return PendingIntent.getBroadcast(context, this.mParam.getSubscribeId(), intent, 167772160);
    }
}
