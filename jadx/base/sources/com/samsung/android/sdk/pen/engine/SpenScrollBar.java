package com.samsung.android.sdk.pen.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.spen.C7932R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u0000 W2\u00020\u0001:\u0003UVWB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010/\u001a\u00020.J\u0010\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0015J\u0016\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nJ8\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0007J\u000e\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020\u001fJ\u000e\u0010?\u001a\u00020.2\u0006\u0010>\u001a\u00020\u001fJ\u000e\u0010@\u001a\u00020.2\u0006\u0010>\u001a\u00020\u001fJ\u000e\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020,J\u0012\u0010D\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010FH\u0017J\u0016\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u0018\u0010J\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020.H\u0002J\u0018\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000fH\u0002J\u0010\u0010Q\u001a\u00020.2\u0006\u0010R\u001a\u00020\u000fH\u0002J\u0010\u0010S\u001a\u00020.2\u0006\u0010T\u001a\u00020\u001fH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u001e\u0010#\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0018\u00010'R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bC\u0010!¨\u0006X"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenScrollBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mScreenWidth", "mScreenHeight", "mDeltaX", "", "mDeltaY", "mDeltaScrollY", "mMaxDeltaX", "mMaxDeltaY", "mRatioWidth", "mRatioHeight", "mScrollBarThick", "mScrollBarMargin", "mTouchOffset", "mRectLR", "Landroid/graphics/Rect;", "mRectTB", "mPaint", "Landroid/graphics/Paint;", "value", "", "isScroll", "()Z", "isHorizontalScroll", "isVerticalScroll", "mIsTouched", "mScrollShow", "mHandler", "Lcom/samsung/android/sdk/pen/engine/SpenScrollBar$UpdateHandler;", "mToolAndActionMap", "Landroid/util/SparseIntArray;", "mUnofficialWaterMarkEnable", "mOnScrollBarChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenScrollBar$OnScrollBarChangedListener;", "init", "", "close", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setScreenSize", "w", "h", "setDeltaValue", "deltaX", "deltaY", "maxDeltaX", "maxDeltaY", "ratioWidth", "ratioHeight", "enableScroll", "enable", "enableVerticalScroll", "enableHorizontalScroll", "setOnScrollBarChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isWorking", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setToolTypeAction", "toolType", "action", "drawUnofficialWaterMark", "text", "", "drawPost", "isScrollBarTouched", "x", "y", "updateScrollVertical", "position", "setSelectedInfo", "isSelected", "OnScrollBarChangedListener", "UpdateHandler", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenScrollBar extends View {
    public static final int DISMISS = 0;
    private static final float MIN_DELTA = 0.001f;
    private static final int SCROLL_OFFSET = 20;

    @NotNull
    private static final String TAG = "SpenScrollBar";
    public static final int UPDATE = 1;
    private boolean isHorizontalScroll;
    private boolean isScroll;
    private boolean isVerticalScroll;
    private float mDeltaScrollY;
    private float mDeltaX;
    private float mDeltaY;

    @Nullable
    private UpdateHandler mHandler;
    private boolean mIsTouched;
    private float mMaxDeltaX;
    private float mMaxDeltaY;

    @Nullable
    private OnScrollBarChangedListener mOnScrollBarChangeListener;

    @NotNull
    private Paint mPaint;
    private int mRatioHeight;
    private int mRatioWidth;

    @NotNull
    private Rect mRectLR;

    @NotNull
    private Rect mRectTB;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mScrollBarMargin;
    private int mScrollBarThick;
    private boolean mScrollShow;

    @Nullable
    private SparseIntArray mToolAndActionMap;
    private float mTouchOffset;
    private final boolean mUnofficialWaterMarkEnable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenScrollBar$OnScrollBarChangedListener;", "", "onScrollVertical", "", "position", "Landroid/graphics/PointF;", "onScrollHorizontal", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnScrollBarChangedListener {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void onScrollHorizontal(@NotNull OnScrollBarChangedListener onScrollBarChangedListener, @NotNull PointF position) {
                Intrinsics.checkNotNullParameter(position, "position");
            }

            public static void onScrollVertical(@NotNull OnScrollBarChangedListener onScrollBarChangedListener, @NotNull PointF position) {
                Intrinsics.checkNotNullParameter(position, "position");
            }
        }

        void onScrollHorizontal(@NotNull PointF position);

        void onScrollVertical(@NotNull PointF position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenScrollBar$UpdateHandler;", "Landroid/os/Handler;", "view", "Lcom/samsung/android/sdk/pen/engine/SpenScrollBar;", "<init>", "(Lcom/samsung/android/sdk/pen/engine/SpenScrollBar;Lcom/samsung/android/sdk/pen/engine/SpenScrollBar;)V", "mView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "close", "", "handleMessage", "msg", "Landroid/os/Message;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class UpdateHandler extends Handler {

        @Nullable
        private WeakReference<View> mView;
        final /* synthetic */ SpenScrollBar this$0;

        public UpdateHandler(@NotNull SpenScrollBar spenScrollBar, SpenScrollBar view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = spenScrollBar;
            this.mView = new WeakReference<>(view);
        }

        public final void close() {
            removeMessages(0);
            removeMessages(1);
            WeakReference<View> weakReference = this.mView;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.mView = null;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            View view;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            WeakReference<View> weakReference = this.mView;
            if (weakReference == null || weakReference == null || (view = weakReference.get()) == null) {
                return;
            }
            int i = msg.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                view.invalidate();
            } else {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                final SpenScrollBar spenScrollBar = this.this$0;
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.engine.SpenScrollBar$UpdateHandler$handleMessage$1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        Log.d("SpenScrollBar", "onAnimationEnd");
                        spenScrollBar.mScrollShow = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }
                });
                view.startAnimation(alphaAnimation);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenScrollBar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectLR = new Rect();
        this.mRectTB = new Rect();
        this.mPaint = new Paint();
        this.mToolAndActionMap = new SparseIntArray(10);
        init(context);
    }

    private final void drawPost() {
        postInvalidateOnAnimation();
    }

    private final void drawUnofficialWaterMark(Canvas canvas, String text) {
        canvas.save();
        Paint paint = new Paint();
        paint.setColor(-65536);
        paint.setTextSize(100.0f);
        float fMeasureText = paint.measureText(text);
        float f = 2;
        canvas.translate((this.mScreenWidth - fMeasureText) / f, (this.mScreenHeight - fMeasureText) / f);
        canvas.rotate(45.0f);
        canvas.drawText(text, 0.0f, 0.0f, paint);
        canvas.restore();
    }

    private final void init(Context context) {
        this.isScroll = false;
        this.isHorizontalScroll = true;
        this.isVerticalScroll = true;
        this.mScrollShow = false;
        this.mScrollBarThick = context.getResources().getDimensionPixelSize(C7932R.dimen.scroll_bar_size);
        this.mScrollBarMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.scroll_bar_margin);
        this.mPaint.setColor(context.getResources().getColor(C7932R.color.scroll_bar_color, null));
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(this.mScrollBarThick);
        this.mHandler = new UpdateHandler(this, this);
        SparseIntArray sparseIntArray = this.mToolAndActionMap;
        if (sparseIntArray != null) {
            sparseIntArray.put(1, 1);
            sparseIntArray.put(2, 2);
            sparseIntArray.put(5, 1);
        }
    }

    private final boolean isScrollBarTouched(float x, float y2) {
        int i = this.mScrollBarMargin / 2;
        if (this.isVerticalScroll) {
            Rect rect = this.mRectTB;
            return x >= ((float) (rect.left - i)) && x <= ((float) (rect.right + i)) && y2 >= ((float) rect.top) && y2 <= ((float) rect.bottom);
        }
        Rect rect2 = this.mRectLR;
        return x >= ((float) rect2.left) && x <= ((float) rect2.right) && y2 >= ((float) (rect2.top - i)) && y2 <= ((float) (rect2.bottom + i));
    }

    private final void setSelectedInfo(boolean isSelected) {
        this.mScrollBarThick = isSelected ? getContext().getResources().getDimensionPixelSize(C7932R.dimen.scroll_bar_selected_size) : getContext().getResources().getDimensionPixelSize(C7932R.dimen.scroll_bar_size);
        this.mScrollBarMargin = isSelected ? getContext().getResources().getDimensionPixelSize(C7932R.dimen.scroll_bar_selected_margin) : getContext().getResources().getDimensionPixelSize(C7932R.dimen.scroll_bar_margin);
        this.mPaint.setColor(isSelected ? getContext().getResources().getColor(C7932R.color.scroll_bar_selected_color, null) : getContext().getResources().getColor(C7932R.color.scroll_bar_color, null));
        if (this.isVerticalScroll) {
            Rect rect = this.mRectTB;
            int i = this.mScreenWidth;
            int i2 = i - this.mScrollBarThick;
            int i4 = this.mScrollBarMargin;
            rect.left = i2 - i4;
            rect.right = i - i4;
        } else {
            Rect rect2 = this.mRectLR;
            int i5 = this.mScreenHeight;
            int i6 = i5 - this.mScrollBarThick;
            int i7 = this.mScrollBarMargin;
            rect2.top = i6 - i7;
            rect2.bottom = i5 - i7;
        }
        invalidate();
    }

    private final void updateScrollVertical(float position) {
        int i = this.mRatioHeight;
        if (i > 0) {
            int i2 = this.mScreenHeight;
            int i4 = (i2 - ((i2 * i2) / i)) + 1;
            float f = i4;
            float fCoerceIn = RangesKt.coerceIn(position - this.mTouchOffset, 0.0f, f);
            if (i4 != 0) {
                PointF pointF = new PointF(0.0f, (fCoerceIn / f) * this.mMaxDeltaY);
                OnScrollBarChangedListener onScrollBarChangedListener = this.mOnScrollBarChangeListener;
                if (onScrollBarChangedListener != null) {
                    onScrollBarChangedListener.onScrollVertical(pointF);
                }
            }
        }
    }

    public final void close() {
        UpdateHandler updateHandler = this.mHandler;
        if (updateHandler != null) {
            updateHandler.close();
        }
        this.mHandler = null;
        SparseIntArray sparseIntArray = this.mToolAndActionMap;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        this.mToolAndActionMap = null;
    }

    public final void enableHorizontalScroll(boolean enable) {
        this.isHorizontalScroll = enable;
    }

    public final void enableScroll(boolean enable) {
        this.isScroll = enable;
    }

    public final void enableVerticalScroll(boolean enable) {
        this.isVerticalScroll = enable;
    }

    /* JADX INFO: renamed from: isHorizontalScroll, reason: from getter */
    public final boolean getIsHorizontalScroll() {
        return this.isHorizontalScroll;
    }

    /* JADX INFO: renamed from: isScroll, reason: from getter */
    public final boolean getIsScroll() {
        return this.isScroll;
    }

    /* JADX INFO: renamed from: isVerticalScroll, reason: from getter */
    public final boolean getIsVerticalScroll() {
        return this.isVerticalScroll;
    }

    public final boolean isWorking() {
        return this.isScroll & this.mScrollShow;
    }

    @Override // android.view.View
    @SuppressLint({WarningType.NewApi})
    public void onDraw(@NotNull Canvas canvas) {
        UpdateHandler updateHandler;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        boolean z = false;
        if (this.isScroll && this.mScrollShow) {
            if (this.isHorizontalScroll && this.mMaxDeltaX > 0.5f) {
                Rect rect = this.mRectLR;
                float f = rect.left;
                float fCenterY = rect.centerY();
                Rect rect2 = this.mRectLR;
                canvas.drawLine(f, fCenterY, rect2.right, rect2.centerY(), this.mPaint);
                z = true;
            }
            if (this.isVerticalScroll && this.mMaxDeltaY > 0.5f) {
                float fCenterX = this.mRectTB.centerX();
                Rect rect3 = this.mRectTB;
                canvas.drawLine(fCenterX, rect3.top, rect3.centerX(), this.mRectTB.bottom, this.mPaint);
                z = true;
            }
        }
        if (z && (updateHandler = this.mHandler) != null) {
            updateHandler.sendEmptyMessage(1);
        }
        if (this.mUnofficialWaterMarkEnable) {
            drawUnofficialWaterMark(canvas, "UNOFFICIAL RELEASE");
        }
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        UpdateHandler updateHandler;
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction() & 255) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            if (this.mScrollShow && isScrollBarTouched(event.getX(), event.getY())) {
                this.mIsTouched = true;
                this.mTouchOffset = event.getY() - this.mRectTB.top;
                setSelectedInfo(this.mIsTouched);
                UpdateHandler updateHandler2 = this.mHandler;
                if (updateHandler2 != null) {
                    updateHandler2.sendEmptyMessage(1);
                    updateHandler2.removeMessages(0);
                }
            }
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            if (this.mScrollShow && this.isVerticalScroll && this.mIsTouched) {
                updateScrollVertical(event.getY());
            }
        } else if ((numValueOf != null && numValueOf.intValue() == 1) || (numValueOf != null && numValueOf.intValue() == 3)) {
            this.mIsTouched = false;
            this.mTouchOffset = 0.0f;
            setSelectedInfo(false);
            if (this.mScrollShow && (updateHandler = this.mHandler) != null) {
                updateHandler.sendEmptyMessage(1);
                updateHandler.removeMessages(0);
                updateHandler.sendEmptyMessageDelayed(0, 300L);
            }
        }
        return this.mIsTouched;
    }

    @SuppressLint({WarningType.NewApi})
    public final void setDeltaValue(float deltaX, float deltaY, float maxDeltaX, float maxDeltaY, int ratioWidth, int ratioHeight) {
        UpdateHandler updateHandler;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("setDeltaValue deltaX=", deltaX, ", deltaY=", deltaY, " maxDeltaX=");
        sbM1176v.append(maxDeltaX);
        sbM1176v.append(", maxDeltaY=");
        sbM1176v.append(maxDeltaY);
        Log.d(TAG, sbM1176v.toString());
        this.mDeltaX = deltaX;
        this.mDeltaY = deltaY;
        this.mMaxDeltaX = maxDeltaX;
        this.mMaxDeltaY = maxDeltaY;
        this.mRatioWidth = ratioWidth;
        this.mRatioHeight = ratioHeight;
        if (Math.abs(this.mDeltaScrollY - deltaY) < 20.0d) {
            return;
        }
        this.mDeltaScrollY = deltaY;
        float f = this.mMaxDeltaX;
        if (f > 0.001f && ratioWidth > 0) {
            int i = this.mScreenWidth;
            int i2 = (i * i) / this.mRatioWidth;
            int i4 = (int) (this.mDeltaX * (((i - i2) + 1) / f) * (-1));
            Rect rect = this.mRectLR;
            int i5 = this.mScreenHeight;
            int i6 = i5 - this.mScrollBarThick;
            int i7 = this.mScrollBarMargin;
            rect.set(i4, i6 - i7, i2 + i4, i5 - i7);
            this.mScrollShow = true;
        }
        float f4 = this.mMaxDeltaY;
        if (f4 > 0.001f && ratioHeight > 0) {
            int i8 = this.mScreenHeight;
            int i9 = (i8 * i8) / this.mRatioHeight;
            int i10 = (int) (this.mDeltaY * (((i8 - i9) + 1) / f4) * (-1));
            Rect rect2 = this.mRectTB;
            int i11 = this.mScreenWidth;
            int i12 = i11 - this.mScrollBarThick;
            int i13 = this.mScrollBarMargin;
            rect2.set(i12 - i13, i10, i11 - i13, i9 + i10);
            this.mScrollShow = true;
        }
        if (!this.isScroll || !this.mScrollShow || this.mIsTouched || (updateHandler = this.mHandler) == null) {
            return;
        }
        updateHandler.sendEmptyMessage(1);
        updateHandler.removeMessages(0);
        updateHandler.sendEmptyMessageDelayed(0, 300L);
    }

    public final void setOnScrollBarChangeListener(@NotNull OnScrollBarChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnScrollBarChangeListener = listener;
    }

    public final void setScreenSize(int w, int h) {
        this.mScreenWidth = w;
        this.mScreenHeight = h;
        getLayoutParams().width = this.mScreenWidth;
        getLayoutParams().height = this.mScreenHeight;
        requestLayout();
    }

    public final void setToolTypeAction(int toolType, int action) {
        SparseIntArray sparseIntArray = this.mToolAndActionMap;
        if (sparseIntArray != null) {
            sparseIntArray.put(toolType, action);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenScrollBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectLR = new Rect();
        this.mRectTB = new Rect();
        this.mPaint = new Paint();
        this.mToolAndActionMap = new SparseIntArray(10);
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenScrollBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectLR = new Rect();
        this.mRectTB = new Rect();
        this.mPaint = new Paint();
        this.mToolAndActionMap = new SparseIntArray(10);
        init(context);
    }
}
