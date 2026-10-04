package androidx.compose.p109ui.graphics.layer;

import android.view.View;
import java.lang.reflect.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/OutlineUtils;", "", "()V", "hasRetrievedMethod", "", "rebuildOutlineMethod", "Ljava/lang/reflect/Method;", "rebuildOutline", "view", "Landroid/view/View;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class OutlineUtils {

    @NotNull
    public static final OutlineUtils INSTANCE = new OutlineUtils();
    private static boolean hasRetrievedMethod;

    @Nullable
    private static Method rebuildOutlineMethod;

    private OutlineUtils() {
    }

    public final boolean rebuildOutline(@NotNull View view) {
        view.invalidateOutline();
        return true;
    }
}
