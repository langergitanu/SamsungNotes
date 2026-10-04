package androidx.picker.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.picker.C3623R;
import androidx.picker.widget.SeslSimpleMonthView;
import androidx.picker.widget.SeslSpinningDatePickerSpinner;
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
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
public class SeslSpinningDatePicker extends LinearLayout implements SeslSimpleMonthView.OnDayClickListener, View.OnClickListener, View.OnLongClickListener, SeslSimpleMonthView.OnDeactivatedDayClickListener {
    private static final PathInterpolator CALENDAR_HEADER_SPINNER_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
    private static final float CALENDAR_HEADER_SPINNER_ROTATE_DEGREE = -180.0f;
    private static final int CALENDAR_HEADER_SPINNER_ROTATION_DURATION = 350;
    public static final int DATE_MODE_END = 2;
    public static final int DATE_MODE_NONE = 0;
    public static final int DATE_MODE_START = 1;
    public static final int DATE_MODE_WEEK_SELECT = 3;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300;
    private static final int DEFAULT_MONTH_PER_YEAR = 12;
    private static final int DEFAULT_START_YEAR = 1902;
    private static final int LAYOUT_MODE_DEFAULT = 0;
    private static final int LAYOUT_MODE_MULTIPANE = 2;
    private static final int LAYOUT_MODE_PHONE = 1;
    private static final int LEAP_MONTH = 1;
    private static final int MESSAGE_CALENDAR_HEADER_MONTH_BUTTON_SET = 1001;
    private static final int MESSAGE_CALENDAR_HEADER_TEXT_VALUE_SET = 1000;
    private static final int NOT_LEAP_MONTH = 0;
    private static final boolean SESL_DEBUG = false;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final String TAG = "SeslSpinningDatePicker";
    private static final String TAG_CSCFEATURE_CALENDAR_SETCOLOROFDAYS = "CscFeature_Calendar_SetColorOfDays";
    private static final int UAE_MCC = 424;
    private static final String UAE_SALES_CODE = "XSG";
    private static final String UAE_WEEK_DAY_STRING_FEATURE = "XXXXXBR";
    private static final int USE_LOCALE = 0;
    public static final int VIEW_TYPE_CALENDAR = 1;
    public static final int VIEW_TYPE_SPINNER = 0;
    private static PackageManager mPackageManager;
    private int mBackgroundBorderlessResId;
    private final View.OnFocusChangeListener mBtnFocusChangeListener;
    private int mBtnTintColor;
    private RelativeLayout mCalendarHeader;
    private View.OnClickListener mCalendarHeaderClickListener;
    private RelativeLayout mCalendarHeaderLayout;
    private int mCalendarHeaderLayoutHeight;
    private View mCalendarHeaderSpinner;
    private TextView mCalendarHeaderText;
    private int mCalendarHeaderTextColor;
    private LinearLayout mCalendarHeaderTextSpinnerLayout;
    private CalendarPagerAdapter mCalendarPagerAdapter;
    private LinearLayout mCalendarViewLayout;
    private int mCalendarViewMargin;
    private ViewPager mCalendarViewPager;
    private int mCalendarViewPagerHeight;
    private int mCalendarViewPagerWidth;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    private FrameLayout mContentFrame;
    private Context mContext;
    private Calendar mCurrentDate;
    private Locale mCurrentLocale;
    private int mCurrentPosition;
    private int mCurrentViewType;
    private RelativeLayout mCustomButtonLayout;
    private View mCustomButtonView;
    private int mDatePickerHeight;
    private SeslSpinningDatePickerSpinner mDatePickerSpinner;
    private LinearLayout mDateTimePickerLayout;
    private SimpleDateFormat mDayFormatter;
    private LinearLayout mDayOfTheWeekLayout;
    private int mDayOfTheWeekLayoutHeight;
    private int mDayOfTheWeekLayoutWidth;
    private DayOfTheWeekView mDayOfTheWeekView;
    private int mDayOfWeekStart;
    private View mEmptySpaceLeft;
    private View mEmptySpaceRight;
    private Calendar mEndDate;
    private View mFirstBlankSpace;
    private int mFirstBlankSpaceHeight;
    private int mFirstDayOfWeek;
    private Handler mHandler;
    private boolean mIs24HourView;
    private boolean mIsCalendarViewDisabled;
    private boolean mIsCalledFromDeactivatedDayClick;
    private boolean mIsConfigurationChanged;
    private boolean mIsCustomButtonSeparate;
    private boolean mIsEnabled;
    private boolean mIsFarsiLanguage;
    private boolean mIsFirstMeasure;
    private boolean mIsFromSetLunar;
    private boolean mIsHeightSetForDialog;
    private boolean mIsInDialog;
    private int mIsLeapEndMonth;
    private boolean mIsLeapMonth;
    private int mIsLeapStartMonth;
    private boolean mIsLunar;
    private boolean mIsLunarSupported;
    private boolean mIsMarginRightShown;
    private boolean mIsRTL;
    private boolean mIsSimplifiedChinese;
    private boolean mIsTibetanLanguage;
    private boolean mIsWeekRangeSet;
    private int mLayoutMode;
    private boolean mLunarChanged;
    private int mLunarCurrentDay;
    private int mLunarCurrentMonth;
    private int mLunarCurrentYear;
    private int mLunarEndDay;
    private int mLunarEndMonth;
    private int mLunarEndYear;
    private int mLunarStartDay;
    private int mLunarStartMonth;
    private int mLunarStartYear;
    private Calendar mMaxDate;
    private int mMeasureSpecHeight;
    private Calendar mMinDate;
    private int mMode;
    private View.OnKeyListener mMonthBtnKeyListener;
    private View.OnTouchListener mMonthBtnTouchListener;
    private String mMonthViewColor;
    private ImageButton mNextButton;
    private int mNumDays;
    private int mOldCalendarViewPagerWidth;
    private int mOldSelectedDay;
    private OnDateChangedListener mOnDateChangedListener;

    @RequiresApi(24)
    private SeslSpinningDatePickerSpinner.OnSpinnerDateClickListener mOnSpinnerDateClickListener;
    private OnViewTypeChangedListener mOnViewTypeChangedListener;
    private int mPadding;
    PathClassLoader mPathClassLoader;
    private LinearLayout mPickerView;
    private int mPickerViewHeight;
    private int mPositionCount;
    private ImageButton mPrevButton;

    @Nullable
    private ObjectAnimator mRotationAnim;
    private View mSecondBlankSpace;
    private int mSecondBlankSpaceHeight;
    private Object mSolarLunarConverter;
    private Object mSolarLunarTables;
    private Calendar mStartDate;
    private boolean mSupportShortSpinnerHeight;
    private Calendar mTempDate;
    private Calendar mTempMinMaxDate;
    private int[] mTotalMonthCountWithLeap;
    private ValidationCallback mValidationCallback;
    private ViewAnimator mViewAnimator;
    private int mWeekStart;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CalendarPagerAdapter extends PagerAdapter {
        SparseArray<SeslSimpleMonthView> views = new SparseArray<>();

        public CalendarPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
            SeslSpinningDatePicker.this.debugLog("destroyItem : " + i);
            ((ViewPager) view).removeView((View) obj);
            this.views.remove(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(View view) {
            SeslSpinningDatePicker.this.debugLog("finishUpdate");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            int maxYear = SeslSpinningDatePicker.this.getMaxYear() - SeslSpinningDatePicker.this.getMinYear();
            SeslSpinningDatePicker seslSpinningDatePicker = SeslSpinningDatePicker.this;
            seslSpinningDatePicker.mPositionCount = (maxYear * 12) + (seslSpinningDatePicker.getMaxMonth() - SeslSpinningDatePicker.this.getMinMonth()) + 1;
            if (SeslSpinningDatePicker.this.mIsLunar) {
                SeslSpinningDatePicker seslSpinningDatePicker2 = SeslSpinningDatePicker.this;
                seslSpinningDatePicker2.mPositionCount = seslSpinningDatePicker2.getTotalMonthCountWithLeap(seslSpinningDatePicker2.getMaxYear());
            }
            return SeslSpinningDatePicker.this.mPositionCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i) {
            boolean z;
            SeslSimpleMonthView seslSimpleMonthView = new SeslSimpleMonthView(SeslSpinningDatePicker.this.mContext);
            SeslSpinningDatePicker.this.debugLog("instantiateItem : " + i);
            seslSimpleMonthView.setClickable(true);
            seslSimpleMonthView.setOnDayClickListener(SeslSpinningDatePicker.this);
            seslSimpleMonthView.setOnDeactivatedDayClickListener(SeslSpinningDatePicker.this);
            seslSimpleMonthView.setTextColor(SeslSpinningDatePicker.this.mMonthViewColor);
            int minMonth = SeslSpinningDatePicker.this.getMinMonth() + i;
            int minYear = SeslSpinningDatePicker.this.getMinYear() + (minMonth / 12);
            int i2 = minMonth % 12;
            if (SeslSpinningDatePicker.this.mIsLunar) {
                LunarDate lunarDateByPosition = SeslSpinningDatePicker.this.getLunarDateByPosition(i);
                minYear = lunarDateByPosition.year;
                int i4 = lunarDateByPosition.month;
                z = lunarDateByPosition.isLeapMonth;
                i2 = i4;
            } else {
                z = false;
            }
            int i5 = -1;
            int i6 = (SeslSpinningDatePicker.this.mCurrentDate.get(1) == minYear && SeslSpinningDatePicker.this.mCurrentDate.get(2) == i2) ? SeslSpinningDatePicker.this.mCurrentDate.get(5) : -1;
            if (!SeslSpinningDatePicker.this.mIsLunar) {
                i5 = i6;
            } else if (SeslSpinningDatePicker.this.mLunarCurrentYear == minYear && SeslSpinningDatePicker.this.mLunarCurrentMonth == i2 && SeslSpinningDatePicker.this.mIsLeapMonth == z) {
                i5 = SeslSpinningDatePicker.this.mLunarCurrentDay;
            }
            if (SeslSpinningDatePicker.this.mIsLunarSupported) {
                seslSimpleMonthView.setLunar(SeslSpinningDatePicker.this.mIsLunar, z, SeslSpinningDatePicker.this.mPathClassLoader);
            }
            int i7 = SeslSpinningDatePicker.this.mStartDate.get(1);
            int i8 = SeslSpinningDatePicker.this.mStartDate.get(2);
            int i9 = SeslSpinningDatePicker.this.mStartDate.get(5);
            int i10 = SeslSpinningDatePicker.this.mEndDate.get(1);
            int i11 = SeslSpinningDatePicker.this.mEndDate.get(2);
            int i12 = SeslSpinningDatePicker.this.mEndDate.get(5);
            if (SeslSpinningDatePicker.this.mIsLunar) {
                i7 = SeslSpinningDatePicker.this.mLunarStartYear;
                i8 = SeslSpinningDatePicker.this.mLunarStartMonth;
                i9 = SeslSpinningDatePicker.this.mLunarStartDay;
                i10 = SeslSpinningDatePicker.this.mLunarEndYear;
                i11 = SeslSpinningDatePicker.this.mLunarEndMonth;
                i12 = SeslSpinningDatePicker.this.mLunarEndDay;
            }
            int i13 = i10;
            int i14 = i9;
            int i15 = i5;
            int i16 = minYear;
            seslSimpleMonthView.setMonthParams(i15, i2, i16, SeslSpinningDatePicker.this.getFirstDayOfWeek(), 1, 31, SeslSpinningDatePicker.this.mMinDate, SeslSpinningDatePicker.this.mMaxDate, i7, i8, i14, SeslSpinningDatePicker.this.mIsLeapStartMonth, i13, i11, i12, SeslSpinningDatePicker.this.mIsLeapEndMonth, SeslSpinningDatePicker.this.mMode);
            if (i == 0) {
                seslSimpleMonthView.setFirstMonth();
            }
            if (i == SeslSpinningDatePicker.this.mPositionCount - 1) {
                seslSimpleMonthView.setLastMonth();
            }
            if (SeslSpinningDatePicker.this.mIsLunar) {
                if (i != 0 && SeslSpinningDatePicker.this.getLunarDateByPosition(i - 1).isLeapMonth) {
                    seslSimpleMonthView.setPrevMonthLeap();
                }
                if (i != SeslSpinningDatePicker.this.mPositionCount - 1 && SeslSpinningDatePicker.this.getLunarDateByPosition(i + 1).isLeapMonth) {
                    seslSimpleMonthView.setNextMonthLeap();
                }
            }
            SeslSpinningDatePicker.this.mNumDays = seslSimpleMonthView.getNumDays();
            SeslSpinningDatePicker.this.mWeekStart = seslSimpleMonthView.getWeekStart();
            ((ViewPager) view).addView(seslSimpleMonthView, 0);
            this.views.put(i, seslSimpleMonthView);
            return seslSimpleMonthView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view != null && view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Parcelable saveState() {
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(View view) {
            SeslSpinningDatePicker.this.debugLog("startUpdate");
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
                SeslSpinningDatePicker.this.mCalendarViewPager.setCurrentItem(SeslSpinningDatePicker.this.mCurrentPosition + 1);
            } else {
                SeslSpinningDatePicker.this.mCalendarViewPager.setCurrentItem(SeslSpinningDatePicker.this.mCurrentPosition - 1);
            }
            SeslSpinningDatePicker.this.postDelayed(this, 300L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DayOfTheWeekView extends View {
        private static final float DAY_OF_WEEK_ALPHA = 0.8f;
        private static final int FONT_WEIGHT_REGULAR = 400;
        private int[] mDayColorSet;
        private Calendar mDayLabelCalendar;
        private String mDefaultWeekdayFeatureString;
        private Paint mMonthDayLabelPaint;
        private int mNormalDayTextColor;
        private int mSaturdayTextColor;
        private int mSundayTextColor;
        private String mWeekdayFeatureString;

        public DayOfTheWeekView(Context context, TypedArray typedArray) {
            super(context);
            this.mDayColorSet = new int[7];
            this.mDefaultWeekdayFeatureString = "XXXXXXR";
            this.mDayLabelCalendar = Calendar.getInstance();
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C3623R.dimen.sesl_date_picker_month_day_label_text_size);
            this.mNormalDayTextColor = typedArray.getColor(C3623R.styleable.DatePicker_dayTextColor, resources.getColor(C3623R.color.sesl_date_picker_normal_text_color_light));
            this.mSundayTextColor = typedArray.getColor(C3623R.styleable.DatePicker_sundayTextColor, resources.getColor(C3623R.color.sesl_date_picker_sunday_text_color_light));
            this.mSaturdayTextColor = ResourcesCompat.getColor(resources, C3623R.color.sesl_date_picker_saturday_week_text_color_light, null);
            if (SeslSpinningDatePicker.this.mMonthViewColor != null) {
                this.mWeekdayFeatureString = SeslSpinningDatePicker.this.mMonthViewColor;
            } else {
                this.mWeekdayFeatureString = SeslCscFeatureReflector.getString(SeslSpinningDatePicker.TAG_CSCFEATURE_CALENDAR_SETCOLOROFDAYS, this.mDefaultWeekdayFeatureString);
            }
            Paint paint = new Paint();
            this.mMonthDayLabelPaint = paint;
            paint.setAntiAlias(true);
            this.mMonthDayLabelPaint.setColor(this.mNormalDayTextColor);
            this.mMonthDayLabelPaint.setTextSize(dimensionPixelSize);
            if (Build.VERSION.SDK_INT >= 33) {
                this.mMonthDayLabelPaint.setTypeface(Typeface.create(Typeface.create("sec", 0), 400, false));
            } else {
                this.mMonthDayLabelPaint.setTypeface(Typeface.create("sec-roboto-light", 0));
            }
            this.mMonthDayLabelPaint.setTextAlign(Paint.Align.CENTER);
            this.mMonthDayLabelPaint.setStyle(Paint.Style.FILL);
            this.mMonthDayLabelPaint.setFakeBoldText(false);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            int i;
            int i2;
            super.onDraw(canvas);
            if (SeslSpinningDatePicker.this.mNumDays == 0) {
                return;
            }
            int i4 = (SeslSpinningDatePicker.this.mDayOfTheWeekLayoutHeight * 2) / 3;
            int i5 = SeslSpinningDatePicker.this.mDayOfTheWeekLayoutWidth / (SeslSpinningDatePicker.this.mNumDays * 2);
            for (int i6 = 0; i6 < SeslSpinningDatePicker.this.mNumDays; i6++) {
                char cCharAt = this.mWeekdayFeatureString.charAt(i6);
                this.mDayColorSet[(i6 + 2) % SeslSpinningDatePicker.this.mNumDays] = cCharAt != 'B' ? cCharAt != 'R' ? ColorUtils.setAlphaComponent(this.mNormalDayTextColor, 204) : ColorUtils.setAlphaComponent(this.mSundayTextColor, 255) : ColorUtils.setAlphaComponent(this.mSaturdayTextColor, 255);
            }
            for (int i7 = 0; i7 < SeslSpinningDatePicker.this.mNumDays; i7++) {
                int i8 = (SeslSpinningDatePicker.this.mWeekStart + i7) % SeslSpinningDatePicker.this.mNumDays;
                this.mDayLabelCalendar.set(7, i8);
                String upperCase = SeslSpinningDatePicker.this.mDayFormatter.format(this.mDayLabelCalendar.getTime()).toUpperCase();
                if (SeslSpinningDatePicker.this.mIsRTL) {
                    i = ((((SeslSpinningDatePicker.this.mNumDays - 1) - i7) * 2) + 1) * i5;
                    i2 = SeslSpinningDatePicker.this.mPadding;
                } else {
                    i = ((i7 * 2) + 1) * i5;
                    i2 = SeslSpinningDatePicker.this.mPadding;
                }
                int i9 = i2 + i;
                this.mMonthDayLabelPaint.setColor(this.mDayColorSet[i8]);
                canvas.drawText(upperCase, i9, i4, this.mMonthDayLabelPaint);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class LunarUtils {
        private static PathClassLoader mClassLoader;

        public static PathClassLoader getPathClassLoader(Context context) {
            if (mClassLoader == null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(SeslSpinningDatePicker.getCalendarPackageName(), 128);
                    if (applicationInfo == null) {
                        Log.e(SeslSpinningDatePicker.TAG, "getPathClassLoader, appInfo is null");
                        return null;
                    }
                    final String str = applicationInfo.sourceDir;
                    if (str == null || TextUtils.isEmpty(str)) {
                        Log.e(SeslSpinningDatePicker.TAG, "getPathClassLoader, calendar package source directory is null or empty");
                        return null;
                    }
                    mClassLoader = (PathClassLoader) AccessController.doPrivileged(new PrivilegedAction<PathClassLoader>() { // from class: androidx.picker.widget.SeslSpinningDatePicker.LunarUtils.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.security.PrivilegedAction
                        public PathClassLoader run() {
                            return new PathClassLoader(str, ClassLoader.getSystemClassLoader());
                        }
                    });
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e(SeslSpinningDatePicker.TAG, "getPathClassLoader, calendar package name not found");
                    return null;
                }
            }
            return mClassLoader;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDateChangedListener {
        void onDateChanged(SeslSpinningDatePicker seslSpinningDatePicker, int i, int i2, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnViewTypeChangedListener {
        void onViewTypeChanged(SeslSpinningDatePicker seslSpinningDatePicker);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ValidationCallback {
        void onValidationChanged(boolean z);
    }

    public SeslSpinningDatePicker(Context context) {
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
        this.mCalendarViewLayout.addView(this.mCustomButtonLayout, 0);
        this.mDatePickerHeight += this.mCalendarHeaderLayoutHeight;
    }

    private void calculateContentHeight() {
        if (getLayoutParams().height == -2 || getMeasuredHeight() <= this.mDatePickerHeight) {
            int measuredHeight = this.mMeasureSpecHeight;
            FrameLayout frameLayout = this.mContentFrame;
            if (frameLayout != null) {
                measuredHeight = frameLayout.getMeasuredHeight();
            }
            updateViewType(measuredHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCalendar(Calendar calendar, int i, int i2, int i4) {
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
        Calendar calendar2 = Calendar.getInstance(locale);
        if (calendar != null) {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        calendar2.set(11, 12);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
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
        if (this.mIsTibetanLanguage) {
            return new SimpleDateFormat("y LLLL", Locale.getDefault()).format(calendar.getTime());
        }
        StringBuilder sb = new StringBuilder(50);
        Formatter formatter = new Formatter(sb, this.mCurrentLocale);
        sb.setLength(0);
        long timeInMillis = calendar.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), formatter, timeInMillis, timeInMillis, 36, Time.getCurrentTimezone()).toString();
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
        } catch (NoClassDefFoundError e) {
            Log.e(TAG, "msg : " + e.getMessage());
        }
        return null;
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

    private boolean isTibetanLanguage() {
        Locale locale = Locale.getDefault();
        return locale != null && "bo".equals(locale.getLanguage());
    }

    private int makeMeasureSpec(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        int i4 = getResources().getConfiguration().smallestScreenWidthDp;
        int dimensionPixelSize = mode == Integer.MIN_VALUE ? i4 >= 600 ? getResources().getDimensionPixelSize(C3623R.dimen.sesl_date_picker_dialog_min_width) : (int) (TypedValue.applyDimension(1, i4, getResources().getDisplayMetrics()) + 0.5f) : View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            if (i4 < 600 || this.mLayoutMode != 0) {
                this.mCalendarViewPagerWidth = this.mViewAnimator.getMeasuredWidth() - (this.mCalendarViewMargin * 2);
                this.mDayOfTheWeekLayoutWidth = this.mViewAnimator.getMeasuredWidth() - (this.mCalendarViewMargin * 2);
            } else {
                int i5 = this.mCalendarViewMargin;
                this.mCalendarViewPagerWidth = dimensionPixelSize - (i5 * 2);
                this.mDayOfTheWeekLayoutWidth = dimensionPixelSize - (i5 * 2);
            }
            return View.MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (mode != 1073741824) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(mode, "Unknown measure mode: "));
        }
        if (i4 < 600 || this.mLayoutMode != 0) {
            this.mCalendarViewPagerWidth = this.mViewAnimator.getMeasuredWidth() - (this.mCalendarViewMargin * 2);
            this.mDayOfTheWeekLayoutWidth = this.mViewAnimator.getMeasuredWidth() - (this.mCalendarViewMargin * 2);
            return i;
        }
        int i6 = this.mCalendarViewMargin;
        this.mCalendarViewPagerWidth = dimensionPixelSize - (i6 * 2);
        this.mDayOfTheWeekLayoutWidth = dimensionPixelSize - (i6 * 2);
        return i;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllCallbacks() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
            new Handler().postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslSpinningDatePicker.10
                @Override // java.lang.Runnable
                public void run() {
                    SeslSpinningDatePicker.this.mCalendarViewPager.setCurrentItem(SeslSpinningDatePicker.this.mCurrentPosition, false);
                }
            }, 200L);
        }
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
        this.mCalendarViewLayout.removeView(this.mCustomButtonLayout);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextButtonProperties(float f, boolean z) {
        this.mNextButton.setAlpha(f);
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
        this.mPrevButton.setAlpha(f);
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
        this.mCalendarViewPager.setCurrentItem(minMonth, z);
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
        if (this.mSupportShortSpinnerHeight) {
            return;
        }
        Activity activityScanForActivity = scanForActivity(this.mContext);
        if (this.mIsCalendarViewDisabled) {
            setCurrentViewType(0);
            SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner = this.mDatePickerSpinner;
            if (seslSpinningDatePickerSpinner != null) {
                seslSpinningDatePickerSpinner.setOnSpinnerDateClickListener(null);
                return;
            }
            return;
        }
        if (activityScanForActivity == null || !activityScanForActivity.isInMultiWindowMode()) {
            SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner2 = this.mDatePickerSpinner;
            if (seslSpinningDatePickerSpinner2 == null || seslSpinningDatePickerSpinner2.getOnSpinnerDateClickListener() != null) {
                return;
            }
            this.mDatePickerSpinner.setOnSpinnerDateClickListener(this.mOnSpinnerDateClickListener);
            return;
        }
        if (i >= this.mDatePickerHeight) {
            SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner3 = this.mDatePickerSpinner;
            if (seslSpinningDatePickerSpinner3 != null) {
                seslSpinningDatePickerSpinner3.setOnSpinnerDateClickListener(this.mOnSpinnerDateClickListener);
                return;
            }
            return;
        }
        setCurrentViewType(0);
        SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner4 = this.mDatePickerSpinner;
        if (seslSpinningDatePickerSpinner4 != null) {
            seslSpinningDatePickerSpinner4.setOnSpinnerDateClickListener(null);
        }
    }

    public void disableCalendarView() {
        this.mIsCalendarViewDisabled = true;
        setCurrentViewType(0);
        SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner = this.mDatePickerSpinner;
        if (seslSpinningDatePickerSpinner != null) {
            seslSpinningDatePickerSpinner.setOnSpinnerDateClickListener(null);
        }
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

    public Calendar getMaxDateCalendar() {
        return this.mMaxDate;
    }

    public int getMaxDay() {
        return this.mMaxDate.get(5);
    }

    public int getMaxMonth() {
        return this.mMaxDate.get(2);
    }

    public int getMaxYear() {
        return this.mMaxDate.get(1);
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    @NonNull
    public Calendar getMinDateCalendar() {
        return this.mMinDate;
    }

    public int getMinDay() {
        return this.mMinDate.get(5);
    }

    public int getMinMonth() {
        return this.mMinDate.get(2);
    }

    public int getMinYear() {
        return this.mMinDate.get(1);
    }

    public int getMonth() {
        return this.mIsLunar ? this.mLunarCurrentMonth : this.mCurrentDate.get(2);
    }

    @NonNull
    public Calendar getSelectedDay() {
        return this.mCurrentDate;
    }

    @NonNull
    public Calendar getStartDate() {
        return this.mStartDate;
    }

    public boolean getWrapSelectorWheel() {
        return this.mDatePickerSpinner.getWrapSelectorWheel();
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
        if (this.mIsLunar) {
            this.mDatePickerSpinner.updateDate(i, i2, i4);
        } else {
            this.mDatePickerSpinner.setValue(this.mCurrentDate);
        }
        this.mOnDateChangedListener = onDateChangedListener;
        updateSimpleMonthView(false);
        onDateChanged();
        this.mDatePickerSpinner.setMinValue(this.mMinDate);
        this.mDatePickerSpinner.setMaxValue(this.mMaxDate);
        if (this.mCurrentViewType == 0) {
            this.mCalendarViewLayout.setVisibility(8);
            this.mCalendarViewLayout.setEnabled(false);
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
                int i = this.mCurrentPosition;
                if (i == this.mPositionCount - 1) {
                    return;
                }
                this.mCalendarViewPager.setCurrentItem(i + 1);
                return;
            }
            int i2 = this.mCurrentPosition;
            if (i2 == 0) {
                return;
            }
            this.mCalendarViewPager.setCurrentItem(i2 - 1);
            return;
        }
        if (id == C3623R.id.sesl_date_picker_calendar_header_next_button) {
            if (this.mIsRTL) {
                int i4 = this.mCurrentPosition;
                if (i4 == 0) {
                    return;
                }
                this.mCalendarViewPager.setCurrentItem(i4 - 1);
                return;
            }
            int i5 = this.mCurrentPosition;
            if (i5 == this.mPositionCount - 1) {
                return;
            }
            this.mCalendarViewPager.setCurrentItem(i5 + 1);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int dimensionPixelOffset;
        super.onConfigurationChanged(configuration);
        this.mIsRTL = isRTL();
        this.mIsFarsiLanguage = isFarsiLanguage();
        this.mIsTibetanLanguage = isTibetanLanguage();
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
        this.mDateTimePickerLayout.setGravity(1);
        this.mIsFirstMeasure = true;
        this.mCalendarHeaderLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_header_height);
        this.mCalendarViewPagerHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_height);
        this.mDayOfTheWeekLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_day_height);
        this.mFirstBlankSpaceHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_header_and_weekend);
        this.mSecondBlankSpaceHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_weekend_and_calender);
        if (this.mSupportShortSpinnerHeight) {
            dimensionPixelOffset = -2;
        } else {
            dimensionPixelOffset = resources.getDimensionPixelOffset(this.mIsHeightSetForDialog ? C3623R.dimen.sesl_spinning_date_picker_height_dialog : C3623R.dimen.sesl_spinning_date_picker_height);
        }
        this.mPickerViewHeight = dimensionPixelOffset;
        this.mDatePickerHeight = this.mCalendarHeaderLayoutHeight + this.mFirstBlankSpaceHeight + this.mDayOfTheWeekLayoutHeight + this.mSecondBlankSpaceHeight + this.mCalendarViewPagerHeight;
        if (this.mIsRTL) {
            this.mIsConfigurationChanged = true;
        }
    }

    @Override // androidx.picker.widget.SeslSimpleMonthView.OnDayClickListener
    public void onDayClick(@NonNull SeslSimpleMonthView seslSimpleMonthView, int i, int i2, int i4) {
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
        setCurrentViewType(0);
        this.mIsCalledFromDeactivatedDayClick = false;
    }

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
            clearCalendar(this.mStartDate, i, i2, i4);
            if (this.mIsLunar) {
                this.mLunarStartYear = i;
                this.mLunarStartMonth = i2;
                this.mLunarStartDay = i4;
                this.mIsLeapStartMonth = this.mIsLeapMonth ? 1 : 0;
            }
        } else if (i5 == 2) {
            clearCalendar(this.mEndDate, i, i2, i4);
            if (this.mIsLunar) {
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
        this.mDatePickerSpinner.updateDate(i, i2, i4);
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
        boolean z3 = lunarDateByPosition.isLeapMonth;
        this.mIsLeapMonth = z3;
        this.mDatePickerSpinner.setLunar(this.mIsLunar, z3);
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
    @SuppressLint({"DrawAllocation"})
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
        this.mCalendarHeaderLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mCalendarHeaderLayoutHeight));
        this.mDayOfTheWeekLayout.setLayoutParams(new LinearLayout.LayoutParams(this.mDayOfTheWeekLayoutWidth, this.mDayOfTheWeekLayoutHeight));
        this.mDayOfTheWeekView.setLayoutParams(new LinearLayout.LayoutParams(this.mDayOfTheWeekLayoutWidth, this.mDayOfTheWeekLayoutHeight));
        this.mCalendarViewPager.setLayoutParams(new LinearLayout.LayoutParams(this.mCalendarViewPagerWidth, this.mCalendarViewPagerHeight));
        this.mPickerView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mPickerViewHeight));
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
        this.mDatePickerSpinner.setValue(this.mCurrentDate);
        if (this.mIsLunar) {
            this.mLunarCurrentYear = savedState.getSelectedYear();
            this.mLunarCurrentMonth = savedState.getSelectedMonth();
            this.mLunarCurrentDay = savedState.getSelectedDay();
        }
        this.mMinDate.setTimeInMillis(savedState.getMinDate());
        this.mMaxDate.setTimeInMillis(savedState.getMaxDate());
    }

    @Override // android.view.View
    @Nullable
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
        return new SavedState(parcelableOnSaveInstanceState, i, i2, i5, this.mMinDate.getTimeInMillis(), this.mMaxDate.getTimeInMillis(), -1);
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

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d9  */
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
                this.mCalendarHeaderSpinner.setRotation(0.0f);
                this.mCalendarPagerAdapter.notifyDataSetChanged();
                this.mViewAnimator.setDisplayedChild(1);
                this.mPickerView.setEnabled(false);
                this.mPickerView.setVisibility(8);
                this.mCalendarViewLayout.setEnabled(true);
                this.mCalendarViewLayout.setVisibility(0);
                this.mCurrentViewType = i;
                requestLayout();
                Message messageObtainMessage = this.mHandler.obtainMessage();
                messageObtainMessage.what = 1000;
                this.mHandler.sendMessage(messageObtainMessage);
            } else {
                z = false;
            }
        } else if (this.mCurrentViewType != i) {
            int i8 = this.mMode;
            if (i8 != 1) {
                if (i8 != 2) {
                    if (this.mIsLunar) {
                        i2 = this.mLunarCurrentYear;
                        i6 = this.mLunarCurrentMonth;
                        i7 = this.mLunarCurrentDay;
                        this.mDatePickerSpinner.updateDate(i2, i6, i7);
                        this.mViewAnimator.setDisplayedChild(0);
                        this.mPickerView.setEnabled(true);
                        this.mPickerView.setVisibility(0);
                        this.mCalendarViewLayout.setVisibility(8);
                        this.mCurrentViewType = i;
                        Message messageObtainMessage2 = this.mHandler.obtainMessage();
                        messageObtainMessage2.what = 1000;
                        this.mHandler.sendMessage(messageObtainMessage2);
                    } else {
                        i2 = this.mCurrentDate.get(1);
                        i4 = this.mCurrentDate.get(2);
                        i5 = this.mCurrentDate.get(5);
                        int i9 = i4;
                        i7 = i5;
                        i6 = i9;
                        this.mDatePickerSpinner.updateDate(i2, i6, i7);
                        this.mViewAnimator.setDisplayedChild(0);
                        this.mPickerView.setEnabled(true);
                        this.mPickerView.setVisibility(0);
                        this.mCalendarViewLayout.setVisibility(8);
                        this.mCurrentViewType = i;
                        Message messageObtainMessage22 = this.mHandler.obtainMessage();
                        messageObtainMessage22.what = 1000;
                        this.mHandler.sendMessage(messageObtainMessage22);
                    }
                } else if (this.mIsLunar) {
                    i2 = this.mLunarEndYear;
                    i6 = this.mLunarEndMonth;
                    i7 = this.mLunarEndDay;
                    this.mDatePickerSpinner.updateDate(i2, i6, i7);
                    this.mViewAnimator.setDisplayedChild(0);
                    this.mPickerView.setEnabled(true);
                    this.mPickerView.setVisibility(0);
                    this.mCalendarViewLayout.setVisibility(8);
                    this.mCurrentViewType = i;
                    Message messageObtainMessage222 = this.mHandler.obtainMessage();
                    messageObtainMessage222.what = 1000;
                    this.mHandler.sendMessage(messageObtainMessage222);
                } else {
                    i2 = this.mEndDate.get(1);
                    i4 = this.mEndDate.get(2);
                    i5 = this.mEndDate.get(5);
                    int i92 = i4;
                    i7 = i5;
                    i6 = i92;
                    this.mDatePickerSpinner.updateDate(i2, i6, i7);
                    this.mViewAnimator.setDisplayedChild(0);
                    this.mPickerView.setEnabled(true);
                    this.mPickerView.setVisibility(0);
                    this.mCalendarViewLayout.setVisibility(8);
                    this.mCurrentViewType = i;
                    Message messageObtainMessage2222 = this.mHandler.obtainMessage();
                    messageObtainMessage2222.what = 1000;
                    this.mHandler.sendMessage(messageObtainMessage2222);
                }
            } else if (this.mIsLunar) {
                i2 = this.mLunarStartYear;
                i6 = this.mLunarStartMonth;
                i7 = this.mLunarStartDay;
                this.mDatePickerSpinner.updateDate(i2, i6, i7);
                this.mViewAnimator.setDisplayedChild(0);
                this.mPickerView.setEnabled(true);
                this.mPickerView.setVisibility(0);
                this.mCalendarViewLayout.setVisibility(8);
                this.mCurrentViewType = i;
                Message messageObtainMessage22222 = this.mHandler.obtainMessage();
                messageObtainMessage22222.what = 1000;
                this.mHandler.sendMessage(messageObtainMessage22222);
            } else {
                i2 = this.mStartDate.get(1);
                i4 = this.mStartDate.get(2);
                i5 = this.mStartDate.get(5);
                int i922 = i4;
                i7 = i5;
                i6 = i922;
                this.mDatePickerSpinner.updateDate(i2, i6, i7);
                this.mViewAnimator.setDisplayedChild(0);
                this.mPickerView.setEnabled(true);
                this.mPickerView.setVisibility(0);
                this.mCalendarViewLayout.setVisibility(8);
                this.mCurrentViewType = i;
                Message messageObtainMessage222222 = this.mHandler.obtainMessage();
                messageObtainMessage222222.what = 1000;
                this.mHandler.sendMessage(messageObtainMessage222222);
            }
        }
        OnViewTypeChangedListener onViewTypeChangedListener = this.mOnViewTypeChangedListener;
        if (onViewTypeChangedListener != null && z) {
            onViewTypeChangedListener.onViewTypeChanged(this);
        }
        Message messageObtainMessage3 = this.mHandler.obtainMessage();
        messageObtainMessage3.what = 1001;
        this.mHandler.sendMessage(messageObtainMessage3);
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
            this.mDatePickerSpinner.updateDate(i2, i4, i5);
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
            this.mDatePickerSpinner.updateDate(i15, i16, i17);
        }
        if (this.mCurrentViewType == 0) {
            this.mPickerView.setVisibility(0);
            this.mPickerView.setEnabled(true);
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

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (isEnabled() == z) {
            return;
        }
        super.setEnabled(z);
        this.mDatePickerSpinner.setEnabled(z);
        this.mIsEnabled = z;
    }

    public void setFirstDayOfWeek(int i) {
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
        }
        this.mFirstDayOfWeek = i;
    }

    @Override // android.widget.LinearLayout
    public void setGravity(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mDatePickerSpinner.getLayoutParams();
        layoutParams.gravity = i;
        this.mDatePickerSpinner.setLayoutParams(layoutParams);
    }

    public void setHeightForDialog() {
        this.mIsHeightSetForDialog = true;
        this.mPickerViewHeight = getResources().getDimensionPixelOffset(C3623R.dimen.sesl_spinning_date_picker_height_dialog);
        this.mPickerView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mPickerViewHeight));
        this.mSupportShortSpinnerHeight = false;
    }

    public void setIs24HourView(@NonNull Boolean bool) {
        if (bool == null) {
            return;
        }
        this.mIs24HourView = bool.booleanValue();
        this.mEmptySpaceLeft.setVisibility((!bool.booleanValue() || this.mIsMarginRightShown) ? 8 : 0);
    }

    public void setLunar(boolean z, boolean z2) {
        if (!this.mIsLunarSupported || this.mIsLunar == z) {
            return;
        }
        this.mIsLunar = z;
        this.mIsLeapMonth = z2;
        this.mDatePickerSpinner.setLunar(z, z2);
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
            this.mDatePickerSpinner.setLunar(false, false);
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

    public void setMargin(int i, int i2, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDatePickerSpinner.getLayoutParams();
        marginLayoutParams.setMargins(i, i2, i4, i5);
        this.mDatePickerSpinner.setLayoutParams(marginLayoutParams);
    }

    public void setMaxDate(long j) {
        this.mTempMinMaxDate.setTimeInMillis(j);
        this.mTempMinMaxDate.set(11, 12);
        this.mTempMinMaxDate.set(12, 0);
        this.mTempMinMaxDate.set(13, 0);
        this.mTempMinMaxDate.set(14, 0);
        if (this.mTempMinMaxDate.get(1) != this.mMaxDate.get(1) || this.mTempMinMaxDate.get(6) == this.mMaxDate.get(6)) {
            if (this.mIsLunar) {
                setTotalMonthCountWithLeap();
            }
            if (this.mCurrentDate.after(this.mTempMinMaxDate)) {
                this.mCurrentDate.setTimeInMillis(j);
                onDateChanged();
            }
            this.mMaxDate.setTimeInMillis(j);
            this.mDatePickerSpinner.setMaxValue(this.mMaxDate);
            this.mCalendarPagerAdapter.notifyDataSetChanged();
            this.mHandler.postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslSpinningDatePicker.9
                @Override // java.lang.Runnable
                public void run() {
                    SeslSpinningDatePicker.this.updateSimpleMonthView(false);
                }
            }, 10L);
        }
    }

    public void setMinDate(long j) {
        this.mTempMinMaxDate.setTimeInMillis(j);
        this.mTempMinMaxDate.set(11, 12);
        this.mTempMinMaxDate.set(12, 0);
        this.mTempMinMaxDate.set(13, 0);
        this.mTempMinMaxDate.set(14, 0);
        if (this.mTempMinMaxDate.get(1) != this.mMinDate.get(1) || this.mTempMinMaxDate.get(6) == this.mMinDate.get(6)) {
            if (this.mIsLunar) {
                setTotalMonthCountWithLeap();
            }
            if (this.mCurrentDate.before(this.mTempMinMaxDate)) {
                this.mCurrentDate.setTimeInMillis(j);
                this.mDatePickerSpinner.setValue(this.mCurrentDate);
                onDateChanged();
            }
            this.mMinDate.setTimeInMillis(j);
            this.mDatePickerSpinner.setMinValue(this.mMinDate);
            this.mCalendarPagerAdapter.notifyDataSetChanged();
            this.mHandler.postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslSpinningDatePicker.8
                @Override // java.lang.Runnable
                public void run() {
                    SeslSpinningDatePicker.this.updateSimpleMonthView(false);
                }
            }, 10L);
        }
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

    public void setSupportShortSpinnerHeight() {
        this.mSupportShortSpinnerHeight = true;
        this.mPickerViewHeight = -2;
        this.mPickerView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mPickerViewHeight));
        this.mIsHeightSetForDialog = false;
    }

    public void setViewAnimatorForCalendarView(ViewAnimator viewAnimator) {
        this.mViewAnimator.removeViewAt(1);
        this.mViewAnimator = viewAnimator;
        viewAnimator.addView(this.mCalendarViewLayout, 1, new LinearLayout.LayoutParams(-1, -2));
    }

    public void setWrapSelectorWheel(boolean z) {
        this.mDatePickerSpinner.setWrapSelectorWheel(z);
    }

    public void showMarginRight(@NonNull Boolean bool) {
        this.mIsMarginRightShown = bool.booleanValue();
        int i = 8;
        this.mEmptySpaceRight.setVisibility(bool.booleanValue() ? 0 : 8);
        View view = this.mEmptySpaceLeft;
        if (this.mIs24HourView && !this.mIsMarginRightShown) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public void updateDate(int i, int i2, int i4) {
        SeslSimpleMonthView seslSimpleMonthView;
        SeslSimpleMonthView seslSimpleMonthView2;
        this.mTempDate.set(1, i);
        this.mTempDate.set(2, i2);
        Calendar calendar = this.mTempDate;
        calendar.set(5, i4 > calendar.getActualMaximum(5) ? this.mTempDate.getActualMaximum(5) : i4);
        this.mCurrentDate = getCalendarForLocale(this.mTempDate, this.mCurrentLocale);
        if (this.mIsLunar) {
            this.mLunarCurrentYear = i;
            this.mLunarCurrentMonth = i2;
            this.mLunarCurrentDay = i4;
        }
        int i5 = this.mMode;
        if (i5 == 1) {
            clearCalendar(this.mStartDate, i, i2, i4);
            if (this.mIsLunar) {
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
            clearCalendar(this.mEndDate, i, i2, i4);
            if (this.mIsLunar) {
                this.mLunarEndYear = i;
                this.mLunarEndMonth = i2;
                this.mLunarEndDay = i4;
            }
        }
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
        SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner = this.mDatePickerSpinner;
        if (seslSpinningDatePickerSpinner != null) {
            seslSpinningDatePickerSpinner.updateDate(i, i2, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.picker.widget.SeslSpinningDatePicker.SavedState.1
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

        private SavedState(Parcelable parcelable, int i, int i2, int i4, long j, long j2, int i5) {
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

    public SeslSpinningDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public SeslSpinningDatePicker(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public SeslSpinningDatePicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsConfigurationChanged = false;
        this.mIsFirstMeasure = true;
        this.mIsEnabled = true;
        this.mIsCalendarViewDisabled = false;
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
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: androidx.picker.widget.SeslSpinningDatePicker.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    return;
                }
                SeslSpinningDatePicker.this.removeAllCallbacks();
            }
        };
        this.mBtnFocusChangeListener = onFocusChangeListener;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: androidx.picker.widget.SeslSpinningDatePicker.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i4 = message.what;
                if (i4 == 1000) {
                    if (SeslSpinningDatePicker.this.mTempDate.get(1) > SeslSpinningDatePicker.this.getMaxYear() || SeslSpinningDatePicker.this.mTempDate.get(1) < SeslSpinningDatePicker.this.getMinYear()) {
                        return;
                    }
                    SeslSpinningDatePicker seslSpinningDatePicker = SeslSpinningDatePicker.this;
                    String monthAndYearString = seslSpinningDatePicker.getMonthAndYearString(seslSpinningDatePicker.mTempDate);
                    SeslSpinningDatePicker.this.mCalendarHeaderText.setText(monthAndYearString);
                    String string = SeslSpinningDatePicker.this.mContext.getString(SeslSpinningDatePicker.this.mCurrentViewType == 1 ? C3623R.string.sesl_date_picker_switch_to_wheel_description : C3623R.string.sesl_date_picker_switch_to_calendar_description);
                    SeslSpinningDatePicker.this.mCalendarHeaderText.setContentDescription(monthAndYearString + SQLKeyword.COMMA + string);
                    return;
                }
                if (i4 != 1001) {
                    return;
                }
                if (SeslSpinningDatePicker.this.mCurrentViewType == 0) {
                    SeslSpinningDatePicker.this.setPrevButtonProperties(0.0f, false);
                    SeslSpinningDatePicker.this.setNextButtonProperties(0.0f, false);
                    int field_TYPE_NONE = SeslHoverPopupWindowReflector.getField_TYPE_NONE();
                    if (field_TYPE_NONE != -1) {
                        SeslViewReflector.semSetHoverPopupType(SeslSpinningDatePicker.this.mPrevButton, field_TYPE_NONE);
                        SeslViewReflector.semSetHoverPopupType(SeslSpinningDatePicker.this.mNextButton, field_TYPE_NONE);
                        return;
                    }
                    return;
                }
                int field_TYPE_TOOLTIP = SeslHoverPopupWindowReflector.getField_TYPE_TOOLTIP();
                if (field_TYPE_TOOLTIP != -1) {
                    SeslViewReflector.semSetHoverPopupType(SeslSpinningDatePicker.this.mPrevButton, field_TYPE_TOOLTIP);
                    SeslViewReflector.semSetHoverPopupType(SeslSpinningDatePicker.this.mNextButton, field_TYPE_TOOLTIP);
                }
                if (SeslSpinningDatePicker.this.mCurrentPosition > 0 && SeslSpinningDatePicker.this.mCurrentPosition < SeslSpinningDatePicker.this.mPositionCount - 1) {
                    SeslSpinningDatePicker.this.setPrevButtonProperties(1.0f, true);
                    SeslSpinningDatePicker.this.setNextButtonProperties(1.0f, true);
                    return;
                }
                if (SeslSpinningDatePicker.this.mPositionCount == 1) {
                    SeslSpinningDatePicker.this.setPrevButtonProperties(0.4f, false);
                    SeslSpinningDatePicker.this.setNextButtonProperties(0.4f, false);
                    SeslSpinningDatePicker.this.removeAllCallbacks();
                } else if (SeslSpinningDatePicker.this.mCurrentPosition == 0) {
                    SeslSpinningDatePicker.this.setPrevButtonProperties(0.4f, false);
                    SeslSpinningDatePicker.this.setNextButtonProperties(1.0f, true);
                    SeslSpinningDatePicker.this.removeAllCallbacks();
                } else if (SeslSpinningDatePicker.this.mCurrentPosition == SeslSpinningDatePicker.this.mPositionCount - 1) {
                    SeslSpinningDatePicker.this.setPrevButtonProperties(1.0f, true);
                    SeslSpinningDatePicker.this.setNextButtonProperties(0.4f, false);
                    SeslSpinningDatePicker.this.removeAllCallbacks();
                }
            }
        };
        this.mMonthBtnTouchListener = new View.OnTouchListener() { // from class: androidx.picker.widget.SeslSpinningDatePicker.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return false;
                }
                SeslSpinningDatePicker.this.removeAllCallbacks();
                return false;
            }
        };
        this.mMonthBtnKeyListener = new View.OnKeyListener() { // from class: androidx.picker.widget.SeslSpinningDatePicker.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                if (SeslSpinningDatePicker.this.mIsRTL) {
                    SeslSpinningDatePicker.this.mIsConfigurationChanged = false;
                }
                if (keyEvent.getAction() == 1 || keyEvent.getAction() == 3) {
                    SeslSpinningDatePicker.this.removeAllCallbacks();
                }
                return false;
            }
        };
        this.mCalendarHeaderClickListener = new View.OnClickListener() { // from class: androidx.picker.widget.SeslSpinningDatePicker.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SeslSpinningDatePicker.this.setCurrentViewType(0);
                SeslSpinningDatePicker.this.mRotationAnim.start();
            }
        };
        this.mOnSpinnerDateClickListener = new SeslSpinningDatePickerSpinner.OnSpinnerDateClickListener() { // from class: androidx.picker.widget.SeslSpinningDatePicker.6
            @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.OnSpinnerDateClickListener
            public void onSpinnerDateClicked(Calendar calendar, LunarDate lunarDate) {
                SeslSpinningDatePicker seslSpinningDatePicker = SeslSpinningDatePicker.this;
                seslSpinningDatePicker.clearCalendar(seslSpinningDatePicker.mCurrentDate, calendar.get(1), calendar.get(2), calendar.get(5));
                if (lunarDate != null) {
                    SeslSpinningDatePicker.this.mLunarCurrentYear = lunarDate.year;
                    SeslSpinningDatePicker.this.mLunarCurrentMonth = lunarDate.month;
                    SeslSpinningDatePicker.this.mLunarCurrentDay = lunarDate.day;
                    SeslSpinningDatePicker.this.mIsLeapMonth = lunarDate.isLeapMonth;
                }
                SeslSpinningDatePicker.this.setCurrentViewType(1);
            }
        };
        this.mContext = context;
        this.mCurrentLocale = Locale.getDefault();
        this.mIsRTL = isRTL();
        this.mIsTibetanLanguage = isTibetanLanguage();
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
        this.mLayoutMode = typedArrayObtainStyledAttributes.getInt(C3623R.styleable.DatePicker_pickerLayoutMode, 0);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        int i4 = this.mLayoutMode;
        if (i4 == 1) {
            layoutInflater.inflate(C3623R.layout.sesl_spinning_date_picker_phone, (ViewGroup) this, true);
        } else if (i4 == 2) {
            layoutInflater.inflate(C3623R.layout.sesl_spinning_date_picker_multipane, (ViewGroup) this, true);
        } else {
            layoutInflater.inflate(C3623R.layout.sesl_spinning_date_picker, (ViewGroup) this, true);
        }
        this.mCalendarViewLayout = (LinearLayout) layoutInflater.inflate(C3623R.layout.sesl_spinning_date_picker_calendar, (ViewGroup) null, false);
        int i5 = typedArrayObtainStyledAttributes.getInt(C3623R.styleable.DatePicker_android_firstDayOfWeek, 0);
        if (i5 != 0) {
            setFirstDayOfWeek(i5);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mMonthViewColor = getMonthViewColorStringForSpecific();
        TypedArray typedArrayObtainStyledAttributes2 = this.mContext.obtainStyledAttributes(attributeSet, C3623R.styleable.DatePicker, i, i2);
        try {
            this.mDayOfTheWeekView = new DayOfTheWeekView(this.mContext, typedArrayObtainStyledAttributes2);
            this.mCalendarHeaderTextColor = typedArrayObtainStyledAttributes2.getColor(C3623R.styleable.DatePicker_dayNumberTextColor, resources.getColor(C3623R.color.sesl_date_picker_normal_day_number_text_color_light));
            this.mBtnTintColor = typedArrayObtainStyledAttributes2.getColor(C3623R.styleable.DatePicker_buttonTintColor, resources.getColor(C3623R.color.sesl_date_picker_button_tint_color_light));
            typedArrayObtainStyledAttributes2.recycle();
            this.mCalendarPagerAdapter = new CalendarPagerAdapter();
            ViewPager viewPager = (ViewPager) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar);
            this.mCalendarViewPager = viewPager;
            viewPager.setAdapter(this.mCalendarPagerAdapter);
            this.mCalendarViewPager.setOnPageChangeListener(new CalendarPageChangeListener());
            this.mCalendarViewPager.seslSetSupportedMouseWheelEvent(true);
            this.mPadding = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_padding);
            this.mCalendarHeader = (RelativeLayout) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header);
            this.mCalendarHeaderTextSpinnerLayout = (LinearLayout) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_text_spinner_layout);
            this.mCalendarHeaderSpinner = this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_spinner);
            TextView textView = (TextView) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_text);
            this.mCalendarHeaderText = textView;
            textView.setTextColor(this.mCalendarHeaderTextColor);
            this.mStartDate = getCalendarForLocale(this.mCurrentDate, this.mCurrentLocale);
            this.mEndDate = getCalendarForLocale(this.mCurrentDate, this.mCurrentLocale);
            this.mPickerView = (LinearLayout) findViewById(C3623R.id.sesl_spinning_date_picker_view);
            this.mEmptySpaceLeft = findViewById(C3623R.id.sesl_spinning_date_time_picker_empty_view_left);
            this.mEmptySpaceRight = findViewById(C3623R.id.sesl_spinning_date_picker_margin_view_center);
            this.mIsMarginRightShown = false;
            SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner = (SeslSpinningDatePickerSpinner) findViewById(C3623R.id.sesl_spinning_date_picker_spinner_view);
            this.mDatePickerSpinner = seslSpinningDatePickerSpinner;
            seslSpinningDatePickerSpinner.setOnSpinnerDateClickListener(this.mOnSpinnerDateClickListener);
            this.mDatePickerSpinner.setMinValue(this.mMinDate);
            this.mDatePickerSpinner.setMaxValue(this.mMaxDate);
            this.mDatePickerSpinner.setValue(this.mCurrentDate);
            this.mDatePickerSpinner.setOnValueChangedListener(new SeslSpinningDatePickerSpinner.OnValueChangeListener() { // from class: androidx.picker.widget.SeslSpinningDatePicker.7
                @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.OnValueChangeListener
                public void onValueChange(SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner2, Calendar calendar, Calendar calendar2, boolean z, LunarDate lunarDate) {
                    SeslSpinningDatePicker.this.mCurrentDate = (Calendar) calendar2.clone();
                    int i6 = calendar2.get(1);
                    int i7 = calendar2.get(2);
                    int i8 = calendar2.get(5);
                    if (lunarDate != null) {
                        i6 = lunarDate.year;
                        i7 = lunarDate.month;
                        i8 = lunarDate.day;
                    }
                    if (SeslSpinningDatePicker.this.mIsLunar) {
                        SeslSpinningDatePicker.this.mLunarCurrentYear = i6;
                        SeslSpinningDatePicker.this.mLunarCurrentMonth = i7;
                        SeslSpinningDatePicker.this.mLunarCurrentDay = i8;
                        SeslSpinningDatePicker.this.mIsLeapMonth = z;
                    }
                    int i9 = SeslSpinningDatePicker.this.mMode;
                    if (i9 == 1) {
                        SeslSpinningDatePicker seslSpinningDatePicker = SeslSpinningDatePicker.this;
                        seslSpinningDatePicker.clearCalendar(seslSpinningDatePicker.mStartDate, i6, i7, i8);
                        if (SeslSpinningDatePicker.this.mIsLunar) {
                            SeslSpinningDatePicker.this.mLunarStartYear = i6;
                            SeslSpinningDatePicker.this.mLunarStartMonth = i7;
                            SeslSpinningDatePicker.this.mLunarStartDay = i8;
                            SeslSpinningDatePicker.this.mIsLeapStartMonth = z ? 1 : 0;
                        }
                    } else if (i9 != 2) {
                        SeslSpinningDatePicker seslSpinningDatePicker2 = SeslSpinningDatePicker.this;
                        seslSpinningDatePicker2.clearCalendar(seslSpinningDatePicker2.mStartDate, i6, i7, i8);
                        SeslSpinningDatePicker seslSpinningDatePicker3 = SeslSpinningDatePicker.this;
                        seslSpinningDatePicker3.clearCalendar(seslSpinningDatePicker3.mEndDate, i6, i7, i8);
                        if (SeslSpinningDatePicker.this.mIsLunar) {
                            SeslSpinningDatePicker.this.mLunarStartYear = i6;
                            SeslSpinningDatePicker.this.mLunarStartMonth = i7;
                            SeslSpinningDatePicker.this.mLunarStartDay = i8;
                            SeslSpinningDatePicker.this.mIsLeapStartMonth = z ? 1 : 0;
                            SeslSpinningDatePicker.this.mLunarEndYear = i6;
                            SeslSpinningDatePicker.this.mLunarEndMonth = i7;
                            SeslSpinningDatePicker.this.mLunarEndDay = i8;
                            SeslSpinningDatePicker.this.mIsLeapEndMonth = z ? 1 : 0;
                            SeslSpinningDatePicker.this.mDatePickerSpinner.setLunar(SeslSpinningDatePicker.this.mIsLunar, SeslSpinningDatePicker.this.mIsLeapMonth);
                        }
                    } else {
                        SeslSpinningDatePicker seslSpinningDatePicker4 = SeslSpinningDatePicker.this;
                        seslSpinningDatePicker4.clearCalendar(seslSpinningDatePicker4.mEndDate, i6, i7, i8);
                        if (SeslSpinningDatePicker.this.mIsLunar) {
                            SeslSpinningDatePicker.this.mLunarEndYear = i6;
                            SeslSpinningDatePicker.this.mLunarEndMonth = i7;
                            SeslSpinningDatePicker.this.mLunarEndDay = i8;
                            SeslSpinningDatePicker.this.mIsLeapEndMonth = z ? 1 : 0;
                        }
                    }
                    SeslSpinningDatePicker seslSpinningDatePicker5 = SeslSpinningDatePicker.this;
                    seslSpinningDatePicker5.onValidationChanged(true ^ seslSpinningDatePicker5.mStartDate.after(SeslSpinningDatePicker.this.mEndDate));
                    SeslSpinningDatePicker.this.updateSimpleMonthView(false);
                    if (SeslSpinningDatePicker.this.mMode == 3 && SeslSpinningDatePicker.this.mIsWeekRangeSet) {
                        SeslSpinningDatePicker seslSpinningDatePicker6 = SeslSpinningDatePicker.this;
                        seslSpinningDatePicker6.updateStartEndDateRange(seslSpinningDatePicker6.getDayOffset(), i6, i7, i8);
                    }
                    SeslSpinningDatePicker.this.onDateChanged();
                }
            });
            ViewAnimator viewAnimator = (ViewAnimator) findViewById(C3623R.id.sesl_spinning_date_picker_view_animator);
            this.mViewAnimator = viewAnimator;
            viewAnimator.addView(this.mCalendarViewLayout, 1, new LinearLayout.LayoutParams(-1, -2));
            this.mCurrentViewType = 0;
            this.mCalendarHeaderTextSpinnerLayout.setOnClickListener(this.mCalendarHeaderClickListener);
            this.mDayOfTheWeekLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_day_height);
            this.mCalendarViewPagerWidth = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_width);
            this.mCalendarViewMargin = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_margin);
            this.mDayOfTheWeekLayoutWidth = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_width);
            LinearLayout linearLayout = (LinearLayout) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_day_of_the_week);
            this.mDayOfTheWeekLayout = linearLayout;
            linearLayout.addView(this.mDayOfTheWeekView);
            this.mDateTimePickerLayout = (LinearLayout) findViewById(C3623R.id.sesl_spinning_date_time_picker_layout);
            this.mCalendarHeaderLayout = (RelativeLayout) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_layout);
            if (this.mIsRTL) {
                this.mPrevButton = (ImageButton) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_next_button);
                this.mNextButton = (ImageButton) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_prev_button);
                this.mPrevButton.setContentDescription(this.mContext.getString(C3623R.string.sesl_date_picker_decrement_month));
                this.mNextButton.setContentDescription(this.mContext.getString(C3623R.string.sesl_date_picker_increment_month));
            } else {
                this.mPrevButton = (ImageButton) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_prev_button);
                this.mNextButton = (ImageButton) this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_calendar_header_next_button);
            }
            this.mPrevButton.setOnClickListener(this);
            this.mNextButton.setOnClickListener(this);
            this.mPrevButton.setOnLongClickListener(this);
            this.mNextButton.setOnLongClickListener(this);
            this.mPrevButton.setOnTouchListener(this.mMonthBtnTouchListener);
            this.mNextButton.setOnTouchListener(this.mMonthBtnTouchListener);
            this.mPrevButton.setOnKeyListener(this.mMonthBtnKeyListener);
            this.mNextButton.setOnKeyListener(this.mMonthBtnKeyListener);
            this.mPrevButton.setOnFocusChangeListener(onFocusChangeListener);
            this.mNextButton.setOnFocusChangeListener(onFocusChangeListener);
            this.mPrevButton.setColorFilter(this.mBtnTintColor);
            this.mNextButton.setColorFilter(this.mBtnTintColor);
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackgroundBorderless, typedValue, true);
            this.mBackgroundBorderlessResId = typedValue.resourceId;
            this.mCalendarHeaderLayoutHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_header_height);
            this.mCalendarViewPagerHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_height);
            this.mOldCalendarViewPagerWidth = this.mCalendarViewPagerWidth;
            this.mPickerViewHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_spinning_date_picker_height);
            this.mCalendarHeaderTextSpinnerLayout.setFocusable(true);
            this.mPrevButton.setNextFocusRightId(C3623R.id.sesl_date_picker_calendar_header_text);
            this.mNextButton.setNextFocusLeftId(C3623R.id.sesl_date_picker_calendar_header_text);
            this.mCalendarHeaderTextSpinnerLayout.setNextFocusRightId(C3623R.id.sesl_date_picker_calendar_header_next_button);
            this.mCalendarHeaderTextSpinnerLayout.setNextFocusLeftId(C3623R.id.sesl_date_picker_calendar_header_prev_button);
            this.mFirstBlankSpace = this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_between_header_and_weekend);
            this.mFirstBlankSpaceHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_header_and_weekend);
            this.mSecondBlankSpace = this.mCalendarViewLayout.findViewById(C3623R.id.sesl_date_picker_between_weekend_and_calender);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_gap_between_weekend_and_calender);
            this.mSecondBlankSpaceHeight = dimensionPixelOffset;
            this.mDatePickerHeight = this.mCalendarHeaderLayoutHeight + this.mFirstBlankSpaceHeight + this.mDayOfTheWeekLayoutHeight + dimensionPixelOffset + this.mCalendarViewPagerHeight;
            updateSimpleMonthView(true);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mCalendarHeaderSpinner, Key.ROTATION, 0.0f, CALENDAR_HEADER_SPINNER_ROTATE_DEGREE);
            this.mRotationAnim = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(350L);
            this.mRotationAnim.setInterpolator(CALENDAR_HEADER_SPINNER_INTERPOLATOR);
            TypedValue typedValue2 = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.windowIsFloating, typedValue2, true);
            this.mIsInDialog = typedValue2.data != 0;
            Activity activityScanForActivity = scanForActivity(this.mContext);
            if (activityScanForActivity != null && !this.mIsInDialog) {
                this.mContentFrame = (FrameLayout) activityScanForActivity.getWindow().getDecorView().findViewById(R.id.content);
            } else if (activityScanForActivity == null) {
                Log.e(TAG, "Cannot get window of this context. context:" + this.mContext);
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
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
            if (SeslSpinningDatePicker.this.mIsRTL) {
                SeslSpinningDatePicker.this.mIsConfigurationChanged = false;
            }
            if (SeslSpinningDatePicker.this.mIsFromSetLunar) {
                SeslSpinningDatePicker.this.mIsFromSetLunar = false;
                return;
            }
            SeslSpinningDatePicker.this.mCurrentPosition = i;
            int minMonth = SeslSpinningDatePicker.this.getMinMonth() + i;
            int minYear = SeslSpinningDatePicker.this.getMinYear() + (minMonth / 12);
            int i2 = minMonth % 12;
            int actualMaximum = SeslSpinningDatePicker.this.mCurrentDate.get(5);
            if (SeslSpinningDatePicker.this.mIsLunar) {
                LunarDate lunarDateByPosition = SeslSpinningDatePicker.this.getLunarDateByPosition(i);
                minYear = lunarDateByPosition.year;
                int i4 = lunarDateByPosition.month;
                int i5 = SeslSpinningDatePicker.this.mLunarCurrentDay;
                SeslSpinningDatePicker.this.mIsLeapMonth = lunarDateByPosition.isLeapMonth;
                SeslSpinningDatePicker.this.mDatePickerSpinner.setLunar(SeslSpinningDatePicker.this.mIsLunar, SeslSpinningDatePicker.this.mIsLeapMonth);
                i2 = i4;
                actualMaximum = i5;
            }
            boolean z = minYear != SeslSpinningDatePicker.this.mTempDate.get(1);
            SeslSpinningDatePicker.this.mTempDate.set(1, minYear);
            SeslSpinningDatePicker.this.mTempDate.set(2, i2);
            SeslSpinningDatePicker.this.mTempDate.set(5, 1);
            if (actualMaximum > SeslSpinningDatePicker.this.mTempDate.getActualMaximum(5)) {
                actualMaximum = SeslSpinningDatePicker.this.mTempDate.getActualMaximum(5);
            }
            SeslSpinningDatePicker.this.mTempDate.set(5, actualMaximum);
            Message messageObtainMessage = SeslSpinningDatePicker.this.mHandler.obtainMessage();
            messageObtainMessage.what = 1000;
            messageObtainMessage.obj = Boolean.valueOf(z);
            SeslSpinningDatePicker.this.mHandler.sendMessage(messageObtainMessage);
            Message messageObtainMessage2 = SeslSpinningDatePicker.this.mHandler.obtainMessage();
            messageObtainMessage2.what = 1001;
            SeslSpinningDatePicker.this.mHandler.sendMessage(messageObtainMessage2);
            SparseArray<SeslSimpleMonthView> sparseArray = SeslSpinningDatePicker.this.mCalendarPagerAdapter.views;
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
            if (i != SeslSpinningDatePicker.this.mPositionCount - 1) {
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
