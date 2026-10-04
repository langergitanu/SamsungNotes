package p004A2;

import androidx.compose.material.ripple.RippleHostView;
import androidx.compose.p109ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.p109ui.text.input.TextInputServiceAndroid;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.widget.NestedScrollView;
import androidx.room.InvalidationTracker;
import androidx.work.CoroutineWorker;
import androidx.work.multiprocess.RemoteCoroutineWorker;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter;
import com.samsung.android.mcf.continuity.common.NetworkUtil;
import com.samsung.android.mcf.continuity.impl.ContinuityDiscoveryManagerImpl;
import com.samsung.android.mcf.continuity.impl.ContinuityReceiveFile;
import com.samsung.android.mcf.continuity.impl.ContinuitySimpleMessageManagerImpl;
import com.samsung.android.support.senl.addons.brush.view.canvas.BrushCanvas;
import com.samsung.android.support.senl.p148nt.app.quicknote.QuickNoteTileService;
import com.samsung.android.support.senl.p148nt.app.settings.about.SetupWizardWelcomeActivity;
import com.samsung.android.support.senl.p148nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener.SimpleComposerPageActionListenerImpl;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p012C1.C0049e;
import p022E1.C0077c;
import p022E1.C0082h;
import p042J1.C0145c;
import p206n0.C13533a;

/* JADX INFO: renamed from: A2.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC0015b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f88a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f89b;

    public /* synthetic */ RunnableC0015b(Object obj, int i) {
        this.f88a = i;
        this.f89b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f88a) {
            case 0:
                BrushCanvas.setPaintingDoc$lambda$2$lambda$1((BrushCanvas) this.f89b);
                break;
            case 1:
                C0077c c0077c = ((C0049e) this.f89b).f205a;
                c0077c.f262e.getApplicationContext();
                NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                notesDatabaseManager.getSyncDocumentDao();
                new SyncNoteDataRepository();
                new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                List<String> uuidListByTrashedUnCategorized = syncCategoryTreeDao.getUuidListByTrashedUnCategorized();
                if (uuidListByTrashedUnCategorized != null && !uuidListByTrashedUnCategorized.isEmpty()) {
                    Debugger.m8615i("SyncFolder", "repairTrashedFolders() : " + uuidListByTrashedUnCategorized.size());
                    c0077c.f262e.getApplicationContext();
                    NotesDatabase notesDatabaseManager2 = NotesDatabaseManager.getInstance();
                    notesDatabaseManager2.getSyncCategoryTreeDao();
                    notesDatabaseManager2.getSyncDocumentDao();
                    new SyncNoteDataRepository();
                    new SoftParentFolderChecker(notesDatabaseManager2.getCategoryTreeClosureDao());
                    Iterator<String> it = uuidListByTrashedUnCategorized.iterator();
                    while (it.hasNext()) {
                        FolderManager.getInstance().restore(it.next());
                    }
                }
                C0145c.m304L("sync_v2_pref", "repairTrashedFolderAfterAppUpdate", true);
                break;
            case 2:
                C0077c c0077c2 = ((C0082h) this.f89b).f286b;
                c0077c2.f262e.getApplicationContext();
                NotesDatabase notesDatabaseManager3 = NotesDatabaseManager.getInstance();
                SyncCategoryTreeDao syncCategoryTreeDao2 = notesDatabaseManager3.getSyncCategoryTreeDao();
                notesDatabaseManager3.getSyncDocumentDao();
                new SyncNoteDataRepository();
                new SoftParentFolderChecker(notesDatabaseManager3.getCategoryTreeClosureDao());
                Collection<NotesFolder> collectionValues = new DocumentCategoryTree(syncCategoryTreeDao2.getAllNotesFoldersForSync()).getFolderMap().values();
                ArrayList arrayList = new ArrayList();
                for (NotesFolder notesFolder : collectionValues) {
                    if (notesFolder.getParentUuid() != null && !notesFolder.getParentUuid().equals("") && !notesFolder.getParentUuid().equals(PredefinedCategory.OLD_NOTES.getUuid())) {
                        arrayList.add(notesFolder.getUuid());
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((C13533a) c0077c2.f268k.f8772b).f9553b.updateIsDirty((String) it2.next(), 1);
                }
                break;
            case 3:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCoreTranslate*/.executeMenu();
                break;
            case 4:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPhotoEditor*/.executeMenu();
                break;
            case 5:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSaveToGallery*/.executeMenu();
                break;
            case 6:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuShare*/.executeMenu();
                break;
            case 7:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSupportedActivities*/.executeMenu();
                break;
            case 8:
                super/*com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarAiAssist*/.onClick();
                break;
            case 9:
                super/*com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarCustomToolbarSetting*/.onClick();
                break;
            case 10:
                super/*com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAi*/.onClicked();
                break;
            case 11:
                ((StorageErrorDialogActivity) this.f89b).finish();
                break;
            case 12:
                WidgetSettingPresenter.mCreatedCallback$lambda$1$lambda$0((WidgetSettingPresenter) this.f89b);
                break;
            case 13:
                ((QuickNoteTileService) this.f89b).lambda$onClick$0();
                break;
            case 14:
                ((SetupWizardWelcomeActivity) this.f89b).finishWithOk();
                break;
            case 15:
                SettingsGlobalSyncStatusHandler.initSyncStatusObserver$lambda$1$lambda$0((SettingsGlobalSyncStatusHandler) this.f89b);
                break;
            case 16:
                SimpleComposerPageActionListenerImpl.onLastPageChanged$lambda$1$lambda$0((SimpleComposerPageActionListenerImpl) this.f89b);
                break;
            case 17:
                NetworkUtil.lambda$closeSocket$0((Socket) this.f89b);
                break;
            case 18:
                RippleHostView.m16973setRippleState$lambda2((RippleHostView) this.f89b);
                break;
            case 19:
                AndroidContentCaptureManager.contentCaptureChangeChecker$lambda$0((AndroidContentCaptureManager) this.f89b);
                break;
            case 20:
                TextInputServiceAndroid.sendInputCommand$lambda$1((TextInputServiceAndroid) this.f89b);
                break;
            case 21:
                ((Carousel) this.f89b).lambda$updateItems$0();
                break;
            case 22:
                ((NestedScrollView) this.f89b).invalidate();
                break;
            case 23:
                ((InvalidationTracker) this.f89b).onAutoCloseCallback$room_runtime_release();
                break;
            case 24:
                CoroutineWorker._init_$lambda$0((CoroutineWorker) this.f89b);
                break;
            case 25:
                RemoteCoroutineWorker._init_$lambda$0((RemoteCoroutineWorker) this.f89b);
                break;
            case 26:
                ((ContinuityDiscoveryManagerImpl) this.f89b).lambda$stopDiscovery$1();
                break;
            case 27:
                ((ContinuityReceiveFile) this.f89b).lambda$read$3();
                break;
            case 28:
                ((ContinuitySimpleMessageManagerImpl) this.f89b).lambda$unregisterMessageListener$1();
                break;
            default:
                ((WorkInitializer) this.f89b).lambda$ensureContextsScheduled$1();
                break;
        }
    }
}
