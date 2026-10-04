package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.NotifyExecutionModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.NotifyExecutionFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/NotifyExecutionExecutor;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AbsExecutor;", "<init>", "()V", "mFactory", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/NotifyExecutionExecutor$IFactory;", "execute", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "setFactory", "factory", "IFactory", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NotifyExecutionExecutor extends AbsExecutor {
    private static final int FLAG_RECEIVER_INCLUDE_BACKGROUND = 16777216;

    @Nullable
    private IFactory mFactory;

    @NotNull
    private static final String TAG = SOLogger.createTag("NotifyExecutionExecutor");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/NotifyExecutionExecutor$IFactory;", "", "createExecutor", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AbsExecutor;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IFactory {
        @NotNull
        AbsExecutor createExecutor(@Nullable Intent intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AbsExecutor
    @SuppressLint({"WrongConstant"})
    public void execute(@Nullable Context context, @Nullable Intent intent) {
        AbsExecutor absExecutorCreateExecutor;
        NotifyExecutionModel notifyExecutionModel = NotifyExecutionModel.INSTANCE;
        String notifiedExecution = notifyExecutionModel.getNotifiedExecution();
        String stringExtra = intent != null ? intent.getStringExtra("state") : null;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("execute notifiedState/currentState : ", notifiedExecution, "/", stringExtra));
        if (stringExtra == null || Intrinsics.areEqual(stringExtra, notifiedExecution)) {
            return;
        }
        intent.setAction(Constants.IntentAction.BLACK_MEMO);
        intent.addFlags(16777216);
        sOLogger.SOLoggerD(str, "execute intent : " + intent);
        sOLogger.SOLoggerF(str, "execute state : " + intent.getStringExtra("state"));
        if (context != null) {
            context.sendBroadcast(intent);
        }
        notifyExecutionModel.setNotifiedExecution(stringExtra);
        if (NotifyExecutionFeature.INSTANCE.isCheckingServiceRunning()) {
            sOLogger.SOLoggerD(str, "execute, ScreenOffExecutor for ControlService");
            Intent intent2 = new Intent();
            intent2.setAction(Constants.IntentAction.SCREEN_OFF);
            intent2.putExtra(Constants.BooleanExtraKey.CONTROL_SERVICE, true);
            intent2.putExtra("state", stringExtra);
            intent2.putExtra(Constants.StringExtraKey.EXECUTE_TYPE, "service");
            IFactory iFactory = this.mFactory;
            if (iFactory == null || (absExecutorCreateExecutor = iFactory.createExecutor(intent2)) == null) {
                return;
            }
            absExecutorCreateExecutor.execute(context, intent2);
        }
    }

    public final void setFactory(@NotNull IFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mFactory = factory;
    }
}
