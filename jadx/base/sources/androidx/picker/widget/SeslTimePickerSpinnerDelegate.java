package androidx.picker.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.icu.text.DateFormatSymbols;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.picker.C3623R;
import androidx.picker.util.SeslAnimationListener;
import androidx.picker.util.SeslPickerBasicUtils;
import androidx.picker.widget.SeslNumberPicker;
import androidx.picker.widget.SeslTimePicker;
import androidx.reflect.icu.SeslLocaleDataReflector;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SeslTimePickerSpinnerDelegate extends SeslTimePicker.AbsTimePickerDelegate {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int DEFAULT_MINUTE_INTERVAL = 1;
    private static final char[] DIGIT_CHARACTERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, 2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415, 2534, 2535, 2536, 2537, 2538, 2539, 2540, 2541, 2542, 2543, 3302, 3303, 3304, 3305, 3306, 3307, 3308, 3309, 3310, 3311, 4160, 4161, 4162, 4163, 4164, 4165, 4166, 4167, 4168, 4169};
    private static final int FONT_WEIGHT_REGULAR = 400;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final int LAST_HOUR_IN_DAY = 23;
    private static final int LAYOUT_MODE_DEFAULT = 0;
    private static final int LAYOUT_MODE_MULTIPANE = 2;
    private static final int LAYOUT_MODE_PHONE = 1;
    private static final char QUOTE = '\'';
    private static final String TAG = "SeslTimePickerSpinner";
    private final View mAmPmMarginInside;
    private final SeslNumberPicker mAmPmSpinner;
    private final EditText mAmPmSpinnerInput;
    private final String[] mAmPmStrings;
    private final View mDTPaddingLeft;
    private final View mDTPaddingRight;
    private final int mDefaultHeight;
    private final int mDefaultWidth;
    private final TextView mDivider;
    private TextView.OnEditorActionListener mEditorActionListener;
    private char mHourFormat;
    private final SeslNumberPicker mHourSpinner;
    private final EditText mHourSpinnerInput;
    private boolean mHourWithTwoDigit;
    private boolean mIs24HourView;
    private boolean mIsAm;
    private boolean mIsAmPmAutoFlipped;
    private boolean mIsDateTimeMode;
    private boolean mIsEditTextMode;
    private boolean mIsEnabled;
    private boolean mIsInvalidMinute;
    private boolean mIsMarginLeftShown;
    private int mLayoutMode;
    private int mMinuteInterval;
    private final SeslNumberPicker mMinuteSpinner;
    private final EditText mMinuteSpinnerInput;
    private SeslNumberPicker.OnEditTextModeChangedListener mModeChangeListener;
    private final View mPaddingLeft;
    private final View mPaddingRight;
    private EditText[] mPickerTexts;
    private boolean mSkipToChangeInterval;
    private Calendar mTempCalendar;
    private final LinearLayout mTimeLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SeslKeyListener implements View.OnKeyListener {
        public SeslKeyListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1) {
                return false;
            }
            if (i == 23) {
                return SeslTimePickerSpinnerDelegate.this.mDelegator.getResources().getConfiguration().keyboard != 3;
            }
            if (i != 61) {
                if (i != 66 && i != 160) {
                    return false;
                }
                if (SeslTimePickerSpinnerDelegate.this.isEditTextMode()) {
                    EditText editText = (EditText) view;
                    if ((editText.getImeOptions() & 5) == 5) {
                        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(SeslTimePickerSpinnerDelegate.this.mDelegator, view, 2);
                        if (viewFindNextFocus == null) {
                            return true;
                        }
                        viewFindNextFocus.requestFocus();
                    } else if ((editText.getImeOptions() & 6) == 6) {
                        SeslTimePickerSpinnerDelegate.this.updateInputState();
                        SeslTimePickerSpinnerDelegate.this.setEditTextMode(false);
                    }
                }
            }
            return true;
        }
    }

    public SeslTimePickerSpinnerDelegate(SeslTimePicker seslTimePicker, Context context, AttributeSet attributeSet, int i, int i2) {
        super(seslTimePicker, context);
        this.mIsInvalidMinute = false;
        this.mSkipToChangeInterval = false;
        this.mIsEnabled = true;
        this.mIsAmPmAutoFlipped = false;
        this.mMinuteInterval = 1;
        this.mPickerTexts = new EditText[3];
        this.mModeChangeListener = new SeslNumberPicker.OnEditTextModeChangedListener() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.4
            @Override // androidx.picker.widget.SeslNumberPicker.OnEditTextModeChangedListener
            public void onEditTextModeChanged(SeslNumberPicker seslNumberPicker, boolean z) {
                SeslTimePickerSpinnerDelegate.this.setEditTextMode(z);
                SeslTimePickerSpinnerDelegate.this.updateModeState(z);
            }
        };
        this.mEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                if (i4 == 6) {
                    if (!SeslTimePickerSpinnerDelegate.this.mSkipToChangeInterval && !SeslTimePickerSpinnerDelegate.this.mMinuteSpinner.isChangedDefaultInterval() && SeslTimePickerSpinnerDelegate.this.mMinuteSpinner.getValue() % 5 != 0) {
                        SeslTimePickerSpinnerDelegate.this.mMinuteSpinner.applyWheelCustomInterval(false);
                    }
                    SeslTimePickerSpinnerDelegate.this.updateInputState();
                    SeslTimePickerSpinnerDelegate.this.setEditTextMode(false);
                }
                return false;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, C3623R.styleable.TimePicker, i, i2);
        this.mIsDateTimeMode = typedArrayObtainStyledAttributes.getBoolean(C3623R.styleable.TimePicker_dateTimeMode, false);
        this.mLayoutMode = typedArrayObtainStyledAttributes.getInt(C3623R.styleable.TimePicker_timeLayoutMode, 0);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        if (isDateTimeMode()) {
            int i4 = this.mLayoutMode;
            if (i4 == 1) {
                layoutInflaterFrom.inflate(C3623R.layout.sesl_spinning_datepicker_time_picker_spinner_phone, (ViewGroup) this.mDelegator, true);
            } else if (i4 == 2) {
                layoutInflaterFrom.inflate(C3623R.layout.sesl_spinning_datepicker_time_picker_spinner_multipane, (ViewGroup) this.mDelegator, true);
            } else {
                layoutInflaterFrom.inflate(C3623R.layout.sesl_spinning_datepicker_time_picker_spinner, (ViewGroup) this.mDelegator, true);
            }
        } else {
            layoutInflaterFrom.inflate(C3623R.layout.sesl_time_picker_spinner, (ViewGroup) this.mDelegator, true);
        }
        SeslNumberPicker seslNumberPicker = (SeslNumberPicker) seslTimePicker.findViewById(C3623R.id.sesl_timepicker_hour);
        this.mHourSpinner = seslNumberPicker;
        seslNumberPicker.setPickerContentDescription(context.getResources().getString(C3623R.string.sesl_time_picker_hour));
        seslNumberPicker.setOnEditTextModeChangedListener(this.mModeChangeListener);
        seslNumberPicker.setOnValueChangedListener(new SeslNumberPicker.OnValueChangeListener() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.1
            @Override // androidx.picker.widget.SeslNumberPicker.OnValueChangeListener
            public void onValueChange(SeslNumberPicker seslNumberPicker2, int i5, int i6) {
                if (!SeslTimePickerSpinnerDelegate.this.is24Hour() && !SeslTimePickerSpinnerDelegate.this.mIsEditTextMode) {
                    int i7 = SeslTimePickerSpinnerDelegate.this.mHourFormat == 'K' ? 0 : 12;
                    if ((i5 == 11 && i6 == i7) || (i5 == i7 && i6 == 11)) {
                        SeslTimePickerSpinnerDelegate seslTimePickerSpinnerDelegate = SeslTimePickerSpinnerDelegate.this;
                        seslTimePickerSpinnerDelegate.mIsAm = seslTimePickerSpinnerDelegate.mAmPmSpinner.getValue() != 0;
                        SeslTimePickerSpinnerDelegate.this.mAmPmSpinner.setEnabled(false);
                        SeslTimePickerSpinnerDelegate.this.mAmPmSpinner.performClick(false);
                        SeslTimePickerSpinnerDelegate.this.mIsAmPmAutoFlipped = true;
                        new Handler().postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SeslTimePickerSpinnerDelegate.this.mIsAmPmAutoFlipped = false;
                                if (SeslTimePickerSpinnerDelegate.this.mAmPmSpinner != null) {
                                    SeslTimePickerSpinnerDelegate.this.mAmPmSpinner.setEnabled(true);
                                }
                            }
                        }, 500L);
                    }
                }
                SeslTimePickerSpinnerDelegate.this.onTimeChanged();
            }
        });
        EditText editText = (EditText) seslNumberPicker.findViewById(C3623R.id.numberpicker_input);
        this.mHourSpinnerInput = editText;
        seslNumberPicker.setYearDateTimeInputMode();
        editText.setImeOptions(33554437);
        seslNumberPicker.setMaxInputLength(2);
        editText.setOnEditorActionListener(this.mEditorActionListener);
        TextView textView = (TextView) this.mDelegator.findViewById(C3623R.id.sesl_timepicker_divider);
        this.mDivider = textView;
        if (textView != null) {
            setDividerText();
        }
        Resources resources = this.mDelegator.getResources();
        int i5 = resources.getConfiguration().smallestScreenWidthDp;
        if (i5 >= 600) {
            this.mDefaultWidth = resources.getDimensionPixelSize(C3623R.dimen.sesl_time_picker_dialog_min_width);
        } else {
            this.mDefaultWidth = (int) (TypedValue.applyDimension(1, i5, resources.getDisplayMetrics()) + 0.5f);
        }
        this.mDefaultHeight = resources.getDimensionPixelSize(C3623R.dimen.sesl_time_picker_spinner_height);
        SeslNumberPicker seslNumberPicker2 = (SeslNumberPicker) this.mDelegator.findViewById(C3623R.id.sesl_timepicker_minute);
        this.mMinuteSpinner = seslNumberPicker2;
        seslNumberPicker2.setYearDateTimeInputMode();
        seslNumberPicker2.setMinValue(0);
        seslNumberPicker2.setMaxValue(59);
        seslNumberPicker2.setOnLongPressUpdateInterval(100L);
        seslNumberPicker2.setSkipValuesOnLongPressEnabled(true);
        seslNumberPicker2.setFormatter(SeslNumberPicker.getTwoDigitFormatter());
        seslNumberPicker2.setPickerContentDescription(context.getResources().getString(C3623R.string.sesl_time_picker_minute));
        seslNumberPicker2.setOnEditTextModeChangedListener(this.mModeChangeListener);
        seslNumberPicker2.setOnValueChangedListener(new SeslNumberPicker.OnValueChangeListener() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.2
            @Override // androidx.picker.widget.SeslNumberPicker.OnValueChangeListener
            public void onValueChange(SeslNumberPicker seslNumberPicker3, int i6, int i7) {
                SeslTimePickerSpinnerDelegate.this.onTimeChanged();
            }
        });
        EditText editText2 = (EditText) seslNumberPicker2.findViewById(C3623R.id.numberpicker_input);
        this.mMinuteSpinnerInput = editText2;
        editText2.setImeOptions(33554438);
        seslNumberPicker2.setMaxInputLength(2);
        editText2.setOnEditorActionListener(this.mEditorActionListener);
        String[] amPmStrings = getAmPmStrings(context);
        this.mAmPmStrings = amPmStrings;
        View viewFindViewById = this.mDelegator.findViewById(C3623R.id.sesl_timepicker_ampm);
        this.mDTPaddingRight = this.mDelegator.findViewById(C3623R.id.sesl_datetimepicker_padding_right);
        this.mDTPaddingLeft = this.mDelegator.findViewById(C3623R.id.sesl_datetimepicker_padding_left);
        this.mIsMarginLeftShown = false;
        this.mPaddingLeft = this.mDelegator.findViewById(C3623R.id.sesl_timepicker_padding_left);
        this.mPaddingRight = this.mDelegator.findViewById(C3623R.id.sesl_timepicker_padding_right);
        this.mTimeLayout = (LinearLayout) this.mDelegator.findViewById(C3623R.id.sesl_timepicker_hour_minute_layout);
        this.mAmPmMarginInside = this.mDelegator.findViewById(C3623R.id.sesl_timepicker_ampm_picker_margin);
        SeslNumberPicker seslNumberPicker3 = (SeslNumberPicker) viewFindViewById;
        this.mAmPmSpinner = seslNumberPicker3;
        seslNumberPicker3.setAmPm();
        seslNumberPicker3.setMinValue(0);
        seslNumberPicker3.setMaxValue(1);
        seslNumberPicker3.setDisplayedValues(amPmStrings);
        seslNumberPicker3.setOnValueChangedListener(new SeslNumberPicker.OnValueChangeListener() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.3
            @Override // androidx.picker.widget.SeslNumberPicker.OnValueChangeListener
            public void onValueChange(SeslNumberPicker seslNumberPicker4, int i6, int i7) {
                if (!SeslTimePickerSpinnerDelegate.this.mAmPmSpinner.isEnabled()) {
                    SeslTimePickerSpinnerDelegate.this.mAmPmSpinner.setEnabled(true);
                }
                if (SeslTimePickerSpinnerDelegate.this.mIsAmPmAutoFlipped) {
                    SeslTimePickerSpinnerDelegate.this.mIsAmPmAutoFlipped = false;
                    return;
                }
                if (SeslTimePickerSpinnerDelegate.this.mIsAm && i7 == 0) {
                    return;
                }
                if (SeslTimePickerSpinnerDelegate.this.mIsAm || i7 != 1) {
                    SeslTimePickerSpinnerDelegate.this.mIsAm = i7 == 0;
                    SeslTimePickerSpinnerDelegate.this.updateAmPmControl();
                    SeslTimePickerSpinnerDelegate.this.onTimeChanged();
                    SeslTimePickerSpinnerDelegate.this.validCheck();
                }
            }
        });
        EditText editText3 = (EditText) seslNumberPicker3.findViewById(C3623R.id.numberpicker_input);
        this.mAmPmSpinnerInput = editText3;
        editText3.setInputType(0);
        editText3.setCursorVisible(false);
        editText3.setFocusable(false);
        editText3.setFocusableInTouchMode(false);
        byte directionality = Character.getDirectionality(amPmStrings[0].charAt(0));
        boolean z = directionality == 1 || directionality == 2;
        Locale locale = this.mCurrentLocale;
        byte directionality2 = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        boolean z2 = directionality2 == 1 || directionality2 == 2;
        boolean zIsAmPmAtStart = isAmPmAtStart();
        if ((zIsAmPmAtStart && z2 == z) || (!zIsAmPmAtStart && z2 != z)) {
            changeAmPmView();
        }
        getHourFormatData();
        updateHourControl();
        updateAmPmControl();
        Calendar calendar = this.mTempCalendar;
        if (calendar != null) {
            setHour(calendar.get(11));
            setMinute(this.mTempCalendar.get(12));
        }
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (this.mDelegator.getImportantForAccessibility() == 0) {
            this.mDelegator.setImportantForAccessibility(1);
        }
        setTextWatcher();
        if (isDateTimeMode()) {
            float dimensionPixelSize = (resources.getDimensionPixelSize(C3623R.dimen.sesl_spinning_date_picker_date_spinner_text_size) * 160.0f) / resources.getDisplayMetrics().densityDpi;
            setNumberPickerTextSize(0, dimensionPixelSize);
            setNumberPickerTextSize(1, dimensionPixelSize);
            setNumberPickerTextSize(3, dimensionPixelSize);
            setNumberPickerTextSize(2, dimensionPixelSize);
        }
    }

    private static int appendQuotedText(SpannableStringBuilder spannableStringBuilder, int i) {
        int length = spannableStringBuilder.length();
        int i2 = i + 1;
        if (i2 < length && spannableStringBuilder.charAt(i2) == '\'') {
            spannableStringBuilder.delete(i, i2);
            return 1;
        }
        spannableStringBuilder.delete(i, i2);
        int i4 = length - 1;
        int i5 = 0;
        while (i < i4) {
            if (spannableStringBuilder.charAt(i) == '\'') {
                int i6 = i + 1;
                if (i6 >= i4 || spannableStringBuilder.charAt(i6) != '\'') {
                    spannableStringBuilder.delete(i, i6);
                    return i5;
                }
                spannableStringBuilder.delete(i, i6);
                i4--;
                i5++;
                i = i6;
            } else {
                i++;
                i5++;
            }
        }
        return i5;
    }

    private void changeAmPmView() {
        ViewGroup viewGroup = (ViewGroup) this.mDelegator.findViewById(C3623R.id.sesl_timepicker_layout);
        viewGroup.removeView(this.mAmPmSpinner);
        viewGroup.removeView(this.mAmPmMarginInside);
        int iIndexOfChild = isDateTimeMode() ? 1 + viewGroup.indexOfChild(this.mDTPaddingLeft) : 1;
        viewGroup.addView(this.mAmPmMarginInside, iIndexOfChild);
        viewGroup.addView(this.mAmPmSpinner, iIndexOfChild);
    }

    public static String[] getAmPmStrings(Context context) {
        String[] strArr = new String[2];
        if (Build.VERSION.SDK_INT >= 31) {
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols((Class<? extends android.icu.util.Calendar>) GregorianCalendar.class, context.getResources().getConfiguration().locale);
            String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
            String[] ampmNarrowStrings = SeslLocaleDataReflector.getAmpmNarrowStrings(dateFormatSymbols);
            if (isMeaLanguage()) {
                strArr[0] = amPmStrings[0];
                strArr[1] = amPmStrings[1];
                return strArr;
            }
            strArr[0] = amPmStrings[0].length() > 4 ? ampmNarrowStrings[0] : amPmStrings[0];
            strArr[1] = amPmStrings[1].length() > 4 ? ampmNarrowStrings[1] : amPmStrings[1];
            return strArr;
        }
        Object obj = SeslLocaleDataReflector.get(context.getResources().getConfiguration().locale);
        if (obj == null) {
            Log.e(TAG, "LocaleData failed. Use DateFormatSymbols for ampm");
            return new java.text.DateFormatSymbols().getAmPmStrings();
        }
        String[] field_amPm = SeslLocaleDataReflector.getField_amPm(obj);
        String field_narrowAm = SeslLocaleDataReflector.getField_narrowAm(obj);
        String field_narrowPm = SeslLocaleDataReflector.getField_narrowPm(obj);
        String str = field_amPm[0];
        String str2 = field_amPm[1];
        if (isMeaLanguage()) {
            strArr[0] = str;
            strArr[1] = str2;
            return strArr;
        }
        if (str.length() <= 4) {
            field_narrowAm = str;
        }
        strArr[0] = field_narrowAm;
        if (str2.length() <= 4) {
            field_narrowPm = str2;
        }
        strArr[1] = field_narrowPm;
        return strArr;
    }

    private static Typeface getFontTypeface(String str) {
        if (AbstractC2322a.m1607A(str)) {
            try {
                return Typeface.createFromFile(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void getHourFormatData() {
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(this.mCurrentLocale, this.mIs24HourView ? "Hm" : "hm");
        int length = bestDateTimePattern.length();
        this.mHourWithTwoDigit = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = bestDateTimePattern.charAt(i);
            if (cCharAt == 'H' || cCharAt == 'h' || cCharAt == 'K' || cCharAt == 'k') {
                this.mHourFormat = cCharAt;
                int i2 = i + 1;
                if (i2 >= length || cCharAt != bestDateTimePattern.charAt(i2)) {
                    return;
                }
                this.mHourWithTwoDigit = true;
                return;
            }
        }
    }

    private static String getHourMinSeparatorFromPattern(String str) {
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ') {
                if (cCharAt == '\'') {
                    if (z) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str.substring(i));
                        return spannableStringBuilder.subSequence(0, appendQuotedText(spannableStringBuilder, 0)).toString();
                    }
                } else if (cCharAt == 'H' || cCharAt == 'K' || cCharAt == 'h' || cCharAt == 'k') {
                    z = true;
                } else if (z) {
                    return Character.toString(str.charAt(i));
                }
            }
        }
        return ":";
    }

    private int getMinuteInterval() {
        return this.mMinuteInterval;
    }

    private boolean isAmPmAtStart() {
        return DateFormat.getBestDateTimePattern(this.mCurrentLocale, "hm").startsWith("a");
    }

    private static boolean isCharacterNumberLanguage() {
        String language = Locale.getDefault().getLanguage();
        return "lo".equals(language) || "ar".equals(language) || MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(language) || "ur".equals(language) || "my".equals(language);
    }

    private boolean isDateTimeMode() {
        return this.mIsDateTimeMode;
    }

    private static boolean isMeaLanguage() {
        String language = Locale.getDefault().getLanguage();
        return "lo".equals(language) || "ar".equals(language) || MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(language) || "ur".equals(language);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeChanged() {
        SeslTimePicker.OnTimeChangedListener onTimeChangedListener = this.mOnTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(this.mDelegator, getHour(), getMinute());
        }
    }

    private void setCurrentHour(int i, boolean z) {
        if (i == getHour()) {
            return;
        }
        if (!is24Hour()) {
            if (i >= 12) {
                this.mIsAm = false;
                if (i > 12) {
                    i -= 12;
                }
            } else {
                this.mIsAm = true;
                if (i == 0) {
                    i = 12;
                }
            }
            updateAmPmControl();
        }
        this.mHourSpinner.setValue(i);
        if (z) {
            onTimeChanged();
        }
    }

    private void setDividerText() {
        this.mDivider.setText(getHourMinSeparatorFromPattern(DateFormat.getBestDateTimePattern(this.mCurrentLocale, this.mIs24HourView ? "Hm" : "hm")));
        Typeface typefaceDefaultFromStyle = Typeface.defaultFromStyle(0);
        Typeface typefaceCreate = Typeface.create("sec-roboto-condensed-light", 0);
        Typeface typefaceCreate2 = Build.VERSION.SDK_INT >= 34 ? Typeface.create(Typeface.create("sec", 0), 400, false) : Typeface.create("sec-roboto-light", 0);
        if (!typefaceDefaultFromStyle.equals(typefaceCreate2)) {
            typefaceCreate = typefaceCreate2;
        } else if (typefaceCreate.equals(typefaceCreate2)) {
            typefaceCreate = Typeface.create("sans-serif-thin", 0);
        }
        this.mDivider.setTypeface(typefaceCreate);
        Typeface openThemeTypeface = SeslPickerBasicUtils.getOpenThemeTypeface(this.mContext);
        if (openThemeTypeface != null) {
            this.mDivider.setTypeface(openThemeTypeface);
        }
    }

    private void setMinuteInterval(int i) {
        this.mMinuteInterval = i;
    }

    private void setTextWatcher() {
        this.mPickerTexts[0] = this.mHourSpinner.getEditText();
        this.mPickerTexts[1] = this.mMinuteSpinner.getEditText();
        this.mPickerTexts[0].addTextChangedListener(new SeslTextWatcher(2, 0));
        this.mPickerTexts[1].addTextChangedListener(new SeslTextWatcher(2, 1));
        this.mPickerTexts[0].setOnKeyListener(new SeslKeyListener());
        this.mPickerTexts[1].setOnKeyListener(new SeslKeyListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAmPmControl() {
        if (is24Hour()) {
            this.mAmPmMarginInside.setVisibility(8);
            this.mAmPmSpinner.setVisibility(8);
            if (isDateTimeMode()) {
                this.mPaddingRight.setVisibility(0);
                if (this.mIsMarginLeftShown) {
                    this.mPaddingLeft.setVisibility(0);
                }
                this.mDTPaddingRight.setVisibility(8);
                this.mDTPaddingLeft.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 560.0f);
            this.mPaddingLeft.setLayoutParams(layoutParams);
            this.mPaddingRight.setLayoutParams(layoutParams);
            this.mDivider.setLayoutParams(layoutParams);
            this.mTimeLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 3080.0f));
            return;
        }
        this.mAmPmSpinner.setValue(!this.mIsAm ? 1 : 0);
        this.mAmPmSpinner.setVisibility(0);
        this.mAmPmMarginInside.setVisibility(0);
        if (isDateTimeMode()) {
            this.mPaddingLeft.setVisibility(8);
            this.mPaddingRight.setVisibility(8);
            this.mDTPaddingRight.setVisibility(0);
            if (this.mIsMarginLeftShown) {
                this.mDTPaddingLeft.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, 270.0f);
        this.mPaddingLeft.setLayoutParams(layoutParams2);
        this.mPaddingRight.setLayoutParams(layoutParams2);
        this.mDivider.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 180.0f));
        this.mTimeLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 2700.0f));
    }

    private void updateHourControl() {
        if (is24Hour()) {
            if (this.mHourFormat == 'k') {
                this.mHourSpinner.setMinValue(1);
                this.mHourSpinner.setMaxValue(24);
            } else {
                this.mHourSpinner.setMinValue(0);
                this.mHourSpinner.setMaxValue(23);
            }
        } else if (this.mHourFormat == 'K') {
            this.mHourSpinner.setMinValue(0);
            this.mHourSpinner.setMaxValue(11);
        } else {
            this.mHourSpinner.setMinValue(1);
            this.mHourSpinner.setMaxValue(12);
        }
        this.mHourSpinner.setFormatter(this.mHourWithTwoDigit ? SeslNumberPicker.getTwoDigitFormatter() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInputState() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(this.mHourSpinnerInput)) {
                inputMethodManager.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
                EditText editText = this.mHourSpinnerInput;
                if (editText != null) {
                    editText.clearFocus();
                    return;
                }
                return;
            }
            if (inputMethodManager.isActive(this.mMinuteSpinnerInput)) {
                inputMethodManager.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
                EditText editText2 = this.mMinuteSpinnerInput;
                if (editText2 != null) {
                    editText2.clearFocus();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateModeState(boolean z) {
        if (this.mIsEditTextMode == z || z) {
            return;
        }
        if (this.mHourSpinner.isEditTextMode()) {
            this.mHourSpinner.setEditTextMode(false);
        }
        if (this.mMinuteSpinner.isEditTextMode()) {
            this.mMinuteSpinner.setEditTextMode(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validCheck() {
        if (this.mIsEditTextMode) {
            EditText editText = this.mHourSpinnerInput;
            if (editText != null && editText.hasFocus()) {
                if (TextUtils.isEmpty(this.mHourSpinnerInput.getText())) {
                    return;
                }
                int i = Integer.parseInt(String.valueOf(this.mHourSpinnerInput.getText()));
                if (!is24Hour()) {
                    boolean z = this.mIsAm;
                    if (!z && i != 12) {
                        i += 12;
                    } else if (z && i == 12) {
                        i = 0;
                    }
                }
                setHour(i);
                this.mHourSpinnerInput.selectAll();
            }
            EditText editText2 = this.mMinuteSpinnerInput;
            if (editText2 == null || !editText2.hasFocus() || TextUtils.isEmpty(this.mMinuteSpinnerInput.getText())) {
                return;
            }
            setMinute(Integer.parseInt(String.valueOf(this.mMinuteSpinnerInput.getText())));
            this.mMinuteSpinnerInput.selectAll();
        }
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public int getBaseline() {
        return this.mHourSpinner.getBaseline();
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public int getDefaultHeight() {
        return this.mDefaultHeight;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public int getDefaultWidth() {
        return this.mDefaultWidth;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public EditText getEditText(int i) {
        return i != 0 ? i != 2 ? this.mMinuteSpinner.getEditText() : this.mAmPmSpinner.getEditText() : this.mHourSpinner.getEditText();
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public int getHour() {
        int value = this.mHourSpinner.getValue();
        return is24Hour() ? value : this.mIsAm ? value % 12 : (value % 12) + 12;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public int getMinute() {
        return this.mMinuteSpinner.getValue();
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public SeslNumberPicker getNumberPicker(int i) {
        return i != 0 ? i != 2 ? this.mMinuteSpinner : this.mAmPmSpinner : this.mHourSpinner;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public boolean is24Hour() {
        return this.mIs24HourView;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public boolean isEditTextMode() {
        return this.mIsEditTextMode;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void onConfigurationChanged(Configuration configuration) {
        setCurrentLocale(configuration.locale);
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setClassName(TimePicker.class.getName());
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i = this.mIs24HourView ? 129 : 65;
        this.mTempCalendar.set(11, getHour());
        this.mTempCalendar.set(12, getMinute());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.mTempCalendar.getTimeInMillis(), i));
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        setHour(savedState.getHour());
        setMinute(savedState.getMinute());
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public Parcelable onSaveInstanceState(Parcelable parcelable) {
        return new SavedState(parcelable, getHour(), getMinute());
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void requestLayout() {
        SeslNumberPicker seslNumberPicker = this.mAmPmSpinner;
        if (seslNumberPicker != null) {
            seslNumberPicker.requestLayout();
        }
        SeslNumberPicker seslNumberPicker2 = this.mHourSpinner;
        if (seslNumberPicker2 != null) {
            seslNumberPicker2.requestLayout();
        }
        SeslNumberPicker seslNumberPicker3 = this.mMinuteSpinner;
        if (seslNumberPicker3 != null) {
            seslNumberPicker3.requestLayout();
        }
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void set5MinuteInterval(boolean z) {
        if (!z) {
            this.mMinuteSpinner.setCustomIntervalValue(5);
            return;
        }
        if (getMinute() >= 58) {
            int hour = getHour();
            setCurrentHour(hour == 23 ? 0 : hour + 1, false);
        }
        this.mMinuteSpinner.setCustomIntervalValue(5);
        this.mMinuteSpinner.applyWheelCustomInterval(true);
        setMinuteInterval(5);
    }

    @Override // androidx.picker.widget.SeslTimePicker.AbsTimePickerDelegate, androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setCurrentLocale(Locale locale) {
        super.setCurrentLocale(locale);
        this.mTempCalendar = Calendar.getInstance(locale);
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setCustomTimePickerIdleColor(int i) {
        this.mHourSpinner.setCustomNumberPickerIdleColor(i);
        this.mMinuteSpinner.setCustomNumberPickerIdleColor(i);
        this.mAmPmSpinner.setCustomNumberPickerIdleColor(i);
        this.mDivider.setTextColor(i);
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setCustomTimePickerScrollColor(int i) {
        this.mHourSpinner.setCustomNumberPickerScrollColor(i);
        this.mMinuteSpinner.setCustomNumberPickerScrollColor(i);
        this.mAmPmSpinner.setCustomNumberPickerScrollColor(i);
        this.mDivider.setTextColor(this.mContext.getResources().getColor(C3623R.color.sesl_number_picker_text_color_appwidget));
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setEditTextMode(boolean z) {
        if (this.mIsEditTextMode == z) {
            return;
        }
        this.mIsEditTextMode = z;
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        this.mHourSpinner.setEditTextMode(z);
        this.mMinuteSpinner.setEditTextMode(z);
        if (inputMethodManager != null) {
            if (this.mIsEditTextMode) {
                if (!inputMethodManager.showSoftInput(this.mMinuteSpinnerInput.hasFocus() ? this.mMinuteSpinnerInput : this.mHourSpinnerInput, 0)) {
                    this.mDelegator.postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.6
                        @Override // java.lang.Runnable
                        public void run() {
                            InputMethodManager inputMethodManager2 = (InputMethodManager) SeslTimePickerSpinnerDelegate.this.mContext.getSystemService("input_method");
                            if (!SeslTimePickerSpinnerDelegate.this.mIsEditTextMode || inputMethodManager2 == null) {
                                return;
                            }
                            inputMethodManager2.showSoftInput(SeslTimePickerSpinnerDelegate.this.mMinuteSpinnerInput.hasFocus() ? SeslTimePickerSpinnerDelegate.this.mMinuteSpinnerInput : SeslTimePickerSpinnerDelegate.this.mHourSpinnerInput, 0);
                        }
                    }, 20L);
                }
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
            }
        }
        SeslTimePicker.OnEditTextModeChangedListener onEditTextModeChangedListener = this.mOnEditTextModeChangedListener;
        if (onEditTextModeChangedListener != null) {
            onEditTextModeChangedListener.onEditTextModeChanged(this.mDelegator, z);
        }
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setEnabled(boolean z) {
        this.mMinuteSpinner.setEnabled(z);
        TextView textView = this.mDivider;
        if (textView != null) {
            textView.setEnabled(z);
        }
        this.mHourSpinner.setEnabled(z);
        this.mAmPmSpinner.setEnabled(z);
        this.mIsEnabled = z;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setHour(int i) {
        setCurrentHour(i, true);
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setIs24Hour(boolean z) {
        if (this.mIs24HourView == z) {
            return;
        }
        int hour = getHour();
        this.mIs24HourView = z;
        getHourFormatData();
        updateHourControl();
        setCurrentHour(hour, false);
        updateAmPmControl();
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setMinute(int i) {
        int minuteInterval = getMinuteInterval();
        if (minuteInterval != 1) {
            if (this.mIsEditTextMode) {
                this.mMinuteSpinner.setValue(i);
            } else {
                if (i % minuteInterval == 0) {
                    this.mMinuteSpinner.applyWheelCustomInterval(true);
                } else {
                    this.mMinuteSpinner.applyWheelCustomInterval(false);
                }
                this.mMinuteSpinner.setValue(i);
            }
        } else {
            if (i == getMinute()) {
                if (isCharacterNumberLanguage()) {
                    this.mMinuteSpinner.setValue(i);
                    return;
                }
                return;
            }
            this.mMinuteSpinner.setValue(i);
        }
        onTimeChanged();
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setNumberPickerSubTextTypeface(int i, Typeface typeface) {
        if (i == 0) {
            this.mHourSpinner.setSubTextTypeface(typeface);
            return;
        }
        if (i == 1) {
            this.mMinuteSpinner.setSubTextTypeface(typeface);
        } else if (i != 2) {
            this.mMinuteSpinner.setSubTextTypeface(typeface);
        } else {
            this.mAmPmSpinner.setSubTextTypeface(typeface);
        }
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setNumberPickerTextSize(int i, float f) {
        if (i == 0) {
            this.mHourSpinner.setTextSize(f);
            return;
        }
        if (i == 1) {
            this.mMinuteSpinner.setTextSize(f);
            return;
        }
        if (i == 2) {
            this.mAmPmSpinner.setTextSize(f);
        } else if (i != 3) {
            this.mMinuteSpinner.setTextSize(f);
        } else {
            this.mDivider.setTextSize(1, f);
        }
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setNumberPickerTextTypeface(int i, Typeface typeface) {
        if (i == 0) {
            this.mHourSpinner.setTextTypeface(typeface);
            return;
        }
        if (i == 1) {
            this.mMinuteSpinner.setTextTypeface(typeface);
            return;
        }
        if (i == 2) {
            this.mAmPmSpinner.setTextTypeface(typeface);
        } else if (i != 3) {
            this.mMinuteSpinner.setTextTypeface(typeface);
        } else {
            this.mDivider.setTypeface(typeface);
        }
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setOnEditTextModeChangedListener(SeslTimePicker.OnEditTextModeChangedListener onEditTextModeChangedListener) {
        this.mOnEditTextModeChangedListener = onEditTextModeChangedListener;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void setOnTimeChangedListener(SeslTimePicker.OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void showMarginLeft(boolean z) {
        this.mIsMarginLeftShown = z;
        if (isDateTimeMode()) {
            updateAmPmControl();
        }
    }

    @Override // androidx.picker.widget.SeslTimePicker.TimePickerDelegate
    public void startAnimation(int i, SeslAnimationListener seslAnimationListener) {
        if (isAmPmAtStart()) {
            this.mAmPmSpinner.startAnimation(i, null);
            this.mHourSpinner.startAnimation(i + 55, null);
            this.mMinuteSpinner.startAnimation(i + 110, seslAnimationListener);
        } else {
            this.mHourSpinner.startAnimation(i, null);
            this.mMinuteSpinner.startAnimation(i + 55, seslAnimationListener);
            this.mAmPmSpinner.startAnimation(i + 110, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.picker.widget.SeslTimePickerSpinnerDelegate.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mHour;
        private final int mMinute;

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SeslTextWatcher implements TextWatcher {
        private int changedLen = 0;
        private int mId;
        private int mMaxLen;
        private int mNext;
        private String prevText;

        public SeslTextWatcher(int i, int i2) {
            this.mMaxLen = i;
            this.mId = i2;
            this.mNext = i2 + 1 >= 2 ? -1 : i2 + 1;
        }

        private void changeFocus() {
            if (((AccessibilityManager) SeslTimePickerSpinnerDelegate.this.mContext.getSystemService("accessibility")).isTouchExplorationEnabled()) {
                int i = this.mId;
                if (i == 0) {
                    SeslTimePickerSpinnerDelegate seslTimePickerSpinnerDelegate = SeslTimePickerSpinnerDelegate.this;
                    seslTimePickerSpinnerDelegate.setHour(Integer.parseInt(String.valueOf(seslTimePickerSpinnerDelegate.mPickerTexts[this.mId].getText())));
                    SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].selectAll();
                    return;
                } else {
                    if (i == 1) {
                        SeslTimePickerSpinnerDelegate seslTimePickerSpinnerDelegate2 = SeslTimePickerSpinnerDelegate.this;
                        seslTimePickerSpinnerDelegate2.setMinute(Integer.parseInt(String.valueOf(seslTimePickerSpinnerDelegate2.mPickerTexts[this.mId].getText())));
                        SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].selectAll();
                        return;
                    }
                    return;
                }
            }
            if (this.mNext >= 0) {
                SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mNext].requestFocus();
                if (SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].isFocused()) {
                    SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].clearFocus();
                    return;
                }
                return;
            }
            if (this.mId == 1) {
                SeslTimePickerSpinnerDelegate seslTimePickerSpinnerDelegate3 = SeslTimePickerSpinnerDelegate.this;
                seslTimePickerSpinnerDelegate3.setMinute(Integer.parseInt(String.valueOf(seslTimePickerSpinnerDelegate3.mPickerTexts[this.mId].getText())));
                SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].selectAll();
            }
        }

        private int convertDigitCharacterToNumber(String str) {
            int i = 0;
            for (char c : SeslTimePickerSpinnerDelegate.DIGIT_CHARACTERS) {
                if (str.equals(Character.toString(c))) {
                    return i % 10;
                }
                i++;
            }
            return -1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            this.prevText = charSequence.toString();
            this.changedLen = i4;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            String str = (String) SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].getTag();
            if (str != null && (str.equals("onClick") || str.equals("onLongClick"))) {
                SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].setTag("");
                return;
            }
            int i5 = this.mId;
            if (i5 == 0) {
                if (this.changedLen == 1) {
                    if (charSequence.length() == this.mMaxLen) {
                        if (SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].isFocused()) {
                            changeFocus();
                            return;
                        }
                        return;
                    } else {
                        if (charSequence.length() > 0) {
                            int iConvertDigitCharacterToNumber = convertDigitCharacterToNumber(charSequence.toString());
                            if ((iConvertDigitCharacterToNumber > 2 || (iConvertDigitCharacterToNumber > 1 && !SeslTimePickerSpinnerDelegate.this.is24Hour())) && SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].isFocused()) {
                                changeFocus();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (i5 != 1) {
                if (this.prevText.length() < charSequence.length() && charSequence.length() == this.mMaxLen && SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].isFocused()) {
                    changeFocus();
                    return;
                }
                return;
            }
            if (this.changedLen == 1) {
                if (charSequence.length() == this.mMaxLen) {
                    if (SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].isFocused()) {
                        changeFocus();
                        return;
                    }
                    return;
                }
                if (charSequence.length() > 0) {
                    int iConvertDigitCharacterToNumber2 = convertDigitCharacterToNumber(charSequence.toString());
                    if (iConvertDigitCharacterToNumber2 >= 6 && iConvertDigitCharacterToNumber2 <= 9) {
                        if (SeslTimePickerSpinnerDelegate.this.mPickerTexts[this.mId].isFocused()) {
                            SeslTimePickerSpinnerDelegate.this.mIsInvalidMinute = true;
                            changeFocus();
                            return;
                        }
                        return;
                    }
                    if (SeslTimePickerSpinnerDelegate.this.mIsInvalidMinute && (iConvertDigitCharacterToNumber2 == 5 || iConvertDigitCharacterToNumber2 == 0)) {
                        SeslTimePickerSpinnerDelegate.this.mIsInvalidMinute = false;
                        SeslTimePickerSpinnerDelegate.this.mSkipToChangeInterval = true;
                    } else {
                        SeslTimePickerSpinnerDelegate.this.mIsInvalidMinute = false;
                        SeslTimePickerSpinnerDelegate.this.mSkipToChangeInterval = false;
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    }
}
