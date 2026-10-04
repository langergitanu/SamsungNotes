package com.samsung.android.app.sdk.deepsky.common;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCallerImpl;", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "context", "Landroid/content/Context;", "tag", "", "(Landroid/content/Context;Ljava/lang/String;)V", "applicationContext", "kotlin.jvm.PlatformType", "isContentProviderSupported", "", "sendCommand", "Landroid/os/Bundle;", "uri", "Landroid/net/Uri;", "method", "bundle", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ContentProviderCallerImpl implements ContentProviderCaller {

    @NotNull
    private static final String TAG = "Requester";

    @NotNull
    private static final String URI = "content://com.samsung.android.app.deepsky.DeepSkyQuery.provider";
    private final Context applicationContext;

    @NotNull
    private final String tag;

    public ContentProviderCallerImpl(@NotNull Context context, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.applicationContext = context.getApplicationContext();
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller
    public boolean isContentProviderSupported() {
        try {
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = this.applicationContext.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.samsung.android.app.deepsky.DeepSkyQuery.provider"));
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                return false;
            }
            Log.i(TAG, "isContentProviderSupported = true");
            contentProviderClientAcquireUnstableContentProviderClient.close();
            return true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller
    @Nullable
    public Bundle sendCommand(@NotNull String method, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Uri uri = Uri.parse("content://com.samsung.android.app.deepsky.DeepSkyQuery.provider");
        Intrinsics.checkNotNullExpressionValue(uri, "parse(URI)");
        return sendCommand(uri, method, bundle);
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller
    @Nullable
    public Bundle sendCommand(@NotNull Uri uri, @NotNull String method, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        try {
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = this.applicationContext.getContentResolver().acquireUnstableContentProviderClient(uri);
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                return null;
            }
            Log.d(TAG, "[" + this.tag + "] packageName = " + this.applicationContext.getPackageName());
            return contentProviderClientAcquireUnstableContentProviderClient.call(method, this.applicationContext.getPackageName(), bundle);
        } catch (Exception e) {
            Log.e(TAG, "[" + this.tag + "] sendCommand = " + e);
            return null;
        }
    }

    public /* synthetic */ ContentProviderCallerImpl(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str);
    }
}
