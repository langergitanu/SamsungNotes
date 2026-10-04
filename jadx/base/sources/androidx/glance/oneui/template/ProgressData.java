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
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/oneui/template/ProgressData;", "Landroidx/glance/oneui/template/BaseComponent;", "value", "", "progressColor", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;", "keepColor", "", "(FLandroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;Z)V", "getAnimation", "()Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;", "getBackgroundColor", "()Landroidx/glance/unit/ColorProvider;", "getProgressColor", "getValue", "()F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class ProgressData extends BaseComponent {
    public static final int $stable = 8;

    @Nullable
    private final RemoteAnimation.ProgressAnimation animation;

    @Nullable
    private final ColorProvider backgroundColor;

    @Nullable
    private final ColorProvider progressColor;
    private final float value;

    public /* synthetic */ ProgressData(float f, ColorProvider colorProvider, ColorProvider colorProvider2, RemoteAnimation.ProgressAnimation progressAnimation, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? null : colorProvider, (i & 4) != 0 ? null : colorProvider2, (i & 8) != 0 ? null : progressAnimation, (i & 16) != 0 ? false : z);
    }

    @Nullable
    public final RemoteAnimation.ProgressAnimation getAnimation() {
        return this.animation;
    }

    @Nullable
    public final ColorProvider getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final ColorProvider getProgressColor() {
        return this.progressColor;
    }

    public final float getValue() {
        return this.value;
    }

    public ProgressData(@FloatRange(from = 0.0d, m705to = 1.0d) float f, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable RemoteAnimation.ProgressAnimation progressAnimation, boolean z) {
        super(z);
        this.value = f;
        this.progressColor = colorProvider;
        this.backgroundColor = colorProvider2;
        this.animation = progressAnimation;
    }
}
