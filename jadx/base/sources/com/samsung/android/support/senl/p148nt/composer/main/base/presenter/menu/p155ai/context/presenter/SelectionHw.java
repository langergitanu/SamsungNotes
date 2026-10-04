package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.graphics.RectF;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ProgressHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LanguageUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionHw {
    private static final String TAG = Logger.createTag("SelectionHw", AiConstants.PREFIX_TAG);
    ComposerViewPresenter mComposerViewPresenter;
    Contract mContract;
    boolean mIsMaxLineSelected;
    private ArrayList<RectF> mLineRectFList;
    ProgressHandler mProgressHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void hide();

        void onRecognitionFailed();

        void updateMenu(boolean z, RectF rectF, RectF rectF2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ConvertToTextCancelListenerImpl implements WritingToolManager.ConvertToTextCancelListener {
        public ConvertToTextCancelListenerImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.WritingToolManager.ConvertToTextCancelListener
        public void onCTTClosed() {
            Logger.m10999d(SelectionHw.TAG, "onCTTClosed# ");
            SelectionHw.this.mContract.hide();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SpenAutoFormatListenerImpl extends SpenAutoFormatListener {
        public SpenAutoFormatListenerImpl() {
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onControlClosed() {
            Logger.m10999d(SelectionHw.TAG, "OnControlClosed# ");
            SelectionHw.this.mContract.hide();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onFailed() {
            Logger.m10999d(SelectionHw.TAG, "onFailed# ");
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onProgressStart() {
            SelectionHw.this.mProgressHandler.onProgressStart();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onProgressStop() {
            SelectionHw.this.mProgressHandler.onProgressStop();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onRecognitionFailed(boolean z) {
            AbstractC8014b.m7220v("onRecognitionFailed# ", SelectionHw.TAG, z);
            SelectionHw.this.mContract.onRecognitionFailed();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onRecognitionRunning(boolean z) {
            AbstractC8014b.m7220v("onRecognitionRunning# ", SelectionHw.TAG, z);
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onResult(boolean z, ArrayList<RectF> arrayList, ArrayList<RectF> arrayList2, String str, ArrayList<SpenTextSpanBase> arrayList3) {
            String str2 = SelectionHw.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("onResult# ", " ", z);
            sbM3200j.append(arrayList2.toString());
            Logger.m10999d(str2, sbM3200j.toString());
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onResultAnalyze(boolean z, ArrayList<RectF> arrayList, ArrayList<RectF> arrayList2, boolean z2) {
            String str = SelectionHw.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("onResultAnalyze# ", " ", z);
            sbM3200j.append(arrayList2.toString());
            Logger.m10999d(str, sbM3200j.toString());
            if (z) {
                SelectionHw.this.mLineRectFList = arrayList;
            }
            RectF rectF = new RectF();
            Iterator<RectF> it = arrayList2.iterator();
            while (it.hasNext()) {
                rectF.union(it.next());
            }
            RectF rectF2 = new RectF();
            if (SelectionHw.this.mLineRectFList != null) {
                Iterator it2 = SelectionHw.this.mLineRectFList.iterator();
                while (it2.hasNext()) {
                    rectF2.union((RectF) it2.next());
                }
            }
            Logger.m10999d(SelectionHw.TAG, "onResultAnalyze# targetRect " + rectF.toShortString() + " | " + rectF2.toShortString());
            SelectionHw.this.mContract.updateMenu(z, rectF, rectF2);
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onResultRecognize(boolean z, ArrayList<RectF> arrayList, ArrayList<RectF> arrayList2, String str, ArrayList<SpenTextSpanBase> arrayList3, String str2) {
            Logger.m10999d(SelectionHw.TAG, "onResultAnalyze# targetRect " + arrayList.toString() + " | " + arrayList2.toString());
            onResultAnalyze(z, arrayList, arrayList2, false);
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener
        public void onUpdated(boolean z, boolean z2) {
            SelectionHw.this.mIsMaxLineSelected = z;
        }
    }

    public SelectionHw(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, Contract contract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mProgressHandler = new ProgressHandler(controllerManager.getProgressController());
        this.mContract = contract;
    }

    public void clear(boolean z) {
        if (z) {
            this.mComposerViewPresenter.getWritingToolManager().setConvertToTextCancelListener(null);
            this.mComposerViewPresenter.getWritingToolManager().cancelConvertToText();
            this.mComposerViewPresenter.getWritingToolManager().setAutoFormatListener(null);
        }
        this.mProgressHandler.release();
    }

    public void doRecognitionFailed() {
        Logger.m10999d(TAG, "doRecognitionFailed# ");
        this.mContract.onRecognitionFailed();
    }

    public ArrayList<RectF> getLineRectFList() {
        return this.mLineRectFList;
    }

    public boolean isMaxLineSelected() {
        return this.mIsMaxLineSelected;
    }

    public void readySelection() {
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        this.mComposerViewPresenter.getWritingToolManager().setConvertToTextCancelListener(new ConvertToTextCancelListenerImpl());
        this.mComposerViewPresenter.getWritingToolManager().setAutoFormatListener(new SpenAutoFormatListenerImpl());
        try {
            this.mComposerViewPresenter.getWritingToolManager().updateLanguage(LanguageUtil.getAutoFormatLanguage(this.mComposerViewPresenter.getActivity()));
        } catch (TextRecognitionLanguage.SupportedLanguageException e) {
            Logger.m11000e(TAG, "readySelection# " + e.getMessage());
        }
    }

    public boolean restoreSelection() {
        readySelection();
        return this.mComposerViewPresenter.getWritingToolManager().restoreAutoFormatAnalyze(this.mLineRectFList);
    }

    public void selectMaximumForText() {
        this.mComposerViewPresenter.getWritingToolManager().selectMaximumForText();
    }

    public void selectNextPageForText() {
        this.mComposerViewPresenter.getWritingToolManager().selectNextPageForText();
    }

    public void setLineRectFList(ArrayList<RectF> arrayList) {
        this.mLineRectFList = arrayList;
    }

    public boolean startHwSelection() {
        readySelection();
        return this.mComposerViewPresenter.getWritingToolManager().executeAutoFormatAnalyze();
    }

    public boolean startSelectionWithSelectedObjects() {
        readySelection();
        return this.mComposerViewPresenter.getWritingToolManager().executeAutoFormatExtractText();
    }
}
