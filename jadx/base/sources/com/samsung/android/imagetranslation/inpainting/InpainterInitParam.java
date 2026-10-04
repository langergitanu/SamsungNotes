package com.samsung.android.imagetranslation.inpainting;

import android.content.Context;
import com.samsung.android.imagetranslation.TaskListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class InpainterInitParam {
    private final Context m_context;
    private final TaskListener m_taskListener;

    public InpainterInitParam(Context context, TaskListener taskListener) {
        this.m_context = context;
        this.m_taskListener = taskListener;
    }

    public Context getContext() {
        return this.m_context;
    }

    public TaskListener get_taskListener() {
        return this.m_taskListener;
    }
}
