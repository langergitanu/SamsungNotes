package com.samsung.android.support.senl.p148nt.model.assist.llm;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.SentenceSeparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NeuralTranslator {

    @VisibleForTesting
    static final int BLOCK_SIZE = 1500;
    private static final String LINE_FEED_PATTERNS = "\r\n|\n\r|\r|\n";
    private static final String TAG = "Ai$NeuralTranslator";
    private final String mCacheKey;
    private Callback mCallback;
    private final String mContent;

    @VisibleForTesting
    final List<String> mContents;

    @VisibleForTesting
    final List<String> mContentsSeparators;
    private String mFromLanguageTag;
    private final SCSOperator mImpl;
    private SCSTextResultListener.Callback mResponse;
    private String mResult;
    private String mToLanguageTag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onFailed(@NonNull String str);

        void onSuccess(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z);
    }

    public NeuralTranslator(String str) {
        this(str, null, null);
    }

    private void identifyLanguage() {
        if (TextUtils.isEmpty(this.mFromLanguageTag) || !AiLanguageHelper.isDownloadableLanguage(AiLanguageHelper.getLocale(this.mFromLanguageTag))) {
            this.mImpl.identifyLanguage(this.mContent).addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.2
                @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
                public void onComplete(@NonNull Task<String> task) {
                    if (NeuralTranslator.this.mCallback == null) {
                        return;
                    }
                    String result = task.getResult();
                    if (TextUtils.isEmpty(result)) {
                        Exception exception = task.getException();
                        String localizedMessage = exception == null ? "Unknown error to detect input language" : exception.getLocalizedMessage();
                        Logger.m8703w(NeuralTranslator.TAG, "identifyLanguage#onComplete# fail - " + localizedMessage);
                        NeuralTranslator.this.mCallback.onFailed(localizedMessage);
                        return;
                    }
                    AbstractC4539a.m3188B("identifyLanguage#onComplete# ", result, NeuralTranslator.TAG);
                    NeuralTranslator.this.mFromLanguageTag = AiLanguageHelper.getLocale(result).toLanguageTag();
                    if (!AiLanguageHelper.isDownloadableLanguage(AiLanguageHelper.getLocale(NeuralTranslator.this.mFromLanguageTag))) {
                        NeuralTranslator.this.mCallback.onFailed("Source language is not available");
                    } else {
                        NeuralTranslator.this.verifyTargetLanguage();
                        NeuralTranslator.this.translate();
                    }
                }
            });
        } else {
            verifyTargetLanguage();
            translate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(String str) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$translate$1(String str) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onSuccess(str, this.mFromLanguageTag, this.mToLanguageTag, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translate() {
        Logger.m8702i(TAG, "execute - fr " + this.mFromLanguageTag + " to " + this.mToLanguageTag);
        String resultFromCache = SCSTools.getResultFromCache(getCacheKey(), this.mContent + this.mFromLanguageTag + this.mToLanguageTag);
        if (!TextUtils.isEmpty(resultFromCache) && this.mCallback != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC11410a(this, resultFromCache, 1), 1000L);
        } else {
            separateContent(this.mContent);
            translateNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateNext() {
        String strRemove = this.mContents.remove(0);
        while ("\n".equals(strRemove) && this.mContents.size() > 0) {
            this.mResult = AbstractC0622a.m1170p(this.mResult, strRemove, new StringBuilder());
            strRemove = this.mContents.remove(0);
            Logger.m8702i(TAG, "translateNext# skip empty block");
        }
        if ("\n".equals(strRemove)) {
            this.mResponse.onSuccess(strRemove, true);
            Logger.m8702i(TAG, "translateNext# end with empty block");
            return;
        }
        String strConvertToScsLanguage = AiLanguageHelper.convertToScsLanguage(this.mFromLanguageTag);
        String strConvertToScsLanguage2 = AiLanguageHelper.convertToScsLanguage(this.mToLanguageTag);
        if (TextUtils.isEmpty(strConvertToScsLanguage) || TextUtils.isEmpty(strConvertToScsLanguage2)) {
            return;
        }
        this.mImpl.translate(strRemove, strConvertToScsLanguage, strConvertToScsLanguage2, false);
        Logger.m8702i(TAG, "translateNext# request - " + strRemove.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyTargetLanguage() {
        List<AiLanguageHelper.Language> targetLanguageList = AiLanguageHelper.getTargetLanguageList(this.mFromLanguageTag);
        Logger.m8697d(TAG, "verifyTargetLanguage : list - " + targetLanguageList.toString());
        if (targetLanguageList.isEmpty()) {
            String languageTag = Locale.getDefault().toLanguageTag();
            if (AiLanguageHelper.getTargetLanguageList(languageTag).isEmpty()) {
                Logger.m8702i(TAG, "verifyTargetLanguage to en");
                this.mToLanguageTag = "en-US";
            } else {
                this.mToLanguageTag = languageTag;
                AbstractC4539a.m3206p("verifyTargetLanguage to ", languageTag, TAG);
            }
        }
    }

    public boolean execute() {
        if (TextUtils.isEmpty(this.mContent)) {
            Logger.m8703w(TAG, "execute with empty content");
            return false;
        }
        String strReplaceAll = this.mContent.replaceAll("\\s+", "");
        int length = strReplaceAll.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount < length) {
                int iCodePointAt = strReplaceAll.codePointAt(iCharCount);
                if (!Character.isWhitespace(iCodePointAt)) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            } else if (this.mCallback != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC11410a(this, BaseUtils.getApplicationContext().getString(C8875R.string.ai_error_can_not_find_any_text), 0), 1000L);
                return false;
            }
        }
        identifyLanguage();
        return true;
    }

    public String getCacheKey() {
        return this.mCacheKey;
    }

    public void registerCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void release() {
        this.mCallback = null;
        this.mResponse = null;
        Logger.m8702i(TAG, "release - " + getClass().getSimpleName() + " : " + hashCode());
    }

    @VisibleForTesting
    public void separateContent(@NonNull String str) {
        if (str.length() <= 1500) {
            this.mContents.add(str);
            this.mContentsSeparators.add("");
            return;
        }
        ListIterator listIterator = Arrays.asList(str.split(LINE_FEED_PATTERNS)).listIterator();
        while (listIterator.hasNext()) {
            String str2 = (String) listIterator.next();
            if (str2.length() < 1500) {
                int size = this.mContents.size() - 1;
                int length = str2.length();
                int iCharCount = 0;
                int iCharCount2 = 0;
                while (true) {
                    if (iCharCount2 >= length) {
                        break;
                    }
                    int iCodePointAt = str2.codePointAt(iCharCount2);
                    if (Character.isWhitespace(iCodePointAt)) {
                        iCharCount2 += Character.charCount(iCodePointAt);
                    } else if (size >= 0) {
                        String str3 = this.mContents.get(size);
                        int length2 = str3.length();
                        while (true) {
                            if (iCharCount >= length2) {
                                break;
                            }
                            int iCodePointAt2 = str3.codePointAt(iCharCount);
                            if (Character.isWhitespace(iCodePointAt2)) {
                                iCharCount += Character.charCount(iCodePointAt2);
                            } else {
                                if (str2.length() + str3.length() < 1500) {
                                    this.mContents.remove(size);
                                    this.mContents.add(str3 + "\n" + str2);
                                }
                            }
                        }
                    }
                }
                this.mContents.add(str2);
                this.mContentsSeparators.add(listIterator.hasNext() ? "\n" : "");
            } else {
                List<Sentence> listExecute = new SentenceSeparator(str2).execute();
                StringBuilder sb = new StringBuilder();
                ListIterator<Sentence> listIterator2 = listExecute.listIterator();
                while (listIterator2.hasNext()) {
                    Sentence next = listIterator2.next();
                    if (next.getLength() + sb.length() < 1500) {
                        if (sb.length() != 0) {
                            sb.append(' ');
                        }
                        sb.append(next.getText());
                    } else {
                        this.mContents.add(sb.toString());
                        this.mContentsSeparators.add(listIterator2.hasNext() ? "" : "\n");
                        sb = new StringBuilder();
                        sb.append(next.getText());
                    }
                }
                if (sb.length() != 0) {
                    this.mContents.add(sb.toString());
                    this.mContentsSeparators.add(listIterator2.hasNext() ? "" : "\n");
                }
            }
        }
        Logger.m8702i(TAG, "preProcessingContent# " + this.mContents.size() + " blocks(" + this.mContentsSeparators.size() + ")");
    }

    public NeuralTranslator(String str, @Nullable String str2) {
        this(str, null, str2);
    }

    public NeuralTranslator(String str, @Nullable String str2, @Nullable String str3) {
        this.mContents = new ArrayList();
        this.mContentsSeparators = new ArrayList();
        this.mResult = "";
        this.mCacheKey = getClass().getSimpleName();
        this.mContent = str;
        this.mFromLanguageTag = str2;
        this.mToLanguageTag = str3;
        this.mResponse = new SCSTextResultListener.Callback() { // from class: com.samsung.android.support.senl.nt.model.assist.llm.NeuralTranslator.1
            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str4) {
                if (NeuralTranslator.this.mCallback == null) {
                    return true;
                }
                NeuralTranslator.this.mCallback.onFailed(str4);
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str4, boolean z) {
                StringBuilder sb = new StringBuilder();
                NeuralTranslator neuralTranslator = NeuralTranslator.this;
                sb.append(neuralTranslator.mResult);
                sb.append(str4);
                sb.append(NeuralTranslator.this.mContentsSeparators.remove(0));
                neuralTranslator.mResult = sb.toString();
                if (!z) {
                    Logger.m8703w(NeuralTranslator.TAG, "onSuccess# not completed");
                    return;
                }
                boolean z2 = NeuralTranslator.this.mContents.size() == 0;
                if (NeuralTranslator.this.mCallback != null) {
                    NeuralTranslator.this.mCallback.onSuccess(NeuralTranslator.this.mResult, NeuralTranslator.this.mFromLanguageTag, NeuralTranslator.this.mToLanguageTag, z2);
                }
                if (!z2) {
                    NeuralTranslator.this.translateNext();
                    return;
                }
                SCSTools.addResultToCache(NeuralTranslator.this.getCacheKey(), NeuralTranslator.this.mContent + NeuralTranslator.this.mFromLanguageTag + NeuralTranslator.this.mToLanguageTag, NeuralTranslator.this.mResult);
            }
        };
        SCSOperator sCSOperator = new SCSOperator();
        this.mImpl = sCSOperator;
        sCSOperator.setCallback(this.mResponse);
    }
}
