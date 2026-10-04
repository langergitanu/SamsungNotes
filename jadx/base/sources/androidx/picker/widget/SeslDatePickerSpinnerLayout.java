package androidx.picker.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.glance.AbstractC2821a;
import androidx.picker.C3623R;
import androidx.picker.widget.SeslDatePicker;
import androidx.picker.widget.SeslNumberPicker;
import androidx.reflect.lunarcalendar.SeslFeatureReflector;
import androidx.reflect.lunarcalendar.SeslSolarLunarTablesReflector;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import dalvik.system.PathClassLoader;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SeslDatePickerSpinnerLayout extends LinearLayout {
    private static final int FONT_WEIGHT_SEMIBOLD = 600;
    private static final int FORMAT_DDMMYYYY = 1;
    private static final int FORMAT_MMDDYYYY = 0;
    private static final int FORMAT_YYYYDDMM = 3;
    private static final int FORMAT_YYYYMMDD = 2;
    private static final int HUNGARIAN_MONTH_TEXT_SIZE_DIFF = 4;
    private static final int PICKER_DAY = 0;
    private static final int PICKER_MONTH = 1;
    private static final int PICKER_YEAR = 2;
    private static final boolean SESL_DEBUG = false;
    private static final String TAG = "SeslDatePickerSpinnerLayout";
    private Context mContext;
    protected Calendar mCurrentDate;
    protected Locale mCurrentLocale;
    protected SeslDatePicker mDatePicker;
    protected final View mDayPaddingView;
    protected final SeslNumberPicker mDaySpinner;
    protected final EditText mDaySpinnerInput;
    private TextView.OnEditorActionListener mEditorActionListener;
    private boolean mIsEditTextMode;
    protected boolean mIsLeapMonth;
    protected boolean mIsLunar;
    protected int mLunarCurrentDay;
    protected int mLunarCurrentMonth;
    protected int mLunarCurrentYear;
    protected int mLunarTempDay;
    protected int mLunarTempMonth;
    protected int mLunarTempYear;
    protected Calendar mMaxDate;
    protected Calendar mMinDate;
    private SeslNumberPicker.OnEditTextModeChangedListener mModeChangeListener;
    protected final SeslNumberPicker mMonthSpinner;
    protected final EditText mMonthSpinnerInput;
    protected String[] mMonths;
    protected int mNumberOfMonths;
    private SeslDatePicker.OnEditTextModeChangedListener mOnEditTextModeChangedListener;
    private OnSpinnerDateChangedListener mOnSpinnerDateChangedListener;
    PathClassLoader mPathClassLoader;
    private EditText[] mPickerTexts;
    protected String[] mShortMonths;
    private Object mSolarLunarTables;
    protected final LinearLayout mSpinners;
    protected Calendar mTempDate;
    private Toast mToast;
    private String mToastText;
    protected final View mYearPaddingView;
    protected final SeslNumberPicker mYearSpinner;
    protected final EditText mYearSpinnerInput;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSpinnerDateChangedListener {
        void onDateChanged(SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout, int i, int i2, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SeslKeyListener implements View.OnKeyListener {
        public SeslKeyListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SeslDatePickerSpinnerLayout.this.seslLog(keyEvent.toString());
            if (keyEvent.getAction() != 1) {
                return false;
            }
            if (i == 23) {
                int i2 = SeslDatePickerSpinnerLayout.this.getResources().getConfiguration().keyboard;
                return false;
            }
            if (i != 61) {
                if (i != 66 && i != 160) {
                    return false;
                }
                if (SeslDatePickerSpinnerLayout.this.isEditTextMode()) {
                    EditText editText = (EditText) view;
                    if ((editText.getImeOptions() & 5) == 5) {
                        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(SeslDatePickerSpinnerLayout.this.mDatePicker, view, 2);
                        if (viewFindNextFocus == null) {
                            return true;
                        }
                        viewFindNextFocus.requestFocus();
                    } else if ((editText.getImeOptions() & 6) == 6) {
                        SeslDatePickerSpinnerLayout.this.updateInputState();
                        SeslDatePickerSpinnerLayout.this.setEditTextMode(false);
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SeslTextWatcher implements TextWatcher {
        private static final int INVALID_POSITION_ID = -1;
        private static final int LAST_POSITION_ID = 2;
        private int mChangedLen;
        private int mCheck;
        private int mId;
        private boolean mIsMonth;
        private int mMaxLen;
        private int mNext;
        private String mPrevText;

        private void changeFocus() {
            AccessibilityManager accessibilityManager = (AccessibilityManager) SeslDatePickerSpinnerLayout.this.mContext.getSystemService("accessibility");
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                SeslDatePickerSpinnerLayout.this.seslLog("[" + this.mId + "] changeFocus() mNext : " + this.mNext + ", mCheck : " + this.mCheck);
                if (this.mNext >= 0) {
                    if (!SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mCheck].isFocused()) {
                        SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mNext].requestFocus();
                    }
                    if (SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mId].isFocused()) {
                        SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mId].clearFocus();
                    }
                }
            }
        }

        private boolean isFarsiLanguage() {
            return MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(SeslDatePickerSpinnerLayout.this.mCurrentLocale.getLanguage());
        }

        private boolean isMeaLanguage() {
            String language = SeslDatePickerSpinnerLayout.this.mCurrentLocale.getLanguage();
            return "ar".equals(language) || MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(language) || "ur".equals(language);
        }

        private boolean isMonthStr(String str) {
            int i = 0;
            while (true) {
                SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout = SeslDatePickerSpinnerLayout.this;
                if (i >= seslDatePickerSpinnerLayout.mNumberOfMonths) {
                    return false;
                }
                if (str.equals(seslDatePickerSpinnerLayout.mShortMonths[i])) {
                    return true;
                }
                i++;
            }
        }

        private boolean isNumericStr(String str) {
            return !TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0));
        }

        private boolean isSwaLanguage() {
            String language = SeslDatePickerSpinnerLayout.this.mCurrentLocale.getLanguage();
            return "hi".equals(language) || "ta".equals(language) || "ml".equals(language) || "te".equals(language) || "or".equals(language) || "ne".equals(language) || "as".equals(language) || "bn".equals(language) || "gu".equals(language) || "si".equals(language) || "pa".equals(language) || "kn".equals(language) || "mr".equals(language);
        }

        private void showInvalidValueEnteredToast(String str, int i) {
            SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mId].setText(str);
            if (i != 0) {
                SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mId].setSelection(i);
            }
            if (SeslDatePickerSpinnerLayout.this.mToast == null) {
                SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout = SeslDatePickerSpinnerLayout.this;
                seslDatePickerSpinnerLayout.mToast = Toast.makeText(seslDatePickerSpinnerLayout.mContext, SeslDatePickerSpinnerLayout.this.mToastText, 0);
                View viewInflate = LayoutInflater.from(SeslDatePickerSpinnerLayout.this.mContext).inflate(C3623R.layout.sesl_custom_toast_layout, (ViewGroup) null);
                ((TextView) viewInflate.findViewById(C3623R.id.message)).setText(SeslDatePickerSpinnerLayout.this.mToastText);
                SeslDatePickerSpinnerLayout.this.mToast.setView(viewInflate);
            }
            SeslDatePickerSpinnerLayout.this.mToast.show();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SeslDatePickerSpinnerLayout.this.seslLog("[" + this.mId + "] afterTextChanged: " + editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout = SeslDatePickerSpinnerLayout.this;
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.mId);
            sb.append("] beforeTextChanged: ");
            sb.append((Object) charSequence);
            sb.append(SQLKeyword.COMMA);
            AbstractC2821a.m2235z(sb, i, i2, SQLKeyword.COMMA, SQLKeyword.COMMA);
            sb.append(i4);
            seslDatePickerSpinnerLayout.seslLog(sb.toString());
            this.mPrevText = charSequence.toString();
            this.mChangedLen = i4;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            SeslDatePickerSpinnerLayout.this.seslLog("[" + this.mId + "] onTextChanged: " + this.mPrevText + " -> " + ((Object) charSequence));
            int length = charSequence.length();
            String string = charSequence.toString();
            String str = (String) SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mId].getTag();
            if (str != null && ("onClick".equals(str) || "onLongClick".equals(str))) {
                SeslDatePickerSpinnerLayout.this.seslLog("[" + this.mId + "] TAG exists: " + str);
                return;
            }
            if (SeslDatePickerSpinnerLayout.this.mPickerTexts[this.mId].isFocused()) {
                if (this.mIsMonth) {
                    if (!SeslDatePickerSpinnerLayout.this.usingNumericMonths() || this.mChangedLen != 1) {
                        if (isNumericStr(this.mPrevText)) {
                            return;
                        }
                        if (length < this.mMaxLen) {
                            if ((isSwaLanguage() || isFarsiLanguage()) && length > 0 && !isNumericStr(string)) {
                                changeFocus();
                                return;
                            }
                            return;
                        }
                        if (!isMeaLanguage()) {
                            changeFocus();
                            return;
                        } else {
                            if (TextUtils.isEmpty(this.mPrevText) && isMonthStr(string)) {
                                changeFocus();
                                return;
                            }
                            return;
                        }
                    }
                    SeslDatePickerSpinnerLayout.this.seslLog(AbstractC2821a.m2223n(new StringBuilder("["), "] Samsung Keypad Num Month", this.mId));
                    int minValue = SeslDatePickerSpinnerLayout.this.mMonthSpinner.getMinValue();
                    int i5 = Integer.parseInt(string);
                    if (length == this.mMaxLen) {
                        if (i5 >= minValue) {
                            changeFocus();
                            return;
                        } else if (Character.getNumericValue(string.charAt(0)) < 2) {
                            showInvalidValueEnteredToast(Character.toString(string.charAt(0)), 1);
                            return;
                        } else {
                            showInvalidValueEnteredToast("", 0);
                            return;
                        }
                    }
                    if (length > 0) {
                        if (minValue >= 10 && "0".equals(string)) {
                            showInvalidValueEnteredToast("", 0);
                            return;
                        }
                        if ("1".equals(string) || "0".equals(string)) {
                            return;
                        }
                        if (i5 < minValue) {
                            showInvalidValueEnteredToast("", 0);
                            return;
                        } else {
                            changeFocus();
                            return;
                        }
                    }
                    return;
                }
                if (this.mChangedLen == 1) {
                    if (this.mMaxLen >= 3) {
                        int minValue2 = SeslDatePickerSpinnerLayout.this.mYearSpinner.getMinValue();
                        int maxValue = SeslDatePickerSpinnerLayout.this.mYearSpinner.getMaxValue();
                        int i6 = Integer.parseInt(string);
                        if (this.mPrevText.length() >= length || length != this.mMaxLen) {
                            int i7 = length - 1;
                            int iPow = (int) (1000.0d / Math.pow(10.0d, i7));
                            String strSubstring = length != 1 ? string.substring(0, i7) : "";
                            if (i6 < minValue2 / iPow || i6 > maxValue / iPow) {
                                showInvalidValueEnteredToast(strSubstring, i7);
                                return;
                            }
                            return;
                        }
                        if (i6 < minValue2 || i6 > maxValue) {
                            showInvalidValueEnteredToast(string.substring(0, 3), 3);
                            return;
                        }
                        int value = SeslDatePickerSpinnerLayout.this.usingNumericMonths() ? SeslDatePickerSpinnerLayout.this.mMonthSpinner.getValue() - 1 : SeslDatePickerSpinnerLayout.this.mMonthSpinner.getValue();
                        SeslDatePickerSpinnerLayout.this.mTempDate.clear();
                        SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout = SeslDatePickerSpinnerLayout.this;
                        seslDatePickerSpinnerLayout.mTempDate.set(i6, value, seslDatePickerSpinnerLayout.mDaySpinner.getValue());
                        Calendar calendar = Calendar.getInstance();
                        calendar.clear();
                        calendar.set(SeslDatePickerSpinnerLayout.this.mMinDate.get(1), SeslDatePickerSpinnerLayout.this.mMinDate.get(2), SeslDatePickerSpinnerLayout.this.mMinDate.get(5));
                        if (!SeslDatePickerSpinnerLayout.this.mTempDate.before(calendar)) {
                            SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout2 = SeslDatePickerSpinnerLayout.this;
                            if (!seslDatePickerSpinnerLayout2.mTempDate.after(seslDatePickerSpinnerLayout2.mMaxDate)) {
                                changeFocus();
                                return;
                            }
                        }
                        showInvalidValueEnteredToast(string.substring(0, 3), 3);
                        return;
                    }
                    int minValue3 = SeslDatePickerSpinnerLayout.this.mDaySpinner.getMinValue();
                    int i8 = Integer.parseInt(string);
                    if (this.mPrevText.length() < length && length == this.mMaxLen) {
                        if (i8 >= minValue3) {
                            changeFocus();
                            return;
                        } else if (Character.getNumericValue(string.charAt(0)) < 4) {
                            showInvalidValueEnteredToast(Character.toString(string.charAt(0)), 1);
                            return;
                        } else {
                            showInvalidValueEnteredToast("", 0);
                            return;
                        }
                    }
                    if ((minValue3 >= 10 && i8 == 0) || ((minValue3 >= 20 && (i8 == 0 || i8 == 1)) || (minValue3 >= 30 && (i8 == 0 || i8 == 1 || i8 == 2)))) {
                        showInvalidValueEnteredToast("", 0);
                        return;
                    }
                    if (i8 > 3) {
                        if (i8 < minValue3) {
                            showInvalidValueEnteredToast("", 0);
                            return;
                        }
                        changeFocus();
                    }
                    int value2 = SeslDatePickerSpinnerLayout.this.usingNumericMonths() ? SeslDatePickerSpinnerLayout.this.mMonthSpinner.getValue() - 1 : SeslDatePickerSpinnerLayout.this.mMonthSpinner.getValue();
                    if (!SeslDatePickerSpinnerLayout.this.mIsLunar && value2 == 1 && i8 == 3) {
                        if (i8 < minValue3) {
                            showInvalidValueEnteredToast("", 0);
                        } else {
                            changeFocus();
                        }
                    }
                }
            }
        }

        private SeslTextWatcher(int i, int i2, boolean z) {
            this.mChangedLen = 0;
            this.mMaxLen = i;
            this.mId = i2;
            this.mIsMonth = z;
            int i4 = i2 - 1;
            this.mCheck = i4;
            if (i4 < 0) {
                this.mCheck = 2;
            }
            this.mNext = i2 + 1 > 2 ? -1 : i2 + 1;
        }
    }

    public SeslDatePickerSpinnerLayout(Context context) {
        this(context, null);
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLunarMaxDayOfMonth(int i, int i2, boolean z) {
        Object obj = this.mSolarLunarTables;
        if (obj == null) {
            return 0;
        }
        return SeslSolarLunarTablesReflector.getDayLengthOf(this.mPathClassLoader, obj, i, i2, z);
    }

    private boolean isNewDate(int i, int i2, int i4) {
        return (this.mCurrentDate.get(1) == i && this.mCurrentDate.get(2) == i2 && this.mCurrentDate.get(5) == i4) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDateChanged() {
        OnSpinnerDateChangedListener onSpinnerDateChangedListener = this.mOnSpinnerDateChangedListener;
        if (onSpinnerDateChangedListener != null) {
            onSpinnerDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    private void reorderSpinners() {
        this.mSpinners.removeAllViews();
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(this.mContext);
        int length = dateFormatOrder.length;
        for (int i = 0; i < length; i++) {
            char c = dateFormatOrder[i];
            if (c == 'M') {
                this.mSpinners.addView(this.mMonthSpinner);
                setImeOptions(this.mMonthSpinner, length, i);
            } else if (c == 'd') {
                this.mSpinners.addView(this.mDaySpinner);
                setImeOptions(this.mDaySpinner, length, i);
            } else {
                if (c != 'y') {
                    throw new IllegalArgumentException(Arrays.toString(dateFormatOrder));
                }
                this.mSpinners.addView(this.mYearSpinner);
                setImeOptions(this.mYearSpinner, length, i);
            }
        }
        if (dateFormatOrder[0] == 'y') {
            this.mSpinners.addView(this.mYearPaddingView, 0);
            this.mSpinners.addView(this.mDayPaddingView);
        } else {
            this.mSpinners.addView(this.mDayPaddingView, 0);
            this.mSpinners.addView(this.mYearPaddingView);
        }
        char c2 = dateFormatOrder[0];
        char c4 = dateFormatOrder[1];
        if (c2 == 'M') {
            setTextWatcher(0);
            return;
        }
        if (c2 == 'd') {
            setTextWatcher(1);
        } else {
            if (c2 != 'y') {
                return;
            }
            if (c4 == 'd') {
                setTextWatcher(3);
            } else {
                setTextWatcher(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(int i, int i2, int i4) {
        this.mCurrentDate.set(i, i2, i4);
        if (this.mIsLunar) {
            this.mLunarCurrentYear = i;
            this.mLunarCurrentMonth = i2;
            this.mLunarCurrentDay = i4;
        }
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        } else if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
    }

    private void setImeOptions(SeslNumberPicker seslNumberPicker, int i, int i2) {
        ((TextView) seslNumberPicker.findViewById(C3623R.id.numberpicker_input)).setImeOptions(i2 < i + (-1) ? 33554437 : 33554438);
    }

    private void setSpinnersTextSize() {
        Resources resources = this.mContext.getResources();
        int integer = resources.getInteger(C3623R.integer.sesl_date_picker_spinner_number_text_size);
        int integer2 = resources.getInteger(C3623R.integer.sesl_date_picker_spinner_number_text_size_with_unit);
        float f = integer;
        this.mDaySpinner.setTextSize(f);
        this.mYearSpinner.setTextSize(f);
        String language = this.mCurrentLocale.getLanguage();
        if ("my".equals(language) || "ml".equals(language) || "ar".equals(language) || MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(language)) {
            integer = resources.getInteger(C3623R.integer.sesl_date_picker_spinner_long_month_text_size);
        } else if ("ga".equals(language)) {
            integer = resources.getInteger(C3623R.integer.sesl_date_picker_spinner_long_month_text_size) - 1;
        } else if ("hu".equals(language)) {
            integer -= 4;
        }
        if (usingNumericMonths()) {
            this.mMonthSpinner.setTextSize(f);
        } else {
            this.mMonthSpinner.setTextSize(integer);
        }
        if (LangPackConfigConstants.LANGUAGE_CODE_KO.equals(language) || "zh".equals(language) || LangPackConfigConstants.LANGUAGE_CODE_JA.equals(language)) {
            float f4 = integer2;
            this.mDaySpinner.setTextSize(f4);
            this.mMonthSpinner.setTextSize(f4);
            this.mYearSpinner.setTextSize(f4);
            this.mDaySpinner.setDateUnit(997);
            this.mMonthSpinner.setDateUnit(998);
            this.mYearSpinner.setDateUnit(999);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setTextWatcher(int i) {
        int i2;
        int i4;
        int i5;
        int i6;
        seslLog("setTextWatcher() usingNumericMonths  : " + usingNumericMonths() + "format  : " + i);
        if (i != 0) {
            if (i == 1) {
                i5 = 0;
                i4 = 2;
            } else if (i == 2) {
                i4 = 0;
                i5 = 2;
            } else {
                if (i != 3) {
                    i4 = -1;
                    i2 = -1;
                    i5 = -1;
                    this.mPickerTexts[i4] = this.mYearSpinner.getEditText();
                    this.mPickerTexts[i2] = this.mMonthSpinner.getEditText();
                    this.mPickerTexts[i5] = this.mDaySpinner.getEditText();
                    int i7 = i4;
                    this.mPickerTexts[i4].addTextChangedListener(new SeslTextWatcher(4, i4, false));
                    if (usingNumericMonths()) {
                        int i8 = i2;
                        this.mPickerTexts[i2].addTextChangedListener(new SeslTextWatcher(2, i8, true));
                        i6 = i8;
                    } else {
                        int i9 = i2;
                        i6 = i9;
                        this.mPickerTexts[i9].addTextChangedListener(new SeslTextWatcher(3, i9, true));
                    }
                    int i10 = i5;
                    this.mPickerTexts[i5].addTextChangedListener(new SeslTextWatcher(2, i10, false));
                    if (i != 3 || usingNumericMonths()) {
                        EditText[] editTextArr = this.mPickerTexts;
                        editTextArr[editTextArr.length - 1].setOnEditorActionListener(this.mEditorActionListener);
                    }
                    this.mPickerTexts[i7].setOnKeyListener(new SeslKeyListener());
                    this.mPickerTexts[i6].setOnKeyListener(new SeslKeyListener());
                    this.mPickerTexts[i10].setOnKeyListener(new SeslKeyListener());
                }
                i4 = 0;
                i2 = 2;
            }
            i2 = 1;
            this.mPickerTexts[i4] = this.mYearSpinner.getEditText();
            this.mPickerTexts[i2] = this.mMonthSpinner.getEditText();
            this.mPickerTexts[i5] = this.mDaySpinner.getEditText();
            int i72 = i4;
            this.mPickerTexts[i4].addTextChangedListener(new SeslTextWatcher(4, i4, false));
            if (usingNumericMonths()) {
            }
            int i102 = i5;
            this.mPickerTexts[i5].addTextChangedListener(new SeslTextWatcher(2, i102, false));
            if (i != 3) {
                EditText[] editTextArr2 = this.mPickerTexts;
                editTextArr2[editTextArr2.length - 1].setOnEditorActionListener(this.mEditorActionListener);
            }
            this.mPickerTexts[i72].setOnKeyListener(new SeslKeyListener());
            this.mPickerTexts[i6].setOnKeyListener(new SeslKeyListener());
            this.mPickerTexts[i102].setOnKeyListener(new SeslKeyListener());
        }
        i2 = 0;
        i4 = 2;
        i5 = 1;
        this.mPickerTexts[i4] = this.mYearSpinner.getEditText();
        this.mPickerTexts[i2] = this.mMonthSpinner.getEditText();
        this.mPickerTexts[i5] = this.mDaySpinner.getEditText();
        int i722 = i4;
        this.mPickerTexts[i4].addTextChangedListener(new SeslTextWatcher(4, i4, false));
        if (usingNumericMonths()) {
        }
        int i1022 = i5;
        this.mPickerTexts[i5].addTextChangedListener(new SeslTextWatcher(2, i1022, false));
        if (i != 3) {
        }
        this.mPickerTexts[i722].setOnKeyListener(new SeslKeyListener());
        this.mPickerTexts[i6].setOnKeyListener(new SeslKeyListener());
        this.mPickerTexts[i1022].setOnKeyListener(new SeslKeyListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateModeState(boolean z) {
        if (this.mIsEditTextMode == z || z) {
            return;
        }
        if (this.mDaySpinner.isEditTextMode()) {
            this.mDaySpinner.setEditTextMode(false);
        }
        if (this.mMonthSpinner.isEditTextMode()) {
            this.mMonthSpinner.setEditTextMode(false);
        }
        if (this.mYearSpinner.isEditTextMode()) {
            this.mYearSpinner.setEditTextMode(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpinners(boolean z, boolean z2, boolean z3, boolean z4) {
        EditText[] editTextArr;
        int actualMaximum;
        int lunarMaxDayOfMonth;
        int i;
        int i2;
        int i4;
        if (z2) {
            this.mYearSpinner.setMinValue(this.mMinDate.get(1));
            this.mYearSpinner.setMaxValue(this.mMaxDate.get(1));
            this.mYearSpinner.setWrapSelectorWheel(false);
        }
        if (z3) {
            if (this.mMaxDate.get(1) - this.mMinDate.get(1) == 0) {
                i2 = this.mMinDate.get(2);
                i4 = this.mMaxDate.get(2);
            } else {
                int i5 = this.mCurrentDate.get(1);
                if (this.mIsLunar) {
                    i5 = this.mLunarCurrentYear;
                }
                if (i5 == this.mMinDate.get(1)) {
                    i2 = this.mMinDate.get(2);
                } else if (i5 == this.mMaxDate.get(1)) {
                    i4 = this.mMaxDate.get(2);
                    i2 = 0;
                } else {
                    i2 = 0;
                }
                i4 = 11;
            }
            if (usingNumericMonths()) {
                i2++;
                i4++;
            }
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(i2);
            this.mMonthSpinner.setMaxValue(i4);
            if (!usingNumericMonths()) {
                this.mMonthSpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.mShortMonths, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
            }
        }
        if (z4) {
            int i6 = this.mMaxDate.get(1) - this.mMinDate.get(1);
            int i7 = this.mMaxDate.get(2) - this.mMinDate.get(2);
            if (i6 == 0 && i7 == 0) {
                i = this.mMinDate.get(5);
                lunarMaxDayOfMonth = this.mMaxDate.get(5);
            } else {
                int i8 = this.mCurrentDate.get(1);
                int i9 = this.mCurrentDate.get(2);
                if (this.mIsLunar) {
                    i8 = this.mLunarCurrentYear;
                    i9 = this.mLunarCurrentMonth;
                }
                if (i8 == this.mMinDate.get(1) && i9 == this.mMinDate.get(2)) {
                    int i10 = this.mMinDate.get(5);
                    int actualMaximum2 = this.mCurrentDate.getActualMaximum(5);
                    if (this.mIsLunar) {
                        lunarMaxDayOfMonth = getLunarMaxDayOfMonth(i8, i9, this.mIsLeapMonth);
                        i = i10;
                    } else {
                        i = i10;
                        lunarMaxDayOfMonth = actualMaximum2;
                    }
                } else if (i8 == this.mMaxDate.get(1) && i9 == this.mMaxDate.get(2)) {
                    actualMaximum = this.mMaxDate.get(5);
                    if (this.mIsLunar) {
                        lunarMaxDayOfMonth = Math.min(actualMaximum, getLunarMaxDayOfMonth(i8, i9, this.mIsLeapMonth));
                        i = 1;
                    }
                    i = 1;
                    lunarMaxDayOfMonth = actualMaximum;
                } else {
                    actualMaximum = this.mCurrentDate.getActualMaximum(5);
                    if (this.mIsLunar) {
                        lunarMaxDayOfMonth = getLunarMaxDayOfMonth(i8, i9, this.mIsLeapMonth);
                        i = 1;
                    }
                    i = 1;
                    lunarMaxDayOfMonth = actualMaximum;
                }
            }
            this.mDaySpinner.setMinValue(i);
            this.mDaySpinner.setMaxValue(lunarMaxDayOfMonth);
        }
        if (z) {
            this.mYearSpinner.setValue(this.mCurrentDate.get(1));
            int i11 = this.mCurrentDate.get(2);
            if (this.mIsLunar) {
                i11 = this.mLunarCurrentMonth;
            }
            if (usingNumericMonths()) {
                this.mMonthSpinner.setValue(i11 + 1);
            } else {
                this.mMonthSpinner.setValue(i11);
            }
            int i12 = this.mCurrentDate.get(5);
            if (this.mIsLunar) {
                i12 = this.mLunarCurrentDay;
            }
            this.mDaySpinner.setValue(i12);
            if (usingNumericMonths()) {
                this.mMonthSpinnerInput.setRawInputType(2);
            }
            if (!this.mIsEditTextMode || (editTextArr = this.mPickerTexts) == null) {
                return;
            }
            for (EditText editText : editTextArr) {
                if (editText.hasFocus()) {
                    editText.setSelection(0, 0);
                    editText.selectAll();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean usingNumericMonths() {
        return Character.isDigit(this.mShortMonths[0].charAt(0));
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public int getDayOfMonth() {
        return this.mIsLunar ? this.mLunarCurrentDay : this.mCurrentDate.get(5);
    }

    public EditText getEditText(int i) {
        return i != 0 ? i != 1 ? i != 2 ? this.mDaySpinner.getEditText() : this.mYearSpinner.getEditText() : this.mMonthSpinner.getEditText() : this.mDaySpinner.getEditText();
    }

    public Calendar getMaxDate() {
        return this.mMaxDate;
    }

    public Calendar getMinDate() {
        return this.mMinDate;
    }

    public int getMonth() {
        return this.mIsLunar ? this.mLunarCurrentMonth : this.mCurrentDate.get(2);
    }

    public SeslNumberPicker getNumberPicker(int i) {
        return i != 0 ? i != 1 ? i != 2 ? this.mDaySpinner : this.mYearSpinner : this.mMonthSpinner : this.mDaySpinner;
    }

    public int getYear() {
        return this.mIsLunar ? this.mLunarCurrentYear : this.mCurrentDate.get(1);
    }

    public void init(int i, int i2, int i4) {
        setDate(i, i2, i4);
        updateSpinners(true, true, true, true);
    }

    public boolean isEditTextMode() {
        return this.mIsEditTextMode;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
        setSpinnersTextSize();
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.mCurrentDate.getTimeInMillis(), 20));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        SeslNumberPicker seslNumberPicker = this.mDaySpinner;
        if (seslNumberPicker != null) {
            seslNumberPicker.requestLayout();
        }
        SeslNumberPicker seslNumberPicker2 = this.mYearSpinner;
        if (seslNumberPicker2 != null) {
            seslNumberPicker2.requestLayout();
        }
        SeslNumberPicker seslNumberPicker3 = this.mMonthSpinner;
        if (seslNumberPicker3 != null) {
            seslNumberPicker3.requestLayout();
        }
    }

    public void setCurrentLocale(Locale locale) {
        this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
        this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
        this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
        this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
        this.mNumberOfMonths = this.mTempDate.getActualMaximum(2) + 1;
        this.mShortMonths = new DateFormatSymbols().getShortMonths();
        this.mMonths = new DateFormatSymbols().getMonths();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.mShortMonths;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = strArr[i2].toUpperCase();
            i2++;
        }
        if (usingNumericMonths()) {
            this.mShortMonths = new String[this.mNumberOfMonths];
            while (i < this.mNumberOfMonths) {
                int i4 = i + 1;
                this.mShortMonths[i] = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i4));
                i = i4;
            }
        }
    }

    public void setEditTextMode(boolean z) {
        if (this.mIsEditTextMode == z) {
            return;
        }
        this.mIsEditTextMode = z;
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        this.mDaySpinner.setEditTextMode(z);
        this.mMonthSpinner.setEditTextMode(z);
        this.mYearSpinner.setEditTextMode(z);
        if (inputMethodManager != null) {
            if (this.mIsEditTextMode) {
                inputMethodManager.showSoftInput(this.mDaySpinner, 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
        SeslDatePicker.OnEditTextModeChangedListener onEditTextModeChangedListener = this.mOnEditTextModeChangedListener;
        if (onEditTextModeChangedListener != null) {
            onEditTextModeChangedListener.onEditTextModeChanged(this.mDatePicker, z);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.mDaySpinner.setEnabled(z);
        this.mMonthSpinner.setEnabled(z);
        this.mYearSpinner.setEnabled(z);
    }

    public void setIsLeapMonth(boolean z) {
        this.mIsLeapMonth = z;
    }

    public void setLunar(boolean z, boolean z2, PathClassLoader pathClassLoader) {
        this.mIsLunar = z;
        this.mIsLeapMonth = z2;
        if (z && this.mPathClassLoader == null) {
            this.mPathClassLoader = pathClassLoader;
            this.mSolarLunarTables = SeslFeatureReflector.getSolarLunarTables(pathClassLoader);
        }
        updateSpinners(false, true, true, true);
    }

    public void setMaxDate(long j) {
        this.mMaxDate.setTimeInMillis(j);
        if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
        updateSpinners(true, true, true, true);
    }

    public void setMinDate(long j) {
        this.mMinDate.setTimeInMillis(j);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        }
        updateSpinners(true, true, true, true);
    }

    public void setOnEditTextModeChangedListener(SeslDatePicker seslDatePicker, SeslDatePicker.OnEditTextModeChangedListener onEditTextModeChangedListener) {
        if (this.mDatePicker == null) {
            this.mDatePicker = seslDatePicker;
        }
        this.mOnEditTextModeChangedListener = onEditTextModeChangedListener;
    }

    public void setOnSpinnerDateChangedListener(SeslDatePicker seslDatePicker, OnSpinnerDateChangedListener onSpinnerDateChangedListener) {
        if (this.mDatePicker == null) {
            this.mDatePicker = seslDatePicker;
        }
        this.mOnSpinnerDateChangedListener = onSpinnerDateChangedListener;
    }

    public void updateDate(int i, int i2, int i4) {
        if (isNewDate(i, i2, i4)) {
            setDate(i, i2, i4);
            updateSpinners(true, true, true, true);
        }
    }

    public void updateInputState() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(this.mYearSpinnerInput)) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                this.mYearSpinnerInput.clearFocus();
            } else if (inputMethodManager.isActive(this.mMonthSpinnerInput)) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                this.mMonthSpinnerInput.clearFocus();
            } else if (inputMethodManager.isActive(this.mDaySpinnerInput)) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                this.mDaySpinnerInput.clearFocus();
            }
        }
    }

    public SeslDatePickerSpinnerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public SeslDatePickerSpinnerLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslDatePickerSpinnerLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        Typeface typefaceCreate;
        super(context, attributeSet, i, i2);
        this.mIsLunar = false;
        this.mIsLeapMonth = false;
        this.mPathClassLoader = null;
        this.mModeChangeListener = new SeslNumberPicker.OnEditTextModeChangedListener() { // from class: androidx.picker.widget.SeslDatePickerSpinnerLayout.1
            @Override // androidx.picker.widget.SeslNumberPicker.OnEditTextModeChangedListener
            public void onEditTextModeChanged(SeslNumberPicker seslNumberPicker, boolean z) {
                SeslDatePickerSpinnerLayout.this.setEditTextMode(z);
                SeslDatePickerSpinnerLayout.this.updateModeState(z);
            }
        };
        this.mPickerTexts = new EditText[3];
        this.mEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.picker.widget.SeslDatePickerSpinnerLayout.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                if (i4 == 6) {
                    SeslDatePickerSpinnerLayout.this.updateInputState();
                    SeslDatePickerSpinnerLayout.this.setEditTextMode(false);
                }
                return false;
            }
        };
        this.mContext = context;
        LayoutInflater.from(context).inflate(C3623R.layout.sesl_date_picker_spinner, (ViewGroup) this, true);
        Locale locale = Locale.getDefault();
        this.mCurrentLocale = locale;
        setCurrentLocale(locale);
        SeslNumberPicker.OnValueChangeListener onValueChangeListener = new SeslNumberPicker.OnValueChangeListener() { // from class: androidx.picker.widget.SeslDatePickerSpinnerLayout.2
            /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x012f  */
            @Override // androidx.picker.widget.SeslNumberPicker.OnValueChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onValueChange(SeslNumberPicker seslNumberPicker, int i4, int i5) {
                boolean z;
                boolean z2;
                SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout;
                SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout2;
                SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout3 = SeslDatePickerSpinnerLayout.this;
                seslDatePickerSpinnerLayout3.mTempDate.setTimeInMillis(seslDatePickerSpinnerLayout3.mCurrentDate.getTimeInMillis());
                SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout4 = SeslDatePickerSpinnerLayout.this;
                if (seslDatePickerSpinnerLayout4.mIsLunar) {
                    seslDatePickerSpinnerLayout4.mLunarTempYear = seslDatePickerSpinnerLayout4.mLunarCurrentYear;
                    seslDatePickerSpinnerLayout4.mLunarTempMonth = seslDatePickerSpinnerLayout4.mLunarCurrentMonth;
                    seslDatePickerSpinnerLayout4.mLunarTempDay = seslDatePickerSpinnerLayout4.mLunarCurrentDay;
                }
                if (seslNumberPicker.equals(seslDatePickerSpinnerLayout4.mDaySpinner)) {
                    int actualMaximum = SeslDatePickerSpinnerLayout.this.mTempDate.getActualMaximum(5);
                    SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout5 = SeslDatePickerSpinnerLayout.this;
                    if (seslDatePickerSpinnerLayout5.mIsLunar) {
                        actualMaximum = seslDatePickerSpinnerLayout5.getLunarMaxDayOfMonth(seslDatePickerSpinnerLayout5.mTempDate.get(1), SeslDatePickerSpinnerLayout.this.mTempDate.get(2), SeslDatePickerSpinnerLayout.this.mIsLeapMonth);
                    }
                    if ((i4 == actualMaximum && i5 == 1) || (i4 == 1 && i5 == actualMaximum)) {
                        SeslDatePickerSpinnerLayout.this.mTempDate.set(5, i5);
                        SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout6 = SeslDatePickerSpinnerLayout.this;
                        if (seslDatePickerSpinnerLayout6.mIsLunar) {
                            seslDatePickerSpinnerLayout6.mLunarTempDay = i5;
                        }
                    } else {
                        int i6 = i5 - i4;
                        SeslDatePickerSpinnerLayout.this.mTempDate.add(5, i6);
                        SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout7 = SeslDatePickerSpinnerLayout.this;
                        if (seslDatePickerSpinnerLayout7.mIsLunar) {
                            seslDatePickerSpinnerLayout7.mLunarTempDay += i6;
                        }
                    }
                    z = false;
                } else {
                    if (seslNumberPicker.equals(SeslDatePickerSpinnerLayout.this.mMonthSpinner)) {
                        if ((i4 == 11 && i5 == 0) || (i4 == 0 && i5 == 11)) {
                            SeslDatePickerSpinnerLayout.this.mTempDate.set(2, i5);
                            SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout8 = SeslDatePickerSpinnerLayout.this;
                            if (seslDatePickerSpinnerLayout8.mIsLunar) {
                                seslDatePickerSpinnerLayout8.mLunarTempMonth = i5;
                            }
                        } else {
                            int i7 = i5 - i4;
                            SeslDatePickerSpinnerLayout.this.mTempDate.add(2, i7);
                            SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout9 = SeslDatePickerSpinnerLayout.this;
                            if (seslDatePickerSpinnerLayout9.mIsLunar) {
                                seslDatePickerSpinnerLayout9.mLunarTempMonth += i7;
                            }
                        }
                        z = false;
                        z2 = true;
                        seslDatePickerSpinnerLayout = SeslDatePickerSpinnerLayout.this;
                        if (seslDatePickerSpinnerLayout.mIsLunar) {
                            int lunarMaxDayOfMonth = seslDatePickerSpinnerLayout.getLunarMaxDayOfMonth(seslDatePickerSpinnerLayout.mLunarTempYear, seslDatePickerSpinnerLayout.mLunarTempMonth, seslDatePickerSpinnerLayout.mIsLeapMonth);
                            SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout10 = SeslDatePickerSpinnerLayout.this;
                            if (seslDatePickerSpinnerLayout10.mLunarTempDay > lunarMaxDayOfMonth) {
                                seslDatePickerSpinnerLayout10.mLunarTempDay = lunarMaxDayOfMonth;
                            }
                            if (seslDatePickerSpinnerLayout10.mIsLeapMonth) {
                                PathClassLoader pathClassLoader = seslDatePickerSpinnerLayout10.mPathClassLoader;
                                Object obj = seslDatePickerSpinnerLayout10.mSolarLunarTables;
                                SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout11 = SeslDatePickerSpinnerLayout.this;
                                seslDatePickerSpinnerLayout10.mIsLeapMonth = SeslSolarLunarTablesReflector.isLeapMonth(pathClassLoader, obj, seslDatePickerSpinnerLayout11.mLunarTempYear, seslDatePickerSpinnerLayout11.mLunarTempMonth);
                            }
                        }
                        int i8 = SeslDatePickerSpinnerLayout.this.mTempDate.get(1);
                        int i9 = SeslDatePickerSpinnerLayout.this.mTempDate.get(2);
                        int i10 = SeslDatePickerSpinnerLayout.this.mTempDate.get(5);
                        seslDatePickerSpinnerLayout2 = SeslDatePickerSpinnerLayout.this;
                        if (seslDatePickerSpinnerLayout2.mIsLunar) {
                            i8 = seslDatePickerSpinnerLayout2.mLunarTempYear;
                            i9 = seslDatePickerSpinnerLayout2.mLunarTempMonth;
                            i10 = seslDatePickerSpinnerLayout2.mLunarTempDay;
                        }
                        seslDatePickerSpinnerLayout2.setDate(i8, i9, i10);
                        if (!z || z2) {
                            SeslDatePickerSpinnerLayout.this.updateSpinners(false, false, z, z2);
                        }
                        SeslDatePickerSpinnerLayout.this.notifyDateChanged();
                    }
                    if (!seslNumberPicker.equals(SeslDatePickerSpinnerLayout.this.mYearSpinner)) {
                        throw new IllegalArgumentException();
                    }
                    int i11 = i5 - i4;
                    SeslDatePickerSpinnerLayout.this.mTempDate.add(1, i11);
                    SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout12 = SeslDatePickerSpinnerLayout.this;
                    if (seslDatePickerSpinnerLayout12.mIsLunar) {
                        seslDatePickerSpinnerLayout12.mLunarTempYear += i11;
                    }
                    z = true;
                }
                z2 = z;
                seslDatePickerSpinnerLayout = SeslDatePickerSpinnerLayout.this;
                if (seslDatePickerSpinnerLayout.mIsLunar) {
                }
                int i82 = SeslDatePickerSpinnerLayout.this.mTempDate.get(1);
                int i92 = SeslDatePickerSpinnerLayout.this.mTempDate.get(2);
                int i102 = SeslDatePickerSpinnerLayout.this.mTempDate.get(5);
                seslDatePickerSpinnerLayout2 = SeslDatePickerSpinnerLayout.this;
                if (seslDatePickerSpinnerLayout2.mIsLunar) {
                }
                seslDatePickerSpinnerLayout2.setDate(i82, i92, i102);
                if (!z) {
                    SeslDatePickerSpinnerLayout.this.updateSpinners(false, false, z, z2);
                }
                SeslDatePickerSpinnerLayout.this.notifyDateChanged();
            }
        };
        this.mSpinners = (LinearLayout) findViewById(C3623R.id.sesl_date_picker_pickers);
        this.mDayPaddingView = findViewById(C3623R.id.sesl_date_picker_spinner_day_padding);
        this.mYearPaddingView = findViewById(C3623R.id.sesl_date_picker_spinner_year_padding);
        SeslNumberPicker seslNumberPicker = (SeslNumberPicker) findViewById(C3623R.id.sesl_date_picker_spinner_day);
        this.mDaySpinner = seslNumberPicker;
        this.mDaySpinnerInput = (EditText) seslNumberPicker.findViewById(C3623R.id.numberpicker_input);
        seslNumberPicker.setFormatter(SeslNumberPicker.getTwoDigitFormatter());
        seslNumberPicker.setOnValueChangedListener(onValueChangeListener);
        seslNumberPicker.setOnEditTextModeChangedListener(this.mModeChangeListener);
        seslNumberPicker.setMaxInputLength(2);
        seslNumberPicker.setYearDateTimeInputMode();
        SeslNumberPicker seslNumberPicker2 = (SeslNumberPicker) findViewById(C3623R.id.sesl_date_picker_spinner_month);
        this.mMonthSpinner = seslNumberPicker2;
        EditText editText = (EditText) seslNumberPicker2.findViewById(C3623R.id.numberpicker_input);
        this.mMonthSpinnerInput = editText;
        if (usingNumericMonths()) {
            seslNumberPicker2.setMinValue(1);
            seslNumberPicker2.setMaxValue(12);
            seslNumberPicker2.setYearDateTimeInputMode();
            seslNumberPicker2.setMaxInputLength(2);
        } else {
            seslNumberPicker2.setMinValue(0);
            seslNumberPicker2.setMaxValue(this.mNumberOfMonths - 1);
            seslNumberPicker2.setFormatter(null);
            seslNumberPicker2.setDisplayedValues(this.mShortMonths);
            editText.setInputType(1);
            seslNumberPicker2.setMonthInputMode();
            seslNumberPicker2.setCustomTalkbackFormatter(new SeslNumberPicker.CustomTalkbackFormatter() { // from class: androidx.picker.widget.SeslDatePickerSpinnerLayout.3
                @Override // androidx.picker.widget.SeslNumberPicker.CustomTalkbackFormatter
                @NonNull
                public String format(int i4) {
                    return SeslDatePickerSpinnerLayout.this.mMonths[i4];
                }
            });
        }
        seslNumberPicker2.setOnValueChangedListener(onValueChangeListener);
        seslNumberPicker2.setOnEditTextModeChangedListener(this.mModeChangeListener);
        SeslNumberPicker seslNumberPicker3 = (SeslNumberPicker) findViewById(C3623R.id.sesl_date_picker_spinner_year);
        this.mYearSpinner = seslNumberPicker3;
        this.mYearSpinnerInput = (EditText) seslNumberPicker3.findViewById(C3623R.id.numberpicker_input);
        seslNumberPicker3.setOnValueChangedListener(onValueChangeListener);
        seslNumberPicker3.setOnEditTextModeChangedListener(this.mModeChangeListener);
        seslNumberPicker3.setMaxInputLength(4);
        seslNumberPicker3.setYearDateTimeInputMode();
        if (Build.VERSION.SDK_INT >= 34) {
            typefaceCreate = Typeface.create(Typeface.create("sec", 0), 600, false);
        } else {
            typefaceCreate = Typeface.create("sec-roboto-light", 1);
        }
        seslNumberPicker.setTextTypeface(typefaceCreate);
        seslNumberPicker2.setTextTypeface(typefaceCreate);
        seslNumberPicker3.setTextTypeface(typefaceCreate);
        this.mToastText = context.getResources().getString(C3623R.string.sesl_number_picker_invalid_value_entered);
        setSpinnersTextSize();
        seslNumberPicker.setPickerContentDescription(context.getResources().getString(C3623R.string.sesl_date_picker_day));
        seslNumberPicker2.setPickerContentDescription(context.getResources().getString(C3623R.string.sesl_date_picker_month));
        seslNumberPicker3.setPickerContentDescription(context.getResources().getString(C3623R.string.sesl_date_picker_year));
        this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        init(this.mCurrentDate.get(1), this.mCurrentDate.get(2), this.mCurrentDate.get(5));
        reorderSpinners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seslLog(String str) {
    }
}
