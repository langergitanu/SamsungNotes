package com.samsung.android.support.senl.p148nt.data.database.core.document.folder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesFolder extends NotesCategoryTreeEntity {

    @Ignore
    private final List<NotesFolder> children;

    @ColumnInfo(name = DBSchema.CategoryTreeClosure.DEPTH)
    private int depth;

    @ColumnInfo(name = DBSchema.CategoryTreeClosure.DOCUMENT_COUNT)
    private int documentCount;

    @Ignore
    private boolean expanded;

    /* JADX INFO: renamed from: id */
    @Ignore
    private long f7401id;

    @Ignore
    private NotesFolder parent;

    @Ignore
    private int viewType;

    public NotesFolder(@NonNull String str, String str2, @NonNull String str3, @Nullable String str4) {
        super(str, str2, str3, str4);
        this.children = new ArrayList();
        this.f7401id = str.hashCode();
    }

    public void addChild(NotesFolder notesFolder) {
        this.children.add(notesFolder);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotesFolder) {
            NotesFolder notesFolder = (NotesFolder) obj;
            if (this.f7401id == notesFolder.f7401id && this.viewType == notesFolder.viewType && this.expanded == notesFolder.expanded && this.depth == notesFolder.depth && this.documentCount == notesFolder.documentCount) {
                NotesCategoryTreeEntity notesCategoryTreeEntity = (NotesCategoryTreeEntity) obj;
                if (Objects.equals(getUuid(), notesCategoryTreeEntity.getUuid()) && Objects.equals(getParentUuid(), notesCategoryTreeEntity.getParentUuid()) && Objects.equals(getDisplayName(), notesCategoryTreeEntity.getDisplayName()) && Objects.equals(getReorder(), notesCategoryTreeEntity.getReorder()) && getDisplayNameColor() == notesCategoryTreeEntity.getDisplayNameColor() && isSyncWithMS() == notesCategoryTreeEntity.isSyncWithMS()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity, com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    @NonNull
    public List<NotesFolder> getChildren() {
        return this.children;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getDocumentCount() {
        return this.documentCount;
    }

    public long getId() {
        return this.f7401id;
    }

    public NotesFolder getParent() {
        return this.parent;
    }

    public int getViewType() {
        return this.viewType;
    }

    public boolean hasChild() {
        return this.children.size() > 0;
    }

    public boolean hasParent() {
        return (getParent() == null && TextUtils.isEmpty(getParentUuid())) ? false : true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity
    public boolean isRootCategory() {
        return !hasParent() && getDepth() <= 0;
    }

    public void setDepth(int i) {
        this.depth = i;
    }

    public void setDocumentCount(int i) {
        this.documentCount = i;
    }

    public void setExpanded(boolean z) {
        this.expanded = z;
    }

    public void setId(long j) {
        this.f7401id = j;
    }

    public void setParent(NotesFolder notesFolder) {
        this.parent = notesFolder;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }
}
