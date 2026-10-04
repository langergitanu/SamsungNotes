package androidx.picker.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.picker.util.SeslAnimationListener;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
public class SeslTimePicker extends FrameLayout {
    public static final int PICKER_AMPM = 2;
    public static final int PICKER_DIVIDER = 3;
    public static final int PICKER_HOUR = 0;
    public static final int PICKER_MINUTE = 1;
    private TimePickerDelegate mDelegate;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class AbsTimePickerDelegate implements TimePickerDelegate {
        protected Context mContext;
        Locale mCurrentLocale;
        SeslTimePicker mDelegator;
        OnEditTextModeChangedListener mOnEditTextModeChangedListener;
        OnTimeChangedListener mOnTimeChangedListener;

        public AbsTimePickerDelegate(@NonNull SeslTimePicker seslTimePicker, @NonNull Context context) {
            this.mDelegator = seslTimePicker;
            this.mContext = context;
            setCurrentLocale(Locale.getDefault());
        }

        @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
        public void setCurrentLocale(Locale locale) {
            if (locale.equals(this.mCurrentLocale)) {
                return;
            }
            this.mCurrentLocale = locale;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnEditTextModeChangedListener {
        void onEditTextModeChanged(SeslTimePicker seslTimePicker, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTimeChangedListener {
        void onTimeChanged(SeslTimePicker seslTimePicker, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TimePickerDelegate {
        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        int getBaseline();

        int getDefaultHeight();

        int getDefaultWidth();

        EditText getEditText(int i);

        int getHour();

        int getMinute();

        SeslNumberPicker getNumberPicker(int i);

        boolean is24Hour();

        boolean isEditTextMode();

        boolean isEnabled();

        void onConfigurationChanged(Configuration configuration);

        void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onRestoreInstanceState(Parcelable parcelable);

        Parcelable onSaveInstanceState(Parcelable parcelable);

        void requestLayout();

        void set5MinuteInterval(boolean z);

        void setCurrentLocale(Locale locale);

        void setCustomTimePickerIdleColor(int i);

        void setCustomTimePickerScrollColor(int i);

        void setEditTextMode(boolean z);

        void setEnabled(boolean z);

        void setHour(@IntRange(from = 0, m706to = 23) int i);

        void setIs24Hour(boolean z);

        void setMinute(@IntRange(from = 0, m706to = 59) int i);

        void setNumberPickerSubTextTypeface(int i, Typeface typeface);

        void setNumberPickerTextSize(int i, float f);

        void setNumberPickerTextTypeface(int i, Typeface typeface);

        void setOnEditTextModeChangedListener(OnEditTextModeChangedListener onEditTextModeChangedListener);

        void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener);

        void showMarginLeft(boolean z);

        void startAnimation(int i, SeslAnimationListener seslAnimationListener);
    }

    public SeslTimePicker(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mDelegate.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.mDelegate.getBaseline();
    }

    public EditText getEditText(int i) {
        return this.mDelegate.getEditText(i);
    }

    public int getHour() {
        return this.mDelegate.getHour();
    }

    public int getMinute() {
        return this.mDelegate.getMinute();
    }

    public SeslNumberPicker getNumberPicker(int i) {
        return this.mDelegate.getNumberPicker(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean is24HourView() {
        return this.mDelegate.is24Hour();
    }

    public boolean isEditTextMode() {
        return this.mDelegate.isEditTextMode();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mDelegate.isEnabled();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        this.mDelegate.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mDelegate.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(this.mDelegate.getDefaultWidth(), 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.mDelegate.getDefaultHeight(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.mDelegate.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View.BaseSavedState baseSavedState = (View.BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.mDelegate.onRestoreInstanceState(baseSavedState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return this.mDelegate.onSaveInstanceState(super.onSaveInstanceState());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        TimePickerDelegate timePickerDelegate = this.mDelegate;
        if (timePickerDelegate != null) {
            timePickerDelegate.requestLayout();
        }
    }

    public void set5MinuteInterval() {
        set5MinuteInterval(true);
    }

    public void setCustomTimePickerIdleColor(int i) {
        this.mDelegate.setCustomTimePickerIdleColor(i);
    }

    public void setCustomTimePickerScrollColor(int i) {
        this.mDelegate.setCustomTimePickerScrollColor(i);
    }

    public void setEditTextMode(boolean z) {
        this.mDelegate.setEditTextMode(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mDelegate.setEnabled(z);
    }

    public void setHour(@IntRange(from = 0, m706to = 23) int i) {
        this.mDelegate.setHour(MathUtils.clamp(i, 0, 23));
    }

    public void setIs24HourView(@NonNull Boolean bool) {
        if (bool == null) {
            return;
        }
        this.mDelegate.setIs24Hour(bool.booleanValue());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setLocale(Locale locale) {
        this.mDelegate.setCurrentLocale(locale);
    }

    public void setMinute(@IntRange(from = 0, m706to = 59) int i) {
        this.mDelegate.setMinute(MathUtils.clamp(i, 0, 59));
    }

    public void setNumberPickerSubTextTypeface(int i, @NonNull Typeface typeface) {
        this.mDelegate.setNumberPickerSubTextTypeface(i, typeface);
    }

    public void setNumberPickerTextSize(int i, float f) {
        this.mDelegate.setNumberPickerTextSize(i, f);
    }

    public void setNumberPickerTextTypeface(int i, @NonNull Typeface typeface) {
        this.mDelegate.setNumberPickerTextTypeface(i, typeface);
    }

    public void setOnEditTextModeChangedListener(OnEditTextModeChangedListener onEditTextModeChangedListener) {
        this.mDelegate.setOnEditTextModeChangedListener(onEditTextModeChangedListener);
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mDelegate.setOnTimeChangedListener(onTimeChangedListener);
    }

    public void showMarginLeft(@NonNull Boolean bool) {
        this.mDelegate.showMarginLeft(bool.booleanValue());
    }

    public void startAnimation(int i, SeslAnimationListener seslAnimationListener) {
        this.mDelegate.startAnimation(i, seslAnimationListener);
    }

    public SeslTimePicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    public void set5MinuteInterval(boolean z) {
        this.mDelegate.set5MinuteInterval(z);
    }

    public SeslTimePicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslTimePicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDelegate = new SeslTimePickerSpinnerDelegate(this, context, attributeSet, i, i2);
    }
}
