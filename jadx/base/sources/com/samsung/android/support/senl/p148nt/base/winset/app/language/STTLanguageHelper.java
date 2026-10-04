package com.samsung.android.support.senl.p148nt.base.winset.app.language;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R.\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR:\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/STTLanguageHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", STTLanguageHelper.STT_RECENT_USED, "localeTag", "defaultLocaleTag", "getDefaultLocaleTag$annotations", "getDefaultLocaleTag", "()Ljava/lang/String;", "setDefaultLocaleTag", "(Ljava/lang/String;)V", "values", "", "recentLanguageSet", "getRecentLanguageSet$annotations", "getRecentLanguageSet", "()Ljava/util/Set;", "setRecentLanguageSet", "(Ljava/util/Set;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTLanguageHelper {

    @NotNull
    public static final STTLanguageHelper INSTANCE = new STTLanguageHelper();

    @NotNull
    private static final String STT_RECENT_USED = "STT_RECENT_USED";

    @NotNull
    private static final String TAG = "STTLanguageHelper";

    private STTLanguageHelper() {
    }

    @Nullable
    public static final String getDefaultLocaleTag() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getString(SettingsConstants.SETTINGS_STT_LANGUAGE, null);
    }

    @JvmStatic
    public static /* synthetic */ void getDefaultLocaleTag$annotations() {
    }

    @Nullable
    public static final Set<String> getRecentLanguageSet() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getStringSet(STT_RECENT_USED, new HashSet());
    }

    @JvmStatic
    public static /* synthetic */ void getRecentLanguageSet$annotations() {
    }

    public static final void setDefaultLocaleTag(@Nullable String str) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_STT_LANGUAGE, str);
    }

    public static final void setRecentLanguageSet(@Nullable Set<String> set) {
        if (set == null) {
            set = new HashSet<>();
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putStringSet(STT_RECENT_USED, set);
    }
}
