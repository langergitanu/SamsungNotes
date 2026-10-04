package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0017\u0018\u0000 \"2\u00020\u0001:\u0004\"#$%B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001b\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout;", "context", "Landroid/content/Context;", "customImagePath", "", "relativeLayout", "Landroid/widget/RelativeLayout;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/RelativeLayout;)V", "mBodyLayout", "Lcom/samsung/android/sdk/pen/setting/selection/SpenSelectionLayout;", "mGSIMLoggingListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionLayout$LoggingListener;", "mSelectionInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionLayout$SelectionInfoChangedListener;", "close", "", "setLoggingListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "settingSelectionInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "info", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "setInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;)V", "setSelectionInfoChangedListener", "setLayoutAnimation", "hasAnimation", "", "construct", "initView", "notifyDataChanged", "Companion", "LoggingListener", "SelectionInfoChangedListener", "ViewListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public class SpenSettingSelectionLayout extends SpenPopupLayout {

    @NotNull
    private static final String TAG = "SpenSettingSelection";
    private SpenSelectionLayout mBodyLayout;

    @Nullable
    private LoggingListener mGSIMLoggingListener;

    @Nullable
    private SelectionInfoChangedListener mSelectionInfoChangedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionLayout$LoggingListener;", "", "onClosed", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface LoggingListener {
        void onClosed();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionLayout$SelectionInfoChangedListener;", "", "onSelectionInfoChanged", "", "selectionInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SelectionInfoChangedListener {
        void onSelectionInfoChanged(@Nullable SpenSettingSelectionInfo selectionInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionLayout$ViewListener;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$ViewListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ViewListener extends SpenPopupLayout.ViewListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingSelectionLayout(@NotNull Context context, @Nullable String str, @Nullable RelativeLayout relativeLayout) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        Log.i(TAG, "construct");
        initView(context);
        setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView(Context context) {
        setTitleText(C7932R.string.pen_string_selection_mode);
        Resources resources = context.getResources();
        String string = resources.getString(C7932R.string.pen_string_close_any, resources.getString(C7932R.string.pen_string_close_selection_mode_settings));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setCloseButtonDescription(string);
        setCloseButtonInfo(new ViewOnClickListenerC0157a(this, 25));
        SpenSelectionLayout spenSelectionLayout = null;
        this.mBodyLayout = new SpenSelectionLayout(context, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = resources.getDimensionPixelSize(C7932R.dimen.setting_selection_layout_margin_top);
        layoutParams.bottomMargin = resources.getDimensionPixelSize(C7932R.dimen.setting_selection_layout_margin_bottom);
        SpenSelectionLayout spenSelectionLayout2 = this.mBodyLayout;
        if (spenSelectionLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBodyLayout");
            spenSelectionLayout2 = null;
        }
        setContentView(spenSelectionLayout2, layoutParams);
        SpenSelectionLayout spenSelectionLayout3 = this.mBodyLayout;
        if (spenSelectionLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBodyLayout");
        } else {
            spenSelectionLayout = spenSelectionLayout3;
        }
        spenSelectionLayout.setActionListener(new SpenSelectionLayout.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingSelectionLayout.initView.2
            @Override // com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout.OnActionListener
            public void onSelectionChanged(int type) {
                SpenSettingSelectionLayout.this.notifyDataChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout.OnActionListener
            public void onSelectionOptionChanged(boolean includePartiallySelected) {
                SpenSettingSelectionLayout.this.notifyDataChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenSettingSelectionLayout spenSettingSelectionLayout, View view) {
        spenSettingSelectionLayout.hideAnimation(null);
        LoggingListener loggingListener = spenSettingSelectionLayout.mGSIMLoggingListener;
        if (loggingListener != null) {
            loggingListener.onClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDataChanged() {
        Log.i(TAG, "notifyDataChanged() changedListener=".concat(this.mSelectionInfoChangedListener != null ? "NOT NULL" : "NULL"));
        SelectionInfoChangedListener selectionInfoChangedListener = this.mSelectionInfoChangedListener;
        if (selectionInfoChangedListener != null) {
            SpenSelectionLayout spenSelectionLayout = this.mBodyLayout;
            if (spenSelectionLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBodyLayout");
                spenSelectionLayout = null;
            }
            selectionInfoChangedListener.onSelectionInfoChanged(spenSelectionLayout.getInfo());
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void close() {
        Log.i(TAG, "close");
        SpenSelectionLayout spenSelectionLayout = this.mBodyLayout;
        if (spenSelectionLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBodyLayout");
            spenSelectionLayout = null;
        }
        spenSelectionLayout.close();
        this.mGSIMLoggingListener = null;
        super.close();
    }

    @Nullable
    public final SpenSettingSelectionInfo getInfo() {
        SpenSelectionLayout spenSelectionLayout = this.mBodyLayout;
        if (spenSelectionLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBodyLayout");
            spenSelectionLayout = null;
        }
        return spenSelectionLayout.getInfo();
    }

    public final void setInfo(@Nullable SpenSettingSelectionInfo spenSettingSelectionInfo) {
        if (spenSettingSelectionInfo == null) {
            return;
        }
        SpenSelectionLayout spenSelectionLayout = this.mBodyLayout;
        if (spenSelectionLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBodyLayout");
            spenSelectionLayout = null;
        }
        spenSelectionLayout.setInfo(spenSettingSelectionInfo);
    }

    public final void setLayoutAnimation(boolean hasAnimation) {
        setAnimation(hasAnimation);
    }

    public final void setLoggingListener(@Nullable LoggingListener listener) {
        if (listener != null) {
            this.mGSIMLoggingListener = listener;
        }
    }

    public final void setSelectionInfoChangedListener(@Nullable SelectionInfoChangedListener listener) {
        this.mSelectionInfoChangedListener = listener;
    }
}
