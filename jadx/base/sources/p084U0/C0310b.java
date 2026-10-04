package p084U0;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: U0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0310b implements ImportBaseTask.Listener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0312d f794a;

    public C0310b(C0312d c0312d) {
        this.f794a = c0312d;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onDownloaded(DocTypeConstants docTypeConstants, ImportItem importItem, int i) {
        AbstractC0299q.m643n(C0312d.f795p, "onDownloaded, type : " + docTypeConstants);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onGetListEnded(DocTypeConstants docTypeConstants) {
        AbstractC0299q.m643n(C0312d.f795p, "onGetListEnded, type : " + docTypeConstants);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onImportEnded(DocTypeConstants docTypeConstants) {
        AbstractC0299q.m643n(C0312d.f795p, "onImportEnded, type : " + docTypeConstants);
        C0312d c0312d = this.f794a;
        c0312d.m667f(c0312d.f798c.size(), c0312d.f802g.get(), c0312d.f803h, c0312d.f801f.get());
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onImportError(DocTypeConstants docTypeConstants, int i, String str, Exception exc) {
        AbstractC0299q.m646q(C0312d.f795p, "onError, " + docTypeConstants + SQLKeyword.COMMA + str);
        this.f794a.m666e("", "", i, str);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onImportStart(DocTypeConstants docTypeConstants) {
        AbstractC0299q.m643n(C0312d.f795p, "onImportStart, type : " + docTypeConstants);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onItemImportFinished(DocTypeConstants docTypeConstants, int i, int i2, int i4) {
        AbstractC0299q.m643n(C0312d.f795p, "onItemImportFinished, type : " + docTypeConstants + " processedCount : " + i + " successListSize : " + i2 + " allListSize : " + i4);
        this.f794a.m668g(i, i4);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onUpdated(DocTypeConstants docTypeConstants, int i, int i2, ImportItem importItem) {
        AbstractC0299q.m643n(C0312d.f795p, "onUpdated, type : " + docTypeConstants + SQLKeyword.COMMA + i + " / " + i2);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public final void onImportEnded(DocTypeConstants docTypeConstants, List list) {
        AbstractC0299q.m643n(C0312d.f795p, "onImportEnded, type : " + docTypeConstants + ", count : " + list.size());
        int size = list.size();
        C0312d c0312d = this.f794a;
        c0312d.m667f(size, c0312d.f802g.get(), c0312d.f803h, c0312d.f801f.get());
    }
}
