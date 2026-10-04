package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiOnDeviceMemoryManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.ChunkSizePolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObjectType;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.utils.MarkdownTableParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.assist.llm.NeuralTranslator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Translation implements AiMenuContract.IAiAction {
    public static final int LANGUAGE_STATE_AVAILABLE = 0;
    public static final int LANGUAGE_STATE_NOT_DOWNLOADED = 1;
    public static final int LANGUAGE_STATE_NOT_SUPPORTED = 2;
    private static final String TAG = Logger.createTag("Translation", AiConstants.PREFIX_TAG);
    ComposerViewPresenter mComposerViewPresenter;
    private ErrorType mErrorType;
    String mFromLanguageTag;
    private boolean mIsHintShown;
    boolean mIsWaitingFirstResult;
    LanguageIdentifier mLanguageIdentifier;
    LanguageIdentifyCallback mLanguageIdentifyCallback;
    private String mLastErrorMessage;
    SpenWNote mOriginalNote;
    String mOriginalText;
    AiMenuContract.ResultListener mResultListener;
    SpenWNote mResultNote;
    SrcContentInfo mSrcContentInfo;
    String mToLanguageTag;
    String mTranslatedText;
    NeuralTranslator mTranslator;
    boolean mIsFirstResult = true;
    boolean mIsCompleted = true;
    private boolean mIsFistTime = true;
    Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorType {
        MINIMUM(C9086R.string.ai_error_can_not_find_any_text),
        UNSUPPORTED_LANGUAGE(C9086R.string.ai_not_supported_from_language);

        final int mMsgRes;

        ErrorType(int i) {
            this.mMsgRes = i;
        }

        public String getMsg(Context context) {
            return context.getResources().getString(this.mMsgRes);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LanguageIdentifyCallback {
        void onComplete();
    }

    public Translation(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSrcContentInfo = srcContentInfo;
        initOriginalText();
    }

    private void fallback(String str, List<MarkdownTableParser.TableInfo> list, String str2) {
        Logger.m11000e(TAG, "fallback# " + str2);
        SpenObjectTextBox spenObjectTextBoxMakeTextBox = makeTextBox(MarkdownTableParser.replaceTablesWithPlaceholder(str, list));
        AiViewUtils.setResultTextBoxState(spenObjectTextBoxMakeTextBox);
        this.mResultNote.getBodyText().copy(spenObjectTextBoxMakeTextBox);
    }

    private List<SpenObjectSpan> filterSpanObjectList(List<SpenObjectSpan> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (SpenObjectSpan spenObjectSpan : list) {
            SpenObjectBase obj = spenObjectSpan.getObj();
            if (obj != null && ResolvableSpanObjectType.INSTANCE.from(obj.getType()) != ResolvableSpanObjectType.OTHER) {
                arrayList.add(spenObjectSpan);
            }
        }
        list.sort(Comparator.comparing(new C9461f(1)));
        return arrayList;
    }

    private String getDefaultLanguageTag() {
        return Locale.getDefault().toLanguageTag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLastLanguageTag() {
        return SharedPreferencesCompat.getInstance("Composer").getString(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_LANGUAGE, getDefaultLanguageTag());
    }

    private int getTextLength(SpenObjectTextBox spenObjectTextBox) {
        String text = spenObjectTextBox.getText();
        if (text == null) {
            return 0;
        }
        return text.length();
    }

    private SpenWNote makeInitialNote() {
        SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getDoc());
        if (spenWNoteMakeNote != null) {
            return spenWNoteMakeNote;
        }
        Logger.m11000e(TAG, "makeNote# note is null");
        return null;
    }

    private SpenObjectTextBox makeTextBox(String str) {
        SpenObjectTextBox newBodyText = this.mComposerViewPresenter.getObjectManager().getNewBodyText();
        newBodyText.setTextAlignment(Alignment.getDefaultAlign());
        newBodyText.setFontSize(14);
        newBodyText.insertText(str, newBodyText.getText().length());
        return newBodyText;
    }

    public static boolean preCheck(String str) {
        if (str.length() > 1000) {
            str = str.substring(0, 1000);
        }
        Locale localeIdentifyLanguageSync = new LanguageIdentifier().identifyLanguageSync(str);
        return AiLanguageHelper.isDownloadedLanguage(localeIdentifyLanguageSync) || AiLanguageHelper.isDownloadableLanguage(localeIdentifyLanguageSync);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setAlignmentParagraph(SpenObjectTextBox spenObjectTextBox) {
        int i;
        String strConvertToScsLanguage = AiLanguageHelper.convertToScsLanguage(this.mToLanguageTag);
        int i2 = 0;
        if (strConvertToScsLanguage != null) {
            i = TextUtils.getLayoutDirectionFromLocale(new Locale(strConvertToScsLanguage)) != 1 ? 0 : 1;
        }
        spenObjectTextBox.setText(this.mTranslatedText);
        setDefApplyFontSizeAll(spenObjectTextBox);
        int length = this.mTranslatedText.split("\n").length;
        while (i2 < length) {
            int i4 = i2 + 1;
            spenObjectTextBox.appendTextParagraph(new SpenAlignmentParagraph(i2, i4, i));
            i2 = i4;
        }
    }

    private void setDefApplyFontSizeAll(SpenObjectTextBox spenObjectTextBox) {
        SpenWNote doc = this.mSrcContentInfo.mSrcNote;
        if (doc == null) {
            doc = this.mComposerViewPresenter.getDoc();
        }
        AiViewUtils.setDefApplyFontSizeAll(doc.getBodyText(), spenObjectTextBox, this.mSrcContentInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        setAlignmentParagraph(newSpenObjectTextBox);
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
                resultOperation.insertToBottom(this.mComposerViewPresenter, this.mSrcContentInfo, newSpenObjectTextBox);
                return;
            } else {
                resultOperation.insertNewPageEndOfNote(this.mComposerViewPresenter, this.mSrcContentInfo, newSpenObjectTextBox);
                return;
            }
        }
        if (ResultOperation.AddTo.NewPageBefore == addTo) {
            this.mSrcContentInfo.setConvertibleColor(true);
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, this.mSrcContentInfo, newSpenObjectTextBox);
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            resultOperation.addToNewNote(this.mComposerViewPresenter, newSpenObjectTextBox);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        return !TextUtils.isEmpty(this.mTranslatedText);
    }

    public ErrorType canExecute() {
        if (TextUtils.isEmpty(getSelectText())) {
            return ErrorType.MINIMUM;
        }
        if (preCheck(getSelectText())) {
            return null;
        }
        return ErrorType.UNSUPPORTED_LANGUAGE;
    }

    public void cancel(boolean z) {
        NeuralTranslator neuralTranslator = this.mTranslator;
        if (neuralTranslator != null) {
            neuralTranslator.release();
            this.mTranslator = null;
            if (z) {
                AiOnDeviceMemoryManager.getInstance().release(hashCode(), TAG);
            }
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void clear() {
        Logger.m10999d(TAG, "clear# ");
        cancel(true);
        setResultListener(null);
        setLanguageIdentifierCallback(null);
        LanguageIdentifier languageIdentifier = this.mLanguageIdentifier;
        if (languageIdentifier != null) {
            languageIdentifier.release();
        }
        this.mLanguageIdentifier = null;
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
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        if (TextUtils.isEmpty(this.mTranslatedText)) {
            Logger.m10999d(TAG, "copy# fail : empty text");
            return;
        }
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(this.mTranslatedText);
        setAlignmentParagraph(newSpenObjectTextBox);
        setDefApplyFontSizeAll(newSpenObjectTextBox);
        resultOperation.setShouldRemoveTableOnOverwrite(true);
        resultOperation.copy(this.mComposerViewPresenter, newSpenObjectTextBox);
    }

    public void copyOriginNoteToResultNote() {
        if (this.mResultNote == null) {
            SpenWNote spenWNoteMakeInitialNote = makeInitialNote();
            this.mResultNote = spenWNoteMakeInitialNote;
            if (spenWNoteMakeInitialNote == null) {
                return;
            }
        }
        makeOriginNote();
        if (this.mOriginalNote != null) {
            this.mResultNote.getBodyText().copy(this.mOriginalNote.getBodyText());
        }
    }

    public void execute() {
        Logger.m10999d(TAG, "execute# ");
        updateOriginalText();
        this.mLastErrorMessage = null;
        identifyLanguage();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "f";
    }

    public ErrorType getErrorType() {
        return this.mErrorType;
    }

    public int getFromLanguageState() {
        Locale locale = AiLanguageHelper.getLocale(this.mFromLanguageTag);
        if (AiLanguageHelper.isDownloadedLanguage(locale)) {
            return 0;
        }
        return AiLanguageHelper.isDownloadableLanguage(locale) ? 1 : 2;
    }

    public String getFromLanguageTag() {
        return this.mFromLanguageTag;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public String getLastErrorMessage() {
        return this.mLastErrorMessage;
    }

    public SpenWNote getOriginalNote() {
        return this.mOriginalNote;
    }

    public String getOriginalText() {
        return TextUtils.isEmpty(this.mOriginalText) ? getSelectText() : this.mOriginalText;
    }

    public SpenWNote getResultNote() {
        return this.mResultNote;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(this.mTranslatedText);
        return newSpenObjectTextBox;
    }

    public String getSelectText() {
        return this.mSrcContentInfo.getSelectedText();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return this.mSrcContentInfo;
    }

    public int getToLanguageState() {
        if (isSame()) {
            return 2;
        }
        if (AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mFromLanguageTag), AiLanguageHelper.getLocale(this.mToLanguageTag), false)) {
            return 0;
        }
        return AiLanguageHelper.isDownloadableLanguage(AiLanguageHelper.getLocale(this.mToLanguageTag)) ? 1 : 2;
    }

    public String getToLanguageTag() {
        return this.mToLanguageTag;
    }

    public String getTranslatedText() {
        return this.mTranslatedText;
    }

    public void identifyLanguage() {
        LanguageIdentifier languageIdentifier = new LanguageIdentifier();
        this.mLanguageIdentifier = languageIdentifier;
        languageIdentifier.identifyLanguage(this.mOriginalText, new LanguageIdentifier.AsyncCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Translation.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.AsyncCallback
            public void onCompleted(Locale locale) {
                boolean z;
                Logger.m10999d(Translation.TAG, "execute#identifyLanguage# identifiedLocale " + locale);
                Locale locale2 = AiLanguageHelper.getLocale(locale.toLanguageTag());
                if (locale2 == null) {
                    Logger.m11000e(Translation.TAG, "execute#identifyLanguage# unexpected error");
                    Translation.this.mFromLanguageTag = locale.toLanguageTag();
                } else {
                    Translation.this.mFromLanguageTag = locale2.toLanguageTag();
                }
                AbstractC8014b.m7213o(new StringBuilder("execute#identifyLanguage# mFromLanguageTag "), Translation.this.mFromLanguageTag, Translation.TAG);
                boolean z2 = false;
                if (AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(Translation.this.mFromLanguageTag))) {
                    z = true;
                } else {
                    Logger.m10999d(Translation.TAG, "execute#identifyLanguage#from not supported");
                    z = false;
                }
                Translation translation = Translation.this;
                translation.mToLanguageTag = translation.getLastLanguageTag();
                AbstractC8014b.m7213o(new StringBuilder("execute#identifyLanguage#to: "), Translation.this.mToLanguageTag, Translation.TAG);
                if (!AiLanguageHelper.isDownloadedLanguage(locale, AiLanguageHelper.getLocale(Translation.this.mToLanguageTag), false)) {
                    Logger.m10999d(Translation.TAG, "execute#identifyLanguage#to not supported");
                    z = false;
                }
                if (Translation.this.isSame()) {
                    Logger.m10999d(Translation.TAG, "execute#identifyLanguage#to from and to is same");
                } else {
                    z2 = z;
                }
                if (z2) {
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_TRANSLATE, "a");
                    Translation translation2 = Translation.this;
                    String originalText = translation2.getOriginalText();
                    Translation translation3 = Translation.this;
                    translation2.translate(originalText, translation3.mFromLanguageTag, translation3.mToLanguageTag);
                }
                LanguageIdentifyCallback languageIdentifyCallback = Translation.this.mLanguageIdentifyCallback;
                if (languageIdentifyCallback != null) {
                    languageIdentifyCallback.onComplete();
                    Translation.this.mLanguageIdentifyCallback = null;
                }
                Translation.this.mLanguageIdentifier = null;
            }
        });
    }

    public void initOriginalText() {
        this.mSrcContentInfo.chunk(ChunkSizePolicy.builder().unitMinLength(200).unitMaxLength(10000).extraLength(500).build());
        StringBuilder sb = new StringBuilder();
        while (this.mSrcContentInfo.hasNextInputUnit()) {
            sb.append(this.mSrcContentInfo.getNextResolvedInput());
        }
        this.mOriginalText = sb.toString();
    }

    public boolean isCompleted() {
        return this.mIsCompleted;
    }

    public boolean isFirstResult() {
        return this.mIsFirstResult;
    }

    public boolean isFistTime() {
        return this.mIsFistTime;
    }

    public boolean isHintShown() {
        return this.mIsHintShown;
    }

    public boolean isSame() {
        Locale locale;
        if (TextUtils.isEmpty(this.mFromLanguageTag) || (locale = AiLanguageHelper.getLocale(this.mFromLanguageTag)) == null) {
            return false;
        }
        if (AiLanguageHelper.isSeperateLanguagePack(locale.getLanguage())) {
            return this.mFromLanguageTag.equals(this.mToLanguageTag);
        }
        Locale locale2 = AiLanguageHelper.getLocale(this.mToLanguageTag);
        if (locale2 == null) {
            return false;
        }
        return AiLanguageHelper.convertSpecificLanguage(locale.getLanguage()).equals(AiLanguageHelper.convertSpecificLanguage(locale2.getLanguage()));
    }

    public boolean isWaitingFirstResult() {
        return this.mIsWaitingFirstResult || isWaitingIdentifyLanguage();
    }

    public boolean isWaitingIdentifyLanguage() {
        return this.mLanguageIdentifier != null;
    }

    public void makeOriginNote() {
        if (this.mOriginalNote != null) {
            Logger.m10999d(TAG, "makeOriginNote# already created");
            return;
        }
        SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mSrcContentInfo.mSrcNote);
        this.mOriginalNote = spenWNoteMakeNote;
        if (spenWNoteMakeNote == null) {
            Logger.m11000e(TAG, "makeOriginNote# mOriginalNote is null");
            return;
        }
        this.mOriginalNote.getBodyText().copyText(this.mSrcContentInfo.mSrcNote.getBodyText(), this.mSrcContentInfo.mStartPos, Math.min(this.mSrcContentInfo.mEndPos - 1, r0.getText().length() - 1));
        AiViewUtils.setResultTextBoxState(this.mOriginalNote.getBodyText());
        AiViewUtils.changeFontSize(this.mOriginalNote.getBodyText(), 14);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (!TextUtils.isEmpty(this.mLastErrorMessage)) {
            Logger.m11000e(TAG, "onSaveInstanceState# failed state");
            return;
        }
        boolean zIsCompleted = isCompleted();
        String str = TAG;
        AbstractC8014b.m7220v("onSaveInstanceState# ", str, zIsCompleted);
        bundle.putBoolean(str, zIsCompleted);
        if (zIsCompleted) {
            Logger.m10999d(str, "onSaveInstanceState# completed");
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
        this.mSrcContentInfo.setConvertibleColor(true);
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(this.mTranslatedText);
        setAlignmentParagraph(newSpenObjectTextBox);
        setDefApplyFontSizeAll(newSpenObjectTextBox);
        resultOperation.setShouldRemoveTableOnOverwrite(true);
        resultOperation.overwrite(this.mComposerViewPresenter, newSpenObjectTextBox, this.mSrcContentInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        String str = TAG;
        if (bundle.containsKey(str)) {
            boolean z = bundle.getBoolean(str);
            AbstractC8014b.m7220v("restore# ", str, z);
            this.mSrcContentInfo = srcContentInfo;
            if (z) {
                return;
            }
            execute();
        }
    }

    public void setErrorType(ErrorType errorType) {
        Logger.m10999d(TAG, "setErrorType# " + errorType);
        this.mErrorType = errorType;
    }

    public void setFirstResult(boolean z) {
        this.mIsFirstResult = z;
    }

    public void setFromLanguageTag(String str) {
        this.mFromLanguageTag = str;
    }

    public void setHint(String str) {
        if (this.mResultNote == null) {
            SpenWNote spenWNoteMakeInitialNote = makeInitialNote();
            this.mResultNote = spenWNoteMakeInitialNote;
            if (spenWNoteMakeInitialNote == null) {
                return;
            }
        }
        if (str != null && !str.isEmpty()) {
            this.mResultNote.getBodyText().copy(makeTextBox(str));
        }
        this.mIsHintShown = true;
    }

    public void setIsFistTime(boolean z) {
        this.mIsFistTime = z;
    }

    public void setLanguageIdentifierCallback(LanguageIdentifyCallback languageIdentifyCallback) {
        this.mLanguageIdentifyCallback = languageIdentifyCallback;
    }

    public void setLastLanguage(String str) {
        Locale locale;
        if (TextUtils.isEmpty(str) || (locale = AiLanguageHelper.getLocale(str)) == null) {
            return;
        }
        SharedPreferencesCompat.getInstance("Composer").putString(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_LANGUAGE, locale.toLanguageTag());
    }

    public void setResultListener(AiMenuContract.ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public void setToLanguageTag(String str) {
        this.mToLanguageTag = str;
        setLastLanguage(str);
    }

    public void setTranslatedText(String str) {
        this.mTranslatedText = str;
    }

    public void switchLanguageTag() {
        String str = this.mFromLanguageTag;
        this.mFromLanguageTag = this.mToLanguageTag;
        this.mToLanguageTag = str;
        String str2 = this.mTranslatedText;
        this.mTranslatedText = this.mOriginalText;
        this.mOriginalText = str2;
    }

    public void translate(String str, String str2, String str3) {
        String str4 = TAG;
        Logger.m10999d(str4, "translate# " + str2 + " - " + str3);
        if (TextUtils.isEmpty(str3)) {
            str3 = getLastLanguageTag();
        } else {
            setLastLanguage(str3);
        }
        AiOnDeviceMemoryManager.getInstance().ready(hashCode(), str4);
        if (this.mTranslator != null) {
            cancel(false);
        }
        SpenWNote spenWNote = this.mResultNote;
        if (spenWNote != null && spenWNote.getBodyText().getText() != null) {
            this.mResultNote.getBodyText().removeAllText();
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_SOURCE, str2);
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_TARGET, str3);
        NeuralTranslator neuralTranslator = new NeuralTranslator(str, str2, str3);
        this.mTranslator = neuralTranslator;
        neuralTranslator.registerCallback(new NeuralTranslator.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Translation.2
            @Override // com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.Callback
            public void onFailed(@NonNull final String str5) {
                AiOnDeviceMemoryManager.getInstance().release(Translation.this.hashCode(), Translation.TAG);
                Translation translation = Translation.this;
                translation.mIsWaitingFirstResult = false;
                translation.mIsCompleted = true;
                translation.mLastErrorMessage = str5;
                Translation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Translation.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuContract.ResultListener resultListener = Translation.this.mResultListener;
                        if (resultListener != null) {
                            resultListener.onFailed(str5);
                        }
                        Translation.this.mIsFirstResult = false;
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.Callback
            public void onSuccess(@NonNull String str5, @NonNull String str6, @NonNull String str7, final boolean z) {
                String str8 = Translation.TAG;
                StringBuilder sbM3200j = AbstractC4539a.m3200j("translate#onSuccess ", "| len: ", z);
                sbM3200j.append(str5.length());
                sbM3200j.append(" ");
                sbM3200j.append(str6);
                sbM3200j.append(":");
                AbstractC8014b.m7213o(sbM3200j, str7, str8);
                if (Translation.this.mIsCompleted) {
                    AiOnDeviceMemoryManager.getInstance().release(Translation.this.hashCode(), Translation.TAG);
                }
                Translation translation = Translation.this;
                translation.mIsWaitingFirstResult = false;
                translation.mIsCompleted = z;
                translation.mTranslatedText = str5;
                translation.mFromLanguageTag = str6;
                translation.mToLanguageTag = str7;
                translation.setLastLanguage(str7);
                Translation.this.updateResultNote();
                Translation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Translation.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuContract.ResultListener resultListener = Translation.this.mResultListener;
                        if (resultListener != null) {
                            resultListener.onCompleted(z);
                        }
                        Translation.this.mIsFirstResult = false;
                    }
                });
            }
        });
        this.mIsCompleted = false;
        this.mIsWaitingFirstResult = true;
        this.mIsFirstResult = true;
        this.mTranslator.execute();
    }

    public void updateOriginalNote() {
        if (this.mOriginalNote == null) {
            SpenWNote spenWNoteMakeInitialNote = makeInitialNote();
            this.mOriginalNote = spenWNoteMakeInitialNote;
            if (spenWNoteMakeInitialNote == null) {
                return;
            }
        }
        this.mOriginalNote.getBodyText().copy(makeTextBox(this.mOriginalText));
    }

    public void updateOriginalText() {
        if (this.mSrcContentInfo.hasDirty()) {
            this.mSrcContentInfo.setDirty(false);
            this.mOriginalText = getSelectText();
        }
    }

    public void updateResultNote() {
        if (this.mResultNote == null) {
            SpenWNote spenWNoteMakeInitialNote = makeInitialNote();
            this.mResultNote = spenWNoteMakeInitialNote;
            if (spenWNoteMakeInitialNote == null) {
                return;
            }
        }
        this.mIsHintShown = false;
        String str = this.mTranslatedText;
        SpenObjectTextBox newBodyText = this.mComposerViewPresenter.getObjectManager().getNewBodyText();
        SpenWNote spenWNote = this.mOriginalNote;
        if (spenWNote != null) {
            newBodyText.copy(spenWNote.getBodyText());
        }
        List<SpenObjectSpan> listFilterSpanObjectList = filterSpanObjectList(newBodyText.findObjectSpan(0, newBodyText.getText().length()));
        List<MarkdownTableParser.TableInfo> listExtractTables = MarkdownTableParser.extractTables(str);
        if (listFilterSpanObjectList.size() != listExtractTables.size()) {
            fallback(str, listExtractTables, "the number of tables not match - " + listFilterSpanObjectList.size() + SQLKeyword.COMMA + listExtractTables.size());
            return;
        }
        int size = listFilterSpanObjectList.size();
        for (int i = 0; i < size; i++) {
            SpenObjectTable spenObjectTable = (SpenObjectTable) listFilterSpanObjectList.get(i).getObj();
            MarkdownTableParser.TableInfo tableInfo = listExtractTables.get(i);
            if (spenObjectTable.getRowsCount() != tableInfo.getRowCount() || spenObjectTable.getColumnsCount() != tableInfo.getColumnCount()) {
                fallback(str, listExtractTables, "table shape not match - " + spenObjectTable.getRowsCount() + SQLKeyword.COMMA + spenObjectTable.getColumnsCount() + " / " + tableInfo.getRowCount() + SQLKeyword.COMMA + tableInfo.getColumnCount());
                return;
            }
        }
        SpenObjectTextBox bodyText = this.mResultNote.getBodyText();
        bodyText.setFontSize(14.0f);
        if (size != 0) {
            int end = 0;
            for (int i2 = 0; i2 < size; i2++) {
                SpenObjectTable spenObjectTable2 = (SpenObjectTable) listFilterSpanObjectList.get(i2).getObj();
                MarkdownTableParser.TableInfo tableInfo2 = listExtractTables.get(i2);
                String strSubstring = str.substring(end, tableInfo2.getStart());
                if (!strSubstring.isEmpty()) {
                    bodyText.insertText(strSubstring, getTextLength(bodyText));
                }
                end = tableInfo2.getEnd();
                for (int i4 = 0; i4 < spenObjectTable2.getRowsCount(); i4++) {
                    for (int i5 = 0; i5 < spenObjectTable2.getColumnsCount(); i5++) {
                        SpenObjectTextBox contentObject = spenObjectTable2.getContentObject(i4, i5);
                        contentObject.setText(tableInfo2.getCells().get(i4).get(i5));
                        spenObjectTable2.setContentText(contentObject, i4, i5);
                    }
                }
                bodyText.appendObjectSpan(new SpenObjectSpan(spenObjectTable2, getTextLength(bodyText)));
            }
            String strSubstring2 = str.substring(end);
            if (!strSubstring2.isEmpty()) {
                bodyText.insertText(strSubstring2, getTextLength(bodyText));
            }
        } else if (bodyText.getText() == null) {
            bodyText.setText(str);
        } else if (bodyText.getText().length() < this.mTranslatedText.length() - 1) {
            bodyText.insertText(this.mTranslatedText.substring(bodyText.getText().length(), this.mTranslatedText.length() - 1), bodyText.getText().length());
        }
        bodyText.setMargin(bodyText.getLeftMargin(), 12.0f, bodyText.getRightMargin(), bodyText.getBottomMargin());
        String strConvertToScsLanguage = AiLanguageHelper.convertToScsLanguage(this.mToLanguageTag);
        if (strConvertToScsLanguage != null) {
            bodyText.setTextAlignment(TextUtils.getLayoutDirectionFromLocale(new Locale(strConvertToScsLanguage)) == 1 ? 1 : 0);
        }
    }

    public SpenObjectTextBox getResultToCopy(String str) {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.setText(str);
        return newSpenObjectTextBox;
    }
}
