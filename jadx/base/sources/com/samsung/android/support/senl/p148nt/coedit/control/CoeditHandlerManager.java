package com.samsung.android.support.senl.p148nt.coedit.control;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.ntnl.base.NtnlDebugger;
import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.data.DocumentUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.ExternalSnapState;
import com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.ErrorCounter;
import com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.UpdatePriority;
import com.samsung.android.support.senl.p148nt.coedit.control.presenter.ThreadHandler;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;
import p079T.AbstractC0291i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditHandlerManager {
    private static final String TAG = "CoeditHandlerManager";
    private static CoeditHandlerManager sInstance;
    private boolean mIsLastCheckedComposerRunning;
    private final Object mWaitingStateListenerMutex = new Object();
    private ConcurrentLinkedQueue<ExternalSnapState> mWaitingStateListeners = new ConcurrentLinkedQueue<>();
    private final InternalSnapQueue mInternalSnapQueue = new InternalSnapQueue();
    private AtomicBoolean mCheckingWaitingExternalSnap = new AtomicBoolean(false);
    private final Object mLock = new Object();
    private final ThreadHandler mMainThreadHandler = new ThreadHandler();
    private final Map<String, CoeditTask> mHandlerMap = new HashMap();
    private final Map<String, RunningStateListener> mRunningStateListeners = new HashMap();
    private final CoeditHandlerState mHandlerState = new CoeditHandlerState();
    private final Map<Integer, ThreadHandler> mThreadHandlerMap = new HashMap();
    private final Map<Integer, Boolean> mThreadHandlerUsedMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditHandlerContractImpl implements ICoeditHandler.ComposerContract {
        final Contract mContract;

        public CoeditHandlerContractImpl(Contract contract) {
            this.mContract = contract;
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean canShowProgress() {
            return this.mContract.canShowProgress();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public String getWorkspaceId() {
            return this.mContract.getWorkspaceId();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public int getXmlDataWeight() {
            return this.mContract.getXmlDataWeight();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void hideInitProgress(String str) {
            this.mContract.hideInitProgress(str);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean hideProgress(String str) {
            return this.mContract.hideProgress(str);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean isCoeditUpdateListenerNonNull() {
            return this.mContract != null;
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean isDeleteOnlyMode() {
            return this.mContract.isDeleteOnlyMode();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean isEditMode() {
            return this.mContract.isEditMode();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean isEditModeWithReadOnly() {
            return this.mContract.isEditModeWithReadOnly();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean isFixedReadPermission() {
            return this.mContract.isFixedReadPermission();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void onClickCloseComposer() {
            this.mContract.onClickCloseComposer();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void onEditorUpdate(String str, String str2) {
            this.mContract.onEditorUpdate(str, str2);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void onListUpdate(List<CoeditDeviceInfo> list) {
            this.mContract.onListUpdate(list);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void requestReopen(String str, boolean z, String str2) {
            this.mContract.requestReopen(str, z, str2);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void requestSaveToDevice(@StringRes int i) {
            this.mContract.requestSaveToDevice(i);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void setDeleteOnlyMode(boolean z) {
            this.mContract.setDeleteOnlyMode(z);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        @WorkerThread
        public void setFixedReadPermission(boolean z, String str) {
            this.mContract.setFixedReadPermission(z, str);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public void setRequestUpdate(boolean z) {
            this.mContract.setRequestUpdate(z);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
        public boolean showProgress(String str) {
            return this.mContract.showProgress(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean canShowProgress();

        String getWorkspaceId();

        int getXmlDataWeight();

        void hideInitProgress(String str);

        boolean hideProgress(String str);

        boolean isDeleteOnlyMode();

        boolean isEditMode();

        boolean isEditModeWithReadOnly();

        boolean isFixedReadPermission();

        void onClickCloseComposer();

        void onEditorUpdate(String str, String str2);

        void onListUpdate(List<CoeditDeviceInfo> list);

        void requestReopen(String str, boolean z, String str2);

        void requestSaveToDevice(@StringRes int i);

        void setDeleteOnlyMode(boolean z);

        void setFixedReadPermission(boolean z, String str);

        void setRequestUpdate(boolean z);

        boolean showProgress(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IReleasePostAction {
        public static final int FAIL = 2;
        public static final int NOT_FOUND = 0;
        public static final int SUCCESS = 1;

        boolean execute(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RunningStateListener {
        void onComposerRunningStateChanged(boolean z);
    }

    private CoeditHandlerManager() {
        allocateThreadHandler();
    }

    @WorkerThread
    private void addCoeditTask(CoeditTask coeditTask) {
        CoeditLogger.m8922f(TAG, "addCoeditTask, add: " + coeditTask.getUuid() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        this.mHandlerMap.put(coeditTask.getUuid(), coeditTask);
        checkCoeditWithComposerRunningState();
    }

    private void checkCoeditWithComposerRunningState() {
        runOnWorkerThread(new RunnableC9040a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* JADX INFO: renamed from: clearAfterCreateCoeditTask, reason: merged with bridge method [inline-methods] */
    public void lambda$internalSnapStart$0(@NonNull SpenWNote spenWNote, @NonNull final String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, SnapControlCallback snapControlCallback, Contract contract) {
        CoeditLogger.m8924w(TAG, "clearAfterCreateCoeditTask, current handler is not Internal Handler, uuid: " + str);
        this.mInternalSnapQueue.enQueueSnapObject(spenWNote, str, str2, str3, str4, snapControlCallback, contract);
        final ErrorCounter errorCounter = getCoeditTask(str).getErrorCounter();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        releaseHandler(str, new IReleasePostAction() { // from class: com.samsung.android.support.senl.nt.coedit.control.c
            @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.IReleasePostAction
            public final boolean execute(int i) {
                return this.f6619a.lambda$clearAfterCreateCoeditTask$1(str, countDownLatch, errorCounter, i);
            }
        }, "clearAfterCreateCoeditTask");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "clearAfterCreateCoeditTask, await failed, InterruptedException: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public CoeditTask createCoeditTask(String str, CoeditConstants.User user) {
        CoeditTask coeditTask = getCoeditTask(str);
        if (!coeditTask.getUser().equals(CoeditConstants.User.Unknown)) {
            return coeditTask;
        }
        int allocatePoolIndex = getAllocatePoolIndex();
        if (allocatePoolIndex == -1) {
            AbstractC8014b.m7219u("createCoeditTask getAllocatePoolIndex failed# ", str, TAG);
            return coeditTask;
        }
        CoeditTask coeditTask2 = new CoeditTask(new CoeditHandler(str, user, createHandlerMangeContract()), this.mThreadHandlerMap.get(Integer.valueOf(allocatePoolIndex)));
        addCoeditTask(coeditTask2);
        return coeditTask2;
    }

    private ICoeditHandler.HandlerMangeContract createHandlerMangeContract() {
        return new ICoeditHandler.HandlerMangeContract() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.4
            @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.HandlerMangeContract
            public void initUiThreadHandler(String str) {
                CoeditHandlerManager.this.getCoeditTask(str).initUiThreadHandler();
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.HandlerMangeContract
            public boolean isMaxCounted(String str, long j, String str2) {
                return CoeditHandlerManager.this.getCoeditTask(str).getErrorCounter().isMaxCounted(j, str2);
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.HandlerMangeContract
            public void releaseUiThreadHandler(String str) {
                CoeditHandlerManager.this.getCoeditTask(str).releaseUiThreadHandler();
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.HandlerMangeContract
            public void runOnUIThread(Runnable runnable, String str) {
                CoeditHandlerManager.this.getCoeditTask(str).runOnUIThread(runnable);
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.HandlerMangeContract
            public void runOnWorkerThread(Runnable runnable, String str, int i) {
                CoeditHandlerManager.this.getCoeditTask(str).runOnWorkerThread(runnable, i);
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.HandlerMangeContract
            public void runOnWorkerThread(Runnable runnable, String str) {
                CoeditHandlerManager.this.getCoeditTask(str).runOnWorkerThread(runnable);
            }
        };
    }

    @WorkerThread
    private CoeditTask getCoeditTask(String str, CoeditConstants.User user) {
        CoeditTask coeditTask = getCoeditTask(str);
        return !coeditTask.getUser().equals(user) ? new CoeditTask(new EmptyCoeditHandler(), null) : coeditTask;
    }

    public static synchronized CoeditHandlerManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new CoeditHandlerManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkCoeditWithComposerRunningState$5() {
        synchronized (this.mRunningStateListeners) {
            try {
                boolean zIsCoeditWithComposerRunning = isCoeditWithComposerRunning();
                if (this.mIsLastCheckedComposerRunning == zIsCoeditWithComposerRunning) {
                    return;
                }
                CoeditLogger.m8923i(TAG, "checkCoeditWithComposerRunningState, composerRunningState changed " + this.mIsLastCheckedComposerRunning + " to " + zIsCoeditWithComposerRunning);
                this.mIsLastCheckedComposerRunning = zIsCoeditWithComposerRunning;
                Iterator<RunningStateListener> it = this.mRunningStateListeners.values().iterator();
                while (it.hasNext()) {
                    it.next().onComposerRunningStateChanged(this.mIsLastCheckedComposerRunning);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkWaitingExternalSnap$8() {
        ExternalSnapState externalSnapState;
        if (this.mCheckingWaitingExternalSnap.get()) {
            return;
        }
        synchronized (this.mWaitingStateListenerMutex) {
            try {
                if (this.mCheckingWaitingExternalSnap.get()) {
                    return;
                }
                this.mCheckingWaitingExternalSnap.set(true);
                while (true) {
                    externalSnapState = null;
                    if (this.mWaitingStateListeners.isEmpty() && (this.mHandlerMap.isEmpty() || this.mHandlerMap.size() > 1)) {
                        break;
                    }
                    ExternalSnapState externalSnapStatePoll = this.mWaitingStateListeners.poll();
                    if (externalSnapStatePoll != null && !AbstractC0291i.m569f(externalSnapStatePoll.getUuid())) {
                        if ((externalSnapStatePoll.isLowUpdatePriority() && this.mHandlerState.isBackgroundDownloadEnable() && !this.mHandlerState.isResumedBackgroundDownload()) || externalSnapStatePoll.isExceedExternalSnap()) {
                            this.mWaitingStateListeners.add(externalSnapStatePoll);
                        } else {
                            externalSnapState = externalSnapStatePoll;
                        }
                    }
                }
                if (externalSnapState != null) {
                    externalSnapState.wakeExternalSnap();
                }
                this.mCheckingWaitingExternalSnap.set(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$clearAfterCreateCoeditTask$1(final String str, final CountDownLatch countDownLatch, final ErrorCounter errorCounter, int i) {
        if (i == 2) {
            while (true) {
                if (!this.mInternalSnapQueue.isNeedRetryWaitingSnapStart(str)) {
                    break;
                }
                if (!this.mHandlerMap.containsKey(str)) {
                    i = 0;
                    break;
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    CoeditLogger.m8920e(TAG, "waitRelease wait, exception: " + e.getMessage());
                }
                this.mInternalSnapQueue.increaseCount(str);
            }
        }
        if (i == 2) {
            countDownLatch.countDown();
            SnapObject snapObjectDeQueueSnapObject = this.mInternalSnapQueue.deQueueSnapObject(str);
            if (snapObjectDeQueueSnapObject != null && snapObjectDeQueueSnapObject.getCallback() != null) {
                snapObjectDeQueueSnapObject.getCallback().onError("clearAfterCreateCoeditTask, timeout failed");
            }
            return false;
        }
        if (this.mHandlerMap.containsKey(str)) {
            removeCoeditTask(str, "clearAfterCreateCoeditTask");
        }
        CoeditConstants.User user = CoeditConstants.User.Internal;
        CoeditTask coeditTaskCreateCoeditTask = createCoeditTask(str, user);
        if (!coeditTaskCreateCoeditTask.getUser().equals(user)) {
            getInstance().registerExternalSnap(new ExternalSnapState(str, new ExternalSnapState.ExternalSnapContract() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.3
                @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
                public boolean isExceedExternalSnap() {
                    return false;
                }

                @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
                public void wakeExternalSnap() {
                    CoeditTask coeditTaskCreateCoeditTask2 = CoeditHandlerManager.this.createCoeditTask(str, CoeditConstants.User.Internal);
                    coeditTaskCreateCoeditTask2.setErrorCounter(errorCounter);
                    SnapObject snapObjectDeQueueSnapObject2 = CoeditHandlerManager.this.mInternalSnapQueue.deQueueSnapObject(str);
                    if (snapObjectDeQueueSnapObject2 != null) {
                        coeditTaskCreateCoeditTask2.internalSnapStart(snapObjectDeQueueSnapObject2.getNote(), snapObjectDeQueueSnapObject2.getFilePath(), snapObjectDeQueueSnapObject2.getGroupId(), snapObjectDeQueueSnapObject2.getWorkspaceId(), snapObjectDeQueueSnapObject2.getCallback(), new CoeditHandlerContractImpl(snapObjectDeQueueSnapObject2.getContract()));
                    }
                    countDownLatch.countDown();
                }
            }, UpdatePriority.COMPOSE_PRIORITY));
            return true;
        }
        coeditTaskCreateCoeditTask.setErrorCounter(errorCounter);
        SnapObject snapObjectDeQueueSnapObject2 = this.mInternalSnapQueue.deQueueSnapObject(str);
        if (snapObjectDeQueueSnapObject2 != null) {
            coeditTaskCreateCoeditTask.internalSnapStart(snapObjectDeQueueSnapObject2.getNote(), snapObjectDeQueueSnapObject2.getFilePath(), snapObjectDeQueueSnapObject2.getGroupId(), snapObjectDeQueueSnapObject2.getWorkspaceId(), snapObjectDeQueueSnapObject2.getCallback(), new CoeditHandlerContractImpl(snapObjectDeQueueSnapObject2.getContract()));
        }
        countDownLatch.countDown();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearWaitingExternalSnap$10() {
        synchronized (this.mWaitingStateListenerMutex) {
            this.mWaitingStateListeners.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerExternalSnap$6(ExternalSnapState externalSnapState) {
        synchronized (this.mWaitingStateListenerMutex) {
            try {
                if (!this.mWaitingStateListeners.contains(externalSnapState) && !AbstractC0291i.m569f(externalSnapState.getUuid())) {
                    CoeditLogger.m8923i(TAG, "registerExternalSnap, uuid : " + externalSnapState.getUuid());
                    if (externalSnapState.isHighUpdatePriority()) {
                        ConcurrentLinkedQueue<ExternalSnapState> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        concurrentLinkedQueue.add(externalSnapState);
                        concurrentLinkedQueue.addAll(this.mWaitingStateListeners);
                        this.mWaitingStateListeners = concurrentLinkedQueue;
                    } else {
                        this.mWaitingStateListeners.add(externalSnapState);
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerRunningStateListener$3(String str, RunningStateListener runningStateListener) {
        synchronized (this.mRunningStateListeners) {
            this.mRunningStateListeners.put(str, runningStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseHandler$2(String str, String str2) {
        CoeditLogger.m8919d(TAG, "releaseHandler finished, caller: " + str + ", uuid: " + str2);
        removeCoeditTask(str2, AbstractC0622a.m1170p(str, "/releaseHandler", new StringBuilder()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestStopSelf$9(Runnable runnable) {
        synchronized (this.mHandlerMap) {
            try {
                int size = this.mHandlerMap.size();
                if (size == 0 && this.mInternalSnapQueue.isEmpty()) {
                    if (runnable != null) {
                        runnable.run();
                    }
                    NtnlDebugger.getInstance().checkLeakState();
                }
                CoeditLogger.m8923i(TAG, "requestStopSelf : handlerCount = " + size + " SnapQueue isEmpty " + this.mInternalSnapQueue.isEmpty());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unregisterExternalSnap$7(String str) {
        ExternalSnapState next;
        synchronized (this.mWaitingStateListenerMutex) {
            try {
                CoeditLogger.m8923i(TAG, "unregisterExternalSnap, uuid : " + str);
                Iterator<ExternalSnapState> it = this.mWaitingStateListeners.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (next.getUuid().equals(str)) {
                            break;
                        }
                    }
                }
                this.mWaitingStateListeners.remove(next);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unregisterRunningStateListener$4(String str) {
        synchronized (this.mRunningStateListeners) {
            this.mRunningStateListeners.remove(str);
        }
    }

    @WorkerThread
    private void removeCoeditTask(String str, String str2) {
        StringBuilder sbM16m = AbstractC0000a.m16m("removeCoeditHandler, remove: ", str, ", caller: ", str2, ", backtrace : ");
        sbM16m.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        CoeditLogger.m8922f(TAG, sbM16m.toString());
        if (this.mHandlerMap.get(str) != null) {
            allocateThreadHandler(this.mHandlerMap.get(str).mThreadHandler);
            this.mHandlerMap.remove(str);
        }
        checkCoeditWithComposerRunningState();
        checkWaitingExternalSnap();
    }

    private void runOnWorkerThread(Runnable runnable) {
        this.mMainThreadHandler.runOnWorkerThread(runnable);
    }

    public void allocateThreadHandler(ThreadHandler threadHandler) {
        synchronized (this.mLock) {
            int i = 0;
            while (true) {
                if (i >= 5) {
                    break;
                }
                try {
                    if (Objects.equals(this.mThreadHandlerMap.get(Integer.valueOf(i)), threadHandler)) {
                        this.mThreadHandlerUsedMap.put(Integer.valueOf(i), Boolean.FALSE);
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void cancel(String str) {
        getCoeditTask(str).setCancelled();
    }

    public void checkDeleteOnlyMode(String str) {
        getCoeditTask(str, CoeditConstants.User.Internal).checkDeleteOnlyMode();
    }

    public void checkWaitingExternalSnap() {
        if (this.mCheckingWaitingExternalSnap.get()) {
            return;
        }
        runOnWorkerThread(new RunnableC9040a(this, 0));
    }

    public void clearWaitingExternalSnap() {
        runOnWorkerThread(new RunnableC9040a(this, 2));
    }

    public void externalChannelOpen(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
        getCoeditTask(str, CoeditConstants.User.External).externalChannelOpen(spenWNote, str2, str3, externalControlCallback);
    }

    public void externalSnapDownload(SpenWNote spenWNote, String str, String str2, String str3, String str4, ExternalControlCallback externalControlCallback) {
        if (getCoeditTask(str).getUser().equals(CoeditConstants.User.Unknown)) {
            createCoeditTask(str, CoeditConstants.User.UpDownloader).externalSnapDownload(spenWNote, str2, str3, str4, externalControlCallback);
            return;
        }
        CoeditLogger.m8920e(TAG, "externalSnapDownload task error# uuid: " + str);
    }

    public void externalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, String str4, ExternalControlCallback externalControlCallback) {
        if (getCoeditTask(str).getUser().equals(CoeditConstants.User.Unknown)) {
            createCoeditTask(str, CoeditConstants.User.External).externalSnapStart(spenWNote, str2, str3, str4, externalControlCallback);
            return;
        }
        CoeditLogger.m8920e(TAG, "externalSnapStart task error# uuid: " + str);
    }

    public void externalSnapUpload(SpenWNote spenWNote, String str, String str2, String str3, String str4, ExternalControlCallback externalControlCallback) {
        if (getCoeditTask(str).getUser().equals(CoeditConstants.User.Unknown)) {
            createCoeditTask(str, CoeditConstants.User.UpDownloader).externalSnapUpload(spenWNote, str2, str3, str4, externalControlCallback);
            return;
        }
        CoeditLogger.m8920e(TAG, "externalSnapUpload task error# uuid: " + str);
    }

    @WorkerThread
    public void forceCancel(final String str, final String str2) {
        if (isCoeditRunning(str)) {
            if (isCoeditWithComposerRunning(str)) {
                CoeditLogger.m8919d(TAG, "forceCancel ignore, note run with composer caller: " + str2 + ", uuid: " + str);
                return;
            }
            CoeditLogger.m8919d(TAG, "forceCancel, uuid: " + str + ", caller: " + str2);
            releaseHandler(str, new IReleasePostAction() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.2
                @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.IReleasePostAction
                public boolean execute(int i) {
                    if (i != 1) {
                        return false;
                    }
                    CoeditLogger.m8919d(CoeditHandlerManager.TAG, "forceCancel onCoeditDocumentClosed, uuid: " + str + ", caller: " + str2);
                    DocumentUpdateManager.getInstance().onCoEditDocumentClosed(str);
                    return false;
                }
            }, str2 + "/forceCancel");
        }
    }

    @WorkerThread
    public List<String> getAllHandledUuids() {
        ArrayList arrayList = new ArrayList();
        Iterator<CoeditTask> it = this.mHandlerMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUuid());
        }
        return arrayList;
    }

    public int getAllocatePoolIndex() {
        synchronized (this.mLock) {
            for (int i = 0; i < 5; i++) {
                try {
                    if (Objects.equals(this.mThreadHandlerUsedMap.get(Integer.valueOf(i)), Boolean.FALSE)) {
                        this.mThreadHandlerUsedMap.put(Integer.valueOf(i), Boolean.TRUE);
                        return i;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return -1;
        }
    }

    public boolean hasLowUpdatePrioritySnap() {
        Iterator<ExternalSnapState> it = this.mWaitingStateListeners.iterator();
        while (it.hasNext()) {
            if (it.next().isLowUpdatePriority()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasWaitingExternalSnap() {
        return !this.mWaitingStateListeners.isEmpty();
    }

    public void internalChannelOpen(@NonNull Activity activity, @NonNull SpenWNote spenWNote, @NonNull String str, @NonNull String str2, @NonNull String str3, CoeditControlCallback coeditControlCallback) {
        getCoeditTask(str, CoeditConstants.User.Internal).internalChannelOpen(activity, spenWNote, str2, str3, coeditControlCallback);
    }

    public void internalSnapRefresh(String str) {
        getCoeditTask(str, CoeditConstants.User.Internal).internalSnapRefresh();
    }

    public void internalSnapRestart(String str, String str2, SnapControlCallback snapControlCallback, CoeditControlCallback coeditControlCallback) {
        getCoeditTask(str, CoeditConstants.User.Internal).internalSnapRestart(str2, snapControlCallback, coeditControlCallback);
    }

    public void internalSnapStart(@NonNull final SpenWNote spenWNote, @NonNull final String str, @NonNull final String str2, @NonNull final String str3, @NonNull final String str4, final SnapControlCallback snapControlCallback, final Contract contract) {
        CoeditTask coeditTask = getCoeditTask(str);
        if (!coeditTask.getUser().equals(CoeditConstants.User.Unknown)) {
            coeditTask.runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.b
                @Override // java.lang.Runnable
                public final void run() {
                    SnapControlCallback snapControlCallback2 = snapControlCallback;
                    CoeditHandlerManager.Contract contract2 = contract;
                    this.f6611a.lambda$internalSnapStart$0(spenWNote, str, str2, str3, str4, snapControlCallback2, contract2);
                }
            });
            return;
        }
        if (this.mInternalSnapQueue.isWaitingSnapStart(str)) {
            this.mInternalSnapQueue.refreshWaitingSnapStart(str, spenWNote, snapControlCallback, contract);
            return;
        }
        CoeditConstants.User user = CoeditConstants.User.Internal;
        CoeditTask coeditTaskCreateCoeditTask = createCoeditTask(str, user);
        if (coeditTaskCreateCoeditTask.getUser().equals(user)) {
            coeditTaskCreateCoeditTask.internalSnapStart(spenWNote, str2, str3, str4, snapControlCallback, new CoeditHandlerContractImpl(contract));
        } else {
            getInstance().registerExternalSnap(new ExternalSnapState(str, new ExternalSnapState.ExternalSnapContract() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.1
                @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
                public boolean isExceedExternalSnap() {
                    return false;
                }

                @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
                public void wakeExternalSnap() {
                    CoeditHandlerManager.this.createCoeditTask(str, CoeditConstants.User.Internal).internalSnapStart(spenWNote, str2, str3, str4, snapControlCallback, new CoeditHandlerContractImpl(contract));
                }
            }, UpdatePriority.COMPOSE_PRIORITY));
        }
    }

    public boolean isBackgroundDownloadDisable() {
        return this.mHandlerState.isBackgroundDownloadEnable();
    }

    public boolean isCancelDownloadRequested() {
        return this.mHandlerState.isCancelDownloadRequested();
    }

    public boolean isCoeditInitializing(String str) {
        CoeditTask coeditTask = getCoeditTask(str);
        if (coeditTask == null) {
            return false;
        }
        return coeditTask.isInitializing();
    }

    public boolean isCoeditRunning(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mHandlerMap.containsKey(str);
    }

    public boolean isCoeditWithComposerRunning(String str) {
        return isCoeditRunning(str, CoeditConstants.User.Internal);
    }

    public boolean isCoeditWithUpDownloaderRunning(String str) {
        return isCoeditRunning(str, CoeditConstants.User.UpDownloader) || isCoeditRunning(str, CoeditConstants.User.External);
    }

    public boolean isResumedBackgroundDownload() {
        return this.mHandlerState.isResumedBackgroundDownload();
    }

    public boolean isSnapEndState(String str) {
        return getCoeditTask(str).isSnapEndState();
    }

    public boolean isWritePermissionGranted(String str) {
        return getCoeditTask(str, CoeditConstants.User.Internal).isWritePermissionGranted();
    }

    public int pauseConcurrency(String str, String str2, Runnable runnable) {
        return getCoeditTask(str, CoeditConstants.User.Internal).pauseConcurrency(str2, runnable);
    }

    public void registerExternalSnap(ExternalSnapState externalSnapState) {
        runOnWorkerThread(new RunnableC9054j(this, externalSnapState, 1));
    }

    public void registerRunningStateListener(String str, RunningStateListener runningStateListener) {
        runOnWorkerThread(new RunnableC8928b(this, 6, str, runningStateListener));
    }

    @WorkerThread
    public void releaseHandler(String str, IReleasePostAction iReleasePostAction, String str2) {
        if (this.mHandlerMap.containsKey(str)) {
            getCoeditTask(str).release(new RunnableC8928b(this, 5, str2, str), iReleasePostAction, AbstractC0541b.m756B(str2, "/releaseHandler"));
            return;
        }
        CoeditLogger.m8924w(TAG, "releaseHandler, ignore, handler is invalid, caller: " + str2);
        if (iReleasePostAction != null) {
            iReleasePostAction.execute(0);
        }
    }

    public boolean requestBackgroundDownload() {
        return this.mHandlerState.requestBackgroundDownload();
    }

    public void requestReadPermission(String str) {
        getCoeditTask(str, CoeditConstants.User.Internal).requestReadPermission();
    }

    public void requestStopSelf(Runnable runnable) {
        runOnWorkerThread(new RunnableC9054j(this, runnable, 2));
    }

    public void resumeBackgroundDownload() {
        this.mHandlerState.resumeBackgroundDownload();
    }

    public int resumeConcurrency(String str, String str2) {
        return getCoeditTask(str, CoeditConstants.User.Internal).resumeConcurrency(str2);
    }

    public void saveCoeditCache(String str) {
        getCoeditTask(str, CoeditConstants.User.Internal).saveCoeditCache();
    }

    public void setBackgroundDownloading(boolean z) {
        this.mHandlerState.setBackgroundDownloading(z);
    }

    public void setCancelDownloadRequested() {
        this.mHandlerState.setCancelDownloadRequested();
    }

    public void stopBackgroundDownload() {
        this.mHandlerState.stopBackgroundDownload();
    }

    public void unregisterExternalSnap(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runOnWorkerThread(new RunnableC9048d(this, str, 1));
    }

    public void unregisterRunningStateListener(String str) {
        runOnWorkerThread(new RunnableC9048d(this, str, 0));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditTask {
        ErrorCounter mErrorCounter = new ErrorCounter();
        final ICoeditHandler mICoeditHandler;
        final ThreadHandler mThreadHandler;

        public CoeditTask(ICoeditHandler iCoeditHandler, ThreadHandler threadHandler) {
            this.mICoeditHandler = iCoeditHandler;
            this.mThreadHandler = threadHandler;
        }

        private boolean isClosingState(IReleasePostAction iReleasePostAction) {
            if (!this.mICoeditHandler.isClosingState()) {
                return false;
            }
            if (iReleasePostAction == null) {
                return true;
            }
            iReleasePostAction.execute(2);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$externalChannelOpen$6(SpenWNote spenWNote, String str, String str2, ExternalControlCallback externalControlCallback) {
            this.mICoeditHandler.externalChannelOpen(spenWNote, str, str2, externalControlCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$externalSnapDownload$9(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
            this.mICoeditHandler.externalSnapDownload(spenWNote, str, str2, str3, externalControlCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$externalSnapStart$7(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
            this.mICoeditHandler.externalSnapStart(spenWNote, str, str2, str3, externalControlCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$externalSnapUpload$8(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
            this.mICoeditHandler.externalSnapUpload(spenWNote, str, str2, str3, externalControlCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$internalChannelOpen$3(Activity activity, SpenWNote spenWNote, String str, String str2, CoeditControlCallback coeditControlCallback) {
            this.mICoeditHandler.internalChannelOpen(activity, spenWNote, str, str2, coeditControlCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$internalSnapRestart$4(String str, SnapControlCallback snapControlCallback, CoeditControlCallback coeditControlCallback) {
            this.mICoeditHandler.internalSnapRestart(str, snapControlCallback, coeditControlCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$internalSnapStart$5(SpenWNote spenWNote, String str, String str2, String str3, SnapControlCallback snapControlCallback, CoeditHandlerContractImpl coeditHandlerContractImpl) {
            this.mICoeditHandler.internalSnapStart(spenWNote, str, str2, str3, snapControlCallback, coeditHandlerContractImpl);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$release$0(IReleasePostAction iReleasePostAction, Runnable runnable) {
            if (iReleasePostAction == null || iReleasePostAction.execute(1)) {
                return;
            }
            runnable.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$release$1(IReleasePostAction iReleasePostAction) {
            if (iReleasePostAction == null) {
                return;
            }
            iReleasePostAction.execute(2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$release$2(IReleasePostAction iReleasePostAction, Runnable runnable, String str) {
            if (isClosingState(iReleasePostAction)) {
                return;
            }
            this.mICoeditHandler.release(new RunnableC9054j(iReleasePostAction, runnable, 0), new RunnableC9040a(iReleasePostAction, 3), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void runOnUIThread(Runnable runnable) {
            ThreadHandler threadHandler = this.mThreadHandler;
            if (threadHandler == null) {
                return;
            }
            threadHandler.runOnUIThread(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void runOnWorkerThread(Runnable runnable) {
            ThreadHandler threadHandler = this.mThreadHandler;
            if (threadHandler == null) {
                return;
            }
            threadHandler.runOnWorkerThread(runnable);
        }

        public void checkDeleteOnlyMode() {
            ICoeditHandler iCoeditHandler = this.mICoeditHandler;
            Objects.requireNonNull(iCoeditHandler);
            runOnWorkerThread(new RunnableC9049e(iCoeditHandler, 0));
        }

        public void externalChannelOpen(final SpenWNote spenWNote, final String str, final String str2, final ExternalControlCallback externalControlCallback) {
            runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6647a.lambda$externalChannelOpen$6(spenWNote, str, str2, externalControlCallback);
                }
            });
        }

        public void externalSnapDownload(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
            runOnWorkerThread(new RunnableC9051g(this, spenWNote, str, str2, str3, externalControlCallback, 1));
        }

        public void externalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
            runOnWorkerThread(new RunnableC9051g(this, spenWNote, str, str2, str3, externalControlCallback, 0));
        }

        public void externalSnapUpload(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
            runOnWorkerThread(new RunnableC9051g(this, spenWNote, str, str2, str3, externalControlCallback, 2));
        }

        public ErrorCounter getErrorCounter() {
            return this.mErrorCounter;
        }

        public int getState() {
            return this.mICoeditHandler.getState();
        }

        public CoeditConstants.User getUser() {
            return this.mICoeditHandler.getUser();
        }

        public String getUuid() {
            return this.mICoeditHandler.getUuid();
        }

        public void initUiThreadHandler() {
            ThreadHandler threadHandler = this.mThreadHandler;
            if (threadHandler == null) {
                return;
            }
            threadHandler.initUiThreadHandler();
        }

        public void internalChannelOpen(Activity activity, SpenWNote spenWNote, String str, String str2, CoeditControlCallback coeditControlCallback) {
            runOnWorkerThread(new RunnableC9051g(this, activity, spenWNote, str, str2, coeditControlCallback));
        }

        public void internalSnapRefresh() {
            ICoeditHandler iCoeditHandler = this.mICoeditHandler;
            Objects.requireNonNull(iCoeditHandler);
            runOnUIThread(new RunnableC9049e(iCoeditHandler, 2));
        }

        public void internalSnapRestart(String str, SnapControlCallback snapControlCallback, CoeditControlCallback coeditControlCallback) {
            runOnWorkerThread(new RunnableC9052h(this, str, snapControlCallback, coeditControlCallback));
        }

        public void internalSnapStart(final SpenWNote spenWNote, final String str, final String str2, final String str3, final SnapControlCallback snapControlCallback, final CoeditHandlerContractImpl coeditHandlerContractImpl) {
            runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6628a.lambda$internalSnapStart$5(spenWNote, str, str2, str3, snapControlCallback, coeditHandlerContractImpl);
                }
            });
        }

        public boolean isInitializing() {
            return this.mICoeditHandler.isInitializing();
        }

        public boolean isSnapEndState() {
            return this.mICoeditHandler.isSnapEndState();
        }

        public boolean isWritePermissionGranted() {
            return this.mICoeditHandler.isWritePermissionGranted();
        }

        public int pauseConcurrency(String str, Runnable runnable) {
            return this.mICoeditHandler.pauseConcurrency(str, runnable);
        }

        public void release(Runnable runnable, IReleasePostAction iReleasePostAction, String str) {
            if (isClosingState(iReleasePostAction)) {
                return;
            }
            runOnWorkerThread(new RunnableC9052h(this, iReleasePostAction, runnable, str), 100L);
        }

        public void releaseUiThreadHandler() {
            ThreadHandler threadHandler = this.mThreadHandler;
            if (threadHandler == null) {
                return;
            }
            threadHandler.releaseUiThreadHandler();
        }

        public void requestReadPermission() {
            ICoeditHandler iCoeditHandler = this.mICoeditHandler;
            Objects.requireNonNull(iCoeditHandler);
            runOnWorkerThread(new RunnableC9049e(iCoeditHandler, 3));
        }

        public int resumeConcurrency(String str) {
            return this.mICoeditHandler.resumeConcurrency(str);
        }

        public void saveCoeditCache() {
            ICoeditHandler iCoeditHandler = this.mICoeditHandler;
            Objects.requireNonNull(iCoeditHandler);
            runOnWorkerThread(new RunnableC9049e(iCoeditHandler, 1));
        }

        public void setCancelled() {
            this.mICoeditHandler.setCancelled();
        }

        public void setErrorCounter(ErrorCounter errorCounter) {
            this.mErrorCounter = errorCounter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void runOnWorkerThread(Runnable runnable, long j) {
            ThreadHandler threadHandler = this.mThreadHandler;
            if (threadHandler == null) {
                return;
            }
            threadHandler.runOnWorkerThread(runnable, j);
        }
    }

    public boolean isCoeditWithComposerRunning() {
        try {
            for (CoeditTask coeditTask : new CopyOnWriteArrayList(this.mHandlerMap.values())) {
                if (coeditTask.getUser() == CoeditConstants.User.Internal) {
                    CoeditLogger.m8923i(TAG, "isCoeditWithComposerRunning, uuid: " + coeditTask.getUuid() + ", state: " + coeditTask.getState());
                    return true;
                }
            }
            return false;
        } catch (ConcurrentModificationException e) {
            CoeditLogger.m8919d(TAG, "isCoeditWithComposerRunning failed# " + e.getMessage());
            return false;
        }
    }

    @WorkerThread
    private boolean isCoeditRunning(String str, CoeditConstants.User user) {
        CoeditTask coeditTask;
        if (TextUtils.isEmpty(str) || (coeditTask = this.mHandlerMap.get(str)) == null) {
            return false;
        }
        return coeditTask.getUser().equals(user);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    @WorkerThread
    public CoeditTask getCoeditTask(String str) {
        if (!TextUtils.isEmpty(str) && this.mHandlerMap.containsKey(str)) {
            return this.mHandlerMap.get(str);
        }
        return new CoeditTask(new EmptyCoeditHandler(), null);
    }

    public void allocateThreadHandler() {
        synchronized (this.mLock) {
            for (int i = 0; i < 5; i++) {
                try {
                    this.mThreadHandlerMap.put(Integer.valueOf(i), new ThreadHandler());
                    this.mThreadHandlerUsedMap.put(Integer.valueOf(i), Boolean.FALSE);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
