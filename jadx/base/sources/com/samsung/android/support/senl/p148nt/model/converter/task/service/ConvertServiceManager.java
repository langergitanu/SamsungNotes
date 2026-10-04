package com.samsung.android.support.senl.p148nt.model.converter.task.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.SDocXConverterWrapper;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.job.ConvertThreadPoolExecutor;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.job.JobRunner;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.job.JobRunnerFuture;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.BaseDocListener;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.CancelListener;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.IServiceRequestor;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.ServiceMsg;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.WConvertQueueItem;
import com.samsung.android.support.senl.p148nt.model.converter.utils.ConvertingUtils;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.data.SaveResult;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenDocumentRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertServiceManager implements IServiceRequestor {
    private static final int SDOCX_CONVERT_SERVICE_JOB_MAX_CAPACITY = 2;
    private static final int SDOCX_CONVERT_SERVICE_JOB_MIN_CAPACITY = 1;
    private static final String TAG = ModelLogger.createConverterTag("ConvertServiceManager");
    private final int SDOCX_CONVERT_SERVICE_JOB_CAPACITY;
    private Context mAppContext;
    private DocumentServiceConnection mConnection;
    private ConvertThreadPoolExecutor mConvertThreadPool;
    private int mPageHeight;
    private int mPageWidth;
    private IDocumentServiceWrapper mService;
    private DocumentSubscriptionId mSubscriptionId;
    private final ConcurrentLinkedQueue<WConvertQueueItem> mItemQueue = new ConcurrentLinkedQueue<>();
    private final List<JobRunnerFuture<?>> mRunningJobs = new ArrayList();
    private final Object mServiceLock = new Object();
    private final Object mConverterLock = new Object();
    private final Object mItemQueueLock = new Object();
    private final Object mRunningJobsLock = new Object();
    private final Object mThreadPoolLock = new Object();
    private int mCountRunningSave = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CloseListener extends BaseDocListener {
        public CloseListener(WConvertQueueItem wConvertQueueItem) {
            super(wConvertQueueItem);
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.BaseDocListener, com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
        public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
            super.completed(notesDocument, str);
            String str2 = ConvertServiceManager.TAG;
            StringBuilder sb = new StringBuilder("close completed : ");
            AbstractC11014a.m12336u(this.mSrcPath, sb, " ");
            sb.append(this.mTakenTime);
            sb.append("ms");
            DataLogger.m12307i(str2, sb.toString());
            this.mListener.onSuccess(3, null);
            ConvertServiceManager.this.produceOpenJob();
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void failed(Throwable th, String str) {
            DataLogger.m12302d(ConvertServiceManager.TAG, "close failed : " + DataLogger.getEncode(this.mSrcPath) + "," + th.getMessage());
            this.mListener.onFailed(3, new ServiceMsg(this.mSrcPath));
            ConvertServiceManager.this.produceOpenJob();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ConvertRunner extends JobRunner {
        private static final String TAG = ModelLogger.createConverterTag("ConvertRunner");

        public ConvertRunner(WConvertQueueItem wConvertQueueItem) {
            super(wConvertQueueItem, 1);
        }

        private void saveTempFile(NotesDocument<ISpenDocument> notesDocument, SaveListener saveListener) {
            SaveResult saveResultSaveSpenDocument = notesDocument.saveSpenDocument();
            if (saveResultSaveSpenDocument.get()) {
                saveListener.completed(notesDocument, notesDocument.getUuid());
            } else {
                saveListener.failed(saveResultSaveSpenDocument.getException("fail to saveTempFile"), notesDocument.getUuid());
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.job.JobRunner
        public void cancel() {
            ISDocXConverter converter = this.mItem.getInfo().getConverter();
            if (converter == null) {
                DataLogger.m12309w(TAG, "cancel - converter is null : " + this.mItem.getInfo().getCallerId());
                return;
            }
            converter.cancel();
            DataLogger.m12309w(TAG, "canceled : " + this.mItem.getInfo().getCallerId());
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.job.JobRunner
        public String getTag() {
            return TAG;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            if (!ConvertingUtils.isAvailableMemoryForSDocXConverting(this.mItem.getInfo().getReqFileSize())) {
                this.mItem.getListener().onFailed(1, new ServiceMsg(this.mItem.getPath(), false));
                ConvertServiceManager.this.produceOpenJob();
                return;
            }
            long id = Thread.currentThread().getId();
            String str = TAG;
            StringBuilder sbM1323p = AbstractC1974b.m1323p(id, "convert start : (", ") ");
            sbM1323p.append(DataLogger.getEncode(this.mItem.getPath()));
            DataLogger.m12302d(str, sbM1323p.toString());
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ConvertServiceManager.this.convert(this.mItem);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            StringBuilder sbM1323p2 = AbstractC1974b.m1323p(id, "convert end : (", ") ");
            sbM1323p2.append(DataLogger.getEncode(this.mItem.getPath()));
            sbM1323p2.append(" ");
            sbM1323p2.append(jElapsedRealtime2 - jElapsedRealtime);
            sbM1323p2.append("ms");
            DataLogger.m12302d(str, sbM1323p2.toString());
            DataLogger.m12302d(str, "request save : " + DataLogger.getEncode(this.mItem.getPath()));
            if (!TextUtils.isEmpty(this.mItem.getInfo().getDstPath())) {
                saveTempFile(this.mItem.getState(), ConvertServiceManager.this.new SaveListener(this.mItem, true));
                return;
            }
            new ConvertedDocumentUpdater(ConvertServiceManager.this.mAppContext, this.mItem.getState(), this.mItem.getInfo()).updateEntity();
            synchronized (ConvertServiceManager.this.mServiceLock) {
                try {
                    if (ConvertServiceManager.this.mService != null) {
                        ConvertServiceManager.this.mService.save(this.mItem.getState(), false, true, ConvertServiceManager.this.new SaveListener(this.mItem, false));
                        StringBuilder sb = new StringBuilder("convert#, count of running save : ");
                        ConvertServiceManager convertServiceManager = ConvertServiceManager.this;
                        int i = convertServiceManager.mCountRunningSave + 1;
                        convertServiceManager.mCountRunningSave = i;
                        sb.append(i);
                        DataLogger.m12302d(str, sb.toString());
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                return;
            }
            ConvertingUtils.reduceConvertingSize(this.mItem.getInfo().getReqFileSize());
            this.mItem.getListener().onFailed(1, new ServiceMsg(this.mItem.getPath()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DocumentServiceConnection implements ServiceConnection {
        public /* synthetic */ DocumentServiceConnection(ConvertServiceManager convertServiceManager, int i) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DataLogger.m12302d(ConvertServiceManager.TAG, "onServiceConnected");
            synchronized (ConvertServiceManager.this.mServiceLock) {
                ConvertServiceManager.this.mService = ((IDocumentServiceBinder) iBinder).subscribe(DocumentSubscriptionId.CONVERT_SERVICE_ID.getUser(), ConvertServiceManager.this.mSubscriptionId);
                ConvertServiceManager convertServiceManager = ConvertServiceManager.this;
                convertServiceManager.mSubscriptionId = convertServiceManager.mService.getUser();
                ConvertServiceManager.this.mService.registerDocumentServiceListener(new IDocumentServiceWrapper.DocumentServiceListener() { // from class: com.samsung.android.support.senl.nt.model.converter.task.service.ConvertServiceManager.DocumentServiceConnection.1
                    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
                    public void onChangedDocumentByUser(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
                        DataLogger.m12302d(ConvertServiceManager.TAG, "onServiceConnected, onChangedDocumentByUser");
                    }

                    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
                    public void onForceClosedDocument() {
                        DataLogger.m12302d(ConvertServiceManager.TAG, "onServiceConnected, onForceClosedDocument");
                    }

                    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
                    public void onOpenedByUser(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str) {
                        DataLogger.m12302d(ConvertServiceManager.TAG, "onServiceConnected, onOpenedByUser");
                    }

                    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
                    public void onReceiveBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent) {
                        DataLogger.m12302d(ConvertServiceManager.TAG, "onReceiveBroadcastMessage, sender : " + documentSubscriptionId + ", intent : " + intent);
                    }

                    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
                    @WorkerThread
                    public void onChangedWorkingState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
                    }
                });
            }
            ConvertServiceManager.this.mPageWidth = Math.min(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
            ConvertServiceManager.this.mPageHeight = (int) (r4.mPageWidth * 1.4142857f);
            ConvertServiceManager.this.execute();
        }

        private DocumentServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OpenListener extends BaseDocListener {
        public OpenListener(WConvertQueueItem wConvertQueueItem) {
            super(wConvertQueueItem);
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.BaseDocListener, com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
        public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
            super.completed(notesDocument, str);
            String str2 = ConvertServiceManager.TAG;
            StringBuilder sb = new StringBuilder("open completed : ");
            AbstractC11014a.m12336u(this.mSrcPath, sb, " ");
            sb.append(this.mTakenTime);
            sb.append("ms");
            DataLogger.m12307i(str2, sb.toString());
            this.mListener.onSuccess(0, null);
            ConvertServiceManager.this.submit(ConvertServiceManager.this.new ConvertRunner(new WConvertQueueItem(this.mSrcPath, this.mListener, this.mInfo, notesDocument)));
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void failed(Throwable th, String str) {
            DataLogger.m12309w(ConvertServiceManager.TAG, "open failed : " + DataLogger.getEncode(this.mSrcPath) + SQLKeyword.COMMA + th.getMessage());
            this.mListener.onFailed(0, new ServiceMsg(this.mSrcPath));
            ConvertServiceManager.this.produceOpenJob();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OpenRunner extends JobRunner {
        private static final String TAG = ModelLogger.createConverterTag("OpenRunner");

        public OpenRunner(@NonNull WConvertQueueItem wConvertQueueItem) {
            super(wConvertQueueItem, 0);
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.job.JobRunner
        public void cancel() {
            this.mItem.getListener().onSuccess(0, new ServiceMsg(this.mItem.getPath()));
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.job.JobRunner
        public String getTag() {
            return TAG;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            DataLogger.m12307i(TAG, "request open : " + DataLogger.getEncode(this.mItem.getPath()));
            synchronized (ConvertServiceManager.this.mServiceLock) {
                try {
                    if (ConvertServiceManager.this.mService != null) {
                        DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepositoryCreateSDocXRepository = ConvertServiceManager.this.createSDocXRepository(this.mItem);
                        ((WordDocumentEntityContainer) documentRepositoryCreateSDocXRepository.getDocumentEntity()).getEntity().setOriginUuid(this.mItem.getInfo().getUuid());
                        ConvertServiceManager.this.mService.open(documentRepositoryCreateSDocXRepository, ConvertServiceManager.this.new OpenListener(this.mItem));
                        z = true;
                    } else {
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                return;
            }
            this.mItem.getListener().onFailed(0, new ServiceMsg(this.mItem.getPath()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SaveListener extends BaseDocListener {
        private final boolean mIsTempDocument;
        private final NotesDocument<ISpenDocument> mState;

        public SaveListener(WConvertQueueItem wConvertQueueItem, boolean z) {
            super(wConvertQueueItem);
            this.mState = wConvertQueueItem.getState();
            this.mIsTempDocument = z;
        }

        private void encryptData(String str) {
            if (this.mInfo.getLockType() == 5) {
                DocumentLockResolver.lock(ConvertServiceManager.this.mAppContext, str);
            }
        }

        private void notifyWidgetMemoConverted(String str) {
            if (this.mInfo.getIsWidgetMemo()) {
                BaseWidgetUtils.INSTANCE.notifyWidgetNoteConverted(ConvertServiceManager.this.mAppContext, this.mInfo.getUuid(), str);
            }
        }

        private void setReadyStateForCollector(@NonNull NotesDocument<ISpenDocument> notesDocument) {
            NotesDataRepositoryFactory.newInstance(ConvertServiceManager.this.mAppContext).createDocumentRetryRepository().deleteByUuid(notesDocument.getUuid());
            CollectResolver.setReadyState(notesDocument.getUuid(), notesDocument.getDocumentRepository().getDocumentEntity().getEntity().getLastModifiedAt(), 1);
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.BaseDocListener, com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
        public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
            super.completed(notesDocument, str);
            DataLogger.m12307i(ConvertServiceManager.TAG, "save completed, src : " + DataLogger.getEncode(this.mSrcPath) + " -> " + DataLogger.getEncode(notesDocument.getPath()) + " / " + this.mTakenTime + "ms");
            if (!this.mIsTempDocument) {
                encryptData(str);
                notifyWidgetMemoConverted(str);
                setReadyStateForCollector(notesDocument);
            }
            ConvertingUtils.reduceConvertingSize(this.mInfo.getReqFileSize());
            this.mListener.onSuccess(1, new ServiceMsg(this.mSrcPath, notesDocument.getPath(), str, notesDocument.isContentEmpty()));
            ConvertServiceManager.this.requestClose(notesDocument, 3, this.mSrcPath, this.mListener);
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void failed(Throwable th, String str) {
            DataLogger.m12309w(ConvertServiceManager.TAG, "save failed : " + DataLogger.getEncode(this.mSrcPath) + SQLKeyword.COMMA + th.getMessage());
            ConvertingUtils.reduceConvertingSize(this.mInfo.getReqFileSize());
            this.mListener.onFailed(1, new ServiceMsg(this.mSrcPath));
            ConvertServiceManager.this.requestClose(this.mState, 3, this.mSrcPath, this.mListener);
        }
    }

    public ConvertServiceManager(Context context) {
        int i = 0;
        this.mAppContext = context.getApplicationContext();
        int i2 = DeviceUtils.getDeviceMemoryLevel() < 1 ? 1 : 2;
        this.SDOCX_CONVERT_SERVICE_JOB_CAPACITY = i2;
        this.mConvertThreadPool = new ConvertThreadPoolExecutor(i2, i2, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.mConnection = new DocumentServiceConnection(this, i);
        this.mAppContext.bindService(new Intent(this.mAppContext, (Class<?>) NotesWordDocumentService.class), this.mConnection, 1);
    }

    private void cancelItemQueue(int i) {
        Iterator<WConvertQueueItem> it = this.mItemQueue.iterator();
        while (it.hasNext()) {
            WConvertQueueItem next = it.next();
            if (next.getInfo().getCallerId() == i) {
                next.getListener().onSuccess(2, new ServiceMsg(next.getPath()));
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void convert(WConvertQueueItem wConvertQueueItem) {
        NotesDocument<ISpenDocument> state = wConvertQueueItem.getState();
        String path = wConvertQueueItem.getPath();
        SpenWordDocument spenWordDocument = (SpenWordDocument) state.getDoc();
        spenWordDocument.setPageDefaultWidth(this.mPageWidth);
        spenWordDocument.setPageDefaultHeight(this.mPageHeight);
        synchronized (this.mConverterLock) {
            try {
                ISDocXConverter converter = wConvertQueueItem.getInfo().getConverter();
                if (converter == null) {
                    converter = new SDocXConverterWrapper(this.mAppContext);
                }
                converter.convert(this.mAppContext, path, spenWordDocument);
                converter.release();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> createSDocXRepository(WConvertQueueItem wConvertQueueItem) {
        int i;
        IConvertInfo info = wConvertQueueItem.getInfo();
        String dstUuid = info.getDstUuid();
        if (TextUtils.isEmpty(dstUuid)) {
            dstUuid = UUIDUtils.newUUID(this.mAppContext);
        }
        String str = dstUuid;
        String dstPath = wConvertQueueItem.getInfo().getDstPath();
        if (TextUtils.isEmpty(dstPath)) {
            dstPath = NotesDocumentFileUtils.createSavePathWithPrefix(this.mAppContext, wConvertQueueItem.getInfo().getDstFilePrefix(), ".sdocx");
            i = 0;
        } else {
            i = 10000;
        }
        return SpenDocumentRepositoryFactory.newInstance(str, null, dstPath, "", "ConvertServiceManager", this.mSubscriptionId).createWordDocRepository().setPageMode(info.isIndividualPage() ? SpenWNote.PageMode.LIST : SpenWNote.PageMode.SINGLE).setPageWidth(this.mPageWidth).setSaveStrategy(296960).setMode(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        synchronized (this.mServiceLock) {
            try {
                if (this.mService == null) {
                    DataLogger.m12309w(TAG, "execute, service is null");
                    return;
                }
                for (int i = 0; i < this.SDOCX_CONVERT_SERVICE_JOB_CAPACITY; i++) {
                    produceOpenJob();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void produceOpenJob() {
        WConvertQueueItem wConvertQueueItemPoll;
        synchronized (this.mThreadPoolLock) {
            try {
                ConvertThreadPoolExecutor convertThreadPoolExecutor = this.mConvertThreadPool;
                if (convertThreadPoolExecutor == null) {
                    return;
                }
                boolean z = convertThreadPoolExecutor.getQueue().size() < this.SDOCX_CONVERT_SERVICE_JOB_CAPACITY;
                if (z) {
                    synchronized (this.mItemQueueLock) {
                        wConvertQueueItemPoll = this.mItemQueue.poll();
                    }
                    if (wConvertQueueItemPoll != null) {
                        submit(new OpenRunner(wConvertQueueItemPoll));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestClose(NotesDocument<ISpenDocument> notesDocument, int i, String str, IServiceRequestor.IServiceListener iServiceListener) {
        boolean z;
        synchronized (this.mServiceLock) {
            try {
                IDocumentServiceWrapper iDocumentServiceWrapper = this.mService;
                if (iDocumentServiceWrapper != null) {
                    if (i == 3) {
                        iDocumentServiceWrapper.close(notesDocument, new CloseListener(new WConvertQueueItem(str, iServiceListener)));
                    } else {
                        iDocumentServiceWrapper.close(notesDocument, new CancelListener(new WConvertQueueItem(str, iServiceListener)));
                    }
                    String str2 = TAG;
                    StringBuilder sb = new StringBuilder("requestClose#, count of running save : ");
                    z = true;
                    int i2 = this.mCountRunningSave - 1;
                    this.mCountRunningSave = i2;
                    sb.append(i2);
                    DataLogger.m12302d(str2, sb.toString());
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            return;
        }
        iServiceListener.onFailed(i, new ServiceMsg(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submit(JobRunner jobRunner) {
        DataLogger.m12302d(TAG, "submit : " + jobRunner.getTaskType());
        synchronized (this.mRunningJobsLock) {
            try {
                ArrayList arrayList = new ArrayList();
                for (JobRunnerFuture<?> jobRunnerFuture : this.mRunningJobs) {
                    if (jobRunnerFuture.isDone()) {
                        arrayList.add(jobRunnerFuture);
                    }
                }
                this.mRunningJobs.removeAll(arrayList);
                synchronized (this.mThreadPoolLock) {
                    ConvertThreadPoolExecutor convertThreadPoolExecutor = this.mConvertThreadPool;
                    if (convertThreadPoolExecutor == null) {
                        return;
                    }
                    Future<?> futureSubmit = convertThreadPoolExecutor.submit(jobRunner);
                    DataLogger.m12302d(TAG, " submit : queue size : " + this.mConvertThreadPool.getQueue().size());
                    if (futureSubmit instanceof JobRunnerFuture) {
                        this.mRunningJobs.add((JobRunnerFuture) futureSubmit);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void cancel(int i) {
        synchronized (this.mItemQueueLock) {
            cancelItemQueue(i);
        }
        synchronized (this.mRunningJobsLock) {
            try {
                Iterator<JobRunnerFuture<?>> it = this.mRunningJobs.iterator();
                while (it.hasNext()) {
                    it.next().cancel(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void cancelAll() {
        synchronized (this.mItemQueueLock) {
            try {
                for (WConvertQueueItem wConvertQueueItem : this.mItemQueue) {
                    wConvertQueueItem.getListener().onSuccess(2, new ServiceMsg(wConvertQueueItem.getPath()));
                }
                this.mItemQueue.clear();
            } finally {
            }
        }
        synchronized (this.mRunningJobsLock) {
            try {
                Iterator<JobRunnerFuture<?>> it = this.mRunningJobs.iterator();
                while (it.hasNext()) {
                    it.next().cancel();
                }
            } finally {
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.IServiceRequestor
    public void convertDocument(@NonNull IConvertInfo iConvertInfo, List<String> list, IServiceRequestor.IServiceListener iServiceListener) {
        for (String str : list) {
            synchronized (this.mItemQueueLock) {
                this.mItemQueue.add(new WConvertQueueItem(str, iServiceListener, iConvertInfo));
            }
        }
        execute();
    }

    public void disconnect() {
        DataLogger.m12302d(TAG, "disconnect");
        synchronized (this.mItemQueueLock) {
            this.mItemQueue.clear();
        }
        synchronized (this.mRunningJobsLock) {
            try {
                Iterator<JobRunnerFuture<?>> it = this.mRunningJobs.iterator();
                while (it.hasNext()) {
                    it.next().cancel();
                }
            } finally {
            }
        }
        synchronized (this.mThreadPoolLock) {
            ConvertThreadPoolExecutor convertThreadPoolExecutor = this.mConvertThreadPool;
            if (convertThreadPoolExecutor != null) {
                convertThreadPoolExecutor.shutdown();
                try {
                    try {
                        if (!this.mConvertThreadPool.awaitTermination(1000L, TimeUnit.MILLISECONDS)) {
                            this.mConvertThreadPool.shutdownNow();
                        }
                    } catch (InterruptedException e) {
                        DataLogger.m12303e(TAG, "disconnect : " + e.getMessage());
                        this.mConvertThreadPool.shutdownNow();
                        Thread.currentThread().interrupt();
                    }
                } finally {
                    this.mConvertThreadPool = null;
                }
            }
        }
        synchronized (this.mServiceLock) {
            try {
                IDocumentServiceWrapper iDocumentServiceWrapper = this.mService;
                if (iDocumentServiceWrapper != null) {
                    iDocumentServiceWrapper.unsubscribe();
                    this.mService = null;
                }
            } finally {
            }
        }
        synchronized (this.mRunningJobsLock) {
            this.mRunningJobs.clear();
        }
        this.mAppContext.unbindService(this.mConnection);
        this.mAppContext = null;
        this.mConnection = null;
        ConvertingUtils.resetConvertingSize();
    }
}
