package com.samsung.android.support.notes.bixby.bixby2.aid;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;", "T", "", "onPreExecuteRequest", "", "onRequestComplete", "results", "(Ljava/lang/Object;)V", "onError", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ActionResponseCallback<T> {
    void onError();

    void onPreExecuteRequest();

    void onRequestComplete(T results);
}
