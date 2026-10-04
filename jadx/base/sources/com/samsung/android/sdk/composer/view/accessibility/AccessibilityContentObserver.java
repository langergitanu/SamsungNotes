package com.samsung.android.sdk.composer.view.accessibility;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/os/Handler;)V", "register", "", "contentResolver", "Landroid/content/ContentResolver;", "unregister", "onChange", "selfChange", "", "uri", "Landroid/net/Uri;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class AccessibilityContentObserver extends ContentObserver {
    public AccessibilityContentObserver(@Nullable Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public abstract void onChange(boolean selfChange, @Nullable Uri uri);

    public final void register(@NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("accessibility_enabled"), false, this);
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("enabled_accessibility_services"), false, this);
    }

    public final void unregister(@NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        contentResolver.unregisterContentObserver(this);
    }
}
