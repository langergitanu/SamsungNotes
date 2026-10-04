package com.samsung.android.sdk.pen.setting.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u000f*\u0001:\b\u0000\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002FGB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J2\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016J\u001a\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u001cH\u0016J\b\u00101\u001a\u00020\u001eH\u0003J\b\u00102\u001a\u00020\u0010H\u0002J\"\u0010<\u001a\u00020(2\b\u0010=\u001a\u0004\u0018\u00010\u00142\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020(H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020&H\u0002J\"\u0010B\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010C\u001a\u00020(H\u0002J \u0010D\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0002J\u0010\u0010E\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020*H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0002048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorValueSeekBar;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewInterface;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColorEventListener;", "Landroid/view/View$OnFocusChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mHsv", "", "mPickerColor", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColor;", "mProgressDrawable", "Landroid/graphics/drawable/GradientDrawable;", "mSeekBar", "Landroid/widget/SeekBar;", "mSeekBarText", "Landroid/widget/EditText;", "mSeekBarTextPostfix", "Landroid/widget/TextView;", "mColors", "", "mTouchUpListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewTouchUpListener;", "mHasFocus", "", "onFinishInflate", "", "setTouchUpListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPickerColor", "pickerColor", "release", Constants.ARG_UPDATE, "who", "", "color", "", "hue", "", "saturation", "value", "onFocusChange", VPathDataCmd.RCurveTo, "Landroid/view/View;", "hasFocus", "init", "initProgressDrawable", "mSeekBarOnTouchListener", "Landroid/view/View$OnTouchListener;", "mSeekBarChangeListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "mSeekBarTextTextWatcher", "Landroid/text/TextWatcher;", "mAccessibilityDelegate", "com/samsung/android/sdk/pen/setting/colorpicker/SpenColorValueSeekBar$mAccessibilityDelegate$1", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorValueSeekBar$mAccessibilityDelegate$1;", "getSelectionIndex", "editText", "textValue", TextConst.KEY_PARAM_NUMBER, "getNumber", "stringNumber", "updateColor", "selectionIndex", "updateSeekBar", "updateSeekBarText", "Companion", "InputFilterMinMax", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorValueSeekBar extends RelativeLayout implements SpenColorViewInterface, SpenPickerColorEventListener, View.OnFocusChangeListener {
    private static final int SEEK_BAR_VALUE_COLOR_CHANEL_MAX_VALUE = 100;
    private static final int SEEK_BAR_VALUE_COLOR_CHANEL_MIN_VALUE = 0;

    @NotNull
    private static final String TAG = "SpenColorValueSeekBar";

    @NotNull
    private final SpenColorValueSeekBar$mAccessibilityDelegate$1 mAccessibilityDelegate;

    @NotNull
    private int[] mColors;
    private boolean mHasFocus;

    @NotNull
    private final float[] mHsv;

    @Nullable
    private SpenPickerColor mPickerColor;

    @Nullable
    private GradientDrawable mProgressDrawable;

    @Nullable
    private SeekBar mSeekBar;

    @NotNull
    private final SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener mSeekBarOnTouchListener;

    @Nullable
    private EditText mSeekBarText;

    @Nullable
    private TextView mSeekBarTextPostfix;

    @NotNull
    private final TextWatcher mSeekBarTextTextWatcher;

    @Nullable
    private SpenColorViewTouchUpListener mTouchUpListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J:\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorValueSeekBar$InputFilterMinMax;", "Landroid/text/InputFilter;", VElementFormulasCmd.FMIN, "", VElementFormulasCmd.FMAX, "<init>", "(Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorValueSeekBar;II)V", "filter", "", "source", "", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "isInRange", "", "value", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class InputFilterMinMax implements InputFilter {
        private final int max;
        private final int min;

        public InputFilterMinMax(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        private final boolean isInRange(int start, int end, int value) {
            return end > start ? start <= value && value <= end : end <= value && value <= start;
        }

        @Override // android.text.InputFilter
        @Nullable
        public String filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            try {
                String strSubstring = dest.toString().substring(0, dstart);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = dest.toString().substring(dend, dest.toString().length());
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                String str = strSubstring + strSubstring2;
                String strSubstring3 = str.substring(0, dstart);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring4 = str.substring(dstart, str.length());
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                if (isInRange(this.min, this.max, Integer.parseInt(strSubstring3 + ((Object) source) + strSubstring4))) {
                    return null;
                }
                return "";
            } catch (NumberFormatException unused) {
                return "";
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.samsung.android.sdk.pen.setting.colorpicker.SpenColorValueSeekBar$mAccessibilityDelegate$1] */
    public SpenColorValueSeekBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHsv = new float[]{0.0f, 0.0f, 0.0f};
        this.mColors = new int[]{-16777216, -1};
        this.mSeekBarOnTouchListener = new ViewOnTouchListenerC4799j(this, 6);
        this.mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorValueSeekBar$mSeekBarChangeListener$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                if (fromUser) {
                    this.this$0.mHsv[2] = progress / 255.0f;
                    AbstractC2821a.m2234y(AbstractC0622a.m1176v("onProgressChanged() [", this.this$0.mHsv[0], SQLKeyword.COMMA, this.this$0.mHsv[1], SQLKeyword.COMMA), this.this$0.mHsv[2], "]", "SpenColorValueSeekBar");
                    SpenPickerColor spenPickerColor = this.this$0.mPickerColor;
                    if (spenPickerColor != null) {
                        spenPickerColor.setColor("SpenColorValueSeekBar", 255, this.this$0.mHsv[0], this.this$0.mHsv[1], this.this$0.mHsv[2]);
                    }
                }
                String strValueOf = String.valueOf(MathKt.roundToInt(100 * this.this$0.mHsv[2]));
                EditText editText = this.this$0.mSeekBarText;
                if (Intrinsics.areEqual(strValueOf, String.valueOf(editText != null ? editText.getEditableText() : null))) {
                    return;
                }
                SpenColorValueSeekBar spenColorValueSeekBar = this.this$0;
                spenColorValueSeekBar.updateSeekBarText(spenColorValueSeekBar.mHsv[2]);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar arg0) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar arg0) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
            }
        };
        this.mSeekBarTextTextWatcher = new TextWatcher() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorValueSeekBar$mSeekBarTextTextWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (this.this$0.mPickerColor == null || !this.this$0.mHasFocus) {
                    return;
                }
                String strValueOf = String.valueOf(s);
                int number = this.this$0.getNumber(String.valueOf(s));
                SpenColorValueSeekBar spenColorValueSeekBar = this.this$0;
                int selectionIndex = spenColorValueSeekBar.getSelectionIndex(spenColorValueSeekBar.mSeekBarText, strValueOf, number);
                SpenColorValueSeekBar spenColorValueSeekBar2 = this.this$0;
                spenColorValueSeekBar2.updateColor(spenColorValueSeekBar2.mSeekBarText, number, selectionIndex);
                this.this$0.mHsv[2] = ((int) (number * 2.55f)) / 255.0f;
                SpenPickerColor spenPickerColor = this.this$0.mPickerColor;
                if (spenPickerColor != null) {
                    spenPickerColor.setColor("SpenColorValueSeekBar", 255, this.this$0.mHsv[0], this.this$0.mHsv[1], this.this$0.mHsv[2]);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        };
        this.mAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorValueSeekBar$mAccessibilityDelegate$1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Editable text;
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                String string = null;
                info.setHintText(null);
                EditText editText = host instanceof EditText ? (EditText) host : null;
                if (editText != null && (text = editText.getText()) != null) {
                    string = text.toString();
                }
                if (string == null || string.length() == 0) {
                    return;
                }
                String string2 = ((EditText) host).getResources().getString(C7932R.string.pen_string_opacity);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                info.setText(string + SQLKeyword.COMMA + string2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNumber(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSelectionIndex(EditText editText, String textValue, int number) {
        if (editText == null || TextUtils.isEmpty(textValue)) {
            return -1;
        }
        return textValue.length() > String.valueOf(number).length() ? editText.getSelectionStart() - (textValue.length() - String.valueOf(number).length()) : editText.getSelectionStart();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void init() {
        Log.i(TAG, "init()");
        View viewFindViewById = findViewById(C7932R.id.color_value_seek_bar);
        SeekBar seekBar = viewFindViewById instanceof SeekBar ? (SeekBar) viewFindViewById : null;
        this.mSeekBar = seekBar;
        if (seekBar != null) {
            this.mColors = new int[]{-16777216, -1};
            this.mProgressDrawable = initProgressDrawable();
            seekBar.setContentDescription(seekBar.getContext().getResources().getString(C7932R.string.pen_string_opacity));
            seekBar.setProgressDrawable(this.mProgressDrawable);
            seekBar.setPadding(0, 0, 0, 0);
            seekBar.setOnTouchListener(this.mSeekBarOnTouchListener);
            seekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        }
        View viewFindViewById2 = findViewById(C7932R.id.color_value_seek_bar_text);
        EditText editText = viewFindViewById2 instanceof EditText ? (EditText) viewFindViewById2 : null;
        this.mSeekBarText = editText;
        if (editText != null) {
            SpenSettingUtilText.setTypeFace(getContext(), SpenSettingUtilText.FontName.REGULAR, this.mSeekBarText);
            editText.setFilters(new InputFilter[]{new InputFilterMinMax(0, 100)});
            editText.addTextChangedListener(this.mSeekBarTextTextWatcher);
            editText.setAccessibilityDelegate(this.mAccessibilityDelegate);
        }
        View viewFindViewById3 = findViewById(C7932R.id.color_value_seek_bar_text_postfix);
        TextView textView = viewFindViewById3 instanceof TextView ? (TextView) viewFindViewById3 : null;
        this.mSeekBarTextPostfix = textView;
        if (textView != null) {
            SpenSettingUtilText.setTypeFace(getContext(), SpenSettingUtilText.FontName.REGULAR, this.mSeekBarTextPostfix);
        }
    }

    private final GradientDrawable initProgressDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.mColors);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C7932R.dimen.color_picker_popup_seekbar_track_height);
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setSize(0, dimensionPixelSize * 2);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mSeekBarOnTouchListener$lambda$4(SpenColorValueSeekBar spenColorValueSeekBar, View view, MotionEvent motionEvent) {
        SpenColorViewTouchUpListener spenColorViewTouchUpListener;
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() == 0) {
            return true;
        }
        if (spenColorValueSeekBar.mTouchUpListener == null || motionEvent.getAction() != 1 || (spenColorViewTouchUpListener = spenColorValueSeekBar.mTouchUpListener) == null) {
            return false;
        }
        spenColorViewTouchUpListener.onTouchUp();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColor(EditText editText, int color, int selectionIndex) {
        if (editText == null) {
            return;
        }
        String strValueOf = String.valueOf(color);
        if (Intrinsics.areEqual(strValueOf, editText.getEditableText().toString())) {
            return;
        }
        editText.setText(strValueOf);
        if (selectionIndex == -1) {
            editText.setSelection(strValueOf.length());
        } else {
            editText.setSelection(selectionIndex);
        }
    }

    private final void updateSeekBar(float hue, float saturation, float value) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setProgress((int) (value * 255));
            this.mColors[1] = SpenSettingUtil.HSVToColor(new float[]{hue, saturation, 1.0f});
            GradientDrawable gradientDrawable = this.mProgressDrawable;
            if (gradientDrawable != null) {
                gradientDrawable.mutate();
            }
            GradientDrawable gradientDrawable2 = this.mProgressDrawable;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColors(this.mColors);
            }
            seekBar.setProgressDrawable(this.mProgressDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSeekBarText(float value) {
        EditText editText = this.mSeekBarText;
        if (editText != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(100 * value))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            editText.setText(str);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(@Nullable View v, boolean hasFocus) {
        this.mHasFocus = hasFocus;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void release() {
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.removeEventListener(this);
        }
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setOnTouchListener(null);
            seekBar.setOnSeekBarChangeListener(null);
        }
        this.mSeekBar = null;
        this.mProgressDrawable = null;
        this.mSeekBarText = null;
        this.mSeekBarTextPostfix = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setPickerColor(@NotNull SpenPickerColor pickerColor) {
        Intrinsics.checkNotNullParameter(pickerColor, "pickerColor");
        this.mPickerColor = pickerColor;
        pickerColor.getColor(this.mHsv);
        float[] fArr = this.mHsv;
        updateSeekBar(fArr[0], fArr[1], fArr[2]);
        pickerColor.addEventListener(this);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setTouchUpListener(@Nullable SpenColorViewTouchUpListener listener) {
        this.mTouchUpListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenPickerColorEventListener
    public void update(@Nullable String who, int color, float hue, float saturation, float value) {
        StringBuilder sb = new StringBuilder("update() who=");
        sb.append(who);
        sb.append(" HSV[");
        sb.append(hue);
        sb.append(SQLKeyword.COMMA);
        Log.i(TAG, AbstractC1038a.m1216q(sb, saturation, SQLKeyword.COMMA, value, "]"));
        float[] fArr = this.mHsv;
        fArr[0] = hue;
        fArr[1] = saturation;
        fArr[2] = value;
        updateSeekBar(hue, saturation, value);
    }
}
