package p188i3;

import android.content.Context;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.samsung.android.sdk.pen.view.gesture.detector.SpenMultipleTapDetector;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.ComposerSaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCutTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTBackground3;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.CompareManager;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.restore.search.RestoreTextService;
import java.io.File;
import java.io.IOException;
import kotlinx.coroutines.Job;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.p215ws.RealWebSocket;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableRunnable;
import p243u0.C14475e;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: i3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12034a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8814a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8815b;

    public /* synthetic */ RunnableC12034a(Object obj, int i) {
        this.f8814a = i;
        this.f8815b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8814a) {
            case 0:
                ComposerSaveModel.lambda$saveForOnlyHyperLink$0((NotesDocument) this.f8815b);
                return;
            case 1:
                RestoreTextService.onStartCommand$lambda$0((RestoreTextService) this.f8815b);
                return;
            case 2:
                ((SpenMultipleTapDetector) this.f8815b).mTapCount = 0;
                return;
            case 3:
                AiResultCutTask.runOnThread$lambda$0((AiResultCutTask) this.f8815b);
                return;
            case 4:
                ConstraintTrackingWorker.startWork$lambda$0((ConstraintTrackingWorker) this.f8815b);
                return;
            case 5:
                ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$1((Job) this.f8815b);
                return;
            case 6:
                ((RealConnectionPool) this.f8815b).lambda$new$0();
                return;
            case 7:
                ((RealWebSocket) this.f8815b).lambda$new$0();
                return;
            case 8:
                Functions.run((Functions.FailableRunnable) this.f8815b);
                return;
            case 9:
                ((TimedSemaphore) this.f8815b).endOfPeriod();
                return;
            case 10:
                Failable.run((FailableRunnable) this.f8815b);
                return;
            case 11:
                Context context = (Context) ((C14475e) this.f8815b).f4022a;
                ToastHandler.showDirectly(context, context.getResources().getString(C7943R.string.sync_now_network_error), 1);
                return;
            case 12:
                ((QTBackground3) this.f8815b).setVisibility(8);
                return;
            case 13:
                File[] fileArr = (File[]) this.f8815b;
                synchronized (AbstractC14517a.class) {
                    for (File file : fileArr) {
                        try {
                            FileUtils.deleteFile(file);
                        } catch (IOException e) {
                            Logger.m8698e("ImportCacheRepository", "trimCache, e: " + e.getMessage());
                        }
                    }
                    Logger.m8697d("ImportCacheRepository", "trimCache, deleted files: " + fileArr.length);
                    break;
                }
                return;
            case 14:
                ((CompareManager) this.f8815b).checkConflict();
                return;
            default:
                AbsInstanceModel.onDestroyView$lambda$0((AbsInstanceModel) this.f8815b);
                return;
        }
    }
}
