package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilArray;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilMath;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementFormulasCmd {
    public static final String FABS = "abs";
    public static final String FATAN2 = "atan2";
    public static final String FCOS = "cos";
    public static final String FCOSATAN2 = "cosatan2";
    public static final String FELLIPSE = "ellipse";
    public static final String FIF = "if";
    public static final String FMAX = "max";
    public static final String FMID = "mid";
    public static final String FMIN = "min";
    public static final String FMOD = "mod";
    public static final String FPROD = "prod";
    public static final String FPRODUCT = "product";
    public static final String FSIN = "sin";
    public static final String FSINATAN2 = "sinatan2";
    public static final String FSQRT = "sqrt";
    public static final String FSUM = "sum";
    public static final String FSUMANGLE = "sumangle";
    public static final String FTAN = "tan";
    public static final String FVAL = "val";
    public static final String VEMUHEIGHT = "emuheight";
    public static final String VEMUHEIGHT2 = "emuheight2";
    public static final String VEMUWIDTH = "emuwidth";
    public static final String VEMUWIDTH2 = "emuwidth2";
    public static final String VHASFILL = "hasfill";
    public static final String VHASSTROKE = "hasstroke";
    public static final String VHEIGHT = "height";
    public static final String VPIXELHEIGHT = "pixelheight";
    public static final String VPIXELLINEWIDTH = "pixellinewidth";
    public static final String VPIXELWIDTH = "pixelwidth";
    public static final String VWIDTH = "width";
    public static final String VXCENTER = "xcenter";
    public static final String VXLIMO = "xlimo";
    public static final String VYCENTER = "ycenter";
    public static final String VYLIMO = "ylimo";

    public static float calculateFucntion(String str, ArrayList<Float> arrayList, ArrayList<Float> arrayList2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        float[] floatArray = VUtilArray.toFloatArray(arrayList);
        float[] floatArray2 = VUtilArray.toFloatArray(arrayList2);
        String strReplaceAll = str.replaceAll(" ", ",");
        if (Pattern.compile(".*[,]*").matcher(strReplaceAll).matches()) {
            String[] strArrSplit = strReplaceAll.split(",");
            int length = strArrSplit.length;
            float valueFromString = length > 1 ? getValueFromString(strArrSplit[1], floatArray, floatArray2, vAttributeCore, vAttributeShape) : 0.0f;
            float valueFromString2 = length > 2 ? getValueFromString(strArrSplit[2], floatArray, floatArray2, vAttributeCore, vAttributeShape) : 0.0f;
            float valueFromString3 = length > 3 ? getValueFromString(strArrSplit[3], floatArray, floatArray2, vAttributeCore, vAttributeShape) : 0.0f;
            if (FVAL.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return valueFromString;
            }
            if (FSUM.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (valueFromString + valueFromString2) - valueFromString3;
            }
            if (FPROD.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (valueFromString * valueFromString2) / valueFromString3;
            }
            if (FPRODUCT.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (valueFromString * valueFromString2) / valueFromString3;
            }
            if ("mid".compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (valueFromString + valueFromString2) / 2.0f;
            }
            if (FABS.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return Math.abs(valueFromString);
            }
            if (FMIN.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return Math.min(valueFromString, valueFromString2);
            }
            if (FMAX.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return Math.max(valueFromString, valueFromString2);
            }
            if (FIF.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return valueFromString > 0.0f ? valueFromString2 : valueFromString3;
            }
            if (FMOD.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) Math.sqrt((valueFromString3 * valueFromString3) + (valueFromString2 * valueFromString2) + (valueFromString * valueFromString));
            }
            if (FATAN2.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) (VUtilMath.radianToDegree(Math.atan2(valueFromString2, valueFromString)) * 65536.0d);
            }
            if (FSIN.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) (Math.sin((float) VUtilMath.degreeToRadian(valueFromString2 / 65536.0f)) * ((double) valueFromString));
            }
            if (FCOS.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) (Math.cos((float) VUtilMath.degreeToRadian(valueFromString2 / 65536.0f)) * ((double) valueFromString));
            }
            if (FCOSATAN2.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) (Math.cos(Math.atan2(valueFromString3, valueFromString2)) * ((double) valueFromString));
            }
            if (FSINATAN2.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) (Math.sin(Math.atan2(valueFromString3, valueFromString2)) * ((double) valueFromString));
            }
            if (FSQRT.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) Math.sqrt(valueFromString);
            }
            if (FSUMANGLE.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return ((valueFromString2 * 65536.0f) + valueFromString) - (valueFromString3 * 65536.0f);
            }
            if (FELLIPSE.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) (Math.sqrt(1.0d - Math.pow(valueFromString / valueFromString2, 2.0d)) * ((double) valueFromString3));
            }
            if (FTAN.compareToIgnoreCase(strArrSplit[0]) == 0) {
                return (float) (Math.tan((float) VUtilMath.degreeToRadian(valueFromString2 / 65536.0f)) * ((double) valueFromString));
            }
        }
        return 0.0f;
    }

    public static float getValueFromString(String str, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        float sy;
        float height;
        if (str == null || str.length() <= 0) {
            return 0.0f;
        }
        if (str.startsWith(Log.TAG_SEPARATOR)) {
            int i = Integer.parseInt(str.substring(1, str.length()));
            if (fArr2 != null) {
                return fArr2[i];
            }
            return 0.0f;
        }
        if (str.startsWith(ContentUtils.HASH_SYMBOL)) {
            int i2 = Integer.parseInt(str.substring(1, str.length()));
            if (fArr != null) {
                return fArr[i2];
            }
            return 0.0f;
        }
        if (str.startsWith("width")) {
            return vAttributeCore.getCoordSize().getWidth();
        }
        if (str.startsWith("height")) {
            return vAttributeCore.getCoordSize().getHeight();
        }
        if (str.startsWith("xcenter")) {
            sy = vAttributeCore.getCoordOrigin().getSx();
            height = vAttributeCore.getCoordSize().getWidth();
        } else {
            if (!str.startsWith("ycenter")) {
                return VUtilString.parseFloat(str);
            }
            sy = vAttributeCore.getCoordOrigin().getSy();
            height = vAttributeCore.getCoordSize().getHeight();
        }
        return (height / 2.0f) + sy;
    }
}
