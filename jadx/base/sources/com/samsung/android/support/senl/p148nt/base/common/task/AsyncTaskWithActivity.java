package com.samsung.android.support.senl.p148nt.base.common.task;

import android.app.Activity;
import android.os.AsyncTask;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.nt.base.common.task.AsyncTaskManager.TaskResult;
import com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0003*\u00020\u00042\u0016\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0005B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0014J#\u0010\u0014\u001a\u0004\u0018\u00018\u00022\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016\"\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00018\u0002H\u0014¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00018\u0002H\u0014¢\u0006\u0002\u0010\u001aJ!\u0010\u0018\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00018\u0002H\u0014¢\u0006\u0002\u0010\u001cJ!\u0010\u001b\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00018\u0002H\u0014¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskWithActivity;", "Params", "Progress", "Result", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", "Landroid/os/AsyncTask;", "mAsyncTaskManager", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager;", "mActivity", "Landroid/app/Activity;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager;Landroid/app/Activity;)V", "value", "", "activityHashCode", "getActivityHashCode", "()I", "onPreExecute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "doInBackground", ActionHandler.PARAMS, "", "([Ljava/lang/Object;)Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", "onPostExecute", "result", "(Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;)V", "onCancelled", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;)V", "onActivityDestroyed", "onActivityCreated", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AsyncTaskWithActivity<Params, Progress, Result extends AsyncTaskManager.TaskResult> extends AsyncTask<Params, Progress, Result> {
    private int activityHashCode;

    @Nullable
    private Activity mActivity;

    @NotNull
    private final AsyncTaskManager mAsyncTaskManager;

    public AsyncTaskWithActivity(@NotNull AsyncTaskManager mAsyncTaskManager, @Nullable Activity activity) {
        Intrinsics.checkNotNullParameter(mAsyncTaskManager, "mAsyncTaskManager");
        this.mAsyncTaskManager = mAsyncTaskManager;
        this.mActivity = activity;
        this.activityHashCode = activity != null ? activity.hashCode() : 0;
    }

    @Override // android.os.AsyncTask
    @Nullable
    public Result doInBackground(@NotNull Params... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return null;
    }

    public final int getActivityHashCode() {
        return this.activityHashCode;
    }

    public void onActivityCreated(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mActivity = activity;
        this.activityHashCode = activity.hashCode();
    }

    public final void onActivityDestroyed() {
        this.mActivity = null;
    }

    public void onCancelled(@Nullable Activity activity, @Nullable Result result) {
    }

    public void onPostExecute(@Nullable Activity activity, @Nullable Result result) {
    }

    public void onPreExecute(@Nullable Activity activity) {
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mAsyncTaskManager.addTask(this);
        onPreExecute(this.mActivity);
    }

    @Override // android.os.AsyncTask
    public void onCancelled(@Nullable Result result) {
        super.onCancelled(result);
        if (result != null) {
            this.mAsyncTaskManager.removeTask(this, result);
        }
        onCancelled(this.mActivity, result);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@Nullable Result result) {
        super.onPostExecute(result);
        if (result != null) {
            this.mAsyncTaskManager.removeTask(this, result);
        }
        onPostExecute(this.mActivity, result);
    }
}
