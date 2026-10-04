package com.samsung.android.app.sdk.deepsky.nedgesuggestion;

import android.content.pm.ShortcutInfo;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/nedgesuggestion/NudgeSuggestion;", "", "pushDynamicShortcut", "", "shortcutInfo", "Landroid/content/pm/ShortcutInfo;", "removeDynamicShortcut", "shortcutId", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface NudgeSuggestion {
    @RequiresApi(33)
    boolean pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo);

    @RequiresApi(33)
    boolean removeDynamicShortcut(@NotNull String shortcutId);
}
