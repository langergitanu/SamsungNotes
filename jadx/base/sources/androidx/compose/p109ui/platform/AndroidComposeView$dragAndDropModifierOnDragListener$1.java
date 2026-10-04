package androidx.compose.p109ui.platform;

import androidx.compose.p109ui.draganddrop.DragAndDropTransferData;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public /* synthetic */ class AndroidComposeView$dragAndDropModifierOnDragListener$1 extends FunctionReferenceImpl implements Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, ? extends Unit>, Boolean> {
    public AndroidComposeView$dragAndDropModifierOnDragListener$1(Object obj) {
        super(3, obj, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(DragAndDropTransferData dragAndDropTransferData, Size size, Function1<? super DrawScope, ? extends Unit> function1) {
        return m20177invoke12SF9DM(dragAndDropTransferData, size.getPackedValue(), function1);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
    public final Boolean m20177invoke12SF9DM(@NotNull DragAndDropTransferData dragAndDropTransferData, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        return Boolean.valueOf(((AndroidComposeView) this.receiver).m20175startDrag12SF9DM(dragAndDropTransferData, j, function1));
    }
}
