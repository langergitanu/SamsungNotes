package com.samsung.android.spensdk.framework;

import android.graphics.Canvas;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface SPenRendererAdapterInterface {
    boolean callOnDraw(Canvas canvas);

    boolean callOnProcess(boolean z);

    void close();
}
