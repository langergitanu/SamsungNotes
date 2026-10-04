package androidx.lifecycle.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010\f\u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u001f\u001a0\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010 \u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020!2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010$\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u008a\u0084\u0002"}, m13886d2 = {"LifecycleResumeEffectNoParamError", "", "LifecycleStartEffectNoParamError", "LifecycleEventEffect", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffect", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key1", "", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleStartEffect", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "LifecycleStartEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose_release", "currentOnEvent"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLifecycleEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleEffect.kt\nandroidx/lifecycle/compose/LifecycleEffectKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,747:1\n74#2:748\n74#2:755\n74#2:762\n74#2:769\n74#2:776\n74#2:786\n74#2:793\n74#2:800\n74#2:807\n74#2:814\n74#2:824\n1116#3,6:749\n1116#3,6:756\n1116#3,6:763\n1116#3,6:770\n1116#3,6:780\n1116#3,6:787\n1116#3,6:794\n1116#3,6:801\n1116#3,6:808\n1116#3,6:818\n1116#3,6:825\n83#4,3:777\n83#4,3:815\n81#5:831\n*S KotlinDebug\n*F\n+ 1 LifecycleEffect.kt\nandroidx/lifecycle/compose/LifecycleEffectKt\n*L\n56#1:748\n134#1:755\n197#1:762\n262#1:769\n323#1:776\n349#1:786\n467#1:793\n530#1:800\n595#1:807\n656#1:814\n682#1:824\n67#1:749,6\n137#1:756,6\n200#1:763,6\n265#1:770,6\n326#1:780,6\n359#1:787,6\n470#1:794,6\n533#1:801,6\n598#1:808,6\n659#1:818,6\n692#1:825,6\n326#1:777,3\n659#1:815,3\n66#1:831\n*E\n"})
public final class LifecycleEffectKt {

    @NotNull
    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    @NotNull
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f6  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleEventEffect(@NotNull final Lifecycle.Event event, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function0<Unit> function0, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-709389590);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(event) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= ((i2 & 2) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-709389590, i4, -1, "androidx.lifecycle.compose.LifecycleEventEffect (LifecycleEffect.kt:57)");
                }
                if (event != Lifecycle.Event.ON_DESTROY) {
                    throw new IllegalArgumentException("LifecycleEventEffect cannot be used to listen for Lifecycle.Event.ON_DESTROY, since Compose disposes of the composition before ON_DESTROY observers are invoked.");
                }
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, (i4 >> 6) & 14);
                composerStartRestartGroup.startReplaceableGroup(380955345);
                boolean zChanged = ((i4 & 14) == 4) | composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changedInstance(lifecycleOwner);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleEffectKt$LifecycleEventEffect$1$1(lifecycleOwner, event, stateRememberUpdatedState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, (i4 >> 3) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (event != Lifecycle.Event.ON_DESTROY) {
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleEventEffect.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleEventEffect(event, lifecycleOwner2, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> LifecycleEventEffect$lambda$0(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d0  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleResumeEffect(@Nullable final Object obj, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1220373486);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= ((i2 & 2) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1220373486, i4, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:468)");
                }
                composerStartRestartGroup.startReplaceableGroup(1469998571);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 3) & 14) | (i4 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(1469998571);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 3) & 14) | (i4 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.1
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleResumeEffect(obj, lifecycleOwner2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void LifecycleResumeEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(912823238);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(lifecycleResumePauseEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(912823238, i2, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:690)");
            }
            composerStartRestartGroup.startReplaceableGroup(657406551);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lifecycleResumePauseEffectScope) | ((i2 & 896) == 256) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LifecycleEffectKt$LifecycleResumeEffectImpl$1$1(lifecycleOwner, lifecycleResumePauseEffectScope, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleResumePauseEffectScope, (Function1) objRememberedValue, composerStartRestartGroup, i2 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffectImpl.2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LifecycleEffectKt.LifecycleResumeEffectImpl(lifecycleOwner, lifecycleResumePauseEffectScope, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d0  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleStartEffect(@Nullable final Object obj, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1408314671);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= ((i2 & 2) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1408314671, i4, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:135)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1877970380);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 3) & 14) | (i4 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(-1877970380);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 3) & 14) | (i4 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.1
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleStartEffect(obj, lifecycleOwner2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void LifecycleStartEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(228371534);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(lifecycleStartStopEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(228371534, i2, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:357)");
            }
            composerStartRestartGroup.startReplaceableGroup(-1076218375);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lifecycleStartStopEffectScope) | ((i2 & 896) == 256) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LifecycleEffectKt$LifecycleStartEffectImpl$1$1(lifecycleOwner, lifecycleStartStopEffectScope, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, (Function1) objRememberedValue, composerStartRestartGroup, i2 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffectImpl.2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LifecycleEffectKt.LifecycleStartEffectImpl(lifecycleOwner, lifecycleStartStopEffectScope, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleResumeEffect(@Nullable final Object obj, @Nullable final Object obj2, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(752680142);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(obj2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i4 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(1470097201);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 6) & 14) | ((i4 >> 3) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                if ((i2 & 4) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(752680142, i4, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:531)");
                }
                composerStartRestartGroup.startReplaceableGroup(1470097201);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 6) & 14) | ((i4 >> 3) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.2
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleResumeEffect(obj, obj2, lifecycleOwner2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleStartEffect(@Nullable final Object obj, @Nullable final Object obj2, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(696924721);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(obj2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i4 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(-1877873222);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 6) & 14) | ((i4 >> 3) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                if ((i2 & 4) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(696924721, i4, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:198)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1877873222);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 6) & 14) | ((i4 >> 3) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.2
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleStartEffect(obj, obj2, lifecycleOwner2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010a  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleResumeEffect(@Nullable final Object obj, @Nullable final Object obj2, @Nullable final Object obj3, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-485941842);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(obj2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(obj3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i4 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i4 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(1470198999);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(obj3) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 9) & 14) | ((i4 >> 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                if ((i2 & 8) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-485941842, i4, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:596)");
                }
                composerStartRestartGroup.startReplaceableGroup(1470198999);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(obj3) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 9) & 14) | ((i4 >> 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.3
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleResumeEffect(obj, obj2, obj3, lifecycleOwner2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010a  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleStartEffect(@Nullable final Object obj, @Nullable final Object obj2, @Nullable final Object obj3, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(574812561);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(obj2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(obj3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i4 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i4 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(-1877772704);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(obj3) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 9) & 14) | ((i4 >> 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                if ((i2 & 8) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(574812561, i4, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:263)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1877772704);
                zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(obj3) | composerStartRestartGroup.changed(lifecycleOwner);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, ((i4 >> 9) & 14) | ((i4 >> 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.3
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LifecycleEffectKt.LifecycleStartEffect(obj, obj2, obj3, lifecycleOwner2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c5 A[LOOP:1: B:54:0x00c3->B:55:0x00c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fe  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleResumeEffect(@NotNull final Object[] objArr, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-781756895);
        int i4 = (i & 48) == 0 ? (((i2 & 2) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 32 : 16) | i : i;
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        composerStartRestartGroup.startMovableGroup(1470288308, Integer.valueOf(objArr.length));
        for (Object obj : objArr) {
            i4 |= composerStartRestartGroup.changedInstance(obj) ? 4 : 0;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i4 & 14) == 0) {
            i4 |= 2;
        }
        if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(objArr);
                spreadBuilder.add(lifecycleOwner);
                Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                zChanged = false;
                while (i < r2) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, (i4 & 896) | ((i4 >> 3) & 14));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                if ((i2 & 2) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-781756895, i4, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:657)");
                }
                SpreadBuilder spreadBuilder2 = new SpreadBuilder(2);
                spreadBuilder2.addSpread(objArr);
                spreadBuilder2.add(lifecycleOwner);
                Object[] array2 = spreadBuilder2.toArray(new Object[spreadBuilder2.size()]);
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                zChanged = false;
                for (Object obj2 : array2) {
                    zChanged |= composerStartRestartGroup.changed(obj2);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleResumeEffectImpl(lifecycleOwner, (LifecycleResumePauseEffectScope) objRememberedValue, function1, composerStartRestartGroup, (i4 & 896) | ((i4 >> 3) & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.4
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    Object[] objArr2 = objArr;
                    LifecycleEffectKt.LifecycleResumeEffect(Arrays.copyOf(objArr2, objArr2.length), lifecycleOwner2, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c5 A[LOOP:1: B:54:0x00c3->B:55:0x00c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fe  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LifecycleStartEffect(@NotNull final Object[] objArr, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1510305724);
        int i4 = (i & 48) == 0 ? (((i2 & 2) == 0 && composerStartRestartGroup.changedInstance(lifecycleOwner)) ? 32 : 16) | i : i;
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        composerStartRestartGroup.startMovableGroup(-1877684705, Integer.valueOf(objArr.length));
        for (Object obj : objArr) {
            i4 |= composerStartRestartGroup.changedInstance(obj) ? 4 : 0;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i4 & 14) == 0) {
            i4 |= 2;
        }
        if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(objArr);
                spreadBuilder.add(lifecycleOwner);
                Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                zChanged = false;
                while (i < r2) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                    LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, (i4 & 896) | ((i4 >> 3) & 14));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                if ((i2 & 2) != 0) {
                    lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1510305724, i4, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:324)");
                }
                SpreadBuilder spreadBuilder2 = new SpreadBuilder(2);
                spreadBuilder2.addSpread(objArr);
                spreadBuilder2.add(lifecycleOwner);
                Object[] array2 = spreadBuilder2.toArray(new Object[spreadBuilder2.size()]);
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                zChanged = false;
                for (Object obj2 : array2) {
                    zChanged |= composerStartRestartGroup.changed(obj2);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner.getLifecycle());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LifecycleStartEffectImpl(lifecycleOwner, (LifecycleStartStopEffectScope) objRememberedValue, function1, composerStartRestartGroup, (i4 & 896) | ((i4 >> 3) & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        final LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.4
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    Object[] objArr2 = objArr;
                    LifecycleEffectKt.LifecycleStartEffect(Arrays.copyOf(objArr2, objArr2.length), lifecycleOwner2, (Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult>) function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LifecycleResumeEffectNoParamError)
    @Composable
    public static final void LifecycleResumeEffect(@Nullable final LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-747476210);
        int i4 = i & 1;
        if (i4 == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.5
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

                    public final void invoke(@Nullable Composer composer2, int i5) {
                        LifecycleEffectKt.LifecycleResumeEffect(lifecycleOwner, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        composerStartRestartGroup.startDefaults();
        if (i4 != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
            composerStartRestartGroup.skipToGroupEnd();
            if ((i2 & 1) != 0) {
                i &= -15;
            }
        } else if ((i2 & 1) != 0) {
            i &= -15;
        }
        composerStartRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-747476210, i, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:683)");
        }
        throw new IllegalStateException(LifecycleResumeEffectNoParamError);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LifecycleStartEffectNoParamError)
    @Composable
    public static final void LifecycleStartEffect(@Nullable final LifecycleOwner lifecycleOwner, @NotNull final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, @Nullable Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-50807951);
        int i4 = i & 1;
        if (i4 == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.5
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

                    public final void invoke(@Nullable Composer composer2, int i5) {
                        LifecycleEffectKt.LifecycleStartEffect(lifecycleOwner, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        composerStartRestartGroup.startDefaults();
        if (i4 != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
            composerStartRestartGroup.skipToGroupEnd();
            if ((i2 & 1) != 0) {
                i &= -15;
            }
        } else if ((i2 & 1) != 0) {
            i &= -15;
        }
        composerStartRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-50807951, i, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:350)");
        }
        throw new IllegalStateException(LifecycleStartEffectNoParamError);
    }
}
