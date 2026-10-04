package com.samsung.android.support.senl.p148nt.base.common.p151ai.common;

import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/common/AiMaxLength;", "", "<init>", "()V", "LEN_COMMON_MAX", "", "LEN_SELECTED_MAX", "setSelectedMaxLength", "", "setSelectedMaxOnDeviceSummary", "LEN_SUMMARY_MIN", "LEN_SUMMARY_MAX", "LEN_SUMMARY_ZH_MAX", "LEN_SUMMARY_CHINA_MAX", "getSummaryMax", "locale", "Ljava/util/Locale;", "LEN_SUMMARY_ON_DEVICE_MAX", "SUMMARY_ON_DEVICE_MAX_MAP", "", "", "getSummaryOnDeviceMax", "language", "LEN_AUTO_FORMAT_MIN", "LEN_AUTO_FORMAT_DEF", "LEN_AUTO_FORMAT_MAX", "LEN_AUTO_FORMAT_CHINA_MAX", "AUTOFORMAT_MAX_MAP", "getAutoFormatMax", "LEN_SPELLING_MIN", "LEN_SPELLING_CHINA_MAX", "CORRECTION_MAX_MAP", "getSpellingCorrectionMax", "COVER_EXTRACT_MIN_CHAR", "COVER_EXTRACT_MAX_CHAR", "COVER_SUMMARY_MAX_CHAR", "COVER_TITLE_MAX_CHAR", "LEN_TRANSLATION_MIN", "LEN_TRANSLATION_MAX", "EXTRA_LENGTH", "EXTRA_LENGTH_ON_DEVICE", "getIdentifyTargetStr", "fullStr", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiMaxLength {

    @NotNull
    private static final Map<String, Integer> AUTOFORMAT_MAX_MAP;

    @NotNull
    private static final Map<String, Integer> CORRECTION_MAX_MAP;
    public static final int COVER_EXTRACT_MAX_CHAR = 500;
    public static final int COVER_EXTRACT_MIN_CHAR = 100;
    public static final int COVER_SUMMARY_MAX_CHAR = 200;
    public static final int COVER_TITLE_MAX_CHAR = 50;
    public static final int EXTRA_LENGTH = 500;
    public static final int EXTRA_LENGTH_ON_DEVICE = 100;
    public static final int LEN_AUTO_FORMAT_CHINA_MAX = 1400;
    public static final int LEN_AUTO_FORMAT_DEF = 1000;
    public static final int LEN_AUTO_FORMAT_MAX = 2000;
    public static final int LEN_AUTO_FORMAT_MIN = 200;
    public static final int LEN_COMMON_MAX = 10000;
    public static final int LEN_SPELLING_CHINA_MAX = 1400;
    public static final int LEN_SPELLING_MIN = 1;
    public static final int LEN_SUMMARY_CHINA_MAX = 1400;
    public static final int LEN_SUMMARY_MAX = 5000;
    public static final int LEN_SUMMARY_MIN = 200;
    public static final int LEN_SUMMARY_ON_DEVICE_MAX = 1000;
    public static final int LEN_SUMMARY_ZH_MAX = 4000;
    public static final int LEN_TRANSLATION_MAX = 10000;
    public static final int LEN_TRANSLATION_MIN = 1;

    @NotNull
    private static final Map<String, Integer> SUMMARY_ON_DEVICE_MAX_MAP;

    @NotNull
    public static final AiMaxLength INSTANCE = new AiMaxLength();

    @JvmField
    public static int LEN_SELECTED_MAX = 10000;

    static {
        char c = 4;
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_KO, 1000), new AbstractMap.SimpleEntry("en", 2000), new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_ES, 2000), new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_FR, 2000), new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_DE, 2000), new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_IT, 2000), new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_PT, 2000), new AbstractMap.SimpleEntry("zh", 900), new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_JA, 1000)};
        HashMap map = new HashMap(9);
        int i = 0;
        for (int i2 = 9; i < i2; i2 = 9) {
            Map.Entry entry = entryArr[i];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            char c2 = c;
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(key, "duplicate key: "));
            }
            i++;
            c = c2;
        }
        char c4 = c;
        Map<String, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "of(...)");
        SUMMARY_ON_DEVICE_MAX_MAP = mapUnmodifiableMap;
        AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_PT, 2000);
        AbstractMap.SimpleEntry simpleEntry2 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_ES, 2000);
        AbstractMap.SimpleEntry simpleEntry3 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_FR, 2000);
        AbstractMap.SimpleEntry simpleEntry4 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_IT, 2000);
        AbstractMap.SimpleEntry simpleEntry5 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_DE, 2000);
        AbstractMap.SimpleEntry simpleEntry6 = new AbstractMap.SimpleEntry("en", 2000);
        Map.Entry[] entryArr2 = new Map.Entry[6];
        entryArr2[0] = simpleEntry;
        entryArr2[1] = simpleEntry2;
        entryArr2[2] = simpleEntry3;
        entryArr2[3] = simpleEntry4;
        entryArr2[c4] = simpleEntry5;
        entryArr2[5] = simpleEntry6;
        HashMap map2 = new HashMap(6);
        for (int i4 = 0; i4 < 6; i4++) {
            Map.Entry entry2 = entryArr2[i4];
            Object key2 = entry2.getKey();
            Objects.requireNonNull(key2);
            Object value2 = entry2.getValue();
            Objects.requireNonNull(value2);
            if (map2.put(key2, value2) != null) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(key2, "duplicate key: "));
            }
        }
        Map<String, Integer> mapUnmodifiableMap2 = Collections.unmodifiableMap(map2);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap2, "of(...)");
        AUTOFORMAT_MAX_MAP = mapUnmodifiableMap2;
        AbstractMap.SimpleEntry simpleEntry7 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_PT, 3000);
        AbstractMap.SimpleEntry simpleEntry8 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_ES, 3000);
        AbstractMap.SimpleEntry simpleEntry9 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_FR, 3000);
        AbstractMap.SimpleEntry simpleEntry10 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_IT, 3000);
        AbstractMap.SimpleEntry simpleEntry11 = new AbstractMap.SimpleEntry(LangPackConfigConstants.LANGUAGE_CODE_DE, 3000);
        AbstractMap.SimpleEntry simpleEntry12 = new AbstractMap.SimpleEntry("en", 3000);
        Map.Entry[] entryArr3 = new Map.Entry[6];
        entryArr3[0] = simpleEntry7;
        entryArr3[1] = simpleEntry8;
        entryArr3[2] = simpleEntry9;
        entryArr3[3] = simpleEntry10;
        entryArr3[c4] = simpleEntry11;
        entryArr3[5] = simpleEntry12;
        HashMap map3 = new HashMap(6);
        for (int i5 = 0; i5 < 6; i5++) {
            Map.Entry entry3 = entryArr3[i5];
            Object key3 = entry3.getKey();
            Objects.requireNonNull(key3);
            Object value3 = entry3.getValue();
            Objects.requireNonNull(value3);
            if (map3.put(key3, value3) != null) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(key3, "duplicate key: "));
            }
        }
        Map<String, Integer> mapUnmodifiableMap3 = Collections.unmodifiableMap(map3);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap3, "of(...)");
        CORRECTION_MAX_MAP = mapUnmodifiableMap3;
    }

    private AiMaxLength() {
    }

    @JvmStatic
    public static final int getAutoFormatMax(@Nullable Locale locale) {
        if (locale == null) {
            return 1000;
        }
        Integer num = AUTOFORMAT_MAX_MAP.get(locale.getLanguage());
        if (num == null) {
            num = 1000;
        }
        return num.intValue();
    }

    @JvmStatic
    @NotNull
    public static final String getIdentifyTargetStr(@NotNull String fullStr) {
        Intrinsics.checkNotNullParameter(fullStr, "fullStr");
        String strSubstring = fullStr.substring(0, (int) Math.min(fullStr.length(), 1000.0d));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @JvmStatic
    public static final int getSpellingCorrectionMax(@Nullable Locale locale) {
        if (locale == null) {
            return 1000;
        }
        Integer num = CORRECTION_MAX_MAP.get(locale.getLanguage());
        if (num == null) {
            num = 1000;
        }
        return num.intValue();
    }

    @JvmStatic
    public static final int getSummaryMax(@Nullable Locale locale) {
        return 5000;
    }

    @JvmStatic
    public static final int getSummaryOnDeviceMax(@Nullable String language) {
        if (TextUtils.isEmpty(language)) {
            return 1000;
        }
        Integer num = SUMMARY_ON_DEVICE_MAX_MAP.get(language);
        if (num == null) {
            num = 1000;
        }
        return num.intValue();
    }

    @JvmStatic
    public static final void setSelectedMaxLength() {
        LEN_SELECTED_MAX = 10000;
    }

    @JvmStatic
    public static final void setSelectedMaxOnDeviceSummary() {
        LEN_SELECTED_MAX = 5000;
    }
}
