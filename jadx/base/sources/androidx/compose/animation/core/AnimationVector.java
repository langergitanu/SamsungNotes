package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H \u0002¢\u0006\u0002\b\nJ\r\u0010\u000b\u001a\u00020\u0000H ¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\u000eH ¢\u0006\u0002\b\u000fJ\u001e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH \u0002¢\u0006\u0002\b\u0012R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u0013\u0014\u0015\u0016¨\u0006\u0017"}, m13886d2 = {"Landroidx/compose/animation/core/AnimationVector;", "", "()V", "size", "", "getSize$animation_core_release", "()I", "get", "", "index", "get$animation_core_release", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "value", "set$animation_core_release", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/AnimationVector3D;", "Landroidx/compose/animation/core/AnimationVector4D;", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class AnimationVector {
    public static final int $stable = 0;

    public /* synthetic */ AnimationVector(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract float get$animation_core_release(int index);

    public abstract int getSize$animation_core_release();

    @NotNull
    public abstract AnimationVector newVector$animation_core_release();

    public abstract void reset$animation_core_release();

    public abstract void set$animation_core_release(int index, float value);

    private AnimationVector() {
    }
}
