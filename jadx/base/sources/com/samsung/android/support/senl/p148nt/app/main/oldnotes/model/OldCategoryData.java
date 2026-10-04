package com.samsung.android.support.senl.p148nt.app.main.oldnotes.model;

import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0007J\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u001a\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0015\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/model/OldCategoryData;", "", "notesCategoryTreeEntry", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entry/NotesDocumentCountEntry;", "<init>", "(Lcom/samsung/android/support/senl/nt/data/database/core/document/entry/NotesDocumentCountEntry;)V", "mHolderType", "", "mNotifyType", "getId", "getDisplayName", "", "getDisplayNameColor", "getCategoryUuid", "getDocumentCount", "setType", "", "holderType", "notifyType", "getHolderType", "getNotifyType", "equals", "", "obj", "hashCode", "component1", "copy", "toString", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class OldCategoryData {
    public static final int CATEGORY_COLOR_NONE = -1;
    private int mHolderType;
    private int mNotifyType;

    @Nullable
    private final NotesDocumentCountEntry notesCategoryTreeEntry;

    public OldCategoryData(@Nullable NotesDocumentCountEntry notesDocumentCountEntry) {
        this.notesCategoryTreeEntry = notesDocumentCountEntry;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final NotesDocumentCountEntry getNotesCategoryTreeEntry() {
        return this.notesCategoryTreeEntry;
    }

    public static /* synthetic */ OldCategoryData copy$default(OldCategoryData oldCategoryData, NotesDocumentCountEntry notesDocumentCountEntry, int i, Object obj) {
        if ((i & 1) != 0) {
            notesDocumentCountEntry = oldCategoryData.notesCategoryTreeEntry;
        }
        return oldCategoryData.copy(notesDocumentCountEntry);
    }

    public static /* synthetic */ void setType$default(OldCategoryData oldCategoryData, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        oldCategoryData.setType(i, i2);
    }

    @NotNull
    public final OldCategoryData copy(@Nullable NotesDocumentCountEntry notesCategoryTreeEntry) {
        return new OldCategoryData(notesCategoryTreeEntry);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof OldCategoryData)) {
            return false;
        }
        OldCategoryData oldCategoryData = (OldCategoryData) obj;
        if (Intrinsics.areEqual(oldCategoryData.getCategoryUuid(), getCategoryUuid()) && oldCategoryData.getDocumentCount() == getDocumentCount()) {
            return true;
        }
        return super.equals(obj);
    }

    @Nullable
    public final String getCategoryUuid() {
        NotesDocumentCountEntry notesDocumentCountEntry = this.notesCategoryTreeEntry;
        return notesDocumentCountEntry == null ? "" : notesDocumentCountEntry.getCategoryUuid();
    }

    @Nullable
    public final String getDisplayName() {
        NotesDocumentCountEntry notesDocumentCountEntry = this.notesCategoryTreeEntry;
        return notesDocumentCountEntry == null ? "" : notesDocumentCountEntry.getDisplayName();
    }

    public final int getDisplayNameColor() {
        NotesDocumentCountEntry notesDocumentCountEntry = this.notesCategoryTreeEntry;
        if (notesDocumentCountEntry == null) {
            return -1;
        }
        return notesDocumentCountEntry.getDisplayNameColor();
    }

    public final int getDocumentCount() {
        NotesDocumentCountEntry notesDocumentCountEntry = this.notesCategoryTreeEntry;
        if (notesDocumentCountEntry == null) {
            return 0;
        }
        return notesDocumentCountEntry.getDocumentCount();
    }

    /* JADX INFO: renamed from: getHolderType, reason: from getter */
    public final int getMHolderType() {
        return this.mHolderType;
    }

    public final int getId() {
        return hashCode();
    }

    /* JADX INFO: renamed from: getNotifyType, reason: from getter */
    public final int getMNotifyType() {
        return this.mNotifyType;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void setType(int holderType, int notifyType) {
        this.mHolderType = holderType;
        this.mNotifyType = notifyType;
    }

    @NotNull
    public String toString() {
        return "OldCategoryData(notesCategoryTreeEntry=" + this.notesCategoryTreeEntry + ")";
    }
}
