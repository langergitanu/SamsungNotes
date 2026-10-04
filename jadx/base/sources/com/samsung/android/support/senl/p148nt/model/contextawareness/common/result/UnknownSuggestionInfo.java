package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.content.Intent;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UnknownSuggestionInfo extends SuggestionInfo {
    public UnknownSuggestionInfo(SuggestionData suggestionData) {
        super(suggestionData);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public boolean isValidExecution() {
        return true;
    }

    public UnknownSuggestionInfo(Intent intent) {
        super(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public void setSuggestionInfo() {
    }
}
