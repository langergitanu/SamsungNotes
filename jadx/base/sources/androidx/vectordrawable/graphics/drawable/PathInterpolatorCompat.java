package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;

    /* JADX INFO: renamed from: mX */
    private float[] f1709mX;

    /* JADX INFO: renamed from: mY */
    private float[] f1710mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void initCubic(float f, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f4, f5, f6, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1166l("The Path has a invalid length ", length));
        }
        this.f1709mX = new float[iMin];
        this.f1710mY = new float[iMin];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < iMin; i2++) {
            pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
            this.f1709mX[i2] = fArr[0];
            this.f1710mY[i2] = fArr[1];
        }
        if (Math.abs(this.f1709mX[0]) <= 1.0E-5d && Math.abs(this.f1710mY[0]) <= 1.0E-5d) {
            int i4 = iMin - 1;
            if (Math.abs(this.f1709mX[i4] - 1.0f) <= 1.0E-5d && Math.abs(this.f1710mY[i4] - 1.0f) <= 1.0E-5d) {
                float f = 0.0f;
                int i5 = 0;
                while (i < iMin) {
                    float[] fArr2 = this.f1709mX;
                    int i6 = i5 + 1;
                    float f4 = fArr2[i5];
                    if (f4 < f) {
                        throw new IllegalArgumentException(AbstractC0622a.m1166l("The Path cannot loop back on itself, x :", f4));
                    }
                    fArr2[i] = f4;
                    i++;
                    f = f4;
                    i5 = i6;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f1709mX[0]);
        sb.append(",");
        sb.append(this.f1710mY[0]);
        sb.append(" end:");
        int i7 = iMin - 1;
        sb.append(this.f1709mX[i7]);
        sb.append(",");
        sb.append(this.f1710mY[i7]);
        throw new IllegalArgumentException(sb.toString());
    }

    private void initQuad(float f, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f4, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path pathCreatePathFromPathData = PathParser.createPathFromPathData(namedString);
            if (pathCreatePathFromPathData == null) {
                throw new InflateException(AbstractC0541b.m772n("The path is null, which is created from ", namedString));
            }
            initPath(pathCreatePathFromPathData);
            return;
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zHasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
        if (zHasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zHasAttribute) {
            initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            initQuad(namedFloat, namedFloat2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f1709mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f1709mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f1709mX;
        float f4 = fArr[length];
        float f5 = fArr[i];
        float f6 = f4 - f5;
        if (f6 == 0.0f) {
            return this.f1710mY[i];
        }
        float f7 = (f - f5) / f6;
        float[] fArr2 = this.f1710mY;
        float f8 = fArr2[i];
        return AbstractC0000a.m29z(fArr2[length], f8, f7, f8);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(typedArrayObtainAttributes, xmlPullParser);
        typedArrayObtainAttributes.recycle();
    }
}
