package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonSize;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementHandles extends VElementBase {
    public static final String NAME = "v:handles";
    private ArrayList<C8000H> mList;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementHandles$H */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class C8000H {
        public static final String NAME = "v:h";
        private String mInvX;
        private String mInvY;
        private VCommonPoint mMap;
        private String mPolor;
        private String mPosition;
        private VCommonSize mRadiusRange;
        private String mSwitch;
        private VCommonSize mXRange;
        private VCommonSize mYRange;

        public String getInvX() {
            return this.mInvX;
        }

        public String getInvY() {
            return this.mInvY;
        }

        public VCommonPoint getMap() {
            return this.mMap;
        }

        public String getPolor() {
            return this.mPolor;
        }

        public String getPosition() {
            return this.mPosition;
        }

        public VCommonSize getRadiusRange() {
            return this.mRadiusRange;
        }

        public String getSwitch() {
            return this.mSwitch;
        }

        public VCommonSize getXRange() {
            return this.mXRange;
        }

        public VCommonSize getYRange() {
            return this.mYRange;
        }

        public void setInvX(String str) {
            this.mInvX = str;
        }

        public void setInvY(String str) {
            this.mInvY = str;
        }

        public void setMap(VCommonPoint vCommonPoint) {
            this.mMap = vCommonPoint;
        }

        public void setPolor(String str) {
            this.mPolor = str;
        }

        public void setPosition(String str) {
            this.mPosition = str;
        }

        public void setRadiusRange(VCommonSize vCommonSize) {
            this.mRadiusRange = vCommonSize;
        }

        public void setSwitch(String str) {
            this.mSwitch = str;
        }

        public void setXRange(VCommonSize vCommonSize) {
            this.mXRange = vCommonSize;
        }

        public void setYRange(VCommonSize vCommonSize) {
            this.mYRange = vCommonSize;
        }

        public String toString() {
            return "H [mPosition=" + this.mPosition + ", mPolor=" + this.mPolor + ", mMap=" + this.mMap + ", mInvX=" + this.mInvX + ", mInvY=" + this.mInvY + ", mSwitch=" + this.mSwitch + ", mXRange=" + this.mXRange + ", mYRange=" + this.mYRange + ", mRadiusRange=" + this.mRadiusRange + "]";
        }

        public void setMap(String str) {
            this.mMap.setPoint(str);
        }

        public void setRadiusRange(String str) {
            this.mRadiusRange.setSize(str);
        }

        public void setXRange(String str) {
            this.mXRange.setSize(str);
        }

        public void setYRange(String str) {
            this.mYRange.setSize(str);
        }
    }

    public C8000H createH() {
        return new C8000H();
    }

    public ArrayList<C8000H> getList() {
        return this.mList;
    }

    public ArrayList<C8000H> makeAndGetList() {
        ArrayList<C8000H> arrayList = new ArrayList<>();
        this.mList = arrayList;
        return arrayList;
    }

    public void setList(ArrayList<C8000H> arrayList) {
        this.mList = arrayList;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("Handles [mHList=");
        Iterator<C8000H> it = this.mList.iterator();
        while (it.hasNext()) {
            sb.append(PropertyUtils.INDEXED_DELIM);
            sb.append(it.next());
            sb.append(PropertyUtils.INDEXED_DELIM2);
        }
        sb.append(", toString()=");
        return AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, super.toString(), sb);
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
    }
}
