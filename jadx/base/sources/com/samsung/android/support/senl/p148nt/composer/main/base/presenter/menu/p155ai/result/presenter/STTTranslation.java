package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiOnDeviceMemoryManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerSpenWNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.model.assist.llm.NeuralTranslator;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class STTTranslation implements AiMenuContract.IAiAction {
    static final int MAX_LENGTH_IDENTIFY_TEXT = 500;
    private static final String TAG = Logger.createTag("STTTranslation", AiConstants.PREFIX_TAG);
    ComposerViewPresenter mComposerViewPresenter;
    String mFromLanguageTag;
    protected ISTTWindow.IAIContract mIAiSTTContract;
    boolean mIsWaitingFirstResult;
    LanguageIdentifier mLanguageIdentifier;
    LanguageIdentifyCallback mLanguageIdentifyCallback;
    protected String mLastErrorMessage;
    AiMenuContract.STTTranslateResultListener mResultListener;
    String mToLanguageTag;
    List<AiTextData> mTranslatedList;
    protected boolean mIsCompleted = false;
    Handler mHandler = new Handler(Looper.getMainLooper());
    AtomicInteger mTranslateCount = new AtomicInteger();
    private boolean mIsTranslateMode = false;
    ArrayList<NeuralTranslator> mTranslatorList = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LanguageIdentifyCallback {
        void onComplete();
    }

    public STTTranslation(ComposerViewPresenter composerViewPresenter, ISTTWindow.IAIContract iAIContract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mIAiSTTContract = iAIContract;
    }

    private String getDefaultLanguageTag() {
        return Locale.getDefault().toLanguageTag();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        ResultOperation resultOperation = new ResultOperation();
        String currentVoiceItemText = getCurrentVoiceItemText();
        if (TextUtils.isEmpty(currentVoiceItemText)) {
            return;
        }
        SpenObjectTextBox newTextBox = this.mComposerViewPresenter.getObjectManager().getNewTextBox();
        newTextBox.setText(currentVoiceItemText);
        AiViewUtils.applySmartAlignment(newTextBox, currentVoiceItemText);
        ComposerSpenWNoteUtils.removeFontSizeSpan(newTextBox);
        int value = new BodyTextFontSize(this.mComposerViewPresenter.getTextManager().getFontSizeDelta()).getValue();
        SrcContentInfo srcContentInfo = new SrcContentInfo("");
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            srcContentInfo.setConvertibleColor(true);
            ComposerSpenWNoteUtils.changeFontSizeSpan(newTextBox, ComposerSpenWNoteUtils.getLastCursorFontSize(this.mComposerViewPresenter.getDoc().getBodyText(), value));
            resultOperation.insertToBottom(this.mComposerViewPresenter, srcContentInfo, newTextBox);
        } else if (ResultOperation.AddTo.NewPageBefore == addTo) {
            srcContentInfo.setConvertibleColor(true);
            ComposerSpenWNoteUtils.changeFontSizeSpan(newTextBox, ComposerSpenWNoteUtils.getCursorFontSize(this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager(), srcContentInfo.mSrcPageIndex, this.mComposerViewPresenter.getDoc().getBodyText(), value));
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, srcContentInfo, newTextBox);
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            resultOperation.addToNewNote(this.mComposerViewPresenter, newTextBox);
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.add_to_new_note_toast, 0);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        return !TextUtils.isEmpty(getCurrentVoiceItemText());
    }

    public void cancel() {
        ArrayList<NeuralTranslator> arrayList = this.mTranslatorList;
        if (arrayList != null) {
            Iterator<NeuralTranslator> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.mTranslatorList.clear();
            SCSOperator.INSTANCE.releaseTranslator();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AiOnDeviceMemoryManager.getInstance().release(hashCode(), TAG);
    }

    public void clear() {
        cancel();
        setResultListener(null);
        setLanguageIdentifierCallback(null);
        this.mLanguageIdentifier = null;
    }

    public void clearTranslatedData() {
        if (this.mTranslatedList != null) {
            for (int i = 0; i < this.mTranslatedList.size(); i++) {
                this.mTranslatedList.get(i).setTranslatedText(null);
            }
        }
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.2
            @Override // java.lang.Runnable
            public void run() {
                AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = STTTranslation.this.mResultListener;
                if (sTTTranslateResultListener != null) {
                    sTTTranslateResultListener.onTranslateCompleted(true, 0);
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        String currentVoiceItemText = getCurrentVoiceItemText();
        if (TextUtils.isEmpty(currentVoiceItemText)) {
            Logger.m10999d(TAG, "copy# fail : empty text");
        } else {
            ClipboardManagerCompat.INSTANCE.getInstance().setClip(this.mComposerViewPresenter.getActivity(), new ClipData.Item(currentVoiceItemText), new String[]{"text/plain"}, "");
        }
    }

    public void execute() {
        String str = TAG;
        Logger.m10999d(str, "execute# ");
        this.mLastErrorMessage = null;
        this.mLanguageIdentifier = new LanguageIdentifier();
        ISTTWindow.IAIContract iAIContract = this.mIAiSTTContract;
        if (iAIContract == null || iAIContract.getSTTPresenter() == null) {
            Logger.m11000e(str, "execute# mIAiSTTContract null");
            return;
        }
        String sTTCurrentVoiceItemAdapterText = this.mIAiSTTContract.getSTTPresenter().getSTTCurrentVoiceItemAdapterText(false);
        if (sTTCurrentVoiceItemAdapterText == null) {
            Logger.m11000e(str, "execute# identifyText null");
            return;
        }
        if (sTTCurrentVoiceItemAdapterText.length() > 500) {
            sTTCurrentVoiceItemAdapterText = sTTCurrentVoiceItemAdapterText.substring(0, 500);
        }
        this.mLanguageIdentifier.identifyLanguageAsync(sTTCurrentVoiceItemAdapterText, new LanguageIdentifier.AsyncCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.AsyncCallback
            public void onCompleted(Locale locale) {
                boolean z;
                Logger.m10999d(STTTranslation.TAG, "execute#identifyLanguage# identifiedLocale " + locale);
                if (locale == null) {
                    return;
                }
                if (TextUtils.isEmpty(STTTranslation.this.mFromLanguageTag)) {
                    Locale locale2 = AiLanguageHelper.getLocale(locale.toLanguageTag());
                    if (locale2 == null) {
                        Logger.m11000e(STTTranslation.TAG, "execute#identifyLanguage# unexpected error");
                        STTTranslation.this.mFromLanguageTag = locale.toLanguageTag();
                    } else {
                        STTTranslation.this.mFromLanguageTag = locale2.toLanguageTag();
                    }
                }
                AbstractC8014b.m7213o(new StringBuilder("execute#identifyLanguage# mFromLanguageTag "), STTTranslation.this.mFromLanguageTag, STTTranslation.TAG);
                if (AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(STTTranslation.this.mFromLanguageTag))) {
                    z = true;
                } else {
                    Logger.m10999d(STTTranslation.TAG, "execute#identifyLanguage#from not supported");
                    z = false;
                }
                STTTranslation sTTTranslation = STTTranslation.this;
                sTTTranslation.mToLanguageTag = sTTTranslation.getLastLanguageTag();
                AbstractC8014b.m7213o(new StringBuilder("execute#identifyLanguage#to: "), STTTranslation.this.mToLanguageTag, STTTranslation.TAG);
                Locale locale3 = AiLanguageHelper.getLocale(STTTranslation.this.mToLanguageTag);
                Objects.requireNonNull(locale3);
                if (!AiLanguageHelper.isDownloadedLanguage(locale, locale3, false)) {
                    Logger.m10999d(STTTranslation.TAG, "execute#identifyLanguage#to not supported");
                    z = false;
                }
                if (STTTranslation.this.isSame()) {
                    Logger.m10999d(STTTranslation.TAG, "execute#identifyLanguage#to from and to is same");
                    STTTranslation.this.clearTranslatedData();
                    z = false;
                }
                if (z) {
                    AiOnDeviceMemoryManager.getInstance().ready(hashCode(), STTTranslation.TAG);
                    STTTranslation sTTTranslation2 = STTTranslation.this;
                    sTTTranslation2.mTranslatedList = sTTTranslation2.mIAiSTTContract.getOriginalSTTListView().getAiTextDataList();
                    STTTranslation sTTTranslation3 = STTTranslation.this;
                    sTTTranslation3.mTranslateCount.set(sTTTranslation3.mTranslatedList.size());
                    boolean z2 = false;
                    for (int i = 0; i < STTTranslation.this.mTranslatedList.size(); i++) {
                        AiTextData aiTextData = STTTranslation.this.mTranslatedList.get(i);
                        if (TextUtils.isEmpty(aiTextData.getText())) {
                            STTTranslation.this.mTranslateCount.getAndDecrement();
                        } else {
                            if (!z2) {
                                STTTranslation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = STTTranslation.this.mResultListener;
                                        if (sTTTranslateResultListener != null) {
                                            sTTTranslateResultListener.onTranslateStart();
                                        }
                                    }
                                });
                                z2 = true;
                            }
                            STTTranslation sTTTranslation4 = STTTranslation.this;
                            String string = aiTextData.getText().toString();
                            STTTranslation sTTTranslation5 = STTTranslation.this;
                            sTTTranslation4.translate(i, string, sTTTranslation5.mFromLanguageTag, sTTTranslation5.mToLanguageTag);
                        }
                    }
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_SOURCE_LANGUAGE, STTTranslation.this.mFromLanguageTag);
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_TARGET_LANGUAGE, STTTranslation.this.mToLanguageTag);
                }
                LanguageIdentifyCallback languageIdentifyCallback = STTTranslation.this.mLanguageIdentifyCallback;
                if (languageIdentifyCallback != null) {
                    languageIdentifyCallback.onComplete();
                    STTTranslation.this.mLanguageIdentifyCallback = null;
                }
                STTTranslation.this.mLanguageIdentifier = null;
            }
        });
    }

    public String getCurrentVoiceItemSelectedText() {
        StringBuilder sb = new StringBuilder();
        List<AiTextData> aiTextDataList = this.mIAiSTTContract.getOriginalSTTListView().getAiTextDataList();
        for (int i = 0; i < aiTextDataList.size(); i++) {
            Map<Integer, Boolean> selectedItemMap = this.mIAiSTTContract.getSTTPresenter().getFloatingController().getSelectedItemMap();
            if (selectedItemMap.get(Integer.valueOf(i)) != null && !Boolean.FALSE.equals(selectedItemMap.get(Integer.valueOf(i)))) {
                AiTextData aiTextData = aiTextDataList.get(i);
                if (this.mIAiSTTContract.getShowSpeakerLabel()) {
                    sb.append((CharSequence) aiTextData.getSpeakerName());
                    sb.append(" (");
                    sb.append(AiSTTListViewAdapter.getStringByDuration(aiTextData.getStartTime(), false));
                    sb.append(")");
                    sb.append(System.lineSeparator());
                } else {
                    sb.append(AiSTTListViewAdapter.getStringByDuration(aiTextData.getStartTime(), false));
                    sb.append(System.lineSeparator());
                }
                sb.append((CharSequence) aiTextData.getText());
                if (isTranslateMode() && !TextUtils.isEmpty(aiTextData.getTranslatedText())) {
                    sb.append(System.lineSeparator());
                    sb.append((CharSequence) aiTextData.getTranslatedText());
                }
                sb.append(System.lineSeparator());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getCurrentVoiceItemText() {
        StringBuilder sb = new StringBuilder();
        for (AiTextData aiTextData : this.mIAiSTTContract.getOriginalSTTListView().getAiTextDataList()) {
            if (this.mIAiSTTContract.getShowSpeakerLabel()) {
                sb.append((CharSequence) aiTextData.getSpeakerName());
                sb.append(" (");
                sb.append(AiSTTListViewAdapter.getStringByDuration(aiTextData.getStartTime(), false));
                sb.append(")");
                sb.append(System.lineSeparator());
            } else {
                sb.append(AiSTTListViewAdapter.getStringByDuration(aiTextData.getStartTime(), false));
                sb.append(System.lineSeparator());
            }
            sb.append((CharSequence) aiTextData.getText());
            if (isTranslateMode() && !TextUtils.isEmpty(aiTextData.getTranslatedText())) {
                sb.append(System.lineSeparator());
                sb.append((CharSequence) aiTextData.getTranslatedText());
            }
            sb.append(System.lineSeparator());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "f";
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

    public LanguageIdentifyCallback getLanguageIdentifierCallback() {
        return this.mLanguageIdentifyCallback;
    }

    public String getLastLanguageTag() {
        return SharedPreferencesCompat.getInstance("Composer").getString(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_LANGUAGE, getDefaultLanguageTag());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        String currentVoiceItemText = getCurrentVoiceItemText();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        if (currentVoiceItemText == null) {
            currentVoiceItemText = "";
        }
        newSpenObjectTextBox.setText(currentVoiceItemText);
        return newSpenObjectTextBox;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return new SrcContentInfo("");
    }

    public int getToLanguageState() {
        if (isSame()) {
            return 2;
        }
        Locale locale = AiLanguageHelper.getLocale(this.mFromLanguageTag);
        Locale locale2 = AiLanguageHelper.getLocale(this.mToLanguageTag);
        Objects.requireNonNull(locale2);
        if (AiLanguageHelper.isDownloadedLanguage(locale, locale2, false)) {
            return 0;
        }
        return AiLanguageHelper.isDownloadableLanguage(AiLanguageHelper.getLocale(this.mToLanguageTag)) ? 1 : 2;
    }

    public String getToLanguageTag() {
        return this.mToLanguageTag;
    }

    public List<AiTextData> getTranslatedList() {
        return this.mTranslatedList;
    }

    public boolean isCompleted() {
        return this.mIsCompleted;
    }

    public boolean isInvalidStatus() {
        if (!TextUtils.isEmpty(this.mFromLanguageTag) && !TextUtils.isEmpty(this.mToLanguageTag)) {
            Locale locale = AiLanguageHelper.getLocale(this.mFromLanguageTag);
            Locale locale2 = AiLanguageHelper.getLocale(this.mToLanguageTag);
            Objects.requireNonNull(locale2);
            if (AiLanguageHelper.isDownloadedLanguage(locale, locale2, true)) {
                return false;
            }
        }
        return true;
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

    public boolean isTranslateMode() {
        return this.mIsTranslateMode;
    }

    public boolean isTranslatePending() {
        AtomicInteger atomicInteger = this.mTranslateCount;
        return (atomicInteger == null || atomicInteger.get() == 0) ? false : true;
    }

    public boolean isWaitingFirstResult() {
        return this.mIsWaitingFirstResult || isWaitingIdentifyLanguage();
    }

    public boolean isWaitingIdentifyLanguage() {
        return this.mLanguageIdentifier != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (TextUtils.isEmpty(this.mLastErrorMessage)) {
            bundle.putBoolean(TAG, isWaitingFirstResult());
        } else {
            Logger.m11000e(TAG, "onSaveInstanceState# failed state");
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        String str = TAG;
        if (bundle.containsKey(str)) {
            Logger.m10999d(str, "restore#");
            if (bundle.getBoolean(str)) {
                execute();
            }
        }
    }

    public void setCompleted(boolean z) {
        this.mIsCompleted = z;
    }

    public void setFromLanguageTag(String str) {
        this.mFromLanguageTag = str;
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

    public void setResultListener(AiMenuContract.STTTranslateResultListener sTTTranslateResultListener) {
        this.mResultListener = sTTTranslateResultListener;
    }

    public void setToLanguageTag(String str) {
        this.mToLanguageTag = str;
        setLastLanguage(str);
    }

    public void stop() {
        this.mIsWaitingFirstResult = false;
        this.mIsCompleted = false;
        this.mIsTranslateMode = false;
        this.mTranslateCount.set(0);
        clearTranslatedData();
    }

    public void switchLanguageTag() {
        String str = this.mFromLanguageTag;
        this.mFromLanguageTag = this.mToLanguageTag;
        this.mToLanguageTag = str;
        setLastLanguage(str);
    }

    public void toggleTranslateMode() {
        if (this.mIsTranslateMode) {
            this.mIsTranslateMode = false;
        } else {
            this.mIsTranslateMode = true;
        }
    }

    public void translate(final int i, String str, String str2, String str3) {
        String str4 = TAG;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("translate# index ", i, " ", str2, " - ");
        sbM1629s.append(str3);
        Logger.m10999d(str4, sbM1629s.toString());
        if (TextUtils.isEmpty(str3)) {
            str3 = getLastLanguageTag();
        } else {
            setLastLanguage(str3);
        }
        NeuralTranslator neuralTranslator = new NeuralTranslator(str, str2, str3);
        neuralTranslator.registerCallback(new NeuralTranslator.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.3
            @Override // com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.Callback
            public void onFailed(@NonNull final String str5) {
                STTTranslation sTTTranslation = STTTranslation.this;
                sTTTranslation.mIsWaitingFirstResult = false;
                sTTTranslation.mIsCompleted = true;
                sTTTranslation.mLastErrorMessage = str5;
                sTTTranslation.mTranslateCount.set(0);
                STTTranslation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = STTTranslation.this.mResultListener;
                        if (sTTTranslateResultListener != null) {
                            sTTTranslateResultListener.onTranslateFailed(str5);
                        }
                    }
                });
                AiOnDeviceMemoryManager.getInstance().release(STTTranslation.this.hashCode(), STTTranslation.TAG);
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.Callback
            public void onSuccess(@NonNull String str5, @NonNull String str6, @NonNull String str7, boolean z) {
                Logger.m10999d(STTTranslation.TAG, "translate#onSuccess index " + i + " " + z + " " + str6 + ":" + str7);
                int i2 = i;
                if (i2 < 0 || i2 >= STTTranslation.this.mTranslatedList.size()) {
                    Logger.m11000e(STTTranslation.TAG, "translate#onSuccess invalid index " + i + "of the length" + STTTranslation.this.mTranslatedList.size());
                    return;
                }
                STTTranslation.this.mTranslatedList.get(i).setTranslatedText(new SpannableStringBuilder(str5));
                if (z && STTTranslation.this.mTranslateCount.decrementAndGet() == 0) {
                    Logger.m10999d(STTTranslation.TAG, "translate#onSuccess translate count = " + STTTranslation.this.mTranslateCount);
                    STTTranslation sTTTranslation = STTTranslation.this;
                    sTTTranslation.mIsWaitingFirstResult = false;
                    sTTTranslation.mIsCompleted = true;
                    sTTTranslation.mFromLanguageTag = str6;
                    sTTTranslation.mToLanguageTag = str7;
                    sTTTranslation.setLastLanguage(str7);
                    AiOnDeviceMemoryManager.getInstance().release(STTTranslation.this.hashCode(), STTTranslation.TAG);
                }
                STTTranslation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C94433 c94433 = C94433.this;
                        STTTranslation sTTTranslation2 = STTTranslation.this;
                        AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = sTTTranslation2.mResultListener;
                        if (sTTTranslateResultListener != null) {
                            sTTTranslateResultListener.onTranslateCompleted(sTTTranslation2.mIsCompleted, i);
                        }
                    }
                });
            }
        });
        this.mIsCompleted = false;
        this.mIsWaitingFirstResult = true;
        this.mTranslatorList.add(neuralTranslator);
        neuralTranslator.execute();
    }

    public void updateLanguageStatus() {
        if (!AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mFromLanguageTag))) {
            Logger.m10999d(TAG, "updateLanguageStatus# reset fromLanguageTag");
            this.mFromLanguageTag = "";
        }
        if (AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mToLanguageTag))) {
            return;
        }
        Logger.m10999d(TAG, "updateLanguageStatus# reset toLanguageTag");
        this.mToLanguageTag = "";
        SharedPreferencesCompat.getInstance("Composer").remove(SharedPreferencesConstants.COMPOSER_KEY_AI_TRANSLATE_LAST_LANGUAGE);
    }
}
