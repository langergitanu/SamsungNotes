package com.samsung.android.support.senl.p148nt.model.assist.llm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.support.senl.p145cm.base.framework.sem.support.GenieMemoryManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterSummary;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SummarizerOnDevice extends Summarizer {
    private int mContinuousListSize;
    private String mDetectedLanguage;

    @Nullable
    private GenieMemoryManager mMemManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SummaryType {
        NOTES,
        VOICE_RECORDER
    }

    public SummarizerOnDevice(String str, SummaryStyle summaryStyle, SummaryType summaryType) {
        super(str, summaryStyle);
        this.mMemManager = new GenieMemoryManager(BaseUtils.getApplicationContext(), summaryType == SummaryType.NOTES ? 1 : 2);
        changeResponseForOnDevice();
    }

    private void changeResponseForOnDevice() {
        this.mResponse = null;
        SCSTextResultListener.Callback callback = new SCSTextResultListener.Callback() { // from class: com.samsung.android.support.senl.nt.model.assist.llm.SummarizerOnDevice.1
            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str) {
                SummarizerOnDevice summarizerOnDevice = SummarizerOnDevice.this;
                if (summarizerOnDevice.mCallback == null) {
                    return true;
                }
                summarizerOnDevice.onPostExecute();
                SummarizerOnDevice.this.mCallback.onFailed(str);
                SummarizerOnDevice.this.loggingSafetyFilter(str);
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                SummarizerOnDevice summarizerOnDevice = SummarizerOnDevice.this;
                if (summarizerOnDevice.mCallback != null) {
                    summarizerOnDevice.onPostExecute();
                    String strPostProcessing = SummarizerOnDevice.this.postProcessing(str);
                    SummarizerOnDevice.this.mCallback.onSuccess(strPostProcessing, z);
                    SummarizerOnDevice summarizerOnDevice2 = SummarizerOnDevice.this;
                    summarizerOnDevice2.mImpl.saveToCache(summarizerOnDevice2.getCacheKey(), SummarizerOnDevice.this.mExecutedContent, strPostProcessing, z);
                }
            }
        };
        this.mResponse = callback;
        this.mImpl.setCallback(callback);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void onPostExecute() {
        GenieMemoryManager genieMemoryManager = this.mMemManager;
        if (genieMemoryManager != null) {
            genieMemoryManager.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer, com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void onPreExecute(String str) {
        GenieMemoryManager genieMemoryManager = this.mMemManager;
        if (genieMemoryManager != null) {
            genieMemoryManager.prepare();
        }
        super.onPreExecute(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer, com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(String str) {
        GenieMemoryManager genieMemoryManager = this.mMemManager;
        if (genieMemoryManager != null) {
            genieMemoryManager.request();
        }
        HashMap map = new HashMap();
        map.put("style", this.mSummaryStyle);
        map.put("summarize_subtask", this.mSummarizeSubTask);
        map.put("locale", AiLanguageHelper.getLocale(this.mDetectedLanguage));
        map.put(SCSRequesterSummary.OPTION_KEY_ON_DEVICE, AppInfo.RequestType.ONDEVICE);
        map.put(SCSRequesterSummary.OPTION_KEY_CONTINUOUS_NUMBER, Integer.valueOf(this.mContinuousListSize));
        this.mImpl.requestText(getRequestType(), map, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer, com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String postProcessing(String str) {
        return str.contains("।.") ? str.replace("।.", "।") : str;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer
    public void setContinuousListSize(int i) {
        this.mContinuousListSize = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer
    public void setDetectedLanguage(String str) {
        this.mDetectedLanguage = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer
    public void unloadModel() {
        this.mMemManager = null;
        this.mCallback = null;
        this.mResponse = null;
        SCSLLMRequesterImpl sCSLLMRequesterImpl = this.mImpl;
        if (sCSLLMRequesterImpl != null) {
            sCSLLMRequesterImpl.release(getRequestType());
        }
    }
}
