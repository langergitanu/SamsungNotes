package p014C3;

import android.graphics.Typeface;
import android.util.Pair;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.DispatchQueue;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$callback$1;
import androidx.room.TransactionExecutor;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.layout.SidecarWindowBackend;
import androidx.window.layout.WindowLayoutInfo;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.background.greedy.TimeLimiter;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter;
import com.samsung.android.app.sdk.deepsky.donation.ActionDonation;
import com.samsung.android.app.sdk.deepsky.donation.DonationImpl;
import com.samsung.android.app.sdk.deepsky.donation.WidgetContribution;
import com.samsung.android.app.sdk.deepsky.smartwidget.SmartWidgetImpl;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.impl.ContinuityAdapterImpl;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuityDiscoveryManagerImpl;
import com.samsung.android.mcf.continuity.impl.ContinuityServerSocket;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.mcf.continuity.impl.ContinuitySessionFileManagerImpl;
import com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdocx.SPDToSDocXConverterWrapper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteTask;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import p079T.AbstractC0299q;
import p084U0.C0312d;
import p086V.C0322h;

/* JADX INFO: renamed from: C3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0054a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f222a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f223b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f224c;

    public /* synthetic */ RunnableC0054a(Object obj, Object obj2, int i) {
        this.f222a = i;
        this.f223b = obj;
        this.f224c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f222a) {
            case 0:
                super/*com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl*/.onCopySelected((CharSequence) this.f224c);
                break;
            case 1:
                SPDToSDocXConverterWrapper.convert$lambda$1((SPDToSDocXConverterWrapper) this.f223b, (SpenWNote) this.f224c);
                break;
            case 2:
                DeleteTask.execute$lambda$0((DeleteTask) this.f223b, (Pair) this.f224c);
                break;
            case 3:
                WidgetSingleGlanceSettingPresenter.createCacheInfo$lambda$4((WidgetSingleGlanceSettingPresenter) this.f223b, (String) this.f224c);
                break;
            case 4:
                WidgetSettingPresenter.createCacheInfo$lambda$4((WidgetSettingPresenter) this.f223b, (String) this.f224c);
                break;
            case 5:
                C0312d c0312d = (C0312d) this.f223b;
                ArrayList arrayList = (ArrayList) this.f224c;
                while (true) {
                    try {
                        FolderManager.getInstance().insert(arrayList);
                    } catch (InvalidParentFolderException e) {
                        AbstractC0299q.m646q(C0312d.f795p, "insertToDatabase, e : " + e.getMessage());
                        InvalidParentFolderException.Info extraInfo = e.getExtraInfo();
                        NotesCategoryTreeEntity notesCategoryTreeEntityCreateRestoredFolder = C0322h.m670a().f829o.createRestoredFolder();
                        String sourceFolderUuid = extraInfo.getSourceFolderUuid();
                        String uuid = notesCategoryTreeEntityCreateRestoredFolder != null ? notesCategoryTreeEntityCreateRestoredFolder.getUuid() : PredefinedCategory.UNCATEGORIZED.getUuid();
                        c0312d.f796a.getApplicationContext();
                        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                        notesDatabaseManager.getSyncDocumentDao();
                        new SyncNoteDataRepository();
                        SoftParentFolderChecker softParentFolderChecker = new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                        long currentTime = TimeManager.getCurrentTime();
                        softParentFolderChecker.checkInvalidRelationShip(sourceFolderUuid, uuid);
                        syncCategoryTreeDao.updateParentFolder(sourceFolderUuid, uuid, currentTime, 1);
                        softParentFolderChecker.checkInvalidRelationShip(sourceFolderUuid, uuid);
                        syncCategoryTreeDao.deleteMovingCategory(sourceFolderUuid);
                        syncCategoryTreeDao.moveToParent(sourceFolderUuid, uuid);
                    }
                    break;
                }
                break;
            case 6:
                DonationImpl.donate$lambda$0((DonationImpl) this.f223b, (ActionDonation) this.f224c);
                break;
            case 7:
                SmartWidgetImpl.contribute$lambda$1((SmartWidgetImpl) this.f223b, (WidgetContribution) this.f224c);
                break;
            case 8:
                ((DataRepositoryScheduler.RequestBuilder) this.f223b).lambda$success$0(this.f224c);
                break;
            case 9:
                ((DataRepositoryScheduler.RequestBuilder) this.f223b).lambda$fail$1((Exception) this.f224c);
                break;
            case 10:
                ((ViewTransition) this.f223b).lambda$applyTransition$0((View[]) this.f224c);
                break;
            case 11:
                ((ResourcesCompat.FontCallback) this.f223b).lambda$callbackSuccessAsync$0((Typeface) this.f224c);
                break;
            case 12:
                DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1((DispatchQueue) this.f223b, (Runnable) this.f224c);
                break;
            case 13:
                MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0((MultiInstanceInvalidationClient) this.f223b, (String[]) this.f224c);
                break;
            case 14:
                TransactionExecutor.execute$lambda$1$lambda$0((Runnable) this.f223b, (TransactionExecutor) this.f224c);
                break;
            case 15:
                ExtensionEmbeddingBackend.SplitListenerWrapper.m22071accept$lambda1((ExtensionEmbeddingBackend.SplitListenerWrapper) this.f223b, (ArrayList) this.f224c);
                break;
            case 16:
                SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m22072accept$lambda0((SidecarWindowBackend.WindowLayoutChangeCallbackWrapper) this.f223b, (WindowLayoutInfo) this.f224c);
                break;
            case 17:
                ((WorkerWrapper) this.f223b).lambda$runWorker$0((ListenableFuture) this.f224c);
                break;
            case 18:
                TimeLimiter.track$lambda$0((TimeLimiter) this.f223b, (StartStopToken) this.f224c);
                break;
            case 19:
                ConstraintTracker._set_state_$lambda$4$lambda$3((List) this.f223b, (ConstraintTracker) this.f224c);
                break;
            case 20:
                ((WorkForegroundRunnable) this.f223b).lambda$run$0((SettableFuture) this.f224c);
                break;
            case 21:
                ((ContinuityAdapterImpl.ServiceConnectionC71851) this.f223b).lambda$onServiceDisconnected$1((ContinuityAdapter.ServiceStateListener) this.f224c);
                break;
            case 22:
                ((ContinuityConnection) this.f223b).lambda$setControlSocket$2((Socket) this.f224c);
                break;
            case 23:
                ((ContinuityDiscoveryManagerImpl) this.f223b).lambda$startDiscovery$0((ContinuityDiscoveryManager.DiscoveryListener) this.f224c);
                break;
            case 24:
                ((ContinuityServerSocket) this.f223b).lambda$accept$1((Consumer) this.f224c);
                break;
            case 25:
                ((ContinuitySession) this.f223b).lambda$registerMessageListener$10((ContinuityMessageManager.MessageListener) this.f224c);
                break;
            case 26:
                ((ContinuitySession.C71985) this.f223b).lambda$onDisconnected$0((String) this.f224c);
                break;
            case 27:
                ((ContinuitySessionFileManagerImpl) this.f223b).lambda$registerFileInfoListener$0((ContinuitySessionFileManager.FileInfoListener) this.f224c);
                break;
            case 28:
                ((ContinuitySessionManagerImpl) this.f223b).lambda$disconnect$4((String) this.f224c);
                break;
            default:
                ((ContinuitySessionManagerImpl) this.f223b).lambda$openSession$0((ContinuitySessionManager.SessionStatusListener) this.f224c);
                break;
        }
    }
}
