package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessResult implements IContextAwarenessResult {
    private static final String TAG = CALogger.createTag("ContextAwarenessResult");
    private Intent mDonatedAppIntent;
    private IContextAwarenessResult.Request mRequest;
    private IContextAwarenessResult.Response mResponse;
    private final List<SuggestionInfo> mSuggestionInfoList = new ArrayList();
    private SuggestionItem mSuggestionItem;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.contextawareness.common.result.ContextAwarenessResult$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114371 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$model$contextawareness$common$result$IContextAwarenessResult$Request */
        static final /* synthetic */ int[] f7699xa6a48947;

        static {
            int[] iArr = new int[IContextAwarenessResult.Request.values().length];
            f7699xa6a48947 = iArr;
            try {
                iArr[IContextAwarenessResult.Request.DRAW_SUGGESTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7699xa6a48947[IContextAwarenessResult.Request.ATTACH_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public Intent getDonatedAppIntent() {
        return this.mDonatedAppIntent;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public IContextAwarenessResult.Request getRequest() {
        return this.mRequest;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public IContextAwarenessResult.Response getResponse() {
        return this.mResponse;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public List<SuggestionInfo> getSuggestionInfoList() {
        return this.mSuggestionInfoList;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public SuggestionItem getSuggestionItem() {
        return this.mSuggestionItem;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public boolean isResponseSuccess() {
        IContextAwarenessResult.Response response = this.mResponse;
        return (response == null || response.ordinal() % 2 == 0) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public void makeSuggestionInfo(IContextAwarenessResult.Request request) {
        int i = C114371.f7699xa6a48947[request.ordinal()];
        if (i == 1) {
            setSuggestionInfoList(SuggestionInfoFactory.getInstance().makeSuggestionInfo(this.mSuggestionItem));
        } else if (i != 2) {
            DataLogger.m12302d(TAG, "makeSuggestionInfo invalid request");
        } else {
            setSuggestionInfoList(SuggestionInfoFactory.getInstance().makeSuggestionInfo(this.mDonatedAppIntent));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public void setDonatedAppIntent(Intent intent) {
        this.mDonatedAppIntent = intent;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public void setRequest(IContextAwarenessResult.Request request) {
        this.mRequest = request;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public void setResponse(IContextAwarenessResult.Response response) {
        this.mResponse = response;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public void setSuggestionInfoList(List<SuggestionInfo> list) {
        this.mSuggestionInfoList.clear();
        this.mSuggestionInfoList.addAll(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult
    public void setSuggestionItem(SuggestionItem suggestionItem) {
        this.mSuggestionItem = suggestionItem;
    }

    @NonNull
    public String toString() {
        return this.mSuggestionInfoList.toString();
    }
}
