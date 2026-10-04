package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrection;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.SpellingCorrector;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import p066P2.RunnableC0202d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpellingCorrectionStreaming extends SpellingCorrection {
    private static final int PARALLEL_DELAY_MILLIS = 1000;
    private static final String TAG = Logger.createTag("SpellingCorrectionStreaming", AiConstants.PREFIX_TAG);
    private boolean isParallelCancel;
    private final StringBuilder mAllResult;
    private int mDefaultFontColor;
    private int mDefaultFontSize;
    private final ArrayList<Boolean> mIsResultStreamingBegin;
    private final ArrayList<Boolean> mIsResultsCompleted;
    private int mResultCompletedCount;
    private StreamingCharManager mStreamingCharManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CallbackStreamingImpl extends SpellingCorrection.CallbackImpl {
        private final int mExecuteResultTotalCount;
        private final int mResultIndex;

        public CallbackStreamingImpl(int i) {
            super();
            this.mExecuteResultTotalCount = SpellingCorrectionStreaming.this.mSrcContentInfo.getInputList().size();
            this.mResultIndex = i;
            initList();
        }

        private void initList() {
            if (SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList() == null || SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().isEmpty()) {
                SpellingCorrectionStreaming.this.mStreamingCharManager.setResultContentSize();
                for (int i = 0; i < this.mExecuteResultTotalCount; i++) {
                    SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().add(new StringBuilder());
                    ArrayList arrayList = SpellingCorrectionStreaming.this.mIsResultsCompleted;
                    Boolean bool = Boolean.FALSE;
                    arrayList.add(bool);
                    SpellingCorrectionStreaming.this.mIsResultStreamingBegin.add(bool);
                }
            }
        }

        private boolean isAllBeginBeforeN(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Boolean) SpellingCorrectionStreaming.this.mIsResultStreamingBegin.get(i2)).booleanValue()) {
                    return false;
                }
            }
            return true;
        }

        private boolean isAllCompletedBeforeN(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Boolean) SpellingCorrectionStreaming.this.mIsResultsCompleted.get(i2)).booleanValue()) {
                    return false;
                }
            }
            return true;
        }

        private void onStreamingMergeResult() {
            SpellingCorrectionStreaming.this.mResultCompletedCount++;
            SpellingCorrectionStreaming.this.mIsResultsCompleted.set(this.mResultIndex, Boolean.TRUE);
            if (SpellingCorrectionStreaming.this.mResultCompletedCount == this.mExecuteResultTotalCount) {
                for (int i = 0; i < this.mExecuteResultTotalCount; i++) {
                    SpellingCorrectionStreaming.this.mAllResult.append(SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(i).toString());
                }
                SpellingCorrectionStreaming.this.mStreamingCharManager.onStreamingMergeResult(SpellingCorrectionStreaming.this.mAllResult.toString(), true);
            }
        }

        private void onStreamingResult(String str) {
            for (int i = 1; i < this.mExecuteResultTotalCount; i++) {
                int i2 = i - 1;
                if (isAllCompletedBeforeN(i2) && !((Boolean) SpellingCorrectionStreaming.this.mIsResultsCompleted.get(i)).booleanValue()) {
                    if (((Boolean) SpellingCorrectionStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue() && this.mResultIndex == i) {
                        SpellingCorrectionStreaming.this.mStreamingCharManager.onResult(str, false);
                        return;
                    } else {
                        if (!isAllBeginBeforeN(i2) || ((Boolean) SpellingCorrectionStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue()) {
                            return;
                        }
                        SpellingCorrectionStreaming.this.mIsResultStreamingBegin.set(i, Boolean.TRUE);
                        SpellingCorrectionStreaming.this.mStreamingCharManager.onResult(SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(i).toString(), false);
                        return;
                    }
                }
                if (((Boolean) SpellingCorrectionStreaming.this.mIsResultsCompleted.get(i)).booleanValue() && isAllBeginBeforeN(i2) && !((Boolean) SpellingCorrectionStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue()) {
                    SpellingCorrectionStreaming.this.mIsResultStreamingBegin.set(i, Boolean.TRUE);
                    SpellingCorrectionStreaming.this.mStreamingCharManager.onResult(SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(i).toString(), false);
                    return;
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.CallbackImpl, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            String str2 = SpellingCorrectionStreaming.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("onCompleted# isCompleted: ", ", mResultIndex = ", z);
            sbM3200j.append(this.mResultIndex);
            sbM3200j.append(", result length = ");
            sbM3200j.append(str.length());
            Logger.m10999d(str2, sbM3200j.toString());
            SpellingCorrectionStreaming spellingCorrectionStreaming = SpellingCorrectionStreaming.this;
            if (spellingCorrectionStreaming.mSpellingCorrector == null || spellingCorrectionStreaming.mStreamingCharManager == null) {
                if (SpellingCorrectionStreaming.this.isParallelCancel) {
                    return;
                }
                Logger.m11000e(SpellingCorrectionStreaming.TAG, "null error");
                return;
            }
            if (z) {
                SrcContentInfo srcContentInfo = SpellingCorrectionStreaming.this.mSrcContentInfo;
                srcContentInfo.setCompletedIndex(srcContentInfo.getCompletedIndex() + 1);
            }
            if (this.mExecuteResultTotalCount <= 1) {
                SpellingCorrectionStreaming.this.mStreamingCharManager.onResult(str, z);
                return;
            }
            if (z) {
                if (SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).toString().isEmpty()) {
                    SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).append(str);
                }
                Logger.m11000e(SpellingCorrectionStreaming.TAG, "mResultIndex = " + this.mResultIndex);
                Logger.m11000e(SpellingCorrectionStreaming.TAG, "result = " + SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).toString());
                onStreamingMergeResult();
                return;
            }
            SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).append(str);
            if (this.mResultIndex == 0) {
                SpellingCorrectionStreaming.this.mIsResultStreamingBegin.set(0, Boolean.TRUE);
                SpellingCorrectionStreaming.this.mStreamingCharManager.onResult(str, false);
            } else if (((Boolean) SpellingCorrectionStreaming.this.mIsResultsCompleted.get(0)).booleanValue()) {
                if (((Boolean) SpellingCorrectionStreaming.this.mIsResultStreamingBegin.get(0)).booleanValue()) {
                    onStreamingResult(str);
                } else {
                    SpellingCorrectionStreaming.this.mStreamingCharManager.onResult(SpellingCorrectionStreaming.this.mStreamingCharManager.getResultContentList().get().get(0).toString(), false);
                }
            }
        }
    }

    public SpellingCorrectionStreaming(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        super(srcContentInfo, composerViewPresenter);
        this.mDefaultFontSize = 15;
        this.mDefaultFontColor = Color.parseColor("#252528");
        this.mIsResultsCompleted = new ArrayList<>();
        this.mIsResultStreamingBegin = new ArrayList<>();
        this.mResultCompletedCount = 0;
        this.mAllResult = new StringBuilder();
        this.isParallelCancel = false;
        this.mIsSupportedContinues = false;
    }

    private void initStreamingChar() {
        if (this.mStreamingCharManager != null) {
            return;
        }
        final boolean z = this.mSrcContentInfo.mSrcType == 2;
        StreamingCharManager streamingCharManager = new StreamingCharManager(new Consumer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.o
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f6893a.lambda$initStreamingChar$2(z, (String) obj);
            }
        });
        this.mStreamingCharManager = streamingCharManager;
        streamingCharManager.addOnCharPostCompleteListener(new C9466k(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeInternal$0() {
        executeInternal(this.mSrcContentInfo.getNextInput(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$1(String str, boolean z) {
        makeStreamingResult(str, z);
        SpellingCorrection.ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onCompleted(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$2(boolean z, String str) {
        this.mHandler.post(new RunnableC0202d(this, str, z, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$3() {
        String fullContent = this.mStreamingCharManager.getFullContent();
        AbstractC8014b.m7196B("#onCharPostComplete: ", fullContent, TAG);
        this.mSpellingCorrector = null;
        this.mStreamingCharManager = null;
        makeResult(fullContent);
        SpellingCorrection.ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onCompleted(true);
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrectionStreaming.1
                @Override // java.lang.Runnable
                public void run() {
                    SpellingCorrectionStreaming spellingCorrectionStreaming = SpellingCorrectionStreaming.this;
                    spellingCorrectionStreaming.mResultListener.setCountDiff(spellingCorrectionStreaming.getCountDiff());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$4(Void r32) {
        this.mHandler.post(new RunnableC9469n(this, 0));
    }

    private void makeStreamingResult(String str, boolean z) {
        SpenWNote spenWNote = this.mViewerNote;
        if (spenWNote == null || spenWNote.getBodyText() == null) {
            this.mViewerNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mSrcContentInfo.mSrcNote);
            this.mDefaultFontSize = AiViewUtils.getDefViewerSpFontSize(this.mComposerViewPresenter.getActivity());
            if (z && this.mSrcContentInfo.mSrcNote.getBodyText() != null) {
                int fontSize = (int) this.mSrcContentInfo.mSrcNote.getBodyText().getFontSize();
                this.mDefaultFontSize = fontSize;
                if (fontSize <= 0) {
                    this.mDefaultFontSize = AiViewUtils.getDefViewerSpFontSize(this.mComposerViewPresenter.getActivity());
                }
                this.mDefaultFontColor = this.mSrcContentInfo.mSrcNote.getBodyText().getTextColor();
            }
        }
        SpenObjectTextBox newBodyText = this.mComposerViewPresenter.getObjectManager().getNewBodyText();
        newBodyText.setFontSize(this.mDefaultFontSize);
        if (z) {
            newBodyText.setTextAlignment(Alignment.getDefaultAlign());
            newBodyText.setTextColor(this.mDefaultFontColor);
        }
        newBodyText.insertText(str, 0);
        ResultNoteManager.replaceStreamingResultText(this.mViewerNote, newBodyText);
        updateResult(newBodyText, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrection
    public void cancel() {
        super.cancel();
        Logger.m10999d(TAG, "cancel");
        Optional.ofNullable(this.mStreamingCharManager).ifPresent(new C9472q(2));
        this.isParallelCancel = true;
        StreamingCharManager streamingCharManager = this.mStreamingCharManager;
        if (streamingCharManager != null) {
            streamingCharManager.cancel();
            this.mStreamingCharManager = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrection
    public void executeInternal(String str, boolean z) {
        Logger.m10999d(TAG, "executeInternal# length = " + str.length());
        initStreamingChar();
        SpellingCorrector spellingCorrector = new SpellingCorrector(str, true);
        this.mSpellingCorrector = spellingCorrector;
        spellingCorrector.registerCallback(new CallbackStreamingImpl(this.mSrcContentInfo.getInputIndex() - 1));
        this.mSpellingCorrector.execute();
        if (this.mSrcContentInfo.hasNextInputUnit()) {
            this.mHandler.postDelayed(new RunnableC9469n(this, 1), 1000L);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrection
    public boolean hasResult() {
        boolean zHasResult = super.hasResult();
        if (!zHasResult || this.mStreamingCharManager == null) {
            return zHasResult;
        }
        return false;
    }
}
