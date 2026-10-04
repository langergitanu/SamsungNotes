package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MenuSAUtils {
    private static final String TAG = Logger.createTag("MenuSAUtils");

    public static String getSADetailValue(PdfManager pdfManager, ObjectManager objectManager) {
        int type;
        if (pdfManager != null) {
            if (pdfManager.hasSelectedText()) {
                return "1";
            }
            if (pdfManager.hasSelectedImage()) {
                return "2";
            }
        }
        List<SpenObjectBase> selectedObjectList = objectManager.getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.isEmpty()) {
            Logger.m11000e(TAG, "getSADetailValue# SelectedObjectList is null");
            return "1";
        }
        if (objectManager.isSelectedObjectOfObjectSpan()) {
            List<SpenObjectSpan> listFindObjectSpan = new ObjectSpanHelper(objectManager.getNote()).findObjectSpan(selectedObjectList);
            if (listFindObjectSpan == null || listFindObjectSpan.isEmpty()) {
                Logger.m11000e(TAG, "getSADetailValue# findObjectSpan is null");
                return "1";
            }
            type = listFindObjectSpan.get(0).getObject().getType();
        } else {
            type = selectedObjectList.get(0).getType();
        }
        return type == 2 ? "1" : type == 3 ? "2" : type == 14 ? "3" : type == 10 ? "4" : type == 13 ? "5" : (type == 1 || type == 7 || type == 8 || type == 4) ? "7" : "1";
    }
}
