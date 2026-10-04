package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.common.VDrawConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.path.VDrawLinePath;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.path.VDrawPath;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilArray;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulas;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementStroke;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataShapeType;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataLineTo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataMoveTo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawShape {

    /* JADX INFO: renamed from: dh */
    private static int f5908dh;

    /* JADX INFO: renamed from: dw */
    private static int f5909dw;
    private static VAttributeShape vShapeattr;

    public static void createMultiPicture(Canvas canvas, VMetaDataShape vMetaDataShape, RectF rectF, float f, String str, String str2, VMetaDataShapeType vMetaDataShapeType, boolean z) {
        drawCanvas(canvas, rectF, f, str, str2, createPictureSub(vMetaDataShape, rectF, f, str, str2, vMetaDataShapeType, z));
    }

    public static Picture createPicture(VMetaDataShape vMetaDataShape, RectF rectF, float f, String str, String str2, VMetaDataShapeType vMetaDataShapeType, boolean z) {
        Path pathCreatePictureSub = createPictureSub(vMetaDataShape, rectF, f, str, str2, vMetaDataShapeType, z);
        Picture picture = new Picture();
        if (!drawCanvas(picture.beginRecording(f5909dw, f5908dh), rectF, f, str, str2, pathCreatePictureSub)) {
            return null;
        }
        picture.endRecording();
        return picture;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0136 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Path createPictureSub(VMetaDataShape vMetaDataShape, RectF rectF, float f, String str, String str2, VMetaDataShapeType vMetaDataShapeType, boolean z) {
        VElementFormulas vElementFormulas;
        VElementStroke vElementStroke;
        VAttributeCore coreAttrs;
        VAttributeShape shapeAttrs;
        ArrayList<Float> adj;
        ArrayList<VPathDataInfo> pathInfos;
        VElementFormulas vElementFormulas2;
        VElementStroke vElementStroke2;
        ArrayList<VPathDataInfo> arrayListInsertValue;
        VElementFormulas vElementFormulas3;
        float[] fArr;
        float[] floatArray;
        float sx;
        float sy;
        VAttributeCore coreAttrs2 = vMetaDataShape.getCoreAttrs();
        vShapeattr = vMetaDataShape.getShapeAttrs();
        ArrayList<Float> adj2 = vMetaDataShape.getAdj();
        ArrayList<VPathDataInfo> pathInfos2 = vMetaDataShape.getPathInfos();
        ArrayList<VElementInfo> elements = vMetaDataShape.getElements();
        if (elements == null || elements.size() <= 0) {
            vElementFormulas = null;
            vElementStroke = null;
        } else {
            vElementFormulas = null;
            vElementStroke = null;
            for (VElementInfo vElementInfo : elements) {
                if (VElementKey.FORMULAS.compareToIgnoreCase(vElementInfo.getKey()) == 0) {
                    vElementFormulas = (VElementFormulas) vElementInfo.getObject();
                } else if ("stroke".compareToIgnoreCase(vElementInfo.getKey()) == 0) {
                    vElementStroke = (VElementStroke) vElementInfo.getObject();
                }
            }
        }
        String type = vMetaDataShape.getType();
        if (vMetaDataShapeType != null && type != null && type.equals(vMetaDataShapeType.getCoreAttrs().getId())) {
            coreAttrs = vMetaDataShapeType.getCoreAttrs();
            shapeAttrs = vMetaDataShapeType.getShapeAttrs();
            adj = vMetaDataShapeType.getAdj();
            pathInfos = vMetaDataShapeType.getPathInfos();
            ArrayList<VElementInfo> elements2 = vMetaDataShapeType.getElements();
            if (elements2 != null && elements2.size() > 0) {
                vElementFormulas2 = null;
                vElementStroke2 = null;
                for (VElementInfo vElementInfo2 : elements2) {
                    if (VElementKey.FORMULAS.compareToIgnoreCase(vElementInfo2.getKey()) == 0) {
                        vElementFormulas2 = (VElementFormulas) vElementInfo2.getObject();
                    } else if ("stroke".compareToIgnoreCase(vElementInfo2.getKey()) == 0) {
                        vElementStroke2 = (VElementStroke) vElementInfo2.getObject();
                    }
                }
            }
            arrayListInsertValue = insertValue(pathInfos2, pathInfos);
            VAttributeCore vAttributeCoreInsertValue = insertValue(coreAttrs2, coreAttrs);
            VAttributeShape vAttributeShapeInsertValue = insertValue(vShapeattr, shapeAttrs);
            ArrayList<Float> arrayListInsertValueFloat = insertValueFloat(adj2, adj);
            vElementFormulas3 = (VElementFormulas) insertValue(vElementFormulas, vElementFormulas2);
            if (vElementFormulas3 != null || vElementFormulas3.getList().size() <= 0) {
                fArr = null;
                floatArray = null;
            } else {
                vElementFormulas3.calculate(arrayListInsertValueFloat, vAttributeCoreInsertValue, vAttributeShapeInsertValue);
                float[] floatArray2 = VUtilArray.toFloatArray(vElementFormulas3.getValues());
                floatArray = VUtilArray.toFloatArray(arrayListInsertValueFloat);
                fArr = floatArray2;
            }
            VElementStroke vElementStroke3 = (VElementStroke) insertValue(vElementStroke, vElementStroke2);
            float fWidth = rectF.width();
            float fHeight = rectF.height();
            f5909dw = (int) fWidth;
            f5908dh = (int) fHeight;
            float width = vAttributeCoreInsertValue.getCoordSize().getWidth();
            float height = vAttributeCoreInsertValue.getCoordSize().getHeight();
            if (arrayListInsertValue != null && arrayListInsertValue.size() > 0) {
                float f4 = 0.0f;
                float f5 = 0.0f;
                for (VPathDataInfo vPathDataInfo : arrayListInsertValue) {
                    String pathCmd = vPathDataInfo.getPathCmd();
                    if (VPathDataCmd.Alias.MoveTo.compareToIgnoreCase(pathCmd) == 0) {
                        VPathDataMoveTo vPathDataMoveTo = (VPathDataMoveTo) vPathDataInfo.getPathData();
                        if (vPathDataMoveTo.getFullCmd() != null && vPathDataMoveTo.getFullCmd().length() > 0) {
                            vPathDataMoveTo.makeListFromFullCmd(floatArray, fArr, vAttributeCoreInsertValue, vAttributeShapeInsertValue);
                        }
                        sx = vPathDataMoveTo.getMaxPoint().getSx();
                        sy = vPathDataMoveTo.getMaxPoint().getSy();
                    } else {
                        if (VPathDataCmd.Alias.LineTo.compareToIgnoreCase(pathCmd) == 0) {
                            VPathDataLineTo vPathDataLineTo = (VPathDataLineTo) vPathDataInfo.getPathData();
                            if (vPathDataLineTo.getFullCmd() != null && vPathDataLineTo.getFullCmd().length() > 0) {
                                vPathDataLineTo.makeListFromFullCmd(floatArray, fArr, vAttributeCoreInsertValue, vAttributeShapeInsertValue);
                            }
                            sx = vPathDataLineTo.getMaxPoint().getSx();
                            sy = vPathDataLineTo.getMaxPoint().getSy();
                        }
                        if (width < f4) {
                            width = f4;
                        }
                        if (height >= f5) {
                            height = f5;
                        }
                    }
                    float f6 = sx;
                    f5 = sy;
                    f4 = f6;
                    if (width < f4) {
                    }
                    if (height >= f5) {
                    }
                }
            }
            float f7 = fWidth / (width + 8640.0f);
            float f8 = fHeight / (height + 8640.0f);
            if (!z) {
                return getLinePath(rectF, f, vElementStroke3);
            }
            return VDrawPath.createPath(arrayListInsertValue, 4320.0f, 4320.0f, f7, f8, floatArray, fArr, vAttributeCoreInsertValue, vAttributeShapeInsertValue);
        }
        coreAttrs = null;
        shapeAttrs = null;
        adj = null;
        pathInfos = null;
        vElementFormulas2 = null;
        vElementStroke2 = null;
        arrayListInsertValue = insertValue(pathInfos2, pathInfos);
        VAttributeCore vAttributeCoreInsertValue2 = insertValue(coreAttrs2, coreAttrs);
        VAttributeShape vAttributeShapeInsertValue2 = insertValue(vShapeattr, shapeAttrs);
        ArrayList<Float> arrayListInsertValueFloat2 = insertValueFloat(adj2, adj);
        vElementFormulas3 = (VElementFormulas) insertValue(vElementFormulas, vElementFormulas2);
        if (vElementFormulas3 != null) {
            fArr = null;
            floatArray = null;
        }
        VElementStroke vElementStroke32 = (VElementStroke) insertValue(vElementStroke, vElementStroke2);
        float fWidth2 = rectF.width();
        float fHeight2 = rectF.height();
        f5909dw = (int) fWidth2;
        f5908dh = (int) fHeight2;
        float width2 = vAttributeCoreInsertValue2.getCoordSize().getWidth();
        float height2 = vAttributeCoreInsertValue2.getCoordSize().getHeight();
        if (arrayListInsertValue != null) {
            float f42 = 0.0f;
            float f52 = 0.0f;
            while (r9.hasNext()) {
            }
        }
        float f72 = fWidth2 / (width2 + 8640.0f);
        float f82 = fHeight2 / (height2 + 8640.0f);
        if (!z) {
        }
    }

    private static boolean drawCanvas(Canvas canvas, RectF rectF, float f, String str, String str2, Path path) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (path == null) {
            return false;
        }
        if (f < 0.0f) {
            f = vShapeattr.getStrokeWeight();
        }
        String strInsertValue = insertValue(vShapeattr.getFillColor(), str2);
        if (vShapeattr.getFill() || (str2 != null && !str2.isEmpty())) {
            float color = strInsertValue != null ? VUtilString.parseColor(strInsertValue) : VUtilString.parseColor(VDrawConst.DEFAULT_FILL_COLOR);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor((int) color);
            canvas.drawPath(path, paint);
        }
        String strInsertValue2 = insertValue(vShapeattr.getStrokeColor(), str);
        if (f >= 1.0f && strInsertValue2 != null) {
            float color2 = VUtilString.parseColor(strInsertValue2);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(1.0f);
            paint.setColor((int) color2);
            canvas.drawPath(path, paint);
        }
        return true;
    }

    private static Path getLinePath(RectF rectF, float f, VElementStroke vElementStroke) {
        boolean startArrow;
        boolean endArrow;
        if (vElementStroke != null) {
            startArrow = vElementStroke.getStartArrow();
            endArrow = vElementStroke.getEndArrow();
        } else {
            startArrow = false;
            endArrow = false;
        }
        return VDrawLinePath.createPath(rectF, 100.0f, f, startArrow, endArrow);
    }

    private static VAttributeCore insertValue(VAttributeCore vAttributeCore, VAttributeCore vAttributeCore2) {
        return vAttributeCore2 != null ? vAttributeCore2 : vAttributeCore;
    }

    private static ArrayList<Float> insertValueFloat(ArrayList<Float> arrayList, ArrayList<Float> arrayList2) {
        return (arrayList == null || arrayList.size() <= 0) ? arrayList2 : arrayList;
    }

    private static VAttributeShape insertValue(VAttributeShape vAttributeShape, VAttributeShape vAttributeShape2) {
        return vAttributeShape2 != null ? vAttributeShape2 : vAttributeShape;
    }

    private static VElementBase insertValue(VElementBase vElementBase, VElementBase vElementBase2) {
        return vElementBase != null ? vElementBase : vElementBase2;
    }

    private static String insertValue(String str, String str2) {
        return (str2 == null || str2.isEmpty()) ? str : str2;
    }

    private static ArrayList<VPathDataInfo> insertValue(ArrayList<VPathDataInfo> arrayList, ArrayList<VPathDataInfo> arrayList2) {
        if (arrayList != null && arrayList.size() > 0) {
            return arrayList;
        }
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return null;
        }
        return arrayList2;
    }
}
