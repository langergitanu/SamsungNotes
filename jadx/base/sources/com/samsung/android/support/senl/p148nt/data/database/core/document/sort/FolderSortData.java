package com.samsung.android.support.senl.p148nt.data.database.core.document.sort;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface FolderSortData {
    @NonNull
    List<? extends FolderSortData> getChildren();

    long getCreatedAt();

    String getDisplayName();

    int getDisplayNameColor();

    long getLastModifiedAt();

    long getRecycleBinTimeMoved();

    Integer getReorder();

    String getUuid();
}
