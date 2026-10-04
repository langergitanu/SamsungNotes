package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.draw.ShadowKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0092\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001ap\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u009a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a%\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a;\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m13886d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SurfaceKt {

    @NotNull
    private static final ProvidableCompositionLocal<C2256Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0<C2256Dp>() { // from class: androidx.compose.material3.SurfaceKt$LocalAbsoluteTonalElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ C2256Dp invoke() {
            return C2256Dp.m20966boximpl(m17333invokeD9Ej5fM());
        }

        /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m17333invokeD9Ej5fM() {
            return C2256Dp.m20968constructorimpl(0);
        }
    }, 1, null);

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m17325SurfaceT9BRK9s(@Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, float f, float f4, @Nullable BorderStroke borderStroke, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-513881741);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        final Shape rectangleShape = (i2 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long jM17062getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU() : j;
        long jM17098contentColorForek8zF_U = (i2 & 8) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composer, (i >> 6) & 14) : j2;
        float fM20968constructorimpl = (i2 & 16) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i2 & 32) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, i, -1, "androidx.compose.material3.Surface (Surface.kt:98)");
        }
        ProvidableCompositionLocal<C2256Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        final float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(((C2256Dp) composer.consume(providableCompositionLocal)).m20982unboximpl() + fM20968constructorimpl);
        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM17098contentColorForek8zF_U)), providableCompositionLocal.provides(C2256Dp.m20966boximpl(fM20968constructorimpl3))};
        final float f5 = fM20968constructorimpl2;
        final BorderStroke borderStroke3 = borderStroke2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, -70914509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1

            /* JADX INFO: renamed from: androidx.compose.material3.SurfaceKt$Surface$1$2 */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.material3.SurfaceKt$Surface$1$2", m14021f = "Surface.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C18742 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                public C18742(Continuation<? super C18742> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C18742(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C18742) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-70914509, i4, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:112)");
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(SurfaceKt.m17331surface8ww4TTg(modifier2, rectangleShape, SurfaceKt.m17332surfaceColorAtElevationCLU3JFs(jM17062getSurface0d7_KjU, fM20968constructorimpl3, composer2, (i >> 6) & 14), borderStroke3, f5), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1.1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                }), Unit.INSTANCE, new C18742(null));
                Function2<Composer, Integer, Unit> function2 = content;
                int i5 = i;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPointerInput);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                composer2.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1703151929);
                if (AbstractC1038a.m1199D(composer2, (i5 >> 21) & 14, function2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m17326Surfaced85dljk(final boolean z, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z2, @Nullable Shape shape, long j, long j2, float f, float f4, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2, int i4) {
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(540296512);
        Modifier modifier3 = (i4 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z3 = (i4 & 8) != 0 ? true : z2;
        Shape rectangleShape = (i4 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long jM17062getSurface0d7_KjU = (i4 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU() : j;
        long jM17098contentColorForek8zF_U = (i4 & 64) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composer, (i >> 15) & 14) : j2;
        float fM20968constructorimpl = (i4 & 128) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i4 & 256) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        BorderStroke borderStroke2 = (i4 & 512) != 0 ? null : borderStroke;
        if ((i4 & 1024) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = modifier3;
            ComposerKt.traceEventStart(540296512, i, i2, "androidx.compose.material3.Surface (Surface.kt:311)");
        } else {
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = modifier3;
        }
        ProvidableCompositionLocal<C2256Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        final float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(((C2256Dp) composer.consume(providableCompositionLocal)).m20982unboximpl() + fM20968constructorimpl);
        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM17098contentColorForek8zF_U)), providableCompositionLocal.provides(C2256Dp.m20966boximpl(fM20968constructorimpl3))};
        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
        final Shape shape2 = rectangleShape;
        final Modifier modifier4 = modifier2;
        final BorderStroke borderStroke3 = borderStroke2;
        final long j3 = jM17062getSurface0d7_KjU;
        final float f5 = fM20968constructorimpl2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, -1164547968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i5) {
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1164547968, i5, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:329)");
                }
                Modifier modifierM16105selectableO2vRcR0 = SelectableKt.m16105selectableO2vRcR0(SurfaceKt.m17331surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier4), shape2, SurfaceKt.m17332surfaceColorAtElevationCLU3JFs(j3, fM20968constructorimpl3, composer2, (i >> 15) & 14), borderStroke3, f5), z, mutableInteractionSource4, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z3, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick);
                Function2<Composer, Integer, Unit> function2 = content;
                int i6 = i2;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16105selectableO2vRcR0);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                composer2.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(796134330);
                if (AbstractC1038a.m1199D(composer2, (i6 >> 3) & 14, function2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m17328Surfaceo_FOJdg(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, long j, long j2, float f, float f4, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2, int i4) {
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-789752804);
        Modifier modifier3 = (i4 & 2) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z2 = (i4 & 4) != 0 ? true : z;
        Shape rectangleShape = (i4 & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long jM17062getSurface0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU() : j;
        long jM17098contentColorForek8zF_U = (i4 & 32) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composer, (i >> 12) & 14) : j2;
        float fM20968constructorimpl = (i4 & 64) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i4 & 128) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        BorderStroke borderStroke2 = (i4 & 256) != 0 ? null : borderStroke;
        if ((i4 & 512) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = modifier3;
            ComposerKt.traceEventStart(-789752804, i, i2, "androidx.compose.material3.Surface (Surface.kt:200)");
        } else {
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = modifier3;
        }
        ProvidableCompositionLocal<C2256Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        final float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(((C2256Dp) composer.consume(providableCompositionLocal)).m20982unboximpl() + fM20968constructorimpl);
        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM17098contentColorForek8zF_U)), providableCompositionLocal.provides(C2256Dp.m20966boximpl(fM20968constructorimpl3))};
        final long j3 = jM17062getSurface0d7_KjU;
        final Shape shape2 = rectangleShape;
        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
        final float f5 = fM20968constructorimpl2;
        final BorderStroke borderStroke3 = borderStroke2;
        final Modifier modifier4 = modifier2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, 1279702876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i5) {
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1279702876, i5, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:217)");
                }
                Modifier modifierM15440clickableO2vRcR0$default = ClickableKt.m15440clickableO2vRcR0$default(SurfaceKt.m17331surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier4), shape2, SurfaceKt.m17332surfaceColorAtElevationCLU3JFs(j3, fM20968constructorimpl3, composer2, (i >> 12) & 14), borderStroke3, f5), mutableInteractionSource4, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z2, null, Role.m20259boximpl(Role.INSTANCE.m20266getButtono7Vup1c()), onClick, 8, null);
                Function2<Composer, Integer, Unit> function2 = content;
                int i6 = i2;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15440clickableO2vRcR0$default);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                composer2.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-126864234);
                if (AbstractC1038a.m1199D(composer2, i6 & 14, function2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final ProvidableCompositionLocal<C2256Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m17331surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Modifier modifierM18189shadows4CzXII$default = ShadowKt.m18189shadows4CzXII$default(modifier, f, shape, false, 0L, 0L, 24, null);
        Modifier modifierBorder = Modifier.INSTANCE;
        if (borderStroke != null) {
            modifierBorder = BorderKt.border(modifierBorder, borderStroke, shape);
        }
        return ClipKt.clip(BackgroundKt.m15408backgroundbw27NRU(modifierM18189shadows4CzXII$default.then(modifierBorder), j, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m17332surfaceColorAtElevationCLU3JFs(long j, float f, Composer composer, int i) {
        composer.startReplaceableGroup(-2079918090);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:481)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        if (Color.m18526equalsimpl0(j, materialTheme.getColorScheme(composer, 6).m17062getSurface0d7_KjU())) {
            j = ColorSchemeKt.m17103surfaceColorAtElevation3ABfNKs(materialTheme.getColorScheme(composer, 6), f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return j;
    }

    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m17327Surfaced85dljk(final boolean z, @NotNull final Function1<? super Boolean, Unit> onCheckedChange, @Nullable Modifier modifier, boolean z2, @Nullable Shape shape, long j, long j2, float f, float f4, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2, int i4) {
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-1877401889);
        Modifier modifier3 = (i4 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z3 = (i4 & 8) != 0 ? true : z2;
        Shape rectangleShape = (i4 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long jM17062getSurface0d7_KjU = (i4 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU() : j;
        long jM17098contentColorForek8zF_U = (i4 & 64) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composer, (i >> 15) & 14) : j2;
        float fM20968constructorimpl = (i4 & 128) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i4 & 256) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        BorderStroke borderStroke2 = (i4 & 512) != 0 ? null : borderStroke;
        if ((i4 & 1024) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = modifier3;
            ComposerKt.traceEventStart(-1877401889, i, i2, "androidx.compose.material3.Surface (Surface.kt:424)");
        } else {
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = modifier3;
        }
        ProvidableCompositionLocal<C2256Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        final float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(((C2256Dp) composer.consume(providableCompositionLocal)).m20982unboximpl() + fM20968constructorimpl);
        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM17098contentColorForek8zF_U)), providableCompositionLocal.provides(C2256Dp.m20966boximpl(fM20968constructorimpl3))};
        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
        final Shape shape2 = rectangleShape;
        final Modifier modifier4 = modifier2;
        final BorderStroke borderStroke3 = borderStroke2;
        final long j3 = jM17062getSurface0d7_KjU;
        final float f5 = fM20968constructorimpl2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, 712720927, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i5) {
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(712720927, i5, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:442)");
                }
                Modifier modifierM16110toggleableO2vRcR0 = ToggleableKt.m16110toggleableO2vRcR0(SurfaceKt.m17331surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier4), shape2, SurfaceKt.m17332surfaceColorAtElevationCLU3JFs(j3, fM20968constructorimpl3, composer2, (i >> 15) & 14), borderStroke3, f5), z, mutableInteractionSource4, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z3, Role.m20259boximpl(Role.INSTANCE.m20271getSwitcho7Vup1c()), onCheckedChange);
                Function2<Composer, Integer, Unit> function2 = content;
                int i6 = i2;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16110toggleableO2vRcR0);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                composer2.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-1621564071);
                if (AbstractC1038a.m1199D(composer2, (i6 >> 3) & 14, function2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
