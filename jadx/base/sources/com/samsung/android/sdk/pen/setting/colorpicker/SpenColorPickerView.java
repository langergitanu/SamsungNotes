package com.samsung.android.sdk.pen.setting.colorpicker;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView;
import com.samsung.android.sdk.pen.setting.common.SpenTabGroup;
import com.samsung.android.sdk.pen.setting.util.SpenRecoilDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilColor;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilImage;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\b\u0000\u0018\u0000 \u007f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0007\u007f\u0080\u0001\u0081\u0001\u0082\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010A2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q2\u0006\u0010,\u001a\u00020QH\u0016J\u0018\u0010S\u001a\u00020M2\u0006\u0010T\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\rH\u0016J\u0010\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020XH\u0016J\u0006\u0010Y\u001a\u00020MJ\u0010\u0010Z\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u000101J\u0010\u0010\\\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u000103J\u0010\u0010]\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u000105J\u0010\u0010^\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u000107J\u0010\u0010_\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u00010;J\u001a\u0010`\u001a\u00020M2\b\u0010a\u001a\u0004\u0018\u00010\t2\b\u0010b\u001a\u0004\u0018\u00010\tJ\u000e\u0010c\u001a\u00020\r2\u0006\u0010O\u001a\u00020\tJ\u000e\u0010d\u001a\u00020M2\u0006\u0010O\u001a\u00020\tJ\u000e\u0010e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010f\u001a\u00020M2\b\u0010g\u001a\u0004\u0018\u00010\t2\u0006\u0010h\u001a\u00020\u0007J\u0018\u0010i\u001a\u00020M2\u0006\u0010j\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\u0007H\u0002J\u0010\u0010k\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u000109J\u0010\u0010l\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010m\u001a\u00020M2\u0006\u0010n\u001a\u00020\u001bH\u0002J\u0018\u0010o\u001a\u00020M2\u0006\u0010n\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010p\u001a\u00020MH\u0002J\u001a\u0010q\u001a\u00020M2\b\u0010j\u001a\u0004\u0018\u00010\u001b2\u0006\u0010O\u001a\u00020\tH\u0002J \u0010r\u001a\u00020M2\u0006\u0010j\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\t2\u0006\u0010s\u001a\u00020AH\u0002J\b\u0010t\u001a\u00020MH\u0002J\u0010\u0010u\u001a\u00020M2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010v\u001a\u00020M2\u0006\u0010w\u001a\u00020\u0007H\u0002J\u0010\u0010x\u001a\u00020M2\u0006\u0010y\u001a\u00020\u001bH\u0002J \u0010|\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u001b2\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u0007H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010z\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{¨\u0006\u0083\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView;", "Landroid/widget/LinearLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColorEventListener;", "Landroid/view/View$OnFocusChangeListener;", "context", "Landroid/content/Context;", "mode", "", "hsvColor", "", "viewInfo", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewInfo;", "mIsSupportRGBCode", "", "mIsSupportEyedropper", "<init>", "(Landroid/content/Context;I[FLcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewInfo;ZZ)V", "mContext", "mPickerColor", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColor;", "mOldHsv", "mMode", "mModeButton", "Landroid/widget/ImageButton;", "mPickerTabGroup", "Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup;", "mCurrentColorView", "Landroid/view/View;", "mNewColorView", "mValueSeekBar", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorValueSeekBar;", "mValueSeekBarText", "Landroid/widget/EditText;", "mPickerView", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewInterface;", "mPickerContainer", "mRecentParent", "Landroid/view/ViewGroup;", "mRGBCodeControl", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenRGBCodeControl;", "mHexInputView", "mRedInputView", "mGreenInputView", "mBlueInputView", "value", "focusID", "getFocusID", "()I", "mColorListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$ColorListener;", "mModeChangeListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$OnModeChangeListener;", "mEyedropperClickListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerEyedropperListener;", "mRgbCodeActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$OnRGBCodeActionListener;", "mColorViewTouchUpListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewTouchUpListener;", "mColorPickerFocusListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerFocusListener;", "mRecentColors", "", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenHSVColor;", "mPickerViewInfo", "mCurrentColorString", "", "mNewColorString", "mColorNameHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilColor;", "mDefaultPostfix", "mUndefinedColorName", "mModeButtonClickListener", "Landroid/view/View$OnClickListener;", "mRecentColorClickListener", "mOnEditorActionListener", "Landroid/widget/TextView$OnEditorActionListener;", Constants.ARG_UPDATE, "", "who", "color", "hue", "", "saturation", "onFocusChange", VPathDataCmd.RCurveTo, "hasFocus", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "close", "setColorListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setModeChangeListener", "setEyedropperClickListener", "setRgbCodeActionListener", "setFocusListener", "setColor", "old", "current", "getCurrentColor", "setCurrentColor", "setMode", "setRecentColors", "recentColors", "numOfColor", "setColorContentDescription", "view", "setColorViewTouchUpListener", "construct", "initRGBTitleText", "parentView", "initTabGroup", "updateNewColor", "setDisplayColor", "setColorAccessibility", "description", "toggleMode", "changeMode", "notifyColorSelected", "type", "initEyedropperButton", "eyedropperButton", "isSupportModeChange", "()Z", "checkViewConstainsPoint", "pointX", "pointY", "Companion", "ColorListener", "OnModeChangeListener", "OnRGBCodeActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorPickerView extends LinearLayout implements SpenPickerColorEventListener, View.OnFocusChangeListener {
    private static final int RECENT_COLOR_BUTTON_MAX = 6;

    @NotNull
    private static final String TAG = "SpenColorPickerView";
    public static final int VIEW_MODE_GRADIENT = 1;
    public static final int VIEW_MODE_SWATCH = 2;
    private int focusID;

    @Nullable
    private EditText mBlueInputView;

    @Nullable
    private ColorListener mColorListener;

    @NotNull
    private SpenSettingUtilColor mColorNameHelper;

    @Nullable
    private SpenColorPickerFocusListener mColorPickerFocusListener;

    @Nullable
    private SpenColorViewTouchUpListener mColorViewTouchUpListener;

    @NotNull
    private Context mContext;

    @NotNull
    private final String mCurrentColorString;
    private View mCurrentColorView;

    @NotNull
    private String mDefaultPostfix;

    @Nullable
    private SpenColorPickerEyedropperListener mEyedropperClickListener;

    @Nullable
    private EditText mGreenInputView;

    @Nullable
    private EditText mHexInputView;
    private final boolean mIsSupportEyedropper;
    private final boolean mIsSupportRGBCode;
    private int mMode;

    @Nullable
    private ImageButton mModeButton;

    @NotNull
    private final View.OnClickListener mModeButtonClickListener;

    @Nullable
    private OnModeChangeListener mModeChangeListener;

    @NotNull
    private final String mNewColorString;
    private View mNewColorView;

    @NotNull
    private float[] mOldHsv;

    @NotNull
    private final TextView.OnEditorActionListener mOnEditorActionListener;

    @NotNull
    private SpenPickerColor mPickerColor;
    private LinearLayout mPickerContainer;

    @Nullable
    private SpenTabGroup mPickerTabGroup;

    @Nullable
    private SpenColorViewInterface mPickerView;

    @NotNull
    private SpenColorPickerViewInfo mPickerViewInfo;

    @Nullable
    private SpenRGBCodeControl mRGBCodeControl;

    @NotNull
    private final View.OnClickListener mRecentColorClickListener;
    private List<SpenHSVColor> mRecentColors;
    private ViewGroup mRecentParent;

    @Nullable
    private EditText mRedInputView;

    @Nullable
    private OnRGBCodeActionListener mRgbCodeActionListener;

    @NotNull
    private String mUndefinedColorName;
    private SpenColorValueSeekBar mValueSeekBar;

    @Nullable
    private EditText mValueSeekBarText;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$ColorListener;", "", "onColorSelected", "", "hue", "", "saturation", "value", "type", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ColorListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int TYPE_COLOR = 1;
        public static final int TYPE_RECENT = 3;
        public static final int TYPE_SEEKBAR = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$ColorListener$Companion;", "", "<init>", "()V", "TYPE_COLOR", "", "TYPE_SEEKBAR", "TYPE_RECENT", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int TYPE_COLOR = 1;
            public static final int TYPE_RECENT = 3;
            public static final int TYPE_SEEKBAR = 2;

            private Companion() {
            }
        }

        void onColorSelected(float hue, float saturation, float value, int type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$OnModeChangeListener;", "", "onModeChanged", "", "mode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeChangeListener {
        void onModeChanged(int mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerView$OnRGBCodeActionListener;", "", "onActionDone", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnRGBCodeActionListener {
        void onActionDone();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorPickerView(@NotNull Context context, int i, @NotNull float[] hsvColor, @NotNull SpenColorPickerViewInfo viewInfo, boolean z, boolean z2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        this.mIsSupportRGBCode = z;
        this.mIsSupportEyedropper = z2;
        this.mModeButtonClickListener = new ViewOnClickListenerC7541c(this, 1);
        this.mRecentColorClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView$mRecentColorClickListener$1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                Object tag = view.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) tag).intValue();
                float[] fArr = new float[3];
                List list = this.this$0.mRecentColors;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecentColors");
                    list = null;
                }
                ((SpenHSVColor) list.get(iIntValue)).getHSV(fArr);
                this.this$0.setCurrentColor(fArr);
                this.this$0.notifyColorSelected(3);
                SpenColorViewTouchUpListener spenColorViewTouchUpListener = this.this$0.mColorViewTouchUpListener;
                if (spenColorViewTouchUpListener != null) {
                    spenColorViewTouchUpListener.onTouchUp();
                }
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView$mOnEditorActionListener$1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                if (actionId != 6) {
                    return false;
                }
                if (this.this$0.getFocusID() == 0) {
                    return true;
                }
                LinearLayout linearLayout = this.this$0.mPickerContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPickerContainer");
                    linearLayout = null;
                }
                View viewFindViewById = linearLayout.getRootView().findViewById(this.this$0.getFocusID());
                if (viewFindViewById == null || !(viewFindViewById instanceof EditText)) {
                    return true;
                }
                EditText editText = (EditText) viewFindViewById;
                if (!editText.isFocused() || this.this$0.mRgbCodeActionListener == null) {
                    return true;
                }
                editText.clearFocus();
                SpenColorPickerView.OnRGBCodeActionListener onRGBCodeActionListener = this.this$0.mRgbCodeActionListener;
                if (onRGBCodeActionListener == null) {
                    return true;
                }
                onRGBCodeActionListener.onActionDone();
                return true;
            }
        };
        this.mContext = context;
        SpenPickerColor spenPickerColor = new SpenPickerColor();
        this.mPickerColor = spenPickerColor;
        spenPickerColor.setColor(TAG, 255, hsvColor[0], hsvColor[1], hsvColor[2]);
        this.mOldHsv = new float[]{hsvColor[0], hsvColor[1], hsvColor[2]};
        this.mMode = i;
        this.mPickerViewInfo = new SpenColorPickerViewInfo(viewInfo);
        this.mRecentColors = new ArrayList();
        this.mColorNameHelper = new SpenSettingUtilColor(context, 2);
        Resources resources = context.getResources();
        String string = resources.getString(C7932R.string.pen_string_current_any, resources.getString(C7932R.string.pen_string_color));
        this.mCurrentColorString = string;
        String string2 = resources.getString(C7932R.string.pen_string_new_any, resources.getString(C7932R.string.pen_string_color));
        this.mNewColorString = string2;
        this.mDefaultPostfix = AbstractC0541b.m772n(SQLKeyword.COMMA, resources.getString(C7932R.string.pen_string_button));
        this.mUndefinedColorName = resources.getString(C7932R.string.pen_palette_color_custom);
        float f = hsvColor[0];
        float f4 = hsvColor[1];
        float f5 = hsvColor[2];
        StringBuilder sbM1176v = AbstractC0622a.m1176v("SpenColorPickerLayout() Color[", f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA);
        sbM1176v.append(f5);
        sbM1176v.append("] mIsSupportEyedropper=");
        sbM1176v.append(z2);
        Log.i(TAG, sbM1176v.toString());
        construct(context);
        changeMode(i);
        View view = this.mCurrentColorView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            view = null;
        }
        setDisplayColor(view, this.mOldHsv);
        View view3 = this.mCurrentColorView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            view3 = null;
        }
        setColorAccessibility(view3, this.mOldHsv, string);
        View view4 = this.mNewColorView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNewColorView");
            view4 = null;
        }
        setDisplayColor(view4, hsvColor);
        View view5 = this.mNewColorView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNewColorView");
        } else {
            view2 = view5;
        }
        setColorAccessibility(view2, hsvColor, string2);
        this.mPickerColor.addEventListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12, types: [android.view.View, com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.ViewGroup] */
    private final void changeMode(int mode) {
        int i;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int i2;
        int i4;
        ?? r14;
        Resources resources = this.mContext.getResources();
        if (mode == 1) {
            Context context = this.mContext;
            SpenColorPickerViewInfo spenColorPickerViewInfo = this.mPickerViewInfo;
            SpenColorGradientView spenColorGradientView = new SpenColorGradientView(context, spenColorPickerViewInfo.gradientCursorSizeDimen, spenColorPickerViewInfo.gradientCursorOutlineDimen);
            i4 = C7932R.drawable.note_pensettings_picker_01;
            i = C7932R.string.pen_string_swatch_mode;
            dimensionPixelSize3 = resources.getDimensionPixelSize(this.mPickerViewInfo.gradientHeightDimen);
            spenColorGradientView.setSoundEffectsEnabled(true);
            spenColorGradientView.setClickable(true);
            spenColorGradientView.setFocusable(false);
            spenColorGradientView.setImportantForAccessibility(2);
            dimensionPixelSize = resources.getDimensionPixelSize(this.mPickerViewInfo.gradientModeBtnSize);
            dimensionPixelSize2 = resources.getDimensionPixelSize(this.mPickerViewInfo.gradientModeBtnStartMargin);
            i2 = 0;
            r14 = spenColorGradientView;
        } else {
            SpenColorSwatchView spenColorSwatchView = new SpenColorSwatchView(this.mContext, this.mPickerViewInfo.itemLayoutId, resources.getDimensionPixelSize(this.mPickerViewInfo.swatchStartMarginDimen), resources.getDimensionPixelSize(this.mPickerViewInfo.swatchTopMarginDimen), resources.getDimensionPixelSize(this.mPickerViewInfo.swatchEndMarginDimen), resources.getDimensionPixelSize(this.mPickerViewInfo.swatchBottomMarginDimen));
            int i5 = C7932R.drawable.note_pensettings_picker_02;
            i = C7932R.string.pen_string_spectrum_mode;
            dimensionPixelSize = resources.getDimensionPixelSize(this.mPickerViewInfo.swatchModeBtnSize);
            dimensionPixelSize2 = resources.getDimensionPixelSize(this.mPickerViewInfo.swatchModeBtnStartMargin);
            dimensionPixelSize3 = -2;
            i2 = 8;
            i4 = i5;
            r14 = spenColorSwatchView;
        }
        r14.setPickerColor(this.mPickerColor);
        r14.setTouchUpListener(this.mColorViewTouchUpListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimensionPixelSize3);
        LinearLayout linearLayout = this.mPickerContainer;
        SpenColorValueSeekBar spenColorValueSeekBar = null;
        ?? r5 = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerContainer");
            r5 = 0;
        }
        r5.addView(r14, 0, layoutParams);
        ?? r12 = this.mPickerView;
        if (r12 != 0) {
            LinearLayout linearLayout2 = this.mPickerContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPickerContainer");
                linearLayout2 = null;
            }
            linearLayout2.removeView((View) r12);
            r12.release();
        }
        this.mPickerView = r14;
        ImageButton imageButton = this.mModeButton;
        if (imageButton != null) {
            ViewGroup.LayoutParams layoutParams2 = imageButton.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
            layoutParams3.width = dimensionPixelSize;
            layoutParams3.height = dimensionPixelSize;
            layoutParams3.setMarginStart(dimensionPixelSize2);
            imageButton.setLayoutParams(layoutParams3);
            imageButton.setBackgroundResource(i4);
            imageButton.setContentDescription(resources.getString(i));
            SpenSettingUtilHover.setHoverText(imageButton, resources.getString(i), true);
        }
        SpenColorValueSeekBar spenColorValueSeekBar2 = this.mValueSeekBar;
        if (spenColorValueSeekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueSeekBar");
            spenColorValueSeekBar2 = null;
        }
        spenColorValueSeekBar2.setVisibility(i2);
        SpenColorValueSeekBar spenColorValueSeekBar3 = this.mValueSeekBar;
        if (spenColorValueSeekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueSeekBar");
        } else {
            spenColorValueSeekBar = spenColorValueSeekBar3;
        }
        spenColorValueSeekBar.setTouchUpListener(this.mColorViewTouchUpListener);
    }

    private final boolean checkViewConstainsPoint(View v, int pointX, int pointY) {
        int[] iArr = new int[2];
        v.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], v.getWidth() + i, v.getHeight() + iArr[1]).contains(pointX, pointY);
    }

    private final void construct(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(this.mPickerViewInfo.layoutId, (ViewGroup) this, false);
        addView(viewInflate);
        this.mCurrentColorView = viewInflate.findViewById(C7932R.id.display_current_view);
        this.mNewColorView = viewInflate.findViewById(C7932R.id.display_new_view);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(this.mPickerViewInfo.colorDisplayRadius);
        ViewGroup viewGroup = null;
        if (AbstractC0541b.m759a(context) == 1) {
            View view = this.mCurrentColorView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
                view = null;
            }
            float f = dimensionPixelSize;
            view.setBackground(SpenSettingUtilDrawable.getRoundedRectDrawable(0.0f, f, 0.0f, f));
            View view2 = this.mNewColorView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewColorView");
                view2 = null;
            }
            view2.setBackground(SpenSettingUtilDrawable.getRoundedRectDrawable(f, 0.0f, f, 0.0f));
        } else {
            View view3 = this.mCurrentColorView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
                view3 = null;
            }
            float f4 = dimensionPixelSize;
            view3.setBackground(SpenSettingUtilDrawable.getRoundedRectDrawable(f4, 0.0f, f4, 0.0f));
            View view4 = this.mNewColorView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewColorView");
                view4 = null;
            }
            view4.setBackground(SpenSettingUtilDrawable.getRoundedRectDrawable(0.0f, f4, 0.0f, f4));
        }
        int i = this.mPickerViewInfo.modeType;
        if (i == 2) {
            View viewFindViewById = viewInflate.findViewById(C7932R.id.display_mode_btn);
            ImageButton imageButton = viewFindViewById instanceof ImageButton ? (ImageButton) viewFindViewById : null;
            this.mModeButton = imageButton;
            if (imageButton != null) {
                imageButton.setOnClickListener(this.mModeButtonClickListener);
            }
        } else if (i == 1) {
            Intrinsics.checkNotNull(viewInflate);
            initTabGroup(viewInflate, this.mMode);
        }
        this.mPickerContainer = (LinearLayout) viewInflate.findViewById(C7932R.id.color_pick_area);
        this.mValueSeekBar = (SpenColorValueSeekBar) viewInflate.findViewById(C7932R.id.color_picker_seek_bar);
        View viewFindViewById2 = viewInflate.findViewById(C7932R.id.color_value_seek_bar_text);
        EditText editText = viewFindViewById2 instanceof EditText ? (EditText) viewFindViewById2 : null;
        this.mValueSeekBarText = editText;
        if (editText != null) {
            editText.setOnFocusChangeListener(this);
            editText.setOnEditorActionListener(this.mOnEditorActionListener);
        }
        SpenColorValueSeekBar spenColorValueSeekBar = this.mValueSeekBar;
        if (spenColorValueSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueSeekBar");
            spenColorValueSeekBar = null;
        }
        spenColorValueSeekBar.setPickerColor(this.mPickerColor);
        TextView textView = (TextView) viewInflate.findViewById(C7932R.id.seek_bar_title);
        if (textView != null) {
            SpenSettingUtilText.applyUpToLargeLevel(context, 14.0f, textView);
        }
        if (this.mIsSupportRGBCode) {
            this.mRGBCodeControl = new SpenRGBCodeControl();
            View viewFindViewById3 = viewInflate.findViewById(C7932R.id.rgb_code);
            EditText editText2 = viewFindViewById3 instanceof EditText ? (EditText) viewFindViewById3 : null;
            this.mHexInputView = editText2;
            if (editText2 != null) {
                editText2.setOnFocusChangeListener(this);
                editText2.setOnEditorActionListener(this.mOnEditorActionListener);
            }
            View viewFindViewById4 = viewInflate.findViewById(C7932R.id.red_code);
            EditText editText3 = viewFindViewById4 instanceof EditText ? (EditText) viewFindViewById4 : null;
            this.mRedInputView = editText3;
            if (editText3 != null) {
                editText3.setOnFocusChangeListener(this);
                editText3.setOnEditorActionListener(this.mOnEditorActionListener);
            }
            View viewFindViewById5 = viewInflate.findViewById(C7932R.id.green_code);
            EditText editText4 = viewFindViewById5 instanceof EditText ? (EditText) viewFindViewById5 : null;
            this.mGreenInputView = editText4;
            if (editText4 != null) {
                editText4.setOnFocusChangeListener(this);
                editText4.setOnEditorActionListener(this.mOnEditorActionListener);
            }
            View viewFindViewById6 = viewInflate.findViewById(C7932R.id.blue_code);
            EditText editText5 = viewFindViewById6 instanceof EditText ? (EditText) viewFindViewById6 : null;
            this.mBlueInputView = editText5;
            if (editText5 != null) {
                editText5.setOnFocusChangeListener(this);
                editText5.setOnEditorActionListener(this.mOnEditorActionListener);
            }
            SpenRGBCodeControl spenRGBCodeControl = this.mRGBCodeControl;
            if (spenRGBCodeControl != null) {
                spenRGBCodeControl.setRGBView(this.mHexInputView, this.mRedInputView, this.mGreenInputView, this.mBlueInputView);
                spenRGBCodeControl.setPickerColor(this.mPickerColor);
                spenRGBCodeControl.setEditorActionListener(this.mOnEditorActionListener);
            }
            Intrinsics.checkNotNull(viewInflate);
            initRGBTitleText(viewInflate);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(C7932R.id.color_picker_recent_color_text_view);
        if (textView2 != null) {
            SpenSettingUtilText.setTypeFace(this.mContext, SpenSettingUtilText.FontName.MEDIUM, textView2);
            textView2.setContentDescription(this.mContext.getResources().getString(C7932R.string.pen_string_recent_color) + SQLKeyword.COMMA + this.mContext.getResources().getString(C7932R.string.pen_string_header));
        }
        this.mRecentParent = (ViewGroup) viewInflate.findViewById(C7932R.id.color_picker_recent_color_button_layout);
        setRecentColors(null, 0);
        ViewGroup viewGroup2 = this.mRecentParent;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentParent");
            viewGroup2 = null;
        }
        ViewGroup viewGroup3 = this.mRecentParent;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentParent");
        } else {
            viewGroup = viewGroup3;
        }
        View childAt = viewGroup2.getChildAt(viewGroup.getChildCount() - 1);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
        initEyedropperButton(childAt);
    }

    private final void initEyedropperButton(View eyedropperButton) {
        if (this.mIsSupportEyedropper) {
            eyedropperButton.setBackgroundResource(this.mPickerViewInfo.eyedropperBgResourceId);
            SpenSettingUtilImage.setForegroundDrawable(this.mContext, eyedropperButton, C7932R.drawable.spen_round_ripple);
            Resources resources = this.mContext.getResources();
            SpenSettingUtilHover.setHoverText(eyedropperButton, resources.getString(C7932R.string.pen_string_color_spuit));
            eyedropperButton.setContentDescription(resources.getString(C7932R.string.pen_string_color_spuit));
            eyedropperButton.setOnClickListener(new ViewOnClickListenerC7541c(this, 0));
            if (SpenSettingUtil.needRecoilVI()) {
                eyedropperButton.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), C7932R.animator.spen_recoil_button_selector));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEyedropperButton$lambda$14(SpenColorPickerView spenColorPickerView, View view) {
        SpenColorPickerEyedropperListener spenColorPickerEyedropperListener = spenColorPickerView.mEyedropperClickListener;
        if (spenColorPickerEyedropperListener != null) {
            spenColorPickerEyedropperListener.onEyedropperButtonClicked();
        }
    }

    private final void initRGBTitleText(View parentView) {
        SpenSettingUtilText.setTypeFace(this.mContext, SpenSettingUtilText.FontName.MEDIUM, (TextView) parentView.findViewById(C7932R.id.rgb_title), (TextView) parentView.findViewById(C7932R.id.red_title), (TextView) parentView.findViewById(C7932R.id.green_title), (TextView) parentView.findViewById(C7932R.id.blue_title));
    }

    private final void initTabGroup(View parentView, int mode) {
        TextView textView = (TextView) parentView.findViewById(C7932R.id.tab_swatch);
        TextView textView2 = (TextView) parentView.findViewById(C7932R.id.tab_spectrum);
        if (textView == null || textView2 == null) {
            Log.i(TAG, "Tab button is not existed.");
            return;
        }
        if (SpenSettingUtil.needRecoilVI()) {
            textView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), C7932R.animator.spen_recoil_button_selector));
            textView2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), C7932R.animator.spen_recoil_button_selector));
        }
        textView.setContentDescription(getResources().getString(C7932R.string.pen_string_swatches) + SQLKeyword.COMMA + getResources().getString(C7932R.string.pen_string_tab));
        textView2.setContentDescription(getResources().getString(C7932R.string.pen_string_spectrum) + SQLKeyword.COMMA + getResources().getString(C7932R.string.pen_string_tab));
        SpenTabGroup spenTabGroup = new SpenTabGroup(C7932R.drawable.setting_picker_tab_background, C7932R.drawable.setting_picker_tab_background_high_contrast);
        this.mPickerTabGroup = spenTabGroup;
        spenTabGroup.addTab(textView);
        spenTabGroup.addTab(textView2);
        spenTabGroup.select(mode == 1 ? C7932R.id.tab_spectrum : C7932R.id.tab_swatch);
        spenTabGroup.setOnTabSelectedListener(new SpenTabGroup.OnTabSelectedListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerView$initTabGroup$1$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabReselected(View tab) {
                Log.d("SpenColorPickerView", "(3) onTabReselected() ");
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabSelected(View tab) {
                Log.d("SpenColorPickerView", "(1) onTabSelected() ");
                this.this$0.toggleMode();
                SpenColorPickerView.OnModeChangeListener onModeChangeListener = this.this$0.mModeChangeListener;
                if (onModeChangeListener != null) {
                    onModeChangeListener.onModeChanged(this.this$0.mMode);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabUnselected(View tab) {
            }
        });
    }

    private final boolean isSupportModeChange() {
        int i = this.mPickerViewInfo.modeType;
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mModeButtonClickListener$lambda$0(SpenColorPickerView spenColorPickerView, View view) {
        spenColorPickerView.toggleMode();
        OnModeChangeListener onModeChangeListener = spenColorPickerView.mModeChangeListener;
        if (onModeChangeListener != null) {
            onModeChangeListener.onModeChanged(spenColorPickerView.mMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyColorSelected(int type) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        if (!this.mPickerColor.getColor(fArr)) {
            Log.i(TAG, "hsv is null.");
            return;
        }
        float f = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        String str = this.mColorListener != null ? "NOT NULL" : "NULL";
        StringBuilder sbM1628r = AbstractC2322a.m1628r(" notifyColorSelected() type", type, " Color[", f, SQLKeyword.COMMA);
        AbstractC11014a.m12337v(sbM1628r, f4, SQLKeyword.COMMA, f5, "] mColorListener is ");
        AbstractC11014a.m12338w(sbM1628r, str, TAG);
        ColorListener colorListener = this.mColorListener;
        if (colorListener != null) {
            colorListener.onColorSelected(fArr[0], fArr[1], fArr[2], type);
        }
    }

    private final void setColorAccessibility(View view, float[] color, String description) {
        StringBuilder sbM781w = AbstractC0541b.m781w(description, " ");
        String colorName = this.mColorNameHelper.getColorName(color);
        if (colorName != null) {
            sbM781w.append(colorName);
        } else {
            sbM781w.append(this.mUndefinedColorName);
        }
        view.setContentDescription(sbM781w);
    }

    private final void setColorContentDescription(View view, int color) {
        StringBuilder sb = new StringBuilder();
        String colorName = this.mColorNameHelper.getColorName(color);
        if (colorName != null) {
            sb.append(colorName);
            sb.append(this.mDefaultPostfix);
        } else {
            sb.append(this.mUndefinedColorName);
        }
        view.setContentDescription(sb);
    }

    private final void setDisplayColor(View view, float[] color) {
        int iHSVToColor = SpenSettingUtil.HSVToColor(color);
        Drawable background = view != null ? view.getBackground() : null;
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(iHSVToColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleMode() {
        AbstractC2322a.m1631u(this.mMode, "toggleMode() mode=", TAG);
        int i = this.mMode == 1 ? 2 : 1;
        changeMode(i);
        this.mMode = i;
    }

    private final void updateNewColor() {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.mPickerColor.getColor(fArr);
        View view = this.mNewColorView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNewColorView");
            view = null;
        }
        setDisplayColor(view, fArr);
        View view3 = this.mNewColorView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNewColorView");
        } else {
            view2 = view3;
        }
        setColorAccessibility(view2, fArr, this.mNewColorString);
    }

    public final void close() {
        List<SpenHSVColor> list = this.mRecentColors;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentColors");
            list = null;
        }
        list.clear();
        SpenColorViewInterface spenColorViewInterface = this.mPickerView;
        if (spenColorViewInterface != null) {
            spenColorViewInterface.release();
        }
        this.mPickerView = null;
        SpenColorValueSeekBar spenColorValueSeekBar = this.mValueSeekBar;
        if (spenColorValueSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mValueSeekBar");
            spenColorValueSeekBar = null;
        }
        spenColorValueSeekBar.release();
        this.mValueSeekBarText = null;
        SpenRGBCodeControl spenRGBCodeControl = this.mRGBCodeControl;
        if (spenRGBCodeControl != null) {
            spenRGBCodeControl.release();
        }
        this.mRGBCodeControl = null;
        this.mColorListener = null;
        this.mModeChangeListener = null;
        this.mEyedropperClickListener = null;
        this.mRgbCodeActionListener = null;
        SpenTabGroup spenTabGroup = this.mPickerTabGroup;
        if (spenTabGroup != null) {
            spenTabGroup.close();
        }
        this.mPickerTabGroup = null;
        this.mPickerColor.removeEventListener(this);
        this.mPickerColor.close();
        this.mColorNameHelper.close();
        this.mHexInputView = null;
        this.mRedInputView = null;
        this.mGreenInputView = null;
        this.mBlueInputView = null;
        this.focusID = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int x = (int) ev.getX();
        int y2 = (int) ev.getY();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = x + iArr[0];
        int i2 = y2 + iArr[1];
        EditText editText = this.mHexInputView;
        EditText editText2 = this.mRedInputView;
        EditText editText3 = this.mGreenInputView;
        EditText editText4 = this.mBlueInputView;
        EditText editText5 = this.mValueSeekBarText;
        if (ev.getAction() == 0 && editText != null && editText2 != null && editText3 != null && editText4 != null && editText5 != null && this.focusID != 0) {
            LinearLayout linearLayout = this.mPickerContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPickerContainer");
                linearLayout = null;
            }
            View viewFindViewById = linearLayout.getRootView().findViewById(this.focusID);
            if ((viewFindViewById instanceof EditText) && !checkViewConstainsPoint(editText, i, i2) && !checkViewConstainsPoint(editText2, i, i2) && !checkViewConstainsPoint(editText3, i, i2) && !checkViewConstainsPoint(editText4, i, i2) && !checkViewConstainsPoint(editText5, i, i2)) {
                if (!checkViewConstainsPoint(viewFindViewById, i, i2)) {
                    ((EditText) viewFindViewById).clearFocus();
                }
                Object systemService = getContext().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(((EditText) viewFindViewById).getWindowToken(), 0);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public final boolean getCurrentColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return this.mPickerColor.getColor(color);
    }

    public final int getFocusID() {
        return this.focusID;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(@NotNull View v, boolean hasFocus) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        Intrinsics.checkNotNullParameter(v, "v");
        if (this.mHexInputView == null || this.mRedInputView == null || this.mGreenInputView == null || this.mBlueInputView == null || (editText = this.mValueSeekBarText) == null) {
            return;
        }
        if (editText != null && v.getId() == editText.getId()) {
            SpenColorValueSeekBar spenColorValueSeekBar = this.mValueSeekBar;
            SpenColorValueSeekBar spenColorValueSeekBar2 = null;
            if (spenColorValueSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mValueSeekBar");
                spenColorValueSeekBar = null;
            }
            SpenColorValueSeekBar spenColorValueSeekBar3 = this.mValueSeekBar;
            if (spenColorValueSeekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mValueSeekBar");
            } else {
                spenColorValueSeekBar2 = spenColorValueSeekBar3;
            }
            spenColorValueSeekBar.onFocusChange(spenColorValueSeekBar2, hasFocus);
        }
        if (!hasFocus) {
            if (this.focusID == v.getId()) {
                this.focusID = 0;
                return;
            }
            return;
        }
        int id = v.getId();
        EditText editText6 = this.mHexInputView;
        if ((editText6 == null || id != editText6.getId()) && (((editText2 = this.mRedInputView) == null || id != editText2.getId()) && (((editText3 = this.mGreenInputView) == null || id != editText3.getId()) && (((editText4 = this.mBlueInputView) == null || id != editText4.getId()) && ((editText5 = this.mValueSeekBarText) == null || id != editText5.getId()))))) {
            return;
        }
        this.focusID = id;
        SpenColorPickerFocusListener spenColorPickerFocusListener = this.mColorPickerFocusListener;
        if (spenColorPickerFocusListener != null) {
            spenColorPickerFocusListener.onFocused();
        }
    }

    public final void setColor(@Nullable float[] old, @Nullable float[] current) {
        if (old == null || current == null) {
            Log.i(TAG, "Invalid param.");
            return;
        }
        System.arraycopy(old, 0, this.mOldHsv, 0, 3);
        View view = this.mCurrentColorView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            view = null;
        }
        setDisplayColor(view, this.mOldHsv);
        View view3 = this.mCurrentColorView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
        } else {
            view2 = view3;
        }
        setColorAccessibility(view2, this.mOldHsv, this.mCurrentColorString);
        setCurrentColor(current);
    }

    public final void setColorListener(@Nullable ColorListener listener) {
        this.mColorListener = listener;
    }

    public final void setColorViewTouchUpListener(@Nullable SpenColorViewTouchUpListener listener) {
        this.mColorViewTouchUpListener = listener;
        SpenColorViewInterface spenColorViewInterface = this.mPickerView;
        if (spenColorViewInterface != null) {
            spenColorViewInterface.setTouchUpListener(listener);
            SpenColorValueSeekBar spenColorValueSeekBar = this.mValueSeekBar;
            if (spenColorValueSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mValueSeekBar");
                spenColorValueSeekBar = null;
            }
            spenColorValueSeekBar.setTouchUpListener(this.mColorViewTouchUpListener);
        }
    }

    public final void setCurrentColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.mPickerColor.setColor(TAG, 255, color[0], color[1], color[2]);
    }

    public final void setEyedropperClickListener(@Nullable SpenColorPickerEyedropperListener listener) {
        if (this.mIsSupportEyedropper) {
            this.mEyedropperClickListener = listener;
        }
    }

    public final void setFocusListener(@Nullable SpenColorPickerFocusListener listener) {
        if (this.mIsSupportRGBCode) {
            this.mColorPickerFocusListener = listener;
        }
    }

    public final boolean setMode(int mode) {
        boolean z = this.mMode != mode;
        if (z && !isSupportModeChange()) {
            Log.i(TAG, "Not support mode change.");
            return false;
        }
        if (z) {
            toggleMode();
        }
        return z;
    }

    public final void setModeChangeListener(@Nullable OnModeChangeListener listener) {
        int i = this.mPickerViewInfo.modeType;
        if (i == 1 || i == 2) {
            this.mModeChangeListener = listener;
        }
    }

    public final void setRecentColors(@Nullable float[] recentColors, int numOfColor) {
        GradientDrawable gradientDrawable;
        if (numOfColor > 0) {
            Intrinsics.checkNotNull(recentColors);
            if (recentColors.length < numOfColor * 3) {
                AbstractC6670b.m4744e(recentColors.length, numOfColor, "Invalid Color array. size=", " numOfColor=", TAG);
                return;
            }
        }
        List<SpenHSVColor> list = this.mRecentColors;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentColors");
            list = null;
        }
        list.clear();
        for (int i = 0; i < numOfColor; i++) {
            Intrinsics.checkNotNull(recentColors);
            int i2 = i * 3;
            SpenHSVColor spenHSVColor = new SpenHSVColor(recentColors[i2], recentColors[i2 + 1], recentColors[i2 + 2]);
            List<SpenHSVColor> list2 = this.mRecentColors;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentColors");
                list2 = null;
            }
            list2.add(spenHSVColor);
        }
        int color = SpenSettingUtil.getColor(this.mContext, C7932R.color.setting_color_picker_recent_shape_background_color);
        int i4 = this.mIsSupportEyedropper ? 5 : 6;
        for (int i5 = 0; i5 < i4; i5++) {
            ViewGroup viewGroup = this.mRecentParent;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentParent");
                viewGroup = null;
            }
            View childAt = viewGroup.getChildAt(i5);
            if (SpenSettingUtil.needRecoilVI()) {
                childAt.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), C7932R.animator.spen_recoil_button_selector));
                Drawable background = childAt.getBackground();
                Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.util.SpenRecoilDrawable");
                Drawable drawable = ((SpenRecoilDrawable) background).getDrawable(0);
                Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                gradientDrawable = (GradientDrawable) drawable;
            } else {
                Drawable background2 = childAt.getBackground();
                Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
                Drawable drawable2 = ((RippleDrawable) background2).getDrawable(0);
                Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                gradientDrawable = (GradientDrawable) drawable2;
            }
            List<SpenHSVColor> list3 = this.mRecentColors;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentColors");
                list3 = null;
            }
            if (i5 < list3.size()) {
                List<SpenHSVColor> list4 = this.mRecentColors;
                if (list4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecentColors");
                    list4 = null;
                }
                gradientDrawable.setColor(list4.get(i5).getRgb());
                childAt.setTag(Integer.valueOf(i5));
                childAt.setOnClickListener(this.mRecentColorClickListener);
                childAt.setEnabled(true);
                childAt.setFocusable(true);
                childAt.setImportantForAccessibility(1);
                Intrinsics.checkNotNull(childAt);
                List<SpenHSVColor> list5 = this.mRecentColors;
                if (list5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecentColors");
                    list5 = null;
                }
                setColorContentDescription(childAt, list5.get(i5).getRgb());
            } else {
                gradientDrawable.setColor(color);
                childAt.setEnabled(false);
                childAt.setFocusable(false);
                childAt.setImportantForAccessibility(2);
            }
        }
    }

    public final void setRgbCodeActionListener(@Nullable OnRGBCodeActionListener listener) {
        if (this.mIsSupportRGBCode) {
            this.mRgbCodeActionListener = listener;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenPickerColorEventListener
    public void update(@Nullable String who, int color, float hue, float saturation, float value) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        StringBuilder sbM16m = AbstractC0000a.m16m("update() who=", who, " color=", AbstractC2322a.m1624n("%X", new Object[]{Integer.valueOf(color)}, 1, "format(format, *args)"), " [");
        AbstractC11014a.m12337v(sbM16m, hue, SQLKeyword.COMMA, saturation, SQLKeyword.COMMA);
        AbstractC2821a.m2234y(sbM16m, value, "]", TAG);
        updateNewColor();
        if (Intrinsics.areEqual(who, TAG)) {
            return;
        }
        notifyColorSelected(Intrinsics.areEqual(who, "SpenColorValueSeekBar") ? 2 : 1);
    }
}
