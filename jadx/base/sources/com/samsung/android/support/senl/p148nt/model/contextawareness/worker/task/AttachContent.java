package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListenerManager;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.ContextAwarenessFeature;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.ContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AttachContent extends DeepSkyTask {
    private static final String TAG = CALogger.createTag("AttachContent");

    public AttachContent(@NonNull ContextAwarenessParam contextAwarenessParam) {
        super(contextAwarenessParam);
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent;
        DataLogger.m12302d(TAG, "run");
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessStarted();
        ContextAwarenessResult contextAwarenessResult = new ContextAwarenessResult();
        try {
            intent = this.mParam.getIntent();
        } catch (NullPointerException e) {
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.ATTACH_CONTENT);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.ATTACH_CONTENT_FAIL);
            DataLogger.m12303e(TAG, "run " + e.getMessage());
        }
        if (!ContextAwarenessFeature.isSupportedDonationApp(intent)) {
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.ATTACH_CONTENT_FAIL);
            ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
            return;
        }
        contextAwarenessResult.setDonatedAppIntent(intent);
        IContextAwarenessResult.Request request = IContextAwarenessResult.Request.ATTACH_CONTENT;
        contextAwarenessResult.makeSuggestionInfo(request);
        contextAwarenessResult.setRequest(request);
        contextAwarenessResult.setResponse(IContextAwarenessResult.Response.ATTACH_CONTENT_SUCCESS);
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
    }
}
