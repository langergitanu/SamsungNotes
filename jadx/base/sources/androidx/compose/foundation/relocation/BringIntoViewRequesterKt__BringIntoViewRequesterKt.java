package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0004"}, m13886d2 = {"BringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "bringIntoViewRequester", "Landroidx/compose/ui/Modifier;", "foundation_release"}, m13887k = 5, m13888mv = {1, 8, 0}, m13890xi = 48, m13891xs = "androidx/compose/foundation/relocation/BringIntoViewRequesterKt")
final /* synthetic */ class BringIntoViewRequesterKt__BringIntoViewRequesterKt {
    @ExperimentalFoundationApi
    @NotNull
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return new BringIntoViewRequesterImpl();
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier bringIntoViewRequester(@NotNull Modifier modifier, @NotNull BringIntoViewRequester bringIntoViewRequester) {
        return modifier.then(new BringIntoViewRequesterElement(bringIntoViewRequester));
    }
}
