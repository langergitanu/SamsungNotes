package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.Immutable;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/material/pullrefresh/ArrowValues;", "", "alpha", "", Key.ROTATION, "startAngle", "endAngle", WiggleAnimationConfig.KEY_SCALE, "(FFFFF)V", "getAlpha", "()F", "getEndAngle", "getRotation", "getScale", "getStartAngle", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class ArrowValues {
    private final float alpha;
    private final float endAngle;
    private final float rotation;
    private final float scale;
    private final float startAngle;

    public ArrowValues(float f, float f4, float f5, float f6, float f7) {
        this.alpha = f;
        this.rotation = f4;
        this.startAngle = f5;
        this.endAngle = f6;
        this.scale = f7;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getEndAngle() {
        return this.endAngle;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }
}
