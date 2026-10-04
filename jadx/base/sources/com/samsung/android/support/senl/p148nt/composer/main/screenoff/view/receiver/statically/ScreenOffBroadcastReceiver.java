package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.receiver.statically;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.RunningChecker;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.ExecutorFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/statically/ScreenOffBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "isAllowedReceiveCase", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffBroadcastReceiver extends BroadcastReceiver {

    @NotNull
    private static final String TAG = SOLogger.createTag("ScreenOffBroadcastReceiver");

    private final boolean isAllowedReceiveCase(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedReceiveCase intent or action is null");
            return false;
        }
        UserHandleCompat.Companion companion = UserHandleCompat.INSTANCE;
        if (!companion.getInstance().isUserOwner()) {
            AbstractC8014b.m7206h("isAllowedReceiveCase isUserOwner is false, ", companion.getInstance().getUserId(0), SOLogger.INSTANCE, TAG);
            return false;
        }
        RunningChecker runningChecker = RunningChecker.INSTANCE;
        if (!runningChecker.isScreenOffActivityRunning() && !runningChecker.isScreenOffServiceRunning(context)) {
            return true;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedReceiveCase ScreenOff is running");
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (isAllowedReceiveCase(context, intent)) {
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            sOLogger.SOLoggerD(str, "onReceive, execute ScreenOffExecutor");
            intent.setAction(Constants.IntentAction.SCREEN_OFF);
            intent.putExtra(Constants.BooleanExtraKey.PRE_INITIALIZED_COM, true);
            intent.putExtra(Constants.StringExtraKey.EXECUTE_TYPE, "service");
            ExecutorFactory.INSTANCE.createExecutor(intent).execute(context, intent);
            sOLogger.SOLoggerD(str, "onReceive end");
        }
    }
}
