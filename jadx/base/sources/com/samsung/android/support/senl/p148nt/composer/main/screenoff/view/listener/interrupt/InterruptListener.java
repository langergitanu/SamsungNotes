package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.interrupt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/interrupt/InterruptListener;", "", "<init>", "()V", "mInterruptReceiver", "Landroid/content/BroadcastReceiver;", "mInterruptListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/interrupt/IInterruptListener;", "registerListener", "", "context", "Landroid/content/Context;", "interruptListener", "registerInterruptReceiver", "unregisterListener", "isAllowedReceiveCase", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InterruptListener {

    @Nullable
    private IInterruptListener mInterruptListener;

    @Nullable
    private BroadcastReceiver mInterruptReceiver;

    @NotNull
    private static final String TAG = SOLogger.createTag("InterruptListener");

    @NotNull
    private static final String[] ACTION_INTERRUPTS = {"android.app.action.ENTER_KNOX_DESKTOP_MODE"};

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAllowedReceiveCase(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            return true;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedReceiveCase# intent or action is null");
        return false;
    }

    private final void registerInterruptReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        for (String str : ACTION_INTERRUPTS) {
            intentFilter.addAction(str);
        }
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.listener.interrupt.InterruptListener.registerInterruptReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                IInterruptListener iInterruptListener;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (!InterruptListener.this.isAllowedReceiveCase(intent) || InterruptListener.this.mInterruptReceiver == null) {
                    return;
                }
                SOLogger.INSTANCE.SOLoggerD(InterruptListener.TAG, "onReceive# intent action " + intent.getAction());
                String[] strArr = InterruptListener.ACTION_INTERRUPTS;
                if (!CollectionsKt.contains(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)), intent.getAction()) || (iInterruptListener = InterruptListener.this.mInterruptListener) == null) {
                    return;
                }
                iInterruptListener.onInterrupted();
            }
        };
        this.mInterruptReceiver = broadcastReceiver;
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    public final void registerListener(@NotNull Context context, @Nullable IInterruptListener interruptListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mInterruptListener = interruptListener;
        registerInterruptReceiver(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void unregisterListener(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            try {
                context.unregisterReceiver(this.mInterruptReceiver);
            } catch (Exception unused) {
                SOLogger.INSTANCE.SOLoggerD(TAG, "unregisterListener# occur exception");
            }
        } finally {
            this.mInterruptReceiver = null;
            this.mInterruptListener = null;
        }
    }
}
