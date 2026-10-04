package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPathDataQuadraticbezier extends VPathDataBase {
    private VCommonPoint mEnd;
    private String mFullCmd;
    private ArrayList<VCommonPoint> mList;

    public VCommonPoint getEnd() {
        return this.mEnd;
    }

    public String getFullCmd() {
        return this.mFullCmd;
    }

    public ArrayList<VCommonPoint> getList() {
        return this.mList;
    }

    public boolean makeListFromFullCmd(float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        String fullCmd = getFullCmd();
        boolean z = false;
        if (fullCmd != null && fullCmd.length() != 0) {
            this.mList.clear();
            ArrayList<Float> floatList = new VPathDataParserHelper(fullCmd, -1).getFloatList(fArr, fArr2, vAttributeCore, vAttributeShape);
            Iterator<Float> it = floatList.iterator();
            int size = floatList.size();
            int i = 0;
            while (it.hasNext()) {
                VCommonPoint vCommonPoint = new VCommonPoint();
                if (size - i == 0) {
                    setEnd(vCommonPoint);
                } else {
                    vCommonPoint.setSx(it.next().floatValue());
                    vCommonPoint.setSy(it.next().floatValue());
                    i += 2;
                    this.mList.add(vCommonPoint);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataBase
    public void setDefaultMember() {
        super.setDefaultMember();
        this.mList = new ArrayList<>();
        this.mEnd = new VCommonPoint();
    }

    public void setEnd(VCommonPoint vCommonPoint) {
        this.mEnd = vCommonPoint;
    }

    public void setFullCmd(String str) {
        this.mFullCmd = str;
    }

    public void setList(ArrayList<VCommonPoint> arrayList) {
        this.mList = arrayList;
    }

    public String toString() {
        Iterator<VCommonPoint> it = this.mList.iterator();
        StringBuilder sb = new StringBuilder("Quadraticbezier [");
        while (it.hasNext()) {
            sb.append(it.next().toString() + "|");
        }
        sb.append("mFullCmd = " + this.mFullCmd);
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    public boolean setList(String str) {
        boolean z = false;
        if (str != null && str.length() != 0) {
            if (str.matches(".*@.*")) {
                setFullCmd(str);
                return true;
            }
            ArrayList<Float> integerList = new VPathDataParserHelper(str, -1).getIntegerList();
            Iterator<Float> it = integerList.iterator();
            int size = integerList.size();
            int i = 0;
            while (it.hasNext()) {
                VCommonPoint vCommonPoint = new VCommonPoint();
                if (size - i == 0) {
                    setEnd(vCommonPoint);
                } else {
                    vCommonPoint.setSx(it.next().floatValue());
                    vCommonPoint.setSy(it.next().floatValue());
                    i += 2;
                    this.mList.add(vCommonPoint);
                }
                z = true;
            }
        }
        return z;
    }
}
