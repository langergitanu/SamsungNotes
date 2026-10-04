package androidx.compose.p109ui.graphics.layer;

import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayerVerificationHelper28;", "", "()V", "resetPivot", "", "view", "Landroid/view/View;", "setOutlineAmbientShadowColor", "target", "", "setOutlineSpotShadowColor", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class ViewLayerVerificationHelper28 {

    @NotNull
    public static final ViewLayerVerificationHelper28 INSTANCE = new ViewLayerVerificationHelper28();

    private ViewLayerVerificationHelper28() {
    }

    public final void resetPivot(@NotNull View view) {
        view.resetPivot();
    }

    public final void setOutlineAmbientShadowColor(@NotNull View view, int target) {
        view.setOutlineAmbientShadowColor(target);
    }

    public final void setOutlineSpotShadowColor(@NotNull View view, int target) {
        view.setOutlineSpotShadowColor(target);
    }
}
