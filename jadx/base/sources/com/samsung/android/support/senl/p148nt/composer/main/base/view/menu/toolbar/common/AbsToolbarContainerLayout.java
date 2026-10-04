package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p145cm.base.common.util.DetourUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.FlexVI;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsToolbarContainerLayout extends FloatLayout implements SoftInputManager.OnSipListener {
    protected static String TAG = Logger.createTag("AbsToolbarContainerLayout");
    private FlexVI mFlexVI;
    private AudioManagerCompat.SoundManager mHapticDetachSound;
    private final Rect mHitOutRect;
    protected float mInitialPositionX;
    protected float mInitialPositionY;
    protected boolean mIsMultiWindowMode;
    private boolean mIsPreTouchHiding;
    private boolean mIsSupportVerticalFold;
    protected boolean mIsTabletLayout;
    private OnAnimationListener mOnAnimationListener;
    private OnToolbarPositionListener mOnToolbarPositionListener;
    private int mOrientation;
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    protected String pref_key_toolbar_x;
    protected String pref_key_toolbar_y;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnAnimationListener {
        void onEnd();

        void onStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnToolbarPositionListener {
        boolean onSetToolbarPosition(Rect rect, boolean z);
    }

    public AbsToolbarContainerLayout(Context context) {
        super(context);
        this.mHitOutRect = new Rect();
        this.mInitialPositionX = -1.0f;
        this.mInitialPositionY = -1.0f;
        this.mIsPreTouchHiding = false;
        this.mIsSupportVerticalFold = false;
        init(context);
    }

    private void getAttrs(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C9086R.styleable.FloaterLayout, i, 0);
        setTypedArray(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasTouchPosition(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Rect rect = new Rect(0, 0, getWidth(), getHeight());
        rect.offset(iArr[0], iArr[1]);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    private void initFlexVI() {
        boolean zBooleanValue = FlexVI.isSupport().booleanValue();
        this.mIsSupportVerticalFold = zBooleanValue;
        if (zBooleanValue) {
            try {
                this.mFlexVI = new FlexVI(this, new FlexVI.IContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.FlexVI.IContract
                    public boolean isDockedAtBottom() {
                        return AbsToolbarContainerLayout.this.getDockingType() == 1;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.FlexVI.IContract
                    public boolean isLandscape() {
                        return AbsToolbarContainerLayout.this.mOrientation == 2;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.FlexVI.IContract
                    public boolean isMultiWindow() {
                        return AbsToolbarContainerLayout.this.mIsMultiWindowMode;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.FlexVI.IContract
                    public void updateDockerSize() {
                        AbsToolbarContainerLayout.this.updateDockerSizeWithMargin();
                    }
                });
            } catch (IllegalArgumentException e) {
                loggingWithChildName("initFlexVI Failed " + e.getMessage());
            }
        }
    }

    private boolean isOutOfBorder() {
        getHitRect(new Rect());
        ((ViewGroup) getParent()).getLocalVisibleRect(new Rect());
        return !r1.intersect(r0);
    }

    private void loggingWithChildName(String str) {
        Logger.m11003i(TAG + "$" + getChildName(), str);
    }

    private void makePreTouchListener() {
        this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2 || actionMasked == 213) {
                    if (!AbsToolbarContainerLayout.this.isStateDocking() && AbsToolbarContainerLayout.this.getVisibility() == 0 && AbsToolbarContainerLayout.this.hasTouchPosition(motionEvent) && !AbsToolbarContainerLayout.this.mIsPreTouchHiding) {
                        AbsToolbarContainerLayout.this.startHideAnimation();
                        AbsToolbarContainerLayout.this.mIsPreTouchHiding = true;
                    }
                } else if ((actionMasked == 1 || actionMasked == 212 || actionMasked == 3 || actionMasked == 214) && AbsToolbarContainerLayout.this.mIsPreTouchHiding) {
                    AbsToolbarContainerLayout.this.mIsPreTouchHiding = false;
                    AbsToolbarContainerLayout.this.startShowAnimation();
                    return false;
                }
                return false;
            }
        };
    }

    private boolean needFlexVI() {
        return this.mIsSupportVerticalFold && this.mFlexVI != null;
    }

    private void setLayOutRect(boolean z) {
        if (isStateDocking()) {
            this.mHitOutRect.set(0, 0, 0, 0);
        } else {
            getHitRect(this.mHitOutRect);
        }
        OnToolbarPositionListener onToolbarPositionListener = this.mOnToolbarPositionListener;
        if (onToolbarPositionListener != null) {
            onToolbarPositionListener.onSetToolbarPosition(this.mHitOutRect, z);
        }
    }

    private void setTypedArray(TypedArray typedArray) {
        this.mHasScrollable = typedArray.getBoolean(C9086R.styleable.FloaterLayout_hasScrollable, false);
        this.mHasViewFlipper = typedArray.getBoolean(C9086R.styleable.FloaterLayout_hasViewFlipper, false);
        this.mHasSeekBar = typedArray.getBoolean(C9086R.styleable.FloaterLayout_hasSeekBar, false);
        Drawable drawable = typedArray.getDrawable(C9086R.styleable.FloaterLayout_floatingToolbarBackground);
        if (drawable != null) {
            setBackground(drawable);
        }
    }

    public void clearSavePosition() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        sharedPreferencesCompat.remove(this.pref_key_toolbar_x);
        sharedPreferencesCompat.remove(this.pref_key_toolbar_y);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void dispatchLongPress(MotionEvent motionEvent) {
        super.dispatchLongPress(motionEvent);
        if (getMEnableDocking()) {
            AudioManagerCompat.SoundManager soundManager = this.mHapticDetachSound;
            if (soundManager != null) {
                soundManager.play();
            }
            ViewCompat.getInstance().performHapticFeedback(this, 108);
        }
    }

    public void enableDocking(int i) {
        enableDocking(true);
        setDockSide(i);
        initFlexVI();
    }

    public int getCenterHorizontal() {
        return (getMParentWidth() / 2) - (getMeasuredWidth() / 2);
    }

    public PointF getCenterPointF() {
        return new PointF((getWidth() / 2.0f) + getX(), (getHeight() / 2.0f) + getY());
    }

    public int getCenterVertical() {
        return (getMParentHeight() / 2) - (getMeasuredHeight() / 2);
    }

    public abstract String getChildName();

    public void getDefaultPosition(float f, float f4, PointF pointF) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        pointF.x = f * viewGroup.getWidth();
        pointF.y = f4 * viewGroup.getHeight();
    }

    public PointF getEndBottomPointF() {
        return new PointF(getX() + getWidth(), getY() + getHeight());
    }

    public SpenPreTouchListenerImpl.PreTouchListener getPreTouchListener() {
        return this.mPreTouchListener;
    }

    public Pair<Float, Float> getStoredRatio() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        float f = sharedPreferencesCompat.getFloat(this.pref_key_toolbar_x, this.mInitialPositionX);
        float f4 = sharedPreferencesCompat.getFloat(this.pref_key_toolbar_y, this.mInitialPositionY);
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        if (Float.isNaN(f4)) {
            f4 = 0.0f;
        }
        StringBuilder sbM1176v = AbstractC0622a.m1176v("storedPosition: ", f, " ", f4, " , ");
        sbM1176v.append(this.mParentHeight);
        loggingWithChildName(sbM1176v.toString());
        return new Pair<>(Float.valueOf(f), Float.valueOf(f4));
    }

    public boolean hasStoredRotate() {
        return false;
    }

    public void hideWithDocker() {
        setVisibility(8);
        setDocker(false);
    }

    public void init(Context context) {
        this.mIsTabletLayout = ResourceUtils.isTabletLayout(context);
        this.mOrientation = context.getResources().getConfiguration().orientation;
        makePreTouchListener();
        this.mHapticDetachSound = AudioManagerCompat.getInstance().createHapticDetachSound(context);
    }

    public boolean isInitialPosition(float f, float f4) {
        float f5 = this.mInitialPositionX;
        return f == f5 && f4 == f5;
    }

    public boolean isShowing() {
        return getVisibility() == 0 && !isHideRunning();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onActionEnd() {
        saveCurrentPosition();
        setLayOutRect(false);
        OnAnimationListener onAnimationListener = this.mOnAnimationListener;
        if (onAnimationListener != null) {
            onAnimationListener.onEnd();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onActionStart() {
        OnAnimationListener onAnimationListener = this.mOnAnimationListener;
        if (onAnimationListener != null) {
            onAnimationListener.onStart();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (this.mOrientation != i) {
            this.mOrientation = i;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onFieldSizeChanged() {
        loggingWithChildName("onFieldSizeChanged# :" + getTranslationX() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + getTranslationY());
        relayoutPosition();
        setLayOutRect(true);
        if (needFlexVI()) {
            this.mFlexVI.update();
        }
        updateDockerSizeWithMargin();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onHide() {
        if (needFlexVI()) {
            this.mFlexVI.setSipShown(false);
            this.mFlexVI.update();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (z) {
            onFieldSizeChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onLongPress() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onShow() {
        if (needFlexVI()) {
            this.mFlexVI.setSipShown(true);
            this.mFlexVI.update();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            return;
        }
        savePosition();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public boolean openDocker(int i) {
        boolean zOpenDocker = super.openDocker(i);
        if (zOpenDocker && getMEnableDocking()) {
            ViewCompat.getInstance().performHapticFeedback(this, 41);
        }
        return zOpenDocker;
    }

    public void relayoutPosition() {
        loggingWithChildName("relayoutPosition");
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return;
        }
        if (this.mParentWidth == 0 && this.mParentHeight == 0) {
            loggingWithChildName("first relayout");
            this.mParentWidth = viewGroup.getWidth();
            this.mParentHeight = viewGroup.getHeight();
            updateDockingAlignment();
            restorePosition();
            return;
        }
        float width = viewGroup.getWidth();
        float height = viewGroup.getHeight();
        loggingWithChildName("relayoutPosition# " + this.mParentWidth + " - " + this.mParentHeight + "    " + width + " - " + height);
        updatePosition(getTranslationX() / ((float) this.mParentWidth), getTranslationY() / ((float) this.mParentHeight));
        this.mParentWidth = (int) width;
        this.mParentHeight = (int) height;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void release() {
        super.release();
        AudioManagerCompat.SoundManager soundManager = this.mHapticDetachSound;
        if (soundManager != null) {
            soundManager.release();
            this.mHapticDetachSound = null;
        }
    }

    public void restorePosition() {
        loggingWithChildName("restorePosition");
        Pair<Float, Float> storedRatio = getStoredRatio();
        float fFloatValue = ((Float) storedRatio.first).floatValue();
        float fFloatValue2 = ((Float) storedRatio.second).floatValue();
        if (updateDockState(fFloatValue, fFloatValue2)) {
            return;
        }
        updatePosition(fFloatValue, fFloatValue2);
    }

    public void saveCurrentPosition() {
        if (this.mParentWidth == 0 || this.mParentHeight == 0) {
            return;
        }
        if (isOutOfBorder()) {
            loggingWithChildName("Floater is located outside of border, clear save position for escape from disappear case");
            clearSavePosition();
            updateState();
        } else {
            savePosition(getTranslationX() / this.mParentWidth, getTranslationY() / this.mParentHeight);
        }
    }

    public void savePosition() {
        if (isShowing()) {
            saveCurrentPosition();
        }
    }

    public void setMultiWindowMode(boolean z) {
        if (this.mIsMultiWindowMode != z) {
            this.mIsMultiWindowMode = z;
            updateDockingAlignment();
        }
    }

    public void setOnAnimationListener(OnAnimationListener onAnimationListener) {
        this.mOnAnimationListener = onAnimationListener;
    }

    public void setOnToolbarPositionListener(OnToolbarPositionListener onToolbarPositionListener) {
        this.mOnToolbarPositionListener = onToolbarPositionListener;
    }

    public void setToolbar(View view) {
    }

    public void setVerticalHalfOpened(boolean z) {
        if (needFlexVI()) {
            this.mFlexVI.setVerticalHalfOpened(z);
            this.mFlexVI.update();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setVisibility : ", ", current alpha : ");
        sbM778t.append(getAlpha());
        loggingWithChildName(sbM778t.toString());
    }

    public void showWithDocker() {
        setVisibility(0);
        setDocker(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void startHideAnimation() {
        super.startHideAnimation();
        if (getDockingType() != -1) {
            setDocker(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void startShowAnimation() {
        super.startShowAnimation();
        if (getDockingType() != -1) {
            setDocker(true);
        }
    }

    public boolean updateDockState(float f, float f4) {
        return false;
    }

    public void updateDockingAlignment() {
    }

    public void updatePosition(float f, float f4) {
        PointF pointF = new PointF();
        getDefaultPosition(f, f4, pointF);
        int width = getWidth();
        int height = getHeight();
        if (width == 0 && height == 0) {
            measure(0, 0);
            width = getMeasuredWidth();
            height = getMeasuredHeight();
        }
        int width2 = ((View) getParent()).getWidth() - width;
        float f5 = pointF.x;
        float f6 = width2;
        if (f5 > f6) {
            pointF.x = f6;
        } else if (f5 < 0.0f) {
            pointF.x = 0.0f;
        }
        setTranslationX(pointF.x);
        int height2 = ((View) getParent()).getHeight() - height;
        float f7 = pointF.y;
        float f8 = height2;
        if (f7 > f8) {
            pointF.y = f8;
        } else if (f7 < 0.0f) {
            pointF.y = 0.0f;
        }
        setTranslationY(pointF.y);
        loggingWithChildName("restorePosition: " + f + " " + f4 + SQLKeyword.COMMA + pointF.x + " " + pointF.y + SQLKeyword.COMMA + height2);
    }

    public void updatePositionByParentHeight(float f, int i, int i2) {
        if (getBottomMargin() + getHeight() + f > i2) {
            f = (i2 - getHeight()) - getBottomMargin();
            setTranslationY(f);
        } else if (getTop() + f < 0.0f) {
            f -= getTop() + f;
            setTranslationY(f);
        }
        if (getMEnableDocking()) {
            if (DetourUtils.equalFloatValues(getBottomMargin() + getHeight() + f, i)) {
                setTranslationY((i2 - getHeight()) - getBottomMargin());
            }
        }
    }

    public void updateRelayoutPosition() {
        float translationY = getTranslationY();
        int i = this.mParentHeight;
        updatePositionByParentHeight(translationY, i, i);
        setLayOutRect(true);
    }

    public void savePosition(float f, float f4) {
        if (Float.isNaN(f) || Float.isNaN(f4)) {
            return;
        }
        StringBuilder sbM1176v = AbstractC0622a.m1176v("savePosition: ", f, " ", f4, SQLKeyword.COMMA);
        AbstractC11014a.m12337v(sbM1176v, f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA);
        sbM1176v.append(this.mParentHeight);
        loggingWithChildName(sbM1176v.toString());
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        sharedPreferencesCompat.putFloat(this.pref_key_toolbar_x, f);
        sharedPreferencesCompat.putFloat(this.pref_key_toolbar_y, f4);
    }

    private void getAttrs(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C9086R.styleable.FloaterLayout, i, i2);
        setTypedArray(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public AbsToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, C9086R.attr.floatingToolbarTheme);
        this.mHitOutRect = new Rect();
        this.mInitialPositionX = -1.0f;
        this.mInitialPositionY = -1.0f;
        this.mIsPreTouchHiding = false;
        this.mIsSupportVerticalFold = false;
        init(context);
        getAttrs(attributeSet, C9086R.attr.floatingToolbarTheme);
    }

    public AbsToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHitOutRect = new Rect();
        this.mInitialPositionX = -1.0f;
        this.mInitialPositionY = -1.0f;
        this.mIsPreTouchHiding = false;
        this.mIsSupportVerticalFold = false;
        init(context);
        getAttrs(attributeSet, i, 0);
    }

    public AbsToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mHitOutRect = new Rect();
        this.mInitialPositionX = -1.0f;
        this.mInitialPositionY = -1.0f;
        this.mIsPreTouchHiding = false;
        this.mIsSupportVerticalFold = false;
        init(context);
        getAttrs(attributeSet, i, i2);
    }
}
