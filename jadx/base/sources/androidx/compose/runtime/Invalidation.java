package androidx.compose.runtime;

import com.samsung.scsp.common.Header;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/runtime/Invalidation;", "", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", Header.LOCATION, "", "instances", "(Landroidx/compose/runtime/RecomposeScopeImpl;ILjava/lang/Object;)V", "getInstances", "()Ljava/lang/Object;", "setInstances", "(Ljava/lang/Object;)V", "getLocation", "()I", "getScope", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "isInvalid", "", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class Invalidation {

    @Nullable
    private Object instances;
    private final int location;

    @NotNull
    private final RecomposeScopeImpl scope;

    public Invalidation(@NotNull RecomposeScopeImpl recomposeScopeImpl, int i, @Nullable Object obj) {
        this.scope = recomposeScopeImpl;
        this.location = i;
        this.instances = obj;
    }

    @Nullable
    public final Object getInstances() {
        return this.instances;
    }

    public final int getLocation() {
        return this.location;
    }

    @NotNull
    public final RecomposeScopeImpl getScope() {
        return this.scope;
    }

    public final boolean isInvalid() {
        return this.scope.isInvalidFor(this.instances);
    }

    public final void setInstances(@Nullable Object obj) {
        this.instances = obj;
    }
}
