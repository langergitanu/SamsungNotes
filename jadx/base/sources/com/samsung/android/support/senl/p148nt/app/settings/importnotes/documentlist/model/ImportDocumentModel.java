package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.model;

import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/model/ImportDocumentModel;", "", "<init>", "()V", "importItem", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "getImportItem", "()Lcom/samsung/android/app/notes/sync/items/ImportItem;", "setImportItem", "(Lcom/samsung/android/app/notes/sync/items/ImportItem;)V", "memoMetaDataItem", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "getMemoMetaDataItem", "()Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "setMemoMetaDataItem", "(Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;)V", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "dataType", "", "getDataType", "()I", "setDataType", "(I)V", "isChecked", "", "()Z", "setChecked", "(Z)V", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportDocumentModel {

    @Nullable
    private String category;
    private int dataType = 1;

    @Nullable
    private ImportItem importItem;
    private boolean isChecked;

    @Nullable
    private MemoMetaDataItem memoMetaDataItem;

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    public final int getDataType() {
        return this.dataType;
    }

    @Nullable
    public final ImportItem getImportItem() {
        return this.importItem;
    }

    @Nullable
    public final MemoMetaDataItem getMemoMetaDataItem() {
        return this.memoMetaDataItem;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void setCategory(@Nullable String str) {
        this.category = str;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setDataType(int i) {
        this.dataType = i;
    }

    public final void setImportItem(@Nullable ImportItem importItem) {
        this.importItem = importItem;
    }

    public final void setMemoMetaDataItem(@Nullable MemoMetaDataItem memoMetaDataItem) {
        this.memoMetaDataItem = memoMetaDataItem;
    }
}
