package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\b\u0000\u0018\u0000 A2\u00020\u0001:\u0002ABB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010#\u001a\u00020 J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\u001aJ\u0016\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001aJ\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010-\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0018\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001aH\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u00102\u001a\u00020\u001aH\u0002J\b\u00105\u001a\u00020 H\u0002J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u000bH\u0002J\u0010\u00108\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u000bH\u0002J\u0010\u00109\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u000bH\u0002J0\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenViewFlipperAction;", "Landroid/view/View$OnTouchListener;", "mContext", "Landroid/content/Context;", "mFlipper", "Landroid/widget/ViewFlipper;", "dir", "", "<init>", "(Landroid/content/Context;Landroid/widget/ViewFlipper;I)V", "downX", "", "downY", "mListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenViewFlipperAction$ViewFlipperActionListener;", "mCurrentIndex", "mFlipDir", "mTouchSlope", "mInOutAnimation", "", "Landroid/view/animation/Animation;", "[[Landroid/view/animation/Animation;", "mRemainAnimationCount", "mAnimateListener", "Landroid/view/animation/Animation$AnimationListener;", "onTouch", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "close", "", "setActionListener", "actionListener", "resetPosition", "moveForward", "needAnimation", "moveBackward", "changeFlip", "position", "onRightSwipe", "doChangeFlip", "onLeftSwipe", "onDownSwipe", "onUpSwipe", "notifyFlipped", "direction", "fromUser", "isMovable", "isNext", "isLTR", "()Z", "clearRemainAnimation", "swipeHorizontal", "delta", "swipeVertical", "isValidTouchAction", "isDifferentAction", "x1", "y1", "x2", "y2", "setInOutAnimation", "swipeDirection", "Companion", "ViewFlipperActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenViewFlipperAction implements View.OnTouchListener {
    private static final int ANI_IN = 0;
    private static final int ANI_MAX = 2;
    private static final int ANI_OUT = 1;
    private static final boolean CIRCULATING_FLIPPER = false;
    public static final int FLIP_DIR_LEFT_RIGHT = 0;
    public static final int FLIP_DIR_UP_DOWN = 1;
    private static final int SWIPE_DIR_BTT = 4;
    private static final int SWIPE_DIR_LTR = 1;
    private static final int SWIPE_DIR_MAX = 5;
    private static final int SWIPE_DIR_NONE = 0;
    private static final int SWIPE_DIR_RTL = 2;
    private static final int SWIPE_DIR_TTB = 3;

    @NotNull
    public static final String TAG = "SpenViewFlipperAction";
    private float downX;
    private float downY;

    @NotNull
    private final Animation.AnimationListener mAnimateListener;

    @NotNull
    private Context mContext;
    private int mCurrentIndex;
    private final int mFlipDir;

    @NotNull
    private ViewFlipper mFlipper;

    @NotNull
    private final Animation[][] mInOutAnimation;

    @Nullable
    private ViewFlipperActionListener mListener;
    private int mRemainAnimationCount;
    private final int mTouchSlope;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenViewFlipperAction$ViewFlipperActionListener;", "", "onFlipped", "", "position", "", "direction", "fromUser", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ViewFlipperActionListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FLIP_DIR_NEXT = 1;
        public static final int FLIP_DIR_NONE = 0;
        public static final int FLIP_DIR_PREV = -1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenViewFlipperAction$ViewFlipperActionListener$Companion;", "", "<init>", "()V", "FLIP_DIR_NONE", "", "FLIP_DIR_PREV", "FLIP_DIR_NEXT", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int FLIP_DIR_NEXT = 1;
            public static final int FLIP_DIR_NONE = 0;
            public static final int FLIP_DIR_PREV = -1;

            private Companion() {
            }
        }

        void onFlipped(int position, int direction, boolean fromUser);
    }

    public SpenViewFlipperAction(@NotNull Context mContext, @NotNull ViewFlipper mFlipper, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mFlipper, "mFlipper");
        this.mContext = mContext;
        this.mFlipper = mFlipper;
        this.mTouchSlope = ViewConfiguration.get(mContext).getScaledTouchSlop();
        Animation[][] animationArr = new Animation[5][];
        for (int i2 = 0; i2 < 5; i2++) {
            animationArr[i2] = new Animation[2];
        }
        this.mInOutAnimation = animationArr;
        this.mAnimateListener = new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenViewFlipperAction$mAnimateListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.mRemainAnimationCount--;
                if (this.this$0.mRemainAnimationCount > 1) {
                    AbstractC2322a.m1631u(this.this$0.mRemainAnimationCount, "onAnimationEnd() remainAnimationCount=", SpenViewFlipperAction.TAG);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.mRemainAnimationCount++;
            }
        };
        Object obj = this.mContext;
        if (obj instanceof ViewFlipperActionListener) {
            this.mListener = (ViewFlipperActionListener) obj;
        }
        this.mCurrentIndex = 1;
        this.mFlipDir = i;
        notifyFlipped(0, false);
        this.mFlipper.setOnTouchListener(this);
    }

    private final void clearRemainAnimation() {
        int i = this.mRemainAnimationCount;
        if (i == 0) {
            return;
        }
        AbstractC2322a.m1631u(i, "clearRemainAnimation() mRemainAnimationCount=", TAG);
        int childCount = this.mFlipper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mFlipper.getChildAt(i2).clearAnimation();
        }
    }

    private final boolean isDifferentAction(float x12, float y1, float x2, float y2, int dir) {
        float f = x12 - x2;
        float f4 = y1 - y2;
        if (dir != 0) {
            return false;
        }
        double dAbs = Math.abs(f);
        double d = f4;
        if (dAbs >= Math.abs(d)) {
            return false;
        }
        double dAbs2 = Math.abs(d);
        int i = this.mTouchSlope;
        if (dAbs2 <= i) {
            return false;
        }
        StringBuilder sbM1176v = AbstractC0622a.m1176v("Maybe Different Direction!! down[", x12, ",", y1, "] --> current[");
        AbstractC11014a.m12337v(sbM1176v, x2, SQLKeyword.COMMA, y2, "] touchSlope=");
        AbstractC0000a.m26w(sbM1176v, TAG, i);
        return true;
    }

    private final boolean isLTR() {
        return AbstractC0541b.m759a(this.mContext) == 0;
    }

    private final boolean isMovable(boolean isNext) {
        int i = this.mCurrentIndex + (isNext ? 1 : -1);
        return i >= 0 && i < this.mFlipper.getChildCount();
    }

    private final boolean isValidTouchAction(float delta) {
        return Math.abs((double) delta) > ((double) this.mTouchSlope);
    }

    private final void notifyFlipped(int direction, boolean fromUser) {
        ViewFlipperActionListener viewFlipperActionListener = this.mListener;
        if (viewFlipperActionListener != null) {
            viewFlipperActionListener.onFlipped(this.mCurrentIndex, direction, fromUser);
        }
    }

    private final void onDownSwipe(boolean doChangeFlip) {
        AbstractC2322a.m1631u(this.mFlipDir, "onDownSwipe mFlipDir = ", TAG);
        if (this.mFlipDir != 1) {
            return;
        }
        setInOutAnimation(3);
        if (doChangeFlip) {
            changeFlip(true);
        }
    }

    private final void onLeftSwipe(boolean doChangeFlip) {
        AbstractC2322a.m1631u(this.mFlipDir, "onLeftSwipe mFlipDir = ", TAG);
        if (this.mFlipDir != 0) {
            return;
        }
        setInOutAnimation(1);
        if (doChangeFlip) {
            changeFlip(false);
        }
    }

    private final void onRightSwipe(boolean doChangeFlip) {
        AbstractC2322a.m1631u(this.mFlipDir, "onRightSwipe mFlipDir = ", TAG);
        if (this.mFlipDir != 0) {
            return;
        }
        setInOutAnimation(2);
        if (doChangeFlip) {
            changeFlip(true);
        }
    }

    private final void onUpSwipe(boolean doChangeFlip) {
        AbstractC2322a.m1631u(this.mFlipDir, "onUpSwipe mFlipDir = ", TAG);
        if (this.mFlipDir != 1) {
            return;
        }
        setInOutAnimation(4);
        if (doChangeFlip) {
            changeFlip(false);
        }
    }

    private final void setInOutAnimation(int swipeDirection) {
        if (swipeDirection == 0) {
            Animation[] animationArr = this.mInOutAnimation[0];
            if (animationArr[0] == null) {
                animationArr[0] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.spen_color_slide_none);
                Animation[] animationArr2 = this.mInOutAnimation[0];
                animationArr2[1] = animationArr2[0];
            }
        } else if (swipeDirection == 1) {
            Animation[] animationArr3 = this.mInOutAnimation[1];
            if (animationArr3[0] == null) {
                animationArr3[0] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_in_left_to_right);
                Animation animation = this.mInOutAnimation[1][0];
                if (animation != null) {
                    animation.setAnimationListener(this.mAnimateListener);
                }
            }
            Animation[] animationArr4 = this.mInOutAnimation[1];
            if (animationArr4[1] == null) {
                animationArr4[1] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_out_left_to_right);
                Animation animation2 = this.mInOutAnimation[1][1];
                if (animation2 != null) {
                    animation2.setAnimationListener(this.mAnimateListener);
                }
            }
        } else if (swipeDirection == 2) {
            Animation[] animationArr5 = this.mInOutAnimation[2];
            if (animationArr5[0] == null) {
                animationArr5[0] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_in_right_to_left);
                Animation animation3 = this.mInOutAnimation[2][0];
                if (animation3 != null) {
                    animation3.setAnimationListener(this.mAnimateListener);
                }
            }
            Animation[] animationArr6 = this.mInOutAnimation[2];
            if (animationArr6[1] == null) {
                animationArr6[1] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_out_right_to_left);
                Animation animation4 = this.mInOutAnimation[2][1];
                if (animation4 != null) {
                    animation4.setAnimationListener(this.mAnimateListener);
                }
            }
        } else if (swipeDirection == 3) {
            Animation[] animationArr7 = this.mInOutAnimation[3];
            if (animationArr7[0] == null) {
                animationArr7[0] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_in_top_to_bottom);
                Animation animation5 = this.mInOutAnimation[3][0];
                if (animation5 != null) {
                    animation5.setAnimationListener(this.mAnimateListener);
                }
            }
            Animation[] animationArr8 = this.mInOutAnimation[3];
            if (animationArr8[1] == null) {
                animationArr8[1] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_out_top_to_bottom);
                Animation animation6 = this.mInOutAnimation[3][1];
                if (animation6 != null) {
                    animation6.setAnimationListener(this.mAnimateListener);
                }
            }
        } else if (swipeDirection == 4) {
            Animation[] animationArr9 = this.mInOutAnimation[4];
            if (animationArr9[0] == null) {
                animationArr9[0] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_in_bottom_to_top);
                Animation animation7 = this.mInOutAnimation[4][0];
                if (animation7 != null) {
                    animation7.setAnimationListener(this.mAnimateListener);
                }
            }
            Animation[] animationArr10 = this.mInOutAnimation[4];
            if (animationArr10[1] == null) {
                animationArr10[1] = AnimationUtils.loadAnimation(this.mContext, C7932R.anim.brush_color_slide_out_bottom_to_top);
                Animation animation8 = this.mInOutAnimation[4][1];
                if (animation8 != null) {
                    animation8.setAnimationListener(this.mAnimateListener);
                }
            }
        }
        this.mFlipper.setInAnimation(this.mInOutAnimation[swipeDirection][0]);
        this.mFlipper.setOutAnimation(this.mInOutAnimation[swipeDirection][1]);
    }

    private final boolean swipeHorizontal(float delta) {
        if (!isValidTouchAction(delta)) {
            return false;
        }
        if (!isMovable(!isLTR() ? delta >= 0.0f : delta <= 0.0f)) {
            notifyFlipped(0, true);
            return true;
        }
        if (delta > 0.0f) {
            onRightSwipe(true);
        } else {
            onLeftSwipe(true);
        }
        return true;
    }

    private final boolean swipeVertical(float delta) {
        if (!isValidTouchAction(delta)) {
            return false;
        }
        if (!isMovable(delta > 0.0f)) {
            notifyFlipped(0, true);
            return true;
        }
        if (delta < 0.0f) {
            onDownSwipe(true);
        } else {
            onUpSwipe(true);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        onRightSwipe(false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void changeFlip(int position, boolean needAnimation) {
        int i;
        AbstractC11014a.m12329n(position, ")", TAG, AbstractC0622a.m1173s(this.mFlipper.getChildCount(), this.mCurrentIndex, "Total =", " mCurrent(", ") --> changePos("));
        if (!needAnimation || (i = this.mCurrentIndex) == position) {
            setInOutAnimation(0);
        } else if (this.mFlipDir == 0) {
            if (isLTR()) {
                onLeftSwipe(false);
            } else {
                onLeftSwipe(false);
            }
        } else if (i < position) {
            onDownSwipe(false);
        } else {
            onUpSwipe(false);
        }
        this.mCurrentIndex = position;
        this.mFlipper.setDisplayedChild(position);
        AbstractC2322a.m1631u(this.mCurrentIndex, "[AFTER] changeFlip() movePosition=", TAG);
        notifyFlipped(0, false);
    }

    public final void close() {
        this.mListener = null;
        this.mRemainAnimationCount = 0;
        for (int i = 0; i < 5; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                this.mInOutAnimation[i][i2] = null;
            }
        }
    }

    public final void moveBackward(boolean needAnimation) {
        setInOutAnimation(needAnimation ? this.mFlipDir == 0 ? 2 : 4 : 0);
        changeFlip(false);
    }

    public final void moveForward(boolean needAnimation) {
        setInOutAnimation(needAnimation ? this.mFlipDir == 0 ? 1 : 3 : 0);
        changeFlip(true);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NotNull View v, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.downX = event.getX();
            this.downY = event.getY();
            return true;
        }
        if (action == 1) {
            float x = this.downX - event.getX();
            float y2 = this.downY - event.getY();
            this.downX = 0.0f;
            this.downY = 0.0f;
            if (Math.abs(x) > Math.abs(y2)) {
                Log.i(TAG, "FlipperAction Swipe = Horizontal");
                return swipeHorizontal(x);
            }
            Log.i(TAG, "FlipperAction Swipe = Vertical");
            return swipeVertical(y2);
        }
        if (action != 2) {
            return false;
        }
        if (this.downX == 0.0f && this.downY == 0.0f) {
            this.downX = event.getX();
            this.downY = event.getY();
        }
        if (!isDifferentAction(this.downX, this.downY, event.getX(), event.getY(), this.mFlipDir)) {
            return true;
        }
        this.downX = 0.0f;
        this.downY = 0.0f;
        if (v.getParent() != null) {
            v.getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    public final void resetPosition() {
        this.mCurrentIndex = 0;
    }

    public final void setActionListener(@Nullable ViewFlipperActionListener actionListener) {
        this.mListener = actionListener;
    }

    private final void changeFlip(boolean isNext) {
        Log.i(TAG, "[BEFORE] changeFlip(" + isNext + ") current=" + this.mCurrentIndex);
        int childCount = this.mFlipper.getChildCount();
        clearRemainAnimation();
        boolean z = (isLTR() || this.mFlipDir == 1) ? isNext : !isNext;
        if (z) {
            this.mFlipper.showNext();
            int i = this.mCurrentIndex + 1;
            this.mCurrentIndex = i;
            if (i >= childCount) {
                this.mCurrentIndex = 0;
            }
        } else {
            this.mFlipper.showPrevious();
            int i2 = this.mCurrentIndex - 1;
            this.mCurrentIndex = i2;
            if (i2 < 0) {
                this.mCurrentIndex = childCount - 1;
            }
        }
        AbstractC0000a.m26w(AbstractC2821a.m2230u("[AFTER] changeFlip(", ") showNext=", " current=", isNext, z), TAG, this.mCurrentIndex);
        notifyFlipped(z ? 1 : -1, true);
    }
}
