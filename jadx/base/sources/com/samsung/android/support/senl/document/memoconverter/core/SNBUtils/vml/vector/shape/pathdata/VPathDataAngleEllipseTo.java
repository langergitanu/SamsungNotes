package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonSize;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPathDataAngleEllipseTo extends VPathDataBase {
    private String mFullCmd;
    private ArrayList<Data> mList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Data {
        private float mEndAngle;
        private float mStartAngle;
        private VCommonPoint mCenter = new VCommonPoint();
        private VCommonSize mSize = new VCommonSize();

        public Data() {
        }

        public VCommonPoint getCenter() {
            return this.mCenter;
        }

        public float getEndAngle() {
            return this.mEndAngle;
        }

        public VCommonSize getSize() {
            return this.mSize;
        }

        public float getStartAngle() {
            return this.mStartAngle;
        }

        public void setCenter(VCommonPoint vCommonPoint) {
            this.mCenter = vCommonPoint;
        }

        public void setEndAngle(float f) {
            this.mEndAngle = f;
        }

        public void setSize(VCommonSize vCommonSize) {
            this.mSize = vCommonSize;
        }

        public void setStartAngle(float f) {
            this.mStartAngle = f;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Data [mFullStr=");
            sb.append(VPathDataAngleEllipseTo.this.mFullCmd);
            sb.append(", mCenter=");
            sb.append(this.mCenter);
            sb.append(", mSize=");
            sb.append(this.mSize);
            sb.append(", mStartAngle=");
            sb.append(this.mStartAngle);
            sb.append(", mEndAngle=");
            return AbstractC0622a.m1171q(sb, this.mEndAngle, PropertyUtils.INDEXED_DELIM2);
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
                data.getCenter().setSx(it.next().floatValue());
                data.getCenter().setSy(it.next().floatValue());
                data.getSize().setWidth(it.next().floatValue());
                data.getSize().setHeight(it.next().floatValue());
                data.setStartAngle(it.next().floatValue());
                data.setEndAngle(it.next().floatValue());
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
        StringBuilder sb = new StringBuilder("VAngleEllipseTo [");
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
                data.getCenter().setSx(it.next().floatValue());
                data.getCenter().setSy(it.next().floatValue());
                data.getSize().setWidth(it.next().floatValue());
                data.getSize().setHeight(it.next().floatValue());
                data.setStartAngle(it.next().floatValue());
                data.setEndAngle(it.next().floatValue());
                this.mList.add(data);
                z = true;
            }
        }
        return z;
    }
}
