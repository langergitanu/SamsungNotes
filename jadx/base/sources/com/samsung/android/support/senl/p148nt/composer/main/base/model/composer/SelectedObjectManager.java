package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.graphics.Point;
import android.graphics.RectF;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SelectedObjectManager {
    private static final String TAG = Logger.createTag("SelectedObjectManager");
    protected SpenWNote mNote;
    private PdfManager mPdfManager;
    private ArrayList<SpenObjectBase> mSelectedObjectList;
    private ArrayList<SpenWPage> mSelectedObjectPageList;
    private ISpenControlObjectManager mSpenControlObjectManager;
    protected TextManager mTextManager;

    private int[] getSelectedObjectSpan() {
        if (isSelectedBodyText()) {
            return new int[]{-1};
        }
        List<SpenObjectSpan> listFindObjectSpan = new ObjectSpanHelper(this.mNote).findObjectSpan(this.mSelectedObjectList);
        if (listFindObjectSpan.isEmpty()) {
            return new int[]{-1};
        }
        int[] iArr = new int[listFindObjectSpan.size()];
        Iterator<SpenObjectSpan> it = listFindObjectSpan.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().getTextIndex();
            i++;
        }
        return iArr;
    }

    private void restoreSelectedObjectSpan(int[] iArr) {
        ArrayList<SpenObjectSpan> objectSpan = this.mNote.getBodyText().getObjectSpan();
        if (objectSpan == null || objectSpan.isEmpty()) {
            return;
        }
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>(iArr.length);
        for (int i : iArr) {
            try {
                arrayList.add(this.mNote.getBodyText().getObjectSpanAtTextIndex(i).getObject());
            } catch (Exception unused) {
                Logger.m11000e(TAG, "restoreSelectedObjectSpan# error textIndex. " + i);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.mNote.selectObject(arrayList);
    }

    private void restoreTextBox(SpenObjectShape spenObjectShape, int i) {
        this.mTextManager.setFocusedTextBox(spenObjectShape);
        this.mNote.selectObject((SpenObjectBase) null);
        this.mNote.selectObject(spenObjectShape);
        int length = spenObjectShape.getText() != null ? spenObjectShape.getText().length() : 0;
        if (i >= 0) {
            if (i > length) {
                i = 0;
            }
            spenObjectShape.setCursorPosition(i);
        }
    }

    public void bringToFront() {
        if (this.mSelectedObjectList == null) {
            return;
        }
        for (int i = 0; i < this.mSelectedObjectList.size(); i++) {
            SpenWPage spenWPage = this.mSelectedObjectPageList.get(i);
            SpenObjectBase spenObjectBase = this.mSelectedObjectList.get(i);
            spenWPage.moveObjectIndex(spenObjectBase, (spenWPage.getObjectCount(true) - spenWPage.getObjectIndex(spenObjectBase)) - 1, false);
        }
        this.mNote.commitHistory();
        clearSelectObject();
    }

    public void clear() {
        this.mSelectedObjectPageList = null;
        this.mSelectedObjectList = null;
    }

    public void clearSelectObject() {
        clearSelectObject(true);
    }

    public void clearSelectedTextTypeObject() {
        if (this.mSelectedObjectPageList == null || !isSelectedTextBox()) {
            return;
        }
        clearSelectObject(true);
    }

    public void clearSelection() {
        if (isFocusedTextBox()) {
            this.mTextManager.clearSelection();
        } else if (!isSelectedObjectOfObjectSpan()) {
            clearSelectObject(false);
        } else {
            SpenWNote spenWNote = this.mNote;
            spenWNote.selectObject(spenWNote.getBodyText());
        }
    }

    public void closeObjectControlExceptTextBox() {
        if (isSelectedTextBox()) {
            return;
        }
        selectObject(null);
    }

    public RectF getRectSelectedObjectList() {
        ArrayList<SpenWPage> arrayList;
        RectF rectF = new RectF();
        ArrayList<SpenObjectBase> arrayList2 = this.mSelectedObjectList;
        if (arrayList2 != null && !arrayList2.isEmpty() && (arrayList = this.mSelectedObjectPageList) != null && !arrayList.isEmpty()) {
            for (SpenWPage spenWPage : this.mSelectedObjectPageList) {
                Point offset = spenWPage.getOffset();
                ArrayList<SpenObjectBase> objectList = spenWPage.getObjectList();
                for (SpenObjectBase spenObjectBase : this.mSelectedObjectList) {
                    if (objectList.contains(spenObjectBase)) {
                        RectF rect = spenObjectBase.getRect();
                        rect.offset(offset.x, offset.y);
                        rectF.union(rect);
                    }
                }
            }
        }
        return rectF;
    }

    public List<SpenObjectBase> getSelectedObjectList() {
        return this.mNote.getSelectedObject();
    }

    public ArrayList<SpenWPage> getSelectedObjectPageList() {
        return this.mSelectedObjectPageList;
    }

    public ArrayList<SpenObjectBase> getSelectedSafeObjectList() {
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        List<SpenObjectBase> selectedObjectList = getSelectedObjectList();
        if (selectedObjectList != null && !selectedObjectList.isEmpty()) {
            for (SpenObjectBase spenObjectBase : selectedObjectList) {
                if (spenObjectBase.isAllContentFileAvailable()) {
                    arrayList.add(spenObjectBase);
                } else {
                    Logger.m11003i(TAG, "getSelectedSafeObjectList# isAllContentFileAvailable is false. id:" + spenObjectBase.getId());
                }
            }
        }
        return arrayList;
    }

    public void init(SpenWNote spenWNote, TextManager textManager, PdfManager pdfManager) {
        this.mNote = spenWNote;
        this.mTextManager = textManager;
        this.mPdfManager = pdfManager;
        clear();
    }

    public boolean isFocusedTable() {
        if (isSelectedTable(this.mSelectedObjectList)) {
            return this.mSpenControlObjectManager.hasFocus();
        }
        return false;
    }

    public boolean isFocusedTextBox() {
        return isSelectedTextBox(this.mSelectedObjectList) ? this.mSelectedObjectPageList == null || this.mSpenControlObjectManager.hasFocus() : this.mTextManager.hasFocusedTextBox();
    }

    public boolean isObjectMathSelected() {
        ArrayList<SpenObjectBase> arrayList = this.mSelectedObjectList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<SpenObjectBase> it = this.mSelectedObjectList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 21) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isObjectPlotSelected() {
        ArrayList<SpenObjectBase> arrayList = this.mSelectedObjectList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<SpenObjectBase> it = this.mSelectedObjectList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 20) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPureStrokeSelectedOnly() {
        return ObjectTypeUtil.hasPureStrokeTypeOnly(this.mSelectedObjectList);
    }

    public boolean isSelectedBodyText() {
        return this.mSelectedObjectPageList == null && isSelectedTextBox();
    }

    public boolean isSelectedFloatingTextBox() {
        return this.mSelectedObjectPageList != null && isSelectedTextBox();
    }

    public boolean isSelectedObject() {
        ArrayList<SpenObjectBase> arrayList = this.mSelectedObjectList;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public boolean isSelectedObjectOfObjectSpan() {
        return (this.mSelectedObjectPageList != null || this.mSelectedObjectList == null || isSelectedTextBox()) ? false : true;
    }

    public boolean isSelectedTable() {
        return isSelectedTable(this.mSelectedObjectList);
    }

    public boolean isSelectedTextBox() {
        return isSelectedTextBox(this.mSelectedObjectList);
    }

    public void restoreState(SavedState savedState) {
        String str = TAG;
        Logger.m10999d(str, "restoreState#");
        if (savedState.getLastSelectedObjectIndexArray() == null) {
            Logger.m11003i(str, "restoreState# getLastSelectedObjectIndexArray is null.");
            List<SpenObjectBase> selectedObjectList = getSelectedObjectList();
            if (selectedObjectList == null || selectedObjectList.isEmpty()) {
                return;
            }
            clearSelectObject();
            return;
        }
        try {
            String[] lastSelectedPageIdArray = savedState.getLastSelectedPageIdArray();
            int[] lastSelectedObjectIndexArray = savedState.getLastSelectedObjectIndexArray();
            if (lastSelectedPageIdArray == null) {
                restoreTextBox(this.mNote.getBodyText(), savedState.getCursorStart());
                Logger.m11003i(str, "restoreState# bodytext : " + savedState.getCursorStart());
                restoreSelectedObjectSpan(lastSelectedObjectIndexArray);
                return;
            }
            if (lastSelectedObjectIndexArray.length == 1 && savedState.getCursorStart() != -1) {
                int pageIndexById = this.mNote.getPageIndexById(lastSelectedPageIdArray[0]);
                restoreTextBox((SpenObjectShape) this.mNote.getPage(pageIndexById).getObject(lastSelectedObjectIndexArray[0]), savedState.getCursorStart());
                setFocus(true);
                Logger.m11003i(str, "restoreState# " + pageIndexById + " page textbox(" + lastSelectedObjectIndexArray[0] + ") cursor " + savedState.getCursorStart());
                return;
            }
            ArrayList<SpenObjectBase> arrayList = new ArrayList<>(lastSelectedPageIdArray.length);
            for (int i = 0; i < lastSelectedPageIdArray.length; i++) {
                try {
                    arrayList.add(this.mNote.getPage(this.mNote.getPageIndexById(lastSelectedPageIdArray[i])).getObject(lastSelectedObjectIndexArray[i]));
                } catch (Exception unused) {
                    Logger.m11000e(TAG, "restoreState# error pageIds " + lastSelectedPageIdArray[i] + " / " + lastSelectedObjectIndexArray[i]);
                }
            }
            this.mNote.selectObject(arrayList);
        } catch (Exception e) {
            AbstractC8014b.m7207i("restoreState# Exception e = ", e, TAG);
        }
    }

    public void saveState(SavedState savedState) {
        String str = TAG;
        Logger.m11003i(str, "saveState#");
        if (this.mSelectedObjectPageList != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.mSelectedObjectList.size(); i++) {
                SpenObjectBase spenObjectBase = this.mSelectedObjectList.get(i);
                if (spenObjectBase.getType() != 2 || !TextUtils.isEmpty(((SpenObjectTextBox) spenObjectBase).getText())) {
                    SpenWPage spenWPage = this.mSelectedObjectPageList.get(i);
                    String id = spenWPage.getId();
                    try {
                        int objectIndex = spenWPage.getObjectIndex(spenObjectBase);
                        arrayList.add(id);
                        arrayList2.add(Integer.valueOf(objectIndex));
                    } catch (SpenAlreadyClosedException e) {
                        Logger.m11001e(TAG, "saveState## " + e.getMessage(), e);
                        arrayList.clear();
                        arrayList2.clear();
                    } catch (IllegalArgumentException e2) {
                        Logger.m11001e(TAG, "saveState## " + e2.getMessage(), e2);
                    }
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            int size = arrayList2.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = ((Integer) arrayList2.get(i2)).intValue();
            }
            savedState.setLastSelectedPageIdArray(strArr);
            savedState.setLastSelectedObjectIndexArray(iArr);
        } else {
            if (this.mSelectedObjectList == null) {
                return;
            }
            Logger.m11003i(str, "saveState# body text has a focus");
            savedState.setLastSelectedPageIdArray(null);
            savedState.setLastSelectedObjectIndexArray(getSelectedObjectSpan());
        }
        if (this.mSelectedObjectList.size() == 1 && isFocusedTextBox()) {
            TextManager textManager = this.mTextManager;
            int[] cursor = textManager.getCursor(textManager.getTextBox());
            String str2 = TAG;
            StringBuilder sb = new StringBuilder("saveState# cursor ");
            sb.append(cursor[0]);
            sb.append(" ~ ");
            AbstractC8014b.m7195A(sb, str2, cursor[1]);
            savedState.setCursor(cursor[0], cursor[1]);
        }
    }

    public void selectObject(SpenObjectBase spenObjectBase) {
        this.mNote.selectObject(spenObjectBase);
    }

    public void selectObjectList(ArrayList<SpenObjectBase> arrayList) {
        this.mNote.selectObject(arrayList);
    }

    public void sendToBack() {
        ArrayList<SpenObjectBase> arrayList = this.mSelectedObjectList;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            SpenWPage spenWPage = this.mSelectedObjectPageList.get(size);
            SpenObjectBase spenObjectBase = this.mSelectedObjectList.get(size);
            spenWPage.moveObjectIndex(spenObjectBase, -spenWPage.getObjectIndex(spenObjectBase), false);
        }
        this.mNote.commitHistory();
        clearSelectObject();
    }

    public void setControlObject(ISpenControlObjectManager iSpenControlObjectManager) {
        this.mSpenControlObjectManager = iSpenControlObjectManager;
    }

    public void setFocus(boolean z) {
        this.mSpenControlObjectManager.setFocus(z);
    }

    public void setFocusCell(int i, int i2, boolean z) {
        this.mSpenControlObjectManager.setFocusCell(i, i2, z);
    }

    public void setFocusCurTextBox() {
        if (!isSelectedTextBox() || this.mSelectedObjectPageList == null || this.mSpenControlObjectManager.hasFocus()) {
            return;
        }
        setFocus(true);
    }

    public void updateSelectedObject(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2) {
        this.mTextManager.resetSelectedBodyTextBox();
        this.mTextManager.resetSelectedTable();
        if (arrayList2 == null) {
            clear();
            this.mTextManager.clearRtState();
            this.mTextManager.setFocusedTextBox(this.mNote.getBodyText());
            return;
        }
        if (isSelectedTextBox(arrayList2)) {
            this.mTextManager.setFocusedTextBox((SpenObjectShape) arrayList2.get(0));
            if (this.mNote.getBodyText().hashCode() == arrayList2.get(0).hashCode()) {
                this.mTextManager.setSelectedBodyTextBox((SpenObjectShape) arrayList2.get(0));
            }
        } else if (isSelectedTable(arrayList2)) {
            this.mTextManager.setSelectedTable((SpenObjectTable) arrayList2.get(0));
        }
        this.mSelectedObjectPageList = arrayList;
        this.mSelectedObjectList = arrayList2;
    }

    public void clearSelectObject(boolean z) {
        clearSelectObject(z, true);
    }

    public boolean isSelectedTable(List<SpenObjectBase> list) {
        if (list == null || list.size() != 1) {
            return false;
        }
        return ObjectTypeUtil.isTableType(list.get(0).getType());
    }

    public boolean isSelectedTextBox(List<SpenObjectBase> list) {
        if (list == null || list.size() != 1) {
            return false;
        }
        return ObjectTypeUtil.isTextType(list.get(0).getType());
    }

    public void clearSelectObject(boolean z, boolean z2) {
        TextManager textManager;
        if (z && (textManager = this.mTextManager) != null) {
            textManager.clearSelection();
        }
        PdfManager pdfManager = this.mPdfManager;
        if (pdfManager != null && z2) {
            pdfManager.clearSelection();
        }
        SpenWNote spenWNote = this.mNote;
        if (spenWNote == null || spenWNote.isClosed()) {
            return;
        }
        this.mNote.selectObject((SpenObjectBase) null);
    }
}
