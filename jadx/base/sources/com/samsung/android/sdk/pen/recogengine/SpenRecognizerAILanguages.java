package com.samsung.android.sdk.pen.recogengine;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizerAILanguages;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mHwrLocaleMap", "", "availableLanguages", "", "getAvailableLanguages$annotations", "getAvailableLanguages", "()Ljava/util/List;", "getInternalLocale", "locale", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecognizerAILanguages {

    @NotNull
    public static final SpenRecognizerAILanguages INSTANCE = new SpenRecognizerAILanguages();

    @NotNull
    private static final String TAG = "AILanguages";

    @NotNull
    private static final Map<String, String> mHwrLocaleMap;

    static {
        Map.Entry[] entryArr = {new AbstractMap.SimpleImmutableEntry("ko_KR", "ko_KR"), new AbstractMap.SimpleImmutableEntry(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE), new AbstractMap.SimpleImmutableEntry("en_GB", "en_GB"), new AbstractMap.SimpleImmutableEntry("en_IN", "en_GB"), new AbstractMap.SimpleImmutableEntry("en_AU", "en_AU"), new AbstractMap.SimpleImmutableEntry("fr_FR", "fr_FR"), new AbstractMap.SimpleImmutableEntry("de_DE", "de_DE"), new AbstractMap.SimpleImmutableEntry("it_IT", "it_IT"), new AbstractMap.SimpleImmutableEntry("es_ES", "es_ES"), new AbstractMap.SimpleImmutableEntry("es_MX", "es_MX"), new AbstractMap.SimpleImmutableEntry("es_US", "es_US"), new AbstractMap.SimpleImmutableEntry("pt_BR", "pt_BR"), new AbstractMap.SimpleImmutableEntry("zh_CN", "zh_CN"), new AbstractMap.SimpleImmutableEntry("ja_JP", "ja_JP"), new AbstractMap.SimpleImmutableEntry("pl_PL", "pl_PL"), new AbstractMap.SimpleImmutableEntry("hi_IN", "hi_IN"), new AbstractMap.SimpleImmutableEntry("th_TH", "th_TH"), new AbstractMap.SimpleImmutableEntry("vi_VN", "vi_VN"), new AbstractMap.SimpleImmutableEntry("ar", "ar"), new AbstractMap.SimpleImmutableEntry("ru_RU", "ru_RU"), new AbstractMap.SimpleImmutableEntry("fr_CA", "fr_CA"), new AbstractMap.SimpleImmutableEntry("zh_HK", "zh_HK"), new AbstractMap.SimpleImmutableEntry("id_ID", "id_ID"), new AbstractMap.SimpleImmutableEntry("zh_TW", "zh_TW"), new AbstractMap.SimpleImmutableEntry("nl_NL", "nl_NL"), new AbstractMap.SimpleImmutableEntry("pt_PT", "pt_PT"), new AbstractMap.SimpleImmutableEntry("sv_SE", "sv_SE"), new AbstractMap.SimpleImmutableEntry("tr_TR", "tr_TR"), new AbstractMap.SimpleImmutableEntry("ro_RO", "ro_RO")};
        HashMap map = new HashMap(29);
        for (int i = 0; i < 29; i++) {
            Map.Entry entry = entryArr[i];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(key, "duplicate key: "));
            }
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "ofEntries(...)");
        mHwrLocaleMap = mapUnmodifiableMap;
    }

    private SpenRecognizerAILanguages() {
    }

    @NotNull
    public static final List<String> getAvailableLanguages() {
        return new ArrayList(new HashSet(mHwrLocaleMap.keySet()));
    }

    @JvmStatic
    public static /* synthetic */ void getAvailableLanguages$annotations() {
    }

    @JvmStatic
    @Nullable
    public static final String getInternalLocale(@NotNull String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Map<String, String> map = mHwrLocaleMap;
        if (!map.containsKey(locale)) {
            return locale;
        }
        String str = map.get(locale);
        Log.i(TAG, AbstractC0541b.m775q("getInternalLocale : [", locale, "] -> [", str, "]"));
        return str;
    }
}
