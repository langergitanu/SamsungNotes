package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0001\t¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/SwitchColors;", "", "()V", "thumb", "Landroidx/glance/appwidget/unit/CheckableColorProvider;", "getThumb$glance_appwidget_release", "()Landroidx/glance/appwidget/unit/CheckableColorProvider;", "track", "getTrack$glance_appwidget_release", "Landroidx/glance/appwidget/SwitchColorsImpl;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class SwitchColors {
    public static final int $stable = 0;

    public /* synthetic */ SwitchColors(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract CheckableColorProvider getThumb$glance_appwidget_release();

    @NotNull
    public abstract CheckableColorProvider getTrack$glance_appwidget_release();

    private SwitchColors() {
    }
}
