package androidx.compose.foundation.text.selection;

import androidx.compose.p109ui.geometry.Offset;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class C1412xf8ffea21 implements OffsetProvider, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    public C1412xf8ffea21(Function0 function0) {
        this.function = function0;
    }

    public final boolean equals(@Nullable Object obj) {
        if ((obj instanceof OffsetProvider) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    @NotNull
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.compose.foundation.text.selection.OffsetProvider
    /* JADX INFO: renamed from: provide-F1C5BW0 */
    public final /* synthetic */ long mo16143provideF1C5BW0() {
        return ((Offset) this.function.invoke()).getPackedValue();
    }
}
