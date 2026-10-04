package androidx.picker.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.icu.text.DecimalFormatSymbols;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.picker.util.SeslAnimationListener;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.view.accessibility.SeslAccessibilityManagerReflector;
import androidx.reflect.widget.SeslTextViewReflector;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
public class SeslNumberPicker extends LinearLayout {
    static final int MODE_UNIT_DAY = 997;
    static final int MODE_UNIT_MONTH = 998;
    static final int MODE_UNIT_NONE = -1;
    static final int MODE_UNIT_YEAR = 999;
    private static final TwoDigitFormatter sTwoDigitFormatter = new TwoDigitFormatter();
    private NumberPickerDelegate mDelegate;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class AbsNumberPickerDelegate implements NumberPickerDelegate {
        protected Context mContext;
        SeslNumberPicker mDelegator;

        public AbsNumberPickerDelegate(SeslNumberPicker seslNumberPicker, Context context) {
            this.mDelegator = seslNumberPicker;
            this.mContext = context;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class CustomEditText extends EditText {
        private int mAdjustEditTextPosition;
        private String mPickerContentDescription;

        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            SeslTextViewReflector.setLocalePreferredLineHeightForMinimumUsed(this, false);
            this.mPickerContentDescription = "";
        }

        private CharSequence getTextForAccessibility() {
            Editable text = getText();
            if (this.mPickerContentDescription.equals("")) {
                return text;
            }
            if (TextUtils.isEmpty(text)) {
                return SQLKeyword.COMMA + this.mPickerContentDescription;
            }
            return text.toString() + SQLKeyword.COMMA + this.mPickerContentDescription;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            canvas.translate(0.0f, this.mAdjustEditTextPosition);
            super.onDraw(canvas);
        }

        @Override // android.widget.TextView
        public void onEditorAction(int i) {
            super.onEditorAction(i);
            if (i == 6) {
                clearFocus();
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (!SeslAccessibilityManagerReflector.isScreenReaderEnabled((AccessibilityManager) getContext().getSystemService("accessibility"), true)) {
                accessibilityNodeInfo.setText(getTextForAccessibility());
            } else {
                accessibilityNodeInfo.setText(getText());
                AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setTooltipText(this.mPickerContentDescription);
            }
        }

        @Override // android.view.View
        public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            int size = accessibilityEvent.getText().size();
            super.onPopulateAccessibilityEvent(accessibilityEvent);
            int size2 = accessibilityEvent.getText().size();
            if (size2 > size) {
                accessibilityEvent.getText().remove(size2 - 1);
            }
            Editable text = getText();
            if (!TextUtils.isEmpty(text)) {
                accessibilityEvent.getText().add(text);
            }
            accessibilityEvent.setContentDescription(this.mPickerContentDescription);
        }

        public void setEditTextPosition(int i) {
            this.mAdjustEditTextPosition = i;
        }

        public void setPickerContentDescription(String str) {
            this.mPickerContentDescription = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CustomTalkbackFormatter {
        @NonNull
        String format(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Formatter {
        String format(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface NumberPickerDelegate {
        void applyWheelCustomInterval(boolean z);

        void computeScroll();

        int computeVerticalScrollExtent();

        int computeVerticalScrollOffset();

        int computeVerticalScrollRange();

        boolean dispatchHoverEvent(MotionEvent motionEvent);

        boolean dispatchKeyEvent(KeyEvent keyEvent);

        boolean dispatchKeyEventPreIme(KeyEvent keyEvent);

        boolean dispatchTouchEvent(MotionEvent motionEvent);

        void dispatchTrackballEvent(MotionEvent motionEvent);

        AccessibilityNodeProvider getAccessibilityNodeProvider();

        String[] getDisplayedValues();

        EditText getEditText();

        int getMaxHeight();

        int getMaxValue();

        int getMaxWidth();

        int getMinHeight();

        int getMinValue();

        int getMinWidth();

        int getPaintFlags();

        int getValue();

        boolean getWrapSelectorWheel();

        boolean isChangedDefaultInterval();

        boolean isEditTextMode();

        boolean isEditTextModeEnabled();

        boolean isEditTextModeNotAmPm();

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

        void setAmPm();

        boolean setCustomInterval(int i);

        void setCustomIntervalValue(int i);

        void setCustomNumberPickerIdleColor(int i);

        void setCustomNumberPickerScrollColor(int i);

        void setCustomTalkbackFormatter(CustomTalkbackFormatter customTalkbackFormatter);

        void setDateUnit(int i);

        void setDisplayedValues(String[] strArr);

        void setEditTextMode(boolean z);

        void setEditTextModeEnabled(boolean z);

        void setEnabled(boolean z);

        void setErrorToastMessage(String str);

        void setFormatter(Formatter formatter);

        void setImeOptions(int i);

        void setMaxInputLength(int i);

        void setMaxValue(int i);

        void setMinValue(int i);

        void setMonthInputMode();

        void setOnEditTextModeChangedListener(OnEditTextModeChangedListener onEditTextModeChangedListener);

        void setOnScrollListener(OnScrollListener onScrollListener);

        void setOnValueChangedListener(OnValueChangeListener onValueChangeListener);

        void setPaintFlags(int i);

        void setPickerContentDescription(String str);

        void setSubTextSize(float f);

        void setSubTextTypeface(Typeface typeface);

        void setTextSize(float f);

        void setTextTypeface(Typeface typeface);

        void setValue(int i);

        void setWrapSelectorWheel(boolean z);

        void setYearDateTimeInputMode();

        void startAnimation(int i, SeslAnimationListener seslAnimationListener);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnEditTextModeChangedListener {
        void onEditTextModeChanged(SeslNumberPicker seslNumberPicker, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface ScrollState {
        }

        void onScrollStateChange(SeslNumberPicker seslNumberPicker, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnValueChangeListener {
        void onValueChange(SeslNumberPicker seslNumberPicker, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TwoDigitFormatter implements Formatter {
        java.util.Formatter mFmt;
        char mZeroDigit;
        final StringBuilder mBuilder = new StringBuilder();
        final Object[] mArgs = new Object[1];

        public TwoDigitFormatter() {
            init(Locale.getDefault());
        }

        private java.util.Formatter createFormatter(Locale locale) {
            return new java.util.Formatter(this.mBuilder, locale);
        }

        @RequiresApi(24)
        private static char getZeroDigit(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale).getZeroDigit();
        }

        private void init(Locale locale) {
            this.mFmt = createFormatter(locale);
            this.mZeroDigit = getZeroDigit(locale);
        }

        @Override // androidx.picker.widget.SeslNumberPicker.Formatter
        public String format(int i) {
            Locale locale = Locale.getDefault();
            if (this.mZeroDigit != getZeroDigit(locale)) {
                init(locale);
            }
            this.mArgs[0] = Integer.valueOf(i);
            synchronized (this.mBuilder) {
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
                this.mFmt.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, this.mArgs);
            }
            return this.mFmt.toString();
        }
    }

    public SeslNumberPicker(Context context) {
        this(context, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Formatter getTwoDigitFormatter() {
        return sTwoDigitFormatter;
    }

    public void applyWheelCustomInterval(boolean z) {
        this.mDelegate.applyWheelCustomInterval(z);
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
        return this.mDelegate.isEditTextModeNotAmPm() ? super.dispatchHoverEvent(motionEvent) : this.mDelegate.dispatchHoverEvent(motionEvent);
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
        return this.mDelegate.isEditTextModeNotAmPm() ? super.getAccessibilityNodeProvider() : this.mDelegate.getAccessibilityNodeProvider();
    }

    public String[] getDisplayedValues() {
        return this.mDelegate.getDisplayedValues();
    }

    public EditText getEditText() {
        return this.mDelegate.getEditText();
    }

    public int[] getEnableStateSet() {
        return LinearLayout.ENABLED_STATE_SET;
    }

    public int getMaxValue() {
        return this.mDelegate.getMaxValue();
    }

    public int getMinValue() {
        return this.mDelegate.getMinValue();
    }

    public int getPaintFlags() {
        return this.mDelegate.getPaintFlags();
    }

    public int getValue() {
        return this.mDelegate.getValue();
    }

    public boolean getWrapSelectorWheel() {
        return this.mDelegate.getWrapSelectorWheel();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isChangedDefaultInterval() {
        return this.mDelegate.isChangedDefaultInterval();
    }

    public boolean isEditTextMode() {
        return this.mDelegate.isEditTextMode();
    }

    public boolean isEditTextModeEnabled() {
        return this.mDelegate.isEditTextModeEnabled();
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
        if (this.mDelegate.isEditTextModeNotAmPm()) {
            super.onDraw(canvas);
        } else {
            this.mDelegate.onDraw(canvas);
        }
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
        if (this.mDelegate.isEditTextModeNotAmPm()) {
            return super.performClick();
        }
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

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setAmPm() {
        this.mDelegate.setAmPm();
    }

    public boolean setCustomInterval(int i) {
        return this.mDelegate.setCustomInterval(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setCustomIntervalValue(int i) {
        this.mDelegate.setCustomIntervalValue(i);
    }

    public void setCustomNumberPickerIdleColor(int i) {
        this.mDelegate.setCustomNumberPickerIdleColor(i);
    }

    public void setCustomNumberPickerScrollColor(int i) {
        this.mDelegate.setCustomNumberPickerScrollColor(i);
    }

    public void setCustomTalkbackFormatter(CustomTalkbackFormatter customTalkbackFormatter) {
        this.mDelegate.setCustomTalkbackFormatter(customTalkbackFormatter);
    }

    public void setDateUnit(int i) {
        this.mDelegate.setDateUnit(i);
    }

    public void setDisplayedValues(String[] strArr) {
        this.mDelegate.setDisplayedValues(strArr);
    }

    public void setEditTextMode(boolean z) {
        this.mDelegate.setEditTextMode(z);
    }

    public void setEditTextModeEnabled(boolean z) {
        this.mDelegate.setEditTextModeEnabled(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mDelegate.setEnabled(z);
    }

    public void setErrorToastMessage(String str) {
        this.mDelegate.setErrorToastMessage(str);
    }

    public void setFormatter(Formatter formatter) {
        this.mDelegate.setFormatter(formatter);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMaxInputLength(int i) {
        this.mDelegate.setMaxInputLength(i);
    }

    public void setMaxValue(int i) {
        this.mDelegate.setMaxValue(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMeasuredDimensionWrapper(int i, int i2) {
        setMeasuredDimension(i, i2);
    }

    public void setMinValue(int i) {
        this.mDelegate.setMinValue(i);
    }

    public void setMonthInputMode() {
        this.mDelegate.setMonthInputMode();
    }

    public void setOnEditTextModeChangedListener(OnEditTextModeChangedListener onEditTextModeChangedListener) {
        this.mDelegate.setOnEditTextModeChangedListener(onEditTextModeChangedListener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mDelegate.setOnScrollListener(onScrollListener);
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

    public void setSubTextSize(float f) {
        this.mDelegate.setSubTextSize(f);
    }

    public void setSubTextTypeface(Typeface typeface) {
        this.mDelegate.setSubTextTypeface(typeface);
    }

    public void setTextSize(float f) {
        this.mDelegate.setTextSize(f);
    }

    public void setTextTypeface(Typeface typeface) {
        this.mDelegate.setTextTypeface(typeface);
    }

    public void setValue(int i) {
        this.mDelegate.setValue(i);
    }

    public void setWrapSelectorWheel(boolean z) {
        this.mDelegate.setWrapSelectorWheel(z);
    }

    public void setYearDateTimeInputMode() {
        this.mDelegate.setYearDateTimeInputMode();
    }

    public void startAnimation(int i, SeslAnimationListener seslAnimationListener) {
        this.mDelegate.startAnimation(i, seslAnimationListener);
    }

    @SuppressLint({"WrongCall"})
    public void superOnMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public SeslNumberPicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean isVisibleToUserWrapper(Rect rect) {
        return SeslViewReflector.isVisibleToUser(this, rect);
    }

    public SeslNumberPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslNumberPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDelegate = new SeslNumberPickerSpinnerDelegate(this, context, attributeSet, i, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void performClick(boolean z) {
        this.mDelegate.performClick(z);
    }

    public void setOnLongPressUpdateInterval(long j) {
    }

    public void setSkipValuesOnLongPressEnabled(boolean z) {
    }
}
