package com.samsung.android.support.senl.p148nt.model.documents.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ISpenDocument {
    void clearChangedPageIdList();

    void close(boolean z);

    ArrayList<String> getChangedPageIdList();

    long getCreatedTime();

    List<String> getInvalidPageIds(List<String> list);

    long getModifiedTime();

    String getOwnerId();

    StorageInfo getStorageSize();

    @NonNull
    String getStringBodyText();

    String getTitleText();

    boolean hasSnapSavedData();

    void insertBody(String str);

    void insertTitle(String str);

    void invertBackgroundColor(boolean z);

    boolean isChangedOnlyThumbnail();

    boolean isClosed();

    boolean isContentChanged();

    boolean isContentEmpty();

    boolean isLocked();

    boolean isSaveCache();

    void quickSave(String str);

    void reload();

    void save(@NonNull String str);

    void setAllPageIdList();

    void setBackgroundColor(int i, boolean z);

    void setChangedPageIdList();

    void setPDFReaderMode(boolean z);

    void setSaveCache(boolean z);

    void snapSave(String str, boolean z);
}
