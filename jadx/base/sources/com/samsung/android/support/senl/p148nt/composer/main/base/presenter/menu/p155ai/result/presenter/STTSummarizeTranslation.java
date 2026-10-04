package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiOnDeviceMemoryManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTTSummarizationItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.NeuralTranslator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class STTSummarizeTranslation extends STTTranslation {
    private static final String TAG = Logger.createTag("STTSummarizeTranslation", AiConstants.PREFIX_TAG);
    private List<AiMenuResultViewSTTSummarizationItem> mSummarizationItems;

    public STTSummarizeTranslation(ComposerViewPresenter composerViewPresenter) {
        super(composerViewPresenter, null);
        Logger.m10999d(TAG, "STTSummarizeTranslation constructor");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTranslation
    public void clearTranslatedData() {
        if (this.mSummarizationItems != null) {
            for (int i = 0; i < this.mSummarizationItems.size(); i++) {
                this.mSummarizationItems.get(i).getTranslatedLines().clear();
            }
        }
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarizeTranslation.2
            @Override // java.lang.Runnable
            public void run() {
                AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = STTSummarizeTranslation.this.mResultListener;
                if (sTTTranslateResultListener != null) {
                    sTTTranslateResultListener.onTranslateCompleted(true, 0);
                }
            }
        });
    }

    public void execute(List<AiMenuResultViewSTTSummarizationItem> list) {
        this.mSummarizationItems = list;
        execute();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTranslation
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
        neuralTranslator.registerCallback(new NeuralTranslator.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarizeTranslation.3
            @Override // com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.Callback
            public void onFailed(@NonNull final String str5) {
                STTSummarizeTranslation sTTSummarizeTranslation = STTSummarizeTranslation.this;
                sTTSummarizeTranslation.mIsWaitingFirstResult = false;
                sTTSummarizeTranslation.mIsCompleted = true;
                sTTSummarizeTranslation.mLastErrorMessage = str5;
                sTTSummarizeTranslation.mTranslateCount.set(0);
                STTSummarizeTranslation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarizeTranslation.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = STTSummarizeTranslation.this.mResultListener;
                        if (sTTTranslateResultListener != null) {
                            sTTTranslateResultListener.onTranslateFailed(str5);
                        }
                    }
                });
                AiOnDeviceMemoryManager.getInstance().release(STTSummarizeTranslation.this.hashCode(), STTSummarizeTranslation.TAG);
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.Callback
            public void onSuccess(@NonNull String str5, @NonNull String str6, @NonNull String str7, boolean z) {
                int i2;
                int i4 = i;
                if (i4 < 0 || i4 >= STTSummarizeTranslation.this.mSummarizationItems.size()) {
                    Logger.m11000e(STTSummarizeTranslation.TAG, "translate#onSuccess invalid index " + i + " in size" + STTSummarizeTranslation.this.mSummarizationItems.size());
                    return;
                }
                Logger.m10999d(STTSummarizeTranslation.TAG, "translate#onSuccess index " + i + " " + z + " " + str6 + ":" + str7);
                String[] strArrSplit = str5.split(System.lineSeparator());
                if (strArrSplit.length == 0) {
                    Logger.m11000e(STTSummarizeTranslation.TAG, "translate#onSuccess dataStrings.length == 0");
                    return;
                }
                String str8 = strArrSplit[0];
                if (TextUtils.isEmpty(((AiMenuResultViewSTTSummarizationItem) STTSummarizeTranslation.this.mSummarizationItems.get(i)).getSummaryTitle())) {
                    str8 = "";
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                while (i2 < strArrSplit.length) {
                    if (!TextUtils.isEmpty(strArrSplit[i2])) {
                        arrayList.add(strArrSplit[i2]);
                    }
                    i2++;
                }
                ((AiMenuResultViewSTTSummarizationItem) STTSummarizeTranslation.this.mSummarizationItems.get(i)).setTranslatedTitle(str8);
                ((AiMenuResultViewSTTSummarizationItem) STTSummarizeTranslation.this.mSummarizationItems.get(i)).setTranslatedLines(arrayList);
                if (z && STTSummarizeTranslation.this.mTranslateCount.decrementAndGet() == 0) {
                    STTSummarizeTranslation sTTSummarizeTranslation = STTSummarizeTranslation.this;
                    sTTSummarizeTranslation.mIsWaitingFirstResult = false;
                    sTTSummarizeTranslation.mIsCompleted = true;
                    sTTSummarizeTranslation.mFromLanguageTag = str6;
                    sTTSummarizeTranslation.mToLanguageTag = str7;
                    sTTSummarizeTranslation.setLastLanguage(str7);
                    AiOnDeviceMemoryManager.getInstance().release(STTSummarizeTranslation.this.hashCode(), STTSummarizeTranslation.TAG);
                }
                STTSummarizeTranslation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarizeTranslation.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C94403 c94403 = C94403.this;
                        STTSummarizeTranslation sTTSummarizeTranslation2 = STTSummarizeTranslation.this;
                        AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = sTTSummarizeTranslation2.mResultListener;
                        if (sTTTranslateResultListener != null) {
                            sTTTranslateResultListener.onTranslateCompleted(sTTSummarizeTranslation2.mIsCompleted, i);
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

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTranslation
    public void execute() {
        List<AiMenuResultViewSTTSummarizationItem> list = this.mSummarizationItems;
        if (list == null || list.isEmpty()) {
            return;
        }
        Logger.m10999d(TAG, "execute# " + this.mSummarizationItems.size());
        this.mLastErrorMessage = null;
        this.mLanguageIdentifier = new LanguageIdentifier();
        StringBuilder sb = new StringBuilder(this.mSummarizationItems.get(0).getSummaryTitle());
        for (String str : this.mSummarizationItems.get(0).getSummaryLines()) {
            sb.append("\n");
            sb.append(str);
        }
        String string = sb.toString();
        if (string.length() > 500) {
            string = string.substring(0, 500);
        }
        this.mLanguageIdentifier.identifyLanguageAsync(string, new LanguageIdentifier.AsyncCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarizeTranslation.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.AsyncCallback
            public void onCompleted(Locale locale) {
                boolean z;
                Logger.m10999d(STTSummarizeTranslation.TAG, "execute#identifyLanguage# identifiedLocale " + locale);
                if (locale == null) {
                    return;
                }
                if (TextUtils.isEmpty(STTSummarizeTranslation.this.mFromLanguageTag)) {
                    Locale locale2 = AiLanguageHelper.getLocale(locale.toLanguageTag());
                    if (locale2 == null) {
                        Logger.m11000e(STTSummarizeTranslation.TAG, "execute#identifyLanguage# unexpected error");
                        STTSummarizeTranslation.this.mFromLanguageTag = locale.toLanguageTag();
                    } else {
                        STTSummarizeTranslation.this.mFromLanguageTag = locale2.toLanguageTag();
                    }
                }
                AbstractC8014b.m7213o(new StringBuilder("execute#identifyLanguage# mFromLanguageTag "), STTSummarizeTranslation.this.mFromLanguageTag, STTSummarizeTranslation.TAG);
                if (AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(STTSummarizeTranslation.this.mFromLanguageTag))) {
                    z = true;
                } else {
                    Logger.m10999d(STTSummarizeTranslation.TAG, "execute#identifyLanguage#from not supported");
                    z = false;
                }
                STTSummarizeTranslation sTTSummarizeTranslation = STTSummarizeTranslation.this;
                sTTSummarizeTranslation.mToLanguageTag = sTTSummarizeTranslation.getLastLanguageTag();
                AbstractC8014b.m7213o(new StringBuilder("execute#identifyLanguage#to: "), STTSummarizeTranslation.this.mToLanguageTag, STTSummarizeTranslation.TAG);
                if (!AiLanguageHelper.isDownloadedLanguage(locale, AiLanguageHelper.getLocale(STTSummarizeTranslation.this.mToLanguageTag), false)) {
                    Logger.m10999d(STTSummarizeTranslation.TAG, "execute#identifyLanguage#to not supported");
                    z = false;
                }
                if (STTSummarizeTranslation.this.isSame()) {
                    Logger.m10999d(STTSummarizeTranslation.TAG, "execute#identifyLanguage#to from and to is same");
                    STTSummarizeTranslation.this.clearTranslatedData();
                    z = false;
                }
                if (z) {
                    AiOnDeviceMemoryManager.getInstance().ready(hashCode(), STTSummarizeTranslation.TAG);
                    STTSummarizeTranslation sTTSummarizeTranslation2 = STTSummarizeTranslation.this;
                    sTTSummarizeTranslation2.mTranslateCount.set(sTTSummarizeTranslation2.mSummarizationItems.size());
                    boolean z2 = false;
                    for (int i = 0; i < STTSummarizeTranslation.this.mSummarizationItems.size(); i++) {
                        AiMenuResultViewSTTSummarizationItem aiMenuResultViewSTTSummarizationItem = (AiMenuResultViewSTTSummarizationItem) STTSummarizeTranslation.this.mSummarizationItems.get(i);
                        if (!aiMenuResultViewSTTSummarizationItem.isHidden()) {
                            if (!z2) {
                                STTSummarizeTranslation.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTSummarizeTranslation.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AiMenuContract.STTTranslateResultListener sTTTranslateResultListener = STTSummarizeTranslation.this.mResultListener;
                                        if (sTTTranslateResultListener != null) {
                                            sTTTranslateResultListener.onTranslateStart();
                                        }
                                    }
                                });
                                z2 = true;
                            }
                            StringBuilder sbM1324q = AbstractC1974b.m1324q(aiMenuResultViewSTTSummarizationItem.getSummaryTitle());
                            sbM1324q.append(System.lineSeparator());
                            for (int i2 = 0; i2 < aiMenuResultViewSTTSummarizationItem.getSummaryLines().size(); i2++) {
                                sbM1324q.append(aiMenuResultViewSTTSummarizationItem.getSummaryLines().get(i2));
                                sbM1324q.append(System.lineSeparator());
                            }
                            String strReplaceAll = sbM1324q.toString().replaceAll("\\s+", "");
                            int length = strReplaceAll.length();
                            int iCharCount = 0;
                            while (true) {
                                if (iCharCount >= length) {
                                    STTSummarizeTranslation.this.mTranslateCount.decrementAndGet();
                                    break;
                                }
                                int iCodePointAt = strReplaceAll.codePointAt(iCharCount);
                                if (!Character.isWhitespace(iCodePointAt)) {
                                    STTSummarizeTranslation sTTSummarizeTranslation3 = STTSummarizeTranslation.this;
                                    String string2 = sbM1324q.toString();
                                    STTSummarizeTranslation sTTSummarizeTranslation4 = STTSummarizeTranslation.this;
                                    sTTSummarizeTranslation3.translate(i, string2, sTTSummarizeTranslation4.mFromLanguageTag, sTTSummarizeTranslation4.mToLanguageTag);
                                    break;
                                }
                                iCharCount += Character.charCount(iCodePointAt);
                            }
                        } else {
                            STTSummarizeTranslation.this.mTranslateCount.getAndDecrement();
                        }
                    }
                }
                STTTranslation.LanguageIdentifyCallback languageIdentifyCallback = STTSummarizeTranslation.this.mLanguageIdentifyCallback;
                if (languageIdentifyCallback != null) {
                    languageIdentifyCallback.onComplete();
                    STTSummarizeTranslation.this.mLanguageIdentifyCallback = null;
                }
                STTSummarizeTranslation.this.mLanguageIdentifier = null;
            }
        });
    }
}
