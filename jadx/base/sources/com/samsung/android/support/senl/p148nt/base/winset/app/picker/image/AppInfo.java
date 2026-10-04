package com.samsung.android.support.senl.p148nt.base.winset.app.picker.image;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/AppInfo;", "", "titleString", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "appType", "", "packageName", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/content/Intent;ILjava/lang/String;)V", "getTitleString", "()Ljava/lang/String;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "getIntent", "()Landroid/content/Intent;", "getAppType", "()I", "getPackageName", "equals", "", "info", "hashCode", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppInfo {
    private final int appType;

    @NotNull
    private final Drawable iconDrawable;

    @NotNull
    private final Intent intent;

    @NotNull
    private final String packageName;

    @NotNull
    private final String titleString;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static int APP_CAMERA = 1;

    @JvmField
    public static int APP_GALLERY = 2;
    private static int APP_MORE_APPS = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/AppInfo$Companion;", "", "<init>", "()V", "APP_CAMERA", "", "APP_GALLERY", "APP_MORE_APPS", "getAPP_MORE_APPS", "()I", "setAPP_MORE_APPS", "(I)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getAPP_MORE_APPS() {
            return AppInfo.APP_MORE_APPS;
        }

        public final void setAPP_MORE_APPS(int i) {
            AppInfo.APP_MORE_APPS = i;
        }

        private Companion() {
        }
    }

    public AppInfo(@NotNull String titleString, @NotNull Drawable iconDrawable, @NotNull Intent intent, int i, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(titleString, "titleString");
        Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.titleString = titleString;
        this.iconDrawable = iconDrawable;
        this.intent = intent;
        this.appType = i;
        this.packageName = packageName;
    }

    public boolean equals(@Nullable Object info) {
        if (info instanceof AppInfo) {
            return StringsKt__StringsJVMKt.equals(this.packageName, ((AppInfo) info).packageName, true);
        }
        return false;
    }

    public final int getAppType() {
        return this.appType;
    }

    @NotNull
    public final Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    @NotNull
    public final Intent getIntent() {
        return this.intent;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getTitleString() {
        return this.titleString;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
