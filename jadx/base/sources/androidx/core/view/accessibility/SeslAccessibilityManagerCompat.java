package androidx.core.view.accessibility;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.view.accessibility.SeslAccessibilityManagerReflector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/core/view/accessibility/SeslAccessibilityManagerCompat;", "", "()V", "getAccessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "context", "Landroid/content/Context;", "isScreenReaderEnabled", "", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class SeslAccessibilityManagerCompat {

    @NotNull
    public static final SeslAccessibilityManagerCompat INSTANCE = new SeslAccessibilityManagerCompat();

    private SeslAccessibilityManagerCompat() {
    }

    private final AccessibilityManager getAccessibilityManager(Context context) {
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return (AccessibilityManager) systemService;
    }

    public final boolean isScreenReaderEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SeslAccessibilityManagerReflector.isScreenReaderEnabled(getAccessibilityManager(context), false);
    }
}
