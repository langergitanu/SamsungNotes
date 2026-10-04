package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListenerManager;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.ContextAwarenessFeature;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.ContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DrawSuggestion extends DeepSkyTask {
    private static final String TAG = CALogger.createTag("DrawSuggestion");

    public DrawSuggestion(@NonNull ContextAwarenessParam contextAwarenessParam) {
        super(contextAwarenessParam);
    }

    @Override // java.lang.Runnable
    public void run() {
        SuggestionItem suggestionItem;
        String str = TAG;
        DataLogger.m12302d(str, "run");
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessStarted();
        ContextAwarenessResult contextAwarenessResult = new ContextAwarenessResult();
        try {
            suggestionItem = (SuggestionItem) this.mParam.getIntent().getBundleExtra(Constants.UserContextBasedContent.RESPONSE_BUNDLE_EXTRA_SUGGESTIONS).getParcelable(Constants.UserContextBasedContent.RESPONSE_BUNDLE_EXTRA_SUGGESTIONS);
        } catch (NullPointerException e) {
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.DRAW_SUGGESTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.DRAW_SUGGESTION_FAIL);
            DataLogger.m12303e(TAG, "run " + e.getMessage());
        }
        if (suggestionItem.getValid() && ContextAwarenessFeature.isSupportedDonationApp(suggestionItem)) {
            contextAwarenessResult.setSuggestionItem(suggestionItem);
            IContextAwarenessResult.Request request = IContextAwarenessResult.Request.DRAW_SUGGESTION;
            contextAwarenessResult.makeSuggestionInfo(request);
            contextAwarenessResult.setRequest(request);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.DRAW_SUGGESTION_SUCCESS);
            ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
            return;
        }
        DataLogger.m12302d(str, "run not valid");
        contextAwarenessResult.setRequest(IContextAwarenessResult.Request.DRAW_SUGGESTION);
        contextAwarenessResult.setResponse(IContextAwarenessResult.Response.DRAW_SUGGESTION_FAIL);
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
    }
}
