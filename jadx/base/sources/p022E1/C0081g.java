package p022E1;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.model.helper.BaseDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: E1.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0081g implements BaseDocumentHelper.Listener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int[] f284a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CountDownLatch f285b;

    public C0081g(int[] iArr, CountDownLatch countDownLatch) {
        this.f284a = iArr;
        this.f285b = countDownLatch;
    }

    @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
    public final void onFailed(String str) {
        this.f284a[0] = 1;
        Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", "saveStrokeGroupSync() : onFailed() : uuid = " + str);
        this.f285b.countDown();
    }

    @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
    public final void onOpen(NotesDocument notesDocument, String str) {
        ((SpenWNote) notesDocument.getDoc()).setStrokeGroupSize(100);
        notesDocument.getDocumentRepository().addSaveStrategy(1024);
    }

    @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
    public final void onSave(NotesDocument notesDocument, String str) {
        this.f284a[0] = 0;
        Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "saveStrokeGroupSync() : onSave() : uuid = " + str);
        this.f285b.countDown();
    }
}
