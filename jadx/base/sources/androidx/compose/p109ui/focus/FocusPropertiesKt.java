package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusProperties;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FocusPropertiesKt {
    @NotNull
    public static final Modifier focusProperties(@NotNull Modifier modifier, @NotNull Function1<? super FocusProperties, Unit> function1) {
        return modifier.then(new FocusPropertiesElement(new C2040xfe8f9d59(function1)));
    }
}
