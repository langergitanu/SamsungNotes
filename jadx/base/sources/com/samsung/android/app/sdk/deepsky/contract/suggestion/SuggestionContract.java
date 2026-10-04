package com.samsung.android.app.sdk.deepsky.contract.suggestion;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionContract;", "", "()V", "EXTRA_ACTION_INTENT", "", "EXTRA_CONFIDENCE", "EXTRA_CONTEXT", "EXTRA_CONTEXT_CHANGED", "EXTRA_IS_MAIN_ACTION", "EXTRA_SUGGESTION_FROM", "EXTRA_SUGGESTION_PACKAGE", "TYPE_ACTION_PATTERN", "TYPE_ACTION_RULE", "TYPE_APP_PATTERN", "TYPE_APP_RULE", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SuggestionContract {

    @NotNull
    public static final String EXTRA_ACTION_INTENT = "extra_action_intent";

    @NotNull
    public static final String EXTRA_CONFIDENCE = "extra_confidence";

    @NotNull
    public static final String EXTRA_CONTEXT = "extra_context";

    @NotNull
    public static final String EXTRA_CONTEXT_CHANGED = "extra_context_changed";

    @NotNull
    public static final String EXTRA_IS_MAIN_ACTION = "extra_is_main_action";

    @NotNull
    public static final String EXTRA_SUGGESTION_FROM = "extra_suggestion_from";

    @NotNull
    public static final String EXTRA_SUGGESTION_PACKAGE = "extra_suggestion_package";

    @NotNull
    public static final SuggestionContract INSTANCE = new SuggestionContract();

    @NotNull
    public static final String TYPE_ACTION_PATTERN = "type_action_pattern";

    @NotNull
    public static final String TYPE_ACTION_RULE = "type_action_rule";

    @NotNull
    public static final String TYPE_APP_PATTERN = "type_app_pattern";

    @NotNull
    public static final String TYPE_APP_RULE = "type_app_rule";

    private SuggestionContract() {
    }
}
