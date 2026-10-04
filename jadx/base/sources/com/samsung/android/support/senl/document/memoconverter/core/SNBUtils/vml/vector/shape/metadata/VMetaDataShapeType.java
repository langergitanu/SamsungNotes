package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VMetaDataShapeType extends VMetaDataBase {
    public static final String NAME = "v:shapetype";
    private ArrayList<Float> mAdj;
    private VAttributeCore mCoreAttrs;
    private ArrayList<VElementInfo> mElements;
    private ArrayList<VPathDataInfo> mPathInfos;
    private boolean mPossibleFill = false;
    private VAttributeShape mShapeAttrs;

    public ArrayList<Float> getAdj() {
        return this.mAdj;
    }

    public VAttributeCore getCoreAttrs() {
        return this.mCoreAttrs;
    }

    public ArrayList<VElementInfo> getElements() {
        return this.mElements;
    }

    public ArrayList<VPathDataInfo> getPathInfos() {
        return this.mPathInfos;
    }

    public boolean getPossibleFill() {
        return this.mPossibleFill;
    }

    public VAttributeShape getShapeAttrs() {
        return this.mShapeAttrs;
    }

    public ArrayList<VElementInfo> makeAndGetElements() {
        ArrayList<VElementInfo> arrayList = new ArrayList<>();
        this.mElements = arrayList;
        return arrayList;
    }

    public void setAdj(ArrayList<Float> arrayList) {
        this.mAdj = arrayList;
    }

    public void setCoreAttrs(VAttributeCore vAttributeCore) {
        this.mCoreAttrs = vAttributeCore;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataBase
    public void setDefaultMember() {
        this.mCoreAttrs = new VAttributeCore();
        this.mShapeAttrs = new VAttributeShape();
    }

    public void setElements(ArrayList<VElementInfo> arrayList) {
        this.mElements = arrayList;
    }

    public void setPathInfos(ArrayList<VPathDataInfo> arrayList) {
        this.mPathInfos = arrayList;
    }

    public void setPossibleFill(boolean z) {
        this.mPossibleFill = z;
    }

    public void setShapeAttrs(VAttributeShape vAttributeShape) {
        this.mShapeAttrs = vAttributeShape;
    }

    public String toString() {
        return "VShapeType [mCoreAttrs=" + this.mCoreAttrs + ", mShapeAttrs=" + this.mShapeAttrs + ", mAdj=" + this.mAdj + ", mPathInfos=" + this.mPathInfos + ", mElements=" + this.mElements + PropertyUtils.INDEXED_DELIM2;
    }

    public void setAdj(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        if (Pattern.compile(".*[,]*").matcher(str).matches()) {
            ArrayList<Float> arrayList = new ArrayList<>();
            String[] strArrSplit = str.split(",");
            int length = strArrSplit.length;
            while (i < length) {
                arrayList.add(Float.valueOf(VUtilString.parseFloat(strArrSplit[i])));
                i++;
            }
            setAdj(arrayList);
            return;
        }
        if (Pattern.compile(".*[ ]*").matcher(str).matches()) {
            ArrayList<Float> arrayList2 = new ArrayList<>();
            String[] strArrSplit2 = str.split(" ");
            int length2 = strArrSplit2.length;
            while (i < length2) {
                arrayList2.add(Float.valueOf(VUtilString.parseFloat(strArrSplit2[i])));
                i++;
            }
            setAdj(arrayList2);
        }
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
}
