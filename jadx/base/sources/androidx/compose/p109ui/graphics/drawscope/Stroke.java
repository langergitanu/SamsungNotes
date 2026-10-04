package androidx.compose.p109ui.graphics.drawscope;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.PathEffect;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "width", "", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "(FFIILandroidx/compose/ui/graphics/PathEffect;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCap-KaPHkGw", "()I", "I", "getJoin-LxFBmk8", "getMiter", "()F", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "getWidth", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Stroke extends DrawStyle {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DefaultCap = StrokeCap.INSTANCE.m18878getButtKaPHkGw();
    private static final int DefaultJoin = StrokeJoin.INSTANCE.m18889getMiterLxFBmk8();
    public static final float DefaultMiter = 4.0f;
    public static final float HairlineWidth = 0.0f;
    private final int cap;
    private final int join;
    private final float miter;

    @Nullable
    private final PathEffect pathEffect;
    private final float width;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke$Companion;", "", "()V", "DefaultCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultCap-KaPHkGw", "()I", "I", "DefaultJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultJoin-LxFBmk8", "DefaultMiter", "", "HairlineWidth", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getDefaultCap-KaPHkGw, reason: not valid java name */
        public final int m19147getDefaultCapKaPHkGw() {
            return Stroke.DefaultCap;
        }

        /* JADX INFO: renamed from: getDefaultJoin-LxFBmk8, reason: not valid java name */
        public final int m19148getDefaultJoinLxFBmk8() {
            return Stroke.DefaultJoin;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Stroke(float f, float f4, int i, int i2, PathEffect pathEffect, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, i, i2, pathEffect);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) other;
        return this.width == stroke.width && this.miter == stroke.miter && StrokeCap.m18874equalsimpl0(this.cap, stroke.cap) && StrokeJoin.m18884equalsimpl0(this.join, stroke.join) && Intrinsics.areEqual(this.pathEffect, stroke.pathEffect);
    }

    /* JADX INFO: renamed from: getCap-KaPHkGw, reason: not valid java name and from getter */
    public final int getCap() {
        return this.cap;
    }

    /* JADX INFO: renamed from: getJoin-LxFBmk8, reason: not valid java name and from getter */
    public final int getJoin() {
        return this.join;
    }

    public final float getMiter() {
        return this.miter;
    }

    @Nullable
    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iM18885hashCodeimpl = (StrokeJoin.m18885hashCodeimpl(this.join) + ((StrokeCap.m18875hashCodeimpl(this.cap) + AbstractC0622a.m1156b(this.miter, Float.hashCode(this.width) * 31, 31)) * 31)) * 31;
        PathEffect pathEffect = this.pathEffect;
        return iM18885hashCodeimpl + (pathEffect != null ? pathEffect.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + ((Object) StrokeCap.m18876toStringimpl(this.cap)) + ", join=" + ((Object) StrokeJoin.m18886toStringimpl(this.join)) + ", pathEffect=" + this.pathEffect + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ Stroke(float f, float f4, int i, int i2, PathEffect pathEffect, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0.0f : f, (i4 & 2) != 0 ? 4.0f : f4, (i4 & 4) != 0 ? DefaultCap : i, (i4 & 8) != 0 ? DefaultJoin : i2, (i4 & 16) != 0 ? null : pathEffect, null);
    }

    private Stroke(float f, float f4, int i, int i2, PathEffect pathEffect) {
        super(null);
        this.width = f;
        this.miter = f4;
        this.cap = i;
        this.join = i2;
        this.pathEffect = pathEffect;
    }
}
