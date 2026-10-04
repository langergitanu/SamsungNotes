package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.DeepSky;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.app.sdk.deepsky.suggestion.CapabilityEnum;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionParameterKey;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
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
public class RequestSuggestion extends DeepSkyTask {
    private static final String TAG = CALogger.createTag("RequestSuggestion");

    public RequestSuggestion(@NonNull ContextAwarenessParam contextAwarenessParam) {
        super(contextAwarenessParam);
    }

    @Override // java.lang.Runnable
    public void run() {
        SuggestionItem suggestionItem;
        DataLogger.m12302d(TAG, "run");
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessStarted();
        ContextAwarenessResult contextAwarenessResult = new ContextAwarenessResult();
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            CapabilityEnum capabilityEnum = CapabilityEnum.USER_CONTEXT_BASED_CONTENT;
            Bundle bundle = new Bundle();
            bundle.putString(SuggestionParameterKey.KNOWLEDGE, Constants.UserContextBasedContent.REQUEST_KNOWLEDGE);
            suggestionItem = DeepSky.with(applicationContext).getSuggestionRequest().requestSuggestion(capabilityEnum, bundle).getSuggestionItem();
        } catch (IndexOutOfBoundsException e) {
            e = e;
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.DRAW_SUGGESTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.DRAW_SUGGESTION_FAIL);
            DataLogger.m12303e(TAG, "run " + e.getMessage());
        } catch (NullPointerException e2) {
            e = e2;
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.DRAW_SUGGESTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.DRAW_SUGGESTION_FAIL);
            DataLogger.m12303e(TAG, "run " + e.getMessage());
        }
        if (!ContextAwarenessFeature.isSupportedDonationApp(suggestionItem)) {
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.DRAW_SUGGESTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.DRAW_SUGGESTION_FAIL);
            ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
        } else {
            contextAwarenessResult.setSuggestionItem(suggestionItem);
            IContextAwarenessResult.Request request = IContextAwarenessResult.Request.DRAW_SUGGESTION;
            contextAwarenessResult.makeSuggestionInfo(request);
            contextAwarenessResult.setRequest(request);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.DRAW_SUGGESTION_SUCCESS);
            ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
        }
    }
}
