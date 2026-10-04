package androidx.glance.oneui.common.sizepolicy.flip;

import android.content.Context;
import android.util.Size;
import android.util.SizeF;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ<\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/flip/FlipSizePolicyManager;", "", "()V", "convertDpToSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "context", "Landroid/content/Context;", "width", "", "height", "isEasyMode", "", "screenSize", "Landroid/util/Size;", "convertDpToSize-h6tS73U", "(Landroid/content/Context;FFZLandroid/util/Size;)I", "convertSizeToDp", "Lkotlin/Pair;", "Landroid/util/SizeF;", "size", "convertSizeToDp-qK15sPk", "(Landroid/content/Context;IZLandroid/util/Size;)Lkotlin/Pair;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class FlipSizePolicyManager {

    @NotNull
    public static final FlipSizePolicyManager INSTANCE = new FlipSizePolicyManager();

    private FlipSizePolicyManager() {
    }

    /* JADX INFO: renamed from: convertDpToSize-h6tS73U, reason: not valid java name */
    public final int m21627convertDpToSizeh6tS73U(@NotNull Context context, float width, float height, boolean isEasyMode, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        return FlipPolicy.INSTANCE.m21625convertDpToSizeh6tS73U(context, width, height, isEasyMode, screenSize);
    }

    @NotNull
    /* JADX INFO: renamed from: convertSizeToDp-qK15sPk, reason: not valid java name */
    public final Pair<SizeF, SizeF> m21628convertSizeToDpqK15sPk(@NotNull Context context, int size, boolean isEasyMode, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        return FlipPolicy.INSTANCE.m21626convertSizeToDpqK15sPk(context, size, isEasyMode, screenSize);
    }
}
