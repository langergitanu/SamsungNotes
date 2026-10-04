package com.samsung.android.sdk.pen.setting.colorpicker;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilSIP;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.sdk.pen.util.SpenLayoutUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 h2\u00020\u0001:\u0005hijklB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000eB\u0019\b\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000fJ0\u0010(\u001a\u00020)2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u0005J\u0010\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u00010\u0007J\u0010\u00101\u001a\u00020)2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0005J\u0010\u00105\u001a\u00020\t2\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u00108\u001a\u00020)H\u0016J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\tH\u0016J\u0006\u0010<\u001a\u00020)J\u0010\u0010=\u001a\u00020)2\b\u0010>\u001a\u0004\u0018\u00010%J\u0010\u0010?\u001a\u00020)2\b\u0010>\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010@\u001a\u00020)2\b\u0010A\u001a\u0004\u0018\u00010\u001eJ\b\u0010B\u001a\u00020)H\u0016J\b\u0010C\u001a\u00020)H\u0016J\u000e\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020\u0005J\u0006\u0010F\u001a\u00020)J\b\u0010K\u001a\u00020)H\u0002J\b\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u00020)H\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\b\u0010P\u001a\u00020)H\u0002J\b\u0010Q\u001a\u00020)H\u0003J\b\u0010R\u001a\u00020)H\u0002J\b\u0010S\u001a\u00020)H\u0002J\u0010\u0010a\u001a\u00020)2\b\u0010b\u001a\u0004\u0018\u00010 J\b\u0010c\u001a\u00020)H\u0002R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010HR\u000e\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "viewMode", "", "hsvColor", "", "isSupportEyedropper", "", "<init>", "(Landroid/content/Context;I[FZ)V", "hasEyedropper", "hasStorage", "(Landroid/content/Context;I[FZZ)V", "(Landroid/content/Context;[F)V", "mContext", "mColorPicker", "Lcom/samsung/android/sdk/pen/setting/colorpicker/ColorPickerDataViewCore;", "mUtilLayout", "Lcom/samsung/android/sdk/pen/util/SpenLayoutUtil;", "cancelTextView", "Lcom/samsung/android/sdk/pen/setting/common/SpenShowButtonShapeText;", "doneTextView", "mPickerView", "Landroid/view/View;", "mCloseButton", "mColorPickerListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerListener;", "mColorPickerChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerChangedListener;", "mCloseClickListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$OnCloseClickListener;", "mCurrentOrientation", "mParentLayout", "Landroid/widget/RelativeLayout;", "mEyedropperButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$PickerEyedropperButtonListener;", "mIsKeyboardShowing", "mIsSupportRGBCode", "construct", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "getCurrentColor", "hsv", "setCurrentColor", "setRecentColors", "recentColors", "numOfColor", "onTouchEvent", "event", "Landroid/view/MotionEvent;", Constants.IntentExtraValue.SHOW, "parent", "onWindowFocusChanged", "hasFocus", "close", "setColorPickerEyedropperButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setColorPickerListener", "setColorPickerChangeListener", "mListener", "dismiss", "onBackPressed", "setOrientationMode", "orientation", "apply", "getViewMode", "()I", "setViewMode", "(I)V", "doneAction", "notifyDataChanged", "notifyPickerUsage", "saveCurrentColorToRecent", "init", "setListener", "initView", "reInitView", "updateSIPState", "mEyedropperButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerEyedropperListener;", "mCancelButtonClickListener", "Landroid/view/View$OnClickListener;", "mDoneButtonClickListener", "mPickerViewModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewModeChangedListener;", "mPickerActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerActionListener;", "mRGBCodeActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$OnRGBCodeActionListener;", "pickerLayoutWidth", "getPickerLayoutWidth", "setCloseButton", "buttonClickListener", "reconfigureTitleLayout", "mColorViewTouchUpListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewTouchUpListener;", "mFocusListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerFocusListener;", "Companion", "PickerEyedropperButtonListener", "ColorPickerListener", "OnCloseClickListener", "ColorPickerChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@TargetApi(17)
@SourceDebugExtension({"SMAP\nSpenColorPickerPopup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenColorPickerPopup.kt\ncom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,717:1\n1#2:718\n*E\n"})
public final class SpenColorPickerPopup extends Dialog {

    @NotNull
    private static final String COLOR_PICKER_LAYOUT_VERSION = "setting_color_picker_layout";

    @NotNull
    private static final String TAG = "SpenColorPickerPopup";
    private static final int TYPE_CUSTOMIZE = 0;
    public static final int VIEW_MODE_GRADIENT = 1;
    public static final int VIEW_MODE_SWATCH = 2;

    @Nullable
    private SpenShowButtonShapeText cancelTextView;

    @Nullable
    private SpenShowButtonShapeText doneTextView;

    @NotNull
    private final View.OnClickListener mCancelButtonClickListener;

    @Nullable
    private View mCloseButton;

    @Nullable
    private OnCloseClickListener mCloseClickListener;
    private ColorPickerDataViewCore mColorPicker;

    @Nullable
    private ColorPickerChangedListener mColorPickerChangedListener;

    @Nullable
    private ColorPickerListener mColorPickerListener;

    @NotNull
    private final SpenColorViewTouchUpListener mColorViewTouchUpListener;
    private Context mContext;
    private int mCurrentOrientation;

    @NotNull
    private final View.OnClickListener mDoneButtonClickListener;

    @NotNull
    private final SpenColorPickerEyedropperListener mEyedropperButtonClickListener;

    @Nullable
    private PickerEyedropperButtonListener mEyedropperButtonListener;

    @NotNull
    private final SpenColorPickerFocusListener mFocusListener;
    private boolean mIsKeyboardShowing;
    private boolean mIsSupportRGBCode;

    @Nullable
    private RelativeLayout mParentLayout;

    @NotNull
    private final SpenColorPickerActionListener mPickerActionListener;

    @Nullable
    private View mPickerView;

    @NotNull
    private final SpenColorPickerViewModeChangedListener mPickerViewModeChangedListener;

    @NotNull
    private final SpenColorPickerView.OnRGBCodeActionListener mRGBCodeActionListener;

    @Nullable
    private SpenLayoutUtil mUtilLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerChangedListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataChangedListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewModeChangedListener;", "onColorChanged", "", "color", "", "hsvColor", "", "onViewModeChanged", "viewMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ColorPickerChangedListener extends SpenColorPickerDataChangedListener, SpenColorPickerViewModeChangedListener {
        @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
        void onColorChanged(int color, @NotNull float[] hsvColor);

        void onViewModeChanged(int viewMode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerListener;", "", "onColorPickerUsage", "", "type", "", "onColorCirclePressed", "onColorSeekBarPressed", "onRecentColorSelected", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ColorPickerListener {
        void onColorCirclePressed();

        void onColorPickerUsage(int type);

        void onColorSeekBarPressed();

        void onRecentColorSelected();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$OnCloseClickListener;", "", "onCloseButtonClick", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnCloseClickListener {
        void onCloseButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$PickerEyedropperButtonListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerEyedropperListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PickerEyedropperButtonListener extends SpenColorPickerEyedropperListener {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenColorPickerPopup(@NotNull Context context, int i, @NotNull float[] hsvColor, boolean z) {
        this(context, i, hsvColor, z, true);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
    }

    private final void construct(Context context, int viewMode, float[] hsvColor, boolean hasEyedropper, boolean hasStorage) {
        this.mContext = context;
        this.mColorPicker = new ColorPickerDataViewCore(context, viewMode, hsvColor, hasEyedropper, this.mIsSupportRGBCode, hasStorage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doneAction() {
        notifyDataChanged();
        notifyPickerUsage();
        saveCurrentColorToRecent();
        dismiss();
    }

    private final int getPickerLayoutWidth() {
        if (this.mCurrentOrientation != 1) {
            return -1;
        }
        Context context = this.mContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_picker_color_area_min_width);
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context3 = null;
        }
        int i = context3.getResources().getDisplayMetrics().widthPixels;
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context4 = null;
        }
        boolean z = AbstractC0541b.m759a(context4) == 1;
        if (i >= dimensionPixelSize) {
            if (!z) {
                return -1;
            }
            float f = i;
            Context context5 = this.mContext;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context2 = context5;
            }
            Log.i(TAG, "isRTL = TRUE dp=" + (f / context2.getResources().getDisplayMetrics().density));
            final Window window = getWindow();
            if (window != null) {
                window.getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$pickerLayoutWidth$1$1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        window.getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AbstractC2322a.m1631u(window.getDecorView().getRootView().getWidth(), "[onGlobarlLayout()] rootView width= ", "SpenColorPickerPopup");
                        int width = window.getDecorView().getRootView().getWidth();
                        View view = this.mPickerView;
                        if (view != null) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.width = width - 1;
                            view.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }
        return dimensionPixelSize;
    }

    private final void init() {
        Log.i(TAG, "init()");
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        ColorPickerDataViewCore colorPickerDataViewCore2 = null;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        colorPickerDataViewCore.clearPickerView();
        this.mPickerView = null;
        RelativeLayout relativeLayout = this.mParentLayout;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        this.mParentLayout = null;
        initView();
        if (this.mCurrentOrientation == 1) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            int statusBarHeight = SpenSettingUtil.getStatusBarHeight(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = statusBarHeight;
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            layoutParams.bottomMargin = context2.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_picker_popup_margin_bottom);
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context3 = null;
            }
            layoutParams.setMarginStart(context3.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_picker_popup_margin_side));
            layoutParams.setMarginEnd(layoutParams.getMarginStart());
            View view = this.mParentLayout;
            if (view != null) {
                setContentView(view, layoutParams);
            }
        } else {
            View view2 = this.mParentLayout;
            if (view2 != null) {
                setContentView(view2);
            }
        }
        setListener();
        if (this.mCloseClickListener != null) {
            reconfigureTitleLayout();
            ColorPickerDataViewCore colorPickerDataViewCore3 = this.mColorPicker;
            if (colorPickerDataViewCore3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
                colorPickerDataViewCore3 = null;
            }
            colorPickerDataViewCore3.setColorViewTouchUpListener(this.mColorViewTouchUpListener);
        }
        ColorPickerDataViewCore colorPickerDataViewCore4 = this.mColorPicker;
        if (colorPickerDataViewCore4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
        } else {
            colorPickerDataViewCore2 = colorPickerDataViewCore4;
        }
        colorPickerDataViewCore2.loadRecentColors();
    }

    @TargetApi(17)
    private final void initView() {
        Log.i(TAG, "initView()");
        SpenColorPickerViewInfo spenColorPickerViewInfo = new SpenColorPickerViewInfo();
        if (this.mIsSupportRGBCode) {
            spenColorPickerViewInfo.layoutId = C7932R.layout.setting_color_picker_view_oneui30;
            spenColorPickerViewInfo.modeType = 1;
        } else {
            spenColorPickerViewInfo.layoutId = C7932R.layout.setting_color_picker_view;
            spenColorPickerViewInfo.modeType = 0;
        }
        spenColorPickerViewInfo.itemLayoutId = C7932R.layout.setting_color_swatch_item;
        spenColorPickerViewInfo.gradientCursorSizeDimen = C7932R.dimen.color_picker_popup_content_point_size;
        spenColorPickerViewInfo.gradientCursorOutlineDimen = C7932R.dimen.color_picker_popup_content_point_outline;
        int i = C7932R.dimen.setting_color_picker_color_swatch_margin_start;
        spenColorPickerViewInfo.gradientSelectorRadiusDimen = i;
        spenColorPickerViewInfo.gradientHeightDimen = C7932R.dimen.setting_color_picker_color_gradient_height;
        spenColorPickerViewInfo.swatchTopMarginDimen = C7932R.dimen.setting_color_picker_color_swatch_margin_top;
        spenColorPickerViewInfo.swatchStartMarginDimen = i;
        spenColorPickerViewInfo.swatchEndMarginDimen = C7932R.dimen.setting_color_picker_color_swatch_margin_end;
        spenColorPickerViewInfo.swatchBottomMarginDimen = C7932R.dimen.setting_color_picker_color_swatch_margin_bottom;
        spenColorPickerViewInfo.gradientModeBtnSize = C7932R.dimen.setting_color_picker_popup_gradient_mode_btn_size;
        spenColorPickerViewInfo.gradientModeBtnStartMargin = C7932R.dimen.setting_color_picker_popup_gradient_mode_btn_margin_start;
        spenColorPickerViewInfo.swatchModeBtnSize = C7932R.dimen.setting_color_picker_popup_swatch_mode_btn_size;
        spenColorPickerViewInfo.swatchModeBtnStartMargin = C7932R.dimen.setting_color_picker_popup_swatch_mode_btn_margin_start;
        spenColorPickerViewInfo.colorDisplayRadius = C7932R.dimen.setting_color_picker_popup_color_display_radius;
        spenColorPickerViewInfo.eyedropperBgResourceId = C7932R.drawable.color_picker_recent_eyedropper;
        SpenLayoutUtil spenLayoutUtil = this.mUtilLayout;
        View layout = spenLayoutUtil != null ? spenLayoutUtil.getLayout(COLOR_PICKER_LAYOUT_VERSION) : null;
        Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) layout;
        RelativeLayout relativeLayout = viewGroup instanceof RelativeLayout ? (RelativeLayout) viewGroup : null;
        this.mParentLayout = relativeLayout;
        View viewFindViewById = relativeLayout != null ? relativeLayout.findViewById(C7932R.id.popup_content_view) : null;
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) viewFindViewById;
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        this.mPickerView = colorPickerDataViewCore.initPickerView(context, spenColorPickerViewInfo);
        frameLayout.addView(this.mPickerView, new ViewGroup.LayoutParams(getPickerLayoutWidth(), -2));
        RelativeLayout relativeLayout2 = this.mParentLayout;
        View viewFindViewById2 = relativeLayout2 != null ? relativeLayout2.findViewById(C7932R.id.color_picker_button_cancel) : null;
        this.cancelTextView = viewFindViewById2 instanceof SpenShowButtonShapeText ? (SpenShowButtonShapeText) viewFindViewById2 : null;
        RelativeLayout relativeLayout3 = this.mParentLayout;
        View viewFindViewById3 = relativeLayout3 != null ? relativeLayout3.findViewById(C7932R.id.color_picker_button_done) : null;
        this.doneTextView = viewFindViewById3 instanceof SpenShowButtonShapeText ? (SpenShowButtonShapeText) viewFindViewById3 : null;
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context2 = null;
        }
        SpenSettingUtilText.setTypeFace(context2, SpenSettingUtilText.FontName.MEDIUM, this.cancelTextView, this.doneTextView);
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context3 = null;
        }
        SpenSettingUtilText.applyUpToLargeLevel(context3, 18.0f, this.cancelTextView, this.doneTextView);
        SpenShowButtonShapeText spenShowButtonShapeText = this.cancelTextView;
        if (spenShowButtonShapeText != null) {
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context4 = null;
            }
            String string = context4.getResources().getString(C7932R.string.pen_string_cancel);
            Context context5 = this.mContext;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context5 = null;
            }
            spenShowButtonShapeText.setContentDescription(string + " " + context5.getResources().getString(C7932R.string.pen_string_button));
        }
        SpenShowButtonShapeText spenShowButtonShapeText2 = this.doneTextView;
        if (spenShowButtonShapeText2 != null) {
            Context context6 = this.mContext;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context6 = null;
            }
            String string2 = context6.getResources().getString(C7932R.string.pen_string_done);
            Context context7 = this.mContext;
            if (context7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context7 = null;
            }
            spenShowButtonShapeText2.setContentDescription(string2 + " " + context7.getResources().getString(C7932R.string.pen_string_button));
        }
        SpenShowButtonShapeText spenShowButtonShapeText3 = this.cancelTextView;
        if (spenShowButtonShapeText3 != null) {
            spenShowButtonShapeText3.setButtonShapeEnabled(true);
        }
        SpenShowButtonShapeText spenShowButtonShapeText4 = this.doneTextView;
        if (spenShowButtonShapeText4 != null) {
            spenShowButtonShapeText4.setButtonShapeEnabled(true);
        }
        RelativeLayout relativeLayout4 = this.mParentLayout;
        View viewFindViewById4 = relativeLayout4 != null ? relativeLayout4.findViewById(C7932R.id.content_main) : null;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setFocusable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDataChanged() {
        if (this.mColorPickerChangedListener == null) {
            return;
        }
        float[] fArr = new float[3];
        getCurrentColor(fArr);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]), Integer.valueOf(SpenSettingUtil.HSVToColor(fArr))}, 4, "HSV[%f,%f,%f] %08X", "format(format, *args)", TAG);
        float f = fArr[1];
        if (f > 1.0f) {
            Log.i(TAG, "HSV is wrong. current=" + f + " change=1");
            fArr[1] = 1.0f;
        }
        ColorPickerChangedListener colorPickerChangedListener = this.mColorPickerChangedListener;
        if (colorPickerChangedListener != null) {
            colorPickerChangedListener.onColorChanged(SpenSettingUtil.HSVToColor(fArr), fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPickerUsage() {
        ColorPickerListener colorPickerListener = this.mColorPickerListener;
        if (colorPickerListener != null) {
            colorPickerListener.onColorPickerUsage(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[PHI: r1
      0x0058: PHI (r1v1 int) = (r1v0 int), (r1v16 int), (r1v16 int) binds: [B:7:0x0013, B:15:0x002e, B:17:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void reInitView() {
        int selectionEnd;
        SpenShowButtonShapeText spenShowButtonShapeText;
        SpenShowButtonShapeText spenShowButtonShapeText2 = this.doneTextView;
        int viewFocusID = 0;
        boolean zIsFocused = spenShowButtonShapeText2 != null ? spenShowButtonShapeText2.isFocused() : false;
        Context context = null;
        if (this.mIsSupportRGBCode) {
            updateSIPState();
            ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
            if (colorPickerDataViewCore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
                colorPickerDataViewCore = null;
            }
            viewFocusID = colorPickerDataViewCore.getViewFocusID();
            RelativeLayout relativeLayout = this.mParentLayout;
            View viewFindViewById = relativeLayout != null ? relativeLayout.findViewById(viewFocusID) : null;
            if (viewFindViewById == null || !(viewFindViewById instanceof EditText)) {
                selectionEnd = -1;
            } else {
                EditText editText = (EditText) viewFindViewById;
                selectionEnd = editText.getSelectionStart() == editText.getSelectionEnd() ? editText.getSelectionEnd() : -1;
                if (this.mIsKeyboardShowing) {
                    Context context2 = this.mContext;
                    if (context2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context2 = null;
                    }
                    SpenSettingUtilSIP.showSoftInput(context2, viewFindViewById, 2);
                }
            }
        }
        float[] fArr = new float[3];
        ColorPickerDataViewCore colorPickerDataViewCore2 = this.mColorPicker;
        if (colorPickerDataViewCore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore2 = null;
        }
        colorPickerDataViewCore2.getCurrentColor(fArr);
        init();
        ColorPickerDataViewCore colorPickerDataViewCore3 = this.mColorPicker;
        if (colorPickerDataViewCore3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore3 = null;
        }
        colorPickerDataViewCore3.setCurrentColor(fArr);
        if (zIsFocused && (spenShowButtonShapeText = this.doneTextView) != null) {
            spenShowButtonShapeText.requestFocus();
        }
        if (!this.mIsSupportRGBCode || viewFocusID == 0) {
            return;
        }
        RelativeLayout relativeLayout2 = this.mParentLayout;
        View viewFindViewById2 = relativeLayout2 != null ? relativeLayout2.findViewById(viewFocusID) : null;
        if (viewFindViewById2 == null || !(viewFindViewById2 instanceof EditText)) {
            Log.i(TAG, "reInitView() - lost focus view");
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context3;
            }
            SpenSettingUtilSIP.forceHideSoftInput(context, viewFindViewById2);
            updateSIPState();
            return;
        }
        EditText editText2 = (EditText) viewFindViewById2;
        editText2.setFocusable(true);
        editText2.setFocusableInTouchMode(true);
        editText2.requestFocus();
        if (selectionEnd != -1) {
            editText2.setSelection(selectionEnd);
        }
        if (this.mIsKeyboardShowing) {
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context4 = null;
            }
            if (SpenSettingUtilSIP.isSIPShowing(context4)) {
                return;
            }
            Context context5 = this.mContext;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context5;
            }
            SpenSettingUtilSIP.showSoftInput(context, viewFindViewById2, 1);
        }
    }

    private final void reconfigureTitleLayout() {
        RelativeLayout relativeLayout = this.mParentLayout;
        if (relativeLayout == null || this.mCloseClickListener == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) relativeLayout.findViewById(C7932R.id.color_picker_top_layout);
        RelativeLayout relativeLayout2 = this.mParentLayout;
        Context context = null;
        ViewGroup viewGroup2 = relativeLayout2 != null ? (ViewGroup) relativeLayout2.findViewById(C7932R.id.color_picker_button_layout) : null;
        RelativeLayout relativeLayout3 = this.mParentLayout;
        View viewFindViewById = relativeLayout3 != null ? relativeLayout3.findViewById(C7932R.id.picker_close_button) : null;
        this.mCloseButton = viewFindViewById;
        if (viewGroup == null || viewGroup2 == null || viewFindViewById == null) {
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup2.setVisibility(8);
        this.doneTextView = null;
        this.cancelTextView = null;
        RelativeLayout relativeLayout4 = this.mParentLayout;
        LinearLayout linearLayout = relativeLayout4 != null ? (LinearLayout) relativeLayout4.findViewById(C7932R.id.content_main) : null;
        if (linearLayout != null) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            linearLayout.setPadding(0, 0, 0, context2.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_picker_bottom_padding));
        }
        View view = this.mCloseButton;
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context3;
        }
        SpenSettingUtilHover.setHoverText(view, context.getResources().getString(C7932R.string.pen_string_close));
        View view2 = this.mCloseButton;
        if (view2 != null) {
            view2.setOnClickListener(new ViewOnClickListenerC7540b(this, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reconfigureTitleLayout$lambda$8(SpenColorPickerPopup spenColorPickerPopup, View view) {
        OnCloseClickListener onCloseClickListener = spenColorPickerPopup.mCloseClickListener;
        if (onCloseClickListener != null) {
            onCloseClickListener.onCloseButtonClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveCurrentColorToRecent() {
        if (this.mUtilLayout == null) {
            return;
        }
        float[] fArr = {0.0f, 0.0f, 0.0f};
        if (getCurrentColor(fArr)) {
            ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
            if (colorPickerDataViewCore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
                colorPickerDataViewCore = null;
            }
            colorPickerDataViewCore.saveRecentColor(fArr);
        }
    }

    private final void setListener() {
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        colorPickerDataViewCore.setViewModeChangedListener(this.mPickerViewModeChangedListener);
        colorPickerDataViewCore.setPickerActionListener(this.mPickerActionListener);
        colorPickerDataViewCore.setPickerEyedropperActionListener(this.mEyedropperButtonClickListener);
        colorPickerDataViewCore.setRGBCodeActionListener(this.mRGBCodeActionListener);
        colorPickerDataViewCore.setFocusListener(this.mFocusListener);
        SpenShowButtonShapeText spenShowButtonShapeText = this.cancelTextView;
        if (spenShowButtonShapeText != null) {
            spenShowButtonShapeText.setOnClickListener(this.mCancelButtonClickListener);
        }
        SpenShowButtonShapeText spenShowButtonShapeText2 = this.doneTextView;
        if (spenShowButtonShapeText2 != null) {
            spenShowButtonShapeText2.setOnClickListener(this.mDoneButtonClickListener);
        }
    }

    private final void updateSIPState() {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        this.mIsKeyboardShowing = SpenSettingUtilSIP.isSIPShowing(context);
    }

    public final void apply() {
        doneAction();
    }

    public final void close() {
        Log.i(TAG, "Color picker close!");
        this.mColorPickerChangedListener = null;
        this.mColorPickerListener = null;
        this.mEyedropperButtonListener = null;
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        colorPickerDataViewCore.close();
        this.mCloseButton = null;
        this.mPickerView = null;
        this.cancelTextView = null;
        this.doneTextView = null;
        this.mParentLayout = null;
        this.mUtilLayout = null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mIsSupportRGBCode) {
            SpenSettingUtilSIP.forceHideSoftInput(getContext(), this.mParentLayout);
        }
        super.dismiss();
        Log.i(TAG, "dismiss");
        close();
    }

    public final boolean getCurrentColor(@Nullable float[] hsv) {
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        return colorPickerDataViewCore.getCurrentColor(hsv);
    }

    public final int getViewMode() {
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        return colorPickerDataViewCore.getViewMode();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        close();
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this.mContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        int i = context.getResources().getConfiguration().orientation;
        this.mCurrentOrientation = i;
        Log.i(TAG, "onCreate() mCurrentOrientation=" + i);
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context2 = context3;
        }
        this.mUtilLayout = new SpenLayoutUtil(context2);
        init();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            dismiss();
        }
        return super.onTouchEvent(event);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (this.mIsSupportRGBCode) {
            Context context = null;
            if (!hasFocus) {
                updateSIPState();
                Context context2 = this.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context2;
                }
                SpenSettingUtilSIP.forceHideSoftInput(context, getCurrentFocus());
                return;
            }
            if (this.mParentLayout == null) {
                return;
            }
            ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
            if (colorPickerDataViewCore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
                colorPickerDataViewCore = null;
            }
            int viewFocusID = colorPickerDataViewCore.getViewFocusID();
            RelativeLayout relativeLayout = this.mParentLayout;
            View viewFindViewById = relativeLayout != null ? relativeLayout.findViewById(viewFocusID) : null;
            if (viewFindViewById == null || !(viewFindViewById instanceof EditText)) {
                return;
            }
            EditText editText = (EditText) viewFindViewById;
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            if (this.mIsKeyboardShowing) {
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context3;
                }
                SpenSettingUtilSIP.showSoftInput(context, viewFindViewById, 0);
            }
        }
    }

    public final void setCloseButton(@Nullable OnCloseClickListener buttonClickListener) {
        this.mCloseClickListener = buttonClickListener;
        if (buttonClickListener != null) {
            reconfigureTitleLayout();
            ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
            if (colorPickerDataViewCore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
                colorPickerDataViewCore = null;
            }
            colorPickerDataViewCore.setColorViewTouchUpListener(this.mColorViewTouchUpListener);
        }
    }

    public final void setColorPickerChangeListener(@Nullable ColorPickerChangedListener mListener) {
        this.mColorPickerChangedListener = mListener;
    }

    public final void setColorPickerEyedropperButtonListener(@Nullable PickerEyedropperButtonListener listener) {
        this.mEyedropperButtonListener = listener;
    }

    public final void setColorPickerListener(@Nullable ColorPickerListener listener) {
        this.mColorPickerListener = listener;
    }

    public final void setColorTheme(int theme) {
        AbstractC2322a.m1631u(theme, "setColorTheme() theme=", TAG);
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        colorPickerDataViewCore.setColorTheme(theme);
    }

    public final void setCurrentColor(@Nullable float[] hsvColor) {
        if (hsvColor == null) {
            Log.i(TAG, "setCurrentColor() invalid state.");
            return;
        }
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        colorPickerDataViewCore.setCurrentColor(hsvColor);
    }

    public final void setOrientationMode(int orientation) {
        AbstractC2322a.m1631u(orientation, "setOrientationMode = ", TAG);
        if (orientation != 1 && orientation != 2 && this.mCurrentOrientation == orientation) {
            Log.i(TAG, "orientation is wrong. so not apply and return.");
            return;
        }
        this.mCurrentOrientation = orientation;
        if (this.mParentLayout == null) {
            Log.i(TAG, "parnetLayout is null.");
        } else {
            Log.i(TAG, "parnetLayout is not null.");
            reInitView();
        }
    }

    public final void setRecentColors(@NotNull float[] recentColors, int numOfColor) {
        Intrinsics.checkNotNullParameter(recentColors, "recentColors");
        Log.i(TAG, "setRecentColors() numOfColors=" + numOfColor);
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        colorPickerDataViewCore.setRecentColors(recentColors, numOfColor);
    }

    public final void setViewMode(int i) {
        ColorPickerDataViewCore colorPickerDataViewCore = this.mColorPicker;
        if (colorPickerDataViewCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
            colorPickerDataViewCore = null;
        }
        colorPickerDataViewCore.setViewMode(i);
    }

    @SuppressLint({"InlinedApi"})
    public final void show(@Nullable View parent) {
        show();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorPickerPopup(@NotNull Context context, int i, @NotNull float[] hsvColor, boolean z, boolean z2) {
        super(context, C7932R.style.ColorPickerPopupDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mCurrentOrientation = 1;
        this.mEyedropperButtonClickListener = new SpenColorPickerEyedropperListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mEyedropperButtonClickListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerEyedropperListener
            public void onEyedropperButtonClicked() {
                SpenColorPickerPopup.PickerEyedropperButtonListener pickerEyedropperButtonListener = this.this$0.mEyedropperButtonListener;
                if (pickerEyedropperButtonListener != null) {
                    pickerEyedropperButtonListener.onEyedropperButtonClicked();
                }
            }
        };
        this.mCancelButtonClickListener = new ViewOnClickListenerC7540b(this, 0);
        this.mDoneButtonClickListener = new ViewOnClickListenerC7540b(this, 1);
        this.mPickerViewModeChangedListener = new SpenColorPickerViewModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mPickerViewModeChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerViewModeChangedListener
            public void onViewModeChanged(int viewMode) {
                AbstractC2322a.m1631u(viewMode, "onModeChanged() mode=", "SpenColorPickerPopup");
                SpenColorPickerPopup.ColorPickerChangedListener colorPickerChangedListener = this.this$0.mColorPickerChangedListener;
                if (colorPickerChangedListener != null) {
                    colorPickerChangedListener.onViewModeChanged(viewMode);
                }
            }
        };
        this.mPickerActionListener = new SpenColorPickerActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mPickerActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
            public void onColorPickerChanged(int mode) {
                SpenColorPickerPopup.ColorPickerListener colorPickerListener = this.this$0.mColorPickerListener;
                if (colorPickerListener != null) {
                    colorPickerListener.onColorCirclePressed();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
            public void onColorSeekBarChanged() {
                SpenColorPickerPopup.ColorPickerListener colorPickerListener = this.this$0.mColorPickerListener;
                if (colorPickerListener != null) {
                    colorPickerListener.onColorSeekBarPressed();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
            public void onRecentColorSelected() {
                SpenColorPickerPopup.ColorPickerListener colorPickerListener = this.this$0.mColorPickerListener;
                if (colorPickerListener != null) {
                    colorPickerListener.onRecentColorSelected();
                }
            }
        };
        this.mRGBCodeActionListener = new SpenColorPickerView.OnRGBCodeActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mRGBCodeActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView.OnRGBCodeActionListener
            public void onActionDone() {
                Context context2 = this.this$0.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                SpenSettingUtilSIP.forceHideSoftInput(context2, this.this$0.getCurrentFocus());
            }
        };
        this.mColorViewTouchUpListener = new SpenColorViewTouchUpListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mColorViewTouchUpListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewTouchUpListener
            public void onTouchUp() {
                this.this$0.notifyDataChanged();
                this.this$0.notifyPickerUsage();
                this.this$0.saveCurrentColorToRecent();
                ColorPickerDataViewCore colorPickerDataViewCore = this.this$0.mColorPicker;
                if (colorPickerDataViewCore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
                    colorPickerDataViewCore = null;
                }
                colorPickerDataViewCore.loadRecentColors();
            }
        };
        this.mFocusListener = new SpenColorPickerFocusListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mFocusListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerFocusListener
            public void onFocused() {
                Window window = this.this$0.getWindow();
                View decorView = window != null ? window.getDecorView() : null;
                if (decorView == null || 2 != (decorView.getSystemUiVisibility() & 2)) {
                    return;
                }
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-3));
            }
        };
        SpenSettingUtil.initDialogWindow(this, 5376, -1);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(256, 256);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setFlags(8, 8);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setSoftInputMode(33);
        }
        this.mIsSupportRGBCode = true;
        construct(context, i, hsvColor, z, z2);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.mIsSupportRGBCode && !this.mIsKeyboardShowing) {
            SpenSettingUtilSIP.forceHideSoftInput(getContext(), getCurrentFocus());
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        if (context instanceof Activity) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            View decorView = ((Activity) context2).getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            if ((decorView.getSystemUiVisibility() & 2) != 0) {
                Window window = getWindow();
                View decorView2 = window != null ? window.getDecorView() : null;
                if (decorView2 != null) {
                    decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 2);
                }
            }
        }
        super.show();
        Window window2 = getWindow();
        if (window2 != null) {
            window2.clearFlags(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "")
    public SpenColorPickerPopup(@NotNull Context context, @NotNull float[] hsvColor) {
        super(context, C7932R.style.ColorPickerPopupDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mCurrentOrientation = 1;
        this.mEyedropperButtonClickListener = new SpenColorPickerEyedropperListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mEyedropperButtonClickListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerEyedropperListener
            public void onEyedropperButtonClicked() {
                SpenColorPickerPopup.PickerEyedropperButtonListener pickerEyedropperButtonListener = this.this$0.mEyedropperButtonListener;
                if (pickerEyedropperButtonListener != null) {
                    pickerEyedropperButtonListener.onEyedropperButtonClicked();
                }
            }
        };
        this.mCancelButtonClickListener = new ViewOnClickListenerC7540b(this, 0);
        this.mDoneButtonClickListener = new ViewOnClickListenerC7540b(this, 1);
        this.mPickerViewModeChangedListener = new SpenColorPickerViewModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mPickerViewModeChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerViewModeChangedListener
            public void onViewModeChanged(int viewMode) {
                AbstractC2322a.m1631u(viewMode, "onModeChanged() mode=", "SpenColorPickerPopup");
                SpenColorPickerPopup.ColorPickerChangedListener colorPickerChangedListener = this.this$0.mColorPickerChangedListener;
                if (colorPickerChangedListener != null) {
                    colorPickerChangedListener.onViewModeChanged(viewMode);
                }
            }
        };
        this.mPickerActionListener = new SpenColorPickerActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mPickerActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
            public void onColorPickerChanged(int mode) {
                SpenColorPickerPopup.ColorPickerListener colorPickerListener = this.this$0.mColorPickerListener;
                if (colorPickerListener != null) {
                    colorPickerListener.onColorCirclePressed();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
            public void onColorSeekBarChanged() {
                SpenColorPickerPopup.ColorPickerListener colorPickerListener = this.this$0.mColorPickerListener;
                if (colorPickerListener != null) {
                    colorPickerListener.onColorSeekBarPressed();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
            public void onRecentColorSelected() {
                SpenColorPickerPopup.ColorPickerListener colorPickerListener = this.this$0.mColorPickerListener;
                if (colorPickerListener != null) {
                    colorPickerListener.onRecentColorSelected();
                }
            }
        };
        this.mRGBCodeActionListener = new SpenColorPickerView.OnRGBCodeActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mRGBCodeActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView.OnRGBCodeActionListener
            public void onActionDone() {
                Context context2 = this.this$0.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                SpenSettingUtilSIP.forceHideSoftInput(context2, this.this$0.getCurrentFocus());
            }
        };
        this.mColorViewTouchUpListener = new SpenColorViewTouchUpListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mColorViewTouchUpListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewTouchUpListener
            public void onTouchUp() {
                this.this$0.notifyDataChanged();
                this.this$0.notifyPickerUsage();
                this.this$0.saveCurrentColorToRecent();
                ColorPickerDataViewCore colorPickerDataViewCore = this.this$0.mColorPicker;
                if (colorPickerDataViewCore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mColorPicker");
                    colorPickerDataViewCore = null;
                }
                colorPickerDataViewCore.loadRecentColors();
            }
        };
        this.mFocusListener = new SpenColorPickerFocusListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup$mFocusListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerFocusListener
            public void onFocused() {
                Window window = this.this$0.getWindow();
                View decorView = window != null ? window.getDecorView() : null;
                if (decorView == null || 2 != (decorView.getSystemUiVisibility() & 2)) {
                    return;
                }
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-3));
            }
        };
        SpenSettingUtil.initDialogWindow(this, 4096, -1);
        this.mIsSupportRGBCode = false;
        construct(context, 2, hsvColor, false, true);
    }
}
