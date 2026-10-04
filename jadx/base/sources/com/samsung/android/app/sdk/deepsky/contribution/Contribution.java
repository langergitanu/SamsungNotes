package com.samsung.android.app.sdk.deepsky.contribution;

import android.content.pm.ShortcutInfo;
import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003H'J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contribution/Contribution;", "", "addDynamicShortcuts", "", "shortcutInfoList", "", "Landroid/content/pm/ShortcutInfo;", "pushDynamicShortcut", "shortcutInfo", "addToLauncherOnly", "permissions", "", "removeDynamicShortcut", "shortcutId", "", "reportShortcutUsed", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface Contribution {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean pushDynamicShortcut$default(Contribution contribution, ShortcutInfo shortcutInfo, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pushDynamicShortcut");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return contribution.pushDynamicShortcut(shortcutInfo, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean pushDynamicShortcut$default(Contribution contribution, ShortcutInfo shortcutInfo, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pushDynamicShortcut");
            }
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            return contribution.pushDynamicShortcut(shortcutInfo, (List<Integer>) list);
        }
    }

    boolean addDynamicShortcuts(@NotNull List<ShortcutInfo> shortcutInfoList);

    @RequiresApi(33)
    boolean pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo, @NotNull List<Integer> permissions);

    @RequiresApi(30)
    boolean pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo, boolean addToLauncherOnly);

    boolean removeDynamicShortcut(@NotNull String shortcutId);

    boolean reportShortcutUsed(@NotNull String shortcutId);
}
