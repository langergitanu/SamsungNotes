package com.samsung.android.app.sdk.deepsky.contract.widget;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/widget/WidgetContract;", "", "()V", "DISABLE_WIDGET_FOCUS", "", "ENABLE_WIDGET_FOCUS", "GET_ENABLED_WIDGET_FOCUS_ID_LIST", "IS_ENABLED", "IS_SUBSCRIBED_WIDGET_FOCUS", "KEY_PENDING_INTENT", "KEY_STACK_ID", "KEY_WIDGET_COMPONENT_NAME_LIST", "RESULT_WIDGET_FOCUS", "SUBSCRIBE_WIDGET_FOCUS", "UNSUBSCRIBE_WIDGET_FOCUS", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class WidgetContract {

    @NotNull
    public static final String DISABLE_WIDGET_FOCUS = "disableWidgetFocus";

    @NotNull
    public static final String ENABLE_WIDGET_FOCUS = "enableWidgetFocus";

    @NotNull
    public static final String GET_ENABLED_WIDGET_FOCUS_ID_LIST = "getEnabledWidgetFocusIdList";

    @NotNull
    public static final WidgetContract INSTANCE = new WidgetContract();

    @NotNull
    public static final String IS_ENABLED = "isEnabled";

    @NotNull
    public static final String IS_SUBSCRIBED_WIDGET_FOCUS = "isSubscribedWidgetFocus";

    @NotNull
    public static final String KEY_PENDING_INTENT = "pendingIntentKey";

    @NotNull
    public static final String KEY_STACK_ID = "smartWidgetIdKey";

    @NotNull
    public static final String KEY_WIDGET_COMPONENT_NAME_LIST = "widgetComponentNameListKey";

    @NotNull
    public static final String RESULT_WIDGET_FOCUS = "result_widget_focus";

    @NotNull
    public static final String SUBSCRIBE_WIDGET_FOCUS = "subscribeWidgetFocus";

    @NotNull
    public static final String UNSUBSCRIBE_WIDGET_FOCUS = "unsubscribeWidgetFocus";

    private WidgetContract() {
    }
}
