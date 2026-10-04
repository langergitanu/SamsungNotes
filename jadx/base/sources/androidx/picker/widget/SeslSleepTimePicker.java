package androidx.picker.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0419R;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.picker.C3623R;
import androidx.picker.util.SeslSleepTimePickerUtil;
import androidx.picker.widget.SeslCircularSeekBarView;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslSleepTimePicker extends LinearLayout {
    private static final int ANIMATION_DURATION = 400;
    private static final int BED_WAKEUP_FADE_IN_DURATION = 200;
    private static final int BED_WAKEUP_FADE_OUT_DURATION = 100;
    private static final int BED_WAKEUP_SRC_FADE_OUT_DURATION = 66;
    private static final float DEFAULT_BED_TIME_MINUTE = 1320.0f;
    private static final float DEFAULT_WAKEUP_TIME_MINUTE = 420.0f;
    private static final int FONT_WEIGHT_REGULAR = 400;
    private static final int MINIMUM_DIMEN_MULTIWINDOW = 290;
    private static final float SIZE_RATIO = 0.75f;
    private static final int SLEEP_PICKER_VIBRATION = 41;
    private static final String TAG = "SleepTimePicker";
    private static final float TOTAL_DEGREE = 360.0f;
    private static final float TOTAL_MINUTES = 1440.0f;
    private final PathInterpolator CENTER_LAYOUT_PATH_INTERPOLATOR;
    private ImageView mBedTimeCenterIcon;
    private ImageView mBedTimeCenterIconRight;
    private TextView mBedTimeCenterTextLeftAmPm;
    private TextView mBedTimeCenterTextRightAmPm;
    private float mBedTimeInMinute;
    private LinearLayout mBedTimeTargetLayout;
    private TextView mBedTimeTargetText;
    private TextView mBedTimeText;
    private TextView mBedTimeTextLeftAmPm;
    private TextView mBedTimeTextRightAmPm;
    private ImageView mBedTimeTopIcon;
    private ImageView mBedTimeTopIconRight;
    private LinearLayout mBedTimeView;
    private SeslCircularSeekBarView mCircularSeekBar;
    private Context mContext;
    private Animator mCurrentAnimator;
    private SeslCircularSeekBarView.OnCircularSeekBarChangeListener mOnCircularSeekBarChangeListener;
    private OnSleepTimeChangedListener mOnSleepTimeChangedListener;
    private int mPaddingHorizontal;
    private TextView mSleepDuration;

    @NonNull
    private SleepDurationFormatter mSleepDurationFormatter;
    private FrameLayout mSleepInnerCircleContainer;
    private RelativeLayout mSleepOuterCircleContainer;
    private FrameLayout mSleepTimePickerFrame;
    private final BroadcastReceiver mTimeFormatChangeReceiver;
    private ImageView mWakeUpBottomIcon;
    private ImageView mWakeUpBottomIconRight;
    private ImageView mWakeUpCenterIcon;
    private ImageView mWakeUpCenterIconRight;
    private TextView mWakeUpTimeCenterTextLeftAmPm;
    private TextView mWakeUpTimeCenterTextRightAmPm;
    private float mWakeUpTimeInMinute;
    private LinearLayout mWakeUpTimeTargetLayout;
    private TextView mWakeUpTimeTargetText;
    private TextView mWakeUpTimeText;
    private TextView mWakeUpTimeTextLeftAmPm;
    private TextView mWakeUpTimeTextRightAmPm;
    private LinearLayout mWakeUpTimeView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSleepTimeChangedListener {
        void onSleepTimeChanged(float f, float f4);

        void onStartSleepTimeChanged(float f, float f4);

        void onStopSleepTimeChanged(float f, float f4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SleepDurationFormatter {
        int formatDuration(float f, float f4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SeslSleepTimePicker(Context context, AttributeSet attributeSet) throws Exception {
        boolean zIsTerminated;
        super(context, attributeSet);
        boolean z = false;
        this.mPaddingHorizontal = 0;
        this.CENTER_LAYOUT_PATH_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        this.mTimeFormatChangeReceiver = new BroadcastReceiver() { // from class: androidx.picker.widget.SeslSleepTimePicker.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null || !BaseWidgetConstant.TIME_SET_CHANGED.equals(intent.getAction())) {
                    return;
                }
                Log.d(SeslSleepTimePicker.TAG, "ACTION_TIME_CHANGED received");
                SeslSleepTimePicker.this.updateWakeUpTimeText();
                SeslSleepTimePicker.this.updateBedTimeText();
            }
        };
        this.mSleepDurationFormatter = new SleepDurationFormatter() { // from class: androidx.picker.widget.SeslSleepTimePicker.6
            @Override // androidx.picker.widget.SeslSleepTimePicker.SleepDurationFormatter
            public int formatDuration(float f, float f4) {
                return (int) (((f4 - f) + SeslSleepTimePicker.TOTAL_MINUTES) % SeslSleepTimePicker.TOTAL_MINUTES);
            }
        };
        this.mContext = context;
        LayoutInflater.from(context).inflate(C3623R.layout.sesl_sleep_time_picker, this);
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3623R.styleable.SeslSleepTimePicker, 0, 0);
            try {
                this.mPaddingHorizontal = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3623R.styleable.SeslSleepTimePicker_sleepPicker_horizontalPadding, 0);
                if (typedArrayObtainStyledAttributes instanceof AutoCloseable) {
                    typedArrayObtainStyledAttributes.close();
                } else if (typedArrayObtainStyledAttributes instanceof ExecutorService) {
                    ExecutorService executorService = (ExecutorService) typedArrayObtainStyledAttributes;
                    if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated = executorService.isTerminated())) {
                        executorService.shutdown();
                        while (!zIsTerminated) {
                            try {
                                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                            } catch (InterruptedException unused) {
                                if (!z) {
                                    executorService.shutdownNow();
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } else {
                    typedArrayObtainStyledAttributes.recycle();
                }
            } finally {
                if (typedArrayObtainStyledAttributes != 0) {
                    try {
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateCenter(final LinearLayout linearLayout, final LinearLayout linearLayout2, final LinearLayout linearLayout3, float f) {
        cancelCurrentAnimator();
        new Rect();
        new Rect();
        float f4 = getBoundingRectangle(linearLayout).top - getBoundingRectangle(linearLayout2).top;
        linearLayout2.setAlpha(1.0f);
        Property property = View.ALPHA;
        ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout3, (Property<LinearLayout, Float>) property, 1.0f, 0.0f).setDuration(100L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) property, 1.0f, 0.0f).setDuration(66L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(linearLayout2, (Property<LinearLayout, Float>) View.TRANSLATION_Y, f4, 0.0f).setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration3).with(duration2);
        animatorSet.play(duration);
        animatorSet.setInterpolator(this.CENTER_LAYOUT_PATH_INTERPOLATOR);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.picker.widget.SeslSleepTimePicker.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                SeslSleepTimePicker.this.mCurrentAnimator = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                linearLayout2.setTranslationY(0.0f);
                linearLayout2.setAlpha(1.0f);
                linearLayout3.setTranslationY(0.0f);
                linearLayout3.setAlpha(0.0f);
                linearLayout.setAlpha(0.0f);
            }
        });
        animatorSet.start();
        this.mCurrentAnimator = animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateText(TextView[] textViewArr, int i, int i2, long j) {
        for (final TextView textView : textViewArr) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
            valueAnimatorOfObject.setDuration(j).setInterpolator(new LinearInterpolator());
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.picker.widget.SeslSleepTimePicker.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    textView.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            valueAnimatorOfObject.start();
        }
    }

    private void cancelCurrentAnimator() {
        Animator animator = this.mCurrentAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    private float convertToAngle(float f) {
        return ((((f - 360.0f) + TOTAL_MINUTES) % TOTAL_MINUTES) * 360.0f) / TOTAL_MINUTES;
    }

    private Rect getBoundingRectangle(LinearLayout linearLayout) {
        int[] iArr = new int[2];
        linearLayout.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], linearLayout.getWidth() + i, linearLayout.getHeight() + iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPrimaryColor() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(C0419R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    private String[] getTimeTextString(int i, int i2) {
        String str;
        String twoDigitString;
        String digitString;
        Locale locale = new Locale(LangPackConfigConstants.LANGUAGE_CODE_ES, "ES");
        str = "";
        if (DateFormat.is24HourFormat(this.mContext)) {
            digitString = Locale.getDefault().equals(locale) ? SeslSleepTimePickerUtil.toDigitString(i % 24) : SeslSleepTimePickerUtil.toTwoDigitString(i);
            twoDigitString = SeslSleepTimePickerUtil.toTwoDigitString(i2);
        } else {
            int i4 = i % 12;
            String digitString2 = i4 == 0 ? LangPackConfigConstants.LANGUAGE_CODE_JA.equals(Locale.getDefault().getLanguage()) ? SeslSleepTimePickerUtil.toDigitString(0) : SeslSleepTimePickerUtil.getHourFormatData(false) ? SeslSleepTimePickerUtil.toTwoDigitString(12) : SeslSleepTimePickerUtil.toDigitString(12) : SeslSleepTimePickerUtil.getHourFormatData(false) ? SeslSleepTimePickerUtil.toTwoDigitString(i4) : SeslSleepTimePickerUtil.toDigitString(i4);
            twoDigitString = SeslSleepTimePickerUtil.toTwoDigitString(i2);
            String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
            str = amPmStrings != null ? i >= 12 ? amPmStrings[1] : amPmStrings[0] : "";
            digitString = digitString2;
        }
        return new String[]{digitString, twoDigitString, str};
    }

    private void init() {
        SeslCircularSeekBarView seslCircularSeekBarView = (SeslCircularSeekBarView) findViewById(C3623R.id.circular_seekbar);
        this.mCircularSeekBar = seslCircularSeekBarView;
        seslCircularSeekBarView.setCircularSeekBarHorizontalPadding(this.mPaddingHorizontal);
        this.mBedTimeText = (TextView) findViewById(C3623R.id.sleep_top_center_duration_bedtime);
        this.mWakeUpTimeText = (TextView) findViewById(C3623R.id.sleep_bottom_center_duration_wakeuptime);
        this.mBedTimeTextLeftAmPm = (TextView) findViewById(C3623R.id.bedtime_am_pm_left);
        this.mBedTimeTextRightAmPm = (TextView) findViewById(C3623R.id.bedtime_am_pm_right);
        this.mBedTimeCenterTextLeftAmPm = (TextView) findViewById(C3623R.id.bedtime_center_am_pm_left);
        this.mBedTimeCenterTextRightAmPm = (TextView) findViewById(C3623R.id.bedtime_center_am_pm_right);
        this.mWakeUpTimeTextLeftAmPm = (TextView) findViewById(C3623R.id.wakeuptime_am_pm_left);
        this.mWakeUpTimeTextRightAmPm = (TextView) findViewById(C3623R.id.wakeuptime_am_pm_right);
        this.mWakeUpTimeCenterTextLeftAmPm = (TextView) findViewById(C3623R.id.wakeuptime_center_am_pm_left);
        this.mWakeUpTimeCenterTextRightAmPm = (TextView) findViewById(C3623R.id.wakeuptime_center_am_pm_right);
        this.mBedTimeTargetLayout = (LinearLayout) findViewById(C3623R.id.sleep_record_center_bedtime);
        this.mBedTimeTargetText = (TextView) findViewById(C3623R.id.sleep_center_duration_bedtime);
        this.mWakeUpTimeTargetLayout = (LinearLayout) findViewById(C3623R.id.sleep_record_center_wakeuptime);
        this.mWakeUpTimeTargetText = (TextView) findViewById(C3623R.id.sleep_center_duration_wakeuptime);
        TextView textView = (TextView) findViewById(C3623R.id.sleep_duration_text_id);
        this.mSleepDuration = textView;
        SeslSleepTimePickerUtil.setLargeTextSize(this.mContext, new TextView[]{textView}, 1.3f);
        this.mWakeUpBottomIcon = (ImageView) findViewById(C3623R.id.sleep_bottom_center_duration_wakeupimage);
        this.mWakeUpBottomIconRight = (ImageView) findViewById(C3623R.id.sleep_bottom_center_duration_wakeupimage_right);
        this.mBedTimeTopIcon = (ImageView) findViewById(C3623R.id.sleep_top_center_duration_bedimage);
        this.mBedTimeTopIconRight = (ImageView) findViewById(C3623R.id.sleep_top_center_duration_bedimage_right);
        this.mWakeUpCenterIcon = (ImageView) findViewById(C3623R.id.sleep_center_icon_wakeuptime);
        this.mBedTimeCenterIcon = (ImageView) findViewById(C3623R.id.sleep_center_icon_bedtime);
        this.mWakeUpCenterIconRight = (ImageView) findViewById(C3623R.id.sleep_center_icon_wakeuptime_right);
        this.mBedTimeCenterIconRight = (ImageView) findViewById(C3623R.id.sleep_center_icon_bedtime_right);
        ImageView imageView = this.mWakeUpBottomIcon;
        int color = ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        imageView.setColorFilter(color, mode);
        this.mWakeUpBottomIconRight.setColorFilter(ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color), mode);
        this.mBedTimeTopIcon.setColorFilter(ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color), mode);
        this.mBedTimeTopIconRight.setColorFilter(ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color), mode);
        this.mWakeUpCenterIcon.setColorFilter(ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color), mode);
        this.mBedTimeCenterIcon.setColorFilter(ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color), mode);
        this.mWakeUpCenterIconRight.setColorFilter(ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color), mode);
        this.mBedTimeCenterIconRight.setColorFilter(ContextCompat.getColor(this.mContext, C3623R.color.sesl_bed_wakeup_time_icon_color), mode);
        this.mWakeUpTimeTargetLayout.setAlpha(0.0f);
        this.mBedTimeTargetLayout.setAlpha(0.0f);
        this.mBedTimeView = (LinearLayout) findViewById(C3623R.id.sleep_record_top_bed_time_layout);
        this.mWakeUpTimeView = (LinearLayout) findViewById(C3623R.id.sleep_record_bottom_wakeup_time_layout);
        this.mSleepOuterCircleContainer = (RelativeLayout) findViewById(C3623R.id.sleep_visual_edit_outer_circle_container);
        this.mSleepInnerCircleContainer = (FrameLayout) findViewById(C3623R.id.sleep_visual_edit_inner_circle_container);
        this.mSleepTimePickerFrame = (FrameLayout) findViewById(C3623R.id.sleepTimePicker);
        initListeners();
        setBedTimeInMinute(DEFAULT_BED_TIME_MINUTE);
        setWakeUpTimeInMinute(DEFAULT_WAKEUP_TIME_MINUTE);
    }

    private void initListeners() {
        final TextView[] textViewArr = {this.mBedTimeTargetText, this.mBedTimeCenterTextLeftAmPm, this.mBedTimeCenterTextRightAmPm};
        final TextView[] textViewArr2 = {this.mWakeUpTimeTargetText, this.mWakeUpTimeCenterTextLeftAmPm, this.mWakeUpTimeCenterTextRightAmPm};
        final TextView[] textViewArr3 = {this.mBedTimeText, this.mBedTimeTextLeftAmPm, this.mBedTimeTextRightAmPm};
        final TextView[] textViewArr4 = {this.mWakeUpTimeText, this.mWakeUpTimeTextLeftAmPm, this.mWakeUpTimeTextRightAmPm};
        SeslCircularSeekBarView.OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = new SeslCircularSeekBarView.OnCircularSeekBarChangeListener() { // from class: androidx.picker.widget.SeslSleepTimePicker.2
            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onProgressChangedBedTime(SeslCircularSeekBarView seslCircularSeekBarView, float f, float f4, boolean z) {
                Log.d(SeslSleepTimePicker.TAG, "onProgressChangedBedTime : BedTimePosition " + f4);
                SeslSleepTimePicker.this.mBedTimeInMinute = SeslSleepTimePickerUtil.convertToTime(f4);
                if (SeslSleepTimePicker.this.updateBedTimeText()) {
                    SeslSleepTimePickerUtil.performHapticFeedback(seslCircularSeekBarView, 41);
                }
                if (SeslSleepTimePicker.this.mOnSleepTimeChangedListener != null) {
                    SeslSleepTimePicker.this.mOnSleepTimeChangedListener.onSleepTimeChanged(SeslSleepTimePicker.this.getBedTimeInMinute(), SeslSleepTimePicker.this.getWakeUpTimeInMinute());
                }
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onProgressChangedWakeupTime(SeslCircularSeekBarView seslCircularSeekBarView, float f, float f4, boolean z) {
                Log.d(SeslSleepTimePicker.TAG, "onProgressChangedWakeupTime : WakeUpTimePosition " + f4);
                SeslSleepTimePicker.this.mWakeUpTimeInMinute = SeslSleepTimePickerUtil.convertToTime(f4);
                if (SeslSleepTimePicker.this.updateWakeUpTimeText()) {
                    SeslSleepTimePickerUtil.performHapticFeedback(seslCircularSeekBarView, 41);
                }
                if (SeslSleepTimePicker.this.mOnSleepTimeChangedListener != null) {
                    SeslSleepTimePicker.this.mOnSleepTimeChangedListener.onSleepTimeChanged(SeslSleepTimePicker.this.getBedTimeInMinute(), SeslSleepTimePicker.this.getWakeUpTimeInMinute());
                }
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onSelectBedTimeIcon() {
                Log.d(SeslSleepTimePicker.TAG, "onSelectedBedTimeIcon");
                int color = ContextCompat.getColor(SeslSleepTimePicker.this.mContext, C3623R.color.sesl_bed_wakeup_time_color);
                int primaryColor = SeslSleepTimePicker.this.getPrimaryColor();
                SeslSleepTimePicker.this.animateText(textViewArr3, color, primaryColor, 100L);
                SeslSleepTimePicker seslSleepTimePicker = SeslSleepTimePicker.this;
                seslSleepTimePicker.animateCenter(seslSleepTimePicker.mBedTimeView, SeslSleepTimePicker.this.mBedTimeTargetLayout, SeslSleepTimePicker.this.mWakeUpTimeView, 100.0f);
                SeslSleepTimePicker.this.animateText(textViewArr, color, primaryColor, 50L);
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onSelectMiddleHandler() {
                Log.d(SeslSleepTimePicker.TAG, "onSelectedMiddleHandler");
                int color = ContextCompat.getColor(SeslSleepTimePicker.this.mContext, C3623R.color.sesl_bed_wakeup_time_color);
                int primaryColor = SeslSleepTimePicker.this.getPrimaryColor();
                SeslSleepTimePicker.this.animateText(textViewArr3, color, primaryColor, 100L);
                SeslSleepTimePicker.this.animateText(textViewArr, color, primaryColor, 100L);
                SeslSleepTimePicker.this.animateText(textViewArr4, color, primaryColor, 100L);
                SeslSleepTimePicker.this.animateText(textViewArr2, color, primaryColor, 100L);
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onSelectWakeUpTimeIcon() {
                Log.d(SeslSleepTimePicker.TAG, "onSelectedWakeUpTimeIcon");
                int color = ContextCompat.getColor(SeslSleepTimePicker.this.mContext, C3623R.color.sesl_bed_wakeup_time_color);
                int primaryColor = SeslSleepTimePicker.this.getPrimaryColor();
                SeslSleepTimePicker.this.animateText(textViewArr4, color, primaryColor, 100L);
                SeslSleepTimePicker seslSleepTimePicker = SeslSleepTimePicker.this;
                seslSleepTimePicker.animateCenter(seslSleepTimePicker.mWakeUpTimeView, SeslSleepTimePicker.this.mWakeUpTimeTargetLayout, SeslSleepTimePicker.this.mBedTimeView, -50.0f);
                SeslSleepTimePicker.this.animateText(textViewArr2, color, primaryColor, 50L);
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onStartTrackingTouch(SeslCircularSeekBarView seslCircularSeekBarView) {
                Log.d(SeslSleepTimePicker.TAG, "onStartTrackingTouch");
                if (SeslSleepTimePicker.this.mOnSleepTimeChangedListener != null) {
                    SeslSleepTimePicker.this.mOnSleepTimeChangedListener.onStartSleepTimeChanged(SeslSleepTimePicker.this.getBedTimeInMinute(), SeslSleepTimePicker.this.getWakeUpTimeInMinute());
                }
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onStopTrackingTouch(SeslCircularSeekBarView seslCircularSeekBarView) {
                Log.d(SeslSleepTimePicker.TAG, "onStopTrackingTouch");
                SeslSleepTimePicker.this.setSleepTimeDurationText();
                if (SeslSleepTimePicker.this.mOnSleepTimeChangedListener != null) {
                    SeslSleepTimePicker.this.mOnSleepTimeChangedListener.onStopSleepTimeChanged(SeslSleepTimePicker.this.getBedTimeInMinute(), SeslSleepTimePicker.this.getWakeUpTimeInMinute());
                }
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onUnselectBedTimeIcon() {
                Log.d(SeslSleepTimePicker.TAG, "onUnselectedBedTimeIcon");
                int primaryColor = SeslSleepTimePicker.this.getPrimaryColor();
                int color = ContextCompat.getColor(SeslSleepTimePicker.this.mContext, C3623R.color.sesl_bed_wakeup_time_color);
                SeslSleepTimePicker.this.animateText(textViewArr, primaryColor, color, 50L);
                SeslSleepTimePicker seslSleepTimePicker = SeslSleepTimePicker.this;
                seslSleepTimePicker.reverseAnimateCenter(seslSleepTimePicker.mBedTimeTargetLayout, SeslSleepTimePicker.this.mBedTimeView, SeslSleepTimePicker.this.mWakeUpTimeView, 50.0f);
                SeslSleepTimePicker.this.animateText(textViewArr3, primaryColor, color, 200L);
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onUnselectMiddleHandler() {
                Log.d(SeslSleepTimePicker.TAG, "onUnselectedMiddleHandler");
                int primaryColor = SeslSleepTimePicker.this.getPrimaryColor();
                int color = ContextCompat.getColor(SeslSleepTimePicker.this.mContext, C3623R.color.sesl_bed_wakeup_time_color);
                SeslSleepTimePicker.this.animateText(textViewArr3, primaryColor, color, 200L);
                SeslSleepTimePicker.this.animateText(textViewArr, primaryColor, color, 200L);
                SeslSleepTimePicker.this.animateText(textViewArr4, primaryColor, color, 200L);
                SeslSleepTimePicker.this.animateText(textViewArr2, primaryColor, color, 200L);
            }

            @Override // androidx.picker.widget.SeslCircularSeekBarView.OnCircularSeekBarChangeListener
            public void onUnselectWakeUpTimeIcon() {
                Log.d(SeslSleepTimePicker.TAG, "onUnselectedWakeUpTimeIcon");
                int primaryColor = SeslSleepTimePicker.this.getPrimaryColor();
                int color = ContextCompat.getColor(SeslSleepTimePicker.this.mContext, C3623R.color.sesl_bed_wakeup_time_color);
                SeslSleepTimePicker.this.animateText(textViewArr2, primaryColor, color, 50L);
                SeslSleepTimePicker seslSleepTimePicker = SeslSleepTimePicker.this;
                seslSleepTimePicker.reverseAnimateCenter(seslSleepTimePicker.mWakeUpTimeTargetLayout, SeslSleepTimePicker.this.mWakeUpTimeView, SeslSleepTimePicker.this.mBedTimeView, -50.0f);
                SeslSleepTimePicker.this.animateText(textViewArr4, primaryColor, color, 200L);
            }
        };
        this.mOnCircularSeekBarChangeListener = onCircularSeekBarChangeListener;
        this.mCircularSeekBar.setOnSeekBarChangeListener(onCircularSeekBarChangeListener);
    }

    private void initSleepTimePickerData() {
        float f = getResources().getConfiguration().screenHeightDp;
        setSleepOuterCircleContainerSize(f);
        setInnerCircleContainerSize();
        setTimeTextSize();
        setTimeTypeFace();
        setSleepTimePickerFrameSize(f);
        updateWakeUpTimeText();
        updateWakeUpTimePointer();
        updateBedTimeText();
        updateBedTimePointer();
        setSleepTimeDurationText();
        updateWakeUpBedTimeIcon();
        this.mCircularSeekBar.startRevealAnimation();
    }

    private String makeSleepDurationText(int i) {
        Resources resources = this.mContext.getResources();
        if (i <= 60) {
            return i > 1 ? resources.getQuantityString(C3623R.plurals.sesl_sleep_duration_in_min_plurals, i, Integer.valueOf(i)) : "";
        }
        int i2 = i % 60;
        int i4 = i / 60;
        return i2 != 0 ? i2 != 1 ? i4 == 1 ? resources.getString(C3623R.string.sesl_sleep_duration_in_one_hour_minutes, Integer.valueOf(i2)) : resources.getString(C3623R.string.sesl_sleep_duration_in_hours_minutes, Integer.valueOf(i4), Integer.valueOf(i2)) : i4 == 1 ? resources.getString(C3623R.string.sesl_sleep_duration_one_hour_one_minute) : resources.getString(C3623R.string.sesl_sleep_duration_in_hours_one_minute, Integer.valueOf(i4)) : resources.getQuantityString(C3623R.plurals.sesl_sleep_duration_in_hour_plurals, i4, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reverseAnimateCenter(final LinearLayout linearLayout, final LinearLayout linearLayout2, final LinearLayout linearLayout3, float f) {
        cancelCurrentAnimator();
        new Rect();
        new Rect();
        float f4 = getBoundingRectangle(linearLayout).top - getBoundingRectangle(linearLayout2).top;
        ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout3, (Property<LinearLayout, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(200L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) View.TRANSLATION_Y, 0.0f, -f4).setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration2);
        animatorSet.play(duration);
        animatorSet.setInterpolator(this.CENTER_LAYOUT_PATH_INTERPOLATOR);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.picker.widget.SeslSleepTimePicker.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                SeslSleepTimePicker.this.mCurrentAnimator = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                linearLayout2.setTranslationY(0.0f);
                linearLayout2.setAlpha(1.0f);
                linearLayout3.setTranslationY(0.0f);
                linearLayout3.setAlpha(1.0f);
                linearLayout.setAlpha(0.0f);
                linearLayout.setTranslationY(0.0f);
            }
        });
        animatorSet.start();
        this.mCurrentAnimator = animatorSet;
    }

    private void setBedTimeIconVisibility() {
        if (SeslSleepTimePickerUtil.isLeftAmPm() && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.mBedTimeCenterIconRight.setVisibility(0);
            this.mBedTimeTopIconRight.setVisibility(0);
            this.mBedTimeTopIcon.setVisibility(8);
            this.mBedTimeCenterIcon.setVisibility(8);
            this.mWakeUpCenterIconRight.setVisibility(0);
            this.mWakeUpBottomIconRight.setVisibility(0);
            this.mWakeUpBottomIcon.setVisibility(8);
            this.mWakeUpCenterIcon.setVisibility(8);
            return;
        }
        this.mBedTimeCenterIconRight.setVisibility(8);
        this.mBedTimeTopIconRight.setVisibility(8);
        this.mBedTimeTopIcon.setVisibility(0);
        this.mBedTimeCenterIcon.setVisibility(0);
        this.mWakeUpCenterIconRight.setVisibility(8);
        this.mWakeUpBottomIconRight.setVisibility(8);
        this.mWakeUpBottomIcon.setVisibility(0);
        this.mWakeUpCenterIcon.setVisibility(0);
    }

    private void setBedTimeTextVisibility(int i, int i2, int i4, int i5) {
        this.mBedTimeCenterTextRightAmPm.setVisibility(i);
        this.mBedTimeTextRightAmPm.setVisibility(i2);
        this.mBedTimeCenterTextLeftAmPm.setVisibility(i4);
        this.mBedTimeTextLeftAmPm.setVisibility(i5);
    }

    private void setInnerCircleContainerSize() {
        float dimension = this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_time_pointer_size) / 2.0f;
        float dimension2 = this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_time_icon_touch_width) + dimension;
        float f = this.mContext.getResources().getConfiguration().screenWidthDp * this.mContext.getResources().getDisplayMetrics().density;
        float f4 = this.mContext.getResources().getConfiguration().screenHeightDp;
        float dimension3 = this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_size);
        if (SeslSleepTimePickerUtil.needBedTimePickerAdjustment(f4)) {
            dimension3 = (int) this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_min_size);
        }
        float fMin = (Math.min((f / 2.0f) - (this.mPaddingHorizontal + dimension2), (dimension3 / 2.0f) - dimension2) - dimension) * 2.0f;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSleepInnerCircleContainer.getLayoutParams();
        int i = (int) fMin;
        layoutParams.height = i;
        layoutParams.width = i;
    }

    private void setSleepGoalTimeDurationText(float f, float f4, TextView textView) {
        String quantityString;
        Resources resources = this.mContext.getResources();
        int i = (int) (((f4 - f) + TOTAL_MINUTES) % TOTAL_MINUTES);
        if (i > 60) {
            int i2 = i % 60;
            int i4 = i / 60;
            quantityString = i2 != 0 ? i2 != 1 ? i4 == 1 ? resources.getString(C3623R.string.sesl_sleep_goal_duration_in_one_hour_minutes, Integer.valueOf(i2)) : resources.getString(C3623R.string.sesl_sleep_goal_duration_in_hours_minutes, Integer.valueOf(i4), Integer.valueOf(i2)) : i4 == 1 ? resources.getString(C3623R.string.sesl_sleep_goal_duration_one_hour_one_minute) : resources.getString(C3623R.string.sesl_sleep_goal_duration_in_hours_one_minute, Integer.valueOf(i4)) : resources.getQuantityString(C3623R.plurals.sesl_sleep_goal_duration_in_hour_plurals, i4, Integer.valueOf(i4));
        } else {
            quantityString = i > 1 ? resources.getQuantityString(C3623R.plurals.sesl_sleep_goal_duration_in_min_plurals, i, Integer.valueOf(i)) : "";
        }
        textView.setText(quantityString);
    }

    private void setSleepOuterCircleContainerSize(float f) {
        int dimension = (int) this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_size);
        if (SeslSleepTimePickerUtil.needBedTimePickerAdjustment(f)) {
            dimension = (int) this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_min_size);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mSleepOuterCircleContainer.getLayoutParams();
        layoutParams.height = dimension;
        layoutParams.width = dimension;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSleepTimeDurationText() {
        this.mSleepDuration.setText(makeSleepDurationText(this.mSleepDurationFormatter.formatDuration(this.mBedTimeInMinute, this.mWakeUpTimeInMinute)));
    }

    private void setSleepTimePickerFrameSize(float f) {
        int dimension = (int) this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_size);
        if (SeslSleepTimePickerUtil.needBedTimePickerAdjustment(f)) {
            dimension = (int) this.mContext.getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_min_size);
        }
        ViewGroup.LayoutParams layoutParams = this.mSleepTimePickerFrame.getLayoutParams();
        layoutParams.height = dimension;
        layoutParams.width = dimension;
    }

    private void setTextSizeForViews(TextView[] textViewArr, float f) {
        for (TextView textView : textViewArr) {
            textView.setTextSize(0, f);
        }
    }

    private void setTimeIconSize(Resources resources, ViewGroup.LayoutParams layoutParams, float f) {
        layoutParams.height = (int) (resources.getDimensionPixelSize(C3623R.dimen.sesl_sleep_record_bed_image_icon_size) * f);
        layoutParams.width = (int) (resources.getDimensionPixelOffset(C3623R.dimen.sesl_sleep_record_bed_image_icon_size) * f);
    }

    private void setTimeTextSize() {
        Resources resources = this.mContext.getResources();
        if (resources.getConfiguration().screenWidthDp < MINIMUM_DIMEN_MULTIWINDOW) {
            setTimeTextSizeRatio(resources, 0.75f);
        } else {
            setTimeTextSizeRatio(resources, 1.0f);
        }
    }

    private void setTimeTextSizeRatio(Resources resources, float f) {
        setTextSizeForViews(new TextView[]{this.mWakeUpTimeText, this.mBedTimeText, this.mWakeUpTimeTargetText, this.mBedTimeTargetText}, resources.getDimensionPixelSize(C3623R.dimen.sesl_sleep_time_text_size) * f);
        setTextSizeForViews(new TextView[]{this.mWakeUpTimeTextLeftAmPm, this.mBedTimeTextLeftAmPm, this.mWakeUpTimeCenterTextLeftAmPm, this.mBedTimeCenterTextLeftAmPm, this.mWakeUpTimeTextRightAmPm, this.mBedTimeTextRightAmPm, this.mWakeUpTimeCenterTextRightAmPm, this.mBedTimeCenterTextRightAmPm}, resources.getDimensionPixelSize(C3623R.dimen.sesl_sleep_time_am_pm_size) * f);
        ViewGroup.LayoutParams[] layoutParamsArr = {this.mWakeUpBottomIcon.getLayoutParams(), this.mWakeUpBottomIconRight.getLayoutParams(), this.mWakeUpCenterIcon.getLayoutParams(), this.mWakeUpCenterIconRight.getLayoutParams(), this.mBedTimeTopIcon.getLayoutParams(), this.mBedTimeTopIconRight.getLayoutParams(), this.mBedTimeCenterIcon.getLayoutParams(), this.mBedTimeCenterIconRight.getLayoutParams()};
        for (int i = 0; i < 8; i++) {
            setTimeIconSize(resources, layoutParamsArr[i], f);
        }
    }

    private void setTimeTypeFace() {
        Typeface fontFromOpenTheme = SeslSleepTimePickerUtil.getFontFromOpenTheme(this.mContext);
        if (fontFromOpenTheme == null) {
            try {
                fontFromOpenTheme = Build.VERSION.SDK_INT >= 34 ? Typeface.create(Typeface.create("sec", 0), 400, false) : Typeface.create("roboto-num3L", 0);
            } catch (Exception e) {
                Log.e(TAG, "setTimeTypeFace exception : " + e);
            }
        }
        this.mBedTimeText.setTypeface(fontFromOpenTheme);
        this.mWakeUpTimeText.setTypeface(fontFromOpenTheme);
        this.mBedTimeTargetText.setTypeface(fontFromOpenTheme);
        this.mWakeUpTimeTargetText.setTypeface(fontFromOpenTheme);
    }

    private boolean setTimeViewInTimePicker(float f, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        int i = (int) f;
        String[] timeTextString = getTimeTextString(i / 60, i % 60);
        String str = timeTextString[0];
        String str2 = timeTextString[1];
        String str3 = timeTextString[2];
        String timeSeparatorText = Locale.getDefault().equals(Locale.CANADA_FRENCH) ? "h" : SeslSleepTimePickerUtil.getTimeSeparatorText(this.mContext);
        if (!DateFormat.is24HourFormat(this.mContext)) {
            textView2.setText(str3);
            if (textView4 != null) {
                textView4.setText(str3);
            }
        }
        textView.setText(str + timeSeparatorText + str2);
        textView.setContentDescription(str + timeSeparatorText + str2 + str3);
        textView.setImportantForAccessibility(2);
        String string = textView3.getText().toString();
        textView3.setText(str + timeSeparatorText + str2);
        textView3.setContentDescription(str + timeSeparatorText + str2 + str3);
        textView3.setImportantForAccessibility(2);
        return !textView3.getText().toString().equals(string);
    }

    private void setWakeUpTimeTextVisibility(int i, int i2, int i4, int i5) {
        this.mWakeUpTimeCenterTextRightAmPm.setVisibility(i);
        this.mWakeUpTimeTextRightAmPm.setVisibility(i2);
        this.mWakeUpTimeCenterTextLeftAmPm.setVisibility(i4);
        this.mWakeUpTimeTextLeftAmPm.setVisibility(i5);
    }

    private void updateBedTimePointer() {
        this.mCircularSeekBar.setBedTimePosition(convertToAngle(this.mBedTimeInMinute));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateBedTimeText() {
        if (DateFormat.is24HourFormat(this.mContext)) {
            setBedTimeTextVisibility(8, 8, 8, 8);
            return setTimeViewInTimePicker(this.mBedTimeInMinute, this.mBedTimeText, null, this.mBedTimeTargetText, null);
        }
        if (SeslSleepTimePickerUtil.isLeftAmPm()) {
            setBedTimeTextVisibility(8, 8, 0, 0);
            return setTimeViewInTimePicker(this.mBedTimeInMinute, this.mBedTimeText, this.mBedTimeTextLeftAmPm, this.mBedTimeTargetText, this.mBedTimeCenterTextLeftAmPm);
        }
        setBedTimeTextVisibility(0, 0, 8, 8);
        return setTimeViewInTimePicker(this.mBedTimeInMinute, this.mBedTimeText, this.mBedTimeTextRightAmPm, this.mBedTimeTargetText, this.mBedTimeCenterTextRightAmPm);
    }

    private void updateWakeUpBedTimeIcon() {
        setBedTimeIconVisibility();
    }

    private void updateWakeUpTimePointer() {
        this.mCircularSeekBar.setWakeUpTimePosition(convertToAngle(this.mWakeUpTimeInMinute));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateWakeUpTimeText() {
        if (DateFormat.is24HourFormat(this.mContext)) {
            setWakeUpTimeTextVisibility(8, 8, 8, 8);
            return setTimeViewInTimePicker(this.mWakeUpTimeInMinute, this.mWakeUpTimeText, null, this.mWakeUpTimeTargetText, null);
        }
        if (SeslSleepTimePickerUtil.isLeftAmPm()) {
            setWakeUpTimeTextVisibility(8, 8, 0, 0);
            return setTimeViewInTimePicker(this.mWakeUpTimeInMinute, this.mWakeUpTimeText, this.mWakeUpTimeTextLeftAmPm, this.mWakeUpTimeTargetText, this.mWakeUpTimeCenterTextLeftAmPm);
        }
        setWakeUpTimeTextVisibility(0, 0, 8, 8);
        return setTimeViewInTimePicker(this.mWakeUpTimeInMinute, this.mWakeUpTimeText, this.mWakeUpTimeTextRightAmPm, this.mWakeUpTimeTargetText, this.mWakeUpTimeCenterTextRightAmPm);
    }

    public float getBedTimeInMinute() {
        return this.mBedTimeInMinute;
    }

    public LinearLayout getBedTimeView() {
        return this.mBedTimeView;
    }

    public float getWakeUpTimeInMinute() {
        return this.mWakeUpTimeInMinute;
    }

    public LinearLayout getWakeUpTimeView() {
        return this.mWakeUpTimeView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().registerReceiver(this.mTimeFormatChangeReceiver, new IntentFilter(BaseWidgetConstant.TIME_SET_CHANGED));
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        float f = getResources().getConfiguration().screenHeightDp;
        setSleepOuterCircleContainerSize(f);
        setInnerCircleContainerSize();
        setTimeTextSize();
        setTimeTypeFace();
        setSleepTimePickerFrameSize(f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getContext().unregisterReceiver(this.mTimeFormatChangeReceiver);
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Receiver was not registered or already unregistered.", e);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("PARENT"));
        this.mBedTimeInMinute = bundle.getFloat("mBedTime");
        this.mWakeUpTimeInMinute = bundle.getFloat("mWakeUpTime");
        initSleepTimePickerData();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("PARENT", parcelableOnSaveInstanceState);
        bundle.putFloat("mBedTime", this.mBedTimeInMinute);
        bundle.putFloat("mWakeUpTime", this.mWakeUpTimeInMinute);
        return bundle;
    }

    public void setBedTimeInMinute(float f) {
        this.mBedTimeInMinute = f;
        initSleepTimePickerData();
    }

    public void setOnSleepTimeChangeListener(OnSleepTimeChangedListener onSleepTimeChangedListener) {
        this.mOnSleepTimeChangedListener = onSleepTimeChangedListener;
    }

    public void setSleepDurationFormatter(@NonNull SleepDurationFormatter sleepDurationFormatter) {
        this.mSleepDurationFormatter = sleepDurationFormatter;
    }

    public void setSleepDurationTextStyle(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.mSleepDuration, i);
    }

    public void setSleepGoal(float f, float f4) {
        TextView textView = (TextView) findViewById(C3623R.id.sleep_goal_text_id);
        textView.setVisibility(0);
        float fConvertToAngle = convertToAngle(f);
        float fConvertToAngle2 = ((convertToAngle(f4) % 360.0f) + 360.0f) % 360.0f;
        this.mCircularSeekBar.setSleepGoalWheel(((fConvertToAngle % 360.0f) + 360.0f) % 360.0f, fConvertToAngle2);
        setSleepGoalTimeDurationText(f, f4, textView);
    }

    public void setWakeUpTimeInMinute(float f) {
        this.mWakeUpTimeInMinute = f;
        initSleepTimePickerData();
    }
}
