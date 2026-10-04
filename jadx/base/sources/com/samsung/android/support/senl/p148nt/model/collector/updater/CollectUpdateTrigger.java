package com.samsung.android.support.senl.p148nt.model.collector.updater;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.DocumentThreadPoolManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/collector/updater/CollectUpdateTrigger;", "", "<init>", "()V", "onTriggerCollect", "", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CollectUpdateTrigger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String TAG = "CollectUpdateTrigger";

    @Nullable
    private static CollectUpdateTrigger sInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/collector/updater/CollectUpdateTrigger$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/nt/model/collector/updater/CollectUpdateTrigger;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/model/collector/updater/CollectUpdateTrigger;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized CollectUpdateTrigger getInstance() {
            CollectUpdateTrigger collectUpdateTrigger;
            try {
                if (CollectUpdateTrigger.sInstance == null) {
                    CollectUpdateTrigger.sInstance = new CollectUpdateTrigger();
                }
                collectUpdateTrigger = CollectUpdateTrigger.sInstance;
                Intrinsics.checkNotNull(collectUpdateTrigger);
            } catch (Throwable th) {
                throw th;
            }
            return collectUpdateTrigger;
        }

        private Companion() {
        }
    }

    public final void onTriggerCollect() {
        boolean zIsRunningComposer = ComposerManager.INSTANCE.getInstance().isRunningComposer();
        boolean zIsRunning = TaskState.INSTANCE.getInstance().isRunning("CONVERT");
        boolean zIsIdle = DocumentThreadPoolManager.getInstance().isIdle();
        AbstractC11014a.m12340y(AbstractC2821a.m2230u("onTriggerCollect, runningComposer/runningConvert/documentIdle: ", " / ", " / ", zIsRunningComposer, zIsRunning), zIsIdle, TAG);
        if (zIsRunningComposer || zIsRunning || !zIsIdle) {
            return;
        }
        CollectController.getInstance().collectReadyState(false);
    }
}
