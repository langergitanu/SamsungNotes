package com.samsung.android.sdk.pen.recogengine.resources;

import com.samsung.android.sdk.handwriting.LanguageID;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u001d\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/resources/SpenResourceID;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mMultiDbMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getLanguageID", "", "language", "getLanguageIDs", "", "languageList", "languages", "([Ljava/lang/String;)Ljava/util/List;", "getPriorityLocaleList", "getDefaultLanguageCode", "getLanguageCodeFrom", "locale", "getSecondaryLanguages", "(Ljava/lang/String;)[Ljava/lang/String;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenResourceID {

    @NotNull
    private static final String TAG = "SpenResourceID";

    @NotNull
    public static final SpenResourceID INSTANCE = new SpenResourceID();

    @NotNull
    private static final HashMap<String, String[]> mMultiDbMap = new HashMap<String, String[]>() { // from class: com.samsung.android.sdk.pen.recogengine.resources.SpenResourceID$mMultiDbMap$1
        {
            put("ko_KR", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
            put("ko_KR_NoHanJa", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
            put("ja_JP", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
            put("zh_CN", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
            put("zh_HK", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
            put("zh_TW", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof String[]) {
                return containsValue((String[]) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, String[]>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<String, String[]>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (String[]) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<String[]> getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<String[]> values() {
            return getValues();
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        public /* bridge */ boolean containsValue(String[] strArr) {
            return super.containsValue((Object) strArr);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String[] get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public final /* bridge */ String[] getOrDefault(Object obj, String[] strArr) {
            return !(obj instanceof String) ? strArr : getOrDefault((String) obj, strArr);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof String[])) {
                return remove((String) obj, (String[]) obj2);
            }
            return false;
        }

        public /* bridge */ String[] get(String str) {
            return (String[]) super.get((Object) str);
        }

        public /* bridge */ String[] getOrDefault(String str, String[] strArr) {
            return (String[]) super.getOrDefault((Object) str, strArr);
        }

        public /* bridge */ boolean remove(String str, String[] strArr) {
            return super.remove((Object) str, (Object) strArr);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String[] remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ String[] remove(String str) {
            return (String[]) super.remove((Object) str);
        }
    };

    private SpenResourceID() {
    }

    @NotNull
    public final String getDefaultLanguageCode(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        String defaultLanguageCode = LanguageID.getDefaultLanguageCode(language);
        Intrinsics.checkNotNullExpressionValue(defaultLanguageCode, "getDefaultLanguageCode(...)");
        return defaultLanguageCode;
    }

    @NotNull
    public final String getLanguageCodeFrom(@NotNull String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String languageCodeFrom = LanguageID.getLanguageCodeFrom(locale);
        Intrinsics.checkNotNullExpressionValue(languageCodeFrom, "getLanguageCodeFrom(...)");
        return languageCodeFrom;
    }

    public final int getLanguageID(@Nullable String language) {
        return LanguageID.getID(language);
    }

    @NotNull
    public final List<Integer> getLanguageIDs(@Nullable List<String> languageList) {
        List<Integer> iDs = LanguageID.getIDs(languageList);
        Intrinsics.checkNotNullExpressionValue(iDs, "getIDs(...)");
        return iDs;
    }

    @NotNull
    public final List<String> getPriorityLocaleList(@Nullable String language) {
        List<String> priorityLocaleList = LanguageID.getPriorityLocaleList(language);
        Intrinsics.checkNotNullExpressionValue(priorityLocaleList, "getPriorityLocaleList(...)");
        return priorityLocaleList;
    }

    @Nullable
    public final String[] getSecondaryLanguages(@Nullable String language) {
        HashMap<String, String[]> map = mMultiDbMap;
        if (map.containsKey(language)) {
            return map.get(language);
        }
        return null;
    }

    @NotNull
    public final List<Integer> getLanguageIDs(@Nullable String[] languages) {
        List<Integer> iDs = LanguageID.getIDs(languages);
        Intrinsics.checkNotNullExpressionValue(iDs, "getIDs(...)");
        return iDs;
    }
}
