package com.samsung.android.sdk.pen.setting.colorpicker;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilSIP;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 D2\u00020\u0001:\u0005DEFGHB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB)\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0011J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0006\u0010%\u001a\u00020#J\u0010\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010.\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\u0019J\u0010\u0010/\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u000100J\u0010\u00101\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0005J\u001a\u00105\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u00010\u00072\b\u00107\u001a\u0004\u0018\u00010\u0007J\u0010\u00108\u001a\u00020#2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u00109\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\u0007J\u0010\u0010;\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010<\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H\u0002J \u0010?\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000fH\u0002J\u0010\u0010A\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020\tH\u0002R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "mode", "", "hsvColor", "", "supportEyedropper", "", "<init>", "(Landroid/content/Context;I[FZ)V", "dataViewCore", "Lcom/samsung/android/sdk/pen/setting/colorpicker/ColorPickerDataViewCore;", "viewInfo", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewInfo;", "layoutId", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/colorpicker/ColorPickerDataViewCore;Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewInfo;I)V", "mCancelButton", "Lcom/samsung/android/sdk/pen/setting/common/SpenShowButtonShapeText;", "mDoneButton", "mColorPicker", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataChangedListener;", "mActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$ActionButtonListener;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mIsDataViewCoreOwner", "mRGBCodeActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$OnRGBCodeActionListener;", "mCancelButtonClickListener", "Landroid/view/View$OnClickListener;", "mDoneButtonClickListener", "setVisibility", "", "visibility", "close", "viewMode", "getViewMode", "()I", "setViewMode", "(I)V", "setPickerColorChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$PickerColorChangedListener;", "setActionButtonListener", "setPickerEyedropperActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$PickerEyedropperActionListener;", "setViewModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$ViewModeChangedListener;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setColor", "oldColor", "currentColor", "setCurrentColor", "getCurrentColor", "hsv", "construct", "initBackground", "view", "Landroid/view/ViewGroup;", "initView", "info", "initActionButton", "notifyColorChanged", "reloadColors", "Companion", "ActionButtonListener", "PickerEyedropperActionListener", "PickerColorChangedListener", "ViewModeChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorPickerLayoutV2 extends LinearLayout {

    @NotNull
    private static final String TAG = "SpenColorPickerLayoutV2";
    public static final int VIEW_MODE_GRADIENT = 1;
    public static final int VIEW_MODE_SWATCH = 2;

    @Nullable
    private ActionButtonListener mActionButtonListener;
    private SpenShowButtonShapeText mCancelButton;

    @NotNull
    private final View.OnClickListener mCancelButtonClickListener;

    @NotNull
    private ColorPickerDataViewCore mColorPicker;

    @Nullable
    private SpenConsumedListener mConsumedListener;

    @Nullable
    private SpenColorPickerDataChangedListener mDataChangedListener;
    private SpenShowButtonShapeText mDoneButton;

    @NotNull
    private final View.OnClickListener mDoneButtonClickListener;
    private boolean mIsDataViewCoreOwner;

    @NotNull
    private final SpenColorPickerView.OnRGBCodeActionListener mRGBCodeActionListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$ActionButtonListener;", "", "onDoneButtonClick", "", "onCancelButtonClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionButtonListener {
        void onCancelButtonClick();

        void onDoneButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$PickerColorChangedListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PickerColorChangedListener extends SpenColorPickerDataChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$PickerEyedropperActionListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerEyedropperListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PickerEyedropperActionListener extends SpenColorPickerEyedropperListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayoutV2$ViewModeChangedListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewModeChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ViewModeChangedListener extends SpenColorPickerViewModeChangedListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorPickerLayoutV2(@NotNull Context context, int i, @NotNull float[] hsvColor, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        SpenColorPickerView.OnRGBCodeActionListener onRGBCodeActionListener = new SpenColorPickerView.OnRGBCodeActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2$mRGBCodeActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView.OnRGBCodeActionListener
            public void onActionDone() {
                SpenSettingUtilSIP.hideSoftInput(this.this$0.getContext(), this.this$0, 0);
            }
        };
        this.mRGBCodeActionListener = onRGBCodeActionListener;
        final int i2 = 0;
        this.mCancelButtonClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.colorpicker.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenColorPickerLayoutV2 f5016b;

            {
                this.f5016b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        SpenColorPickerLayoutV2.mCancelButtonClickListener$lambda$0(this.f5016b, view);
                        break;
                    default:
                        SpenColorPickerLayoutV2.mDoneButtonClickListener$lambda$1(this.f5016b, view);
                        break;
                }
            }
        };
        final int i4 = 1;
        this.mDoneButtonClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.colorpicker.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenColorPickerLayoutV2 f5016b;

            {
                this.f5016b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        SpenColorPickerLayoutV2.mCancelButtonClickListener$lambda$0(this.f5016b, view);
                        break;
                    default:
                        SpenColorPickerLayoutV2.mDoneButtonClickListener$lambda$1(this.f5016b, view);
                        break;
                }
            }
        };
        this.mIsDataViewCoreOwner = true;
        this.mColorPicker = new ColorPickerDataViewCore(context, i, hsvColor, z, true, true);
        construct(context);
        this.mColorPicker.loadRecentColors();
        this.mColorPicker.setRGBCodeActionListener(onRGBCodeActionListener);
    }

    private final void construct(Context context) {
        SpenColorPickerViewInfo spenColorPickerViewInfo = new SpenColorPickerViewInfo();
        spenColorPickerViewInfo.layoutId = C7932R.layout.setting_color_picker_view_portrait_v2;
        spenColorPickerViewInfo.itemLayoutId = C7932R.layout.setting_color_swatch_item_v2;
        spenColorPickerViewInfo.gradientCursorSizeDimen = C7932R.dimen.setting_color_picker_layout_v2_content_point_size;
        spenColorPickerViewInfo.gradientCursorOutlineDimen = C7932R.dimen.setting_color_picker_layout_v2_point_outline;
        spenColorPickerViewInfo.gradientSelectorRadiusDimen = C7932R.dimen.setting_color_picker_color_swatch_margin_start;
        spenColorPickerViewInfo.gradientHeightDimen = C7932R.dimen.setting_color_picker_layout_v2_gradient_height;
        spenColorPickerViewInfo.swatchTopMarginDimen = C7932R.dimen.setting_color_picker_layout_v2_color_swatch_margin_top;
        spenColorPickerViewInfo.swatchStartMarginDimen = C7932R.dimen.setting_color_picker_layout_v2_color_swatch_margin_start;
        spenColorPickerViewInfo.swatchEndMarginDimen = C7932R.dimen.setting_color_picker_layout_v2_color_swatch_margin_end;
        spenColorPickerViewInfo.swatchBottomMarginDimen = C7932R.dimen.setting_color_picker_color_swatch_margin_bottom;
        int i = C7932R.dimen.setting_color_picker_layout_v2_gradient_mode_btn_size;
        spenColorPickerViewInfo.gradientModeBtnSize = i;
        int i2 = C7932R.dimen.setting_color_picker_layout_v2_gradient_mode_btn_margin_start;
        spenColorPickerViewInfo.gradientModeBtnStartMargin = i2;
        spenColorPickerViewInfo.swatchModeBtnSize = i;
        spenColorPickerViewInfo.swatchModeBtnStartMargin = i2;
        spenColorPickerViewInfo.colorDisplayRadius = C7932R.dimen.setting_color_picker_layout_v2_color_display_radius;
        spenColorPickerViewInfo.modeType = 1;
        spenColorPickerViewInfo.eyedropperBgResourceId = C7932R.drawable.color_picker_recent_eyedropper;
        initView(context, C7932R.layout.setting_color_picker_layout_v2_1, spenColorPickerViewInfo);
        setClipToOutline(true);
        initBackground(context, this);
        this.mConsumedListener = new SpenConsumedListener();
        FrameLayout frameLayout = (FrameLayout) findViewById(C7932R.id.total_layout);
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            spenConsumedListener.setConsumedListener(this, frameLayout);
        }
    }

    private final void initActionButton(Context context) {
        View viewFindViewById = findViewById(C7932R.id.color_picker_button_cancel);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
        this.mCancelButton = (SpenShowButtonShapeText) viewFindViewById;
        View viewFindViewById2 = findViewById(C7932R.id.color_picker_button_done);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
        this.mDoneButton = (SpenShowButtonShapeText) viewFindViewById2;
        SpenSettingUtilText.FontName fontName = SpenSettingUtilText.FontName.MEDIUM;
        SpenShowButtonShapeText spenShowButtonShapeText = this.mCancelButton;
        SpenShowButtonShapeText spenShowButtonShapeText2 = null;
        if (spenShowButtonShapeText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelButton");
            spenShowButtonShapeText = null;
        }
        SpenShowButtonShapeText spenShowButtonShapeText3 = this.mDoneButton;
        if (spenShowButtonShapeText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
            spenShowButtonShapeText3 = null;
        }
        SpenSettingUtilText.setTypeFace(context, fontName, spenShowButtonShapeText, spenShowButtonShapeText3);
        SpenShowButtonShapeText spenShowButtonShapeText4 = this.mCancelButton;
        if (spenShowButtonShapeText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelButton");
            spenShowButtonShapeText4 = null;
        }
        SpenShowButtonShapeText spenShowButtonShapeText5 = this.mDoneButton;
        if (spenShowButtonShapeText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
            spenShowButtonShapeText5 = null;
        }
        SpenSettingUtilText.applyUpToLargeLevel(context, 16.0f, spenShowButtonShapeText4, spenShowButtonShapeText5);
        SpenShowButtonShapeText spenShowButtonShapeText6 = this.mCancelButton;
        if (spenShowButtonShapeText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelButton");
            spenShowButtonShapeText6 = null;
        }
        spenShowButtonShapeText6.setContentDescription(context.getResources().getString(C7932R.string.pen_string_cancel) + " " + context.getResources().getString(C7932R.string.pen_string_button));
        SpenShowButtonShapeText spenShowButtonShapeText7 = this.mDoneButton;
        if (spenShowButtonShapeText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
            spenShowButtonShapeText7 = null;
        }
        spenShowButtonShapeText7.setContentDescription(context.getResources().getString(C7932R.string.pen_string_done) + " " + context.getResources().getString(C7932R.string.pen_string_button));
        SpenShowButtonShapeText spenShowButtonShapeText8 = this.mCancelButton;
        if (spenShowButtonShapeText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelButton");
            spenShowButtonShapeText8 = null;
        }
        spenShowButtonShapeText8.setButtonShapeEnabled(true);
        SpenShowButtonShapeText spenShowButtonShapeText9 = this.mDoneButton;
        if (spenShowButtonShapeText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
            spenShowButtonShapeText9 = null;
        }
        spenShowButtonShapeText9.setButtonShapeEnabled(true);
        SpenShowButtonShapeText spenShowButtonShapeText10 = this.mCancelButton;
        if (spenShowButtonShapeText10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelButton");
            spenShowButtonShapeText10 = null;
        }
        spenShowButtonShapeText10.setOnClickListener(this.mCancelButtonClickListener);
        SpenShowButtonShapeText spenShowButtonShapeText11 = this.mDoneButton;
        if (spenShowButtonShapeText11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
        } else {
            spenShowButtonShapeText2 = spenShowButtonShapeText11;
        }
        spenShowButtonShapeText2.setOnClickListener(this.mDoneButtonClickListener);
    }

    private final void initBackground(Context context, ViewGroup view) {
        view.setElevation(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_popup_bg_elevation));
        view.setBackgroundResource(C7932R.drawable.dialog_bg);
        view.setClipChildren(false);
        SpenSettingUtil.setShadowAlpha(view, 0.5f);
    }

    private final void initView(Context context, int layoutId, SpenColorPickerViewInfo info) {
        View.inflate(context, layoutId, this);
        FrameLayout frameLayout = (FrameLayout) findViewById(C7932R.id.body_layout);
        if (frameLayout == null) {
            return;
        }
        frameLayout.addView(this.mColorPicker.initPickerView(context, info), new FrameLayout.LayoutParams(-1, -2));
        initActionButton(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCancelButtonClickListener$lambda$0(SpenColorPickerLayoutV2 spenColorPickerLayoutV2, View view) {
        ActionButtonListener actionButtonListener = spenColorPickerLayoutV2.mActionButtonListener;
        if (actionButtonListener != null) {
            actionButtonListener.onCancelButtonClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDoneButtonClickListener$lambda$1(SpenColorPickerLayoutV2 spenColorPickerLayoutV2, View view) {
        spenColorPickerLayoutV2.notifyColorChanged(true);
        ActionButtonListener actionButtonListener = spenColorPickerLayoutV2.mActionButtonListener;
        if (actionButtonListener != null) {
            actionButtonListener.onDoneButtonClick();
        }
    }

    private final void notifyColorChanged(boolean reloadColors) {
        float[] fArr = new float[3];
        getCurrentColor(fArr);
        float f = fArr[1];
        if (f > 1.0f) {
            Log.i(TAG, "HSV is wrong. current=" + f + " change=1");
            fArr[1] = 1.0f;
            setColor(fArr, fArr);
        }
        this.mColorPicker.saveRecentColor(fArr);
        if (reloadColors) {
            this.mColorPicker.loadRecentColors();
        }
        SpenColorPickerDataChangedListener spenColorPickerDataChangedListener = this.mDataChangedListener;
        if (spenColorPickerDataChangedListener != null) {
            spenColorPickerDataChangedListener.onColorChanged(SpenSettingUtil.HSVToColor(fArr), fArr);
        }
    }

    public final void close() {
        if (this.mIsDataViewCoreOwner) {
            this.mColorPicker.close();
        }
        this.mDataChangedListener = null;
        this.mActionButtonListener = null;
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            spenConsumedListener.close();
        }
        this.mConsumedListener = null;
    }

    public final boolean getCurrentColor(@Nullable float[] hsv) {
        if (hsv == null || hsv.length < 3) {
            return false;
        }
        return this.mColorPicker.getCurrentColor(hsv);
    }

    public final int getViewMode() {
        return this.mColorPicker.getViewMode();
    }

    public final void setActionButtonListener(@Nullable ActionButtonListener listener) {
        this.mActionButtonListener = listener;
    }

    public final void setColor(@Nullable float[] oldColor, @Nullable float[] currentColor) {
        if (oldColor == null || oldColor.length < 3 || currentColor == null || currentColor.length < 3) {
            return;
        }
        this.mColorPicker.setColor(oldColor, currentColor);
    }

    public final void setColorTheme(int theme) {
        this.mColorPicker.setColorTheme(theme);
    }

    public final void setCurrentColor(@Nullable float[] hsvColor) {
        this.mColorPicker.setCurrentColor(hsvColor);
    }

    public final void setPickerColorChangedListener(@Nullable PickerColorChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void setPickerEyedropperActionListener(@Nullable PickerEyedropperActionListener listener) {
        this.mColorPicker.setPickerEyedropperActionListener(listener);
    }

    public final void setViewMode(int i) {
        this.mColorPicker.setViewMode(i);
    }

    public final void setViewModeChangedListener(@Nullable ViewModeChangedListener listener) {
        this.mColorPicker.setViewModeChangedListener(listener);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 8) {
            SpenSettingUtilSIP.hideSoftInput(getContext(), this, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorPickerLayoutV2(@NotNull Context context, @NotNull ColorPickerDataViewCore dataViewCore, @NotNull SpenColorPickerViewInfo viewInfo, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataViewCore, "dataViewCore");
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        this.mRGBCodeActionListener = new SpenColorPickerView.OnRGBCodeActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2$mRGBCodeActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView.OnRGBCodeActionListener
            public void onActionDone() {
                SpenSettingUtilSIP.hideSoftInput(this.this$0.getContext(), this.this$0, 0);
            }
        };
        final int i2 = 0;
        this.mCancelButtonClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.colorpicker.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenColorPickerLayoutV2 f5016b;

            {
                this.f5016b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        SpenColorPickerLayoutV2.mCancelButtonClickListener$lambda$0(this.f5016b, view);
                        break;
                    default:
                        SpenColorPickerLayoutV2.mDoneButtonClickListener$lambda$1(this.f5016b, view);
                        break;
                }
            }
        };
        final int i4 = 1;
        this.mDoneButtonClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.colorpicker.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenColorPickerLayoutV2 f5016b;

            {
                this.f5016b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        SpenColorPickerLayoutV2.mCancelButtonClickListener$lambda$0(this.f5016b, view);
                        break;
                    default:
                        SpenColorPickerLayoutV2.mDoneButtonClickListener$lambda$1(this.f5016b, view);
                        break;
                }
            }
        };
        this.mIsDataViewCoreOwner = false;
        this.mColorPicker = dataViewCore;
        initView(context, i, viewInfo);
        this.mColorPicker.loadRecentColors();
    }
}
