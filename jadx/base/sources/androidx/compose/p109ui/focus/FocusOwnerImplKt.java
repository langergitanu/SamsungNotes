package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.focus.FocusDirection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, m13886d2 = {"Warning", "", "is1dFocusSearch", "", "Landroidx/compose/ui/focus/FocusDirection;", "is1dFocusSearch-3ESFkO8", "(I)Z", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FocusOwnerImplKt {

    @NotNull
    private static final String Warning = "FocusRelatedWarning";

    /* JADX INFO: renamed from: is1dFocusSearch-3ESFkO8, reason: not valid java name */
    public static final boolean m18222is1dFocusSearch3ESFkO8(int i) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m18196equalsimpl0(i, companion.m18206getNextdhqQ8s())) {
            return true;
        }
        return FocusDirection.m18196equalsimpl0(i, companion.m18207getPreviousdhqQ8s());
    }
}
