package androidx.glance.appwidget;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/WidgetLayoutImpl31;", "", "()V", "toProto", "Landroidx/glance/appwidget/proto/LayoutProto$DimensionType;", TypedValues.Custom.S_DIMENSION, "Landroidx/glance/unit/Dimension;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class WidgetLayoutImpl31 {

    @NotNull
    public static final WidgetLayoutImpl31 INSTANCE = new WidgetLayoutImpl31();

    private WidgetLayoutImpl31() {
    }

    @DoNotInline
    @NotNull
    public final LayoutProto.DimensionType toProto(@NotNull Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        return dimension instanceof Dimension.Expand ? LayoutProto.DimensionType.EXPAND : LayoutProto.DimensionType.WRAP;
    }
}
