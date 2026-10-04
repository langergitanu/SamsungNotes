package com.samsung.android.support.senl.p148nt.model.restore.folder;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class RestoreFolderCreator {
    private static final String TAG = ModelLogger.createTag("RestoreFolderCreator");
    private final Context mAppContext;
    private final List<NotesCategoryTreeEntity> mCreatedEntities = new ArrayList();

    public RestoreFolderCreator(@NonNull Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    private void createOldRestoredFolder(DocumentCategoryTree documentCategoryTree) {
        if (documentCategoryTree.getFolderMap().get(CategoryConstants.OldRestored.UUID) == null) {
            String defaultFolderName = getDefaultFolderName(documentCategoryTree, CategoryConstants.OldRestored.UUID);
            if (TextUtils.isEmpty(defaultFolderName)) {
                return;
            }
            this.mCreatedEntities.add(makeFolderEntity(CategoryConstants.OldRestored.UUID, PredefinedCategory.OLD_NOTES.getUuid(), defaultFolderName, -1));
        }
    }

    private void createRestoredFolder(DocumentCategoryTree documentCategoryTree, String str) {
        if (documentCategoryTree.getFolderMap().get(str) == null) {
            String defaultFolderName = getDefaultFolderName(documentCategoryTree, CategoryConstants.Restored.UUID);
            if (TextUtils.isEmpty(defaultFolderName)) {
                return;
            }
            this.mCreatedEntities.add(makeFolderEntity(str, PredefinedCategory.UNCATEGORIZED.getUuid(), defaultFolderName, -1));
        }
    }

    private String getDefaultFolderName(DocumentCategoryTree documentCategoryTree, String str) {
        String string = this.mAppContext.getString(C11397R.string.restored_note_string);
        NotesFolder notesFolder = CategoryConstants.OldRestored.UUID.equals(str) ? documentCategoryTree.getFolderMap().get(PredefinedCategory.OLD_NOTES.getUuid()) : CategoryConstants.Restored.UUID.equals(str) ? documentCategoryTree.getFolderMap().get(PredefinedCategory.UNCATEGORIZED.getUuid()) : null;
        if (getNotesFolderFail(notesFolder)) {
            return null;
        }
        List<NotesFolder> children = notesFolder.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<NotesFolder> it = children.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDisplayName());
        }
        if (!arrayList.contains(string)) {
            return string;
        }
        int i = 1;
        while (true) {
            if (i > arrayList.size() + 1) {
                i = 0;
                break;
            }
            if (!arrayList.contains(this.mAppContext.getString(C11397R.string.default_restored_notes, Integer.valueOf(i)))) {
                break;
            }
            i++;
        }
        return this.mAppContext.getString(C11397R.string.default_restored_notes, Integer.valueOf(i));
    }

    private boolean getNotesFolderFail(NotesFolder notesFolder) {
        if (notesFolder != null) {
            return false;
        }
        DataLogger.m12303e(TAG, "getNotesFolderFail fail");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NotesCategoryTreeEntity lambda$createFolderByVersion$1() {
        DocumentCategoryTree allDocumentCategoryTree = FolderManager.getInstance().getAllDocumentCategoryTree(false);
        String restoredFolderUuidByVersion = getRestoredFolderUuidByVersion();
        createRestoredFolder(allDocumentCategoryTree, restoredFolderUuidByVersion);
        try {
            if (!this.mCreatedEntities.isEmpty()) {
                FolderManager.getInstance().insert(this.mCreatedEntities);
            }
        } catch (InvalidParentFolderException e) {
            DataLogger.m12303e(TAG, "createFolderByVersion, fail to insert, e : " + e.getMessage());
        }
        return FolderManager.getInstance().getCategoryEntity(restoredFolderUuidByVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$createFolders$0(boolean z, boolean z2) {
        DocumentCategoryTree allDocumentCategoryTree = FolderManager.getInstance().getAllDocumentCategoryTree(false);
        if (z) {
            createOldRestoredFolder(allDocumentCategoryTree);
        }
        if (z2) {
            createRestoredFolder(allDocumentCategoryTree, CategoryConstants.Restored.UUID);
        }
        if (this.mCreatedEntities.isEmpty()) {
            return null;
        }
        FolderManager.getInstance().insert(this.mCreatedEntities);
        return null;
    }

    private NotesCategoryTreeEntity makeFolderEntity(String str, String str2, String str3, int i) {
        NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(str, str2, str3, (String) null, (Integer) Integer.MAX_VALUE, 0);
        notesCategoryTreeEntity.setDisplayNameColor(i);
        return notesCategoryTreeEntity;
    }

    @Nullable
    public NotesCategoryTreeEntity createFolderByVersion() {
        return (NotesCategoryTreeEntity) FolderManager.getInstance().executeOperation(new CallableC11473c(this, 1));
    }

    public void createFolders(final boolean z, final boolean z2) {
        FolderManager.getInstance().executeOperation(new Callable() { // from class: com.samsung.android.support.senl.nt.model.restore.folder.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f7757a.lambda$createFolders$0(z2, z);
            }
        });
    }

    public String getRestoredFolderUuidByVersion() {
        PackageManagerCompat companion = PackageManagerCompat.INSTANCE.getInstance();
        Context context = this.mAppContext;
        String strValueOf = String.valueOf(companion.getVersionCode(context, context.getPackageName()));
        return AbstractC0541b.m773o("restored_", strValueOf.length() == 9 ? strValueOf.substring(0, 6) : "Unknown", CoverConstants.SEPARATOR);
    }
}
