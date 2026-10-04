package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.text.FontFamily;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.unit.ColorProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/TypedTextListData;", "Landroidx/glance/oneui/template/TypedTextData;", "items", "", "orientation", "Landroidx/glance/oneui/template/Orientation;", "textAlign", "Landroidx/glance/text/TextAlign;", "(Ljava/util/List;Landroidx/glance/oneui/template/Orientation;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getItems", "()Ljava/util/List;", "getOrientation", "()Landroidx/glance/oneui/template/Orientation;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TypedTextListData extends TypedTextData {
    public static final int $stable = 8;

    @NotNull
    private final List<TypedTextData> items;

    @NotNull
    private final Orientation orientation;

    public /* synthetic */ TypedTextListData(List list, Orientation orientation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, orientation, i);
    }

    @NotNull
    public final List<TypedTextData> getItems() {
        return this.items;
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    public /* synthetic */ TypedTextListData(List list, Orientation orientation, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? Orientation.Vertical : orientation, (i2 & 4) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    private TypedTextListData(List<? extends TypedTextData> items, Orientation orientation, int i) {
        super("", TextType.INSTANCE.m21695getUnknowngxbDmow$glance_oneui_template_release(), (ColorProvider) null, i, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 65524, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.items = items;
        this.orientation = orientation;
    }
}
