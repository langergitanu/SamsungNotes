package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.MeetingAutoFormatter;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.StructuredAutoFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatStreaming extends AutoFormat {
    private static final int PARALLEL_DELAY_MILLIS = 1000;
    public static final int STREAMING_STYLE_NUM = 999;
    private static final String TAG = Logger.createTag("AutoFormatStreaming", AiConstants.PREFIX_TAG);
    private final String END_SYMBOL;
    private final String QUOTA;
    private final AtomicReference<Boolean> isParallelCancel;
    private Operator.Callback mCallback;
    private Operator mFormatter;
    private final AtomicReference<Pair<Boolean, Boolean>> mFormattingStatus;
    private StreamingCharManager mStreamingCharManager;
    private SpenWNote mStreamingResultNote;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MeetingFormatStreaming extends AutoFormat.MeetingFormat {
        private final StringBuilder mAllResult;
        private Integer mDefaultFontSize;
        private final List<Boolean> mIsResultStreamingBegin;
        private final List<Boolean> mIsResultsCompleted;
        private int mResultCompletedCount;
        private StreamingCharManager mStreamingCharManager;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class MeetingFormatCallbackStreamingImpl implements Operator.Callback {
            private final int mResultIndex;
            private final StreamingCharManager mStreamingCharManager;

            public MeetingFormatCallbackStreamingImpl(int i, StreamingCharManager streamingCharManager) {
                this.mResultIndex = i;
                this.mStreamingCharManager = streamingCharManager;
                initResultContent();
            }

            private void initResultContent() {
                StreamingCharManager streamingCharManager = this.mStreamingCharManager;
                if (streamingCharManager == null) {
                    return;
                }
                if (streamingCharManager.getResultContentList() == null || this.mStreamingCharManager.getResultContentList().get().isEmpty()) {
                    this.mStreamingCharManager.setResultContentSize();
                    for (int i = 0; i < AutoFormatStreaming.this.mSrcContentInfo.getInputList().size(); i++) {
                        this.mStreamingCharManager.getResultContentList().get().add(new StringBuilder());
                        List list = MeetingFormatStreaming.this.mIsResultsCompleted;
                        Boolean bool = Boolean.FALSE;
                        list.add(bool);
                        MeetingFormatStreaming.this.mIsResultStreamingBegin.add(bool);
                    }
                }
            }

            private boolean isAllBeginBeforeN(int i) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (!((Boolean) MeetingFormatStreaming.this.mIsResultStreamingBegin.get(i2)).booleanValue()) {
                        return false;
                    }
                }
                return true;
            }

            private boolean isAllCompletedBeforeN(int i) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (!((Boolean) MeetingFormatStreaming.this.mIsResultsCompleted.get(i2)).booleanValue()) {
                        return false;
                    }
                }
                return true;
            }

            private void matchResult(String str) {
                for (int i = 1; i < AutoFormatStreaming.this.mSrcContentInfo.getInputList().size(); i++) {
                    int i2 = i - 1;
                    if (isAllCompletedBeforeN(i2) && !((Boolean) MeetingFormatStreaming.this.mIsResultsCompleted.get(i)).booleanValue()) {
                        if (((Boolean) MeetingFormatStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue() && this.mResultIndex == i) {
                            this.mStreamingCharManager.onResult(AutoFormatStreaming.this.updateResult(str), false);
                            return;
                        } else {
                            if (!isAllBeginBeforeN(i2) || ((Boolean) MeetingFormatStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue()) {
                                return;
                            }
                            MeetingFormatStreaming.this.mIsResultStreamingBegin.set(i, Boolean.TRUE);
                            StreamingCharManager streamingCharManager = this.mStreamingCharManager;
                            streamingCharManager.onResult(AutoFormatStreaming.this.updateResult(streamingCharManager.getResultContentList().get().get(i).toString()), false);
                            return;
                        }
                    }
                    if (((Boolean) MeetingFormatStreaming.this.mIsResultsCompleted.get(i)).booleanValue() && isAllBeginBeforeN(i2) && !((Boolean) MeetingFormatStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue()) {
                        MeetingFormatStreaming.this.mIsResultStreamingBegin.set(i, Boolean.TRUE);
                        StreamingCharManager streamingCharManager2 = this.mStreamingCharManager;
                        streamingCharManager2.onResult(AutoFormatStreaming.this.updateResult(streamingCharManager2.getResultContentList().get().get(i).toString()), false);
                        return;
                    }
                }
            }

            private void onStreamingMergeResult() {
                MeetingFormatStreaming.this.mResultCompletedCount++;
                MeetingFormatStreaming.this.mIsResultsCompleted.set(this.mResultIndex, Boolean.TRUE);
                int i = this.mResultIndex;
                if (i == 0) {
                    AutoFormatStreaming.this.changeResultContent(i);
                    MeetingFormatStreaming.this.mAllResult.append(this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).toString());
                }
                if (MeetingFormatStreaming.this.mResultCompletedCount == AutoFormatStreaming.this.mSrcContentInfo.getInputList().size()) {
                    for (int i2 = 1; i2 < MeetingFormatStreaming.this.mResultCompletedCount; i2++) {
                        if (i2 != MeetingFormatStreaming.this.mResultCompletedCount - 1) {
                            AutoFormatStreaming.this.changeResultContent(i2);
                        }
                        MeetingFormatStreaming.this.mAllResult.append(AutoFormatStreaming.this.updateResult(this.mStreamingCharManager.getResultContentList().get().get(i2).toString()));
                    }
                    this.mStreamingCharManager.onStreamingMergeResult(MeetingFormatStreaming.this.mAllResult.toString(), true);
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str) {
                AutoFormatStreaming.this.mFormatter = null;
                MeetingFormatStreaming.this.onFailed(AutoFormatStreaming.this.getErrorMessage(str));
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
            public void onRetry(Runnable runnable) {
                AiCommonUtil.executeRetryAction(runnable);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                if (this.mStreamingCharManager == null || ((Boolean) AutoFormatStreaming.this.isParallelCancel.get()).booleanValue() || !((Boolean) ((Pair) AutoFormatStreaming.this.mFormattingStatus.get()).second).booleanValue()) {
                    return;
                }
                if (AutoFormatStreaming.this.mSrcContentInfo.getInputList().size() <= 1) {
                    Logger.m10999d(AutoFormatStreaming.TAG, "MeetingFormatStreaming# onSuccess: " + str.length());
                    this.mStreamingCharManager.onResult(str, z);
                    return;
                }
                String str2 = AutoFormatStreaming.TAG;
                StringBuilder sbM3200j = AbstractC4539a.m3200j("MeetingFormatStreaming# isCompleted: ", ", mResultIndex = ", z);
                sbM3200j.append(this.mResultIndex);
                sbM3200j.append(", result length = ");
                sbM3200j.append(str.length());
                Logger.m10999d(str2, sbM3200j.toString());
                if (this.mStreamingCharManager.getResultContentList() == null) {
                    return;
                }
                if (z) {
                    if ("".equals(this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).toString())) {
                        this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).append(str);
                    }
                    onStreamingMergeResult();
                    return;
                }
                this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).append(str);
                if (this.mResultIndex == 0) {
                    MeetingFormatStreaming.this.mIsResultStreamingBegin.set(0, Boolean.TRUE);
                    this.mStreamingCharManager.onResult(str, false);
                } else if (((Boolean) MeetingFormatStreaming.this.mIsResultsCompleted.get(0)).booleanValue()) {
                    if (((Boolean) MeetingFormatStreaming.this.mIsResultStreamingBegin.get(0)).booleanValue()) {
                        matchResult(str);
                    } else {
                        StreamingCharManager streamingCharManager = this.mStreamingCharManager;
                        streamingCharManager.onResult(streamingCharManager.getResultContentList().get().get(0).toString(), false);
                    }
                }
            }
        }

        public /* synthetic */ MeetingFormatStreaming(AutoFormatStreaming autoFormatStreaming, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$formatting$0() {
            formatting(AutoFormatStreaming.this.mSrcContentInfo.getNextInput());
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void cancel() {
            super.cancel();
            if (AutoFormatStreaming.this.mFormatter != null) {
                AutoFormatStreaming.this.mFormatter.registerCallback(null);
                AutoFormatStreaming.this.mFormatter = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void formatting(String str) {
            Logger.m10999d(AutoFormatStreaming.TAG, "MeetingFormatStreaming formatting# " + str.length());
            this.mDefaultFontSize = null;
            AutoFormatStreaming autoFormatStreaming = AutoFormatStreaming.this;
            autoFormatStreaming.mCallback = new MeetingFormatCallbackStreamingImpl(autoFormatStreaming.mSrcContentInfo.getInputIndex() - 1, this.mStreamingCharManager);
            this.mIdentifiedLocale = Locale.SIMPLIFIED_CHINESE;
            AutoFormatStreaming.this.mFormatter = new MeetingAutoFormatter(str, true);
            AutoFormatStreaming.this.mFormatter.registerCallback(AutoFormatStreaming.this.mCallback);
            AutoFormatStreaming.this.mFormatter.execute();
            if (AutoFormatStreaming.this.mSrcContentInfo.hasNextInputUnit()) {
                AutoFormatStreaming.this.mHandler.postDelayed(new RunnableC9463h(this, 0), 1000L);
            }
        }

        public void makeStreamingNote() {
            if (AutoFormatStreaming.this.mStreamingResultNote == null || AutoFormatStreaming.this.mStreamingResultNote.getBodyText() == null) {
                AutoFormatStreaming autoFormatStreaming = AutoFormatStreaming.this;
                autoFormatStreaming.mStreamingResultNote = ResultNoteManager.makeNote(autoFormatStreaming.mComposerViewPresenter.getActivity(), AutoFormatStreaming.this.mComposerViewPresenter.getDoc());
            }
            if (this.mDefaultFontSize == null) {
                this.mDefaultFontSize = Integer.valueOf(getFontSize());
            }
            SpenObjectTextBox newBodyText = AutoFormatStreaming.this.mComposerViewPresenter.getObjectManager().getNewBodyText();
            AutoFormatStreaming.this.mServerResultParser.applyFormat(999, newBodyText, this.mDefaultFontSize.intValue());
            SrcContentInfo srcContentInfo = AutoFormatStreaming.this.mSrcContentInfo;
            if (srcContentInfo != null && srcContentInfo.mSrcType == 2) {
                newBodyText.setTextAlignment(Alignment.getDefaultAlign());
            }
            ResultNoteManager.replaceStreamingResultText(AutoFormatStreaming.this.mStreamingResultNote, newBodyText);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void onCompleted(String str, boolean z) {
            if (this.mStreamingCharManager == null) {
                Logger.m11004w(AutoFormatStreaming.TAG, "MeetingFormatStreaming# onCompleted streaming: process end, return: " + AutoFormatStreaming.this.mFormatter + " " + this.mStreamingCharManager);
                return;
            }
            if (z) {
                Logger.m10999d(AutoFormatStreaming.TAG, "MeetingFormatStreaming# isCompleted");
                AutoFormatStreaming.this.mFormatter = null;
                this.mStreamingCharManager = null;
                super.onCompleted(str, true);
                return;
            }
            parseResult(str);
            if (AutoFormatStreaming.this.mServerResultParser.checkParseResult()) {
                makeStreamingNote();
                AutoFormat.ResultListener resultListener = AutoFormatStreaming.this.mResultListener;
                if (resultListener != null) {
                    resultListener.onResult(false);
                }
            }
        }

        public void setStreamingCharManager(StreamingCharManager streamingCharManager) {
            this.mStreamingCharManager = streamingCharManager;
        }

        private MeetingFormatStreaming() {
            super();
            this.mIsResultsCompleted = new ArrayList();
            this.mIsResultStreamingBegin = new ArrayList();
            this.mResultCompletedCount = 0;
            this.mAllResult = new StringBuilder();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class NormalFormatStreaming extends AutoFormat.NormalFormat {
        private final StringBuilder mAllResult;
        private Integer mDefaultFontSize;
        private final List<Boolean> mIsResultStreamingBegin;
        private final List<Boolean> mIsResultsCompleted;
        private int mResultCompletedCount;
        private StreamingCharManager mStreamingCharManager;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class NormalFormatCallbackStreamingImpl implements Operator.Callback {
            private final int mResultIndex;
            private StreamingCharManager mStreamingCharManager;

            public NormalFormatCallbackStreamingImpl(int i, StreamingCharManager streamingCharManager) {
                this.mResultIndex = i;
                this.mStreamingCharManager = streamingCharManager;
                initResultContent();
            }

            private void initResultContent() {
                StreamingCharManager streamingCharManager = this.mStreamingCharManager;
                if (streamingCharManager == null) {
                    return;
                }
                if (streamingCharManager.getResultContentList() == null || this.mStreamingCharManager.getResultContentList().get().isEmpty()) {
                    this.mStreamingCharManager.setResultContentSize();
                    for (int i = 0; i < AutoFormatStreaming.this.mSrcContentInfo.getInputList().size(); i++) {
                        this.mStreamingCharManager.getResultContentList().get().add(new StringBuilder());
                        List list = NormalFormatStreaming.this.mIsResultsCompleted;
                        Boolean bool = Boolean.FALSE;
                        list.add(bool);
                        NormalFormatStreaming.this.mIsResultStreamingBegin.add(bool);
                    }
                }
            }

            private boolean isAllBeginBeforeN(int i) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (!((Boolean) NormalFormatStreaming.this.mIsResultStreamingBegin.get(i2)).booleanValue()) {
                        return false;
                    }
                }
                return true;
            }

            private boolean isAllCompletedBeforeN(int i) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (!((Boolean) NormalFormatStreaming.this.mIsResultsCompleted.get(i2)).booleanValue()) {
                        return false;
                    }
                }
                return true;
            }

            private void matchResult(String str) {
                for (int i = 1; i < AutoFormatStreaming.this.mSrcContentInfo.getInputList().size(); i++) {
                    int i2 = i - 1;
                    if (isAllCompletedBeforeN(i2) && !((Boolean) NormalFormatStreaming.this.mIsResultsCompleted.get(i)).booleanValue()) {
                        if (((Boolean) NormalFormatStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue() && this.mResultIndex == i) {
                            this.mStreamingCharManager.onResult(AutoFormatStreaming.this.updateResult(str), false);
                            return;
                        } else {
                            if (!isAllBeginBeforeN(i2) || ((Boolean) NormalFormatStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue()) {
                                return;
                            }
                            NormalFormatStreaming.this.mIsResultStreamingBegin.set(i, Boolean.TRUE);
                            StreamingCharManager streamingCharManager = this.mStreamingCharManager;
                            streamingCharManager.onResult(AutoFormatStreaming.this.updateResult(streamingCharManager.getResultContentList().get().get(i).toString()), false);
                            return;
                        }
                    }
                    if (((Boolean) NormalFormatStreaming.this.mIsResultsCompleted.get(i)).booleanValue() && isAllBeginBeforeN(i2) && !((Boolean) NormalFormatStreaming.this.mIsResultStreamingBegin.get(i)).booleanValue()) {
                        NormalFormatStreaming.this.mIsResultStreamingBegin.set(i, Boolean.TRUE);
                        StreamingCharManager streamingCharManager2 = this.mStreamingCharManager;
                        streamingCharManager2.onResult(AutoFormatStreaming.this.updateResult(streamingCharManager2.getResultContentList().get().get(i).toString()), false);
                        return;
                    }
                }
            }

            private void onStreamingMergeResult() {
                NormalFormatStreaming.this.mResultCompletedCount++;
                NormalFormatStreaming.this.mIsResultsCompleted.set(this.mResultIndex, Boolean.TRUE);
                int i = this.mResultIndex;
                if (i == 0) {
                    AutoFormatStreaming.this.changeResultContent(i);
                    NormalFormatStreaming.this.mAllResult.append(this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).toString());
                }
                if (NormalFormatStreaming.this.mResultCompletedCount == AutoFormatStreaming.this.mSrcContentInfo.getInputList().size()) {
                    for (int i2 = 1; i2 < NormalFormatStreaming.this.mResultCompletedCount; i2++) {
                        if (i2 != NormalFormatStreaming.this.mResultCompletedCount - 1) {
                            AutoFormatStreaming.this.changeResultContent(i2);
                        }
                        NormalFormatStreaming.this.mAllResult.append(AutoFormatStreaming.this.updateResult(this.mStreamingCharManager.getResultContentList().get().get(i2).toString()));
                    }
                    this.mStreamingCharManager.onStreamingMergeResult(NormalFormatStreaming.this.mAllResult.toString(), true);
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str) {
                AutoFormatStreaming.this.mFormatter = null;
                this.mStreamingCharManager = null;
                NormalFormatStreaming.this.onFailed(AutoFormatStreaming.this.getErrorMessage(str));
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
            public void onRetry(Runnable runnable) {
                AiCommonUtil.executeRetryAction(runnable);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                if (this.mStreamingCharManager == null || ((Boolean) AutoFormatStreaming.this.isParallelCancel.get()).booleanValue() || !((Boolean) ((Pair) AutoFormatStreaming.this.mFormattingStatus.get()).first).booleanValue()) {
                    return;
                }
                if (AutoFormatStreaming.this.mSrcContentInfo.getInputList().size() <= 1) {
                    Logger.m10999d(AutoFormatStreaming.TAG, "NormalFormatStreaming# onSuccess: " + str.length());
                    this.mStreamingCharManager.onResult(str, z);
                    return;
                }
                String str2 = AutoFormatStreaming.TAG;
                StringBuilder sbM3200j = AbstractC4539a.m3200j("NormalFormatStreaming# isCompleted: ", ", mResultIndex = ", z);
                sbM3200j.append(this.mResultIndex);
                sbM3200j.append(", result length = ");
                sbM3200j.append(str.length());
                Logger.m10999d(str2, sbM3200j.toString());
                if (this.mStreamingCharManager.getResultContentList() == null) {
                    return;
                }
                if (z) {
                    if ("".equals(this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).toString())) {
                        this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).append(str);
                    }
                    onStreamingMergeResult();
                    return;
                }
                this.mStreamingCharManager.getResultContentList().get().get(this.mResultIndex).append(str);
                if (this.mResultIndex == 0) {
                    NormalFormatStreaming.this.mIsResultStreamingBegin.set(0, Boolean.TRUE);
                    this.mStreamingCharManager.onResult(str, false);
                } else if (((Boolean) NormalFormatStreaming.this.mIsResultsCompleted.get(0)).booleanValue()) {
                    if (((Boolean) NormalFormatStreaming.this.mIsResultStreamingBegin.get(0)).booleanValue()) {
                        matchResult(str);
                    } else {
                        StreamingCharManager streamingCharManager = this.mStreamingCharManager;
                        streamingCharManager.onResult(streamingCharManager.getResultContentList().get().get(0).toString(), false);
                    }
                }
            }
        }

        public /* synthetic */ NormalFormatStreaming(AutoFormatStreaming autoFormatStreaming, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$formatting$0() {
            formatting(AutoFormatStreaming.this.mSrcContentInfo.getNextInput());
        }

        private void makeStreamingNote() {
            if (AutoFormatStreaming.this.mStreamingResultNote == null || AutoFormatStreaming.this.mStreamingResultNote.getBodyText() == null) {
                AutoFormatStreaming autoFormatStreaming = AutoFormatStreaming.this;
                autoFormatStreaming.mStreamingResultNote = ResultNoteManager.makeNote(autoFormatStreaming.mComposerViewPresenter.getActivity(), AutoFormatStreaming.this.mComposerViewPresenter.getDoc());
            }
            if (this.mDefaultFontSize == null) {
                this.mDefaultFontSize = Integer.valueOf(getFontSize());
            }
            SpenObjectTextBox newBodyText = AutoFormatStreaming.this.mComposerViewPresenter.getObjectManager().getNewBodyText();
            AutoFormatStreaming.this.mServerResultParser.applyFormat(999, newBodyText, this.mDefaultFontSize.intValue());
            SrcContentInfo srcContentInfo = AutoFormatStreaming.this.mSrcContentInfo;
            if (srcContentInfo != null && srcContentInfo.mSrcType == 2) {
                newBodyText.setTextAlignment(Alignment.getDefaultAlign());
            }
            ResultNoteManager.replaceStreamingResultText(AutoFormatStreaming.this.mStreamingResultNote, newBodyText);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.NormalFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void cancel() {
            super.cancel();
            if (AutoFormatStreaming.this.mFormatter != null) {
                AutoFormatStreaming.this.mFormatter.registerCallback(null);
                AutoFormatStreaming.this.mFormatter = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.NormalFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void formatting(String str) {
            Logger.m10999d(AutoFormatStreaming.TAG, "NormalFormatStreaming formatting# " + str.length());
            this.mDefaultFontSize = null;
            AutoFormatStreaming autoFormatStreaming = AutoFormatStreaming.this;
            autoFormatStreaming.mCallback = new NormalFormatCallbackStreamingImpl(autoFormatStreaming.mSrcContentInfo.getInputIndex() - 1, this.mStreamingCharManager);
            AutoFormatStreaming.this.mFormatter = new StructuredAutoFormatter(str, StructuredAutoFormatter.Style.Note, true);
            AutoFormatStreaming.this.mFormatter.registerCallback(AutoFormatStreaming.this.mCallback);
            AutoFormatStreaming.this.mFormatter.execute();
            if (AutoFormatStreaming.this.mSrcContentInfo.hasNextInputUnit()) {
                AutoFormatStreaming.this.mHandler.postDelayed(new RunnableC9463h(this, 1), 1000L);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void onCompleted(String str, boolean z) {
            if (AutoFormatStreaming.this.mFormatter == null || this.mStreamingCharManager == null) {
                Logger.m11004w(AutoFormatStreaming.TAG, "NormalFormatStreaming# onCompleted streaming: process end, return");
                return;
            }
            if (z) {
                Logger.m10999d(AutoFormatStreaming.TAG, "NormalFormatStreaming# isCompleted");
                AutoFormatStreaming.this.mFormatter = null;
                this.mStreamingCharManager = null;
                super.onCompleted(str, true);
                return;
            }
            parseResult(str);
            if (AutoFormatStreaming.this.mServerResultParser.checkParseResult()) {
                makeStreamingNote();
                AutoFormat.ResultListener resultListener = AutoFormatStreaming.this.mResultListener;
                if (resultListener != null) {
                    resultListener.onResult(false);
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.NormalFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void parseResult(String str) {
            AutoFormatStreaming.this.mServerResultParser = new ServerResultParser(str, true);
            AutoFormatStreaming.this.mServerResultParser.parse();
        }

        public void setStreamingCharManager(StreamingCharManager streamingCharManager) {
            this.mStreamingCharManager = streamingCharManager;
        }

        private NormalFormatStreaming() {
            super();
            this.mIsResultsCompleted = new ArrayList();
            this.mIsResultStreamingBegin = new ArrayList();
            this.mResultCompletedCount = 0;
            this.mAllResult = new StringBuilder();
        }
    }

    public AutoFormatStreaming(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        super(srcContentInfo, composerViewPresenter);
        this.QUOTA = "\"";
        this.END_SYMBOL = "]\n}\n";
        this.isParallelCancel = new AtomicReference<>(Boolean.FALSE);
        this.mFormattingStatus = new AtomicReference<>();
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeResultContent(int i) {
        this.mStreamingCharManager.getResultContentList().get().get(i).delete(this.mStreamingCharManager.getResultContentList().get().get(i).length() - 4, this.mStreamingCharManager.getResultContentList().get().get(i).length());
    }

    private void initStreamingCharManager() {
        if (this.mStreamingCharManager != null) {
            return;
        }
        final int i = 0;
        StreamingCharManager streamingCharManager = new StreamingCharManager(new Consumer(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AutoFormatStreaming f6881b;

            {
                this.f6881b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.f6881b.lambda$initStreamingCharManager$1((String) obj);
                        break;
                    default:
                        this.f6881b.lambda$initStreamingCharManager$3((Void) obj);
                        break;
                }
            }
        });
        this.mStreamingCharManager = streamingCharManager;
        final int i2 = 1;
        streamingCharManager.addOnCharPostCompleteListener(new Consumer(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AutoFormatStreaming f6881b;

            {
                this.f6881b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.f6881b.lambda$initStreamingCharManager$1((String) obj);
                        break;
                    default:
                        this.f6881b.lambda$initStreamingCharManager$3((Void) obj);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingCharManager$0(String str) {
        this.mAbsFormat.onCompleted(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingCharManager$1(String str) {
        this.mHandler.post(new RunnableC9456a(5, this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingCharManager$2() {
        StreamingCharManager streamingCharManager;
        if (this.mFormatter == null || (streamingCharManager = this.mStreamingCharManager) == null) {
            return;
        }
        this.mAbsFormat.onCompleted(streamingCharManager.getFullContent(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStreamingCharManager$3(Void r32) {
        this.mHandler.post(new RunnableC9463h(this, 4));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat
    public void cancel() {
        Logger.m10999d(TAG, "cancel");
        super.cancel();
        Optional.ofNullable(this.mStreamingCharManager).ifPresent(new C9472q(2));
        this.mStreamingCharManager = null;
        this.isParallelCancel.set(Boolean.TRUE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat
    public void formatting(String str, AutoFormat.FormatType formatType) {
        Logger.m10999d(TAG, "formatting# " + formatType);
        int i = 0;
        if (formatType.equals(AutoFormat.FormatType.Meeting)) {
            MeetingFormatStreaming meetingFormatStreaming = new MeetingFormatStreaming(this, i);
            this.mAbsFormat = meetingFormatStreaming;
            this.mFormatter = meetingFormatStreaming.mMeetingFormatter;
            this.mFormattingStatus.set(new Pair<>(Boolean.FALSE, Boolean.TRUE));
        } else {
            NormalFormatStreaming normalFormatStreaming = new NormalFormatStreaming(this, i);
            this.mAbsFormat = normalFormatStreaming;
            this.mFormatter = normalFormatStreaming.mStructuredFormatter;
            this.mFormattingStatus.set(new Pair<>(Boolean.TRUE, Boolean.FALSE));
        }
        if (this.isParallelCancel.get().booleanValue()) {
            this.isParallelCancel.set(Boolean.FALSE);
        }
        StreamingCharManager streamingCharManager = this.mStreamingCharManager;
        if (streamingCharManager != null) {
            Optional.of(streamingCharManager).ifPresent(new C9472q(2));
            SpenWNote spenWNote = this.mStreamingResultNote;
            if (spenWNote != null) {
                spenWNote.getBodyText().removeAllText();
            }
            this.mStreamingCharManager = null;
        }
        this.mCallback = null;
        initStreamingCharManager();
        Optional.ofNullable(this.mStreamingResultNote).map(new C9461f(0)).ifPresent(new C9472q(3));
        String strRemoveObjectReplacementChar = UnicodeUtils.removeObjectReplacementChar(str);
        AutoFormat.AbsFormat absFormat = this.mAbsFormat;
        if (absFormat instanceof NormalFormatStreaming) {
            ((NormalFormatStreaming) absFormat).setStreamingCharManager(this.mStreamingCharManager);
        } else if (absFormat instanceof MeetingFormatStreaming) {
            ((MeetingFormatStreaming) absFormat).setStreamingCharManager(this.mStreamingCharManager);
        }
        this.mAbsFormat.formatting(strRemoveObjectReplacementChar);
    }

    public SpenWNote getStreamingNote() {
        return this.mStreamingResultNote;
    }

    public String updateResult(String str) {
        int iIndexOf = str.indexOf("\"contents\"");
        if (iIndexOf < 0) {
            return str;
        }
        String strSubstring = str.substring(iIndexOf, str.length());
        int iIndexOf2 = strSubstring.indexOf("[");
        return iIndexOf2 < 0 ? "" : strSubstring.substring(iIndexOf2 + 1, strSubstring.length()).replaceFirst("\n", ",\n");
    }
}
