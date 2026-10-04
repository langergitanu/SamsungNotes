package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model;

import com.samsung.android.app.notes.sync.items.ImportItem;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u000eB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "Ljava/io/Serializable;", "type", "", "displayPath", "", "folderPath", "name", "item", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "modifiedTime", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/app/notes/sync/items/ImportItem;J)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "(ILcom/samsung/android/app/notes/sync/items/ImportItem;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getDisplayPath", "()Ljava/lang/String;", "getFolderPath", "getName", "getItem", "()Lcom/samsung/android/app/notes/sync/items/ImportItem;", "getModifiedTime", "()J", "isChecked", "", "()Z", "setChecked", "(Z)V", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportFolderInfo implements Serializable {
    private static final long serialVersionUID = 1;

    @Nullable
    private final String displayPath;

    @Nullable
    private final String folderPath;
    private boolean isChecked;

    @Nullable
    private final ImportItem item;
    private final long modifiedTime;

    @Nullable
    private final String name;
    private final int type;

    public ImportFolderInfo(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImportItem importItem, long j) {
        this.type = i;
        this.displayPath = str;
        this.folderPath = str2;
        this.name = str3;
        this.item = importItem;
        this.modifiedTime = j;
    }

    @Nullable
    public final String getDisplayPath() {
        return this.displayPath;
    }

    @Nullable
    public final String getFolderPath() {
        return this.folderPath;
    }

    @Nullable
    public final ImportItem getItem() {
        return this.item;
    }

    public final long getModifiedTime() {
        return this.modifiedTime;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public ImportFolderInfo(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, long j) {
        this(i, str, str2, str3, null, j);
    }

    public ImportFolderInfo(int i, @Nullable ImportItem importItem, @Nullable String str, @Nullable String str2) {
        this(i, str, null, str2, importItem, importItem != null ? importItem.getTimeStamp() : 0L);
    }
}
