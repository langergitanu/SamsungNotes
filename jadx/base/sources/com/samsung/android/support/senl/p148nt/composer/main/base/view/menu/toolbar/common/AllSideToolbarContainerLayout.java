package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IDock;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.layout.HorizontalDockingLTR;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.layout.HorizontalDockingRTL;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.layout.IHorizontalDocking;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.CustomizeGuideTip;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.IntroGuideTip;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AllSideToolbarContainerLayout extends AbsToolbarContainerLayout {
    private static final float ALL_SIDE_POSITION_NONE = -1.0f;
    private static final String PREF_KEY_TOOLBAR_DOCK_SIDE = "all_side_toolbar_dock_type";
    private static final String PREF_KEY_TOOLBAR_ROTATE = "toolbar_rotate";
    private static final String PREF_KEY_TOOLBAR_SAVE_X = "all_side_toolbar_save_x";
    private static final String PREF_KEY_TOOLBAR_SAVE_Y = "all_side_toolbar_save_y";
    private static final float SAFE_CONTAIN_THRESHOLD_RATIO = 0.07f;
    private static final String TAG = Logger.createTag("AllSideToolbarContainerLayout");
    private CheckAnimation isRunningAnimationTypeNone;
    private Contract mContract;
    protected int mDockSide;
    private IHorizontalDocking mHorizontalDocking;
    private final int[] mLocation;
    private int mOrientation;
    protected boolean mRotate;
    private final PointF mTouch;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CheckAnimation {
        boolean onUpdateAnimationState();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void updateToolbarItemList();
    }

    public AllSideToolbarContainerLayout(Context context) {
        super(context);
        this.mTouch = new PointF(-1.0f, -1.0f);
        this.mLocation = new int[2];
        this.mRotate = false;
        this.mDockSide = -1;
        initialize();
    }

    private void checkBottomBoundaryInFloating(PointF pointF) {
        if (this.mRotate || getDockingType() != -1) {
            return;
        }
        float height = ((View) getParent()).getHeight() - getHeight();
        if (pointF.y > height) {
            pointF.y = height;
        }
    }

    private void checkExactPosition() {
        if (isSafeFromOutBorder()) {
            return;
        }
        Logger.m11003i(TAG, "Floater is located almost outside of border, clear save position to avoid edge case");
        clearSavePosition();
        if (getMEnableDocking()) {
            updateDockState(this.mInitialPositionX, this.mInitialPositionY);
        } else {
            updatePosition(0.0f, 0.0f);
        }
    }

    private void dismissGuideTip() {
        CustomizeGuideTip.dismiss();
        IntroGuideTip.dismiss();
    }

    private Rect getDisplayCutoutInset() {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        Rect rect = new Rect(0, 0, 0, 0);
        if (!this.mIsMultiWindowMode && Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getRootWindowInsets()) != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
            for (Rect rect2 : displayCutout.getBoundingRects()) {
                if (this.mDelegate.getGlobalVisibleRect(0).intersect(rect2)) {
                    rect.top = Math.max(rect.top, rect2.bottom - rect2.top);
                }
                if (this.mDelegate.getGlobalVisibleRect(1).intersect(rect2)) {
                    rect.bottom = Math.max(rect.bottom, rect2.bottom - rect2.top);
                }
                if (this.mDelegate.getGlobalVisibleRect(2).intersect(rect2)) {
                    rect.left = Math.max(rect.left, rect2.right - rect2.left);
                }
                if (this.mDelegate.getGlobalVisibleRect(3).intersect(rect2)) {
                    rect.right = Math.max(rect.right, rect2.right - rect2.left);
                }
            }
        }
        return rect;
    }

    private int getDockerInset() {
        Rect displayCutoutInset = getDisplayCutoutInset();
        Logger.m10999d(TAG, "updateDockerInset# inset: " + displayCutoutInset.toShortString());
        this.mDelegate.setDockerInsetSize(0, displayCutoutInset.top);
        this.mDelegate.setDockerInsetSize(1, displayCutoutInset.bottom);
        this.mDelegate.setDockerInsetSize(2, displayCutoutInset.left);
        this.mDelegate.setDockerInsetSize(3, displayCutoutInset.right);
        return this.mDelegate.getDockerInsetSize();
    }

    private float getEndDockingArea() {
        return this.mHorizontalDocking.getEndDockingArea(this.mParentWidth);
    }

    private float getStartDockingArea() {
        return this.mHorizontalDocking.getStartDockingArea(this.mParentWidth);
    }

    private void initialize() {
        setEndEdgeSize((int) getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_container_end_margin));
        setStartMargin(getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_margin));
        setDefaultCornerRadius(getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_container_corner_radius));
        this.pref_key_toolbar_x = PREF_KEY_TOOLBAR_SAVE_X;
        this.pref_key_toolbar_y = PREF_KEY_TOOLBAR_SAVE_Y;
        this.mInitialPositionX = -1.0f;
        this.mInitialPositionY = -1.0f;
        float horizontalDockingArea = getHorizontalDockingArea();
        float horizontalMenuWidth = getHorizontalMenuWidth();
        if (LocaleUtils.isRTLMode()) {
            this.mHorizontalDocking = new HorizontalDockingRTL(horizontalDockingArea, horizontalMenuWidth);
        } else {
            this.mHorizontalDocking = new HorizontalDockingLTR(horizontalDockingArea, horizontalMenuWidth);
        }
        getStoredRatio();
        enableDocking(this.mDockSide);
        Logger.m10999d(TAG, "initialize");
    }

    private boolean isHorizontalDock(int i) {
        return i == 0 || i == 1;
    }

    private boolean isSafeFromOutBorder() {
        Rect rect = new Rect();
        getHitRect(rect);
        float fHeight = rect.height() * rect.width();
        if (fHeight <= 0.0f) {
            return true;
        }
        Rect rect2 = new Rect();
        ((ViewGroup) getParent()).getLocalVisibleRect(rect2);
        Rect intersect = ToolbarUtil.getIntersect(rect2, rect);
        return ((float) (intersect.height() * intersect.width())) / fHeight > 0.07f;
    }

    private boolean isVerticalDock(int i) {
        return i == 2 || i == 3;
    }

    private void runRotateVI(final int i, final float f, final float f4) {
        animate().scaleX(0.9f).scaleY(0.9f).setDuration(100L).setInterpolator(new LinearInterpolator()).withStartAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout.2
            @Override // java.lang.Runnable
            public void run() {
                AllSideToolbarContainerLayout.this.animate().alpha(0.0f).setDuration(100L).setInterpolator(new LinearInterpolator()).start();
            }
        }).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AllSideToolbarContainerLayout.this.setScaleX(1.0f);
                AllSideToolbarContainerLayout.this.setScaleY(1.0f);
                AllSideToolbarContainerLayout.this.setX(f);
                AllSideToolbarContainerLayout.this.setY(f4);
                AllSideToolbarContainerLayout.this.onDocking(i, false);
                AllSideToolbarContainerLayout.this.animate().alpha(1.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).start();
            }
        }).start();
    }

    private void updateContainerContentsGravity(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            float f = 1.0f;
            float f4 = 0.5f;
            if (i == 0) {
                f4 = 1.0f;
                f = 0.5f;
            } else if (i == 1) {
                f = 0.5f;
                f4 = 0.0f;
            } else if (i != 2) {
                f = i != 3 ? 0.5f : 0.0f;
            }
            View childAt = getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.horizontalBias = f;
            layoutParams.verticalBias = f4;
            childAt.setLayoutParams(layoutParams);
        }
    }

    private void updateContainerLayout() {
        int dockingType = getDockingType();
        int dockerInset = getDockerInset();
        AbstractC14516b.m15114b(dockingType, dockerInset, "updateContainerLayout# dockingType: ", " insetSize: ", TAG);
        updateContainerSize(dockingType, dockerInset);
        updateContainerContentsGravity(dockingType);
    }

    private void updateContainerSize(int i, int i2) {
        int dockingSize;
        int dockingSize2 = -1;
        if (i == 0 || i == 1) {
            dockingSize = this.mDelegate.getDockingSize() + i2;
        } else if (i == 2 || i == 3) {
            dockingSize2 = this.mDelegate.getDockingSize() + i2;
            dockingSize = -1;
        } else {
            dockingSize2 = -2;
            dockingSize = -2;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = dockingSize2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = dockingSize;
        setLayoutParams(layoutParams);
    }

    private void updateCurrentTouch(PointF pointF) {
        this.mTouch.set(pointF);
        PointF pointF2 = this.mTouch;
        float f = pointF2.x;
        int[] iArr = this.mLocation;
        pointF2.x = f - iArr[0];
        pointF2.y -= iArr[1];
    }

    private void updateGuideTip() {
        CustomizeGuideTip.update();
        IntroGuideTip.update();
    }

    private void updateOpenDocker() {
        if (this.mHorizontalDocking.isInStartDockingArea(this.mTouch.x, this.mParentWidth)) {
            openDocker(2);
            return;
        }
        if (this.mHorizontalDocking.isInEndDockingArea(this.mTouch.x, this.mParentWidth)) {
            openDocker(3);
            return;
        }
        if (this.mTouch.y <= getTopDockingArea()) {
            openDocker(0);
        } else if (this.mTouch.y >= getBottomDockingArea()) {
            openDocker(1);
        } else {
            this.mDelegate.closeAllDocker();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void actionFly(float f, float f4, Runnable runnable) {
        boolean z;
        float f5;
        float f6;
        PointF pointF = this.mTouch;
        float f7 = f * 0.05f;
        float f8 = pointF.x + f7;
        float f9 = 0.05f * f4;
        float f10 = pointF.y + f9;
        float centerHorizontal = getCenterHorizontal();
        float centerVertical = getCenterVertical();
        if (this.mHorizontalDocking.isStartDockingArea(f8, this.mParentWidth)) {
            centerHorizontal = getStartDockingPosition();
            if (!this.mRotate) {
                runRotateVI(2, centerHorizontal, 0.0f);
                return;
            }
        } else if (this.mHorizontalDocking.isEndDockingArea(f8, this.mParentWidth)) {
            centerHorizontal = getEndDockingPosition();
            if (!this.mRotate) {
                runRotateVI(3, centerHorizontal, 0.0f);
                return;
            }
        } else {
            z = false;
            if (f10 < getTopDockingArea()) {
                float topDockingPosition = getTopDockingPosition();
                if (this.mRotate) {
                    runRotateVI(0, 0.0f, topDockingPosition);
                    return;
                }
                f5 = topDockingPosition;
                f6 = centerHorizontal;
                z = true;
                this.mDelegate.fly(this, f6, f5, f, f4, z, runnable);
            }
            if (f10 <= getBottomDockingPosition()) {
                float x = getX() + f7;
                float y2 = getY() + f9;
                String str = TAG;
                StringBuilder sbM1176v = AbstractC0622a.m1176v("fly to drop zone : ", x, SQLKeyword.COMMA, y2, " : ");
                sbM1176v.append(this.mTouch.x);
                sbM1176v.append(SQLKeyword.COMMA);
                sbM1176v.append(this.mTouch.y);
                Logger.m10999d(str, sbM1176v.toString());
                f5 = y2;
                f6 = x;
                this.mDelegate.fly(this, f6, f5, f, f4, z, runnable);
            }
            centerVertical = getBottomDockingPosition();
            if (this.mRotate) {
                runRotateVI(1, 0.0f, centerVertical);
                return;
            }
        }
        f6 = centerHorizontal;
        f5 = centerVertical;
        z = true;
        this.mDelegate.fly(this, f6, f5, f, f4, z, runnable);
    }

    public void adjustPositionToInside() {
        if (this.mEnableDocking) {
            PointF pointF = this.mInit;
            PointF pointF2 = new PointF(pointF.x, pointF.y);
            measure(0, 0);
            float f = this.mTouch.x;
            float f4 = this.mInit.x;
            if (f < f4) {
                pointF2.x = (f - f4) + pointF2.x;
            } else if (f > f4 + getMeasuredWidth()) {
                pointF2.x = (this.mTouch.x - (this.mInit.x + getMeasuredWidth())) + pointF2.x;
            }
            float f5 = this.mTouch.y;
            float f6 = this.mInit.y;
            if (f5 < f6) {
                pointF2.y = (f5 - f6) + pointF2.y;
            } else if (f5 > f6 + getMeasuredHeight()) {
                pointF2.y = (this.mTouch.y - (this.mInit.y + getMeasuredHeight())) + pointF2.y;
            }
            this.mInit.set(pointF2.x, pointF2.y);
        }
    }

    public void changeDockTypeParam() {
        if (isStateDocking()) {
            int dockingType = getDockingType();
            if (isVerticalDock(dockingType)) {
                getLayoutParams().width = -2;
                getLayoutParams().height = -1;
                this.mRotate = true;
            } else if (isHorizontalDock(dockingType)) {
                getLayoutParams().width = -1;
                getLayoutParams().height = -2;
                this.mRotate = false;
            }
        } else {
            getLayoutParams().width = -2;
            getLayoutParams().height = -2;
        }
        requestLayout();
        savePosition(getX(), getY());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void clearSavePosition() {
        super.clearSavePosition();
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        sharedPreferencesCompat.remove(PREF_KEY_TOOLBAR_DOCK_SIDE);
        sharedPreferencesCompat.remove(PREF_KEY_TOOLBAR_ROTATE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void dispatchLongPress(MotionEvent motionEvent) {
        super.dispatchLongPress(motionEvent);
        adjustPositionToInside();
    }

    public void dropVerticalDocking(boolean z, int i) {
        float startDockingPosition = i == 2 ? getStartDockingPosition() : getEndDockingPosition();
        Logger.m10999d(TAG, "dropVerticalDocking# " + startDockingPosition + SQLKeyword.COMMA + i);
        if (!this.mEnableDocking) {
            startDockingPosition = 0.0f;
        }
        reboundOnDropZone(startDockingPosition, 0.0f, z, 1);
        onDocking(i, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public boolean dropX(boolean z) {
        int dockingSide = getDockingSide();
        if (this.mDelegate.getMState() != 2) {
            this.mDelegate.closeAllDocker();
        } else {
            this.mDelegate.hideDockOthers(dockingSide);
        }
        if (!isVerticalDock(dockingSide)) {
            return false;
        }
        dropVerticalDocking(z, dockingSide);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public boolean dropY(boolean z) {
        int dockingSide = getDockingSide();
        if (this.mDelegate.isBlockaded(dockingSide) || !isHorizontalDock(dockingSide)) {
            return false;
        }
        dropHorizontalDocking(z, dockingSide);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public float getBottomDockingArea() {
        return (this.mParentHeight - (getDockingSize() * 1.2f)) - getBottomMargin();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public String getChildName() {
        return getClass().getSimpleName();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public int getDockingBoundary() {
        if (this.mHorizontalDocking.isStartDockingArea(this.mTouch.x, this.mParentWidth)) {
            return 2;
        }
        if (this.mHorizontalDocking.isEndDockingArea(this.mTouch.x, this.mParentWidth)) {
            return 3;
        }
        if (this.mTouch.y < getTopDockingArea()) {
            return 0;
        }
        return this.mTouch.y > getBottomDockingArea() ? 1 : -1;
    }

    public int getDockingSizePixel() {
        return getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_container_height);
    }

    public float getEndDockingPosition() {
        return this.mHorizontalDocking.getEndDockingPosition(this.mParentWidth);
    }

    public float getHorizontalDockingArea() {
        return getResources().getDimensionPixelSize(C9086R.dimen.float_layout_horizontal_docking_area);
    }

    public float getHorizontalMenuWidth() {
        return getResources().getDimensionPixelSize(C9086R.dimen.float_layout_horizontal_menu_width);
    }

    public float getStartDockingPosition() {
        return this.mHorizontalDocking.getStartDockingPosition(this.mParentWidth);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public Pair<Float, Float> getStoredRatio() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        this.mRotate = sharedPreferencesCompat.getBoolean(PREF_KEY_TOOLBAR_ROTATE, false);
        this.mDockSide = sharedPreferencesCompat.getInt(PREF_KEY_TOOLBAR_DOCK_SIDE, -1);
        return super.getStoredRatio();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public float getTopDockingArea() {
        return super.getTopDockingArea() * 1.2f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void getUndockDestination(@NonNull float[] fArr, @NonNull MotionEvent motionEvent) {
        getChildAt(0).getLocationOnScreen(new int[2]);
        this.mInit.x = r0[0] - this.mLocation[0];
        this.mStart.x = motionEvent.getRawX();
        this.mInit.y = r0[1] - this.mLocation[1];
        this.mStart.y = motionEvent.getRawY();
        PointF pointF = this.mInit;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public boolean hasStoredRotate() {
        return this.mRotate;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = this.mOrientation;
        int i2 = configuration.orientation;
        if (i != i2) {
            this.mOrientation = i2;
            updateGuideTip();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissGuideTip();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onDocking(int i, boolean z) {
        super.onDocking(i, z);
        Logger.m10999d(TAG, "onDocking# ");
        updateContainerLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onFieldSizeChanged() {
        if (this.mParentWidth == 0 && this.mParentHeight == 0) {
            CustomizeGuideTip.showOnValidCount(this);
            IntroGuideTip.showOnValidCount(this);
        }
        updateContainerLayout();
        super.onFieldSizeChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        ((View) getParent()).getLocationOnScreen(this.mLocation);
        if (z) {
            updateGuideTip();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onTouchDown(PointF pointF) {
        updateCurrentTouch(pointF);
        super.onTouchDown(pointF);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public boolean onTouchMove(PointF pointF) {
        updateCurrentTouch(pointF);
        return super.onTouchMove(pointF);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void relayoutPosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return;
        }
        if (this.mParentWidth == 0 && this.mParentHeight == 0) {
            this.mParentWidth = viewGroup.getWidth();
            this.mParentHeight = viewGroup.getHeight();
            updateDockingAlignment();
            restorePosition();
            checkExactPosition();
            return;
        }
        float width = viewGroup.getWidth();
        float height = viewGroup.getHeight();
        Logger.m10999d(TAG, "relayoutPosition# " + this.mParentWidth + " - " + this.mParentHeight + "    " + width + " - " + height);
        if (!isStateDocking()) {
            float translationX = getTranslationX() / this.mParentWidth;
            float translationY = getTranslationY() / this.mParentHeight;
            CheckAnimation checkAnimation = this.isRunningAnimationTypeNone;
            if (checkAnimation == null || !checkAnimation.onUpdateAnimationState()) {
                updatePosition(translationX, translationY);
            }
        } else if (!this.mRotate && getDockingType() == 1) {
            setTranslationY((height - getHeight()) - getBottomMargin());
        } else if (this.mRotate && getDockingType() == 3) {
            if (LocaleUtils.isRTLMode()) {
                setTranslationX(0.0f);
            } else {
                setTranslationX(width - getWidth());
            }
        }
        this.mParentWidth = (int) width;
        this.mParentHeight = (int) height;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void savePosition(float f, float f4) {
        super.savePosition(f, f4);
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        sharedPreferencesCompat.putBoolean(PREF_KEY_TOOLBAR_ROTATE, this.mRotate);
        sharedPreferencesCompat.putInt(PREF_KEY_TOOLBAR_DOCK_SIDE, getDockingType());
    }

    public void setAnimationStateTypeNone(CheckAnimation checkAnimation) {
        this.isRunningAnimationTypeNone = checkAnimation;
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            CustomizeGuideTip.dismiss();
            IntroGuideTip.dismiss();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public boolean updateDockState(float f, float f4) {
        if (isInitialPosition(f, f4)) {
            this.mDockSide = 0;
        }
        int i = this.mDockSide;
        if (i == -1) {
            return false;
        }
        if (isVerticalDock(i)) {
            dropVerticalDocking(false, this.mDockSide);
        } else {
            dropHorizontalDocking(false, this.mDockSide);
        }
        this.mDockSide = -1;
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void updateDockingAlignment() {
        super.updateDockingAlignment();
        IDock.AlignmentParam alignmentParam = new IDock.AlignmentParam();
        alignmentParam.dockingSize = getDockingSizePixel();
        setDockParams(alignmentParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void updatePosition(float f, float f4) {
        PointF pointF = new PointF();
        getDefaultPosition(f, f4, pointF);
        checkBottomBoundaryInFloating(pointF);
        setTranslationX(pointF.x);
        setTranslationY(pointF.y);
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("updatePosition: ", f, " ", f4, SQLKeyword.COMMA);
        sbM1176v.append(pointF.x);
        sbM1176v.append(" ");
        sbM1176v.append(pointF.y);
        Logger.m10999d(str, sbM1176v.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void updatePositionByParentHeight(float f, int i, int i2) {
        Logger.m11003i(TAG, "updatePositionByParentHeight - nothing to do in AllSideToolbarContainer");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void updateState() {
        relayoutPosition();
    }

    public void updateToolbarItemList() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.updateToolbarItemList();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void updateXY(float f, float f4) {
        updateOpenDocker();
        setTranslationX(f);
        setTranslationY(f4);
    }

    public AllSideToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouch = new PointF(-1.0f, -1.0f);
        this.mLocation = new int[2];
        this.mRotate = false;
        this.mDockSide = -1;
        initialize();
    }

    public AllSideToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouch = new PointF(-1.0f, -1.0f);
        this.mLocation = new int[2];
        this.mRotate = false;
        this.mDockSide = -1;
        initialize();
    }

    public AllSideToolbarContainerLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTouch = new PointF(-1.0f, -1.0f);
        this.mLocation = new int[2];
        this.mRotate = false;
        this.mDockSide = -1;
        initialize();
    }
}
