package com.samsung.android.support.senl.docscan.rectify.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.rectify.util.RectifyUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001&B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0014J0\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0014J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0014J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mContract", "Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyImageView$Contract;", "mIsDrawLine", "", "init", "", "setContract", "contract", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "setDrawLine", "isDrawLine", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "createRectifyArea", "Landroid/graphics/Bitmap;", "Contract", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RectifyImageView extends ImageView {

    @Nullable
    private Contract mContract;
    private boolean mIsDrawLine;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\nH&R\u0012\u0010\u0006\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyImageView$Contract;", "", "getVertexFromIndex", "Landroid/graphics/PointF;", "index", "", "numOfAngle", "getNumOfAngle", "()I", "onMeasured", "", "width", "", "height", "onLayout", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        int getNumOfAngle();

        @Nullable
        PointF getVertexFromIndex(int index);

        void onLayout();

        void onMeasured(float width, float height);
    }

    public RectifyImageView(@Nullable Context context) {
        super(context);
        init();
    }

    private final Bitmap createRectifyArea() {
        if (this.mContract == null) {
            return null;
        }
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0.0f || measuredHeight <= 0.0f) {
            return null;
        }
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        int numOfAngle = contract.getNumOfAngle();
        PointF[] pointFArr = new PointF[numOfAngle];
        for (int i = 0; i < numOfAngle; i++) {
            RectifyUtil rectifyUtil = RectifyUtil.INSTANCE;
            Contract contract2 = this.mContract;
            Intrinsics.checkNotNull(contract2);
            PointF vertexFromIndex = contract2.getVertexFromIndex(i);
            Intrinsics.checkNotNull(vertexFromIndex);
            pointFArr[i] = rectifyUtil.getRealPositionFromRatio(vertexFromIndex, 0.0f, 0.0f, measuredWidth, measuredHeight, 0.0f);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) measuredWidth, (int) measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        int i2 = 1;
        Paint paint = new Paint(1);
        paint.setColor(getContext().getColor(C7976R.color.detect_highlight_color));
        paint.setStrokeWidth(getResources().getDimension(C7976R.dimen.rectify_area_line_width));
        int i4 = 0;
        while (i4 < numOfAngle) {
            PointF pointF = pointFArr[i4];
            i4++;
            PointF pointF2 = pointFArr[i4 % numOfAngle];
            Intrinsics.checkNotNull(pointF);
            float f = pointF.x;
            float f4 = pointF.y;
            Intrinsics.checkNotNull(pointF2);
            canvasM4740a.drawLine(f, f4, pointF2.x, pointF2.y, paint);
        }
        Paint paint2 = new Paint(1);
        paint2.setColor(Color.argb(128, 0, 0, 0));
        Path path = new Path();
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        PointF pointF3 = pointFArr[0];
        Intrinsics.checkNotNull(pointF3);
        path.moveTo(pointF3.x, pointF3.y);
        if (1 <= numOfAngle) {
            while (true) {
                PointF pointF4 = pointFArr[i2 % numOfAngle];
                Intrinsics.checkNotNull(pointF4);
                path.lineTo(pointF4.x, pointF4.y);
                if (i2 == numOfAngle) {
                    break;
                }
                i2++;
            }
        }
        path.close();
        canvasM4740a.drawPath(path, paint2);
        return bitmapCreateBitmap;
    }

    private final void init() {
        this.mIsDrawLine = true;
    }

    @Override // android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Bitmap bitmapCreateRectifyArea;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.mIsDrawLine && (bitmapCreateRectifyArea = createRectifyArea()) != null) {
            canvas.drawBitmap(bitmapCreateRectifyArea, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Contract contract = this.mContract;
        if (contract != null) {
            Intrinsics.checkNotNull(contract);
            contract.onLayout();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Contract contract = this.mContract;
        if (contract != null) {
            Intrinsics.checkNotNull(contract);
            contract.onMeasured(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void setDrawLine(boolean isDrawLine) {
        this.mIsDrawLine = isDrawLine;
    }

    public RectifyImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RectifyImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public RectifyImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
