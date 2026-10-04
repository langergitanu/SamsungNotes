package com.samsung.android.support.senl.p148nt.composer.main.base.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerSpenDocModel {
    private static final int OBJECT_FILTER_TYPE = 8708;
    private static final String TAG = Logger.createTag("ComposerSpenDocModel");
    private static final int UNDO_REDO_HISTORY_SIZE = 50;
    private SpenWordDocument mDoc = null;

    private boolean isLargeSizeType(int i) {
        return i == 3 || i == 10 || i == 14;
    }

    public boolean canAllowToChangeCoedit() {
        return DocumentCopyUtils.canAllowToChangeCoedit(this.mDoc) == 101;
    }

    public void clearCanvasCacheData() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return;
        }
        Iterator<SpenWPage> it = spenWordDocument.getPageList().iterator();
        while (it.hasNext()) {
            it.next().clearCanvasCacheData();
        }
    }

    public String getDetailNoteStyleAndScrollType(boolean z, int i) {
        if (this.mDoc == null) {
            return "";
        }
        if (isSingleMode()) {
            return "a";
        }
        if (this.mDoc.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
            return z ? "g" : "h";
        }
        int iMax = Math.max(this.mDoc.getPageCount(), 2);
        for (int i2 = 0; i2 < iMax; i2++) {
            SpenWPage page = this.mDoc.getPage(i2);
            if (page.getWidth() * 2.0f > page.getHeight()) {
                return z ? "b" : i == 2 ? "d" : "c";
            }
        }
        return z ? "e" : i == 2 ? "i" : "f";
    }

    public SpenWNote getDoc() {
        return this.mDoc;
    }

    public int getDocHeight(boolean z) {
        SpenWordDocument spenWordDocument = this.mDoc;
        int height = 0;
        if (spenWordDocument == null) {
            return 0;
        }
        ArrayList<SpenWPage> pageList = spenWordDocument.getPageList();
        int size = pageList.size();
        Iterator<SpenWPage> it = pageList.iterator();
        while (it.hasNext()) {
            height += it.next().getHeight();
        }
        return (z || size <= 1) ? height : height - pageList.get(size - 1).getHeight();
    }

    @NonNull
    public List<SpenObjectBase> getFilteredLargeSizeItems(@NonNull List<SpenObjectBase> list) {
        ArrayList arrayList = new ArrayList();
        for (SpenObjectBase spenObjectBase : list) {
            if (isLargeSizeType(spenObjectBase.getType())) {
                arrayList.add(spenObjectBase);
            }
        }
        return arrayList;
    }

    public int getLargeSizeItemsCount() {
        SpenWordDocument spenWordDocument = this.mDoc;
        int objectCount = 0;
        if (spenWordDocument == null) {
            return 0;
        }
        Iterator<SpenWPage> it = spenWordDocument.getPageList().iterator();
        while (it.hasNext()) {
            objectCount += it.next().getObjectCount(OBJECT_FILTER_TYPE, true);
        }
        return this.mDoc.getBodyObjectCount(OBJECT_FILTER_TYPE) + objectCount;
    }

    public int getLogBodyTextLength() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return 0;
        }
        return ModelLogger.getTextBoxLength(spenWordDocument.getBodyText());
    }

    public int getPageCountForLog() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return 0;
        }
        if (spenWordDocument.getPageMode() == SpenWNote.PageMode.SINGLE) {
            return 1;
        }
        return this.mDoc.getPageCount() - 1;
    }

    public int getPageHeight(int i) {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument != null) {
            return spenWordDocument.getPage(i).getHeight();
        }
        return 0;
    }

    public int getPageLengthInSingleMode() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return 1;
        }
        try {
            return (int) (spenWordDocument.getPage(0).getDrawnRectOfAllObject().bottom / 297.0f);
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("getPageLengthInSingleMode#, error "), TAG);
            return 1;
        }
    }

    public int getPageWidth(int i) {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument != null) {
            return spenWordDocument.getPage(i).getWidth();
        }
        return 0;
    }

    public String getSpenDocInfo(boolean z) {
        int size;
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return "";
        }
        if (spenWordDocument.isClosed()) {
            return "isClosed";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(ModelLogger.getContentLog(this.mDoc));
        } else {
            sb.append(", pageC: ");
            sb.append(this.mDoc.getPageCount());
        }
        boolean z2 = false;
        if (this.mDoc.getPageCount() > 0) {
            sb.append(", bg: ");
            sb.append(this.mDoc.getPage(0).getBackgroundColor());
            sb.append(", invert: ");
            sb.append(this.mDoc.isBackgroundColorInverted());
        }
        if (!z) {
            return sb.toString();
        }
        ArrayList<SpenVoiceData> voiceDataList = this.mDoc.getVoiceDataList();
        if (voiceDataList != null && (size = voiceDataList.size()) > 0) {
            sb.append(", Voice: ");
            sb.append(size);
        }
        Iterator<SpenWPage> it = this.mDoc.getPageList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SpenWPage next = it.next();
            if (next.hasPDF()) {
                z2 = true;
                break;
            }
            if (!z2 && next.getTemplateType() == 12 && next.hasBackgroundImage()) {
                z2 = true;
            }
        }
        if (z2) {
            sb.append(", hasPdfOrBGImage: true ");
        }
        return sb.toString();
    }

    public int getStickyMemoCountForLog() {
        SpenWordDocument spenWordDocument = this.mDoc;
        int customObjectCount = 0;
        if (spenWordDocument != null && spenWordDocument.hasCustomObject()) {
            Iterator<SpenWPage> it = this.mDoc.getPageList().iterator();
            while (it.hasNext()) {
                customObjectCount += it.next().getCustomObjectCount();
            }
        }
        return customObjectCount;
    }

    public int getXmlDataWeight() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument != null) {
            return spenWordDocument.getCoeditXmlDataWeight();
        }
        return 0;
    }

    public boolean hasCodeBlockObject() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return false;
        }
        return spenWordDocument.hasBodyObject(23);
    }

    public boolean hasPdf(int i) {
        SpenWordDocument spenWordDocument = this.mDoc;
        return spenWordDocument != null && spenWordDocument.getPage(i).hasPDF();
    }

    public boolean hasStickyMemo() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return false;
        }
        return spenWordDocument.hasCustomObject();
    }

    public boolean hasStrokeInSelected() {
        ArrayList<SpenObjectBase> selectedObject;
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null || (selectedObject = spenWordDocument.getSelectedObject()) == null) {
            return false;
        }
        Iterator<SpenObjectBase> it = selectedObject.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTableObject() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return false;
        }
        return spenWordDocument.hasBodyObject(22);
    }

    public boolean hasTextFormat() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return false;
        }
        if (hasTextFormat(spenWordDocument.getBodyText())) {
            return true;
        }
        Iterator<SpenWPage> it = this.mDoc.getPageList().iterator();
        while (it.hasNext()) {
            ArrayList<SpenObjectBase> objectList = it.next().getObjectList(66);
            if (objectList != null) {
                for (SpenObjectBase spenObjectBase : objectList) {
                    if ((spenObjectBase instanceof SpenObjectShape) && hasTextFormat((SpenObjectShape) spenObjectBase)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasUnknownObject() {
        SpenWordDocument spenWordDocument = this.mDoc;
        return (spenWordDocument == null || spenWordDocument.getMinUnknownVersion() == 0) ? false : true;
    }

    public boolean isBodyTextOnlyNote() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return false;
        }
        for (SpenWPage spenWPage : spenWordDocument.getPageList()) {
            if (spenWPage.getObjectCount(true) > 0 || spenWPage.hasPDF() || spenWPage.getTemplateType() != 0) {
                return false;
            }
        }
        return this.mDoc.getBodyObjectCount() == 0;
    }

    public boolean isHandwritingOnlyNote() {
        SpenWordDocument spenWordDocument = this.mDoc;
        if (spenWordDocument == null) {
            return false;
        }
        if (spenWordDocument.getBodyText().getText() != null && !this.mDoc.getBodyText().getText().trim().isEmpty()) {
            return false;
        }
        int size = 0;
        for (SpenWPage spenWPage : this.mDoc.getPageList()) {
            if (spenWPage.hasPDF()) {
                return false;
            }
            size += spenWPage.getObjectList(1).size();
            if (size >= 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isLocked() {
        SpenWordDocument spenWordDocument = this.mDoc;
        return spenWordDocument != null && spenWordDocument.isLocked();
    }

    public boolean isSingleMode() {
        SpenWordDocument spenWordDocument = this.mDoc;
        return spenWordDocument != null && spenWordDocument.getPageMode() == SpenWNote.PageMode.SINGLE;
    }

    public void setDoc(SpenWordDocument spenWordDocument) {
        this.mDoc = spenWordDocument;
        if (spenWordDocument != null) {
            spenWordDocument.setUndoLimit(50);
        }
    }

    public void setStrokeRecognitionData(Map<String, ArrayList<SpenWPage.StrokeRecognitionData>> map, List<String> list, boolean z) {
        Logger.m11003i(TAG, "setStrokeRecognitionData#, page size : " + map.size());
        boolean zIsChanged = this.mDoc.isChanged();
        ArrayList<SpenWPage> pageList = this.mDoc.getPageList();
        for (Map.Entry<String, ArrayList<SpenWPage.StrokeRecognitionData>> entry : map.entrySet()) {
            try {
                String key = entry.getKey();
                SpenWPage spenWPage = pageList.get(this.mDoc.getPageIndexById(key));
                if (list.contains(key)) {
                    spenWPage.setStrokeRecognitionData(null);
                }
                spenWPage.setStrokeRecognitionData(entry.getValue());
                spenWPage.setRecognizedDataModifiedTime(spenWPage.getModifiedTime());
            } catch (SpenAlreadyClosedException e) {
                Logger.m11000e(TAG, e.getMessage());
            } catch (IllegalArgumentException e2) {
                e = e2;
                Logger.m11000e(TAG, "setStrokeRecognitionData, exception  " + e.getMessage());
            } catch (NullPointerException e3) {
                e = e3;
                Logger.m11000e(TAG, "setStrokeRecognitionData, exception  " + e.getMessage());
            }
        }
        if (zIsChanged || !z) {
            return;
        }
        this.mDoc.clearChangedFlag();
    }

    @NonNull
    public List<SpenObjectSpan> getFilteredLargeSizeItems(@NonNull SpenObjectTextBox spenObjectTextBox) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenObjectSpan> objectSpan = spenObjectTextBox.getObjectSpan();
        if (objectSpan != null) {
            for (SpenObjectSpan spenObjectSpan : objectSpan) {
                if (isLargeSizeType(spenObjectSpan.getObject().getType())) {
                    arrayList.add(spenObjectSpan);
                }
            }
        }
        return arrayList;
    }

    private boolean hasTextFormat(SpenObjectShape spenObjectShape) {
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph;
        String text = spenObjectShape.getText();
        return (TextUtils.isEmpty(text) || (arrayListFindTextParagraph = spenObjectShape.findTextParagraph(0, text.length(), 1024)) == null || arrayListFindTextParagraph.isEmpty()) ? false : true;
    }
}
