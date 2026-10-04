package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.content.Intent;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IContextAwarenessResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Request {
        NONE,
        SUBSCRIBE_SUGGESTION,
        DRAW_SUGGESTION,
        EXECUTE_ACTION,
        ATTACH_CONTENT,
        UNSUBSCRIBE_SUGGESTION
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Response {
        NONE,
        SUBSCRIBE_SUGGESTION_SUCCESS,
        SUBSCRIBE_SUGGESTION_FAIL,
        DRAW_SUGGESTION_SUCCESS,
        DRAW_SUGGESTION_FAIL,
        EXECUTE_ACTION_SUCCESS,
        EXECUTE_ACTION_FAIL,
        ATTACH_CONTENT_SUCCESS,
        ATTACH_CONTENT_FAIL,
        UNSUBSCRIBE_SUGGESTION_SUCCESS,
        UNSUBSCRIBE_SUGGESTION_FAIL
    }

    Intent getDonatedAppIntent();

    Request getRequest();

    Response getResponse();

    List<SuggestionInfo> getSuggestionInfoList();

    SuggestionItem getSuggestionItem();

    boolean isResponseSuccess();

    void makeSuggestionInfo(Request request);

    void setDonatedAppIntent(Intent intent);

    void setRequest(Request request);

    void setResponse(Response response);

    void setSuggestionInfoList(List<SuggestionInfo> list);

    void setSuggestionItem(SuggestionItem suggestionItem);
}
