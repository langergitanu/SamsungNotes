package com.samsung.android.support.senl.p148nt.base.extension.stickymemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.document.SmDocumentManager;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u0001:\u0002QRB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\u0006\u0010)\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u000fJ\u0016\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bJ(\u0010.\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fH\u0002J \u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020&H\u0002J \u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0018H\u0002J\u0010\u0010:\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000bH\u0002J\u0006\u0010;\u001a\u00020&J*\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\u0018H\u0002J\u0006\u0010@\u001a\u00020&J\b\u0010A\u001a\u00020&H\u0016J\b\u0010B\u001a\u00020\u0018H\u0002J\b\u0010C\u001a\u00020&H\u0016J\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0018H\u0016J\u0006\u0010F\u001a\u00020&J\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020&H\u0002J\u000e\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020MJ\b\u0010N\u001a\u00020\u0018H\u0002J\u0010\u0010O\u001a\u00020&2\u0006\u0010H\u001a\u00020IH\u0002J\f\u0010P\u001a\u00020\u000f*\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/FloatingControl;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController$OnSipStateListener;", "target", "Landroid/view/View;", "floatingContainer", "spenView", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/FloatingControl$ISpenView;", "<init>", "(Landroid/view/View;Landroid/view/View;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/FloatingControl$ISpenView;)V", "movingHandleView", "minHeight", "", "maxHeight", "outHorizontal", "minTranslationX", "", "minHeightWithSip", "inboundMinX", "inboundMinY", "onLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "lastRectF", "Landroid/graphics/RectF;", "isSipShowing", "", "()Z", "setSipShowing", "(Z)V", "isMovedBySip", "isUpdatingSip", "isCalledLayoutChangedBySip", "isPendingMoveIntoBounds", "isOrientationChanged", "orientation", "screenWidthDp", "screenHeightDp", "isBlockingRestore", "init", "", "initResizeHandle", "initMovingControl", "getMaxTranslationX", "getMaxTranslationY", SecureFolderConstants.TEMP_FOLDER_NAME, "x", "y", "moveTarget", "maxTx", "maxTy", "checkMoveBoundary", "value", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "initLayoutChangeListener", "moveIntoOutbound", "containerWidth", "containerHeight", "isChangedWidth", "getLeftAtCenter", "moveIntoBounds", "targetTX", "targetTY", "targetHeight", NotesSyncRpcProvider.FORCE_SYNC, "release", "onSipShow", "hasFocus", "onSipHide", "onSipVisibilityChanged", "isVisible", "saveLastRect", "clearLastRect", "msg", "", "restoreLastRect", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "closeInLandscape", "setBlockRestore", "dpToPx", "ISpenView", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FloatingControl implements SipController.OnSipStateListener {

    @NotNull
    private static final String TAG = SmLogger.createTag("FloatingControl");

    @NotNull
    private static final String TAG_LAYOUT = SmLogger.createTag("FloatingControl#LAYOUT");

    @NotNull
    private final View floatingContainer;
    private final float inboundMinX;
    private final float inboundMinY;
    private boolean isBlockingRestore;
    private boolean isCalledLayoutChangedBySip;
    private boolean isMovedBySip;
    private boolean isOrientationChanged;
    private boolean isPendingMoveIntoBounds;
    private boolean isSipShowing;
    private boolean isUpdatingSip;

    @Nullable
    private RectF lastRectF;
    private final int maxHeight;
    private final int minHeight;
    private final int minHeightWithSip;
    private final float minTranslationX;
    private View movingHandleView;
    private View.OnLayoutChangeListener onLayoutChangeListener;
    private int orientation;
    private final int outHorizontal;
    private int screenHeightDp;
    private int screenWidthDp;

    @Nullable
    private ISpenView spenView;

    @NotNull
    private final View target;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/FloatingControl$ISpenView;", "", "readyResize", "", "endResize", "hasFocus", "", "close", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISpenView {
        void close();

        void endResize();

        boolean hasFocus();

        void readyResize();
    }

    public FloatingControl(@NotNull View target, @NotNull View floatingContainer, @Nullable ISpenView iSpenView) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(floatingContainer, "floatingContainer");
        this.target = target;
        this.floatingContainer = floatingContainer;
        this.spenView = iSpenView;
        this.isCalledLayoutChangedBySip = true;
        Resources resources = target.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C8875R.dimen.sticky_memo_decor_view_width);
        SmDocumentManager.Companion companion = SmDocumentManager.INSTANCE;
        Context context = target.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int defWidth = companion.getDefWidth(context);
        Context context2 = target.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.maxHeight = companion.getDefHeight(context2) + defWidth;
        Context context3 = target.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        this.minHeight = companion.getMinHeight(context3);
        this.outHorizontal = (defWidth + dimensionPixelSize) / 2;
        this.minTranslationX = (-(defWidth - dimensionPixelSize)) / 2;
        this.minHeightWithSip = resources.getDimensionPixelSize(C8875R.dimen.sticky_memo_top_btn_touch_height) + resources.getDimensionPixelSize(C8875R.dimen.top_menu_top_margin) + 100;
        this.inboundMinX = resources.getDimensionPixelSize(C8875R.dimen.sticky_memo_outside_horizontal_margin);
        this.inboundMinY = resources.getDimensionPixelSize(C8875R.dimen.sticky_memo_outside_top_margin);
        this.orientation = target.getResources().getConfiguration().orientation;
        this.screenWidthDp = target.getResources().getConfiguration().screenWidthDp;
        this.screenHeightDp = target.getResources().getConfiguration().screenHeightDp;
    }

    private final float checkMoveBoundary(float value, float min, float max) {
        return value < min ? min : value > max ? max : value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearLastRect(String msg) {
        SmLogger.m8661d(TAG, "clearLastRect# " + msg);
        this.lastRectF = null;
    }

    private final boolean closeInLandscape() {
        if (!this.isSipShowing || this.orientation != 2 || ResourceUtils.isTabletLayout(this.target.getContext())) {
            return false;
        }
        SmLogger.m8661d(TAG, "onConfigurationChanged# close in landscape");
        ISpenView iSpenView = this.spenView;
        if (iSpenView == null) {
            return true;
        }
        iSpenView.close();
        return true;
    }

    private final float dpToPx(int i) {
        return TypedValue.applyDimension(1, i, this.target.getContext().getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getLeftAtCenter(int containerWidth) {
        return (containerWidth / 2.0f) - (this.target.getWidth() / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasFocus() {
        ISpenView iSpenView = this.spenView;
        return iSpenView != null && iSpenView.hasFocus();
    }

    private final void initLayoutChangeListener() {
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.FloatingControl.initLayoutChangeListener.1
            private final boolean moveInSipCase(int newWidth, boolean isChangedWidth) {
                if (!FloatingControl.this.isMovedBySip || FloatingControl.this.lastRectF == null) {
                    return false;
                }
                float leftAtCenter = isChangedWidth ? FloatingControl.this.getLeftAtCenter(newWidth) : FloatingControl.this.target.getTranslationX();
                FloatingControl floatingControl = FloatingControl.this;
                float translationY = floatingControl.target.getTranslationY();
                RectF rectF = FloatingControl.this.lastRectF;
                Intrinsics.checkNotNull(rectF);
                FloatingControl.moveIntoBounds$default(floatingControl, leftAtCenter, translationY, (int) rectF.height(), false, 8, null);
                printTargetRect();
                return true;
            }

            private final void printTargetRect() {
                Rect rect = new Rect();
                FloatingControl.this.target.getGlobalVisibleRect(rect);
                SmLogger.m8661d(FloatingControl.TAG_LAYOUT, "onLayoutChange# " + rect);
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Intrinsics.checkNotNullParameter(v, "v");
                int i = right - left;
                int i2 = bottom - top;
                int i4 = oldBottom - oldTop;
                boolean z = i != oldRight - oldLeft;
                if (z || i2 != i4) {
                    onLayoutChange(i, i2, z);
                }
            }

            private final void onLayoutChange(int newWidth, int newHeight, boolean isChangedWidth) {
                String str = FloatingControl.TAG_LAYOUT;
                StringBuilder sbM2230u = AbstractC2821a.m2230u("onLayoutChange ", " ", " ", FloatingControl.this.isUpdatingSip, FloatingControl.this.hasFocus());
                sbM2230u.append(newHeight);
                SmLogger.m8661d(str, sbM2230u.toString());
                if (FloatingControl.this.isUpdatingSip) {
                    FloatingControl.this.isCalledLayoutChangedBySip = true;
                }
                if (moveInSipCase(newWidth, isChangedWidth)) {
                    return;
                }
                if (FloatingControl.this.isPendingMoveIntoBounds || (FloatingControl.this.isUpdatingSip && FloatingControl.this.hasFocus())) {
                    FloatingControl floatingControl = FloatingControl.this;
                    FloatingControl.moveIntoBounds$default(floatingControl, floatingControl.target.getTranslationX(), FloatingControl.this.target.getTranslationY(), FloatingControl.this.target.getLayoutParams().height, false, 8, null);
                } else if (FloatingControl.this.isOrientationChanged) {
                    FloatingControl.this.isOrientationChanged = false;
                    FloatingControl floatingControl2 = FloatingControl.this;
                    floatingControl2.moveIntoBounds(floatingControl2.target.getTranslationX(), FloatingControl.this.target.getTranslationY(), FloatingControl.this.target.getLayoutParams().height, true);
                } else {
                    FloatingControl.this.moveIntoOutbound(newWidth, newHeight, isChangedWidth);
                }
                printTargetRect();
            }
        };
        this.onLayoutChangeListener = onLayoutChangeListener;
        this.floatingContainer.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    private final void initMovingControl() {
        this.movingHandleView = this.target.findViewById(C8875R.id.top_decoration_view);
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.FloatingControl$initMovingControl$onTouchListener$1
            private Float maxTx;
            private Float maxTy;
            private final PathInterpolator oneEasing = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
            private final float scale = 1.02f;
            private Float startTx;
            private Float startTy;
            private Float startX;
            private Float startY;

            private final void move(float x, float y2) {
                FloatingControl floatingControl = this.this$0;
                Float f = this.startTx;
                Intrinsics.checkNotNull(f);
                float fFloatValue = f.floatValue();
                Float f4 = this.startX;
                Intrinsics.checkNotNull(f4);
                float fFloatValue2 = (x - f4.floatValue()) + fFloatValue;
                Float f5 = this.startTy;
                Intrinsics.checkNotNull(f5);
                float fFloatValue3 = f5.floatValue();
                Float f6 = this.startY;
                Intrinsics.checkNotNull(f6);
                float fFloatValue4 = (y2 - f6.floatValue()) + fFloatValue3;
                Float f7 = this.maxTx;
                Intrinsics.checkNotNull(f7);
                float fFloatValue5 = f7.floatValue();
                Float f8 = this.maxTy;
                Intrinsics.checkNotNull(f8);
                floatingControl.moveTarget(fFloatValue2, fFloatValue4, fFloatValue5, f8.floatValue());
            }

            private final void updateLastRect() {
                if (this.this$0.getIsSipShowing()) {
                    this.this$0.clearLastRect("moved with sip");
                } else {
                    this.this$0.saveLastRect();
                }
            }

            public final Float getMaxTx() {
                return this.maxTx;
            }

            public final Float getMaxTy() {
                return this.maxTy;
            }

            public final PathInterpolator getOneEasing() {
                return this.oneEasing;
            }

            public final float getScale() {
                return this.scale;
            }

            public final Float getStartTx() {
                return this.startTx;
            }

            public final Float getStartTy() {
                return this.startTy;
            }

            public final Float getStartX() {
                return this.startX;
            }

            public final Float getStartY() {
                return this.startY;
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View v, MotionEvent event) {
                if (event == null) {
                    return false;
                }
                int action = event.getAction();
                if (action == 0) {
                    NotesSamsungAnalytics.INSTANCE.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, StickyMemoSAConstants.EVENT_MOVE_STICKY_NOTE, "0");
                    this.startTx = Float.valueOf(this.this$0.target.getTranslationX());
                    this.startTy = Float.valueOf(this.this$0.target.getTranslationY());
                    this.maxTx = Float.valueOf(this.this$0.getMaxTranslationX());
                    this.maxTy = Float.valueOf(this.this$0.getMaxTranslationY());
                    this.startX = Float.valueOf(event.getRawX());
                    this.startY = Float.valueOf(event.getRawY());
                    this.this$0.target.animate().scaleX(this.scale).scaleY(this.scale).setDuration(450L).setInterpolator(this.oneEasing).start();
                    return true;
                }
                if (action != 1) {
                    if (action == 2) {
                        move(event.getRawX(), event.getRawY());
                        return true;
                    }
                    if (action != 3) {
                        return false;
                    }
                }
                move(event.getRawX(), event.getRawY());
                updateLastRect();
                this.this$0.target.animate().cancel();
                this.this$0.target.animate().scaleX(1.0f).scaleY(1.0f).setDuration(450L).setInterpolator(this.oneEasing).start();
                return true;
            }

            public final void setMaxTx(Float f) {
                this.maxTx = f;
            }

            public final void setMaxTy(Float f) {
                this.maxTy = f;
            }

            public final void setStartTx(Float f) {
                this.startTx = f;
            }

            public final void setStartTy(Float f) {
                this.startTy = f;
            }

            public final void setStartX(Float f) {
                this.startX = f;
            }

            public final void setStartY(Float f) {
                this.startY = f;
            }
        };
        View view = this.movingHandleView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("movingHandleView");
            view = null;
        }
        view.setOnTouchListener(onTouchListener);
    }

    private final void initResizeHandle() {
        View viewFindViewById = this.target.findViewById(C8875R.id.sticky_memo_resize_handle);
        if (viewFindViewById == null) {
            SmLogger.m8662e(TAG, "initResizeHandle# resizeHandleView is null");
        } else {
            final View viewFindViewById2 = viewFindViewById.findViewById(C8875R.id.sticky_memo_resize_handle_img_view);
            viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.FloatingControl.initResizeHandle.1
                private int startH;
                private float startY;
                private int viewMaxHeight;

                private final void resizeView(float y2) {
                    FloatingControl.this.target.getLayoutParams().height = Math.min(FloatingControl.this.maxHeight, Math.min(this.viewMaxHeight, Math.max(FloatingControl.this.minHeight, this.startH + ((int) (y2 - this.startY)))));
                    FloatingControl.this.target.requestLayout();
                }

                private final void updateLastRect() {
                    if (FloatingControl.this.getIsSipShowing()) {
                        FloatingControl.this.clearLastRect("resize with sip");
                    } else {
                        FloatingControl.this.saveLastRect();
                    }
                }

                public final int getStartH() {
                    return this.startH;
                }

                public final float getStartY() {
                    return this.startY;
                }

                public final int getViewMaxHeight() {
                    return this.viewMaxHeight;
                }

                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View v, MotionEvent event) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    Intrinsics.checkNotNullParameter(event, "event");
                    int action = event.getAction();
                    if (action == 0) {
                        NotesSamsungAnalytics.INSTANCE.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, "404");
                        this.startH = FloatingControl.this.target.getLayoutParams().height;
                        this.startY = event.getRawY();
                        this.viewMaxHeight = FloatingControl.this.floatingContainer.getHeight() - ((int) FloatingControl.this.target.getTranslationY());
                        ISpenView iSpenView = FloatingControl.this.spenView;
                        if (iSpenView != null) {
                            iSpenView.readyResize();
                        }
                        viewFindViewById2.setPressed(true);
                        return true;
                    }
                    if (action != 1) {
                        if (action == 2) {
                            resizeView(event.getRawY());
                            return true;
                        }
                        if (action != 3) {
                            return false;
                        }
                    }
                    resizeView(event.getRawY());
                    ISpenView iSpenView2 = FloatingControl.this.spenView;
                    if (iSpenView2 != null) {
                        iSpenView2.endResize();
                    }
                    updateLastRect();
                    viewFindViewById2.setPressed(false);
                    return true;
                }

                public final void setStartH(int i) {
                    this.startH = i;
                }

                public final void setStartY(float f) {
                    this.startY = f;
                }

                public final void setViewMaxHeight(int i) {
                    this.viewMaxHeight = i;
                }
            });
        }
    }

    public static /* synthetic */ void moveIntoBounds$default(FloatingControl floatingControl, float f, float f4, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        floatingControl.moveIntoBounds(f, f4, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveIntoOutbound(int containerWidth, int containerHeight, boolean isChangedWidth) {
        SmLogger.m8661d(TAG_LAYOUT, "moveIntoOutbound");
        int i = containerWidth - this.outHorizontal;
        int iMax = Math.max(0, containerHeight - this.minHeight);
        float leftAtCenter = getLeftAtCenter(containerWidth);
        if (isChangedWidth) {
            this.target.setTranslationX(checkMoveBoundary(leftAtCenter, this.minTranslationX, i));
        } else {
            View view = this.target;
            view.setTranslationX(checkMoveBoundary(view.getTranslationX(), this.minTranslationX, i));
        }
        View view2 = this.target;
        view2.setTranslationY(checkMoveBoundary(view2.getTranslationY(), 0.0f, iMax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveTarget(float x, float y2, float maxTx, float maxTy) {
        this.target.setTranslationX(checkMoveBoundary(x, this.minTranslationX, maxTx));
        this.target.setTranslationY(checkMoveBoundary(y2, 0.0f, maxTy));
    }

    private final void restoreLastRect() {
        if (!this.isMovedBySip || this.isBlockingRestore) {
            return;
        }
        SmLogger.m8661d(TAG, "restoreLastRect# " + this.lastRectF);
        RectF rectF = this.lastRectF;
        if (rectF != null) {
            this.target.setTranslationY(rectF.top);
            this.target.getLayoutParams().height = (int) rectF.height();
            moveIntoOutbound(this.floatingContainer.getWidth(), this.floatingContainer.getHeight(), false);
            this.target.requestLayout();
        }
    }

    private final void setBlockRestore(String msg) {
        SmLogger.m8661d(TAG, "setBlockRestore# " + msg);
        this.isBlockingRestore = true;
    }

    public final float getMaxTranslationX() {
        return Math.max(0, this.floatingContainer.getWidth() - this.outHorizontal);
    }

    public final float getMaxTranslationY() {
        return Math.max(0, this.floatingContainer.getHeight() - this.minHeight);
    }

    public final void init() {
        initResizeHandle();
        initMovingControl();
        initLayoutChangeListener();
    }

    /* JADX INFO: renamed from: isSipShowing, reason: from getter */
    public final boolean getIsSipShowing() {
        return this.isSipShowing;
    }

    public final void move(int x, int y2) {
        moveTarget(x, y2, getMaxTranslationX(), getMaxTranslationY());
        saveLastRect();
        moveIntoBounds();
    }

    public final void moveIntoBounds() {
        if (this.isSipShowing) {
            moveIntoBounds$default(this, this.target.getTranslationX(), this.target.getTranslationY(), this.target.getLayoutParams().height, false, 8, null);
        }
    }

    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        String str = TAG;
        SmLogger.m8661d(str, "onConfigurationChanged# " + newConfig.orientation);
        if (this.orientation != newConfig.orientation) {
            SmLogger.m8661d(str, "onConfigurationChanged# orientation is changed");
            this.orientation = newConfig.orientation;
            if (closeInLandscape() || this.isSipShowing) {
                return;
            }
            this.isOrientationChanged = true;
            return;
        }
        if (this.screenWidthDp != newConfig.screenWidthDp) {
            this.screenWidthDp = newConfig.screenHeightDp;
            if (this.isSipShowing) {
                setBlockRestore("screen width is changed");
                return;
            }
            return;
        }
        int i = this.screenHeightDp;
        int i2 = newConfig.screenHeightDp;
        if (i != i2) {
            this.screenHeightDp = i2;
            if (this.isSipShowing) {
                setBlockRestore("screen height is changed");
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.sip.SipController.OnSipStateListener
    public void onSipHide() {
        this.isSipShowing = false;
        restoreLastRect();
        this.isMovedBySip = false;
        this.isBlockingRestore = false;
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.sip.SipController.OnSipStateListener
    public void onSipShow() {
        SmLogger.m8661d(TAG_LAYOUT, "onSipShow");
        this.isUpdatingSip = false;
        this.isSipShowing = true;
        if (hasFocus()) {
            if (this.isCalledLayoutChangedBySip) {
                moveIntoBounds();
                return;
            }
            SmLogger.m8661d(TAG, "onSipShow# pending layout");
            this.isCalledLayoutChangedBySip = true;
            this.isPendingMoveIntoBounds = true;
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.sip.SipController.OnSipStateListener
    public void onSipVisibilityChanged(boolean isVisible) {
        if (!isVisible) {
            this.isUpdatingSip = false;
        } else {
            this.isUpdatingSip = !this.isSipShowing;
            this.isCalledLayoutChangedBySip = false;
        }
    }

    public final void release() {
        View view = this.movingHandleView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("movingHandleView");
            view = null;
        }
        view.setOnTouchListener(null);
        View view2 = this.floatingContainer;
        View.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
        if (onLayoutChangeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onLayoutChangeListener");
            onLayoutChangeListener = null;
        }
        view2.removeOnLayoutChangeListener(onLayoutChangeListener);
        this.spenView = null;
    }

    public final void saveLastRect() {
        ViewGroup.LayoutParams layoutParams = this.target.getLayoutParams();
        RectF rectF = new RectF(this.target.getTranslationX(), this.target.getTranslationY(), this.target.getTranslationX() + layoutParams.width, this.target.getTranslationY() + layoutParams.height);
        this.lastRectF = rectF;
        SmLogger.m8661d(TAG, "saveLastRect# " + rectF);
    }

    public final void setSipShowing(boolean z) {
        this.isSipShowing = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveIntoBounds(float targetTX, float targetTY, int targetHeight, boolean force) {
        if (force || this.isSipShowing) {
            SmLogger.m8661d(TAG_LAYOUT, "moveIntoBounds");
            float width = this.floatingContainer.getWidth() - this.target.getWidth();
            float f = this.inboundMinX;
            float fCheckMoveBoundary = checkMoveBoundary(targetTX, this.inboundMinX, RangesKt.coerceAtLeast(width - f, f));
            float height = this.floatingContainer.getHeight();
            float f4 = this.inboundMinY;
            float f5 = targetHeight;
            float f6 = (height - f4) - f5;
            if (f6 < 0.0f) {
                targetHeight = (int) (this.floatingContainer.getHeight() - this.inboundMinY);
            } else {
                if (f5 + targetTY >= this.floatingContainer.getHeight()) {
                    targetTY = this.inboundMinY + f6;
                }
                f4 = targetTY;
            }
            this.target.setTranslationX(fCheckMoveBoundary);
            this.target.setTranslationY(f4);
            if (this.target.getLayoutParams().height != targetHeight) {
                this.target.getLayoutParams().height = Math.max(targetHeight, this.minHeightWithSip);
                this.target.requestLayout();
            }
            this.isMovedBySip = true;
        }
    }
}
