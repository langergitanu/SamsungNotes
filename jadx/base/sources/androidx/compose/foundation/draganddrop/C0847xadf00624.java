package androidx.compose.foundation.draganddrop;

import androidx.compose.p109ui.draw.CacheDrawScope;
import androidx.compose.p109ui.draw.DrawResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public /* synthetic */ class C0847xadf00624 extends FunctionReferenceImpl implements Function1<CacheDrawScope, DrawResult> {
    public C0847xadf00624(Object obj) {
        super(1, obj, CacheDrawScopeDragShadowCallback.class, "cachePicture", "cachePicture(Landroidx/compose/ui/draw/CacheDrawScope;)Landroidx/compose/ui/draw/DrawResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
        return ((CacheDrawScopeDragShadowCallback) this.receiver).cachePicture(cacheDrawScope);
    }
}
