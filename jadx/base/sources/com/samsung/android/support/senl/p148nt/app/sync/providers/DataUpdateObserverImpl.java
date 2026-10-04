package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.RunnableC8013a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;
import com.samsung.android.support.senl.p148nt.app.trash.EmptyTrashNotifier;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.SearchUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.data.impl.repository.search.SemanticSearchRepositoryImpl;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.data.resolver.tag.OldHashtagResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DataUpdateObserverImpl implements DataUpdateManager.DataUpdateObserver {
    private static final long NOTIFICATION_DELAY_TO_SEARCH_ENGINE = 2000;
    private static final String TAG = "DataUpdateObserverImpl";
    private final Context mAppContext;
    private final BlockingQueue<Runnable> mEventQueue;
    private final ExecutorService mExecutor;
    private final Runnable mNotifyEventToSearchEngine;
    private final Handler mSearchEngineEventHandler;

    public DataUpdateObserverImpl(Context context) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.mEventQueue = linkedBlockingQueue;
        this.mExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, linkedBlockingQueue, new SenlThreadFactory(TAG));
        this.mSearchEngineEventHandler = new Handler();
        this.mAppContext = context;
        this.mNotifyEventToSearchEngine = new RunnableC8669a(this, 16);
    }

    private static boolean checkEvent(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOldNoteDeleted$4(List list) {
        if (NotesDataRepositoryFactory.newInstance(this.mAppContext).createNotesOldDocumentRepository().includeOldNotes(list)) {
            SettingsSearchIndexingManager.requestIndexing();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDataUpdated$0() {
        new EmptyTrashNotifier().execute(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDocumentLocked$1(Collection collection) {
        Logger.m11003i(TAG, "onDocumentLocked, in search result: " + collection.size());
        if (collection.isEmpty()) {
            return;
        }
        SemanticSearchRepositoryImpl.requestDelete(collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDocumentMovedToTrash$2(Collection collection) {
        Logger.m11003i(TAG, "onDocumentMovedToTrash, in search result: " + collection.size());
        if (collection.isEmpty()) {
            return;
        }
        SemanticSearchRepositoryImpl.requestDelete(collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDocumentUpdated$3(Collection collection) {
        Logger.m11003i(TAG, "onDocumentUpdated, in search result: " + collection.size());
        if (collection.isEmpty()) {
            return;
        }
        SemanticSearchRepositoryImpl.requestUpdate(collection);
    }

    private synchronized void notify(@NonNull Runnable runnable) {
        if (runnable == this.mNotifyEventToSearchEngine) {
            notifyToSearchEngine(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    private void notifyDocumentNotInUsed(@NonNull List<String> list) {
        NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentTagRepository().notifyTagBoardByUuid(list);
        WidgetBroadcast.sendDocumentDeletedBroadcast(this.mAppContext, list, BaseWidgetConstant.ACTION_WIDGET_LIST_SETTING_DELETE);
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEventToOtherApps() {
        this.mAppContext.getContentResolver().notifyChange(ExternalDataConstants.URI_MULTIPLE_DOCUMENTS_UPDATED.buildUpon().authority("com.samsung.android.app.notes").build(), null);
        Logger.m11003i(TAG, "notifyEventToOtherApps");
    }

    private void notifyOldNoteDeleted(@NonNull List<String> list) {
        notify(new RunnableC8515c(this, list, 13));
    }

    @SuppressLint({WarningType.NewApi})
    private void notifyToSearchEngine(@NonNull Runnable runnable) {
        if (Features.isSearchEngineConnected()) {
            if (this.mSearchEngineEventHandler.hasCallbacks(runnable)) {
                Logger.m10999d(TAG, "notifyToSearchEngine, skip");
            } else {
                this.mSearchEngineEventHandler.postDelayed(runnable, 2000L);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onDataUpdated(@DataBaseConstants.Source int i, @DataBaseConstants.EventType int i2) {
        if (checkEvent(i2, 1)) {
            notify(new RunnableC0284b(20));
        }
        if (checkEvent(i2, 2)) {
            notify(this.mNotifyEventToSearchEngine);
        }
        if (i == 1 || !checkEvent(i2, 3)) {
            return;
        }
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        Objects.requireNonNull(companion);
        notify(new RunnableC8669a(companion, 17));
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onDocumentDeleted(@NonNull List<String> list, @DataBaseConstants.DeletedBy int i) {
        SyncInfoDao syncInfoDao = NotesDatabaseManager.getInstance().getSyncInfoDao();
        Debugger.m8607d("SyncInfoRepository", "updateDeletedBy, uuids: " + list.size() + ", deletedBy: " + i);
        syncInfoDao.updateDeletedBy(list, i);
        notifyDocumentNotInUsed(list);
        notifyOldNoteDeleted(list);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onDocumentFileDeleted(@NonNull String str) {
        if (UUIDUtils.isCoeditUuid(str)) {
            CoeditCacheUtils.removeCoeditCache(this.mAppContext, str);
        }
        CollectTaskManager.getInstance().cancelCollect(new CollectParam.CollectParamBuilder().setActionType(ICollectParam.ActionType.CANCEL.getValue()).setCancelType(ICollectParam.CancelType.DELETE.getValue()).setUuid(str).build());
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onDocumentLocked(@NonNull Collection<String> collection) {
        Collection<String> documentUuidsInSearchResult = SearchUtils.getDocumentUuidsInSearchResult(collection);
        notify(new RunnableC8013a(documentUuidsInSearchResult, 3));
        if (collection.size() != documentUuidsInSearchResult.size()) {
            notify(this.mNotifyEventToSearchEngine);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onDocumentMovedToTrash(@NonNull Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (OldHashtagResolver.hashTagExists(arrayList)) {
            new NotesTagRepository(this.mAppContext).notifyTagBoard();
        }
        notifyDocumentNotInUsed(arrayList);
        Collection<String> documentUuidsInSearchResult = SearchUtils.getDocumentUuidsInSearchResult(collection);
        notify(new RunnableC8013a(documentUuidsInSearchResult, 1));
        if (collection.size() != documentUuidsInSearchResult.size()) {
            notify(this.mNotifyEventToSearchEngine);
        }
        notifyOldNoteDeleted(arrayList);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onDocumentUnlocked(@NonNull Collection<String> collection) {
        notify(this.mNotifyEventToSearchEngine);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onDocumentUpdated(@NonNull Collection<String> collection) {
        Collection<String> documentUuidsInSearchResult = SearchUtils.getDocumentUuidsInSearchResult(collection);
        notify(new RunnableC8013a(documentUuidsInSearchResult, 2));
        if (collection.size() != documentUuidsInSearchResult.size()) {
            notify(this.mNotifyEventToSearchEngine);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onFolderDeleted(@NonNull List<String> uuids, int i) {
        SyncFolderInfoDao syncFolderInfoDao = NotesDatabaseManager.getInstance().getSyncFolderInfoDao();
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Debugger.INSTANCE.m8619d("SyncFolderInfoRepository", AbstractC1038a.m1214o(uuids.size(), i, "updateDeletedBy, uuids: ", ", deletedBy: "));
        syncFolderInfoDao.updateDeletedBy(uuids, i);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onFolderUpdated() {
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onOldNoteRestored() {
        notify(new RunnableC0284b(19));
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onOldNoteSaved(@NotNull String str, @NotNull String str2) {
        notify(new RunnableC0284b(19));
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager.DataUpdateObserver
    public void onSearchDataCollected(@NonNull String str) {
    }
}
