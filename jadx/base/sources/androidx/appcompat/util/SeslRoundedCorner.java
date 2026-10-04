package androidx.appcompat.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.core.graphics.Insets;
import androidx.core.graphics.PathParser;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 23)
public class SeslRoundedCorner {
    public static final int ROUNDED_CORNER_ALL = 15;
    public static final int ROUNDED_CORNER_BOTTOM_LEFT = 4;
    public static final int ROUNDED_CORNER_BOTTOM_RIGHT = 8;
    public static final int ROUNDED_CORNER_NONE = 0;
    public static final int ROUNDED_CORNER_TOP_LEFT = 1;
    public static final int ROUNDED_CORNER_TOP_RIGHT = 2;
    static final String TAG = "SeslRoundedCorner";

    @NonNull
    protected final SeslRoundedChunkingDrawable mBottomLeftRound;

    @ColorInt
    private int mBottomLeftRoundColor;

    @NonNull
    protected final SeslRoundedChunkingDrawable mBottomRightRound;

    @ColorInt
    private int mBottomRightRoundColor;

    @Nullable
    private Insets mInsets;
    final int mRoundRadius;
    final Rect mRoundedCornerBounds;
    int mRoundedCornerMode;

    @NonNull
    protected final SeslRoundedChunkingDrawable mTopLeftRound;

    @ColorInt
    private int mTopLeftRoundColor;

    @NonNull
    protected final SeslRoundedChunkingDrawable mTopRightRound;

    @ColorInt
    private int mTopRightRoundColor;

    public SeslRoundedCorner(@NonNull Context context) {
        this(context, false);
    }

    private void drawRoundedCornerInternal(Canvas canvas) {
        Rect rect = this.mRoundedCornerBounds;
        int i = rect.left;
        Insets insets = this.mInsets;
        int i2 = i + (insets != null ? insets.left : 0);
        int i4 = rect.right - (insets != null ? insets.right : 0);
        int i5 = rect.top + (insets != null ? insets.top : 0);
        int i6 = rect.bottom - (insets != null ? insets.bottom : 0);
        if ((this.mRoundedCornerMode & 1) != 0) {
            SeslRoundedChunkingDrawable seslRoundedChunkingDrawable = this.mTopLeftRound;
            int i7 = this.mRoundRadius;
            seslRoundedChunkingDrawable.setBounds(i2, i5, i2 + i7, i7 + i5);
            this.mTopLeftRound.draw(canvas);
        }
        if ((this.mRoundedCornerMode & 2) != 0) {
            SeslRoundedChunkingDrawable seslRoundedChunkingDrawable2 = this.mTopRightRound;
            int i8 = this.mRoundRadius;
            seslRoundedChunkingDrawable2.setBounds(i4 - i8, i5, i4, i8 + i5);
            this.mTopRightRound.draw(canvas);
        }
        if ((this.mRoundedCornerMode & 4) != 0) {
            SeslRoundedChunkingDrawable seslRoundedChunkingDrawable3 = this.mBottomLeftRound;
            int i9 = this.mRoundRadius;
            seslRoundedChunkingDrawable3.setBounds(i2, i6 - i9, i9 + i2, i6);
            this.mBottomLeftRound.draw(canvas);
        }
        if ((this.mRoundedCornerMode & 8) != 0) {
            SeslRoundedChunkingDrawable seslRoundedChunkingDrawable4 = this.mBottomRightRound;
            int i10 = this.mRoundRadius;
            seslRoundedChunkingDrawable4.setBounds(i4 - i10, i6 - i10, i4, i6);
            this.mBottomRightRound.draw(canvas);
        }
        int i11 = this.mTopLeftRoundColor;
        if (i11 == this.mTopRightRoundColor && i11 == this.mBottomLeftRoundColor && i11 == this.mBottomRightRoundColor) {
            Paint paint = new Paint();
            paint.setColor(i11);
            Insets insets2 = this.mInsets;
            if (insets2 != null && insets2.top > 0) {
                Insets insets3 = this.mInsets;
                canvas.drawRect(new Rect(i2 - insets3.left, i5 - insets3.top, insets3.right + i4, i5), paint);
            }
            Insets insets4 = this.mInsets;
            if (insets4 != null && insets4.bottom > 0) {
                Insets insets5 = this.mInsets;
                canvas.drawRect(new Rect(i2 - insets5.left, i6, insets5.right + i4, insets5.bottom + i6), paint);
            }
            Insets insets6 = this.mInsets;
            if (insets6 != null && insets6.left > 0) {
                Insets insets7 = this.mInsets;
                canvas.drawRect(new Rect(i2 - insets7.left, i5 - insets7.top, i2, insets7.bottom + i6), paint);
            }
            Insets insets8 = this.mInsets;
            if (insets8 == null || insets8.right <= 0) {
                return;
            }
            Insets insets9 = this.mInsets;
            canvas.drawRect(new Rect(i4, i5 - insets9.top, insets9.right + i4, i6 + insets9.bottom), paint);
        }
    }

    @NonNull
    @Deprecated
    public static Path getSmoothCornerRectPath(float f, float f4, float f5) {
        Log.w(TAG, "This method is deprecated. Use getSmoothCornerRectPath(float, float, float, float, float) instead.");
        return getSmoothCornerRectPath(f, 0.0f, 0.0f, f4, f5);
    }

    private boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    public void drawRoundedCorner(@NonNull Canvas canvas) {
        canvas.getClipBounds(this.mRoundedCornerBounds);
        drawRoundedCornerInternal(canvas);
    }

    @ColorInt
    public int getRoundedCornerColor(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("There is no rounded corner on = " + this);
        }
        if (i == 1 || i == 2 || i == 4 || i == 8) {
            return (i & 1) != 0 ? this.mTopLeftRoundColor : (i & 2) != 0 ? this.mTopRightRoundColor : (i & 4) != 0 ? this.mBottomLeftRoundColor : this.mBottomRightRoundColor;
        }
        throw new IllegalArgumentException("Use multiple rounded corner as param on = " + this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getRoundedCornerRadius() {
        return this.mRoundRadius;
    }

    public int getRoundedCorners() {
        return this.mRoundedCornerMode;
    }

    public void setRoundedCornerColor(int i, @ColorInt int i2) {
        if (i == 0) {
            throw new IllegalArgumentException("There is no rounded corner on = " + this);
        }
        if ((i & (-16)) != 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Use wrong rounded corners to the param, corners = "));
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN);
        if ((i & 1) != 0) {
            this.mTopLeftRoundColor = i2;
            this.mTopLeftRound.setColorFilter(porterDuffColorFilter);
        }
        if ((i & 2) != 0) {
            this.mTopRightRoundColor = i2;
            this.mTopRightRound.setColorFilter(porterDuffColorFilter);
        }
        if ((i & 4) != 0) {
            this.mBottomLeftRoundColor = i2;
            this.mBottomLeftRound.setColorFilter(porterDuffColorFilter);
        }
        if ((i & 8) != 0) {
            this.mBottomRightRoundColor = i2;
            this.mBottomRightRound.setColorFilter(porterDuffColorFilter);
        }
    }

    public void setRoundedCorners(int i) {
        if ((i & (-16)) != 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Use wrong rounded corners to the param, corners = "));
        }
        this.mRoundedCornerMode = i;
    }

    public SeslRoundedCorner(@NonNull Context context, boolean z) {
        int color;
        this.mRoundedCornerBounds = new Rect();
        this.mInsets = null;
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C0419R.dimen.sesl_rounded_corner_radius);
        this.mRoundRadius = dimensionPixelSize;
        boolean zIsLightTheme = SeslMisc.isLightTheme(context);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0419R.attr.roundedCornerColor, typedValue, true);
        if (typedValue.resourceId > 0 && isColorType(typedValue.type)) {
            color = resources.getColor(typedValue.resourceId);
        } else if (typedValue.data <= 0 || !isColorType(typedValue.type)) {
            color = resources.getColor(!zIsLightTheme ? C0419R.color.sesl_round_and_bgcolor_dark : C0419R.color.sesl_round_and_bgcolor_light);
        } else {
            color = typedValue.data;
        }
        this.mBottomRightRoundColor = color;
        this.mBottomLeftRoundColor = color;
        this.mTopRightRoundColor = color;
        this.mTopLeftRoundColor = color;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
        SeslRoundedChunkingDrawable seslRoundedChunkingDrawable = new SeslRoundedChunkingDrawable(dimensionPixelSize, paint, 0.0f);
        this.mTopLeftRound = seslRoundedChunkingDrawable;
        seslRoundedChunkingDrawable.setColorFilter(porterDuffColorFilter);
        SeslRoundedChunkingDrawable seslRoundedChunkingDrawable2 = new SeslRoundedChunkingDrawable(dimensionPixelSize, paint, 90.0f);
        this.mTopRightRound = seslRoundedChunkingDrawable2;
        seslRoundedChunkingDrawable2.setColorFilter(porterDuffColorFilter);
        SeslRoundedChunkingDrawable seslRoundedChunkingDrawable3 = new SeslRoundedChunkingDrawable(dimensionPixelSize, paint, 270.0f);
        this.mBottomLeftRound = seslRoundedChunkingDrawable3;
        seslRoundedChunkingDrawable3.setColorFilter(porterDuffColorFilter);
        SeslRoundedChunkingDrawable seslRoundedChunkingDrawable4 = new SeslRoundedChunkingDrawable(dimensionPixelSize, paint, 180.0f);
        this.mBottomRightRound = seslRoundedChunkingDrawable4;
        seslRoundedChunkingDrawable4.setColorFilter(porterDuffColorFilter);
    }

    @NonNull
    public static Path getSmoothCornerRectPath(float f, float f4, float f5, float f6, float f7, int i) {
        float f8;
        float f9;
        float f10;
        float f11;
        Path path = new Path();
        if (f6 <= 0.0f || f7 <= 0.0f) {
            return new Path();
        }
        if (i == 0) {
            path.addRect(f4, f5, f4 + f6, f5 + f7, Path.Direction.CW);
            return path;
        }
        float f12 = f6 / 2.0f;
        float f13 = f7 / 2.0f;
        float fMin = Math.min(f12, f13);
        float fMin2 = Math.min(Math.max(f, 0.0f), fMin);
        float f14 = fMin2 / fMin;
        float fMin3 = f14 > 0.5f ? 1.0f - (Math.min(1.0f, (f14 - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin4 = ((double) f14) > 0.6d ? 1.0f + (Math.min(1.0f, (f14 - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        if ((i & 2) != 0) {
            path.moveTo(f4 + f12, f5);
            float f15 = fMin2 / 100.0f;
            float f16 = f15 * 128.19f * fMin3;
            path.lineTo(Math.max(f12, f6 - f16) + f4, f5);
            float f17 = f4 + f6;
            float f18 = f15 * 83.62f * fMin4;
            float f19 = f15 * 67.45f;
            float f20 = f15 * 4.64f;
            float f21 = f15 * 51.16f;
            float f22 = f15 * 13.36f;
            f9 = 22.07f;
            path.cubicTo(f17 - f18, f5, f17 - f19, f5 + f20, f17 - f21, f5 + f22);
            float f23 = f15 * 34.86f;
            float f24 = f15 * 22.07f;
            f8 = 34.86f;
            f10 = f5;
            path.cubicTo(f17 - f23, f5 + f24, f17 - f24, f5 + f23, f17 - f22, f5 + f21);
            path.cubicTo(f17 - f20, f10 + f19, f17, f10 + f18, f17, Math.min(f13, f16) + f10);
        } else {
            f8 = 34.86f;
            f9 = 22.07f;
            f10 = f5;
            path.moveTo(f4 + f12, f10);
            path.lineTo(f4 + f6, f10);
        }
        if ((i & 8) != 0) {
            float f25 = f4 + f6;
            float f26 = fMin2 / 100.0f;
            float f27 = f26 * 128.19f * fMin3;
            path.lineTo(f25, Math.max(f13, f7 - f27) + f10);
            float f28 = f10 + f7;
            float f29 = f26 * 83.62f * fMin4;
            float f30 = f26 * 4.64f;
            float f31 = f26 * 67.45f;
            float f32 = f26 * 13.36f;
            float f33 = f26 * 51.16f;
            path.cubicTo(f25, f28 - f29, f25 - f30, f28 - f31, f25 - f32, f28 - f33);
            float f34 = f26 * f9;
            float f35 = f26 * f8;
            path.cubicTo(f25 - f34, f28 - f35, f25 - f35, f28 - f34, f25 - f33, f28 - f32);
            path.cubicTo(f25 - f31, f28 - f30, f25 - f29, f28, Math.max(f12, f6 - f27) + f4, f28);
        } else {
            path.lineTo(f4 + f6, f10 + f7);
        }
        if ((i & 4) != 0) {
            float f36 = fMin2 / 100.0f;
            float f37 = f36 * 128.19f * fMin3;
            float f38 = f10 + f7;
            path.lineTo(Math.min(f12, f37) + f4, f38);
            float f39 = f36 * 83.62f * fMin4;
            float f40 = f36 * 67.45f;
            float f41 = f36 * 4.64f;
            float f42 = f36 * 51.16f;
            float f43 = f36 * 13.36f;
            path.cubicTo(f4 + f39, f38, f4 + f40, f38 - f41, f4 + f42, f38 - f43);
            float f44 = f36 * f8;
            float f45 = f36 * f9;
            path.cubicTo(f4 + f44, f38 - f45, f4 + f45, f38 - f44, f4 + f43, f38 - f42);
            path.cubicTo(f4 + f41, f38 - f40, f4, f38 - f39, f4, Math.max(f13, f7 - f37) + f10);
            f11 = f4;
        } else {
            f11 = f4;
            path.lineTo(f11, f10 + f7);
        }
        if ((i & 1) != 0) {
            float f46 = fMin2 / 100.0f;
            float f47 = fMin3 * 128.19f * f46;
            path.lineTo(f11, Math.min(f13, f47) + f10);
            float f48 = 83.62f * f46 * fMin4;
            float f49 = 4.64f * f46;
            float f50 = 67.45f * f46;
            float f51 = 13.36f * f46;
            float f52 = 51.16f * f46;
            path.cubicTo(f11, f10 + f48, f11 + f49, f10 + f50, f11 + f51, f10 + f52);
            float f53 = f11;
            float f54 = f46 * f9;
            float f55 = f46 * f8;
            path.cubicTo(f53 + f54, f10 + f55, f53 + f55, f10 + f54, f53 + f52, f10 + f51);
            path.cubicTo(f53 + f50, f10 + f49, f53 + f48, f10, Math.min(f12, f47) + f53, f5);
        } else {
            path.lineTo(f11, f10);
        }
        path.close();
        return path;
    }

    public void drawRoundedCorner(@NonNull View view, @NonNull Canvas canvas) {
        int left;
        int top;
        if (view.getTranslationY() != 0.0f) {
            left = Math.round(view.getX());
            top = Math.round(view.getY());
            canvas.translate((view.getX() - left) + 0.5f, (view.getY() - top) + 0.5f);
        } else {
            left = view.getLeft();
            top = view.getTop();
        }
        this.mRoundedCornerBounds.set(left, top, view.getWidth() + left, view.getHeight() + top);
        drawRoundedCornerInternal(canvas);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SeslRoundedChunkingDrawable extends Drawable {
        private final float mAngle;
        private ColorFilter mColorFilter;
        private final Paint mPaint;
        private final int mRoundRadius;
        private PathParser.PathDataNode[] mPathDataNodes = null;
        private final Path mPath = new Path();

        public SeslRoundedChunkingDrawable(int i, @NonNull Paint paint, float f) {
            this.mRoundRadius = i;
            this.mPaint = paint;
            this.mAngle = f;
        }

        private Path getSmoothCornerRectPath(float f, int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                return new Path();
            }
            float f4 = i;
            float f5 = i2;
            float fMin = Math.min(f4 / 2.0f, f5 / 2.0f);
            float fMin2 = Math.min(Math.max(f, 0.0f), fMin);
            float f6 = fMin2 / fMin;
            return getSmoothCornerRectPath(fMin2, f4, f5, f6 > 0.5f ? 1.0f - (Math.min(1.0f, (f6 - 0.5f) / 0.4f) * 0.13877845f) : 1.0f, ((double) f6) > 0.6d ? 1.0f + (Math.min(1.0f, (f6 - 0.6f) / 0.3f) * 0.042454004f) : 1.0f);
        }

        private Path getTopLeftSmoothCornerPath(float f, float f4, float f5, float f6, float f7) {
            SeslRoundedChunkingDrawable seslRoundedChunkingDrawable;
            Float fValueOf = Float.valueOf(34.86f);
            Float fValueOf2 = Float.valueOf(22.07f);
            Float fValueOf3 = Float.valueOf(51.16f);
            Float fValueOf4 = Float.valueOf(13.36f);
            Float fValueOf5 = Float.valueOf(67.45f);
            Float fValueOf6 = Float.valueOf(4.64f);
            Float fValueOf7 = Float.valueOf(0.0f);
            if (this.mPathDataNodes == null) {
                float f8 = ((f4 / 2.0f) / f) * 100.0f;
                Locale locale = Locale.ENGLISH;
                float f9 = f6 * 128.19f;
                String str = String.format(locale, "L %f %f ", fValueOf7, Float.valueOf(Math.min(((f5 / 2.0f) / f) * 100.0f, f9)));
                float f10 = f7 * 83.62f;
                String str2 = String.format(locale, "C %f %f %f %f %f %f ", fValueOf7, Float.valueOf(f10), fValueOf6, fValueOf5, fValueOf4, fValueOf3);
                String str3 = String.format(locale, "C %f %f %f %f %f %f ", fValueOf2, fValueOf, fValueOf, fValueOf2, fValueOf3, fValueOf4);
                String str4 = String.format(locale, "C %f %f %f %f %f %f ", fValueOf5, fValueOf6, Float.valueOf(f10), fValueOf7, Float.valueOf(Math.min(f8, f9)), fValueOf7);
                String str5 = String.format(locale, "L %f %f ", Float.valueOf(Math.min(f8, f9)), fValueOf7);
                StringBuilder sbM16m = AbstractC0000a.m16m("M 0 0 ", str, str2, str3, str4);
                sbM16m.append(str5);
                sbM16m.append("Z");
                seslRoundedChunkingDrawable = this;
                seslRoundedChunkingDrawable.mPathDataNodes = PathParser.createNodesFromPathData(sbM16m.toString());
            } else {
                seslRoundedChunkingDrawable = this;
            }
            seslRoundedChunkingDrawable.mPath.reset();
            PathParser.PathDataNode.nodesToPath(seslRoundedChunkingDrawable.mPathDataNodes, seslRoundedChunkingDrawable.mPath);
            return seslRoundedChunkingDrawable.mPath;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            this.mPaint.setColorFilter(this.mColorFilter);
            canvas.drawPath(getSmoothCornerRectPath(this.mRoundRadius, canvas.getWidth(), canvas.getHeight()), this.mPaint);
        }

        @Override // android.graphics.drawable.Drawable
        @Nullable
        public ColorFilter getColorFilter() {
            return this.mColorFilter;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mPaint.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.mColorFilter = colorFilter;
        }

        public Path getSmoothCornerRectPath(float f, float f4, float f5, float f6, float f7) {
            Path topLeftSmoothCornerPath = getTopLeftSmoothCornerPath(f, f4, f5, f6, f7);
            Matrix matrix = new Matrix();
            float f8 = f / 100.0f;
            matrix.setScale(f8, f8);
            topLeftSmoothCornerPath.transform(matrix);
            Rect bounds = getBounds();
            Matrix matrix2 = new Matrix();
            matrix2.setRotate(this.mAngle, bounds.width() / 2.0f, bounds.height() / 2.0f);
            topLeftSmoothCornerPath.transform(matrix2);
            Matrix matrix3 = new Matrix();
            matrix3.setTranslate(bounds.left, bounds.top);
            topLeftSmoothCornerPath.transform(matrix3);
            return topLeftSmoothCornerPath;
        }
    }

    public void drawRoundedCorner(@NonNull Canvas canvas, @Nullable Insets insets) {
        this.mInsets = insets;
        drawRoundedCorner(canvas);
    }

    public void drawRoundedCorner(@NonNull Rect rect, @NonNull Canvas canvas) {
        this.mRoundedCornerBounds.set(rect);
        drawRoundedCornerInternal(canvas);
    }

    @NonNull
    public static Path getSmoothCornerRectPath(float f, float f4, float f5, float f6, float f7) {
        return getSmoothCornerRectPath(f, f4, f5, f6, f7, 15);
    }
}
