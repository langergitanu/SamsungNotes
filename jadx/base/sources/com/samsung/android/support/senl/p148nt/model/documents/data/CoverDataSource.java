package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.content.Context;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface CoverDataSource extends Parcelable {
    String getBackgroundColor();

    String getCategoryUuid();

    long getCreatedAt();

    long getLastModifiedAt();

    int getState();

    String getSummary();

    String getTemplateUuid();

    String getTitle();

    boolean isChanged();

    boolean isEnabled();

    void save(@NonNull Context context, @NonNull String str);

    void setCoverData(String str, String str2, @CoverConstants.Template String str3, @CoverStickerConstants.Category String str4, @CoverConstants.Color String str5, int i, int i2, int i4, int i5, boolean z);

    void setEnable(boolean z);

    void setState(int i);

    void setTitle(String str);
}
