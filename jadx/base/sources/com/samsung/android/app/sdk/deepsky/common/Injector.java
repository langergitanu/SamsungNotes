package com.samsung.android.app.sdk.deepsky.common;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/Injector;", "", "()V", "provideAppSearch", "Lcom/samsung/android/app/sdk/deepsky/common/AppSearch;", "context", "Landroid/content/Context;", "provideAppSearch$deepsky_sdk_smartsuggestion_6_1_0_release", "provideServiceCaller", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release", "provideShortcutManagerWrapper", "Lcom/samsung/android/app/sdk/deepsky/common/ShortcutManagerWrapper;", "provideShortcutManagerWrapper$deepsky_sdk_smartsuggestion_6_1_0_release", "shareSystemDatasource", "Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;", "shareSystemDatasource$deepsky_sdk_smartsuggestion_6_1_0_release", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Injector {

    @NotNull
    public static final Injector INSTANCE = new Injector();

    private Injector() {
    }

    @NotNull
    public final AppSearch provideAppSearch$deepsky_sdk_smartsuggestion_6_1_0_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AppSearchImpl(context);
    }

    @NotNull
    public final ContentProviderCaller provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ContentProviderCallerImpl(context, null, 2, null);
    }

    @NotNull
    /* JADX INFO: renamed from: provideShortcutManagerWrapper$deepsky_sdk_smartsuggestion_6_1_0_release */
    public final ShortcutManagerWrapper m5316x83c63589(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ShortcutManagerWrapperImpl(context);
    }

    @NotNull
    public final SystemDataSource shareSystemDatasource$deepsky_sdk_smartsuggestion_6_1_0_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SystemRepository(context);
    }
}
