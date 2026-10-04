package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenActionButtonManager;", "", "<init>", "()V", "mActionLayout", "Landroid/widget/LinearLayout;", "mContentBody", "mDefaultResource", "", "mActionLayoutId", "value", "buttonCount", "getButtonCount", "()I", "close", "", "setContentView", "contentBody", "addButton", "Landroid/view/View;", "text", "", "actionLayout", "getActionLayout", "()Landroid/view/View;", "initValue", "initActionLayout", "getPixelSize", "context", "Landroid/content/Context;", "dimenId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenActionButtonManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenActionButtonManager.kt\ncom/samsung/android/sdk/pen/setting/SpenActionButtonManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n1#2:122\n*E\n"})
public final class SpenActionButtonManager {
    private static final int MAX_ACTION_BUTTON = 2;

    @NotNull
    private static final String TAG = "SpenPenLayoutVertical";
    private int buttonCount;

    @Nullable
    private LinearLayout mActionLayout;

    @Nullable
    private LinearLayout mContentBody;
    private final int mDefaultResource = C7932R.layout.setting_dialog_action_layout;
    private final int mActionLayoutId = C7932R.id.action_button_layout;

    public SpenActionButtonManager() {
        initValue();
    }

    private final int getPixelSize(Context context, int dimenId) {
        return context.getResources().getDimensionPixelSize(dimenId);
    }

    private final void initActionLayout() {
        initValue();
        LinearLayout linearLayout = this.mContentBody;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(this.mActionLayoutId);
            this.mActionLayout = linearLayout2;
            if (linearLayout2 != null) {
                int childCount = linearLayout2.getChildCount();
                int i = 0;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = linearLayout2.getChildAt(i2);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        i++;
                    }
                }
                this.buttonCount = (int) Math.min(i, 2.0d);
            }
        }
    }

    private final void initValue() {
        this.buttonCount = 0;
        this.mActionLayout = null;
    }

    @Nullable
    public final View addButton(@Nullable CharSequence text) {
        LinearLayout linearLayout;
        View viewFindViewById;
        int i;
        Log.i(TAG, "addActionButton()");
        SpenShowButtonShapeText spenShowButtonShapeText = null;
        if (this.buttonCount == 2 || (linearLayout = this.mContentBody) == null) {
            return null;
        }
        Context context = linearLayout.getContext();
        LinearLayout linearLayout2 = this.mActionLayout;
        if (linearLayout2 == null) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(this.mDefaultResource, (ViewGroup) linearLayout, false);
            this.mActionLayout = viewInflate instanceof LinearLayout ? (LinearLayout) viewInflate : null;
            Intrinsics.checkNotNull(context);
            int pixelSize = getPixelSize(context, C7932R.dimen.setting_peninfo_selector_action_layout_height);
            int pixelSize2 = getPixelSize(context, C7932R.dimen.setting_peninfo_selector_action_layout_margin_side);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, pixelSize);
            layoutParams.topMargin = getPixelSize(context, C7932R.dimen.setting_peninfo_selector_action_layout_margin_top);
            layoutParams.setMarginStart(pixelSize2);
            layoutParams.setMarginEnd(pixelSize2);
            linearLayout.addView(this.mActionLayout, layoutParams);
            LinearLayout linearLayout3 = this.mActionLayout;
            i = 8;
            viewFindViewById = linearLayout3 != null ? linearLayout3.findViewById(C7932R.id.cancel) : null;
        } else {
            viewFindViewById = linearLayout2 != null ? linearLayout2.findViewById(C7932R.id.done) : null;
            i = 0;
        }
        this.buttonCount++;
        LinearLayout linearLayout4 = this.mActionLayout;
        if (linearLayout4 != null) {
            int childCount = linearLayout4.getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                linearLayout4.getChildAt(i2).setVisibility(i);
            }
        }
        String string = context.getResources().getString(C7932R.string.pen_string_button);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonShapeText");
        } else {
            spenShowButtonShapeText = (SpenShowButtonShapeText) viewFindViewById;
        }
        spenShowButtonShapeText.setText(text);
        spenShowButtonShapeText.setContentDescription(((Object) text) + " " + string);
        spenShowButtonShapeText.setButtonShapeEnabled(true);
        SpenShowButtonShapeText spenShowButtonShapeText2 = (SpenShowButtonShapeText) viewFindViewById;
        SpenSettingUtilText.setTypeFace(context, SpenSettingUtilText.FontName.MEDIUM, spenShowButtonShapeText2);
        SpenSettingUtilText.applyUpToLargeLevel(context, 18.0f, spenShowButtonShapeText2);
        return spenShowButtonShapeText2;
    }

    public final void close() {
        initValue();
        this.mContentBody = null;
    }

    @Nullable
    public final View getActionLayout() {
        return this.mActionLayout;
    }

    public final int getButtonCount() {
        return this.buttonCount;
    }

    public final void setContentView(@Nullable LinearLayout contentBody) {
        this.mContentBody = contentBody;
        initActionLayout();
    }
}
