package androidx.compose.p109ui.platform;

import androidx.compose.p109ui.focus.FocusDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public /* synthetic */ class AndroidComposeView$focusOwner$3 extends FunctionReferenceImpl implements Function1<FocusDirection, Boolean> {
    public AndroidComposeView$focusOwner$3(Object obj) {
        super(1, obj, AndroidComposeView.class, "onMoveFocusInChildren", "onMoveFocusInChildren-3ESFkO8(I)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FocusDirection focusDirection) {
        return m20179invoke3ESFkO8(focusDirection.getValue());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
    public final Boolean m20179invoke3ESFkO8(int i) {
        return Boolean.valueOf(((AndroidComposeView) this.receiver).m20171onMoveFocusInChildren3ESFkO8(i));
    }
}
