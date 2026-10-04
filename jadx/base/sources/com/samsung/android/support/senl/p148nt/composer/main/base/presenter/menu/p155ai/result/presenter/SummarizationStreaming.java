package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.SummarizerPostProcessor;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SummarizationStreaming extends Summarization {
    private static final String TAG = Logger.createTag("SummarizationStreaming", AiConstants.PREFIX_TAG);
    private StreamingCharManager mStreamingCharManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CallbackStreamingImpl implements Operator.Callback {
        public CallbackStreamingImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$0(String str) {
            AiMenuContract.ResultListener resultListener = SummarizationStreaming.this.mResultListener;
            if (resultListener != null) {
                resultListener.onFailed(str);
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            SummarizationStreaming summarizationStreaming = SummarizationStreaming.this;
            if (summarizationStreaming.mSummarizer == null) {
                Logger.m10999d(SummarizationStreaming.TAG, "onFailed# is canceled");
                return false;
            }
            summarizationStreaming.mSummarizer = null;
            SummarizationStreaming.this.mHandler.post(new RunnableC9456a(4, this, summarizationStreaming.getErrorMessage(str)));
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
        public void onRetry(Runnable runnable) {
            AiCommonUtil.executeRetryAction(runnable);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            Logger.m10999d(SummarizationStreaming.TAG, "onCompleted# " + str.length());
            SummarizationStreaming summarizationStreaming = SummarizationStreaming.this;
            if (summarizationStreaming.mSummarizer == null) {
                Logger.m10999d(SummarizationStreaming.TAG, "onSuccess# is canceled");
                return;
            }
            if (z) {
                SrcContentInfo srcContentInfo = summarizationStreaming.mSrcContentInfo;
                srcContentInfo.setCompletedIndex(srcContentInfo.getCompletedIndex() + 1);
            }
            if (!z || !SummarizationStreaming.this.hasNext()) {
                SummarizationStreaming.this.mStreamingCharManager.onResult(str, z);
                return;
            }
            SummarizationStreaming summarizationStreaming2 = SummarizationStreaming.this;
            summarizationStreaming2.summarize(summarizationStreaming2.mSrcContentInfo.getNextInput(), SummaryStyle.valueOf(SummarizationStreaming.this.mOption.getSCSOptionStr()), false);
            SummarizationStreaming.this.mStreamingCharManager.onResult(str.concat("\n"), false);
        }
    }

    public SummarizationStreaming(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        super(srcContentInfo, composerViewPresenter);
        this.mIsStreamingMode = true;
    }

    private void initStreamingChar() {
        if (this.mStreamingCharManager != null) {
            return;
        }
        final int i = 0;
        StreamingCharManager streamingCharManager = new StreamingCharManager(new Consumer(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.r

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SummarizationStreaming f6897b;

            {
                this.f6897b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.f6897b.lambda$initStreamingChar$1((String) obj);
                        break;
                    default:
                        this.f6897b.lambda$initStreamingChar$3((Void) obj);
                        break;
                }
            }
        });
        this.mStreamingCharManager = streamingCharManager;
        final int i2 = 1;
        streamingCharManager.addOnCharPostCompleteListener(new Consumer(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.r

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SummarizationStreaming f6897b;

            {
                this.f6897b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.f6897b.lambda$initStreamingChar$1((String) obj);
                        break;
                    default:
                        this.f6897b.lambda$initStreamingChar$3((Void) obj);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$0(String str) {
        SpenWNote spenWNote;
        if (str.length() >= 2) {
            str = new SummarizerPostProcessor(str).getResult();
        }
        makeResultNote(str);
        SrcContentInfo srcContentInfo = this.mSrcContentInfo;
        if (srcContentInfo != null && srcContentInfo.mSrcType == 2 && (spenWNote = this.mResultNote) != null && spenWNote.getBodyText() != null) {
            this.mResultNote.getBodyText().setTextAlignment(Alignment.getDefaultAlign());
        }
        AiMenuContract.ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onCompleted(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$1(String str) {
        this.mHandler.post(new RunnableC9456a(6, this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$2() {
        StreamingCharManager streamingCharManager = this.mStreamingCharManager;
        if (streamingCharManager != null && this.mResultListener != null) {
            String fullContent = streamingCharManager.getFullContent();
            setSelectionMaxLength(fullContent.length());
            setResultText(fullContent);
            if (fullContent.length() >= 2) {
                fullContent = new SummarizerPostProcessor(fullContent).getResult();
            }
            makeResultNote(fullContent);
            this.mResultListener.onCompleted(true);
        }
        this.mSummarizer = null;
        this.mStreamingCharManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingChar$3(Void r32) {
        this.mHandler.post(new RunnableC9463h(this, 5));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization
    public void cancel() {
        super.cancel();
        StreamingCharManager streamingCharManager = this.mStreamingCharManager;
        if (streamingCharManager != null) {
            streamingCharManager.cancel();
            this.mStreamingCharManager = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization
    public boolean hasResult() {
        boolean zHasResult = super.hasResult();
        if (!zHasResult || this.mStreamingCharManager == null) {
            return zHasResult;
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization
    public void summarize(String str, SummaryStyle summaryStyle, boolean z) {
        Logger.m10999d(TAG, "summarize# " + summaryStyle.name());
        initStreamingChar();
        Summarizer summarizer = new Summarizer(UnicodeUtils.removeObjectReplacementChar(str), summaryStyle, true);
        this.mSummarizer = summarizer;
        summarizer.registerCallback(new CallbackStreamingImpl());
        this.mSummarizer.execute();
    }
}
