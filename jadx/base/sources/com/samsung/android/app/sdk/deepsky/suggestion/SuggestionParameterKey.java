package com.samsung.android.app.sdk.deepsky.suggestion;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionParameterKey;", "", "()V", "CANDIDATE_ACTION_LIST", "", "CONDITION_AND", "CONTEXT_FILTER_LIST", "IMAGE_OBJECT", "IMAGE_URI", "KNOWLEDGE", "OCR_RESULT", CredentialProviderBaseController.REQUEST_TAG, "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SuggestionParameterKey {

    @NotNull
    public static final String CANDIDATE_ACTION_LIST = "candidate_action_list";

    @NotNull
    public static final String CONDITION_AND = "condition_and";

    @NotNull
    public static final String CONTEXT_FILTER_LIST = "context_filter_list";

    @NotNull
    public static final String IMAGE_OBJECT = "suggestion_image_object";

    @NotNull
    public static final String IMAGE_URI = "image_uri";

    @NotNull
    public static final SuggestionParameterKey INSTANCE = new SuggestionParameterKey();

    @NotNull
    public static final String KNOWLEDGE = "knowledge";

    @NotNull
    public static final String OCR_RESULT = "ocr_result";

    @NotNull
    public static final String REQUEST_TYPE = "request_type";

    private SuggestionParameterKey() {
    }
}
