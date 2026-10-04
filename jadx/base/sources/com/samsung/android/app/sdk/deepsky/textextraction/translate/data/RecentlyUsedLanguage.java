package com.samsung.android.app.sdk.deepsky.textextraction.translate.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tJ\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/RecentlyUsedLanguage;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "sourceLanguages", "", "", "targetLanguages", "getRecentlyUsedLanguages", "", "isSource", "", "updateLanguages", "", "currentSourceLang", "currentTargetLang", "splitToMutableList", "separator", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RecentlyUsedLanguage {

    @NotNull
    private static final String RECENTLY_USED_LANGUAGE_PREFERENCE = "com.samsung.android.app.deepsky.RECENTLY_USED_LANGUAGES";

    @NotNull
    private static final String RECENTLY_USED_LANGUAGE_SEPARATOR = ";";

    @NotNull
    private static final String RECENTLY_USED_SOURCE_LANGUAGES = "RECENTLY_USED_SOURCE_LANGUAGES";

    @NotNull
    private static final String RECENTLY_USED_TARGET_LANGUAGES = "RECENTLY_USED_TARGET_LANGUAGES";

    @NotNull
    private static final String TAG = "RecentlyUsedLanguage";

    @NotNull
    private final Context context;

    @NotNull
    private final SharedPreferences sharedPreferences;

    @NotNull
    private final List<String> sourceLanguages;

    @NotNull
    private final List<String> targetLanguages;

    public RecentlyUsedLanguage(@NotNull Context context) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(RECENTLY_USED_LANGUAGE_PREFERENCE, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ntext.MODE_PRIVATE,\n    )");
        this.sharedPreferences = sharedPreferences;
        String string = sharedPreferences.getString(RECENTLY_USED_SOURCE_LANGUAGES, "");
        string = string == null ? "" : string;
        String string2 = sharedPreferences.getString(RECENTLY_USED_TARGET_LANGUAGES, "");
        String str = string2 != null ? string2 : "";
        List<String> listSplitToMutableList = splitToMutableList(string, ";");
        this.sourceLanguages = listSplitToMutableList;
        List<String> listSplitToMutableList2 = splitToMutableList(str, ";");
        this.targetLanguages = listSplitToMutableList2;
        LibLogger.m5432i(TAG, "Recently used source languages: \"" + CollectionsKt.m13955n(listSplitToMutableList, null, null, null, null, 63) + "\"");
        LibLogger.m5432i(TAG, "Recently used target languages: \"" + CollectionsKt.m13955n(listSplitToMutableList2, null, null, null, null, 63) + "\"");
    }

    private final List<String> splitToMutableList(String str, String str2) {
        return str.length() == 0 ? new ArrayList() : CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default(str, new String[]{str2}, false, 0, 6, (Object) null));
    }

    @NotNull
    public final List<String> getRecentlyUsedLanguages(boolean isSource) {
        return isSource ? this.sourceLanguages : this.targetLanguages;
    }

    public final void updateLanguages(@NotNull String currentSourceLang, @NotNull String currentTargetLang) {
        Intrinsics.checkNotNullParameter(currentSourceLang, "currentSourceLang");
        Intrinsics.checkNotNullParameter(currentTargetLang, "currentTargetLang");
        if (!Intrinsics.areEqual(currentSourceLang, LangPackConfigConstants.LANGUAGE_CODE_AUTO)) {
            List<String> list = this.sourceLanguages;
            list.remove(currentSourceLang);
            list.add(0, currentSourceLang);
        }
        List<String> list2 = this.targetLanguages;
        list2.remove(currentTargetLang);
        list2.add(0, currentTargetLang);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(RECENTLY_USED_SOURCE_LANGUAGES, CollectionsKt.m13955n(this.sourceLanguages, ";", null, null, null, 62));
        editorEdit.putString(RECENTLY_USED_TARGET_LANGUAGES, CollectionsKt.m13955n(this.targetLanguages, ";", null, null, null, 62));
        editorEdit.apply();
    }
}
