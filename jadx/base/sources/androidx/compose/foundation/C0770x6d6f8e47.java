package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003JP\u0010\b\u001a\u00020\t*\u00020\n2A\u0010\b\u001a=\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\u0011H\u0096\u0001J&\u0010\u0012\u001a\u00020\t*\u00020\n2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0011H\u0096\u0001R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"androidx/compose/foundation/BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroidx/compose/foundation/SurfaceScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "onChanged", "", "Landroid/view/Surface;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "width", "height", "Lkotlin/ExtensionFunctionType;", "onDestroyed", "Lkotlin/Function1;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class C0770x6d6f8e47 implements SurfaceCoroutineScope, SurfaceScope, CoroutineScope {
    private final /* synthetic */ BaseAndroidExternalSurfaceState $$delegate_0;
    private final /* synthetic */ CoroutineScope $$delegate_1;

    public C0770x6d6f8e47(BaseAndroidExternalSurfaceState baseAndroidExternalSurfaceState, CoroutineScope coroutineScope) {
        this.$$delegate_0 = baseAndroidExternalSurfaceState;
        this.$$delegate_1 = coroutineScope;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_1.getCoroutineContext();
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onChanged(@NotNull Surface surface, @NotNull Function3<? super Surface, ? super Integer, ? super Integer, Unit> function3) {
        this.$$delegate_0.onChanged(surface, function3);
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onDestroyed(@NotNull Surface surface, @NotNull Function1<? super Surface, Unit> function1) {
        this.$$delegate_0.onDestroyed(surface, function1);
    }
}
