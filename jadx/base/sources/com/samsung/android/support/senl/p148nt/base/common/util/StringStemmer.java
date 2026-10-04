package com.samsung.android.support.senl.p148nt.base.common.util;

import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.stemmer.snowball.SnowballStemmer;
import org.apache.commons.lang3.BooleanUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0014R$\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/StringStemmer;", "", "<init>", "()V", "mLanguageDetector", "Lcom/samsung/android/support/senl/nt/base/common/ai/SCSOperator;", "getMLanguageDetector$ntBase_release$annotations", "getMLanguageDetector$ntBase_release", "()Lcom/samsung/android/support/senl/nt/base/common/ai/SCSOperator;", "setMLanguageDetector$ntBase_release", "(Lcom/samsung/android/support/senl/nt/base/common/ai/SCSOperator;)V", "mAlgorithm", "Lopennlp/tools/stemmer/snowball/SnowballStemmer$ALGORITHM;", "mStemmer", "Lopennlp/tools/stemmer/snowball/SnowballStemmer;", "stem", "", "input", "detectAlgorithm", "langCode", "detectAlgorithm$ntBase_release", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StringStemmer {

    @NotNull
    private static final String TAG = "StringStemmer";

    @NotNull
    private SnowballStemmer.ALGORITHM mAlgorithm;

    @NotNull
    private SCSOperator mLanguageDetector = new SCSOperator();

    @NotNull
    private SnowballStemmer mStemmer;

    public StringStemmer() {
        SnowballStemmer.ALGORITHM algorithm = SnowballStemmer.ALGORITHM.ENGLISH;
        this.mAlgorithm = algorithm;
        this.mStemmer = new SnowballStemmer(algorithm);
    }

    @VisibleForTesting
    public static /* synthetic */ void getMLanguageDetector$ntBase_release$annotations() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @VisibleForTesting
    @Nullable
    public final SnowballStemmer.ALGORITHM detectAlgorithm$ntBase_release(@NotNull String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        if (langCode.length() < 2) {
            return null;
        }
        String strSubstring = langCode.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        switch (strSubstring.hashCode()) {
            case 3121:
                if (strSubstring.equals("ar")) {
                    return SnowballStemmer.ALGORITHM.ARABIC;
                }
                return null;
            case 3166:
                if (strSubstring.equals("ca")) {
                    return SnowballStemmer.ALGORITHM.CATALAN;
                }
                return null;
            case 3197:
                if (strSubstring.equals("da")) {
                    return SnowballStemmer.ALGORITHM.DANISH;
                }
                return null;
            case 3201:
                if (strSubstring.equals(LangPackConfigConstants.LANGUAGE_CODE_DE)) {
                    return SnowballStemmer.ALGORITHM.GERMAN;
                }
                return null;
            case 3239:
                if (strSubstring.equals("el")) {
                    return SnowballStemmer.ALGORITHM.GREEK;
                }
                return null;
            case 3241:
                if (strSubstring.equals("en")) {
                    return SnowballStemmer.ALGORITHM.ENGLISH;
                }
                return null;
            case 3246:
                if (strSubstring.equals(LangPackConfigConstants.LANGUAGE_CODE_ES)) {
                    return SnowballStemmer.ALGORITHM.SPANISH;
                }
                return null;
            case 3267:
                if (strSubstring.equals("fi")) {
                    return SnowballStemmer.ALGORITHM.FINNISH;
                }
                return null;
            case 3276:
                if (strSubstring.equals(LangPackConfigConstants.LANGUAGE_CODE_FR)) {
                    return SnowballStemmer.ALGORITHM.FRENCH;
                }
                return null;
            case 3290:
                if (strSubstring.equals("ga")) {
                    return SnowballStemmer.ALGORITHM.IRISH;
                }
                return null;
            case 3341:
                if (strSubstring.equals("hu")) {
                    return SnowballStemmer.ALGORITHM.HUNGARIAN;
                }
                return null;
            case 3365:
                if (strSubstring.equals("in")) {
                    return SnowballStemmer.ALGORITHM.INDONESIAN;
                }
                return null;
            case 3371:
                if (strSubstring.equals(LangPackConfigConstants.LANGUAGE_CODE_IT)) {
                    return SnowballStemmer.ALGORITHM.ITALIAN;
                }
                return null;
            case 3518:
                if (strSubstring.equals("nl")) {
                    return SnowballStemmer.ALGORITHM.DUTCH;
                }
                return null;
            case 3521:
                if (strSubstring.equals(BooleanUtils.f9757NO)) {
                    return SnowballStemmer.ALGORITHM.NORWEGIAN;
                }
                return null;
            case 3588:
                if (strSubstring.equals(LangPackConfigConstants.LANGUAGE_CODE_PT)) {
                    return SnowballStemmer.ALGORITHM.PORTUGUESE;
                }
                return null;
            case 3645:
                if (strSubstring.equals("ro")) {
                    return SnowballStemmer.ALGORITHM.ROMANIAN;
                }
                return null;
            case 3651:
                if (strSubstring.equals(LangPackConfigConstants.LANGUAGE_CODE_RU)) {
                    return SnowballStemmer.ALGORITHM.RUSSIAN;
                }
                return null;
            case 3683:
                if (strSubstring.equals("sv")) {
                    return SnowballStemmer.ALGORITHM.SWEDISH;
                }
                return null;
            case 3710:
                if (strSubstring.equals("tr")) {
                    return SnowballStemmer.ALGORITHM.TURKISH;
                }
                return null;
            default:
                return null;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getMLanguageDetector$ntBase_release, reason: from getter */
    public final SCSOperator getMLanguageDetector() {
        return this.mLanguageDetector;
    }

    public final void setMLanguageDetector$ntBase_release(@NotNull SCSOperator sCSOperator) {
        Intrinsics.checkNotNullParameter(sCSOperator, "<set-?>");
        this.mLanguageDetector = sCSOperator;
    }

    @WorkerThread
    @NotNull
    public final String stem(@NotNull String input) {
        SnowballStemmer.ALGORITHM algorithmDetectAlgorithm$ntBase_release;
        Intrinsics.checkNotNullParameter(input, "input");
        String strIdentifyLanguageOnThread = this.mLanguageDetector.identifyLanguageOnThread(input);
        Logger.m8697d(TAG, "Detected lang - " + strIdentifyLanguageOnThread);
        if (strIdentifyLanguageOnThread.length() == 0 || (algorithmDetectAlgorithm$ntBase_release = detectAlgorithm$ntBase_release(strIdentifyLanguageOnThread)) == null) {
            return "";
        }
        if (algorithmDetectAlgorithm$ntBase_release != this.mAlgorithm) {
            this.mAlgorithm = algorithmDetectAlgorithm$ntBase_release;
            this.mStemmer = new SnowballStemmer(algorithmDetectAlgorithm$ntBase_release);
        }
        CharSequence charSequenceStem = this.mStemmer.stem(input);
        return charSequenceStem.equals(input) ? "" : charSequenceStem.toString();
    }
}
