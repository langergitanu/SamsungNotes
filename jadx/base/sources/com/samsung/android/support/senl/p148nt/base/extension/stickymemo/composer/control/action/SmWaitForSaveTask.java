package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmWaitForSaveTask;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmWaitForSaveTask$Inputs;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmWaitForSaveTask$Results;", "runnable", "Ljava/lang/Runnable;", "<init>", "(Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "run", "", "clear", "Inputs", "Results", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmWaitForSaveTask extends SmTask<Inputs, Results> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmWaitForSaveTask");

    @NotNull
    private final Runnable runnable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmWaitForSaveTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmWaitForSaveTask.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmWaitForSaveTask$Inputs;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Inputs;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Inputs implements SmTask.Inputs {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmWaitForSaveTask$Results;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Results;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Results implements SmTask.Results {

        @Nullable
        private final Exception exception;

        /* JADX WARN: Multi-variable type inference failed */
        public Results() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        public final Exception getException() {
            return this.exception;
        }

        public Results(@Nullable Exception exc) {
            this.exception = exc;
        }

        public /* synthetic */ Results(Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : exc);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmWaitForSaveTask(@NotNull Runnable runnable) {
        super(TAG);
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.runnable = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void run$lambda$0(SmWaitForSaveTask smWaitForSaveTask) {
        try {
            smWaitForSaveTask.runnable.run();
            smWaitForSaveTask.notifyCallback(true, new Results(null, 1, 0 == true ? 1 : 0));
        } catch (Exception e) {
            smWaitForSaveTask.notifyCallback(false, new Results(e));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.ITask
    public void clear() {
    }

    @NotNull
    public final Runnable getRunnable() {
        return this.runnable;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask
    public void run() {
        setExecutorService(Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG)));
        ExecutorService executorService = getExecutorService();
        if (executorService != null) {
            executorService.execute(new RunnableC8669a(this, 19));
        }
    }
}
