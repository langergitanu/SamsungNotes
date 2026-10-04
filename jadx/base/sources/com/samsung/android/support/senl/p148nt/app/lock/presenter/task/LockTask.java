package com.samsung.android.support.senl.p148nt.app.lock.presenter.task;

import android.app.Activity;
import android.content.Context;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskWithActivity;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import com.samsung.android.support.senl.p148nt.data.resolver.tag.OldHashtagResolver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p055M2.CallableC0178a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 &2$\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001:\u0002%&B)\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002JC\u0010\u001f\u001a\u0004\u0018\u00010\u000622\u0010 \u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040!\"\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0014¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/task/LockTask;", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskWithActivity;", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/task/LockTask$DocumentInfo;", "Lkotlin/collections/ArrayList;", "Ljava/lang/Void;", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "mIsLock", "", "mShowWidgetNoteWarning", "mPostRunnable", "Ljava/lang/Runnable;", "<init>", "(Landroid/app/Activity;ZZLjava/lang/Runnable;)V", "weakReference", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "mLockTaskSuccess", "getMLockTaskSuccess", "()Z", "setMLockTaskSuccess", "(Z)V", "taskResult", "onPreExecute", "", "toCallableSetLockNotes", "Ljava/util/concurrent/Callable;", DocInfo.KEY_DOC_INFO, "toCallableSetUnLockNotes", "doInBackground", ActionHandler.PARAMS, "", "([Ljava/util/ArrayList;)Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", "onPostExecute", "result", "DocumentInfo", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockTask extends AsyncTaskWithActivity<ArrayList<DocumentInfo>, Void, AsyncTaskManager.TaskResult> {

    @JvmField
    @NotNull
    public static final Executor SINGLE_THREAD_EXECUTOR;

    @NotNull
    public static final String TAG = "LockTask";
    private final boolean mIsLock;
    private boolean mLockTaskSuccess;

    @Nullable
    private final Runnable mPostRunnable;
    private final boolean mShowWidgetNoteWarning;

    @NotNull
    private final AsyncTaskManager.TaskResult taskResult;

    @NotNull
    private final WeakReference<Context> weakReference;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/task/LockTask$DocumentInfo;", "", "uuid", "", "isSdoc", "", "<init>", "(Ljava/lang/String;Z)V", "getUuid", "()Ljava/lang/String;", "()Z", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DocumentInfo {
        private final boolean isSdoc;

        @NotNull
        private final String uuid;

        public DocumentInfo(@NotNull String uuid, boolean z) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.uuid = uuid;
            this.isSdoc = z;
        }

        @NotNull
        public final String getUuid() {
            return this.uuid;
        }

        /* JADX INFO: renamed from: isSdoc, reason: from getter */
        public final boolean getIsSdoc() {
            return this.isSdoc;
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        SINGLE_THREAD_EXECUTOR = executorServiceNewSingleThreadExecutor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockTask(@NotNull Activity activity, boolean z, boolean z2, @Nullable Runnable runnable) {
        super(ApplicationManager.INSTANCE.getInstance().getAsyncTaskManager(), activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mIsLock = z;
        this.mShowWidgetNoteWarning = z2;
        this.mPostRunnable = runnable;
        this.weakReference = new WeakReference<>(activity);
        this.taskResult = new AsyncTaskManager.TaskResult() { // from class: com.samsung.android.support.senl.nt.app.lock.presenter.task.LockTask$taskResult$1
            @Override // com.samsung.android.support.senl.nt.base.common.task.AsyncTaskManager.TaskResult
            public String getType() {
                return LockTask.TAG;
            }
        };
    }

    private final Callable<Void> toCallableSetLockNotes(DocumentInfo docInfo) {
        return new CallableC0178a(this, docInfo, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void toCallableSetLockNotes$lambda$0(LockTask lockTask, DocumentInfo documentInfo) {
        try {
            lockTask.mLockTaskSuccess = DocumentLockResolver.lock(lockTask.weakReference.get(), documentInfo.getUuid(), false);
            LockLogger.m7358i(TAG, "toCallableSetLockNotes# success - isSdoc : " + documentInfo.getIsSdoc());
            return null;
        } catch (Exception e) {
            LockLogger.INSTANCE.m7359e(TAG, "toCallableSetLockNotes# failed : " + e.getMessage(), e);
            return null;
        }
    }

    private final Callable<Void> toCallableSetUnLockNotes(DocumentInfo docInfo) {
        return new CallableC0178a(this, docInfo, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void toCallableSetUnLockNotes$lambda$1(LockTask lockTask, DocumentInfo documentInfo) {
        try {
            lockTask.mLockTaskSuccess = DocumentLockResolver.unlock(lockTask.weakReference.get(), documentInfo.getUuid());
            LockLogger.m7358i(TAG, "toCallableSetUnLockNotes# success - isSdoc : " + documentInfo.getIsSdoc());
            return null;
        } catch (Exception e) {
            LockLogger.INSTANCE.m7359e(TAG, "toCallableSetUnLockNotes# failed : " + e.getMessage(), e);
            return null;
        }
    }

    public final boolean getMLockTaskSuccess() {
        return this.mLockTaskSuccess;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskWithActivity
    public void onPostExecute(@Nullable Activity activity, @Nullable AsyncTaskManager.TaskResult result) {
        super.onPostExecute(activity, result);
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Runnable runnable = this.mPostRunnable;
        if (runnable != null) {
            runnable.run();
        }
        if (this.mShowWidgetNoteWarning) {
            DialogUtils.showWidgetNoteWarning(activity);
        } else {
            if (this.mLockTaskSuccess) {
                return;
            }
            ToastHandler.show(activity, C8003R.string.base_string_failed_to_load_image, 0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskWithActivity
    public void onPreExecute(@Nullable Activity activity) {
        super.onPreExecute(activity);
        ApplicationManager.INSTANCE.getInstance().getAsyncTaskManager().onStart(this);
    }

    public final void setMLockTaskSuccess(boolean z) {
        this.mLockTaskSuccess = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskWithActivity, android.os.AsyncTask
    @Nullable
    public AsyncTaskManager.TaskResult doInBackground(@NotNull ArrayList<DocumentInfo>... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList<DocumentInfo> arrayList = params[0];
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5, new SenlThreadFactory(TAG));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator<DocumentInfo> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            DocumentInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            DocumentInfo documentInfo = next;
            if (documentInfo.getIsSdoc()) {
                arrayList3.add(documentInfo.getUuid());
            } else {
                arrayList4.add(documentInfo.getUuid());
            }
            arrayList2.add(this.mIsLock ? toCallableSetLockNotes(documentInfo) : toCallableSetUnLockNotes(documentInfo));
        }
        try {
            executorServiceNewFixedThreadPool.invokeAll(arrayList2);
            executorServiceNewFixedThreadPool.shutdown();
            executorServiceNewFixedThreadPool.awaitTermination(1L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            LockLogger.m7357e(TAG, "InterruptedException# " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        Context context = this.weakReference.get();
        if (context != null) {
            NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().notifyTagBoardByUuid(arrayList4);
            OldHashtagResolver.notifyTagBoardByUuid(context, arrayList3);
        }
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        return this.taskResult;
    }
}
