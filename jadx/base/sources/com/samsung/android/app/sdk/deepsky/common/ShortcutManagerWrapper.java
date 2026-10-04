package com.samsung.android.app.sdk.deepsky.common;

import android.content.pm.ShortcutInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H&J\u0016\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0010H&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/ShortcutManagerWrapper;", "", "addDynamicShortcuts", "", "shortcutInfoList", "", "Landroid/content/pm/ShortcutInfo;", "getMaxShortcutCountPerActivity", "", "getShortcuts", "matchFlags", "pushDynamicShortcut", "", "shortcutInfo", "removeDynamicShortcuts", "shortcutIds", "", "reportShortcutUsed", "shortcutId", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ShortcutManagerWrapper {
    boolean addDynamicShortcuts(@NotNull List<ShortcutInfo> shortcutInfoList);

    int getMaxShortcutCountPerActivity();

    @NotNull
    List<ShortcutInfo> getShortcuts(int matchFlags);

    void pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo);

    void removeDynamicShortcuts(@NotNull List<String> shortcutIds);

    void reportShortcutUsed(@NotNull String shortcutId);
}
