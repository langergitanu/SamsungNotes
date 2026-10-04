package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementPath extends VElementBase {
    public static final String NAME = "v:path";
    private boolean mArrowOk;
    private boolean mFillOk;
    private boolean mGradientShapeOk;
    private VCommonPoint mLimo;
    private ArrayList<VPathDataInfo> mPathInfos;
    private boolean mPossibleFill = false;
    private boolean mShadowOk;
    private boolean mStrokeOk;
    private String mTextBoxRect;
    private boolean mTextPathOk;

    public boolean getArrowOk() {
        return this.mArrowOk;
    }

    public boolean getFillOk() {
        return this.mFillOk;
    }

    public boolean getGradientShapeOk() {
        return this.mGradientShapeOk;
    }

    public VCommonPoint getLimo() {
        return this.mLimo;
    }

    public ArrayList<VPathDataInfo> getPathInfos() {
        return this.mPathInfos;
    }

    public boolean getPossibleFill() {
        return this.mPossibleFill;
    }

    public boolean getShadowOk() {
        return this.mShadowOk;
    }

    public boolean getStrokeOk() {
        return this.mStrokeOk;
    }

    public String getTextBoxRect() {
        return this.mTextBoxRect;
    }

    public boolean getTextPathOk() {
        return this.mTextPathOk;
    }

    public void setArrowOk(boolean z) {
        this.mArrowOk = z;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
        this.mPathInfos = new ArrayList<>();
        this.mLimo = new VCommonPoint();
    }

    public void setFillOk(boolean z) {
        this.mFillOk = z;
    }

    public void setGradientShapeOk(boolean z) {
        this.mGradientShapeOk = z;
    }

    public void setLimo(VCommonPoint vCommonPoint) {
        this.mLimo = vCommonPoint;
    }

    public void setPathInfos(ArrayList<VPathDataInfo> arrayList) {
        this.mPathInfos = arrayList;
    }

    public void setPossibleFill(boolean z) {
        this.mPossibleFill = z;
    }

    public void setShadowOk(boolean z) {
        this.mShadowOk = z;
    }

    public void setStrokeOk(boolean z) {
        this.mStrokeOk = z;
    }

    public void setTextBoxRect(String str) {
        this.mTextBoxRect = str;
    }

    public void setTextPathOk(boolean z) {
        this.mTextPathOk = z;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("Path [mPathInfos=");
        Iterator<VPathDataInfo> it = this.mPathInfos.iterator();
        while (it.hasNext()) {
            sb.append(PropertyUtils.INDEXED_DELIM);
            sb.append(it.next());
            sb.append(PropertyUtils.INDEXED_DELIM2);
        }
        sb.append(", mLimo=");
        sb.append(this.mLimo);
        sb.append(", mFillOk=");
        sb.append(this.mFillOk);
        sb.append(", mStrokeOk=");
        sb.append(this.mStrokeOk);
        sb.append(", mShadowOk=");
        sb.append(this.mShadowOk);
        sb.append(", mArrowOk=");
        sb.append(this.mArrowOk);
        sb.append(", mGradientShapeOk=");
        sb.append(this.mGradientShapeOk);
        sb.append(", mTextPathOk=");
        sb.append(this.mTextPathOk);
        sb.append(", mTextBoxRect=");
        sb.append(this.mTextBoxRect);
        sb.append(", toString()=");
        return AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, super.toString(), sb);
    }

    public void setArrowOk(String str) {
        setArrowOk(VUtilString.parseBoolean(str));
    }

    public void setFillOk(String str) {
        setFillOk(VUtilString.parseBoolean(str));
    }

    public void setGradientShapeOk(String str) {
        setGradientShapeOk(VUtilString.parseBoolean(str));
    }

    public void setLimo(String str) {
        this.mLimo.setPoint(str);
    }

    public void setPathInfos(String str) {
        ArrayList<VPathDataInfo> arrayListMakePathInfoList = VPathDataCmd.makePathInfoList(str);
        setPathInfos(arrayListMakePathInfoList);
        if (arrayListMakePathInfoList != null) {
            Iterator<VPathDataInfo> it = arrayListMakePathInfoList.iterator();
            while (it.hasNext()) {
                if (VPathDataCmd.Alias.Close.compareToIgnoreCase(it.next().getPathCmd()) == 0) {
                    setPossibleFill(true);
                }
            }
        }
    }

    public void setShadowOk(String str) {
        setShadowOk(VUtilString.parseBoolean(str));
    }

    public void setStrokeOk(String str) {
        setStrokeOk(VUtilString.parseBoolean(str));
    }

    public void setTextPathOk(String str) {
        setTextPathOk(VUtilString.parseBoolean(str));
    }
}
