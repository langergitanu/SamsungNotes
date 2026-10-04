package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WebPageSuggestionInfo extends SuggestionInfo {
    private String mUrl;

    public WebPageSuggestionInfo(SuggestionData suggestionData) {
        super(suggestionData);
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public boolean isValidExecution() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public void setSuggestionInfo() {
        this.mUrl = this.mIntent.getStringExtra("url");
    }

    @NonNull
    public String toString() {
        return "WebPageSuggestionInfo{mUrl='" + Logger.getEncode(this.mUrl) + "'}";
    }

    public WebPageSuggestionInfo(Intent intent) {
        super(intent);
    }
}
