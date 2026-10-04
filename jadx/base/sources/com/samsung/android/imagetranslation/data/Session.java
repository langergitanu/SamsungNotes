package com.samsung.android.imagetranslation.data;

import android.content.Context;
import com.samsung.android.imagetranslation.LttEngineListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Session {
    private Context context;
    private boolean isInpainterModuleEnabled;
    private LttEngineListener lttEngineListener;

    public Session(Context context, LttEngineListener lttEngineListener) {
        this.isInpainterModuleEnabled = true;
        this.context = context;
        this.lttEngineListener = lttEngineListener;
    }

    public Context getContext() {
        return this.context;
    }

    public LttEngineListener getLttEngineListener() {
        return this.lttEngineListener;
    }

    public boolean isInpainterModuleEnabled() {
        return this.isInpainterModuleEnabled;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setInpainterModuleEnabled(boolean z) {
        this.isInpainterModuleEnabled = z;
    }

    public void setLttEngineListener(LttEngineListener lttEngineListener) {
        this.lttEngineListener = lttEngineListener;
    }

    public Session(Context context, LttEngineListener lttEngineListener, boolean z) {
        this.context = context;
        this.lttEngineListener = lttEngineListener;
        this.isInpainterModuleEnabled = z;
    }
}
