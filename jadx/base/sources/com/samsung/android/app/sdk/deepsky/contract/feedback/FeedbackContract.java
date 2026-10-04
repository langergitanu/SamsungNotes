package com.samsung.android.app.sdk.deepsky.contract.feedback;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/feedback/FeedbackContract;", "", "()V", "AUTHORITY", "", "CONTENT_URI", "Landroid/net/Uri;", "getCONTENT_URI", "()Landroid/net/Uri;", "KEY_FEEDBACK_RESULT", "KEY_FEEDBACK_TYPE", "KEY_STACK_ID", "KEY_SUGGESTION_ID", "KEY_TIMESTAMP", "KEY_WIDGET_COMPONENT_NAME", "METHOD_SUBMIT_FEEDBACK", "METHOD_SUBMIT_FEEDBACK_WIDGET", "METHOD_SUBMIT_RAW_FEEDBACK_WIDGET", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FeedbackContract {

    @NotNull
    public static final String AUTHORITY = "com.samsung.android.app.deepsky.feedback";

    @NotNull
    private static final Uri CONTENT_URI;

    @NotNull
    public static final FeedbackContract INSTANCE = new FeedbackContract();

    @NotNull
    public static final String KEY_FEEDBACK_RESULT = "feedback_result";

    @NotNull
    public static final String KEY_FEEDBACK_TYPE = "feedback_type";

    @NotNull
    public static final String KEY_STACK_ID = "stack_id";

    @NotNull
    public static final String KEY_SUGGESTION_ID = "suggestion_id";

    @NotNull
    public static final String KEY_TIMESTAMP = "feedback_timestamp";

    @NotNull
    public static final String KEY_WIDGET_COMPONENT_NAME = "widget_component_name";

    @NotNull
    public static final String METHOD_SUBMIT_FEEDBACK = "submit_feedback";

    @NotNull
    public static final String METHOD_SUBMIT_FEEDBACK_WIDGET = "submit_feedback_widget";

    @NotNull
    public static final String METHOD_SUBMIT_RAW_FEEDBACK_WIDGET = "submit_raw_feedback_widget";

    static {
        Uri uri = Uri.parse("content://com.samsung.android.app.deepsky.feedback/feedback");
        Intrinsics.checkNotNullExpressionValue(uri, "parse(\"content://$AUTHORITY/feedback\")");
        CONTENT_URI = uri;
    }

    private FeedbackContract() {
    }

    @NotNull
    public final Uri getCONTENT_URI() {
        return CONTENT_URI;
    }
}
