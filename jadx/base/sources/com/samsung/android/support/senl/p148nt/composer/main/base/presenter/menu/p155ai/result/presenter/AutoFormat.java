package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.util.Consumer;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.MeetingFormatNoteMerger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.ChunkSizePolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.assist.llm.MeetingAutoFormatter;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.StructuredAutoFormatter;
import com.samsung.android.support.senl.p148nt.model.assist.llm.StructuredManualFormatter;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.StructuredAutoFormatMerger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormat implements AiMenuContract.IAiAction {
    private static final boolean DEBUG = true;
    private static final String TAG = Logger.createTag("AutoFormat", AiConstants.PREFIX_TAG);
    AbsFormat mAbsFormat;
    Integer mApplyFontSize;
    ComposerViewPresenter mComposerViewPresenter;
    LanguageIdentifier mLanguageIdentifier;
    private String mLastErrorMessage;
    int mLastSelectedStyle;
    ArrayList<SpenTextSpanBase> mOriginalTextSpanList;
    ResultListener mResultListener;
    ResultNoteManager mResultNoteManager;
    ServerResultParser mServerResultParser;
    SrcContentInfo mSrcContentInfo;
    List<Integer> mStyleOrder;
    FormatType mPreFormatType = null;
    ErrorType mErrorType = null;
    boolean mIsRestore = false;
    Handler mHandler = new Handler(Looper.getMainLooper());
    FormatType mCurrentFormatType = FormatType.Normal;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class AbsFormat {
        public AbsFormat() {
        }

        private boolean handleCNError() {
            if (!CscFeature.INSTANCE.getInstance().isChinaAiFeature() || AutoFormat.this.mServerResultParser.checkParseResult()) {
                return false;
            }
            Logger.m10999d(AutoFormat.TAG, "handleCNError fail# ");
            onFailed(AutoFormat.this.getErrorMessage("SAFE_FILTER_ERROR_CHN_SENSITIVE"));
            return true;
        }

        private void insertResult(List<SpenObjectTextBox> list, String str) {
            Logger.startTime(String.valueOf(hashCode()), AutoFormat.TAG, "makeNote start");
            boolean z = false;
            for (int i = 0; i < AutoFormat.this.mResultNoteManager.getFormattedNoteList().size(); i++) {
                SpenWNote spenWNote = AutoFormat.this.mResultNoteManager.getFormattedNoteList().get(i);
                SpenObjectTextBox spenObjectTextBox = list.get(i);
                SpenObjectTextBox bodyText = spenWNote.getBodyText();
                if (TextUtils.isEmpty(spenObjectTextBox.getText())) {
                    if (!z) {
                        AbstractC8014b.m7198D("insertResult# empty result: ", str, AutoFormat.TAG);
                    }
                    Logger.m11000e(AutoFormat.TAG, "insertResult# empty result: " + i);
                    z = true;
                } else {
                    bodyText.insertText(bodyText.getText().length(), spenObjectTextBox, 0, spenObjectTextBox.getText().length());
                }
            }
            mergeNote();
            Logger.endTime(String.valueOf(hashCode()), AutoFormat.TAG, "makeNote end");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCompleted$0(boolean z) {
            ResultListener resultListener = AutoFormat.this.mResultListener;
            if (resultListener != null) {
                resultListener.onResult(z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$1(String str) {
            ResultListener resultListener = AutoFormat.this.mResultListener;
            if (resultListener != null) {
                resultListener.onFailed(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextCompleted$2(List list, String str, String str2) {
            insertResult(list, str);
            ResultListener resultListener = AutoFormat.this.mResultListener;
            if (resultListener != null) {
                resultListener.onNextCompleted(!r1.mSrcContentInfo.hasNextInputUnit());
            }
            updateState(str2);
            AutoFormat autoFormat = AutoFormat.this;
            autoFormat.mResultNoteManager.setOriginalFormattedNoteList(autoFormat.mComposerViewPresenter.getActivity(), AutoFormat.this.mResultNoteManager.getFormattedNoteList());
            Logger.m10999d(AutoFormat.TAG, "onNextCompleted# end");
        }

        private List<SpenObjectTextBox> makeFormattedTextBox() {
            Logger.startTime(String.valueOf(hashCode()), AutoFormat.TAG, "makeFormattedTextBox start");
            ArrayList arrayList = new ArrayList(5);
            int fontSize = getFontSize();
            for (int i = 0; i < 5; i++) {
                SpenObjectTextBox newBodyText = AutoFormat.this.mComposerViewPresenter.getObjectManager().getNewBodyText();
                AiViewUtils.setResultTextBoxState(newBodyText);
                AutoFormat.this.mServerResultParser.applyFormat(i, newBodyText, fontSize);
                AiViewUtils.applySpFontSize(AutoFormat.this.mComposerViewPresenter.getActivity(), newBodyText);
                arrayList.add(newBodyText);
            }
            Logger.endTime(String.valueOf(hashCode()), AutoFormat.TAG, "makeFormattedTextBox end");
            return arrayList;
        }

        private void makeNote(List<SpenObjectTextBox> list) {
            Logger.startTime(String.valueOf(hashCode()), AutoFormat.TAG, "makeNote start");
            AutoFormat autoFormat = AutoFormat.this;
            autoFormat.mResultNoteManager.initResultNote(autoFormat.mComposerViewPresenter.getActivity(), AutoFormat.this.mComposerViewPresenter.getDoc());
            for (int i = 0; i < AutoFormat.this.mResultNoteManager.getFormattedNoteList().size(); i++) {
                SpenObjectTextBox bodyText = AutoFormat.this.mResultNoteManager.getFormattedNoteList().get(i).getBodyText();
                float leftMargin = bodyText.getLeftMargin();
                float topMargin = bodyText.getTopMargin();
                float rightMargin = bodyText.getRightMargin();
                float bottomMargin = bodyText.getBottomMargin();
                bodyText.copy(list.get(i));
                bodyText.setMargin(leftMargin, topMargin, rightMargin, bottomMargin);
            }
            ResultNoteManager resultNoteManager = AutoFormat.this.mResultNoteManager;
            resultNoteManager.setResultNoteList(resultNoteManager.getFormattedNoteList());
            AutoFormat autoFormat2 = AutoFormat.this;
            autoFormat2.mResultNoteManager.setOriginalFormattedNoteList(autoFormat2.mComposerViewPresenter.getActivity(), AutoFormat.this.mResultNoteManager.getFormattedNoteList());
            Logger.endTime(String.valueOf(hashCode()), AutoFormat.TAG, "makeNote end");
        }

        public abstract void cancel();

        public abstract void formatting(String str);

        public int getFontSize() {
            return AiViewUtils.getDefViewerFontSize(AutoFormat.this.mComposerViewPresenter.getActivity());
        }

        public void initMerger(String str) {
        }

        public abstract boolean isWaiting();

        public void makeFormattedNote(String str) {
            parseResult(str);
            if (handleCNError()) {
                return;
            }
            makeNote(makeFormattedTextBox());
        }

        public void mergeNote() {
        }

        public abstract String mergeResult(@NonNull String str);

        public void nextFormatting(String str) {
        }

        public void onCompleted(String str, boolean z) {
            Logger.m10999d(AutoFormat.TAG, "onCompleted# ");
            if (AutoFormat.this.mResultNoteManager.getOriginNote() == null && AutoFormat.this.mSrcContentInfo.getSrcType() != 2) {
                Logger.m11000e(AutoFormat.TAG, "onCompleted# autoformat is completed before view is created");
                AutoFormat.this.makeOriginNote();
            }
            makeFormattedNote(str);
            AutoFormat.this.mHandler.post(new RunnableC9458c(0, this, z));
            updateState(str);
        }

        public void onFailed(String str) {
            AutoFormat.this.mLastErrorMessage = str;
            AbstractC8014b.m7196B("formatting#onFailed: ", str, AutoFormat.TAG);
            AutoFormat.this.mHandler.post(new RunnableC9456a(0, this, str));
        }

        public void onNextCompleted(@NonNull final String str) {
            Logger.m10999d(AutoFormat.TAG, "onNextCompleted# start");
            final String strMergeResult = mergeResult(str);
            Logger.startTime(String.valueOf(hashCode()), AutoFormat.TAG, "parse start");
            parseResult(strMergeResult);
            Logger.endTime(String.valueOf(hashCode()), AutoFormat.TAG, "parse end");
            if (handleCNError()) {
                return;
            }
            final List<SpenObjectTextBox> listMakeFormattedTextBox = makeFormattedTextBox();
            AutoFormat.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6866a.lambda$onNextCompleted$2(listMakeFormattedTextBox, strMergeResult, str);
                }
            });
        }

        public abstract void parseResult(String str);

        public void updateState(String str) {
            SrcContentInfo srcContentInfo = AutoFormat.this.mSrcContentInfo;
            srcContentInfo.setCompletedIndex(srcContentInfo.getCompletedIndex() + 1);
            Activity activity = AutoFormat.this.mComposerViewPresenter.getActivity();
            AutoFormat autoFormat = AutoFormat.this;
            AiViewUtils.updateOriginalTextColor(activity, autoFormat.mSrcContentInfo, autoFormat.mResultNoteManager.getOriginNote(), AutoFormat.this.mOriginalTextSpanList);
            if (AutoFormat.this.mResultNoteManager.hasResult() && AutoFormat.this.mSrcContentInfo.hasNextInputUnit()) {
                initMerger(str);
                nextFormatting(UnicodeUtils.removeObjectReplacementChar(AutoFormat.this.mSrcContentInfo.getNextInput()));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorType {
        MINIMUM(C9086R.plurals.ai_error_cant_auto_format_text_with_fewer_than_pd_characters);

        final int mMsgRes;

        ErrorType(int i) {
            this.mMsgRes = i;
        }

        public String getMsg(Context context) {
            return equals(MINIMUM) ? context.getResources().getQuantityString(this.mMsgRes, 200, 200) : context.getResources().getString(this.mMsgRes);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FormatType {
        Normal(C9086R.string.ai_auto_format_type_headers_and_bullets),
        Manual(C9086R.string.ai_auto_format_type_headers_and_bullets),
        Meeting(C9086R.string.ai_auto_format_type_meeting);


        @StringRes
        final int mStrRes;

        FormatType(int i) {
            this.mStrRes = i;
        }

        public int getStrRes() {
            return this.mStrRes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ManualFormat extends AbsFormat {
        StructuredAutoFormatMerger mStructuredAutoFormatMerger;
        StructuredManualFormatter mStructuredManualFormatter;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class CallbackImpl implements Operator.Callback {
            public CallbackImpl() {
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str) {
                ManualFormat manualFormat = ManualFormat.this;
                if (manualFormat.mStructuredManualFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onFailed# is canceled");
                    return true;
                }
                manualFormat.mStructuredManualFormatter = null;
                ManualFormat.this.onFailed(AutoFormat.this.getErrorMessage(str));
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
            public void onRetry(Runnable runnable) {
                AiCommonUtil.executeRetryAction(runnable);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                ManualFormat manualFormat = ManualFormat.this;
                if (manualFormat.mStructuredManualFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onSuccess# is canceled");
                } else {
                    manualFormat.mStructuredManualFormatter = null;
                    manualFormat.onCompleted(str, z);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class NextCallbackImpl extends CallbackImpl {
            public NextCallbackImpl() {
                super();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.ManualFormat.CallbackImpl, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                Logger.m10999d(AutoFormat.TAG, "NextCallbackImpl#onSuccess# (" + AutoFormat.this.mSrcContentInfo.getInputIndex() + "/" + AutoFormat.this.mSrcContentInfo.getInputList().size() + ")");
                ManualFormat manualFormat = ManualFormat.this;
                if (manualFormat.mStructuredManualFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onSuccess# is canceled");
                } else {
                    manualFormat.mStructuredManualFormatter = null;
                    manualFormat.onNextCompleted(str);
                }
            }
        }

        public ManualFormat() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void cancel() {
            StructuredManualFormatter structuredManualFormatter = this.mStructuredManualFormatter;
            if (structuredManualFormatter != null) {
                structuredManualFormatter.registerCallback(null);
                this.mStructuredManualFormatter = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void formatting(String str) {
            StructuredManualFormatter structuredManualFormatter = new StructuredManualFormatter(str);
            this.mStructuredManualFormatter = structuredManualFormatter;
            structuredManualFormatter.registerCallback(new CallbackImpl());
            this.mStructuredManualFormatter.execute();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void initMerger(String str) {
            if (this.mStructuredAutoFormatMerger == null) {
                StructuredAutoFormatMerger structuredAutoFormatMerger = new StructuredAutoFormatMerger();
                this.mStructuredAutoFormatMerger = structuredAutoFormatMerger;
                structuredAutoFormatMerger.getResult(str);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public boolean isWaiting() {
            return this.mStructuredManualFormatter != null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public String mergeResult(@NonNull String str) {
            Logger.startTime(String.valueOf(hashCode()), AutoFormat.TAG, "merge start");
            String result = this.mStructuredAutoFormatMerger.getResult(str);
            Logger.endTime(String.valueOf(hashCode()), AutoFormat.TAG, "merge end");
            return result;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void nextFormatting(String str) {
            Logger.m10999d(AutoFormat.TAG, "nextFormatting#");
            StructuredManualFormatter structuredManualFormatter = new StructuredManualFormatter(str);
            this.mStructuredManualFormatter = structuredManualFormatter;
            structuredManualFormatter.registerCallback(new NextCallbackImpl());
            this.mStructuredManualFormatter.execute();
            ResultListener resultListener = AutoFormat.this.mResultListener;
            if (resultListener != null) {
                resultListener.onProgressing();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void parseResult(String str) {
            AutoFormat.this.mServerResultParser = new ServerResultParser(str);
            AutoFormat.this.mServerResultParser.parse();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MeetingFormat extends AbsFormat {
        Locale mIdentifiedLocale;
        MeetingFormatNoteMerger mMeetingFormatNoteMerger;
        MeetingAutoFormatter mMeetingFormatter;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class CallbackImpl implements Operator.Callback {
            public CallbackImpl() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onSuccess$0(String str, boolean z, Void r32) {
                MeetingFormat.this.onCompleted(str, z);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str) {
                MeetingFormat meetingFormat = MeetingFormat.this;
                if (meetingFormat.mMeetingFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onFailed# is canceled");
                    return true;
                }
                meetingFormat.mMeetingFormatter = null;
                MeetingFormat.this.onFailed(AutoFormat.this.getErrorMessage(str));
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
            public void onRetry(Runnable runnable) {
                AiCommonUtil.executeRetryAction(runnable);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull final String str, final boolean z) {
                MeetingFormat meetingFormat = MeetingFormat.this;
                if (meetingFormat.mMeetingFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onSuccess# is canceled");
                } else {
                    meetingFormat.identifyLanguage(str, new Consumer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.e
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            this.f6876a.lambda$onSuccess$0(str, z, (Void) obj);
                        }
                    });
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class NextCallbackImpl extends CallbackImpl {
            public NextCallbackImpl() {
                super();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.MeetingFormat.CallbackImpl, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                Logger.m10999d(AutoFormat.TAG, "NextCallbackImpl#onSuccess# (" + AutoFormat.this.mSrcContentInfo.getInputIndex() + "/" + AutoFormat.this.mSrcContentInfo.getInputList().size() + ")");
                MeetingFormat meetingFormat = MeetingFormat.this;
                if (meetingFormat.mMeetingFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onSuccess# is canceled");
                } else {
                    meetingFormat.mMeetingFormatter = null;
                    meetingFormat.onNextCompleted(str);
                }
            }
        }

        public MeetingFormat() {
            super();
            this.mIdentifiedLocale = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$identifyLanguage$0(Consumer consumer, Locale locale) {
            this.mIdentifiedLocale = locale;
            if (locale == null) {
                this.mIdentifiedLocale = Locale.ENGLISH;
            }
            this.mMeetingFormatter = null;
            consumer.accept(null);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void cancel() {
            MeetingAutoFormatter meetingAutoFormatter = this.mMeetingFormatter;
            if (meetingAutoFormatter != null) {
                meetingAutoFormatter.registerCallback(null);
                this.mMeetingFormatter = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void formatting(String str) {
            MeetingAutoFormatter meetingAutoFormatter = new MeetingAutoFormatter(str);
            this.mMeetingFormatter = meetingAutoFormatter;
            meetingAutoFormatter.registerCallback(new CallbackImpl());
            this.mMeetingFormatter.execute();
        }

        public void identifyLanguage(String str, Consumer<Void> consumer) {
            Logger.m10999d(AutoFormat.TAG, "identifyLanguage#");
            new LanguageIdentifier().identifyLanguage(str, new C9459d(this, consumer, 0));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void initMerger(String str) {
            if (this.mMeetingFormatNoteMerger == null) {
                MeetingFormatNoteMerger meetingFormatNoteMerger = new MeetingFormatNoteMerger();
                this.mMeetingFormatNoteMerger = meetingFormatNoteMerger;
                meetingFormatNoteMerger.initialize((ServerResultMeetingParser) AutoFormat.this.mServerResultParser, str);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public boolean isWaiting() {
            return this.mMeetingFormatter != null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void mergeNote() {
            this.mMeetingFormatNoteMerger.mergeNote((ServerResultMeetingParser) AutoFormat.this.mServerResultParser, getFontSize(), new MeetingFormatNoteMerger.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.MeetingFormat.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.MeetingFormatNoteMerger.Contract
                public List<SpenWNote> getNoteList() {
                    return AutoFormat.this.mResultNoteManager.getFormattedNoteList();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.MeetingFormatNoteMerger.Contract
                public SpenObjectTextBox makeNewTextBox() {
                    SpenObjectTextBox newBodyText = AutoFormat.this.mComposerViewPresenter.getObjectManager().getNewBodyText();
                    AiViewUtils.setResultTextBoxState(newBodyText);
                    return newBodyText;
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public String mergeResult(@NonNull String str) {
            Logger.startTime(String.valueOf(hashCode()), AutoFormat.TAG, "merge start");
            this.mMeetingFormatNoteMerger.getMeetingAutoFormatMerger().addFormatToResult(str);
            String contents = this.mMeetingFormatNoteMerger.getMeetingAutoFormatMerger().getContents();
            Logger.endTime(String.valueOf(hashCode()), AutoFormat.TAG, "merge end");
            return contents;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void nextFormatting(String str) {
            Logger.m10999d(AutoFormat.TAG, "nextFormatting#");
            MeetingAutoFormatter meetingAutoFormatter = new MeetingAutoFormatter(str);
            this.mMeetingFormatter = meetingAutoFormatter;
            meetingAutoFormatter.registerCallback(new NextCallbackImpl());
            this.mMeetingFormatter.execute();
            ResultListener resultListener = AutoFormat.this.mResultListener;
            if (resultListener != null) {
                resultListener.onProgressing();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void parseResult(String str) {
            AutoFormat.this.mServerResultParser = new ServerResultMeetingParser(str);
            AutoFormat autoFormat = AutoFormat.this;
            ((ServerResultMeetingParser) autoFormat.mServerResultParser).setMeetingInfoLanguage(autoFormat.mComposerViewPresenter.getActivity(), this.mIdentifiedLocale);
            AutoFormat.this.mServerResultParser.parse();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class NormalFormat extends AbsFormat {
        StructuredAutoFormatMerger mStructuredAutoFormatMerger;
        StructuredAutoFormatter mStructuredFormatter;
        StructuredManualFormatter mStructuredManualFormatter;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class CallbackImpl implements Operator.Callback {
            String mSelectedText;

            public CallbackImpl(String str) {
                this.mSelectedText = str;
            }

            public boolean formattingManual(String str) {
                if (!"AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED".equals(str)) {
                    return false;
                }
                AutoFormat.this.formatting(this.mSelectedText, FormatType.Manual);
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str) {
                NormalFormat normalFormat = NormalFormat.this;
                if (normalFormat.mStructuredFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onFailed# is canceled");
                    return true;
                }
                normalFormat.mStructuredFormatter = null;
                if (formattingManual(str)) {
                    return true;
                }
                NormalFormat.this.onFailed(AutoFormat.this.getErrorMessage(str));
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
            public void onRetry(Runnable runnable) {
                AiCommonUtil.executeRetryAction(runnable);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                NormalFormat normalFormat = NormalFormat.this;
                if (normalFormat.mStructuredFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onSuccess# is canceled");
                } else {
                    normalFormat.mStructuredFormatter = null;
                    normalFormat.onCompleted(str, z);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class NextCallbackImpl extends CallbackImpl {
            public NextCallbackImpl(String str) {
                super(str);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.NormalFormat.CallbackImpl
            public boolean formattingManual(String str) {
                if (!"AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED".equals(str)) {
                    return false;
                }
                Logger.m10999d(AutoFormat.TAG, "NextCallbackImpl#formattingManual");
                NormalFormat.this.mStructuredManualFormatter = new StructuredManualFormatter(this.mSelectedText);
                NormalFormat.this.mStructuredManualFormatter.registerCallback(new Operator.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.NormalFormat.NextCallbackImpl.1
                    @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                    public boolean onFailed(@NonNull String str2) {
                        return NextCallbackImpl.this.onFailed(str2);
                    }

                    @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
                    public void onRetry(Runnable runnable) {
                        NextCallbackImpl.this.onRetry(runnable);
                    }

                    @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                    public void onSuccess(@NonNull String str2, boolean z) {
                        NextCallbackImpl.this.onSuccess(str2, z);
                    }
                });
                NormalFormat.this.mStructuredManualFormatter.execute();
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.NormalFormat.CallbackImpl, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str, boolean z) {
                Logger.m10999d(AutoFormat.TAG, "NextCallbackImpl#onSuccess# (" + AutoFormat.this.mSrcContentInfo.getInputIndex() + "/" + AutoFormat.this.mSrcContentInfo.getInputList().size() + ")");
                NormalFormat normalFormat = NormalFormat.this;
                if (normalFormat.mStructuredFormatter == null) {
                    Logger.m10999d(AutoFormat.TAG, "onSuccess# is canceled");
                } else {
                    normalFormat.mStructuredFormatter = null;
                    normalFormat.onNextCompleted(str);
                }
            }
        }

        public NormalFormat() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void cancel() {
            StructuredAutoFormatter structuredAutoFormatter = this.mStructuredFormatter;
            if (structuredAutoFormatter != null) {
                structuredAutoFormatter.registerCallback(null);
                this.mStructuredFormatter = null;
            }
            StructuredManualFormatter structuredManualFormatter = this.mStructuredManualFormatter;
            if (structuredManualFormatter != null) {
                structuredManualFormatter.registerCallback(null);
                this.mStructuredManualFormatter = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void formatting(String str) {
            StructuredAutoFormatter structuredAutoFormatter = new StructuredAutoFormatter(str, StructuredAutoFormatter.Style.Note);
            this.mStructuredFormatter = structuredAutoFormatter;
            structuredAutoFormatter.registerCallback(new CallbackImpl(str));
            this.mStructuredFormatter.execute();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void initMerger(String str) {
            if (this.mStructuredAutoFormatMerger == null) {
                StructuredAutoFormatMerger structuredAutoFormatMerger = new StructuredAutoFormatMerger();
                this.mStructuredAutoFormatMerger = structuredAutoFormatMerger;
                structuredAutoFormatMerger.getResult(str);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public boolean isWaiting() {
            return this.mStructuredFormatter != null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public String mergeResult(@NonNull String str) {
            Logger.startTime(String.valueOf(hashCode()), AutoFormat.TAG, "merge start");
            String result = this.mStructuredAutoFormatMerger.getResult(str);
            Logger.endTime(String.valueOf(hashCode()), AutoFormat.TAG, "merge end");
            return result;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void nextFormatting(String str) {
            Logger.m10999d(AutoFormat.TAG, "nextFormatting#");
            StructuredAutoFormatter structuredAutoFormatter = new StructuredAutoFormatter(str, StructuredAutoFormatter.Style.Note);
            this.mStructuredFormatter = structuredAutoFormatter;
            structuredAutoFormatter.registerCallback(new NextCallbackImpl(str));
            this.mStructuredFormatter.execute();
            ResultListener resultListener = AutoFormat.this.mResultListener;
            if (resultListener != null) {
                resultListener.onProgressing();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.AbsFormat
        public void parseResult(String str) {
            AutoFormat.this.mServerResultParser = new ServerResultParser(str);
            AutoFormat.this.mServerResultParser.parse();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        void onFailed(@NonNull String str);

        void onNextCompleted(boolean z);

        void onProgressing();

        void onResult(boolean z);
    }

    public AutoFormat(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSrcContentInfo = srcContentInfo;
        srcContentInfo.setBGColorInverted(composerViewPresenter.getActivity(), composerViewPresenter.getComposerModel().getDoc());
        this.mResultNoteManager = new ResultNoteManager();
        divideInput();
        this.mStyleOrder = getLastStyleOrder();
    }

    private void applyNoteFontSize(SpenObjectTextBox spenObjectTextBox) {
        AiViewUtils.restoreDpFromSpFontSize(this.mComposerViewPresenter.getActivity(), spenObjectTextBox, this.mApplyFontSize.intValue() - AiViewUtils.getDefViewerFontSize(this.mComposerViewPresenter.getActivity()));
    }

    public static boolean checkLimitationAndSplit(Context context, SrcContentInfo srcContentInfo, Locale locale) {
        String selectedText = srcContentInfo.getSelectedText();
        if (isLimitedMinLength(context, selectedText, true)) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_HEADERS_AND_BULLETS, ComposerSA.getDetailAiSelectedTextLength(selectedText.length(), 10000));
            return false;
        }
        if (!CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            int i = AiMaxLength.LEN_SELECTED_MAX;
            if (selectedText.length() > i) {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_FOR_AUTO_FORMAT, ComposerSA.getDetailAiSelectedTextMaxLength(selectedText.length(), 2000, 1000, 8));
                Logger.m10999d(TAG, "checkLimitationAndSplit# over max: " + i);
                AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_reselect_maximum_characters));
                fixSelection(srcContentInfo, i);
                return false;
            }
        } else if (isLimitedCNMaxLength(context, selectedText, AiMaxLength.LEN_SELECTED_MAX)) {
            fixSelection(srcContentInfo, 1400);
            return false;
        }
        return true;
    }

    public static int checkMaxLimitation(Context context, String str, Locale locale) {
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            int i = AiMaxLength.LEN_SELECTED_MAX;
            if (isLimitedCNMaxLength(context, str, i)) {
                return i;
            }
            return 0;
        }
        int i2 = AiMaxLength.LEN_SELECTED_MAX;
        if (str.length() <= i2) {
            return 0;
        }
        Logger.m10999d(TAG, "checkLimitation# over max: " + i2);
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_reselect_maximum_characters));
        return i2;
    }

    private String convertOrderListToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    private void divideInput() {
        this.mSrcContentInfo.chunk(ChunkSizePolicy.builder().unitMinLength(200).unitMaxLength(getMaxLength(this.mSrcContentInfo.getSelectedText(), this.mLanguageIdentifier)).extraLength(500).build());
    }

    private static void fixSelection(SrcContentInfo srcContentInfo, int i) {
        if (srcContentInfo.mSrcType == 1) {
            srcContentInfo.mEndPos = srcContentInfo.mStartPos + i;
        }
        srcContentInfo.setSelectedText(TextUtil.subString(srcContentInfo.getSelectedText(), 0, i, true));
    }

    private SpenObjectTextBox getFormattedTarget(boolean z) {
        SpenObjectTextBox bodyText = this.mResultNoteManager.getOriginalFormattedNoteList().get(this.mLastSelectedStyle).getBodyText();
        if (z) {
            applyNoteFontSize(bodyText);
        }
        return bodyText;
    }

    private List<Integer> getLastStyleOrder() {
        ArrayList arrayList = new ArrayList();
        String string = SharedPreferencesCompat.getInstance("Composer").getString(getSharedPreferenceString(this.mCurrentFormatType), "01234");
        String str = TextUtils.isEmpty(string) ? "01234" : string;
        Logger.m10999d(TAG, "getLastStyleOrder# " + str);
        for (int length = str.length() + (-1); length >= 0; length--) {
            arrayList.add(Integer.valueOf(Integer.parseInt(String.valueOf(str.charAt(length)))));
        }
        return arrayList;
    }

    public static int getMaxLength(String str, LanguageIdentifier languageIdentifier) {
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            return 1400;
        }
        int length = str.length();
        if (length <= 1000 || languageIdentifier == null) {
            return 1000;
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

    private String getSharedPreferenceString(FormatType formatType) {
        return FormatType.Normal.equals(formatType) ? SharedPreferencesConstants.AUTO_FORMAT_MULTI_LEVEL_STYLE_ORDER : FormatType.Meeting.equals(formatType) ? SharedPreferencesConstants.AUTO_FORMAT_MEETING_STYLE_ORDER : "";
    }

    private static boolean isLimitedCNMaxLength(Context context, @NonNull String str, int i) {
        if (str.length() <= i) {
            return false;
        }
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_cant_auto_format_text_with_more_than));
        return true;
    }

    public static boolean isLimitedMinLength(Context context, @NonNull String str, boolean z) {
        if (str.trim().length() >= 200) {
            return false;
        }
        if (!z) {
            return true;
        }
        AiCommonUtil.showCustomToast(context, context.getResources().getQuantityString(C9086R.plurals.ai_error_cant_auto_format_text_with_fewer_than_pd_characters, 200, 200));
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox formattedTarget = getFormattedTarget(true);
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
                resultOperation.insertToBottom(this.mComposerViewPresenter, this.mSrcContentInfo, formattedTarget);
                return;
            } else {
                resultOperation.insertNewPageEndOfNote(this.mComposerViewPresenter, this.mSrcContentInfo, formattedTarget);
                return;
            }
        }
        if (ResultOperation.AddTo.NewPageBefore == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            resultOperation.removeLastEmptyLinefeed(formattedTarget);
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, this.mSrcContentInfo, formattedTarget);
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            resultOperation.addToNewNote(this.mComposerViewPresenter, formattedTarget);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        SpenObjectTextBox formattedTarget;
        return (this.mResultNoteManager.getFormattedNoteList().isEmpty() || (formattedTarget = getFormattedTarget(false)) == null || formattedTarget.getText().isEmpty()) ? false : true;
    }

    public ErrorType canExecute() {
        if (isLimitedMinLength(null, this.mSrcContentInfo.getSelectedText(), false)) {
            return ErrorType.MINIMUM;
        }
        return null;
    }

    public void cancel() {
        AbsFormat absFormat = this.mAbsFormat;
        if (absFormat != null) {
            absFormat.cancel();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void clearResultNote() {
        this.mResultNoteManager.clear();
    }

    public void clearResultText() {
        Logger.m10999d(TAG, "clearResultText#");
        this.mResultNoteManager.clearResultText();
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
        AbsFormat absFormat = this.mAbsFormat;
        if (absFormat != null) {
            absFormat.cancel();
        }
        formatting(this.mSrcContentInfo.getNextInput(), this.mCurrentFormatType);
        if (this.mApplyFontSize == null) {
            this.mApplyFontSize = Integer.valueOf(AiViewUtils.getDefApplyFontSize(this.mComposerViewPresenter.getDoc().getBodyText(), this.mSrcContentInfo));
        }
    }

    public void formatting(String str, FormatType formatType) {
        Logger.m10999d(TAG, "formatting# " + formatType);
        this.mLastErrorMessage = null;
        if (formatType.equals(FormatType.Meeting)) {
            this.mAbsFormat = new MeetingFormat();
        } else if (formatType.equals(FormatType.Manual)) {
            this.mAbsFormat = new ManualFormat();
        } else {
            this.mAbsFormat = new NormalFormat();
        }
        this.mAbsFormat.formatting(UnicodeUtils.removeObjectReplacementChar(str));
    }

    public FormatType getCurrentFormatType() {
        return this.mCurrentFormatType;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return this.mCurrentFormatType == FormatType.Meeting ? "b" : "a";
    }

    public String getErrorMessage(String str) {
        return str.isEmpty() ? "unexpected error" : "SAFE_FILTER_ERROR_CHILD".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_child_auto_fortmat) : "SAFE_FILTER_ERROR_RECITATION".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_recitation_auto_format) : "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_unsupported_language_auto_format) : "SAFE_FILTER_ERROR_CHN_SENSITIVE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_chn_sensitive_auto_fortmat) : "SAFE_FILTER_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_ai_error_msg_safety_filter_in_other_cases_auto_format) : "NETWORK_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_network_connection_error_msg) : ("INTERNAL_SERVER_ERROR".equals(str) || "UNEXPECTED_ERROR".equals(str)) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_something_went_wrong) : str;
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

    public SpenWNote getOriginalResultNote(int i) {
        if (this.mResultNoteManager.getOriginalFormattedNoteList().isEmpty()) {
            Logger.m11000e(TAG, "getOriginalResultNote# list is empty");
            return null;
        }
        if (this.mResultNoteManager.getOriginalFormattedNoteList().size() > i) {
            return this.mResultNoteManager.getOriginalFormattedNoteList().get(i);
        }
        Logger.m11000e(TAG, "getOriginalResultNote# list size is small: " + this.mResultNoteManager.getFormattedNoteList().size() + "/" + i);
        return null;
    }

    @Nullable
    public SpenWNote getResultNote(int i) {
        if (this.mResultNoteManager.getFormattedNoteList().isEmpty()) {
            Logger.m11000e(TAG, "getResultNote# list is empty");
            return null;
        }
        if (this.mResultNoteManager.getFormattedNoteList().size() > i) {
            return this.mResultNoteManager.getFormattedNoteList().get(i);
        }
        Logger.m11000e(TAG, "getResultNote# list size is small: " + this.mResultNoteManager.getFormattedNoteList().size() + "/" + i);
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(getFormattedTarget(false));
        applyNoteFontSize(newSpenObjectTextBox);
        return newSpenObjectTextBox;
    }

    public int getSelectionMaxLength(int i) {
        try {
            return this.mResultNoteManager.getResultNoteList().get(i).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return this.mSrcContentInfo;
    }

    public List<Integer> getStyleOrder() {
        return this.mStyleOrder;
    }

    public SpenWNote getTextOriginNote() {
        return this.mResultNoteManager.getOriginNote();
    }

    public boolean hasNext() {
        return this.mSrcContentInfo.hasNextInputUnit();
    }

    public boolean hasResult() {
        if (isWaiting()) {
            return false;
        }
        return this.mResultNoteManager.hasResult();
    }

    public boolean isRestore() {
        return this.mIsRestore;
    }

    public boolean isWaiting() {
        AbsFormat absFormat = this.mAbsFormat;
        return absFormat != null && absFormat.isWaiting();
    }

    public void makeOriginNote() {
        ResultNoteManager resultNoteManager = this.mResultNoteManager;
        Activity activity = this.mComposerViewPresenter.getActivity();
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        SrcContentInfo srcContentInfo = this.mSrcContentInfo;
        resultNoteManager.initOriginNote(activity, doc, srcContentInfo.mStartPos, srcContentInfo.mEndPos);
        AiViewUtils.applyDefViewerSpFontSizeAll(this.mComposerViewPresenter.getActivity(), getTextOriginNote().getBodyText());
        AiViewUtils.setResultTextBoxState(getTextOriginNote().getBodyText());
        if (this.mOriginalTextSpanList == null) {
            this.mOriginalTextSpanList = this.mResultNoteManager.getOriginNote().getBodyText().getTextSpan();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (!TextUtils.isEmpty(this.mLastErrorMessage)) {
            Logger.m11000e(TAG, "onSaveInstanceState# failed state");
            return;
        }
        this.mResultNoteManager.onSaveInstanceState(bundle);
        FormatType formatType = this.mPreFormatType;
        if (formatType != null) {
            this.mCurrentFormatType = formatType;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
        this.mSrcContentInfo.setConvertibleColor(true);
        ResultOperation resultOperation = new ResultOperation();
        int i = this.mSrcContentInfo.mSrcType;
        if (i == 2 || i == 0) {
            resultOperation.insert(this.mComposerViewPresenter, getFormattedTarget(true), this.mSrcContentInfo.mStartPos);
        } else {
            resultOperation.overwrite(this.mComposerViewPresenter, getFormattedTarget(true), this.mSrcContentInfo);
        }
    }

    public void resetPreFormatType() {
        this.mPreFormatType = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        this.mSrcContentInfo = srcContentInfo;
        this.mAbsFormat = null;
        this.mIsRestore = true;
        this.mResultNoteManager.restore(bundle, this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getDoc(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AutoFormat.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(AutoFormat.TAG, "restoreState# execute e:" + AutoFormat.this.mErrorType);
                AutoFormat autoFormat = AutoFormat.this;
                if (autoFormat.mErrorType == null) {
                    autoFormat.execute();
                }
            }
        });
    }

    public boolean setCurrentFormatType(FormatType formatType) {
        if (this.mCurrentFormatType.equals(formatType)) {
            return false;
        }
        this.mPreFormatType = this.mCurrentFormatType;
        this.mCurrentFormatType = formatType;
        this.mSrcContentInfo.setInputIndex(0);
        return true;
    }

    public void setErrorType(ErrorType errorType) {
        Logger.m10999d(TAG, "setErrorType# " + errorType);
        this.mErrorType = errorType;
    }

    public void setResultListener(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public void setSelectedStyle(int i) {
        this.mLastSelectedStyle = i;
        List<Integer> lastStyleOrder = getLastStyleOrder();
        lastStyleOrder.remove(Integer.valueOf(i));
        lastStyleOrder.add(0, Integer.valueOf(i));
        String strConvertOrderListToString = convertOrderListToString(lastStyleOrder);
        SharedPreferencesCompat.getInstance("Composer").edit().putString(getSharedPreferenceString(this.mCurrentFormatType), strConvertOrderListToString).apply();
        AbstractC8014b.m7196B("setSelectedStyle# ", strConvertOrderListToString, TAG);
    }
}
