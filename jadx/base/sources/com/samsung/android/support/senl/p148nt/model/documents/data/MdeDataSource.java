package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface MdeDataSource extends Parcelable {
    String getGroupId();

    String getOwnerId();

    String getSpaceId();

    void setGroupId(@NonNull String str);

    void setOwnerId(@NonNull String str);

    void setSpaceId(@NonNull String str);
}
