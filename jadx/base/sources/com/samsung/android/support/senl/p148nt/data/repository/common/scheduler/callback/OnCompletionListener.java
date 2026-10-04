package com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface OnCompletionListener<T> {
    void onComplete(@Nullable T t);

    void onFail(@NonNull Exception exc);
}
