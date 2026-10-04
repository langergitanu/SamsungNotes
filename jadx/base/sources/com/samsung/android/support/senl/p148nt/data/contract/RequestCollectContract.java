package com.samsung.android.support.senl.p148nt.data.contract;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface RequestCollectContract {
    void cancelCollect();

    int getSourceType(@SearchConstants.Source int i);

    void pausePdfCollect(@NonNull Class<?> cls, @NonNull String str);

    void resumePdfCollect(@NonNull Class<?> cls, @NonNull String str);

    void startCollect(String str, String str2, long j, List<String> list, int i, boolean z);
}
