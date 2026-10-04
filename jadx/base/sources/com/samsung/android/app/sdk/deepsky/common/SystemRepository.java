package com.samsung.android.app.sdk.deepsky.common;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/SystemRepository;", "Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMainThreadDispatcher", "Ljava/util/concurrent/Executor;", "newBundle", "Landroid/os/Bundle;", "registerContentObserver", "", "uri", "Landroid/net/Uri;", "notifyForDescendants", "", "observer", "Landroid/database/ContentObserver;", "unregisterContentObserver", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SystemRepository implements SystemDataSource {

    @NotNull
    private final Context context;

    public SystemRepository(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.SystemDataSource
    @NotNull
    public Executor getMainThreadDispatcher() {
        Executor mainExecutor = this.context.getMainExecutor();
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "context.mainExecutor");
        return mainExecutor;
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.SystemDataSource
    @NotNull
    public Bundle newBundle() {
        return new Bundle();
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.SystemDataSource
    public void registerContentObserver(@NotNull Uri uri, boolean notifyForDescendants, @NotNull ContentObserver observer) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.context.getContentResolver().registerContentObserver(uri, notifyForDescendants, observer);
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.SystemDataSource
    public void unregisterContentObserver(@NotNull ContentObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.context.getContentResolver().unregisterContentObserver(observer);
    }
}
