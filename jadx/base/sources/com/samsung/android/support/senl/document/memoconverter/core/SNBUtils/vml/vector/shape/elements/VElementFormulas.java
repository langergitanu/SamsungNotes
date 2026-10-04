package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementFormulas extends VElementBase {
    public static final String NAME = "v:formulas";
    private ArrayList<C7999F> mList;
    private ArrayList<Float> mValues;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulas$F */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class C7999F {
        public static final String NAME = "v:f";
        private String mEqn;

        public String getEqn() {
            return this.mEqn;
        }

        public void setEqn(String str) {
            this.mEqn = str;
        }
    }

    public void calculate(ArrayList<Float> arrayList, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        ArrayList<Float> arrayList2 = new ArrayList<>();
        Iterator<C7999F> it = getList().iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(VElementFormulasCmd.calculateFucntion(it.next().getEqn(), arrayList, arrayList2, vAttributeCore, vAttributeShape)));
        }
        setValues(arrayList2);
    }

    public C7999F createF() {
        return new C7999F();
    }

    public ArrayList<C7999F> getList() {
        return this.mList;
    }

    public ArrayList<Float> getValues() {
        return this.mValues;
    }

    public ArrayList<C7999F> makeAndGetList() {
        ArrayList<C7999F> arrayList = new ArrayList<>();
        this.mList = arrayList;
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
        this.mList = new ArrayList<>();
    }

    public void setList(ArrayList<C7999F> arrayList) {
        this.mList = arrayList;
    }

    public void setValues(ArrayList<Float> arrayList) {
        this.mValues = arrayList;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("VFormulas [mList=");
        Iterator<C7999F> it = this.mList.iterator();
        while (it.hasNext()) {
            sb.append(PropertyUtils.INDEXED_DELIM);
            sb.append(it.next());
            sb.append(PropertyUtils.INDEXED_DELIM2);
        }
        sb.append(", toString()=");
        return AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, super.toString(), sb);
    }
}
