package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/runtime/RememberObserverHolder;", "", "wrapped", "Landroidx/compose/runtime/RememberObserver;", "after", "Landroidx/compose/runtime/Anchor;", "(Landroidx/compose/runtime/RememberObserver;Landroidx/compose/runtime/Anchor;)V", "getAfter", "()Landroidx/compose/runtime/Anchor;", "setAfter", "(Landroidx/compose/runtime/Anchor;)V", "getWrapped", "()Landroidx/compose/runtime/RememberObserver;", "setWrapped", "(Landroidx/compose/runtime/RememberObserver;)V", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RememberObserverHolder {
    public static final int $stable = 8;

    @Nullable
    private Anchor after;

    @NotNull
    private RememberObserver wrapped;

    public RememberObserverHolder(@NotNull RememberObserver rememberObserver, @Nullable Anchor anchor) {
        this.wrapped = rememberObserver;
        this.after = anchor;
    }

    @Nullable
    public final Anchor getAfter() {
        return this.after;
    }

    @NotNull
    public final RememberObserver getWrapped() {
        return this.wrapped;
    }

    public final void setAfter(@Nullable Anchor anchor) {
        this.after = anchor;
    }

    public final void setWrapped(@NotNull RememberObserver rememberObserver) {
        this.wrapped = rememberObserver;
    }
}
