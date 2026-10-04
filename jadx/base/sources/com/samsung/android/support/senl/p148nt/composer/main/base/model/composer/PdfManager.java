package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfCursorPosition;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfListener;
import com.samsung.android.sdk.pdf.SpenPdfParagraph;
import com.samsung.android.sdk.pdf.SpenPdfTextConverter;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenNotePdfActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.repository.data.pdf.PDFDataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfManager implements PDFDataSource {
    private static final String TAG = Logger.createTag("PdfManager");
    private AttachPdfStateListener mAttachPdfStateListener;
    private String mCacheDirPath;
    private boolean mIsAvailableAddToNoteWithTranslation;
    private boolean mIsReadOnlyNoteData;
    private PdfPageListener mPdfPageListener;
    private PdfSelectionChangedListener mPdfSelectionChangedListener;
    private SelectedPdfStateListener mSelectedPdfStateListener;
    private SpenNotePdfActionListenerImpl mSpenNotePdfActionListener;
    private SpenNotePdfListenerImpl mSpenNotePdfListenerImpl;
    private ISpenNotePdfManager mSpenPdfManager;
    private final Map<Integer, Pair<Integer, String[]>> mTranslationCacheMap = new ConcurrentHashMap();
    private SparseArray<String[]> mTranslationMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AttachPdfStateListener {
        void onCompleted();

        void onProgressChanged(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PdfPageListener {
        void onLoadPdfPage(int i);

        void onUnLoadPdfPage(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PdfSelectionChangedListener {
        void onCursorChanged(SpenNotePdfCursorPosition spenNotePdfCursorPosition, SpenNotePdfCursorPosition spenNotePdfCursorPosition2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SelectedPdfStateListener {
        void onMaxSelectionTextLengthReached();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SpenNotePdfListenerImpl extends SpenNotePdfListener {
        public /* synthetic */ SpenNotePdfListenerImpl(PdfManager pdfManager, int i) {
            this();
        }

        @Override // com.samsung.android.sdk.composer.pdf.SpenNotePdfListener
        public void onCompleted() {
            if (PdfManager.this.mAttachPdfStateListener != null) {
                PdfManager.this.mAttachPdfStateListener.onCompleted();
            }
        }

        @Override // com.samsung.android.sdk.composer.pdf.SpenNotePdfListener
        public void onCursorChanged(SpenNotePdfCursorPosition spenNotePdfCursorPosition, SpenNotePdfCursorPosition spenNotePdfCursorPosition2) {
            if (PdfManager.this.mPdfSelectionChangedListener != null) {
                PdfManager.this.mPdfSelectionChangedListener.onCursorChanged(spenNotePdfCursorPosition, spenNotePdfCursorPosition2);
            }
        }

        @Override // com.samsung.android.sdk.composer.pdf.SpenNotePdfListener
        public void onLoadPdfPage(int i) {
            if (PdfManager.this.mPdfPageListener != null) {
                PdfManager.this.mPdfPageListener.onLoadPdfPage(i);
            }
        }

        @Override // com.samsung.android.sdk.composer.pdf.SpenNotePdfListener
        public void onMaxSelectionTextLengthReached() {
            if (PdfManager.this.mSelectedPdfStateListener != null) {
                PdfManager.this.mSelectedPdfStateListener.onMaxSelectionTextLengthReached();
            }
        }

        @Override // com.samsung.android.sdk.composer.pdf.SpenNotePdfListener
        public void onProgressChanged(int i) {
            if (PdfManager.this.mAttachPdfStateListener != null) {
                PdfManager.this.mAttachPdfStateListener.onProgressChanged(i);
            }
        }

        @Override // com.samsung.android.sdk.composer.pdf.SpenNotePdfListener
        public void onSelectionAreaLongPressed() {
            Logger.m10999d(PdfManager.TAG, "onSelectionAreaLongPressed#");
            if (PdfManager.this.mSpenNotePdfActionListener != null) {
                PdfManager.this.mSpenNotePdfActionListener.onSelectionAreaLongPressed();
            }
        }

        @Override // com.samsung.android.sdk.composer.pdf.SpenNotePdfListener
        public void onUnLoadPdfPage(int i) {
            if (PdfManager.this.mPdfPageListener != null) {
                PdfManager.this.mPdfPageListener.onUnLoadPdfPage(i);
            }
        }

        private SpenNotePdfListenerImpl() {
        }
    }

    public ISpenNotePdfManager.ResultType attach(int i, String str, String str2, boolean z) {
        ISpenNotePdfManager.AttachOption attachOption = ISpenNotePdfManager.AttachOption.NONE;
        if (z) {
            attachOption = ISpenNotePdfManager.AttachOption.APPLY_TEMPLATE;
        }
        return this.mSpenPdfManager.attachFile(i, str, str2, attachOption, this.mIsReadOnlyNoteData);
    }

    public void cancelToAttach() {
        this.mSpenPdfManager.cancelAttachFile();
    }

    public void clearAllOverlayImage() {
        Logger.m11003i("AI" + TAG, "clearAllOverlayImage#");
        this.mSpenPdfManager.clearAllOverlayImage();
        this.mIsAvailableAddToNoteWithTranslation = false;
    }

    public void clearAllOverlayText() {
        Logger.m11003i("AI" + TAG, "clearAllOverlayText#");
        this.mSpenPdfManager.clearAllOverlayText();
        this.mTranslationMap.clear();
        this.mIsAvailableAddToNoteWithTranslation = false;
    }

    public void clearSelection() {
        this.mSpenPdfManager.clearSelection();
    }

    public void clearTranslationCacheMap() {
        this.mTranslationCacheMap.clear();
    }

    public SpenWNote.PageMode convertPageMode(ISpenNotePdfManager.PageMode pageMode) {
        if (pageMode == ISpenNotePdfManager.PageMode.PAGE_MODE_LIST) {
            return SpenWNote.PageMode.LIST;
        }
        if (pageMode == ISpenNotePdfManager.PageMode.PAGE_MODE_SINGLE) {
            return SpenWNote.PageMode.SINGLE;
        }
        return null;
    }

    public void deletedPage(int i, int i2) {
        if (i == -1) {
            return;
        }
        if ((Build.VERSION.SDK_INT >= 30 && this.mTranslationMap.contains(i)) || this.mTranslationMap.indexOfKey(i) >= 0) {
            AbstractC0000a.m3D(i, "deletedPage# TranslationMap remove pageIndex from : ", TAG);
            this.mTranslationMap.remove(i);
        }
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            String[] strArr = this.mTranslationMap.get(i);
            if (strArr != null) {
                int i4 = i - 1;
                AbstractC8014b.m7221w(AbstractC0541b.m778t(i, "deletedPage# TranslationMap replace pageIndex from : ", ", to : "), TAG, i4);
                this.mTranslationMap.remove(i);
                this.mTranslationMap.put(i4, strArr);
            }
        }
    }

    public String getCacheDirPath() {
        return this.mCacheDirPath;
    }

    public Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> getCurrentCursor() {
        return Pair.create(this.mSpenPdfManager.getStartSelectionCursorPosition(), this.mSpenPdfManager.getEndSelectionCursorPosition());
    }

    public Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> getCursorByRect(RectF rectF) {
        return this.mSpenPdfManager.getCursorRangeByRect(rectF);
    }

    public SpenNotePdfCursorPosition getEndSelectionCursorPosition() {
        return this.mSpenPdfManager.getEndSelectionCursorPosition();
    }

    public SparseArray<Bitmap> getImageTranslationMap() {
        SparseArray<Bitmap> sparseArray = new SparseArray<>();
        int pageCount = this.mSpenPdfManager.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            Bitmap overlayImage = this.mSpenPdfManager.getOverlayImage(i);
            if (overlayImage != null) {
                sparseArray.put(i, Bitmap.createBitmap(overlayImage));
            }
        }
        return sparseArray;
    }

    public ISpenNotePdfManager.NoteOrientation getNoteOrientation(String str, String str2, ISpenNotePdfManager.PageMode pageMode) {
        return this.mSpenPdfManager.getNoteOrientation(str, str2, pageMode);
    }

    public int getOverlayTextLength(int i) {
        String str = TAG;
        Logger.startTime(str, str, "getPageOverlayTextLength#Start ");
        int overlayTextLength = this.mSpenPdfManager.getOverlayTextLength(i);
        Logger.endTime(str, str, "getPageOverlayTextLength#End : " + overlayTextLength);
        return overlayTextLength;
    }

    public int getPageCount(String str) {
        return this.mSpenPdfManager.getPageCount(str, "");
    }

    public Bitmap getPageImage(int i, float f) {
        AbstractC8014b.m7217s(i, "getPageImage# pageIndex : ", "AI" + TAG);
        return this.mSpenPdfManager.getPageImage(i, f);
    }

    public ISpenNotePdfManager.PageMode getPageMode(String str) {
        return this.mSpenPdfManager.getPageMode(str, "");
    }

    public String[] getPageTaggedTextList(int i) {
        AbstractC8014b.m7217s(i, "getPageTaggedTextList# pageIndex : ", "AI" + TAG);
        ArrayList<SpenPdfParagraph> pageRichTextList = this.mSpenPdfManager.getPageRichTextList(i);
        if (pageRichTextList == null || pageRichTextList.isEmpty()) {
            return new String[0];
        }
        String[] strArrCompose = SpenPdfTextConverter.compose(pageRichTextList);
        Iterator<SpenPdfParagraph> it = pageRichTextList.iterator();
        while (it.hasNext()) {
            it.next().getListPdfText().clear();
        }
        pageRichTextList.clear();
        return strArrCompose;
    }

    public int getPageTextLength(int i) {
        String str = TAG;
        Logger.startTime(str, str, "getPageTextLength#Start ");
        int pageTextLength = this.mSpenPdfManager.getPageTextLength(i);
        Logger.endTime(str, str, "getPageTextLength#End : " + pageTextLength);
        return pageTextLength;
    }

    public String[] getPageTextList(int i) {
        AbstractC8014b.m7217s(i, "getPageTextList# pageIndex : ", "AI" + TAG);
        return this.mSpenPdfManager.getPageTextList(i);
    }

    public RectF getPdfPageSize(int i) {
        return this.mSpenPdfManager.getPdfPageSize(i);
    }

    public RectF getRectByCursor(Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> pair) {
        return this.mSpenPdfManager.getRectByCursorRange((SpenNotePdfCursorPosition) pair.first, (SpenNotePdfCursorPosition) pair.second);
    }

    public boolean getSelectedImage(Bitmap bitmap) {
        return this.mSpenPdfManager.getSelectedImage(bitmap);
    }

    public RectF getSelectedImageRect() {
        return this.mSpenPdfManager.getSelectedImageRect();
    }

    public String getSelectedText() {
        return this.mSpenPdfManager.getSelectedText();
    }

    public SpenNotePdfCursorPosition getStartSelectionCursorPosition() {
        return this.mSpenPdfManager.getStartSelectionCursorPosition();
    }

    public String getTextFromCursor(Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> pair) {
        return "";
    }

    public int getTextLengthOnScreen() {
        return this.mSpenPdfManager.getTextLengthOnScreen();
    }

    public List<String> getTextsByRect(RectF rectF) {
        List<String> textByRect = this.mSpenPdfManager.getTextByRect(rectF);
        List<String> list = Collections.EMPTY_LIST;
        if (textByRect == null) {
            Objects.requireNonNull(list, "defaultObj");
            textByRect = list;
        }
        return textByRect;
    }

    public int getTranslatedPageCount() {
        return this.mTranslationMap.size();
    }

    public Map getTranslationCacheMap() {
        return new ConcurrentHashMap(this.mTranslationCacheMap);
    }

    public SparseArray<String[]> getTranslationMap() {
        return this.mTranslationMap.clone();
    }

    public boolean hasAnnotationPermission() {
        return this.mSpenPdfManager.hasAnnotationPermission();
    }

    public boolean hasInputField(int i) {
        boolean zHasInputField = this.mSpenPdfManager.hasInputField(i);
        Logger.m10999d(TAG, "hasInputField# pageIdx/result: " + i + "/" + zHasInputField);
        return zHasInputField;
    }

    public boolean hasOverlayImage() {
        int pageCount = this.mSpenPdfManager.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            if (this.mSpenPdfManager.getOverlayImage(i) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOwnerPermission(String str) {
        return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED.equals(this.mSpenPdfManager.hasOwnerPermission(str, ""));
    }

    public boolean hasPassword(String str) {
        return this.mSpenPdfManager.hasPassword(str);
    }

    public boolean hasPdfOnScreen() {
        return this.mSpenPdfManager.hasPdfOnScreen();
    }

    public boolean hasSelectedImage() {
        return this.mSpenPdfManager.hasSelectedImage();
    }

    public boolean hasSelectedPDF() {
        if (hasSelectedImage()) {
            return true;
        }
        return hasSelectedText() && !TextUtils.isEmpty(getSelectedText());
    }

    public boolean hasSelectedText() {
        return this.mSpenPdfManager.hasSelectedText();
    }

    public boolean hasSelection(int i) {
        SpenNotePdfCursorPosition startSelectionCursorPosition = getStartSelectionCursorPosition();
        return startSelectionCursorPosition.getPageIndex() >= 0 && startSelectionCursorPosition.getPageIndex() <= i && getEndSelectionCursorPosition().getPageIndex() >= i;
    }

    public void init(String str, boolean z) {
        this.mCacheDirPath = str;
        this.mIsReadOnlyNoteData = z;
    }

    public void insertedPage(int i) {
        for (int pageCount = this.mSpenPdfManager.getPageCount(); pageCount >= i; pageCount--) {
            String[] strArr = this.mTranslationMap.get(pageCount);
            if (strArr != null) {
                int i2 = pageCount + 1;
                AbstractC8014b.m7221w(AbstractC0541b.m778t(pageCount, "insertedPage# TranslationMap replace pageIndex from : ", ", to : "), TAG, i2);
                this.mTranslationMap.remove(pageCount);
                this.mTranslationMap.put(i2, strArr);
            }
        }
    }

    public boolean isAvailableAddToNoteWithTranslation() {
        return this.mIsAvailableAddToNoteWithTranslation;
    }

    public boolean isEmptyTranslationCacheMap() {
        return this.mTranslationCacheMap.isEmpty();
    }

    public boolean isOverlayTextEnabled() {
        return this.mSpenPdfManager.isOverlayTextEnabled();
    }

    public boolean isSecured(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return hasPassword(str) || hasOwnerPermission(str);
    }

    public void requestReloadOverlayPages() {
        Logger.m11003i("AI" + TAG, "requestReloadOverlayPages#");
        this.mSpenPdfManager.requestReloadOverlayPages();
    }

    public void selectText(int i, int i2, int i4) {
        this.mSpenPdfManager.setTextSelection(i, i2, i4);
    }

    public void selectTextOnScreen() {
        this.mSpenPdfManager.selectTextOnScreen();
    }

    public void setAiTextFormat(boolean z) {
        if (z) {
            this.mSpenPdfManager.setCursorSelectionMaxLength(AiMaxLength.LEN_SELECTED_MAX);
        } else {
            this.mSpenPdfManager.setCursorSelectionMaxLength(0);
        }
    }

    public void setAvailableAddToNoteWithTranslation(boolean z) {
        this.mIsAvailableAddToNoteWithTranslation = z;
    }

    public void setCursorSelectionMaxLength(int i) {
        this.mSpenPdfManager.setCursorSelectionMaxLength(i);
    }

    public void setListener(AttachPdfStateListener attachPdfStateListener) {
        this.mAttachPdfStateListener = attachPdfStateListener;
    }

    public boolean setOverlayImage(int i, Bitmap bitmap) {
        AbstractC8014b.m7217s(i, "setOverlayImage# pageIndex : ", "AI" + TAG);
        if (!this.mIsAvailableAddToNoteWithTranslation) {
            this.mIsAvailableAddToNoteWithTranslation = true;
        }
        return this.mSpenPdfManager.setOverlayImage(i, bitmap);
    }

    public void setOverlayTaggedText(int i, String[] strArr, String str) {
        StringBuilder sb = new StringBuilder("AI");
        String str2 = TAG;
        sb.append(str2);
        AbstractC8014b.m7195A(AbstractC2322a.m1629s("setOverlayTaggedText# pageIndex : ", i, ", dstLanguageTag : ", str, " overlayText : "), sb.toString(), strArr.length);
        ArrayList<SpenPdfParagraph> arrayList = SpenPdfTextConverter.parse(strArr);
        if (arrayList == null) {
            Logger.m11000e("AI" + str2, "setOverlayTaggedText# paragraphs is null");
            return;
        }
        if (!this.mIsAvailableAddToNoteWithTranslation) {
            this.mIsAvailableAddToNoteWithTranslation = true;
        }
        this.mSpenPdfManager.setOverlayRichText(i, arrayList, str);
        Iterator<SpenPdfParagraph> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().getListPdfText().clear();
        }
        arrayList.clear();
        this.mTranslationMap.put(i, strArr);
    }

    public void setOverlayText(int i, String[] strArr, String str) {
        AbstractC8014b.m7195A(AbstractC2322a.m1629s("setOverlayText# pageIndex : ", i, ", dstLanguageTag : ", str, " overlayText : "), "AI" + TAG, strArr.length);
        this.mSpenPdfManager.setOverlayText(i, strArr, str);
    }

    public void setOverlayTextEnable(boolean z) {
        AbstractC8014b.m7224z("setOverlayTextEnable# enable : ", "AI" + TAG, z);
        this.mSpenPdfManager.setOverlayTextEnable(z);
    }

    public void setPdfPageListener(PdfPageListener pdfPageListener) {
        this.mPdfPageListener = pdfPageListener;
    }

    public void setPdfSelectionChangedListener(PdfSelectionChangedListener pdfSelectionChangedListener) {
        this.mPdfSelectionChangedListener = pdfSelectionChangedListener;
    }

    public void setSelectedPdfStateListener(SelectedPdfStateListener selectedPdfStateListener) {
        this.mSelectedPdfStateListener = selectedPdfStateListener;
    }

    public void setSpenNotePdfActionListener(SpenNotePdfActionListenerImpl spenNotePdfActionListenerImpl) {
        this.mSpenNotePdfActionListener = spenNotePdfActionListenerImpl;
    }

    public void setSpenNotePdfManager(ISpenNotePdfManager iSpenNotePdfManager) {
        this.mSpenPdfManager = iSpenNotePdfManager;
        SpenNotePdfListenerImpl spenNotePdfListenerImpl = new SpenNotePdfListenerImpl(this, 0);
        this.mSpenNotePdfListenerImpl = spenNotePdfListenerImpl;
        this.mSpenPdfManager.setListener(spenNotePdfListenerImpl);
        this.mTranslationMap = new SparseArray<>();
    }

    public void setStreamingOverlayTaggedText(int i, int i2, String[] strArr, String str) {
        String str2 = "AI" + TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "setStreamingOverlayTaggedText# pageIndex : ", ", startParagraphIndex : ", ", dstLanguageTag : ");
        sbM1173s.append(str);
        sbM1173s.append(" overlayText : ");
        AbstractC8014b.m7195A(sbM1173s, str2, strArr.length);
        for (String str3 : strArr) {
            Logger.m10999d("AI" + TAG, "setStreamingOverlayTaggedText# text : " + LoggerBase.getEncode(str3));
        }
        ArrayList<SpenPdfParagraph> arrayList = SpenPdfTextConverter.parse(strArr);
        if (arrayList == null) {
            Logger.m11000e("AI" + TAG, "setStreamingOverlayTaggedText# paragraphs is null");
        } else {
            this.mSpenPdfManager.setStreamingOverlayRichText(i, i2, arrayList, str);
            Iterator<SpenPdfParagraph> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().getListPdfText().clear();
            }
            arrayList.clear();
        }
    }

    public void setTextSelection(SpenNotePdfCursorPosition spenNotePdfCursorPosition, SpenNotePdfCursorPosition spenNotePdfCursorPosition2) {
        this.mSpenPdfManager.setTextSelection(spenNotePdfCursorPosition, spenNotePdfCursorPosition2);
    }

    public void setTranslationCacheMap(Map map) {
        if (map.isEmpty()) {
            this.mTranslationCacheMap.clear();
        } else {
            this.mTranslationCacheMap.clear();
            this.mTranslationCacheMap.putAll(map);
        }
    }

    public boolean unlock(String str, String str2, String str3) {
        return this.mSpenPdfManager.copyFile(str, str3, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.repository.data.pdf.PDFDataSource
    public void updateAttachedFile() {
        AbstractC8014b.m7220v("updateAttachedFile# result: ", TAG, this.mSpenPdfManager.updateAttachedFile());
    }

    public boolean verifyPassword(String str, String str2) {
        return this.mSpenPdfManager.verifyPassword(str, str2) == ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS;
    }
}
