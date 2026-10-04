package androidx.glance.oneui.template;

import androidx.annotation.FloatRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/template/LinearProgressData;", "Landroidx/glance/oneui/template/ProgressData;", "Landroidx/glance/oneui/template/LinearGraph;", "value", "", "icon", "Landroidx/glance/oneui/template/ImageData;", "mainText", "Landroidx/glance/oneui/template/TextData;", "subText", "progressColor", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;", "keepColor", "", "(FLandroidx/glance/oneui/template/ImageData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;Z)V", "getIcon", "()Landroidx/glance/oneui/template/ImageData;", "getMainText", "()Landroidx/glance/oneui/template/TextData;", "getSubText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class LinearProgressData extends ProgressData implements LinearGraph {
    public static final int $stable = 8;

    @Nullable
    private final ImageData icon;

    @Nullable
    private final TextData mainText;

    @Nullable
    private final TextData subText;

    public /* synthetic */ LinearProgressData(float f, ImageData imageData, TextData textData, TextData textData2, ColorProvider colorProvider, ColorProvider colorProvider2, RemoteAnimation.ProgressAnimation progressAnimation, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? null : imageData, (i & 4) != 0 ? null : textData, (i & 8) != 0 ? null : textData2, (i & 16) != 0 ? null : colorProvider, (i & 32) != 0 ? null : colorProvider2, (i & 64) != 0 ? null : progressAnimation, (i & 128) != 0 ? false : z);
    }

    @Nullable
    public final ImageData getIcon() {
        return this.icon;
    }

    @Nullable
    public final TextData getMainText() {
        return this.mainText;
    }

    @Nullable
    public final TextData getSubText() {
        return this.subText;
    }

    public LinearProgressData(@FloatRange(from = 0.0d, m705to = 1.0d) float f, @Nullable ImageData imageData, @Nullable TextData textData, @Nullable TextData textData2, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable RemoteAnimation.ProgressAnimation progressAnimation, boolean z) {
        super(f, colorProvider, colorProvider2, progressAnimation, z);
        this.icon = imageData;
        this.mainText = textData;
        this.subText = textData2;
    }
}
