package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/DisplayLanguageUtils;", "", "<init>", "()V", "DISPLAY_LANGUAGE_CEBUANO", "", "DISPLAY_LANGUAGE_CEBUANO_LOCAL_FORM", "LANGCODE_HINGLISH", "LANGCODE_CHINESE", "LANGCODE_CHINESE_CH", "LANGCODE_CHINESE_HK", "LANGCODE_CHINESE_TW", "DISPLAY_NAME_HINGLISH_PREFIX", "getDisplayNamesFromLanguageCodes", "", "languageCodes", "addableLanguageCodes", "getDisplayLanguageSystem", "langCode", "getDisplayLanguage", "locale", "Ljava/util/Locale;", "displayLocale", "getDisplayNameWithoutCountry", "getDisplayName", "getDisplayNameForChinese", "context", "Landroid/content/Context;", "isChineseLanguageCode", "", "getLocaleFromLanguageCode", "languageCode", "convertLanguageCode", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDisplayLanguageUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DisplayLanguageUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/DisplayLanguageUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class DisplayLanguageUtils {

    @NotNull
    private static final String DISPLAY_LANGUAGE_CEBUANO = "Cebuano";

    @NotNull
    private static final String DISPLAY_LANGUAGE_CEBUANO_LOCAL_FORM = "Binisaya";

    @NotNull
    private static final String DISPLAY_NAME_HINGLISH_PREFIX = "hg";

    @NotNull
    public static final DisplayLanguageUtils INSTANCE = new DisplayLanguageUtils();

    @NotNull
    private static final String LANGCODE_CHINESE = "zh";

    @NotNull
    private static final String LANGCODE_CHINESE_CH = "zh-CN";

    @NotNull
    private static final String LANGCODE_CHINESE_HK = "zh-HK";

    @NotNull
    private static final String LANGCODE_CHINESE_TW = "zh-TW";

    @NotNull
    private static final String LANGCODE_HINGLISH = "hg-IN";

    private DisplayLanguageUtils() {
    }

    private final String convertLanguageCode(String languageCode) {
        return StringsKt.m14139M(languageCode, "_", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
    }

    @JvmStatic
    @NotNull
    public static final String getDisplayLanguageSystem(@NotNull String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        if (TextUtils.isEmpty(langCode)) {
            return "";
        }
        return INSTANCE.getDisplayLanguage(getLocaleFromLanguageCode(langCode), null);
    }

    @JvmStatic
    @NotNull
    public static final String getDisplayName(@NotNull String langCode) {
        String strM14139M;
        String string;
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        String strConvertLanguageCode = INSTANCE.convertLanguageCode(langCode);
        String element = getLocaleFromLanguageCode(strConvertLanguageCode).getDisplayName();
        if (TextUtils.isEmpty(element)) {
            return "";
        }
        if (Intrinsics.areEqual(LANGCODE_HINGLISH, strConvertLanguageCode)) {
            Intrinsics.checkNotNullExpressionValue(element, "element");
            if (StringsKt.m14145S(element, "hg")) {
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext == null || (string = applicationContext.getString(C8875R.string.language_hinglish)) == null) {
                    strM14139M = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(element, "element");
                    strM14139M = StringsKt.m14139M(element, "hg", string);
                }
                element = String.valueOf(strM14139M);
            }
        }
        if (isChineseLanguageCode(strConvertLanguageCode)) {
            Context applicationContext2 = BaseUtils.getApplicationContext();
            element = String.valueOf(applicationContext2 != null ? getDisplayNameForChinese(applicationContext2, strConvertLanguageCode) : null);
        }
        Intrinsics.checkNotNullExpressionValue(element, "element");
        return element;
    }

    @JvmStatic
    @NotNull
    public static final String getDisplayNameForChinese(@NotNull Context context, @NotNull String langCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
            if (Intrinsics.areEqual("zh-HK", langCode)) {
                String string = context.getString(C8875R.string.language_hk_chn);
                Intrinsics.checkNotNull(string);
                return string;
            }
            if (Intrinsics.areEqual("zh-TW", langCode)) {
                String string2 = context.getString(C8875R.string.language_tw_chn);
                Intrinsics.checkNotNull(string2);
                return string2;
            }
            String string3 = context.getString(C8875R.string.language_cn_chn);
            Intrinsics.checkNotNull(string3);
            return string3;
        }
        if (Intrinsics.areEqual("zh-HK", langCode)) {
            String string4 = context.getString(C8875R.string.language_hk_global);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
        if (Intrinsics.areEqual("zh-TW", langCode)) {
            String string5 = context.getString(C8875R.string.language_tw_global);
            Intrinsics.checkNotNull(string5);
            return string5;
        }
        String string6 = context.getString(C8875R.string.language_cn_global);
        Intrinsics.checkNotNull(string6);
        return string6;
    }

    @JvmStatic
    @NotNull
    public static final List<String> getDisplayNamesFromLanguageCodes(@NotNull List<String> languageCodes, @NotNull List<String> addableLanguageCodes) {
        Intrinsics.checkNotNullParameter(languageCodes, "languageCodes");
        Intrinsics.checkNotNullParameter(addableLanguageCodes, "addableLanguageCodes");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = addableLanguageCodes.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.getDisplayLanguage(it.next()));
        }
        int size = languageCodes.size();
        HashMap map = new HashMap();
        for (int i = 0; i < size; i++) {
            String displayLanguage = INSTANCE.getDisplayLanguage(languageCodes.get(i));
            Boolean bool = (Boolean) map.get(displayLanguage);
            if (bool == null) {
                if (arrayList.contains(displayLanguage)) {
                    map.put(displayLanguage, Boolean.TRUE);
                } else {
                    map.put(displayLanguage, Boolean.FALSE);
                }
            } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                map.remove(displayLanguage);
                map.put(displayLanguage, Boolean.TRUE);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            String str = languageCodes.get(i2);
            DisplayLanguageUtils displayLanguageUtils = INSTANCE;
            Boolean bool2 = (Boolean) map.get(displayLanguageUtils.getDisplayLanguage(str));
            if (bool2 != null) {
                if (Intrinsics.areEqual(bool2, Boolean.TRUE)) {
                    arrayList2.add(getDisplayName(str));
                } else {
                    arrayList2.add(displayLanguageUtils.getDisplayNameWithoutCountry(str));
                }
            }
        }
        return arrayList2;
    }

    @JvmStatic
    @NotNull
    public static final Locale getLocaleFromLanguageCode(@NotNull String languageCode) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Locale localeForLanguageTag = Locale.forLanguageTag(INSTANCE.convertLanguageCode(languageCode));
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
        return localeForLanguageTag;
    }

    @JvmStatic
    public static final boolean isChineseLanguageCode(@Nullable String langCode) {
        return Intrinsics.areEqual("zh", langCode) || Intrinsics.areEqual("zh-CN", langCode) || Intrinsics.areEqual("zh-HK", langCode) || Intrinsics.areEqual("zh-TW", langCode);
    }

    @NotNull
    public final String getDisplayLanguage(@NotNull String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        if (TextUtils.isEmpty(langCode)) {
            return "";
        }
        Locale localeFromLanguageCode = getLocaleFromLanguageCode(langCode);
        return getDisplayLanguage(localeFromLanguageCode, localeFromLanguageCode);
    }

    @NotNull
    public final String getDisplayNameWithoutCountry(@NotNull String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        String displayName = getDisplayName(langCode);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        int iM14129C = StringsKt.m14129C("(", 0, 6, displayName);
        if (iM14129C < 0) {
            return displayName;
        }
        String strSubstring = displayName.substring(0, iM14129C - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final String getDisplayLanguage(Locale locale, Locale displayLocale) {
        String displayLanguage;
        if (displayLocale != null) {
            displayLanguage = locale.getDisplayLanguage(locale);
        } else {
            displayLanguage = locale.getDisplayLanguage();
        }
        Intrinsics.checkNotNull(displayLanguage);
        if (!TextUtils.isEmpty(displayLanguage)) {
            if (StringsKt__StringsJVMKt.equals(displayLanguage, DISPLAY_LANGUAGE_CEBUANO_LOCAL_FORM, true)) {
                displayLanguage = DISPLAY_LANGUAGE_CEBUANO;
            }
            String strSubstring = displayLanguage.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String upperCase = strSubstring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String strSubstring2 = displayLanguage.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            return AbstractC0541b.m756B(upperCase, strSubstring2);
        }
        return "";
    }
}
