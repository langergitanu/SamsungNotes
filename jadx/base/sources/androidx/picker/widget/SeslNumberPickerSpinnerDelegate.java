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
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import android.widget.NumberPicker;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.picker.C3623R;
import androidx.picker.util.SeslAnimationListener;
import androidx.picker.util.SeslPickerBasicUtils;
import androidx.picker.widget.SeslNumberPicker;
import androidx.reflect.content.res.SeslCompatibilityInfoReflector;
import androidx.reflect.content.res.SeslConfigurationReflector;
import androidx.reflect.graphics.SeslPaintReflector;
import androidx.reflect.media.SeslAudioManagerReflector;
import androidx.reflect.media.SeslSemSoundAssistantManagerReflector;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslHoverPopupWindowReflector;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SeslNumberPickerSpinnerDelegate extends SeslNumberPicker.AbsNumberPickerDelegate {
    private static final int DECREASE_BUTTON = 1;
    protected static final int DEFAULT_WHEEL_INTERVAL = 1;
    private static final char[] DIGIT_CHARACTERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, 2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415, 2534, 2535, 2536, 2537, 2538, 2539, 2540, 2541, 2542, 2543, 3302, 3303, 3304, 3305, 3306, 3307, 3308, 3309, 3310, 3311, 4160, 4161, 4162, 4163, 4164, 4165, 4166, 4167, 4168, 4169};
    protected static final float FAST_SCROLL_VELOCITY_START = 1000.0f;
    private static final int FONT_WEIGHT_SEMIBOLD = 600;
    private static final int INCREASE_BUTTON = 3;
    private static final int INPUT = 2;
    private static final String INPUT_TYPE_MONTH = "inputType=month_edittext";
    private static final String INPUT_TYPE_YEAR_DATE_TIME = "inputType=YearDateTime_edittext";
    protected static final int INTERNAL_INDEX_OFFSET = 50024;
    protected static final int PICKER_VIBRATE_INDEX = 32;
    protected static final int SAMSUNG_VIBRATION_START = 50056;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 300;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 4;
    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 2;
    private static final int SELECTOR_WHEEL_ITEM_COUNT = 5;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 500;
    private static final int START_ANIMATION_SCROLL_DURATION = 857;
    private static final int START_ANIMATION_SCROLL_DURATION_2016B = 557;
    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
    protected final PathInterpolator ALPHA_PATH_INTERPOLATOR;
    protected final PathInterpolator SIZE_PATH_INTERPOLATOR;
    private AccessibilityManager mAccessibilityManager;
    protected AccessibilityNodeProviderImpl mAccessibilityNodeProvider;
    protected float mActivatedAlpha;
    protected final Scroller mAdjustScroller;
    protected float mAlpha;
    protected SeslAnimationListener mAnimationListener;
    protected AudioManager mAudioManager;
    protected BeginSoftInputOnLongPressCommand mBeginSoftInputOnLongPressCommand;
    protected int mBottomSelectionDividerBottom;
    protected ValueAnimator mColorInAnimator;
    protected ValueAnimator mColorOutAnimator;
    private ValueAnimator.AnimatorUpdateListener mColorUpdateListener;
    protected final boolean mComputeMaxWidth;
    protected float mCurVelocity;
    protected int mCurrentScrollOffset;
    protected final Scroller mCustomScroller;
    private SeslNumberPicker.CustomTalkbackFormatter mCustomTalkbackFormatter;
    protected int mCustomTextColorScrolling;
    protected boolean mCustomTypefaceSet;
    protected boolean mCustomWheelIntervalMode;
    protected boolean mDecrementVirtualButtonPressed;
    protected final Typeface mDefaultTypeface;
    protected String[] mDisplayedValues;
    protected ValueAnimator mFadeInAnimator;
    protected ValueAnimator mFadeOutAnimator;
    protected Scroller mFlingScroller;
    protected SeslNumberPicker.Formatter mFormatter;
    protected OverScroller mGravityScroller;
    protected HapticPreDrawListener mHapticPreDrawListener;
    protected Typeface mHcfFocusedTypefaceBold;
    protected final float mHeightRatio;
    protected FloatValueHolder mHolder;
    protected float mIdleAlpha;
    protected boolean mIgnoreMoveEvents;
    protected boolean mIgnoreUpEvent;
    protected boolean mIncrementVirtualButtonPressed;
    protected float mInitialAlpha;
    protected int mInitialScrollOffset;
    protected final EditText mInputText;
    protected boolean mIsAmPm;
    protected boolean mIsBoldTextEnabled;
    protected boolean mIsCustomScrollColorForPicker;
    protected boolean mIsEditTextMode;
    protected boolean mIsEditTextModeEnabled;
    protected boolean mIsHcfEnabled;
    protected boolean mIsLongClicked;
    protected boolean mIsLongPressed;
    protected boolean mIsPressedBackKey;
    protected boolean mIsStartingAnimation;
    protected boolean mIsValueChanged;
    protected long mLastDownEventTime;
    protected float mLastDownEventY;
    protected float mLastDownOrMoveEventY;
    protected int mLastFocusedChildVirtualViewId;
    protected int mLastHoveredChildVirtualViewId;
    protected final Typeface mLegacyTypeface;
    protected final Scroller mLinearScroller;
    protected final int mMaxHeight;
    protected int mMaxValue;
    protected int mMaxWidth;
    protected int mMaximumFlingVelocity;
    protected final int mMinHeight;
    protected int mMinValue;
    protected final int mMinWidth;
    protected int mMinimumFlingVelocity;
    protected int mModifiedTxtHeight;
    protected SeslNumberPicker.OnEditTextModeChangedListener mOnEditTextModeChangedListener;
    protected SeslNumberPicker.OnScrollListener mOnScrollListener;
    protected SeslNumberPicker.OnValueChangeListener mOnValueChangeListener;
    protected boolean mPerformClickOnTap;
    protected String mPickerContentDescription;
    protected int mPickerSoundFastIndex;
    protected int mPickerSoundIndex;
    protected int mPickerSoundSlowIndex;
    protected Typeface mPickerSubTypeface;
    protected Typeface mPickerTypeface;
    protected int mPickerVibrateIndex;
    protected final PressedStateHelper mPressedStateHelper;
    protected int mPreviousScrollerY;
    protected float mPreviousSpringY;
    protected boolean mReservedStartAnimation;
    protected int mScrollState;
    protected final int mSelectionDividerHeight;
    protected int mSelectorElementHeight;
    protected final SparseArray<String> mSelectorIndexToStringCache;
    protected final int[] mSelectorIndices;
    protected int mSelectorTextGapHeight;
    protected Paint mSelectorWheelPaint;
    protected int mShortFlickThreshold;
    protected SpringAnimation mSpringAnimation;
    private DynamicAnimation.OnAnimationEndListener mSpringAnimationEndListener;
    private DynamicAnimation.OnAnimationUpdateListener mSpringAnimationUpdateListener;
    protected boolean mSpringFlingRunning;
    protected SwitchIntervalOnLongPressCommand mSwitchIntervalOnLongPressCommand;
    protected int mTextColor;
    protected int mTextColorIdle;
    protected int mTextColorScrolling;
    protected int mTextSize;
    private Toast mToast;
    private String mToastText;
    protected int mTopSelectionDividerTop;
    protected int mTouchSlop;
    protected String mUnitValue;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener;
    protected int mValue;
    protected int mValueChangeOffset;
    protected VelocityTracker mVelocityTracker;
    protected final Drawable mVirtualButtonFocusedDrawable;
    protected int mWheelInterval;
    protected boolean mWrapSelectorWheel;
    protected boolean mWrapSelectorWheelPreferred;
    protected int selectedPickerColor;

    /* JADX INFO: renamed from: androidx.picker.widget.SeslNumberPickerSpinnerDelegate$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC36485 implements Runnable {
        final /* synthetic */ int val$delay;

        /* JADX INFO: renamed from: androidx.picker.widget.SeslNumberPickerSpinnerDelegate$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ int val$forwardDistance;

            public AnonymousClass1(int i) {
                this.val$forwardDistance = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                new Handler().postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.5.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
                        if (!seslNumberPickerSpinnerDelegate.moveToFinalScrollerPosition(seslNumberPickerSpinnerDelegate.mFlingScroller)) {
                            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
                            seslNumberPickerSpinnerDelegate2.moveToFinalScrollerPosition(seslNumberPickerSpinnerDelegate2.mAdjustScroller);
                        }
                        SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(false);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate3 = SeslNumberPickerSpinnerDelegate.this;
                        seslNumberPickerSpinnerDelegate3.mPreviousScrollerY = 0;
                        seslNumberPickerSpinnerDelegate3.mFlingScroller.startScroll(0, 0, 0, -anonymousClass1.val$forwardDistance, seslNumberPickerSpinnerDelegate3.mIsAmPm ? SeslNumberPickerSpinnerDelegate.START_ANIMATION_SCROLL_DURATION : SeslNumberPickerSpinnerDelegate.START_ANIMATION_SCROLL_DURATION_2016B);
                        SeslNumberPickerSpinnerDelegate.this.mDelegator.invalidate();
                        new Handler().postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.5.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate4 = SeslNumberPickerSpinnerDelegate.this;
                                seslNumberPickerSpinnerDelegate4.moveToFinalScrollerPosition(seslNumberPickerSpinnerDelegate4.mFlingScroller);
                                SeslNumberPickerSpinnerDelegate.this.mFlingScroller.abortAnimation();
                                SeslNumberPickerSpinnerDelegate.this.mAdjustScroller.abortAnimation();
                                SeslNumberPickerSpinnerDelegate.this.ensureScrollWheelAdjusted();
                                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate5 = SeslNumberPickerSpinnerDelegate.this;
                                seslNumberPickerSpinnerDelegate5.mFlingScroller = seslNumberPickerSpinnerDelegate5.mLinearScroller;
                                seslNumberPickerSpinnerDelegate5.mIsStartingAnimation = false;
                                seslNumberPickerSpinnerDelegate5.mDelegator.invalidate();
                                SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(true);
                                SeslAnimationListener seslAnimationListener = SeslNumberPickerSpinnerDelegate.this.mAnimationListener;
                                if (seslAnimationListener != null) {
                                    seslAnimationListener.onAnimationEnd();
                                }
                            }
                        }, 857L);
                    }
                }, 100L);
            }
        }

        public RunnableC36485(int i) {
            this.val$delay = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            if (seslNumberPickerSpinnerDelegate.mSelectorElementHeight == 0) {
                seslNumberPickerSpinnerDelegate.mReservedStartAnimation = true;
                return;
            }
            seslNumberPickerSpinnerDelegate.mIsStartingAnimation = true;
            seslNumberPickerSpinnerDelegate.mFlingScroller = seslNumberPickerSpinnerDelegate.mCustomScroller;
            int i = seslNumberPickerSpinnerDelegate.getValue() != SeslNumberPickerSpinnerDelegate.this.getMinValue() ? SeslNumberPickerSpinnerDelegate.this.mSelectorElementHeight : -SeslNumberPickerSpinnerDelegate.this.mSelectorElementHeight;
            int value = SeslNumberPickerSpinnerDelegate.this.getValue() - SeslNumberPickerSpinnerDelegate.this.getMinValue();
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
            boolean z = seslNumberPickerSpinnerDelegate2.mWrapSelectorWheel;
            int i2 = (z || value >= 5) ? 5 : value;
            float f = (z || value >= 5) ? 5.4f : value + 0.4f;
            boolean z2 = seslNumberPickerSpinnerDelegate2.mIsAmPm;
            int i4 = z2 ? i : seslNumberPickerSpinnerDelegate2.mSelectorElementHeight * i2;
            if (!z2) {
                i = (int) (seslNumberPickerSpinnerDelegate2.mSelectorElementHeight * f);
            }
            seslNumberPickerSpinnerDelegate2.scrollBy(0, i4);
            SeslNumberPickerSpinnerDelegate.this.mDelegator.invalidate();
            new Handler().postDelayed(new AnonymousClass1(i), this.val$delay);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AccessibilityNodeProviderImpl extends AccessibilityNodeProvider {
        private static final int UNDEFINED = Integer.MIN_VALUE;
        private static final int VIRTUAL_VIEW_ID_DECREMENT = 1;
        private static final int VIRTUAL_VIEW_ID_INCREMENT = 3;
        private static final int VIRTUAL_VIEW_ID_INPUT = 2;
        private final Rect mTempRect = new Rect();
        private final int[] mTempArray = new int[2];
        private int mAccessibilityFocusedView = Integer.MIN_VALUE;

        public AccessibilityNodeProviderImpl() {
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForNumberPicker(int i, int i2, int i4, int i5) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setClassName(NumberPicker.class.getName());
            accessibilityNodeInfoObtain.setPackageName(SeslNumberPickerSpinnerDelegate.this.mContext.getPackageName());
            accessibilityNodeInfoObtain.setSource(SeslNumberPickerSpinnerDelegate.this.mDelegator);
            if (hasVirtualDecrementButton()) {
                accessibilityNodeInfoObtain.addChild(SeslNumberPickerSpinnerDelegate.this.mDelegator, 1);
            }
            accessibilityNodeInfoObtain.addChild(SeslNumberPickerSpinnerDelegate.this.mDelegator, 2);
            if (hasVirtualIncrementButton()) {
                accessibilityNodeInfoObtain.addChild(SeslNumberPickerSpinnerDelegate.this.mDelegator, 3);
            }
            accessibilityNodeInfoObtain.setParent((View) SeslNumberPickerSpinnerDelegate.this.mDelegator.getParentForAccessibility());
            accessibilityNodeInfoObtain.setEnabled(SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled());
            accessibilityNodeInfoObtain.setScrollable(true);
            float field_applicationScale = SeslCompatibilityInfoReflector.getField_applicationScale(SeslNumberPickerSpinnerDelegate.this.mContext.getResources());
            Rect rect = this.mTempRect;
            rect.set(i, i2, i4, i5);
            scaleRect(rect, field_applicationScale);
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            accessibilityNodeInfoObtain.setVisibleToUser(SeslNumberPickerSpinnerDelegate.this.mDelegator.isVisibleToUserWrapper());
            int[] iArr = this.mTempArray;
            SeslNumberPickerSpinnerDelegate.this.mDelegator.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            scaleRect(rect, field_applicationScale);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != -1) {
                accessibilityNodeInfoObtain.addAction(64);
            } else {
                accessibilityNodeInfoObtain.addAction(128);
            }
            if (SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                if (SeslNumberPickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslNumberPickerSpinnerDelegate.this.getValue() < SeslNumberPickerSpinnerDelegate.this.getMaxValue()) {
                    accessibilityNodeInfoObtain.addAction(4096);
                }
                if (SeslNumberPickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslNumberPickerSpinnerDelegate.this.getValue() > SeslNumberPickerSpinnerDelegate.this.getMinValue()) {
                    accessibilityNodeInfoObtain.addAction(8192);
                }
            }
            return accessibilityNodeInfoObtain;
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForVirtualButton(int i, String str, int i2, int i4, int i5, int i6) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setClassName(Button.class.getName());
            accessibilityNodeInfoObtain.setPackageName(SeslNumberPickerSpinnerDelegate.this.mContext.getPackageName());
            accessibilityNodeInfoObtain.setSource(SeslNumberPickerSpinnerDelegate.this.mDelegator, i);
            accessibilityNodeInfoObtain.setParent(SeslNumberPickerSpinnerDelegate.this.mDelegator);
            accessibilityNodeInfoObtain.setText(str);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfoObtain).setTooltipText(SeslNumberPickerSpinnerDelegate.this.mPickerContentDescription);
            accessibilityNodeInfoObtain.setClickable(true);
            accessibilityNodeInfoObtain.setLongClickable(true);
            accessibilityNodeInfoObtain.setEnabled(SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled());
            Rect rect = this.mTempRect;
            rect.set(i2, i4, i5, i6);
            accessibilityNodeInfoObtain.setVisibleToUser(SeslNumberPickerSpinnerDelegate.this.mDelegator.isVisibleToUserWrapper(rect));
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            int[] iArr = this.mTempArray;
            SeslNumberPickerSpinnerDelegate.this.mDelegator.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != i) {
                accessibilityNodeInfoObtain.addAction(64);
            } else {
                accessibilityNodeInfoObtain.addAction(128);
            }
            if (SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                accessibilityNodeInfoObtain.addAction(16);
            }
            return accessibilityNodeInfoObtain;
        }

        private AccessibilityNodeInfo createAccessibiltyNodeInfoForInputText(int i, int i2, int i4, int i5) {
            AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = SeslNumberPickerSpinnerDelegate.this.mInputText.createAccessibilityNodeInfo();
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setSource(SeslNumberPickerSpinnerDelegate.this.mDelegator, 2);
            if (this.mAccessibilityFocusedView != 2) {
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setAccessibilityFocused(false);
                accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(64);
            } else {
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setAccessibilityFocused(true);
                accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(128);
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            if (!seslNumberPickerSpinnerDelegate.mIsEditTextModeEnabled) {
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setClassName(TextView.class.getName());
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setText(getVirtualCurrentButtonText(false));
                AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfoCreateAccessibilityNodeInfo).setTooltipText(SeslNumberPickerSpinnerDelegate.this.mPickerContentDescription);
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setSelected(true);
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setAccessibilityFocused(false);
            } else if (seslNumberPickerSpinnerDelegate.mCustomTalkbackFormatter != null) {
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setText(getVirtualCurrentButtonText(false));
            }
            Rect rect = this.mTempRect;
            rect.set(i, i2, i4, i5);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setVisibleToUser(SeslNumberPickerSpinnerDelegate.this.mDelegator.isVisibleToUserWrapper(rect));
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setBoundsInParent(rect);
            int[] iArr = this.mTempArray;
            SeslNumberPickerSpinnerDelegate.this.mDelegator.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setBoundsInScreen(rect);
            return accessibilityNodeInfoCreateAccessibilityNodeInfo;
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
                Editable text = SeslNumberPickerSpinnerDelegate.this.mInputText.getText();
                if (TextUtils.isEmpty(text) || !text.toString().toLowerCase().contains(str)) {
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
        public String getVirtualCurrentButtonText(boolean z) {
            String number;
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            int wrappedSelectorIndex = seslNumberPickerSpinnerDelegate.mValue;
            if (seslNumberPickerSpinnerDelegate.mWrapSelectorWheel) {
                wrappedSelectorIndex = seslNumberPickerSpinnerDelegate.getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
            if (wrappedSelectorIndex > seslNumberPickerSpinnerDelegate2.mMaxValue) {
                number = null;
            } else if (seslNumberPickerSpinnerDelegate2.mCustomTalkbackFormatter != null) {
                number = SeslNumberPickerSpinnerDelegate.this.mCustomTalkbackFormatter.format(wrappedSelectorIndex);
            } else {
                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate3 = SeslNumberPickerSpinnerDelegate.this;
                String[] strArr = seslNumberPickerSpinnerDelegate3.mDisplayedValues;
                number = strArr == null ? seslNumberPickerSpinnerDelegate3.formatNumber(wrappedSelectorIndex) : strArr[wrappedSelectorIndex - seslNumberPickerSpinnerDelegate3.mMinValue];
            }
            if (number == null || !z) {
                return number;
            }
            return AbstractC0622a.m1170p(SeslNumberPickerSpinnerDelegate.this.mPickerContentDescription, SQLKeyword.COMMA, AbstractC0541b.m781w(number, SQLKeyword.COMMA));
        }

        private String getVirtualDecrementButtonText() {
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            int i = seslNumberPickerSpinnerDelegate.mWheelInterval;
            if (i == 1 || !seslNumberPickerSpinnerDelegate.mCustomWheelIntervalMode) {
                i = 1;
            }
            int wrappedSelectorIndex = seslNumberPickerSpinnerDelegate.mValue - i;
            if (seslNumberPickerSpinnerDelegate.mWrapSelectorWheel) {
                wrappedSelectorIndex = seslNumberPickerSpinnerDelegate.getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
            if (wrappedSelectorIndex < seslNumberPickerSpinnerDelegate2.mMinValue) {
                return null;
            }
            if (seslNumberPickerSpinnerDelegate2.mCustomTalkbackFormatter != null) {
                return SeslNumberPickerSpinnerDelegate.this.mCustomTalkbackFormatter.format(wrappedSelectorIndex);
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate3 = SeslNumberPickerSpinnerDelegate.this;
            String[] strArr = seslNumberPickerSpinnerDelegate3.mDisplayedValues;
            return strArr == null ? seslNumberPickerSpinnerDelegate3.formatNumber(wrappedSelectorIndex) : strArr[wrappedSelectorIndex - seslNumberPickerSpinnerDelegate3.mMinValue];
        }

        private String getVirtualIncrementButtonText() {
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            int i = seslNumberPickerSpinnerDelegate.mWheelInterval;
            if (i == 1 || !seslNumberPickerSpinnerDelegate.mCustomWheelIntervalMode) {
                i = 1;
            }
            int wrappedSelectorIndex = seslNumberPickerSpinnerDelegate.mValue + i;
            if (seslNumberPickerSpinnerDelegate.mWrapSelectorWheel) {
                wrappedSelectorIndex = seslNumberPickerSpinnerDelegate.getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
            if (wrappedSelectorIndex > seslNumberPickerSpinnerDelegate2.mMaxValue) {
                return null;
            }
            if (seslNumberPickerSpinnerDelegate2.mCustomTalkbackFormatter != null) {
                return SeslNumberPickerSpinnerDelegate.this.mCustomTalkbackFormatter.format(wrappedSelectorIndex);
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate3 = SeslNumberPickerSpinnerDelegate.this;
            String[] strArr = seslNumberPickerSpinnerDelegate3.mDisplayedValues;
            return strArr == null ? seslNumberPickerSpinnerDelegate3.formatNumber(wrappedSelectorIndex) : strArr[wrappedSelectorIndex - seslNumberPickerSpinnerDelegate3.mMinValue];
        }

        private boolean hasVirtualDecrementButton() {
            return SeslNumberPickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslNumberPickerSpinnerDelegate.this.getValue() > SeslNumberPickerSpinnerDelegate.this.getMinValue();
        }

        private boolean hasVirtualIncrementButton() {
            return SeslNumberPickerSpinnerDelegate.this.getWrapSelectorWheel() || SeslNumberPickerSpinnerDelegate.this.getValue() < SeslNumberPickerSpinnerDelegate.this.getMaxValue();
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
        private void sendAccessibilityEventForVirtualButton(int i, int i2, String str) {
            if (SeslNumberPickerSpinnerDelegate.this.mAccessibilityManager.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
                accessibilityEventObtain.setClassName(Button.class.getName());
                accessibilityEventObtain.setPackageName(SeslNumberPickerSpinnerDelegate.this.mContext.getPackageName());
                accessibilityEventObtain.getText().add(str);
                accessibilityEventObtain.setEnabled(SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled());
                accessibilityEventObtain.setSource(SeslNumberPickerSpinnerDelegate.this.mDelegator, i);
                SeslNumberPicker seslNumberPicker = SeslNumberPickerSpinnerDelegate.this.mDelegator;
                seslNumberPicker.requestSendAccessibilityEvent(seslNumberPicker, accessibilityEventObtain);
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
        private void sendAccessibilityEventForVirtualText(int i) {
            if (SeslNumberPickerSpinnerDelegate.this.mAccessibilityManager.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
                SeslNumberPickerSpinnerDelegate.this.mInputText.onInitializeAccessibilityEvent(accessibilityEventObtain);
                SeslNumberPickerSpinnerDelegate.this.mInputText.onPopulateAccessibilityEvent(accessibilityEventObtain);
                accessibilityEventObtain.setSource(SeslNumberPickerSpinnerDelegate.this.mDelegator, 2);
                SeslNumberPicker seslNumberPicker = SeslNumberPickerSpinnerDelegate.this.mDelegator;
                seslNumberPicker.requestSendAccessibilityEvent(seslNumberPicker, accessibilityEventObtain);
            }
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            int left = SeslNumberPickerSpinnerDelegate.this.mDelegator.getLeft();
            int right = SeslNumberPickerSpinnerDelegate.this.mDelegator.getRight();
            int top = SeslNumberPickerSpinnerDelegate.this.mDelegator.getTop();
            int bottom = SeslNumberPickerSpinnerDelegate.this.mDelegator.getBottom();
            int scrollX = SeslNumberPickerSpinnerDelegate.this.mDelegator.getScrollX();
            int scrollY = SeslNumberPickerSpinnerDelegate.this.mDelegator.getScrollY();
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            if (seslNumberPickerSpinnerDelegate.mLastFocusedChildVirtualViewId != -1 || seslNumberPickerSpinnerDelegate.mLastHoveredChildVirtualViewId != Integer.MIN_VALUE) {
                if (i == -1) {
                    return createAccessibilityNodeInfoForNumberPicker(scrollX, scrollY, (right - left) + scrollX, (bottom - top) + scrollY);
                }
                if (i == 1) {
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
                    return createAccessibilityNodeInfoForVirtualButton(1, getVirtualDecrementButtonText(), scrollX, scrollY, (right - left) + scrollX, seslNumberPickerSpinnerDelegate2.mTopSelectionDividerTop + seslNumberPickerSpinnerDelegate2.mSelectionDividerHeight);
                }
                if (i == 2) {
                    int i2 = seslNumberPickerSpinnerDelegate.mTopSelectionDividerTop;
                    int i4 = seslNumberPickerSpinnerDelegate.mSelectionDividerHeight;
                    return createAccessibiltyNodeInfoForInputText(scrollX, i2 + i4, (right - left) + scrollX, seslNumberPickerSpinnerDelegate.mBottomSelectionDividerBottom - i4);
                }
                if (i == 3) {
                    String virtualIncrementButtonText = getVirtualIncrementButtonText();
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate3 = SeslNumberPickerSpinnerDelegate.this;
                    return createAccessibilityNodeInfoForVirtualButton(3, virtualIncrementButtonText, scrollX, seslNumberPickerSpinnerDelegate3.mBottomSelectionDividerBottom - seslNumberPickerSpinnerDelegate3.mSelectionDividerHeight, (right - left) + scrollX, (bottom - top) + scrollY);
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
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            if (seslNumberPickerSpinnerDelegate.mIsStartingAnimation) {
                return false;
            }
            int right = seslNumberPickerSpinnerDelegate.mDelegator.getRight();
            int bottom = SeslNumberPickerSpinnerDelegate.this.mDelegator.getBottom();
            if (i != -1) {
                if (i == 1) {
                    if (i2 == 16) {
                        if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                            return false;
                        }
                        SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(false);
                        SeslNumberPickerSpinnerDelegate.this.changeValueByOne(false);
                        sendAccessibilityEventForVirtualView(i, 1);
                        SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(true);
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.mAccessibilityFocusedView == i) {
                            return false;
                        }
                        this.mAccessibilityFocusedView = i;
                        sendAccessibilityEventForVirtualView(i, 32768);
                        SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
                        seslNumberPickerSpinnerDelegate2.mDelegator.invalidate(0, 0, right, seslNumberPickerSpinnerDelegate2.mTopSelectionDividerTop);
                        return true;
                    }
                    if (i2 != 128 || this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    sendAccessibilityEventForVirtualView(i, 65536);
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate3 = SeslNumberPickerSpinnerDelegate.this;
                    seslNumberPickerSpinnerDelegate3.mDelegator.invalidate(0, 0, right, seslNumberPickerSpinnerDelegate3.mTopSelectionDividerTop);
                    return true;
                }
                if (i == 2) {
                    if (i2 == 1) {
                        if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled() || SeslNumberPickerSpinnerDelegate.this.mInputText.isFocused()) {
                            return false;
                        }
                        return SeslNumberPickerSpinnerDelegate.this.mInputText.requestFocus();
                    }
                    if (i2 == 2) {
                        if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled() || !SeslNumberPickerSpinnerDelegate.this.mInputText.isFocused()) {
                            return false;
                        }
                        SeslNumberPickerSpinnerDelegate.this.mInputText.clearFocus();
                        return true;
                    }
                    if (i2 == 16) {
                        if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                            return false;
                        }
                        SeslNumberPickerSpinnerDelegate.this.performClick();
                        return true;
                    }
                    if (i2 == 32) {
                        if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                            return false;
                        }
                        SeslNumberPickerSpinnerDelegate.this.performLongClick();
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.mAccessibilityFocusedView == i) {
                            return false;
                        }
                        this.mAccessibilityFocusedView = i;
                        sendAccessibilityEventForVirtualView(i, 32768);
                        SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate4 = SeslNumberPickerSpinnerDelegate.this;
                        seslNumberPickerSpinnerDelegate4.mDelegator.invalidate(0, seslNumberPickerSpinnerDelegate4.mTopSelectionDividerTop, right, seslNumberPickerSpinnerDelegate4.mBottomSelectionDividerBottom);
                        return true;
                    }
                    if (i2 != 128) {
                        return SeslNumberPickerSpinnerDelegate.this.mInputText.performAccessibilityAction(i2, bundle);
                    }
                    if (this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    sendAccessibilityEventForVirtualView(i, 65536);
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate5 = SeslNumberPickerSpinnerDelegate.this;
                    seslNumberPickerSpinnerDelegate5.mDelegator.invalidate(0, seslNumberPickerSpinnerDelegate5.mTopSelectionDividerTop, right, seslNumberPickerSpinnerDelegate5.mBottomSelectionDividerBottom);
                    return true;
                }
                if (i == 3) {
                    if (i2 == 16) {
                        if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled()) {
                            return false;
                        }
                        SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(false);
                        SeslNumberPickerSpinnerDelegate.this.changeValueByOne(true);
                        sendAccessibilityEventForVirtualView(i, 1);
                        SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(true);
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.mAccessibilityFocusedView == i) {
                            return false;
                        }
                        this.mAccessibilityFocusedView = i;
                        sendAccessibilityEventForVirtualView(i, 32768);
                        SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate6 = SeslNumberPickerSpinnerDelegate.this;
                        seslNumberPickerSpinnerDelegate6.mDelegator.invalidate(0, seslNumberPickerSpinnerDelegate6.mBottomSelectionDividerBottom, right, bottom);
                        return true;
                    }
                    if (i2 != 128 || this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    sendAccessibilityEventForVirtualView(i, 65536);
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate7 = SeslNumberPickerSpinnerDelegate.this;
                    seslNumberPickerSpinnerDelegate7.mDelegator.invalidate(0, seslNumberPickerSpinnerDelegate7.mBottomSelectionDividerBottom, right, bottom);
                    return true;
                }
            } else {
                if (i2 == 64) {
                    if (this.mAccessibilityFocusedView == i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = i;
                    SeslViewReflector.requestAccessibilityFocus(SeslNumberPickerSpinnerDelegate.this.mDelegator);
                    return true;
                }
                if (i2 == 128) {
                    if (this.mAccessibilityFocusedView != i) {
                        return false;
                    }
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    SeslViewReflector.clearAccessibilityFocus(SeslNumberPickerSpinnerDelegate.this.mDelegator);
                    return true;
                }
                if (i2 == 4096) {
                    if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled() || (!SeslNumberPickerSpinnerDelegate.this.getWrapSelectorWheel() && SeslNumberPickerSpinnerDelegate.this.getValue() >= SeslNumberPickerSpinnerDelegate.this.getMaxValue())) {
                        return false;
                    }
                    SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(false);
                    SeslNumberPickerSpinnerDelegate.this.changeValueByOne(true);
                    SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(true);
                    return true;
                }
                if (i2 == 8192) {
                    if (!SeslNumberPickerSpinnerDelegate.this.mDelegator.isEnabled() || (!SeslNumberPickerSpinnerDelegate.this.getWrapSelectorWheel() && SeslNumberPickerSpinnerDelegate.this.getValue() <= SeslNumberPickerSpinnerDelegate.this.getMinValue())) {
                        return false;
                    }
                    SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(false);
                    SeslNumberPickerSpinnerDelegate.this.changeValueByOne(false);
                    SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(true);
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
                sendAccessibilityEventForVirtualText(i2);
            } else if (i == 3 && hasVirtualIncrementButton()) {
                sendAccessibilityEventForVirtualButton(i, i2, getVirtualIncrementButtonText());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BeginSoftInputOnLongPressCommand implements Runnable {
        public BeginSoftInputOnLongPressCommand() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SeslNumberPickerSpinnerDelegate.this.performLongClick();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HapticPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        public boolean mSkipHapticCalls;

        private HapticPreDrawListener() {
            this.mSkipHapticCalls = false;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.mSkipHapticCalls = false;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class InputTextFilter extends NumberKeyListener {
        public InputTextFilter() {
        }

        @Override // android.text.method.NumberKeyListener, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
            if (SeslNumberPickerSpinnerDelegate.this.mDisplayedValues == null) {
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter == null) {
                    charSequenceFilter = charSequence.subSequence(i, i2);
                }
                String str = String.valueOf(spanned.subSequence(0, i4)) + ((Object) charSequenceFilter) + ((Object) spanned.subSequence(i5, spanned.length()));
                if ("".equals(str)) {
                    return str;
                }
                if (SeslNumberPickerSpinnerDelegate.this.getSelectedPos(str) <= SeslNumberPickerSpinnerDelegate.this.mMaxValue) {
                    int length = str.length();
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
                    if (length <= seslNumberPickerSpinnerDelegate.formatNumber(seslNumberPickerSpinnerDelegate.mMaxValue).length()) {
                        return charSequenceFilter;
                    }
                }
                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
                if (seslNumberPickerSpinnerDelegate2.mIsEditTextMode) {
                    if (seslNumberPickerSpinnerDelegate2.mToast == null) {
                        SeslNumberPickerSpinnerDelegate.this.initToastObject();
                    }
                    SeslNumberPickerSpinnerDelegate.this.mToast.show();
                }
                return "";
            }
            String strValueOf = String.valueOf(charSequence.subSequence(i, i2));
            String lowerCase = String.valueOf(String.valueOf(spanned.subSequence(0, i4)) + ((Object) strValueOf) + ((Object) spanned.subSequence(i5, spanned.length()))).toLowerCase();
            boolean zNeedCompareEqualMonthLanguage = SeslNumberPickerSpinnerDelegate.this.needCompareEqualMonthLanguage();
            for (String str2 : SeslNumberPickerSpinnerDelegate.this.mDisplayedValues) {
                String lowerCase2 = str2.toLowerCase();
                if ((zNeedCompareEqualMonthLanguage && lowerCase2.equals(lowerCase)) || lowerCase2.startsWith(lowerCase)) {
                    return strValueOf;
                }
            }
            if (SeslNumberPickerSpinnerDelegate.this.mIsEditTextMode && !TextUtils.isEmpty(lowerCase)) {
                if (SeslNumberPickerSpinnerDelegate.this.mToast == null) {
                    SeslNumberPickerSpinnerDelegate.this.initToastObject();
                }
                SeslNumberPickerSpinnerDelegate.this.mToast.show();
            }
            return "";
        }

        @Override // android.text.method.NumberKeyListener
        public char[] getAcceptedChars() {
            return SeslNumberPickerSpinnerDelegate.DIGIT_CHARACTERS;
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PressedStateHelper implements Runnable {
        public static final int BUTTON_DECREMENT = 2;
        public static final int BUTTON_INCREMENT = 1;
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
            SeslNumberPickerSpinnerDelegate.this.mDelegator.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        public void buttonTapped(int i) {
            cancel();
            this.mMode = 2;
            this.mManagedButton = i;
            SeslNumberPickerSpinnerDelegate.this.mDelegator.post(this);
        }

        public void cancel() {
            int right = SeslNumberPickerSpinnerDelegate.this.mDelegator.getRight();
            int bottom = SeslNumberPickerSpinnerDelegate.this.mDelegator.getBottom();
            this.mMode = 0;
            this.mManagedButton = 0;
            SeslNumberPickerSpinnerDelegate.this.mDelegator.removeCallbacks(this);
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            if (seslNumberPickerSpinnerDelegate.mIncrementVirtualButtonPressed) {
                seslNumberPickerSpinnerDelegate.mIncrementVirtualButtonPressed = false;
                seslNumberPickerSpinnerDelegate.mDelegator.invalidate(0, seslNumberPickerSpinnerDelegate.mBottomSelectionDividerBottom, right, bottom);
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
            if (seslNumberPickerSpinnerDelegate2.mDecrementVirtualButtonPressed) {
                seslNumberPickerSpinnerDelegate2.mDecrementVirtualButtonPressed = false;
                seslNumberPickerSpinnerDelegate2.mDelegator.invalidate(0, 0, right, seslNumberPickerSpinnerDelegate2.mTopSelectionDividerTop);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int right = SeslNumberPickerSpinnerDelegate.this.mDelegator.getRight();
            int bottom = SeslNumberPickerSpinnerDelegate.this.mDelegator.getBottom();
            int i = this.mMode;
            if (i == 1) {
                int i2 = this.mManagedButton;
                if (i2 == 1) {
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
                    seslNumberPickerSpinnerDelegate.mIncrementVirtualButtonPressed = true;
                    seslNumberPickerSpinnerDelegate.mDelegator.invalidate(0, seslNumberPickerSpinnerDelegate.mBottomSelectionDividerBottom, right, bottom);
                    return;
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
                    seslNumberPickerSpinnerDelegate2.mDecrementVirtualButtonPressed = true;
                    seslNumberPickerSpinnerDelegate2.mDelegator.invalidate(0, 0, right, seslNumberPickerSpinnerDelegate2.mTopSelectionDividerTop);
                    return;
                }
            }
            if (i != 2) {
                return;
            }
            int i4 = this.mManagedButton;
            if (i4 == 1) {
                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate3 = SeslNumberPickerSpinnerDelegate.this;
                if (!seslNumberPickerSpinnerDelegate3.mIncrementVirtualButtonPressed) {
                    seslNumberPickerSpinnerDelegate3.mDelegator.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate4 = SeslNumberPickerSpinnerDelegate.this;
                seslNumberPickerSpinnerDelegate4.mIncrementVirtualButtonPressed = !seslNumberPickerSpinnerDelegate4.mIncrementVirtualButtonPressed;
                seslNumberPickerSpinnerDelegate4.mDelegator.invalidate(0, seslNumberPickerSpinnerDelegate4.mBottomSelectionDividerBottom, right, bottom);
                return;
            }
            if (i4 != 2) {
                return;
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate5 = SeslNumberPickerSpinnerDelegate.this;
            if (!seslNumberPickerSpinnerDelegate5.mDecrementVirtualButtonPressed) {
                seslNumberPickerSpinnerDelegate5.mDelegator.postDelayed(this, ViewConfiguration.getPressedStateDuration());
            }
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate6 = SeslNumberPickerSpinnerDelegate.this;
            seslNumberPickerSpinnerDelegate6.mDecrementVirtualButtonPressed = !seslNumberPickerSpinnerDelegate6.mDecrementVirtualButtonPressed;
            seslNumberPickerSpinnerDelegate6.mDelegator.invalidate(0, 0, right, seslNumberPickerSpinnerDelegate6.mTopSelectionDividerTop);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SwitchIntervalOnLongPressCommand implements Runnable {
        public SwitchIntervalOnLongPressCommand() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
            seslNumberPickerSpinnerDelegate.mIgnoreMoveEvents = true;
            seslNumberPickerSpinnerDelegate.mIgnoreUpEvent = true;
            seslNumberPickerSpinnerDelegate.applyWheelCustomInterval(true ^ seslNumberPickerSpinnerDelegate.mCustomWheelIntervalMode);
        }
    }

    public SeslNumberPickerSpinnerDelegate(SeslNumberPicker seslNumberPicker, Context context, AttributeSet attributeSet, int i, int i2) {
        int i4;
        super(seslNumberPicker, context);
        this.mWheelInterval = 1;
        this.mCustomWheelIntervalMode = false;
        this.mIsPressedBackKey = false;
        this.mSelectorIndexToStringCache = new SparseArray<>();
        this.mSelectorIndices = new int[5];
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mWrapSelectorWheelPreferred = true;
        this.mScrollState = 0;
        this.mIsEditTextModeEnabled = true;
        this.mIsLongClicked = false;
        this.mIsStartingAnimation = false;
        this.mReservedStartAnimation = false;
        this.mIsLongPressed = false;
        this.mCustomTypefaceSet = false;
        this.mIsCustomScrollColorForPicker = false;
        this.mIsValueChanged = false;
        PathInterpolator pathInterpolator = new PathInterpolator(0.5f, 0.0f, 0.4f, 1.0f);
        this.SIZE_PATH_INTERPOLATOR = pathInterpolator;
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.17f, 0.17f, 0.83f, 0.83f);
        this.ALPHA_PATH_INTERPOLATOR = pathInterpolator2;
        this.mActivatedAlpha = 0.4f;
        this.mIdleAlpha = 0.2f;
        this.mInitialAlpha = 1.0f;
        this.mAlpha = 0.2f;
        this.mShortFlickThreshold = 1700;
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SeslNumberPickerSpinnerDelegate.this.mAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SeslNumberPickerSpinnerDelegate.this.mDelegator.invalidate();
            }
        };
        this.mColorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SeslNumberPickerSpinnerDelegate.this.mTextColor = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SeslNumberPickerSpinnerDelegate.this.mDelegator.invalidate();
            }
        };
        this.mSpringAnimationUpdateListener = new DynamicAnimation.OnAnimationUpdateListener() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.8
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
                if (f4 <= 0.0f) {
                    f4 = -f4;
                }
                seslNumberPickerSpinnerDelegate.mCurVelocity = f4;
                float f5 = f - seslNumberPickerSpinnerDelegate.mPreviousSpringY;
                if (!seslNumberPickerSpinnerDelegate.mSpringFlingRunning && Math.round(f5) == 0) {
                    dynamicAnimation.cancel();
                    if (SeslNumberPickerSpinnerDelegate.this.ensureScrollWheelAdjusted()) {
                        return;
                    }
                    SeslNumberPickerSpinnerDelegate.this.updateInputTextView();
                    return;
                }
                if (Math.round(f5) == 0) {
                    SeslNumberPickerSpinnerDelegate.this.mSpringFlingRunning = false;
                }
                SeslNumberPickerSpinnerDelegate.this.scrollBy(0, Math.round(f5));
                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
                seslNumberPickerSpinnerDelegate2.mPreviousSpringY = f;
                seslNumberPickerSpinnerDelegate2.mDelegator.invalidate();
            }
        };
        this.mSpringAnimationEndListener = new DynamicAnimation.OnAnimationEndListener() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.9
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
                SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
                seslNumberPickerSpinnerDelegate.mSpringFlingRunning = false;
                seslNumberPickerSpinnerDelegate.mGravityScroller.forceFinished(true);
                SeslNumberPickerSpinnerDelegate.this.startFadeAnimation(true);
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
        if (dimensionPixelSize3 != -1 && dimensionPixelSize4 != -1 && dimensionPixelSize3 > dimensionPixelSize4) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        if (dimensionPixelSize5 != -1 && (i4 = this.mMaxWidth) != -1 && dimensionPixelSize5 > i4) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        this.mSelectionDividerHeight = (int) TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics());
        this.mComputeMaxWidth = this.mMaxWidth == -1;
        if (!SeslMisc.isLightTheme(this.mContext)) {
            this.mIdleAlpha = 0.2f;
            this.mAlpha = 0.2f;
        }
        this.mPressedStateHelper = new PressedStateHelper();
        this.mDelegator.setWillNotDraw(false);
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C3623R.layout.sesl_number_picker_spinner, (ViewGroup) this.mDelegator, true);
        EditText editText = (EditText) this.mDelegator.findViewById(C3623R.id.numberpicker_input);
        this.mInputText = editText;
        editText.setLongClickable(false);
        editText.setIncludeFontPadding(false);
        editText.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
                if (i5 == 16) {
                    SeslNumberPickerSpinnerDelegate.this.mInputText.selectAll();
                    SeslNumberPickerSpinnerDelegate.this.showSoftInput();
                }
                return super.performAccessibilityAction(view, i5, bundle);
            }
        });
        Typeface typefaceDefaultFromStyle = Typeface.defaultFromStyle(1);
        this.mDefaultTypeface = typefaceDefaultFromStyle;
        Typeface typefaceCreate = Typeface.create("sec-roboto-condensed-light", 1);
        this.mLegacyTypeface = typefaceCreate;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            this.mPickerTypeface = Typeface.create(Typeface.create("sec", 0), 600, false);
        } else {
            Typeface typefaceCreate2 = Typeface.create("sec-roboto-light", 1);
            this.mPickerTypeface = typefaceCreate2;
            if (typefaceDefaultFromStyle.equals(typefaceCreate2)) {
                if (typefaceCreate.equals(this.mPickerTypeface)) {
                    this.mPickerTypeface = Typeface.create("sans-serif-thin", 1);
                } else {
                    this.mPickerTypeface = typefaceCreate;
                }
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
            editText.setIncludeFontPadding(true);
            this.mPickerTypeface = typefaceDefaultFromStyle;
            this.mPickerSubTypeface = Typeface.create(typefaceDefaultFromStyle, 0);
        }
        this.mIsHcfEnabled = isHighContrastFontEnabled();
        this.mHcfFocusedTypefaceBold = Typeface.create(this.mPickerTypeface, 1);
        setInputTextTypeface();
        initPickerTextColor(this.mContext);
        this.mVirtualButtonFocusedDrawable = new ColorDrawable(this.selectedPickerColor);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SeslNumberPickerSpinnerDelegate.this.setEditTextMode(true);
                    SeslNumberPickerSpinnerDelegate.this.mInputText.selectAll();
                } else {
                    SeslNumberPickerSpinnerDelegate.this.mInputText.setSelection(0, 0);
                    SeslNumberPickerSpinnerDelegate.this.validateInputTextView(view);
                }
            }
        });
        editText.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!(view instanceof EditText) || motionEvent.getActionMasked() != 0) {
                    return false;
                }
                ((EditText) view).selectAll();
                SeslNumberPickerSpinnerDelegate.this.showSoftInput();
                return true;
            }
        });
        editText.setFilters(new InputFilter[]{new InputTextFilter()});
        editText.setRawInputType(2);
        editText.setImeOptions(33554438);
        if (i5 >= 33) {
            editText.setAutoHandwritingEnabled(false);
        } else {
            editText.setPrivateImeOptions("disableDirectWriting=true;");
        }
        editText.setCursorVisible(false);
        SeslViewReflector.semSetHoverPopupType(editText, SeslHoverPopupWindowReflector.getField_TYPE_NONE());
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
        if (updateBoldTextEnabledInSettings()) {
            this.mSelectorWheelPaint.setFakeBoldText(true);
        }
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
        setFormatter(SeslNumberPicker.getTwoDigitFormatter());
        updateInputTextView();
        this.mDelegator.setVerticalScrollBarEnabled(false);
        if (this.mDelegator.getImportantForAccessibility() == 0) {
            this.mDelegator.setImportantForAccessibility(1);
        }
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mHapticPreDrawListener = new HapticPreDrawListener();
        this.mPickerVibrateIndex = SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(32);
        this.mPickerSoundIndex = SeslAudioManagerReflector.getField_SOUND_TIME_PICKER_SCROLL();
        this.mPickerSoundFastIndex = SeslAudioManagerReflector.getField_SOUND_TIME_PICKER_SCROLL_FAST();
        this.mPickerSoundSlowIndex = SeslAudioManagerReflector.getField_SOUND_TIME_PICKER_SCROLL_SLOW();
        SeslSemSoundAssistantManagerReflector.setFastAudioOpenMode(this.mContext, true);
        this.mDelegator.setFocusableInTouchMode(false);
        this.mDelegator.setDescendantFocusability(131072);
        this.mDelegator.setDefaultFocusHighlightEnabled(false);
        this.mPickerContentDescription = "";
        this.mToastText = resources.getString(C3623R.string.sesl_number_picker_invalid_value_entered);
        this.mUnitValue = "";
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
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.mTextColorIdle), Integer.valueOf(this.mTextColorScrolling));
        this.mColorInAnimator = valueAnimatorOfObject;
        valueAnimatorOfObject.setInterpolator(pathInterpolator2);
        this.mColorInAnimator.setDuration(200L);
        this.mColorInAnimator.addUpdateListener(this.mColorUpdateListener);
        ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.mTextColorScrolling), Integer.valueOf(this.mTextColorIdle));
        this.mColorOutAnimator = valueAnimatorOfObject2;
        valueAnimatorOfObject2.setInterpolator(pathInterpolator2);
        this.mColorOutAnimator.setDuration(200L);
        this.mColorOutAnimator.setStartDelay(100L);
        this.mColorOutAnimator.addUpdateListener(this.mColorUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeValueByOne(boolean z) {
        this.mInputText.setVisibility(4);
        if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
            moveToFinalScrollerPosition(this.mAdjustScroller);
        }
        this.mPreviousScrollerY = 0;
        if (z) {
            this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 500);
        } else {
            this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 500);
        }
        this.mDelegator.invalidate();
    }

    private void decrementSelectorIndices(int[] iArr) {
        System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
        int i = iArr[1] - 1;
        if (this.mWrapSelectorWheel && i < this.mMinValue) {
            i = this.mMaxValue;
        }
        iArr[0] = i;
        ensureCachedScrollSelectorValue(i);
    }

    private void ensureCachedScrollSelectorValue(int i) {
        String number;
        SparseArray<String> sparseArray = this.mSelectorIndexToStringCache;
        if (sparseArray.get(i) != null) {
            return;
        }
        int i2 = this.mMinValue;
        if (i < i2 || i > this.mMaxValue) {
            number = "";
        } else {
            String[] strArr = this.mDisplayedValues;
            number = strArr != null ? strArr[i - i2] : formatNumber(i);
        }
        sparseArray.put(i, number);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureScrollWheelAdjusted() {
        return ensureScrollWheelAdjusted(0);
    }

    private void ensureValueAdjusted(int i) {
        int i2 = this.mValue;
        int i4 = i2 % i;
        if (i4 == 0) {
            return;
        }
        int i5 = i2 - i4;
        if (i4 > i / 2) {
            i5 += i;
        }
        setValueInternal(i5, true);
    }

    private void fling(int i) {
        if (!this.mWrapSelectorWheel && i > 0 && getValue() == getMinValue()) {
            startFadeAnimation(true);
            return;
        }
        if (!this.mWrapSelectorWheel && i < 0 && getValue() == getMaxValue()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public String formatNumber(int i) {
        SeslNumberPicker.Formatter formatter = this.mFormatter;
        return formatter != null ? formatter.format(i) : formatNumberWithLocale(i);
    }

    private static String formatNumberWithLocale(int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectedPos(String str) {
        try {
            if (this.mDisplayedValues == null) {
                return Integer.parseInt(str);
            }
            for (int i = 0; i < this.mDisplayedValues.length; i++) {
                str = str.toLowerCase();
                if (this.mDisplayedValues[i].toLowerCase().startsWith(str)) {
                    return this.mMinValue + i;
                }
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return this.mMinValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWrappedSelectorIndex(int i) {
        int i2 = this.mMaxValue;
        if (i > i2) {
            int i4 = this.mMinValue;
            return ((i - i4) % ((i2 - i4) + 1)) + i4;
        }
        int i5 = this.mMinValue;
        return i < i5 ? i2 - ((i2 - i) % ((i2 - i5) + 1)) : i;
    }

    private void hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive(this.mInputText)) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
        this.mInputText.setVisibility(4);
    }

    private void incrementSelectorIndices(int[] iArr) {
        System.arraycopy(iArr, 1, iArr, 0, iArr.length - 1);
        int i = iArr[iArr.length - 2] + 1;
        if (this.mWrapSelectorWheel && i > this.mMaxValue) {
            i = this.mMinValue;
        }
        iArr[iArr.length - 1] = i;
        ensureCachedScrollSelectorValue(i);
    }

    private void initPickerTextColor(Context context) {
        if (this.mIsCustomScrollColorForPicker) {
            this.mTextColorScrolling = this.mCustomTextColorScrolling;
            this.mTextColorIdle = ResourcesCompat.getColor(context.getResources(), C3623R.color.sesl_number_picker_text_color_appwidget, context.getTheme());
            this.selectedPickerColor = ResourcesCompat.getColor(context.getResources(), C3623R.color.sesl_number_picker_text_highlight_color_appwidget, context.getTheme());
            int i = this.mTextColorIdle;
            this.mTextColor = i;
            this.mSelectorWheelPaint.setColor(i);
            this.mInputText.setHighlightColor(this.selectedPickerColor);
            this.mInputText.setTextColor(this.mContext.getResources().getColor(C3623R.color.sesl_number_picker_text_color_appwidget));
            return;
        }
        this.mTextColorScrolling = ResourcesCompat.getColor(context.getResources(), C3623R.color.sesl_number_picker_text_color_scroll, context.getTheme());
        ColorStateList textColors = this.mInputText.getTextColors();
        int[] enableStateSet = this.mDelegator.getEnableStateSet();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 29) {
            this.mTextColorIdle = textColors.getColorForState(enableStateSet, -1);
            this.selectedPickerColor = ResourcesCompat.getColor(context.getResources(), C3623R.color.sesl_number_picker_text_highlight_color, context.getTheme());
        } else {
            this.mTextColorIdle = ResourcesCompat.getColor(context.getResources(), C3623R.color.sesl_number_picker_text_color_scroll, context.getTheme());
            this.selectedPickerColor = (this.mTextColorScrolling & 16777215) | 855638016;
        }
        this.mTextColor = this.mTextColorIdle;
        this.mInputText.setHighlightColor(this.selectedPickerColor);
        if (i2 <= 29) {
            this.mInputText.setTextColor(this.mTextColorScrolling);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initToastObject() {
        this.mToast = Toast.makeText(this.mContext, this.mToastText, 0);
        View viewInflate = LayoutInflater.from(this.mContext).inflate(C3623R.layout.sesl_custom_toast_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(C3623R.id.message)).setText(this.mToastText);
        this.mToast.setView(viewInflate);
    }

    private void initializeSelectorWheel() {
        if (this.mIsStartingAnimation) {
            if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
                moveToFinalScrollerPosition(this.mAdjustScroller);
            }
            stopScrollAnimation();
        } else {
            initializeSelectorWheelIndices();
        }
        int bottom = (int) ((((this.mDelegator.getBottom() - this.mDelegator.getTop()) - (this.mTextSize * 3)) / 3) + 0.5f);
        this.mSelectorTextGapHeight = bottom;
        int i = this.mTextSize + bottom;
        this.mSelectorElementHeight = i;
        int height = this.mModifiedTxtHeight;
        if (height > i || this.mIsAmPm) {
            height = this.mDelegator.getHeight() / 3;
        }
        this.mValueChangeOffset = height;
        int top = ((this.mModifiedTxtHeight / 2) + this.mInputText.getTop()) - this.mSelectorElementHeight;
        this.mInitialScrollOffset = top;
        this.mCurrentScrollOffset = top;
        ((SeslNumberPicker.CustomEditText) this.mInputText).setEditTextPosition(((int) (((this.mSelectorWheelPaint.descent() - this.mSelectorWheelPaint.ascent()) / 2.0f) - this.mSelectorWheelPaint.descent())) - (this.mInputText.getBaseline() - (this.mModifiedTxtHeight / 2)));
        if (this.mReservedStartAnimation) {
            startAnimation(0, this.mAnimationListener);
            this.mReservedStartAnimation = false;
        }
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] iArr = this.mSelectorIndices;
        int value = this.mIsStartingAnimation ? iArr[2] : getValue();
        for (int i = 0; i < this.mSelectorIndices.length; i++) {
            int wrappedSelectorIndex = ((i - 2) * (this.mCustomWheelIntervalMode ? this.mWheelInterval : 1)) + value;
            if (this.mWrapSelectorWheel) {
                wrappedSelectorIndex = getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            iArr[i] = wrappedSelectorIndex;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needCompareEqualMonthLanguage() {
        return LangPackConfigConstants.LANGUAGE_CODE_VI.equals(Locale.getDefault().getLanguage()) && INPUT_TYPE_MONTH.equals(this.mInputText.getPrivateImeOptions());
    }

    private void notifyChange(int i, int i2) {
        if (this.mAccessibilityManager.isEnabled() && !this.mIsStartingAnimation) {
            int wrappedSelectorIndex = getWrappedSelectorIndex(this.mValue);
            if (wrappedSelectorIndex <= this.mMaxValue) {
                String[] strArr = this.mDisplayedValues;
                if (strArr == null) {
                    formatNumber(wrappedSelectorIndex);
                } else {
                    String str = strArr[wrappedSelectorIndex - this.mMinValue];
                }
            }
            this.mDelegator.sendAccessibilityEvent(4);
            AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider();
            if (accessibilityNodeProviderImpl != null && (!this.mIsEditTextModeEnabled || (!this.mWrapSelectorWheel && (getValue() == getMaxValue() || getValue() == getMinValue())))) {
                accessibilityNodeProviderImpl.performAction(2, 64, null);
            }
        }
        SeslNumberPicker.OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this.mDelegator, i, this.mValue);
        }
    }

    private void onScrollStateChange(int i) {
        if (this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        SeslNumberPicker.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this.mDelegator, i);
        }
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller == this.mFlingScroller) {
            if (!ensureScrollWheelAdjusted()) {
                updateInputTextView();
            }
            onScrollStateChange(0);
        } else if (this.mScrollState != 1) {
            updateInputTextView();
        }
    }

    private void playSoundAndHapticFeedback() {
        this.mAudioManager.playSoundEffect(this.mCurVelocity > FAST_SCROLL_VELOCITY_START ? this.mPickerSoundFastIndex : this.mPickerSoundSlowIndex);
        if (this.mHapticPreDrawListener.mSkipHapticCalls) {
            return;
        }
        this.mDelegator.performHapticFeedback(SAMSUNG_VIBRATION_START);
        this.mHapticPreDrawListener.mSkipHapticCalls = true;
    }

    private void postBeginSoftInputOnLongPressCommand() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand == null) {
            this.mBeginSoftInputOnLongPressCommand = new BeginSoftInputOnLongPressCommand();
        } else {
            this.mDelegator.removeCallbacks(beginSoftInputOnLongPressCommand);
        }
        this.mDelegator.postDelayed(this.mBeginSoftInputOnLongPressCommand, ViewConfiguration.getLongPressTimeout());
    }

    private void postSwitchIntervalOnLongPress() {
        SwitchIntervalOnLongPressCommand switchIntervalOnLongPressCommand = this.mSwitchIntervalOnLongPressCommand;
        if (switchIntervalOnLongPressCommand == null) {
            this.mSwitchIntervalOnLongPressCommand = new SwitchIntervalOnLongPressCommand();
        } else {
            this.mDelegator.removeCallbacks(switchIntervalOnLongPressCommand);
        }
        this.mDelegator.postDelayed(this.mSwitchIntervalOnLongPressCommand, ViewConfiguration.getLongPressTimeout());
    }

    private void removeAllCallbacks() {
        SwitchIntervalOnLongPressCommand switchIntervalOnLongPressCommand = this.mSwitchIntervalOnLongPressCommand;
        if (switchIntervalOnLongPressCommand != null) {
            this.mDelegator.removeCallbacks(switchIntervalOnLongPressCommand);
        }
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand != null) {
            this.mDelegator.removeCallbacks(beginSoftInputOnLongPressCommand);
        }
        this.mPressedStateHelper.cancel();
    }

    private void removeBeginSoftInputCommand() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand != null) {
            this.mDelegator.removeCallbacks(beginSoftInputOnLongPressCommand);
        }
    }

    private void removeSwitchIntervalOnLongPress() {
        SwitchIntervalOnLongPressCommand switchIntervalOnLongPressCommand = this.mSwitchIntervalOnLongPressCommand;
        if (switchIntervalOnLongPressCommand != null) {
            this.mDelegator.removeCallbacks(switchIntervalOnLongPressCommand);
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
            this.mSelectorWheelPaint.setTextSize(this.mTextSize);
        }
    }

    private void setInputTextTypeface() {
        if (this.mIsHcfEnabled) {
            this.mInputText.setTypeface(this.mHcfFocusedTypefaceBold);
        } else {
            this.mInputText.setTypeface(this.mPickerTypeface);
        }
    }

    private void setValueInternal(int i, boolean z) {
        if (this.mValue == i) {
            if (isCharacterNumberLanguage()) {
                updateInputTextView();
                this.mDelegator.invalidate();
                return;
            }
            return;
        }
        int wrappedSelectorIndex = this.mWrapSelectorWheel ? getWrappedSelectorIndex(i) : Math.min(Math.max(i, this.mMinValue), this.mMaxValue);
        int i2 = this.mValue;
        this.mValue = wrappedSelectorIndex;
        updateInputTextView();
        if (z) {
            notifyChange(i2, wrappedSelectorIndex);
        }
        initializeSelectorWheelIndices();
        this.mDelegator.invalidate();
        if (!this.mAccessibilityManager.isEnabled() || this.mDelegator.getParent() == null) {
            return;
        }
        ViewParent parent = this.mDelegator.getParent();
        SeslNumberPicker seslNumberPicker = this.mDelegator;
        parent.notifySubtreeAccessibilityStateChanged(seslNumberPicker, seslNumberPicker, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager != null) {
            this.mInputText.setVisibility(0);
            this.mInputText.requestFocus();
            inputMethodManager.viewClicked(this.mInputText);
            inputMethodManager.showSoftInput(this.mInputText, 0);
        }
    }

    private void showSoftInputForWindowFocused() {
        this.mDelegator.postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.4
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) SeslNumberPickerSpinnerDelegate.this.mContext.getSystemService("input_method");
                if (inputMethodManager != null) {
                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate = SeslNumberPickerSpinnerDelegate.this;
                    if (seslNumberPickerSpinnerDelegate.mIsEditTextMode && seslNumberPickerSpinnerDelegate.mInputText.isFocused() && !inputMethodManager.showSoftInput(SeslNumberPickerSpinnerDelegate.this.mInputText, 0)) {
                        SeslNumberPickerSpinnerDelegate.this.mDelegator.postDelayed(new Runnable() { // from class: androidx.picker.widget.SeslNumberPickerSpinnerDelegate.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                InputMethodManager inputMethodManager2 = (InputMethodManager) SeslNumberPickerSpinnerDelegate.this.mContext.getSystemService("input_method");
                                if (inputMethodManager2 != null) {
                                    SeslNumberPickerSpinnerDelegate seslNumberPickerSpinnerDelegate2 = SeslNumberPickerSpinnerDelegate.this;
                                    if (seslNumberPickerSpinnerDelegate2.mIsEditTextMode && seslNumberPickerSpinnerDelegate2.mInputText.isFocused()) {
                                        inputMethodManager2.showSoftInput(SeslNumberPickerSpinnerDelegate.this.mInputText, 0);
                                    }
                                }
                            }
                        }, 20L);
                    }
                }
            }
        }, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFadeAnimation(boolean z) {
        if (z) {
            this.mFadeOutAnimator.setStartDelay((this.mFlingScroller.isFinished() ? 0 : this.mFlingScroller.getDuration()) + 100);
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
        this.mIsStartingAnimation = false;
        if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
            moveToFinalScrollerPosition(this.mAdjustScroller);
        }
        ensureScrollWheelAdjusted();
    }

    private void tryComputeMaxWidth() {
        int i;
        if (this.mComputeMaxWidth) {
            String[] strArr = this.mDisplayedValues;
            int i2 = 0;
            if (strArr == null) {
                float f = 0.0f;
                for (int i4 = 0; i4 <= 9; i4++) {
                    float fMeasureText = this.mSelectorWheelPaint.measureText(formatNumberWithLocale(i4));
                    if (fMeasureText > f) {
                        f = fMeasureText;
                    }
                }
                for (int i5 = this.mMaxValue; i5 > 0; i5 /= 10) {
                    i2++;
                }
                i = (int) (i2 * f);
            } else {
                int length = strArr.length;
                int i6 = 0;
                int length2 = 0;
                while (i2 < length) {
                    float fMeasureText2 = this.mSelectorWheelPaint.measureText(this.mDisplayedValues[i2]);
                    if (fMeasureText2 > i6) {
                        i6 = (int) fMeasureText2;
                        length2 = this.mDisplayedValues[i2].length();
                    }
                    i2++;
                }
                i = i6;
                i2 = length2;
            }
            int paddingRight = this.mInputText.getPaddingRight() + this.mInputText.getPaddingLeft() + i;
            if (isHighContrastFontEnabled()) {
                paddingRight += (i2 + 2) * ((int) Math.ceil(SeslPaintReflector.getHCTStrokeWidth(this.mSelectorWheelPaint) / 2.0f));
            }
            if (this.mMaxWidth != paddingRight) {
                int i7 = this.mMinWidth;
                if (paddingRight > i7) {
                    this.mMaxWidth = paddingRight;
                } else {
                    this.mMaxWidth = i7;
                }
                this.mDelegator.invalidate();
            }
        }
    }

    private boolean updateBoldTextEnabledInSettings() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        boolean z = Settings.Global.getInt(this.mContext.getContentResolver(), "bold_text", 0) != 0;
        this.mIsBoldTextEnabled = z;
        return z;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateInputTextView() {
        String[] strArr = this.mDisplayedValues;
        String number = strArr == null ? formatNumber(this.mValue) : strArr[this.mValue - this.mMinValue];
        if (TextUtils.isEmpty(number) || number.equals(this.mInputText.getText().toString())) {
            return false;
        }
        this.mInputText.setText(number);
        Selection.setSelection(this.mInputText.getText(), this.mInputText.getText().length());
        return true;
    }

    private void updateWrapSelectorWheel() {
        boolean z = this.mMaxValue - this.mMinValue >= this.mSelectorIndices.length && this.mWrapSelectorWheelPreferred;
        if (this.mWrapSelectorWheel != z) {
            this.mWrapSelectorWheel = z;
            initializeSelectorWheelIndices();
            this.mDelegator.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateInputTextView(View view) {
        String strValueOf = String.valueOf(((TextView) view).getText());
        int selectedPos = getSelectedPos(strValueOf);
        if (!TextUtils.isEmpty(strValueOf) && this.mValue != selectedPos) {
            int i = this.mWheelInterval;
            if (i != 1 && this.mCustomWheelIntervalMode) {
                applyWheelCustomInterval(selectedPos % i == 0);
            }
            setValueInternal(selectedPos, true);
            return;
        }
        int i2 = this.mWheelInterval;
        if (i2 != 1 && this.mCustomWheelIntervalMode && this.mIsPressedBackKey) {
            applyWheelCustomInterval(selectedPos % i2 == 0);
        } else {
            updateInputTextView();
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void applyWheelCustomInterval(boolean z) {
        int i = this.mWheelInterval;
        if (i == 1) {
            return;
        }
        this.mCustomWheelIntervalMode = z;
        if (z) {
            ensureValueAdjusted(i);
        }
        initializeSelectorWheelIndices();
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
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

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int computeVerticalScrollExtent() {
        return this.mDelegator.getHeight();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int computeVerticalScrollOffset() {
        return this.mCurrentScrollOffset;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int computeVerticalScrollRange() {
        return ((this.mMaxValue - this.mMinValue) + 1) * this.mSelectorElementHeight;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mAccessibilityManager.isEnabled()) {
            return false;
        }
        int y2 = (int) motionEvent.getY();
        int i = 2;
        if (!this.mIsEditTextMode) {
            if (y2 <= this.mTopSelectionDividerTop) {
                i = 1;
            } else if (this.mBottomSelectionDividerBottom <= y2) {
                i = 3;
            }
        }
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
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b7  */
    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
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
                    if (this.mIsEditTextMode) {
                        return false;
                    }
                    if (action == 0) {
                        if (keyCode == 20) {
                            int i = this.mLastFocusedChildVirtualViewId;
                            if (i == 1) {
                                this.mLastFocusedChildVirtualViewId = 2;
                                this.mDelegator.invalidate();
                                return true;
                            }
                            if (i == 2) {
                                if (!this.mWrapSelectorWheel && getValue() == getMaxValue()) {
                                    return false;
                                }
                                this.mLastFocusedChildVirtualViewId = 3;
                                this.mDelegator.invalidate();
                                return true;
                            }
                        } else if (keyCode == 19) {
                            int i2 = this.mLastFocusedChildVirtualViewId;
                            if (i2 == 2) {
                                if (!this.mWrapSelectorWheel && getValue() == getMinValue()) {
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
        } else if (!this.mIsEditTextMode && action == 1) {
            if (this.mLastFocusedChildVirtualViewId == 2) {
                if (!this.mIsEditTextModeEnabled) {
                    return false;
                }
                this.mInputText.setVisibility(0);
                this.mInputText.requestFocus();
                showSoftInput();
                removeAllCallbacks();
                return true;
            }
            if (this.mFlingScroller.isFinished()) {
                int i4 = this.mLastFocusedChildVirtualViewId;
                if (i4 == 1) {
                    startFadeAnimation(false);
                    changeValueByOne(false);
                    if (!this.mWrapSelectorWheel && getValue() == getMinValue() + 1) {
                        this.mLastFocusedChildVirtualViewId = 2;
                    }
                    startFadeAnimation(true);
                } else if (i4 == 3) {
                    startFadeAnimation(false);
                    changeValueByOne(true);
                    if (!this.mWrapSelectorWheel && getValue() == getMaxValue() - 1) {
                        this.mLastFocusedChildVirtualViewId = 2;
                    }
                    startFadeAnimation(true);
                }
            }
        }
        return false;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (!this.mIsEditTextModeEnabled) {
            return false;
        }
        if ((!this.mInputText.hasFocus() && (this.mIsEditTextModeEnabled || !this.mDelegator.hasFocus())) || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            this.mIsPressedBackKey = false;
            return false;
        }
        this.mIsPressedBackKey = true;
        hideSoftInput();
        setEditTextMode(false);
        return true;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            return false;
        }
        removeAllCallbacks();
        return false;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            removeAllCallbacks();
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.mAccessibilityNodeProvider == null) {
            this.mAccessibilityNodeProvider = new AccessibilityNodeProviderImpl();
        }
        return this.mAccessibilityNodeProvider;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public EditText getEditText() {
        return this.mInputText;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getMaxHeight() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getMaxValue() {
        return this.mMaxValue;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getMaxWidth() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getMinHeight() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getMinValue() {
        return this.mMinValue;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getMinWidth() {
        return 0;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getPaintFlags() {
        return this.mSelectorWheelPaint.getFlags();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public int getValue() {
        return this.mValue;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean isChangedDefaultInterval() {
        return (this.mWheelInterval == 1 || this.mCustomWheelIntervalMode) ? false : true;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean isEditTextMode() {
        return this.mIsEditTextMode;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean isEditTextModeEnabled() {
        return this.mIsEditTextModeEnabled;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean isEditTextModeNotAmPm() {
        return this.mIsEditTextMode && !this.mIsAmPm;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onAttachedToWindow() {
        this.mDelegator.getViewTreeObserver().addOnPreDrawListener(this.mHapticPreDrawListener);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onConfigurationChanged(Configuration configuration) {
        boolean z = this.mIsBoldTextEnabled;
        updateBoldTextEnabledInSettings();
        boolean z2 = this.mIsBoldTextEnabled;
        if (z != z2) {
            this.mSelectorWheelPaint.setFakeBoldText(z2);
        }
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

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onDetachedFromWindow() {
        this.mGravityScroller.abortAnimation();
        this.mSpringAnimation.cancel();
        this.mSpringFlingRunning = false;
        removeAllCallbacks();
        this.mDelegator.getViewTreeObserver().removeOnPreDrawListener(this.mHapticPreDrawListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x016b  */
    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        int right = this.mDelegator.getRight();
        int left = this.mDelegator.getLeft();
        int bottom = this.mDelegator.getBottom();
        float f = (right - left) / 2.0f;
        float f4 = this.mCurrentScrollOffset - this.mSelectorElementHeight;
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
        for (int i2 : this.mSelectorIndices) {
            String string = this.mSelectorIndexToStringCache.get(i2);
            if (string != null && !string.isEmpty() && !this.mUnitValue.isEmpty()) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
                sbM1324q.append(this.mUnitValue);
                string = sbM1324q.toString();
            }
            float f5 = this.mAlpha;
            float f6 = this.mIdleAlpha;
            if (f5 < f6) {
                f5 = f6;
            }
            int iDescent = (int) ((((this.mSelectorWheelPaint.descent() - this.mSelectorWheelPaint.ascent()) / 2.0f) + f4) - this.mSelectorWheelPaint.descent());
            int i4 = this.mTopSelectionDividerTop;
            int i5 = this.mInitialScrollOffset;
            if (f4 >= i4 - i5) {
                int i6 = this.mBottomSelectionDividerBottom;
                if (f4 > i5 + i6) {
                    canvas.save();
                    this.mSelectorWheelPaint.setAlpha((int) (f5 * 255.0f * this.mInitialAlpha));
                    this.mSelectorWheelPaint.setTypeface(this.mPickerSubTypeface);
                    canvas.drawText(string, f, iDescent, this.mSelectorWheelPaint);
                    canvas.restore();
                } else if (f4 <= (i4 + i6) / 2.0f) {
                    canvas.save();
                    canvas.clipRect(0, this.mTopSelectionDividerTop, right, this.mBottomSelectionDividerBottom);
                    this.mSelectorWheelPaint.setColor(this.mTextColor);
                    this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
                    float f7 = iDescent;
                    canvas.drawText(string, f, f7, this.mSelectorWheelPaint);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, 0, right, this.mTopSelectionDividerTop);
                    this.mSelectorWheelPaint.setTypeface(this.mPickerSubTypeface);
                    this.mSelectorWheelPaint.setAlpha((int) (f5 * 255.0f * this.mInitialAlpha));
                    canvas.drawText(string, f, f7, this.mSelectorWheelPaint);
                    canvas.restore();
                } else {
                    canvas.save();
                    canvas.clipRect(0, this.mTopSelectionDividerTop, right, this.mBottomSelectionDividerBottom);
                    this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
                    this.mSelectorWheelPaint.setColor(this.mTextColor);
                    float f8 = iDescent;
                    canvas.drawText(string, f, f8, this.mSelectorWheelPaint);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.mBottomSelectionDividerBottom, right, bottom);
                    this.mSelectorWheelPaint.setAlpha((int) (f5 * 255.0f * this.mInitialAlpha));
                    this.mSelectorWheelPaint.setTypeface(this.mPickerSubTypeface);
                    canvas.drawText(string, f, f8, this.mSelectorWheelPaint);
                    canvas.restore();
                }
            }
            f4 += this.mSelectorElementHeight;
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onFocusChanged(boolean z, int i, Rect rect) {
        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl;
        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl2;
        if (z) {
            if (this.mIsEditTextMode) {
                this.mLastFocusedChildVirtualViewId = -1;
                if (this.mInputText.getVisibility() == 0) {
                    this.mInputText.requestFocus();
                }
            } else {
                this.mLastFocusedChildVirtualViewId = 1;
                if (!this.mWrapSelectorWheel && getValue() == getMinValue()) {
                    this.mLastFocusedChildVirtualViewId = 2;
                }
            }
            if (this.mAccessibilityManager.isEnabled() && (accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider()) != null) {
                if (this.mIsEditTextMode) {
                    this.mLastFocusedChildVirtualViewId = 2;
                }
                accessibilityNodeProviderImpl.performAction(this.mLastFocusedChildVirtualViewId, 64, null);
            }
        } else {
            if (this.mAccessibilityManager.isEnabled() && (accessibilityNodeProviderImpl2 = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider()) != null) {
                if (this.mIsEditTextMode) {
                    this.mLastFocusedChildVirtualViewId = 2;
                }
                accessibilityNodeProviderImpl2.performAction(this.mLastFocusedChildVirtualViewId, 128, null);
            }
            this.mLastFocusedChildVirtualViewId = -1;
            this.mLastHoveredChildVirtualViewId = Integer.MIN_VALUE;
        }
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mDelegator.isEnabled() && !this.mIsEditTextMode && !this.mIsStartingAnimation && (motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
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

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.mMinValue + this.mValue) * this.mSelectorElementHeight);
        accessibilityEvent.setMaxScrollY((this.mMaxValue - this.mMinValue) * this.mSelectorElementHeight);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mDelegator.isEnabled() || this.mIsEditTextMode || this.mIsStartingAnimation || motionEvent.getActionMasked() != 0) {
            return false;
        }
        removeAllCallbacks();
        this.mInputText.setVisibility(4);
        float y2 = motionEvent.getY();
        this.mLastDownEventY = y2;
        this.mLastDownOrMoveEventY = y2;
        this.mLastDownEventTime = motionEvent.getEventTime();
        this.mIgnoreMoveEvents = false;
        this.mIgnoreUpEvent = false;
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
                if (this.mWheelInterval != 1) {
                    postSwitchIntervalOnLongPress();
                }
            } else if (f4 <= this.mBottomSelectionDividerBottom) {
                this.mPerformClickOnTap = true;
                if (this.mWheelInterval != 1) {
                    postSwitchIntervalOnLongPress();
                } else {
                    postBeginSoftInputOnLongPressCommand();
                }
            } else if (this.mWheelInterval != 1) {
                postSwitchIntervalOnLongPress();
            }
        } else {
            this.mFlingScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
        }
        return true;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
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

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onMeasure(int i, int i2) {
        this.mDelegator.superOnMeasure(makeMeasureSpec(i, this.mMaxWidth), makeMeasureSpec(i2, this.mMaxHeight));
        this.mDelegator.setMeasuredDimensionWrapper(resolveSizeAndStateRespectingMinSize(this.mMinWidth, this.mDelegator.getMeasuredWidth(), i), resolveSizeAndStateRespectingMinSize(this.mMinHeight, this.mDelegator.getMeasuredHeight(), i2));
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.getText().add(((AccessibilityNodeProviderImpl) getAccessibilityNodeProvider()).getVirtualCurrentButtonText(true));
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mDelegator.isEnabled() || this.mIsEditTextMode || this.mIsStartingAnimation) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            removeBeginSoftInputCommand();
            removeSwitchIntervalOnLongPress();
            if (!this.mIgnoreUpEvent) {
                this.mPressedStateHelper.cancel();
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity();
                int y2 = (int) motionEvent.getY();
                int iAbs = (int) Math.abs(y2 - this.mLastDownEventY);
                if (!this.mIsEditTextModeEnabled && this.mIgnoreMoveEvents) {
                    ensureScrollWheelAdjusted();
                    startFadeAnimation(true);
                    onScrollStateChange(0);
                } else if (Math.abs(yVelocity) <= this.mMinimumFlingVelocity || Math.abs(yVelocity) <= this.mShortFlickThreshold) {
                    if (iAbs > this.mTouchSlop) {
                        if (this.mIsLongClicked) {
                            showSoftInput();
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
            }
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

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onWindowFocusChanged(boolean z) {
        InputMethodManager inputMethodManager;
        if (z && this.mIsEditTextMode && this.mInputText.isFocused()) {
            showSoftInputForWindowFocused();
        } else if (z && this.mIsEditTextMode && !this.mInputText.isFocused() && (inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method")) != null && inputMethodManager.isActive(this.mInputText)) {
            inputMethodManager.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
        }
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

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void performClick() {
        if (this.mIsEditTextModeEnabled) {
            showSoftInput();
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void performLongClick() {
        this.mIgnoreMoveEvents = true;
        if (this.mIsEditTextModeEnabled) {
            this.mIsLongClicked = true;
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void scrollBy(int i, int i2) {
        int[] iArr = this.mSelectorIndices;
        if (i2 == 0 || this.mSelectorElementHeight <= 0) {
            return;
        }
        if (!this.mWrapSelectorWheel) {
            int i4 = this.mCurrentScrollOffset;
            int i5 = i4 + i2;
            int i6 = this.mInitialScrollOffset;
            if (i5 > i6 && iArr[2] <= this.mMinValue) {
                i2 = i6 - i4;
                stopFlingAnimation();
                if (this.mIsAmPm && this.mLastDownOrMoveEventY > this.mDelegator.getBottom()) {
                    this.mIgnoreMoveEvents = true;
                    return;
                }
            }
        }
        if (!this.mWrapSelectorWheel) {
            int i7 = this.mCurrentScrollOffset;
            int i8 = i7 + i2;
            int i9 = this.mInitialScrollOffset;
            if (i8 < i9 && iArr[2] >= this.mMaxValue) {
                i2 = i9 - i7;
                stopFlingAnimation();
                if (this.mIsAmPm && this.mLastDownOrMoveEventY < this.mDelegator.getTop()) {
                    this.mIgnoreMoveEvents = true;
                    return;
                }
            }
        }
        this.mCurrentScrollOffset += i2;
        while (true) {
            int i10 = this.mCurrentScrollOffset;
            if (i10 - this.mInitialScrollOffset < this.mValueChangeOffset) {
                break;
            }
            this.mCurrentScrollOffset = i10 - this.mSelectorElementHeight;
            decrementSelectorIndices(iArr);
            playSoundAndHapticFeedback();
            if (!this.mIsStartingAnimation) {
                setValueInternal(iArr[2], true);
                this.mIsValueChanged = true;
            } else if (this.mWheelInterval != 1 && this.mCustomWheelIntervalMode) {
                initializeSelectorWheelIndices();
            }
            if (!this.mWrapSelectorWheel && iArr[2] <= this.mMinValue) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
        while (true) {
            int i11 = this.mCurrentScrollOffset;
            if (i11 - this.mInitialScrollOffset > (-this.mValueChangeOffset)) {
                return;
            }
            this.mCurrentScrollOffset = i11 + this.mSelectorElementHeight;
            incrementSelectorIndices(iArr);
            playSoundAndHapticFeedback();
            if (!this.mIsStartingAnimation) {
                setValueInternal(iArr[2], true);
                this.mIsValueChanged = true;
            } else if (this.mWheelInterval != 1 && this.mCustomWheelIntervalMode) {
                initializeSelectorWheelIndices();
            }
            if (!this.mWrapSelectorWheel && iArr[2] >= this.mMaxValue) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setAmPm() {
        this.mIsAmPm = true;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C3623R.dimen.sesl_time_picker_spinner_am_pm_text_size);
        this.mTextSize = dimensionPixelSize;
        this.mSelectorWheelPaint.setTextSize(dimensionPixelSize);
        this.mInputText.setTextSize(0, this.mTextSize);
        setEditTextModeEnabled(false);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public boolean setCustomInterval(int i) {
        boolean z = this.mWrapSelectorWheel;
        if (this.mMinValue % i != 0 || (this.mMaxValue + (z ? 1 : 0)) % i != 0) {
            return false;
        }
        setCustomIntervalValue(i);
        applyWheelCustomInterval(true);
        return true;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setCustomIntervalValue(int i) {
        this.mWheelInterval = i;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setCustomNumberPickerIdleColor(int i) {
        this.mInputText.setTextColor(i);
        initPickerTextColor(this.mContext);
        this.mSelectorWheelPaint.setColor(this.mTextColor);
        this.mColorInAnimator.setIntValues(this.mTextColorIdle, this.mTextColorScrolling);
        this.mColorOutAnimator.setIntValues(this.mTextColorScrolling, this.mTextColorIdle);
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setCustomNumberPickerScrollColor(int i) {
        this.mIsCustomScrollColorForPicker = true;
        this.mCustomTextColorScrolling = i;
        initPickerTextColor(this.mContext);
        this.mColorInAnimator.setIntValues(this.mTextColorIdle, this.mTextColorScrolling);
        this.mColorOutAnimator.setIntValues(this.mTextColorScrolling, this.mTextColorIdle);
        this.mDelegator.invalidate();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setCustomTalkbackFormatter(SeslNumberPicker.CustomTalkbackFormatter customTalkbackFormatter) {
        this.mCustomTalkbackFormatter = customTalkbackFormatter;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setDateUnit(int i) {
        if (i == -1) {
            this.mUnitValue = "";
            return;
        }
        switch (i) {
            case 997:
                this.mUnitValue = this.mContext.getResources().getString(C3623R.string.sesl_date_picker_day);
                break;
            case 998:
                this.mUnitValue = this.mContext.getResources().getString(C3623R.string.sesl_date_picker_month);
                break;
            case 999:
                this.mUnitValue = this.mContext.getResources().getString(C3623R.string.sesl_date_picker_year);
                break;
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setDisplayedValues(String[] strArr) {
        if (this.mDisplayedValues == strArr) {
            return;
        }
        this.mDisplayedValues = strArr;
        if (strArr != null) {
            this.mInputText.setRawInputType(524289);
        } else {
            this.mInputText.setRawInputType(2);
        }
        updateInputTextView();
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setEditTextMode(boolean z) {
        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl;
        if (!this.mIsEditTextModeEnabled || this.mIsEditTextMode == z) {
            return;
        }
        this.mIsEditTextMode = z;
        if (z) {
            tryComputeMaxWidth();
            removeAllCallbacks();
            if (!this.mIsStartingAnimation) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
                this.mFlingScroller.abortAnimation();
                this.mGravityScroller.abortAnimation();
                this.mSpringFlingRunning = false;
                this.mSpringAnimation.cancel();
                onScrollStateChange(0);
            }
            this.mDelegator.setDescendantFocusability(262144);
            updateInputTextView();
            this.mInputText.setVisibility(0);
            if (this.mAccessibilityManager.isEnabled() && (accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider()) != null) {
                accessibilityNodeProviderImpl.performAction(2, 128, null);
            }
        } else {
            int i = this.mWheelInterval;
            if (i != 1 && this.mCustomWheelIntervalMode && this.mValue % i != 0) {
                applyWheelCustomInterval(false);
            }
            if (this.mFadeOutAnimator.isRunning()) {
                this.mFadeOutAnimator.cancel();
            }
            if (this.mFadeInAnimator.isRunning()) {
                this.mFadeInAnimator.cancel();
            }
            if (this.mColorInAnimator.isRunning()) {
                this.mColorInAnimator.cancel();
            }
            if (this.mColorOutAnimator.isRunning()) {
                this.mColorOutAnimator.cancel();
            }
            this.mTextColor = this.mTextColorIdle;
            this.mAlpha = this.mIdleAlpha;
            this.mInputText.setVisibility(4);
            this.mDelegator.setDescendantFocusability(131072);
        }
        this.mDelegator.invalidate();
        SeslNumberPicker.OnEditTextModeChangedListener onEditTextModeChangedListener = this.mOnEditTextModeChangedListener;
        if (onEditTextModeChangedListener != null) {
            onEditTextModeChangedListener.onEditTextModeChanged(this.mDelegator, this.mIsEditTextMode);
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setEditTextModeEnabled(boolean z) {
        if (this.mIsEditTextModeEnabled == z || z) {
            return;
        }
        if (this.mIsEditTextMode) {
            setEditTextMode(false);
        }
        this.mInputText.setAccessibilityDelegate(null);
        this.mIsEditTextModeEnabled = z;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setEnabled(boolean z) {
        this.mInputText.setEnabled(z);
        if (z || this.mScrollState == 0) {
            return;
        }
        stopScrollAnimation();
        onScrollStateChange(0);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setErrorToastMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mToastText = str;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setFormatter(SeslNumberPicker.Formatter formatter) {
        if (formatter == this.mFormatter) {
            return;
        }
        this.mFormatter = formatter;
        initializeSelectorWheelIndices();
        updateInputTextView();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setImeOptions(int i) {
        this.mInputText.setImeOptions(i);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setMaxInputLength(int i) {
        this.mInputText.setFilters(new InputFilter[]{this.mInputText.getFilters()[0], new InputFilter.LengthFilter(i)});
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setMaxValue(int i) {
        if (this.mMaxValue == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        boolean z = this.mWrapSelectorWheel;
        int i2 = this.mWheelInterval;
        if (i2 == 1 || ((z ? 1 : 0) + i) % i2 == 0) {
            this.mMaxValue = i;
            if (i < this.mValue) {
                this.mValue = i;
            }
            updateWrapSelectorWheel();
            initializeSelectorWheelIndices();
            updateInputTextView();
            tryComputeMaxWidth();
            this.mDelegator.invalidate();
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setMinValue(int i) {
        if (this.mMinValue == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        int i2 = this.mWheelInterval;
        if (i2 == 1 || i % i2 == 0) {
            this.mMinValue = i;
            if (i > this.mValue) {
                this.mValue = i;
            }
            updateWrapSelectorWheel();
            initializeSelectorWheelIndices();
            updateInputTextView();
            tryComputeMaxWidth();
            this.mDelegator.invalidate();
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setMonthInputMode() {
        this.mInputText.setImeOptions(33554432);
        this.mInputText.setPrivateImeOptions(INPUT_TYPE_MONTH);
        this.mInputText.setText("");
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setOnEditTextModeChangedListener(SeslNumberPicker.OnEditTextModeChangedListener onEditTextModeChangedListener) {
        this.mOnEditTextModeChangedListener = onEditTextModeChangedListener;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setOnScrollListener(SeslNumberPicker.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setOnValueChangedListener(SeslNumberPicker.OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setPaintFlags(int i) {
        if (this.mSelectorWheelPaint.getFlags() != i) {
            this.mSelectorWheelPaint.setFlags(i);
            this.mInputText.setPaintFlags(i);
            tryComputeMaxWidth();
        }
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setPickerContentDescription(String str) {
        this.mPickerContentDescription = str;
        ((SeslNumberPicker.CustomEditText) this.mInputText).setPickerContentDescription(str);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setSubTextTypeface(Typeface typeface) {
        this.mCustomTypefaceSet = true;
        this.mPickerSubTypeface = typeface;
        this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
        this.mHcfFocusedTypefaceBold = Typeface.create(this.mPickerTypeface, 1);
        setInputTextTypeface();
        tryComputeMaxWidth();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setTextSize(float f) {
        int iApplyDimension = (int) TypedValue.applyDimension(1, f, this.mContext.getResources().getDisplayMetrics());
        this.mTextSize = iApplyDimension;
        this.mSelectorWheelPaint.setTextSize(iApplyDimension);
        this.mInputText.setTextSize(0, this.mTextSize);
        tryComputeMaxWidth();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setTextTypeface(Typeface typeface) {
        this.mCustomTypefaceSet = true;
        this.mPickerTypeface = typeface;
        this.mPickerSubTypeface = Typeface.create(typeface, 0);
        this.mSelectorWheelPaint.setTypeface(this.mPickerTypeface);
        this.mHcfFocusedTypefaceBold = Typeface.create(this.mPickerTypeface, 1);
        setInputTextTypeface();
        tryComputeMaxWidth();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setValue(int i) {
        if (!this.mFlingScroller.isFinished() || this.mSpringAnimation.isRunning()) {
            stopScrollAnimation();
        }
        setValueInternal(i, false);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setWrapSelectorWheel(boolean z) {
        this.mWrapSelectorWheelPreferred = z;
        updateWrapSelectorWheel();
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setYearDateTimeInputMode() {
        this.mInputText.setImeOptions(33554432);
        this.mInputText.setPrivateImeOptions(INPUT_TYPE_YEAR_DATE_TIME);
        this.mInputText.setText("");
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void startAnimation(int i, SeslAnimationListener seslAnimationListener) {
        this.mAnimationListener = seslAnimationListener;
        if (this.mIsEditTextMode) {
            return;
        }
        if (!this.mIsAmPm && !this.mWrapSelectorWheel && getValue() - getMinValue() == 0) {
            SeslAnimationListener seslAnimationListener2 = this.mAnimationListener;
            if (seslAnimationListener2 != null) {
                seslAnimationListener2.onAnimationEnd();
                return;
            }
            return;
        }
        if (this.mFadeOutAnimator.isStarted()) {
            this.mFadeOutAnimator.cancel();
        }
        if (this.mFadeInAnimator.isStarted()) {
            this.mFadeInAnimator.cancel();
        }
        if (this.mColorInAnimator.isStarted()) {
            this.mColorInAnimator.cancel();
        }
        if (this.mColorOutAnimator.isStarted()) {
            this.mColorOutAnimator.cancel();
        }
        this.mDelegator.post(new RunnableC36485(i));
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

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void performClick(boolean z) {
        if (this.mIsAmPm) {
            z = this.mValue != this.mMaxValue;
        }
        changeValueByOne(z);
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // androidx.picker.widget.SeslNumberPicker.NumberPickerDelegate
    public void setSubTextSize(float f) {
    }
}
