package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener;
import com.samsung.android.sdk.pen.util.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.CvPageSettingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecognizedHw implements AiMenuContract.IAiAction {
    private static final String KEY_SAVE_LINE_RECT = "save_line_rect";
    private static final String TAG = Logger.createTag("RecognizedHw", AiConstants.PREFIX_TAG);
    private SpannableStringBuilder mBackup;
    private final AiBixbyParam mBixbyParam;
    private WritingToolManager.CTTLanguageListener mCTTLanguageListener;
    ComposerViewPresenter mComposerViewPresenter;
    Contract mContract;
    private int mEndPage;
    private boolean mIsLastNightMode;
    private String mLanguageForRecognizedText;
    private ArrayList<RectF> mLineRectFList;
    SpenWNote mNote;
    private float[] mOffSets;
    private String mRecognizedText;
    private ArrayList<SpenTextSpanBase> mSpanList;
    SpannableStringBuilder mSpannableStringBuilder;
    SrcContentInfo mSrcContentInfo;
    private int mStartPage;
    private ResultListener mResultListener = null;
    private boolean mIsSelecting = true;
    private final boolean mIsEditable = true;
    private boolean mIsEnabledTranslationLanguageFilter = false;
    private String mLastErrorMessage = null;
    private boolean mDirtyFlagByLanguage = false;
    private boolean mStartFlag = true;
    private boolean mIsEditing = false;
    private boolean mIsRestoreHW = false;
    private boolean mIsRecognizing = false;
    private final Runnable mRequestFocusToComposer = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.1
        @Override // java.lang.Runnable
        public void run() {
            RecognizedHw.this.mComposerViewPresenter.getView().requestFocus();
        }
    };
    Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onClosedCTT();

        void requestClose();

        void setProgress(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ConvertToTextCancelListenerImpl implements WritingToolManager.ConvertToTextCancelListener {
        public /* synthetic */ ConvertToTextCancelListenerImpl(RecognizedHw recognizedHw, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.WritingToolManager.ConvertToTextCancelListener
        public void onCTTClosed() {
            Logger.m10999d(RecognizedHw.TAG, "ConvertToTextCancelListenerImpl#OnControlClosed");
            boolean z = RecognizedHw.this.mIsRecognizing;
            if (z) {
                RecognizedHw.this.mContract.requestClose();
            }
            RecognizedHw.this.mIsRecognizing = false;
            RecognizedHw.this.mIsSelecting = false;
            if (z) {
                return;
            }
            RecognizedHw.this.mContract.onClosedCTT();
        }

        private ConvertToTextCancelListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        void onCompleted(boolean z);

        void onFailed(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SpenAutoFormatListenerImpl extends SpenAutoFormatListener {
        public /* synthetic */ SpenAutoFormatListenerImpl(RecognizedHw recognizedHw, int i) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onControlClosed() {
            Logger.m10999d(RecognizedHw.TAG, "SpenAutoFormatListenerImpl#OnControlClosed recognizing: " + RecognizedHw.this.mIsRecognizing);
            boolean z = RecognizedHw.this.mIsRecognizing;
            if (z) {
                RecognizedHw.this.mContract.requestClose();
            }
            RecognizedHw.this.mIsRecognizing = false;
            RecognizedHw.this.mIsSelecting = false;
            RecognizedHw.this.mSrcContentInfo.mSelectedRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            if (z) {
                return;
            }
            RecognizedHw.this.mContract.onClosedCTT();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onProgressStart() {
            Logger.m10999d(RecognizedHw.TAG, "SpenAutoFormatListenerImpl#onProgressStart");
            RecognizedHw.this.mIsRecognizing = true;
            if (RecognizedHw.this.mIsRestoreHW) {
                return;
            }
            RecognizedHw.this.mContract.setProgress(true);
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onProgressStop() {
            Logger.m10999d(RecognizedHw.TAG, "SpenAutoFormatListenerImpl#onProgressStop");
            RecognizedHw.this.mContract.setProgress(false);
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onRecognitionFailed(boolean z) {
            Logger.m10999d(RecognizedHw.TAG, "SpenAutoFormatListenerImpl#onRecognitionFailed# ");
            RecognizedHw.this.mIsRecognizing = false;
            RecognizedHw.this.mDirtyFlagByLanguage = false;
            RecognizedHw recognizedHw = RecognizedHw.this;
            recognizedHw.mLastErrorMessage = recognizedHw.mComposerViewPresenter.getActivity().getString(C9086R.string.composer_unable_to_extract_text);
            if (RecognizedHw.this.mResultListener != null) {
                RecognizedHw.this.mResultListener.onFailed(RecognizedHw.this.mLastErrorMessage);
            }
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onResult(boolean z, ArrayList<RectF> arrayList, ArrayList<RectF> arrayList2, String str, ArrayList<SpenTextSpanBase> arrayList3) {
            AbstractC8014b.m7220v("SpenAutoFormatListenerImpl#onResult# ", RecognizedHw.TAG, z);
            RecognizedHw.this.mIsRecognizing = false;
            if (z) {
                RecognizedHw recognizedHw = RecognizedHw.this;
                recognizedHw.updateRecognizedText(str, arrayList3, recognizedHw.mLanguageForRecognizedText);
            }
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onResultRecognize(boolean z, ArrayList<RectF> arrayList, ArrayList<RectF> arrayList2, String str, ArrayList<SpenTextSpanBase> arrayList3, String str2) {
            RecognizedHw.this.mIsRecognizing = false;
            RecognizedHw.this.mLastErrorMessage = null;
            if (RecognizedHw.this.mRecognizedText == null || !RecognizedHw.this.mRecognizedText.equals(str)) {
                AbstractC8014b.m7221w(new StringBuilder("onResultRecognize# mRecognizedText and text are not the same "), RecognizedHw.TAG, str != null ? str.length() : 0);
                if (str == null) {
                    onRecognitionFailed(false);
                    return;
                }
            }
            RecognizedHw.this.mLineRectFList = arrayList;
            RectF rectF = new RectF();
            Iterator<RectF> it = arrayList2.iterator();
            while (it.hasNext()) {
                rectF.union(it.next());
            }
            RectF rectF2 = new RectF();
            if (RecognizedHw.this.mLineRectFList != null) {
                Iterator it2 = RecognizedHw.this.mLineRectFList.iterator();
                while (it2.hasNext()) {
                    rectF2.union((RectF) it2.next());
                }
            }
            Logger.m10999d(RecognizedHw.TAG, "SpenAutoFormatListenerImpl#onResultRecognize# " + z + " " + arrayList2 + " " + rectF.toShortString() + " | " + rectF2.toShortString());
            if (!z || !RecognizedHw.this.mStartFlag) {
                if (z) {
                    RecognizedHw.this.updateRecognizedText(str, arrayList3, str2);
                    return;
                }
                return;
            }
            String sAForAIScenarioScreenID = RecognizedHw.this.mSrcContentInfo.getSAForAIScenarioScreenID();
            String sAForAIScenario = RecognizedHw.this.mSrcContentInfo.getSAForAIScenario();
            RecognizedHw recognizedHw = RecognizedHw.this;
            recognizedHw.mSrcContentInfo = recognizedHw.makeSrcContentInfo(str, arrayList3);
            RecognizedHw.this.mSrcContentInfo.setSAForAIScenarioScreenID(sAForAIScenarioScreenID);
            RecognizedHw.this.mSrcContentInfo.setSAForAIScenario(sAForAIScenario);
            if (RecognizedHw.this.mResultListener != null) {
                RecognizedHw.this.mResultListener.onCompleted(true);
            }
            RecognizedHw.this.mStartFlag = false;
        }

        private SpenAutoFormatListenerImpl() {
        }
    }

    public RecognizedHw(ComposerViewPresenter composerViewPresenter, ArrayList<RectF> arrayList, AiBixbyParam aiBixbyParam) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mLineRectFList = arrayList;
        this.mBixbyParam = aiBixbyParam;
        SrcContentInfo srcContentInfo = new SrcContentInfo(2);
        this.mSrcContentInfo = srcContentInfo;
        srcContentInfo.setSelectedRectF(getSelectedRectF());
        this.mSrcContentInfo.setLineRectFList(this.mLineRectFList);
        this.mSrcContentInfo.setAiBixbyParam(aiBixbyParam);
        getStartPageIndex();
        getOffSet();
        Pair<Integer, Integer> pageIndex = getPageIndex(this.mSrcContentInfo.mSelectedRectF);
        this.mSrcContentInfo.setSrcPageIndex(((Integer) pageIndex.first).intValue(), ((Integer) pageIndex.second).intValue());
        this.mSrcContentInfo.setBGColorInverted(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getComposerModel().getDoc());
    }

    private void adjustColor(int i) {
        SpenColorThemeUtil spenColorThemeUtil = new SpenColorThemeUtil(this.mComposerViewPresenter.getActivity());
        spenColorThemeUtil.setColorTheme(i);
        SpannableStringBuilder spannableStringBuilder = this.mSpannableStringBuilder;
        for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ForegroundColorSpan.class)) {
            int spanStart = this.mSpannableStringBuilder.getSpanStart(foregroundColorSpan);
            int spanEnd = this.mSpannableStringBuilder.getSpanEnd(foregroundColorSpan);
            int spanFlags = this.mSpannableStringBuilder.getSpanFlags(foregroundColorSpan);
            this.mSpannableStringBuilder.removeSpan(foregroundColorSpan);
            int color = spenColorThemeUtil.getColor(foregroundColorSpan.getForegroundColor());
            if (isScreenOffNote() && ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity()) && color == -16777216) {
                color = -1;
            }
            this.mSpannableStringBuilder.setSpan(new ForegroundColorSpan(color), spanStart, spanEnd, spanFlags);
        }
        spenColorThemeUtil.close();
    }

    private void clearNote() {
        try {
            SpenWNote spenWNote = this.mNote;
            if (spenWNote == null || spenWNote.isClosed()) {
                return;
            }
            this.mNote.close(true);
            this.mNote = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void convertSpenToSpannable(String str, ArrayList<SpenTextSpanBase> arrayList) {
        this.mSpanList = arrayList;
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(str);
        newSpenObjectTextBox.setTextSpan(arrayList);
        this.mSpannableStringBuilder = (SpannableStringBuilder) ConvertSpenTextToSpannable.convertSpenTextToSpannableSBuilder(newSpenObjectTextBox, new ConvertSpenTextToSpannable.IObjectSpanConverter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.3
            @Override // com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
            public void convert(@NonNull List<SpenObjectSpan> list, @NonNull SpannableStringBuilder spannableStringBuilder) {
            }
        });
        if (isScreenOffNote()) {
            adjustColor((this.mComposerViewPresenter.isBackgroundDarkTheme() || !ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity())) ? 0 : 1);
        } else if (ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity())) {
            adjustColor(1);
        }
    }

    private List<Bitmap> createThumbnail(SpenWNote spenWNote, NoteCaptureControl noteCaptureControl) {
        Logger.m10999d(TAG, "createThumbnail# " + this.mSrcContentInfo.mSelectedRectF.toShortString());
        ArrayList<SpenObjectBase> selectedObject = this.mComposerViewPresenter.getDoc().getSelectedObject();
        if (selectedObject != null && !selectedObject.isEmpty()) {
            Bitmap selectedData = this.mComposerViewPresenter.getObjectManager().getSelectedData(1.0f, 1.0f);
            ArrayList arrayList = new ArrayList();
            if (selectedData != null) {
                arrayList.add(selectedData);
                return arrayList;
            }
        }
        List<Bitmap> listCreateThumbnailSinglePage = createThumbnailSinglePage(spenWNote, noteCaptureControl);
        if (listCreateThumbnailSinglePage != null) {
            return listCreateThumbnailSinglePage;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = this.mSrcContentInfo.mSrcPageIndex; i <= this.mSrcContentInfo.mSrcPageEndIndex; i++) {
            SpenWPage page = spenWNote.getPage(i);
            noteCaptureControl.setContents(page, spenWNote.getBodyText(), i);
            RectF rectF = new RectF(0.0f, 0.0f, page.getWidth(), page.getHeight());
            String str = TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "makeSelectedHwThumbnailList# page index ", " page Rect ");
            sbM778t.append(rectF.toShortString());
            Logger.m10999d(str, sbM778t.toString());
            rectF.offset(page.getOffset().x, page.getOffset().y);
            updateLineRectFList();
            Iterator<RectF> it = this.mLineRectFList.iterator();
            while (it.hasNext()) {
                rectF.intersect(it.next());
            }
            String str2 = TAG;
            Logger.m10999d(str2, "makeSelectedHwThumbnailList# after intersect " + rectF.toShortString());
            rectF.offset((float) (-page.getOffset().x), (float) (-page.getOffset().y));
            if (i != this.mSrcContentInfo.mSrcPageIndex) {
                rectF.top = 0.0f;
            }
            Logger.m10999d(str2, "makeSelectedHwThumbnailList# adjust offset: " + rectF.toShortString());
            arrayList2.add(noteCaptureControl.captureHandwritingRect(rectF, 1.0f));
        }
        return arrayList2;
    }

    private List<Bitmap> createThumbnailForTwoPageStyle(SpenWNote spenWNote, NoteCaptureControl noteCaptureControl) {
        ArrayList arrayList = new ArrayList();
        Logger.m10999d(TAG, "createThumbnailForTwoPageStyle# " + this.mSrcContentInfo.mSelectedRectF);
        for (int i = this.mSrcContentInfo.mSrcPageIndex; i <= this.mSrcContentInfo.mSrcPageEndIndex; i++) {
            SpenWPage page = spenWNote.getPage(i);
            noteCaptureControl.setContents(page, spenWNote.getBodyText(), i);
            RectF rectF = new RectF(0.0f, 0.0f, page.getWidth(), page.getHeight());
            String str = TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "createThumbnailForTwoPageStyle# page index ", " page Rect ");
            sbM778t.append(rectF.toShortString());
            Logger.m10999d(str, sbM778t.toString());
            rectF.offset(page.getOffset().x, page.getOffset().y);
            Iterator<RectF> it = this.mSrcContentInfo.mLineRectFList.iterator();
            while (it.hasNext()) {
                rectF.intersect(it.next());
            }
            String str2 = TAG;
            Logger.m10999d(str2, "createThumbnailForTwoPageStyle# after intersect " + rectF.toShortString());
            rectF.offset((float) (-page.getOffset().x), (float) (-page.getOffset().y));
            Logger.m10999d(str2, "createThumbnailForTwoPageStyle# adjust offset: " + rectF.toShortString());
            arrayList.add(noteCaptureControl.captureHandwritingRect(new RectF(0.0f, rectF.top, (float) page.getWidth(), rectF.bottom), 1.0f));
        }
        return arrayList;
    }

    private List<Bitmap> createThumbnailSinglePage(SpenWNote spenWNote, NoteCaptureControl noteCaptureControl) {
        if (spenWNote.getPageMode() != SpenWNote.PageMode.SINGLE) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int height = DocumentPageRatio.PAGE_RATIO.getHeight(spenWNote.getPageDefaultWidth());
        int iHeight = (int) this.mSrcContentInfo.mSelectedRectF.height();
        if (height > iHeight) {
            height = iHeight;
        }
        int i = (int) this.mSrcContentInfo.mSelectedRectF.top;
        noteCaptureControl.setContents(spenWNote.getPage(0), spenWNote.getBodyText(), 0);
        while (iHeight > 0) {
            i += height;
            arrayList.add(noteCaptureControl.captureHandwritingRect(new RectF(0.0f, i, r5.getWidth(), i), 1.0f));
            iHeight -= height;
            if (height > iHeight) {
                height = iHeight;
            }
        }
        return arrayList;
    }

    @Nullable
    private Integer getMenuNameStr(int i) {
        if (i == 1) {
            return Integer.valueOf(C9086R.string.ai_translate_name);
        }
        if (i == 3 || i == 4) {
            return Integer.valueOf(C9086R.string.ai_auto_format_name);
        }
        if (i == 5) {
            return Integer.valueOf(C9086R.string.ai_spelling_correction);
        }
        if (i == 2) {
            return Integer.valueOf(C9086R.string.ai_summarize_name);
        }
        return null;
    }

    private void getOffSet() {
        SpenWNote doc = this.mComposerViewPresenter.getComposerModel().getDoc();
        for (RectF rectF : this.mLineRectFList) {
            if (rectF.width() != 0.0f && rectF.height() != 0.0f) {
                if (this.mOffSets == null) {
                    this.mOffSets = new float[2];
                    SpenWPage page = doc.getPage(this.mStartPage);
                    this.mOffSets[0] = (rectF.top - page.getOffset().y) / page.getHeight();
                }
                SpenWPage page2 = doc.getPage(this.mEndPage);
                this.mOffSets[1] = (rectF.bottom - page2.getOffset().y) / page2.getHeight();
            }
        }
    }

    private Pair<Integer, Integer> getPageIndex(RectF rectF) {
        int iMax;
        ArrayList<Integer> pageIndexListByRect = this.mComposerViewPresenter.getObjectManager().getPageIndexListByRect(rectF);
        int iMax2 = 0;
        if (pageIndexListByRect == null || pageIndexListByRect.isEmpty()) {
            iMax = 0;
        } else {
            iMax2 = Math.max(pageIndexListByRect.get(0).intValue(), 0);
            iMax = Math.max(((Integer) AbstractC1974b.m1313f(1, pageIndexListByRect)).intValue(), iMax2);
        }
        return new Pair<>(Integer.valueOf(iMax2), Integer.valueOf(iMax));
    }

    private RectF getSelectedRectF() {
        RectF rectF = new RectF();
        ArrayList<RectF> arrayList = this.mLineRectFList;
        if (arrayList != null) {
            Iterator<RectF> it = arrayList.iterator();
            while (it.hasNext()) {
                rectF.union(it.next());
            }
        }
        return rectF;
    }

    private void getStartPageIndex() {
        int height;
        int i;
        int width;
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        RectF rectF = null;
        int i2 = 0;
        for (RectF rectF2 : this.mLineRectFList) {
            if (rectF2.width() != 0.0f && rectF2.height() != 0.0f) {
                if (rectF == null) {
                    rectF = rectF2;
                }
                i2++;
            }
        }
        if (rectF == null) {
            return;
        }
        ArrayList<Integer> pageIndexListByRect = this.mComposerViewPresenter.getObjectManager().getPageIndexListByRect(rectF);
        if (pageIndexListByRect != null && !pageIndexListByRect.isEmpty()) {
            this.mStartPage = pageIndexListByRect.get(0).intValue();
            this.mEndPage = (r0 + i2) - 1;
            return;
        }
        int pageCount = doc.getPageCount() - 1;
        boolean zIsScrollVertical = this.mComposerViewPresenter.getPageManager().getDocPageInfo().isScrollVertical();
        int i4 = 0;
        while (i4 <= pageCount) {
            int i5 = (i4 + pageCount) / 2;
            if (zIsScrollVertical) {
                if (i5 > 0) {
                    int i6 = i5 - 1;
                    height = doc.getPage(i6).getHeight() + doc.getPage(i6).getOffset().y;
                } else {
                    height = 0;
                }
                i = i5 + 1;
                int i7 = doc.getPage(i).getOffset().y;
                float f = rectF.top;
                float f4 = height;
                if (f >= f4 && rectF.bottom <= i7) {
                    this.mStartPage = i5;
                    this.mEndPage = (i5 + i2) - 1;
                    return;
                } else if (f < f4) {
                    pageCount = i5 - 1;
                } else {
                    i4 = i;
                }
            } else {
                if (i5 > 0) {
                    int i8 = i5 - 1;
                    width = doc.getPage(i8).getWidth() + doc.getPage(i8).getOffset().x;
                } else {
                    width = 0;
                }
                i = i5 + 1;
                int i9 = doc.getPage(i).getOffset().x;
                float f5 = rectF.left;
                float f6 = width;
                if (f5 >= f6 && rectF.right <= i9) {
                    this.mStartPage = i5;
                    this.mEndPage = (i5 + i2) - 1;
                    return;
                } else if (f5 < f6) {
                    pageCount = i5 - 1;
                } else {
                    i4 = i;
                }
            }
        }
        SrcContentInfo srcContentInfo = this.mSrcContentInfo;
        this.mStartPage = srcContentInfo.mSrcPageIndex;
        this.mEndPage = srcContentInfo.mSrcPageEndIndex;
    }

    private boolean isScreenOffNote() {
        return this.mComposerViewPresenter.getComposerModel().getDocInfo().getUuid().endsWith("_screenoff");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SrcContentInfo makeSrcContentInfo(String str, ArrayList<SpenTextSpanBase> arrayList) {
        this.mRecognizedText = str;
        RectF selectedRectF = getSelectedRectF();
        int cursorIndexToInsertIntoBodyText = this.mComposerViewPresenter.getTextManager().getCursorIndexToInsertIntoBodyText(new PointF(selectedRectF.left, selectedRectF.top));
        Pair<Integer, Integer> pageIndex = getPageIndex(selectedRectF);
        Logger.m10999d(TAG, "getSrcContentInfo# firstItemRect = " + selectedRectF + " / insertPointCursor = " + cursorIndexToInsertIntoBodyText + " / pageIndex = " + pageIndex.first + " / endPageIndex = " + pageIndex.second);
        SrcContentInfo recognizedTextSpanList = new SrcContentInfo(str, cursorIndexToInsertIntoBodyText).setSrcPageIndex(((Integer) pageIndex.first).intValue(), ((Integer) pageIndex.second).intValue()).setSelectedRectF(selectedRectF).setLineRectFList(this.mLineRectFList).setRecognizedTextSpanList(arrayList);
        recognizedTextSpanList.setBGColorInverted(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getComposerModel().getDoc());
        recognizedTextSpanList.setAiBixbyParam(this.mBixbyParam);
        convertSpenToSpannable(str, arrayList);
        return recognizedTextSpanList;
    }

    private void setDefApplyFontSizeAll(SpenObjectTextBox spenObjectTextBox) {
        AiViewUtils.setDefApplyFontSizeAll(null, spenObjectTextBox, this.mSrcContentInfo);
    }

    private void updateLineRectFList() {
        this.mLineRectFList = new ArrayList<>();
        SpenWNote doc = this.mComposerViewPresenter.getComposerModel().getDoc();
        int i = this.mStartPage;
        while (i <= this.mEndPage) {
            int i2 = doc.getPage(i).getOffset().y;
            float f = i2;
            this.mLineRectFList.add(new RectF(doc.getPage(i).getOffset().x, (doc.getPage(i).getHeight() * (i == this.mStartPage ? this.mOffSets[0] : 0.0f)) + f, doc.getPage(i).getWidth() + r3, (doc.getPage(i).getHeight() * (i == this.mEndPage ? this.mOffSets[1] : 1.0f)) + f));
            i++;
        }
    }

    public void addSpenObjectSelectListener(SpenObjectSelectListener spenObjectSelectListener) {
        this.mComposerViewPresenter.getListenerManager().addSpenObjectSelectListener(spenObjectSelectListener);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        convertSpannableToSpen();
        ResultOperation resultOperation = new ResultOperation();
        resultOperation.convertTextColor(this.mComposerViewPresenter.getActivity(), this.mNote.getBodyText(), isScreenOffNote() && this.mComposerViewPresenter.isBackgroundDarkTheme() && ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity()));
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
                resultOperation.insertToBottom(this.mComposerViewPresenter, this.mSrcContentInfo, this.mNote.getBodyText());
                return;
            } else {
                resultOperation.insertNewPageEndOfNote(this.mComposerViewPresenter, this.mSrcContentInfo, this.mNote.getBodyText());
                return;
            }
        }
        if (ResultOperation.AddTo.NewPageBefore == addTo) {
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, this.mSrcContentInfo, this.mNote.getBodyText());
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            resultOperation.addToNewNote(this.mComposerViewPresenter, this.mNote.getBodyText());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        SpannableStringBuilder spannableStringBuilder = this.mSpannableStringBuilder;
        return spannableStringBuilder != null && spannableStringBuilder.length() > 0;
    }

    public void clear() {
        clearNote();
        this.mSpannableStringBuilder = null;
        this.mResultListener = null;
        if (this.mCTTLanguageListener != null) {
            this.mComposerViewPresenter.getWritingToolManager().removeCTTLanguageListener(this.mCTTLanguageListener);
            this.mCTTLanguageListener = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void convertSpannableToSpen() {
        SpannableStringBuilder spannableStringBuilder = this.mSpannableStringBuilder;
        if (spannableStringBuilder == null || spannableStringBuilder.length() == 0) {
            return;
        }
        makeNote();
        this.mNote.getBodyText().removeAllText();
        this.mNote.getBodyText().setText(this.mSpannableStringBuilder.toString());
        if (isScreenOffNote()) {
            this.mNote.getBodyText().setTextSpan(this.mSpanList);
        } else {
            CharUtils.convertSpannablerToSpen(this.mSpannableStringBuilder, this.mNote.getBodyText());
        }
        setDefApplyFontSizeAll(this.mNote.getBodyText());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox resultToCopy = getResultToCopy();
        resultOperation.convertTextColor(this.mComposerViewPresenter.getActivity(), resultToCopy, isScreenOffNote());
        resultOperation.copy(this.mComposerViewPresenter, resultToCopy);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "e";
    }

    public String getErrorMessage() {
        return this.mLastErrorMessage;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public SpenWNote getRecognizedHwNote() {
        convertSpannableToSpen();
        return this.mNote;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        convertSpannableToSpen();
        return this.mNote.getBodyText();
    }

    public CharSequence getSpannableStringBuilder() {
        return this.mSpannableStringBuilder;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return this.mSrcContentInfo;
    }

    public String getText() {
        return this.mSrcContentInfo.getSelectedText();
    }

    public boolean hasSelectedObject() {
        return this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected();
    }

    public void hideSoftInput(View view) {
        this.mComposerViewPresenter.getSoftInputManager().hide(view);
    }

    public void initListener() {
        Logger.m10999d(TAG, "initListener#");
        int i = 0;
        this.mComposerViewPresenter.getWritingToolManager().setAutoFormatListener(new SpenAutoFormatListenerImpl(this, i));
        this.mComposerViewPresenter.getWritingToolManager().setConvertToTextCancelListener(new ConvertToTextCancelListenerImpl(this, i));
    }

    public boolean isEditable() {
        return true;
    }

    public boolean isEditing() {
        return this.mIsEditing;
    }

    public boolean isSelecting() {
        return this.mIsSelecting;
    }

    public boolean isShowingSoftInput() {
        return this.mComposerViewPresenter.getSoftInputManager().isInputMethodShown();
    }

    public void makeNote() {
        SpenWNote spenWNote = this.mNote;
        if (spenWNote == null || spenWNote.isClosed()) {
            SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getDoc());
            this.mNote = spenWNoteMakeNote;
            if (spenWNoteMakeNote == null) {
                return;
            }
            spenWNoteMakeNote.getBodyText().setText("");
        }
    }

    public List<Bitmap> makeSelectedHwThumbnailList() {
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(this.mComposerViewPresenter.getActivity());
        noteCaptureControl.setWNote(doc);
        noteCaptureControl.setColorTheme(ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity()) ? 1 : 0);
        CvPageSettingController cvPageSettingController = this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController();
        SrcContentInfo srcContentInfo = this.mSrcContentInfo;
        List<Bitmap> listCreateThumbnail = (srcContentInfo.mSrcPageIndex == srcContentInfo.mSrcPageEndIndex || !cvPageSettingController.getPageLayoutState().isTwoPage()) ? createThumbnail(doc, noteCaptureControl) : createThumbnailForTwoPageStyle(doc, noteCaptureControl);
        noteCaptureControl.close();
        return listCreateThumbnail;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (this.mLastErrorMessage != null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.mSpannableStringBuilder;
        boolean z = spannableStringBuilder != null && spannableStringBuilder.length() > 0;
        String str = TAG;
        bundle.putBoolean(str, z);
        if (this.mSpannableStringBuilder != null) {
            this.mBackup = new SpannableStringBuilder(this.mSpannableStringBuilder);
            this.mIsLastNightMode = ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity());
        }
        bundle.putParcelableArrayList(KEY_SAVE_LINE_RECT, this.mLineRectFList);
        Logger.m10999d(str, "onSaveInstanceState# " + z + " night = " + this.mIsLastNightMode + " rect = " + this.mSrcContentInfo.mSelectedRectF);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
        convertSpannableToSpen();
        ResultOperation resultOperation = new ResultOperation();
        resultOperation.convertTextColor(this.mComposerViewPresenter.getActivity(), this.mNote.getBodyText(), isScreenOffNote());
        resultOperation.overwriteInTextBox(this.mComposerViewPresenter, this.mSrcContentInfo, this.mNote.getBodyText());
    }

    public void removeSpenObjectSelectListener(SpenObjectSelectListener spenObjectSelectListener) {
        this.mComposerViewPresenter.getListenerManager().removeSpenObjectSelectListener(spenObjectSelectListener);
    }

    public void requestFocusToComposer() {
        this.mHandler.removeCallbacks(this.mRequestFocusToComposer);
        this.mHandler.postDelayed(this.mRequestFocusToComposer, 500L);
    }

    public void restoreRecognize() {
        Logger.m10999d(TAG, "restoreRecognize#");
        this.mIsSelecting = true;
        this.mIsRestoreHW = AiViewUtils.isSupportFloatingLayout();
        if (this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected()) {
            return;
        }
        updateLineRectFList();
        this.mComposerViewPresenter.getWritingToolManager().restoreAutoFormatRecognize(this.mLineRectFList);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        String str = TAG;
        if (bundle.containsKey(str)) {
            Logger.m10999d(str, "restore# " + srcContentInfo.mSelectedRectF);
            this.mSrcContentInfo = srcContentInfo;
            if (bundle.getBoolean(str)) {
                this.mSpannableStringBuilder = this.mBackup;
                if (isScreenOffNote()) {
                    if (this.mIsLastNightMode != ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity())) {
                        AbstractC8014b.m7215q(new StringBuilder("restore# night = "), this.mIsLastNightMode, str);
                        adjustColor(0);
                    } else {
                        adjustColor(1);
                    }
                } else if (this.mIsLastNightMode != ContextUtils.isNightMode(this.mComposerViewPresenter.getActivity())) {
                    AbstractC8014b.m7215q(new StringBuilder("restore## night = "), this.mIsLastNightMode, str);
                    adjustColor(1);
                }
                this.mBackup = null;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.mLineRectFList = bundle.getParcelableArrayList("save_line_rect", RectF.class);
            }
        }
    }

    public void setCancelRecognizingState() {
        if (this.mIsRecognizing) {
            this.mComposerViewPresenter.getWritingToolManager().cancelConvertToText(false);
            this.mIsRecognizing = false;
            this.mIsSelecting = false;
            Integer menuNameStr = getMenuNameStr(this.mBixbyParam.getAction());
            if (menuNameStr != null) {
                String string = this.mComposerViewPresenter.getActivity().getString(C9086R.string.could_not_run_something, this.mComposerViewPresenter.getActivity().getString(menuNameStr.intValue()));
                this.mLastErrorMessage = string;
                ResultListener resultListener = this.mResultListener;
                if (resultListener != null) {
                    resultListener.onFailed(string);
                }
            }
        }
    }

    public void setConstruct(Contract contract) {
        this.mContract = contract;
    }

    public void setEditing(boolean z) {
        this.mIsEditing = z;
    }

    public void setResultListener(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public void setTemporarySoftInputMode(int i) {
        this.mComposerViewPresenter.getSoftInputManager().setTemporarySoftInputMode(i);
    }

    public void setTranslationLanguageFilter(boolean z) {
        this.mIsEnabledTranslationLanguageFilter = z;
    }

    public void showSettingDialog() {
        this.mComposerViewPresenter.getDialogPresenterManager().showConvertSettingDialog(false, this.mIsEnabledTranslationLanguageFilter);
        this.mCTTLanguageListener = new WritingToolManager.CTTLanguageListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.WritingToolManager.CTTLanguageListener
            public void onLanguageChanged() {
                RecognizedHw.this.mDirtyFlagByLanguage = true;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.WritingToolManager.CTTLanguageListener
            public void onPreLanguageChanged(CharSequence charSequence) {
                RecognizedHw.this.mLanguageForRecognizedText = charSequence.toString();
            }
        };
        this.mComposerViewPresenter.getWritingToolManager().addCTTLanguageListener(this.mCTTLanguageListener);
    }

    public void showSoftInput(View view) {
        this.mComposerViewPresenter.getSoftInputManager().show(view);
    }

    public boolean startRecognition(ArrayList<RectF> arrayList) {
        return this.mComposerViewPresenter.getWritingToolManager().executeAutoFormatRecognize(arrayList);
    }

    public boolean startRecognitionWithSelectedStroke() {
        return this.mComposerViewPresenter.getWritingToolManager().executeAutoFormatExtractText();
    }

    public void updateRecognizedText(String str, ArrayList<SpenTextSpanBase> arrayList, String str2) {
        if (TextUtils.isEmpty(this.mLanguageForRecognizedText) || !this.mLanguageForRecognizedText.equals(str2)) {
            Logger.m11003i(TAG, "updateRecognizedText# language error " + this.mLanguageForRecognizedText + " / " + str2);
            return;
        }
        if (str.equals(this.mRecognizedText)) {
            return;
        }
        Logger.m10999d(TAG, "updateRecognizedText#");
        this.mRecognizedText = str;
        this.mSrcContentInfo.setSelectedText(str).setRecognizedTextSpanList(arrayList);
        convertSpenToSpannable(str, arrayList);
        ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onCompleted(true);
        }
        if (this.mDirtyFlagByLanguage) {
            this.mSrcContentInfo.setDirty(true);
        }
    }

    public void updateSpannableString(CharSequence charSequence) {
        if (this.mSpannableStringBuilder == null) {
            return;
        }
        if (!getText().equals(charSequence.toString())) {
            this.mSrcContentInfo.setDirty(true);
        }
        this.mSpannableStringBuilder.clear();
        this.mSpannableStringBuilder.clearSpans();
        this.mSpannableStringBuilder.append(charSequence);
        this.mSrcContentInfo.setSelectedText(charSequence.toString());
    }
}
