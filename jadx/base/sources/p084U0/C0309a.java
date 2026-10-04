package p084U0;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.migration.importer.task.ConvertLMemoTask;
import com.samsung.android.app.notes.sync.migration.importer.task.ConvertNMemoTask;
import com.samsung.android.app.notes.sync.migration.importer.task.ConvertQMemoTask;
import com.samsung.android.app.notes.sync.migration.importer.task.ConvertSNoteTask;
import com.samsung.android.app.notes.sync.migration.importer.task.ConvertTMemoTask;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.importer.utils.ImportUtils;
import java.util.ArrayList;
import java.util.List;
import p014C3.RunnableC0054a;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;
import p087V0.C0324b;

/* JADX INFO: renamed from: U0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0309a implements OnCompletionListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ boolean f792a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0312d f793b;

    public C0309a(C0312d c0312d, boolean z) {
        this.f793b = c0312d;
        this.f792a = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
    public final void onComplete(Object obj) {
        C0324b c0324b = (C0324b) obj;
        C0312d c0312d = this.f793b;
        Context context = c0312d.f796a;
        ArrayList<ImportItem> arrayList = c0312d.f798c;
        if (c0324b != null) {
            List<NotesFolder> list = c0324b.f836a;
            if (!list.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (NotesFolder notesFolder : list) {
                    AbstractC0299q.m643n(C0312d.f795p, "importCategory. name : " + Logger.getEncode(notesFolder.getDisplayName()) + ", uuid : " + notesFolder.getUuid() + ", parent : " + notesFolder.getParentUuid());
                    arrayList2.add(notesFolder);
                }
                if (!arrayList2.isEmpty()) {
                    FolderManager.getInstance().executeOperation(new RunnableC0054a(c0312d, arrayList2, 5));
                }
            }
        }
        if (arrayList.isEmpty()) {
            for (ImportDocument importDocument : c0312d.f797b) {
                String path = importDocument.getPath() == null ? "" : importDocument.getPath();
                C0312d.m662a(c0312d, TextUtils.isEmpty(importDocument.getUuid()) ? ImportUtils.createNewUuid(context, path) : importDocument.getUuid(), path, importDocument.getFolderUuid(), 0, null, this.f792a, importDocument.getTitle(), importDocument.getIsCoeditNote());
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (ImportItem importItem : arrayList) {
            String strM387b = AbstractC0155m.m387b(importItem.getLocalFullPath(), importItem.getTitle());
            if (importItem.getItemType() == 30) {
                C0312d.m662a(c0312d, UUIDUtils.newUUID(context), strM387b, "1", importItem.getDeleteType(), importItem, this.f792a, null, false);
            } else {
                arrayList3.add(importItem);
            }
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        C0310b c0310b = c0312d.f810o;
        AsyncTask convertNMemoTask = null;
        if (!arrayList3.isEmpty()) {
            int itemType = ((ImportItem) arrayList3.get(0)).getItemType();
            if (itemType == 11) {
                convertNMemoTask = new ConvertNMemoTask(c0312d.f796a, c0310b, 3, arrayList3, true);
            } else if (itemType == 13 || itemType == 20) {
                convertNMemoTask = new ConvertSNoteTask(c0312d.f796a, c0310b, 3, arrayList3, true);
            } else if (itemType == 32) {
                convertNMemoTask = new ConvertTMemoTask(c0312d.f796a, c0310b, 3, arrayList3, true);
            } else if (itemType == 35) {
                convertNMemoTask = new ConvertLMemoTask(c0312d.f796a, c0310b, 3, arrayList3, true);
            } else if (itemType == 36) {
                convertNMemoTask = new ConvertQMemoTask(c0312d.f796a, c0310b, 3, arrayList3, true);
            }
        }
        if (convertNMemoTask != null) {
            convertNMemoTask.executeOnExecutor(c0312d.m665d(), new Void[0]);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
    public final void onFail(Exception exc) {
        AbstractC6670b.m4762w(exc, new StringBuilder("onFail, e: "), C0312d.f795p);
        this.f793b.m666e("", "", 0, exc.getMessage());
    }
}
