package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPathDataClockWiseArc extends VPathDataBase {
    private String mFullCmd;
    private ArrayList<Data> mList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Data {
        private float mBottom;
        private float mLeft;
        private float mRight;
        private float mTop;
        private VCommonPoint mStart = new VCommonPoint();
        private VCommonPoint mEnd = new VCommonPoint();

        public Data() {
        }

        public float getBottom() {
            return this.mBottom;
        }

        public VCommonPoint getEnd() {
            return this.mEnd;
        }

        public float getLeft() {
            return this.mLeft;
        }

        public float getRight() {
            return this.mRight;
        }

        public VCommonPoint getStart() {
            return this.mStart;
        }

        public float getTop() {
            return this.mTop;
        }

        public void setBottom(float f) {
            this.mBottom = f;
        }

        public void setEnd(VCommonPoint vCommonPoint) {
            this.mEnd = vCommonPoint;
        }

        public void setLeft(float f) {
            this.mLeft = f;
        }

        public void setRight(float f) {
            this.mRight = f;
        }

        public void setStart(VCommonPoint vCommonPoint) {
            this.mStart = vCommonPoint;
        }

        public void setTop(float f) {
            this.mTop = f;
        }

        public String toString() {
            return "Data [mFullStr=" + VPathDataClockWiseArc.this.mFullCmd + ", mLeft=" + this.mLeft + ", mTop=" + this.mTop + ", mRight=" + this.mRight + ", mBottom=" + this.mBottom + ", mStart=" + this.mStart + ", mEnd=" + this.mEnd + PropertyUtils.INDEXED_DELIM2;
        }
    }

    public String getFullCmd() {
        return this.mFullCmd;
    }

    public ArrayList<Data> getList() {
        return this.mList;
    }

    public boolean makeListFromFullCmd(float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        String fullCmd = getFullCmd();
        boolean z = false;
        if (fullCmd != null && fullCmd.length() != 0) {
            this.mList.clear();
            Iterator<Float> it = new VPathDataParserHelper(fullCmd, -1).getFloatList(fArr, fArr2, vAttributeCore, vAttributeShape).iterator();
            while (it.hasNext()) {
                Data data = new Data();
                data.setLeft(it.next().floatValue());
                data.setTop(it.next().floatValue());
                data.setRight(it.next().floatValue());
                data.setBottom(it.next().floatValue());
                data.getStart().setSx(it.next().floatValue());
                data.getStart().setSy(it.next().floatValue());
                data.getEnd().setSx(it.next().floatValue());
                data.getEnd().setSy(it.next().floatValue());
                this.mList.add(data);
                z = true;
            }
        }
        return z;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataBase
    public void setDefaultMember() {
        super.setDefaultMember();
        this.mList = new ArrayList<>();
    }

    public void setFullCmd(String str) {
        this.mFullCmd = str;
    }

    public void setList(ArrayList<Data> arrayList) {
        this.mList = arrayList;
    }

    public String toString() {
        Iterator<Data> it = this.mList.iterator();
        StringBuilder sb = new StringBuilder("VClockWiseArc [");
        while (it.hasNext()) {
            sb.append(it.next().toString() + "|");
        }
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
            Iterator<Float> it = new VPathDataParserHelper(str, -1).getIntegerList().iterator();
            while (it.hasNext()) {
                Data data = new Data();
                data.setLeft(it.next().floatValue());
                data.setTop(it.next().floatValue());
                data.setRight(it.next().floatValue());
                data.setBottom(it.next().floatValue());
                data.getStart().setSx(it.next().floatValue());
                data.getStart().setSy(it.next().floatValue());
                data.getEnd().setSx(it.next().floatValue());
                data.getEnd().setSy(it.next().floatValue());
                this.mList.add(data);
                z = true;
            }
        }
        return z;
    }
}
