package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.DeepSky;
import com.samsung.android.app.sdk.deepsky.suggestion.CapabilityEnum;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionParameterKey;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListenerManager;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.ContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SubscribeSuggestion extends DeepSkyTask {
    private static final String TAG = CALogger.createTag("SubscribeSuggestion");

    public SubscribeSuggestion(@NonNull ContextAwarenessParam contextAwarenessParam) {
        super(contextAwarenessParam);
    }

    @Override // java.lang.Runnable
    public void run() {
        DataLogger.m12302d(TAG, "run " + this.mParam.getSubscribeId());
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessStarted();
        ContextAwarenessResult contextAwarenessResult = new ContextAwarenessResult();
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            CapabilityEnum capabilityEnum = CapabilityEnum.USER_CONTEXT_BASED_CONTENT;
            Bundle bundle = new Bundle();
            bundle.putString(SuggestionParameterKey.KNOWLEDGE, Constants.UserContextBasedContent.REQUEST_KNOWLEDGE);
            DeepSky.with(BaseUtils.getApplicationContext()).getSuggestionRequest().subscribeSuggestion(this.mParam.getSubscribeId(), capabilityEnum, bundle, createPendingIntent(applicationContext));
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.SUBSCRIBE_SUGGESTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.SUBSCRIBE_SUGGESTION_SUCCESS);
        } catch (NullPointerException e) {
            contextAwarenessResult.setRequest(IContextAwarenessResult.Request.SUBSCRIBE_SUGGESTION);
            contextAwarenessResult.setResponse(IContextAwarenessResult.Response.SUBSCRIBE_SUGGESTION_FAIL);
            DataLogger.m12303e(TAG, "run " + e.getMessage());
        }
        ContextAwarenessListenerManager.getInstance().notifyContextAwarenessFinished(contextAwarenessResult);
    }
}
