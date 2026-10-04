package androidx.compose.animation.core;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.KeyframeBaseEntity;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u0000H ¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\u00028\u0001*\u00028\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u0007H\u0096\u0004¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00028\u0001*\u00028\u00002\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\u0096\u0004¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00028\u0001*\u00028\u00012\u0006\u0010 \u001a\u00020!H\u0086\u0004¢\u0006\u0002\u0010\"R(\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0002#$¨\u0006%"}, m13886d2 = {"Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "T", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/animation/core/KeyframeBaseEntity;", "", "()V", "<set-?>", "", "delayMillis", "getDelayMillis", "()I", "setDelayMillis", "(I)V", "durationMillis", "getDurationMillis", "setDurationMillis", "keyframes", "Landroidx/collection/MutableIntObjectMap;", "getKeyframes$animation_core_release", "()Landroidx/collection/MutableIntObjectMap;", "createEntityFor", "value", "createEntityFor$animation_core_release", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframeBaseEntity;", VPathDataCmd.ArcTo, "timeStamp", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframeBaseEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframeBaseEntity;", "using", "easing", "Landroidx/compose/animation/core/Easing;", "(Landroidx/compose/animation/core/KeyframeBaseEntity;Landroidx/compose/animation/core/Easing;)Landroidx/compose/animation/core/KeyframeBaseEntity;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnimationSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationSpec.kt\nandroidx/compose/animation/core/KeyframesSpecBaseConfig\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,1095:1\n26#2:1096\n*S KotlinDebug\n*F\n+ 1 AnimationSpec.kt\nandroidx/compose/animation/core/KeyframesSpecBaseConfig\n*L\n527#1:1096\n*E\n"})
public abstract class KeyframesSpecBaseConfig<T, E extends KeyframeBaseEntity<T>> {
    public static final int $stable = 8;
    private int delayMillis;
    private int durationMillis;

    @NotNull
    private final MutableIntObjectMap<E> keyframes;

    public /* synthetic */ KeyframesSpecBaseConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @NotNull
    /* JADX INFO: renamed from: at */
    public E mo1191at(T t, @IntRange(from = 0) int i) {
        E e = (E) createEntityFor$animation_core_release(t);
        this.keyframes.set(i, e);
        return e;
    }

    @NotNull
    public E atFraction(T t, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        return (E) mo1191at(t, Math.round(this.durationMillis * f));
    }

    @NotNull
    public abstract E createEntityFor$animation_core_release(T value);

    @IntRange(from = 0)
    public final int getDelayMillis() {
        return this.delayMillis;
    }

    @IntRange(from = 0)
    public final int getDurationMillis() {
        return this.durationMillis;
    }

    @NotNull
    public final MutableIntObjectMap<E> getKeyframes$animation_core_release() {
        return this.keyframes;
    }

    public final void setDelayMillis(@IntRange(from = 0) int i) {
        this.delayMillis = i;
    }

    public final void setDurationMillis(@IntRange(from = 0) int i) {
        this.durationMillis = i;
    }

    @NotNull
    public final E using(@NotNull E e, @NotNull Easing easing) {
        e.setEasing$animation_core_release(easing);
        return e;
    }

    private KeyframesSpecBaseConfig() {
        this.durationMillis = 300;
        this.keyframes = IntObjectMapKt.mutableIntObjectMapOf();
    }
}
