package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/NotifyExecutionModel;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "value", "", "isPreInitialized", "()Z", "notifiedExecution", "getNotifiedExecution", "()Ljava/lang/String;", "init", "", "initNotifiedExecution", "setNotifiedExecution", "release", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NotifyExecutionModel {

    @NotNull
    public static final NotifyExecutionModel INSTANCE = new NotifyExecutionModel();

    @NotNull
    private static final String TAG = SOLogger.createTag("NotifyExecutionModel");
    private static boolean isPreInitialized;

    @Nullable
    private static String notifiedExecution;

    private NotifyExecutionModel() {
    }

    private final void initNotifiedExecution() {
        notifiedExecution = "none";
        AbstractC8014b.m7208j("initNotifiedExecution# ", notifiedExecution, SOLogger.INSTANCE, TAG);
    }

    @Nullable
    public final String getNotifiedExecution() {
        return notifiedExecution;
    }

    public final void init() {
        isPreInitialized = true;
        initNotifiedExecution();
    }

    public final boolean isPreInitialized() {
        return isPreInitialized;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        notifiedExecution = "none";
        isPreInitialized = false;
    }

    public final void setNotifiedExecution(@NotNull String notifiedExecution2) {
        Intrinsics.checkNotNullParameter(notifiedExecution2, "notifiedExecution");
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        AbstractC8014b.m7208j("setNotifiedExecution# ", notifiedExecution2, sOLogger, str);
        if (!isPreInitialized) {
            sOLogger.SOLoggerD(str, "setNotifiedExecution# preInitialized is set");
            isPreInitialized = true;
        }
        notifiedExecution = notifiedExecution2;
    }
}
