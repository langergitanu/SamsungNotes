package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPredefinedPolyLine extends VPredefinedBase {
    public static final String NAME = "v:polyline";
    public ArrayList<VCommonPoint> mPoints;

    public ArrayList<VCommonPoint> getPoints() {
        return this.mPoints;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public void setDefaultMember() {
        super.setDefaultMember();
        this.mPoints = new ArrayList<>();
    }

    public void setPoints(ArrayList<VCommonPoint> arrayList) {
        this.mPoints = arrayList;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public String toString() {
        Iterator<VCommonPoint> it = this.mPoints.iterator();
        String strM1170p = AbstractC0622a.m1170p(super.toString(), "] [", new StringBuilder("PolyLine [toString()="));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strM1170p);
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
            stringBuffer.append("| ");
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }

    public void setPoints(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        if (Pattern.compile(".*[,]*").matcher(str).matches()) {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length % 2 == 0) {
                while (i < strArrSplit.length) {
                    VCommonPoint vCommonPoint = new VCommonPoint();
                    vCommonPoint.setSx(VUtilString.parseFloat(strArrSplit[i]));
                    vCommonPoint.setSy(VUtilString.parseFloat(strArrSplit[i + 1]));
                    this.mPoints.add(vCommonPoint);
                    i += 2;
                }
                return;
            }
            return;
        }
        if (Pattern.compile(".*[ ]*").matcher(str).matches()) {
            String[] strArrSplit2 = str.split(" ");
            if (strArrSplit2.length % 2 == 0) {
                while (i < strArrSplit2.length) {
                    VCommonPoint vCommonPoint2 = new VCommonPoint();
                    vCommonPoint2.setSx(VUtilString.parseFloat(strArrSplit2[i]));
                    vCommonPoint2.setSy(VUtilString.parseFloat(strArrSplit2[i + 1]));
                    this.mPoints.add(vCommonPoint2);
                    i += 2;
                }
            }
        }
    }
}
