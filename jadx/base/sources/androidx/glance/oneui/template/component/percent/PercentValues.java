package androidx.glance.oneui.template.component.percent;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.percent.PercentScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/oneui/template/component/percent/PercentValues;", "", "percent", "", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "scope", "Landroidx/glance/appwidget/percent/PercentScope;", "(FILandroidx/glance/appwidget/percent/PercentScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPercent", "()F", "getPolicy-3SpTkPA", "()I", "I", "getScope", "()Landroidx/glance/appwidget/percent/PercentScope;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class PercentValues {
    public static final int $stable = PercentScope.$stable;
    private final float percent;
    private final int policy;

    @NotNull
    private final PercentScope scope;

    public /* synthetic */ PercentValues(float f, int i, PercentScope percentScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i, percentScope);
    }

    public final float getPercent() {
        return this.percent;
    }

    /* JADX INFO: renamed from: getPolicy-3SpTkPA, reason: not valid java name and from getter */
    public final int getPolicy() {
        return this.policy;
    }

    @NotNull
    public final PercentScope getScope() {
        return this.scope;
    }

    private PercentValues(float f, int i, PercentScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.percent = f;
        this.policy = i;
        this.scope = scope;
    }
}
