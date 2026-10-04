package com.samsung.android.support.senl.p148nt.app.inapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.ContinuityConstant;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/receiver/ContinuityServiceReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContinuityServiceReceiver extends BroadcastReceiver {
    private static final int SCREEN_ON_TIMEOUT = 1000;

    @NotNull
    public static final String TAG = "ContinuityServiceReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (context == null) {
            InAppLogger.m8596e(TAG, "onReceive# context is null!");
            return;
        }
        if (intent == null) {
            InAppLogger.m8596e(TAG, "onReceive# intent is null!");
            return;
        }
        String action = intent.getAction();
        InAppLogger.m8595d(TAG, "onReceive# action : " + action);
        if (!Intrinsics.areEqual(ContinuityConstant.INTENT_ACTION_NOTIFICATION, action)) {
            InAppLogger.m8596e(TAG, "onReceive# action is not notification");
            return;
        }
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        boolean zIsInteractive = companion.getInstance(context).isInteractive();
        InAppLogger.m8595d(TAG, "onReceive# screenOn : " + zIsInteractive);
        intent.setClassName("com.samsung.android.app.notes", "com.samsung.android.support.senl.nt.app.inapp.InAppCollaborationTriggerActivity");
        intent.setFlags(403177472);
        context.startActivity(intent);
        if (zIsInteractive) {
            return;
        }
        companion.getInstance(context).acquireWakeLock(TAG, 1000L);
        companion.getInstance(context).releaseWakeLock();
    }
}
