package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.content.Context;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface TagDataSource extends Parcelable {
    List<TagData> cloneChangedSortedList();

    List<TagData> cloneOriginalSortedList();

    boolean isChanged();

    boolean save(@NonNull Context context, @NonNull String str);

    void setChangedSortedList(List<TagData> list);

    void setOriginalSortedList(List<TagData> list);
}
