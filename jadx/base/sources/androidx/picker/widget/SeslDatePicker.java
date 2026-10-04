package androidx.picker.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.picker.C3623R;
import androidx.picker.widget.SeslDatePickerSpinnerLayout;
import androidx.picker.widget.SeslSimpleMonthView;
import androidx.reflect.feature.SeslCscFeatureReflector;
import androidx.reflect.feature.SeslFloatingFeatureReflector;
import androidx.reflect.lunarcalendar.SeslFeatureReflector;
import androidx.reflect.lunarcalendar.SeslSolarLunarConverterReflector;
import androidx.reflect.lunarcalendar.SeslSolarLunarTablesReflector;
import androidx.reflect.p112os.SeslSystemPropertiesReflector;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslHoverPopupWindowReflector;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import dalvik.system.PathClassLoader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
public class SeslDatePicker extends LinearLayout implements SeslSimpleMonthView.OnDayClickListener, View.OnClickListener, View.OnLongClickListener, SeslSimpleMonthView.OnDeactivatedDayClickListener {
    private static final int CALENDAR_HEADER_MINIMUM_SCREEN_WIDTH_FOR_SHOWING_FULL_MONTH = 250;
    private static final PathInterpolator CALENDAR_HEADER_SPINNER_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
    private static final float CALENDAR_HEADER_SPINNER_ROTATE_DEGREE = -180.0f;
    private static final int CALENDAR_HEADER_SPINNER_ROTATION_DURATION = 350;
    public static final int DATE_MODE_END = 2;
    public static final int DATE_MODE_NONE = 0;
    public static final int DATE_MODE_START = 1;
    public static final int DATE_MODE_WEEK_SELECT = 3;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300;
    private static final int DEFAULT_MONTH_PER_YEAR = 12;
    private static final int DEFAULT_START_YEAR = 1902;
    private static final int LEAP_MONTH = 1;
    private static final int MESSAGE_CALENDAR_HEADER_MONTH_BUTTON_SET = 1001;
    private static final int MESSAGE_CALENDAR_HEADER_TEXT_VALUE_SET = 1000;
    private static final int NOT_LEAP_MONTH = 0;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final String TAG = "SeslDatePicker";
    private static final String TAG_CSCFEATURE_CALENDAR_SETCOLOROFDAYS = "CscFeature_Calendar_SetColorOfDays";
    private static final int UAE_MCC = 424;
    private static final String UAE_SALES_CODE = "XSG";
    private static final String UAE_WEEK_DAY_STRING_FEATURE = "XXXXXBR";
    private static final int USE_LOCALE = 0;
    public static final int VIEW_TYPE_CALENDAR = 0;
    public static final int VIEW_TYPE_SPINNER = 1;
    private static PackageManager mPackageManager;
    private final ViewAnimator mAnimator;

    @Nullable
    private final ObjectAnimator mAntiClockwiseAnim;
    protected int mBackgroundBorderlessResId;
    private final View.OnFocusChangeListener mBtnFocusChangeListener;
    private final int mBtnTintColor;
    private final RelativeLayout mCalendarHeader;
    private final View.OnClickListener mCalendarHeaderClickListener;
    private final RelativeLayout mCalendarHeaderLayout;
    protected int mCalendarHeaderLayoutHeight;
    private final View mCalendarHeaderSpinner;
    private final TextView mCalendarHeaderText;
    private final int mCalendarHeaderTextColor;
    private final LinearLayout mCalendarHeaderTextSpinnerLayout;
    private final CalendarPagerAdapter mCalendarPagerAdapter;
    protected int mCalendarViewMargin;
    private final ViewPager mCalendarViewPager;
    protected int mCalendarViewPagerHeight;
    protected int mCalendarViewPagerWidth;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;

    @Nullable
    private final ObjectAnimator mClockwiseAnim;
    private FrameLayout mContentFrame;
    private final Context mContext;
    protected Calendar mCurrentDate;
    private Locale mCurrentLocale;
    protected int mCurrentPosition;
    protected int mCurrentViewType;
    private RelativeLayout mCustomButtonLayout;
    private View mCustomButtonView;
    protected int mDatePickerHeight;
    private final LinearLayout mDatePickerLayout;

    @Nullable
    private DateValidator mDateValidator;
    private SimpleDateFormat mDayFormatter;
    private final LinearLayout mDayOfTheWeekLayout;
    protected int mDayOfTheWeekLayoutHeight;
    protected int mDayOfTheWeekLayoutWidth;
    private final DayOfTheWeekView mDayOfTheWeekView;
    protected int mDayOfWeekStart;
    private int mDialogPaddingVertical;
    private Window mDialogWindow;
    protected Calendar mEndDate;
    private final View mFirstBlankSpace;
    protected int mFirstBlankSpaceHeight;
    protected int mFirstDayOfWeek;
    private final Handler mHandler;
    private boolean mIsCalendarViewDisabled;
    private boolean mIsCalledFromDeactivatedDayClick;
    private boolean mIsConfigurationChanged;
    protected boolean mIsCustomButtonSeparate;
    private boolean mIsEnabled;
    private boolean mIsFarsiLanguage;
    private boolean mIsFirstMeasure;
    protected boolean mIsFromSetLunar;
    private final boolean mIsInDialog;
    protected int mIsLeapEndMonth;
    protected boolean mIsLeapMonth;
    protected int mIsLeapStartMonth;
    protected boolean mIsLunar;
    protected boolean mIsLunarSupported;
    private boolean mIsRTL;
    private boolean mIsSimplifiedChinese;
    private boolean mIsSpinnerViewDisabled;
    private boolean mIsWeekRangeSet;
    protected boolean mLunarChanged;
    protected int mLunarCurrentDay;
    protected int mLunarCurrentMonth;
    protected int mLunarCurrentYear;
    protected int mLunarEndDay;
    protected int mLunarEndMonth;
    protected int mLunarEndYear;
    protected int mLunarStartDay;
    protected int mLunarStartMonth;
    protected int mLunarStartYear;
    protected Calendar mMaxDate;
    private int mMeasureSpecHeight;
    protected Calendar mMinDate;
    protected int mMode;
    private final View.OnKeyListener mMonthBtnKeyListener;
    private final View.OnTouchListener mMonthBtnTouchListener;
    protected String mMonthViewColor;
    private final ImageButton mNextButton;
    protected int mNumDays;
    protected int mOldCalendarViewPagerWidth;
    protected int mOldSelectedDay;
    private OnDateChangedListener mOnDateChangedListener;
    private OnViewTypeChangedListener mOnViewTypeChangedListener;
    protected int mPadding;
    PathClassLoader mPathClassLoader;
    protected int mPositionCount;
    private final ImageButton mPrevButton;
    private final View mSecondBlankSpace;
    protected int mSecondBlankSpaceHeight;
    private Object mSolarLunarConverter;
    private Object mSolarLunarTables;
    private final SeslDatePickerSpinnerLayout mSpinnerLayout;
    protected Calendar mStartDate;
    protected final Calendar mTempDate;
    protected final Calendar mTempMinMaxDate;
    protected int[] mTotalMonthCountWithLeap;
    private ValidationCallback mValidationCallback;
    protected int mWeekStart;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CalendarPagerAdapter extends PagerAdapter {
        final SparseArray<SeslSimpleMonthView> views = new SparseArray<>();

        public CalendarPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i, @NonNull Object obj) {
            SeslDatePicker.this.debugLog("destroyItem : " + i);
            ((ViewPager) view).removeView((View) obj);
            this.views.remove(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull View view) {
            SeslDatePicker.this.debugLog("finishUpdate");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            int maxYear = SeslDatePicker.this.getMaxYear() - SeslDatePicker.this.getMinYear();
            SeslDatePicker seslDatePicker = SeslDatePicker.this;
            seslDatePicker.mPositionCount = (maxYear * 12) + (seslDatePicker.getMaxMonth() - SeslDatePicker.this.getMinMonth()) + 1;
            SeslDatePicker seslDatePicker2 = SeslDatePicker.this;
            if (seslDatePicker2.mIsLunar) {
                seslDatePicker2.mPositionCount = seslDatePicker2.getTotalMonthCountWithLeap(seslDatePicker2.getMaxYear());
            }
            return SeslDatePicker.this.mPositionCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull View view, int i) {
            boolean z;
            SeslSimpleMonthView seslSimpleMonthView = new SeslSimpleMonthView(SeslDatePicker.this.mContext);
            SeslDatePicker.this.debugLog("instantiateItem : " + i);
            seslSimpleMonthView.setClickable(true);
            seslSimpleMonthView.setOnDayClickListener(SeslDatePicker.this);
            seslSimpleMonthView.setOnDeactivatedDayClickListener(SeslDatePicker.this);
            seslSimpleMonthView.setTextColor(SeslDatePicker.this.mMonthViewColor);
            int minMonth = SeslDatePicker.this.getMinMonth() + i;
            int minYear = SeslDatePicker.this.getMinYear() + (minMonth / 12);
            int i2 = minMonth % 12;
            SeslDatePicker seslDatePicker = SeslDatePicker.this;
            if (seslDatePicker.mIsLunar) {
                LunarDate lunarDateByPosition = seslDatePicker.getLunarDateByPosition(i);
                minYear = lunarDateByPosition.year;
                int i4 = lunarDateByPosition.month;
                z = lunarDateByPosition.isLeapMonth;
                i2 = i4;
            } else {
                z = false;
            }
            int i5 = -1;
            int i6 = (SeslDatePicker.this.mCurrentDate.get(1) == minYear && SeslDatePicker.this.mCurrentDate.get(2) == i2) ? SeslDatePicker.this.mCurrentDate.get(5) : -1;
            SeslDatePicker seslDatePicker2 = SeslDatePicker.this;
            boolean z2 = seslDatePicker2.mIsLunar;
            if (!z2) {
                i5 = i6;
            } else if (seslDatePicker2.mLunarCurrentYear == minYear && seslDatePicker2.mLunarCurrentMonth == i2) {
                i5 = seslDatePicker2.mLunarCurrentDay;
            }
            if (seslDatePicker2.mIsLunarSupported) {
                seslSimpleMonthView.setLunar(z2, z, seslDatePicker2.mPathClassLoader);
            }
            int i7 = SeslDatePicker.this.mStartDate.get(1);
            int i8 = SeslDatePicker.this.mStartDate.get(2);
            int i9 = SeslDatePicker.this.mStartDate.get(5);
            int i10 = SeslDatePicker.this.mEndDate.get(1);
            int i11 = SeslDatePicker.this.mEndDate.get(2);
            int i12 = SeslDatePicker.this.mEndDate.get(5);
            SeslDatePicker seslDatePicker3 = SeslDatePicker.this;
            if (seslDatePicker3.mIsLunar) {
                i7 = seslDatePicker3.mLunarStartYear;
                i8 = seslDatePicker3.mLunarStartMonth;
                i9 = seslDatePicker3.mLunarStartDay;
                i10 = seslDatePicker3.mLunarEndYear;
                i11 = seslDatePicker3.mLunarEndMonth;
                i12 = seslDatePicker3.mLunarEndDay;
            }
            int i13 = i11;
            int i14 = i10;
            int i15 = i7;
            int i16 = i9;
            int i17 = i8;
            int firstDayOfWeek = seslDatePicker3.getFirstDayOfWeek();
            SeslDatePicker seslDatePicker4 = SeslDatePicker.this;
            seslSimpleMonthView.setMonthParams(i5, i2, minYear, firstDayOfWeek, 1, 31, seslDatePicker4.mMinDate, seslDatePicker4.mMaxDate, i15, i17, i16, seslDatePicker4.mIsLeapStartMonth, i14, i13, i12, seslDatePicker4.mIsLeapEndMonth, seslDatePicker4.mMode);
            if (i == 0) {
                seslSimpleMonthView.setFirstMonth();
            }
            if (i == SeslDatePicker.this.mPositionCount - 1) {
                seslSimpleMonthView.setLastMonth();
            }
            SeslDatePicker seslDatePicker5 = SeslDatePicker.this;
            if (seslDatePicker5.mIsLunar) {
                if (i != 0 && seslDatePicker5.getLunarDateByPosition(i - 1).isLeapMonth) {
                    seslSimpleMonthView.setPrevMonthLeap();
                }
                SeslDatePicker seslDatePicker6 = SeslDatePicker.this;
                if (i != seslDatePicker6.mPositionCount - 1 && seslDatePicker6.getLunarDateByPosition(i + 1).isLeapMonth) {
                    seslSimpleMonthView.setNextMonthLeap();
                }
            }
            if (SeslDatePicker.this.mDateValidator != null) {
                SeslDatePicker.this.manageCalendarHeaderLayoutClick(true);
                seslSimpleMonthView.setDisableDates(SeslDatePicker.this.mDateValidator);
            }
            SeslDatePicker.this.mNumDays = seslSimpleMonthView.getNumDays();
            SeslDatePicker.this.mWeekStart = seslSimpleMonthView.getWeekStart();
            ((ViewPager) view).addView(seslSimpleMonthView, 0);
            this.views.put(i, seslSimpleMonthView);
            return seslSimpleMonthView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view != null && view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Parcelable saveState() {
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull View view) {
            SeslDatePicker.this.debugLog("startUpdate");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        private boolean mIncrement;

        private ChangeCurrentByOneFromLongPressCommand() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStep(boolean z) {
            this.mIncrement = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mIncrement) {
                SeslDatePicker.this.mCalendarViewPager.setCurrentItem(SeslDatePicker.this.mCurrentPosition + 1);
            } else {
                SeslDatePicker.this.mCalendarViewPager.setCurrentItem(SeslDatePicker.this.mCurrentPosition - 1);
            }
            SeslDatePicker.this.postDelayed(this, 300L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DateMode {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DateValidator {
        boolean isValid(Date date);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DayOfTheWeekView extends View {
        private static final float DAY_OF_WEEK_ALPHA = 0.8f;
        private static final int FONT_WEIGHT_REGULAR = 400;
        private final int[] mDayColorSet;
        private final Calendar mDayLabelCalendar;
        private final String mDefaultWeekdayFeatureString;
        private final Paint mMonthDayLabelPaint;
        private final int mNormalDayTextColor;
        private final int mSaturdayTextColor;
        private final int mSundayTextColor;
        private final String mWeekdayFeatureString;

        public DayOfTheWeekView(Context context, TypedArray typedArray) {
            super(context);
            this.mDayColorSet = new int[7];
            this.mDefaultWeekdayFeatureString = "XXXXXXR";
            this.mDayLabelCalendar = Calendar.getInstance();
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C3623R.dimen.sesl_date_picker_month_day_label_text_size);
            int color = typedArray.getColor(C3623R.styleable.DatePicker_dayTextColor, resources.getColor(C3623R.color.sesl_date_picker_normal_text_color_light));
            this.mNormalDayTextColor = color;
            this.mSundayTextColor = typedArray.getColor(C3623R.styleable.DatePicker_sundayTextColor, resources.getColor(C3623R.color.sesl_date_picker_sunday_text_color_light));
            this.mSaturdayTextColor = ResourcesCompat.getColor(resources, C3623R.color.sesl_date_picker_saturday_week_text_color_light, null);
            String str = SeslDatePicker.this.mMonthViewColor;
            if (str != null) {
                this.mWeekdayFeatureString = str;
            } else {
                this.mWeekdayFeatureString = SeslCscFeatureReflector.getString(SeslDatePicker.TAG_CSCFEATURE_CALENDAR_SETCOLOROFDAYS, "XXXXXXR");
            }
            Paint paint = new Paint();
            this.mMonthDayLabelPaint = paint;
            paint.setAntiAlias(true);
            paint.setColor(color);
            paint.setTextSize(dimensionPixelSize);
            if (Build.VERSION.SDK_INT >= 33) {
                paint.setTypeface(Typeface.create(Typeface.create("sec", 0), 400, false));
            } else {
                paint.setTypeface(Typeface.create("sec-roboto-light", 0));
            }
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setStyle(Paint.Style.FILL);
            paint.setFakeBoldText(false);
        }

        @Override // android.view.View
        public void onDraw(@NonNull Canvas canvas) {
            int i;
            int i2;
            super.onDraw(canvas);
            SeslDatePicker seslDatePicker = SeslDatePicker.this;
            int i4 = seslDatePicker.mNumDays;
            if (i4 == 0) {
                return;
            }
            int i5 = (seslDatePicker.mDayOfTheWeekLayoutHeight * 2) / 3;
            int i6 = seslDatePicker.mDayOfTheWeekLayoutWidth / (i4 * 2);
            int i7 = 0;
            for (int i8 = 0; i8 < SeslDatePicker.this.mNumDays; i8++) {
                char cCharAt = this.mWeekdayFeatureString.charAt(i8);
                this.mDayColorSet[(i8 + 2) % SeslDatePicker.this.mNumDays] = cCharAt != 'B' ? cCharAt != 'R' ? ColorUtils.setAlphaComponent(this.mNormalDayTextColor, 204) : ColorUtils.setAlphaComponent(this.mSundayTextColor, 255) : ColorUtils.setAlphaComponent(this.mSaturdayTextColor, 255);
            }
            while (true) {
                SeslDatePicker seslDatePicker2 = SeslDatePicker.this;
                int i9 = seslDatePicker2.mNumDays;
                if (i7 >= i9) {
                    return;
                }
                int i10 = (seslDatePicker2.mWeekStart + i7) % i9;
                this.mDayLabelCalendar.set(7, i10);
                String upperCase = SeslDatePicker.this.mDayFormatter.format(this.mDayLabelCalendar.getTime()).toUpperCase();
                if (SeslDatePicker.this.mIsRTL) {
                    i2 = ((((r5.mNumDays - 1) - i7) * 2) + 1) * i6;
                    i = SeslDatePicker.this.mPadding;
                } else {
                    i = ((i7 * 2) + 1) * i6;
                    i2 = SeslDatePicker.this.mPadding;
                }
                this.mMonthDayLabelPaint.setColor(this.mDayColorSet[i10]);
                canvas.drawText(upperCase, i2 + i, i5, this.mMonthDayLabelPaint);
                i7++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LunarUtils {
        private static PathClassLoader mClassLoader;

        private LunarUtils() {
        }

        public static PathClassLoader getPathClassLoader(Context context) {
            if (mClassLoader == null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(SeslDatePicker.getCalendarPackageName(), 128);
                    if (applicationInfo == null) {
                        Log.e(SeslDatePicker.TAG, "getPathClassLoader, appInfo is null");
                        return null;
                    }
                    String str = applicationInfo.sourceDir;
                    if (str == null || TextUtils.isEmpty(str)) {
                        Log.e(SeslDatePicker.TAG, "getPathClassLoader, calendar package source directory is null or empty");
                        return null;
                    }
                    mClassLoader = new PathClassLoader(str, ClassLoader.getSystemClassLoader());
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e(SeslDatePicker.TAG, "getPathClassLoader, calendar package name not found");
                    return null;
                }
            }
            return mClassLoader;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDateChangedListener {
        void onDateChanged(SeslDatePicker seslDatePicker, int i, int i2, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnEditTextModeChangedListener {
        void onEditTextModeChanged(SeslDatePicker seslDatePicker, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnViewTypeChangedListener {
        void onViewTypeChanged(SeslDatePicker seslDatePicker);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface ValidationCallback {
        void onValidationChanged(boolean z);
    }

    public SeslDatePicker(@NonNull Context context) {
        this(context, null);
    }

    private void addCustomButtonInHeader() {
        if (this.mCustomButtonView == null) {
            return;
        }
        removeCustomViewFromParent();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCalendarHeader.getLayoutParams();
        layoutParams.addRule(16, this.mCustomButtonView.getId());
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_lunar_calendar_header_margin);
        ((RelativeLayout.LayoutParams) this.mPrevButton.getLayoutParams()).leftMargin = 0;
        ((RelativeLayout.LayoutParams) this.mNextButton.getLayoutParams()).rightMargin = 0;
        this.mCalendarHeaderLayout.addView(this.mCustomButtonView);
    }

    private void addCustomButtonSeparateLayout() {
        if (this.mCustomButtonView == null) {
            return;
        }
        RelativeLayout relativeLayout = this.mCustomButtonLayout;
        if (relativeLayout == null) {
            this.mCustomButtonLayout = new RelativeLayout(this.mContext);
            this.mCustomButtonLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mCalendarHeaderLayoutHeight));
        } else {
            ((LinearLayout.LayoutParams) relativeLayout.getLayoutParams()).height = this.mCalendarHeaderLayoutHeight;
        }
        removeCustomViewFromParent();
        this.mCustomButtonLayout.addView(this.mCustomButtonView);
        this.mDatePickerLayout.addView(this.mCustomButtonLayout, 0);
        this.mDatePickerHeight += this.mCalendarHeaderLayoutHeight;
    }

    private void calculateContentHeight() {
        Window window;
        if (getLayoutParams().height == -2 || getMeasuredHeight() <= this.mDatePickerHeight) {
            if (this.mContentFrame == null && (window = this.mDialogWindow) != null) {
                this.mContentFrame = (FrameLayout) window.findViewById(C0419R.id.customPanel);
            }
            int measuredHeight = this.mMeasureSpecHeight;
            FrameLayout frameLayout = this.mContentFrame;
            if (frameLayout != null) {
                measuredHeight = frameLayout.getMeasuredHeight();
                if (this.mDialogWindow != null) {
                    measuredHeight -= this.mDialogPaddingVertical;
                }
            }
            if (isEditTextMode()) {
                return;
            }
            updateViewType(measuredHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCalendar(Calendar calendar, int i, int i2, int i4) {
        calendar.clear();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i4);
    }

    private Calendar convertLunarToSolar(Calendar calendar, int i, int i2, int i4) {
        Calendar calendar2 = (Calendar) calendar.clone();
        SeslSolarLunarConverterReflector.convertLunarToSolar(this.mPathClassLoader, this.mSolarLunarConverter, i, i2, i4, this.mIsLeapMonth);
        calendar2.set(SeslSolarLunarConverterReflector.getYear(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getMonth(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getDay(this.mPathClassLoader, this.mSolarLunarConverter));
        return calendar2;
    }

    private Calendar convertSolarToLunar(Calendar calendar, LunarDate lunarDate) {
        Calendar calendar2 = (Calendar) calendar.clone();
        SeslSolarLunarConverterReflector.convertSolarToLunar(this.mPathClassLoader, this.mSolarLunarConverter, calendar.get(1), calendar.get(2), calendar.get(5));
        calendar2.set(SeslSolarLunarConverterReflector.getYear(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getMonth(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getDay(this.mPathClassLoader, this.mSolarLunarConverter));
        if (lunarDate != null) {
            lunarDate.day = SeslSolarLunarConverterReflector.getDay(this.mPathClassLoader, this.mSolarLunarConverter);
            lunarDate.month = SeslSolarLunarConverterReflector.getMonth(this.mPathClassLoader, this.mSolarLunarConverter);
            lunarDate.year = SeslSolarLunarConverterReflector.getYear(this.mPathClassLoader, this.mSolarLunarConverter);
            lunarDate.isLeapMonth = SeslSolarLunarConverterReflector.isLeapMonth(this.mPathClassLoader, this.mSolarLunarConverter);
        }
        return calendar2;
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
    public static String getCalendarPackageName() {
        String string = SeslFloatingFeatureReflector.getString("SEC_FLOATING_FEATURE_CALENDAR_CONFIG_PACKAGE_NAME", "com.android.calendar");
        if ("com.android.calendar".equals(string)) {
            return string;
        }
        try {
            mPackageManager.getPackageInfo(string, 0);
            return string;
        } catch (PackageManager.NameNotFoundException unused) {
            return "com.android.calendar";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDayOffset() {
        SeslSimpleMonthView seslSimpleMonthView = this.mCalendarPagerAdapter.views.get(this.mCurrentPosition);
        this.mDayOfWeekStart = seslSimpleMonthView == null ? 1 : seslSimpleMonthView.getDayOfWeekStart();
        int i = (((this.mCurrentDate.get(5) % 7) + this.mDayOfWeekStart) - 1) % 7;
        if (i == 0) {
            return 7;
        }
        return i;
    }

    private String getFormattedCurrentDate() {
        return DateUtils.formatDateTime(this.mContext, this.mCurrentDate.getTimeInMillis(), 20);
    }

    private int getIndexOfleapMonthOfYear(int i) {
        Object obj = this.mSolarLunarTables;
        if (obj == null) {
            return 127;
        }
        int field_START_OF_LUNAR_YEAR = SeslSolarLunarTablesReflector.getField_START_OF_LUNAR_YEAR(this.mPathClassLoader, obj);
        int field_WIDTH_PER_YEAR = SeslSolarLunarTablesReflector.getField_WIDTH_PER_YEAR(this.mPathClassLoader, this.mSolarLunarTables);
        return SeslSolarLunarTablesReflector.getLunar(this.mPathClassLoader, this.mSolarLunarTables, ((i - field_START_OF_LUNAR_YEAR) * field_WIDTH_PER_YEAR) + SeslSolarLunarTablesReflector.getField_INDEX_OF_LEAP_MONTH(this.mPathClassLoader, this.mSolarLunarTables));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public LunarDate getLunarDateByPosition(int i) {
        int i2;
        boolean z;
        LunarDate lunarDate = new LunarDate();
        int minYear = getMinYear();
        int minYear2 = getMinYear();
        while (true) {
            i2 = 0;
            if (minYear2 > getMaxYear()) {
                z = 0;
                break;
            }
            if (i < getTotalMonthCountWithLeap(minYear2)) {
                int totalMonthCountWithLeap = i - (minYear2 == getMinYear() ? -getMinMonth() : getTotalMonthCountWithLeap(minYear2 - 1));
                int indexOfleapMonthOfYear = getIndexOfleapMonthOfYear(minYear2);
                char c = indexOfleapMonthOfYear <= 12 ? '\r' : '\f';
                int i4 = totalMonthCountWithLeap < indexOfleapMonthOfYear ? totalMonthCountWithLeap : totalMonthCountWithLeap - 1;
                if (c == '\r' && indexOfleapMonthOfYear == totalMonthCountWithLeap) {
                    i2 = 1;
                }
                minYear = minYear2;
                z = i2;
                i2 = i4;
            } else {
                minYear2++;
            }
        }
        lunarDate.set(minYear, i2, 1, z);
        return lunarDate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMonthAndYearString(Calendar calendar) {
        if (this.mIsFarsiLanguage) {
            return new SimpleDateFormat("LLLL y", this.mCurrentLocale).format(calendar.getTime());
        }
        int i = this.mContext.getResources().getConfiguration().screenWidthDp;
        StringBuilder sb = new StringBuilder(50);
        Formatter formatter = new Formatter(sb, this.mCurrentLocale);
        sb.setLength(0);
        long timeInMillis = calendar.getTimeInMillis();
        return i <= 250 ? DateUtils.formatDateRange(getContext(), formatter, timeInMillis, timeInMillis, 65572, Time.getCurrentTimezone()).toString().toUpperCase() : DateUtils.formatDateRange(getContext(), formatter, timeInMillis, timeInMillis, 36, Time.getCurrentTimezone()).toString();
    }

    private String getMonthViewColorStringForSpecific() {
        String simOperator;
        try {
            if ("wifi-only".equalsIgnoreCase(SeslSystemPropertiesReflector.getStringProperties("ro.carrier"))) {
                String stringProperties = SeslSystemPropertiesReflector.getStringProperties("persist.sys.selected_country_iso");
                if (TextUtils.isEmpty(stringProperties)) {
                    stringProperties = SeslSystemPropertiesReflector.getStringProperties("ro.csc.countryiso_code");
                }
                if ("AE".equals(stringProperties)) {
                    return UAE_WEEK_DAY_STRING_FEATURE;
                }
            } else if (UAE_SALES_CODE.equals(SeslSystemPropertiesReflector.getSalesCode()) && (simOperator = ((TelephonyManager) this.mContext.getSystemService("phone")).getSimOperator()) != null && simOperator.length() > 3 && Integer.parseInt(simOperator.substring(0, 3)) == 424) {
                return UAE_WEEK_DAY_STRING_FEATURE;
            }
            return null;
        } catch (NoClassDefFoundError e) {
            Log.e(TAG, "msg : " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTotalMonthCountWithLeap(int i) {
        if (this.mTotalMonthCountWithLeap == null || i < getMinYear()) {
            return 0;
        }
        return this.mTotalMonthCountWithLeap[i - getMinYear()];
    }

    private boolean isFarsiLanguage() {
        return MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(this.mCurrentLocale.getLanguage());
    }

    private boolean isRTL() {
        if ("ur".equals(this.mCurrentLocale.getLanguage())) {
            return false;
        }
        Locale locale = this.mCurrentLocale;
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return directionality == 1 || directionality == 2;
    }

    private boolean isSimplifiedChinese() {
        String language = this.mCurrentLocale.getLanguage();
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        return language.equals(locale.getLanguage()) && this.mCurrentLocale.getCountry().equals(locale.getCountry());
    }

    private boolean isSystemAnimationsRemoved() {
        return Settings.Global.getFloat(this.mContext.getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f;
    }

    private int makeMeasureSpec(int i, int i2) {
        int size;
        if (i2 == -1) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = getResources().getConfiguration().smallestScreenWidthDp;
            size = i4 >= 600 ? getResources().getDimensionPixelSize(C3623R.dimen.sesl_date_picker_dialog_min_width) : (int) (TypedValue.applyDimension(1, i4, getResources().getDisplayMetrics()) + 0.5f);
        } else {
            size = View.MeasureSpec.getSize(i);
        }
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.mCalendarViewMargin;
            this.mCalendarViewPagerWidth = size - (i5 * 2);
            this.mDayOfTheWeekLayoutWidth = size - (i5 * 2);
            return View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (mode != 1073741824) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(mode, "Unknown measure mode: "));
        }
        int i6 = this.mCalendarViewMargin;
        this.mCalendarViewPagerWidth = size - (i6 * 2);
        this.mDayOfTheWeekLayoutWidth = size - (i6 * 2);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageCalendarHeaderLayoutClick(boolean z) {
        if (z) {
            this.mCalendarHeaderTextSpinnerLayout.setOnClickListener(null);
            this.mCalendarHeaderTextSpinnerLayout.setClickable(false);
            setCalendarHeaderPadding(false);
            this.mCalendarHeaderSpinner.setVisibility(8);
            return;
        }
        if (this.mCalendarHeaderTextSpinnerLayout.hasOnClickListeners()) {
            return;
        }
        this.mCalendarHeaderTextSpinnerLayout.setOnClickListener(this.mCalendarHeaderClickListener);
        this.mCalendarHeaderTextSpinnerLayout.setClickable(true);
        setCalendarHeaderPadding(true);
        this.mCalendarHeaderSpinner.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDateChanged() {
        if (this.mOnDateChangedListener != null) {
            int i = this.mCurrentDate.get(1);
            int i2 = this.mCurrentDate.get(2);
            int i4 = this.mCurrentDate.get(5);
            if (this.mIsLunar) {
                i = this.mLunarCurrentYear;
                i2 = this.mLunarCurrentMonth;
                i4 = this.mLunarCurrentDay;
            }
            this.mOnDateChangedListener.onDateChanged(this, i, i2, i4);
        }
    }

    private void postChangeCurrentByOneFromLongPress(boolean z, long j) {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand == null) {
            this.mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } else {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.mChangeCurrentByOneFromLongPressCommand.setStep(z);
        postDelayed(this.mChangeCurrentByOneFromLongPressCommand, j);
    }

    private void removeCustomButtonInHeader() {
        Resources resources = this.mContext.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCalendarHeader.getLayoutParams();
        layoutParams.removeRule(16);
        layoutParams.leftMargin = 0;
        ((RelativeLayout.LayoutParams) this.mPrevButton.getLayoutParams()).leftMargin = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_margin);
        ((RelativeLayout.LayoutParams) this.mNextButton.getLayoutParams()).rightMargin = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_margin);
        removeCustomViewFromParent();
    }

    private void removeCustomButtonSeparateLayout() {
        removeCustomViewFromParent();
        this.mDatePickerLayout.removeView(this.mCustomButtonLayout);
        this.mDatePickerHeight -= this.mCalendarHeaderLayoutHeight;
    }

    private void removeCustomViewFromParent() {
        View view = this.mCustomButtonView;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mCustomButtonView);
        }
    }

    private static Activity scanForActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private void setCalendarHeaderPadding(boolean z) {
        if (z) {
            this.mCalendarHeaderTextSpinnerLayout.setPadding(this.mContext.getResources().getDimensionPixelSize(C3623R.dimen.sesl_date_picker_calendar_header_layout_padding_left), getPaddingTop(), this.mContext.getResources().getDimensionPixelSize(C3623R.dimen.sesl_date_picker_calendar_header_layout_padding_right), getPaddingBottom());
        } else {
            this.mCalendarHeaderTextSpinnerLayout.setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextButtonProperties(float f, boolean z) {
        this.mNextButton.setImageAlpha((int) (f * 255.0f));
        if (z) {
            this.mNextButton.setBackgroundResource(this.mBackgroundBorderlessResId);
            this.mNextButton.setEnabled(true);
            this.mNextButton.setFocusable(true);
        } else {
            this.mNextButton.setBackground(null);
            this.mNextButton.setEnabled(false);
            this.mNextButton.setFocusable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrevButtonProperties(float f, boolean z) {
        this.mPrevButton.setImageAlpha((int) (f * 255.0f));
        if (z) {
            this.mPrevButton.setBackgroundResource(this.mBackgroundBorderlessResId);
            this.mPrevButton.setEnabled(true);
            this.mPrevButton.setFocusable(true);
        } else {
            this.mPrevButton.setBackground(null);
            this.mPrevButton.setEnabled(false);
            this.mPrevButton.setFocusable(false);
        }
    }

    private void setTotalMonthCountWithLeap() {
        int i;
        if (this.mSolarLunarTables == null || this.mPathClassLoader == null) {
            return;
        }
        this.mTotalMonthCountWithLeap = new int[(getMaxYear() - getMinYear()) + 1];
        int i2 = 0;
        for (int minYear = getMinYear(); minYear <= getMaxYear(); minYear++) {
            if (minYear == getMinYear()) {
                int minMonth = getMinMonth() + 1;
                int indexOfleapMonthOfYear = getIndexOfleapMonthOfYear(minYear);
                i = (indexOfleapMonthOfYear > 12 || indexOfleapMonthOfYear < minMonth) ? 13 - minMonth : 14 - minMonth;
            } else if (minYear == getMaxYear()) {
                int maxMonth = getMaxMonth();
                int i4 = maxMonth + 1;
                int indexOfleapMonthOfYear2 = getIndexOfleapMonthOfYear(minYear);
                i = (indexOfleapMonthOfYear2 > 12 || i4 < indexOfleapMonthOfYear2) ? i4 : maxMonth + 2;
            } else {
                i = getIndexOfleapMonthOfYear(minYear) <= 12 ? 13 : 12;
            }
            i2 += i;
            this.mTotalMonthCountWithLeap[minYear - getMinYear()] = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCalendarHeaderSpinnerAnimation() {
        if (this.mCurrentViewType == 0) {
            if (this.mAntiClockwiseAnim.isRunning()) {
                this.mAntiClockwiseAnim.cancel();
            }
            this.mClockwiseAnim.start();
        } else {
            if (this.mClockwiseAnim.isRunning()) {
                this.mClockwiseAnim.cancel();
            }
            this.mAntiClockwiseAnim.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSimpleMonthView(boolean z) {
        int i = this.mCurrentDate.get(2);
        int i2 = this.mCurrentDate.get(1);
        if (this.mIsLunar) {
            i2 = this.mLunarCurrentYear;
            i = this.mLunarCurrentMonth;
        }
        if (this.mLunarChanged) {
            i = this.mTempDate.get(2);
            i2 = this.mTempDate.get(1);
        }
        int minMonth = (i - getMinMonth()) + ((i2 - getMinYear()) * 12);
        if (this.mIsLunar) {
            minMonth = (i2 == getMinYear() ? -getMinMonth() : getTotalMonthCountWithLeap(i2 - 1)) + (i < getIndexOfleapMonthOfYear(i2) ? i : i + 1);
            int i4 = this.mMode;
            if (((i4 == 1 || i4 == 3) && i == this.mLunarStartMonth && this.mIsLeapStartMonth == 1) || (((i4 == 2 || i4 == 3) && i == this.mLunarEndMonth && this.mIsLeapEndMonth == 1) || (i4 == 0 && this.mIsLeapMonth))) {
                minMonth++;
            }
        }
        this.mCurrentPosition = minMonth;
        if (isSystemAnimationsRemoved()) {
            this.mCalendarViewPager.setCurrentItem(minMonth, false);
        } else {
            this.mCalendarViewPager.setCurrentItem(minMonth, z);
        }
        Message messageObtainMessage = this.mHandler.obtainMessage();
        messageObtainMessage.what = 1000;
        messageObtainMessage.obj = Boolean.TRUE;
        this.mHandler.sendMessage(messageObtainMessage);
        Message messageObtainMessage2 = this.mHandler.obtainMessage();
        messageObtainMessage2.what = 1001;
        this.mHandler.sendMessage(messageObtainMessage2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStartEndDateRange(int i, int i2, int i4, int i5) {
        clearCalendar(this.mStartDate, i2, i4, (i5 - i) + 1);
        int i6 = 7 - i;
        clearCalendar(this.mEndDate, i2, i4, i5 + i6);
        if (this.mIsLunar) {
            Calendar calendarConvertLunarToSolar = convertLunarToSolar(getCalendarForLocale(null, this.mCurrentLocale), i2, i4, i5);
            Calendar calendar = (Calendar) calendarConvertLunarToSolar.clone();
            calendar.add(6, (-i) + 1);
            LunarDate lunarDate = new LunarDate();
            convertSolarToLunar(calendar, lunarDate);
            this.mLunarStartYear = lunarDate.year;
            this.mLunarStartMonth = lunarDate.month;
            this.mLunarStartDay = lunarDate.day;
            this.mIsLeapStartMonth = 0;
            calendarConvertLunarToSolar.add(6, i6);
            convertSolarToLunar(calendarConvertLunarToSolar, lunarDate);
            this.mLunarEndYear = lunarDate.year;
            this.mLunarEndMonth = lunarDate.month;
            this.mLunarEndDay = lunarDate.day;
            this.mIsLeapEndMonth = 0;
        }
    }

    private void updateViewType(int i) {
        Activity activityScanForActivity = scanForActivity(this.mContext);
        boolean z = this.mIsCalendarViewDisabled;
        if (z || this.mIsSpinnerViewDisabled) {
            setCurrentViewType(z ? 1 : 0);
            manageCalendarHeaderLayoutClick(true);
            this.mAnimator.setMeasureAllChildren(false);
        } else {
            if (this.mDateValidator != null) {
                manageCalendarHeaderLayoutClick(true);
                return;
            }
            if (activityScanForActivity == null || !activityScanForActivity.isInMultiWindowMode()) {
                manageCalendarHeaderLayoutClick(false);
            } else if (i >= this.mDatePickerHeight) {
                manageCalendarHeaderLayoutClick(false);
            } else {
                setCurrentViewType(1);
                manageCalendarHeaderLayoutClick(true);
            }
        }
    }

    public void disableCalendarView() {
        this.mIsCalendarViewDisabled = true;
        setCurrentViewType(1);
        manageCalendarHeaderLayoutClick(true);
        this.mAnimator.setMeasureAllChildren(false);
    }

    public void disableSpinnerView() {
        this.mIsSpinnerViewDisabled = true;
        setCurrentViewType(0);
        manageCalendarHeaderLayoutClick(true);
        this.mAnimator.setMeasureAllChildren(false);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(getFormattedCurrentDate());
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getCurrentViewType() {
        return this.mCurrentViewType;
    }

    public int getDateMode() {
        return this.mMode;
    }

    public int getDayOfMonth() {
        return this.mIsLunar ? this.mLunarCurrentDay : this.mCurrentDate.get(5);
    }

    public EditText getEditText(int i) {
        return this.mSpinnerLayout.getEditText(i);
    }

    @NonNull
    public Calendar getEndDate() {
        return this.mEndDate;
    }

    public int getFirstDayOfWeek() {
        int i = this.mFirstDayOfWeek;
        return i != 0 ? i : this.mCurrentDate.getFirstDayOfWeek();
    }

    public int[] getLunarEndDate() {
        return new int[]{this.mLunarEndYear, this.mLunarEndMonth, this.mLunarEndDay, this.mIsLeapEndMonth};
    }

    public int[] getLunarStartDate() {
        return new int[]{this.mLunarStartYear, this.mLunarStartMonth, this.mLunarStartDay, this.mIsLeapStartMonth};
    }

    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMaxDay() {
        return this.mMaxDate.get(5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMaxMonth() {
        return this.mMaxDate.get(2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMaxYear() {
        return this.mMaxDate.get(1);
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinDay() {
        return this.mMinDate.get(5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinMonth() {
        return this.mMinDate.get(2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinYear() {
        return this.mMinDate.get(1);
    }

    public int getMonth() {
        return this.mIsLunar ? this.mLunarCurrentMonth : this.mCurrentDate.get(2);
    }

    public SeslNumberPicker getNumberPicker(int i) {
        return this.mSpinnerLayout.getNumberPicker(i);
    }

    @NonNull
    public Calendar getStartDate() {
        return this.mStartDate;
    }

    public int getYear() {
        return this.mIsLunar ? this.mLunarCurrentYear : this.mCurrentDate.get(1);
    }

    public void init(int i, int i2, int i4, OnDateChangedListener onDateChangedListener) {
        this.mCurrentDate.set(1, i);
        this.mCurrentDate.set(2, i2);
        this.mCurrentDate.set(5, i4);
        if (this.mIsLunar) {
            this.mLunarCurrentYear = i;
            this.mLunarCurrentMonth = i2;
            this.mLunarCurrentDay = i4;
        }
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate = getCalendarForLocale(this.mMinDate, this.mCurrentLocale);
        }
        if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate = getCalendarForLocale(this.mMaxDate, this.mCurrentLocale);
        }
        this.mOnDateChangedListener = onDateChangedListener;
        updateSimpleMonthView(true);
        onDateChanged();
        this.mSpinnerLayout.setMinDate(this.mMinDate.getTimeInMillis());
        this.mSpinnerLayout.setMaxDate(this.mMaxDate.getTimeInMillis());
        if (this.mCurrentViewType == 0) {
            this.mSpinnerLayout.setVisibility(4);
            this.mSpinnerLayout.setEnabled(false);
        }
        clearCalendar(this.mStartDate, i, i2, i4);
        clearCalendar(this.mEndDate, i, i2, i4);
        if (this.mIsLunar) {
            this.mLunarStartYear = i;
            this.mLunarStartMonth = i2;
            this.mLunarStartDay = i4;
            this.mLunarEndYear = i;
            this.mLunarEndMonth = i2;
            this.mLunarEndDay = i4;
        }
    }

    public boolean isEditTextMode() {
        return this.mCurrentViewType != 0 && this.mSpinnerLayout.isEditTextMode();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isLeapMonth() {
        return this.mIsLeapMonth;
    }

    public boolean isLunar() {
        return this.mIsLunar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C3623R.id.sesl_date_picker_calendar_header_prev_button) {
            if (this.mIsRTL) {
                if (this.mCurrentPosition == this.mPositionCount - 1) {
                    return;
                }
                if (isSystemAnimationsRemoved()) {
                    this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition + 1, false);
                    return;
                } else {
                    this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition + 1);
                    return;
                }
            }
            if (this.mCurrentPosition == 0) {
                return;
            }
            if (isSystemAnimationsRemoved()) {
                this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition - 1, false);
                return;
            } else {
                this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition - 1);
                return;
            }
        }
        if (id == C3623R.id.sesl_date_picker_calendar_header_next_button) {
            if (this.mIsRTL) {
                if (this.mCurrentPosition == 0) {
                    return;
                }
                if (isSystemAnimationsRemoved()) {
                    this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition - 1, false);
                    return;
                } else {
                    this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition - 1);
                    return;
                }
            }
            if (this.mCurrentPosition == this.mPositionCount - 1) {
                return;
            }
            if (isSystemAnimationsRemoved()) {
                this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition + 1, false);
            } else {
                this.mCalendarViewPager.setCurrentItem(this.mCurrentPosition + 1);
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mIsRTL = isRTL();
        this.mIsFarsiLanguage = isFarsiLanguage();
        Locale locale = configuration.getLocales().get(0);
        if (!this.mCurrentLocale.equals(locale)) {
            this.mCurrentLocale = locale;
            boolean zIsSimplifiedChinese = isSimplifiedChinese();
            this.mIsSimplifiedChinese = zIsSimplifiedChinese;
            if (zIsSimplifiedChinese) {
                this.mDayFormatter = new SimpleDateFormat("EEEEE", locale);
            } else {
                this.mDayFormatter = new SimpleDateFormat("EEE", locale);
            }
        }
        Resources resources = this.mContext.getResources();
        this.mDatePickerLayout.setGravity(1);
        this.mIsFirstMeasure = true;
        this.mCalendarHeaderLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_header_height);
        this.mCalendarViewPagerHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_height);
        this.mDayOfTheWeekLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_day_height);
        this.mFirstBlankSpaceHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_header_and_weekend);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_weekend_and_calender);
        this.mSecondBlankSpaceHeight = dimensionPixelOffset;
        this.mDatePickerHeight = this.mCalendarHeaderLayoutHeight + this.mFirstBlankSpaceHeight + this.mDayOfTheWeekLayoutHeight + dimensionPixelOffset + this.mCalendarViewPagerHeight;
        if (this.mIsRTL) {
            this.mIsConfigurationChanged = true;
        }
    }

    @Override // androidx.picker.widget.SeslSimpleMonthView.OnDayClickListener
    public void onDayClick(SeslSimpleMonthView seslSimpleMonthView, int i, int i2, int i4) {
        debugLog(AbstractC0000a.m11h(i4, "onDayClick day : "));
        if (!this.mIsCalledFromDeactivatedDayClick) {
            this.mDayOfWeekStart = seslSimpleMonthView.getDayOfWeekStart();
        }
        int i5 = this.mCurrentDate.get(1);
        int i6 = this.mCurrentDate.get(2);
        if (this.mIsLunar) {
            i5 = this.mLunarCurrentYear;
            i6 = this.mLunarCurrentMonth;
        }
        onDayOfMonthSelected(i, i2, i4);
        boolean z = this.mCurrentPosition != ((i - getMinYear()) * 12) + (i2 - getMinMonth());
        if (i != i5 || i2 != i6 || i4 != this.mOldSelectedDay || this.mIsLunar || z) {
            this.mOldSelectedDay = i4;
            this.mCalendarPagerAdapter.notifyDataSetChanged();
        }
        int minDay = (getMinMonth() == i2 && getMinYear() == i) ? getMinDay() : 1;
        int maxDay = (getMaxMonth() == i2 && getMaxYear() == i) ? getMaxDay() : 31;
        if (this.mIsLunarSupported) {
            seslSimpleMonthView.setLunar(this.mIsLunar, this.mIsLeapMonth, this.mPathClassLoader);
        }
        int i7 = this.mStartDate.get(1);
        int i8 = this.mStartDate.get(2);
        int i9 = this.mStartDate.get(5);
        int i10 = this.mEndDate.get(1);
        int i11 = this.mEndDate.get(2);
        int i12 = this.mEndDate.get(5);
        if (this.mIsLunar) {
            i7 = this.mLunarStartYear;
            i8 = this.mLunarStartMonth;
            i9 = this.mLunarStartDay;
            i10 = this.mLunarEndYear;
            i11 = this.mLunarEndMonth;
            i12 = this.mLunarEndDay;
        }
        int i13 = i8;
        int i14 = i7;
        int i15 = maxDay;
        seslSimpleMonthView.setMonthParams(i4, i2, i, getFirstDayOfWeek(), minDay, i15, this.mMinDate, this.mMaxDate, i14, i13, i9, this.mIsLeapStartMonth, i10, i11, i12, this.mIsLeapEndMonth, this.mMode);
        seslSimpleMonthView.invalidate();
        this.mIsCalledFromDeactivatedDayClick = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onDayOfMonthSelected(int i, int i2, int i4) {
        this.mCurrentDate.set(1, i);
        this.mCurrentDate.set(2, i2);
        this.mCurrentDate.set(5, i4);
        if (this.mIsLunar) {
            this.mLunarCurrentYear = i;
            this.mLunarCurrentMonth = i2;
            this.mLunarCurrentDay = i4;
        }
        Message messageObtainMessage = this.mHandler.obtainMessage();
        messageObtainMessage.what = 1000;
        this.mHandler.sendMessage(messageObtainMessage);
        int i5 = this.mMode;
        if (i5 == 1) {
            if (this.mStartDate.compareTo(this.mEndDate) == 0 || this.mCurrentDate.compareTo(this.mEndDate) >= 0) {
                clearCalendar(this.mEndDate, i, i2, i4);
            }
            clearCalendar(this.mStartDate, i, i2, i4);
            if (this.mIsLunar) {
                if (this.mStartDate.compareTo(this.mEndDate) == 0 || this.mCurrentDate.compareTo(this.mEndDate) >= 0) {
                    this.mLunarEndYear = i;
                    this.mLunarEndMonth = i2;
                    this.mLunarEndDay = i4;
                    this.mIsLeapEndMonth = this.mIsLeapMonth ? 1 : 0;
                }
                this.mLunarStartYear = i;
                this.mLunarStartMonth = i2;
                this.mLunarStartDay = i4;
                this.mIsLeapStartMonth = this.mIsLeapMonth ? 1 : 0;
            }
        } else if (i5 == 2) {
            if (this.mCurrentDate.compareTo(this.mStartDate) < 0) {
                clearCalendar(this.mStartDate, i, i2, i4);
            }
            clearCalendar(this.mEndDate, i, i2, i4);
            if (this.mIsLunar) {
                if (this.mCurrentDate.compareTo(this.mStartDate) < 0) {
                    this.mLunarStartYear = i;
                    this.mLunarStartMonth = i2;
                    this.mLunarStartDay = i4;
                    this.mIsLeapStartMonth = this.mIsLeapMonth ? 1 : 0;
                }
                this.mLunarEndYear = i;
                this.mLunarEndMonth = i2;
                this.mLunarEndDay = i4;
                this.mIsLeapEndMonth = this.mIsLeapMonth ? 1 : 0;
            }
        } else if (i5 != 3) {
            clearCalendar(this.mStartDate, i, i2, i4);
            clearCalendar(this.mEndDate, i, i2, i4);
            if (this.mIsLunar) {
                this.mLunarStartYear = i;
                this.mLunarStartMonth = i2;
                this.mLunarStartDay = i4;
                boolean z = this.mIsLeapMonth;
                this.mIsLeapStartMonth = z ? 1 : 0;
                this.mLunarEndYear = i;
                this.mLunarEndMonth = i2;
                this.mLunarEndDay = i4;
                this.mIsLeapEndMonth = z ? 1 : 0;
            }
        } else {
            this.mIsWeekRangeSet = true;
            int i6 = (((i4 % 7) + this.mDayOfWeekStart) - 1) % 7;
            updateStartEndDateRange(i6 != 0 ? i6 : 7, i, i2, i4);
        }
        if (this.mMode != 0) {
            onValidationChanged(!this.mStartDate.after(this.mEndDate));
        }
        onDateChanged();
    }

    @Override // androidx.picker.widget.SeslSimpleMonthView.OnDeactivatedDayClickListener
    public void onDeactivatedDayClick(@NonNull SeslSimpleMonthView seslSimpleMonthView, int i, int i2, int i4, boolean z, boolean z2) {
        this.mIsCalledFromDeactivatedDayClick = true;
        if (!this.mIsLunar) {
            SeslSimpleMonthView seslSimpleMonthView2 = this.mCalendarPagerAdapter.views.get((i2 - getMinMonth()) + ((i - getMinYear()) * 12));
            this.mDayOfWeekStart = seslSimpleMonthView2 == null ? 1 : seslSimpleMonthView2.getDayOfWeekStart();
            onDayClick(seslSimpleMonthView, i, i2, i4);
            updateSimpleMonthView(true);
            return;
        }
        int i5 = this.mCurrentPosition;
        LunarDate lunarDateByPosition = getLunarDateByPosition(z2 ? i5 - 1 : i5 + 1);
        int i6 = lunarDateByPosition.year;
        int i7 = lunarDateByPosition.month;
        this.mIsLeapMonth = lunarDateByPosition.isLeapMonth;
        int i8 = this.mCurrentPosition;
        int i9 = z2 ? i8 - 1 : i8 + 1;
        this.mCurrentPosition = i9;
        this.mCalendarViewPager.setCurrentItem(i9);
        SeslSimpleMonthView seslSimpleMonthView3 = this.mCalendarPagerAdapter.views.get(this.mCurrentPosition);
        this.mDayOfWeekStart = seslSimpleMonthView3 != null ? seslSimpleMonthView3.getDayOfWeekStart() : 1;
        onDayClick(seslSimpleMonthView, i6, i7, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeAllCallbacks();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        calculateContentHeight();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        int id = view.getId();
        if (id == C3623R.id.sesl_date_picker_calendar_header_prev_button && this.mCurrentPosition != 0) {
            postChangeCurrentByOneFromLongPress(false, ViewConfiguration.getLongPressTimeout());
        } else if (id == C3623R.id.sesl_date_picker_calendar_header_next_button && this.mCurrentPosition != this.mPositionCount - 1) {
            postChangeCurrentByOneFromLongPress(true, ViewConfiguration.getLongPressTimeout());
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.mMeasureSpecHeight = View.MeasureSpec.getSize(i2);
        int iMakeMeasureSpec = makeMeasureSpec(i, this.mCalendarViewPagerWidth);
        if (!this.mIsFirstMeasure && this.mOldCalendarViewPagerWidth == this.mCalendarViewPagerWidth) {
            super.onMeasure(iMakeMeasureSpec, i2);
            return;
        }
        this.mIsFirstMeasure = false;
        this.mOldCalendarViewPagerWidth = this.mCalendarViewPagerWidth;
        RelativeLayout relativeLayout = this.mCustomButtonLayout;
        if (relativeLayout != null) {
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mCalendarHeaderLayoutHeight));
        }
        this.mCalendarHeaderLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mDayOfTheWeekLayout.setLayoutParams(new LinearLayout.LayoutParams(this.mDayOfTheWeekLayoutWidth, this.mDayOfTheWeekLayoutHeight));
        this.mDayOfTheWeekView.setLayoutParams(new LinearLayout.LayoutParams(this.mDayOfTheWeekLayoutWidth, this.mDayOfTheWeekLayoutHeight));
        this.mCalendarViewPager.setLayoutParams(new LinearLayout.LayoutParams(this.mCalendarViewPagerWidth, this.mCalendarViewPagerHeight));
        if (this.mIsRTL && this.mIsConfigurationChanged) {
            this.mCalendarViewPager.seslSetConfigurationChanged(true);
        }
        this.mFirstBlankSpace.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mFirstBlankSpaceHeight));
        this.mSecondBlankSpace.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mSecondBlankSpaceHeight));
        super.onMeasure(iMakeMeasureSpec, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(((View.BaseSavedState) parcelable).getSuperState());
        SavedState savedState = (SavedState) parcelable;
        this.mCurrentDate.set(savedState.getSelectedYear(), savedState.getSelectedMonth(), savedState.getSelectedDay());
        if (this.mIsLunar) {
            this.mLunarCurrentYear = savedState.getSelectedYear();
            this.mLunarCurrentMonth = savedState.getSelectedMonth();
            this.mLunarCurrentDay = savedState.getSelectedDay();
        }
        this.mMinDate.setTimeInMillis(savedState.getMinDate());
        this.mMaxDate.setTimeInMillis(savedState.getMaxDate());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        int i = this.mCurrentDate.get(1);
        int i2 = this.mCurrentDate.get(2);
        int i4 = this.mCurrentDate.get(5);
        if (this.mIsLunar) {
            i = this.mLunarCurrentYear;
            i2 = this.mLunarCurrentMonth;
            i4 = this.mLunarCurrentDay;
        }
        int i5 = i4;
        return new SavedState(parcelableOnSaveInstanceState, i, i2, i5, this.mMinDate.getTimeInMillis(), this.mMaxDate.getTimeInMillis());
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onValidationChanged(boolean z) {
        ValidationCallback validationCallback = this.mValidationCallback;
        if (validationCallback != null) {
            validationCallback.onValidationChanged(z);
        }
    }

    public void removeAllCallbacks() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
            new Handler().postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslDatePicker.8
                @Override // java.lang.Runnable
                public void run() {
                    SeslDatePicker.this.mCalendarViewPager.setCurrentItem(SeslDatePicker.this.mCurrentPosition, false);
                }
            }, 200L);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout = this.mSpinnerLayout;
        if (seslDatePickerSpinnerLayout == null || seslDatePickerSpinnerLayout.getVisibility() != 0) {
            return;
        }
        this.mSpinnerLayout.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setCurrentViewType(int i) {
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z = true;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            if (this.mCurrentViewType != i) {
                this.mCalendarHeaderSpinner.setRotation(CALENDAR_HEADER_SPINNER_ROTATE_DEGREE);
                int i8 = this.mMode;
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (this.mIsLunar) {
                            i2 = this.mLunarCurrentYear;
                            i6 = this.mLunarCurrentMonth;
                            i7 = this.mLunarCurrentDay;
                            this.mSpinnerLayout.updateDate(i2, i6, i7);
                            this.mAnimator.setDisplayedChild(1);
                            this.mSpinnerLayout.setEnabled(true);
                            this.mCurrentViewType = i;
                            Message messageObtainMessage = this.mHandler.obtainMessage();
                            messageObtainMessage.what = 1000;
                            this.mHandler.sendMessage(messageObtainMessage);
                        } else {
                            i2 = this.mCurrentDate.get(1);
                            i4 = this.mCurrentDate.get(2);
                            i5 = this.mCurrentDate.get(5);
                            int i9 = i4;
                            i7 = i5;
                            i6 = i9;
                            this.mSpinnerLayout.updateDate(i2, i6, i7);
                            this.mAnimator.setDisplayedChild(1);
                            this.mSpinnerLayout.setEnabled(true);
                            this.mCurrentViewType = i;
                            Message messageObtainMessage2 = this.mHandler.obtainMessage();
                            messageObtainMessage2.what = 1000;
                            this.mHandler.sendMessage(messageObtainMessage2);
                        }
                    } else if (this.mIsLunar) {
                        i2 = this.mLunarEndYear;
                        i6 = this.mLunarEndMonth;
                        i7 = this.mLunarEndDay;
                        this.mSpinnerLayout.updateDate(i2, i6, i7);
                        this.mAnimator.setDisplayedChild(1);
                        this.mSpinnerLayout.setEnabled(true);
                        this.mCurrentViewType = i;
                        Message messageObtainMessage22 = this.mHandler.obtainMessage();
                        messageObtainMessage22.what = 1000;
                        this.mHandler.sendMessage(messageObtainMessage22);
                    } else {
                        i2 = this.mEndDate.get(1);
                        i4 = this.mEndDate.get(2);
                        i5 = this.mEndDate.get(5);
                        int i92 = i4;
                        i7 = i5;
                        i6 = i92;
                        this.mSpinnerLayout.updateDate(i2, i6, i7);
                        this.mAnimator.setDisplayedChild(1);
                        this.mSpinnerLayout.setEnabled(true);
                        this.mCurrentViewType = i;
                        Message messageObtainMessage222 = this.mHandler.obtainMessage();
                        messageObtainMessage222.what = 1000;
                        this.mHandler.sendMessage(messageObtainMessage222);
                    }
                } else if (this.mIsLunar) {
                    i2 = this.mLunarStartYear;
                    i6 = this.mLunarStartMonth;
                    i7 = this.mLunarStartDay;
                    this.mSpinnerLayout.updateDate(i2, i6, i7);
                    this.mAnimator.setDisplayedChild(1);
                    this.mSpinnerLayout.setEnabled(true);
                    this.mCurrentViewType = i;
                    Message messageObtainMessage2222 = this.mHandler.obtainMessage();
                    messageObtainMessage2222.what = 1000;
                    this.mHandler.sendMessage(messageObtainMessage2222);
                } else {
                    i2 = this.mStartDate.get(1);
                    i4 = this.mStartDate.get(2);
                    i5 = this.mStartDate.get(5);
                    int i922 = i4;
                    i7 = i5;
                    i6 = i922;
                    this.mSpinnerLayout.updateDate(i2, i6, i7);
                    this.mAnimator.setDisplayedChild(1);
                    this.mSpinnerLayout.setEnabled(true);
                    this.mCurrentViewType = i;
                    Message messageObtainMessage22222 = this.mHandler.obtainMessage();
                    messageObtainMessage22222.what = 1000;
                    this.mHandler.sendMessage(messageObtainMessage22222);
                }
            } else {
                z = false;
            }
        } else if (this.mCurrentViewType != i) {
            this.mSpinnerLayout.updateInputState();
            this.mSpinnerLayout.setEditTextMode(false);
            this.mAnimator.setDisplayedChild(0);
            this.mSpinnerLayout.setVisibility(4);
            this.mSpinnerLayout.setEnabled(false);
            this.mCurrentViewType = i;
            Message messageObtainMessage3 = this.mHandler.obtainMessage();
            messageObtainMessage3.what = 1000;
            this.mHandler.sendMessage(messageObtainMessage3);
            this.mCalendarPagerAdapter.notifyDataSetChanged();
        }
        OnViewTypeChangedListener onViewTypeChangedListener = this.mOnViewTypeChangedListener;
        if (onViewTypeChangedListener != null && z) {
            onViewTypeChangedListener.onViewTypeChanged(this);
        }
        Message messageObtainMessage4 = this.mHandler.obtainMessage();
        messageObtainMessage4.what = 1001;
        this.mHandler.sendMessage(messageObtainMessage4);
    }

    public void setDateMode(int i) {
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        this.mMode = i;
        this.mIsWeekRangeSet = false;
        if (i == 1) {
            if (this.mIsLunar) {
                i2 = this.mLunarStartYear;
                i4 = this.mLunarStartMonth;
                i5 = this.mLunarStartDay;
            } else {
                i2 = this.mStartDate.get(1);
                i4 = this.mStartDate.get(2);
                i5 = this.mStartDate.get(5);
            }
            this.mSpinnerLayout.updateDate(i2, i4, i5);
        } else if (i == 2) {
            if (this.mIsLunar) {
                i15 = this.mLunarEndYear;
                i16 = this.mLunarEndMonth;
                i17 = this.mLunarEndDay;
            } else {
                i15 = this.mEndDate.get(1);
                i16 = this.mEndDate.get(2);
                i17 = this.mEndDate.get(5);
            }
            this.mSpinnerLayout.updateDate(i15, i16, i17);
        }
        if (this.mCurrentViewType == 1) {
            this.mSpinnerLayout.setVisibility(0);
            this.mSpinnerLayout.setEnabled(true);
        }
        SeslSimpleMonthView seslSimpleMonthView = this.mCalendarPagerAdapter.views.get(this.mCurrentPosition);
        if (seslSimpleMonthView != null) {
            if (this.mIsLunar) {
                i6 = this.mLunarCurrentYear;
                i7 = this.mLunarCurrentMonth;
                i8 = this.mLunarCurrentDay;
            } else {
                i6 = this.mCurrentDate.get(1);
                i7 = this.mCurrentDate.get(2);
                i8 = this.mCurrentDate.get(5);
            }
            int i18 = i8;
            int i19 = i7;
            int i20 = i6;
            int minDay = (getMinMonth() == i19 && getMinYear() == i20) ? getMinDay() : 1;
            int maxDay = (getMaxMonth() == i19 && getMaxYear() == i20) ? getMaxDay() : 31;
            if (this.mIsLunar) {
                i9 = this.mLunarStartYear;
                int i21 = this.mLunarStartMonth;
                int i22 = this.mLunarStartDay;
                i10 = this.mLunarEndYear;
                i13 = i21;
                i14 = i22;
                i12 = this.mLunarEndMonth;
                i11 = this.mLunarEndDay;
            } else {
                i9 = this.mStartDate.get(1);
                int i23 = this.mStartDate.get(2);
                int i24 = this.mStartDate.get(5);
                i10 = this.mEndDate.get(1);
                int i25 = this.mEndDate.get(2);
                i11 = this.mEndDate.get(5);
                i12 = i25;
                i13 = i23;
                i14 = i24;
            }
            seslSimpleMonthView.setMonthParams(i18, i19, i20, getFirstDayOfWeek(), minDay, maxDay, this.mMinDate, this.mMaxDate, i9, i13, i14, this.mIsLeapStartMonth, i10, i12, i11, this.mIsLeapEndMonth, this.mMode);
            seslSimpleMonthView.invalidate();
        }
        if (this.mIsLunar) {
            updateSimpleMonthView(false);
        }
        this.mCalendarPagerAdapter.notifyDataSetChanged();
    }

    public void setDateValidator(@Nullable DateValidator dateValidator) {
        this.mDateValidator = dateValidator;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setDialogPaddingVertical(int i) {
        this.mDialogPaddingVertical = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setDialogWindow(Window window) {
        if (window != null) {
            this.mDialogWindow = window;
        }
    }

    public void setEditTextMode(boolean z) {
        if (this.mCurrentViewType == 0) {
            return;
        }
        this.mSpinnerLayout.setEditTextMode(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (isEnabled() == z) {
            return;
        }
        super.setEnabled(z);
        this.mIsEnabled = z;
    }

    public void setFirstDayOfWeek(int i) {
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
        }
        this.mFirstDayOfWeek = i;
    }

    public void setLunar(boolean z, boolean z2) {
        if (!this.mIsLunarSupported || this.mIsLunar == z) {
            return;
        }
        this.mIsLunar = z;
        this.mIsLeapMonth = z2;
        this.mSpinnerLayout.setLunar(z, z2, this.mPathClassLoader);
        if (z) {
            setTotalMonthCountWithLeap();
            if (this.mMode == 0) {
                this.mIsLeapStartMonth = z2 ? 1 : 0;
                this.mIsLeapEndMonth = z2 ? 1 : 0;
            }
        }
        this.mIsFromSetLunar = true;
        this.mCalendarPagerAdapter.notifyDataSetChanged();
        this.mLunarChanged = true;
        updateSimpleMonthView(true);
        this.mLunarChanged = false;
    }

    public void setLunarEndDate(int i, int i2, int i4, boolean z) {
        this.mLunarEndYear = i;
        this.mLunarEndMonth = i2;
        this.mLunarEndDay = i4;
        this.mIsLeapEndMonth = z ? 1 : 0;
    }

    public void setLunarStartDate(int i, int i2, int i4, boolean z) {
        this.mLunarStartYear = i;
        this.mLunarStartMonth = i2;
        this.mLunarStartDay = i4;
        this.mIsLeapStartMonth = z ? 1 : 0;
    }

    public void setLunarSupported(boolean z, View view) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        this.mIsLunarSupported = z;
        if (z) {
            removeCustomViewFromParent();
            this.mCustomButtonView = view;
            if (view != null) {
                removeCustomViewFromParent();
                this.mCustomButtonView.setId(R.id.custom);
                ViewGroup.LayoutParams layoutParams3 = this.mCustomButtonView.getLayoutParams();
                if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                    layoutParams = (RelativeLayout.LayoutParams) layoutParams3;
                } else {
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        layoutParams2 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams3);
                    } else if (layoutParams3 != null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(layoutParams3);
                    } else {
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    }
                    layoutParams = layoutParams2;
                }
                layoutParams.addRule(15);
                layoutParams.addRule(21);
                addCustomButtonInHeader();
            }
        } else {
            this.mIsLunar = false;
            this.mIsLeapMonth = false;
            this.mCustomButtonView = null;
        }
        if (this.mIsLunarSupported && this.mPathClassLoader == null) {
            mPackageManager = this.mContext.getApplicationContext().getPackageManager();
            PathClassLoader pathClassLoader = LunarUtils.getPathClassLoader(getContext());
            this.mPathClassLoader = pathClassLoader;
            if (pathClassLoader == null) {
                return;
            }
            this.mSolarLunarConverter = SeslFeatureReflector.getSolarLunarConverter(pathClassLoader);
            this.mSolarLunarTables = SeslFeatureReflector.getSolarLunarTables(this.mPathClassLoader);
        }
    }

    public void setMaxDate(long j) {
        this.mTempMinMaxDate.setTimeInMillis(j);
        if (this.mTempMinMaxDate.get(1) != this.mMaxDate.get(1) || this.mTempMinMaxDate.get(6) == this.mMaxDate.get(6)) {
            if (this.mIsLunar) {
                setTotalMonthCountWithLeap();
            }
            if (this.mCurrentDate.after(this.mTempMinMaxDate)) {
                this.mCurrentDate.setTimeInMillis(j);
                onDateChanged();
            }
            this.mMaxDate.setTimeInMillis(j);
            this.mSpinnerLayout.setMaxDate(this.mMaxDate.getTimeInMillis());
            this.mCalendarPagerAdapter.notifyDataSetChanged();
            updateSimpleMonthView(false);
        }
    }

    public void setMinDate(long j) {
        this.mTempMinMaxDate.setTimeInMillis(j);
        if (this.mTempMinMaxDate.get(1) != this.mMinDate.get(1) || this.mTempMinMaxDate.get(6) == this.mMinDate.get(6)) {
            if (this.mIsLunar) {
                setTotalMonthCountWithLeap();
            }
            if (this.mCurrentDate.before(this.mTempMinMaxDate)) {
                this.mCurrentDate.setTimeInMillis(j);
                onDateChanged();
            }
            this.mMinDate.setTimeInMillis(j);
            this.mSpinnerLayout.setMinDate(this.mMinDate.getTimeInMillis());
            this.mCalendarPagerAdapter.notifyDataSetChanged();
            updateSimpleMonthView(false);
        }
    }

    public void setOnEditTextModeChangedListener(OnEditTextModeChangedListener onEditTextModeChangedListener) {
        this.mSpinnerLayout.setOnEditTextModeChangedListener(this, onEditTextModeChangedListener);
    }

    public void setOnViewTypeChangedListener(OnViewTypeChangedListener onViewTypeChangedListener) {
        this.mOnViewTypeChangedListener = onViewTypeChangedListener;
    }

    public void setSeparateLunarButton(boolean z) {
        if (this.mIsCustomButtonSeparate == z) {
            return;
        }
        if (z) {
            removeCustomButtonInHeader();
            addCustomButtonSeparateLayout();
        } else {
            removeCustomButtonSeparateLayout();
            addCustomButtonInHeader();
        }
        this.mIsCustomButtonSeparate = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setValidationCallback(@Nullable ValidationCallback validationCallback) {
        this.mValidationCallback = validationCallback;
    }

    public void updateDate(int i, int i2, int i4) {
        SeslSimpleMonthView seslSimpleMonthView;
        SeslSimpleMonthView seslSimpleMonthView2;
        this.mTempDate.set(1, i);
        this.mTempDate.set(2, i2);
        Calendar calendar = this.mTempDate;
        calendar.set(5, i4 > calendar.getActualMaximum(5) ? this.mTempDate.getActualMaximum(5) : i4);
        Calendar calendarForLocale = getCalendarForLocale(this.mTempDate, this.mCurrentLocale);
        this.mCurrentDate = calendarForLocale;
        if (this.mIsLunar) {
            this.mLunarCurrentYear = i;
            this.mLunarCurrentMonth = i2;
            this.mLunarCurrentDay = i4;
        }
        int i5 = this.mMode;
        if (i5 == 1) {
            if (this.mStartDate.compareTo(this.mEndDate) == 0 || this.mCurrentDate.compareTo(this.mEndDate) > 0) {
                clearCalendar(this.mEndDate, i, i2, i4);
            }
            clearCalendar(this.mStartDate, i, i2, i4);
            if (this.mIsLunar) {
                if (this.mStartDate.compareTo(this.mEndDate) == 0 || this.mCurrentDate.compareTo(this.mEndDate) > 0) {
                    this.mLunarEndYear = i;
                    this.mLunarEndMonth = i2;
                    this.mLunarEndDay = i4;
                }
                this.mLunarStartYear = i;
                this.mLunarStartMonth = i2;
                this.mLunarStartDay = i4;
            }
        } else if (i5 != 2) {
            clearCalendar(this.mStartDate, i, i2, i4);
            clearCalendar(this.mEndDate, i, i2, i4);
            if (this.mIsLunar) {
                this.mLunarStartYear = i;
                this.mLunarStartMonth = i2;
                this.mLunarStartDay = i4;
                this.mLunarEndYear = i;
                this.mLunarEndMonth = i2;
                this.mLunarEndDay = i4;
            }
        } else {
            if (calendarForLocale.compareTo(this.mStartDate) < 0) {
                clearCalendar(this.mStartDate, i, i2, i4);
            }
            clearCalendar(this.mEndDate, i, i2, i4);
            if (this.mIsLunar) {
                if (this.mCurrentDate.compareTo(this.mStartDate) < 0) {
                    this.mLunarStartYear = i;
                    this.mLunarStartMonth = i2;
                    this.mLunarStartDay = i4;
                }
                this.mLunarEndYear = i;
                this.mLunarEndMonth = i2;
                this.mLunarEndDay = i4;
            }
        }
        this.mCalendarPagerAdapter.notifyDataSetChanged();
        updateSimpleMonthView(true);
        onDateChanged();
        SparseArray<SeslSimpleMonthView> sparseArray = this.mCalendarPagerAdapter.views;
        SeslSimpleMonthView seslSimpleMonthView3 = sparseArray.get(this.mCurrentPosition);
        if (seslSimpleMonthView3 != null) {
            int minDay = (getMinMonth() == i2 && getMinYear() == i) ? getMinDay() : 1;
            int maxDay = (getMaxMonth() == i2 && getMaxYear() == i) ? getMaxDay() : 31;
            if (this.mIsLunarSupported) {
                seslSimpleMonthView3.setLunar(this.mIsLunar, this.mIsLeapMonth, this.mPathClassLoader);
            }
            if (this.mMode == 3 && this.mIsWeekRangeSet) {
                updateStartEndDateRange(getDayOffset(), i, i2, i4);
            }
            int i6 = this.mStartDate.get(1);
            int i7 = this.mStartDate.get(2);
            int i8 = this.mStartDate.get(5);
            int i9 = this.mEndDate.get(1);
            int i10 = this.mEndDate.get(2);
            int i11 = this.mEndDate.get(5);
            if (this.mIsLunar) {
                i6 = this.mLunarStartYear;
                i7 = this.mLunarStartMonth;
                i8 = this.mLunarStartDay;
                i9 = this.mLunarEndYear;
                i10 = this.mLunarEndMonth;
                i11 = this.mLunarEndDay;
            }
            seslSimpleMonthView3.setMonthParams(i4, i2, i, getFirstDayOfWeek(), minDay, maxDay, this.mMinDate, this.mMaxDate, i6, i7, i8, this.mIsLeapStartMonth, i9, i10, i11, this.mIsLeapEndMonth, this.mMode);
            seslSimpleMonthView3.invalidate();
            if (!this.mIsLunar) {
                int i12 = this.mCurrentPosition - 1;
                if (i12 >= 0 && (seslSimpleMonthView2 = sparseArray.get(i12)) != null) {
                    seslSimpleMonthView2.setStartDate(this.mStartDate, this.mIsLeapStartMonth);
                    seslSimpleMonthView2.setEndDate(this.mEndDate, this.mIsLeapEndMonth);
                }
                int i13 = this.mCurrentPosition + 1;
                if (i13 < this.mPositionCount && (seslSimpleMonthView = sparseArray.get(i13)) != null) {
                    seslSimpleMonthView.setStartDate(this.mStartDate, this.mIsLeapStartMonth);
                    seslSimpleMonthView.setEndDate(this.mEndDate, this.mIsLeapEndMonth);
                }
            }
        }
        SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout = this.mSpinnerLayout;
        if (seslDatePickerSpinnerLayout != null) {
            seslDatePickerSpinnerLayout.updateDate(i, i2, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.picker.widget.SeslDatePicker.SavedState.1
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
        private final long mMaxDate;
        private final long mMinDate;
        private final int mSelectedDay;
        private final int mSelectedMonth;
        private final int mSelectedYear;

        public long getMaxDate() {
            return this.mMaxDate;
        }

        public long getMinDate() {
            return this.mMinDate;
        }

        public int getSelectedDay() {
            return this.mSelectedDay;
        }

        public int getSelectedMonth() {
            return this.mSelectedMonth;
        }

        public int getSelectedYear() {
            return this.mSelectedYear;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mSelectedYear);
            parcel.writeInt(this.mSelectedMonth);
            parcel.writeInt(this.mSelectedDay);
            parcel.writeLong(this.mMinDate);
            parcel.writeLong(this.mMaxDate);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i4, long j, long j2) {
            super(parcelable);
            this.mSelectedYear = i;
            this.mSelectedMonth = i2;
            this.mSelectedDay = i4;
            this.mMinDate = j;
            this.mMaxDate = j2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSelectedYear = parcel.readInt();
            this.mSelectedMonth = parcel.readInt();
            this.mSelectedDay = parcel.readInt();
            this.mMinDate = parcel.readLong();
            this.mMaxDate = parcel.readLong();
        }
    }

    public SeslDatePicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public SeslDatePicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslDatePicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsConfigurationChanged = false;
        this.mIsFirstMeasure = true;
        this.mIsEnabled = true;
        this.mIsCalendarViewDisabled = false;
        this.mIsSpinnerViewDisabled = false;
        this.mCurrentViewType = -1;
        this.mOldSelectedDay = -1;
        this.mPadding = 0;
        this.mBackgroundBorderlessResId = -1;
        this.mMode = 0;
        this.mFirstDayOfWeek = 0;
        this.mMonthViewColor = null;
        this.mIsLunarSupported = false;
        this.mIsLunar = false;
        this.mIsLeapMonth = false;
        this.mIsFromSetLunar = false;
        this.mLunarChanged = false;
        this.mIsCustomButtonSeparate = false;
        this.mPathClassLoader = null;
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: androidx.picker.widget.SeslDatePicker.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    return;
                }
                SeslDatePicker.this.removeAllCallbacks();
            }
        };
        this.mBtnFocusChangeListener = onFocusChangeListener;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: androidx.picker.widget.SeslDatePicker.2
            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                int i4 = message.what;
                if (i4 == 1000) {
                    if (SeslDatePicker.this.mTempDate.get(1) > SeslDatePicker.this.getMaxYear() || SeslDatePicker.this.mTempDate.get(1) < SeslDatePicker.this.getMinYear()) {
                        return;
                    }
                    SeslDatePicker seslDatePicker = SeslDatePicker.this;
                    String monthAndYearString = seslDatePicker.getMonthAndYearString(seslDatePicker.mTempDate);
                    SeslDatePicker.this.mCalendarHeaderText.setText(monthAndYearString);
                    SeslDatePicker seslDatePicker2 = SeslDatePicker.this;
                    String monthAndYearString2 = seslDatePicker2.getMonthAndYearString(seslDatePicker2.mTempDate);
                    SeslDatePicker seslDatePicker3 = SeslDatePicker.this;
                    if (!monthAndYearString2.equals(seslDatePicker3.getMonthAndYearString(seslDatePicker3.mCurrentDate))) {
                        SeslDatePicker.this.mCalendarViewPager.announceForAccessibility(SeslDatePicker.this.mCalendarHeaderText.getText());
                    }
                    String string = SeslDatePicker.this.mContext.getString(SeslDatePicker.this.mCurrentViewType == 0 ? C3623R.string.sesl_date_picker_switch_to_month_day_year_view_description : C3623R.string.sesl_date_picker_switch_to_calendar_description);
                    if (SeslDatePicker.this.mDateValidator != null) {
                        SeslDatePicker.this.mCalendarHeaderText.setContentDescription(monthAndYearString);
                        return;
                    }
                    SeslDatePicker.this.mCalendarHeaderText.setContentDescription(monthAndYearString + SQLKeyword.COMMA + string);
                    return;
                }
                if (i4 != 1001) {
                    return;
                }
                SeslDatePicker seslDatePicker4 = SeslDatePicker.this;
                if (seslDatePicker4.mCurrentViewType == 1) {
                    seslDatePicker4.setPrevButtonProperties(0.0f, false);
                    SeslDatePicker.this.setNextButtonProperties(0.0f, false);
                    SeslDatePicker.this.mPrevButton.setImportantForAccessibility(2);
                    SeslDatePicker.this.mNextButton.setImportantForAccessibility(2);
                    SeslDatePicker.this.mCalendarHeaderText.sendAccessibilityEvent(8);
                    return;
                }
                int field_TYPE_NONE = SeslHoverPopupWindowReflector.getField_TYPE_NONE();
                if (field_TYPE_NONE != -1) {
                    SeslViewReflector.semSetHoverPopupType(SeslDatePicker.this.mPrevButton, field_TYPE_NONE);
                    SeslViewReflector.semSetHoverPopupType(SeslDatePicker.this.mNextButton, field_TYPE_NONE);
                }
                TooltipCompat.setTooltipText(SeslDatePicker.this.mPrevButton, SeslDatePicker.this.getResources().getString(C3623R.string.sesl_date_picker_decrement_month));
                TooltipCompat.setTooltipText(SeslDatePicker.this.mNextButton, SeslDatePicker.this.getResources().getString(C3623R.string.sesl_date_picker_increment_month));
                SeslDatePicker.this.mPrevButton.setImportantForAccessibility(1);
                SeslDatePicker.this.mNextButton.setImportantForAccessibility(1);
                SeslDatePicker seslDatePicker5 = SeslDatePicker.this;
                int i5 = seslDatePicker5.mCurrentPosition;
                if (i5 > 0 && i5 < seslDatePicker5.mPositionCount - 1) {
                    seslDatePicker5.setPrevButtonProperties(1.0f, true);
                    SeslDatePicker.this.setNextButtonProperties(1.0f, true);
                    return;
                }
                int i6 = seslDatePicker5.mPositionCount;
                if (i6 == 1) {
                    seslDatePicker5.setPrevButtonProperties(0.4f, false);
                    SeslDatePicker.this.setNextButtonProperties(0.4f, false);
                    SeslDatePicker.this.removeAllCallbacks();
                } else if (i5 == 0) {
                    seslDatePicker5.setPrevButtonProperties(0.4f, false);
                    SeslDatePicker.this.setNextButtonProperties(1.0f, true);
                    SeslDatePicker.this.removeAllCallbacks();
                } else if (i5 == i6 - 1) {
                    seslDatePicker5.setPrevButtonProperties(1.0f, true);
                    SeslDatePicker.this.setNextButtonProperties(0.4f, false);
                    SeslDatePicker.this.removeAllCallbacks();
                }
            }
        };
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: androidx.picker.widget.SeslDatePicker.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return false;
                }
                SeslDatePicker.this.removeAllCallbacks();
                return false;
            }
        };
        this.mMonthBtnTouchListener = onTouchListener;
        View.OnKeyListener onKeyListener = new View.OnKeyListener() { // from class: androidx.picker.widget.SeslDatePicker.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                if (SeslDatePicker.this.mIsRTL) {
                    SeslDatePicker.this.mIsConfigurationChanged = false;
                }
                if (keyEvent.getAction() == 1 || keyEvent.getAction() == 3) {
                    SeslDatePicker.this.removeAllCallbacks();
                }
                return false;
            }
        };
        this.mMonthBtnKeyListener = onKeyListener;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: androidx.picker.widget.SeslDatePicker.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SeslDatePicker seslDatePicker = SeslDatePicker.this;
                seslDatePicker.setCurrentViewType((seslDatePicker.mCurrentViewType + 1) % 2);
                SeslDatePicker.this.startCalendarHeaderSpinnerAnimation();
            }
        };
        this.mCalendarHeaderClickListener = onClickListener;
        this.mContext = context;
        this.mCurrentLocale = Locale.getDefault();
        this.mIsRTL = isRTL();
        this.mIsFarsiLanguage = isFarsiLanguage();
        boolean zIsSimplifiedChinese = isSimplifiedChinese();
        this.mIsSimplifiedChinese = zIsSimplifiedChinese;
        if (zIsSimplifiedChinese) {
            this.mDayFormatter = new SimpleDateFormat("EEEEE", this.mCurrentLocale);
        } else {
            this.mDayFormatter = new SimpleDateFormat("EEE", this.mCurrentLocale);
        }
        this.mMinDate = getCalendarForLocale(this.mMinDate, this.mCurrentLocale);
        Calendar calendarForLocale = getCalendarForLocale(this.mMaxDate, this.mCurrentLocale);
        this.mMaxDate = calendarForLocale;
        this.mTempMinMaxDate = getCalendarForLocale(calendarForLocale, this.mCurrentLocale);
        Calendar calendarForLocale2 = getCalendarForLocale(this.mCurrentDate, this.mCurrentLocale);
        this.mCurrentDate = calendarForLocale2;
        this.mTempDate = getCalendarForLocale(calendarForLocale2, this.mCurrentLocale);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3623R.styleable.DatePicker, i, i2);
        this.mMinDate.set(typedArrayObtainStyledAttributes.getInt(C3623R.styleable.DatePicker_android_startYear, DEFAULT_START_YEAR), 0, 1);
        this.mMaxDate.set(typedArrayObtainStyledAttributes.getInt(C3623R.styleable.DatePicker_android_endYear, DEFAULT_END_YEAR), 11, 31);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C3623R.layout.sesl_date_picker, (ViewGroup) this, true);
        int i4 = typedArrayObtainStyledAttributes.getInt(C3623R.styleable.DatePicker_android_firstDayOfWeek, 0);
        if (i4 != 0) {
            setFirstDayOfWeek(i4);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mMonthViewColor = getMonthViewColorStringForSpecific();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C3623R.styleable.DatePicker, i, i2);
        try {
            DayOfTheWeekView dayOfTheWeekView = new DayOfTheWeekView(context, typedArrayObtainStyledAttributes2);
            this.mDayOfTheWeekView = dayOfTheWeekView;
            int color = typedArrayObtainStyledAttributes2.getColor(C3623R.styleable.DatePicker_headerTextColor, resources.getColor(C3623R.color.sesl_date_picker_header_text_color_light));
            this.mCalendarHeaderTextColor = color;
            int color2 = typedArrayObtainStyledAttributes2.getColor(C3623R.styleable.DatePicker_buttonTintColor, resources.getColor(C3623R.color.sesl_date_picker_button_tint_color_light));
            this.mBtnTintColor = color2;
            typedArrayObtainStyledAttributes2.recycle();
            CalendarPagerAdapter calendarPagerAdapter = new CalendarPagerAdapter();
            this.mCalendarPagerAdapter = calendarPagerAdapter;
            ViewPager viewPager = (ViewPager) findViewById(C3623R.id.sesl_date_picker_calendar);
            this.mCalendarViewPager = viewPager;
            viewPager.setAdapter(calendarPagerAdapter);
            viewPager.setOnPageChangeListener(new CalendarPageChangeListener());
            viewPager.seslSetSupportedMouseWheelEvent(true);
            viewPager.canSupportLayoutDirectionForDatePicker(true);
            this.mPadding = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_padding);
            this.mCalendarHeader = (RelativeLayout) findViewById(C3623R.id.sesl_date_picker_calendar_header);
            LinearLayout linearLayout = (LinearLayout) findViewById(C3623R.id.sesl_date_picker_calendar_header_text_spinner_layout);
            this.mCalendarHeaderTextSpinnerLayout = linearLayout;
            View viewFindViewById = findViewById(C3623R.id.sesl_date_picker_calendar_header_spinner);
            this.mCalendarHeaderSpinner = viewFindViewById;
            TextView textView = (TextView) findViewById(C3623R.id.sesl_date_picker_calendar_header_text);
            this.mCalendarHeaderText = textView;
            textView.setTextColor(color);
            this.mStartDate = getCalendarForLocale(this.mCurrentDate, this.mCurrentLocale);
            this.mEndDate = getCalendarForLocale(this.mCurrentDate, this.mCurrentLocale);
            this.mAnimator = (ViewAnimator) findViewById(C3623R.id.sesl_date_picker_view_animator);
            SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout = (SeslDatePickerSpinnerLayout) findViewById(C3623R.id.sesl_date_picker_spinner_view);
            this.mSpinnerLayout = seslDatePickerSpinnerLayout;
            seslDatePickerSpinnerLayout.setOnSpinnerDateChangedListener(this, new SeslDatePickerSpinnerLayout.OnSpinnerDateChangedListener() { // from class: androidx.picker.widget.SeslDatePicker.6
                /* JADX WARN: Removed duplicated region for block: B:24:0x00a4  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
                @Override // androidx.picker.widget.SeslDatePickerSpinnerLayout.OnSpinnerDateChangedListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onDateChanged(SeslDatePickerSpinnerLayout seslDatePickerSpinnerLayout2, int i5, int i6, int i7) {
                    SeslDatePicker.this.mCurrentDate.set(1, i5);
                    SeslDatePicker.this.mCurrentDate.set(2, i6);
                    SeslDatePicker.this.mCurrentDate.set(5, i7);
                    SeslDatePicker seslDatePicker = SeslDatePicker.this;
                    if (seslDatePicker.mIsLunar) {
                        seslDatePicker.mLunarCurrentYear = i5;
                        seslDatePicker.mLunarCurrentMonth = i6;
                        seslDatePicker.mLunarCurrentDay = i7;
                    }
                    int i8 = seslDatePicker.mMode;
                    if (i8 != 1) {
                        if (i8 != 2) {
                            seslDatePicker.clearCalendar(seslDatePicker.mStartDate, i5, i6, i7);
                            SeslDatePicker seslDatePicker2 = SeslDatePicker.this;
                            seslDatePicker2.clearCalendar(seslDatePicker2.mEndDate, i5, i6, i7);
                            SeslDatePicker seslDatePicker3 = SeslDatePicker.this;
                            if (seslDatePicker3.mIsLunar) {
                                seslDatePicker3.mLunarStartYear = i5;
                                seslDatePicker3.mLunarStartMonth = i6;
                                seslDatePicker3.mLunarStartDay = i7;
                                seslDatePicker3.mIsLeapStartMonth = 0;
                                seslDatePicker3.mLunarEndYear = i5;
                                seslDatePicker3.mLunarEndMonth = i6;
                                seslDatePicker3.mLunarEndDay = i7;
                                seslDatePicker3.mIsLeapEndMonth = 0;
                                seslDatePicker3.mIsLeapMonth = false;
                            }
                        } else {
                            if (seslDatePicker.mCurrentDate.compareTo(seslDatePicker.mStartDate) < 0) {
                                SeslDatePicker seslDatePicker4 = SeslDatePicker.this;
                                seslDatePicker4.clearCalendar(seslDatePicker4.mStartDate, i5, i6, i7);
                            }
                            SeslDatePicker seslDatePicker5 = SeslDatePicker.this;
                            seslDatePicker5.clearCalendar(seslDatePicker5.mEndDate, i5, i6, i7);
                            SeslDatePicker seslDatePicker6 = SeslDatePicker.this;
                            if (seslDatePicker6.mIsLunar) {
                                if (seslDatePicker6.mCurrentDate.compareTo(seslDatePicker6.mStartDate) < 0) {
                                    SeslDatePicker seslDatePicker7 = SeslDatePicker.this;
                                    seslDatePicker7.mLunarStartYear = i5;
                                    seslDatePicker7.mLunarStartMonth = i6;
                                    seslDatePicker7.mLunarStartDay = i7;
                                    seslDatePicker7.mIsLeapStartMonth = 0;
                                }
                                SeslDatePicker seslDatePicker8 = SeslDatePicker.this;
                                seslDatePicker8.mLunarEndYear = i5;
                                seslDatePicker8.mLunarEndMonth = i6;
                                seslDatePicker8.mLunarEndDay = i7;
                                seslDatePicker8.mIsLeapEndMonth = 0;
                            }
                        }
                    } else if (seslDatePicker.mStartDate.compareTo(seslDatePicker.mEndDate) != 0) {
                        SeslDatePicker seslDatePicker9 = SeslDatePicker.this;
                        if (seslDatePicker9.mCurrentDate.compareTo(seslDatePicker9.mEndDate) > 0) {
                            SeslDatePicker seslDatePicker10 = SeslDatePicker.this;
                            seslDatePicker10.clearCalendar(seslDatePicker10.mEndDate, i5, i6, i7);
                        }
                        SeslDatePicker seslDatePicker11 = SeslDatePicker.this;
                        seslDatePicker11.clearCalendar(seslDatePicker11.mStartDate, i5, i6, i7);
                        SeslDatePicker seslDatePicker12 = SeslDatePicker.this;
                        if (seslDatePicker12.mIsLunar) {
                            if (seslDatePicker12.mStartDate.compareTo(seslDatePicker12.mEndDate) != 0) {
                                SeslDatePicker seslDatePicker13 = SeslDatePicker.this;
                                if (seslDatePicker13.mCurrentDate.compareTo(seslDatePicker13.mEndDate) > 0) {
                                    SeslDatePicker seslDatePicker14 = SeslDatePicker.this;
                                    seslDatePicker14.mLunarEndYear = i5;
                                    seslDatePicker14.mLunarEndMonth = i6;
                                    seslDatePicker14.mLunarEndDay = i7;
                                    seslDatePicker14.mIsLeapEndMonth = 0;
                                }
                                SeslDatePicker seslDatePicker15 = SeslDatePicker.this;
                                seslDatePicker15.mLunarStartYear = i5;
                                seslDatePicker15.mLunarStartMonth = i6;
                                seslDatePicker15.mLunarStartDay = i7;
                                seslDatePicker15.mIsLeapStartMonth = 0;
                            }
                        }
                    }
                    SeslDatePicker seslDatePicker16 = SeslDatePicker.this;
                    seslDatePicker16.onValidationChanged(true ^ seslDatePicker16.mStartDate.after(seslDatePicker16.mEndDate));
                    SeslDatePicker.this.updateSimpleMonthView(false);
                    SeslDatePicker seslDatePicker17 = SeslDatePicker.this;
                    if (seslDatePicker17.mMode == 3 && seslDatePicker17.mIsWeekRangeSet) {
                        SeslDatePicker seslDatePicker18 = SeslDatePicker.this;
                        seslDatePicker18.updateStartEndDateRange(seslDatePicker18.getDayOffset(), i5, i6, i7);
                    }
                    SeslDatePicker.this.onDateChanged();
                }
            });
            this.mCurrentViewType = 0;
            linearLayout.setOnClickListener(onClickListener);
            linearLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.picker.widget.SeslDatePicker.7
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        SeslDatePicker seslDatePicker = SeslDatePicker.this;
                        if (seslDatePicker.mCurrentViewType == 1) {
                            seslDatePicker.setEditTextMode(false);
                        }
                    }
                }
            });
            this.mDayOfTheWeekLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_day_height);
            this.mCalendarViewPagerWidth = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_width);
            this.mCalendarViewMargin = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_margin);
            this.mDayOfTheWeekLayoutWidth = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_width);
            LinearLayout linearLayout2 = (LinearLayout) findViewById(C3623R.id.sesl_date_picker_day_of_the_week);
            this.mDayOfTheWeekLayout = linearLayout2;
            linearLayout2.addView(dayOfTheWeekView);
            this.mDatePickerLayout = (LinearLayout) findViewById(C3623R.id.sesl_date_picker_layout);
            this.mCalendarHeaderLayout = (RelativeLayout) findViewById(C3623R.id.sesl_date_picker_calendar_header_layout);
            if (this.mIsRTL) {
                ImageButton imageButton = (ImageButton) findViewById(C3623R.id.sesl_date_picker_calendar_header_next_button);
                this.mPrevButton = imageButton;
                ImageButton imageButton2 = (ImageButton) findViewById(C3623R.id.sesl_date_picker_calendar_header_prev_button);
                this.mNextButton = imageButton2;
                imageButton.setContentDescription(context.getString(C3623R.string.sesl_date_picker_decrement_month));
                imageButton2.setContentDescription(context.getString(C3623R.string.sesl_date_picker_increment_month));
            } else {
                this.mPrevButton = (ImageButton) findViewById(C3623R.id.sesl_date_picker_calendar_header_prev_button);
                this.mNextButton = (ImageButton) findViewById(C3623R.id.sesl_date_picker_calendar_header_next_button);
            }
            this.mPrevButton.setOnClickListener(this);
            this.mNextButton.setOnClickListener(this);
            this.mPrevButton.setOnLongClickListener(this);
            this.mNextButton.setOnLongClickListener(this);
            this.mPrevButton.setOnTouchListener(onTouchListener);
            this.mNextButton.setOnTouchListener(onTouchListener);
            this.mPrevButton.setOnKeyListener(onKeyListener);
            this.mNextButton.setOnKeyListener(onKeyListener);
            this.mPrevButton.setOnFocusChangeListener(onFocusChangeListener);
            this.mNextButton.setOnFocusChangeListener(onFocusChangeListener);
            this.mPrevButton.setColorFilter(color2);
            this.mNextButton.setColorFilter(color2);
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackgroundBorderless, typedValue, true);
            this.mBackgroundBorderlessResId = typedValue.resourceId;
            this.mCalendarHeaderLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_header_height);
            this.mCalendarViewPagerHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_height);
            this.mOldCalendarViewPagerWidth = this.mCalendarViewPagerWidth;
            linearLayout.setFocusable(true);
            this.mPrevButton.setNextFocusRightId(C3623R.id.sesl_date_picker_calendar_header_text);
            this.mNextButton.setNextFocusLeftId(C3623R.id.sesl_date_picker_calendar_header_text);
            linearLayout.setNextFocusRightId(C3623R.id.sesl_date_picker_calendar_header_next_button);
            linearLayout.setNextFocusLeftId(C3623R.id.sesl_date_picker_calendar_header_prev_button);
            this.mFirstBlankSpace = findViewById(C3623R.id.sesl_date_picker_between_header_and_weekend);
            this.mFirstBlankSpaceHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_header_and_weekend);
            this.mSecondBlankSpace = findViewById(C3623R.id.sesl_date_picker_between_weekend_and_calender);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_weekend_and_calender);
            this.mSecondBlankSpaceHeight = dimensionPixelOffset;
            this.mDatePickerHeight = this.mCalendarHeaderLayoutHeight + this.mFirstBlankSpaceHeight + this.mDayOfTheWeekLayoutHeight + dimensionPixelOffset + this.mCalendarViewPagerHeight;
            updateSimpleMonthView(true);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById, Key.ROTATION, CALENDAR_HEADER_SPINNER_ROTATE_DEGREE, 0.0f);
            this.mClockwiseAnim = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(350L);
            PathInterpolator pathInterpolator = CALENDAR_HEADER_SPINNER_INTERPOLATOR;
            objectAnimatorOfFloat.setInterpolator(pathInterpolator);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewById, Key.ROTATION, 0.0f, CALENDAR_HEADER_SPINNER_ROTATE_DEGREE);
            this.mAntiClockwiseAnim = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(350L);
            objectAnimatorOfFloat2.setInterpolator(pathInterpolator);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.windowIsFloating, typedValue2, true);
            boolean z = typedValue2.data != 0;
            this.mIsInDialog = z;
            Activity activityScanForActivity = scanForActivity(context);
            if (activityScanForActivity != null && !z) {
                this.mContentFrame = (FrameLayout) activityScanForActivity.getWindow().getDecorView().findViewById(R.id.content);
            } else if (activityScanForActivity == null) {
                Log.e(TAG, "Cannot get window of this context. context:" + context);
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LunarDate {
        public int day;
        boolean isLeapMonth;
        public int month;
        public int year;

        public LunarDate() {
            this.year = 1900;
            this.month = 1;
            this.day = 1;
            this.isLeapMonth = false;
        }

        public void set(int i, int i2, int i4, boolean z) {
            this.year = i;
            this.month = i2;
            this.day = i4;
            this.isLeapMonth = z;
        }

        public LunarDate(int i, int i2, int i4, boolean z) {
            this.year = i;
            this.month = i2;
            this.day = i4;
            this.isLeapMonth = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CalendarPageChangeListener implements ViewPager.OnPageChangeListener {
        private CalendarPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (SeslDatePicker.this.mIsRTL) {
                SeslDatePicker.this.mIsConfigurationChanged = false;
            }
            SeslDatePicker seslDatePicker = SeslDatePicker.this;
            if (seslDatePicker.mIsFromSetLunar) {
                seslDatePicker.mIsFromSetLunar = false;
                return;
            }
            seslDatePicker.mCurrentPosition = i;
            int minMonth = seslDatePicker.getMinMonth() + i;
            int minYear = SeslDatePicker.this.getMinYear() + (minMonth / 12);
            int i2 = minMonth % 12;
            int actualMaximum = SeslDatePicker.this.mCurrentDate.get(5);
            SeslDatePicker seslDatePicker2 = SeslDatePicker.this;
            if (seslDatePicker2.mIsLunar) {
                LunarDate lunarDateByPosition = seslDatePicker2.getLunarDateByPosition(i);
                minYear = lunarDateByPosition.year;
                int i4 = lunarDateByPosition.month;
                SeslDatePicker seslDatePicker3 = SeslDatePicker.this;
                int i5 = seslDatePicker3.mLunarCurrentDay;
                seslDatePicker3.mIsLeapMonth = lunarDateByPosition.isLeapMonth;
                i2 = i4;
                actualMaximum = i5;
            }
            boolean z = minYear != SeslDatePicker.this.mTempDate.get(1);
            SeslDatePicker.this.mTempDate.set(1, minYear);
            SeslDatePicker.this.mTempDate.set(2, i2);
            SeslDatePicker.this.mTempDate.set(5, 1);
            if (actualMaximum > SeslDatePicker.this.mTempDate.getActualMaximum(5)) {
                actualMaximum = SeslDatePicker.this.mTempDate.getActualMaximum(5);
            }
            SeslDatePicker.this.mTempDate.set(5, actualMaximum);
            Message messageObtainMessage = SeslDatePicker.this.mHandler.obtainMessage();
            messageObtainMessage.what = 1000;
            messageObtainMessage.obj = Boolean.valueOf(z);
            SeslDatePicker.this.mHandler.sendMessage(messageObtainMessage);
            Message messageObtainMessage2 = SeslDatePicker.this.mHandler.obtainMessage();
            messageObtainMessage2.what = 1001;
            SeslDatePicker.this.mHandler.sendMessage(messageObtainMessage2);
            SparseArray<SeslSimpleMonthView> sparseArray = SeslDatePicker.this.mCalendarPagerAdapter.views;
            if (sparseArray.get(i) != null) {
                sparseArray.get(i).clearAccessibilityFocus();
                sparseArray.get(i).setImportantForAccessibility(1);
            }
            if (i != 0) {
                int i6 = i - 1;
                if (sparseArray.get(i6) != null) {
                    sparseArray.get(i6).clearAccessibilityFocus();
                    sparseArray.get(i6).setImportantForAccessibility(2);
                }
            }
            if (i != SeslDatePicker.this.mPositionCount - 1) {
                int i7 = i + 1;
                if (sparseArray.get(i7) != null) {
                    sparseArray.get(i7).clearAccessibilityFocus();
                    sparseArray.get(i7).setImportantForAccessibility(2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debugLog(String str) {
    }
}
