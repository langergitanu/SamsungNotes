package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentIntentUtils;
import java.util.concurrent.ThreadPoolExecutor;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NotesWordDocumentService extends NotesDocumentService {
    private static final String TAG = ModelLogger.createTag("NotesWordDocumentService");
    private ActivityLifecycleTracker.ApplicationLifecycleCallback mApplicationLifeCycleCallback;
    private boolean mIsOnTaskRemoving;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.service.NotesWordDocumentService$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114904 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$model$executor$scheduler$SchedulerDataSource$WorkingState */
        static final /* synthetic */ int[] f7760xb4550142;

        static {
            int[] iArr = new int[SchedulerDataSource.WorkingState.values().length];
            f7760xb4550142 = iArr;
            try {
                iArr[SchedulerDataSource.WorkingState.SAVING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7760xb4550142[SchedulerDataSource.WorkingState.SAVING_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7760xb4550142[SchedulerDataSource.WorkingState.SNAP_SAVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7760xb4550142[SchedulerDataSource.WorkingState.LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7760xb4550142[SchedulerDataSource.WorkingState.LOADING_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7760xb4550142[SchedulerDataSource.WorkingState.RELOADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void dumpServiceWrapper() {
        synchronized (getServiceWrapperManager()) {
            DataLogger.m12309w(TAG, "dumpServiceWrapper, wrappers : " + getServiceWrapperManager());
        }
    }

    private String getNotificationText(@NonNull SchedulerDataSource.WorkingState workingState) {
        String string;
        switch (C114904.f7760xb4550142[workingState.ordinal()]) {
            case 1:
            case 2:
            case 3:
                string = getString(C11397R.string.document_service_notification_name_saving);
                break;
            case 4:
            case 5:
            case 6:
                string = getString(C11397R.string.document_service_notification_name);
                break;
            default:
                string = getString(C11397R.string.document_service_notification_name_closing);
                break;
        }
        DataLogger.m12302d(TAG, "getNotificationText, workingState : " + workingState + ", notificationText : " + string);
        return string;
    }

    private void removeCacheAndResave(Intent intent) {
        getNotesDocumentHandler().getDocumentIntentHandler().removeCacheAndResave(intent);
    }

    private void restoreCaches(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        final String string = extras != null ? extras.getString("folder_uuid") : "";
        getNotesDocumentHandler().getDocumentIntentHandler().restoreCaches(intent, new NotesDocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesWordDocumentService.3
            private void saveDocument(final NotesDocument<ISpenDocument> notesDocument) {
                NotesWordDocumentService.this.save(notesDocument, false, false, new NotesDocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesWordDocumentService.3.1
                    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
                    public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument2, @NonNull String str) {
                        AbstractC0000a.m2C("restore, saveCache, completed, uuid : ", str, NotesWordDocumentService.TAG);
                        NotesWordDocumentService.this.close(notesDocument2, null);
                        RestoreCacheManager.remove(str);
                    }

                    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
                    public void failed(Throwable th, String str) {
                        DataLogger.m12307i(NotesWordDocumentService.TAG, "restore, saveCache, failed, uuid : " + str + ", exc : " + th);
                        NotesWordDocumentService.this.close(notesDocument, null);
                        RestoreCacheManager.remove(str);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
            public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
                DataLogger.m12305f(NotesWordDocumentService.TAG, "restoreCaches, openCache, completed, uuid : " + str);
                if (notesDocument.getWritingMode() != 0) {
                    notesDocument.setDirty(true);
                    saveDocument(notesDocument);
                    return;
                }
                boolean zIsContentEmpty = notesDocument.isContentEmpty();
                DataLogger.m12302d(NotesWordDocumentService.TAG, "restoreCaches, isContentEmpty: " + zIsContentEmpty);
                if (zIsContentEmpty) {
                    NotesWordDocumentService.this.close(notesDocument, null);
                    RestoreCacheManager.remove(str);
                    return;
                }
                notesDocument.setDirty(true);
                if (!TextUtils.isEmpty(string)) {
                    notesDocument.getDocumentEntityContainer().getEntity().setCategoryUuid(string);
                }
                notesDocument.getDocumentRepository().addSaveStrategy(8);
                notesDocument.getDocumentRepository().addSaveStrategy(2048);
                notesDocument.getDocumentRepository().addSaveStrategy(8192);
                saveDocument(notesDocument);
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable th, String str) {
                DataLogger.m12307i(NotesWordDocumentService.TAG, "restoreCaches, openCache, failed, uuid : " + str + ", exc : " + th);
                RestoreCacheManager.remove(str);
            }
        }, extras != null ? (DocumentSubscriptionId) extras.getParcelable(DocumentServiceConstants.Extra.ARG_SUBSCRIPTION_ID) : null);
    }

    private void save(@NonNull Intent intent) {
        DataLogger.m12307i(TAG, "save#");
        getNotesDocumentHandler().getDocumentIntentHandler().save(intent, new MarkdownConverter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startForeground(@NonNull SchedulerDataSource.WorkingState workingState) {
        boolean zIsEmpty;
        synchronized (getServiceWrapperManager()) {
            zIsEmpty = getServiceWrapperManager().isEmpty();
        }
        int activityCount = ApplicationManager.getInstance().getActivityTracker().getActivityCount();
        boolean zIsApplicationInIdle = ApplicationManager.getInstance().getActivityTracker().isApplicationInIdle();
        DataLogger.m12302d(TAG, "startForeground, isEmpty : " + zIsEmpty + ", remains : " + activityCount + ", isApplicationInIdle : " + zIsApplicationInIdle);
        if (zIsApplicationInIdle) {
            ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.DOCUMENT_NOTIFICATION_CHANNEL_ID, getString(C11397R.string.document_service_notification_channel_name), getNotificationText(workingState), ServiceType.DEFAULT, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopForeground() {
        DataLogger.m12302d(TAG, "stopForeground");
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
    }

    @VisibleForTesting
    public ActivityLifecycleTracker.ApplicationLifecycleCallback getApplicationLifeCycleCallback() {
        return this.mApplicationLifeCycleCallback;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.NotesDocumentService
    public void handleStartCommand(Intent intent, int i, int i2) {
        if (intent == null || intent.getAction() == null) {
            DataLogger.m12302d(TAG, "handleStartCommand, not exist intent : " + intent);
            stopSelfIfNoLongerUsed();
            return;
        }
        startForeground(getNotesDocumentHandler().getState());
        String action = intent.getAction();
        String str = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("handleStartCommand, intent action: ", action, ", caller : ");
        sbM15l.append(NotesDocumentIntentUtils.getIntentCaller(intent));
        DataLogger.m12302d(str, sbM15l.toString());
        action.getClass();
        switch (action) {
            case "ACTION_RESTORE_CACHE":
                restoreCaches(intent);
                break;
            case "ACTION_SAVE_BY_TITLE_BODY":
                save(intent);
                break;
            case "ACTION_REMOVE_CACHE_AND_RESAVE":
                removeCacheAndResave(intent);
                break;
        }
        stopSelfIfNoLongerUsed();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.NotesDocumentService, android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        DocumentCacheUtils.stopTrimCache(this.mContext);
        return super.onBind(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.NotesDocumentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ActivityLifecycleTracker activityTracker = ApplicationManager.getInstance().getActivityTracker();
        ActivityLifecycleTracker.ApplicationLifecycleCallback applicationLifecycleCallback = new ActivityLifecycleTracker.ApplicationLifecycleCallback() { // from class: com.samsung.android.support.senl.nt.model.service.NotesWordDocumentService.1
            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
            public void onApplicationBackground() {
                DataLogger.m12309w(NotesWordDocumentService.TAG, "onApplicationBackground, activity count : " + ApplicationManager.getInstance().getActivityTracker().getActivityCount());
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
            public void onApplicationForeground() {
                DataLogger.m12309w(NotesWordDocumentService.TAG, "onApplicationForeground, activity count : " + ApplicationManager.getInstance().getActivityTracker().getActivityCount());
                NotesWordDocumentService.this.stopForeground();
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
            public void onApplicationIdle() {
                DataLogger.m12309w(NotesWordDocumentService.TAG, "onApplicationIdle, activity count : " + ApplicationManager.getInstance().getActivityTracker().getActivityCount());
                NotesWordDocumentService notesWordDocumentService = NotesWordDocumentService.this;
                notesWordDocumentService.startForeground(notesWordDocumentService.getNotesDocumentHandler().getState());
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
            public void onApplicationCreated() {
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
            public void onApplicationRunningCritical() {
            }
        };
        this.mApplicationLifeCycleCallback = applicationLifecycleCallback;
        activityTracker.addOnApplicationLifecycleCallback(applicationLifecycleCallback);
        getNotesDocumentHandler().setOnDocumentHandlerStateListener(new SchedulerDataSource.OnWorkingStateListener() { // from class: com.samsung.android.support.senl.nt.model.service.NotesWordDocumentService.2
            @Override // com.samsung.android.support.senl.nt.model.executor.scheduler.SchedulerDataSource.OnWorkingStateListener
            public void onState(@Nullable ThreadPoolExecutor threadPoolExecutor, @NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
                boolean zIsApplicationInIdle = ApplicationManager.getInstance().getActivityTracker().isApplicationInIdle();
                DataLogger.m12302d(NotesWordDocumentService.TAG, "setOnDocumentHandlerStateListener - onState, isApplicationInIdle : " + zIsApplicationInIdle + ", uuid : " + str + ", state : " + workingState + ", owner : " + documentSubscriptionId);
                if (zIsApplicationInIdle) {
                    NotesWordDocumentService.this.startForeground(workingState);
                }
            }
        });
        startForeground(getNotesDocumentHandler().getState());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.NotesDocumentService, android.app.Service
    public void onDestroy() {
        dumpServiceWrapper();
        super.onDestroy();
        stopForeground();
        ApplicationManager.getInstance().getActivityTracker().removeOnApplicationLifecycleCallback(this.mApplicationLifeCycleCallback);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.NotesDocumentService
    public void onSubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper) {
        super.onSubscribed(iDocumentServiceWrapper);
        dumpServiceWrapper();
        maintainConnection(true, getClass());
        try {
            startService(new Intent(getContext(), (Class<?>) NotesWordDocumentService.class));
        } catch (IllegalStateException e) {
            DataLogger.m12303e(TAG, "onSubscribed, wrapper : " + iDocumentServiceWrapper + ", e : " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.NotesDocumentService, android.app.Service
    public void onTaskRemoved(Intent intent) {
        int activityCount = ApplicationManager.getInstance().getActivityTracker().getActivityCount();
        String str = TAG;
        DataLogger.m12307i(str, "onTaskRemoved, call stopRecording, rootIntent: " + intent + ", activity count : " + activityCount);
        PostLaunchManager.getInstance().executeBaseLogic(1);
        if (activityCount > 0 || this.mIsOnTaskRemoving) {
            AbstractC11014a.m12340y(AbstractC0541b.m778t(activityCount, "onTaskRemoved, activity count : ", ", isOnTaskRemoving : "), this.mIsOnTaskRemoving, str);
            return;
        }
        this.mIsOnTaskRemoving = true;
        super.onTaskRemoved(intent);
        stopForeground();
        DataLogger.m12307i(str, "onTaskRemoved, done");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.NotesDocumentService
    public void onUnsubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper) {
        dumpServiceWrapper();
        maintainConnection(false, getClass());
        stopSelfIfNoLongerUsed();
    }
}
