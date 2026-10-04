package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAdaptiveColor;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001@\b\u0000\u0018\u0000 O2\u00020\u0001:\u0003OPQB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ \u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u001a2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020+J\u000e\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\"J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020%J\u0010\u00104\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u00010\u001eJ\u000e\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\"J\u000e\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020 J\u0010\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020%H\u0004J\u0018\u0010<\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020%H\u0002J\b\u0010>\u001a\u00020+H\u0002J\u0010\u0010F\u001a\u00020+2\u0006\u0010\t\u001a\u00020\"H\u0002J\u0010\u0010G\u001a\u00020+2\u0006\u00101\u001a\u00020\"H\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u00020\"H\u0002J\u0010\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020+2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010N\u001a\u00020\"2\u0006\u0010K\u001a\u00020LH\u0002R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010AR\u0014\u0010B\u001a\u00020C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Landroid/widget/ImageView;", "colorSizeView", "getColorSizeView", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "labelTextView", "getLabelTextView", "()Landroid/widget/TextView;", "Landroid/view/View;", "thumbBackgroundView", "getThumbBackgroundView", "()Landroid/view/View;", "mStrokeSizeViewContainer", "mSpenRoundLayout", "Lcom/samsung/android/sdk/pen/setting/common/SpenRoundLayout;", "mSeekBar", "Landroid/widget/SeekBar;", "mSliderThumbAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbAnimator;", "mSliderThumbChangeListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$OnSliderThumbChangeListener;", "mDeltaTouch", "", "mDefaultDiffRadius", "", "mProgressValue", "mIsThumbAnimationEnable", "", "mApplyAdaptiveColor", "mDefaultTextColor", "mAdaptiveTextColor", "mRotateDegree", "init", "", "seekBar", "sliderType", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;", "close", "setColor", "color", "setThumbAnimationEnable", "enable", "setSliderThumbChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateProgressValue", "processValue", "setRotateDegree", "degree", "setProgressValueVisibility", "visible", "initTextColor", "applyAdaptiveColor", "initSeekBarText", "mOnTouchListener", "com/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$mOnTouchListener$1", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$mOnTouchListener$1;", "seekBarDirection", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$SeekBarDir;", "getSeekBarDirection", "()Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$SeekBarDir;", "updateLabelText", "updateLabelTextColor", "updateThumbStrokeSize", "level", "requestInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "updateDeltaTouch", "calculateProgress", "Companion", "OnSliderThumbChangeListener", "SeekBarDir", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSliderThumbView extends RelativeLayout {

    @NotNull
    private static final String TAG = "SpenSliderFloatingThumb";

    @Nullable
    private ImageView colorSizeView;

    @Nullable
    private TextView labelTextView;
    private int mAdaptiveTextColor;
    private boolean mApplyAdaptiveColor;
    private int mDefaultDiffRadius;
    private int mDefaultTextColor;
    private float mDeltaTouch;
    private boolean mIsThumbAnimationEnable;

    @NotNull
    private final SpenSliderThumbView$mOnTouchListener$1 mOnTouchListener;
    private int mProgressValue;
    private float mRotateDegree;

    @Nullable
    private SeekBar mSeekBar;

    @Nullable
    private SpenSliderThumbAnimator mSliderThumbAnimation;

    @Nullable
    private OnSliderThumbChangeListener mSliderThumbChangeListener;

    @Nullable
    private SpenRoundLayout mSpenRoundLayout;

    @Nullable
    private RelativeLayout mStrokeSizeViewContainer;

    @Nullable
    private View thumbBackgroundView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$OnSliderThumbChangeListener;", "", "OnProgressChange", "", "progress", "", "onStartTrackingTouch", "onStopTrackingTouch", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderThumbChangeListener {
        void OnProgressChange(int progress);

        void onStartTrackingTouch();

        void onStopTrackingTouch();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$SeekBarDir;", "", "<init>", "(Ljava/lang/String;I)V", "DIR_LTR", "DIR_RTL", "DIR_BTT", "DIR_TTB", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SeekBarDir {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SeekBarDir[] $VALUES;
        public static final SeekBarDir DIR_LTR = new SeekBarDir("DIR_LTR", 0);
        public static final SeekBarDir DIR_RTL = new SeekBarDir("DIR_RTL", 1);
        public static final SeekBarDir DIR_BTT = new SeekBarDir("DIR_BTT", 2);
        public static final SeekBarDir DIR_TTB = new SeekBarDir("DIR_TTB", 3);

        private static final /* synthetic */ SeekBarDir[] $values() {
            return new SeekBarDir[]{DIR_LTR, DIR_RTL, DIR_BTT, DIR_TTB};
        }

        static {
            SeekBarDir[] seekBarDirArr$values = $values();
            $VALUES = seekBarDirArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(seekBarDirArr$values);
        }

        private SeekBarDir(String str, int i) {
        }

        @NotNull
        public static EnumEntries<SeekBarDir> getEntries() {
            return $ENTRIES;
        }

        public static SeekBarDir valueOf(String str) {
            return (SeekBarDir) Enum.valueOf(SeekBarDir.class, str);
        }

        public static SeekBarDir[] values() {
            return (SeekBarDir[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SeekBarDir.values().length];
            try {
                iArr[SeekBarDir.DIR_LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SeekBarDir.DIR_RTL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SeekBarDir.DIR_TTB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SeekBarDir.DIR_BTT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView$mOnTouchListener$1] */
    public SpenSliderThumbView(@Nullable Context context) {
        super(context);
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView$mOnTouchListener$1
            /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View v, MotionEvent event) {
                SpenSliderThumbAnimator spenSliderThumbAnimator;
                if (v == null || event == null) {
                    return false;
                }
                if (this.this$0.mIsThumbAnimationEnable && (spenSliderThumbAnimator = this.this$0.mSliderThumbAnimation) != null) {
                    spenSliderThumbAnimator.setOnTouchEvent(event);
                }
                int action = event.getAction();
                if (action == 0) {
                    SpenSliderThumbView.OnSliderThumbChangeListener onSliderThumbChangeListener = this.this$0.mSliderThumbChangeListener;
                    if (onSliderThumbChangeListener != null) {
                        onSliderThumbChangeListener.onStartTrackingTouch();
                    }
                    this.this$0.updateDeltaTouch(event);
                } else if (action == 1) {
                    SpenSliderThumbView.OnSliderThumbChangeListener onSliderThumbChangeListener2 = this.this$0.mSliderThumbChangeListener;
                    if (onSliderThumbChangeListener2 != null) {
                        onSliderThumbChangeListener2.onStopTrackingTouch();
                    }
                } else if (action == 2) {
                    int iCalculateProgress = this.this$0.calculateProgress(event);
                    SpenSliderThumbView.OnSliderThumbChangeListener onSliderThumbChangeListener3 = this.this$0.mSliderThumbChangeListener;
                    if (onSliderThumbChangeListener3 != null) {
                        onSliderThumbChangeListener3.OnProgressChange(iCalculateProgress);
                    }
                } else if (action == 3) {
                }
                this.this$0.requestInterceptTouchEvent(event);
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateProgress(MotionEvent event) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            float width = ((seekBar.getWidth() - seekBar.getPaddingLeft()) - seekBar.getPaddingRight()) / (seekBar.getMax() + 1);
            seekBar.getLocationOnScreen(new int[2]);
            int i = WhenMappings.$EnumSwitchMapping$0[getSeekBarDirection().ordinal()];
            int iRoundToInt = (int) ((i != 2 ? i != 3 ? i != 4 ? MathKt.roundToInt(((event.getRawX() - r5[0]) - this.mDeltaTouch) - seekBar.getPaddingLeft()) : MathKt.roundToInt(((r5[1] - event.getRawY()) + this.mDeltaTouch) - seekBar.getPaddingLeft()) : MathKt.roundToInt(((event.getRawY() - r5[1]) - this.mDeltaTouch) - seekBar.getPaddingLeft()) : MathKt.roundToInt(((r5[0] - event.getRawX()) + this.mDeltaTouch) - seekBar.getPaddingLeft())) / width);
            max = iRoundToInt > 0 ? iRoundToInt >= seekBar.getMax() ? seekBar.getMax() : iRoundToInt : 0;
            if (getResources().getConfiguration().getLayoutDirection() == 1) {
                max = seekBar.getMax() - max;
            }
            AbstractC2322a.m1631u(max, "calculateProgress progressValue = ", TAG);
        }
        return max;
    }

    private final SeekBarDir getSeekBarDirection() {
        SeekBarDir seekBarDir = SeekBarDir.DIR_LTR;
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Log.e(TAG, "isHorizontalSeekbar SeekBar is null");
            return seekBarDir;
        }
        float rotation = seekBar.getRotation();
        if (rotation != 90.0f) {
            float f = this.mRotateDegree;
            if (f != 90.0f) {
                return (rotation == 180.0f || f == 180.0f) ? SeekBarDir.DIR_RTL : (rotation == 270.0f || f == 270.0f) ? SeekBarDir.DIR_BTT : seekBarDir;
            }
        }
        return SeekBarDir.DIR_TTB;
    }

    private final void initSeekBarText() {
        TextView textView = (TextView) findViewById(C7932R.id.seek_bar_value);
        this.labelTextView = textView;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setImportantForAccessibility(2);
            textView.setTextColor(this.mDefaultTextColor);
            SpenSettingUtilText.setTypeFace(getContext(), SpenSettingUtilText.FontName.REGULAR, textView);
            SpenSettingUtilText.applyUpToLargeLevel(getContext(), 10.0f, textView);
        }
    }

    private final void initTextColor(Context context, boolean applyAdaptiveColor) {
        AbstractC4539a.m3208r("initTextColor() applyAdaptiveColor=", TAG, applyAdaptiveColor);
        this.mApplyAdaptiveColor = applyAdaptiveColor;
        if (applyAdaptiveColor) {
            this.mDefaultTextColor = SpenSettingUtil.getColor(context, C7932R.color.setting_slider_handler_text_adaptive_default_color);
            this.mAdaptiveTextColor = SpenSettingUtil.getColor(context, C7932R.color.setting_slider_handler_text_adaptive_color);
        } else {
            int color = SpenSettingUtil.getColor(context, C7932R.color.setting_slider_handler_text_color);
            this.mDefaultTextColor = color;
            this.mAdaptiveTextColor = color;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDeltaTouch(MotionEvent event) {
        float rawX;
        int i;
        int width;
        float f;
        int i2;
        int width2;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        SeekBar seekBar = this.mSeekBar;
        int i4 = WhenMappings.$EnumSwitchMapping$0[(!Intrinsics.areEqual(seekBar != null ? Float.valueOf(seekBar.getRotation()) : null, 0.0f) ? SeekBarDir.DIR_TTB : getSeekBarDirection()).ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                rawX = event.getRawX();
                i2 = iArr[0];
                width2 = getWidth() / 2;
            } else if (i4 != 3) {
                rawX = event.getRawY();
                i2 = iArr[1];
                width2 = getWidth() / 2;
            } else {
                rawX = event.getRawY();
                i = iArr[1];
                width = getWidth() / 2;
            }
            f = i2 - width2;
            this.mDeltaTouch = rawX - f;
        }
        rawX = event.getRawX();
        i = iArr[0];
        width = getWidth() / 2;
        f = width + i;
        this.mDeltaTouch = rawX - f;
    }

    private final void updateLabelText(int value) {
        TextView textView = this.labelTextView;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            textView.setText(AbstractC11014a.m12323h(new Object[]{Integer.valueOf(value)}, 1, Locale.getDefault(), TimeModel.NUMBER_FORMAT, "format(locale, format, *args)"));
        }
    }

    private final void updateLabelTextColor(int color) {
        if (this.mApplyAdaptiveColor) {
            boolean zIsAdaptiveColor = SpenSettingUtilAdaptiveColor.isAdaptiveColor(getContext(), color, SpenSettingUtilAdaptiveColor.UseType.DECISION_FG_COLOR);
            TextView textView = this.labelTextView;
            if (textView != null) {
                textView.setTextColor(zIsAdaptiveColor ? this.mAdaptiveTextColor : this.mDefaultTextColor);
            }
        }
    }

    private final void updateThumbStrokeSize(int level) {
        ImageView imageView = this.colorSizeView;
        if (imageView == null) {
            return;
        }
        int i = (int) (((double) ((100 - level) * this.mDefaultDiffRadius)) * 0.01d);
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(i, i, i, i);
        ImageView imageView2 = this.colorSizeView;
        if (imageView2 != null) {
            imageView2.setLayoutParams(layoutParams2);
        }
    }

    public final void close() {
        this.mSliderThumbChangeListener = null;
        SpenSliderThumbAnimator spenSliderThumbAnimator = this.mSliderThumbAnimation;
        if (spenSliderThumbAnimator != null) {
            spenSliderThumbAnimator.close();
        }
        this.mSliderThumbAnimation = null;
    }

    @Nullable
    public final ImageView getColorSizeView() {
        return this.colorSizeView;
    }

    @Nullable
    public final TextView getLabelTextView() {
        return this.labelTextView;
    }

    @Nullable
    public final View getThumbBackgroundView() {
        return this.thumbBackgroundView;
    }

    public final void init(@NotNull Context context, @Nullable SeekBar seekBar, @NotNull SpenSlider.SliderType sliderType) {
        RelativeLayout relativeLayout;
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        LayoutInflater.from(context).inflate(C7932R.layout.setting_slider_thumb_layout, (ViewGroup) this, true);
        this.mStrokeSizeViewContainer = (RelativeLayout) findViewById(C7932R.id.stroke_size_view_container);
        View viewFindViewById = findViewById(C7932R.id.slider_thumb_background);
        if (viewFindViewById == null) {
            viewFindViewById = null;
        }
        this.thumbBackgroundView = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnTouchListener(this.mOnTouchListener);
        }
        View viewFindViewById2 = findViewById(C7932R.id.mask_layout);
        SpenRoundLayout spenRoundLayout = viewFindViewById2 instanceof SpenRoundLayout ? (SpenRoundLayout) viewFindViewById2 : null;
        this.mSpenRoundLayout = spenRoundLayout;
        if (spenRoundLayout != null) {
            spenRoundLayout.setRadius(getResources().getDimensionPixelSize(C7932R.dimen.setting_slider_thumb_radius));
            spenRoundLayout.setWillNotDraw(false);
        }
        View viewFindViewById3 = findViewById(C7932R.id.seek_bar_stroke);
        ImageView imageView = viewFindViewById3 instanceof ImageView ? (ImageView) viewFindViewById3 : null;
        this.colorSizeView = imageView;
        if (imageView != null && sliderType == SpenSlider.SliderType.DISCRETE) {
            SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
            spenGradientDrawableHelper.setDrawableInfo(1, -16777216, context.getResources().getDimensionPixelSize(C7932R.dimen.setting_slider_outline_size), -16777216);
            imageView.setImageDrawable(spenGradientDrawableHelper.makeDrawable());
        }
        this.mSeekBar = seekBar;
        this.mDefaultDiffRadius = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_slider_default_color_diff_radius);
        this.mIsThumbAnimationEnable = true;
        this.mProgressValue = 0;
        this.mRotateDegree = 0.0f;
        initTextColor(context, sliderType != SpenSlider.SliderType.DISCRETE);
        initSeekBarText();
        TextView textView = this.labelTextView;
        if (textView == null || (relativeLayout = this.mStrokeSizeViewContainer) == null || (view = this.thumbBackgroundView) == null) {
            return;
        }
        this.mSliderThumbAnimation = new SpenSliderThumbAnimator(context, textView, relativeLayout, view);
    }

    public final void setColor(int color) {
        updateLabelTextColor(color);
    }

    public final void setProgressValueVisibility(boolean visible) {
        TextView textView = this.labelTextView;
        if (textView != null) {
            textView.setVisibility(visible ? 0 : 8);
        }
    }

    public final void setRotateDegree(float degree) {
        this.mRotateDegree = degree;
    }

    public final void setSliderThumbChangeListener(@Nullable OnSliderThumbChangeListener listener) {
        this.mSliderThumbChangeListener = listener;
    }

    public final void setThumbAnimationEnable(boolean enable) {
        this.mIsThumbAnimationEnable = enable;
    }

    public final void updateProgressValue(int processValue) {
        AbstractC2322a.m1631u(processValue, "updateProgressValue value= ", TAG);
        if (this.mProgressValue == processValue) {
            return;
        }
        this.mProgressValue = processValue;
        updateThumbStrokeSize(processValue);
        updateLabelText(processValue);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView$mOnTouchListener$1] */
    public SpenSliderThumbView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView$mOnTouchListener$1
            /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View v, MotionEvent event) {
                SpenSliderThumbAnimator spenSliderThumbAnimator;
                if (v == null || event == null) {
                    return false;
                }
                if (this.this$0.mIsThumbAnimationEnable && (spenSliderThumbAnimator = this.this$0.mSliderThumbAnimation) != null) {
                    spenSliderThumbAnimator.setOnTouchEvent(event);
                }
                int action = event.getAction();
                if (action == 0) {
                    SpenSliderThumbView.OnSliderThumbChangeListener onSliderThumbChangeListener = this.this$0.mSliderThumbChangeListener;
                    if (onSliderThumbChangeListener != null) {
                        onSliderThumbChangeListener.onStartTrackingTouch();
                    }
                    this.this$0.updateDeltaTouch(event);
                } else if (action == 1) {
                    SpenSliderThumbView.OnSliderThumbChangeListener onSliderThumbChangeListener2 = this.this$0.mSliderThumbChangeListener;
                    if (onSliderThumbChangeListener2 != null) {
                        onSliderThumbChangeListener2.onStopTrackingTouch();
                    }
                } else if (action == 2) {
                    int iCalculateProgress = this.this$0.calculateProgress(event);
                    SpenSliderThumbView.OnSliderThumbChangeListener onSliderThumbChangeListener3 = this.this$0.mSliderThumbChangeListener;
                    if (onSliderThumbChangeListener3 != null) {
                        onSliderThumbChangeListener3.OnProgressChange(iCalculateProgress);
                    }
                } else if (action == 3) {
                }
                this.this$0.requestInterceptTouchEvent(event);
                return true;
            }
        };
    }
}
