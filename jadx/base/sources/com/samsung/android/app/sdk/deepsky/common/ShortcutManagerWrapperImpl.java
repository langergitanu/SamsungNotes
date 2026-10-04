package com.samsung.android.app.sdk.deepsky.common;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.util.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/ShortcutManagerWrapperImpl;", "Lcom/samsung/android/app/sdk/deepsky/common/ShortcutManagerWrapper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addDynamicShortcuts", "", "shortcutInfoList", "", "Landroid/content/pm/ShortcutInfo;", "getMaxShortcutCountPerActivity", "", "getShortcuts", "matchFlags", "pushDynamicShortcut", "", "shortcutInfo", "removeDynamicShortcuts", "shortcutIds", "", "reportShortcutUsed", "shortcutId", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nShortcutManagerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShortcutManagerWrapper.kt\ncom/samsung/android/app/sdk/deepsky/common/ShortcutManagerWrapperImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
public final class ShortcutManagerWrapperImpl implements ShortcutManagerWrapper {

    @NotNull
    private static final String TAG = "ShortcutManagerWrapper";

    @NotNull
    private final Context context;

    public ShortcutManagerWrapperImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ShortcutManagerWrapper
    public boolean addDynamicShortcuts(@NotNull List<ShortcutInfo> shortcutInfoList) {
        Intrinsics.checkNotNullParameter(shortcutInfoList, "shortcutInfoList");
        try {
            Result.Companion companion = Result.INSTANCE;
            return ((ShortcutManager) this.context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(shortcutInfoList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(Result.m22215constructorimpl(ResultKt.createFailure(th)));
            if (thM22218exceptionOrNullimpl == null) {
                return false;
            }
            Log.e(TAG, String.valueOf(thM22218exceptionOrNullimpl.getMessage()));
            return false;
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ShortcutManagerWrapper
    public int getMaxShortcutCountPerActivity() {
        try {
            Result.Companion companion = Result.INSTANCE;
            return ((ShortcutManager) this.context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(Result.m22215constructorimpl(ResultKt.createFailure(th)));
            if (thM22218exceptionOrNullimpl == null) {
                return 0;
            }
            Log.e(TAG, String.valueOf(thM22218exceptionOrNullimpl.getMessage()));
            return 0;
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ShortcutManagerWrapper
    @NotNull
    public List<ShortcutInfo> getShortcuts(int matchFlags) {
        try {
            Result.Companion companion = Result.INSTANCE;
            List<ShortcutInfo> shortcuts = ((ShortcutManager) this.context.getSystemService(ShortcutManager.class)).getShortcuts(matchFlags);
            Intrinsics.checkNotNullExpressionValue(shortcuts, "shortcutManager.getShortcuts(matchFlags)");
            return shortcuts;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(Result.m22215constructorimpl(ResultKt.createFailure(th)));
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(TAG, String.valueOf(thM22218exceptionOrNullimpl.getMessage()));
            }
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ShortcutManagerWrapper
    public void pushDynamicShortcut(@NotNull ShortcutInfo shortcutInfo) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        try {
            Result.Companion companion = Result.INSTANCE;
            ((ShortcutManager) this.context.getSystemService(ShortcutManager.class)).pushDynamicShortcut(shortcutInfo);
            objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            Log.e(TAG, String.valueOf(thM22218exceptionOrNullimpl.getMessage()));
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ShortcutManagerWrapper
    public void removeDynamicShortcuts(@NotNull List<String> shortcutIds) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(shortcutIds, "shortcutIds");
        try {
            Result.Companion companion = Result.INSTANCE;
            ((ShortcutManager) this.context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(shortcutIds);
            objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            Log.e(TAG, String.valueOf(thM22218exceptionOrNullimpl.getMessage()));
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ShortcutManagerWrapper
    public void reportShortcutUsed(@NotNull String shortcutId) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(shortcutId, "shortcutId");
        try {
            Result.Companion companion = Result.INSTANCE;
            ((ShortcutManager) this.context.getSystemService(ShortcutManager.class)).reportShortcutUsed(shortcutId);
            objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            Log.e(TAG, String.valueOf(thM22218exceptionOrNullimpl.getMessage()));
        }
    }
}
