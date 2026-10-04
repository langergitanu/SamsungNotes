package androidx.picker.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.picker.C3623R;
import androidx.picker.widget.SeslDatePicker;
import androidx.reflect.feature.SeslCscFeatureReflector;
import androidx.reflect.lunarcalendar.SeslFeatureReflector;
import androidx.reflect.lunarcalendar.SeslLunarDateUtilsReflector;
import androidx.reflect.lunarcalendar.SeslSolarLunarConverterReflector;
import androidx.reflect.view.SeslViewReflector;
import com.google.android.material.timepicker.TimeModel;
import dalvik.system.PathClassLoader;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SeslSimpleMonthView extends View {
    protected static final int DEFAULT_MONTH_LINE = 6;
    private static final int DEFAULT_NUM_DAYS = 7;
    private static final String DEFAULT_WEEK_DAY_STRING_FEATURE = "XXXXXXR";
    private static final int DEFAULT_WEEK_START = 1;
    private static final float DIVISOR_FOR_CIRCLE_POSITION_Y = 2.7f;
    private static final int FONT_WEIGHT_REGULAR = 400;
    private static final int FONT_WEIGHT_SEMIBOLD = 600;
    private static final int LEAP_MONTH = 1;
    private static final float LEAP_MONTH_WEIGHT = 0.5f;
    private static final int MAX_MONTH_VIEW_ID = 42;
    private static final int MIN_HEIGHT = 10;
    private static final int MONTH_WEIGHT = 100;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final String TAG = "SeslSimpleMonthView";
    private static final String TAG_CSCFEATURE_CALENDAR_SETCOLOROFDAYS = "CscFeature_Calendar_SetColorOfDays";
    private static final int YEAR_WEIGHT = 10000;
    protected Paint mAbnormalSelectedDayPaint;
    protected final int mAbnormalStartEndDateBackgroundAlpha;
    protected final Calendar mCalendar;
    protected int mCalendarWidth;
    protected final Context mContext;

    @Nullable
    protected SeslDatePicker.DateValidator mDateValidator;
    protected final int[] mDayColorSet;
    protected int mDayNumberDisabledAlpha;
    protected Paint mDayNumberPaint;
    protected Paint mDayNumberSelectedPaint;
    protected int mDayOfWeekStart;
    protected int mDaySelectedCircleSize;
    protected int mDaySelectedCircleStroke;
    protected int mEnabledDayEnd;
    protected int mEnabledDayStart;
    protected int mEndDay;
    protected int mEndMonth;
    protected int mEndYear;
    protected Paint mHcfEnabledDayNumberPaint;
    protected boolean mIsFirstMonth;
    protected boolean mIsHcfEnabled;
    protected boolean mIsLastMonth;
    protected int mIsLeapEndMonth;
    protected boolean mIsLeapMonth;
    protected int mIsLeapStartMonth;
    protected boolean mIsLunar;
    protected boolean mIsNextMonthLeap;
    protected boolean mIsPrevMonthLeap;
    protected boolean mIsRTL;
    protected int mLastAccessibilityFocusedView;
    protected boolean mLockAccessibilityDelegate;
    protected boolean mLostAccessibilityFocus;
    protected Calendar mMaxDate;
    protected Calendar mMinDate;
    protected int mMiniDayNumberTextSize;
    protected int mMode;
    protected int mMonth;
    protected int mNormalTextColor;
    protected int mNumCells;
    protected final int mNumDays;
    protected OnDayClickListener mOnDayClickListener;
    protected OnDeactivatedDayClickListener mOnDeactivatedDayClickListener;
    protected int mPadding;
    protected PathClassLoader mPathClassLoader;
    protected final int mPrevNextMonthDayNumberAlpha;
    protected final int mSaturdayTextColor;
    protected int mSelectedDay;
    protected final int mSelectedDayColor;
    protected int mSelectedDayNumberTextColor;
    protected Object mSolarLunarConverter;
    protected int mStartDay;
    protected int mStartMonth;
    protected int mStartYear;
    protected final int mSundayTextColor;
    protected Calendar mTempDate;
    protected Calendar mTodayDate;
    protected Paint mTodayDateMarkPaint;
    protected final MonthViewTouchHelper mTouchHelper;
    protected int mWeekHeight;
    protected int mWeekStart;
    protected int mYear;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MonthViewTouchHelper extends ExploreByTouchHelper {
        private final Calendar mTempCalendar;
        private final Rect mTempRect;

        public MonthViewTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
            this.mTempCalendar = Calendar.getInstance();
        }

        private int getDayPositionInWeek(int i) {
            int dayOfWeekStart = ((SeslSimpleMonthView.this.getDayOfWeekStart() - 1) + i) % 7;
            if (dayOfWeekStart == 0) {
                return 7;
            }
            return dayOfWeekStart;
        }

        private void getItemBounds(int i, Rect rect) {
            SeslSimpleMonthView seslSimpleMonthView = SeslSimpleMonthView.this;
            int i2 = seslSimpleMonthView.mPadding;
            int i4 = (int) (seslSimpleMonthView.mContext.getResources().getDisplayMetrics().density * (-1.0f));
            SeslSimpleMonthView seslSimpleMonthView2 = SeslSimpleMonthView.this;
            int i5 = seslSimpleMonthView2.mWeekHeight;
            int i6 = seslSimpleMonthView2.mCalendarWidth / 7;
            int iFindDayOffset = (i - 1) + seslSimpleMonthView2.findDayOffset();
            int i7 = iFindDayOffset / 7;
            int i8 = iFindDayOffset % 7;
            int i9 = (i7 * i5) + i4;
            SeslSimpleMonthView seslSimpleMonthView3 = SeslSimpleMonthView.this;
            if (seslSimpleMonthView3.mMode == 3) {
                rect.set(0, i9, seslSimpleMonthView3.mCalendarWidth, i5 + i9);
            } else {
                int i10 = (i8 * i6) + i2;
                rect.set(i10, i9, i6 + i10, i5 + i9);
            }
        }

        private CharSequence getItemDescription(int i) {
            Calendar calendar = this.mTempCalendar;
            SeslSimpleMonthView seslSimpleMonthView = SeslSimpleMonthView.this;
            calendar.set(seslSimpleMonthView.mYear, seslSimpleMonthView.mMonth, i);
            String dateTime = DateUtils.formatDateTime(SeslSimpleMonthView.this.mContext, this.mTempCalendar.getTimeInMillis(), 22);
            SeslSimpleMonthView seslSimpleMonthView2 = SeslSimpleMonthView.this;
            if (!seslSimpleMonthView2.mIsLunar || seslSimpleMonthView2.mPathClassLoader == null) {
                return dateTime;
            }
            int i2 = seslSimpleMonthView2.mYear;
            int i4 = seslSimpleMonthView2.mMonth;
            boolean z = seslSimpleMonthView2.mIsLeapMonth;
            if (i <= 0) {
                i4 -= !z ? 1 : 0;
                z = seslSimpleMonthView2.mIsPrevMonthLeap;
                if (i4 < 0) {
                    i2--;
                    i4 = 11;
                }
                i += seslSimpleMonthView2.getDaysInMonthLunar(i4, i2, z);
            } else {
                int i5 = seslSimpleMonthView2.mNumCells;
                if (i > i5) {
                    z = seslSimpleMonthView2.mIsNextMonthLeap;
                    i4 += !z ? 1 : 0;
                    if (i4 > 11) {
                        i2++;
                        i4 = 0;
                    }
                    i -= i5;
                }
            }
            int i6 = i;
            int i7 = i2;
            int i8 = i4;
            boolean z2 = z;
            SeslSimpleMonthView seslSimpleMonthView3 = SeslSimpleMonthView.this;
            SeslSolarLunarConverterReflector.convertLunarToSolar(seslSimpleMonthView3.mPathClassLoader, seslSimpleMonthView3.mSolarLunarConverter, i7, i8, i6, z2);
            SeslSimpleMonthView seslSimpleMonthView4 = SeslSimpleMonthView.this;
            int year = SeslSolarLunarConverterReflector.getYear(seslSimpleMonthView4.mPathClassLoader, seslSimpleMonthView4.mSolarLunarConverter);
            SeslSimpleMonthView seslSimpleMonthView5 = SeslSimpleMonthView.this;
            int month = SeslSolarLunarConverterReflector.getMonth(seslSimpleMonthView5.mPathClassLoader, seslSimpleMonthView5.mSolarLunarConverter);
            SeslSimpleMonthView seslSimpleMonthView6 = SeslSimpleMonthView.this;
            int day = SeslSolarLunarConverterReflector.getDay(seslSimpleMonthView6.mPathClassLoader, seslSimpleMonthView6.mSolarLunarConverter);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(year, month, day);
            SeslSimpleMonthView seslSimpleMonthView7 = SeslSimpleMonthView.this;
            return SeslLunarDateUtilsReflector.buildLunarDateString(seslSimpleMonthView7.mPathClassLoader, calendar2, seslSimpleMonthView7.getContext());
        }

        private String getItemDescriptionWeek(int i, int i2) {
            return String.format(SeslSimpleMonthView.this.getResources().getString(C3623R.string.sesl_date_picker_week_select_content_description), getItemDescription(i), getItemDescription(i2));
        }

        public void clearFocusedVirtualView() {
            int focusedVirtualView = getFocusedVirtualView();
            if (focusedVirtualView != Integer.MIN_VALUE) {
                getAccessibilityNodeProvider(SeslSimpleMonthView.this).performAction(focusedVirtualView, 128, null);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f4) {
            int dayFromLocation = SeslSimpleMonthView.this.getDayFromLocation(f, f4);
            SeslSimpleMonthView seslSimpleMonthView = SeslSimpleMonthView.this;
            if ((seslSimpleMonthView.mIsFirstMonth && dayFromLocation < seslSimpleMonthView.mEnabledDayStart) || (seslSimpleMonthView.mIsLastMonth && dayFromLocation > seslSimpleMonthView.mEnabledDayEnd)) {
                return Integer.MIN_VALUE;
            }
            if (seslSimpleMonthView.mDateValidator != null) {
                seslSimpleMonthView.mTempDate.clear();
                SeslSimpleMonthView seslSimpleMonthView2 = SeslSimpleMonthView.this;
                seslSimpleMonthView2.mTempDate.set(seslSimpleMonthView2.mYear, seslSimpleMonthView2.mMonth, dayFromLocation);
                SeslSimpleMonthView seslSimpleMonthView3 = SeslSimpleMonthView.this;
                if (!seslSimpleMonthView3.mDateValidator.isValid(seslSimpleMonthView3.mTempDate.getTime())) {
                    return Integer.MIN_VALUE;
                }
            }
            int iFindDayOffset = dayFromLocation + SeslSimpleMonthView.this.findDayOffset();
            if (SeslSimpleMonthView.this.mMode != 3) {
                return iFindDayOffset;
            }
            int i = iFindDayOffset + 6;
            return i - (i % 7);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
        @Override // androidx.customview.widget.ExploreByTouchHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void getVisibleVirtualViews(List<Integer> list) {
            int iFindDayOffset = SeslSimpleMonthView.this.findDayOffset();
            for (int i = 1; i <= 42; i++) {
                int i2 = i - iFindDayOffset;
                SeslSimpleMonthView seslSimpleMonthView = SeslSimpleMonthView.this;
                if ((seslSimpleMonthView.mMode != 3 || i % 7 == 0) && ((!seslSimpleMonthView.mIsFirstMonth || i2 >= seslSimpleMonthView.mEnabledDayStart) && (!seslSimpleMonthView.mIsLastMonth || i2 <= seslSimpleMonthView.mEnabledDayEnd))) {
                    if (seslSimpleMonthView.mDateValidator != null) {
                        seslSimpleMonthView.mTempDate.clear();
                        SeslSimpleMonthView seslSimpleMonthView2 = SeslSimpleMonthView.this;
                        seslSimpleMonthView2.mTempDate.set(seslSimpleMonthView2.mYear, seslSimpleMonthView2.mMonth, i2);
                        SeslSimpleMonthView seslSimpleMonthView3 = SeslSimpleMonthView.this;
                        if (seslSimpleMonthView3.mDateValidator.isValid(seslSimpleMonthView3.mTempDate.getTime())) {
                            list.add(Integer.valueOf(i));
                        }
                    }
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            int iFindDayOffset = i - SeslSimpleMonthView.this.findDayOffset();
            SeslSimpleMonthView seslSimpleMonthView = SeslSimpleMonthView.this;
            if ((seslSimpleMonthView.mIsFirstMonth && iFindDayOffset < seslSimpleMonthView.mEnabledDayStart) || (seslSimpleMonthView.mIsLastMonth && iFindDayOffset > seslSimpleMonthView.mEnabledDayEnd)) {
                return true;
            }
            if (iFindDayOffset > 0) {
                int i4 = seslSimpleMonthView.mNumCells;
                if (iFindDayOffset <= i4) {
                    seslSimpleMonthView.onDayClick(seslSimpleMonthView.mYear, seslSimpleMonthView.mMonth, iFindDayOffset);
                } else if (seslSimpleMonthView.mIsLunar) {
                    int i5 = seslSimpleMonthView.mMonth + 1;
                    if (i5 > 11) {
                        seslSimpleMonthView.onDeactivatedDayClick(seslSimpleMonthView.mYear + 1, 0, iFindDayOffset - i4, false);
                    } else {
                        seslSimpleMonthView.onDeactivatedDayClick(seslSimpleMonthView.mYear, i5, iFindDayOffset - i4, false);
                    }
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.clear();
                    SeslSimpleMonthView seslSimpleMonthView2 = SeslSimpleMonthView.this;
                    calendar.set(seslSimpleMonthView2.mYear, seslSimpleMonthView2.mMonth, seslSimpleMonthView2.mNumCells);
                    calendar.add(5, iFindDayOffset - SeslSimpleMonthView.this.mNumCells);
                    SeslSimpleMonthView.this.onDeactivatedDayClick(calendar.get(1), calendar.get(2), calendar.get(5), false);
                }
            } else if (seslSimpleMonthView.mIsLunar) {
                int i6 = seslSimpleMonthView.mMonth;
                boolean z = seslSimpleMonthView.mIsLeapMonth;
                int i7 = i6 - (!z ? 1 : 0);
                if (i7 < 0) {
                    int daysInMonthLunar = seslSimpleMonthView.getDaysInMonthLunar(11, seslSimpleMonthView.mYear - 1, z);
                    SeslSimpleMonthView seslSimpleMonthView3 = SeslSimpleMonthView.this;
                    seslSimpleMonthView3.onDeactivatedDayClick(seslSimpleMonthView3.mYear - 1, i7, daysInMonthLunar + iFindDayOffset, true);
                } else {
                    int daysInMonthLunar2 = seslSimpleMonthView.getDaysInMonthLunar(i7, seslSimpleMonthView.mYear, z);
                    SeslSimpleMonthView seslSimpleMonthView4 = SeslSimpleMonthView.this;
                    seslSimpleMonthView4.onDeactivatedDayClick(seslSimpleMonthView4.mYear, i7, daysInMonthLunar2 + iFindDayOffset, true);
                }
            } else {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.clear();
                SeslSimpleMonthView seslSimpleMonthView5 = SeslSimpleMonthView.this;
                calendar2.set(seslSimpleMonthView5.mYear, seslSimpleMonthView5.mMonth, 1);
                calendar2.add(5, iFindDayOffset - 1);
                SeslSimpleMonthView.this.onDeactivatedDayClick(calendar2.get(1), calendar2.get(2), calendar2.get(5), true);
            }
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            int iFindDayOffset = i - SeslSimpleMonthView.this.findDayOffset();
            if (accessibilityEvent.getEventType() == 32768) {
                SeslSimpleMonthView seslSimpleMonthView = SeslSimpleMonthView.this;
                seslSimpleMonthView.mLastAccessibilityFocusedView = iFindDayOffset;
                seslSimpleMonthView.mLostAccessibilityFocus = false;
            }
            if (accessibilityEvent.getEventType() == 65536) {
                SeslSimpleMonthView seslSimpleMonthView2 = SeslSimpleMonthView.this;
                seslSimpleMonthView2.mLastAccessibilityFocusedView = -1;
                seslSimpleMonthView2.mLostAccessibilityFocus = true;
            }
            if (SeslSimpleMonthView.this.mMode != 3) {
                accessibilityEvent.setContentDescription(getItemDescription(iFindDayOffset));
            } else {
                int dayPositionInWeek = getDayPositionInWeek(iFindDayOffset);
                accessibilityEvent.setContentDescription(getItemDescriptionWeek((iFindDayOffset - dayPositionInWeek) + 1, (7 - dayPositionInWeek) + iFindDayOffset));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int iFindDayOffset = i - SeslSimpleMonthView.this.findDayOffset();
            getItemBounds(iFindDayOffset, this.mTempRect);
            if (SeslSimpleMonthView.this.mMode == 3) {
                int dayPositionInWeek = getDayPositionInWeek(iFindDayOffset);
                accessibilityNodeInfoCompat.setContentDescription(getItemDescriptionWeek((iFindDayOffset - dayPositionInWeek) + 1, (7 - dayPositionInWeek) + iFindDayOffset));
            } else {
                accessibilityNodeInfoCompat.setContentDescription(getItemDescription(iFindDayOffset));
            }
            accessibilityNodeInfoCompat.setBoundsInParent(this.mTempRect);
            accessibilityNodeInfoCompat.addAction(16);
            int i2 = SeslSimpleMonthView.this.mSelectedDay;
            if (i2 == -1 || iFindDayOffset != i2) {
                return;
            }
            accessibilityNodeInfoCompat.addAction(4);
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.setCheckable(true);
            accessibilityNodeInfoCompat.setChecked(true);
        }

        public void setFocusedVirtualView(int i) {
            getAccessibilityNodeProvider(SeslSimpleMonthView.this).performAction(i, 64, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDayClickListener {
        void onDayClick(SeslSimpleMonthView seslSimpleMonthView, int i, int i2, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDeactivatedDayClickListener {
        void onDeactivatedDayClick(SeslSimpleMonthView seslSimpleMonthView, int i, int i2, int i4, boolean z, boolean z2);
    }

    public SeslSimpleMonthView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0323 A[EDGE_INSN: B:279:0x0323->B:150:0x0323 BREAK  A[LOOP:0: B:49:0x00c1->B:149:0x030a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawDays(Canvas canvas) {
        int i;
        boolean z;
        int i2;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        char c;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        String str;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        Canvas canvas2 = canvas;
        int i37 = (this.mWeekHeight * 2) / 3;
        int i38 = this.mCalendarWidth / 14;
        int iFindDayOffset = findDayOffset();
        float f4 = this.mMiniDayNumberTextSize / DIVISOR_FOR_CIRCLE_POSITION_Y;
        int i39 = this.mStartYear;
        float f5 = this.mStartMonth;
        int i40 = this.mStartDay;
        int i41 = this.mEndYear;
        float f6 = this.mEndMonth;
        int i42 = this.mEndDay;
        boolean z4 = this.mIsLunar;
        if (z4 && this.mIsLeapStartMonth == 1) {
            f5 += 0.5f;
        }
        float f7 = f5;
        if (z4 && this.mIsLeapEndMonth == 1) {
            f6 += 0.5f;
        }
        float f8 = f6;
        int i43 = this.mYear;
        float f9 = this.mMonth;
        if (z4 && this.mIsLeapMonth) {
            f9 += 0.5f;
        }
        float f10 = f9;
        int i44 = (i39 * 10000) + ((int) (f7 * 100.0f));
        int i45 = (i41 * 10000) + ((int) (f8 * 100.0f));
        int i46 = 1;
        int i47 = (i43 * 10000) + ((int) (f10 * 100.0f));
        if (this.mMode != 0) {
            i = 2;
            if (i44 + i40 > i45 + i42) {
                z = true;
            }
            if (z) {
                i2 = -1;
                i4 = -1;
            } else if (i39 == i41 && f7 == f8 && i43 == i39 && f10 == f7) {
                i4 = i40;
                i2 = i42;
            } else {
                if (i44 < i47 && i47 < i45 && (i43 != i41 || f10 != f8)) {
                    i2 = this.mNumCells + 1;
                } else if (i43 == i39 && f10 == f7) {
                    i2 = this.mNumCells + 1;
                    i4 = i40;
                } else {
                    if (i43 == i41 && f10 == f8) {
                        i2 = i42;
                    }
                    i2 = -1;
                    i4 = -1;
                }
                i4 = 0;
            }
            this.mIsHcfEnabled = isHighContrastFontEnabled();
            int i48 = iFindDayOffset;
            int i49 = 0;
            i5 = 1;
            z2 = z;
            while (true) {
                z3 = z2;
                f = f4;
                if (i5 <= this.mNumCells) {
                    break;
                }
                if (this.mIsRTL) {
                    i20 = (((6 - i48) * 2) + 1) * i38;
                    i19 = 7;
                    i21 = this.mPadding;
                } else {
                    i19 = 7;
                    i20 = ((i48 * 2) + 1) * i38;
                    i21 = this.mPadding;
                }
                int i50 = i20 + i21;
                int i51 = iFindDayOffset;
                this.mDayNumberPaint.setColor(this.mDayColorSet[(i48 + this.mWeekStart) % 7]);
                if (i5 < this.mEnabledDayStart || i5 > this.mEnabledDayEnd) {
                    this.mDayNumberPaint.setAlpha(this.mDayNumberDisabledAlpha);
                }
                if (this.mDateValidator != null) {
                    this.mTempDate.clear();
                    Calendar calendar = this.mTempDate;
                    int i52 = this.mYear;
                    str = TimeModel.NUMBER_FORMAT;
                    calendar.set(i52, this.mMonth, i5);
                    if (!this.mDateValidator.isValid(this.mTempDate.getTime())) {
                        this.mDayNumberPaint.setAlpha(this.mDayNumberDisabledAlpha);
                    }
                } else {
                    str = TimeModel.NUMBER_FORMAT;
                }
                if (isTodayDate(this.mYear, this.mMonth, i5)) {
                    i22 = i38;
                    canvas2.drawCircle(i50, i37 - f, this.mDaySelectedCircleSize - this.mDaySelectedCircleStroke, this.mTodayDateMarkPaint);
                } else {
                    i22 = i38;
                }
                Paint paint = this.mDayNumberPaint;
                if (this.mIsHcfEnabled && paint.getAlpha() != this.mDayNumberDisabledAlpha) {
                    this.mHcfEnabledDayNumberPaint.setColor(this.mDayNumberPaint.getColor());
                    paint = this.mHcfEnabledDayNumberPaint;
                }
                if (z3) {
                    if ((i39 == i43 && f7 == f10 && i40 == i5 && ((i36 = this.mMode) == i || i36 == 3)) || (i41 == i43 && f8 == f10 && i42 == i5 && ((i33 = this.mMode) == i46 || i33 == 3))) {
                        i32 = i2;
                        canvas2.drawCircle(i50, i37 - f, this.mDaySelectedCircleSize, this.mDayNumberSelectedPaint);
                        paint.setColor(this.mSelectedDayNumberTextColor);
                    } else {
                        i32 = i2;
                    }
                    if ((i41 == i43 && f8 == f10 && i42 == i5 && ((i35 = this.mMode) == 2 || i35 == 3)) || (i39 == i43 && f7 == f10 && i40 == i5 && ((i34 = this.mMode) == 1 || i34 == 3))) {
                        canvas2.drawCircle(i50, i37 - f, this.mDaySelectedCircleSize, this.mAbnormalSelectedDayPaint);
                    }
                    i23 = i37;
                    i24 = i4;
                    i25 = i39;
                    i29 = i40;
                    i30 = i41;
                    i31 = i22;
                    i26 = i32;
                    i27 = i43;
                    i28 = i5;
                } else {
                    int i53 = i2;
                    if (i4 >= i5) {
                        i23 = i37;
                        i24 = i4;
                        i25 = i39;
                        i26 = i53;
                        i27 = i43;
                    } else if (i5 < i53) {
                        float f11 = i50 - i22;
                        float f12 = (i37 - f) - this.mDaySelectedCircleSize;
                        i23 = i37;
                        i24 = i4;
                        i25 = i39;
                        i28 = i5;
                        i27 = i43;
                        i26 = i53;
                        canvas2 = canvas;
                        canvas2.drawRect(f11, f12, (i22 * 2) + f11, (r11 * 2) + f12, this.mDayNumberSelectedPaint);
                        paint.setColor(this.mSelectedDayNumberTextColor);
                        if (i24 == -1 && i24 == i26 && i28 == i24) {
                            canvas2.drawCircle(i50, i23 - f, this.mDaySelectedCircleSize, this.mDayNumberSelectedPaint);
                            paint.setColor(this.mSelectedDayNumberTextColor);
                            i29 = i40;
                            i30 = i41;
                            i31 = i22;
                        } else if (i26 != i28) {
                            float f13 = i23 - f;
                            float f14 = this.mIsRTL ? i50 : i50 - i22;
                            float f15 = f13 - this.mDaySelectedCircleSize;
                            i29 = i40;
                            i31 = i22;
                            i30 = i41;
                            canvas2.drawRect(f14, f15, i31 + f14, (r5 * 2) + f15, this.mDayNumberSelectedPaint);
                            canvas2.drawCircle(i50, f13, this.mDaySelectedCircleSize, this.mDayNumberSelectedPaint);
                            paint.setColor(this.mSelectedDayNumberTextColor);
                        } else {
                            i29 = i40;
                            i30 = i41;
                            i31 = i22;
                            if (i24 == i28) {
                                float f16 = i23 - f;
                                float f17 = this.mIsRTL ? i50 - i31 : i50;
                                float f18 = f16 - this.mDaySelectedCircleSize;
                                canvas2.drawRect(f17, f18, i31 + f17, (r3 * 2) + f18, this.mDayNumberSelectedPaint);
                                canvas2.drawCircle(i50, f16, this.mDaySelectedCircleSize, this.mDayNumberSelectedPaint);
                                paint.setColor(this.mSelectedDayNumberTextColor);
                            }
                        }
                    } else {
                        i23 = i37;
                        i27 = i43;
                        i26 = i53;
                        i24 = i4;
                        i25 = i39;
                    }
                    i28 = i5;
                    if (i24 == -1) {
                        if (i26 != i28) {
                        }
                    }
                }
                if (this.mMode == 0 && i28 == i26) {
                    paint.setColor(this.mSelectedDayNumberTextColor);
                }
                canvas2.drawText(String.format(str, Integer.valueOf(i28)), i50, i23, paint);
                int i54 = i48 + 1;
                if (i54 == i19) {
                    i37 = this.mWeekHeight + i23;
                    i49++;
                    i48 = 0;
                } else {
                    i48 = i54;
                    i37 = i23;
                }
                i5 = i28 + 1;
                i2 = i26;
                i4 = i24;
                i38 = i31;
                i40 = i29;
                z2 = z3;
                f4 = f;
                iFindDayOffset = i51;
                i43 = i27;
                i39 = i25;
                i41 = i30;
                i46 = 1;
                i = 2;
            }
            int i55 = i4;
            int i56 = i38;
            i6 = iFindDayOffset;
            int i57 = i37;
            int i58 = i2;
            if (!this.mIsLastMonth) {
                int i59 = this.mMonth;
                int i60 = i59 + 1;
                int i61 = this.mYear;
                if (i60 > 11) {
                    i11 = i61 + 1;
                    i60 = 0;
                } else {
                    i11 = i61;
                }
                if (this.mIsLunar) {
                    int i62 = (!this.mIsNextMonthLeap ? 1 : 0) + i59;
                    if (i62 > 11) {
                        i13 = i61 + 1;
                        i12 = 0;
                    } else {
                        i12 = i62;
                        i13 = i61;
                    }
                } else {
                    i12 = i60;
                    i13 = i11;
                }
                int i63 = i49;
                int i64 = 1;
                while (i63 != 6) {
                    if (this.mIsRTL) {
                        i14 = (((6 - i48) * 2) + 1) * i56;
                        i15 = this.mPadding;
                    } else {
                        i14 = ((i48 * 2) + 1) * i56;
                        i15 = this.mPadding;
                    }
                    int i65 = i14 + i15;
                    this.mDayNumberPaint.setColor(this.mDayColorSet[(i48 + this.mWeekStart) % 7]);
                    this.mDayNumberPaint.setAlpha(this.mPrevNextMonthDayNumberAlpha);
                    if (this.mMode == 0 || i58 != this.mNumCells + 1) {
                        i16 = i63;
                        i17 = i65;
                        i18 = i55;
                    } else if (i64 < this.mEndDay || !isNextMonthEndMonth()) {
                        i16 = i63;
                        i17 = i65;
                        i18 = i55;
                        float f19 = i17 - i56;
                        float f20 = (i57 - f) - this.mDaySelectedCircleSize;
                        canvas2.drawRect(f19, f20, (i56 * 2) + f19, (r4 * 2) + f20, this.mDayNumberSelectedPaint);
                    } else if (i64 == this.mEndDay) {
                        float f21 = i57 - f;
                        float f22 = this.mIsRTL ? i65 : i65 - i56;
                        float f23 = f21 - this.mDaySelectedCircleSize;
                        i16 = i63;
                        i17 = i65;
                        i18 = i55;
                        canvas2 = canvas;
                        canvas2.drawRect(f22, f23, i56 + f22, (r6 * 2) + f23, this.mDayNumberSelectedPaint);
                        canvas2.drawCircle(i17, f21, this.mDaySelectedCircleSize, this.mDayNumberSelectedPaint);
                    }
                    if (!this.mIsLunar) {
                        this.mTempDate.clear();
                        this.mTempDate.set(i13, i12, i64);
                        if (this.mTempDate.after(this.mMaxDate)) {
                            this.mDayNumberPaint.setAlpha(this.mDayNumberDisabledAlpha);
                        }
                    }
                    if (isTodayDate(i13, i12, i64)) {
                        this.mTodayDateMarkPaint.setAlpha(this.mPrevNextMonthDayNumberAlpha);
                        canvas2.drawCircle(i17, i57 - f, this.mDaySelectedCircleSize - this.mDaySelectedCircleStroke, this.mTodayDateMarkPaint);
                    }
                    Paint paint2 = this.mDayNumberPaint;
                    if (this.mIsHcfEnabled && paint2.getAlpha() != this.mDayNumberDisabledAlpha) {
                        this.mHcfEnabledDayNumberPaint.setColor(this.mDayNumberPaint.getColor());
                        paint2 = this.mHcfEnabledDayNumberPaint;
                    }
                    if (this.mMode != 0 && i58 == this.mNumCells + 1 && (i64 <= this.mEndDay || !isNextMonthEndMonth())) {
                        paint2.setColor(this.mSelectedDayNumberTextColor);
                    }
                    canvas2.drawText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i64)), i17, i57, paint2);
                    int i66 = i48 + 1;
                    if (i66 == 7) {
                        i57 += this.mWeekHeight;
                        i63 = i16 + 1;
                        i48 = 0;
                    } else {
                        i48 = i66;
                        i63 = i16;
                    }
                    i64++;
                    i55 = i18;
                }
            }
            int i67 = i55;
            if (i6 > 0 || this.mIsFirstMonth) {
            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.clear();
            calendar2.set(this.mYear, this.mMonth, 1);
            int i68 = i6;
            calendar2.add(5, -i68);
            int i69 = this.mMonth - 1;
            int i70 = this.mYear;
            if (i69 < 0) {
                i70--;
                i69 = 11;
            }
            int daysInMonthLunar = calendar2.get(5);
            if (this.mIsLunar) {
                int i71 = this.mYear;
                i69 = this.mMonth - (!this.mIsLeapMonth ? 1 : 0);
                if (i69 < 0) {
                    i71--;
                    i69 = 11;
                }
                i70 = i71;
                daysInMonthLunar = (getDaysInMonthLunar(i69, i70, this.mIsPrevMonthLeap) - i68) + 1;
            }
            int i72 = i69;
            int i73 = i70;
            int i74 = daysInMonthLunar;
            int i75 = 0;
            while (i75 < i68) {
                if (this.mIsRTL) {
                    i7 = (((6 - i75) * 2) + 1) * i56;
                    i8 = this.mPadding;
                } else {
                    i7 = ((i75 * 2) + 1) * i56;
                    i8 = this.mPadding;
                }
                int i76 = i7 + i8;
                int i77 = (this.mWeekHeight * 2) / 3;
                this.mDayNumberPaint.setColor(this.mDayColorSet[(this.mWeekStart + i75) % 7]);
                this.mDayNumberPaint.setAlpha(this.mPrevNextMonthDayNumberAlpha);
                if (this.mMode == 0 || i67 != 0) {
                    i9 = i77;
                    i10 = i68;
                } else if (i74 > this.mStartDay || !isPrevMonthStartMonth()) {
                    i9 = i77;
                    i10 = i68;
                    float f24 = i76 - i56;
                    float f25 = (i9 - f) - this.mDaySelectedCircleSize;
                    canvas2.drawRect(f24, f25, (i56 * 2) + f24, (r4 * 2) + f25, this.mDayNumberSelectedPaint);
                } else if (i74 == this.mStartDay) {
                    float f26 = i77 - f;
                    float f27 = this.mIsRTL ? i76 - i56 : i76;
                    float f28 = f26 - this.mDaySelectedCircleSize;
                    i9 = i77;
                    i10 = i68;
                    canvas2.drawRect(f27, f28, i56 + f27, (r5 * 2) + f28, this.mDayNumberSelectedPaint);
                    canvas2.drawCircle(i76, f26, this.mDaySelectedCircleSize, this.mDayNumberSelectedPaint);
                }
                if (this.mIsLunar) {
                    c = 5;
                } else {
                    this.mTempDate.clear();
                    this.mTempDate.set(i73, i72, i74);
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.clear();
                    c = 5;
                    calendar3.set(this.mMinDate.get(1), this.mMinDate.get(2), this.mMinDate.get(5));
                    if (this.mTempDate.before(this.mMinDate)) {
                        this.mDayNumberPaint.setAlpha(this.mDayNumberDisabledAlpha);
                    }
                }
                if (isTodayDate(i73, i72, i74)) {
                    this.mTodayDateMarkPaint.setAlpha(this.mPrevNextMonthDayNumberAlpha);
                    canvas2.drawCircle(i76, i9 - f, this.mDaySelectedCircleSize - this.mDaySelectedCircleStroke, this.mTodayDateMarkPaint);
                }
                Paint paint3 = this.mDayNumberPaint;
                if (this.mIsHcfEnabled && paint3.getAlpha() != this.mDayNumberDisabledAlpha) {
                    this.mHcfEnabledDayNumberPaint.setColor(this.mDayNumberPaint.getColor());
                    paint3 = this.mHcfEnabledDayNumberPaint;
                }
                if (this.mMode != 0 && i67 == 0 && (i74 >= this.mStartDay || !isPrevMonthStartMonth())) {
                    paint3.setColor(this.mSelectedDayNumberTextColor);
                }
                canvas2.drawText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i74)), i76, i9, paint3);
                i74++;
                i75++;
                i68 = i10;
            }
            return;
        }
        i = 2;
        z = false;
        if (z) {
        }
        this.mIsHcfEnabled = isHighContrastFontEnabled();
        int i482 = iFindDayOffset;
        int i492 = 0;
        i5 = 1;
        z2 = z;
        while (true) {
            z3 = z2;
            f = f4;
            if (i5 <= this.mNumCells) {
            }
            i5 = i28 + 1;
            i2 = i26;
            i4 = i24;
            i38 = i31;
            i40 = i29;
            z2 = z3;
            f4 = f;
            iFindDayOffset = i51;
            i43 = i27;
            i39 = i25;
            i41 = i30;
            i46 = 1;
            i = 2;
        }
        int i552 = i4;
        int i562 = i38;
        i6 = iFindDayOffset;
        int i572 = i37;
        int i582 = i2;
        if (!this.mIsLastMonth) {
        }
        int i672 = i552;
        if (i6 > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findDayOffset() {
        int i = this.mDayOfWeekStart;
        int i2 = this.mWeekStart;
        if (i < i2) {
            i += 7;
        }
        return i - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDayFromLocation(float f, float f4) {
        int i = this.mPadding;
        if (this.mIsRTL) {
            f = this.mCalendarWidth - f;
        }
        float f5 = i;
        if (f < f5) {
            return -1;
        }
        int i2 = this.mCalendarWidth;
        if (f > i + i2) {
            return -1;
        }
        return ((((int) f4) / this.mWeekHeight) * 7) + (((int) (((f - f5) * 7.0f) / i2)) - findDayOffset()) + 1;
    }

    private static int getDaysInMonth(int i, int i2) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                if (i2 % 4 == 0) {
                    return (i2 % 100 != 0 || i2 % 400 == 0) ? 29 : 28;
                }
                return 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDaysInMonthLunar(int i, int i2, boolean z) {
        int daysInMonth = getDaysInMonth(i, i2);
        Object obj = this.mSolarLunarConverter;
        if (obj != null) {
            return SeslSolarLunarConverterReflector.getDayLengthOf(this.mPathClassLoader, obj, i2, i, z);
        }
        Log.e(TAG, "getDaysInMonthLunar, mSolarLunarConverter is null");
        return daysInMonth;
    }

    private void initView() {
        Paint paint = new Paint();
        this.mDayNumberSelectedPaint = paint;
        paint.setAntiAlias(true);
        this.mDayNumberSelectedPaint.setColor(this.mSelectedDayColor);
        Paint paint2 = this.mDayNumberSelectedPaint;
        Paint.Align align = Paint.Align.CENTER;
        paint2.setTextAlign(align);
        this.mDayNumberSelectedPaint.setStrokeWidth(this.mDaySelectedCircleStroke);
        this.mDayNumberSelectedPaint.setFakeBoldText(true);
        Paint paint3 = this.mDayNumberSelectedPaint;
        Paint.Style style = Paint.Style.FILL;
        paint3.setStyle(style);
        Paint paint4 = new Paint(this.mDayNumberSelectedPaint);
        this.mAbnormalSelectedDayPaint = paint4;
        paint4.setColor(this.mNormalTextColor);
        this.mAbnormalSelectedDayPaint.setAlpha(this.mAbnormalStartEndDateBackgroundAlpha);
        Paint paint5 = new Paint();
        this.mDayNumberPaint = paint5;
        paint5.setAntiAlias(true);
        this.mDayNumberPaint.setTextSize(this.mMiniDayNumberTextSize);
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.mDayNumberPaint.setTypeface(Typeface.create(Typeface.create("sec", 0), 400, false));
        } else {
            this.mDayNumberPaint.setTypeface(Typeface.create("sec-roboto-light", 0));
        }
        this.mDayNumberPaint.setTextAlign(align);
        this.mDayNumberPaint.setStyle(style);
        this.mDayNumberPaint.setFakeBoldText(false);
        Paint paint6 = new Paint(this.mDayNumberPaint);
        this.mHcfEnabledDayNumberPaint = paint6;
        if (i >= 34) {
            this.mHcfEnabledDayNumberPaint.setTypeface(Typeface.create(Typeface.create("sec", 0), 600, false));
        } else {
            paint6.setTypeface(Typeface.create("sec-roboto-light", 1));
        }
        Paint paint7 = new Paint(this.mDayNumberPaint);
        this.mTodayDateMarkPaint = paint7;
        paint7.setColor(this.mNormalTextColor);
        this.mTodayDateMarkPaint.setAntiAlias(true);
        this.mTodayDateMarkPaint.setStrokeWidth(this.mDaySelectedCircleStroke);
        this.mTodayDateMarkPaint.setStyle(Paint.Style.STROKE);
    }

    private boolean isHighContrastFontEnabled() {
        return SeslViewReflector.isHighContrastTextEnabled(this);
    }

    private boolean isNextMonthEndMonth() {
        if (!this.mIsLunar) {
            int i = this.mYear;
            int i2 = this.mEndYear;
            return (i == i2 && this.mMonth == this.mEndMonth - 1) || (i == i2 - 1 && this.mMonth == 11 && this.mEndMonth == 0);
        }
        float f = this.mMonth;
        float f4 = this.mEndMonth;
        if (this.mIsLeapMonth) {
            f += 0.5f;
        }
        if (this.mIsLeapEndMonth == 1) {
            f4 += 0.5f;
        }
        float f5 = f4 - f;
        int i4 = this.mYear;
        int i5 = this.mEndYear;
        if (i4 != i5 || (f5 >= 1.0f && (f5 != 1.0f || this.mIsNextMonthLeap))) {
            if (i4 == i5 - 1) {
                float f6 = f5 + 12.0f;
                if (f6 < 1.0f || (f6 == 1.0f && !this.mIsNextMonthLeap)) {
                }
            }
            return false;
        }
        return true;
    }

    private boolean isPrevMonthStartMonth() {
        if (!this.mIsLunar) {
            int i = this.mYear;
            int i2 = this.mStartYear;
            return (i == i2 && this.mMonth == this.mStartMonth + 1) || (i == i2 + 1 && this.mMonth == 0 && this.mStartMonth == 11);
        }
        float f = this.mMonth;
        float f4 = this.mStartMonth;
        if (this.mIsLeapMonth) {
            f += 0.5f;
        }
        if (this.mIsLeapStartMonth == 1) {
            f4 += 0.5f;
        }
        float f5 = f - f4;
        int i4 = this.mYear;
        int i5 = this.mStartYear;
        if (i4 != i5 || (f5 >= 1.0f && (f5 != 1.0f || this.mIsPrevMonthLeap))) {
            if (i4 == i5 + 1) {
                float f6 = f5 + 12.0f;
                if (f6 < 1.0f || (f6 == 1.0f && !this.mIsPrevMonthLeap)) {
                }
            }
            return false;
        }
        return true;
    }

    private boolean isRTL() {
        Locale locale = Locale.getDefault();
        if ("ur".equals(locale.getLanguage())) {
            return false;
        }
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return directionality == 1 || directionality == 2;
    }

    private boolean isTodayDate(int i, int i2, int i4) {
        PathClassLoader pathClassLoader;
        Object obj;
        int year = this.mTodayDate.get(1);
        int month = this.mTodayDate.get(2);
        int day = this.mTodayDate.get(5);
        if (this.mIsLunar && (pathClassLoader = this.mPathClassLoader) != null && (obj = this.mSolarLunarConverter) != null) {
            SeslSolarLunarConverterReflector.convertSolarToLunar(pathClassLoader, obj, year, month, day);
            year = SeslSolarLunarConverterReflector.getYear(this.mPathClassLoader, this.mSolarLunarConverter);
            month = SeslSolarLunarConverterReflector.getMonth(this.mPathClassLoader, this.mSolarLunarConverter);
            day = SeslSolarLunarConverterReflector.getDay(this.mPathClassLoader, this.mSolarLunarConverter);
        }
        return year == i && month == i2 && day == i4;
    }

    private static boolean isValidDayOfWeek(int i) {
        return i >= 1 && i <= 7;
    }

    private static boolean isValidMonth(int i) {
        return i >= 0 && i <= 11;
    }

    private int makeMeasureSpec(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            int iMin = Math.min(size, i2);
            this.mCalendarWidth = iMin;
            return View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (mode != 1073741824) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(mode, "Unknown measure mode: "));
        }
        this.mCalendarWidth = size;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDayClick(int i, int i2, int i4) {
        if (this.mOnDayClickListener != null) {
            playSoundEffect(0);
            this.mOnDayClickListener.onDayClick(this, i, i2, i4);
        }
        this.mTouchHelper.sendEventForVirtualView(i4 + findDayOffset(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeactivatedDayClick(int i, int i2, int i4, boolean z) {
        SeslSimpleMonthView seslSimpleMonthView;
        int i5;
        if (!this.mIsLunar) {
            this.mTempDate.clear();
            this.mTempDate.set(i, i2, i4);
            if (z) {
                Calendar calendar = Calendar.getInstance();
                calendar.clear();
                calendar.set(this.mMinDate.get(1), this.mMinDate.get(2), this.mMinDate.get(5));
                if (this.mTempDate.before(calendar)) {
                    return;
                }
            } else if (this.mTempDate.after(this.mMaxDate)) {
                return;
            }
        }
        if (this.mOnDeactivatedDayClickListener != null) {
            playSoundEffect(0);
            seslSimpleMonthView = this;
            i5 = i4;
            this.mOnDeactivatedDayClickListener.onDeactivatedDayClick(seslSimpleMonthView, i, i2, i5, this.mIsLeapMonth, z);
        } else {
            seslSimpleMonthView = this;
            i5 = i4;
        }
        seslSimpleMonthView.mTouchHelper.sendEventForVirtualView(i5, 1);
    }

    public void clearAccessibilityFocus() {
        this.mTouchHelper.clearFocusedVirtualView();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.mTouchHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public int getDayOfWeekStart() {
        return this.mDayOfWeekStart - (this.mWeekStart - 1);
    }

    public int getNumDays() {
        return 7;
    }

    public int getWeekStart() {
        return this.mWeekStart;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mIsRTL = isRTL();
        this.mTouchHelper.invalidateRoot();
        Resources resources = this.mContext.getResources();
        this.mWeekHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_week_height);
        this.mDaySelectedCircleSize = resources.getDimensionPixelSize(C3623R.dimen.sesl_date_picker_selected_day_circle_radius);
        this.mMiniDayNumberTextSize = resources.getDimensionPixelSize(C3623R.dimen.sesl_date_picker_day_number_text_size);
        initView();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        drawDays(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        int i6;
        int i7;
        boolean z2 = this.mLostAccessibilityFocus;
        if (!z2 && this.mLastAccessibilityFocusedView == -1 && (i7 = this.mSelectedDay) != -1) {
            this.mTouchHelper.sendEventForVirtualView(i7 + findDayOffset(), 32768);
        } else if (!z2 && (i6 = this.mLastAccessibilityFocusedView) != -1) {
            this.mTouchHelper.sendEventForVirtualView(i6 + findDayOffset(), 32768);
        }
        if (z) {
            this.mTouchHelper.invalidateRoot();
        }
        super.onLayout(z, i, i2, i4, i5);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(makeMeasureSpec(i, this.mCalendarWidth), i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        this.mTouchHelper.invalidateRoot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int dayFromLocation = getDayFromLocation(motionEvent.getX(), motionEvent.getY());
            if ((this.mIsFirstMonth && dayFromLocation < this.mEnabledDayStart) || (this.mIsLastMonth && dayFromLocation > this.mEnabledDayEnd)) {
                return true;
            }
            if (this.mDateValidator != null) {
                this.mTempDate.clear();
                this.mTempDate.set(this.mYear, this.mMonth, dayFromLocation);
                if (!this.mDateValidator.isValid(this.mTempDate.getTime())) {
                    return true;
                }
            }
            int i = 11;
            if (dayFromLocation > 0) {
                int i2 = this.mNumCells;
                if (dayFromLocation <= i2) {
                    onDayClick(this.mYear, this.mMonth, dayFromLocation);
                } else if (this.mIsLunar) {
                    int i4 = this.mYear;
                    int i5 = this.mMonth + (!this.mIsNextMonthLeap ? 1 : 0);
                    if (i5 > 11) {
                        i4++;
                        i5 = 0;
                    }
                    onDeactivatedDayClick(i4, i5, dayFromLocation - i2, false);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.clear();
                    calendar.set(this.mYear, this.mMonth, this.mNumCells);
                    calendar.add(5, dayFromLocation - this.mNumCells);
                    onDeactivatedDayClick(calendar.get(1), calendar.get(2), calendar.get(5), false);
                }
            } else if (this.mIsLunar) {
                int i6 = this.mYear;
                int i7 = this.mMonth - (!this.mIsLeapMonth ? 1 : 0);
                if (i7 < 0) {
                    i6--;
                } else {
                    i = i7;
                }
                onDeactivatedDayClick(i6, i, getDaysInMonthLunar(i, i6, this.mIsPrevMonthLeap) + dayFromLocation, true);
            } else {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.clear();
                calendar2.set(this.mYear, this.mMonth, 1);
                calendar2.add(5, dayFromLocation - 1);
                onDeactivatedDayClick(calendar2.get(1), calendar2.get(2), calendar2.get(5), true);
            }
        }
        return true;
    }

    @Override // android.view.View
    public void setAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
        if (this.mLockAccessibilityDelegate) {
            return;
        }
        super.setAccessibilityDelegate(accessibilityDelegate);
    }

    public void setDisableDates(SeslDatePicker.DateValidator dateValidator) {
        this.mDateValidator = dateValidator;
    }

    public void setEndDate(Calendar calendar, int i) {
        this.mEndYear = calendar.get(1);
        this.mEndMonth = calendar.get(2);
        this.mEndDay = calendar.get(5);
        this.mIsLeapEndMonth = i;
    }

    public void setFirstMonth() {
        this.mIsFirstMonth = true;
    }

    public void setLastMonth() {
        this.mIsLastMonth = true;
    }

    public void setLunar(boolean z, boolean z2, PathClassLoader pathClassLoader) {
        this.mIsLunar = z;
        this.mIsLeapMonth = z2;
        if (z && this.mSolarLunarConverter == null) {
            this.mPathClassLoader = pathClassLoader;
            this.mSolarLunarConverter = SeslFeatureReflector.getSolarLunarConverter(pathClassLoader);
        }
    }

    public void setMonthParams(int i, int i2, int i4, int i5, int i6, int i7, Calendar calendar, Calendar calendar2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        Object obj;
        this.mMode = i16;
        if (this.mWeekHeight < 10) {
            this.mWeekHeight = 10;
        }
        this.mSelectedDay = i;
        if (isValidMonth(i2)) {
            this.mMonth = i2;
        }
        this.mYear = i4;
        this.mCalendar.clear();
        this.mCalendar.set(2, this.mMonth);
        this.mCalendar.set(1, this.mYear);
        this.mCalendar.set(5, 1);
        this.mMinDate = calendar;
        this.mMaxDate = calendar2;
        if (!this.mIsLunar || (obj = this.mSolarLunarConverter) == null) {
            this.mDayOfWeekStart = this.mCalendar.get(7);
            this.mNumCells = getDaysInMonth(this.mMonth, this.mYear);
        } else {
            SeslSolarLunarConverterReflector.convertLunarToSolar(this.mPathClassLoader, obj, this.mYear, this.mMonth, 1, this.mIsLeapMonth);
            this.mDayOfWeekStart = SeslSolarLunarConverterReflector.getWeekday(this.mPathClassLoader, this.mSolarLunarConverter, SeslSolarLunarConverterReflector.getYear(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getMonth(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getDay(this.mPathClassLoader, this.mSolarLunarConverter)) + 1;
            this.mNumCells = getDaysInMonthLunar(this.mMonth, this.mYear, this.mIsLeapMonth);
        }
        if (isValidDayOfWeek(i5)) {
            this.mWeekStart = i5;
        } else {
            this.mWeekStart = this.mCalendar.getFirstDayOfWeek();
        }
        int i17 = (this.mMonth == calendar.get(2) && this.mYear == calendar.get(1)) ? calendar.get(5) : i6;
        int i18 = (this.mMonth == calendar2.get(2) && this.mYear == calendar2.get(1)) ? calendar2.get(5) : i7;
        if (i17 > 0 && i18 < 32) {
            this.mEnabledDayStart = i17;
        }
        if (i18 > 0 && i18 < 32 && i18 >= i17) {
            this.mEnabledDayEnd = i18;
        }
        this.mTouchHelper.invalidateRoot();
        this.mStartYear = i8;
        this.mStartMonth = i9;
        this.mStartDay = i10;
        this.mIsLeapStartMonth = i11;
        this.mEndYear = i12;
        this.mEndMonth = i13;
        this.mEndDay = i14;
        this.mIsLeapEndMonth = i15;
    }

    public void setNextMonthLeap() {
        this.mIsNextMonthLeap = true;
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.mOnDayClickListener = onDayClickListener;
    }

    public void setOnDeactivatedDayClickListener(OnDeactivatedDayClickListener onDeactivatedDayClickListener) {
        this.mOnDeactivatedDayClickListener = onDeactivatedDayClickListener;
    }

    public void setPrevMonthLeap() {
        this.mIsPrevMonthLeap = true;
    }

    public void setStartDate(Calendar calendar, int i) {
        this.mStartYear = calendar.get(1);
        this.mStartMonth = calendar.get(2);
        this.mStartDay = calendar.get(5);
        this.mIsLeapStartMonth = i;
    }

    public void setTextColor(String str) {
        if (str == null) {
            str = SeslCscFeatureReflector.getString(TAG_CSCFEATURE_CALENDAR_SETCOLOROFDAYS, DEFAULT_WEEK_DAY_STRING_FEATURE);
        }
        for (int i = 0; i < 7; i++) {
            char cCharAt = str.charAt(i);
            int i2 = (i + 2) % 7;
            if (cCharAt == 'R') {
                this.mDayColorSet[i2] = this.mSundayTextColor;
            } else if (cCharAt == 'B') {
                this.mDayColorSet[i2] = this.mSaturdayTextColor;
            } else {
                this.mDayColorSet[i2] = this.mNormalTextColor;
            }
        }
    }

    public SeslSimpleMonthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public SeslSimpleMonthView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mDayColorSet = new int[7];
        this.mMode = 0;
        this.mDayOfWeekStart = 0;
        this.mPadding = 0;
        this.mSelectedDay = -1;
        this.mWeekStart = 1;
        this.mNumDays = 7;
        this.mNumCells = 7;
        this.mEnabledDayStart = 1;
        this.mEnabledDayEnd = 31;
        this.mIsHcfEnabled = false;
        this.mCalendar = Calendar.getInstance();
        this.mMinDate = Calendar.getInstance();
        this.mMaxDate = Calendar.getInstance();
        this.mTempDate = Calendar.getInstance();
        this.mTodayDate = Calendar.getInstance();
        this.mIsLunar = false;
        this.mIsLeapMonth = false;
        this.mPathClassLoader = null;
        this.mIsFirstMonth = false;
        this.mIsLastMonth = false;
        this.mIsPrevMonthLeap = false;
        this.mIsNextMonthLeap = false;
        this.mLastAccessibilityFocusedView = -1;
        this.mLostAccessibilityFocus = false;
        this.mContext = context;
        this.mIsRTL = isRTL();
        Resources resources = context.getResources();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0419R.attr.colorPrimary, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 != 0) {
            this.mSelectedDayColor = resources.getColor(i2);
        } else {
            this.mSelectedDayColor = typedValue.data;
        }
        this.mSundayTextColor = resources.getColor(C3623R.color.sesl_date_picker_sunday_number_text_color_light);
        this.mSaturdayTextColor = resources.getColor(C3623R.color.sesl_date_picker_saturday_text_color_light);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3623R.styleable.DatePicker, i, 0);
        try {
            this.mNormalTextColor = typedArrayObtainStyledAttributes.getColor(C3623R.styleable.DatePicker_dayNumberTextColor, resources.getColor(C3623R.color.sesl_date_picker_normal_day_number_text_color_light));
            this.mSelectedDayNumberTextColor = typedArrayObtainStyledAttributes.getColor(C3623R.styleable.DatePicker_selectedDayNumberTextColor, resources.getColor(C3623R.color.sesl_date_picker_selected_day_number_text_color_light));
            this.mDayNumberDisabledAlpha = typedArrayObtainStyledAttributes.getInteger(C3623R.styleable.DatePicker_dayNumberDisabledAlpha, resources.getInteger(C3623R.integer.sesl_day_number_disabled_alpha_light));
            typedArrayObtainStyledAttributes.recycle();
            this.mWeekHeight = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_week_height);
            this.mDaySelectedCircleSize = resources.getDimensionPixelSize(C3623R.dimen.sesl_date_picker_selected_day_circle_radius);
            this.mDaySelectedCircleStroke = resources.getDimensionPixelSize(C3623R.dimen.sesl_date_picker_selected_day_circle_stroke);
            this.mMiniDayNumberTextSize = resources.getDimensionPixelSize(C3623R.dimen.sesl_date_picker_day_number_text_size);
            this.mCalendarWidth = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_width);
            this.mPadding = resources.getDimensionPixelOffset(C3623R.dimen.sesl_date_picker_calendar_view_padding);
            MonthViewTouchHelper monthViewTouchHelper = new MonthViewTouchHelper(this);
            this.mTouchHelper = monthViewTouchHelper;
            ViewCompat.setAccessibilityDelegate(this, monthViewTouchHelper);
            setImportantForAccessibility(1);
            this.mLockAccessibilityDelegate = true;
            if (Settings.System.getString(context.getContentResolver(), "current_sec_active_themepackage") != null) {
                this.mDayNumberDisabledAlpha = resources.getInteger(C3623R.integer.sesl_day_number_theme_disabled_alpha);
            }
            this.mPrevNextMonthDayNumberAlpha = resources.getInteger(C3623R.integer.sesl_day_number_theme_disabled_alpha);
            this.mAbnormalStartEndDateBackgroundAlpha = resources.getInteger(C3623R.integer.sesl_date_picker_abnormal_start_end_date_background_alpha);
            initView();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
