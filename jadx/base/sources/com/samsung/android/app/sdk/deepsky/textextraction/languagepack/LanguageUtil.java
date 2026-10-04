package com.samsung.android.app.sdk.deepsky.textextraction.languagepack;

import android.content.Context;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.common.Header;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LanguageUtil;", "", "()V", "NEUTRAL_LANGUAGE", "", "SUPPORTED_COUNTRIES_MAP", "", "", SearchConstants.TargetContents.TAG, "UNKNOWN_LANGUAGE", "createSourceLanguage", "langCode", "createTargetLanguage", "getDisplayNameFromLangCode", "context", "Landroid/content/Context;", "isCountryImportant", "", "language", "country", "isNormalLanguage", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLanguageUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LanguageUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1#2:66\n1747#3,3:67\n*S KotlinDebug\n*F\n+ 1 LanguageUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LanguageUtil\n*L\n54#1:67,3\n*E\n"})
public final class LanguageUtil {

    @NotNull
    private static final String NEUTRAL_LANGUAGE = "<neutral>";

    @NotNull
    private static final String TAG = "LanguageUtil";

    @NotNull
    public static final String UNKNOWN_LANGUAGE = "Unknown";

    @NotNull
    public static final LanguageUtil INSTANCE = new LanguageUtil();

    @NotNull
    private static final Map<String, List<String>> SUPPORTED_COUNTRIES_MAP = MapsKt.mapOf(TuplesKt.m13893to("zh", CollectionsKt.listOf((Object[]) new String[]{"hk", "tw"})), TuplesKt.m13893to(LangPackConfigConstants.LANGUAGE_CODE_PT, CollectionsKt.listOf(Header.f8126BR)), TuplesKt.m13893to(LangPackConfigConstants.LANGUAGE_CODE_ES, CollectionsKt.listOf((Object[]) new String[]{"mx", "us"})), TuplesKt.m13893to(LangPackConfigConstants.LANGUAGE_CODE_FR, CollectionsKt.listOf("ca")));

    private LanguageUtil() {
    }

    private final boolean isCountryImportant(String language, String country) {
        List<String> list = SUPPORTED_COUNTRIES_MAP.get(language);
        if (list != null) {
            return list.contains(country);
        }
        return false;
    }

    @NotNull
    public final String createSourceLanguage(@NotNull String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        if (!isNormalLanguage(langCode) || langCode.length() <= 2) {
            return langCode;
        }
        Set<String> setKeySet = SUPPORTED_COUNTRIES_MAP.keySet();
        if (!(setKeySet instanceof Collection) || !setKeySet.isEmpty()) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                if (StringsKt.m14145S(langCode, (String) it.next())) {
                    return langCode;
                }
            }
        }
        String strSubstring = langCode.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public final String createTargetLanguage() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getDefault().country");
        Locale locale = Locale.ROOT;
        String lowerCase = country.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        Intrinsics.checkNotNullExpressionValue(language, "language");
        if (isCountryImportant(language, lowerCase)) {
            String lowerCase2 = lowerCase.toLowerCase(locale);
            language = AbstractC12991c.m13991l(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)", language, lowerCase2);
        }
        LibLogger.m5432i(TAG, "target language: \"" + language + "\"");
        Intrinsics.checkNotNullExpressionValue(language, "targetLanguage.also { Li…get language: \\\"$it\\\"\") }");
        return language;
    }

    @NotNull
    public final String getDisplayNameFromLangCode(@NotNull Context context, @NotNull String langCode) {
        String displayName;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        if (Intrinsics.areEqual(langCode, LangPackConfigConstants.LANGUAGE_CODE_AUTO)) {
            String string = context.getString(C7039R.string.lang_auto_detected);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.lang_auto_detected)");
            return string;
        }
        if (langCode.length() == 4) {
            String strSubstring = langCode.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = langCode.substring(2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            displayName = new Locale(strSubstring, strSubstring2).getDisplayName();
        } else {
            displayName = new Locale(langCode).getDisplayName();
        }
        Intrinsics.checkNotNullExpressionValue(displayName, "{\n            if (langCo…e\n            }\n        }");
        return displayName;
    }

    public final boolean isNormalLanguage(@NotNull String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        return (Intrinsics.areEqual(langCode, "Unknown") || Intrinsics.areEqual(langCode, NEUTRAL_LANGUAGE)) ? false : true;
    }
}
