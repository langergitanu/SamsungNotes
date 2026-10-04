package androidx.compose.foundation.text;

import androidx.compose.p109ui.text.Placeholder;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tR$\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/foundation/text/InlineTextContent;", "", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "children", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/Placeholder;Lkotlin/jvm/functions/Function3;)V", "getChildren", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getPlaceholder", "()Landroidx/compose/ui/text/Placeholder;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class InlineTextContent {
    public static final int $stable = 0;

    @NotNull
    private final Function3<String, Composer, Integer, Unit> children;

    @NotNull
    private final Placeholder placeholder;

    /* JADX WARN: Multi-variable type inference failed */
    public InlineTextContent(@NotNull Placeholder placeholder, @NotNull Function3<? super String, ? super Composer, ? super Integer, Unit> function3) {
        this.placeholder = placeholder;
        this.children = function3;
    }

    @NotNull
    public final Function3<String, Composer, Integer, Unit> getChildren() {
        return this.children;
    }

    @NotNull
    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }
}
