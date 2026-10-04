package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.receiver.dynamically;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.RunningChecker;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/DynamicalBroadCastReceiver;", "", "<init>", "()V", "mScreenOnReceiver", "Landroid/content/BroadcastReceiver;", "mBroadcastListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/DynamicalBroadCastReceiver$IBroadcastListener;", "registerReceivers", "", "context", "Landroid/content/Context;", "broadcastListener", "unregisterReceivers", "registerScreenOnReceiver", "isAllowedReceiveCase", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "IBroadcastListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicalBroadCastReceiver {

    @NotNull
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";

    @NotNull
    private static final String TAG = SOLogger.createTag("DynamicalBroadCastReceiver");

    @Nullable
    private IBroadcastListener mBroadcastListener;

    @Nullable
    private BroadcastReceiver mScreenOnReceiver;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/DynamicalBroadCastReceiver$IBroadcastListener;", "", "onReceivedBroadcast", "", "action", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IBroadcastListener {
        void onReceivedBroadcast(@Nullable String action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAllowedReceiveCase(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedReceiveCase intent or action is null");
            return false;
        }
        if (!RunningChecker.INSTANCE.isScreenOffActivityRunning()) {
            return true;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedReceiveCase ScreenOffActivity is running");
        return false;
    }

    private final void registerScreenOnReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_SCREEN_ON);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.receiver.dynamically.DynamicalBroadCastReceiver.registerScreenOnReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (!DynamicalBroadCastReceiver.this.isAllowedReceiveCase(intent) || DynamicalBroadCastReceiver.this.mBroadcastListener == null) {
                    return;
                }
                SOLogger.INSTANCE.SOLoggerD(DynamicalBroadCastReceiver.TAG, "ScreenOnReceiver onReceive intent : " + intent);
                IBroadcastListener iBroadcastListener = DynamicalBroadCastReceiver.this.mBroadcastListener;
                if (iBroadcastListener != null) {
                    iBroadcastListener.onReceivedBroadcast(intent.getAction());
                }
            }
        };
        this.mScreenOnReceiver = broadcastReceiver;
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    public final void registerReceivers(@NotNull Context context, @Nullable IBroadcastListener broadcastListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBroadcastListener = broadcastListener;
        registerScreenOnReceiver(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void unregisterReceivers(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            try {
                context.unregisterReceiver(this.mScreenOnReceiver);
            } catch (Exception unused) {
                SOLogger.INSTANCE.SOLoggerD(TAG, "unregisterReceivers occur exception");
            }
        } finally {
            this.mScreenOnReceiver = null;
            this.mBroadcastListener = null;
        }
    }
}
