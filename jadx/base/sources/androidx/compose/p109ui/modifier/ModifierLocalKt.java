package androidx.compose.p109ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005"}, m13886d2 = {"modifierLocalOf", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "T", "defaultFactory", "Lkotlin/Function0;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ModifierLocalKt {
    @NotNull
    public static final <T> ProvidableModifierLocal<T> modifierLocalOf(@NotNull Function0<? extends T> function0) {
        return new ProvidableModifierLocal<>(function0);
    }
}
