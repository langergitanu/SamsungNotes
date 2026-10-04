package androidx.picker.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.res.ResourcesCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.picker.C3623R;
import androidx.picker.util.SeslAnimationListener;
import androidx.picker.util.SeslPickerBasicUtils;
import androidx.picker.widget.SeslSpinningDatePicker;
import androidx.picker.widget.SeslSpinningDatePickerSpinner;
import androidx.reflect.content.res.SeslCompatibilityInfoReflector;
import androidx.reflect.content.res.SeslConfigurationReflector;
import androidx.reflect.graphics.SeslPaintReflector;
import androidx.reflect.lunarcalendar.SeslFeatureReflector;
import androidx.reflect.lunarcalendar.SeslSolarLunarConverterReflector;
import androidx.reflect.media.SeslAudioManagerReflector;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import androidx.reflect.view.SeslViewReflector;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import dalvik.system.PathClassLoader;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SeslSpinningDatePickerSpinnerDelegate extends SeslSpinningDatePickerSpinner.AbsDatePickerDelegate {
    private static final int DECREASE_BUTTON = 1;
    private static final int DEFAULT_CHANGE_VALUE_BY = 1;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300;
    private static final int DEFAULT_START_YEAR = 1902;
    private static final int FONT_WEIGHT_SEMIBOLD = 600;
    private static final int HCF_UNFOCUSED_TEXT_SIZE_DIFF = 2;
    private static final int INCREASE_BUTTON = 3;
    private static final int INPUT = 2;
    private static final int LONG_PRESSED_SCROLL_COUNT = 10;
    private static final int PICKER_VIBRATE_INDEX = 32;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 300;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 4;
    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 2;
    private static final int SELECTOR_WHEEL_ITEM_COUNT = 5;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 500;
    private static final int START_ANIMATION_SCROLL_DURATION = 857;
    private static final int START_ANIMATION_SCROLL_DURATION_2016B = 557;
    private static final int TEXT_GAP_COUNT = 3;
    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
    private final PathInterpolator ALPHA_PATH_INTERPOLATOR;
    private final PathInterpolator SIZE_PATH_INTERPOLATOR;
    private AccessibilityManager mAccessibilityManager;
    private AccessibilityNodeProviderImpl mAccessibilityNodeProvider;
    private float mActivatedAlpha;
    private final Scroller mAdjustScroller;
    private float mAlpha;
    private SeslAnimationListener mAnimationListener;
    private AudioManager mAudioManager;
    private int mBottomSelectionDividerBottom;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    private int mChangeValueBy;
    private ValueAnimator mColorInAnimator;
    private ValueAnimator mColorOutAnimator;
    private ValueAnimator.AnimatorUpdateListener mColorUpdateListener;
    private final boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    private final Scroller mCustomScroller;
    private boolean mCustomTypefaceSet;
    private boolean mDecrementVirtualButtonPressed;
    private final Typeface mDefaultTypeface;
    private ValueAnimator mFadeInAnimator;
    private ValueAnimator mFadeOutAnimator;
    private Scroller mFlingScroller;
    private SeslSpinningDatePickerSpinner.Formatter mFormatter;
    private OverScroller mGravityScroller;
    private HapticPreDrawListener mHapticPreDrawListener;
    private Typeface mHcfFocusedTypefaceBold;
    private final int mHcfUnfocusedTextSizeDiff;
    private final float mHeightRatio;
    private FloatValueHolder mHolder;
    private float mIdleAlpha;
    private boolean mIgnoreMoveEvents;
    private boolean mIncrementVirtualButtonPressed;
    private float mInitialAlpha;
    private int mInitialScrollOffset;
    private final EditText mInputText;
    private boolean mIsHcfEnabled;
    private boolean mIsLeapMonth;
    private boolean mIsLongClicked;
    private boolean mIsLongPressed;
    private boolean mIsLunar;
    private boolean mIsStartingAnimation;
    private boolean mIsValueChanged;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private int mLastFocusedChildVirtualViewId;
    private int mLastHoveredChildVirtualViewId;
    private final Typeface mLegacyTypeface;
    private final Scroller mLinearScroller;
    private String[] mLongMonths;
    private int mLongPressCount;
    private long mLongPressUpdateInterval;
    private boolean mLongPressed_FIRST_SCROLL;
    private boolean mLongPressed_SECOND_SCROLL;
    private boolean mLongPressed_THIRD_SCROLL;
    private final int mMaxHeight;
    private Calendar mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private final int mMinHeight;
    private Calendar mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private int mModifiedTxtHeight;
    private SeslSpinningDatePickerSpinner.OnScrollListener mOnScrollListener;
    private SeslSpinningDatePickerSpinner.OnSpinnerDateClickListener mOnSpinnerDateClickListener;
    private SeslSpinningDatePickerSpinner.OnValueChangeListener mOnValueChangeListener;
    private PathClassLoader mPathClassLoader;
    private boolean mPerformClickOnTap;
    private String mPickerContentDescription;
    private int mPickerSoundIndex;
    private Typeface mPickerSubTypeface;
    private Typeface mPickerTypeface;
    private int mPickerVibrateIndex;
    private final PressedStateHelper mPressedStateHelper;
    private int mPreviousScrollerY;
    private float mPreviousSpringY;
    private boolean mReservedStartAnimation;
    private int mScrollState;
    private final int mSelectionDividerHeight;
    private int mSelectorElementHeight;
    private final HashMap<Calendar, String> mSelectorIndexToStringCache;
    private final Calendar[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private Paint mSelectorWheelPaint;
    private String[] mShortMonths;
    private boolean mSkipNumbers;
    private Object mSolarLunarConverter;
    private SpringAnimation mSpringAnimation;
    private DynamicAnimation.OnAnimationEndListener mSpringAnimationEndListener;
    private DynamicAnimation.OnAnimationUpdateListener mSpringAnimationUpdateListener;
    private boolean mSpringFlingRunning;
    private int mTextColor;
    private final int mTextColorIdle;
    private final int mTextColorScrolling;
    private int mTextSize;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener;
    private Calendar mValue;
    private int mValueChangeOffset;
    private VelocityTracker mVelocityTracker;
    private final Drawable mVirtualButtonFocusedDrawable;
    private boolean mWrapSelectorWheel;
    private boolean mWrapSelectorWheelPreferred;

    /* JADX INFO: renamed from: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC36711 implements Runnable {
        final /* synthetic */ int val$delay;

        /* JADX INFO: renamed from: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ int val$forwardDistance;

            public AnonymousClass1(int i) {
                this.val$forwardDistance = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                new Handler().postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate.1.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate = SeslSpinningDatePickerSpinnerDelegate.this;
                        if (!seslSpinningDatePickerSpinnerDelegate.moveToFinalScrollerPosition(seslSpinningDatePickerSpinnerDelegate.mFlingScroller)) {
                            SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate2 = SeslSpinningDatePickerSpinnerDelegate.this;
                            seslSpinningDatePickerSpinnerDelegate2.moveToFinalScrollerPosition(seslSpinningDatePickerSpinnerDelegate2.mAdjustScroller);
                        }
                        SeslSpinningDatePickerSpinnerDelegate.this.mPreviousScrollerY = 0;
                        SeslSpinningDatePickerSpinnerDelegate.this.mFlingScroller.startScroll(0, 0, 0, -AnonymousClass1.this.val$forwardDistance, SeslSpinningDatePickerSpinnerDelegate.START_ANIMATION_SCROLL_DURATION_2016B);
                        SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.invalidate();
                        new Handler().postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate.1.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate3 = SeslSpinningDatePickerSpinnerDelegate.this;
                                seslSpinningDatePickerSpinnerDelegate3.moveToFinalScrollerPosition(seslSpinningDatePickerSpinnerDelegate3.mFlingScroller);
                                SeslSpinningDatePickerSpinnerDelegate.this.mFlingScroller.abortAnimation();
                                SeslSpinningDatePickerSpinnerDelegate.this.mAdjustScroller.abortAnimation();
                                SeslSpinningDatePickerSpinnerDelegate.this.ensureScrollWheelAdjusted();
                                SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate4 = SeslSpinningDatePickerSpinnerDelegate.this;
                                seslSpinningDatePickerSpinnerDelegate4.mFlingScroller = seslSpinningDatePickerSpinnerDelegate4.mLinearScroller;
                                SeslSpinningDatePickerSpinnerDelegate.this.mIsStartingAnimation = false;
                                SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.invalidate();
                                SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(true);
                                if (SeslSpinningDatePickerSpinnerDelegate.this.mAnimationListener != null) {
                                    SeslSpinningDatePickerSpinnerDelegate.this.mAnimationListener.onAnimationEnd();
                                }
                            }
                        }, 857L);
                    }
                }, 100L);
            }
        }

        public RunnableC36711(int i) {
            this.val$delay = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SeslSpinningDatePickerSpinnerDelegate.this.mSelectorElementHeight == 0) {
                SeslSpinningDatePickerSpinnerDelegate.this.mReservedStartAnimation = true;
                return;
            }
            SeslSpinningDatePickerSpinnerDelegate.this.mIsStartingAnimation = true;
            SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate = SeslSpinningDatePickerSpinnerDelegate.this;
            seslSpinningDatePickerSpinnerDelegate.mFlingScroller = seslSpinningDatePickerSpinnerDelegate.mCustomScroller;
            int i = SeslSpinningDatePickerSpinnerDelegate.this.mSelectorElementHeight * 5;
            int i2 = (int) (((double) SeslSpinningDatePickerSpinnerDelegate.this.mSelectorElementHeight) * 5.4d);
            SeslSpinningDatePickerSpinnerDelegate.this.scrollBy(0, i);
            SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.invalidate();
            new Handler().postDelayed(new AnonymousClass1(i2), this.val$delay);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AccessibilityNodeProviderImpl extends AccessibilityNodeProvider {
        private static final int UNDEFINED = Integer.MIN_VALUE;
        private static final int VIRTUAL_VIEW_ID_CENTER = 2;
        private static final int VIRTUAL_VIEW_ID_DECREMENT = 1;
        private static final int VIRTUAL_VIEW_ID_INCREMENT = 3;
        private final Rect mTempRect = new Rect();
        private final int[] mTempArray = new int[2];
        private int mAccessibilityFocusedView = Integer.MIN_VALUE;

        public AccessibilityNodeProviderImpl() {
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForDatePickerWidget(int i, int i2, int i4, int i5) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setClassName(SeslSpinningDatePickerSpinner.class.getName());
            accessibilityNodeInfoObtain.setPackageName(SeslSpinningDatePickerSpinnerDelegate.this.mContext.getPackageName());
            accessibilityNodeInfoObtain.setSource(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator);
            if (hasVirtualDecrementButton()) {
                accessibilityNodeInfoObtain.addChild(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator, 1);
            }
            accessibilityNodeInfoObtain.addChild(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator, 2);
            if (hasVirtualIncrementButton()) {
                accessibilityNodeInfoObtain.addChild(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator, 3);
            }
            accessibilityNodeInfoObtain.setParent((View) SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getParentForAccessibility());
            accessibilityNodeInfoObtain.setEnabled(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled());
            accessibilityNodeInfoObtain.setScrollable(true);
            float field_applicationScale = SeslCompatibilityInfoReflector.getField_applicationScale(SeslSpinningDatePickerSpinnerDelegate.this.mContext.getResources());
            Rect rect = this.mTempRect;
            rect.set(i, i2, i4, i5);
            scaleRect(rect, field_applicationScale);
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            accessibilityNodeInfoObtain.setVisibleToUser(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isVisibleToUserWrapper());
            int[] iArr = this.mTempArray;
            SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            scaleRect(rect, field_applicationScale);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != -1) {
                accessibilityNodeInfoObtain.addAction(64);
            } else {
                accessibilityNodeInfoObtain.addAction(128);
            }
            if (SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                if (SeslSpinningDatePickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslSpinningDatePickerSpinnerDelegate.this.getValue().compareTo(SeslSpinningDatePickerSpinnerDelegate.this.getMaxValue()) < 0) {
                    accessibilityNodeInfoObtain.addAction(4096);
                }
                if (SeslSpinningDatePickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslSpinningDatePickerSpinnerDelegate.this.getValue().compareTo(SeslSpinningDatePickerSpinnerDelegate.this.getMinValue()) > 0) {
                    accessibilityNodeInfoObtain.addAction(8192);
                }
            }
            return accessibilityNodeInfoObtain;
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForVirtualButton(int i, String str, int i2, int i4, int i5, int i6) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setClassName(Button.class.getName());
            accessibilityNodeInfoObtain.setPackageName(SeslSpinningDatePickerSpinnerDelegate.this.mContext.getPackageName());
            accessibilityNodeInfoObtain.setSource(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator, i);
            accessibilityNodeInfoObtain.setParent(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator);
            accessibilityNodeInfoObtain.setText(str);
            accessibilityNodeInfoObtain.setClickable(true);
            accessibilityNodeInfoObtain.setLongClickable(true);
            accessibilityNodeInfoObtain.setEnabled(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled());
            Rect rect = this.mTempRect;
            rect.set(i2, i4, i5, i6);
            accessibilityNodeInfoObtain.setVisibleToUser(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isVisibleToUserWrapper(rect));
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            int[] iArr = this.mTempArray;
            SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != i) {
                accessibilityNodeInfoObtain.addAction(64);
            } else {
                accessibilityNodeInfoObtain.addAction(128);
            }
            if (SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                accessibilityNodeInfoObtain.addAction(16);
            }
            return accessibilityNodeInfoObtain;
        }

        private AccessibilityNodeInfo createAccessibiltyNodeInfoForCenter(int i, int i2, int i4, int i5) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setPackageName(SeslSpinningDatePickerSpinnerDelegate.this.mContext.getPackageName());
            accessibilityNodeInfoObtain.setSource(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator, 2);
            accessibilityNodeInfoObtain.setParent(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator);
            accessibilityNodeInfoObtain.setText(getVirtualCurrentButtonText() + SeslSpinningDatePickerSpinnerDelegate.this.mContext.getString(C3623R.string.sesl_date_picker_switch_to_calendar_description));
            accessibilityNodeInfoObtain.setClickable(true);
            accessibilityNodeInfoObtain.setEnabled(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled());
            if (this.mAccessibilityFocusedView != 2) {
                accessibilityNodeInfoObtain.setAccessibilityFocused(false);
                accessibilityNodeInfoObtain.addAction(64);
            } else {
                accessibilityNodeInfoObtain.setAccessibilityFocused(true);
                accessibilityNodeInfoObtain.addAction(128);
            }
            Rect rect = this.mTempRect;
            rect.set(i, i2, i4, i5);
            accessibilityNodeInfoObtain.setVisibleToUser(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isVisibleToUserWrapper(rect));
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            int[] iArr = this.mTempArray;
            SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            return accessibilityNodeInfoObtain;
        }

        private void findAccessibilityNodeInfosByTextInChild(String str, int i, List<AccessibilityNodeInfo> list) {
            if (i == 1) {
                String virtualDecrementButtonText = getVirtualDecrementButtonText();
                if (TextUtils.isEmpty(virtualDecrementButtonText) || !virtualDecrementButtonText.toLowerCase().contains(str)) {
                    return;
                }
                list.add(createAccessibilityNodeInfo(1));
                return;
            }
            if (i == 2) {
                String virtualCurrentButtonText = getVirtualCurrentButtonText();
                if (TextUtils.isEmpty(virtualCurrentButtonText) || !virtualCurrentButtonText.toLowerCase().contains(str)) {
                    return;
                }
                list.add(createAccessibilityNodeInfo(2));
                return;
            }
            if (i != 3) {
                return;
            }
            String virtualIncrementButtonText = getVirtualIncrementButtonText();
            if (TextUtils.isEmpty(virtualIncrementButtonText) || !virtualIncrementButtonText.toLowerCase().contains(str)) {
                return;
            }
            list.add(createAccessibilityNodeInfo(3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getVirtualCurrentButtonText() {
            Calendar wrappedSelectorIndex = (Calendar) SeslSpinningDatePickerSpinnerDelegate.this.mValue.clone();
            if (SeslSpinningDatePickerSpinnerDelegate.this.mWrapSelectorWheel) {
                wrappedSelectorIndex = SeslSpinningDatePickerSpinnerDelegate.this.getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            if (wrappedSelectorIndex.compareTo(SeslSpinningDatePickerSpinnerDelegate.this.mMaxValue) > 0) {
                return null;
            }
            if (SeslSpinningDatePickerSpinnerDelegate.this.mIsLunar) {
                return SeslSpinningDatePickerSpinnerDelegate.this.formatDateForLunarForAccessibility(wrappedSelectorIndex);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SeslSpinningDatePickerSpinnerDelegate.this.formatDateForAccessibility(wrappedSelectorIndex));
            sb.append(SQLKeyword.COMMA);
            return AbstractC0622a.m1170p(SeslSpinningDatePickerSpinnerDelegate.this.mPickerContentDescription, SQLKeyword.COMMA, sb);
        }

        private String getVirtualDecrementButtonText() {
            Calendar wrappedSelectorIndex = (Calendar) SeslSpinningDatePickerSpinnerDelegate.this.mValue.clone();
            wrappedSelectorIndex.add(5, -1);
            if (SeslSpinningDatePickerSpinnerDelegate.this.mWrapSelectorWheel) {
                wrappedSelectorIndex = SeslSpinningDatePickerSpinnerDelegate.this.getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            if (wrappedSelectorIndex.compareTo(SeslSpinningDatePickerSpinnerDelegate.this.mMinValue) < 0) {
                return null;
            }
            if (SeslSpinningDatePickerSpinnerDelegate.this.mIsLunar) {
                return SeslSpinningDatePickerSpinnerDelegate.this.formatDateForLunarForAccessibility(wrappedSelectorIndex);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SeslSpinningDatePickerSpinnerDelegate.this.formatDateForAccessibility(wrappedSelectorIndex));
            sb.append(SQLKeyword.COMMA);
            return AbstractC0622a.m1170p(SeslSpinningDatePickerSpinnerDelegate.this.mPickerContentDescription, SQLKeyword.COMMA, sb);
        }

        private String getVirtualIncrementButtonText() {
            Calendar wrappedSelectorIndex = (Calendar) SeslSpinningDatePickerSpinnerDelegate.this.mValue.clone();
            wrappedSelectorIndex.add(5, 1);
            if (SeslSpinningDatePickerSpinnerDelegate.this.mWrapSelectorWheel) {
                wrappedSelectorIndex = SeslSpinningDatePickerSpinnerDelegate.this.getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            if (wrappedSelectorIndex.compareTo(SeslSpinningDatePickerSpinnerDelegate.this.mMaxValue) > 0) {
                return null;
            }
            if (SeslSpinningDatePickerSpinnerDelegate.this.mIsLunar) {
                return SeslSpinningDatePickerSpinnerDelegate.this.formatDateForLunarForAccessibility(wrappedSelectorIndex);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SeslSpinningDatePickerSpinnerDelegate.this.formatDateForAccessibility(wrappedSelectorIndex));
            sb.append(SQLKeyword.COMMA);
            return AbstractC0622a.m1170p(SeslSpinningDatePickerSpinnerDelegate.this.mPickerContentDescription, SQLKeyword.COMMA, sb);
        }

        private boolean hasVirtualDecrementButton() {
            return SeslSpinningDatePickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslSpinningDatePickerSpinnerDelegate.this.getValue().compareTo(SeslSpinningDatePickerSpinnerDelegate.this.getMinValue()) > 0;
        }

        private boolean hasVirtualIncrementButton() {
            return SeslSpinningDatePickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslSpinningDatePickerSpinnerDelegate.this.getValue().compareTo(SeslSpinningDatePickerSpinnerDelegate.this.getMaxValue()) < 0;
        }

        private void scaleRect(@NonNull Rect rect, float f) {
            if (f != 1.0f) {
                rect.left = (int) ((rect.left * f) + 0.5f);
                rect.top = (int) ((rect.top * f) + 0.5f);
                rect.right = (int) ((rect.right * f) + 0.5f);
                rect.bottom = (int) ((rect.bottom * f) + 0.5f);
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void sendAccessibilityEventForCenter(int i) {
            if (SeslSpinningDatePickerSpinnerDelegate.this.mAccessibilityManager.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
                accessibilityEventObtain.setPackageName(SeslSpinningDatePickerSpinnerDelegate.this.mContext.getPackageName());
                accessibilityEventObtain.getText().add(getVirtualCurrentButtonText() + SeslSpinningDatePickerSpinnerDelegate.this.mContext.getString(C3623R.string.sesl_date_picker_switch_to_calendar_description));
                accessibilityEventObtain.setEnabled(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled());
                accessibilityEventObtain.setSource(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator, 2);
                SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator;
                seslSpinningDatePickerSpinner.requestSendAccessibilityEvent(seslSpinningDatePickerSpinner, accessibilityEventObtain);
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void sendAccessibilityEventForVirtualButton(int i, int i2, String str) {
            if (SeslSpinningDatePickerSpinnerDelegate.this.mAccessibilityManager.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
                accessibilityEventObtain.setClassName(Button.class.getName());
                accessibilityEventObtain.setPackageName(SeslSpinningDatePickerSpinnerDelegate.this.mContext.getPackageName());
                accessibilityEventObtain.getText().add(str);
                accessibilityEventObtain.setEnabled(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled());
                accessibilityEventObtain.setSource(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator, i);
                SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator;
                seslSpinningDatePickerSpinner.requestSendAccessibilityEvent(seslSpinningDatePickerSpinner, accessibilityEventObtain);
            }
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            int left = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getLeft();
            int right = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getRight();
            int top = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getTop();
            int bottom = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getBottom();
            int scrollX = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getScrollX();
            int scrollY = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getScrollY();
            if (SeslSpinningDatePickerSpinnerDelegate.this.mLastFocusedChildVirtualViewId != -1 || SeslSpinningDatePickerSpinnerDelegate.this.mLastHoveredChildVirtualViewId != Integer.MIN_VALUE) {
                if (i == -1) {
                    return createAccessibilityNodeInfoForDatePickerWidget(scrollX, scrollY, (right - left) + scrollX, (bottom - top) + scrollY);
                }
                if (i == 1) {
                    return createAccessibilityNodeInfoForVirtualButton(1, getVirtualDecrementButtonText(), scrollX, scrollY, (right - left) + scrollX, SeslSpinningDatePickerSpinnerDelegate.this.mTopSelectionDividerTop + SeslSpinningDatePickerSpinnerDelegate.this.mSelectionDividerHeight);
                }
                if (i == 2) {
                    return createAccessibiltyNodeInfoForCenter(scrollX, SeslSpinningDatePickerSpinnerDelegate.this.mTopSelectionDividerTop + SeslSpinningDatePickerSpinnerDelegate.this.mSelectionDividerHeight, (right - left) + scrollX, SeslSpinningDatePickerSpinnerDelegate.this.mBottomSelectionDividerBottom - SeslSpinningDatePickerSpinnerDelegate.this.mSelectionDividerHeight);
                }
                if (i == 3) {
                    return createAccessibilityNodeInfoForVirtualButton(3, getVirtualIncrementButtonText(), scrollX, SeslSpinningDatePickerSpinnerDelegate.this.mBottomSelectionDividerBottom - SeslSpinningDatePickerSpinnerDelegate.this.mSelectionDividerHeight, (right - left) + scrollX, (bottom - top) + scrollY);
                }
            }
            AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = super.createAccessibilityNodeInfo(i);
            return accessibilityNodeInfoCreateAccessibilityNodeInfo == null ? AccessibilityNodeInfo.obtain() : accessibilityNodeInfoCreateAccessibilityNodeInfo;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.EMPTY_LIST;
            }
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (i == -1) {
                findAccessibilityNodeInfosByTextInChild(lowerCase, 1, arrayList);
                findAccessibilityNodeInfosByTextInChild(lowerCase, 2, arrayList);
                findAccessibilityNodeInfosByTextInChild(lowerCase, 3, arrayList);
                return arrayList;
            }
            if (i != 1 && i != 2 && i != 3) {
                return super.findAccessibilityNodeInfosByText(str, i);
            }
            findAccessibilityNodeInfosByTextInChild(lowerCase, i, arrayList);
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            if (SeslSpinningDatePickerSpinnerDelegate.this.mIsStartingAnimation) {
                return false;
            }
            int right = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getRight();
            int bottom = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getBottom();
            if (i != -1) {
                if (i == 1) {
                    if (i2 == 16) {
                        if (!SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                            return false;
                        }
                        SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(false);
                        SeslSpinningDatePickerSpinnerDelegate.this.changeValueByOne(false);
                        sendAccessibilityEventForVirtualView(i, 1);
                        SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(true);
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.mAccessibilityFocusedView == i) {
                            return false;
                        }
                        this.mAccessibilityFocusedView = i;
                        sendAccessibilityEventForVirtualView(i, 32768);
                        SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate = SeslSpinningDatePickerSpinnerDelegate.this;
                        seslSpinningDatePickerSpinnerDelegate.mDelegator.invalidate(0, 0, right, seslSpinningDatePickerSpinnerDelegate.mTopSelectionDividerTop);
                        return true;
                    }
                    if (i2 != 128 || this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    sendAccessibilityEventForVirtualView(i, 65536);
                    SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate2 = SeslSpinningDatePickerSpinnerDelegate.this;
                    seslSpinningDatePickerSpinnerDelegate2.mDelegator.invalidate(0, 0, right, seslSpinningDatePickerSpinnerDelegate2.mTopSelectionDividerTop);
                    return true;
                }
                if (i == 2) {
                    if (i2 == 16) {
                        if (!SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                            return false;
                        }
                        SeslSpinningDatePickerSpinnerDelegate.this.performClick();
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.mAccessibilityFocusedView == i) {
                            return false;
                        }
                        this.mAccessibilityFocusedView = i;
                        sendAccessibilityEventForVirtualView(i, 32768);
                        SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate3 = SeslSpinningDatePickerSpinnerDelegate.this;
                        seslSpinningDatePickerSpinnerDelegate3.mDelegator.invalidate(0, seslSpinningDatePickerSpinnerDelegate3.mTopSelectionDividerTop, right, SeslSpinningDatePickerSpinnerDelegate.this.mBottomSelectionDividerBottom);
                        return true;
                    }
                    if (i2 != 128 || this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    sendAccessibilityEventForVirtualView(i, 65536);
                    SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate4 = SeslSpinningDatePickerSpinnerDelegate.this;
                    seslSpinningDatePickerSpinnerDelegate4.mDelegator.invalidate(0, seslSpinningDatePickerSpinnerDelegate4.mTopSelectionDividerTop, right, SeslSpinningDatePickerSpinnerDelegate.this.mBottomSelectionDividerBottom);
                    return true;
                }
                if (i == 3) {
                    if (i2 == 16) {
                        if (!SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                            return false;
                        }
                        SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(false);
                        SeslSpinningDatePickerSpinnerDelegate.this.changeValueByOne(true);
                        sendAccessibilityEventForVirtualView(i, 1);
                        SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(true);
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.mAccessibilityFocusedView == i) {
                            return false;
                        }
                        this.mAccessibilityFocusedView = i;
                        sendAccessibilityEventForVirtualView(i, 32768);
                        SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate5 = SeslSpinningDatePickerSpinnerDelegate.this;
                        seslSpinningDatePickerSpinnerDelegate5.mDelegator.invalidate(0, seslSpinningDatePickerSpinnerDelegate5.mBottomSelectionDividerBottom, right, bottom);
                        return true;
                    }
                    if (i2 != 128 || this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    sendAccessibilityEventForVirtualView(i, 65536);
                    SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate6 = SeslSpinningDatePickerSpinnerDelegate.this;
                    seslSpinningDatePickerSpinnerDelegate6.mDelegator.invalidate(0, seslSpinningDatePickerSpinnerDelegate6.mBottomSelectionDividerBottom, right, bottom);
                    return true;
                }
            } else {
                if (i2 == 64) {
                    if (this.mAccessibilityFocusedView == i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = i;
                    SeslViewReflector.requestAccessibilityFocus(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator);
                    return true;
                }
                if (i2 == 128) {
                    if (this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    SeslViewReflector.clearAccessibilityFocus(SeslSpinningDatePickerSpinnerDelegate.this.mDelegator);
                    return true;
                }
                if (i2 == 4096) {
                    if (!SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled() || (!SeslSpinningDatePickerSpinnerDelegate.this.getWrapSelectorWheel() && SeslSpinningDatePickerSpinnerDelegate.this.getValue().compareTo(SeslSpinningDatePickerSpinnerDelegate.this.getMaxValue()) >= 0)) {
                        return false;
                    }
                    SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(false);
                    SeslSpinningDatePickerSpinnerDelegate.this.changeValueByOne(true);
                    SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(true);
                    return true;
                }
                if (i2 == 8192) {
                    if (!SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.isEnabled() || (!SeslSpinningDatePickerSpinnerDelegate.this.getWrapSelectorWheel() && SeslSpinningDatePickerSpinnerDelegate.this.getValue().compareTo(SeslSpinningDatePickerSpinnerDelegate.this.getMinValue()) <= 0)) {
                        return false;
                    }
                    SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(false);
                    SeslSpinningDatePickerSpinnerDelegate.this.changeValueByOne(false);
                    SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(true);
                    return true;
                }
            }
            return super.performAction(i, i2, bundle);
        }

        public void sendAccessibilityEventForVirtualView(int i, int i2) {
            if (i == 1) {
                if (hasVirtualDecrementButton()) {
                    sendAccessibilityEventForVirtualButton(i, i2, getVirtualDecrementButtonText());
                }
            } else if (i == 2) {
                sendAccessibilityEventForCenter(i2);
            } else if (i == 3 && hasVirtualIncrementButton()) {
                sendAccessibilityEventForVirtualButton(i, i2, getVirtualIncrementButtonText());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        private boolean mIncrement;

        public ChangeCurrentByOneFromLongPressCommand() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStep(boolean z) {
            this.mIncrement = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SeslSpinningDatePickerSpinnerDelegate.this.changeValueByOne(this.mIncrement);
            SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate = SeslSpinningDatePickerSpinnerDelegate.this;
            seslSpinningDatePickerSpinnerDelegate.mDelegator.postDelayed(this, seslSpinningDatePickerSpinnerDelegate.mLongPressUpdateInterval);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PressedStateHelper implements Runnable {
        static final int BUTTON_DECREMENT = 2;
        static final int BUTTON_INCREMENT = 1;
        private static final int MODE_PRESS = 1;
        private static final int MODE_TAPPED = 2;
        private int mManagedButton;
        private int mMode;

        public PressedStateHelper() {
        }

        public void buttonPressDelayed(int i) {
            cancel();
            this.mMode = 1;
            this.mManagedButton = i;
            SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        public void buttonTapped(int i) {
            cancel();
            this.mMode = 2;
            this.mManagedButton = i;
            SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.post(this);
        }

        public void cancel() {
            int right = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getRight();
            int bottom = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getBottom();
            this.mMode = 0;
            this.mManagedButton = 0;
            SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.removeCallbacks(this);
            if (SeslSpinningDatePickerSpinnerDelegate.this.mIncrementVirtualButtonPressed) {
                SeslSpinningDatePickerSpinnerDelegate.this.mIncrementVirtualButtonPressed = false;
                SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate = SeslSpinningDatePickerSpinnerDelegate.this;
                seslSpinningDatePickerSpinnerDelegate.mDelegator.invalidate(0, seslSpinningDatePickerSpinnerDelegate.mBottomSelectionDividerBottom, right, bottom);
            }
            if (SeslSpinningDatePickerSpinnerDelegate.this.mDecrementVirtualButtonPressed) {
                SeslSpinningDatePickerSpinnerDelegate.this.mDecrementVirtualButtonPressed = false;
                SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate2 = SeslSpinningDatePickerSpinnerDelegate.this;
                seslSpinningDatePickerSpinnerDelegate2.mDelegator.invalidate(0, 0, right, seslSpinningDatePickerSpinnerDelegate2.mTopSelectionDividerTop);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int right = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getRight();
            int bottom = SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.getBottom();
            int i = this.mMode;
            if (i == 1) {
                int i2 = this.mManagedButton;
                if (i2 == 1) {
                    SeslSpinningDatePickerSpinnerDelegate.this.mIncrementVirtualButtonPressed = true;
                    SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate = SeslSpinningDatePickerSpinnerDelegate.this;
                    seslSpinningDatePickerSpinnerDelegate.mDelegator.invalidate(0, seslSpinningDatePickerSpinnerDelegate.mBottomSelectionDividerBottom, right, bottom);
                    return;
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SeslSpinningDatePickerSpinnerDelegate.this.mDecrementVirtualButtonPressed = true;
                    SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate2 = SeslSpinningDatePickerSpinnerDelegate.this;
                    seslSpinningDatePickerSpinnerDelegate2.mDelegator.invalidate(0, 0, right, seslSpinningDatePickerSpinnerDelegate2.mTopSelectionDividerTop);
                    return;
                }
            }
            if (i != 2) {
                return;
            }
            int i4 = this.mManagedButton;
            if (i4 == 1) {
                if (!SeslSpinningDatePickerSpinnerDelegate.this.mIncrementVirtualButtonPressed) {
                    SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                SeslSpinningDatePickerSpinnerDelegate.access$2080(SeslSpinningDatePickerSpinnerDelegate.this, 1);
                SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate3 = SeslSpinningDatePickerSpinnerDelegate.this;
                seslSpinningDatePickerSpinnerDelegate3.mDelegator.invalidate(0, seslSpinningDatePickerSpinnerDelegate3.mBottomSelectionDividerBottom, right, bottom);
                return;
            }
            if (i4 != 2) {
                return;
            }
            if (!SeslSpinningDatePickerSpinnerDelegate.this.mDecrementVirtualButtonPressed) {
                SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.postDelayed(this, ViewConfiguration.getPressedStateDuration());
            }
            SeslSpinningDatePickerSpinnerDelegate.access$2280(SeslSpinningDatePickerSpinnerDelegate.this, 1);
            SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate4 = SeslSpinningDatePickerSpinnerDelegate.this;
            seslSpinningDatePickerSpinnerDelegate4.mDelegator.invalidate(0, 0, right, seslSpinningDatePickerSpinnerDelegate4.mTopSelectionDividerTop);
        }
    }

    public SeslSpinningDatePickerSpinnerDelegate(SeslSpinningDatePickerSpinner seslSpinningDatePickerSpinner, Context context, AttributeSet attributeSet, int i, int i2) {
        int i4;
        super(seslSpinningDatePickerSpinner, context);
        this.mLongPressUpdateInterval = 300L;
        this.mSelectorIndexToStringCache = new HashMap<>();
        this.mSelectorIndices = new Calendar[5];
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mWrapSelectorWheelPreferred = true;
        this.mScrollState = 0;
        this.mChangeValueBy = 1;
        this.mIsLongClicked = false;
        this.mIsStartingAnimation = false;
        this.mReservedStartAnimation = false;
        this.mIsLongPressed = false;
        this.mCustomTypefaceSet = false;
        this.mIsValueChanged = false;
        this.mPathClassLoader = null;
        this.mSolarLunarConverter = null;
        PathInterpolator pathInterpolator = new PathInterpolator(0.5f, 0.0f, 0.4f, 1.0f);
        this.SIZE_PATH_INTERPOLATOR = pathInterpolator;
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.17f, 0.17f, 0.83f, 0.83f);
        this.ALPHA_PATH_INTERPOLATOR = pathInterpolator2;
        this.mActivatedAlpha = 0.4f;
        this.mIdleAlpha = 0.1f;
        this.mAlpha = 0.1f;
        this.mInitialAlpha = 1.0f;
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SeslSpinningDatePickerSpinnerDelegate.this.mAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.invalidate();
            }
        };
        this.mColorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SeslSpinningDatePickerSpinnerDelegate.this.mTextColor = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.invalidate();
            }
        };
        this.mSpringAnimationUpdateListener = new DynamicAnimation.OnAnimationUpdateListener() { // from class: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate.4
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                float f5 = f - SeslSpinningDatePickerSpinnerDelegate.this.mPreviousSpringY;
                if (!SeslSpinningDatePickerSpinnerDelegate.this.mSpringFlingRunning && Math.round(f5) == 0) {
                    dynamicAnimation.cancel();
                    SeslSpinningDatePickerSpinnerDelegate.this.ensureScrollWheelAdjusted();
                    return;
                }
                if (Math.round(f5) == 0) {
                    SeslSpinningDatePickerSpinnerDelegate.this.mSpringFlingRunning = false;
                }
                SeslSpinningDatePickerSpinnerDelegate.this.scrollBy(0, Math.round(f5));
                SeslSpinningDatePickerSpinnerDelegate.this.mPreviousSpringY = f;
                SeslSpinningDatePickerSpinnerDelegate.this.mDelegator.invalidate();
            }
        };
        this.mSpringAnimationEndListener = new DynamicAnimation.OnAnimationEndListener() { // from class: androidx.picker.widget.SeslSpinningDatePickerSpinnerDelegate.5
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
                SeslSpinningDatePickerSpinnerDelegate.this.mSpringFlingRunning = false;
                SeslSpinningDatePickerSpinnerDelegate.this.mGravityScroller.forceFinished(true);
                SeslSpinningDatePickerSpinnerDelegate.this.startFadeAnimation(true);
            }
        };
        Resources resources = this.mContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C3623R.dimen.sesl_number_picker_spinner_height);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C3623R.dimen.sesl_number_picker_spinner_width);
        this.mHeightRatio = resources.getDimensionPixelSize(C3623R.dimen.sesl_number_picker_spinner_edit_text_height) / dimensionPixelSize;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3623R.styleable.NumberPicker, i, i2);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3623R.styleable.NumberPicker_internalMinHeight, -1);
        this.mMinHeight = dimensionPixelSize3;
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3623R.styleable.NumberPicker_internalMaxHeight, dimensionPixelSize);
        this.mMaxHeight = dimensionPixelSize4;
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3623R.styleable.NumberPicker_internalMinWidth, dimensionPixelSize2);
        this.mMinWidth = dimensionPixelSize5;
        this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3623R.styleable.NumberPicker_internalMaxWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
        this.mValue = getCalendarForLocale(this.mValue, Locale.getDefault());
        this.mMinValue = getCalendarForLocale(this.mMinValue, Locale.getDefault());
        this.mMaxValue = getCalendarForLocale(this.mMaxValue, Locale.getDefault());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C3623R.styleable.DatePicker, i, i2);
        try {
            this.mMinValue.set(typedArrayObtainStyledAttributes2.getInt(C3623R.styleable.DatePicker_android_startYear, DEFAULT_START_YEAR), 0, 1);
            this.mMaxValue.set(typedArrayObtainStyledAttributes2.getInt(C3623R.styleable.DatePicker_android_endYear, DEFAULT_END_YEAR), 11, 31);
            if (dimensionPixelSize3 != -1 && dimensionPixelSize4 != -1 && dimensionPixelSize3 > dimensionPixelSize4) {
                throw new IllegalArgumentException("minHeight > maxHeight");
            }
            if (dimensionPixelSize5 != -1 && (i4 = this.mMaxWidth) != -1 && dimensionPixelSize5 > i4) {
                throw new IllegalArgumentException("minWidth > maxWidth");
            }
            this.mSelectionDividerHeight = (int) TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics());
            this.mComputeMaxWidth = this.mMaxWidth == -1;
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0419R.attr.colorPrimaryDark, typedValue, true);
            int i5 = typedValue.resourceId;
            this.mVirtualButtonFocusedDrawable = new ColorDrawable(((i5 != 0 ? ResourcesCompat.getColor(resources, i5, null) : typedValue.data) & 16777215) | 855638016);
            if (!SeslMisc.isLightTheme(this.mContext)) {
                this.mIdleAlpha = 0.2f;
                this.mAlpha = 0.2f;
            }
            this.mPressedStateHelper = new PressedStateHelper();
            this.mDelegator.setWillNotDraw(false);
            ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C3623R.layout.sesl_spinning_date_picker_spinner, (ViewGroup) this.mDelegator, true);
            EditText editText = (EditText) this.mDelegator.findViewById(C3623R.id.datepicker_input);
            this.mInputText = editText;
            editText.setIncludeFontPadding(false);
            Typeface typefaceDefaultFromStyle = Typeface.defaultFromStyle(1);
            this.mDefaultTypeface = typefaceDefaultFromStyle;
            Typeface typefaceCreate = Typeface.create("sec-roboto-condensed-light", 1);
            this.mLegacyTypeface = typefaceCreate;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 34) {
                this.mPickerTypeface = Typeface.create(Typeface.create("sec", 0), 600, false);
            } else {
                this.mPickerTypeface = Typeface.create("sec-roboto-light", 1);
            }
            if (typefaceDefaultFromStyle.equals(this.mPickerTypeface)) {
                if (typefaceCreate.equals(this.mPickerTypeface)) {
                    this.mPickerTypeface = Typeface.create("sans-serif-thin", 1);
                } else {
                    this.mPickerTypeface = typefaceCreate;
                }
            }
            this.mPickerSubTypeface = Typeface.create(this.mPickerTypeface, 0);
            if (SeslConfigurationReflector.isDexEnabled(resources.getConfiguration())) {
                this.mIdleAlpha = 0.2f;
                this.mAlpha = 0.2f;
            } else {
                Typeface openThemeTypeface = SeslPickerBasicUtils.getOpenThemeTypeface(this.mContext);
                if (openThemeTypeface != null) {
                    this.mPickerTypeface = openThemeTypeface;
                    this.mPickerSubTypeface = Typeface.create(openThemeTypeface, 0);
                }
            }
            if (isCharacterNumberLanguage()) {
                this.mPickerTypeface = typefaceDefaultFromStyle;
                this.mPickerSubTypeface = Typeface.create(typefaceDefaultFromStyle, 0);
            }
            this.mIsHcfEnabled = isHighContrastFontEnabled();
            this.mHcfFocusedTypefaceBold = Typeface.create(this.mPickerTypeface, 1);
            this.mHcfUnfocusedTextSizeDiff = (int) TypedValue.applyDimension(1, 2.0f, this.mContext.getResources().getDisplayMetrics());
            setInputTextTypeface();
            ColorStateList textColors = editText.getTextColors();
            int[] enableStateSet = this.mDelegator.getEnableStateSet();
            if (i6 > 29) {
                this.mTextColorIdle = textColors.getColorForState(enableStateSet, -1);
            } else {
                this.mTextColorIdle = ResourcesCompat.getColor(resources, C3623R.color.sesl_number_picker_text_color_scroll, context.getTheme());
            }
            int color = ResourcesCompat.getColor(resources, C3623R.color.sesl_number_picker_text_color_scroll, context.getTheme());
            this.mTextColorScrolling = color;
            this.mTextColor = this.mTextColorIdle;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 2;
            this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 4;
            this.mTextSize = (int) editText.getTextSize();
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(this.mTextSize);
            paint.setTypeface(this.mPickerTypeface);
            paint.setColor(this.mTextColor);
            this.mSelectorWheelPaint = paint;
            this.mInitialAlpha = paint.getAlpha() / 255.0f;
            this.mCustomScroller = new Scroller(this.mContext, pathInterpolator, true);
            Scroller scroller = new Scroller(this.mContext, null, true);
            this.mLinearScroller = scroller;
            this.mFlingScroller = scroller;
            this.mAdjustScroller = new Scroller(this.mContext, new PathInterpolator(0.4f, 0.0f, 0.3f, 1.0f));
            this.mGravityScroller = new OverScroller(this.mContext, new DecelerateInterpolator());
            this.mHolder = new FloatValueHolder();
            SpringAnimation springAnimation = new SpringAnimation(this.mHolder);
            this.mSpringAnimation = springAnimation;
            springAnimation.setSpring(new SpringForce());
            this.mSpringAnimation.setMinimumVisibleChange(1.0f);
            this.mSpringAnimation.addUpdateListener(this.mSpringAnimationUpdateListener);
            this.mSpringAnimation.addEndListener(this.mSpringAnimationEndListener);
            this.mSpringAnimation.getSpring().setStiffness(7.0f);
            this.mSpringAnimation.getSpring().setDampingRatio(0.99f);
            setFormatter(SeslSpinningDatePickerSpinner.getDateFormatter());
            this.mDelegator.setVerticalScrollBarEnabled(false);
            if (this.mDelegator.getImportantForAccessibility() == 0) {
                this.mDelegator.setImportantForAccessibility(1);
            }
            this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
            this.mHapticPreDrawListener = new HapticPreDrawListener(null);
            this.mPickerVibrateIndex = SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(32);
            this.mPickerSoundIndex = SeslAudioManagerReflector.getField_SOUND_TIME_PICKER_SCROLL();
            this.mDelegator.setFocusableInTouchMode(false);
            this.mDelegator.setDescendantFocusability(131072);
            this.mDelegator.setDefaultFocusHighlightEnabled(false);
            this.mPickerContentDescription = "";
            SeslViewReflector.semSetDirectPenInputEnabled(editText, false);
            this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mActivatedAlpha, this.mIdleAlpha);
            this.mFadeOutAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setInterpolator(pathInterpolator2);
            this.mFadeOutAnimator.setDuration(200L);
            this.mFadeOutAnimator.setStartDelay(100L);
            this.mFadeOutAnimator.addUpdateListener(this.mUpdateListener);
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.mIdleAlpha, this.mActivatedAlpha);
            this.mFadeInAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setInterpolator(pathInterpolator2);
            this.mFadeInAnimator.setDuration(200L);
            this.mFadeInAnimator.addUpdateListener(this.mUpdateListener);
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.mTextColorIdle), Integer.valueOf(color));
            this.mColorInAnimator = valueAnimatorOfObject;
            valueAnimatorOfObject.setInterpolator(pathInterpolator2);
            this.mColorInAnimator.setDuration(200L);
            this.mColorInAnimator.addUpdateListener(this.mColorUpdateListener);
            ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(color), Integer.valueOf(this.mTextColorIdle));
            this.mColorOutAnimator = valueAnimatorOfObject2;
            valueAnimatorOfObject2.setInterpolator(pathInterpolator2);
            this.mColorOutAnimator.setDuration(200L);
            this.mColorOutAnimator.setStartDelay(100L);
            this.mColorOutAnimator.addUpdateListener(this.mColorUpdateListener);
            this.mShortMonths = new DateFormatSymbols().getShortMonths();
            this.mLongMonths = new DateFormatSymbols().getMonths();
        } finally {
            typedArrayObtainStyledAttributes2.recycle();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    public static /* synthetic */ boolean access$2080(SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate, int i) {
        ?? r2 = (byte) (i ^ (seslSpinningDatePickerSpinnerDelegate.mIncrementVirtualButtonPressed ? 1 : 0));
        seslSpinningDatePickerSpinnerDelegate.mIncrementVirtualButtonPressed = r2;
        return r2;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    public static /* synthetic */ boolean access$2280(SeslSpinningDatePickerSpinnerDelegate seslSpinningDatePickerSpinnerDelegate, int i) {
        ?? r2 = (byte) (i ^ (seslSpinningDatePickerSpinnerDelegate.mDecrementVirtualButtonPressed ? 1 : 0));
        seslSpinningDatePickerSpinnerDelegate.mDecrementVirtualButtonPressed = r2;
        return r2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeValueByOne(boolean z) {
        int i;
        if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
            moveToFinalScrollerPosition(this.mAdjustScroller);
        }
        this.mPreviousScrollerY = 0;
        this.mChangeValueBy = 1;
        if (this.mLongPressed_FIRST_SCROLL) {
            this.mLongPressed_FIRST_SCROLL = false;
            this.mLongPressed_SECOND_SCROLL = true;
        } else if (this.mLongPressed_SECOND_SCROLL) {
            this.mLongPressed_SECOND_SCROLL = false;
            this.mLongPressed_THIRD_SCROLL = true;
            if (getValue().get(5) % 10 == 0) {
                this.mChangeValueBy = 10;
            } else if (z) {
                this.mChangeValueBy = 10 - (getValue().get(5) % 10);
            } else {
                this.mChangeValueBy = getValue().get(5) % 10;
            }
        } else if (this.mLongPressed_THIRD_SCROLL) {
            this.mChangeValueBy = 10;
        }
        boolean z2 = this.mIsLongPressed;
        if (z2 && this.mSkipNumbers) {
            this.mLongPressUpdateInterval = 600L;
            i = 200;
        } else if (z2) {
            this.mChangeValueBy = 1;
            this.mLongPressUpdateInterval = 300L;
            i = 100;
        } else {
            i = 500;
        }
        int i2 = i;
        int i4 = this.mChangeValueBy;
        this.mLongPressCount = i4 - 1;
        if (z) {
            this.mFlingScroller.startScroll(0, 0, 0, (-this.mSelectorElementHeight) * i4, i2);
        } else {
            this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight * i4, i2);
        }
        this.mDelegator.invalidate();
    }

    private void clearCalendar(Calendar calendar, Calendar calendar2) {
        calendar.set(1, calendar2.get(1));
        calendar.set(2, calendar2.get(2));
        calendar.set(5, calendar2.get(5));
    }

    private void decrementSelectorIndices(Calendar[] calendarArr) {
        System.arraycopy(calendarArr, 0, calendarArr, 1, calendarArr.length - 1);
        Calendar calendar = (Calendar) calendarArr[1].clone();
        calendar.add(5, -1);
        if (this.mWrapSelectorWheel && calendar.compareTo(this.mMinValue) < 0) {
            clearCalendar(calendar, this.mMaxValue);
        }
        calendarArr[0] = calendar;
        ensureCachedScrollSelectorValue(calendar);
    }

    private void ensureCachedScrollSelectorValue(Calendar calendar) {
        HashMap<Calendar, String> map = this.mSelectorIndexToStringCache;
        if (map.get(calendar) != null) {
            return;
        }
        map.put(calendar, (calendar.compareTo(this.mMinValue) < 0 || calendar.compareTo(this.mMaxValue) > 0) ? "" : this.mIsLunar ? formatDateForLunar(calendar) : formatDate(calendar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureScrollWheelAdjusted() {
        return ensureScrollWheelAdjusted(0);
    }

    private void fling(int i) {
        if (!this.mWrapSelectorWheel && i > 0 && getValue().equals(getMinValue())) {
            startFadeAnimation(true);
            return;
        }
        if (!this.mWrapSelectorWheel && i < 0 && getValue().equals(getMaxValue())) {
            startFadeAnimation(true);
            return;
        }
        this.mPreviousScrollerY = 0;
        Math.abs(i);
        this.mPreviousSpringY = this.mCurrentScrollOffset;
        this.mSpringAnimation.setStartVelocity(i);
        this.mGravityScroller.forceFinished(true);
        this.mGravityScroller.fling(0, this.mCurrentScrollOffset, 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int iRound = Math.round((this.mGravityScroller.getFinalY() + this.mCurrentScrollOffset) / this.mSelectorElementHeight);
        int i2 = this.mSelectorElementHeight;
        int i4 = this.mInitialScrollOffset;
        int i5 = (iRound * i2) + i4;
        float fMax = i > 0 ? Math.max(i5, i2 + i4) : Math.min(i5, (-i2) + i4);
        this.mSpringAnimation.setStartValue(this.mCurrentScrollOffset);
        this.mSpringFlingRunning = true;
        this.mSpringAnimation.animateToFinalPosition(fMax);
        this.mDelegator.invalidate();
    }

    private String formatDate(Calendar calendar) {
        SeslSpinningDatePickerSpinner.Formatter formatter = this.mFormatter;
        return formatter == null ? formatDateWithLocale(calendar) : formatter instanceof SeslSpinningDatePickerSpinner.DateFormatter ? ((SeslSpinningDatePickerSpinner.DateFormatter) formatter).format(calendar, this.mContext) : formatter.format(calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatDateForAccessibility(Calendar calendar) {
        SeslSpinningDatePickerSpinner.Formatter formatter = this.mFormatter;
        return formatter == null ? formatDateWithLocale(calendar) : formatter instanceof SeslSpinningDatePickerSpinner.DateFormatter ? ((SeslSpinningDatePickerSpinner.DateFormatter) formatter).formatForAccessibility(calendar, this.mContext) : formatter.format(calendar);
    }

    private String formatDateForLunar(Calendar calendar) {
        int iLastIndexOf;
        Calendar calendar2 = (Calendar) calendar.clone();
        SeslSpinningDatePicker.LunarDate lunarDate = new SeslSpinningDatePicker.LunarDate();
        SeslSpinningDatePickerSpinner.Formatter formatter = this.mFormatter;
        String dateWithLocale = formatter == null ? formatDateWithLocale(calendar2) : formatter instanceof SeslSpinningDatePickerSpinner.DateFormatter ? ((SeslSpinningDatePickerSpinner.DateFormatter) formatter).format(calendar2, this.mContext) : formatter.format(calendar2);
        String dayWithLocale = getDayWithLocale(lunarDate.day);
        String dayWithLocale2 = formatDayWithLocale(calendar2);
        String monthWithLocale = getMonthWithLocale(lunarDate.month);
        String monthWithLocale2 = formatMonthWithLocale(calendar2);
        StringBuilder sb = new StringBuilder(dateWithLocale);
        if (Locale.getDefault().getLanguage() == LangPackConfigConstants.LANGUAGE_CODE_VI) {
            iLastIndexOf = sb.lastIndexOf(" " + dayWithLocale2) + 1;
        } else {
            iLastIndexOf = sb.lastIndexOf(dayWithLocale2);
        }
        if (iLastIndexOf != -1) {
            sb.replace(iLastIndexOf, dayWithLocale2.length() + iLastIndexOf, dayWithLocale);
        }
        int iLastIndexOf2 = sb.lastIndexOf(monthWithLocale2);
        if (iLastIndexOf2 != -1) {
            sb.replace(iLastIndexOf2, monthWithLocale2.length() + iLastIndexOf2, monthWithLocale);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatDateForLunarForAccessibility(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        SeslSpinningDatePicker.LunarDate lunarDate = new SeslSpinningDatePicker.LunarDate();
        SeslSpinningDatePickerSpinner.Formatter formatter = this.mFormatter;
        String dateWithLocaleForAccessibility = formatter == null ? formatDateWithLocaleForAccessibility(calendar2) : formatter instanceof SeslSpinningDatePickerSpinner.DateFormatter ? ((SeslSpinningDatePickerSpinner.DateFormatter) formatter).formatForAccessibility(calendar2, this.mContext) : formatter.format(calendar2);
        String dayWithLocale = getDayWithLocale(lunarDate.day);
        String dayWithLocale2 = formatDayWithLocale(calendar2);
        String monthWithLocaleForAccessibility = getMonthWithLocaleForAccessibility(lunarDate.month);
        String monthWithLocaleForAccessibility2 = formatMonthWithLocaleForAccessibility(calendar2);
        StringBuilder sb = new StringBuilder(dateWithLocaleForAccessibility);
        int iLastIndexOf = sb.lastIndexOf(dayWithLocale2);
        if (iLastIndexOf != -1) {
            sb.replace(iLastIndexOf, dayWithLocale2.length() + iLastIndexOf, dayWithLocale);
        }
        int iLastIndexOf2 = sb.lastIndexOf(monthWithLocaleForAccessibility2);
        if (iLastIndexOf2 != -1) {
            sb.replace(iLastIndexOf2, monthWithLocaleForAccessibility2.length() + iLastIndexOf2, monthWithLocaleForAccessibility);
        }
        return sb.toString();
    }

    private static String formatDateWithLocale(Calendar calendar) {
        return new SimpleDateFormat("EEE, MMM d", Locale.getDefault()).format(calendar.getTime());
    }

    private static String formatDateWithLocaleForAccessibility(Calendar calendar) {
        return new SimpleDateFormat("EEEE, MMMM d", Locale.getDefault()).format(calendar.getTime());
    }

    private static String formatDayWithLocale(Calendar calendar) {
        return new SimpleDateFormat("d", Locale.getDefault()).format(calendar.getTime());
    }

    private static String formatMonthWithLocale(Calendar calendar) {
        return new SimpleDateFormat("MMM", Locale.getDefault()).format(calendar.getTime());
    }

    private static String formatMonthWithLocaleForAccessibility(Calendar calendar) {
        return new SimpleDateFormat("MMMM", Locale.getDefault()).format(calendar.getTime());
    }

    private static String formatNumberWithLocale(int i) {
        return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
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

    private static String getDayWithLocale(int i) {
        return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
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

    private String getMonthWithLocale(int i) {
        return this.mShortMonths[i];
    }

    private String getMonthWithLocaleForAccessibility(int i) {
        return this.mLongMonths[i];
    }

    private Calendar getSelectedPos(String str) {
        Calendar calendar = SeslSpinningDatePickerSpinner.getDateFormatter().parse(str);
        return calendar == null ? (Calendar) this.mMinValue.clone() : calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Calendar getWrappedSelectorIndex(Calendar calendar) {
        if (calendar.compareTo(this.mMaxValue) > 0) {
            Calendar calendar2 = (Calendar) this.mMinValue.clone();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            calendar2.add(5, ((int) timeUnit.toDays(calendar.getTimeInMillis() - this.mMinValue.getTimeInMillis())) % (((int) timeUnit.toDays(this.mMaxValue.getTimeInMillis() - this.mMinValue.getTimeInMillis())) + 1));
            return calendar2;
        }
        if (calendar.compareTo(this.mMinValue) >= 0) {
            return calendar;
        }
        Calendar calendar3 = (Calendar) this.mMaxValue.clone();
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        calendar3.add(5, -(((int) timeUnit2.toDays(this.mMaxValue.getTimeInMillis() - calendar.getTimeInMillis())) % (((int) timeUnit2.toDays(this.mMaxValue.getTimeInMillis() - this.mMinValue.getTimeInMillis())) + 1)));
        return calendar3;
    }

    private void incrementSelectorIndices(Calendar[] calendarArr) {
        System.arraycopy(calendarArr, 1, calendarArr, 0, calendarArr.length - 1);
        Calendar calendar = (Calendar) calendarArr[calendarArr.length - 2].clone();
        calendar.add(5, 1);
        if (this.mWrapSelectorWheel && calendar.compareTo(this.mMaxValue) > 0) {
            clearCalendar(calendar, this.mMinValue);
        }
        calendarArr[calendarArr.length - 1] = calendar;
        ensureCachedScrollSelectorValue(calendar);
    }

    private void initializeSelectorWheel() {
        if (this.mIsStartingAnimation) {
            if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
                moveToFinalScrollerPosition(this.mAdjustScroller);
            }
            stopScrollAnimation();
        }
        if (!this.mIsStartingAnimation) {
            initializeSelectorWheelIndices();
        }
        int bottom = (int) ((((this.mDelegator.getBottom() - this.mDelegator.getTop()) - (this.mTextSize * 3)) / 3.0f) + 0.5f);
        this.mSelectorTextGapHeight = bottom;
        int i = this.mTextSize + bottom;
        this.mSelectorElementHeight = i;
        int height = this.mModifiedTxtHeight;
        if (height > i) {
            height = this.mDelegator.getHeight() / 3;
        }
        this.mValueChangeOffset = height;
        int top = ((this.mModifiedTxtHeight / 2) + this.mInputText.getTop()) - this.mSelectorElementHeight;
        this.mInitialScrollOffset = top;
        this.mCurrentScrollOffset = top;
        ((SeslSpinningDatePickerSpinner.CustomEditText) this.mInputText).setEditTextPosition(((int) (((this.mSelectorWheelPaint.descent() - this.mSelectorWheelPaint.ascent()) / 2.0f) - this.mSelectorWheelPaint.descent())) - (this.mInputText.getBaseline() - (this.mModifiedTxtHeight / 2)));
        if (this.mReservedStartAnimation) {
            startAnimation(0, this.mAnimationListener);
            this.mReservedStartAnimation = false;
        }
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        Calendar[] calendarArr = this.mSelectorIndices;
        Calendar value = getValue();
        for (int i = 0; i < this.mSelectorIndices.length; i++) {
            Calendar wrappedSelectorIndex = (Calendar) value.clone();
            wrappedSelectorIndex.add(5, i - 2);
            if (this.mWrapSelectorWheel) {
                wrappedSelectorIndex = getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            calendarArr[i] = wrappedSelectorIndex;
            ensureCachedScrollSelectorValue(wrappedSelectorIndex);
        }
    }

    private boolean isCharacterNumberLanguage() {
        String language = Locale.getDefault().getLanguage();
        return "ar".equals(language) || MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(language) || "my".equals(language);
    }

    private boolean isHighContrastFontEnabled() {
        return SeslViewReflector.isHighContrastTextEnabled(this.mInputText);
    }

    private int makeMeasureSpec(int i, int i2) {
        if (i2 != -1) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
            }
            if (mode == 0) {
                return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            }
            if (mode != 1073741824) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(mode, "Unknown measure mode: "));
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean moveToFinalScrollerPosition(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i = this.mSelectorElementHeight;
        if (i == 0) {
            return false;
        }
        int i2 = this.mInitialScrollOffset - (this.mCurrentScrollOffset + finalY);
        if (i2 == 0) {
            return false;
        }
        int i4 = i2 % i;
        int iAbs = Math.abs(i4);
        int i5 = this.mSelectorElementHeight;
        if (iAbs > i5 / 2) {
            i4 = i4 > 0 ? i4 - i5 : i4 + i5;
        }
        scrollBy(0, finalY + i4);
        return true;
    }

    private boolean needCompareEqualMonthLanguage() {
        return LangPackConfigConstants.LANGUAGE_CODE_VI.equals(Locale.getDefault().getLanguage());
    }

    private void notifyChange(Calendar calendar) {
        if (this.mAccessibilityManager.isEnabled() && !this.mIsStartingAnimation) {
            Calendar wrappedSelectorIndex = getWrappedSelectorIndex(this.mValue);
            if (wrappedSelectorIndex.compareTo(this.mMaxValue) <= 0) {
                if (this.mIsLunar) {
                    formatDateForLunarForAccessibility(wrappedSelectorIndex);
                } else {
                    formatDateForAccessibility(wrappedSelectorIndex);
                }
            }
            this.mDelegator.sendAccessibilityEvent(4);
        }
        SeslSpinningDatePickerSpinner.OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
        if (onValueChangeListener != null) {
            if (!this.mIsLunar) {
                onValueChangeListener.onValueChange(this.mDelegator, calendar, this.mValue, false, null);
                return;
            }
            SeslSpinningDatePicker.LunarDate lunarDate = new SeslSpinningDatePicker.LunarDate();
            this.mOnValueChangeListener.onValueChange(this.mDelegator, convertSolarToLunar(calendar, null), convertSolarToLunar(this.mValue, lunarDate), lunarDate.isLeapMonth, lunarDate);
        }
    }

    private void onScrollStateChange(int i) {
        if (this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        SeslSpinningDatePickerSpinner.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this.mDelegator, i);
        }
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller == this.mFlingScroller) {
            onScrollStateChange(0);
        }
    }

    private void playSoundAndHapticFeedback() {
        this.mAudioManager.playSoundEffect(this.mPickerSoundIndex);
        if (this.mHapticPreDrawListener.mSkipHapticCalls) {
            return;
        }
        this.mDelegator.performHapticFeedback(this.mPickerVibrateIndex);
        this.mHapticPreDrawListener.mSkipHapticCalls = true;
    }

    private void postChangeCurrentByOneFromLongPress(boolean z, long j) {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand == null) {
            this.mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } else {
            this.mDelegator.removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.mIsLongPressed = true;
        this.mLongPressed_FIRST_SCROLL = true;
        this.mChangeCurrentByOneFromLongPressCommand.setStep(z);
        this.mDelegator.postDelayed(this.mChangeCurrentByOneFromLongPressCommand, j);
    }

    private void removeAllCallbacks() {
        if (this.mIsLongPressed) {
            this.mIsLongPressed = false;
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
        }
        this.mLongPressed_FIRST_SCROLL = false;
        this.mLongPressed_SECOND_SCROLL = false;
        this.mLongPressed_THIRD_SCROLL = false;
        this.mChangeValueBy = 1;
        this.mLongPressUpdateInterval = 300L;
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            this.mDelegator.removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.mPressedStateHelper.cancel();
    }

    private void removeChangeCurrentByOneFromLongPress() {
        if (this.mIsLongPressed) {
            this.mIsLongPressed = false;
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
        }
        this.mLongPressed_FIRST_SCROLL = false;
        this.mLongPressed_SECOND_SCROLL = false;
        this.mLongPressed_THIRD_SCROLL = false;
        this.mChangeValueBy = 1;
        this.mLongPressUpdateInterval = 300L;
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            this.mDelegator.removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
    }

    private int resolveSizeAndStateRespectingMinSize(int i, int i2, int i4) {
        return i != -1 ? View.resolveSizeAndState(Math.max(i, i2), i4, 0) : i2;
    }

    private void setHcfTextAppearance(boolean z) {
        if (this.mIsHcfEnabled) {
            if (z) {
                this.mSelectorWheelPaint.setTypeface(this.mHcfFocusedTypefaceBold);
            } else {
                this.mSelectorWheelPaint.setTypeface(this.mPickerSubTypeface);
            }
        }
    }

    private void setInputTextTypeface() {
        if (this.mIsHcfEnabled) {
            this.mInputText.setTypeface(this.mHcfFocusedTypefaceBold);
        } else {
            this.mInputText.setTypeface(this.mPickerTypeface);
        }
    }

    private void setValueInternal(Calendar calendar, boolean z) {
        Calendar wrappedSelectorIndex;
        if (this.mWrapSelectorWheel) {
            wrappedSelectorIndex = getWrappedSelectorIndex(calendar);
        } else {
            int iCompareTo = calendar.compareTo(this.mMinValue);
            Object objClone = calendar;
            if (iCompareTo < 0) {
                objClone = this.mMinValue.clone();
            }
            Calendar calendar2 = (Calendar) objClone;
            int iCompareTo2 = calendar2.compareTo(this.mMaxValue);
            Object objClone2 = calendar2;
            if (iCompareTo2 > 0) {
                objClone2 = this.mMaxValue.clone();
            }
            wrappedSelectorIndex = (Calendar) objClone2;
        }
        Calendar calendar3 = (Calendar) this.mValue.clone();
        clearCalendar(this.mValue, wrappedSelectorIndex);
        if (z) {
            notifyChange(calendar3);
        }
        initializeSelectorWheelIndices();
        this.mDelegator.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFadeAnimation(boolean z) {
        if (z) {
            this.mFadeOutAnimator.setStartDelay(this.mFlingScroller.getDuration() + 100);
            this.mColorOutAnimator.setStartDelay((this.mFlingScroller.isFinished() ? 0 : this.mFlingScroller.getDuration()) + 100);
            this.mColorOutAnimator.start();
            this.mFadeOutAnimator.start();
            return;
        }
        this.mFadeInAnimator.setFloatValues(this.mAlpha, this.mActivatedAlpha);
        this.mColorInAnimator.setIntValues(this.mTextColor, this.mTextColorScrolling);
        this.mColorOutAnimator.cancel();
        this.mFadeOutAnimator.cancel();
        this.mColorInAnimator.start();
        this.mFadeInAnimator.start();
    }

    private void stopFlingAnimation() {
        this.mFlingScroller.abortAnimation();
        this.mAdjustScroller.abortAnimation();
        this.mGravityScroller.abortAnimation();
        this.mSpringAnimation.cancel();
        this.mSpringFlingRunning = false;
    }

    private void stopScrollAnimation() {
        this.mFlingScroller.abortAnimation();
        this.mAdjustScroller.abortAnimation();
        this.mGravityScroller.abortAnimation();
        this.mSpringAnimation.cancel();
        this.mSpringFlingRunning = false;
        if (!this.mIsStartingAnimation && !moveToFinalScrollerPosition(this.mFlingScroller)) {
            moveToFinalScrollerPosition(this.mAdjustScroller);
        }
        ensureScrollWheelAdjusted();
    }

    private void tryComputeMaxWidth() {
        if (this.mComputeMaxWidth) {
            float f = 0.0f;
            float f4 = 0.0f;
            for (int i = 0; i <= 9; i++) {
                float fMeasureText = this.mSelectorWheelPaint.measureText(formatNumberWithLocale(i));
                if (fMeasureText > f4) {
                    f4 = fMeasureText;
                }
            }
            float f5 = (int) (2 * f4);
            float f6 = 0.0f;
            for (String str : new android.icu.text.DateFormatSymbols(Locale.getDefault()).getShortWeekdays()) {
                float fMeasureText2 = this.mSelectorWheelPaint.measureText(str);
                if (fMeasureText2 > f6) {
                    f6 = fMeasureText2;
                }
            }
            for (String str2 : new android.icu.text.DateFormatSymbols(Locale.getDefault()).getShortMonths()) {
                float fMeasureText3 = this.mSelectorWheelPaint.measureText(str2);
                if (fMeasureText3 > f) {
                    f = fMeasureText3;
                }
            }
            int paddingRight = this.mInputText.getPaddingRight() + this.mInputText.getPaddingLeft() + ((int) (f5 + f6 + f + (this.mSelectorWheelPaint.measureText(" ") * 2.0f) + this.mSelectorWheelPaint.measureText(",")));
            if (isHighContrastFontEnabled()) {
                paddingRight += ((int) Math.ceil(SeslPaintReflector.getHCTStrokeWidth(this.mSelectorWheelPaint) / 2.0f)) * 13;
            }
            if (this.mMaxWidth != paddingRight) {
                int i2 = this.mMinWidth;
                if (paddingRight > i2) {
                    this.mMaxWidth = paddingRight;
                } else {
                    this.mMaxWidth = i2;
                }
                this.mDelegator.invalidate();
            }
        }
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = this.mLastHoveredChildVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.mLastHoveredChildVirtualViewId = i;
        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider();
        accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(i, 128);
        accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(i2, 256);
    }

    private void updateWrapSelectorWheel() {
        boolean z = ((int) TimeUnit.MILLISECONDS.toDays(this.mMaxValue.getTimeInMillis() - this.mMinValue.getTimeInMillis())) >= this.mSelectorIndices.length && this.mWrapSelectorWheelPreferred;
        if (this.mWrapSelectorWheel != z) {
            this.mWrapSelectorWheel = z;
            initializeSelectorWheelIndices();
            this.mDelegator.invalidate();
        }
    }

    private void validateInputTextView(View view) {
        String strValueOf = String.valueOf(((TextView) view).getText());
        Calendar selectedPos = getSelectedPos(strValueOf);
        if (TextUtils.isEmpty(strValueOf) || this.mValue.equals(selectedPos)) {
            return;
        }
        setValueInternal(selectedPos, true);
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void computeScroll() {
        if (this.mSpringFlingRunning) {
            return;
        }
        Scroller scroller = this.mFlingScroller;
        if (scroller.isFinished()) {
            scroller = this.mAdjustScroller;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.mPreviousScrollerY == 0) {
            this.mPreviousScrollerY = scroller.getStartY();
        }
        scrollBy(0, currY - this.mPreviousScrollerY);
        this.mPreviousScrollerY = currY;
        if (scroller.isFinished()) {
            onScrollerFinished(scroller);
        } else {
            this.mDelegator.invalidate();
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int computeVerticalScrollExtent() {
        return this.mDelegator.getHeight();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int computeVerticalScrollOffset() {
        return this.mCurrentScrollOffset;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int computeVerticalScrollRange() {
        return (((int) TimeUnit.MILLISECONDS.toDays(this.mMaxValue.getTimeInMillis() - this.mMinValue.getTimeInMillis())) + 1) * this.mSelectorElementHeight;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public Calendar convertLunarToSolar(Calendar calendar, int i, int i2, int i4) {
        Calendar calendar2 = (Calendar) calendar.clone();
        SeslSolarLunarConverterReflector.convertLunarToSolar(this.mPathClassLoader, this.mSolarLunarConverter, i, i2, i4, this.mIsLeapMonth);
        calendar2.set(SeslSolarLunarConverterReflector.getYear(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getMonth(this.mPathClassLoader, this.mSolarLunarConverter), SeslSolarLunarConverterReflector.getDay(this.mPathClassLoader, this.mSolarLunarConverter));
        return calendar2;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public Calendar convertSolarToLunar(Calendar calendar, SeslSpinningDatePicker.LunarDate lunarDate) {
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

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mAccessibilityManager.isEnabled()) {
            return false;
        }
        int y2 = (int) motionEvent.getY();
        int i = y2 <= this.mTopSelectionDividerTop ? 1 : this.mBottomSelectionDividerBottom <= y2 ? 3 : 2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7 || actionMasked == 9) {
            updateHoveredVirtualView(i);
            return true;
        }
        if (actionMasked != 10 || this.mLastHoveredChildVirtualViewId == Integer.MIN_VALUE) {
            return false;
        }
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba  */
    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 66 && keyCode != 160) {
            switch (keyCode) {
                case 19:
                case 20:
                    if (action == 0) {
                        if (keyCode == 20) {
                            int i = this.mLastFocusedChildVirtualViewId;
                            if (i == 1) {
                                this.mLastFocusedChildVirtualViewId = 2;
                                this.mDelegator.invalidate();
                                return true;
                            }
                            if (i == 2) {
                                if (!this.mWrapSelectorWheel && getValue().equals(getMaxValue())) {
                                    return false;
                                }
                                this.mLastFocusedChildVirtualViewId = 3;
                                this.mDelegator.invalidate();
                                return true;
                            }
                        } else if (keyCode == 19) {
                            int i2 = this.mLastFocusedChildVirtualViewId;
                            if (i2 == 2) {
                                if (!this.mWrapSelectorWheel && getValue().equals(getMinValue())) {
                                    return false;
                                }
                                this.mLastFocusedChildVirtualViewId = 1;
                                this.mDelegator.invalidate();
                                return true;
                            }
                            if (i2 == 3) {
                                this.mLastFocusedChildVirtualViewId = 2;
                                this.mDelegator.invalidate();
                                return true;
                            }
                        }
                    } else if (action == 1 && this.mAccessibilityManager.isEnabled()) {
                        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider();
                        if (accessibilityNodeProviderImpl != null) {
                            accessibilityNodeProviderImpl.performAction(this.mLastFocusedChildVirtualViewId, 64, null);
                        }
                        return true;
                    }
                    break;
                case 21:
                case 22:
                    if (action == 0) {
                        if (keyCode == 21) {
                            View viewFocusSearch = this.mDelegator.focusSearch(17);
                            if (viewFocusSearch != null) {
                                viewFocusSearch.requestFocus(17);
                            }
                            return true;
                        }
                        if (keyCode == 22) {
                            View viewFocusSearch2 = this.mDelegator.focusSearch(66);
                            if (viewFocusSearch2 != null) {
                                viewFocusSearch2.requestFocus(66);
                            }
                            return true;
                        }
                    }
                    break;
            }
        } else if (action == 0) {
            if (this.mLastFocusedChildVirtualViewId == 2) {
                performClick();
                removeAllCallbacks();
            } else if (this.mFlingScroller.isFinished()) {
                int i4 = this.mLastFocusedChildVirtualViewId;
                if (i4 == 1) {
                    startFadeAnimation(false);
                    changeValueByOne(false);
                    Calendar calendar = (Calendar) getMinValue().clone();
                    calendar.add(5, 1);
                    if (!this.mWrapSelectorWheel && getValue().equals(calendar)) {
                        this.mLastFocusedChildVirtualViewId = 2;
                    }
                    startFadeAnimation(true);
                } else if (i4 == 3) {
                    startFadeAnimation(false);
                    changeValueByOne(true);
                    Calendar calendar2 = (Calendar) getMaxValue().clone();
                    calendar2.add(5, -1);
                    if (!this.mWrapSelectorWheel && getValue().equals(calendar2)) {
                        this.mLastFocusedChildVirtualViewId = 2;
                    }
                    startFadeAnimation(true);
                }
            }
        }
        return false;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            return false;
        }
        removeAllCallbacks();
        return false;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            removeAllCallbacks();
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.mAccessibilityNodeProvider == null) {
            this.mAccessibilityNodeProvider = new AccessibilityNodeProviderImpl();
        }
        return this.mAccessibilityNodeProvider;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int getMaxHeight() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public Calendar getMaxValue() {
        return this.mMaxValue;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int getMaxWidth() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int getMinHeight() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public Calendar getMinValue() {
        return this.mMinValue;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int getMinWidth() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public SeslSpinningDatePickerSpinner.OnSpinnerDateClickListener getOnSpinnerDateClickListener() {
        return this.mOnSpinnerDateClickListener;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public int getPaintFlags() {
        return this.mSelectorWheelPaint.getFlags();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public Calendar getValue() {
        return this.mValue;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onAttachedToWindow() {
        this.mDelegator.getViewTreeObserver().addOnPreDrawListener(this.mHapticPreDrawListener);
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onConfigurationChanged(Configuration configuration) {
        if (this.mCustomTypefaceSet) {
            return;
        }
        if (!isCharacterNumberLanguage()) {
            this.mInputText.setIncludeFontPadding(false);
            setInputTextTypeface();
            tryComputeMaxWidth();
        } else {
            this.mInputText.setIncludeFontPadding(true);
            Typeface typeface = this.mDefaultTypeface;
            this.mPickerTypeface = typeface;
            this.mPickerSubTypeface = Typeface.create(typeface, 0);
            this.mHcfFocusedTypefaceBold = Typeface.create(this.mPickerTypeface, 1);
            setInputTextTypeface();
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onDetachedFromWindow() {
        this.mGravityScroller.abortAnimation();
        this.mSpringAnimation.cancel();
        this.mSpringFlingRunning = false;
        removeAllCallbacks();
        this.mDelegator.getViewTreeObserver().removeOnPreDrawListener(this.mHapticPreDrawListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0151  */
    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        int right = this.mDelegator.getRight();
        int left = this.mDelegator.getLeft();
        int bottom = this.mDelegator.getBottom();
        float f = 2.0f;
        float f4 = (right - left) / 2.0f;
        float f5 = this.mCurrentScrollOffset - this.mSelectorElementHeight;
        Drawable drawable = this.mVirtualButtonFocusedDrawable;
        if (drawable != null && this.mScrollState == 0) {
            int i = this.mLastFocusedChildVirtualViewId;
            if (i == 1) {
                drawable.setState(this.mDelegator.getDrawableState());
                this.mVirtualButtonFocusedDrawable.setBounds(0, 0, right, this.mTopSelectionDividerTop);
                this.mVirtualButtonFocusedDrawable.draw(canvas);
            } else if (i == 2) {
                drawable.setState(this.mDelegator.getDrawableState());
                this.mVirtualButtonFocusedDrawable.setBounds(0, this.mTopSelectionDividerTop, right, this.mBottomSelectionDividerBottom);
                this.mVirtualButtonFocusedDrawable.draw(canvas);
            } else if (i == 3) {
                drawable.setState(this.mDelegator.getDrawableState());
                this.mVirtualButtonFocusedDrawable.setBounds(0, this.mBottomSelectionDividerBottom, right, bottom);
                this.mVirtualButtonFocusedDrawable.draw(canvas);
            }
        }
        Calendar[] calendarArr = this.mSelectorIndices;
        int length = calendarArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = this.mSelectorIndexToStringCache.get(calendarArr[i2]);
            float f6 = this.mAlpha;
            float f7 = this.mIdleAlpha;
            if (f6 < f7) {
                f6 = f7;
            }
            int iDescent = (int) ((((this.mSelectorWheelPaint.descent() - this.mSelectorWheelPaint.ascent()) / f) + f5) - this.mSelectorWheelPaint.descent());
            int i4 = this.mTopSelectionDividerTop;
            int i5 = this.mInitialScrollOffset;
            float f8 = f;
            if (f5 >= i4 - i5) {
                int i6 = this.mBottomSelectionDividerBottom;
                if (f5 > i5 + i6) {
                    canvas.save();
                    this.mSelectorWheelPaint.setAlpha((int) (f6 * 255.0f * this.mInitialAlpha));
                    this.mSelectorWheelPaint.setTypeface(this.mPickerSubTypeface);
                    canvas.drawText(str, f4, iDescent, this.mSelectorWheelPaint);
                    canvas.restore();
                } else if (f5 <= (i4 + i6) / f8) {
                    canvas.save();
                    canvas.clipRect(0, this.mTopSelectionDividerTop, right, this.mBottomSelectionDividerBottom);
                    this.mSelectorWheelPaint.setColor(this.mTextColor);
                    this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
                    float f9 = iDescent;
                    canvas.drawText(str, f4, f9, this.mSelectorWheelPaint);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, 0, right, this.mTopSelectionDividerTop);
                    this.mSelectorWheelPaint.setTypeface(this.mPickerSubTypeface);
                    this.mSelectorWheelPaint.setAlpha((int) (f6 * 255.0f * this.mInitialAlpha));
                    canvas.drawText(str, f4, f9, this.mSelectorWheelPaint);
                    canvas.restore();
                } else {
                    canvas.save();
                    canvas.clipRect(0, this.mTopSelectionDividerTop, right, this.mBottomSelectionDividerBottom);
                    this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
                    this.mSelectorWheelPaint.setColor(this.mTextColor);
                    float f10 = iDescent;
                    canvas.drawText(str, f4, f10, this.mSelectorWheelPaint);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.mBottomSelectionDividerBottom, right, bottom);
                    this.mSelectorWheelPaint.setAlpha((int) (f6 * 255.0f * this.mInitialAlpha));
                    this.mSelectorWheelPaint.setTypeface(this.mPickerSubTypeface);
                    canvas.drawText(str, f4, f10, this.mSelectorWheelPaint);
                    canvas.restore();
                }
            }
            f5 += this.mSelectorElementHeight;
            i2++;
            f = f8;
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onFocusChanged(boolean z, int i, Rect rect) {
        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl;
        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl2;
        if (z) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
            }
            this.mLastFocusedChildVirtualViewId = 1;
            if (!this.mWrapSelectorWheel && getValue().equals(getMinValue())) {
                this.mLastFocusedChildVirtualViewId = 2;
            }
            if (this.mAccessibilityManager.isEnabled() && (accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider()) != null) {
                accessibilityNodeProviderImpl.performAction(this.mLastFocusedChildVirtualViewId, 64, null);
            }
        } else {
            if (this.mAccessibilityManager.isEnabled() && (accessibilityNodeProviderImpl2 = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider()) != null) {
                accessibilityNodeProviderImpl2.performAction(this.mLastFocusedChildVirtualViewId, 128, null);
            }
            this.mLastFocusedChildVirtualViewId = -1;
            this.mLastHoveredChildVirtualViewId = Integer.MIN_VALUE;
        }
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mDelegator.isEnabled() && !this.mIsStartingAnimation && (motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                startFadeAnimation(false);
                changeValueByOne(axisValue < 0.0f);
                startFadeAnimation(true);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setClassName(SeslSpinningDatePickerSpinner.class.getName());
        accessibilityEvent.setScrollable(true);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        accessibilityEvent.setScrollY(((int) timeUnit.toDays(this.mValue.getTimeInMillis() - this.mMinValue.getTimeInMillis())) * this.mSelectorElementHeight);
        accessibilityEvent.setMaxScrollY(((int) timeUnit.toDays(this.mMaxValue.getTimeInMillis() - this.mMinValue.getTimeInMillis())) * this.mSelectorElementHeight);
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mDelegator.isEnabled() || this.mIsStartingAnimation || motionEvent.getActionMasked() != 0) {
            return false;
        }
        removeAllCallbacks();
        float y2 = motionEvent.getY();
        this.mLastDownEventY = y2;
        this.mLastDownOrMoveEventY = y2;
        this.mLastDownEventTime = motionEvent.getEventTime();
        this.mIgnoreMoveEvents = false;
        this.mPerformClickOnTap = false;
        this.mIsValueChanged = false;
        float f = this.mLastDownEventY;
        if (f < this.mTopSelectionDividerTop) {
            startFadeAnimation(false);
            if (this.mScrollState == 0) {
                this.mPressedStateHelper.buttonPressDelayed(2);
            }
        } else if (f > this.mBottomSelectionDividerBottom) {
            startFadeAnimation(false);
            if (this.mScrollState == 0) {
                this.mPressedStateHelper.buttonPressDelayed(1);
            }
        }
        this.mDelegator.getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.mFlingScroller.isFinished()) {
            this.mFlingScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
            if (this.mScrollState == 2) {
                this.mFlingScroller.abortAnimation();
                this.mAdjustScroller.abortAnimation();
            }
            onScrollStateChange(0);
        } else if (this.mSpringAnimation.isRunning()) {
            this.mGravityScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
            this.mSpringAnimation.cancel();
            this.mSpringFlingRunning = false;
            if (this.mScrollState == 2) {
                this.mGravityScroller.abortAnimation();
                this.mAdjustScroller.abortAnimation();
            }
            onScrollStateChange(0);
        } else if (this.mAdjustScroller.isFinished()) {
            float f4 = this.mLastDownEventY;
            if (f4 < this.mTopSelectionDividerTop) {
                postChangeCurrentByOneFromLongPress(false, ViewConfiguration.getLongPressTimeout());
            } else if (f4 > this.mBottomSelectionDividerBottom) {
                postChangeCurrentByOneFromLongPress(true, ViewConfiguration.getLongPressTimeout());
            } else {
                this.mPerformClickOnTap = true;
            }
        } else {
            this.mFlingScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
        }
        return true;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        int measuredWidth = this.mDelegator.getMeasuredWidth();
        int measuredHeight = this.mDelegator.getMeasuredHeight();
        int measuredWidth2 = this.mInputText.getMeasuredWidth();
        int iMax = Math.max(this.mInputText.getMeasuredHeight(), (int) Math.floor(measuredHeight * this.mHeightRatio));
        this.mModifiedTxtHeight = iMax;
        int i6 = (measuredWidth - measuredWidth2) / 2;
        int i7 = (measuredHeight - iMax) / 2;
        int i8 = iMax + i7;
        this.mInputText.layout(i6, i7, measuredWidth2 + i6, i8);
        if (z) {
            initializeSelectorWheel();
            if (this.mModifiedTxtHeight <= this.mSelectorElementHeight) {
                this.mTopSelectionDividerTop = i7;
                this.mBottomSelectionDividerBottom = i8;
            } else {
                int i9 = this.mValueChangeOffset;
                this.mTopSelectionDividerTop = i9;
                this.mBottomSelectionDividerBottom = i9 * 2;
            }
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onMeasure(int i, int i2) {
        this.mDelegator.superOnMeasure(makeMeasureSpec(i, this.mMaxWidth), makeMeasureSpec(i2, this.mMaxHeight));
        this.mDelegator.setMeasuredDimensionWrapper(resolveSizeAndStateRespectingMinSize(this.mMinWidth, this.mDelegator.getMeasuredWidth(), i), resolveSizeAndStateRespectingMinSize(this.mMinHeight, this.mDelegator.getMeasuredHeight(), i2));
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.getText().add(((AccessibilityNodeProviderImpl) getAccessibilityNodeProvider()).getVirtualCurrentButtonText());
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mDelegator.isEnabled() || this.mIsStartingAnimation) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            removeChangeCurrentByOneFromLongPress();
            this.mPressedStateHelper.cancel();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            int yVelocity = (int) velocityTracker.getYVelocity();
            int y2 = (int) motionEvent.getY();
            int iAbs = (int) Math.abs(y2 - this.mLastDownEventY);
            if (Math.abs(yVelocity) <= this.mMinimumFlingVelocity) {
                long eventTime = motionEvent.getEventTime() - this.mLastDownEventTime;
                if (iAbs > this.mTouchSlop || eventTime >= ViewConfiguration.getLongPressTimeout()) {
                    if (this.mIsLongClicked) {
                        this.mIsLongClicked = false;
                    }
                    ensureScrollWheelAdjusted(iAbs);
                    startFadeAnimation(true);
                } else if (this.mPerformClickOnTap) {
                    this.mPerformClickOnTap = false;
                    performClick();
                } else {
                    if (y2 > this.mBottomSelectionDividerBottom) {
                        changeValueByOne(true);
                        this.mPressedStateHelper.buttonTapped(1);
                    } else if (y2 < this.mTopSelectionDividerTop) {
                        changeValueByOne(false);
                        this.mPressedStateHelper.buttonTapped(2);
                    } else {
                        ensureScrollWheelAdjusted(iAbs);
                    }
                    startFadeAnimation(true);
                }
                this.mIsValueChanged = false;
                onScrollStateChange(0);
            } else if (iAbs > this.mTouchSlop || !this.mPerformClickOnTap) {
                fling(yVelocity);
                onScrollStateChange(2);
            } else {
                this.mPerformClickOnTap = false;
                performClick();
                onScrollStateChange(0);
            }
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                ensureScrollWheelAdjusted();
                startFadeAnimation(true);
                onScrollStateChange(0);
            }
        } else if (!this.mIgnoreMoveEvents) {
            float y3 = motionEvent.getY();
            if (this.mScrollState == 1) {
                scrollBy(0, (int) (y3 - this.mLastDownOrMoveEventY));
                this.mDelegator.invalidate();
            } else if (((int) Math.abs(y3 - this.mLastDownEventY)) > this.mTouchSlop) {
                removeAllCallbacks();
                startFadeAnimation(false);
                onScrollStateChange(1);
            }
            this.mLastDownOrMoveEventY = y3;
        }
        return true;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onWindowFocusChanged(boolean z) {
        if (!this.mIsStartingAnimation) {
            if (!this.mFlingScroller.isFinished()) {
                this.mFlingScroller.forceFinished(true);
            }
            if (!this.mAdjustScroller.isFinished()) {
                this.mAdjustScroller.forceFinished(true);
            }
            if (!this.mGravityScroller.isFinished()) {
                this.mGravityScroller.forceFinished(true);
            }
            if (this.mSpringAnimation.isRunning()) {
                this.mSpringAnimation.cancel();
                this.mSpringFlingRunning = false;
            }
            ensureScrollWheelAdjusted();
        }
        this.mIsHcfEnabled = isHighContrastFontEnabled();
        this.mSelectorWheelPaint.setTextSize(this.mTextSize);
        this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
        setInputTextTypeface();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void performClick() {
        SeslSpinningDatePicker.LunarDate lunarDate;
        Calendar calendarConvertSolarToLunar;
        stopScrollAnimation();
        if (this.mOnSpinnerDateClickListener != null) {
            if (this.mIsLunar) {
                lunarDate = new SeslSpinningDatePicker.LunarDate();
                calendarConvertSolarToLunar = convertSolarToLunar(this.mValue, lunarDate);
            } else {
                lunarDate = null;
                calendarConvertSolarToLunar = null;
            }
            SeslSpinningDatePickerSpinner.OnSpinnerDateClickListener onSpinnerDateClickListener = this.mOnSpinnerDateClickListener;
            if (!this.mIsLunar) {
                calendarConvertSolarToLunar = this.mValue;
            }
            onSpinnerDateClickListener.onSpinnerDateClicked(calendarConvertSolarToLunar, lunarDate);
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void performLongClick() {
        this.mIgnoreMoveEvents = true;
        this.mIsLongClicked = true;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void scrollBy(int i, int i2) {
        Calendar[] calendarArr = this.mSelectorIndices;
        if (i2 == 0 || this.mSelectorElementHeight <= 0) {
            return;
        }
        if (!this.mWrapSelectorWheel && this.mCurrentScrollOffset + i2 > this.mInitialScrollOffset && calendarArr[2].compareTo(this.mMinValue) <= 0) {
            stopFlingAnimation();
            i2 = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        }
        if (!this.mWrapSelectorWheel && this.mCurrentScrollOffset + i2 < this.mInitialScrollOffset && calendarArr[2].compareTo(this.mMaxValue) >= 0) {
            stopFlingAnimation();
            i2 = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        }
        this.mCurrentScrollOffset += i2;
        while (true) {
            int i4 = this.mCurrentScrollOffset;
            if (i4 - this.mInitialScrollOffset < this.mValueChangeOffset) {
                break;
            }
            this.mCurrentScrollOffset = i4 - this.mSelectorElementHeight;
            decrementSelectorIndices(calendarArr);
            if (!this.mIsStartingAnimation) {
                setValueInternal(calendarArr[2], true);
                this.mIsValueChanged = true;
                int i5 = this.mLongPressCount;
                if (i5 > 0) {
                    this.mLongPressCount = i5 - 1;
                } else {
                    playSoundAndHapticFeedback();
                }
            }
            if (!this.mWrapSelectorWheel && calendarArr[2].compareTo(this.mMinValue) <= 0) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
        while (true) {
            int i6 = this.mCurrentScrollOffset;
            if (i6 - this.mInitialScrollOffset > (-this.mValueChangeOffset)) {
                return;
            }
            this.mCurrentScrollOffset = i6 + this.mSelectorElementHeight;
            incrementSelectorIndices(calendarArr);
            if (!this.mIsStartingAnimation) {
                setValueInternal(calendarArr[2], true);
                this.mIsValueChanged = true;
                int i7 = this.mLongPressCount;
                if (i7 > 0) {
                    this.mLongPressCount = i7 - 1;
                } else {
                    playSoundAndHapticFeedback();
                }
            }
            if (!this.mWrapSelectorWheel && calendarArr[2].compareTo(this.mMaxValue) >= 0) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setEnabled(boolean z) {
        if (z || this.mScrollState == 0) {
            return;
        }
        stopScrollAnimation();
        onScrollStateChange(0);
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setFormatter(SeslSpinningDatePickerSpinner.Formatter formatter) {
        if (formatter == this.mFormatter) {
            return;
        }
        this.mFormatter = formatter;
        initializeSelectorWheelIndices();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setLunar(boolean z, boolean z2) {
        this.mIsLunar = z;
        this.mIsLeapMonth = z2;
        if (!z) {
            this.mPathClassLoader = null;
            this.mSolarLunarConverter = null;
        } else if (this.mSolarLunarConverter == null) {
            PathClassLoader pathClassLoader = SeslSpinningDatePicker.LunarUtils.getPathClassLoader(this.mContext);
            this.mPathClassLoader = pathClassLoader;
            this.mSolarLunarConverter = SeslFeatureReflector.getSolarLunarConverter(pathClassLoader);
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setMaxValue(Calendar calendar) {
        if (this.mMaxValue.equals(calendar)) {
            return;
        }
        clearCalendar(this.mMaxValue, calendar);
        if (this.mMaxValue.compareTo(this.mValue) < 0) {
            clearCalendar(this.mValue, this.mMaxValue);
        }
        updateWrapSelectorWheel();
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setMinValue(Calendar calendar) {
        if (this.mMinValue.equals(calendar)) {
            return;
        }
        clearCalendar(this.mMinValue, calendar);
        if (this.mMinValue.compareTo(this.mValue) > 0) {
            clearCalendar(this.mValue, this.mMinValue);
        }
        updateWrapSelectorWheel();
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setOnLongPressUpdateInterval(long j) {
        this.mLongPressUpdateInterval = j;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setOnScrollListener(SeslSpinningDatePickerSpinner.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setOnSpinnerDateClickListener(SeslSpinningDatePickerSpinner.OnSpinnerDateClickListener onSpinnerDateClickListener) {
        this.mOnSpinnerDateClickListener = onSpinnerDateClickListener;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setOnValueChangedListener(SeslSpinningDatePickerSpinner.OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setPaintFlags(int i) {
        if (this.mSelectorWheelPaint.getFlags() != i) {
            this.mSelectorWheelPaint.setFlags(i);
            this.mInputText.setPaintFlags(i);
            tryComputeMaxWidth();
        }
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setPickerContentDescription(String str) {
        this.mPickerContentDescription = str;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setSkipValuesOnLongPressEnabled(boolean z) {
        this.mSkipNumbers = z;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setTextSize(float f) {
        int iApplyDimension = (int) TypedValue.applyDimension(1, f, this.mContext.getResources().getDisplayMetrics());
        this.mTextSize = iApplyDimension;
        this.mSelectorWheelPaint.setTextSize(iApplyDimension);
        this.mInputText.setTextSize(0, this.mTextSize);
        tryComputeMaxWidth();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setTextTypeface(Typeface typeface) {
        this.mCustomTypefaceSet = true;
        this.mPickerTypeface = typeface;
        this.mPickerSubTypeface = Typeface.create(typeface, 0);
        this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
        this.mHcfFocusedTypefaceBold = Typeface.create(this.mPickerTypeface, 1);
        setInputTextTypeface();
        tryComputeMaxWidth();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setValue(Calendar calendar) {
        if (!this.mFlingScroller.isFinished() || this.mSpringAnimation.isRunning()) {
            stopScrollAnimation();
        }
        setValueInternal(calendar, false);
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setWrapSelectorWheel(boolean z) {
        this.mWrapSelectorWheelPreferred = z;
        updateWrapSelectorWheel();
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void startAnimation(int i, SeslAnimationListener seslAnimationListener) {
        this.mAnimationListener = seslAnimationListener;
        this.mAlpha = this.mActivatedAlpha;
        this.mDelegator.post(new RunnableC36711(i));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HapticPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        boolean mSkipHapticCalls;

        private HapticPreDrawListener() {
            this.mSkipHapticCalls = false;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.mSkipHapticCalls = false;
            return true;
        }

        public /* synthetic */ HapticPreDrawListener(RunnableC36711 runnableC36711) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[PHI: r1
      0x001f: PHI (r1v5 int) = (r1v3 int), (r1v7 int) binds: [B:18:0x002d, B:12:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ensureScrollWheelAdjusted(int i) {
        int i2;
        int i4 = this.mInitialScrollOffset;
        if (i4 == Integer.MIN_VALUE) {
            return false;
        }
        int i5 = i4 - this.mCurrentScrollOffset;
        if (i5 == 0) {
            this.mIsValueChanged = false;
            return false;
        }
        this.mPreviousScrollerY = 0;
        if (this.mIsValueChanged || i == 0) {
            int iAbs = Math.abs(i5);
            i2 = this.mSelectorElementHeight;
            if (iAbs > i2 / 2) {
                if (i5 > 0) {
                    i2 = -i2;
                }
                i5 += i2;
            }
        } else {
            int iAbs2 = Math.abs(i);
            i2 = this.mSelectorElementHeight;
            if (iAbs2 < i2) {
                if (i5 > 0) {
                }
                i5 += i2;
            }
        }
        this.mAdjustScroller.startScroll(0, 0, 0, i5, 300);
        this.mDelegator.invalidate();
        this.mIsValueChanged = false;
        return true;
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void performClick(boolean z) {
        changeValueByOne(z);
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // androidx.picker.widget.SeslSpinningDatePickerSpinner.DatePickerDelegate
    public void setSubTextSize(float f) {
    }
}
