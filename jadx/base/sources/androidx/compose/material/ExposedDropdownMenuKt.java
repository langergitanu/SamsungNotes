package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ExposedDropdownMenuBoxScope;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusRequester;
import androidx.compose.p109ui.focus.FocusRequesterModifierKt;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.node.Ref;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, m13886d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ExposedDropdownMenuKt {

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1", m14021f = "ExposedDropdownMenu.kt", m14022i = {}, m14023l = {516}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C15401 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onExpandedChange;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1", m14021f = "ExposedDropdownMenu.kt", m14022i = {}, m14023l = {517}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $onExpandedChange;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1", m14021f = "ExposedDropdownMenu.kt", m14022i = {}, m14023l = {518}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputScope $$this$forEachGesture;
                final /* synthetic */ Function0<Unit> $onExpandedChange;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1", m14021f = "ExposedDropdownMenu.kt", m14022i = {0}, m14023l = {521}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope"}, m14026s = {"L$0"})
                public static final class C145481 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function0<Unit> $onExpandedChange;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C145481(Function0<Unit> function0, Continuation<? super C145481> continuation) {
                        super(2, continuation);
                        this.$onExpandedChange = function0;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        C145481 c145481 = new C145481(this.$onExpandedChange, continuation);
                        c145481.L$0 = obj;
                        return c145481;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((C145481) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:12:0x0030). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(@NotNull Object obj) {
                        AwaitPointerEventScope awaitPointerEventScope;
                        int size;
                        int i;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i2 = this.label;
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            PointerEventPass pointerEventPass = PointerEventPass.Initial;
                            this.L$0 = awaitPointerEventScope;
                            this.label = 1;
                            obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, this);
                            if (obj == coroutine_suspended) {
                            }
                            List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                            size = changes.size();
                            i = 0;
                            while (i < size) {
                            }
                            this.$onExpandedChange.invoke();
                            return Unit.INSTANCE;
                        }
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
                        size = changes2.size();
                        i = 0;
                        while (i < size) {
                            if (PointerEventKt.changedToUp(changes2.get(i))) {
                                i++;
                            } else {
                                PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                                this.L$0 = awaitPointerEventScope;
                                this.label = 1;
                                obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                List<PointerInputChange> changes22 = ((PointerEvent) obj).getChanges();
                                size = changes22.size();
                                i = 0;
                                while (i < size) {
                                }
                            }
                        }
                        this.$onExpandedChange.invoke();
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145471(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super C145471> continuation) {
                    super(2, continuation);
                    this.$$this$forEachGesture = pointerInputScope;
                    this.$onExpandedChange = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C145471(this.$$this$forEachGesture, this.$onExpandedChange, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PointerInputScope pointerInputScope = this.$$this$forEachGesture;
                        C145481 c145481 = new C145481(this.$onExpandedChange, null);
                        this.label = 1;
                        if (pointerInputScope.awaitPointerEventScope(c145481, this) == coroutine_suspended) {
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
                    return ((C145471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onExpandedChange = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onExpandedChange, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    C145471 c145471 = new C145471((PointerInputScope) this.L$0, this.$onExpandedChange, null);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(c145471, this) == coroutine_suspended) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15401(Function0<Unit> function0, Continuation<? super C15401> continuation) {
            super(2, continuation);
            this.$onExpandedChange = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C15401 c15401 = new C15401(this.$onExpandedChange, continuation);
            c15401.L$0 = obj;
            return c15401;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C15401) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onExpandedChange, null);
                this.label = 1;
                if (ForEachGestureKt.forEachGesture(pointerInputScope, anonymousClass1, this) == coroutine_suspended) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0289 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x028a  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(final boolean z, @NotNull final Function1<? super Boolean, Unit> onExpandedChange, @Nullable Modifier modifier, @NotNull final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        final Density density;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        Object objRememberedValue3;
        boolean zChanged;
        Object objRememberedValue4;
        Object objRememberedValue5;
        boolean zChanged2;
        Object objRememberedValue6;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onExpandedChange, "onExpandedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1456052980);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onExpandedChange) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
            }
            if ((i4 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1456052980, i4, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:89)");
                }
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                final View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue2;
                final int iMo15540roundToPx0680j_4 = density.mo15540roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final Ref ref = (Ref) objRememberedValue3;
                Integer numValueOf = Integer.valueOf(m16750ExposedDropdownMenuBox$lambda4(mutableState2));
                Integer numValueOf2 = Integer.valueOf(m16748ExposedDropdownMenuBox$lambda1(mutableState));
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(numValueOf) | composerStartRestartGroup.changed(numValueOf2);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                        @Composable
                        public void ExposedDropdownMenu(boolean z2, @NotNull Function0<Unit> function0, @NotNull Modifier modifier5, @NotNull Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer2, int i6, int i7) {
                            ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(this, z2, function0, modifier5, function3, composer2, i6, i7);
                        }

                        @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                        @NotNull
                        public Modifier exposedDropdownSize(@NotNull Modifier modifier5, boolean z2) {
                            Intrinsics.checkNotNullParameter(modifier5, "<this>");
                            Density density2 = density;
                            MutableState<Integer> mutableState3 = mutableState2;
                            MutableState<Integer> mutableState4 = mutableState;
                            Modifier modifierM15887heightInVpY3zN4$default = SizeKt.m15887heightInVpY3zN4$default(modifier5, 0.0f, density2.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m16750ExposedDropdownMenuBox$lambda4(mutableState3)), 1, null);
                            return z2 ? SizeKt.m15904width3ABfNKs(modifierM15887heightInVpY3zN4$default, density2.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m16748ExposedDropdownMenuBox$lambda1(mutableState4))) : modifierM15887heightInVpY3zN4$default;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue4;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final FocusRequester focusRequester = (FocusRequester) objRememberedValue5;
                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LayoutCoordinates it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ExposedDropdownMenuKt.m16749ExposedDropdownMenuBox$lambda2(mutableState, IntSize.m21138getWidthimpl(it.mo19863getSizeYbymL2g()));
                        ref.setValue(it);
                        View rootView = view.getRootView();
                        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                        LayoutCoordinates value = ref.getValue();
                        int i6 = iMo15540roundToPx0680j_4;
                        final MutableState<Integer> mutableState3 = mutableState2;
                        ExposedDropdownMenuKt.updateHeight(rootView, value, i6, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i7) {
                                ExposedDropdownMenuKt.m16751ExposedDropdownMenuBox$lambda5(mutableState3, i7);
                            }
                        });
                    }
                });
                Boolean boolValueOf = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(onExpandedChange) | composerStartRestartGroup.changed(boolValueOf);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            onExpandedChange.invoke(Boolean.valueOf(!z));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(expandable(modifierOnGloballyPositioned, (Function0) objRememberedValue6, Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16866getExposedDropdownMenuUdPEhr4(), composerStartRestartGroup, 6)), focusRequester);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                int i6 = i4;
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Modifier modifier5 = modifier4;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFocusRequester);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density2));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-443225682);
                content.invoke(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1, composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 112));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (z) {
                            focusRequester.requestFocus();
                        }
                    }
                }, composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final View view2 = view;
                        final Ref<LayoutCoordinates> ref2 = ref;
                        final int i7 = iMo15540roundToPx0680j_4;
                        final MutableState<Integer> mutableState3 = mutableState2;
                        final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                View rootView = view2.getRootView();
                                Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                LayoutCoordinates value = ref2.getValue();
                                int i8 = i7;
                                final MutableState<Integer> mutableState4 = mutableState3;
                                ExposedDropdownMenuKt.updateHeight(rootView, value, i8, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i9) {
                                        ExposedDropdownMenuKt.m16751ExposedDropdownMenuBox$lambda5(mutableState4, i9);
                                    }
                                });
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                onGlobalLayoutListener.dispose();
                            }
                        };
                    }
                }, composerStartRestartGroup, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.6
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

                public final void invoke(@Nullable Composer composer2, int i7) {
                    ExposedDropdownMenuKt.ExposedDropdownMenuBox(z, onExpandedChange, modifier3, content, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i4 & 5851) == 1170) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            final View view2 = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState2 = (MutableState) objRememberedValue2;
            final int iMo15540roundToPx0680j_42 = density.mo15540roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            final Ref<LayoutCoordinates> ref2 = (Ref) objRememberedValue3;
            Integer numValueOf3 = Integer.valueOf(m16750ExposedDropdownMenuBox$lambda4(mutableState2));
            Integer numValueOf22 = Integer.valueOf(m16748ExposedDropdownMenuBox$lambda1(mutableState));
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(numValueOf3) | composerStartRestartGroup.changed(numValueOf22);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                    @Composable
                    public void ExposedDropdownMenu(boolean z2, @NotNull Function0<Unit> function0, @NotNull Modifier modifier52, @NotNull Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer2, int i62, int i7) {
                        ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(this, z2, function0, modifier52, function3, composer2, i62, i7);
                    }

                    @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                    @NotNull
                    public Modifier exposedDropdownSize(@NotNull Modifier modifier52, boolean z2) {
                        Intrinsics.checkNotNullParameter(modifier52, "<this>");
                        Density density22 = density;
                        MutableState<Integer> mutableState3 = mutableState2;
                        MutableState<Integer> mutableState4 = mutableState;
                        Modifier modifierM15887heightInVpY3zN4$default = SizeKt.m15887heightInVpY3zN4$default(modifier52, 0.0f, density22.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m16750ExposedDropdownMenuBox$lambda4(mutableState3)), 1, null);
                        return z2 ? SizeKt.m15904width3ABfNKs(modifierM15887heightInVpY3zN4$default, density22.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m16748ExposedDropdownMenuBox$lambda1(mutableState4))) : modifierM15887heightInVpY3zN4$default;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                composerStartRestartGroup.endReplaceableGroup();
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$12 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue4;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                final FocusRequester focusRequester2 = (FocusRequester) objRememberedValue5;
                Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LayoutCoordinates it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ExposedDropdownMenuKt.m16749ExposedDropdownMenuBox$lambda2(mutableState, IntSize.m21138getWidthimpl(it.mo19863getSizeYbymL2g()));
                        ref2.setValue(it);
                        View rootView = view2.getRootView();
                        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                        LayoutCoordinates value = ref2.getValue();
                        int i62 = iMo15540roundToPx0680j_42;
                        final MutableState<Integer> mutableState3 = mutableState2;
                        ExposedDropdownMenuKt.updateHeight(rootView, value, i62, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i7) {
                                ExposedDropdownMenuKt.m16751ExposedDropdownMenuBox$lambda5(mutableState3, i7);
                            }
                        });
                    }
                });
                Boolean boolValueOf2 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(onExpandedChange) | composerStartRestartGroup.changed(boolValueOf2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue6 = new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            onExpandedChange.invoke(Boolean.valueOf(!z));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(expandable(modifierOnGloballyPositioned2, (Function0) objRememberedValue6, Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16866getExposedDropdownMenuUdPEhr4(), composerStartRestartGroup, 6)), focusRequester2);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
                    Density density22 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    int i62 = i4;
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Modifier modifier52 = modifier4;
                    Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierFocusRequester2);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl2, measurePolicyM1210k2, composerM18018constructorimpl2, density22));
                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-443225682);
                    content.invoke(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$12, composerStartRestartGroup, Integer.valueOf((i62 >> 6) & 112));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (z) {
                                focusRequester2.requestFocus();
                            }
                        }
                    }, composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(view2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final View view22 = view2;
                            final Ref<LayoutCoordinates> ref22 = ref2;
                            final int i7 = iMo15540roundToPx0680j_42;
                            final MutableState<Integer> mutableState3 = mutableState2;
                            final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view22, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    View rootView = view22.getRootView();
                                    Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                    LayoutCoordinates value = ref22.getValue();
                                    int i8 = i7;
                                    final MutableState<Integer> mutableState4 = mutableState3;
                                    ExposedDropdownMenuKt.updateHeight(rootView, value, i8, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                            invoke(num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(int i9) {
                                            ExposedDropdownMenuKt.m16751ExposedDropdownMenuBox$lambda5(mutableState4, i9);
                                        }
                                    });
                                }
                            });
                            return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    onGlobalLayoutListener.dispose();
                                }
                            };
                        }
                    }, composerStartRestartGroup, 8);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier52;
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-1, reason: not valid java name */
    public static final int m16748ExposedDropdownMenuBox$lambda1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-2, reason: not valid java name */
    public static final void m16749ExposedDropdownMenuBox$lambda2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-4, reason: not valid java name */
    public static final int m16750ExposedDropdownMenuBox$lambda4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-5, reason: not valid java name */
    public static final void m16751ExposedDropdownMenuBox$lambda5(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final Modifier expandable(Modifier modifier, final Function0<Unit> function0, final String str) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, Unit.INSTANCE, new C15401(function0, null)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.expandable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, str);
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ExposedDropdownMenuKt.expandable.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        function02.invoke();
                        return Boolean.TRUE;
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates == null) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop() - rect.top, (rect.bottom - r1) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i));
    }
}
