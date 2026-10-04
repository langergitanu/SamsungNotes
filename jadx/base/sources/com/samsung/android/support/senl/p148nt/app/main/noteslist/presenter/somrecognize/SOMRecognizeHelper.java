package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SOMRecognizedCardHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SOMRecognizedInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.SOMRecognizeUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.model.RecognizeTextInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.task.SOMRecognizeTask;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.contract.DataToComposerManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SOMRecognizeHelper {
    private static final String TAG = "SOMRecognizeHelper";
    private final Runnable mChangeIdleStateRunnable;
    private final Runnable mChangeProgressStateRunnable;
    private final Runnable mCheckSOMUnRecognizedCountRunnable;
    private final SOMRecognizeListener mContract;
    private final Runnable mDataChangeRunnable;
    private final DocumentMap mDocumentMap;
    private boolean mHandleOrganizedDataPended;
    private final Handler mHandler;
    private boolean mIsHandleOrganizedDataByLiveDataIgnore;
    private Boolean mIsNoteListPenMultiSelectionEnabled;
    private boolean mIsPenMultiSelectionStarted;
    boolean mIsRunRecognizeTaskMethodLocked;
    private String mLastCaller;
    private final RecyclerView.SimpleOnItemTouchListener mNotePenRecyclerViewSimpleOnItemTouchListener;
    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener;
    private int mRecognizedDataChangedCount;
    private final Map<String, Long> mRecognizedModifiedTimes;
    private final Runnable mReleaseNoteListPenMultiSelectionRunnable;
    private final LiveData<List<NotesOrganizedDocumentEntity>> mSOMCardLiveData;
    private final Observer<List<NotesOrganizedDocumentEntity>> mSOMCardLiveDataObserver;
    private final Runnable mSOMRecognizedCardCollapseRunnable;
    private final SOMRecognizeTask.Contract mSOMRecognizedTaskContract;
    private final List<SOMRecognizedInfo> mSomRecognizedInfo;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;
    private final ExecutorService RECOGNIZE_EXECUTOR = AbstractC4539a.m3201k("SOMRecognizeHelper_RECOGNIZE_EXECUTOR");
    private final ExecutorService COMPOSER_STATE_CHECK_EXECUTOR = AbstractC4539a.m3201k("SOMRecognizeHelper_COMPOSER_STATE_CHECK_EXECUTOR");
    private final Object mRecognizeMutex = new Object();
    private final Object mRecognizeTaskMutex = new Object();
    private final Object mHandleOrganizedDataMutex = new Object();
    private final Map<String, SOMRecognizeTask> mSOMRecognizeTasks = new HashMap();

    public SOMRecognizeHelper(ViewParams viewParams, StateInfo stateInfo, DocumentMap documentMap, SOMRecognizeListener sOMRecognizeListener) {
        Looper looperMyLooper = Looper.myLooper();
        Objects.requireNonNull(looperMyLooper);
        this.mHandler = new Handler(looperMyLooper);
        this.mDataChangeRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.1
            @Override // java.lang.Runnable
            public void run() {
                NotesFolder folderData;
                String folderUuid = SOMRecognizeHelper.this.mStateInfo.getFolderUuid();
                if (1 == SOMRecognizeHelper.this.mStateInfo.getModeIndex() && (folderData = SOMRecognizeHelper.this.mDocumentMap.getFolderData(folderUuid)) != null && folderData.getDocumentCount() > 0 && SOMRecognizeHelper.this.mViewParams.getAbsFragment().isResumed()) {
                    if (!FolderConstants.ScreenOffMemo.UUID.equals(folderUuid)) {
                        SOMRecognizeHelper.this.mIsHandleOrganizedDataByLiveDataIgnore = true;
                        if (!SOMRecognizeHelper.this.mStateInfo.isSOMRecognizedCardCollapsed()) {
                            SOMRecognizeHelper.this.scrollToPosition(0);
                        }
                        SOMRecognizeHelper.this.removeSOMRecognizedCard("onDataChanged, not som folder now");
                        SOMRecognizeHelper.this.updateSOMRecognizedInfo(new ArrayList());
                        SOMRecognizeHelper.this.unregisterObserver();
                        return;
                    }
                    SOMRecognizeHelper.this.registerObserver();
                    if (SOMRecognizeHelper.this.isScrolling()) {
                        MainLogger.m7254d(SOMRecognizeHelper.TAG, "onDataChanged, ignore, noteList is scrolling now");
                        return;
                    }
                    if (!SOMRecognizeHelper.this.getSOMRecognizedInfo().isEmpty()) {
                        SOMRecognizeHelper.this.onSOMRecognizeStateEnd();
                    }
                    SOMRecognizeHelper.this.runSOMRecognizedTask(Constant.TASK_CALLER_DATA_CHANGED);
                    SOMRecognizeHelper.this.mIsHandleOrganizedDataByLiveDataIgnore = false;
                }
            }
        };
        this.mSOMRecognizedTaskContract = new SOMRecognizeTask.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.2
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.task.SOMRecognizeTask.Contract
            public void onFailed(String str, long j) {
                SOMRecognizeHelper.this.handleRecognizeTaskEndForFailed(str, j);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.task.SOMRecognizeTask.Contract
            public void onIgnored(String str, long j) {
                SOMRecognizeHelper.this.handleRecognizeTaskEndForIgnored(str, j);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.task.SOMRecognizeTask.Contract
            public void onRetry(String str) {
                SOMRecognizeHelper.this.handleRecognizeTaskEndForRetry(str);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.task.SOMRecognizeTask.Contract
            public void onSuccess(String str, long j, String str2) {
                SOMRecognizeHelper.this.handleRecognizeTaskEndForSuccess(str, j, str2);
            }
        };
        this.mNotePenRecyclerViewSimpleOnItemTouchListener = new RecyclerView.SimpleOnItemTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.3
            private void handleNoteListTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                if (motionEvent.getButtonState() != 32 && motionEvent.getButtonState() != 64) {
                    SOMRecognizeHelper.this.restoreNoteListPenMultiSelection();
                    SOMRecognizeHelper.this.mIsPenMultiSelectionStarted = false;
                    return;
                }
                View viewFindChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (viewFindChildViewUnder == null) {
                    SOMRecognizeHelper.this.restoreNoteListPenMultiSelection();
                    return;
                }
                if (!(recyclerView.findContainingViewHolder(viewFindChildViewUnder) instanceof SOMRecognizedCardHolder)) {
                    SOMRecognizeHelper.this.restoreNoteListPenMultiSelection();
                    return;
                }
                if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 211 || motionEvent.getAction() == 2 || motionEvent.getAction() == 213) && !SOMRecognizeHelper.this.mIsPenMultiSelectionStarted) {
                    SOMRecognizeHelper.this.disableNoteListPenMultiSelection();
                    SOMRecognizeHelper sOMRecognizeHelper = SOMRecognizeHelper.this;
                    sOMRecognizeHelper.runOnNoteListHandler(sOMRecognizeHelper.mReleaseNoteListPenMultiSelectionRunnable, 300L);
                }
                SOMRecognizeHelper.this.mIsPenMultiSelectionStarted = true;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                handleNoteListTouchEvent(recyclerView, motionEvent);
                return super.onInterceptTouchEvent(recyclerView, motionEvent);
            }
        };
        this.mReleaseNoteListPenMultiSelectionRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (!SOMRecognizeHelper.this.mViewParams.getNotesRecyclerView().isPenMultiSelectionOn()) {
                    SOMRecognizeHelper.this.mIsPenMultiSelectionStarted = false;
                    SOMRecognizeHelper.this.restoreNoteListPenMultiSelection();
                } else {
                    SOMRecognizeHelper sOMRecognizeHelper = SOMRecognizeHelper.this;
                    sOMRecognizeHelper.removeFromNoteListHandler(sOMRecognizeHelper.mReleaseNoteListPenMultiSelectionRunnable);
                    SOMRecognizeHelper sOMRecognizeHelper2 = SOMRecognizeHelper.this;
                    sOMRecognizeHelper2.runOnNoteListHandler(sOMRecognizeHelper2.mReleaseNoteListPenMultiSelectionRunnable, 300L);
                }
            }
        };
        this.mChangeProgressStateRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (!SOMRecognizeHelper.this.isSOMRecognizeTaskRunning() || SOMRecognizeHelper.this.mStateInfo.isSOMRecognitionStateProgressing()) {
                    return;
                }
                SOMRecognizeHelper.this.mStateInfo.setSOMRecognitionStateProgressing();
                SOMRecognizeHelper.this.onSOMRecognizeStateChanged();
            }
        };
        this.mChangeIdleStateRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (SOMRecognizeHelper.this.mStateInfo.isSOMRecognizeTaskIdle()) {
                    return;
                }
                SOMRecognizeHelper.this.mStateInfo.setSOMRecognitionStateIdle();
                SOMRecognizeHelper.this.onSOMRecognizeStateChanged();
            }
        };
        this.mSOMRecognizedCardCollapseRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.7
            @Override // java.lang.Runnable
            public void run() {
                SOMRecognizeHelper.this.setSOMRecognizedCardShape(0);
            }
        };
        this.mCheckSOMUnRecognizedCountRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.8
            @Override // java.lang.Runnable
            public void run() {
                SOMRecognizeHelper.this.runSOMRecognizedTask(Constant.TASK_CALLER_CHECK_UNRECOGNIZED_COUNT);
            }
        };
        this.mSOMCardLiveDataObserver = new Observer<List<NotesOrganizedDocumentEntity>>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.9
            @Override // androidx.lifecycle.Observer
            public void onChanged(List<NotesOrganizedDocumentEntity> list) throws Throwable {
                if (SOMRecognizeHelper.this.mIsHandleOrganizedDataByLiveDataIgnore) {
                    return;
                }
                SOMRecognizeHelper.this.handleOrganizedDocumentEntities(list, "onOrganizedDocumentEntityChanged");
            }
        };
        this.mPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.10
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String str) {
                if (SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE.equals(str)) {
                    SOMRecognizeHelper.this.runSOMRecognizedTask("RecognitionLanguageChanged");
                } else if (SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION.equals(str)) {
                    if (RecognitionUtil.isSupported(SOMRecognizeHelper.this.mViewParams.getContext())) {
                        SOMRecognizeHelper.this.runSOMRecognizedTask("RecognitionEnabled");
                    } else {
                        SOMRecognizeHelper.this.removeSOMRecognizedCard("RecognitionDisabled");
                    }
                }
            }
        };
        this.mSomRecognizedInfo = new ArrayList();
        this.mRecognizedModifiedTimes = new HashMap();
        this.mRecognizedDataChangedCount = 0;
        this.mHandleOrganizedDataPended = false;
        this.mIsRunRecognizeTaskMethodLocked = false;
        this.mIsPenMultiSelectionStarted = false;
        this.mIsHandleOrganizedDataByLiveDataIgnore = true;
        this.mLastCaller = "";
        this.mViewParams = viewParams;
        this.mStateInfo = stateInfo;
        this.mDocumentMap = documentMap;
        this.mContract = sOMRecognizeListener;
        this.mSOMCardLiveData = SOMRecognizeUtil.getOrganizedDocumentsLiveData();
    }

    private void addSOMRecognizedCard() {
        if (FeatureUtils.canShowSOMRecognizedCard(this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid())) {
            if (this.mDocumentMap.hasHolderInfo(2)) {
                MainLogger.m7258i(TAG, "addSOMRecognizedCard, ignore, card already added");
                return;
            }
            this.mDocumentMap.putHolderInfoMap(2, true);
            this.mViewParams.getNotesRecyclerView().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.13
                @Override // java.lang.Runnable
                public void run() {
                    SOMRecognizeHelper sOMRecognizeHelper = SOMRecognizeHelper.this;
                    sOMRecognizeHelper.scrollToPosition(sOMRecognizeHelper.getSOMRecognizedCardPosition());
                }
            });
            onSOMRecognizedCardVisibilityChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableNoteListPenMultiSelection() {
        if (this.mIsNoteListPenMultiSelectionEnabled != null) {
            return;
        }
        this.mIsNoteListPenMultiSelectionEnabled = this.mViewParams.getNotesRecyclerView().isPenMultiSelectionEnabled();
        this.mViewParams.getNotesRecyclerView().seslSetPenSelectionEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOrganizedDocumentEntities(List<NotesOrganizedDocumentEntity> list, String str) throws Throwable {
        synchronized (this.mHandleOrganizedDataMutex) {
            try {
                MainLogger.m7258i(TAG, "handleOrganizedDocumentEntities, caller: " + str);
                ArrayList arrayList = new ArrayList();
                for (NotesOrganizedDocumentEntity notesOrganizedDocumentEntity : list) {
                    if (20 <= arrayList.size()) {
                        break;
                    }
                    String uuid = notesOrganizedDocumentEntity.getUuid();
                    if (SOMRecognizeUtil.isTargetNote(this.mDocumentMap.getNoteData(uuid))) {
                        long jLongValue = notesOrganizedDocumentEntity.getModifiedTime().longValue();
                        String recognizedLanguage = notesOrganizedDocumentEntity.getRecognizedLanguage();
                        String recognizerDBVersion = notesOrganizedDocumentEntity.getRecognizerDBVersion();
                        RecognizeTextInfo recognizeTextInfo = new RecognizeTextInfo(notesOrganizedDocumentEntity.getContents());
                        try {
                            SOMRecognizedInfo sOMRecognizedInfoFindSOMRecognizedInfo = findSOMRecognizedInfo(uuid, recognizeTextInfo.getContentStr().toString(), recognizedLanguage, recognizerDBVersion, jLongValue);
                            if (sOMRecognizedInfoFindSOMRecognizedInfo == null) {
                                try {
                                    sOMRecognizedInfoFindSOMRecognizedInfo = SOMRecognizeUtil.getSOMRecognized(this.mViewParams.getContext(), uuid, recognizeTextInfo, recognizedLanguage, recognizerDBVersion, jLongValue, "onDataChanged");
                                    if (sOMRecognizedInfoFindSOMRecognizedInfo == null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                            arrayList.add(sOMRecognizedInfoFindSOMRecognizedInfo);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                List<SOMRecognizedInfo> sOMRecognizedInfo = getSOMRecognizedInfo();
                boolean z = sOMRecognizedInfo.size() == arrayList.size();
                if (z) {
                    int i = 0;
                    while (true) {
                        if (i >= sOMRecognizedInfo.size()) {
                            break;
                        }
                        if (!sOMRecognizedInfo.get(i).equals(arrayList.get(i))) {
                            z = false;
                            break;
                        }
                        i++;
                    }
                }
                MainLogger.m7254d(TAG, "handleOrganizedDocumentEntities, isSameWithOldData: " + z + ", count: " + arrayList.size());
                if (arrayList.isEmpty()) {
                    BadgeHelper.setSOMFolderHasNewBadge(false, str + "/handleOrganizedDocumentEntities");
                    removeSOMRecognizedCard(str + "/handleOrganizedDocumentEntities");
                } else {
                    addSOMRecognizedCard();
                }
                if (!z) {
                    updateSOMRecognizedInfo(new ArrayList(arrayList));
                    onSOMRecognizedInfoChanged();
                }
                onSOMRecognizeStateEnd();
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRecognizeTaskEnd() throws Throwable {
        if (isSOMRecognizeTaskRunning()) {
            return;
        }
        boolean zIsRunningOnCoeditMode = ComposerManager.getInstance().isRunningOnCoeditMode();
        BadgeHelper.updateSOMRecognizedTimes(this.mRecognizedModifiedTimes, this.mStateInfo.isSOMRecognizedCardCollapsed(), "RecognizeTask Finished");
        if (this.mRecognizedDataChangedCount <= 0 && !zIsRunningOnCoeditMode) {
            handleOrganizedDocumentEntities(SOMRecognizeUtil.getOrganizedDocuments(), "handleRecognizeTaskEnd(data is not changed by recognized task)");
        } else if (!isLiveDataObserved() || zIsRunningOnCoeditMode) {
            this.mHandleOrganizedDataPended = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRecognizeTaskEndForFailed(String str, long j) {
        synchronized (this.mRecognizeTaskMutex) {
            this.mRecognizedModifiedTimes.put(str, Long.valueOf(j));
            this.mSOMRecognizeTasks.remove(str);
            MainLogger.m7259w(TAG, "handleRecognizeTaskEndForFailed, remainedTask: " + this.mSOMRecognizeTasks.size());
            handleRecognizeTaskEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRecognizeTaskEndForIgnored(String str, long j) {
        synchronized (this.mRecognizeTaskMutex) {
            this.mRecognizedModifiedTimes.put(str, Long.valueOf(j));
            this.mSOMRecognizeTasks.remove(str);
            handleRecognizeTaskEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRecognizeTaskEndForRetry(final String str) {
        this.RECOGNIZE_EXECUTOR.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.12
            /* JADX WARN: Removed duplicated region for block: B:64:0x018f  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                try {
                    try {
                        MainLogger.m7259w(SOMRecognizeHelper.TAG, "handleRecognizeTaskEndForRetry, ");
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        SOMRecognizeHelper.this.COMPOSER_STATE_CHECK_EXECUTOR.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                while (ComposerManager.getInstance().isRunningOnEditMode()) {
                                    try {
                                        MainLogger.m7254d(SOMRecognizeHelper.TAG, "handleRecognizeTaskEndForRetry, checking ...");
                                        Thread.sleep(200L);
                                    } catch (InterruptedException unused) {
                                        countDownLatch.countDown();
                                    }
                                }
                                countDownLatch.countDown();
                            }
                        });
                        if (!countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                            if (TextUtils.isEmpty("retry waiting timeout")) {
                                return;
                            }
                            synchronized (SOMRecognizeHelper.this.mRecognizeTaskMutex) {
                                SOMRecognizeHelper.this.mSOMRecognizeTasks.remove(str);
                                MainLogger.m7259w(SOMRecognizeHelper.TAG, "onRetry, failed, retry waiting timeout, remained task count: " + SOMRecognizeHelper.this.mSOMRecognizeTasks.size());
                                SOMRecognizeHelper.this.handleRecognizeTaskEnd();
                            }
                            return;
                        }
                        MainListDocumentData recognizeTargetNoteData = SOMRecognizeUtil.getRecognizeTargetNoteData(str);
                        if (recognizeTargetNoteData == null) {
                            if (TextUtils.isEmpty("noteData is null")) {
                                return;
                            }
                            synchronized (SOMRecognizeHelper.this.mRecognizeTaskMutex) {
                                SOMRecognizeHelper.this.mSOMRecognizeTasks.remove(str);
                                MainLogger.m7259w(SOMRecognizeHelper.TAG, "onRetry, failed, noteData is null, remained task count: " + SOMRecognizeHelper.this.mSOMRecognizeTasks.size());
                                SOMRecognizeHelper.this.handleRecognizeTaskEnd();
                            }
                            return;
                        }
                        synchronized (SOMRecognizeHelper.this.mRecognizeTaskMutex) {
                            NotesOrganizedDocumentEntity organizedDocumentEntity = SOMRecognizeUtil.getOrganizedDocumentEntity(recognizeTargetNoteData.getUuid());
                            SOMRecognizeTask sOMRecognizeTask = new SOMRecognizeTask(SOMRecognizeHelper.this.mSOMRecognizedTaskContract, "handleRecognizeTaskEndForRetry", true);
                            SOMRecognizeHelper.this.mSOMRecognizeTasks.put(str, sOMRecognizeTask);
                            sOMRecognizeTask.run(new Pair(recognizeTargetNoteData, organizedDocumentEntity));
                        }
                        if (TextUtils.isEmpty("")) {
                            return;
                        }
                        synchronized (SOMRecognizeHelper.this.mRecognizeTaskMutex) {
                            SOMRecognizeHelper.this.mSOMRecognizeTasks.remove(str);
                            MainLogger.m7259w(SOMRecognizeHelper.TAG, "onRetry, failed, , remained task count: " + SOMRecognizeHelper.this.mSOMRecognizeTasks.size());
                            SOMRecognizeHelper.this.handleRecognizeTaskEnd();
                        }
                        return;
                    } catch (InterruptedException e) {
                        String str2 = "InterruptedException: " + e.getMessage();
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        synchronized (SOMRecognizeHelper.this.mRecognizeTaskMutex) {
                            SOMRecognizeHelper.this.mSOMRecognizeTasks.remove(str);
                            MainLogger.m7259w(SOMRecognizeHelper.TAG, "onRetry, failed, " + str2 + ", remained task count: " + SOMRecognizeHelper.this.mSOMRecognizeTasks.size());
                            SOMRecognizeHelper.this.handleRecognizeTaskEnd();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    if (!TextUtils.isEmpty("")) {
                    }
                    throw th;
                }
                if (!TextUtils.isEmpty("")) {
                    synchronized (SOMRecognizeHelper.this.mRecognizeTaskMutex) {
                        SOMRecognizeHelper.this.mSOMRecognizeTasks.remove(str);
                        MainLogger.m7259w(SOMRecognizeHelper.TAG, "onRetry, failed, , remained task count: " + SOMRecognizeHelper.this.mSOMRecognizeTasks.size());
                        SOMRecognizeHelper.this.handleRecognizeTaskEnd();
                    }
                }
                throw th;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRecognizeTaskEndForSuccess(String str, long j, String str2) {
        synchronized (this.mRecognizeTaskMutex) {
            this.mRecognizedDataChangedCount++;
            this.mRecognizedModifiedTimes.put(str, Long.valueOf(j));
            this.mSOMRecognizeTasks.remove(str);
            MainLogger.m7259w(TAG, "handleRecognizeTaskEndForSuccess, msg: " + str2 + ", remainedTask: " + this.mSOMRecognizeTasks.size() + ", mRecognizedDataChangedCount: " + this.mRecognizedDataChangedCount);
            handleRecognizeTaskEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecognizeTaskExecutor() {
        Iterator<SOMRecognizeTask> it = this.mSOMRecognizeTasks.values().iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.mSOMRecognizeTasks.clear();
    }

    private boolean isLiveDataObserved() {
        LiveData<List<NotesOrganizedDocumentEntity>> liveData = this.mSOMCardLiveData;
        if (liveData != null) {
            return liveData.hasObservers();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSOMRecognizeTaskRunning() {
        boolean z;
        synchronized (this.mRecognizeTaskMutex) {
            z = !this.mSOMRecognizeTasks.isEmpty();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isScrolling() {
        return this.mViewParams.getNotesRecyclerView().getScrollState() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSOMRecognizeStateBegin() {
        removeFromNoteListHandler(this.mChangeProgressStateRunnable);
        runOnNoteListHandler(this.mChangeProgressStateRunnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSOMRecognizeStateChanged() {
        runOnNoteListHandler(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.15
            @Override // java.lang.Runnable
            public void run() {
                if (SOMRecognizeHelper.this.mContract == null) {
                    return;
                }
                SOMRecognizeHelper.this.mContract.onSOMRecognizeStateChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSOMRecognizeStateEnd() {
        removeFromNoteListHandler(this.mChangeIdleStateRunnable);
        runOnNoteListHandler(this.mChangeIdleStateRunnable, 1500L);
    }

    private void onSOMRecognizedCardShapeChanged() {
        SOMRecognizeListener sOMRecognizeListener = this.mContract;
        if (sOMRecognizeListener == null) {
            return;
        }
        sOMRecognizeListener.onSOMRecognizedCardShapeChanged();
    }

    private void onSOMRecognizedCardVisibilityChanged() {
        runOnNoteListHandler(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.14
            @Override // java.lang.Runnable
            public void run() {
                if (SOMRecognizeHelper.this.mDocumentMap.initCommonDisplayList() && SOMRecognizeHelper.this.mContract != null) {
                    SOMRecognizeHelper.this.mContract.onSOMRecognizedCardVisibilityChanged();
                }
                SOMRecognizeHelper.this.mViewParams.getNotesView().onDataChanged(SOMRecognizeHelper.this.mDocumentMap.getCommonDisplayListSize(new String[0]), "onSOMRecognizedCardVisibilityChanged");
            }
        });
    }

    private void onSOMRecognizedInfoChanged() {
        runOnNoteListHandler(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.16
            @Override // java.lang.Runnable
            public void run() {
                if (SOMRecognizeHelper.this.mContract == null) {
                    return;
                }
                SOMRecognizeHelper.this.mContract.onSOMRecognizedInfoChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerObserver() {
        if (!FeatureUtils.isSOMFeatureSupported() || isLiveDataObserved()) {
            return;
        }
        LiveData<List<NotesOrganizedDocumentEntity>> liveData = this.mSOMCardLiveData;
        if (liveData != null) {
            liveData.observe(this.mViewParams.getAbsFragment().getViewLifecycleOwner(), this.mSOMCardLiveDataObserver);
        }
        SharedPreferencesCompat.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromNoteListHandler(Runnable runnable) {
        if (this.mViewParams.getNotesRecyclerView() == null) {
            return;
        }
        this.mViewParams.getNotesRecyclerView().removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreNoteListPenMultiSelection() {
        if (this.mIsNoteListPenMultiSelectionEnabled == null) {
            return;
        }
        this.mViewParams.getNotesRecyclerView().seslSetPenSelectionEnabled(this.mIsNoteListPenMultiSelectionEnabled.booleanValue());
        this.mIsNoteListPenMultiSelectionEnabled = null;
    }

    private void runOnNoteListHandler(Runnable runnable) {
        runOnNoteListHandler(runnable, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runSOMRecognizedTask(final String str) {
        if (!FeatureUtils.isSOMFeatureSupported()) {
            BadgeHelper.setSOMFolderHasNewBadge(false, str + "(Feature is not Supported)");
            return;
        }
        if (DataToComposerManager.getInstance().getParseHyperTextContract() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(302);
        }
        if (this.mIsRunRecognizeTaskMethodLocked && !Constant.TASK_CALLER_DATA_CHANGED.equals(str)) {
            AbstractC8014b.m7209k("runSOMRecognizedTask, ignore, already running method, caller: ", str, TAG);
            return;
        }
        if (isSOMRecognizeTaskRunning()) {
            AbstractC8014b.m7209k("runSOMRecognizedTask, ignore, already running task, caller: ", str, TAG);
            return;
        }
        if (Constant.TASK_CALLER_DATA_CHANGED.equals(this.mLastCaller) && Constant.TASK_CALLER_CHECK_UNRECOGNIZED_COUNT.equals(str)) {
            MainLogger.m7258i(TAG, "runSOMRecognizedTask, ignore, last caller has higher priority, lastCaller: " + this.mLastCaller + ", caller: " + str);
            return;
        }
        this.mLastCaller = str;
        this.mIsRunRecognizeTaskMethodLocked = true;
        if (!getSOMRecognizedInfo().isEmpty()) {
            onSOMRecognizeStateEnd();
        }
        this.RECOGNIZE_EXECUTOR.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper.11
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Map<String, MainListDocumentData> recognizeTargetNoteData = SOMRecognizeUtil.getRecognizeTargetNoteData();
                if (recognizeTargetNoteData.isEmpty()) {
                    MainLogger.m7259w(SOMRecognizeHelper.TAG, "runSOMRecognizedTask, run, ignore, there is no note to be recognized, caller: " + str);
                    BadgeHelper.setSOMFolderHasNewBadge(false, "runSOMRecognizedTask(There is no targetNote)");
                    SOMRecognizeHelper.this.removeSOMRecognizedCard("runSOMRecognizedTask");
                    SOMRecognizeHelper.this.mIsRunRecognizeTaskMethodLocked = false;
                    return;
                }
                if (ComposerManager.getInstance().isRunningComposer() && Constant.TASK_CALLER_CHECK_UNRECOGNIZED_COUNT.equals(str)) {
                    MainLogger.m7258i(SOMRecognizeHelper.TAG, "runSOMRecognizedTask, ignore, running composer, caller: " + str);
                    SOMRecognizeHelper.this.mIsRunRecognizeTaskMethodLocked = false;
                    return;
                }
                MainLogger.m7258i(SOMRecognizeHelper.TAG, "runSOMRecognizedTask, run, caller: " + str);
                SOMRecognizeHelper.this.onSOMRecognizeStateBegin();
                SOMRecognizeHelper.this.setRecognizeDBVersion();
                synchronized (SOMRecognizeHelper.this.mRecognizeTaskMutex) {
                    try {
                        SOMRecognizeHelper.this.initRecognizeTaskExecutor();
                        SOMRecognizeHelper.this.mRecognizedModifiedTimes.clear();
                        SOMRecognizeHelper.this.mRecognizedDataChangedCount = 0;
                        List<NotesOrganizedDocumentEntity> organizedDocumentEntities = SOMRecognizeUtil.getOrganizedDocumentEntities(recognizeTargetNoteData.keySet());
                        HashMap map = new HashMap();
                        for (NotesOrganizedDocumentEntity notesOrganizedDocumentEntity : organizedDocumentEntities) {
                            map.put(notesOrganizedDocumentEntity.getUuid(), notesOrganizedDocumentEntity);
                        }
                        for (Map.Entry<String, MainListDocumentData> entry : recognizeTargetNoteData.entrySet()) {
                            String key = entry.getKey();
                            if (((SOMRecognizeTask) SOMRecognizeHelper.this.mSOMRecognizeTasks.get(key)) == null) {
                                SOMRecognizeTask sOMRecognizeTask = new SOMRecognizeTask(SOMRecognizeHelper.this.mSOMRecognizedTaskContract, str, false);
                                SOMRecognizeHelper.this.mSOMRecognizeTasks.put(key, sOMRecognizeTask);
                                sOMRecognizeTask.run(new Pair(entry.getValue(), (NotesOrganizedDocumentEntity) map.get(key)));
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!SOMRecognizeHelper.this.isSOMRecognizeTaskRunning()) {
                    SOMRecognizeHelper.this.handleOrganizedDocumentEntities(SOMRecognizeUtil.getOrganizedDocuments(), "runSOMRecognizedTask(recognize task is not running)");
                } else if (SOMRecognizeHelper.this.mHandleOrganizedDataPended) {
                    SOMRecognizeHelper.this.mHandleOrganizedDataPended = false;
                    SOMRecognizeHelper.this.handleOrganizedDocumentEntities(SOMRecognizeUtil.getOrganizedDocuments(), "runSOMRecognizedTask(need to handle pended action)");
                }
                SOMRecognizeHelper.this.mIsRunRecognizeTaskMethodLocked = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i) {
        this.mViewParams.getNotesRecyclerView().scrollToPosition(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecognizeDBVersion() throws Throwable {
        RecognitionUtil.setRecognizerDBVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSOMRecognizedCardShape(@NotesConstants.SOMRecognizedCardShape int i) {
        this.mStateInfo.setSOMRecognizedCardShape(i);
        onSOMRecognizedCardShapeChanged();
        if (i == 1) {
            BadgeHelper.setSOMFolderHasNewBadge(false, "setSOMRecognizedCardShape, expand");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterObserver() {
        if (FeatureUtils.isSOMFeatureSupported() && isLiveDataObserved()) {
            LiveData<List<NotesOrganizedDocumentEntity>> liveData = this.mSOMCardLiveData;
            if (liveData != null) {
                liveData.removeObserver(this.mSOMCardLiveDataObserver);
            }
            SharedPreferencesCompat.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
        }
    }

    public void checkSOMUnRecognizedCount() {
        if (!FeatureUtils.isSOMFeatureSupported()) {
            BadgeHelper.setSOMFolderHasNewBadge(false, "checkSOMUnRecognizedCount(Feature is not Supported)");
        } else {
            if (PostLaunchManager.getInstance().hasLogic(this.mViewParams.getAbsFragment().getPostLaunchToken(), 105) || FolderConstants.ScreenOffMemo.UUID.equals(this.mStateInfo.getFolderUuid())) {
                return;
            }
            removeFromNoteListHandler(this.mCheckSOMUnRecognizedCountRunnable);
            runOnNoteListHandler(this.mCheckSOMUnRecognizedCountRunnable, 2000L);
        }
    }

    public SOMRecognizedInfo findSOMRecognizedInfo(String str, String str2, String str3, String str4, long j) {
        synchronized (this.mRecognizeMutex) {
            try {
                for (SOMRecognizedInfo sOMRecognizedInfo : this.mSomRecognizedInfo) {
                    if (sOMRecognizedInfo != null && sOMRecognizedInfo.getUuid().equals(str) && sOMRecognizedInfo.getLastModifiedTime() == j && sOMRecognizedInfo.getRecognizedLanguage().equals(str3) && sOMRecognizedInfo.getRecognizerDBVersion().equals(str4) && sOMRecognizedInfo.getOriginalText().equals(str2)) {
                        return sOMRecognizedInfo;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getSOMRecognizedCardPosition() {
        if (!this.mDocumentMap.hasHolderInfo(2)) {
            return -1;
        }
        List<Common> commonDisplayList = this.mDocumentMap.getCommonDisplayList();
        int size = commonDisplayList.size();
        for (int i = 0; i < size; i++) {
            if (commonDisplayList.get(i).type == 262144) {
                return i;
            }
        }
        return -1;
    }

    public List<SOMRecognizedInfo> getSOMRecognizedInfo() {
        List<SOMRecognizedInfo> list;
        synchronized (this.mRecognizeMutex) {
            list = this.mSomRecognizedInfo;
        }
        return list;
    }

    public boolean isDataChangeNotifyPendingRequired() {
        if (!this.mViewParams.getAbsFragment().isVisible()) {
            MainLogger.m7254d(TAG, "isDataChangeNotifyPendingRequired, true, fragment is not visible");
            return true;
        }
        if (this.mStateInfo.isSOMRecognizedCardCollapsed()) {
            MainLogger.m7254d(TAG, "isDataChangeNotifyPendingRequired, true, som recognized card is collapsed");
            return true;
        }
        if (!isScrolling()) {
            return false;
        }
        MainLogger.m7254d(TAG, "isDataChangeNotifyPendingRequired, true, is scrolling now");
        return true;
    }

    public boolean isSOMRecognizedCardHolder(int i) {
        return this.mDocumentMap.getCommonDisplayList().get(i).type == 262144;
    }

    public boolean isUuidExistInSOMRecognizedInfo(String str) {
        synchronized (this.mRecognizeMutex) {
            try {
                if (this.mStateInfo.isSOMRecognizedCardCollapsed()) {
                    return false;
                }
                Iterator<SOMRecognizedInfo> it = this.mSomRecognizedInfo.iterator();
                while (it.hasNext()) {
                    if (it.next().getUuid().equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onDataChanged(String str) {
        AbstractC0000a.m25v("onDataChanged, caller: ", str, TAG);
        this.mHandler.removeCallbacks(this.mDataChangeRunnable);
        this.mHandler.postDelayed(this.mDataChangeRunnable, 1000L);
    }

    public void onFolderChanged(String str, String str2) {
        if (str.equals(str2)) {
            this.mLastCaller = "";
        } else {
            onDataChanged("onFolderChanged");
        }
    }

    public void onPostResume() {
        if (RecognitionUtil.isHWREnabled()) {
            runSOMRecognizedTask("onPostResume/RecognitionEnabled");
        } else {
            removeSOMRecognizedCard("onPostResume/RecognitionDisabled");
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        MainLogger.m7254d(TAG, "onRestoreInstanceState# ");
        updateSOMRecognizedInfo(bundle.getParcelableArrayList(NotesConstants.KEY_SOM_RECOGNIZED_INFOS));
        if (FolderConstants.ScreenOffMemo.UUID.equals(this.mStateInfo.getFolderUuid())) {
            synchronized (this.mRecognizeMutex) {
                synchronized (this.mRecognizeTaskMutex) {
                    try {
                        this.mDocumentMap.putHolderInfoMap(2, (this.mSomRecognizedInfo.isEmpty() && this.mSOMRecognizeTasks.isEmpty()) ? false : true);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public void onSOMRecognizedCardAttachedToWindow() {
        this.mViewParams.getNotesRecyclerView().addOnItemTouchListener(this.mNotePenRecyclerViewSimpleOnItemTouchListener);
    }

    public void onSOMRecognizedCardDetachedFromWindow() {
        restoreNoteListPenMultiSelection();
        this.mViewParams.getNotesRecyclerView().removeOnItemTouchListener(this.mNotePenRecyclerViewSimpleOnItemTouchListener);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        synchronized (this.mRecognizeMutex) {
            bundle.putParcelableArrayList(NotesConstants.KEY_SOM_RECOGNIZED_INFOS, (ArrayList) this.mSomRecognizedInfo);
        }
    }

    public void removeSOMRecognizedCard(String str) {
        if (!this.mDocumentMap.hasHolderInfo(2)) {
            AbstractC8014b.m7209k("removeSOMRecognizedCard, ignore, card already removed, caller: ", str, TAG);
            return;
        }
        setSOMRecognizedCardShape(0);
        this.mDocumentMap.putHolderInfoMap(2, false);
        onSOMRecognizedCardVisibilityChanged();
    }

    public void toggleSOMRecognizedCardExpandCollapseState() {
        boolean zIsSOMRecognizedCardCollapsed = this.mStateInfo.isSOMRecognizedCardCollapsed();
        if (zIsSOMRecognizedCardCollapsed) {
            registerObserver();
            if (this.mStateInfo.isSOMRecognitionStateProgressing()) {
                ToastHandler.show(this.mViewParams.getContext(), C8003R.string.som_recognized_card_expand_block_msg, 0);
                return;
            }
            setSOMRecognizedCardShape(1);
        } else {
            this.mSOMRecognizedCardCollapseRunnable.run();
        }
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_SCREEN_OFF_MEMO_FOLDER, NotesSAConstants.EVENT_SCREEN_OFF_MEMO_VIEW_RECENT_MEMOS_AS_TEXT_EXPAND_COLLAPSE, !zIsSOMRecognizedCardCollapsed ? 1 : 0);
        if (zIsSOMRecognizedCardCollapsed) {
            return;
        }
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_SCREEN_OFF_MEMO_FOLDER, NotesSAConstants.EVENT_SCREEN_OFF_MEMO_VIEW_RECENT_MEMOS_AS_TEXT_COUNT, getSOMRecognizedInfo().size());
    }

    public void updateSOMRecognizedInfo(List<SOMRecognizedInfo> list) {
        synchronized (this.mRecognizeMutex) {
            try {
                if (list == null) {
                    return;
                }
                this.mSomRecognizedInfo.clear();
                this.mSomRecognizedInfo.addAll(list);
                if (!DeviceInfo.isUserMode()) {
                    Iterator<SOMRecognizedInfo> it = list.iterator();
                    while (it.hasNext()) {
                        MainLogger.m7254d(TAG, "updateSOMRecognizedInfo, textInfo: " + MainLogger.getEncode(it.next().getTextInfo().toString()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnNoteListHandler(Runnable runnable, long j) {
        if (this.mViewParams.getNotesRecyclerView() == null) {
            return;
        }
        if (CommonUtils.isOnMainUIThread() && j == 0) {
            runnable.run();
        } else {
            this.mViewParams.getNotesRecyclerView().postDelayed(runnable, j);
        }
    }
}
