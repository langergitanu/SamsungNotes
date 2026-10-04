package com.samsung.android.support.senl.p148nt.composer.main.compare.viewer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\nJ(\u0010\u001e\u001a\u00020\u001f2\u0010\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001cJ\b\u0010#\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0015J\u0006\u0010'\u001a\u00020\u001fR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/viewer/HighLightView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mColorDelete", "", "mColorInsert", "mColorFormat", "mColorBackground", "mPositions", "", "mPathEffect", "mPaint", "Landroid/graphics/Paint;", "mRectFList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "mType", "isEnableDashedLine", "", "getType", "setRectF", "", "rectF", "type", "enableDashedLine", "initPaint", "onDraw", "canvas", "Landroid/graphics/Canvas;", "clear", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HighLightView extends View {
    private boolean isEnableDashedLine;
    private final int mColorBackground;

    @NotNull
    private final int[] mColorDelete;

    @NotNull
    private final int[] mColorFormat;

    @NotNull
    private final int[] mColorInsert;
    private Paint mPaint;

    @NotNull
    private final float[] mPathEffect;

    @NotNull
    private final float[] mPositions;

    @Nullable
    private ArrayList<RectF> mRectFList;
    private int mType;

    public HighLightView(@Nullable Context context) {
        super(context);
        this.mColorDelete = new int[]{-65536, -39424, -3407770};
        this.mColorInsert = new int[]{VUtilString.GREEN, -16737793, -16724839};
        this.mColorFormat = new int[]{-256, -26368, -26317};
        this.mColorBackground = 1154272511;
        this.mPositions = new float[]{0.0f, 0.5f, 1.0f};
        this.mPathEffect = new float[]{10.0f, 10.0f};
    }

    private final void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.mPaint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaint");
            paint2 = null;
        }
        paint2.setStrokeWidth(4.0f);
    }

    public final void clear() {
        this.mRectFList = null;
        this.mType = -1;
        invalidate();
    }

    /* JADX INFO: renamed from: getType, reason: from getter */
    public final int getMType() {
        return this.mType;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isEnableDashedLine) {
            DashPathEffect dashPathEffect = new DashPathEffect(this.mPathEffect, 0.0f);
            Paint paint = this.mPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaint");
                paint = null;
            }
            paint.setPathEffect(dashPathEffect);
        }
        ArrayList<RectF> arrayList = this.mRectFList;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ArrayList<RectF> arrayList2 = this.mRectFList;
                Intrinsics.checkNotNull(arrayList2);
                RectF rectF = arrayList2.get(i);
                if (rectF != null) {
                    if (i == 0) {
                        Paint paint2 = new Paint();
                        paint2.setStyle(Paint.Style.FILL);
                        paint2.setColor(this.mColorBackground);
                        canvas.drawRect(new RectF(0.0f, rectF.top, getWidth(), rectF.bottom), paint2);
                    } else {
                        int i2 = this.mType;
                        LinearGradient linearGradient = i2 != 0 ? i2 != 1 ? i2 != 2 ? null : new LinearGradient(0.0f, 0.0f, rectF.right - rectF.left, rectF.bottom - rectF.top, this.mColorFormat, this.mPositions, Shader.TileMode.MIRROR) : new LinearGradient(0.0f, 0.0f, rectF.right - rectF.left, rectF.bottom - rectF.top, this.mColorDelete, this.mPositions, Shader.TileMode.MIRROR) : new LinearGradient(0.0f, 0.0f, rectF.right - rectF.left, rectF.bottom - rectF.top, this.mColorInsert, this.mPositions, Shader.TileMode.MIRROR);
                        if (linearGradient != null) {
                            Paint paint3 = this.mPaint;
                            if (paint3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPaint");
                                paint3 = null;
                            }
                            paint3.setShader(linearGradient);
                            Paint paint4 = this.mPaint;
                            if (paint4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPaint");
                                paint4 = null;
                            }
                            canvas.drawRoundRect(rectF, 5.0f, 5.0f, paint4);
                        }
                    }
                }
            }
        }
    }

    public final void setRectF(@Nullable ArrayList<RectF> rectF, int type, boolean enableDashedLine) {
        this.mRectFList = rectF;
        this.mType = type;
        this.isEnableDashedLine = enableDashedLine;
    }

    public HighLightView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HighLightView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mColorDelete = new int[]{-65536, -39424, -3407770};
        this.mColorInsert = new int[]{VUtilString.GREEN, -16737793, -16724839};
        this.mColorFormat = new int[]{-256, -26368, -26317};
        this.mColorBackground = 1154272511;
        this.mPositions = new float[]{0.0f, 0.5f, 1.0f};
        this.mPathEffect = new float[]{10.0f, 10.0f};
        initPaint();
    }
}
