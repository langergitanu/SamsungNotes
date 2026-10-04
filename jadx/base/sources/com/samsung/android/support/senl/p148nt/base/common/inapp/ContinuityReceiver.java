package com.samsung.android.support.senl.p148nt.base.common.inapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onContinuityServiceReconnected", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ContinuityReceiver extends BroadcastReceiver {

    @NotNull
    public static final String ACTION_MCF_SERVICE_STARTED = "com.samsung.android.mcfds.SERVICE_STARTED";

    @NotNull
    public static final String PERMISSION_MCF_SERVICE = "com.samsung.android.mcfds.permission.START_SERVICE";

    @NotNull
    private static final String TAG = "ContinuityReceiver";

    public abstract void onContinuityServiceReconnected(@Nullable Context context);

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (context == null) {
            InAppLogger.m8595d(TAG, "onReceive# context is null");
            return;
        }
        String action = intent.getAction();
        InAppLogger.m8595d(TAG, "onReceive# action : " + action);
        if (Intrinsics.areEqual(action, ACTION_MCF_SERVICE_STARTED)) {
            onContinuityServiceReconnected(context);
        }
    }
}
