package androidx.picker.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.icu.text.SimpleDateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.picker.util.SeslAnimationListener;
import androidx.picker.widget.SeslSpinningDatePicker;
import androidx.reflect.view.SeslViewReflector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SeslSpinningDatePickerSpinner extends LinearLayout {
    private static final DateFormatter mDateFormatter = new DateFormatter();
    private DatePickerDelegate mDelegate;
    private boolean mIsLeapMonth;
    private boolean mIsLunar;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbsDatePickerDelegate implements DatePickerDelegate {
        Context mContext;
        SeslSpinningDatePickerSpinner mDelegator;

        public AbsDatePickerDelegate(SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner, Context context) {
            this.mDelegator = seslSpinningDatePickerSpinner;
            this.mContext = context;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CustomEditText extends EditText {
        private int mAdjustEditTextPosition;

        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            canvas.translate(0.0f, this.mAdjustEditTextPosition);
            super.onDraw(canvas);
        }

        public void setEditTextPosition(int i) {
            this.mAdjustEditTextPosition = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DatePickerDelegate {
        void computeScroll();

        int computeVerticalScrollExtent();

        int computeVerticalScrollOffset();

        int computeVerticalScrollRange();

        Calendar convertLunarToSolar(Calendar calendar, int i, int i2, int i4);

        Calendar convertSolarToLunar(Calendar calendar, SeslSpinningDatePicker.LunarDate lunarDate);

        boolean dispatchHoverEvent(MotionEvent motionEvent);

        boolean dispatchKeyEvent(KeyEvent keyEvent);

        boolean dispatchKeyEventPreIme(KeyEvent keyEvent);

        boolean dispatchTouchEvent(MotionEvent motionEvent);

        void dispatchTrackballEvent(MotionEvent motionEvent);

        AccessibilityNodeProvider getAccessibilityNodeProvider();

        int getMaxHeight();

        Calendar getMaxValue();

        int getMaxWidth();

        int getMinHeight();

        Calendar getMinValue();

        int getMinWidth();

        OnSpinnerDateClickListener getOnSpinnerDateClickListener();

        int getPaintFlags();

        Calendar getValue();

        boolean getWrapSelectorWheel();

        void onAttachedToWindow();

        void onConfigurationChanged(Configuration configuration);

        void onDetachedFromWindow();

        void onDraw(Canvas canvas);

        void onFocusChanged(boolean z, int i, Rect rect);

        boolean onGenericMotionEvent(MotionEvent motionEvent);

        void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        boolean onInterceptTouchEvent(MotionEvent motionEvent);

        void onLayout(boolean z, int i, int i2, int i4, int i5);

        void onMeasure(int i, int i2);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        boolean onTouchEvent(MotionEvent motionEvent);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i);

        void performClick();

        void performClick(boolean z);

        void performLongClick();

        void scrollBy(int i, int i2);

        void setEnabled(boolean z);

        void setFormatter(Formatter formatter);

        void setLunar(boolean z, boolean z2);

        void setMaxValue(Calendar calendar);

        void setMinValue(Calendar calendar);

        void setOnLongPressUpdateInterval(long j);

        void setOnScrollListener(OnScrollListener onScrollListener);

        void setOnSpinnerDateClickListener(OnSpinnerDateClickListener onSpinnerDateClickListener);

        void setOnValueChangedListener(OnValueChangeListener onValueChangeListener);

        void setPaintFlags(int i);

        void setPickerContentDescription(String str);

        void setSkipValuesOnLongPressEnabled(boolean z);

        void setSubTextSize(float f);

        void setTextSize(float f);

        void setTextTypeface(Typeface typeface);

        void setValue(Calendar calendar);

        void setWrapSelectorWheel(boolean z);

        void startAnimation(int i, SeslAnimationListener seslAnimationListener);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Formatter {
        String format(Calendar calendar);

        Calendar parse(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollState {
        }

        void onScrollStateChange(SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSpinnerDateClickListener {
        void onSpinnerDateClicked(Calendar calendar, SeslSpinningDatePicker.LunarDate lunarDate);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnValueChangeListener {
        void onValueChange(SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner, Calendar calendar, Calendar calendar2, boolean z, SeslSpinningDatePicker.LunarDate lunarDate);
    }

    public SeslSpinningDatePickerSpinner(Context context) {
        this(context, null);
    }

    public static Formatter getDateFormatter() {
        return mDateFormatter;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mDelegate.computeScroll();
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return this.mDelegate.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return this.mDelegate.computeVerticalScrollOffset();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return this.mDelegate.computeVerticalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.mDelegate.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mDelegate.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (this.mDelegate.dispatchKeyEventPreIme(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mDelegate.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        this.mDelegate.dispatchTrackballEvent(motionEvent);
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return this.mDelegate.getAccessibilityNodeProvider();
    }

    public int[] getEnableStateSet() {
        return LinearLayout.ENABLED_STATE_SET;
    }

    public Calendar getMaxValue() {
        return this.mDelegate.getMaxValue();
    }

    public Calendar getMinValue() {
        return this.mDelegate.getMinValue();
    }

    public OnSpinnerDateClickListener getOnSpinnerDateClickListener() {
        return this.mDelegate.getOnSpinnerDateClickListener();
    }

    public int getPaintFlags() {
        return this.mDelegate.getPaintFlags();
    }

    public Calendar getValue() {
        Calendar calendar = (Calendar) this.mDelegate.getValue().clone();
        return this.mIsLunar ? this.mDelegate.convertSolarToLunar(calendar, null) : calendar;
    }

    public boolean getWrapSelectorWheel() {
        return this.mDelegate.getWrapSelectorWheel();
    }

    public boolean isVisibleToUserWrapper() {
        return SeslViewReflector.isVisibleToUser(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mDelegate.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mDelegate.onDetachedFromWindow();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        this.mDelegate.onDraw(canvas);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        this.mDelegate.onFocusChanged(z, i, rect);
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mDelegate.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        this.mDelegate.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mDelegate.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        this.mDelegate.onLayout(z, i, i2, i4, i5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.mDelegate.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.mDelegate.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDelegate.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mDelegate.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        this.mDelegate.onWindowVisibilityChanged(i);
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        this.mDelegate.performClick();
        return true;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (super.performLongClick()) {
            return true;
        }
        this.mDelegate.performLongClick();
        return true;
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        this.mDelegate.scrollBy(i, i2);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mDelegate.setEnabled(z);
    }

    public void setFormatter(Formatter formatter) {
        this.mDelegate.setFormatter(formatter);
    }

    public void setLunar(boolean z, boolean z2) {
        this.mIsLunar = z;
        this.mIsLeapMonth = z2;
        this.mDelegate.setLunar(z, z2);
    }

    public void setMaxValue(Calendar calendar) {
        this.mDelegate.setMaxValue(calendar);
    }

    public void setMeasuredDimensionWrapper(int i, int i2) {
        setMeasuredDimension(i, i2);
    }

    public void setMinValue(Calendar calendar) {
        this.mDelegate.setMinValue(calendar);
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.mDelegate.setOnLongPressUpdateInterval(j);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mDelegate.setOnScrollListener(onScrollListener);
    }

    public void setOnSpinnerDateClickListener(OnSpinnerDateClickListener onSpinnerDateClickListener) {
        this.mDelegate.setOnSpinnerDateClickListener(onSpinnerDateClickListener);
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.mDelegate.setOnValueChangedListener(onValueChangeListener);
    }

    public void setPaintFlags(int i) {
        this.mDelegate.setPaintFlags(i);
    }

    public void setPickerContentDescription(String str) {
        this.mDelegate.setPickerContentDescription(str);
    }

    public void setSkipValuesOnLongPressEnabled(boolean z) {
        this.mDelegate.setSkipValuesOnLongPressEnabled(z);
    }

    public void setSubTextSize(float f) {
        this.mDelegate.setSubTextSize(f);
    }

    public void setTextSize(float f) {
        this.mDelegate.setTextSize(f);
    }

    public void setTextTypeface(Typeface typeface) {
        this.mDelegate.setTextTypeface(typeface);
    }

    public void setValue(Calendar calendar) {
        this.mDelegate.setValue(calendar);
    }

    public void setWrapSelectorWheel(boolean z) {
        this.mDelegate.setWrapSelectorWheel(z);
    }

    public void startAnimation(int i, SeslAnimationListener seslAnimationListener) {
        this.mDelegate.startAnimation(i, seslAnimationListener);
    }

    @SuppressLint({"WrongCall"})
    public void superOnMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void updateDate(int i, int i2, int i4) {
        Calendar calendarConvertLunarToSolar = (Calendar) getValue().clone();
        calendarConvertLunarToSolar.set(i, i2, i4);
        if (this.mIsLunar) {
            calendarConvertLunarToSolar = this.mDelegate.convertLunarToSolar(calendarConvertLunarToSolar, i, i2, i4);
        }
        setValue(calendarConvertLunarToSolar);
    }

    public SeslSpinningDatePickerSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean isVisibleToUserWrapper(Rect rect) {
        return SeslViewReflector.isVisibleToUser(this, rect);
    }

    public SeslSpinningDatePickerSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public void performClick(boolean z) {
        this.mDelegate.performClick(z);
    }

    public SeslSpinningDatePickerSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDelegate = new SeslSpinningDatePickerSpinnerDelegate(this, context, attributeSet, i, i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DateFormatter implements Formatter {
        final Object[] mArgs = new Object[1];
        Locale mCurrentLocale;
        SimpleDateFormat mFmt;

        public DateFormatter() {
            init(Locale.getDefault());
        }

        private SimpleDateFormat createFormatter(Locale locale) {
            return isSimplifiedChinese(locale) ? new SimpleDateFormat("EEEEE, MMM dd", locale) : isRTL(locale) ? new SimpleDateFormat("EEEEE, MMM dd", locale) : new SimpleDateFormat("EEE, MMM dd", locale);
        }

        private void init(Locale locale) {
            this.mFmt = createFormatter(locale);
            this.mCurrentLocale = locale;
        }

        private boolean isRTL(Locale locale) {
            byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
            return directionality == 1 || directionality == 2;
        }

        private boolean isSimplifiedChinese(Locale locale) {
            String language = locale.getLanguage();
            Locale locale2 = Locale.SIMPLIFIED_CHINESE;
            return language.equals(locale2.getLanguage()) && locale.getCountry().equals(locale2.getCountry());
        }

        @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.Formatter
        public String format(Calendar calendar) {
            Locale locale = Locale.getDefault();
            if (!this.mCurrentLocale.equals(locale)) {
                init(locale);
            }
            this.mArgs[0] = calendar;
            return this.mFmt.format(calendar.getTime());
        }

        public String formatForAccessibility(Calendar calendar, Context context) {
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 26);
        }

        @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.Formatter
        public Calendar parse(String str) {
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            try {
                calendar.setTime(this.mFmt.parse(str));
                return calendar;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String format(Calendar calendar, Context context) {
            this.mArgs[0] = calendar;
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 524314);
        }
    }
}
