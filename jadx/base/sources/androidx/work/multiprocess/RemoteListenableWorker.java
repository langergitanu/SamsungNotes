package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.parcelable.ParcelConverters;
import androidx.work.multiprocess.parcelable.ParcelableInterruptRequest;
import androidx.work.multiprocess.parcelable.ParcelableRemoteWorkRequest;
import androidx.work.multiprocess.parcelable.ParcelableResult;
import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.identity.common.java.WarningType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract class RemoteListenableWorker extends ListenableWorker {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";
    public static final String ARGUMENT_PACKAGE_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";
    static final String TAG = Logger.tagWithPrefix("RemoteListenableWorker");
    final ListenableWorkerImplClient mClient;

    @Nullable
    private ComponentName mComponentName;

    @Nullable
    String mWorkerClassName;
    final WorkerParameters mWorkerParameters;

    public RemoteListenableWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
        this.mClient = new ListenableWorkerImplClient(context, getBackgroundExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStopped$0(int i, IListenableWorkerImpl iListenableWorkerImpl, IWorkManagerImplCallback iWorkManagerImplCallback) {
        iListenableWorkerImpl.interrupt(ParcelConverters.marshall(new ParcelableInterruptRequest(this.mWorkerParameters.getId().toString(), i)), iWorkManagerImplCallback);
    }

    @Override // androidx.work.ListenableWorker
    @SuppressLint({WarningType.NewApi})
    @CallSuper
    public void onStopped() {
        super.onStopped();
        int stopReason = getStopReason();
        ComponentName componentName = this.mComponentName;
        if (componentName != null) {
            this.mClient.execute(componentName, new C4148a(this, stopReason, 0));
        }
    }

    @NonNull
    public abstract ListenableFuture<ListenableWorker.Result> startRemoteWork();

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        SettableFuture settableFutureCreate = SettableFuture.create();
        Data inputData = getInputData();
        final String string = this.mWorkerParameters.getId().toString();
        String string2 = inputData.getString(ARGUMENT_PACKAGE_NAME);
        String string3 = inputData.getString(ARGUMENT_CLASS_NAME);
        if (TextUtils.isEmpty(string2)) {
            Logger.get().error(TAG, "Need to specify a package name for the Remote Service.");
            settableFutureCreate.setException(new IllegalArgumentException("Need to specify a package name for the Remote Service."));
            return settableFutureCreate;
        }
        if (TextUtils.isEmpty(string3)) {
            Logger.get().error(TAG, "Need to specify a class name for the Remote Service.");
            settableFutureCreate.setException(new IllegalArgumentException("Need to specify a class name for the Remote Service."));
            return settableFutureCreate;
        }
        this.mComponentName = new ComponentName(string2, string3);
        final WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
        return RemoteClientUtils.map(this.mClient.execute(this.mComponentName, new RemoteDispatcher<IListenableWorkerImpl>() { // from class: androidx.work.multiprocess.RemoteListenableWorker.1
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IListenableWorkerImpl iListenableWorkerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                WorkSpec workSpec = workManagerImpl.getWorkDatabase().workSpecDao().getWorkSpec(string);
                RemoteListenableWorker.this.mWorkerClassName = workSpec.workerClassName;
                iListenableWorkerImpl.startWork(ParcelConverters.marshall(new ParcelableRemoteWorkRequest(workSpec.workerClassName, RemoteListenableWorker.this.mWorkerParameters)), iWorkManagerImplCallback);
            }
        }), new Function<byte[], ListenableWorker.Result>() { // from class: androidx.work.multiprocess.RemoteListenableWorker.2
            @Override // androidx.arch.core.util.Function
            /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public ListenableWorker.Result mo22196apply(byte[] bArr) {
                ParcelableResult parcelableResult = (ParcelableResult) ParcelConverters.unmarshall(bArr, ParcelableResult.CREATOR);
                Logger.get().debug(RemoteListenableWorker.TAG, "Cleaning up");
                RemoteListenableWorker.this.mClient.unbindService();
                return parcelableResult.getResult();
            }
        }, getBackgroundExecutor());
    }
}
