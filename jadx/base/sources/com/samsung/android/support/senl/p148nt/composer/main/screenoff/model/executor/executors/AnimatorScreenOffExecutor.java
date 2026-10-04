package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AnimatorScreenOffExecutor;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AbsExecutor;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AnimatorScreenOffExecutor extends AbsExecutor {

    @NotNull
    private static final String ACTIVITY_CLASS_NAME = "com.samsung.android.support.senl.nt.composer.main.screenoff.ScreenOffAnimatorActivity";

    @NotNull
    private static final String TAG = SOLogger.createTag("ExposeScreenOffExecutor");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AbsExecutor
    public void execute(@Nullable Context context, @Nullable Intent intent) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "execute");
        if (context == null || intent == null) {
            return;
        }
        intent.setClassName(context.getApplicationContext(), ACTIVITY_CLASS_NAME);
        intent.addFlags(402653184);
        intent.addFlags(65536);
        context.startActivity(intent);
    }
}
