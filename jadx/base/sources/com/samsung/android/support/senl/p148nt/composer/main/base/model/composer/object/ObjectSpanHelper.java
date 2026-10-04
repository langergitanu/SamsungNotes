package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectSpanHelper {
    private static final String TAG = Logger.createTag("ObjectSpanHelper");
    private SpenWNote mNote;

    public ObjectSpanHelper(SpenWNote spenWNote) {
        this.mNote = spenWNote;
    }

    public void deleteObjectSpan(List<SpenObjectSpan> list) {
        Iterator<SpenObjectSpan> it = list.iterator();
        while (it.hasNext()) {
            this.mNote.getBodyText().removeObjectSpan(it.next());
        }
    }

    public List<SpenObjectSpan> findObjectSpan(List<SpenObjectBase> list) {
        return findObjectSpan(list, false);
    }

    public int[] findObjectSpanCursorPosition(List<SpenObjectBase> list) {
        List<SpenObjectSpan> listFindObjectSpan = findObjectSpan(list);
        if (listFindObjectSpan.isEmpty()) {
            Logger.m11000e(TAG, "findObjectSpanCursorPosition# empty object span");
            return new int[]{0, 0};
        }
        int[] iArr = {listFindObjectSpan.get(0).getTextIndex(), listFindObjectSpan.get(0).getTextIndex()};
        for (SpenObjectSpan spenObjectSpan : listFindObjectSpan) {
            if (iArr[0] > spenObjectSpan.getTextIndex()) {
                iArr[0] = spenObjectSpan.getTextIndex();
            }
            if (iArr[1] < spenObjectSpan.getTextIndex()) {
                iArr[1] = spenObjectSpan.getTextIndex();
            }
        }
        iArr[1] = iArr[1] + 1;
        return iArr;
    }

    public List<SpenObjectSpan> findObjectSpan(List<SpenObjectBase> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenObjectSpan> objectSpan = this.mNote.getBodyText().getObjectSpan();
        if (objectSpan != null) {
            ArrayList arrayList2 = new ArrayList(list);
            for (SpenObjectSpan spenObjectSpan : objectSpan) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    SpenObjectBase spenObjectBase = (SpenObjectBase) it.next();
                    SpenObjectBase obj = spenObjectSpan.getObj();
                    if (obj != null && obj.getId().equals(spenObjectBase.getId()) && (!z || obj.getType() != 22 || obj.getRemovable())) {
                        arrayList.add(spenObjectSpan);
                        it.remove();
                        break;
                    }
                }
                if (arrayList2.isEmpty()) {
                    break;
                }
            }
        }
        return arrayList;
    }
}
