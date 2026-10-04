package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.path;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilMath;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataAngleEllipse;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataAngleEllipseTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataArc;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataArcTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataClockWiseArc;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataClockWiseArcTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataClose;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCurveTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataEllipticalQaudrantX;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataEllipticalQaudrantY;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataEnd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataLineTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataMoveTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataNoFill;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataNoStroke;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataQuadraticbezier;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataRCurveTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataRLineTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataRMoveTo;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawPath {
    public static final int QuarterPositionB = 1;
    public static final int QuarterPositionL = 2;
    public static final int QuarterPositionR = 3;
    public static final int QuarterPositionT = 0;
    public static float currX;
    public static float currY;
    public static float mEx;
    public static float mEy;
    public static float mSx;
    public static float mSy;

    public static Path createPath(ArrayList<VPathDataInfo> arrayList, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        mEy = 0.0f;
        mEx = 0.0f;
        mSy = 0.0f;
        mSx = 0.0f;
        currX = f * f5;
        currY = f4 * f6;
        Path path = new Path();
        if (arrayList == null || arrayList.size() <= 0) {
            createPathDraw(f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
            path = path;
        } else {
            for (VPathDataInfo vPathDataInfo : arrayList) {
                String pathCmd = vPathDataInfo.getPathCmd();
                if (VPathDataCmd.Alias.Quadraticbezier.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataQuadraticbezier) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.EllipticalQaudrantY.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataEllipticalQaudrantY) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.EllipticalQaudrantX.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataEllipticalQaudrantX) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.ClockWiseArc.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataClockWiseArc) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.ClockWiseArcTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataClockWiseArcTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.Arc.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataArc) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.ArcTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataArcTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.AngleEllipse.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataAngleEllipse) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.AngleEllipseTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataAngleEllipseTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.NoStroke.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataNoStroke) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.NoFill.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataNoFill) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.End.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataEnd) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.Close.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataClose) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.RCurveTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataRCurveTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.RLineTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataRLineTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.RMoveTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataRMoveTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.CurveTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataCurveTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.LineTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataLineTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                } else if (VPathDataCmd.Alias.MoveTo.compareToIgnoreCase(pathCmd) == 0) {
                    createPathDraw((VPathDataMoveTo) vPathDataInfo.getPathData(), f, f4, f5, f6, fArr, fArr2, vAttributeCore, vAttributeShape, path);
                }
            }
        }
        mEx = currX;
        mEy = currY;
        return path;
    }

    private static void createPathDraw(VPathDataEnd vPathDataEnd, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
    }

    private static void createPathDraw(VPathDataNoFill vPathDataNoFill, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
    }

    private static void createPathDraw(VPathDataNoStroke vPathDataNoStroke, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
    }

    private static void createPathDraw(float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        path.moveTo(f, f4);
        float width = vAttributeCore.getCoordSize().getWidth();
        float height = vAttributeCore.getCoordSize().getHeight();
        float sx = vAttributeCore.getCoordOrigin().getSx() + f;
        float sy = vAttributeCore.getCoordOrigin().getSy() + f4;
        float f7 = sx * f5;
        float f8 = sy * f6;
        path.addRect(f7, f8, (width + sx) * f5, (height + sy) * f6, Path.Direction.CW);
        currX = f7;
        currY = f8;
    }

    private static void createPathDraw(VPathDataQuadraticbezier vPathDataQuadraticbezier, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataQuadraticbezier.getFullCmd() != null && vPathDataQuadraticbezier.getFullCmd().length() > 0) {
            vPathDataQuadraticbezier.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        float sx = vPathDataQuadraticbezier.getEnd().getSx() + f;
        float sy = vPathDataQuadraticbezier.getEnd().getSy() + f4;
        for (VCommonPoint vCommonPoint : vPathDataQuadraticbezier.getList()) {
            path.quadTo((vCommonPoint.getSx() + f) * f5, (vCommonPoint.getSy() + f4) * f6, sx, sy);
        }
        currX = sx;
        currY = sy;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066 A[PHI: r11
      0x0066: PHI (r11v5 char) = (r11v1 char), (r11v1 char), (r11v7 char), (r11v7 char) binds: [B:35:0x007b, B:36:0x007d, B:23:0x0064, B:20:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[PHI: r11
      0x0068: PHI (r11v3 char) = (r11v1 char), (r11v1 char), (r11v7 char), (r11v7 char) binds: [B:36:0x007d, B:33:0x0077, B:21:0x0060, B:23:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void createPathDraw(VPathDataEllipticalQaudrantY vPathDataEllipticalQaudrantY, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        VPathDataEllipticalQaudrantY vPathDataEllipticalQaudrantY2;
        char c;
        boolean z;
        float f7;
        float f8;
        if (vPathDataEllipticalQaudrantY.getFullCmd() == null || vPathDataEllipticalQaudrantY.getFullCmd().length() <= 0) {
            vPathDataEllipticalQaudrantY2 = vPathDataEllipticalQaudrantY;
        } else {
            vPathDataEllipticalQaudrantY2 = vPathDataEllipticalQaudrantY;
            vPathDataEllipticalQaudrantY2.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        int i = 0;
        for (VCommonPoint vCommonPoint : vPathDataEllipticalQaudrantY2.getList()) {
            float f9 = currX;
            float f10 = currY;
            float sx = (vCommonPoint.getSx() + f) * f5;
            float sy = (vCommonPoint.getSy() + f4) * f6;
            if (i % 2 == 0) {
                c = f9 > sx ? (char) 3 : (char) 2;
                z = (f9 >= sx || f10 >= sy) && (f9 <= sx || f10 <= sy);
            } else {
                c = f10 > sy ? (char) 1 : (char) 0;
                if ((f9 >= sx || f10 >= sy) && (f9 <= sx || f10 <= sy)) {
                }
            }
            float f11 = 270.0f;
            float f12 = 90.0f;
            float f13 = 0.0f;
            if (z) {
                if (c == 0) {
                    f9 -= sx - f9;
                    f13 = sy - (f10 - sy);
                    f8 = sx;
                } else if (c == 1) {
                    f7 = f9 - (sx - f9);
                    f13 = f10;
                    f10 = sy - (f10 - sy);
                    f11 = 90.0f;
                    f8 = f7;
                    f9 = sx;
                } else if (c == 2) {
                    f8 = sx - (f9 - sx);
                    f13 = f10 - (sy - f10);
                    f11 = 180.0f;
                    f10 = sy;
                } else if (c != 3) {
                    f9 = 0.0f;
                    f10 = 0.0f;
                    f8 = 0.0f;
                    f11 = 0.0f;
                } else {
                    f10 -= sy - f10;
                    f8 = f9;
                    f9 = sx - (f9 - sx);
                    f11 = 0.0f;
                    f13 = sy;
                }
            } else if (c == 0) {
                f7 = f9 - (sx - f9);
                f12 = -90.0f;
                f13 = sy - (f10 - sy);
                f8 = f7;
                f9 = sx;
            } else if (c == 1) {
                f9 -= sx - f9;
                f13 = f10;
                f10 = sy - (f10 - sy);
                f11 = 90.0f;
                f12 = -90.0f;
                f8 = sx;
            } else if (c == 2) {
                f10 -= sy - f10;
                f13 = sy;
                f12 = -90.0f;
                f8 = sx - (f9 - sx);
                f11 = 180.0f;
            } else if (c != 3) {
                f12 = -90.0f;
                f9 = 0.0f;
                f10 = 0.0f;
                f8 = 0.0f;
                f11 = 0.0f;
            } else {
                f12 = -90.0f;
                f11 = 0.0f;
                f8 = f9;
                f13 = f10 - (sy - f10);
                f9 = sx - (f9 - sx);
                f10 = sy;
            }
            path.arcTo(new RectF(f9, f10, f8, f13), f11, f12);
            currX = sx;
            currY = sy;
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066 A[PHI: r11
      0x0066: PHI (r11v5 char) = (r11v1 char), (r11v1 char), (r11v7 char), (r11v7 char) binds: [B:34:0x0079, B:36:0x007d, B:23:0x0064, B:20:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[PHI: r11
      0x0068: PHI (r11v3 char) = (r11v1 char), (r11v1 char), (r11v7 char), (r11v7 char) binds: [B:36:0x007d, B:33:0x0077, B:22:0x0062, B:23:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void createPathDraw(VPathDataEllipticalQaudrantX vPathDataEllipticalQaudrantX, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        VPathDataEllipticalQaudrantX vPathDataEllipticalQaudrantX2;
        char c;
        boolean z;
        float f7;
        float f8;
        if (vPathDataEllipticalQaudrantX.getFullCmd() == null || vPathDataEllipticalQaudrantX.getFullCmd().length() <= 0) {
            vPathDataEllipticalQaudrantX2 = vPathDataEllipticalQaudrantX;
        } else {
            vPathDataEllipticalQaudrantX2 = vPathDataEllipticalQaudrantX;
            vPathDataEllipticalQaudrantX2.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        int i = 0;
        for (VCommonPoint vCommonPoint : vPathDataEllipticalQaudrantX2.getList()) {
            float f9 = currX;
            float f10 = currY;
            float sx = (vCommonPoint.getSx() + f) * f5;
            float sy = (vCommonPoint.getSy() + f4) * f6;
            if (i % 2 == 0) {
                c = f10 > sy ? (char) 1 : (char) 0;
                z = (f9 < sx && f10 < sy) || (f9 > sx && f10 > sy);
            } else {
                c = f9 > sx ? (char) 3 : (char) 2;
                if ((f9 >= sx || f10 >= sy) && (f9 <= sx || f10 <= sy)) {
                }
            }
            float f11 = 270.0f;
            float f12 = 90.0f;
            float f13 = 0.0f;
            if (z) {
                if (c == 0) {
                    f9 -= sx - f9;
                    f13 = sy - (f10 - sy);
                    f8 = sx;
                } else if (c == 1) {
                    f7 = f9 - (sx - f9);
                    f13 = f10;
                    f10 = sy - (f10 - sy);
                    f11 = 90.0f;
                    f8 = f7;
                    f9 = sx;
                } else if (c == 2) {
                    f8 = sx - (f9 - sx);
                    f13 = f10 - (sy - f10);
                    f11 = 180.0f;
                    f10 = sy;
                } else if (c != 3) {
                    f9 = 0.0f;
                    f10 = 0.0f;
                    f8 = 0.0f;
                    f11 = 0.0f;
                } else {
                    f10 -= sy - f10;
                    f8 = f9;
                    f9 = sx - (f9 - sx);
                    f11 = 0.0f;
                    f13 = sy;
                }
            } else if (c == 0) {
                f7 = f9 - (sx - f9);
                f12 = -90.0f;
                f13 = sy - (f10 - sy);
                f8 = f7;
                f9 = sx;
            } else if (c == 1) {
                f9 -= sx - f9;
                f13 = f10;
                f10 = sy - (f10 - sy);
                f11 = 90.0f;
                f12 = -90.0f;
                f8 = sx;
            } else if (c == 2) {
                f10 -= sy - f10;
                f13 = sy;
                f12 = -90.0f;
                f8 = sx - (f9 - sx);
                f11 = 180.0f;
            } else if (c != 3) {
                f12 = -90.0f;
                f9 = 0.0f;
                f10 = 0.0f;
                f8 = 0.0f;
                f11 = 0.0f;
            } else {
                f12 = -90.0f;
                f11 = 0.0f;
                f8 = f9;
                f13 = f10 - (sy - f10);
                f9 = sx - (f9 - sx);
                f10 = sy;
            }
            path.arcTo(new RectF(f9, f10, f8, f13), f11, f12);
            currX = sx;
            currY = sy;
            i++;
        }
    }

    private static void createPathDraw(VPathDataClockWiseArc vPathDataClockWiseArc, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        VPathDataClockWiseArc vPathDataClockWiseArc2;
        if (vPathDataClockWiseArc.getFullCmd() == null || vPathDataClockWiseArc.getFullCmd().length() <= 0) {
            vPathDataClockWiseArc2 = vPathDataClockWiseArc;
        } else {
            vPathDataClockWiseArc2 = vPathDataClockWiseArc;
            vPathDataClockWiseArc2.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        Iterator<VPathDataClockWiseArc.Data> it = vPathDataClockWiseArc2.getList().iterator();
        boolean z = false;
        while (it.hasNext()) {
            VPathDataClockWiseArc.Data next = it.next();
            float left = next.getLeft() + f;
            float top = next.getTop() + f4;
            float right = next.getRight() + f;
            float bottom = next.getBottom() + f4;
            float sx = next.getStart().getSx() + f;
            float sy = next.getStart().getSy() + f4;
            float sx2 = next.getEnd().getSx() + f;
            float sy2 = next.getEnd().getSy() + f4;
            float f7 = (right - left) / 2.0f;
            double d = left + f7;
            Iterator<VPathDataClockWiseArc.Data> it2 = it;
            boolean z2 = z;
            double d2 = f7;
            float fM2210a = (float) AbstractC2821a.m2210a(Math.acos((sx - r4) / f7), d2, d);
            double d3 = top + ((bottom - top) / 2.0f);
            float fM5b = (float) AbstractC0000a.m5b(Math.asin((sy - r5) / r7), d2, d3);
            float fCos = (float) ((Math.cos(Math.acos((sx2 - r4) / f7)) * d2) + d);
            float fSin = (float) ((Math.sin(Math.asin((sy2 - r5) / r7)) * d2) + d3);
            double d4 = fM2210a;
            double d5 = fM5b;
            float threePointDegree = (float) VUtilMath.getThreePointDegree(r4 + f7, d3, d, d3, d4, d5, true, 0.0f, true);
            float threePointDegree2 = (float) VUtilMath.getThreePointDegree(d4, d5, d, d3, fCos, fSin, true, threePointDegree, false);
            RectF rectF = new RectF((next.getLeft() + f) * f5, (next.getTop() + f4) * f6, (next.getRight() + f) * f5, (next.getBottom() + f4) * f6);
            float sx3 = (next.getStart().getSx() + f) * f5;
            float sy3 = (next.getStart().getSy() + f4) * f6;
            float sx4 = (next.getEnd().getSx() + f) * f5;
            float sy4 = (next.getEnd().getSy() + f4) * f6;
            if (z2) {
                z = z2;
            } else {
                path.moveTo(sx3, sy3);
                currX = sx3;
                currY = sy3;
                z = true;
            }
            path.arcTo(rectF, threePointDegree, threePointDegree2);
            currX = sx4;
            currY = sy4;
            it = it2;
        }
    }

    private static void createPathDraw(VPathDataClockWiseArcTo vPathDataClockWiseArcTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        VPathDataClockWiseArcTo vPathDataClockWiseArcTo2;
        if (vPathDataClockWiseArcTo.getFullCmd() == null || vPathDataClockWiseArcTo.getFullCmd().length() <= 0) {
            vPathDataClockWiseArcTo2 = vPathDataClockWiseArcTo;
        } else {
            vPathDataClockWiseArcTo2 = vPathDataClockWiseArcTo;
            vPathDataClockWiseArcTo2.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        Iterator<VPathDataClockWiseArcTo.Data> it = vPathDataClockWiseArcTo2.getList().iterator();
        while (it.hasNext()) {
            VPathDataClockWiseArcTo.Data next = it.next();
            float left = next.getLeft() + f;
            float top = next.getTop() + f4;
            float right = next.getRight() + f;
            float bottom = next.getBottom() + f4;
            float sx = next.getStart().getSx() + f;
            float sy = next.getStart().getSy() + f4;
            float sx2 = next.getEnd().getSx() + f;
            float sy2 = next.getEnd().getSy() + f4;
            float f7 = (right - left) / 2.0f;
            float f8 = left + f7;
            double d = f8;
            double d2 = f7;
            float fM2210a = (float) AbstractC2821a.m2210a(Math.acos((sx - f8) / f7), d2, d);
            Iterator<VPathDataClockWiseArcTo.Data> it2 = it;
            double d3 = top + ((bottom - top) / 2.0f);
            float fM5b = (float) AbstractC0000a.m5b(Math.asin((sy - r3) / r5), d2, d3);
            float fCos = (float) ((Math.cos(Math.acos((sx2 - f8) / f7)) * d2) + d);
            float fSin = (float) ((Math.sin(Math.asin((sy2 - r3) / r5)) * d2) + d3);
            double d4 = f8 + f7;
            double d5 = fM2210a;
            double d6 = fM5b;
            float threePointDegree = (float) VUtilMath.getThreePointDegree(d4, d3, d, d3, d5, d6, true, 0.0f, true);
            float threePointDegree2 = (float) VUtilMath.getThreePointDegree(d5, d6, d, d3, fCos, fSin, true, threePointDegree, false);
            RectF rectF = new RectF((next.getLeft() + f) * f5, (next.getTop() + f4) * f6, (next.getRight() + f) * f5, (next.getBottom() + f4) * f6);
            next.getStart().getSx();
            next.getStart().getSy();
            float sx3 = (next.getEnd().getSx() + f) * f5;
            float sy3 = (next.getEnd().getSy() + f4) * f6;
            path.arcTo(rectF, threePointDegree, threePointDegree2);
            currX = sx3;
            currY = sy3;
            it = it2;
        }
    }

    private static void createPathDraw(VPathDataArc vPathDataArc, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        VPathDataArc vPathDataArc2;
        if (vPathDataArc.getFullCmd() == null || vPathDataArc.getFullCmd().length() <= 0) {
            vPathDataArc2 = vPathDataArc;
        } else {
            vPathDataArc2 = vPathDataArc;
            vPathDataArc2.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        Iterator<VPathDataArc.Data> it = vPathDataArc2.getList().iterator();
        boolean z = false;
        while (it.hasNext()) {
            VPathDataArc.Data next = it.next();
            float left = next.getLeft() + f;
            float top = next.getTop() + f4;
            float right = next.getRight() + f;
            float bottom = next.getBottom() + f4;
            float sx = next.getStart().getSx() + f;
            float sy = next.getStart().getSy() + f4;
            float sx2 = next.getEnd().getSx() + f;
            float sy2 = next.getEnd().getSy() + f4;
            float f7 = (right - left) / 2.0f;
            double d = left + f7;
            Iterator<VPathDataArc.Data> it2 = it;
            boolean z2 = z;
            double d2 = f7;
            float fM2210a = (float) AbstractC2821a.m2210a(Math.acos((sx - r4) / f7), d2, d);
            double d3 = top + ((bottom - top) / 2.0f);
            float fM5b = (float) AbstractC0000a.m5b(Math.asin((sy - r5) / r7), d2, d3);
            float fCos = (float) ((Math.cos(Math.acos((sx2 - r4) / f7)) * d2) + d);
            float fSin = (float) ((Math.sin(Math.asin((sy2 - r5) / r7)) * d2) + d3);
            double d4 = fM2210a;
            double d5 = fM5b;
            float threePointDegree = (float) VUtilMath.getThreePointDegree(r4 + f7, d3, d, d3, d4, d5, true, 0.0f, true);
            float threePointDegree2 = (float) VUtilMath.getThreePointDegree(d4, d5, d, d3, fCos, fSin, false, threePointDegree, false);
            RectF rectF = new RectF((next.getLeft() + f) * f5, (next.getTop() + f4) * f6, (next.getRight() + f) * f5, (next.getBottom() + f4) * f6);
            float sx3 = (next.getStart().getSx() + f) * f5;
            float sy3 = (next.getStart().getSy() + f4) * f6;
            float sx4 = (next.getEnd().getSx() + f) * f5;
            float sy4 = (next.getEnd().getSy() + f4) * f6;
            if (z2) {
                z = z2;
            } else {
                path.moveTo(sx3, sy3);
                currX = sx3;
                currY = sy3;
                z = true;
            }
            path.arcTo(rectF, threePointDegree, threePointDegree2);
            currX = sx4;
            currY = sy4;
            it = it2;
        }
    }

    private static void createPathDraw(VPathDataArcTo vPathDataArcTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        VPathDataArcTo vPathDataArcTo2;
        if (vPathDataArcTo.getFullCmd() == null || vPathDataArcTo.getFullCmd().length() <= 0) {
            vPathDataArcTo2 = vPathDataArcTo;
        } else {
            vPathDataArcTo2 = vPathDataArcTo;
            vPathDataArcTo2.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        Iterator<VPathDataArcTo.Data> it = vPathDataArcTo2.getList().iterator();
        while (it.hasNext()) {
            VPathDataArcTo.Data next = it.next();
            float left = next.getLeft() + f;
            float top = next.getTop() + f4;
            float right = next.getRight() + f;
            float bottom = next.getBottom() + f4;
            float sx = next.getStart().getSx() + f;
            float sy = next.getStart().getSy() + f4;
            float sx2 = next.getEnd().getSx() + f;
            float sy2 = next.getEnd().getSy() + f4;
            float f7 = (right - left) / 2.0f;
            float f8 = left + f7;
            double d = f8;
            double d2 = f7;
            float fM2210a = (float) AbstractC2821a.m2210a(Math.acos((sx - f8) / f7), d2, d);
            Iterator<VPathDataArcTo.Data> it2 = it;
            double d3 = top + ((bottom - top) / 2.0f);
            float fM5b = (float) AbstractC0000a.m5b(Math.asin((sy - r3) / r5), d2, d3);
            float fCos = (float) ((Math.cos(Math.acos((sx2 - f8) / f7)) * d2) + d);
            float fSin = (float) ((Math.sin(Math.asin((sy2 - r3) / r5)) * d2) + d3);
            double d4 = f8 + f7;
            double d5 = fM2210a;
            double d6 = fM5b;
            float threePointDegree = (float) VUtilMath.getThreePointDegree(d4, d3, d, d3, d5, d6, true, 0.0f, true);
            float threePointDegree2 = (float) VUtilMath.getThreePointDegree(d5, d6, d, d3, fCos, fSin, false, threePointDegree, false);
            RectF rectF = new RectF((next.getLeft() + f) * f5, (next.getTop() + f4) * f6, (next.getRight() + f) * f5, (next.getBottom() + f4) * f6);
            next.getStart().getSx();
            next.getStart().getSy();
            float sx3 = (next.getEnd().getSx() + f) * f5;
            float sy3 = (next.getEnd().getSy() + f4) * f6;
            path.arcTo(rectF, threePointDegree, threePointDegree2);
            currX = sx3;
            currY = sy3;
            it = it2;
        }
    }

    private static void createPathDraw(VPathDataAngleEllipse vPathDataAngleEllipse, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataAngleEllipse.getFullCmd() != null && vPathDataAngleEllipse.getFullCmd().length() > 0) {
            vPathDataAngleEllipse.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VPathDataAngleEllipse.Data data : vPathDataAngleEllipse.getList()) {
            float sx = (data.getCenter().getSx() + f) * f5;
            float sy = (data.getCenter().getSy() + f4) * f6;
            float width = data.getSize().getWidth() * f5;
            float height = data.getSize().getHeight() * f6;
            path.arcTo(new RectF(sx - width, sy - height, sx + width, sy + height), data.getStartAngle(), -data.getEndAngle());
        }
    }

    private static void createPathDraw(VPathDataAngleEllipseTo vPathDataAngleEllipseTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataAngleEllipseTo.getFullCmd() != null && vPathDataAngleEllipseTo.getFullCmd().length() > 0) {
            vPathDataAngleEllipseTo.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VPathDataAngleEllipseTo.Data data : vPathDataAngleEllipseTo.getList()) {
            float sx = (data.getCenter().getSx() + f) * f5;
            float sy = (data.getCenter().getSy() + f4) * f6;
            float width = data.getSize().getWidth() * f5;
            float height = data.getSize().getHeight() * f6;
            path.arcTo(new RectF(sx - width, sy - height, sx + width, sy + height), data.getStartAngle(), -data.getEndAngle());
        }
    }

    private static void createPathDraw(VPathDataClose vPathDataClose, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        path.close();
    }

    private static void createPathDraw(VPathDataRCurveTo vPathDataRCurveTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataRCurveTo.getFullCmd() != null && vPathDataRCurveTo.getFullCmd().length() > 0) {
            vPathDataRCurveTo.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VPathDataRCurveTo.Data data : vPathDataRCurveTo.getList()) {
            float sx = data.getControl1().getSx() * f5;
            float sy = data.getControl1().getSy() * f6;
            float sx2 = data.getControl2().getSx() * f5;
            float sy2 = data.getControl2().getSy() * f6;
            float sx3 = data.getEnd().getSx() * f5;
            float sy3 = data.getEnd().getSy() * f6;
            path.rCubicTo(sx, sy, sx2, sy2, sx3, sy3);
            currX += sx3;
            currY += sy3;
        }
    }

    private static void createPathDraw(VPathDataRLineTo vPathDataRLineTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataRLineTo.getFullCmd() != null && vPathDataRLineTo.getFullCmd().length() > 0) {
            vPathDataRLineTo.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VCommonPoint vCommonPoint : vPathDataRLineTo.getList()) {
            float sx = vCommonPoint.getSx() * f5;
            float sy = vCommonPoint.getSy() * f6;
            path.rLineTo(sx, sy);
            currX += sx;
            currY += sy;
        }
    }

    private static void createPathDraw(VPathDataRMoveTo vPathDataRMoveTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataRMoveTo.getFullCmd() != null && vPathDataRMoveTo.getFullCmd().length() > 0) {
            vPathDataRMoveTo.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VCommonPoint vCommonPoint : vPathDataRMoveTo.getList()) {
            float sx = vCommonPoint.getSx() * f5;
            float sy = vCommonPoint.getSy() * f6;
            path.rMoveTo(sx, sy);
            currX += sx;
            currY += sy;
        }
    }

    private static void createPathDraw(VPathDataCurveTo vPathDataCurveTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataCurveTo.getFullCmd() != null && vPathDataCurveTo.getFullCmd().length() > 0) {
            vPathDataCurveTo.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VPathDataCurveTo.Data data : vPathDataCurveTo.getList()) {
            float sx = (data.getControl1().getSx() + f) * f5;
            float sy = (data.getControl1().getSy() + f4) * f6;
            float sx2 = (data.getControl2().getSx() + f) * f5;
            float sy2 = (data.getControl2().getSy() + f4) * f6;
            float sx3 = (data.getEnd().getSx() + f) * f5;
            float sy3 = (data.getEnd().getSy() + f4) * f6;
            path.cubicTo(sx, sy, sx2, sy2, sx3, sy3);
            currX = sx3;
            currY = sy3;
        }
    }

    private static void createPathDraw(VPathDataLineTo vPathDataLineTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataLineTo.getFullCmd() != null && vPathDataLineTo.getFullCmd().length() > 0) {
            vPathDataLineTo.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VCommonPoint vCommonPoint : vPathDataLineTo.getList()) {
            float sx = (vCommonPoint.getSx() + f) * f5;
            float sy = (vCommonPoint.getSy() + f4) * f6;
            path.lineTo(sx, sy);
            currX = sx;
            currY = sy;
        }
    }

    private static void createPathDraw(VPathDataMoveTo vPathDataMoveTo, float f, float f4, float f5, float f6, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape, Path path) {
        if (vPathDataMoveTo.getFullCmd() != null && vPathDataMoveTo.getFullCmd().length() > 0) {
            vPathDataMoveTo.makeListFromFullCmd(fArr, fArr2, vAttributeCore, vAttributeShape);
        }
        for (VCommonPoint vCommonPoint : vPathDataMoveTo.getList()) {
            float sx = (vCommonPoint.getSx() + f) * f5;
            float sy = (vCommonPoint.getSy() + f4) * f6;
            path.moveTo(sx, sy);
            currX = sx;
            currY = sy;
            if (mSx == 0.0f) {
                mSx = sx;
            }
            if (mSy == 0.0f) {
                mSy = sy;
            }
        }
    }
}
