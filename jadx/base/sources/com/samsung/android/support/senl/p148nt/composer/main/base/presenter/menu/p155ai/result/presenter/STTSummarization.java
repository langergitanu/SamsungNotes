package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.SummarizeSubTask;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextFontSize;
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
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.ParagraphSttTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.SummaryMultipleResultParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.SummaryResultParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.ThreadPoolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTTSummarizationItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerSpenWNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.STTSummarizer;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class STTSummarization implements AiMenuContract.IAiAction {
    public static final int FULL_SUMMARY_MINIMUM_STRING_LENGTH = 200;
    public static final int INVALID_SPEAKER_ID = -1;
    public static final int MAX_LENGTH;
    public static final int MIN_LENGTH = 200;
    public static final int SUMMARY_MINIMUM_STRING_LENGTH = 20;
    public static final long SUMMARY_REQUEST_SLEEP_TIME;
    private static final String TAG = Logger.createTag("STTSummarization", AiConstants.PREFIX_TAG);
    protected ISTTWindow.IAIContract mAiSTTContract;
    private SpenObjectTextBox mBackupTextBox;
    SummaryOption mBeforeOption;
    ComposerViewPresenter mComposerViewPresenter;
    protected int mExecutePosition;
    Handler mHandler;
    boolean mIsStreamingMode;
    boolean mIsSummarizeAgain;
    boolean mIsSummaryStyleChanged;
    String mLastErrorMessage;
    SummaryOption mOption;
    private final int mParagraphStringMaxLength;
    AiMenuContract.ResultListener mResultListener;
    SpenWNote mResultNote;
    private STTSummarizeTranslation mSTTSummarizeTranslation;
    private TreeMap<Integer, Boolean> mSelectedMap;
    private ArrayList<ArrayList<TextData>> mSttParagraphList;
    Summarizer mSummarizer;
    protected List<AiMenuResultViewSTTSummarizationItem> mSummaryResultItemList;
    protected AtomicInteger mSummaryRequestCount = new AtomicInteger(0);
    protected AtomicInteger mSummaryFailedCount = new AtomicInteger(0);

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarization$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C94363 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$presenter$menu$ai$result$presenter$STTSummarization$SummaryOption */
        static final /* synthetic */ int[] f6862xc2a6ad1a;

        static {
            int[] iArr = new int[SummaryOption.values().length];
            f6862xc2a6ad1a = iArr;
            try {
                iArr[SummaryOption.SHOW_AS_TIMELINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6862xc2a6ad1a[SummaryOption.GROUP_BY_SUBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SummarizeCallback implements Operator.Callback {
        private final int mIndex;

        public SummarizeCallback(int i) {
            this.mIndex = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$1(String str) {
            STTSummarization.this.mResultListener.onFailed(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$2(boolean z) {
            STTSummarization.this.mAiSTTContract.getSTTPresenter().onVoiceDataListChange(STTSummarization.this.mExecutePosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(boolean z) {
            STTSummarization.this.mAiSTTContract.getSTTPresenter().onVoiceDataListChange(STTSummarization.this.mExecutePosition);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            int iDecrementAndGet = STTSummarization.this.mSummaryRequestCount.decrementAndGet();
            Logger.m11000e(STTSummarization.TAG, "SummarizeCallback#onFailed# index: " + this.mIndex + " mSummaryFailedCount : " + STTSummarization.this.mSummaryFailedCount.get() + " pending : " + iDecrementAndGet + " : " + str);
            STTSummarization.this.hideSummaryResultItem(this.mIndex);
            if (STTSummarization.this.mSummaryFailedCount.incrementAndGet() == STTSummarization.this.mSummaryResultItemList.size()) {
                Logger.m10999d(STTSummarization.TAG, "SummarizeCallback#onFailed completed, all items have failed");
                STTSummarization sTTSummarization = STTSummarization.this;
                sTTSummarization.mSummarizer = null;
                sTTSummarization.mSummaryRequestCount.set(0);
                String errorMessage = STTSummarization.this.getErrorMessage(str);
                STTSummarization sTTSummarization2 = STTSummarization.this;
                sTTSummarization2.mLastErrorMessage = errorMessage;
                if (sTTSummarization2.mResultListener != null) {
                    sTTSummarization2.mHandler.post(new RunnableC9456a(1, this, errorMessage));
                    return true;
                }
            } else {
                if (iDecrementAndGet == 0) {
                    Logger.m10999d(STTSummarization.TAG, "SummarizeCallback#onFailed completed");
                    STTSummarization sTTSummarization3 = STTSummarization.this;
                    sTTSummarization3.mSummarizer = null;
                    sTTSummarization3.removeHiddenItem();
                    AiMenuContract.ResultListener resultListener = STTSummarization.this.mResultListener;
                    if (resultListener != null) {
                        resultListener.onCompleted(true);
                    }
                    STTSummarization.this.writeSummaryResult(new C9465j(this, 0));
                    return true;
                }
                Logger.m10999d(STTSummarization.TAG, "SummarizeCallback#onFailed update view for hiddenItem");
                AiMenuContract.ResultListener resultListener2 = STTSummarization.this.mResultListener;
                if (resultListener2 != null) {
                    resultListener2.onCompleted(false);
                }
            }
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
        public void onRetry(Runnable runnable) {
            AiCommonUtil.executeRetryAction(runnable);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            boolean z2;
            Logger.m10999d(STTSummarization.TAG, "SummarizeCallback#onCompleted# index: " + this.mIndex + " pending: " + STTSummarization.this.mSummaryRequestCount.get() + " isCompleted " + z);
            STTSummarization sTTSummarization = STTSummarization.this;
            if (sTTSummarization.mOption == SummaryOption.GROUP_BY_SUBJECT) {
                sTTSummarization.updateSummaryMultipleResultItem(this.mIndex, str);
            } else {
                sTTSummarization.updateSummaryResultItem(this.mIndex, str);
            }
            if (STTSummarization.this.mSummaryRequestCount.decrementAndGet() == 0) {
                STTSummarization sTTSummarization2 = STTSummarization.this;
                sTTSummarization2.mSummarizer = null;
                sTTSummarization2.removeHiddenItem();
                z2 = true;
            } else {
                z2 = false;
            }
            AiMenuContract.ResultListener resultListener = STTSummarization.this.mResultListener;
            if (resultListener != null) {
                resultListener.onCompleted(z2);
            }
            if (z2) {
                STTSummarization.this.writeSummaryResult(new C9465j(this, 1));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SummaryOption {
        SHOW_AS_TIMELINE(SummaryStyle.SHORT.name()),
        GROUP_BY_SUBJECT(SummaryStyle.LONG.name());

        final String mSCSOptionStr;

        SummaryOption(String str) {
            this.mSCSOptionStr = str;
        }

        public static SummaryOption fromValue(int i) {
            for (SummaryOption summaryOption : values()) {
                if (summaryOption.ordinal() == i) {
                    return summaryOption;
                }
            }
            throw new IllegalArgumentException("#SummaryOption invalid value");
        }

        public String getSCSOptionStr() {
            return this.mSCSOptionStr;
        }
    }

    static {
        CscFeature.Companion companion = CscFeature.INSTANCE;
        MAX_LENGTH = companion.getInstance().isChinaAiFeature() ? 1400 : 5000;
        SUMMARY_REQUEST_SLEEP_TIME = companion.getInstance().isChinaAiFeature() ? 1500L : 20L;
    }

    public STTSummarization(ISTTWindow.IAIContract iAIContract, ComposerViewPresenter composerViewPresenter) {
        SummaryOption summaryOption = SummaryOption.SHOW_AS_TIMELINE;
        this.mBeforeOption = summaryOption;
        this.mOption = summaryOption;
        this.mLastErrorMessage = null;
        this.mIsStreamingMode = false;
        this.mIsSummarizeAgain = false;
        this.mIsSummaryStyleChanged = false;
        this.mExecutePosition = -1;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mAiSTTContract = iAIContract;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSummaryResultItemList = new ArrayList();
        this.mSttParagraphList = new ArrayList<>();
        this.mSTTSummarizeTranslation = new STTSummarizeTranslation(composerViewPresenter);
        this.mParagraphStringMaxLength = CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? 3000 : SCSTools.getRequestType() == AppInfo.RequestType.CLOUD ? 1000 : 900;
    }

    private void addLastLineFeed(SpenObjectTextBox spenObjectTextBox) {
        String text = spenObjectTextBox.getText();
        if (TextUtils.isEmpty(text) || AbstractC0000a.m4a(1, text) == '\n') {
            return;
        }
        spenObjectTextBox.insertText("\n", text.length(), false);
    }

    private void addSummaryItemToTextBox(AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem, TextStyleHelper textStyleHelper, int i) {
        String translatedTitle;
        applyTitleFormat(aiMenuResultViewSTTSummarizationItem.getSummaryTitle(), textStyleHelper);
        for (int i2 = 0; i2 < aiMenuResultViewSTTSummarizationItem.getSummaryLines().size(); i2++) {
            applyFormat(aiMenuResultViewSTTSummarizationItem.getSummaryLines().get(i2), textStyleHelper, i);
        }
        if (this.mSTTSummarizeTranslation.isTranslateMode() && (translatedTitle = aiMenuResultViewSTTSummarizationItem.getTranslatedTitle()) != null) {
            applyTitleFormat(translatedTitle, textStyleHelper);
            for (int i4 = 0; i4 < aiMenuResultViewSTTSummarizationItem.getTranslatedLines().size(); i4++) {
                applyFormat(aiMenuResultViewSTTSummarizationItem.getTranslatedLines().get(i4), textStyleHelper, i);
            }
        }
        SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
        objectTextBox.insertText("\n", objectTextBox.getText().length());
    }

    private void applyTitleFormat(String str, TextStyleHelper textStyleHelper) {
        SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
        int length = objectTextBox.getText().length();
        objectTextBox.insertText(str + "\n", length);
        int length2 = objectTextBox.getText().length();
        objectTextBox.appendTextSpan(new SpenBoldSpan(length, length2, 1, true));
        objectTextBox.removeTextSpan(new SpenBoldSpan(length2 + (-1), length2, 1, true));
        textStyleHelper.setAlign(AiViewUtils.hasRtlCharacters(str) ? 1 : 0, new int[]{length, str.length() + length});
    }

    public static int checkMaxLimitation(Context context, String str, LanguageIdentifier languageIdentifier) {
        int length = str.length();
        int summaryMax = MAX_LENGTH;
        if (!CscFeature.INSTANCE.getInstance().isChinaAiFeature() && length > summaryMax && languageIdentifier != null) {
            Locale localeIdentifyLanguageSync = languageIdentifier.identifyLanguageSync(AiMaxLength.getIdentifyTargetStr(str));
            summaryMax = AiMaxLength.getSummaryMax(localeIdentifyLanguageSync);
            String str2 = TAG;
            StringBuilder sb = new StringBuilder("checkLimitation# locale:");
            sb.append(localeIdentifyLanguageSync);
            sb.append(" maxLength = ");
            sb.append(summaryMax);
            sb.append(" / ");
            AbstractC8014b.m7195A(sb, str2, length);
        }
        if (length <= summaryMax) {
            return 0;
        }
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_cant_summarize_text_with_more_than));
        return summaryMax;
    }

    private String getSelectedText() {
        if (this.mSelectedMap == null || this.mSTTSummarizeTranslation == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.mSelectedMap.keySet().iterator();
        while (it.hasNext()) {
            AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = this.mSummaryResultItemList.get(it.next().intValue());
            sb.append(aiMenuResultViewSTTSummarizationItem.getSummaryTitle());
            sb.append("\n");
            Iterator<String> it2 = aiMenuResultViewSTTSummarizationItem.getSummaryLines().iterator();
            while (it2.hasNext()) {
                AbstractC1974b.m1332y(sb, "- ", it2.next(), "\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStringFromTextData(ArrayList<TextData> arrayList) {
        StringBuilder sb = new StringBuilder();
        int speakerId = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            TextData textData = arrayList.get(i);
            if (textData.getText() != null) {
                if (textData.getSpeakerId() != speakerId) {
                    speakerId = textData.getSpeakerId();
                    sb.append("\n");
                }
                sb.append(textData.getText());
            }
        }
        return sb.toString();
    }

    public static boolean isLimitedMinLength(@NonNull String str) {
        return str.trim().length() < 200;
    }

    private static Boolean isSummaryItemEmpty(String str, ArrayList<String> arrayList) {
        if (arrayList == null || str == null || str.trim().isEmpty() || arrayList.isEmpty()) {
            return Boolean.TRUE;
        }
        for (String str2 : arrayList) {
            if (str2 != null && !str2.trim().isEmpty()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSTTSummaryOptionDialog$0(Runnable runnable, int i) {
        if (i == this.mOption.ordinal()) {
            return;
        }
        this.mBeforeOption = this.mOption;
        SummaryOption summaryOption = SummaryOption.GROUP_BY_SUBJECT;
        if (summaryOption.ordinal() == i) {
            this.mOption = summaryOption;
        } else {
            this.mOption = SummaryOption.SHOW_AS_TIMELINE;
        }
        if (this.mOption != this.mBeforeOption) {
            this.mIsSummarizeAgain = true;
            this.mIsSummaryStyleChanged = true;
            SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.SETTINGS_STT_SUMMARY_STYLE, this.mOption.ordinal());
        }
        execute();
        runnable.run();
        ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_SUMMARY, STTConstant.EVENT_SELECT_SUMMARY_STYLE, this.mOption == SummaryOption.SHOW_AS_TIMELINE ? "a" : "b");
    }

    private SpenWNote makeInitialNote() {
        SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getDoc());
        if (spenWNoteMakeNote == null) {
            Logger.m11000e(TAG, "makeNote# mResultNote is null");
            return null;
        }
        spenWNoteMakeNote.setBodyTextFontSizeDelta(0);
        return spenWNoteMakeNote;
    }

    private SpenObjectTextBox makeSummaryTextBox() {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText("");
        newSpenObjectTextBox.setTextAlignment(Alignment.getDefaultAlign());
        int defViewerSpFontSize = AiViewUtils.getDefViewerSpFontSize(this.mComposerViewPresenter.getActivity());
        newSpenObjectTextBox.setFontSize(defViewerSpFontSize);
        TextStyleHelper textStyleHelper = new TextStyleHelper(newSpenObjectTextBox);
        if (!this.mAiSTTContract.isSTTSelectionSummaryMode() || this.mSelectedMap.size() == this.mSummaryResultItemList.size()) {
            for (AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem : this.mSummaryResultItemList) {
                if (!aiMenuResultViewSTTSummarizationItem.isHidden()) {
                    addSummaryItemToTextBox(aiMenuResultViewSTTSummarizationItem, textStyleHelper, defViewerSpFontSize);
                }
            }
        } else {
            Iterator<Integer> it = this.mSelectedMap.keySet().iterator();
            while (it.hasNext()) {
                addSummaryItemToTextBox(this.mSummaryResultItemList.get(it.next().intValue()), textStyleHelper, defViewerSpFontSize);
            }
        }
        removeLinefeed(newSpenObjectTextBox);
        return newSpenObjectTextBox;
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

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        makeResultNote();
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox bodyText = this.mResultNote.getBodyText();
        addLastLineFeed(bodyText);
        int value = new BodyTextFontSize(this.mComposerViewPresenter.getTextManager().getFontSizeDelta()).getValue();
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            ComposerSpenWNoteUtils.changeFontSizeSpan(bodyText, ComposerSpenWNoteUtils.getLastCursorFontSize(this.mComposerViewPresenter.getDoc().getBodyText(), value));
            if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
                resultOperation.insertToBottom(this.mComposerViewPresenter, new SrcContentInfo(""), bodyText);
                return;
            } else {
                resultOperation.insertNewPageEndOfNote(this.mComposerViewPresenter, new SrcContentInfo(""), bodyText);
                return;
            }
        }
        if (ResultOperation.AddTo.NewPageBefore == addTo) {
            ComposerSpenWNoteUtils.changeFontSizeSpan(bodyText, ComposerSpenWNoteUtils.getCursorFontSize(this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager(), new SrcContentInfo("").mSrcPageIndex, this.mComposerViewPresenter.getDoc().getBodyText(), value));
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, new SrcContentInfo(""), bodyText);
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            resultOperation.addToNewNote(this.mComposerViewPresenter, bodyText);
        }
    }

    public void applyFormat(String str, TextStyleHelper textStyleHelper, int i) {
        SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
        int length = objectTextBox.getText().length();
        int[] iArr = {length, str.length() + length};
        boolean zHasRtlCharacters = AiViewUtils.hasRtlCharacters(str);
        objectTextBox.insertText(str.concat("\n"), length);
        textStyleHelper.setFontSize(i, iArr);
        textStyleHelper.setTask(iArr);
        textStyleHelper.setAlign(zHasRtlCharacters ? 1 : 0, iArr);
        int i2 = iArr[1];
        textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        return !this.mSummaryResultItemList.isEmpty();
    }

    public void clear() {
        ListenerImplContract.IDialogPresenter dialogPresenterManager = this.mComposerViewPresenter.getDialogPresenterManager();
        if (dialogPresenterManager instanceof DialogPresenterManager) {
            ((DialogPresenterManager) dialogPresenterManager).hideSummaryOptionDialog();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        new ResultOperation().copy(this.mComposerViewPresenter, getResultToCopy());
    }

    public void execute() {
        this.mLastErrorMessage = null;
        this.mSummaryResultItemList.clear();
        this.mSttParagraphList.clear();
        if (!this.mIsSummarizeAgain && setSummaryDataFromFile()) {
            getHandler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarization.1
                @Override // java.lang.Runnable
                public void run() {
                    AiMenuContract.ResultListener resultListener = STTSummarization.this.mResultListener;
                    if (resultListener != null) {
                        resultListener.onCompleted(true);
                    }
                }
            });
            return;
        }
        if (this.mIsSummaryStyleChanged) {
            this.mIsSummaryStyleChanged = false;
        } else {
            this.mOption = SummaryOption.SHOW_AS_TIMELINE;
        }
        STTPresenter sTTPresenter = this.mAiSTTContract.getSTTPresenter();
        this.mExecutePosition = sTTPresenter.getMItemIndexToShow();
        ParagraphSttTask paragraphSttTask = new ParagraphSttTask(sTTPresenter.getCurrentShowingTextDataList(), new ParagraphSttTask.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarization.2
            /* JADX WARN: Removed duplicated region for block: B:22:0x00e2  */
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.ParagraphSttTask.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResult(ArrayList<TextData> arrayList) {
                int startTime;
                STTSummarization.this.mSttParagraphList.add(new ArrayList(arrayList));
                Logger.m10999d(STTSummarization.TAG, "mSttParagraphList " + STTSummarization.this.mSttParagraphList.size());
                if (STTSummarization.this.mSttParagraphList.isEmpty()) {
                    Logger.m11003i(STTSummarization.TAG, "onResult# paragraphs size is 0");
                    return;
                }
                ArrayList arrayList2 = (ArrayList) STTSummarization.this.mSttParagraphList.get(0);
                StringBuilder sb = new StringBuilder();
                if (arrayList2.isEmpty()) {
                    startTime = 0;
                } else {
                    startTime = ((TextData) arrayList2.get(0)).getStartTime();
                    sb.append(STTSummarization.getStringFromTextData(arrayList2));
                }
                int i = 1;
                while (i < STTSummarization.this.mSttParagraphList.size()) {
                    ArrayList arrayList3 = (ArrayList) STTSummarization.this.mSttParagraphList.get(i);
                    String stringFromTextData = STTSummarization.getStringFromTextData(arrayList3);
                    if (stringFromTextData.length() + sb.length() >= STTSummarization.this.mParagraphStringMaxLength) {
                        if (stringFromTextData.length() < (i < STTSummarization.this.mSttParagraphList.size() - 1 ? 20 : 200)) {
                            sb.append(stringFromTextData);
                        } else {
                            AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = new AiMenuResultViewSTTSummarizationItem();
                            aiMenuResultViewSTTSummarizationItem.setParagraph(sb.toString());
                            aiMenuResultViewSTTSummarizationItem.setTimeStamp(startTime);
                            aiMenuResultViewSTTSummarizationItem.setHidden(true);
                            STTSummarization.this.mSummaryResultItemList.add(aiMenuResultViewSTTSummarizationItem);
                            startTime = ((TextData) arrayList3.get(0)).getStartTime();
                            sb = new StringBuilder(stringFromTextData);
                        }
                    }
                    i++;
                }
                AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem2 = new AiMenuResultViewSTTSummarizationItem();
                aiMenuResultViewSTTSummarizationItem2.setParagraph(sb.toString());
                aiMenuResultViewSTTSummarizationItem2.setTimeStamp(startTime);
                aiMenuResultViewSTTSummarizationItem2.setHidden(true);
                STTSummarization.this.mSummaryResultItemList.add(aiMenuResultViewSTTSummarizationItem2);
                STTSummarization sTTSummarization = STTSummarization.this;
                sTTSummarization.mSummaryRequestCount.set(sTTSummarization.mSummaryResultItemList.size());
                STTSummarization.this.mSummaryFailedCount.set(0);
                for (int i2 = 0; i2 < STTSummarization.this.mSummaryResultItemList.size(); i2++) {
                    AbstractC8014b.m7217s(i2, "requestSummary item ", STTSummarization.TAG);
                    STTSummarization.this.requestSummary(i2);
                    try {
                        Thread.sleep(STTSummarization.SUMMARY_REQUEST_SLEEP_TIME);
                    } catch (InterruptedException e) {
                        Logger.m11000e(STTSummarization.TAG, e.getMessage());
                    }
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.ParagraphSttTask.Callback
            public void onUpdate(ArrayList<TextData> arrayList) {
                STTSummarization.this.mSttParagraphList.add(new ArrayList(arrayList));
            }
        });
        int i = C94363.f6862xc2a6ad1a[this.mOption.ordinal()];
        if (i == 1) {
            ThreadPoolManager.getsInstance().addCallable(paragraphSttTask);
        } else if (i == 2) {
            String sTTCurrentVoiceItemAdapterText = this.mAiSTTContract.getSTTPresenter().getSTTCurrentVoiceItemAdapterText(false);
            AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = new AiMenuResultViewSTTSummarizationItem();
            aiMenuResultViewSTTSummarizationItem.setParagraph(sTTCurrentVoiceItemAdapterText);
            aiMenuResultViewSTTSummarizationItem.setTimeStamp(-1);
            aiMenuResultViewSTTSummarizationItem.setHidden(true);
            this.mSummaryResultItemList.add(aiMenuResultViewSTTSummarizationItem);
            this.mSummaryRequestCount.set(this.mSummaryResultItemList.size());
            this.mSummaryFailedCount.set(0);
            requestSummary(0);
        }
        ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_SUMMARY, STTConstant.EVENT_NUMBER_OF_TEXT_SUMMARIZE, ComposerSA.getDetailAiSelectedTextLength(this.mAiSTTContract.getSTTPresenter().getCurrentVoiceItemText().length(), 5000));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "c";
    }

    public String getErrorMessage(String str) {
        return str.isEmpty() ? "unexpected error" : "SAFE_FILTER_ERROR_CHILD".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_child_summarize) : "SAFE_FILTER_ERROR_RECITATION".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_recitation_summarize) : "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_unsupported_language_summarize) : "SAFE_FILTER_ERROR_CHN_SENSITIVE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_chn_sensitive_summarize) : "SAFE_FILTER_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_ai_error_msg_safety_filter_in_other_cases_summarize) : "NETWORK_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_network_connection_error_msg) : ("INTERNAL_SERVER_ERROR".equals(str) || "UNEXPECTED_ERROR".equals(str)) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_something_went_wrong) : str;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public String getLastErrorMessage() {
        return this.mLastErrorMessage;
    }

    public SpenWNote getResultNote() {
        return this.mResultNote;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        makeResultNote();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(this.mResultNote.getBodyText());
        addLastLineFeed(newSpenObjectTextBox);
        ComposerSpenWNoteUtils.removeFontSizeSpan(newSpenObjectTextBox);
        return newSpenObjectTextBox;
    }

    public STTSummarizeTranslation getSTTSummarizeTranslation() {
        return this.mSTTSummarizeTranslation;
    }

    public TreeMap<Integer, Boolean> getSelectedMap() {
        return this.mSelectedMap;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return new SrcContentInfo("");
    }

    public List<AiMenuResultViewSTTSummarizationItem> getSummaryResultItemList() {
        return this.mSummaryResultItemList;
    }

    public void hideSummaryResultItem(int i) {
        List<AiMenuResultViewSTTSummarizationItem> list = this.mSummaryResultItemList;
        if (list == null) {
            return;
        }
        list.get(i).setHidden(true);
    }

    public boolean isStreamingMode() {
        return this.mIsStreamingMode;
    }

    public boolean isWorking() {
        return this.mSummarizer != null;
    }

    public void makeResultNote() {
        SpenWNote spenWNote = this.mResultNote;
        if (spenWNote == null) {
            SpenWNote spenWNoteMakeInitialNote = makeInitialNote();
            this.mResultNote = spenWNoteMakeInitialNote;
            if (spenWNoteMakeInitialNote == null) {
                return;
            }
        } else {
            spenWNote.getBodyText().removeAllText();
        }
        if (this.mResultNote.getBodyText() != null) {
            this.mResultNote.getBodyText().copy(makeSummaryTextBox());
        }
    }

    public void onReleaseSection() {
        setResultListener(null);
        SpenWNote spenWNote = this.mResultNote;
        if (spenWNote != null && !spenWNote.isClosed()) {
            try {
                this.mResultNote.close(true);
            } catch (IOException e) {
                Logger.m11000e(TAG, "onReleaseSection# " + e);
            }
        }
        this.mResultNote = null;
        Summarizer summarizer = this.mSummarizer;
        if (summarizer != null) {
            summarizer.registerCallback(null);
            this.mSummarizer = null;
            this.mOption = this.mBeforeOption;
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (!TextUtils.isEmpty(this.mLastErrorMessage)) {
            Logger.m11000e(TAG, "onSaveInstanceState# failed state");
            return;
        }
        if (this.mResultNote == null) {
            bundle.putBoolean(TAG, false);
            return;
        }
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        this.mBackupTextBox = newSpenObjectTextBox;
        newSpenObjectTextBox.copy(this.mResultNote.getBodyText());
        bundle.putBoolean(TAG, !TextUtils.isEmpty(this.mBackupTextBox.getText()));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
    }

    public void removeHiddenItem() {
        this.mSummaryResultItemList.removeIf(new C9464i());
    }

    public void requestSummary(int i) {
        String paragraph = this.mSummaryResultItemList.get(i).getParagraph();
        Logger.m10999d(TAG, "requestSummary" + LoggerBase.getEncode(paragraph));
        STTSummarizer sTTSummarizer = new STTSummarizer(UnicodeUtils.removeObjectReplacementChar(paragraph), SummaryStyle.valueOf(this.mOption.getSCSOptionStr()));
        this.mSummarizer = sTTSummarizer;
        sTTSummarizer.setSummarizeSubTask(SummarizeSubTask.DIALOGUE);
        this.mSummarizer.setExtraKey(String.valueOf(i));
        this.mSummarizer.registerCallback(new SummarizeCallback(i));
        if (this.mIsSummarizeAgain) {
            this.mSummarizer.deleteCache();
        }
        this.mSummarizer.execute();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        String str = TAG;
        if (bundle.containsKey(str)) {
            Logger.m10999d(str, "restore#");
        }
    }

    public void setIsSummarizeAgain(boolean z) {
        this.mIsSummarizeAgain = z;
        if (z && this.mSTTSummarizeTranslation.isTranslateMode()) {
            this.mSTTSummarizeTranslation.toggleTranslateMode();
            this.mSTTSummarizeTranslation.setCompleted(false);
        }
    }

    public void setResultListener(AiMenuContract.ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public void setSelectedMap(TreeMap<Integer, Boolean> treeMap) {
        this.mSelectedMap = treeMap;
    }

    public boolean setSummaryDataFromFile() {
        STTPresenter sTTPresenter = this.mAiSTTContract.getSTTPresenter();
        SpenVoiceTextDataReader spenVoiceTextDataReader = SpenVoiceTextDataReaderCache.getInstance().get(sTTPresenter.getVoiceDataList().get(sTTPresenter.getMItemIndexToShow()));
        String[] summaryTitle = spenVoiceTextDataReader.getSummaryTitle();
        ArrayList<String>[] summaryLines = spenVoiceTextDataReader.getSummaryLines();
        int iOrdinal = spenVoiceTextDataReader.getSummaryStyle() == null ? SummaryOption.SHOW_AS_TIMELINE.ordinal() : spenVoiceTextDataReader.getSummaryStyle().intValue();
        long[] timeStamp = spenVoiceTextDataReader.getTimeStamp();
        if (summaryTitle == null || summaryTitle.length == 0) {
            return false;
        }
        this.mOption = SummaryOption.fromValue(iOrdinal);
        for (int i = 0; i < summaryTitle.length; i++) {
            if (!isSummaryItemEmpty(summaryTitle[i], summaryLines[i]).booleanValue()) {
                AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = new AiMenuResultViewSTTSummarizationItem();
                aiMenuResultViewSTTSummarizationItem.setSummaryLines(summaryLines[i]);
                aiMenuResultViewSTTSummarizationItem.setSummaryTitle(summaryTitle[i]);
                aiMenuResultViewSTTSummarizationItem.setTimeStamp((int) timeStamp[i]);
                aiMenuResultViewSTTSummarizationItem.setTranslatedLines(new ArrayList<>());
                this.mSummaryResultItemList.add(aiMenuResultViewSTTSummarizationItem);
            }
        }
        return true;
    }

    public void setSummaryStyle(SummaryOption summaryOption) {
        this.mOption = summaryOption;
    }

    public void shareSelectedSummaryItem() {
        String selectedText = getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            Logger.m11000e(TAG, "shareSelectedTextData# fail : empty text");
            return;
        }
        Logger.m10999d(TAG, "shareSelectedTextData #" + this.mSTTSummarizeTranslation.isTranslateMode() + " " + selectedText.length());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", selectedText);
        try {
            Activity activity = this.mComposerViewPresenter.getActivity();
            Intent intent2 = new Intent(activity, (Class<?>) ShareCallbackReceiver.class);
            intent2.setAction(ShareCallbackReceiver.ACTION_SHARE_CALLBACK);
            activity.startActivity(Intent.createChooser(intent, activity.getString(C9086R.string.action_share), (Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(activity, 0, intent2, 33554432) : PendingIntent.getBroadcast(activity, 0, intent2, 134217728)).getIntentSender()));
        } catch (ActivityNotFoundException e) {
            Logger.m11001e(TAG, "activity not found!", e);
        }
    }

    public void showSTTSummaryOptionDialog(Runnable runnable, View view) {
        if (this.mComposerViewPresenter.getDialogPresenterManager() instanceof DialogPresenterManager) {
            ((DialogPresenterManager) this.mComposerViewPresenter.getDialogPresenterManager()).showSummaryOptionDialog(this.mOption.ordinal(), new C9459d(this, runnable, 1), true, view);
        }
    }

    public void summarize(String str, SummaryStyle summaryStyle, boolean z) {
        Logger.m10999d(TAG, "summarize# " + summaryStyle.name());
        Summarizer summarizer = new Summarizer(UnicodeUtils.removeObjectReplacementChar(str), summaryStyle, true);
        this.mSummarizer = summarizer;
        summarizer.setSummarizeSubTask(SummarizeSubTask.DIALOGUE);
        this.mSummarizer.registerCallback(new SummarizeCallback(0));
        this.mSummarizer.execute();
        if (z) {
            return;
        }
        this.mResultListener.onProgressing();
    }

    public void updateSummaryMultipleResultItem(int i, String str) {
        if (this.mSummaryResultItemList == null) {
            return;
        }
        SummaryMultipleResultParser summaryMultipleResultParser = new SummaryMultipleResultParser(str);
        for (int i2 = 1; i2 < summaryMultipleResultParser.getResultParsers().size(); i2++) {
            AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = new AiMenuResultViewSTTSummarizationItem();
            aiMenuResultViewSTTSummarizationItem.setParagraph("");
            aiMenuResultViewSTTSummarizationItem.setTimeStamp(-1);
            aiMenuResultViewSTTSummarizationItem.setHidden(true);
            this.mSummaryResultItemList.add(aiMenuResultViewSTTSummarizationItem);
        }
        for (int i4 = 0; i4 < summaryMultipleResultParser.getResultParsers().size(); i4++) {
            SummaryResultParser summaryResultParser = summaryMultipleResultParser.getResultParsers().get(i4);
            AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem2 = this.mSummaryResultItemList.get(i4);
            aiMenuResultViewSTTSummarizationItem2.setSummaryLines(summaryResultParser.getSummaries());
            aiMenuResultViewSTTSummarizationItem2.setSummaryTitle(summaryResultParser.getTitle());
            aiMenuResultViewSTTSummarizationItem2.setTranslatedLines(new ArrayList<>());
            if (summaryResultParser.getSummaries().isEmpty() && TextUtils.isEmpty(summaryResultParser.getTitle())) {
                aiMenuResultViewSTTSummarizationItem2.setHidden(true);
            } else {
                aiMenuResultViewSTTSummarizationItem2.setHidden(false);
            }
            aiMenuResultViewSTTSummarizationItem2.setStreamCompleted(true);
        }
    }

    public void updateSummaryResultItem(int i, String str) {
        List<AiMenuResultViewSTTSummarizationItem> list = this.mSummaryResultItemList;
        if (list == null || i < 0 || i >= list.size()) {
            return;
        }
        AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = this.mSummaryResultItemList.get(i);
        SummaryResultParser summaryResultParser = new SummaryResultParser(str);
        aiMenuResultViewSTTSummarizationItem.setSummaryLines(summaryResultParser.getSummaries());
        aiMenuResultViewSTTSummarizationItem.setSummaryTitle(summaryResultParser.getTitle());
        aiMenuResultViewSTTSummarizationItem.setTranslatedLines(new ArrayList<>());
        aiMenuResultViewSTTSummarizationItem.setHidden(summaryResultParser.getSummaries().isEmpty() && TextUtils.isEmpty(summaryResultParser.getTitle()));
        aiMenuResultViewSTTSummarizationItem.setStreamCompleted(true);
    }

    public void writeSummaryResult(STTUpdateDataTask.Callback callback) {
        List<SpenVoiceData> voiceDataList = this.mAiSTTContract.getSTTPresenter().getVoiceDataList();
        int i = this.mExecutePosition;
        if (i < 0 || i >= voiceDataList.size()) {
            Logger.m10999d(TAG, "writeSummaryResult# index out of bound");
            return;
        }
        SpenVoiceData spenVoiceData = voiceDataList.get(this.mExecutePosition);
        List<AiMenuResultViewSTTSummarizationItem> list = this.mSummaryResultItemList;
        if (list == null) {
            Logger.m10999d(TAG, "writeSummaryResult# mSummaryResultItemList is null");
            return;
        }
        int size = list.size();
        String[] strArr = new String[size];
        long[] jArr = new long[size];
        ArrayList<String>[] arrayListArr = new ArrayList[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.mSummaryResultItemList.get(i2).getSummaryTitle();
            jArr[i2] = this.mSummaryResultItemList.get(i2).getTimeStamp();
            arrayListArr[i2] = this.mSummaryResultItemList.get(i2).getSummaryLines();
        }
        int iOrdinal = this.mOption.ordinal();
        if (this.mIsStreamingMode) {
            iOrdinal = SummaryOption.SHOW_AS_TIMELINE.ordinal();
        }
        new STTUpdateDataTask().writeSummaryResult(this.mComposerViewPresenter.getComposerModel().getDocInfo().getDocPath(), spenVoiceData, size, strArr, jArr, arrayListArr, iOrdinal, callback);
    }
}
