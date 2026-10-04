package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionHandle;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListenerManager;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.ContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ExecuteAction extends DeepSkyTask {
    private static final String TAG = CALogger.createTag("ExecuteAction");

    public ExecuteAction(@NonNull ContextAwarenessParam contextAwarenessParam) {
        super(contextAwarenessParam);
    }

    @Override // java.lang.Runnable
    public void run() throws URISyntaxException {
        DataLogger.m12302d(TAG, "run");
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessStarted();
        ContextAwarenessResult contextAwarenessResult = new ContextAwarenessResult();
        try {
            SuggestionHandle.doAction(this.mParam.getActivity(), this.mParam.getSuggestionInfo().getSuggestionData());
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.EXECUTE_ACTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.EXECUTE_ACTION_SUCCESS);
        } catch (NullPointerException e) {
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.EXECUTE_ACTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.EXECUTE_ACTION_FAIL);
            DataLogger.m12303e(TAG, "run " + e.getMessage());
        }
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
    }
}
