package com.samsung.android.sdk.pen.setting;

import android.animation.Animator;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenBrushDropListener;
import com.samsung.android.sdk.pen.setting.SpenBrushMoveObject;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 T2\u00020\u0001:\u0002TUB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010$\u001a\u00020%J.\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bJ\u0010\u0010,\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.J\u000e\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020%2\u0006\u00100\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u000bJ\u0010\u00104\u001a\u00020%2\b\u00105\u001a\u0004\u0018\u000106J\u0006\u00107\u001a\u00020\rJ\u0012\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\"J\b\u0010;\u001a\u00020%H\u0002J\u0018\u0010<\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010=\u001a\u00020\rH\u0002J\u0018\u0010>\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010?\u001a\u00020\rH\u0002J\"\u0010@\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020%H\u0002J\u0010\u0010D\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0013H\u0002J(\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u000209H\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020\u000bH\u0002J\b\u0010O\u001a\u00020%H\u0002J\u0010\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020RH\u0002J\u0010\u0010S\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveControl;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$LongClickListener;", "context", "Landroid/content/Context;", "guideControl", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideControl;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideControl;)V", "mDragAreaDecision", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDragAreaDecision;", "mViewRadius", "", "mIsDragStarted", "", "mNeedUpdatePartner", "mBrushDragListener", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDropListener;", "mGuideControl", "mMovePenObject", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject;", "mMoveColorObject", "mCurrentMoveObject", "mParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mDragShadowBuilder", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDragShadowBuilder;", "mMoveEffect", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveEffect;", "mDragActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDropListener$ActionListener;", "mAnimatorListener", "Landroid/animation/Animator$AnimatorListener;", "onLongClick", "view", "Landroid/view/View;", "moveObject", "close", "", "setControlInfo", "parent", "penView", "colorView", "penAlign", "colorAlign", "setAnimationStrategy", "aniStrategy", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAniStrategy;", "setPenAlign", "align", "setColorAlign", "setChildRadius", "radius", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveControl$ActionListener;", "hasMoveEffect", "decideDragViewSize", "Landroid/graphics/Point;", "targetView", "setGuideLayout", "endAction", "result", "restoreViewScale", "visible", "updatePositionChanged", "toAlign", "partnerAlignment", "prepareToDrag", "startDrag", "makeShadowBuilder", CoeditServiceConstants.Element.NAME_OBJECT, "readyToDrag", "isDragPen", "currentAlign", "size", TypedValues.Cycle.S_WAVE_OFFSET, "getDragArea", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDragArea;", "regionAlign", "endDrag", "updateAnimationViewPos", "current", "Landroid/graphics/Rect;", "cancelDrag", "Companion", "ActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenBrushMoveControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenBrushMoveControl.kt\ncom/samsung/android/sdk/pen/setting/SpenBrushMoveControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
public final class SpenBrushMoveControl implements SpenBrushMoveObject.LongClickListener {
    private static final int DEFAULT_GUIDE_BG = Color.parseColor("#50c7c7c7");
    private static final int DELAY_TIME_FOR_ANIMATION_END = 250;

    @NotNull
    private static final String TAG = "SpenBrushMoveControl";

    @NotNull
    private final Animator.AnimatorListener mAnimatorListener;

    @Nullable
    private SpenBrushDropListener mBrushDragListener;

    @Nullable
    private SpenBrushMoveObject mCurrentMoveObject;

    @NotNull
    private final SpenBrushDropListener.ActionListener mDragActionListener;

    @NotNull
    private SpenBrushDragAreaDecision mDragAreaDecision;

    @Nullable
    private SpenBrushDragShadowBuilder mDragShadowBuilder;

    @Nullable
    private SpenBrushGuideControl mGuideControl;
    private boolean mIsDragStarted;

    @Nullable
    private SpenBrushMoveObject mMoveColorObject;

    @Nullable
    private SpenBrushMoveEffect mMoveEffect;

    @Nullable
    private SpenBrushMoveObject mMovePenObject;
    private boolean mNeedUpdatePartner;

    @Nullable
    private ConstraintLayout mParent;
    private int mViewRadius;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveControl$ActionListener;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$ActionListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener extends SpenBrushMoveObject.ActionListener {
    }

    public SpenBrushMoveControl(@NotNull Context context, @Nullable SpenBrushGuideControl spenBrushGuideControl) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDragActionListener = new SpenBrushDropListener.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenBrushMoveControl$mDragActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenBrushDropListener.ActionListener
            public void onActionEnded(View view, boolean isHandled) {
                if (this.this$0.mGuideControl == null || view == null) {
                    return;
                }
                this.this$0.endAction(view, isHandled);
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenBrushDropListener.ActionListener
            public void onActionStarted(View view) {
                String string;
                if (view == null || (string = view.toString()) == null) {
                    string = "NULL";
                }
                Log.d("SpenBrushMoveControl", "onActionStarted() view=".concat(string));
                if (view != null) {
                    view.setAlpha(0.0f);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenBrushDropListener.ActionListener
            public void onColorPositionChanged(int align, Rect current) {
                Intrinsics.checkNotNullParameter(current, "current");
                Log.d("SpenBrushMoveControl", "onColorPositionChanged() align=" + align);
                SpenBrushMoveObject spenBrushMoveObject = this.this$0.mMovePenObject;
                if (spenBrushMoveObject != null) {
                    SpenBrushMoveControl spenBrushMoveControl = this.this$0;
                    spenBrushMoveControl.updatePositionChanged(spenBrushMoveControl.mMoveColorObject, align, spenBrushMoveObject.getMAlignment());
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenBrushDropListener.ActionListener
            public void onDragLocationChanged(Rect current) {
                Intrinsics.checkNotNullParameter(current, "current");
                Log.d("SpenBrushMoveControl", "onDragLocationChanged() rect=" + current);
                this.this$0.updateAnimationViewPos(current);
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenBrushDropListener.ActionListener
            public void onPenPositionChanged(int align, Rect current) {
                Intrinsics.checkNotNullParameter(current, "current");
                Log.d("SpenBrushMoveControl", "onPenPositionChanged() align=" + align);
                SpenBrushMoveObject spenBrushMoveObject = this.this$0.mMoveColorObject;
                if (spenBrushMoveObject != null) {
                    int mAlignment = spenBrushMoveObject.getMAlignment();
                    SpenBrushMoveControl spenBrushMoveControl = this.this$0;
                    spenBrushMoveControl.updatePositionChanged(spenBrushMoveControl.mMovePenObject, align, mAlignment);
                }
            }
        };
        this.mAnimatorListener = new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.SpenBrushMoveControl$mAnimatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.d("SpenBrushMoveControl", "onAnimationCancel()");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.this$0.hasMoveEffect()) {
                    SpenBrushMoveObject spenBrushMoveObject = this.this$0.mCurrentMoveObject;
                    if (spenBrushMoveObject != null) {
                        spenBrushMoveObject.notifyActionPositionChanged(this.this$0.mNeedUpdatePartner);
                    }
                    this.this$0.endDrag();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        };
        Log.d(TAG, "SpenBrushMoveControl()");
        this.mGuideControl = spenBrushGuideControl;
        if (spenBrushGuideControl != null) {
            spenBrushGuideControl.setGuideRoundedBackground(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_brush_radius_default), DEFAULT_GUIDE_BG);
        }
        this.mViewRadius = 0;
        this.mDragAreaDecision = new SpenBrushDragAreaDecision();
    }

    private final void cancelDrag(View view) {
        Log.d(TAG, "Drag is canceled.");
        restoreViewScale(view, true);
        endDrag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAction(View view, boolean result) {
        AbstractC4539a.m3208r("endAction() result=", TAG, result);
        if (!result) {
            SpenBrushDropListener spenBrushDropListener = this.mBrushDragListener;
            if (spenBrushDropListener != null) {
                spenBrushDropListener.makeFirstState();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC4199v(this, view, 10), 250L);
            return;
        }
        if (!hasMoveEffect()) {
            view.setAlpha(1.0f);
            endDrag();
        } else if (this.mIsDragStarted) {
            if (this.mMoveEffect != null) {
                restoreViewScale(view, !r5.getIsProcessing());
            }
            this.mIsDragStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endAction$lambda$3(SpenBrushMoveControl spenBrushMoveControl, View view) {
        spenBrushMoveControl.restoreViewScale(view, true);
        SpenBrushMoveObject spenBrushMoveObject = spenBrushMoveControl.mCurrentMoveObject;
        if (spenBrushMoveObject != null) {
            spenBrushMoveObject.notifyActionPositionChanged(true);
        }
        spenBrushMoveControl.endDrag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endDrag() {
        SpenBrushMoveEffect spenBrushMoveEffect;
        AbstractC6670b.m4759t("endDrag() dragFlag=", TAG, this.mIsDragStarted);
        this.mIsDragStarted = false;
        if (hasMoveEffect() && (spenBrushMoveEffect = this.mMoveEffect) != null) {
            spenBrushMoveEffect.endEffect();
        }
        SpenBrushGuideControl spenBrushGuideControl = this.mGuideControl;
        if (spenBrushGuideControl != null) {
            spenBrushGuideControl.setAllChildBgVisibility(false);
        }
        this.mDragShadowBuilder = null;
        this.mCurrentMoveObject = null;
    }

    private final SpenBrushDragArea getDragArea(int regionAlign) {
        SpenBrushMoveObject spenBrushMoveObject;
        SpenBrushMoveObject spenBrushMoveObject2;
        Point[] area;
        boolean z;
        SpenBrushGuideControl spenBrushGuideControl = this.mGuideControl;
        if (spenBrushGuideControl == null || (spenBrushMoveObject = this.mMovePenObject) == null || (spenBrushMoveObject2 = this.mMoveColorObject) == null) {
            return null;
        }
        View penGuideView = spenBrushGuideControl.getPenGuideView(regionAlign);
        View colorGuideView = spenBrushGuideControl.getColorGuideView(regionAlign);
        if (penGuideView == null || colorGuideView == null || (area = this.mDragAreaDecision.getArea(regionAlign)) == null) {
            return null;
        }
        boolean z2 = false;
        if (spenBrushMoveObject.getMAlignment() == regionAlign) {
            z = false;
            z2 = true;
        } else {
            z = false;
        }
        return new SpenBrushDragArea(penGuideView, colorGuideView, z2, spenBrushMoveObject2.getMAlignment() != regionAlign ? z : true, (Point[]) Arrays.copyOf(area, area.length));
    }

    private final boolean makeShadowBuilder(SpenBrushMoveObject object) {
        SpenBrushDragShadowBuilder spenBrushDragShadowBuilder;
        SpenBrushMoveEffect spenBrushMoveEffect;
        SpenBrushGuideControl spenBrushGuideControl = this.mGuideControl;
        Point pointDecideDragViewSize = decideDragViewSize(spenBrushGuideControl != null ? object.getCurrentGuideView(spenBrushGuideControl) : null);
        if (pointDecideDragViewSize == null) {
            Log.d(TAG, "prePareToDrag targetView is null");
            return false;
        }
        this.mDragShadowBuilder = object.makeShadowBuilder(this.mViewRadius);
        Point point = new Point();
        SpenBrushDragShadowBuilder spenBrushDragShadowBuilder2 = this.mDragShadowBuilder;
        if (spenBrushDragShadowBuilder2 != null) {
            spenBrushDragShadowBuilder2.getOffset(point);
        }
        readyToDrag(object == this.mMovePenObject, object.getMAlignment(), pointDecideDragViewSize, point);
        if (hasMoveEffect() && (spenBrushDragShadowBuilder = this.mDragShadowBuilder) != null && (spenBrushMoveEffect = this.mMoveEffect) != null) {
            spenBrushMoveEffect.setShadowBuilder(spenBrushDragShadowBuilder);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareToDrag() {
        SpenBrushMoveObject spenBrushMoveObject = this.mCurrentMoveObject;
        if (spenBrushMoveObject != null) {
            SpenBrushGuideControl spenBrushGuideControl = this.mGuideControl;
            if (spenBrushGuideControl != null) {
                spenBrushGuideControl.setAllChildBgVisibility(true);
            }
            if (makeShadowBuilder(spenBrushMoveObject)) {
                startDrag(spenBrushMoveObject.getMView());
            }
        }
    }

    private final void readyToDrag(boolean isDragPen, int currentAlign, Point size, Point offset) {
        Log.d(TAG, "startDrag() isDragPen=" + isDragPen + " size=" + size + " offset=" + offset + " currentAlign=" + currentAlign);
        this.mIsDragStarted = true;
        if (!this.mDragAreaDecision.makeDecision()) {
            Log.i(TAG, "Not make decision.");
            return;
        }
        Integer[] numArr = {Integer.valueOf(SpenBrushGuideControl.ALIGN_TOP), Integer.valueOf(SpenBrushGuideControl.ALIGN_START), Integer.valueOf(SpenBrushGuideControl.ALIGN_END)};
        SpenBrushDragArea[] spenBrushDragAreaArr = new SpenBrushDragArea[3];
        for (int i = 0; i < 3; i++) {
            SpenBrushDragArea dragArea = getDragArea(numArr[i].intValue());
            spenBrushDragAreaArr[i] = dragArea;
            if (dragArea != null) {
                dragArea.setTarget(isDragPen);
            }
            SpenBrushDragArea spenBrushDragArea = spenBrushDragAreaArr[i];
            if (spenBrushDragArea != null) {
                spenBrushDragArea.startDrag();
            }
        }
        try {
            SpenBrushDropListener spenBrushDropListener = this.mBrushDragListener;
            if (spenBrushDropListener != null) {
                int iIndexOf = CollectionsKt.listOf(Arrays.copyOf(numArr, 3)).indexOf(Integer.valueOf(currentAlign));
                SpenBrushDragArea[] spenBrushDragAreaArr2 = (SpenBrushDragArea[]) ArraysKt.requireNoNulls(spenBrushDragAreaArr);
                spenBrushDropListener.setDragArea(iIndexOf, (SpenBrushDragArea[]) Arrays.copyOf(spenBrushDragAreaArr2, spenBrushDragAreaArr2.length));
            }
        } catch (IllegalArgumentException unused) {
            Log.i(TAG, "dragArea has null element.");
        }
        SpenBrushDropListener spenBrushDropListener2 = this.mBrushDragListener;
        if (spenBrushDropListener2 != null) {
            spenBrushDropListener2.setDragViewInfo(size, offset);
        }
    }

    private final void restoreViewScale(View view, boolean visible) {
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(visible ? 1.0f : 0.0f);
    }

    private final void setGuideLayout() {
        SpenBrushMoveObject spenBrushMoveObject;
        SpenBrushGuideControl spenBrushGuideControl;
        SpenBrushMoveObject spenBrushMoveObject2 = this.mMovePenObject;
        if (spenBrushMoveObject2 == null || (spenBrushMoveObject = this.mMoveColorObject) == null || (spenBrushGuideControl = this.mGuideControl) == null) {
            return;
        }
        spenBrushGuideControl.adjustGuide(spenBrushMoveObject2.getMAlignment(), spenBrushMoveObject.getMAlignment());
    }

    private final void startDrag(View view) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.CharSequence");
        ClipData.Item item = new ClipData.Item((CharSequence) tag);
        if (view.startDrag(new ClipData(view.getTag().toString(), new String[]{"text/plain"}, item), this.mDragShadowBuilder, view, 0)) {
            return;
        }
        Log.d(TAG, "[DRAG] startDrag is impossible.");
        cancelDrag(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAnimationViewPos(Rect current) {
        SpenBrushMoveEffect spenBrushMoveEffect;
        if (hasMoveEffect() && (spenBrushMoveEffect = this.mMoveEffect) != null) {
            spenBrushMoveEffect.updateEffectRect(current);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionChanged(SpenBrushMoveObject moveObject, int toAlign, int partnerAlignment) {
        View currentGuideView;
        SpenBrushMoveEffect spenBrushMoveEffect;
        if (moveObject == null) {
            return;
        }
        int alignment = moveObject.getMAlignment();
        this.mNeedUpdatePartner = alignment == partnerAlignment;
        moveObject.setAlignment(toAlign);
        if (!hasMoveEffect()) {
            moveObject.notifyActionPositionChanged(this.mNeedUpdatePartner);
            return;
        }
        SpenBrushNextMovement nextMovement = moveObject.getNextMovement();
        nextMovement.decideDirection(alignment, toAlign);
        SpenBrushGuideControl spenBrushGuideControl = this.mGuideControl;
        if (spenBrushGuideControl == null || (currentGuideView = moveObject.getCurrentGuideView(spenBrushGuideControl)) == null || (spenBrushMoveEffect = this.mMoveEffect) == null) {
            return;
        }
        spenBrushMoveEffect.startAttachEffect(currentGuideView, nextMovement);
    }

    public final void close() {
        Log.d(TAG, "close()");
        SpenBrushMoveEffect spenBrushMoveEffect = this.mMoveEffect;
        if (spenBrushMoveEffect != null) {
            spenBrushMoveEffect.close();
        }
        this.mMoveEffect = null;
        this.mGuideControl = null;
        SpenBrushDropListener spenBrushDropListener = this.mBrushDragListener;
        if (spenBrushDropListener != null) {
            spenBrushDropListener.close();
        }
        this.mBrushDragListener = null;
        SpenBrushMoveObject spenBrushMoveObject = this.mMovePenObject;
        if (spenBrushMoveObject != null) {
            spenBrushMoveObject.close();
        }
        this.mMovePenObject = null;
        SpenBrushMoveObject spenBrushMoveObject2 = this.mMoveColorObject;
        if (spenBrushMoveObject2 != null) {
            spenBrushMoveObject2.close();
        }
        this.mMoveColorObject = null;
        this.mDragAreaDecision.close();
        this.mParent = null;
    }

    @Nullable
    public final Point decideDragViewSize(@Nullable View targetView) {
        if (targetView == null) {
            return null;
        }
        return new Point((int) (targetView.getWidth() * 1.05f), (int) (targetView.getHeight() * 1.05f));
    }

    public final boolean hasMoveEffect() {
        return this.mMoveEffect != null;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject.LongClickListener
    public boolean onLongClick(@Nullable View view, @Nullable SpenBrushMoveObject moveObject) {
        this.mCurrentMoveObject = moveObject;
        if (moveObject != null) {
            moveObject.notifyActionLongClicked();
        }
        if (!hasMoveEffect()) {
            prepareToDrag();
            return false;
        }
        if (view != null) {
            float rotation = view.getRotation();
            float pivotX = view.getPivotX();
            float pivotY = view.getPivotY();
            int width = view.getWidth();
            int height = view.getHeight();
            StringBuilder sbM1176v = AbstractC0622a.m1176v("+++ view rotation=", rotation, " Pivot[", pivotX, SQLKeyword.COMMA);
            sbM1176v.append(pivotY);
            sbM1176v.append("] size[");
            sbM1176v.append(width);
            sbM1176v.append(SQLKeyword.COMMA);
            sbM1176v.append(height);
            sbM1176v.append("]");
            Log.d(TAG, sbM1176v.toString());
            SpenBrushMoveEffect spenBrushMoveEffect = this.mMoveEffect;
            if (spenBrushMoveEffect != null) {
                spenBrushMoveEffect.beginEffect(view);
            }
        }
        SpenBrushMoveEffect spenBrushMoveEffect2 = this.mMoveEffect;
        if (spenBrushMoveEffect2 == null) {
            return false;
        }
        spenBrushMoveEffect2.startDetachEffect(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.SpenBrushMoveControl.onLongClick.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.d(SpenBrushMoveControl.TAG, "onAnimationEnd() ==============");
                SpenBrushMoveControl.this.prepareToDrag();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        return false;
    }

    public final void setActionListener(@Nullable ActionListener listener) {
        SpenBrushMoveObject spenBrushMoveObject = this.mMovePenObject;
        if (spenBrushMoveObject != null) {
            spenBrushMoveObject.setActionListener(listener);
        }
        SpenBrushMoveObject spenBrushMoveObject2 = this.mMoveColorObject;
        if (spenBrushMoveObject2 != null) {
            spenBrushMoveObject2.setActionListener(listener);
        }
    }

    public final void setAnimationStrategy(@Nullable SpenBrushMoveAniStrategy aniStrategy) {
        if (aniStrategy == null) {
            return;
        }
        ConstraintLayout constraintLayout = this.mParent;
        SpenBrushMoveEffect spenBrushMoveEffect = constraintLayout != null ? new SpenBrushMoveEffect(constraintLayout, aniStrategy) : null;
        this.mMoveEffect = spenBrushMoveEffect;
        if (spenBrushMoveEffect != null) {
            spenBrushMoveEffect.setAttachEffectListener(this.mAnimatorListener);
        }
    }

    public final void setChildRadius(int radius) {
        AbstractC0541b.m755A(radius, "setChildRadius() radius=", TAG);
        SpenBrushGuideControl spenBrushGuideControl = this.mGuideControl;
        if (spenBrushGuideControl != null) {
            spenBrushGuideControl.setGuideRoundedBackground(radius, DEFAULT_GUIDE_BG);
        }
        this.mViewRadius = radius;
    }

    public final void setColorAlign(int align) {
        AbstractC0541b.m755A(align, "setColorAlign() color=", TAG);
        SpenBrushMoveObject spenBrushMoveObject = this.mMoveColorObject;
        if (spenBrushMoveObject != null) {
            spenBrushMoveObject.setAlignment(align);
        }
        setGuideLayout();
    }

    public final void setControlInfo(@NotNull ConstraintLayout parent, @NotNull View penView, @NotNull View colorView, int penAlign, int colorAlign) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(penView, "penView");
        Intrinsics.checkNotNullParameter(colorView, "colorView");
        Log.d(TAG, "setControlInfo() penAlign=" + penAlign + " colorAlign=" + colorAlign);
        this.mParent = parent;
        this.mDragAreaDecision.setParent(parent);
        this.mMovePenObject = new SpenBrushMovePenObject(penView, penAlign, this);
        this.mMoveColorObject = new SpenBrushMoveColorObject(colorView, colorAlign, this);
        this.mCurrentMoveObject = null;
        SpenBrushMoveObject spenBrushMoveObject = this.mMovePenObject;
        String tagName = spenBrushMoveObject != null ? spenBrushMoveObject.getTagName() : null;
        SpenBrushMoveObject spenBrushMoveObject2 = this.mMoveColorObject;
        SpenBrushDropListener spenBrushDropListener = new SpenBrushDropListener(tagName, spenBrushMoveObject2 != null ? spenBrushMoveObject2.getTagName() : null);
        this.mBrushDragListener = spenBrushDropListener;
        spenBrushDropListener.setActionListener(this.mDragActionListener);
        SpenBrushGuideControl spenBrushGuideControl = this.mGuideControl;
        if (spenBrushGuideControl != null) {
            spenBrushGuideControl.setTag();
        }
        parent.setOnDragListener(this.mBrushDragListener);
        setGuideLayout();
    }

    public final void setPenAlign(int align) {
        AbstractC0541b.m755A(align, "setPenAlign() pen=", TAG);
        SpenBrushMoveObject spenBrushMoveObject = this.mMovePenObject;
        if (spenBrushMoveObject != null) {
            spenBrushMoveObject.setAlignment(align);
        }
        setGuideLayout();
    }
}
