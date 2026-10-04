package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.p142ai.language.SummarizeSubTask;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.STTStreamingJsonManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.StreamingSummaryParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTTSummarizationItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.STTSummarizer;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class STTSummarizationStreaming extends STTSummarization {
    private static final int MAX_SUMMARIZE_REQUEST_AT_SAME_TIME = 3;
    private static final String TAG = Logger.createTag("STTSummarizationStreaming", AiConstants.PREFIX_TAG);
    private final AtomicInteger mCurrentExecutingCount;
    private int mCurrentRequestedIndex;
    private int mCurrentStreamingIndex;
    private final List<Pair<Summarizer, SummarizeStreamingCallback>> mSummarizersList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SummarizeStreamingCallback implements Operator.Callback {
        private final int mIndex;
        private String mSummaryJsonResult;
        private STTStreamingJsonManager sttStreamingJsonManager;
        private boolean mIsCompleted = false;
        private boolean mIsStartedRequest = false;
        private boolean mIsStartedStreaming = false;
        private boolean mIsSkipStreaming = false;

        public SummarizeStreamingCallback(int i) {
            this.mIndex = i;
            STTStreamingJsonManager sTTStreamingJsonManager = new STTStreamingJsonManager(new C9466k(this, 0));
            this.sttStreamingJsonManager = sTTStreamingJsonManager;
            sTTStreamingJsonManager.setOnCharPostCompleteListener(new C9466k(this, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(final StreamingSummaryParser streamingSummaryParser) {
            STTSummarizationStreaming.this.requestNextSummary();
            this.mSummaryJsonResult = this.sttStreamingJsonManager.getFullContent();
            if (STTSummarizationStreaming.this.mCurrentStreamingIndex != this.mIndex) {
                return;
            }
            Logger.m10999d(STTSummarizationStreaming.TAG, "mStreamingCharManager# index: " + this.mIndex + ", pending count: " + STTSummarizationStreaming.this.mSummaryRequestCount.get() + ", length: " + this.mSummaryJsonResult.length());
            STTSummarizationStreaming.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarizationStreaming.SummarizeStreamingCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    SummarizeStreamingCallback summarizeStreamingCallback = SummarizeStreamingCallback.this;
                    List<AiMenuResultViewSTTSummarizationItem> list = STTSummarizationStreaming.this.mSummaryResultItemList;
                    if (list == null) {
                        return;
                    }
                    AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = list.get(summarizeStreamingCallback.mIndex);
                    aiMenuResultViewSTTSummarizationItem.setSummaryLines(streamingSummaryParser.getSummaries());
                    aiMenuResultViewSTTSummarizationItem.setSummaryTitle(streamingSummaryParser.getTitle());
                    aiMenuResultViewSTTSummarizationItem.setTranslatedLines(new ArrayList<>());
                    aiMenuResultViewSTTSummarizationItem.setHidden(false);
                    aiMenuResultViewSTTSummarizationItem.setStreamCompleted(false);
                    AiMenuContract.ResultListener resultListener = STTSummarizationStreaming.this.mResultListener;
                    if (resultListener != null) {
                        resultListener.onCompleted(false);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(boolean z) {
            STTSummarizationStreaming.this.mAiSTTContract.getSTTPresenter().onVoiceDataListChange(STTSummarizationStreaming.this.mExecutePosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2() {
            boolean z;
            STTSummarizationStreaming.this.streamingNextItem();
            STTStreamingJsonManager sTTStreamingJsonManager = this.sttStreamingJsonManager;
            if (sTTStreamingJsonManager == null || STTSummarizationStreaming.this.mResultListener == null) {
                return;
            }
            String fullContent = sTTStreamingJsonManager.getFullContent();
            this.mSummaryJsonResult = fullContent;
            STTSummarizationStreaming.this.updateSummaryResultItem(this.mIndex, fullContent);
            if (STTSummarizationStreaming.this.mSummaryRequestCount.decrementAndGet() == 0) {
                STTSummarizationStreaming sTTSummarizationStreaming = STTSummarizationStreaming.this;
                sTTSummarizationStreaming.mSummarizer = null;
                sTTSummarizationStreaming.removeHiddenItem();
                z = true;
            } else {
                z = false;
            }
            Logger.m10999d(STTSummarizationStreaming.TAG, "OnCharPostCompleteListener# " + STTSummarizationStreaming.this.mSummaryRequestCount.get() + " " + this.mSummaryJsonResult.length() + " #completedAll " + z);
            AiMenuContract.ResultListener resultListener = STTSummarizationStreaming.this.mResultListener;
            if (resultListener != null) {
                resultListener.onCompleted(z);
            }
            if (z) {
                STTSummarizationStreaming.this.writeSummaryResult(new C9467l(this, 0));
            }
            this.sttStreamingJsonManager.cancel();
            this.sttStreamingJsonManager = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$3(Void r32) {
            STTSummarizationStreaming.this.mHandler.post(new RunnableC9463h(this, 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$4(String str) {
            STTSummarizationStreaming.this.mResultListener.onFailed(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$5(boolean z) {
            STTSummarizationStreaming.this.mAiSTTContract.getSTTPresenter().onVoiceDataListChange(STTSummarizationStreaming.this.mExecutePosition);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            int iDecrementAndGet = STTSummarizationStreaming.this.mSummaryRequestCount.decrementAndGet();
            Logger.m11000e(STTSummarizationStreaming.TAG, "SummarizeCallback#onFailed# index: " + this.mIndex + " mSummaryFailedCount : " + STTSummarizationStreaming.this.mSummaryFailedCount.get() + " pending : " + iDecrementAndGet + " : " + str);
            STTSummarizationStreaming sTTSummarizationStreaming = STTSummarizationStreaming.this;
            if (sTTSummarizationStreaming.mSummarizer != null) {
                sTTSummarizationStreaming.hideSummaryResultItem(this.mIndex);
                STTSummarizationStreaming.this.mCurrentExecutingCount.decrementAndGet();
                this.mIsSkipStreaming = true;
                this.mIsCompleted = true;
                STTSummarizationStreaming.this.streamingNextItem();
                this.sttStreamingJsonManager.cancel();
                if (STTSummarizationStreaming.this.mSummaryFailedCount.incrementAndGet() == STTSummarizationStreaming.this.mSummaryResultItemList.size()) {
                    Logger.m10999d(STTSummarizationStreaming.TAG, "SummarizeCallback#onFailed completed, all items have failed");
                    STTSummarizationStreaming sTTSummarizationStreaming2 = STTSummarizationStreaming.this;
                    sTTSummarizationStreaming2.mSummarizer = null;
                    sTTSummarizationStreaming2.mSummaryRequestCount.set(0);
                    String errorMessage = STTSummarizationStreaming.this.getErrorMessage(str);
                    STTSummarizationStreaming sTTSummarizationStreaming3 = STTSummarizationStreaming.this;
                    sTTSummarizationStreaming3.mLastErrorMessage = errorMessage;
                    if (sTTSummarizationStreaming3.mResultListener != null) {
                        sTTSummarizationStreaming3.mHandler.post(new RunnableC9456a(2, this, errorMessage));
                        return true;
                    }
                } else {
                    if (iDecrementAndGet == 0) {
                        Logger.m10999d(STTSummarizationStreaming.TAG, "SummarizeCallback#onFailed completed");
                        STTSummarizationStreaming sTTSummarizationStreaming4 = STTSummarizationStreaming.this;
                        sTTSummarizationStreaming4.mSummarizer = null;
                        sTTSummarizationStreaming4.removeHiddenItem();
                        AiMenuContract.ResultListener resultListener = STTSummarizationStreaming.this.mResultListener;
                        if (resultListener != null) {
                            resultListener.onCompleted(true);
                        }
                        STTSummarizationStreaming.this.writeSummaryResult(new C9467l(this, 1));
                        return true;
                    }
                    Logger.m10999d(STTSummarizationStreaming.TAG, "SummarizeCallback#onFailed update view for hiddenItem");
                    AiMenuContract.ResultListener resultListener2 = STTSummarizationStreaming.this.mResultListener;
                    if (resultListener2 != null) {
                        resultListener2.onCompleted(false);
                    }
                }
            }
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
        public void onRetry(Runnable runnable) {
            Logger.m10999d(STTSummarizationStreaming.TAG, "SummarizeCallback#onRetry");
            AiCommonUtil.executeRetryAction(runnable);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            String str2 = STTSummarizationStreaming.TAG;
            StringBuilder sb = new StringBuilder("SummarizeStreamingCallback#onSuccess# ");
            sb.append(this.mIndex);
            sb.append(" : ");
            sb.append(str.length());
            sb.append(" ##");
            AbstractC8014b.m7215q(sb, z, str2);
            STTSummarizationStreaming sTTSummarizationStreaming = STTSummarizationStreaming.this;
            if (sTTSummarizationStreaming.mSummarizer == null) {
                return;
            }
            this.mIsCompleted = z;
            if (z) {
                int iDecrementAndGet = sTTSummarizationStreaming.mCurrentExecutingCount.decrementAndGet();
                Logger.m10999d(STTSummarizationStreaming.TAG, "SummarizeStreamingCallback#onSuccess# index " + this.mIndex + "## streamingExecutingCount " + iDecrementAndGet);
            }
            this.sttStreamingJsonManager.onResult(str, z);
            if (STTSummarizationStreaming.this.mCurrentStreamingIndex == this.mIndex) {
                this.mIsStartedStreaming = true;
                this.sttStreamingJsonManager.startStreaming();
            }
        }
    }

    public STTSummarizationStreaming(ISTTWindow.IAIContract iAIContract, ComposerViewPresenter composerViewPresenter) {
        super(iAIContract, composerViewPresenter);
        this.mSummarizersList = new ArrayList();
        this.mCurrentExecutingCount = new AtomicInteger(0);
        this.mIsStreamingMode = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void requestNextSummary() {
        for (int i = this.mCurrentRequestedIndex; i < this.mSummarizersList.size(); i++) {
            if (this.mCurrentExecutingCount.get() >= 3) {
                Logger.m10999d(TAG, "requestNextSummary skip MAX_SUMMARIZE_REQUEST_AT_SAME_TIME 3");
                return;
            }
            Pair<Summarizer, SummarizeStreamingCallback> pair = this.mSummarizersList.get(i);
            SummarizeStreamingCallback summarizeStreamingCallback = (SummarizeStreamingCallback) pair.second;
            if (!summarizeStreamingCallback.mIsCompleted && !summarizeStreamingCallback.mIsStartedStreaming && !summarizeStreamingCallback.mIsStartedRequest) {
                ((Summarizer) pair.first).execute();
                summarizeStreamingCallback.mIsStartedRequest = true;
                this.mCurrentExecutingCount.incrementAndGet();
                this.mCurrentRequestedIndex = summarizeStreamingCallback.mIndex;
                Logger.m10999d(TAG, "requestNextSummary executing: " + this.mCurrentExecutingCount.get() + " index " + summarizeStreamingCallback.mIndex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void streamingNextItem() {
        requestNextSummary();
        if (this.mCurrentStreamingIndex >= this.mSummarizersList.size()) {
            return;
        }
        SummarizeStreamingCallback summarizeStreamingCallback = (SummarizeStreamingCallback) this.mSummarizersList.get(this.mCurrentStreamingIndex).second;
        if (!summarizeStreamingCallback.mIsStartedStreaming && !summarizeStreamingCallback.mIsSkipStreaming) {
            AbstractC8014b.m7221w(new StringBuilder("wait for current item start streaming: item "), TAG, this.mCurrentStreamingIndex);
            return;
        }
        int i = this.mCurrentStreamingIndex + 1;
        this.mCurrentStreamingIndex = i;
        if (i >= this.mSummarizersList.size()) {
            return;
        }
        Object obj = this.mSummarizersList.get(this.mCurrentStreamingIndex).second;
        while (true) {
            SummarizeStreamingCallback summarizeStreamingCallback2 = (SummarizeStreamingCallback) obj;
            if (!summarizeStreamingCallback2.mIsSkipStreaming) {
                if (!summarizeStreamingCallback2.mIsStartedRequest || summarizeStreamingCallback2.mIsStartedStreaming) {
                    AbstractC8014b.m7221w(new StringBuilder("invalid nextStreamingItem "), TAG, this.mCurrentStreamingIndex);
                    return;
                }
                AbstractC8014b.m7221w(new StringBuilder("start nextStreamingItem "), TAG, this.mCurrentStreamingIndex);
                summarizeStreamingCallback2.mIsStartedStreaming = true;
                if (summarizeStreamingCallback2.sttStreamingJsonManager != null) {
                    summarizeStreamingCallback2.sttStreamingJsonManager.startStreaming();
                    return;
                }
                return;
            }
            int i2 = this.mCurrentStreamingIndex + 1;
            this.mCurrentStreamingIndex = i2;
            if (i2 >= this.mSummarizersList.size()) {
                return;
            } else {
                obj = this.mSummarizersList.get(this.mCurrentStreamingIndex).second;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization
    public void execute() {
        this.mSummarizersList.clear();
        this.mCurrentExecutingCount.set(0);
        this.mCurrentStreamingIndex = 0;
        this.mCurrentRequestedIndex = 0;
        super.execute();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization
    public void onReleaseSection() {
        super.onReleaseSection();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization
    public void requestSummary(int i) {
        String paragraph = this.mSummaryResultItemList.get(i).getParagraph();
        Logger.m10999d(TAG, "requestSummary " + LoggerBase.getEncode(paragraph));
        STTSummarizer sTTSummarizer = new STTSummarizer(UnicodeUtils.removeObjectReplacementChar(paragraph), SummaryStyle.valueOf(this.mOption.getSCSOptionStr()), true);
        sTTSummarizer.setSummarizeSubTask(SummarizeSubTask.DIALOGUE);
        sTTSummarizer.setExtraKey(String.valueOf(i));
        SummarizeStreamingCallback summarizeStreamingCallback = new SummarizeStreamingCallback(i);
        sTTSummarizer.registerCallback(summarizeStreamingCallback);
        this.mSummarizersList.add(new Pair<>(sTTSummarizer, summarizeStreamingCallback));
        if (i != 0) {
            requestNextSummary();
            return;
        }
        this.mCurrentStreamingIndex = 0;
        Pair<Summarizer, SummarizeStreamingCallback> pair = this.mSummarizersList.get(0);
        if (pair != null) {
            this.mSummarizer = (Summarizer) pair.first;
            ((SummarizeStreamingCallback) pair.second).mIsStartedRequest = true;
            this.mSummarizer.execute();
            this.mCurrentRequestedIndex = 0;
            this.mCurrentExecutingCount.incrementAndGet();
        }
    }
}
