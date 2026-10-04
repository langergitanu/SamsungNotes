package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.receiver.dynamically;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/SystemKeyReceiver;", "", "<init>", "()V", "mSystemKeyReceiver", "Landroid/content/BroadcastReceiver;", "mSystemKeyReceiverListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/ISystemKeyReceiver;", "registerReceivers", "", "context", "Landroid/content/Context;", "systemKeyReceiverListener", "registerSystemKeyReceiver", "unregisterReceivers", "isAllowedReceiveCase", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemKeyReceiver {

    @NotNull
    private static final String TAG = SOLogger.createTag("SystemKeyReceiver");

    @Nullable
    private BroadcastReceiver mSystemKeyReceiver;

    @Nullable
    private ISystemKeyReceiver mSystemKeyReceiverListener;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAllowedReceiveCase(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            return true;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedReceiveCase# intent or action is null");
        return false;
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private final void registerSystemKeyReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.receiver.dynamically.SystemKeyReceiver.registerSystemKeyReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (!SystemKeyReceiver.this.isAllowedReceiveCase(intent) || SystemKeyReceiver.this.mSystemKeyReceiverListener == null) {
                    return;
                }
                SOLogger.INSTANCE.SOLoggerD(SystemKeyReceiver.TAG, "SystemKeyReceiver# onReceive intent " + intent);
                ISystemKeyReceiver iSystemKeyReceiver = SystemKeyReceiver.this.mSystemKeyReceiverListener;
                if (iSystemKeyReceiver != null) {
                    iSystemKeyReceiver.onSystemKeyReceived(intent);
                }
            }
        };
        this.mSystemKeyReceiver = broadcastReceiver;
        if (Build.VERSION.SDK_INT >= 34) {
            context.registerReceiver(broadcastReceiver, intentFilter, 4);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final void registerReceivers(@NotNull Context context, @Nullable ISystemKeyReceiver systemKeyReceiverListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSystemKeyReceiverListener = systemKeyReceiverListener;
        registerSystemKeyReceiver(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void unregisterReceivers(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            try {
                context.unregisterReceiver(this.mSystemKeyReceiver);
            } catch (Exception unused) {
                SOLogger.INSTANCE.SOLoggerD(TAG, "unregisterReceivers# occur exception");
            }
        } finally {
            this.mSystemKeyReceiver = null;
            this.mSystemKeyReceiverListener = null;
        }
    }
}
