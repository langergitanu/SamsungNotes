package com.samsung.android.sdk.pen.setting.colorpicker;

import android.content.Context;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0005;<=>?B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010&\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u0012J\u0010\u0010)\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010*J\u0018\u0010+\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020\u0005J&\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\u001a\u00103\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u00010\u00072\b\u00105\u001a\u0004\u0018\u00010\u0007J(\u00106\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00108\u001a\u00020\tH\u0002J\u0014\u00109\u001a\u0004\u0018\u00010:2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "mode", "", "hsvColor", "", "supportEyedropper", "", "<init>", "(Landroid/content/Context;I[FZ)V", "(Landroid/content/Context;I[F)V", "mPickerController", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerControl;", "mCloseButton", "Landroid/widget/ImageButton;", "mCloseClickListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$OnCloseClickListener;", "mPickerView", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mCloseButtonClickListener", "Landroid/view/View$OnClickListener;", "close", "", "getCurrentColor", "hsv", "setCurrentColor", "viewMode", "getViewMode", "()I", "setViewMode", "(I)V", "setPickerChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$PickerChangedListener;", "setPickerActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$PickerActionListener;", "setOnCloseClickListener", "setPickerEyedropperActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$PickerEyedropperActionListener;", "setRecentColors", "recentColors", "numOfColor", "setRoundedBackground", "radius", "bgColor", "strokeSize", "strokeColor", "setColor", "oldColor", "currentColor", "construct", "pickerMode", "isSupportEyedropper", "initView", "Landroid/widget/FrameLayout;", "Companion", "PickerActionListener", "PickerChangedListener", "OnCloseClickListener", "PickerEyedropperActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenColorPickerLayout extends LinearLayout {

    @NotNull
    private static final String TAG = "SpenColorPickerLayout";
    public static final int VIEW_MODE_GRADIENT = 1;
    public static final int VIEW_MODE_SWATCH = 2;
    private ImageButton mCloseButton;

    @NotNull
    private final View.OnClickListener mCloseButtonClickListener;

    @Nullable
    private OnCloseClickListener mCloseClickListener;

    @Nullable
    private SpenConsumedListener mConsumedListener;
    private SpenColorPickerControl mPickerController;
    private SpenColorPickerView mPickerView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$OnCloseClickListener;", "", "onCloseButtonClick", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnCloseClickListener {
        void onCloseButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$PickerActionListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerActionListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PickerActionListener extends SpenColorPickerActionListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$PickerChangedListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewModeChangedListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PickerChangedListener extends SpenColorPickerViewModeChangedListener, SpenColorPickerDataChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout$PickerEyedropperActionListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerEyedropperListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PickerEyedropperActionListener extends SpenColorPickerEyedropperListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorPickerLayout(@NotNull Context context, int i, @Nullable float[] fArr, boolean z) {
        super(new ContextThemeWrapper(context, C7932R.style.BasicUITheme));
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCloseButtonClickListener = new ViewOnClickListenerC7538b(this, 1);
        if (fArr != null) {
            construct(context, i, fArr, z);
        }
    }

    private final void construct(Context context, int pickerMode, float[] hsvColor, boolean isSupportEyedropper) {
        FrameLayout frameLayoutInitView = initView(context);
        if (frameLayoutInitView == null) {
            return;
        }
        this.mPickerController = new SpenColorPickerControl(pickerMode, hsvColor);
        SpenColorPickerViewInfo spenColorPickerViewInfo = new SpenColorPickerViewInfo();
        spenColorPickerViewInfo.layoutId = C7932R.layout.setting_color_picker_view_portrait;
        spenColorPickerViewInfo.itemLayoutId = C7932R.layout.setting_layout_color_swatch_item;
        spenColorPickerViewInfo.gradientSelectorRadiusDimen = C7932R.dimen.setting_color_picker_color_swatch_margin_start;
        spenColorPickerViewInfo.gradientHeightDimen = C7932R.dimen.setting_color_picker_layout_gradient_height;
        spenColorPickerViewInfo.gradientCursorSizeDimen = C7932R.dimen.setting_color_picker_layout_content_point_size;
        spenColorPickerViewInfo.gradientCursorOutlineDimen = C7932R.dimen.setting_color_picker_layout_point_outline;
        int i = C7932R.dimen.setting_color_picker_layout_color_swatch_margin_top;
        spenColorPickerViewInfo.swatchTopMarginDimen = i;
        spenColorPickerViewInfo.swatchStartMarginDimen = C7932R.dimen.setting_color_picker_layout_color_swatch_margin_start;
        spenColorPickerViewInfo.swatchEndMarginDimen = C7932R.dimen.setting_color_picker_layout_color_swatch_margin_end;
        spenColorPickerViewInfo.swatchBottomMarginDimen = i;
        int i2 = C7932R.dimen.setting_color_picker_layout_gradient_mode_btn_size;
        spenColorPickerViewInfo.gradientModeBtnSize = i2;
        int i4 = C7932R.dimen.setting_color_picker_layout_gradient_mode_btn_margin_start;
        spenColorPickerViewInfo.gradientModeBtnStartMargin = i4;
        spenColorPickerViewInfo.swatchModeBtnSize = i2;
        spenColorPickerViewInfo.swatchModeBtnStartMargin = i4;
        spenColorPickerViewInfo.colorDisplayRadius = C7932R.dimen.setting_color_picker_layout_color_display_radius;
        spenColorPickerViewInfo.modeType = 2;
        spenColorPickerViewInfo.eyedropperBgResourceId = C7932R.drawable.color_circle_eyedropper_no_spr;
        this.mPickerView = new SpenColorPickerView(context, pickerMode, hsvColor, spenColorPickerViewInfo, false, isSupportEyedropper);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        SpenColorPickerView spenColorPickerView = this.mPickerView;
        ImageButton imageButton = null;
        if (spenColorPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerView");
            spenColorPickerView = null;
        }
        frameLayoutInitView.addView(spenColorPickerView, layoutParams);
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        SpenColorPickerView spenColorPickerView2 = this.mPickerView;
        if (spenColorPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerView");
            spenColorPickerView2 = null;
        }
        spenColorPickerControl.setPickerView(spenColorPickerView2);
        SpenColorPickerControl spenColorPickerControl2 = this.mPickerController;
        if (spenColorPickerControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl2 = null;
        }
        spenColorPickerControl2.setViewMode(pickerMode);
        SpenColorPickerView spenColorPickerView3 = this.mPickerView;
        if (spenColorPickerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerView");
            spenColorPickerView3 = null;
        }
        ImageButton imageButton2 = (ImageButton) spenColorPickerView3.findViewById(C7932R.id.close_btn);
        this.mCloseButton = imageButton2;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setBackgroundResource(C7932R.drawable.spen_brush_btn_ripple_effect);
        imageButton.setImageResource(C7932R.drawable.note_setting_ic_close);
        imageButton.setColorFilter(SpenSettingUtil.getColor(context, C7932R.color.setting_brush_text_color));
        imageButton.setContentDescription(imageButton.getContext().getResources().getString(C7932R.string.pen_string_close));
        SpenSettingUtilHover.setHoverText(imageButton, imageButton.getContext().getResources().getString(C7932R.string.pen_string_close), true);
        imageButton.setOnClickListener(this.mCloseButtonClickListener);
        this.mConsumedListener = new SpenConsumedListener();
        FrameLayout frameLayout = (FrameLayout) findViewById(C7932R.id.total_layout);
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            spenConsumedListener.setConsumedListener(this, frameLayout);
        }
    }

    private final FrameLayout initView(Context context) {
        if (context == null) {
            return null;
        }
        View.inflate(context, C7932R.layout.setting_color_picker_layout_v2, this);
        View viewFindViewById = findViewById(C7932R.id.top_bg);
        if (viewFindViewById != null) {
            viewFindViewById.setClipToOutline(true);
        }
        return (FrameLayout) findViewById(C7932R.id.body_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCloseButtonClickListener$lambda$0(SpenColorPickerLayout spenColorPickerLayout, View view) {
        Log.i(TAG, "onCloseButtonClick() ".concat(spenColorPickerLayout.mCloseClickListener != null ? "Listener is not null" : "Listener is null"));
        OnCloseClickListener onCloseClickListener = spenColorPickerLayout.mCloseClickListener;
        if (onCloseClickListener != null) {
            onCloseClickListener.onCloseButtonClick();
        }
    }

    public void close() {
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        spenColorPickerControl.close();
        SpenColorPickerView spenColorPickerView = this.mPickerView;
        if (spenColorPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerView");
            spenColorPickerView = null;
        }
        spenColorPickerView.close();
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            spenConsumedListener.close();
        }
        this.mConsumedListener = null;
        this.mCloseClickListener = null;
    }

    public final boolean getCurrentColor(@Nullable float[] hsv) {
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        return spenColorPickerControl.getCurrentColor(hsv);
    }

    public final int getViewMode() {
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        return spenColorPickerControl.getMPickerMode();
    }

    public final void setColor(@Nullable float[] oldColor, @Nullable float[] currentColor) {
        Log.i(TAG, "setColor()");
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        spenColorPickerControl.setColor(oldColor, currentColor);
    }

    public final void setCurrentColor(@Nullable float[] hsvColor) {
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        spenColorPickerControl.setCurrentColor(hsvColor);
    }

    public final void setOnCloseClickListener(@Nullable OnCloseClickListener listener) {
        this.mCloseClickListener = listener;
    }

    public final void setPickerActionListener(@Nullable PickerActionListener listener) {
        Log.i(TAG, "setPickerActionListener()");
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        spenColorPickerControl.setColorPickerActionListener(listener);
    }

    public final void setPickerChangedListener(@Nullable PickerChangedListener listener) {
        Log.i(TAG, "setPickerChangedListener()");
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        spenColorPickerControl.setColorPickerChangeListener(listener);
    }

    public final void setPickerEyedropperActionListener(@Nullable PickerEyedropperActionListener listener) {
        Log.i(TAG, "setPickerEyedropperActionListener() ");
        SpenColorPickerView spenColorPickerView = this.mPickerView;
        if (spenColorPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerView");
            spenColorPickerView = null;
        }
        spenColorPickerView.setEyedropperClickListener(listener);
    }

    public final void setRecentColors(@Nullable float[] recentColors, int numOfColor) {
        if (recentColors != null) {
            AbstractC6670b.m4744e(numOfColor, recentColors.length, "setRecentColors() numOfColors=", " size=", TAG);
        }
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        spenColorPickerControl.setRecentColors(recentColors, numOfColor);
    }

    public final void setRoundedBackground(int radius, int bgColor, int strokeSize, int strokeColor) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(radius, bgColor, "setRoundedBackground() radius=", " bgColor=", "strokeSize=");
        sbM1173s.append(strokeSize);
        sbM1173s.append(" strokeColor=");
        sbM1173s.append(strokeColor);
        Log.i(TAG, sbM1173s.toString());
        View viewFindViewById = findViewById(C7932R.id.top_bg);
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(SpenSettingUtilDrawable.getRoundedCornerDrawable(radius, bgColor, strokeSize, strokeColor));
            viewFindViewById.setClipToOutline(true);
        }
    }

    public final void setViewMode(int i) {
        SpenColorPickerControl spenColorPickerControl = this.mPickerController;
        if (spenColorPickerControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerController");
            spenColorPickerControl = null;
        }
        spenColorPickerControl.setViewMode(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenColorPickerLayout(@NotNull Context context, int i, @Nullable float[] fArr) {
        this(context, i, fArr, false);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
