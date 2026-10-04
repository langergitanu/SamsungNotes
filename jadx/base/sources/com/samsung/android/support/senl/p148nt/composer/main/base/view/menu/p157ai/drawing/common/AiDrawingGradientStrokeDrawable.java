package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.common;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingGradientStrokeDrawable extends Drawable {
    private int[] mColors;
    private final Path mGradientPath = new Path();
    private Paint mGradientStroke;
    private float[] mPositions;
    private float mRadius;
    private float mWidth;

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.drawPath(this.mGradientPath, this.mGradientStroke);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) {
        this.mColors = resources.getIntArray(C9086R.array.ai_gradient_stroke_colors);
        int[] intArray = resources.getIntArray(C9086R.array.ai_gradient_stroke_positions);
        if (intArray.length > 0) {
            this.mPositions = new float[intArray.length];
            for (int i = 0; i < intArray.length; i++) {
                float[] fArr = this.mPositions;
                fArr[i] = intArray[i] / fArr[intArray.length - 1];
            }
        }
        this.mRadius = resources.getDimension(C9086R.dimen.ai_drawing_style_list_item_radius);
        this.mWidth = resources.getDimension(C9086R.dimen.ai_drawing_style_list_item_selected_border_width);
        Paint paint = new Paint();
        this.mGradientStroke = paint;
        paint.setAntiAlias(true);
        this.mGradientStroke.setStyle(Paint.Style.STROKE);
        this.mGradientStroke.setStrokeWidth(this.mWidth);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        float[] fArr;
        super.onBoundsChange(rect);
        int i = rect.left;
        float f = this.mWidth;
        rect.left = i + ((int) (f / 2.0f));
        rect.top += (int) (f / 2.0f);
        rect.right -= (int) (f / 2.0f);
        rect.bottom -= (int) (f / 2.0f);
        int[] iArr = this.mColors;
        if (iArr == null || (fArr = this.mPositions) == null || iArr.length != fArr.length) {
            this.mGradientStroke.setShader(null);
        } else {
            LinearGradient linearGradient = new LinearGradient(rect.left, rect.top, rect.right, rect.bottom, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setRotate(45.0f, rect.centerX(), rect.centerY());
            linearGradient.setLocalMatrix(matrix);
            this.mGradientStroke.setShader(linearGradient);
        }
        this.mGradientPath.reset();
        Path path = this.mGradientPath;
        RectF rectF = new RectF(rect);
        float f4 = this.mRadius;
        path.addRoundRect(rectF, f4, f4, Path.Direction.CCW);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
