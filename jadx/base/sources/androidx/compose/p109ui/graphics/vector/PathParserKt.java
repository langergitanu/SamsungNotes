package androidx.compose.p109ui.graphics.vector;

import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.vector.PathNode;
import androidx.compose.runtime.AbstractC1974b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001aX\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u001a\u0010\u001a\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u001a\r\u0010\u001e\u001a\u00020\t*\u00020\tH\u0082\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, m13886d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "arcToBezier", "", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "toPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "toRadians", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPathParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathParser.kt\nandroidx/compose/ui/graphics/vector/PathParserKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,589:1\n588#1:596\n33#2,6:590\n*S KotlinDebug\n*F\n+ 1 PathParser.kt\nandroidx/compose/ui/graphics/vector/PathParserKt\n*L\n441#1:596\n211#1:590,6\n*E\n"})
public final class PathParserKt {

    @NotNull
    private static final float[] EmptyArray = new float[0];

    private static final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d9 * d10) / 3.141592653589793d));
        double dCos = Math.cos(d7);
        double dSin = Math.sin(d7);
        double dCos2 = Math.cos(d8);
        double dSin2 = Math.sin(d8);
        double d11 = -d3;
        double d12 = d11 * dCos;
        double d13 = d4 * dSin;
        double d14 = (d12 * dSin2) - (d13 * dCos2);
        double d15 = d11 * dSin;
        double d16 = d4 * dCos;
        double d17 = (dCos2 * d16) + (dSin2 * d15);
        double d18 = d9 / ((double) iCeil);
        double d19 = d17;
        double d20 = d14;
        int i = 0;
        double d21 = d5;
        double d22 = d6;
        double d23 = d8;
        while (i < iCeil) {
            double d24 = d23 + d18;
            double dSin3 = Math.sin(d24);
            double dCos3 = Math.cos(d24);
            int i2 = i;
            double d25 = (((d3 * dCos) * dCos3) + d) - (d13 * dSin3);
            double d26 = d10;
            double d27 = (d16 * dSin3) + (d3 * dSin * dCos3) + d2;
            double d28 = (d12 * dSin3) - (d13 * dCos3);
            double d29 = (dCos3 * d16) + (dSin3 * d15);
            double d30 = d24 - d23;
            int i4 = iCeil;
            double dTan = Math.tan(d30 / ((double) 2));
            double dSqrt = ((Math.sqrt(((3.0d * dTan) * dTan) + d26) - ((double) 1)) * Math.sin(d30)) / ((double) 3);
            path.cubicTo((float) ((d20 * dSqrt) + d21), (float) ((d19 * dSqrt) + d22), (float) (d25 - (dSqrt * d28)), (float) (d27 - (dSqrt * d29)), (float) d25, (float) d27);
            dSin = dSin;
            d18 = d18;
            d21 = d25;
            d22 = d27;
            i = i2 + 1;
            d23 = d24;
            d19 = d29;
            iCeil = i4;
            d20 = d28;
            dCos = dCos;
            d10 = d26;
        }
    }

    private static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = (d7 / ((double) 180)) * 3.141592653589793d;
        double dCos = Math.cos(d10);
        double dSin = Math.sin(d10);
        double dM1308a = AbstractC1974b.m1308a(d2, dSin, d * dCos, d5);
        double dM1308a2 = AbstractC1974b.m1308a(d2, dCos, (-d) * dSin, d6);
        double dM1308a3 = AbstractC1974b.m1308a(d4, dSin, d3 * dCos, d5);
        double dM1308a4 = AbstractC1974b.m1308a(d4, dCos, (-d3) * dSin, d6);
        double d11 = dM1308a - dM1308a3;
        double d12 = dM1308a2 - dM1308a4;
        double d13 = 2;
        double d14 = (dM1308a + dM1308a3) / d13;
        double d15 = (dM1308a2 + dM1308a4) / d13;
        double d16 = (d12 * d12) + (d11 * d11);
        if (d16 == 0.0d) {
            return;
        }
        double d17 = (1.0d / d16) - 0.25d;
        if (d17 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d16) / 1.99999d);
            drawArc(path, d, d2, d3, d4, d5 * dSqrt, d6 * dSqrt, d7, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d17);
        double d18 = d11 * dSqrt2;
        double d19 = dSqrt2 * d12;
        if (z == z2) {
            d8 = d14 - d19;
            d9 = d15 + d18;
        } else {
            d8 = d14 + d19;
            d9 = d15 - d18;
        }
        double dAtan2 = Math.atan2(dM1308a2 - d9, dM1308a - d8);
        double dAtan22 = Math.atan2(dM1308a4 - d9, dM1308a3 - d8) - dAtan2;
        if (z2 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d20 = d8 * d5;
        double d21 = d9 * d6;
        arcToBezier(path, (d20 * dCos) - (d21 * dSin), (d21 * dCos) + (d20 * dSin), d5, d6, d, d2, d10, dAtan2, dAtan22);
    }

    @NotNull
    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    @NotNull
    public static final Path toPath(@NotNull List<? extends PathNode> list, @NotNull Path path) {
        int i;
        float f;
        int i2;
        PathNode pathNode;
        float f4;
        float f5;
        float x12;
        float y1;
        float x2;
        float y2;
        float dy2;
        float f6;
        float f7;
        float dx1;
        float dy1;
        float dx2;
        float dy22;
        float y3;
        float y4;
        float x;
        float x5;
        float y5;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        int iMo18416getFillTypeRgk1Os = path2.mo18416getFillTypeRgk1Os();
        path2.rewind();
        path2.mo18418setFillTypeoQ8Xj4U(iMo18416getFillTypeRgk1Os);
        PathNode pathNode2 = list2.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0);
        int size = list2.size();
        float f8 = 0.0f;
        int i4 = 0;
        float arcStartX = 0.0f;
        float arcStartY = 0.0f;
        float x6 = 0.0f;
        float y6 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        while (i4 < size) {
            PathNode pathNode3 = list2.get(i4);
            if (pathNode3 instanceof PathNode.Close) {
                path2.close();
                i = size;
                f = f8;
                i2 = i4;
                pathNode = pathNode3;
                arcStartX = f9;
                x6 = arcStartX;
                arcStartY = f10;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    x5 = relativeMoveTo.getDx() + x6;
                    y5 = relativeMoveTo.getDy() + y6;
                    path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                } else if (pathNode3 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                    x5 = moveTo.getX();
                    y5 = moveTo.getY();
                    path2.moveTo(moveTo.getX(), moveTo.getY());
                } else {
                    if (pathNode3 instanceof PathNode.RelativeLineTo) {
                        PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                        path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                        x2 = relativeLineTo.getDx() + x6;
                        dy2 = relativeLineTo.getDy();
                    } else {
                        if (pathNode3 instanceof PathNode.LineTo) {
                            PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                            path2.lineTo(lineTo.getX(), lineTo.getY());
                            x2 = lineTo.getX();
                            y2 = lineTo.getY();
                        } else {
                            if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                                PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                                path2.relativeLineTo(relativeHorizontalTo.getDx(), f8);
                                x = relativeHorizontalTo.getDx() + x6;
                            } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                                PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                                path2.lineTo(horizontalTo.getX(), y6);
                                x = horizontalTo.getX();
                            } else {
                                if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                                    PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                                    path2.relativeLineTo(f8, relativeVerticalTo.getDy());
                                    y4 = relativeVerticalTo.getDy() + y6;
                                } else if (pathNode3 instanceof PathNode.VerticalTo) {
                                    PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                                    path2.lineTo(x6, verticalTo.getY());
                                    y4 = verticalTo.getY();
                                } else {
                                    if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                                        PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                                        path2.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                                        dx1 = relativeCurveTo.getDx2() + x6;
                                        dy1 = relativeCurveTo.getDy2() + y6;
                                        dx2 = relativeCurveTo.getDx3() + x6;
                                        dy22 = relativeCurveTo.getDy3();
                                    } else if (pathNode3 instanceof PathNode.CurveTo) {
                                        PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                                        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                        dx1 = curveTo.getX2();
                                        dy1 = curveTo.getY2();
                                        dx2 = curveTo.getX3();
                                        y3 = curveTo.getY3();
                                        x6 = dx2;
                                        y6 = y3;
                                        i = size;
                                        f = f8;
                                        i2 = i4;
                                        pathNode = pathNode3;
                                        arcStartX = dx1;
                                        arcStartY = dy1;
                                        i4 = i2 + 1;
                                        path2 = path;
                                        pathNode2 = pathNode;
                                        size = i;
                                        f8 = f;
                                        list2 = list;
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                                        if (pathNode2.getIsCurve()) {
                                            float f11 = x6 - arcStartX;
                                            f7 = y6 - arcStartY;
                                            f6 = f11;
                                        } else {
                                            f6 = f8;
                                            f7 = f6;
                                        }
                                        PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                                        path.relativeCubicTo(f6, f7, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                        dx1 = relativeReflectiveCurveTo.getDx1() + x6;
                                        dy1 = relativeReflectiveCurveTo.getDy1() + y6;
                                        dx2 = relativeReflectiveCurveTo.getDx2() + x6;
                                        dy22 = relativeReflectiveCurveTo.getDy2();
                                    } else {
                                        if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                                            if (pathNode2.getIsCurve()) {
                                                float f12 = 2;
                                                x6 = (x6 * f12) - arcStartX;
                                                y6 = (f12 * y6) - arcStartY;
                                            }
                                            PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                                            path.cubicTo(x6, y6, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                            x12 = reflectiveCurveTo.getX1();
                                            y1 = reflectiveCurveTo.getY1();
                                            float x22 = reflectiveCurveTo.getX2();
                                            float y22 = reflectiveCurveTo.getY2();
                                            x6 = x22;
                                            y6 = y22;
                                        } else if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                                            PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                                            path.relativeQuadraticTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                            arcStartX = relativeQuadTo.getDx1() + x6;
                                            arcStartY = relativeQuadTo.getDy1() + y6;
                                            x2 = relativeQuadTo.getDx2() + x6;
                                            dy2 = relativeQuadTo.getDy2();
                                        } else if (pathNode3 instanceof PathNode.QuadTo) {
                                            PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                            path.quadraticTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                            arcStartX = quadTo.getX1();
                                            arcStartY = quadTo.getY1();
                                            x2 = quadTo.getX2();
                                            y2 = quadTo.getY2();
                                        } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                            if (pathNode2.getIsQuad()) {
                                                f4 = x6 - arcStartX;
                                                f5 = y6 - arcStartY;
                                            } else {
                                                f4 = f8;
                                                f5 = f4;
                                            }
                                            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                            path.relativeQuadraticTo(f4, f5, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                            x12 = f4 + x6;
                                            y1 = f5 + y6;
                                            float dx = relativeReflectiveQuadTo.getDx() + x6;
                                            y6 = relativeReflectiveQuadTo.getDy() + y6;
                                            x6 = dx;
                                        } else {
                                            if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                                if (pathNode2.getIsQuad()) {
                                                    float f13 = 2;
                                                    x6 = (x6 * f13) - arcStartX;
                                                    y6 = (f13 * y6) - arcStartY;
                                                }
                                                PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                                path.quadraticTo(x6, y6, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                                float f14 = x6;
                                                x6 = reflectiveQuadTo.getX();
                                                arcStartX = f14;
                                                i = size;
                                                f = f8;
                                                i2 = i4;
                                                arcStartY = y6;
                                                pathNode = pathNode3;
                                                y6 = reflectiveQuadTo.getY();
                                            } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                                PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                                float arcStartDx = relativeArcTo.getArcStartDx() + x6;
                                                float arcStartDy = relativeArcTo.getArcStartDy() + y6;
                                                f = f8;
                                                pathNode = pathNode3;
                                                i = size;
                                                i2 = i4;
                                                drawArc(path, x6, y6, arcStartDx, arcStartDy, relativeArcTo.getHorizontalEllipseRadius(), relativeArcTo.getVerticalEllipseRadius(), relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                                arcStartX = arcStartDx;
                                                x6 = arcStartX;
                                                arcStartY = arcStartDy;
                                            } else {
                                                i = size;
                                                f = f8;
                                                i2 = i4;
                                                pathNode = pathNode3;
                                                if (pathNode instanceof PathNode.ArcTo) {
                                                    PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                                    drawArc(path, x6, y6, arcTo.getArcStartX(), arcTo.getArcStartY(), arcTo.getHorizontalEllipseRadius(), arcTo.getVerticalEllipseRadius(), arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                                    arcStartX = arcTo.getArcStartX();
                                                    x6 = arcStartX;
                                                    arcStartY = arcTo.getArcStartY();
                                                }
                                            }
                                            i4 = i2 + 1;
                                            path2 = path;
                                            pathNode2 = pathNode;
                                            size = i;
                                            f8 = f;
                                            list2 = list;
                                        }
                                        i = size;
                                        f = f8;
                                        i2 = i4;
                                        pathNode = pathNode3;
                                        arcStartY = y1;
                                        arcStartX = x12;
                                        i4 = i2 + 1;
                                        path2 = path;
                                        pathNode2 = pathNode;
                                        size = i;
                                        f8 = f;
                                        list2 = list;
                                    }
                                    y3 = dy22 + y6;
                                    x6 = dx2;
                                    y6 = y3;
                                    i = size;
                                    f = f8;
                                    i2 = i4;
                                    pathNode = pathNode3;
                                    arcStartX = dx1;
                                    arcStartY = dy1;
                                    i4 = i2 + 1;
                                    path2 = path;
                                    pathNode2 = pathNode;
                                    size = i;
                                    f8 = f;
                                    list2 = list;
                                }
                                y6 = y4;
                                i = size;
                                f = f8;
                                i2 = i4;
                                pathNode = pathNode3;
                                i4 = i2 + 1;
                                path2 = path;
                                pathNode2 = pathNode;
                                size = i;
                                f8 = f;
                                list2 = list;
                            }
                            x6 = x;
                            i = size;
                            f = f8;
                            i2 = i4;
                            pathNode = pathNode3;
                            i4 = i2 + 1;
                            path2 = path;
                            pathNode2 = pathNode;
                            size = i;
                            f8 = f;
                            list2 = list;
                        }
                        y6 = y2;
                        x6 = x2;
                        i = size;
                        f = f8;
                        i2 = i4;
                        pathNode = pathNode3;
                        i4 = i2 + 1;
                        path2 = path;
                        pathNode2 = pathNode;
                        size = i;
                        f8 = f;
                        list2 = list;
                    }
                    y2 = dy2 + y6;
                    y6 = y2;
                    x6 = x2;
                    i = size;
                    f = f8;
                    i2 = i4;
                    pathNode = pathNode3;
                    i4 = i2 + 1;
                    path2 = path;
                    pathNode2 = pathNode;
                    size = i;
                    f8 = f;
                    list2 = list;
                }
                x6 = x5;
                f9 = x6;
                y6 = y5;
                f10 = y6;
                i = size;
                f = f8;
                i2 = i4;
                pathNode = pathNode3;
                i4 = i2 + 1;
                path2 = path;
                pathNode2 = pathNode;
                size = i;
                f8 = f;
                list2 = list;
            }
            y6 = arcStartY;
            i4 = i2 + 1;
            path2 = path;
            pathNode2 = pathNode;
            size = i;
            f8 = f;
            list2 = list;
        }
        return path;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    private static final double toRadians(double d) {
        return (d / ((double) 180)) * 3.141592653589793d;
    }
}
