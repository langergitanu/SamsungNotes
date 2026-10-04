package com.samsung.android.support.senl.p148nt.app.main.common.task;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$TaskParams;", NotesConstants.KEY_CALLER, "", "<init>", "(Ljava/lang/String;)V", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$Result;", "execute", "", "taskParams", "setPostCallback", "postCallback", "Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$Callback;", "getTag", "getResult", "TaskParams", "Result", "Companion", "Callback", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FolderWorkerTask extends WorkerTask<TaskParams> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String TAG = "FolderWorkerTask";

    @NotNull
    private final Result result;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$Callback;", "", "onPostExecute", "", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$Result;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        void onPostExecute(@NotNull Result result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return FolderWorkerTask.TAG;
        }

        public final void setTAG(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FolderWorkerTask.TAG = str;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "mSuccess", "", "tag", "", "getTag", "()Ljava/lang/String;", "success", "getSuccess", "()Z", "setSuccess", "", "boolean", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {
        private final int hashCode;
        private boolean mSuccess;

        public Result(int i) {
            this.hashCode = i;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        /* JADX INFO: renamed from: getSuccess, reason: from getter */
        public final boolean getMSuccess() {
            return this.mSuccess;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return FolderWorkerTask.INSTANCE.getTAG();
        }

        public final void setSuccess(boolean z) {
            this.mSuccess = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderWorkerTask$TaskParams;", "", "runnable", "Ljava/lang/Runnable;", "<init>", "(Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class TaskParams {

        @NotNull
        private final Runnable runnable;

        public TaskParams(@NotNull Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.runnable = runnable;
        }

        public static /* synthetic */ TaskParams copy$default(TaskParams taskParams, Runnable runnable, int i, Object obj) {
            if ((i & 1) != 0) {
                runnable = taskParams.runnable;
            }
            return taskParams.copy(runnable);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Runnable getRunnable() {
            return this.runnable;
        }

        @NotNull
        public final TaskParams copy(@NotNull Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            return new TaskParams(runnable);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TaskParams) && Intrinsics.areEqual(this.runnable, ((TaskParams) other).runnable);
        }

        @NotNull
        public final Runnable getRunnable() {
            return this.runnable;
        }

        public int hashCode() {
            return this.runnable.hashCode();
        }

        @NotNull
        public String toString() {
            return "TaskParams(runnable=" + this.runnable + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderWorkerTask(@NotNull String caller) {
        super(0, null, 2, null);
        Intrinsics.checkNotNullParameter(caller, "caller");
        this.result = new Result(getHashCode());
        TAG = AbstractC0541b.m772n("FolderWorkerTask$", caller);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(TaskParams taskParams) {
        Runnable runnable;
        if (taskParams == null || (runnable = taskParams.getRunnable()) == null) {
            return;
        }
        runnable.run();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    public final void setPostCallback(@Nullable final Callback postCallback) {
        setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.common.task.FolderWorkerTask.setPostCallback.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(WorkerTask.Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Callback callback = postCallback;
                if (callback != null) {
                    callback.onPostExecute((Result) result);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(WorkerTask<?> task) {
                Intrinsics.checkNotNullParameter(task, "task");
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable TaskParams taskParams) {
        FolderManager.getInstance().executeOperation(new RunnableC7599e(taskParams, 20));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult, reason: from getter */
    public Result getTaskResult() {
        return this.result;
    }
}
