package com.samsung.android.imagetranslation.util;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.geometry.SmallestSurroundingRectangle;
import com.samsung.android.imagetranslation.jni.SceneText;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SceneTextUtils {
    private static final int MAX_PADDING = 15;
    private static final float PADDING_RATIO = 0.1f;
    private static final String TAG = "SceneTextUtils";
    static int[] adjustmentX = {-1, 1, 1, -1};
    static int[] adjustmentY = {-1, -1, 1, 1};
    private static boolean isCurrencyConverted = false;
    public static boolean use_text_rotation = true;

    private static double calcSlopeWithSimple(SceneText sceneText) {
        if (sceneText.getComponents() != null && sceneText.getComponents().size() != 0) {
            SceneText sceneText2 = sceneText.getComponents().get(0);
            SceneText sceneText3 = sceneText.getComponents().get(sceneText.getComponents().size() - 1);
            if (sceneText2.getComponents() != null && sceneText2.getComponents().size() != 0 && sceneText3.getComponents() != null && sceneText3.getComponents().size() != 0 && sceneText2.getComponents().get(0).getPoly() != null && sceneText3.getComponents().get(sceneText3.getComponents().size() - 1).getPoly() != null) {
                Point ceneterPoint = SceneTextUtil.getCeneterPoint(sceneText2.getComponents().get(0).getPoly());
                Point ceneterPoint2 = SceneTextUtil.getCeneterPoint(sceneText3.getComponents().get(sceneText3.getComponents().size() - 1).getPoly());
                if (ceneterPoint.equals(ceneterPoint2.x, ceneterPoint2.y)) {
                    return 0.0d;
                }
                int i = ceneterPoint.x;
                int i2 = ceneterPoint2.x;
                if (i == i2) {
                    return Double.MAX_VALUE;
                }
                return (((double) (ceneterPoint2.y - ceneterPoint.y)) * 1.0d) / ((double) (i2 - i));
            }
        }
        return 0.0d;
    }

    public static boolean containsOnlyNumbersAndSymbols(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^(?=.*[\\d\\p{S}\\p{Punct}])[\\d\\p{S}\\p{Punct}\\s]*[a-zA-Z]?[\\d\\p{S}\\p{Punct}\\s]*$").matcher(str).matches();
    }

    public static void convertCoordiate(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, Matrix matrix, int i) {
        for (SceneText sceneText : copyOnWriteArrayList) {
            if (sceneText.getComponents() != null) {
                convertCoordiate(sceneText.getComponents(), matrix, i);
            }
            sceneText.setPoly(SceneTextUtil.rotatePoly(sceneText.getPoly(), sceneText.getValue(), matrix, i));
        }
    }

    public static void detectVerticalLine(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return;
        }
        for (SceneText sceneText : copyOnWriteArrayList) {
            if (sceneText.getComponents() != null) {
                for (SceneText sceneText2 : sceneText.getComponents()) {
                    if (sceneText2 != null) {
                        sceneText2.setVerticalType(isVerticalTypeLine(sceneText2));
                    }
                }
            }
        }
    }

    public static boolean getCurrencyState() {
        return isCurrencyConverted;
    }

    private static int getDynamicPadding(Point[] pointArr) {
        return Math.min((int) (Math.min((int) Math.sqrt(Math.pow(pointArr[3].y - pointArr[0].y, 2.0d) + Math.pow(pointArr[3].x - pointArr[0].x, 2.0d)), (int) Math.sqrt(Math.pow(pointArr[1].y - pointArr[0].y, 2.0d) + Math.pow(pointArr[1].x - pointArr[0].x, 2.0d))) * 0.1f), 15);
    }

    private static double getOrientationWithPoly(Point[] pointArr) {
        if (pointArr.length != 4) {
            return 0.0d;
        }
        Point point = pointArr[0];
        Point point2 = pointArr[1];
        Point point3 = new Point();
        int i = point2.x - point.x;
        point3.x = i;
        point3.y = point2.y - point.y;
        double degrees = Math.toDegrees(Math.acos(((double) point3.x) / Math.sqrt(Math.pow(point3.y, 2.0d) + Math.pow(i, 2.0d))));
        if (point3.y < 0) {
            degrees = 360.0d - degrees;
        }
        return 360.0d - degrees;
    }

    private static boolean isPolyOutOfBound(Point[] pointArr, int i, int i2) {
        int i4;
        for (Point point : pointArr) {
            int i5 = point.x;
            if (i5 < 0 || (i4 = point.y) < 0 || i5 > i2 || i4 > i) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRectIntersecting(Point[] pointArr, Point[] pointArr2) {
        return Util.isPolyValueIntersecting(pointArr, pointArr2);
    }

    public static boolean isVerticalTypeLine(SceneText sceneText) {
        int size;
        if (sceneText.getType() != SceneText.SceneTextType.LINE) {
            LTTLogger.m5458d(TAG, "NOT LINE");
            return false;
        }
        if (sceneText.getComponents() != null) {
            size = 0;
            for (SceneText sceneText2 : sceneText.getComponents()) {
                if (sceneText2.getComponents() != null) {
                    size += sceneText2.getComponents().size();
                }
            }
        } else {
            size = 0;
        }
        if (size < 2 || Math.abs(calcSlopeWithSimple(sceneText)) <= 3.0d) {
            return false;
        }
        sceneText.getValue();
        return true;
    }

    public static CopyOnWriteArrayList<SceneText> makeOneParagraph(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        CopyOnWriteArrayList<SceneText> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        if (copyOnWriteArrayList == null) {
            return null;
        }
        int i = 0;
        if (copyOnWriteArrayList.size() == 1) {
            copyOnWriteArrayList2.add(copyOnWriteArrayList.get(0).m22154clone());
            return copyOnWriteArrayList2;
        }
        SceneText sceneText = new SceneText();
        sceneText.setType(SceneText.SceneTextType.PARAGRAPH);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.setLength(0);
        ArrayList<String> arrayList = new ArrayList<>();
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (SceneText sceneText2 : copyOnWriteArrayList) {
            for (SceneText sceneText3 : sceneText2.getComponents()) {
                sceneText.setComponent(sceneText3.m22154clone());
                stringBuffer.append('\n');
                stringBuffer.append(sceneText3.getValue());
            }
            Point[] poly = sceneText2.getPoly();
            int length = poly.length;
            for (int i2 = i; i2 < length; i2++) {
                Point point = poly[i2];
                iMin = Math.min(iMin, point.x);
                iMax = Math.max(iMax, point.x);
                iMin2 = Math.min(iMin2, point.y);
                iMax2 = Math.max(iMax2, point.y);
            }
            Iterator<String> it = sceneText2.getLanguages().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            i = 0;
        }
        sceneText.setPoly(new Point[]{new Point(iMin, iMin2), new Point(iMax, iMin2), new Point(iMax, iMax2), new Point(iMin, iMax2)});
        sceneText.setDeviceOrientation(copyOnWriteArrayList.get(0).getDeviceOrientation());
        sceneText.setLanguages(arrayList);
        if (stringBuffer.length() > 1) {
            sceneText.setValue(stringBuffer.toString().substring(1));
        } else {
            LTTLogger.m5459e(TAG, "Unexpected value length : " + stringBuffer.toString());
            sceneText.setValue("");
        }
        copyOnWriteArrayList2.add(sceneText);
        return copyOnWriteArrayList2;
    }

    public static boolean repairSceneTexts(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        Iterator<SceneText> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (!it.next().repair()) {
                return false;
            }
        }
        return true;
    }

    public static void updatePadding(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, int i, int i2) {
        for (SceneText sceneText : copyOnWriteArrayList) {
            updatePoly(sceneText, getDynamicPadding(sceneText.getPoly()), sceneText.getPoly());
        }
        validatePadding(copyOnWriteArrayList, i, i2);
    }

    private static void updatePoly(SceneText sceneText, int i, Point[] pointArr) {
        ArrayList arrayList = new ArrayList();
        for (Point point : pointArr) {
            arrayList.add(new PointF(point.x, point.y));
        }
        Point[] pointArrSortPoint = SmallestSurroundingRectangle.sortPoint(arrayList);
        Point[] pointArr2 = new Point[4];
        for (int i2 = 0; i2 < pointArr.length; i2++) {
            Point point2 = pointArr[i2];
            int i4 = point2.x;
            int i5 = point2.y;
            for (int i6 = 0; i6 < pointArrSortPoint.length; i6++) {
                Point point3 = pointArrSortPoint[i6];
                if (i4 == point3.x && i5 == point3.y) {
                    pointArr2[i2] = new Point((adjustmentX[i6] * i) + i4, (adjustmentY[i6] * i) + i5);
                }
            }
        }
        sceneText.setPaddedBoxPoly(pointArr2);
    }

    public static void updateSceneTextRect(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        LTTLogger.m5458d(TAG, "updateSceneTextRect: E");
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            SceneText sceneText = copyOnWriteArrayList.get(i);
            if (sceneText.getComponents() != null) {
                for (int i2 = 0; i2 < sceneText.getComponents().size(); i2++) {
                    SceneText sceneText2 = sceneText.getComponents().get(i2);
                    if (sceneText2.getComponents() != null) {
                        for (int i4 = 0; i4 < sceneText2.getComponents().size(); i4++) {
                            SceneText sceneText3 = sceneText2.getComponents().get(i4);
                            if (sceneText3.getComponents() != null && sceneText3.getComponents().size() > 0) {
                                sceneText3.setPoly(sceneText3.getComponents().get(0).getPoly());
                                for (int i5 = 0; i5 < sceneText3.getComponents().size(); i5++) {
                                    sceneText3.setPoly(SmallestSurroundingRectangle.computeCorners(sceneText3.getPoly(), sceneText3.getComponents().get(i5).getPoly()));
                                }
                            }
                            if (i4 == 0) {
                                sceneText2.setPoly(sceneText3.getPoly());
                            } else {
                                sceneText2.setPoly(SmallestSurroundingRectangle.computeCorners(sceneText2.getPoly(), sceneText3.getPoly()));
                            }
                        }
                    }
                    if (i2 == 0) {
                        sceneText.setPoly(sceneText2.getPoly());
                    } else {
                        sceneText.setPoly(SmallestSurroundingRectangle.computeCorners(sceneText.getPoly(), sceneText2.getPoly()));
                    }
                }
            }
        }
    }

    public static void updateSceneTextRotation(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, int i) {
        if (copyOnWriteArrayList == null || !use_text_rotation) {
            return;
        }
        for (SceneText sceneText : copyOnWriteArrayList) {
            Point[] pointArr = (Point[]) sceneText.getPoly().clone();
            StringBuffer stringBuffer = new StringBuffer();
            for (Point point : pointArr) {
                stringBuffer.append(point.x + SQLKeyword.COMMA + point.y + SQLKeyword.COMMA);
            }
            double orientationWithPoly = getOrientationWithPoly(pointArr);
            ArrayList arrayList = new ArrayList(Arrays.asList("ar", "ur", "iw", MarketingConstants.NotificationConst.FLIPPING_ANIMATION, "ps", "ckb"));
            SceneText.SceneTextType type = sceneText.getType();
            SceneText.SceneTextType sceneTextType = SceneText.SceneTextType.PARAGRAPH;
            if ((type.equals(sceneTextType) || sceneText.getType().equals(SceneText.SceneTextType.WORD)) && !sceneText.getLanguages().isEmpty() && arrayList.contains(sceneText.getLanguages().get(0))) {
                orientationWithPoly += 180.0d;
            }
            SceneText.SceneTextType type2 = sceneText.getType();
            SceneText.SceneTextType sceneTextType2 = SceneText.SceneTextType.LINE;
            if (type2.equals(sceneTextType2) && sceneText.getComponents() != null && !sceneText.getComponents().isEmpty() && !sceneText.getComponents().get(0).getLanguages().isEmpty() && arrayList.contains(sceneText.getComponents().get(0).getLanguages().get(0)) && sceneText.getComponents().size() > 1) {
                orientationWithPoly += 180.0d;
            }
            double d = ((orientationWithPoly + 360.0d) + ((double) (i - 90))) % 360.0d;
            double d2 = (i == 90 || i == 270) ? d - 26.190476190476186d : d + 26.190476190476186d;
            sceneText.setOrient((d2 < 45.0d || d2 >= 315.0d) ? SceneText.TextOrientation.CCW_0 : (d2 < 45.0d || d2 >= 135.0d) ? (d2 < 135.0d || d2 >= 225.0d) ? SceneText.TextOrientation.CCW_270 : SceneText.TextOrientation.CCW_180 : SceneText.TextOrientation.CCW_90);
            if (sceneText.getType().equals(sceneTextType) || sceneText.getType().equals(sceneTextType2)) {
                LTTLogger.m5458d(TAG, "Type = [" + sceneText.getType() + "], Rot = " + SceneText.TextOrientation.values()[sceneText.getOrient()] + ", angle = " + d2 + ", Text = " + sceneText.getValue() + ", Poly = " + ((Object) stringBuffer));
            }
            updateSceneTextRotation(sceneText.getComponents(), i);
        }
    }

    private static void validatePadding(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, int i, int i2) {
        int size = copyOnWriteArrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            int dynamicPadding = getDynamicPadding(copyOnWriteArrayList.get(i4).getPoly());
            LTTLogger.m5458d(TAG, "Initial Padding : " + dynamicPadding);
            for (int i5 = 0; i5 < size; i5++) {
                if (i4 != i5 || size == 1) {
                    Point[] paddedBoxPoly = copyOnWriteArrayList.get(i4).getPaddedBoxPoly();
                    Point[] paddedBoxPoly2 = copyOnWriteArrayList.get(i5).getPaddedBoxPoly();
                    while (dynamicPadding > 0 && ((size != 1 && isRectIntersecting(paddedBoxPoly, paddedBoxPoly2)) || isPolyOutOfBound(paddedBoxPoly, i, i2))) {
                        dynamicPadding--;
                        updatePoly(copyOnWriteArrayList.get(i4), dynamicPadding, copyOnWriteArrayList.get(i4).getPoly());
                        paddedBoxPoly = copyOnWriteArrayList.get(i4).getPaddedBoxPoly();
                    }
                }
            }
            String str = TAG;
            Log.d(str, "Current block : " + copyOnWriteArrayList.get(i4).getValue());
            Log.d(str, "validatePadding: Current Padding - " + dynamicPadding);
        }
    }
}
