package com.samsung.android.app.sdk.deepsky.nedgesuggestion;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.app.sdk.deepsky.common.AccessControl;
import com.samsung.android.app.sdk.deepsky.common.AppSearch;
import com.samsung.android.app.sdk.deepsky.common.ShortcutInfoDocument;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/nedgesuggestion/NudgeSuggestionImpl;", "Lcom/samsung/android/app/sdk/deepsky/nedgesuggestion/NudgeSuggestion;", "Lcom/samsung/android/app/sdk/deepsky/common/AccessControl;", "context", "Landroid/content/Context;", "appSearch", "Lcom/samsung/android/app/sdk/deepsky/common/AppSearch;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/common/AppSearch;)V", "checkIfAccessAllowed", "", "pushDynamicShortcut", "shortcutInfo", "Landroid/content/pm/ShortcutInfo;", "removeDynamicShortcut", "shortcutId", "", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class NudgeSuggestionImpl implements NudgeSuggestion, AccessControl {

    @NotNull
    private static final String TAG = "NudgeSuggestion";

    @NotNull
    private final AppSearch appSearch;

    @NotNull
    private final Context context;

    public NudgeSuggestionImpl(@NotNull Context context, @NotNull AppSearch appSearch) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appSearch, "appSearch");
        this.context = context;
        this.appSearch = appSearch;
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.AccessControl
    public boolean checkIfAccessAllowed() {
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.nedgesuggestion.NudgeSuggestion
    @RequiresApi(33)
    public boolean pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo) {
        Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        Log.i(TAG, "pushDynamicShortcut - hidden");
        AppSearch appSearch = this.appSearch;
        ShortcutInfoDocument.Companion companion = ShortcutInfoDocument.INSTANCE;
        return appSearch.putDocument(companion.getSchema(), companion.toGenericDocument(shortcutInfo), CollectionsKt.emptyList(), true);
    }

    @Override // com.samsung.android.app.sdk.deepsky.nedgesuggestion.NudgeSuggestion
    @RequiresApi(33)
    public boolean removeDynamicShortcut(@NotNull String shortcutId) {
        Intrinsics.checkNotNullParameter(shortcutId, "shortcutId");
        Log.i(TAG, "removeDynamicShortcut");
        return this.appSearch.removeDocument(shortcutId);
    }
}
