package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.TextStyleHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.ChunkSizePolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer;
import com.samsung.android.support.senl.p148nt.model.assist.llm.SummarizerOnDevice;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Summarization implements AiMenuContract.IAiAction, AiMenuContract.SubTransition.IParentAction {
    public static final int MAX_LENGTH;
    public static final int MIN_LENGTH = 200;
    private static final String TAG = Logger.createTag("Summarization", AiConstants.PREFIX_TAG);
    private SpenObjectTextBox mBackupOrigin;
    private SpenObjectTextBox mBackupResult;
    SummaryOption mBeforeOption;
    ComposerViewPresenter mComposerViewPresenter;
    ErrorType mErrorType;
    Handler mHandler;
    private String mIdentifiedLanguage;
    boolean mIsAutoProcessing;
    boolean mIsRestore;
    boolean mIsStreamingMode;
    LanguageIdentifier mLanguageIdentifier;
    String mLastErrorMessage;
    SummaryOption mOption;
    SpenWNote mOriginalNote;
    SpenObjectTextBox mOriginalResultTextbox;
    ArrayList<SpenTextSpanBase> mOriginalTextSpanList;
    AiMenuContract.ResultListener mResultListener;
    SpenWNote mResultNote;
    SpenWNote mResultNoteOriginal;
    private String mResultText;
    private int mSelectionMaxLength;
    SrcContentInfo mSrcContentInfo;
    private SubTranslation mSubTranslation;
    Summarizer mSummarizer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorType {
        MINIMUM(C9086R.plurals.ai_error_cant_summarize_text_with_fewer_than_pd_characters),
        UNSUPPORTED_LANGUAGE(C9086R.string.ai_error_msg_safety_filter_unsupported_language_summarize);

        final int mMsgRes;

        ErrorType(int i) {
            this.mMsgRes = i;
        }

        public String getMsg(Context context) {
            return equals(MINIMUM) ? context.getResources().getQuantityString(this.mMsgRes, 200, 200) : context.getResources().getString(this.mMsgRes);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnDeviceSummarizeCallback extends SummarizeCallback {
        public OnDeviceSummarizeCallback() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallback
        public String getErrorMessageInternal(String str) {
            return Summarization.this.getErrorMessageOnDevice(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallback, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            AbstractC8014b.m7196B("OnDeviceSummarizeCallback#onFailed# ", str, Summarization.TAG);
            if (Summarization.this.hasNext()) {
                super.onSuccess("", true);
            } else {
                super.onFailed(str);
                Summarization.this.unload();
            }
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallback, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            AbstractC8014b.m7220v("OnDeviceSummarizeCallback#onSuccess# ", Summarization.TAG, z);
            if (!Summarization.this.hasNext()) {
                Summarization.this.unload();
            }
            super.onSuccess(str, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnDeviceSummarizeCallbackNext extends SummarizeCallbackNext {
        public OnDeviceSummarizeCallbackNext() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$0() {
            if (Summarization.this.hasNext()) {
                updateState();
                return;
            }
            AiMenuContract.ResultListener resultListener = Summarization.this.mResultListener;
            if (resultListener != null) {
                resultListener.onNextCompleted(true);
            }
            Summarization.this.unload();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallback
        public String getErrorMessageInternal(String str) {
            return Summarization.this.getErrorMessageOnDevice(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallback, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            AbstractC8014b.m7196B("OnDeviceSummarizeCallbackNext#onFailed# ", str, Summarization.TAG);
            if (!Summarization.this.hasNext() && Summarization.this.mResultNote.getBodyText().getText().isEmpty()) {
                return super.onFailed(str);
            }
            Summarization summarization = Summarization.this;
            if (summarization.mSummarizer == null) {
                Logger.m10999d(Summarization.TAG, "onFailed# is canceled");
                return true;
            }
            summarization.mSummarizer = null;
            summarization.mLastErrorMessage = null;
            summarization.mHandler.post(new RunnableC9463h(this, 3));
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallbackNext, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallback, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            AbstractC8014b.m7220v("OnDeviceSummarizeCallbackNext#onSuccess# ", Summarization.TAG, z);
            if (!Summarization.this.hasNext()) {
                Summarization.this.unload();
            }
            super.onSuccess(str, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SummarizeCallback implements Operator.Callback {
        public SummarizeCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$1(String str) {
            AiMenuContract.ResultListener resultListener = Summarization.this.mResultListener;
            if (resultListener != null) {
                resultListener.onFailed(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(boolean z) {
            AiMenuContract.ResultListener resultListener = Summarization.this.mResultListener;
            if (resultListener != null) {
                resultListener.onCompleted(z);
            }
        }

        public String getErrorMessageInternal(String str) {
            return Summarization.this.getErrorMessage(str);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            Summarization summarization = Summarization.this;
            if (summarization.mSummarizer == null) {
                Logger.m10999d(Summarization.TAG, "onFailed# is canceled");
                return true;
            }
            summarization.mSummarizer = null;
            String errorMessageInternal = getErrorMessageInternal(str);
            Summarization summarization2 = Summarization.this;
            summarization2.mLastErrorMessage = errorMessageInternal;
            if (summarization2.mResultListener != null) {
                summarization2.mHandler.post(new RunnableC9456a(3, this, errorMessageInternal));
            }
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
        public void onRetry(Runnable runnable) {
            AiCommonUtil.executeRetryAction(runnable);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            AbstractC8014b.m7220v("SummarizeCallback#onCompleted# ", Summarization.TAG, z);
            Summarization summarization = Summarization.this;
            if (summarization.mSummarizer == null) {
                Logger.m10999d(Summarization.TAG, "onSuccess# is canceled");
                return;
            }
            summarization.mSummarizer = null;
            summarization.makeResultNote(str);
            Summarization summarization2 = Summarization.this;
            if (summarization2.mResultListener != null) {
                summarization2.mHandler.post(new RunnableC9458c(1, this, z));
            }
            updateState();
        }

        public void updateState() {
            SrcContentInfo srcContentInfo = Summarization.this.mSrcContentInfo;
            srcContentInfo.setCompletedIndex(srcContentInfo.getCompletedIndex() + 1);
            Activity activity = Summarization.this.mComposerViewPresenter.getActivity();
            Summarization summarization = Summarization.this;
            AiViewUtils.updateOriginalTextColor(activity, summarization.mSrcContentInfo, summarization.mOriginalNote, summarization.mOriginalTextSpanList);
            Summarization summarization2 = Summarization.this;
            if (summarization2.mResultNote != null && summarization2.mIsAutoProcessing && summarization2.mSrcContentInfo.hasNextInputUnit()) {
                Summarization summarization3 = Summarization.this;
                summarization3.summarize(summarization3.mSrcContentInfo.getNextResolvedInput(), SummaryStyle.valueOf(Summarization.this.mOption.getSCSOptionStr()), false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SummarizeCallbackNext extends SummarizeCallback {
        public SummarizeCallbackNext() {
            super();
        }

        private void appendResult(String str) {
            SpenObjectTextBox spenObjectTextBoxMakeSummaryTextBox = Summarization.this.makeSummaryTextBox(str);
            SpenObjectTextBox bodyText = Summarization.this.mResultNote.getBodyText();
            if (bodyText != null) {
                String text = bodyText.getText();
                bodyText.insertText(MarkdownDocument.NEW_LINE, text.length());
                new TextStyleHelper(bodyText).removeTask(new int[]{text.length() + 1, text.length() + 2});
                Summarization.this.mResultNote.getBodyText().insertText(bodyText.getText().length(), spenObjectTextBoxMakeSummaryTextBox, 0, spenObjectTextBoxMakeSummaryTextBox.getText().length());
                Summarization summarization = Summarization.this;
                if (summarization.mResultNoteOriginal == null) {
                    summarization.mResultNoteOriginal = summarization.makeInitialNote();
                }
                SpenWNote spenWNote = Summarization.this.mResultNoteOriginal;
                if (spenWNote != null) {
                    spenWNote.getBodyText().copy(Summarization.this.mResultNote.getBodyText());
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Summarization.SummarizeCallback, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            AbstractC8014b.m7220v("SummarizeCallbackNext#onCompleted# ", Summarization.TAG, z);
            Summarization summarization = Summarization.this;
            if (summarization.mSummarizer == null) {
                Logger.m10999d(Summarization.TAG, "onSuccess# is canceled");
                return;
            }
            summarization.mSummarizer = null;
            appendResult(str);
            AiMenuContract.ResultListener resultListener = Summarization.this.mResultListener;
            if (resultListener != null) {
                resultListener.onNextCompleted(!r3.hasNext());
            }
            updateState();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SummaryOption {
        STANDARD(SummaryStyle.SHORT.name(), C9086R.string.ai_summrize_option_dialog_standard),
        DETAIL(SummaryStyle.LONG.name(), C9086R.string.ai_summrize_option_dialog_detail);

        final String mSCSOptionStr;
        final int mStrRes;

        SummaryOption(String str, @StringRes int i) {
            this.mSCSOptionStr = str;
            this.mStrRes = i;
        }

        public String getSCSOptionStr() {
            return this.mSCSOptionStr;
        }

        public int getStrRes() {
            return this.mStrRes;
        }
    }

    static {
        MAX_LENGTH = CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? 1400 : 4000;
    }

    public Summarization(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        SummaryOption summaryOption = SummaryOption.STANDARD;
        this.mBeforeOption = summaryOption;
        this.mOption = summaryOption;
        this.mLastErrorMessage = null;
        this.mIsStreamingMode = false;
        this.mIsAutoProcessing = true;
        this.mErrorType = null;
        this.mIdentifiedLanguage = null;
        this.mIsRestore = false;
        this.mSelectionMaxLength = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mSrcContentInfo = srcContentInfo;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mLanguageIdentifier = new LanguageIdentifier();
        divideInput();
    }

    private void addLastLineFeed(SpenObjectTextBox spenObjectTextBox) {
        String text = spenObjectTextBox.getText();
        if (TextUtils.isEmpty(text) || AbstractC0000a.m4a(1, text) == '\n') {
            return;
        }
        spenObjectTextBox.insertText("\n", text.length(), false);
    }

    public static boolean checkLimitationAndSplit(Context context, SrcContentInfo srcContentInfo, LanguageIdentifier languageIdentifier) {
        String selectedText = srcContentInfo.getSelectedText();
        int i = AiMaxLength.LEN_SELECTED_MAX;
        if (selectedText.length() <= i) {
            return true;
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_FOR_SUMMARIZE, ComposerSA.getDetailAiSelectedTextMaxLength(selectedText.length(), 5000, 1000, 5));
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_reselect_maximum_characters));
        if (srcContentInfo.mSrcType == 1) {
            srcContentInfo.mEndPos = srcContentInfo.mStartPos + i;
        }
        srcContentInfo.setSelectedText(TextUtil.subString(srcContentInfo.getSelectedText(), 0, i, true));
        return false;
    }

    public static int checkMaxLimitation(Context context, String str, LanguageIdentifier languageIdentifier) {
        int i = AiMaxLength.LEN_SELECTED_MAX;
        if (str.length() <= i) {
            return 0;
        }
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_cant_summarize_text_with_more_than));
        return i;
    }

    private void divideInput() {
        boolean zIsSummaryOnDeviceMode = FeatureInfo.isSummaryOnDeviceMode();
        this.mSrcContentInfo.chunk(ChunkSizePolicy.builder().unitMinLength(200).unitMaxLength(zIsSummaryOnDeviceMode ? getMaxLengthOnDevice() : getMaxLength(this.mSrcContentInfo.getSelectedText(), this.mLanguageIdentifier)).extraLength(zIsSummaryOnDeviceMode ? 100 : 500).splitLastIfExceedsMax(zIsSummaryOnDeviceMode).build());
    }

    private void executeSummary(boolean z) {
        this.mSummarizer.execute();
        if (z) {
            return;
        }
        this.mResultListener.onProgressing();
    }

    private void executeSummaryOnDevice(boolean z) {
        String identifiedLanguage = getIdentifiedLanguage();
        if (SummarizationOnDevice.supportSummaryOnDevice(identifiedLanguage)) {
            this.mSummarizer.setDetectedLanguage(identifiedLanguage);
            executeSummary(z);
            return;
        }
        this.mLastErrorMessage = getErrorMessageOnDevice("SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE");
        cancel();
        AiMenuContract.ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onFailed(this.mLastErrorMessage);
        }
    }

    public static void executeWithSetting(Activity activity, Runnable runnable) {
        AiCommonUtil.executeSummaryAction(activity, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorMessageOnDevice(String str) {
        return str.equals("SAFE_FILTER_ERROR_CHILD") ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_child_summarize) : str.equals("SAFE_FILTER_ERROR_RECITATION") ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_recitation_summarize) : str.equals("SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE") ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_unsupported_language_summarize) : str.equals("SAFE_FILTER_ERROR_CHN_SENSITIVE") ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_chn_sensitive_summarize) : str.equals("SAFE_FILTER_ERROR") ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_ai_error_msg_safety_filter_in_other_cases_summarize) : str.equals("SERVICE_IS_BUSY") ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_on_device_service_is_busy) : this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_something_went_wrong);
    }

    private String getIdentifiedLanguage() {
        if (this.mIdentifiedLanguage == null) {
            this.mIdentifiedLanguage = this.mLanguageIdentifier.identifyLanguageSync(AiMaxLength.getIdentifyTargetStr(this.mSrcContentInfo.getSelectedText())).getLanguage();
        }
        return this.mIdentifiedLanguage;
    }

    private int getMaxLengthOnDevice() {
        return AiMaxLength.getSummaryOnDeviceMax(getIdentifiedLanguage());
    }

    public static boolean isLimitedMinLength(Context context, @NonNull String str, boolean z) {
        if (str.trim().length() >= 200) {
            return false;
        }
        if (!z) {
            return true;
        }
        AiCommonUtil.showCustomToast(context, ErrorType.MINIMUM.getMsg(context));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showOptionDialog$0(Runnable runnable, int i) {
        if (i == this.mOption.ordinal()) {
            return;
        }
        this.mBeforeOption = this.mOption;
        SummaryOption summaryOption = SummaryOption.DETAIL;
        if (summaryOption.ordinal() == i) {
            this.mOption = summaryOption;
        } else {
            this.mOption = SummaryOption.STANDARD;
        }
        this.mSrcContentInfo.setInputIndex(0);
        this.mSrcContentInfo.setCompletedIndex(-1);
        this.mIsRestore = false;
        this.mOriginalResultTextbox = null;
        execute();
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpenWNote makeInitialNote() {
        SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getDoc());
        if (spenWNoteMakeNote != null) {
            return spenWNoteMakeNote;
        }
        Logger.m11000e(TAG, "makeNote# mResultNote is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpenObjectTextBox makeSummaryTextBox(String str) {
        SpenObjectTextBox newBodyText = this.mComposerViewPresenter.getObjectManager().getNewBodyText();
        newBodyText.setTextAlignment(Alignment.getDefaultAlign());
        newBodyText.setFontSize(14);
        TextStyleHelper textStyleHelper = new TextStyleHelper(newBodyText);
        for (String str2 : splitSentence(str)) {
            int length = str2.length();
            int iCharCount = 0;
            while (true) {
                if (iCharCount < length) {
                    int iCodePointAt = str2.codePointAt(iCharCount);
                    if (Character.isWhitespace(iCodePointAt)) {
                        iCharCount += Character.charCount(iCodePointAt);
                    } else if (!str2.equals("\u200b")) {
                        applyFormat(str2, textStyleHelper, 14);
                    }
                }
            }
        }
        removeLinefeed(newBodyText);
        return newBodyText;
    }

    private void removeLinefeed(SpenObjectTextBox spenObjectTextBox) {
        String text = spenObjectTextBox.getText();
        if (text.length() > 2) {
            int length = text.length() - 2;
            int i = 0;
            for (int length2 = text.length() - 1; length2 >= length; length2--) {
                if (text.charAt(length2) == '\n') {
                    i++;
                }
            }
            if (i > 0) {
                spenObjectTextBox.removeText(spenObjectTextBox.getText().length() - i, i);
            }
        }
    }

    private void setDefApplyFontSizeAll(SpenObjectTextBox spenObjectTextBox) {
        SpenWNote doc = this.mSrcContentInfo.mSrcNote;
        if (doc == null) {
            doc = this.mComposerViewPresenter.getDoc();
        }
        AiViewUtils.setDefApplyFontSizeAll(doc.getBodyText(), spenObjectTextBox, this.mSrcContentInfo);
    }

    public static String[] splitSentence(String str) {
        String[] strArrSplit = str.split("\n");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (!TextUtils.isEmpty(strTrim)) {
                arrayList.add(strTrim);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unload() {
        Logger.m10999d(TAG, "unloadModel");
        Summarizer summarizer = this.mSummarizer;
        if (summarizer != null) {
            summarizer.unloadModel();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox bodyText = this.mResultNoteOriginal.getBodyText();
        addLastLineFeed(bodyText);
        setDefApplyFontSizeAll(bodyText);
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
                resultOperation.insertToBottom(this.mComposerViewPresenter, this.mSrcContentInfo, bodyText);
                return;
            } else {
                resultOperation.insertNewPageEndOfNote(this.mComposerViewPresenter, this.mSrcContentInfo, bodyText);
                return;
            }
        }
        if (ResultOperation.AddTo.NewPageBefore == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, this.mSrcContentInfo, bodyText);
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            resultOperation.addToNewNote(this.mComposerViewPresenter, bodyText);
        }
    }

    public void applyFormat(String str, TextStyleHelper textStyleHelper, int i) {
        SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
        int length = objectTextBox.getText().length();
        int[] iArr = {length, str.length() + length};
        objectTextBox.insertText(str.concat(MarkdownDocument.NEW_LINE), length);
        textStyleHelper.setFontSize(i, iArr);
        textStyleHelper.setTask(iArr);
        int i2 = iArr[1];
        textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        SpenObjectTextBox bodyText;
        SpenWNote spenWNote = this.mResultNote;
        return (spenWNote == null || (bodyText = spenWNote.getBodyText()) == null || bodyText.getText().length() <= 0) ? false : true;
    }

    public ErrorType canExecute() {
        if (isLimitedMinLength(null, this.mSrcContentInfo.getSelectedText(), false)) {
            return ErrorType.MINIMUM;
        }
        return null;
    }

    public void cancel() {
        if (this.mSummarizer != null) {
            unload();
            this.mSummarizer.registerCallback(null);
            this.mSummarizer = null;
            this.mOption = this.mBeforeOption;
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void clear() {
        cancel();
        setResultListener(null);
        LanguageIdentifier languageIdentifier = this.mLanguageIdentifier;
        if (languageIdentifier != null) {
            languageIdentifier.release();
        }
        SpenWNote spenWNote = this.mOriginalNote;
        if (spenWNote != null && !spenWNote.isClosed()) {
            try {
                this.mOriginalNote.close(true);
            } catch (IOException e) {
                Logger.m11000e(TAG, "clear# " + e);
            }
        }
        this.mOriginalNote = null;
        SpenWNote spenWNote2 = this.mResultNote;
        if (spenWNote2 != null && !spenWNote2.isClosed()) {
            try {
                this.mResultNote.close(true);
            } catch (IOException e2) {
                Logger.m11000e(TAG, "clear# " + e2);
            }
        }
        this.mResultNote = null;
        ListenerImplContract.IDialogPresenter dialogPresenterManager = this.mComposerViewPresenter.getDialogPresenterManager();
        if (dialogPresenterManager instanceof DialogPresenterManager) {
            ((DialogPresenterManager) dialogPresenterManager).hideSummaryOptionDialog();
        }
    }

    public void clearResultText() {
        Logger.m10999d(TAG, "clearResultText#");
        SpenWNote spenWNote = this.mResultNote;
        if (spenWNote == null || spenWNote.isClosed()) {
            return;
        }
        this.mResultNote.getBodyText().setText(" ");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        new ResultOperation().copy(this.mComposerViewPresenter, getResultToCopy());
    }

    public void execute() {
        if (this.mSrcContentInfo.hasDirty()) {
            divideInput();
            this.mSrcContentInfo.setDirty(false);
        }
        this.mSrcContentInfo.resetInputIndex();
        summarize(this.mSrcContentInfo.getNextResolvedInput(), SummaryStyle.valueOf(this.mOption.getSCSOptionStr()), true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "c";
    }

    public String getErrorMessage(String str) {
        return str.isEmpty() ? "unexpected error" : "SAFE_FILTER_ERROR_CHILD".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_child_summarize) : "SAFE_FILTER_ERROR_RECITATION".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_recitation_summarize) : "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_unsupported_language_summarize) : "SAFE_FILTER_ERROR_CHN_SENSITIVE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_chn_sensitive_summarize) : "SAFE_FILTER_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_ai_error_msg_safety_filter_in_other_cases_summarize) : "NETWORK_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_network_connection_error_msg) : ("INTERNAL_SERVER_ERROR".equals(str) || "UNEXPECTED_ERROR".equals(str)) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_something_went_wrong) : "SERVICE_IS_BUSY".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_on_device_service_is_busy) : "INPUT_TOO_LONG".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_something_went_wrong) : str;
    }

    public ErrorType getErrorType() {
        return this.mErrorType;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public String getLastErrorMessage() {
        return this.mLastErrorMessage;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.SubTransition.IParentAction
    public int getMaxLength() {
        return getSelectionMaxLength();
    }

    public SummaryOption getOption() {
        return this.mOption;
    }

    public SpenWNote getOriginalNote() {
        return this.mOriginalNote;
    }

    public SpenObjectTextBox getOriginalResultTextbox() {
        return this.mOriginalResultTextbox;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.SubTransition.IParentAction
    public SpenWNote getResultNote() {
        return this.mResultNote;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.SubTransition.IParentAction
    public String getResultText() {
        return this.mResultText;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(this.mResultNoteOriginal.getBodyText());
        addLastLineFeed(newSpenObjectTextBox);
        setDefApplyFontSizeAll(newSpenObjectTextBox);
        return newSpenObjectTextBox;
    }

    public int getSelectionMaxLength() {
        return this.mSelectionMaxLength;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return this.mSrcContentInfo;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.SubTransition.IParentAction
    public SubTranslation getSubTranslation() {
        if (this.mSubTranslation == null) {
            this.mSubTranslation = new SubTranslation(this.mSrcContentInfo, this.mComposerViewPresenter);
        }
        return this.mSubTranslation;
    }

    public boolean hasNext() {
        return this.mSrcContentInfo.hasNextInputUnit();
    }

    public boolean hasResult() {
        SpenWNote spenWNote = this.mResultNote;
        return (spenWNote == null || spenWNote.getBodyText() == null || TextUtils.isEmpty(this.mResultNote.getBodyText().getText())) ? false : true;
    }

    public boolean isRestore() {
        return this.mIsRestore;
    }

    public boolean isShowingSubTranslation() {
        if (this.mSubTranslation == null || this.mSrcContentInfo.getSubResultText() == null) {
            return false;
        }
        return this.mSubTranslation.isShowing();
    }

    public boolean isStandardTypeWithCurrentOption() {
        return this.mOption == SummaryOption.STANDARD;
    }

    public boolean isWorking() {
        return this.mSummarizer != null;
    }

    public void makeOriginNote() {
        if (this.mOriginalNote != null) {
            Logger.m10999d(TAG, "makeOriginNote# already created");
            return;
        }
        SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getDoc());
        this.mOriginalNote = spenWNoteMakeNote;
        if (spenWNoteMakeNote == null) {
            Logger.m11000e(TAG, "makeOriginNote# mOriginalNote is null");
            return;
        }
        if (this.mSrcContentInfo.getSrcType() == 0) {
            this.mOriginalNote.getBodyText().insertText(this.mSrcContentInfo.getSelectedText(), 0);
        } else {
            this.mOriginalNote.getBodyText().copyText(this.mComposerViewPresenter.getDoc().getBodyText(), this.mSrcContentInfo.mStartPos, Math.min(this.mSrcContentInfo.mEndPos - 1, r0.getText().length() - 1));
        }
        SpenObjectTextBox bodyText = this.mOriginalNote.getBodyText();
        AiViewUtils.setResultTextBoxState(bodyText);
        this.mOriginalNote.getBodyText().setFontSize(14.0f);
        this.mOriginalTextSpanList = bodyText.getTextSpan();
    }

    public SpenWNote makeResultNote(String str) {
        SpenWNote spenWNote = this.mResultNote;
        if (spenWNote == null) {
            SpenWNote spenWNoteMakeInitialNote = makeInitialNote();
            this.mResultNote = spenWNoteMakeInitialNote;
            if (spenWNoteMakeInitialNote == null) {
                return null;
            }
        } else {
            spenWNote.getBodyText().removeAllText();
        }
        SpenObjectTextBox spenObjectTextBoxMakeSummaryTextBox = makeSummaryTextBox(str);
        SpenObjectTextBox bodyText = this.mResultNote.getBodyText();
        String text = bodyText.getText();
        this.mResultNote.getBodyText().insertText(text != null ? text.length() : 0, spenObjectTextBoxMakeSummaryTextBox, 0, spenObjectTextBoxMakeSummaryTextBox.getText().length());
        if (!this.mIsStreamingMode) {
            bodyText.setCursorPosition(0);
        }
        AiViewUtils.setResultTextBoxState(this.mResultNote.getBodyText());
        SpenWNote spenWNoteMakeInitialNote2 = makeInitialNote();
        this.mResultNoteOriginal = spenWNoteMakeInitialNote2;
        spenWNoteMakeInitialNote2.getBodyText().copy(this.mResultNote.getBodyText());
        return this.mResultNote;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (!TextUtils.isEmpty(this.mLastErrorMessage)) {
            Logger.m11000e(TAG, "onSaveInstanceState# failed state");
            return;
        }
        if (this.mOriginalNote != null) {
            SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
            this.mBackupOrigin = newSpenObjectTextBox;
            newSpenObjectTextBox.copy(this.mOriginalNote.getBodyText());
        }
        boolean zHasResult = hasResult();
        if (zHasResult) {
            Logger.m10999d(TAG, "onSaveInstanceState# completed");
            SpenObjectTextBox newSpenObjectTextBox2 = ObjectTextFactory.getNewSpenObjectTextBox();
            this.mBackupResult = newSpenObjectTextBox2;
            newSpenObjectTextBox2.copy(this.mResultNote.getBodyText());
        }
        bundle.putBoolean(TAG, zHasResult);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
        this.mSrcContentInfo.setConvertibleColor(true);
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox bodyText = this.mResultNoteOriginal.getBodyText();
        addLastLineFeed(bodyText);
        setDefApplyFontSizeAll(bodyText);
        resultOperation.setShouldRemoveTableOnOverwrite(true);
        resultOperation.overwrite(this.mComposerViewPresenter, bodyText, this.mSrcContentInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        String str = TAG;
        if (!bundle.containsKey(str)) {
            Logger.m10999d(str, "restoreState# no data");
            return;
        }
        Logger.m10999d(str, "restore#");
        this.mIsRestore = true;
        this.mSrcContentInfo = srcContentInfo;
        if (this.mBackupOrigin != null) {
            SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getDoc());
            this.mOriginalNote = spenWNoteMakeNote;
            if (spenWNoteMakeNote != null) {
                AiViewUtils.applyDefViewerSpFontSizeAll(this.mComposerViewPresenter.getActivity(), this.mBackupOrigin);
                this.mOriginalNote.getBodyText().copy(this.mBackupOrigin);
                this.mOriginalNote.getBodyText().setFontSize(14.0f);
            }
            this.mBackupOrigin = null;
        }
        if (!bundle.getBoolean(str)) {
            if (this.mErrorType == null) {
                execute();
                return;
            }
            return;
        }
        SpenWNote spenWNoteMakeInitialNote = makeInitialNote();
        this.mResultNote = spenWNoteMakeInitialNote;
        if (spenWNoteMakeInitialNote != null) {
            AiViewUtils.applyDefViewerSpFontSizeAll(this.mComposerViewPresenter.getActivity(), this.mBackupResult);
            this.mResultNote.getBodyText().copy(this.mBackupResult);
            this.mResultNote.getBodyText().setFontSize(14.0f);
        }
        this.mBackupResult = null;
    }

    public void setErrorType(ErrorType errorType) {
        Logger.m10999d(TAG, "setErrorType# " + errorType);
        this.mErrorType = errorType;
    }

    public void setOriginalResultTextbox(SpenWNote spenWNote) {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        this.mOriginalResultTextbox = newSpenObjectTextBox;
        newSpenObjectTextBox.copy(spenWNote.getBodyText());
    }

    public void setResultListener(AiMenuContract.ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public void setResultText(String str) {
        this.mResultText = str;
    }

    public void setSelectionMaxLength(int i) {
        this.mSelectionMaxLength = i;
    }

    public void showOptionDialog(Runnable runnable, View view) {
        if (this.mComposerViewPresenter.getDialogPresenterManager() instanceof DialogPresenterManager) {
            ((DialogPresenterManager) this.mComposerViewPresenter.getDialogPresenterManager()).showSummaryOptionDialog(this.mOption.ordinal(), new C9459d(this, runnable, 2), false, view);
        }
    }

    public void summarize(String str, SummaryStyle summaryStyle, boolean z) {
        Logger.m10999d(TAG, "summarize# " + summaryStyle.name());
        String strRemoveObjectReplacementChar = UnicodeUtils.removeObjectReplacementChar(str);
        boolean zIsSummaryOnDeviceMode = FeatureInfo.isSummaryOnDeviceMode();
        this.mLastErrorMessage = null;
        Summarizer summarizerOnDevice = zIsSummaryOnDeviceMode ? new SummarizerOnDevice(strRemoveObjectReplacementChar, summaryStyle, SummarizerOnDevice.SummaryType.NOTES) : new Summarizer(strRemoveObjectReplacementChar, summaryStyle);
        this.mSummarizer = summarizerOnDevice;
        if (z) {
            summarizerOnDevice.registerCallback(zIsSummaryOnDeviceMode ? new OnDeviceSummarizeCallback() : new SummarizeCallback());
        } else {
            summarizerOnDevice.registerCallback(zIsSummaryOnDeviceMode ? new OnDeviceSummarizeCallbackNext() : new SummarizeCallbackNext());
        }
        if (!zIsSummaryOnDeviceMode) {
            executeSummary(z);
        } else {
            this.mSummarizer.setContinuousListSize(this.mSrcContentInfo.getInputList().size());
            executeSummaryOnDevice(z);
        }
    }

    public static int getMaxLength(String str, LanguageIdentifier languageIdentifier) {
        int length = str.length();
        int i = MAX_LENGTH;
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature() || length <= i || languageIdentifier == null) {
            return i;
        }
        Locale localeIdentifyLanguageSync = languageIdentifier.identifyLanguageSync(AiMaxLength.getIdentifyTargetStr(str));
        int summaryMax = AiMaxLength.getSummaryMax(localeIdentifyLanguageSync);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("getMaxLength# locale:");
        sb.append(localeIdentifyLanguageSync);
        sb.append(" maxLength = ");
        sb.append(summaryMax);
        sb.append(" / ");
        AbstractC8014b.m7195A(sb, str2, length);
        return summaryMax;
    }
}
