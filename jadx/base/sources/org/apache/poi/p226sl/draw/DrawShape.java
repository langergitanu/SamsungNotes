package org.apache.poi.p226sl.draw;

import java.util.Locale;
import org.apache.poi.java.awt.BasicStroke;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.PlaceableShape;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.StrokeStyle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DrawShape implements Drawable {
    protected final Shape<?, ?> shape;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawShape$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C140681 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap;

        static {
            int[] iArr = new int[StrokeStyle.LineCap.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap = iArr;
            try {
                iArr[StrokeStyle.LineCap.ROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap[StrokeStyle.LineCap.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap[StrokeStyle.LineCap.FLAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DrawShape(Shape<?, ?> shape) {
        this.shape = shape;
    }

    public static Rectangle2D getAnchor(Graphics2D graphics2D, PlaceableShape<?, ?> placeableShape) {
        return getAnchor(graphics2D, placeableShape.getAnchor());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[PHI: r0
      0x004c: PHI (r0v8 int) = (r0v7 int), (r0v9 int) binds: [B:20:0x0045, B:22:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BasicStroke getStroke(StrokeStyle strokeStyle) {
        float[] fArr;
        int i;
        float lineWidth = (float) strokeStyle.getLineWidth();
        if (lineWidth == 0.0f) {
            lineWidth = 0.25f;
        }
        float f = lineWidth;
        StrokeStyle.LineDash lineDash = strokeStyle.getLineDash();
        if (lineDash == null) {
            lineDash = StrokeStyle.LineDash.SOLID;
        }
        int[] iArr = lineDash.pattern;
        if (iArr != null) {
            fArr = new float[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                fArr[i2] = Math.max(1.0f, f) * iArr[i2];
            }
        } else {
            fArr = null;
        }
        float[] fArr2 = fArr;
        StrokeStyle.LineCap lineCap = strokeStyle.getLineCap();
        if (lineCap == null) {
            lineCap = StrokeStyle.LineCap.FLAT;
        }
        int i4 = C140681.$SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCap[lineCap.ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            i = i4 != 2 ? 0 : i5;
        }
        return new BasicStroke(f, i, 1, f, fArr2, 0.0f);
    }

    public static boolean isHSLF(Shape<?, ?> shape) {
        return shape.getClass().getCanonicalName().toLowerCase(Locale.ROOT).contains("hslf");
    }

    private static double safeScale(double d, double d2) {
        if (d == 0.0d || d2 == 0.0d) {
            return 1.0d;
        }
        return d / d2;
    }

    @Override // org.apache.poi.p226sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
        boolean z;
        PlaceableShape placeableShape;
        AffineTransform affineTransform;
        Rectangle2D rectangle2D;
        AffineTransform affineTransform2;
        double d;
        double dSafeScale;
        Shape<?, ?> shape = this.shape;
        if (shape instanceof PlaceableShape) {
            PlaceableShape placeableShape2 = (PlaceableShape) shape;
            boolean zIsHSLF = isHSLF(shape);
            AffineTransform affineTransform3 = (AffineTransform) graphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM);
            if (affineTransform3 == null) {
                affineTransform3 = new AffineTransform();
            }
            Rectangle2D bounds2D = affineTransform3.createTransformedShape(placeableShape2.getAnchor()).getBounds2D();
            char c = 'r';
            char c2 = 'v';
            char c4 = 'h';
            char[] cArr = new char[3];
            if (zIsHSLF) {
                cArr[0] = 'h';
                cArr[1] = 'v';
                cArr[2] = 'r';
            } else {
                cArr[0] = 'r';
                cArr[1] = 'h';
                cArr[2] = 'v';
            }
            int length = cArr.length;
            int i = 0;
            while (i < length) {
                char c5 = cArr[i];
                char[] cArr2 = cArr;
                double d2 = 1.0d;
                if (c5 != c4) {
                    if (c5 == c) {
                        z = zIsHSLF;
                        placeableShape = placeableShape2;
                        double rotation = placeableShape.getRotation();
                        if (rotation != 0.0d) {
                            double centerX = bounds2D.getCenterX();
                            double centerY = bounds2D.getCenterY();
                            double d3 = rotation % 360.0d;
                            if (d3 < 0.0d) {
                                d3 += 360.0d;
                            }
                            int i2 = ((((int) d3) + 45) / 90) % 4;
                            if (i2 == 1 || i2 == 3) {
                                if (z) {
                                    affineTransform2 = new AffineTransform(affineTransform3);
                                    d = d3;
                                } else {
                                    affineTransform2 = new AffineTransform();
                                    affineTransform2.translate(centerX, centerY);
                                    affineTransform2.rotate(1.5707963267948966d);
                                    d = d3;
                                    affineTransform2.translate(-centerX, -centerY);
                                    affineTransform2.concatenate(affineTransform3);
                                }
                                affineTransform2.translate(centerX, centerY);
                                affineTransform2.rotate(1.5707963267948966d);
                                affineTransform2.translate(-centerX, -centerY);
                                Rectangle2D bounds2D2 = affineTransform2.createTransformedShape(placeableShape.getAnchor()).getBounds2D();
                                double dSafeScale2 = safeScale(bounds2D.getWidth(), bounds2D2.getWidth());
                                dSafeScale = safeScale(bounds2D.getHeight(), bounds2D2.getHeight());
                                d2 = dSafeScale2;
                            } else {
                                d = d3;
                                dSafeScale = 1.0d;
                                i2 = 0;
                            }
                            graphics2D.translate(centerX, centerY);
                            affineTransform = affineTransform3;
                            rectangle2D = bounds2D;
                            double d4 = ((double) i2) * 90.0d;
                            double radians = Math.toRadians(d - d4);
                            if (radians != 0.0d) {
                                graphics2D.rotate(radians);
                            }
                            graphics2D.scale(d2, dSafeScale);
                            double radians2 = Math.toRadians(d4);
                            if (radians2 != 0.0d) {
                                graphics2D.rotate(radians2);
                            }
                            graphics2D.translate(-centerX, -centerY);
                        }
                    } else {
                        if (c5 != c2) {
                            throw new RuntimeException("unexpected transform code " + c5);
                        }
                        if (placeableShape2.getFlipVertical()) {
                            z = zIsHSLF;
                            placeableShape = placeableShape2;
                            graphics2D.translate(bounds2D.getX(), bounds2D.getHeight() + bounds2D.getY());
                            graphics2D.scale(1.0d, -1.0d);
                            graphics2D.translate(-bounds2D.getX(), -bounds2D.getY());
                        } else {
                            z = zIsHSLF;
                            placeableShape = placeableShape2;
                        }
                    }
                    affineTransform = affineTransform3;
                    rectangle2D = bounds2D;
                } else {
                    z = zIsHSLF;
                    placeableShape = placeableShape2;
                    affineTransform = affineTransform3;
                    rectangle2D = bounds2D;
                    if (placeableShape.getFlipHorizontal()) {
                        graphics2D.translate(rectangle2D.getWidth() + rectangle2D.getX(), rectangle2D.getY());
                        graphics2D.scale(-1.0d, 1.0d);
                        graphics2D.translate(-rectangle2D.getX(), -rectangle2D.getY());
                    }
                }
                i++;
                affineTransform3 = affineTransform;
                cArr = cArr2;
                bounds2D = rectangle2D;
                placeableShape2 = placeableShape;
                zIsHSLF = z;
                c = 'r';
                c2 = 'v';
                c4 = 'h';
            }
        }
    }

    public Shape<?, ?> getShape() {
        return this.shape;
    }

    public static Rectangle2D getAnchor(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        AffineTransform affineTransform;
        return (graphics2D == null || (affineTransform = (AffineTransform) graphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM)) == null || affineTransform.isIdentity()) ? rectangle2D : affineTransform.createTransformedShape(rectangle2D).getBounds2D();
    }

    @Override // org.apache.poi.p226sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.p226sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }
}
