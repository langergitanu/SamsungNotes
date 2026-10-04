package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/RadioButtonColors;", "", "radio", "Landroidx/glance/appwidget/unit/CheckableColorProvider;", "(Landroidx/glance/appwidget/unit/CheckableColorProvider;)V", "getRadio$glance_appwidget_release", "()Landroidx/glance/appwidget/unit/CheckableColorProvider;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class RadioButtonColors {
    public static final int $stable = 8;

    @NotNull
    private final CheckableColorProvider radio;

    public RadioButtonColors(@NotNull CheckableColorProvider radio) {
        Intrinsics.checkNotNullParameter(radio, "radio");
        this.radio = radio;
    }

    @NotNull
    /* JADX INFO: renamed from: getRadio$glance_appwidget_release, reason: from getter */
    public final CheckableColorProvider getRadio() {
        return this.radio;
    }
}
