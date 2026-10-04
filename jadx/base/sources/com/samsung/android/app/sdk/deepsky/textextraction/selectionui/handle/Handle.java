package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableCharacter;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableOcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawInfo;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.VectorUtil;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 d2\u00020\u0001:\u0003defB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u00107\u001a\u00020\b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0002¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bJ\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000eH\u0002J\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ#\u0010E\u001a\u00020\b2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010GJ!\u0010H\u001a\b\u0012\u0004\u0012\u00020:092\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0002¢\u0006\u0002\u0010IJ#\u0010J\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010MJ\u0006\u0010N\u001a\u00020\u0016J\u0006\u0010O\u001a\u00020\u0016J\u0006\u0010P\u001a\u00020BJ\b\u0010Q\u001a\u00020BH\u0002J\u0010\u0010R\u001a\u00020B2\b\u00102\u001a\u0004\u0018\u000103JF\u0010S\u001a\u00020B2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u00102\u001a\u0002032\f\u0010X\u001a\b\u0012\u0004\u0012\u00020B0YH\u0002J\u000e\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020\\J\u000e\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020\u001fJ\u0010\u0010_\u001a\u00020B2\u0006\u0010[\u001a\u00020\\H\u0002J\f\u0010`\u001a\u00020\b*\u00020\bH\u0002J\u0014\u0010a\u001a\u00020B*\u00020b2\u0006\u0010c\u001a\u00020\bH\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006g"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle;", "", "context", "Landroid/content/Context;", "handleType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle$HandleType;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle$HandleType;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "drawAreaRect", "Landroid/graphics/Rect;", "drawStrategy", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/draw/HandleDrawStrategy;", "drawable", "Landroid/graphics/drawable/LayerDrawable;", "drawableHeight", "drawableWidth", "isLeftToRight", "", "isMagnifyHandle", "isMovingEnabled", "()Z", "setMovingEnabled", "(Z)V", "isShadowEnabled", "setShadowEnabled", "movingState", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle$MovingState;", "rotationAngle", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "", "getScaleFactor", "()F", "setScaleFactor", "(F)V", "scaledDrawableHeight", "scaledDrawableWidth", "scaledTouchAreaMarginBottom", "scaledTouchAreaMarginLeft", "scaledTouchAreaMarginRight", "scaledTouchAreaMarginTop", "<set-?>", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "selectedChar", "getSelectedChar", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "teView", "Landroid/view/View;", "touchAreaRect", "getTouchAreaRect", "()Landroid/graphics/Rect;", "computeAngleOfPoly", "poly", "", "Landroid/graphics/Point;", "([Landroid/graphics/Point;)I", "contains", "x", "y", "createDefaultTouchableAreaRect", "defaultRect", "draw", "", "canvas", "Landroid/graphics/Canvas;", "findHandleVisibleRotationAngle", "targetPoly", "([Landroid/graphics/Point;Landroid/graphics/Rect;)I", "getGlobalVisiblePoly", "([Landroid/graphics/Point;)[Landroid/graphics/Point;", "getRotatedRect", "angle", "rect", "(ILandroid/graphics/Rect;)[Landroid/graphics/Point;", "isMoving", "isNotEmpty", "setEmpty", "setScaledParameters", "setTeView", "showHandleAnimation", "startBounds", "endBounds", "startRotation", "endRotation", "handleAnimationCallback", "Lkotlin/Function0;", "updateHandle", "handleDrawInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/draw/HandleDrawInfo;", "updateMovingState", "newState", "updateRectAndDrawable", "dimenToPixel", "setDegree", "Landroid/graphics/drawable/RotateDrawable;", "degree", "Companion", "HandleType", "MovingState", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handle.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,289:1\n11335#2:290\n11670#2,3:291\n12541#2,2:296\n11335#2:298\n11670#2,3:299\n11335#2:304\n11670#2,3:305\n37#3,2:294\n37#3,2:302\n37#3,2:308\n*S KotlinDebug\n*F\n+ 1 Handle.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle\n*L\n234#1:290\n234#1:291,3\n239#1:296,2\n261#1:298\n261#1:299,3\n272#1:304\n272#1:305,3\n234#1:294,2\n266#1:302,2\n272#1:308,2\n*E\n"})
public final class Handle {
    private static final int DRAWABLE_RESIZE_RATIO = 3;
    private static final long HANDLE_ANIMATION_MILLISECONDS = 400;
    private static final float HANDLE_SCALE_FACTOR = 1.2f;
    private static final int LTR_LEFT_BOTTOM_POSITION = 3;
    private static final int LTR_RIGHT_BOTTOM_POSITION = 2;
    private static final int RTL_LEFT_BOTTOM_POSITION = 2;
    private static final int RTL_RIGHT_BOTTOM_POSITION = 3;

    @NotNull
    private static final String TAG = "Handle";
    private int color;

    @NotNull
    private final Context context;

    @NotNull
    private Rect drawAreaRect;

    @NotNull
    private HandleDrawStrategy drawStrategy;

    @NotNull
    private LayerDrawable drawable;
    private int drawableHeight;
    private int drawableWidth;

    @NotNull
    private final HandleType handleType;
    private boolean isLeftToRight;
    private boolean isMagnifyHandle;
    private boolean isMovingEnabled;
    private boolean isShadowEnabled;

    @NotNull
    private MovingState movingState;
    private int rotationAngle;
    private float scaleFactor;
    private int scaledDrawableHeight;
    private int scaledDrawableWidth;
    private int scaledTouchAreaMarginBottom;
    private int scaledTouchAreaMarginLeft;
    private int scaledTouchAreaMarginRight;
    private int scaledTouchAreaMarginTop;

    @NotNull
    private SelectableCharacter selectedChar;

    @Nullable
    private View teView;

    @NotNull
    private Rect touchAreaRect;

    @NotNull
    private static final PathInterpolator HANDLE_ANIMATION_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle$HandleType;", "", "(Ljava/lang/String;I)V", CoeditGrpcMethod.Caller.START, CoeditGrpcMethod.Caller.END, "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum HandleType {
        START,
        END
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle$MovingState;", "", "(Ljava/lang/String;I)V", "IDLE", "MOVING", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum MovingState {
        IDLE,
        MOVING
    }

    public Handle(@NotNull Context context, @NotNull HandleType handleType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handleType, "handleType");
        this.context = context;
        this.handleType = handleType;
        this.drawable = new LayerDrawable(new Drawable[0]);
        this.drawAreaRect = new Rect();
        this.isLeftToRight = true;
        MovingState movingState = MovingState.IDLE;
        this.movingState = movingState;
        this.drawStrategy = HandleDrawStrategyFactory.INSTANCE.createDrawStrategy(handleType, movingState, true, true);
        this.color = context.getColor(C7039R.color.textextraction_handle_tint_color);
        this.isMovingEnabled = true;
        this.touchAreaRect = new Rect();
        this.scaleFactor = 1.0f;
        this.selectedChar = SelectableOcrResult.INSTANCE.getEMPTY_CHARACTER();
        RotateDrawable rotateDrawable = this.drawStrategy.getRotateDrawable(context, this.color);
        this.drawableWidth = rotateDrawable.getIntrinsicWidth() / 3;
        this.drawableHeight = rotateDrawable.getIntrinsicHeight() / 3;
    }

    private final int computeAngleOfPoly(Point[] poly) {
        return (int) (this.isLeftToRight ? VectorUtil.INSTANCE.getRotationDegree(poly[3], poly[2]) : VectorUtil.INSTANCE.getRotationDegree(poly[2], poly[3]));
    }

    private final Rect createDefaultTouchableAreaRect(Rect defaultRect) {
        return new Rect(defaultRect.left - this.scaledTouchAreaMarginLeft, defaultRect.top - this.scaledTouchAreaMarginTop, defaultRect.right + this.scaledTouchAreaMarginRight, defaultRect.bottom + this.scaledTouchAreaMarginBottom);
    }

    private final int dimenToPixel(int i) {
        return this.context.getResources().getDimensionPixelSize(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0079, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int findHandleVisibleRotationAngle(Point[] targetPoly, Rect drawAreaRect) {
        Rect rect = new Rect();
        View view = this.teView;
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        int iComputeAngleOfPoly = computeAngleOfPoly(targetPoly);
        Integer[] numArr = {0, 90, -90, 180};
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            arrayList.add(Integer.valueOf(numArr[i].intValue() + iComputeAngleOfPoly));
        }
        Integer[] numArr2 = (Integer[]) ArraysKt.plus(arrayList.toArray(new Integer[0]), (Object[]) new Integer[]{0, 90, -90, 180});
        int length = numArr2.length;
        int i2 = 0;
        while (i2 < length) {
            int iIntValue = numArr2[i2].intValue();
            for (Point point : getGlobalVisiblePoly(getRotatedRect(iIntValue, drawAreaRect))) {
                if (!rect.contains(point.x, point.y)) {
                    break;
                }
            }
            return iIntValue;
        }
        return 180;
    }

    private final Point[] getGlobalVisiblePoly(Point[] poly) {
        int[] iArr = new int[2];
        View view = this.teView;
        if (view != null) {
            view.getLocationInWindow(iArr);
        }
        ArrayList arrayList = new ArrayList(poly.length);
        for (Point point : poly) {
            arrayList.add(new Point(point.x + iArr[0], point.y + iArr[1]));
        }
        return (Point[]) arrayList.toArray(new Point[0]);
    }

    private final Point[] getRotatedRect(int angle, Rect rect) {
        Point[] rotatedDefaultRect = this.drawStrategy.getRotatedDefaultRect(angle, rect);
        ArrayList arrayList = new ArrayList(rotatedDefaultRect.length);
        for (Point point : rotatedDefaultRect) {
            float f = point.x;
            float f4 = this.scaleFactor;
            arrayList.add(new Point((int) (f / f4), (int) (r3.y / f4)));
        }
        return (Point[]) arrayList.toArray(new Point[0]);
    }

    private final void setDegree(RotateDrawable rotateDrawable, int i) {
        rotateDrawable.setLevel((int) ((i / 360.0f) * 10000));
    }

    private final void setScaledParameters() {
        float f = this.isMagnifyHandle ? this.scaleFactor * 1.2f : this.scaleFactor;
        int iDimenToPixel = dimenToPixel(C7039R.dimen.textextraction_handle_touch_margin_top);
        int iDimenToPixel2 = dimenToPixel(C7039R.dimen.textextraction_handle_touch_margin_bottom);
        int iDimenToPixel3 = dimenToPixel(C7039R.dimen.textextraction_handle_touch_margin_start);
        int iDimenToPixel4 = dimenToPixel(C7039R.dimen.textextraction_handle_touch_margin_end);
        this.scaledDrawableWidth = (int) (this.drawableWidth * f);
        this.scaledDrawableHeight = (int) (this.drawableHeight * f);
        this.scaledTouchAreaMarginLeft = (int) (iDimenToPixel3 * f);
        this.scaledTouchAreaMarginTop = (int) (iDimenToPixel * f);
        this.scaledTouchAreaMarginRight = (int) (iDimenToPixel4 * f);
        this.scaledTouchAreaMarginBottom = (int) (iDimenToPixel2 * f);
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [T, android.graphics.drawable.RotateDrawable] */
    private final void showHandleAnimation(LayerDrawable drawable, final Rect startBounds, final Rect endBounds, final int startRotation, final int endRotation, final View teView, final Function0<Unit> handleAnimationCallback) {
        Drawable drawable2 = drawable.getDrawable(0);
        Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
        final RotateDrawable rotateDrawable = (RotateDrawable) drawable2;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.isShadowEnabled) {
            Drawable drawable3 = drawable.getDrawable(1);
            Intrinsics.checkNotNull(drawable3, "null cannot be cast to non-null type android.graphics.drawable.RotateDrawable");
            objectRef.element = (RotateDrawable) drawable3;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Handle.showHandleAnimation$lambda$5$lambda$4(startBounds, endBounds, startRotation, endRotation, rotateDrawable, objectRef, this, teView, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.Handle$showHandleAnimation$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                handleAnimationCallback.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                handleAnimationCallback.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        valueAnimatorOfFloat.setInterpolator(HANDLE_ANIMATION_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showHandleAnimation$lambda$5$lambda$4(Rect startBounds, Rect endBounds, int i, int i2, RotateDrawable handleDrawable, Ref.ObjectRef shadowDrawable, Handle this$0, View teView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(startBounds, "$startBounds");
        Intrinsics.checkNotNullParameter(endBounds, "$endBounds");
        Intrinsics.checkNotNullParameter(handleDrawable, "$handleDrawable");
        Intrinsics.checkNotNullParameter(shadowDrawable, "$shadowDrawable");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(teView, "$teView");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        DrawUtil drawUtil = DrawUtil.INSTANCE;
        Rect rectInterpolateRect = drawUtil.interpolateRect(startBounds, endBounds, fFloatValue);
        int iInterpolateInt = drawUtil.interpolateInt(i, i2, fFloatValue);
        handleDrawable.setBounds(rectInterpolateRect);
        RotateDrawable rotateDrawable = (RotateDrawable) shadowDrawable.element;
        if (rotateDrawable != null) {
            rotateDrawable.setBounds(rectInterpolateRect);
        }
        this$0.setDegree(handleDrawable, iInterpolateInt);
        RotateDrawable rotateDrawable2 = (RotateDrawable) shadowDrawable.element;
        if (rotateDrawable2 != null) {
            this$0.setDegree(rotateDrawable2, iInterpolateInt);
        }
        teView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRectAndDrawable(HandleDrawInfo handleDrawInfo) {
        RotateDrawable shadowDrawable;
        this.drawAreaRect = this.drawStrategy.getDefaultRect(handleDrawInfo, this.scaledDrawableWidth, this.scaledDrawableHeight);
        this.rotationAngle = findHandleVisibleRotationAngle(handleDrawInfo.getSelectedChar().getPoly(), this.drawAreaRect);
        HandleDrawStrategy handleDrawStrategy = this.drawStrategy;
        Rect rect = this.drawAreaRect;
        this.touchAreaRect = handleDrawStrategy.getTouchableAreaRect(rect, createDefaultTouchableAreaRect(rect), this.rotationAngle);
        RotateDrawable rotateDrawable = this.drawStrategy.getRotateDrawable(this.context, this.color);
        setDegree(rotateDrawable, this.rotationAngle);
        rotateDrawable.setBounds(this.drawAreaRect);
        if (this.isShadowEnabled) {
            shadowDrawable = this.drawStrategy.getShadowDrawable(this.context);
            setDegree(shadowDrawable, this.rotationAngle);
            shadowDrawable.setBounds(this.drawAreaRect);
        } else {
            shadowDrawable = null;
        }
        this.drawable = new LayerDrawable(new RotateDrawable[]{rotateDrawable, shadowDrawable});
    }

    public final boolean contains(int x, int y2) {
        return this.touchAreaRect.contains(x, y2);
    }

    public final void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.drawable.draw(canvas);
    }

    public final int getColor() {
        return this.color;
    }

    public final float getScaleFactor() {
        return this.scaleFactor;
    }

    @NotNull
    public final SelectableCharacter getSelectedChar() {
        return this.selectedChar;
    }

    @NotNull
    public final Rect getTouchAreaRect() {
        return this.touchAreaRect;
    }

    public final boolean isMoving() {
        return this.movingState == MovingState.MOVING;
    }

    /* JADX INFO: renamed from: isMovingEnabled, reason: from getter */
    public final boolean getIsMovingEnabled() {
        return this.isMovingEnabled;
    }

    public final boolean isNotEmpty() {
        return !this.drawAreaRect.isEmpty();
    }

    /* JADX INFO: renamed from: isShadowEnabled, reason: from getter */
    public final boolean getIsShadowEnabled() {
        return this.isShadowEnabled;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setEmpty() {
        this.drawAreaRect = new Rect();
        this.touchAreaRect = new Rect();
    }

    public final void setMovingEnabled(boolean z) {
        this.isMovingEnabled = z;
    }

    public final void setScaleFactor(float f) {
        this.scaleFactor = f;
    }

    public final void setShadowEnabled(boolean z) {
        this.isShadowEnabled = z;
    }

    public final void setTeView(@Nullable View teView) {
        this.teView = teView;
    }

    public final void updateHandle(@NotNull final HandleDrawInfo handleDrawInfo) {
        Intrinsics.checkNotNullParameter(handleDrawInfo, "handleDrawInfo");
        this.selectedChar = handleDrawInfo.getSelectedChar();
        boolean zIsLeftToRight = handleDrawInfo.isLeftToRight();
        this.isLeftToRight = zIsLeftToRight;
        this.drawStrategy = HandleDrawStrategyFactory.INSTANCE.createDrawStrategy(this.handleType, this.movingState, this.isMovingEnabled, zIsLeftToRight);
        setScaledParameters();
        if (handleDrawInfo.getCharForAnimation() == null) {
            updateRectAndDrawable(handleDrawInfo);
            return;
        }
        Rect defaultRectForAnimation = this.drawStrategy.getDefaultRectForAnimation(handleDrawInfo, this.scaledDrawableWidth, this.scaledDrawableHeight);
        int iFindHandleVisibleRotationAngle = findHandleVisibleRotationAngle(handleDrawInfo.getCharForAnimation().getPoly(), defaultRectForAnimation);
        View view = this.teView;
        if (view != null) {
            showHandleAnimation(this.drawable, this.drawAreaRect, defaultRectForAnimation, this.rotationAngle, iFindHandleVisibleRotationAngle, view, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.Handle$updateHandle$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.updateRectAndDrawable(handleDrawInfo);
                }
            });
        }
    }

    public final void updateMovingState(@NotNull MovingState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        this.movingState = newState;
        this.isMagnifyHandle = newState != MovingState.IDLE;
    }
}
