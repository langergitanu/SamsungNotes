package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor;

import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AODPinExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AbsExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AnimatorScreenOffExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.NoneExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.NotifyExecutionExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.ScreenOffExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/ExecutorFactory;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "createExecutor", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AbsExecutor;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ExecutorFactory {

    @NotNull
    public static final ExecutorFactory INSTANCE = new ExecutorFactory();

    @NotNull
    private static final String TAG = SOLogger.createTag("ExecutorFactory");

    private ExecutorFactory() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    public final AbsExecutor createExecutor(@Nullable Intent intent) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "createExecutor : " + intent);
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -1136162217:
                    if (action.equals(Constants.IntentAction.EXPOSE_SCREEN_OFF)) {
                        return new AnimatorScreenOffExecutor();
                    }
                    break;
                case 79221:
                    if (action.equals(Constants.IntentAction.PIN)) {
                        return new AODPinExecutor();
                    }
                    break;
                case 69009148:
                    if (action.equals(Constants.IntentAction.SCREEN_OFF)) {
                        return new ScreenOffExecutor();
                    }
                    break;
                case 2142361986:
                    if (action.equals(Constants.IntentAction.NOTIFY_EXECUTION)) {
                        NotifyExecutionExecutor notifyExecutionExecutor = new NotifyExecutionExecutor();
                        notifyExecutionExecutor.setFactory(new NotifyExecutionExecutor.IFactory() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.model.executor.ExecutorFactory.createExecutor.1
                            @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.model.executor.executors.NotifyExecutionExecutor.IFactory
                            public AbsExecutor createExecutor(Intent intent2) {
                                return ExecutorFactory.INSTANCE.createExecutor(intent2);
                            }
                        });
                        return notifyExecutionExecutor;
                    }
                    break;
            }
        }
        return new NoneExecutor();
    }
}
