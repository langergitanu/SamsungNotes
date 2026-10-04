package com.samsung.android.app.sdk.deepsky.classifier.language;

import android.content.Context;
import android.icu.util.ULocale;
import android.os.Build;
import android.os.LocaleList;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextLanguage;
import com.samsung.android.app.sdk.deepsky.logger.LibLogger;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import p074R1.AbstractC0229a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/language/LanguageDetectorImpl;", "Lcom/samsung/android/app/sdk/deepsky/classifier/language/LanguageDetector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", TextConst.METHOD_DETECT_LANGUAGE, "", "text", "defaultLanguage", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLanguageDetectorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageDetectorImpl.kt\ncom/samsung/android/app/sdk/deepsky/classifier/language/LanguageDetectorImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1549#2:44\n1620#2,3:45\n1963#2,14:48\n1549#2:62\n1620#2,3:63\n*S KotlinDebug\n*F\n+ 1 LanguageDetectorImpl.kt\ncom/samsung/android/app/sdk/deepsky/classifier/language/LanguageDetectorImpl\n*L\n19#1:44\n19#1:45,3\n20#1:48,14\n28#1:62\n28#1:63,3\n*E\n"})
public final class LanguageDetectorImpl implements LanguageDetector {

    @NotNull
    private static final String TAG = "LanguageDetectorImpl";

    @NotNull
    private final Context context;

    public LanguageDetectorImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.samsung.android.app.sdk.deepsky.classifier.language.LanguageDetector
    @NotNull
    public String detectLanguage(@NotNull String text, @NotNull String defaultLanguage) {
        Object next;
        ULocale uLocale;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(defaultLanguage, "defaultLanguage");
        if (Build.VERSION.SDK_INT >= 29) {
            TextClassifier textClassifier = ((TextClassificationManager) this.context.getSystemService(TextClassificationManager.class)).getTextClassifier();
            Intrinsics.checkNotNullExpressionValue(textClassifier, "context.getSystemService…lass.java).textClassifier");
            AbstractC0229a.m516p();
            TextLanguage textLanguageDetectLanguage = textClassifier.detectLanguage(AbstractC0229a.m513m(text).build());
            Intrinsics.checkNotNullExpressionValue(textLanguageDetectLanguage, "textClassifier.detectLan…st.Builder(text).build())");
            IntRange intRangeUntil = RangesKt.until(0, textLanguageDetectLanguage.getLocaleHypothesisCount());
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(intRangeUntil));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                arrayList.add(TuplesKt.m13893to(textLanguageDetectLanguage.getLocale(iNextInt), Float.valueOf(textLanguageDetectLanguage.getConfidenceScore(textLanguageDetectLanguage.getLocale(iNextInt)))));
            }
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    float fFloatValue = ((Number) ((Pair) next).getSecond()).floatValue();
                    do {
                        Object next2 = it2.next();
                        float fFloatValue2 = ((Number) ((Pair) next2).getSecond()).floatValue();
                        if (Float.compare(fFloatValue, fFloatValue2) < 0) {
                            next = next2;
                            fFloatValue = fFloatValue2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            Pair pair = (Pair) next;
            String language = (pair == null || (uLocale = (ULocale) pair.getFirst()) == null) ? null : uLocale.getLanguage();
            if (language != null) {
                LibLogger.m5380d(TAG, "detectLanguage, by classifier: ".concat(language));
                return language;
            }
        }
        LocaleList locales = this.context.getResources().getConfiguration().getLocales();
        Intrinsics.checkNotNullExpressionValue(locales, "context.resources.configuration.locales");
        IntRange intRangeUntil2 = RangesKt.until(0, locales.size());
        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(intRangeUntil2));
        Iterator<Integer> it3 = intRangeUntil2.iterator();
        while (it3.hasNext()) {
            arrayList2.add(locales.get(((IntIterator) it3).nextInt()));
        }
        Locale locale = (Locale) CollectionsKt.firstOrNull((List) arrayList2);
        String language2 = locale != null ? locale.getLanguage() : null;
        if (language2 != null) {
            LibLogger.m5380d(TAG, "detectLanguage, by settings: ".concat(language2));
            return language2;
        }
        LibLogger.m5380d(TAG, "detectLanguage, by default");
        return defaultLanguage;
    }
}
