package androidx.work.multiprocess;

import android.content.Context;
import android.view.View;
import androidx.arch.core.util.Function;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.app.trigger.task.TriggerListCreationTask;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.samsung.scsp.framework.core.util.NetworkUtil;
import com.vladsch.flexmark.util.format.MarkdownTable;
import com.vladsch.flexmark.util.format.TableRow;
import com.vladsch.flexmark.util.format.TableRowManipulator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: androidx.work.multiprocess.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C4148a implements RemoteDispatcher, AccessibilityViewCommand, TriggerListCreationTask.ICallback, NotesDocumentDeleteUtils.Callback, Function, TableRowManipulator, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1751a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f1752b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1753c;

    public /* synthetic */ C4148a(Object obj, int i, int i2) {
        this.f1751a = i2;
        this.f1753c = obj;
        this.f1752b = i;
    }

    @Override // com.vladsch.flexmark.util.format.TableRowManipulator
    public int apply(TableRow tableRow, int i, ArrayList arrayList, int i2) {
        return MarkdownTable.lambda$isEmptyColumn$6(this.f1752b, (boolean[]) this.f1753c, tableRow, i, arrayList, i2);
    }

    @Override // androidx.work.multiprocess.RemoteDispatcher
    public void execute(Object obj, IWorkManagerImplCallback iWorkManagerImplCallback) {
        ((RemoteListenableWorker) this.f1753c).lambda$onStopped$0(this.f1752b, (IListenableWorkerImpl) obj, iWorkManagerImplCallback);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f1751a) {
            case 7:
                return DeviceUtil.lambda$getSystemProperties$15((String) this.f1753c, this.f1752b);
            default:
                return NetworkUtil.lambda$isConnected$0((Context) this.f1753c, this.f1752b);
        }
    }

    @Override // com.samsung.android.support.senl.nt.model.utils.NotesDocumentDeleteUtils.Callback
    public void onDeleted(String str) {
        DummyDocumentDetector.lambda$deleteDummyFile$4((CountDownLatch) this.f1753c, this.f1752b, str);
    }

    @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerListCreationTask.ICallback
    public void onPostExecute(List list, List list2) {
        ((DocOpenTriggerActivity) this.f1753c).lambda$openDocument$1(this.f1752b, list, list2);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((SideSheetBehavior) this.f1753c).lambda$createAccessibilityViewCommandForState$2(this.f1752b, view, commandArguments);
    }

    public /* synthetic */ C4148a(boolean[] zArr, int i) {
        this.f1751a = 6;
        this.f1752b = i;
        this.f1753c = zArr;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public Object mo22196apply(Object obj) {
        switch (this.f1751a) {
            case 4:
                return ((SyncFolderInfoDao) this.f1753c).lambda$updateDeletedBy$0(this.f1752b, (List) obj);
            default:
                return ((SyncInfoDao) this.f1753c).lambda$updateDeletedBy$0(this.f1752b, (List) obj);
        }
    }
}
