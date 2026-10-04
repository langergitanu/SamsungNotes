package androidx.glance.oneui.template.component.padding;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.percent.PercentScope;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.oneui.template.component.percent.PercentValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\n"}, m13886d2 = {"Landroidx/glance/oneui/template/component/padding/PaddingValues;", "Landroidx/glance/oneui/template/component/percent/PercentValues;", "padding", "", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "scope", "Landroidx/glance/appwidget/percent/PercentScope;", "(FILandroidx/glance/appwidget/percent/PercentScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PaddingValues extends PercentValues {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final PaddingValues None;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/template/component/padding/PaddingValues$Companion;", "", "()V", "None", "Landroidx/glance/oneui/template/component/padding/PaddingValues;", "getNone", "()Landroidx/glance/oneui/template/component/padding/PaddingValues;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PaddingValues getNone() {
            return PaddingValues.None;
        }

        private Companion() {
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        None = new PaddingValues(0.0f, PercentSizePolicy.INSTANCE.m21380getAll3SpTkPA(), PercentScope.WidgetSize.INSTANCE, defaultConstructorMarker);
    }

    public /* synthetic */ PaddingValues(float f, int i, PercentScope percentScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i, percentScope);
    }

    public /* synthetic */ PaddingValues(float f, int i, PercentScope percentScope, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i2 & 2) != 0 ? PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA() : i, (i2 & 4) != 0 ? PercentScope.WidgetSize.INSTANCE : percentScope, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private PaddingValues(float f, int i, PercentScope scope) {
        super(f, i, scope, null);
        Intrinsics.checkNotNullParameter(scope, "scope");
    }
}
