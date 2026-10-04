package androidx.glance.oneui.template;

import androidx.annotation.FloatRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001BM\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/oneui/template/ArcProgressData;", "Landroidx/glance/oneui/template/CircularProgressData;", "value", "", "icon", "Landroidx/glance/oneui/template/ImageData;", "text", "Landroidx/glance/oneui/template/TextData;", "progressColor", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;", "keepColor", "", "(FLandroidx/glance/oneui/template/ImageData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;Z)V", "getText", "()Landroidx/glance/oneui/template/TextData;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class ArcProgressData extends CircularProgressData {
    public static final int $stable = 8;

    @NotNull
    private final TextData text;

    public /* synthetic */ ArcProgressData(float f, ImageData imageData, TextData textData, ColorProvider colorProvider, ColorProvider colorProvider2, RemoteAnimation.ProgressAnimation progressAnimation, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, imageData, textData, (i & 8) != 0 ? null : colorProvider, (i & 16) != 0 ? null : colorProvider2, (i & 32) != 0 ? null : progressAnimation, (i & 64) != 0 ? false : z);
    }

    @NotNull
    public final TextData getText() {
        return this.text;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArcProgressData(@FloatRange(from = 0.0d, m705to = 1.0d) float f, @NotNull ImageData icon, @NotNull TextData text, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable RemoteAnimation.ProgressAnimation progressAnimation, boolean z) {
        super(f, icon, colorProvider, colorProvider2, progressAnimation, z);
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }
}
