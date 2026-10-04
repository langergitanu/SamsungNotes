package com.samsung.android.support.senl.p148nt.model.contextawareness;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ContextAwarenessListener {
    void onContextAwarenessFinished(@NonNull IContextAwarenessResult iContextAwarenessResult);

    void onContextAwarenessStarted();
}
