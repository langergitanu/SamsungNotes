package com.samsung.android.app.sdk.deepsky.contribution;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.app.sdk.deepsky.common.AccessControl;
import com.samsung.android.app.sdk.deepsky.common.AppSearch;
import com.samsung.android.app.sdk.deepsky.common.ShortcutInfoDocument;
import com.samsung.android.app.sdk.deepsky.common.ShortcutManagerWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0017J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rH\u0017J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contribution/ContributionImpl;", "Lcom/samsung/android/app/sdk/deepsky/contribution/Contribution;", "Lcom/samsung/android/app/sdk/deepsky/common/AccessControl;", "context", "Landroid/content/Context;", "appSearch", "Lcom/samsung/android/app/sdk/deepsky/common/AppSearch;", "shortcutManagerWrapper", "Lcom/samsung/android/app/sdk/deepsky/common/ShortcutManagerWrapper;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/common/AppSearch;Lcom/samsung/android/app/sdk/deepsky/common/ShortcutManagerWrapper;)V", "addDynamicShortcuts", "", "shortcutInfoList", "", "Landroid/content/pm/ShortcutInfo;", "checkIfAccessAllowed", "pushDynamicShortcut", "shortcutInfo", "addToLauncherOnly", "permissions", "", "removeDynamicShortcut", "shortcutId", "", "reportShortcutUsed", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContributionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContributionImpl.kt\ncom/samsung/android/app/sdk/deepsky/contribution/ContributionImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n766#2:86\n857#2,2:87\n2333#2,14:89\n1#3:103\n*S KotlinDebug\n*F\n+ 1 ContributionImpl.kt\ncom/samsung/android/app/sdk/deepsky/contribution/ContributionImpl\n*L\n30#1:86\n30#1:87,2\n30#1:89,14\n*E\n"})
public final class ContributionImpl implements Contribution, AccessControl {

    @NotNull
    private static final String TAG = "Contribution";

    @NotNull
    private final AppSearch appSearch;

    @NotNull
    private final Context context;

    @NotNull
    private final ShortcutManagerWrapper shortcutManagerWrapper;

    public ContributionImpl(@NotNull Context context, @NotNull AppSearch appSearch, @NotNull ShortcutManagerWrapper shortcutManagerWrapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appSearch, "appSearch");
        Intrinsics.checkNotNullParameter(shortcutManagerWrapper, "shortcutManagerWrapper");
        this.context = context;
        this.appSearch = appSearch;
        this.shortcutManagerWrapper = shortcutManagerWrapper;
    }

    @Override // com.samsung.android.app.sdk.deepsky.contribution.Contribution
    public boolean addDynamicShortcuts(@NotNull List<ShortcutInfo> shortcutInfoList) {
        Intrinsics.checkNotNullParameter(shortcutInfoList, "shortcutInfoList");
        Log.i(TAG, "addDynamicShortcuts");
        this.shortcutManagerWrapper.addDynamicShortcuts(shortcutInfoList);
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.AccessControl
    public boolean checkIfAccessAllowed() {
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.contribution.Contribution
    @RequiresApi(30)
    public boolean pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo, boolean addToLauncherOnly) {
        Object obj;
        String id;
        Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        Log.i(TAG, "pushDynamicShortcut - visible");
        if (!addToLauncherOnly) {
            this.shortcutManagerWrapper.pushDynamicShortcut(shortcutInfo);
            return true;
        }
        List<ShortcutInfo> shortcuts = this.shortcutManagerWrapper.getShortcuts(3);
        if (shortcuts.size() == this.shortcutManagerWrapper.getMaxShortcutCountPerActivity()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : shortcuts) {
                if (((ShortcutInfo) obj2).isDynamic()) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    int rank = ((ShortcutInfo) next).getRank();
                    do {
                        Object next2 = it.next();
                        int rank2 = ((ShortcutInfo) next2).getRank();
                        if (rank > rank2) {
                            next = next2;
                            rank = rank2;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            ShortcutInfo shortcutInfo2 = (ShortcutInfo) obj;
            if (shortcutInfo2 != null && (id = shortcutInfo2.getId()) != null) {
                this.shortcutManagerWrapper.removeDynamicShortcuts(CollectionsKt.listOf(id));
            }
        }
        this.shortcutManagerWrapper.addDynamicShortcuts(CollectionsKt.listOf(shortcutInfo));
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.contribution.Contribution
    public boolean removeDynamicShortcut(@NotNull String shortcutId) {
        Intrinsics.checkNotNullParameter(shortcutId, "shortcutId");
        Log.i(TAG, "removeDynamicShortcut");
        this.shortcutManagerWrapper.removeDynamicShortcuts(CollectionsKt.listOf(shortcutId));
        if (Build.VERSION.SDK_INT < 33) {
            return true;
        }
        this.appSearch.removeDocument(shortcutId);
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.contribution.Contribution
    public boolean reportShortcutUsed(@NotNull String shortcutId) {
        Intrinsics.checkNotNullParameter(shortcutId, "shortcutId");
        Log.i(TAG, "reportShortcutUsed");
        this.shortcutManagerWrapper.reportShortcutUsed(shortcutId);
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.contribution.Contribution
    @RequiresApi(33)
    public boolean pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo, @NotNull List<Integer> permissions) {
        Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Log.i(TAG, "pushDynamicShortcut - hidden");
        AppSearch appSearch = this.appSearch;
        ShortcutInfoDocument.Companion companion = ShortcutInfoDocument.INSTANCE;
        boolean zPutDocument = appSearch.putDocument(companion.getSchema(), companion.toGenericDocument(shortcutInfo), permissions, false);
        this.shortcutManagerWrapper.pushDynamicShortcut(shortcutInfo);
        return zPutDocument;
    }
}
