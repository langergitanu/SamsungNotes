package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IDock;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.IntroGuideTip;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.IntroVI;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ToolbarContainerLayout extends AbsToolbarContainerLayout {
    private static final String PREF_KEY_TOOLBAR_DOCK_SIDE = "toolbar_dock_type";
    protected static final String PREF_KEY_TOOLBAR_X = "toolbar_pos_x";
    protected static final String PREF_KEY_TOOLBAR_Y = "toolbar_pos_y";
    protected static String TAG = Logger.createTag("ToolbarContainerLayout");
    private boolean mBottomDockDisabled;
    private float mBottomDockDisabledPosX;
    private float mBottomDockDisabledPosY;
    private IntroVI mIntroVI;
    private int mOrientation;
    private int mSavedDockSide;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.ToolbarContainerLayout$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C105321 implements IntroVI.Contract {
        public C105321() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.IntroVI.Contract
        public void cancel() {
            Logger.m11003i(ToolbarContainerLayout.TAG, "IntroVI, cancel animation");
            ToolbarContainerLayout.this.cancelTranslationAnimation();
            ToolbarContainerLayout.super.restorePosition();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.IntroVI.Contract
        public void doDockingByDirection(int i) {
            ToolbarContainerLayout.this.runTranslationAnimation(new Point((int) ToolbarContainerLayout.this.getTranslationX(), (int) (i == 0 ? ToolbarContainerLayout.this.getTopDockingPosition() : ToolbarContainerLayout.this.getBottomDockingPosition())), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.ToolbarContainerLayout.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ToolbarContainerLayout.this.actionFly(0.0f, 0.0f, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.ToolbarContainerLayout.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.m11003i(ToolbarContainerLayout.TAG, "IntroVI, end animation");
                            ToolbarContainerLayout.this.updateState();
                            ToolbarContainerLayout.this.savePosition(-100.0f, -100.0f);
                        }
                    });
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.IntroVI.Contract
        public boolean isReleased() {
            Logger.m10999d(ToolbarContainerLayout.TAG, "IntroVI.IContract : isReleased - " + ((FloatLayout) ToolbarContainerLayout.this).mIsReleased);
            return ((FloatLayout) ToolbarContainerLayout.this).mIsReleased;
        }
    }

    public ToolbarContainerLayout(Context context) {
        super(context);
        this.mBottomDockDisabled = false;
        this.mBottomDockDisabledPosX = -1.0f;
        this.mBottomDockDisabledPosY = -1.0f;
        init(context);
    }

    private int getDefaultDockType() {
        return 0;
    }

    private int getDockingByPosition(float f) {
        float topDockingArea = getTopDockingArea();
        float bottomDockingArea = getBottomDockingArea();
        if (f < topDockingArea) {
            return 0;
        }
        return f > bottomDockingArea ? 1 : -1;
    }

    private IntroVI getIntroVI() {
        if (this.mIntroVI == null) {
            this.mIntroVI = new IntroVI(this, getDefaultDockType(), new C105321());
        }
        return this.mIntroVI;
    }

    private boolean introVI() {
        if (!IntroVI.isSupport()) {
            Logger.m11003i(TAG, "introVI# is not supported");
            return false;
        }
        if (getIntroVI().isRunning()) {
            Logger.m11003i(TAG, "introVI# is running");
            return true;
        }
        Pair<Float, Float> storedRatio = getStoredRatio();
        if (IntroVI.isInitialPosition(((Float) storedRatio.first).floatValue(), ((Float) storedRatio.second).floatValue()).booleanValue() && getVisibility() == 0 && !getIntroVI().hasStarted()) {
            return getIntroVI().start();
        }
        return false;
    }

    private void updateRatio(float f, float f4) {
        float translationX = getTranslationX();
        if (translationX != 0.0f) {
            setTranslationX((f / this.mParentWidth) * translationX);
        }
        float translationY = getTranslationY();
        float height = getHeight() + translationY;
        int i = this.mParentHeight;
        setTranslationY(height >= ((float) i) ? f4 - getHeight() : (f4 / i) * translationY);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void blockadeDock(int i, boolean z) {
        super.blockadeDock(i, z);
        if (z == this.mBottomDockDisabled || i != 1) {
            return;
        }
        this.mBottomDockDisabled = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void clearSavePosition() {
        Logger.m11003i(TAG, "clearSavePosition");
        super.clearSavePosition();
        SharedPreferencesCompat.getInstance("Composer").remove(PREF_KEY_TOOLBAR_DOCK_SIDE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public String getChildName() {
        return getClass().getSimpleName();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public int getDockingBoundary() {
        return getDockingByPosition(getTranslationY());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public Pair<Float, Float> getStoredRatio() {
        this.mSavedDockSide = SharedPreferencesCompat.getInstance("Composer").getInt(PREF_KEY_TOOLBAR_DOCK_SIDE, -1);
        AbstractC8014b.m7195A(new StringBuilder("getStoredRatio# savedDockSide "), TAG, this.mSavedDockSide);
        return super.getStoredRatio();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void init(Context context) {
        super.init(context);
        this.mSavedDockSide = -1;
        this.mOrientation = getResources().getConfiguration().orientation;
        setEndEdgeSize((int) getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_container_end_margin));
        setStartMargin(getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_margin));
        setDefaultCornerRadius(getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_container_corner_radius));
        this.pref_key_toolbar_x = PREF_KEY_TOOLBAR_X;
        this.pref_key_toolbar_y = PREF_KEY_TOOLBAR_Y;
        this.mInitialPositionX = -100.0f;
        this.mInitialPositionY = -100.0f;
        getStoredRatio();
        enableDocking(this.mSavedDockSide);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = this.mOrientation;
        int i2 = configuration.orientation;
        if (i != i2) {
            this.mOrientation = i2;
            if (ResourceUtils.isTabletLayout(getContext()) || this.mOrientation == 1) {
                IntroGuideTip.update();
            } else {
                IntroGuideTip.showAfterDismiss();
            }
            if (getIntroVI().isRunning()) {
                Logger.m11003i(TAG, "onConfigurationChanged# IntroVI is running.");
                getIntroVI().cancel();
                getIntroVI().start();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (z) {
            IntroGuideTip.update();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onShow() {
        super.onShow();
        if (IntroVI.isSupport()) {
            getIntroVI().setKeyboardShown();
            if (getIntroVI().isRunning() && getVisibility() == 0) {
                getIntroVI().cancel();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void relayoutPosition() {
        Logger.m11003i(TAG, "relayoutPosition");
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return;
        }
        if (this.mParentWidth == 0 && this.mParentHeight == 0) {
            Logger.m11003i(TAG, "first relayout");
            this.mParentWidth = viewGroup.getWidth();
            this.mParentHeight = viewGroup.getHeight();
            updateDockingAlignment();
            restorePosition();
            return;
        }
        float width = viewGroup.getWidth();
        float height = viewGroup.getHeight();
        Logger.m11003i(TAG, "relayoutPosition# " + this.mParentWidth + " - " + this.mParentHeight + "    " + width + " - " + height);
        int i = this.mParentWidth;
        if (i == width && this.mParentHeight == height) {
            return;
        }
        int i2 = this.mParentHeight;
        if (i2 == height || i != width) {
            updateRatio(width, height);
        } else {
            boolean z = this.mBottomDockDisabled;
            if (!z || i2 >= height) {
                if (z) {
                    blockadeDock(1, false);
                    this.mBottomDockDisabled = true;
                    if (getTranslationY() + getHeight() > height) {
                        this.mBottomDockDisabledPosX = getTranslationX();
                        this.mBottomDockDisabledPosY = getTranslationY();
                    }
                }
                updatePositionByParentHeight(getTranslationY(), this.mParentHeight, (int) height);
            } else {
                blockadeDock(1, true);
                onUndocking(width);
                if (this.mBottomDockDisabledPosX != -1.0f) {
                    float height2 = height - getHeight();
                    float f = this.mBottomDockDisabledPosY;
                    if (f <= height2) {
                        height2 = f;
                    }
                    this.mBottomDockDisabledPosY = height2;
                    setTranslationX(this.mBottomDockDisabledPosX);
                    setTranslationY(this.mBottomDockDisabledPosY);
                    this.mBottomDockDisabledPosX = -1.0f;
                    this.mBottomDockDisabledPosY = -1.0f;
                }
            }
        }
        this.mParentWidth = (int) width;
        this.mParentHeight = (int) height;
        updateDockingAlignment();
        updateState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void restorePosition() {
        Logger.m11003i(TAG, "restorePosition");
        if (introVI()) {
            return;
        }
        super.restorePosition();
        IntroGuideTip.show(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void savePosition(float f, float f4) {
        super.savePosition(f, f4);
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        int dockingType = getDockingType();
        sharedPreferencesCompat.putInt(PREF_KEY_TOOLBAR_DOCK_SIDE, dockingType);
        AbstractC8014b.m7217s(dockingType, "savePosition# currentDockingType ", TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void setMoving(boolean z) {
        super.setMoving(z);
        if (z) {
            this.mBottomDockDisabledPosX = -1.0f;
            this.mBottomDockDisabledPosY = -1.0f;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        AbstractC8014b.m7217s(i, "setVisibility ", TAG);
        if (i != 0) {
            IntroGuideTip.dismiss();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public boolean updateDockState(float f, float f4) {
        int dockingByPosition;
        Logger.m11003i(TAG, "updateDockState# xRatio : " + f + "  yRatio : " + f4);
        if (isInitialPosition(f, f4)) {
            dockingByPosition = getDefaultDockType();
            AbstractC8014b.m7217s(dockingByPosition, "updateDockState# defaultDockType : ", TAG);
        } else if (this.mSavedDockSide != -1) {
            AbstractC8014b.m7195A(new StringBuilder("updateDockState# savedDockSide : "), TAG, this.mSavedDockSide);
            dockingByPosition = this.mSavedDockSide;
            this.mSavedDockSide = -1;
        } else {
            PointF pointF = new PointF();
            getDefaultPosition(f, f4, pointF);
            dockingByPosition = getDockingByPosition(pointF.y);
            Logger.m11003i(TAG, "updateDockState# getDockingByPosition : y : " + pointF.y + " dockType " + dockingByPosition);
        }
        if (dockingByPosition == -1) {
            return false;
        }
        dropHorizontalDocking(false, dockingByPosition);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void updateDockingAlignment() {
        super.updateDockingAlignment();
        Resources resources = getContext().getResources();
        IDock.AlignmentParam alignmentParam = new IDock.AlignmentParam();
        alignmentParam.dockingSize = resources.getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_container_height);
        setDockParams(alignmentParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void updatePosition(float f, float f4) {
        PointF pointF = new PointF();
        getDefaultPosition(f, f4, pointF);
        float mEndEdgeSize = this.mStartMargin;
        float mEndEdgeSize2 = this.mParentWidth - getMEndEdgeSize();
        if (LocaleUtils.isRTLMode()) {
            mEndEdgeSize = getMEndEdgeSize() - getWidth();
            mEndEdgeSize2 = (this.mParentWidth - getWidth()) - this.mStartMargin;
        }
        float f5 = pointF.x;
        if (f5 < mEndEdgeSize) {
            setTranslationX(mEndEdgeSize);
        } else if (f5 > mEndEdgeSize2) {
            setTranslationX(mEndEdgeSize2);
        } else {
            setTranslationX(f5);
        }
        int height = getHeight();
        if (height == 0) {
            measure(0, 0);
            height = getMeasuredHeight();
        }
        int height2 = ((View) getParent()).getHeight() - height;
        float f6 = pointF.y;
        float f7 = height2;
        if (f6 > f7) {
            pointF.y = f7;
        } else if (f6 < 0.0f) {
            pointF.y = 0.0f;
        }
        setTranslationY(pointF.y);
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("restorePosition: ", f, " ", f4, SQLKeyword.COMMA);
        sbM1176v.append(pointF.x);
        sbM1176v.append(" ");
        sbM1176v.append(pointF.y);
        sbM1176v.append(SQLKeyword.COMMA);
        sbM1176v.append(height2);
        Logger.m10999d(str, sbM1176v.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void updateXY(float f, float f4) {
        float bottomMargin = getBottomMargin() + getHeight() + f4;
        int i = this.mParentHeight;
        if (bottomMargin > i) {
            f4 -= bottomMargin - i;
        }
        float fMax = Math.max(0.0f, f4);
        float topDockingArea = getTopDockingArea();
        float bottomDockingArea = getBottomDockingArea();
        if (fMax <= topDockingArea) {
            openDocker(0);
        } else if (fMax >= bottomDockingArea) {
            openDocker(1);
        } else {
            this.mDelegate.closeAllDocker();
        }
        setTranslationY(fMax);
        setTranslationX(f);
    }

    public ToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, C9086R.attr.floatingToolbarTheme);
        this.mBottomDockDisabled = false;
        this.mBottomDockDisabledPosX = -1.0f;
        this.mBottomDockDisabledPosY = -1.0f;
        init(context);
    }

    public ToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBottomDockDisabled = false;
        this.mBottomDockDisabledPosX = -1.0f;
        this.mBottomDockDisabledPosY = -1.0f;
        init(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void savePosition() {
        Pair<Float, Float> storedRatio = getStoredRatio();
        if (isInitialPosition(((Float) storedRatio.first).floatValue(), ((Float) storedRatio.second).floatValue())) {
            return;
        }
        saveCurrentPosition();
        if (IntroVI.isInitialPosition(((Float) storedRatio.first).floatValue(), ((Float) storedRatio.second).floatValue()).booleanValue()) {
            return;
        }
        Logger.m11003i(TAG, "disable IntroVI cause toolbar has been moved");
    }

    public ToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mBottomDockDisabled = false;
        this.mBottomDockDisabledPosX = -1.0f;
        this.mBottomDockDisabledPosY = -1.0f;
        init(context);
    }
}
