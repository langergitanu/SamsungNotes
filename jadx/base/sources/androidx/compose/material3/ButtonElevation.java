package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0010J(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/material3/ButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", TokenizerME.NO_SPLIT, "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation$material3_release", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ButtonElevation {
    private final float defaultElevation;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    /* JADX INFO: renamed from: androidx.compose.material3.ButtonElevation$animateElevation$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material3.ButtonElevation$animateElevation$2", m14021f = "Button.kt", m14022i = {}, m14023l = {855}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C17252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<C2256Dp, AnimationVector1D> $animatable;
        final /* synthetic */ float $target;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17252(Animatable<C2256Dp, AnimationVector1D> animatable, float f, Continuation<? super C17252> continuation) {
            super(2, continuation);
            this.$animatable = animatable;
            this.$target = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C17252(this.$animatable, this.$target, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<C2256Dp, AnimationVector1D> animatable = this.$animatable;
                C2256Dp c2256DpM20966boximpl = C2256Dp.m20966boximpl(this.$target);
                this.label = 1;
                if (animatable.snapTo(c2256DpM20966boximpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C17252) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ButtonElevation$animateElevation$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material3.ButtonElevation$animateElevation$3", m14021f = "Button.kt", m14022i = {}, m14023l = {864}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C17263 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<C2256Dp, AnimationVector1D> $animatable;
        final /* synthetic */ Interaction $interaction;
        final /* synthetic */ float $target;
        int label;
        final /* synthetic */ ButtonElevation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17263(Animatable<C2256Dp, AnimationVector1D> animatable, ButtonElevation buttonElevation, float f, Interaction interaction, Continuation<? super C17263> continuation) {
            super(2, continuation);
            this.$animatable = animatable;
            this.this$0 = buttonElevation;
            this.$target = f;
            this.$interaction = interaction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C17263(this.$animatable, this.this$0, this.$target, this.$interaction, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fM20982unboximpl = this.$animatable.getTargetValue().m20982unboximpl();
                Interaction focus = null;
                if (C2256Dp.m20973equalsimpl0(fM20982unboximpl, this.this$0.pressedElevation)) {
                    focus = new PressInteraction.Press(Offset.INSTANCE.m18300getZeroF1C5BW0(), null);
                } else if (C2256Dp.m20973equalsimpl0(fM20982unboximpl, this.this$0.hoveredElevation)) {
                    focus = new HoverInteraction.Enter();
                } else if (C2256Dp.m20973equalsimpl0(fM20982unboximpl, this.this$0.focusedElevation)) {
                    focus = new FocusInteraction.Focus();
                }
                Animatable<C2256Dp, AnimationVector1D> animatable = this.$animatable;
                float f = this.$target;
                Interaction interaction = this.$interaction;
                this.label = 1;
                if (ElevationKt.m17147animateElevationrAjV9yQ(animatable, f, focus, interaction, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C17263) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ ButtonElevation(float f, float f4, float f5, float f6, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, f7);
    }

    @Composable
    private final State<C2256Dp> animateElevation(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceableGroup(-1312510462);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1312510462, i, -1, "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:803)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateListOf();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
        int i2 = (i >> 3) & 14;
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(interactionSource) | composer.changed(snapshotStateList);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new ButtonElevation$animateElevation$1$1(interactionSource, snapshotStateList, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i2 | 64);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        float f = !z ? this.disabledElevation : interaction instanceof PressInteraction.Press ? this.pressedElevation : interaction instanceof HoverInteraction.Enter ? this.hoveredElevation : interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            Object animatable = new Animatable(C2256Dp.m20966boximpl(f), VectorConvertersKt.getVectorConverter(C2256Dp.INSTANCE), null, 4, null);
            composer.updateRememberedValue(animatable);
            objRememberedValue3 = animatable;
        }
        composer.endReplaceableGroup();
        Animatable animatable2 = (Animatable) objRememberedValue3;
        if (z) {
            composer.startReplaceableGroup(-719929769);
            EffectsKt.LaunchedEffect(C2256Dp.m20966boximpl(f), new C17263(animatable2, this, f, interaction, null), composer, 64);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-719929912);
            EffectsKt.LaunchedEffect(C2256Dp.m20966boximpl(f), new C17252(animatable2, f, null), composer, 64);
            composer.endReplaceableGroup();
        }
        State<C2256Dp> stateAsState = animatable2.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateAsState;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) other;
        return C2256Dp.m20973equalsimpl0(this.defaultElevation, buttonElevation.defaultElevation) && C2256Dp.m20973equalsimpl0(this.pressedElevation, buttonElevation.pressedElevation) && C2256Dp.m20973equalsimpl0(this.focusedElevation, buttonElevation.focusedElevation) && C2256Dp.m20973equalsimpl0(this.hoveredElevation, buttonElevation.hoveredElevation) && C2256Dp.m20973equalsimpl0(this.disabledElevation, buttonElevation.disabledElevation);
    }

    public int hashCode() {
        return C2256Dp.m20974hashCodeimpl(this.disabledElevation) + AbstractC0622a.m1153C(this.hoveredElevation, AbstractC0622a.m1153C(this.focusedElevation, AbstractC0622a.m1153C(this.pressedElevation, C2256Dp.m20974hashCodeimpl(this.defaultElevation) * 31, 31), 31), 31);
    }

    @Composable
    @NotNull
    public final State<C2256Dp> shadowElevation$material3_release(boolean z, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, -2045116089)) {
            ComposerKt.traceEventStart(-2045116089, i, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:795)");
        }
        State<C2256Dp> stateAnimateElevation = animateElevation(z, interactionSource, composer, i & Event.CAPS_LOCK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateAnimateElevation;
    }

    @Composable
    @NotNull
    public final State<C2256Dp> tonalElevation$material3_release(boolean z, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, -423890235)) {
            ComposerKt.traceEventStart(-423890235, i, -1, "androidx.compose.material3.ButtonElevation.tonalElevation (Button.kt:779)");
        }
        State<C2256Dp> stateAnimateElevation = animateElevation(z, interactionSource, composer, i & Event.CAPS_LOCK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateAnimateElevation;
    }

    private ButtonElevation(float f, float f4, float f5, float f6, float f7) {
        this.defaultElevation = f;
        this.pressedElevation = f4;
        this.focusedElevation = f5;
        this.hoveredElevation = f6;
        this.disabledElevation = f7;
    }
}
