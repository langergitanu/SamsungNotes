package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.modifier.ModifierLocalKt;
import androidx.compose.p109ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"ModifierLocalBeyondBoundsLayout", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getModifierLocalBeyondBoundsLayout", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BeyondBoundsLayoutKt {

    @NotNull
    private static final ProvidableModifierLocal<BeyondBoundsLayout> ModifierLocalBeyondBoundsLayout = ModifierLocalKt.modifierLocalOf(new Function0<BeyondBoundsLayout>() { // from class: androidx.compose.ui.layout.BeyondBoundsLayoutKt$ModifierLocalBeyondBoundsLayout$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final BeyondBoundsLayout invoke() {
            return null;
        }
    });

    @NotNull
    public static final ProvidableModifierLocal<BeyondBoundsLayout> getModifierLocalBeyondBoundsLayout() {
        return ModifierLocalBeyondBoundsLayout;
    }
}
