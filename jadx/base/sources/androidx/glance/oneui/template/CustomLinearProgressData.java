package androidx.glance.oneui.template;

import androidx.annotation.FloatRange;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000H'¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/oneui/template/CustomLinearProgressData;", "Landroidx/glance/oneui/template/LinearProgressData;", "value", "", "icon", "Landroidx/glance/oneui/template/ImageData;", "mainText", "Landroidx/glance/oneui/template/TextData;", "subText", "progressColor", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;", "keepColor", "", "(FLandroidx/glance/oneui/template/ImageData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;Z)V", "CustomContent", "", "data", "(Landroidx/glance/oneui/template/CustomLinearProgressData;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class CustomLinearProgressData extends LinearProgressData {
    public static final int $stable = 0;

    public /* synthetic */ CustomLinearProgressData(float f, ImageData imageData, TextData textData, TextData textData2, ColorProvider colorProvider, ColorProvider colorProvider2, RemoteAnimation.ProgressAnimation progressAnimation, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? null : imageData, (i & 4) != 0 ? null : textData, (i & 8) != 0 ? null : textData2, (i & 16) != 0 ? null : colorProvider, (i & 32) != 0 ? null : colorProvider2, (i & 64) != 0 ? null : progressAnimation, (i & 128) != 0 ? false : z);
    }

    @Composable
    public abstract void CustomContent(@NotNull CustomLinearProgressData customLinearProgressData, @Nullable Composer composer, int i);

    public CustomLinearProgressData(@FloatRange(from = 0.0d, m705to = 1.0d) float f, @Nullable ImageData imageData, @Nullable TextData textData, @Nullable TextData textData2, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable RemoteAnimation.ProgressAnimation progressAnimation, boolean z) {
        super(f, imageData, textData, textData2, colorProvider, colorProvider2, progressAnimation, z);
    }
}
