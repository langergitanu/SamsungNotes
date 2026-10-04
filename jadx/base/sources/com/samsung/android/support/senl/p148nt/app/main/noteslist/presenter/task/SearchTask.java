package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task;

import android.app.Activity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u000f\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/SearchTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Ljava/lang/Runnable;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "taskResult", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/SearchTask$Result;", "getTag", "", "getResult", "execute", "", "taskParams", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchTask extends WorkerTask<Runnable> {

    @NotNull
    private final Result taskResult;

    @NotNull
    private static final String TAG = "SearchTask";
    private static final ExecutorService SINGLE_THREAD_EXECUTOR = AbstractC4539a.m3201k(TAG);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/SearchTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "tag", "", "getTag", "()Ljava/lang/String;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {
        private final int hashCode;

        public Result(int i) {
            this.hashCode = i;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return SearchTask.TAG;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchTask(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int iHashCode = activity.hashCode();
        ExecutorService SINGLE_THREAD_EXECUTOR2 = SINGLE_THREAD_EXECUTOR;
        Intrinsics.checkNotNullExpressionValue(SINGLE_THREAD_EXECUTOR2, "SINGLE_THREAD_EXECUTOR");
        super(iHashCode, ExecutorsKt.from(SINGLE_THREAD_EXECUTOR2));
        this.taskResult = new Result(activity.hashCode());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Runnable taskParams) {
        if (isCancelled()) {
            return;
        }
        MainLogger.m7254d(TAG, "execute# run");
        if (taskParams != null) {
            taskParams.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult, reason: from getter */
    public Result getTaskResult() {
        return this.taskResult;
    }
}
