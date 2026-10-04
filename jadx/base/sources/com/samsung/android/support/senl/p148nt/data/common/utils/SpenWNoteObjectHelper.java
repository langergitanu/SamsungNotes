package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.base.SpenObjectFindType;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenWNoteObjectHelper<SPenObject extends SpenObjectBase> {
    private static final String TAG = DataLogger.createTag("SpenWNoteObjectHelper");

    public static boolean existOnlyStrokeObject(@NonNull SpenWNote spenWNote) {
        if (spenWNote.getBodyText() != null && !isEmptyBodyText(spenWNote.getBodyText().getText())) {
            DataLogger.m12307i(TAG, "existOnlyStrokeObject, body text exists");
            return false;
        }
        SpenWNoteObjectHelper spenWNoteObjectHelper = new SpenWNoteObjectHelper();
        boolean z = spenWNoteObjectHelper.hasObject(spenWNote, 1) || spenWNoteObjectHelper.hasObject(spenWNote, 7) || spenWNoteObjectHelper.hasObject(spenWNote, 8);
        AbstractC11014a.m12335t("existOnlyStrokeObject, find stroke object : ", TAG, z);
        return z;
    }

    private SPenObject findFirstPageObject(@NonNull SpenWNote spenWNote, int i) {
        for (int i2 = 0; i2 < spenWNote.getPageCount(); i2++) {
            ArrayList<SpenObjectBase> objectList = spenWNote.getPage(i2).getObjectList(i);
            if (!objectList.isEmpty()) {
                return (SPenObject) objectList.get(0);
            }
        }
        return null;
    }

    @Nullable
    public static <SPenObject extends SpenObjectBase> SPenObject getFirstObject(SpenWPage spenWPage, int i) {
        ArrayList<SpenObjectBase> objectList = spenWPage.getObjectList(i);
        if (objectList.isEmpty()) {
            return null;
        }
        return (SPenObject) objectList.get(0);
    }

    public static boolean hasPdfObject(SpenWPage spenWPage) {
        return (spenWPage == null || !spenWPage.hasPDF() || spenWPage.getTemplateType() == 16) ? false : true;
    }

    public static boolean hasPdfObjectRegardlessOfType(SpenWPage spenWPage) {
        return spenWPage != null && spenWPage.hasPDF();
    }

    public static boolean isEmptyBodyText(String str) {
        if (str == null) {
            return true;
        }
        String strRemoveObjectReplacementChar = UnicodeUtils.removeObjectReplacementChar(str);
        return TextUtils.isEmpty(strRemoveObjectReplacementChar) || strRemoveObjectReplacementChar.matches("\\s*");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getSortedBodyObjects$1(SpenObjectBase spenObjectBase, SpenObjectBase spenObjectBase2) {
        return Float.compare(spenObjectBase.getPageIndex(), spenObjectBase2.getPageIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getSortedObjectList$0(SpenObjectBase spenObjectBase, SpenObjectBase spenObjectBase2) {
        return Float.compare(spenObjectBase.getRect().top, spenObjectBase2.getRect().top);
    }

    public SPenObject findFirstBodyObject(@NonNull SpenWNote spenWNote, int i) {
        ArrayList<SpenObjectBase> bodyObjectList = spenWNote.getBodyObjectList(i);
        if (bodyObjectList == null || bodyObjectList.isEmpty()) {
            return null;
        }
        return (SPenObject) bodyObjectList.get(0);
    }

    public SPenObject findFirstObject(@NonNull SpenWNote spenWNote, int i, int i2) {
        if (!hasObject(spenWNote, i)) {
            DataLogger.m12307i(TAG, "findFirstObject, object not exist");
            return null;
        }
        SPenObject spenobject = (SPenObject) findFirstBodyObject(spenWNote, i2);
        SpenObjectBase spenObjectBaseFindFirstPageObject = findFirstPageObject(spenWNote, i2);
        if (spenobject == null && spenObjectBaseFindFirstPageObject == null) {
            return null;
        }
        if (spenobject == null || spenObjectBaseFindFirstPageObject == null ? spenObjectBaseFindFirstPageObject != null : spenobject.getRect().top >= spenObjectBaseFindFirstPageObject.getRect().top) {
            spenobject = (SPenObject) spenObjectBaseFindFirstPageObject;
        }
        DataLogger.m12307i(TAG, "findFirstObject, first : " + spenobject);
        return spenobject;
    }

    @NonNull
    public List<SPenObject> getObjectList(@NonNull SpenWNote spenWNote, int i) {
        ArrayList arrayList = new ArrayList();
        int pageCount = spenWNote.getPageCount();
        for (int i2 = 0; i2 < pageCount; i2++) {
            ArrayList<SpenObjectBase> objectList = spenWNote.getPage(i2).getObjectList(i);
            if (!objectList.isEmpty()) {
                arrayList.addAll(objectList);
            }
        }
        ArrayList<SpenObjectBase> bodyObjectList = spenWNote.getBodyObjectList(i);
        if (bodyObjectList != null && !bodyObjectList.isEmpty()) {
            arrayList.addAll(bodyObjectList);
        }
        return arrayList;
    }

    @NonNull
    public List<SpenObjectBase> getSortedBodyObjects(@NonNull SpenWNote spenWNote) {
        ArrayList<SpenObjectBase> bodyObjectList = spenWNote.getBodyObjectList(SpenObjectFindType.ALL);
        if (bodyObjectList == null) {
            return new ArrayList();
        }
        bodyObjectList.sort(new C0016a(12));
        return bodyObjectList;
    }

    @NonNull
    public List<SPenObject> getSortedObjectList(@NonNull SpenWNote spenWNote, int i) {
        List<SPenObject> objectList = getObjectList(spenWNote, i);
        objectList.sort(new C0016a(11));
        return objectList;
    }

    public boolean hasCustomPdf(@NonNull SpenWNote spenWNote) {
        Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
        while (it.hasNext()) {
            if (hasPdfObject(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasObject(SpenWNote spenWNote, int i) {
        return spenWNote.hasObject(i) || spenWNote.hasBodyObject(i);
    }
}
