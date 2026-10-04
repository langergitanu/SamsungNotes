package p093X;

import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import p234q1.C14433b;

/* JADX INFO: renamed from: X.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0336d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C14433b f855a;

    public RunnableC0336d(C14433b c14433b) {
        this.f855a = c14433b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PredefinedCategory predefinedCategory = PredefinedCategory.RECYCLE_BIN;
        String uuid = predefinedCategory.getUuid();
        C14433b c14433b = this.f855a;
        boolean zEquals = uuid.equals(((C0338f) c14433b.f10228b).f856a.getCategoryUuid());
        String absolutePath = CategoryConstants.OldUncategorized.PATH;
        if (zEquals) {
            ((C0338f) c14433b.f10228b).f856a.setAbsolutePath(CategoryConstants.OldUncategorized.PATH);
            return;
        }
        NotesFolder folder = FolderManager.getInstance().getAllDocumentCategoryTree(false).getFolder(((C0338f) c14433b.f10228b).f856a.getCategoryUuid());
        ((C0338f) c14433b.f10228b).f856a.setCategoryUuid(predefinedCategory.getUuid());
        NotesDocumentEntity notesDocumentEntity = ((C0338f) c14433b.f10228b).f856a;
        if (folder != null) {
            absolutePath = folder.getAbsolutePath();
        }
        notesDocumentEntity.setAbsolutePath(absolutePath);
    }
}
