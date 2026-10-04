package androidx.test.platform.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0003R0\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, m13886d2 = {"Landroidx/test/platform/app/AppComponentFactoryRegistry;", "", "()V", "value", "Landroid/app/AppComponentFactory;", "appComponentFactory", "getAppComponentFactory$annotations", "getAppComponentFactory", "()Landroid/app/AppComponentFactory;", "setAppComponentFactory", "(Landroid/app/AppComponentFactory;)V", "instantiateActivity", "Landroid/app/Activity;", "cl", "Ljava/lang/ClassLoader;", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "instantiateApplication", "Landroid/app/Application;", "isVersionCodeAtLeastP", "", "runner_monitor_java_androidx_test-monitor_kt"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AppComponentFactoryRegistry {

    @NotNull
    public static final AppComponentFactoryRegistry INSTANCE = new AppComponentFactoryRegistry();

    @Nullable
    private static volatile AppComponentFactory appComponentFactory;

    private AppComponentFactoryRegistry() {
    }

    @Nullable
    public static final AppComponentFactory getAppComponentFactory() {
        return appComponentFactory;
    }

    @JvmStatic
    @Nullable
    public static final Activity instantiateActivity(@NotNull ClassLoader cl, @NotNull String className, @Nullable Intent intent) {
        AppComponentFactory appComponentFactory2;
        Intrinsics.checkNotNullParameter(cl, "cl");
        Intrinsics.checkNotNullParameter(className, "className");
        if (!INSTANCE.isVersionCodeAtLeastP() || (appComponentFactory2 = appComponentFactory) == null) {
            return null;
        }
        return appComponentFactory2.instantiateActivity(cl, className, intent);
    }

    public static /* synthetic */ Activity instantiateActivity$default(ClassLoader classLoader, String str, Intent intent, int i, Object obj) {
        if ((i & 4) != 0) {
            intent = null;
        }
        return instantiateActivity(classLoader, str, intent);
    }

    @JvmStatic
    @Nullable
    public static final Application instantiateApplication(@NotNull ClassLoader cl, @NotNull String className) {
        AppComponentFactory appComponentFactory2;
        Intrinsics.checkNotNullParameter(cl, "cl");
        Intrinsics.checkNotNullParameter(className, "className");
        if (!INSTANCE.isVersionCodeAtLeastP() || (appComponentFactory2 = appComponentFactory) == null) {
            return null;
        }
        return appComponentFactory2.instantiateApplication(cl, className);
    }

    @ChecksSdkIntAtLeast(api = 28)
    private final boolean isVersionCodeAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static final void setAppComponentFactory(@Nullable AppComponentFactory appComponentFactory2) {
        if (!INSTANCE.isVersionCodeAtLeastP()) {
            throw new IllegalStateException("AppComponentFactoryRegistry is not supported on 'VERSION.SDK_INT < VERSION_CODES.P'");
        }
        appComponentFactory = appComponentFactory2;
    }

    @JvmStatic
    public static /* synthetic */ void getAppComponentFactory$annotations() {
    }
}
