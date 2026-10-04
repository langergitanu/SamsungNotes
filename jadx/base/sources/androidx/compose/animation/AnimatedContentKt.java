package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutModifierKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.samsung.scsp.odm.dos.common.OdmDosApiContract;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p002A0.C0009i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0086\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0087\u0004¨\u0006("}, m13886d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", OdmDosApiContract.Parameter.CONTENT_KEY, "Lkotlin/ParameterName;", "name", "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnimatedContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimatedContent.kt\nandroidx/compose/animation/AnimatedContentKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,899:1\n77#2:900\n1225#3,6:901\n1225#3,6:907\n1225#3,6:913\n1225#3,6:932\n1225#3,6:938\n350#4,7:919\n33#5,6:926\n33#5,6:972\n79#6,6:944\n86#6,4:959\n90#6,2:969\n94#6:980\n368#7,9:950\n377#7:971\n378#7,2:978\n4034#8,6:963\n*S KotlinDebug\n*F\n+ 1 AnimatedContent.kt\nandroidx/compose/animation/AnimatedContentKt\n*L\n715#1:900\n716#1:901,6\n720#1:907,6\n721#1:913,6\n809#1:932,6\n820#1:938,6\n747#1:919,7\n756#1:926,6\n814#1:972,6\n811#1:944,6\n811#1:959,4\n811#1:969,2\n811#1:980\n811#1:950,9\n811#1:971\n811#1:978,2\n811#1:963,6\n*E\n"})
public final class AnimatedContentKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0108  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final S s, @Nullable Modifier modifier, @Nullable Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, @Nullable Alignment alignment, @Nullable String str, @Nullable Function1<? super S, ? extends Object> function12, @NotNull final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        int i6;
        Alignment topStart;
        int i7;
        String str2;
        int i8;
        Function1<? super S, ? extends Object> function14;
        Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42;
        final String str3;
        final Modifier modifier3;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function15;
        final Alignment alignment2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2132720749);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(s) : composerStartRestartGroup.changedInstance(s) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function13 = function1;
                    i4 |= composerStartRestartGroup.changedInstance(function13) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        topStart = alignment;
                        i4 |= composerStartRestartGroup.changed(topStart) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            str2 = str;
                            i4 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
                        }
                        i8 = i2 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                        } else {
                            if ((196608 & i) == 0) {
                                function14 = function12;
                                i4 |= composerStartRestartGroup.changedInstance(function14) ? 131072 : 65536;
                            }
                            if ((i2 & 64) != 0) {
                                if ((i & 1572864) == 0) {
                                    function42 = function4;
                                    i4 |= composerStartRestartGroup.changedInstance(function42) ? 1048576 : 524288;
                                }
                                if ((i4 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier2;
                                    function15 = function13;
                                    alignment2 = topStart;
                                    str3 = str2;
                                } else {
                                    Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i5 != 0) {
                                        function13 = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.1
                                            @Override // kotlin.jvm.functions.Function1
                                            @NotNull
                                            public final ContentTransform invoke(@NotNull AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                                return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m15249scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                            }
                                        };
                                    }
                                    if (i6 != 0) {
                                        topStart = Alignment.INSTANCE.getTopStart();
                                    }
                                    String str4 = i7 == 0 ? "AnimatedContent" : str2;
                                    if (i8 != 0) {
                                        function14 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final S invoke(S s2) {
                                                return s2;
                                            }
                                        };
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2132720749, i4, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
                                    }
                                    Transition transitionUpdateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(s, str4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 9) & 112), 0);
                                    int i10 = i4 & 8176;
                                    int i11 = i4 >> 3;
                                    Modifier modifier5 = modifier4;
                                    Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function16 = function13;
                                    Alignment alignment3 = topStart;
                                    AnimatedContent(transitionUpdateTransition, modifier5, function16, alignment3, function14, function42, composerStartRestartGroup, i10 | (57344 & i11) | (i11 & 458752), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    str3 = str4;
                                    modifier3 = modifier5;
                                    function15 = function16;
                                    alignment2 = alignment3;
                                }
                                final Function1<? super S, ? extends Object> function17 = function14;
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.3
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

                                        public final void invoke(@Nullable Composer composer2, int i12) {
                                            AnimatedContentKt.AnimatedContent(s, modifier3, function15, alignment2, str3, function17, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i4 |= 1572864;
                            function42 = function4;
                            if ((i4 & 599187) == 599186) {
                                if (i9 == 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Transition transitionUpdateTransition2 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 9) & 112), 0);
                                int i102 = i4 & 8176;
                                int i112 = i4 >> 3;
                                Modifier modifier52 = modifier4;
                                Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function162 = function13;
                                Alignment alignment32 = topStart;
                                AnimatedContent(transitionUpdateTransition2, modifier52, function162, alignment32, function14, function42, composerStartRestartGroup, i102 | (57344 & i112) | (i112 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                str3 = str4;
                                modifier3 = modifier52;
                                function15 = function162;
                                alignment2 = alignment32;
                            }
                            final Function1<? super S, ? extends Object> function172 = function14;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        function14 = function12;
                        if ((i2 & 64) != 0) {
                        }
                        function42 = function4;
                        if ((i4 & 599187) == 599186) {
                        }
                        final Function1<? super S, ? extends Object> function1722 = function14;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    str2 = str;
                    i8 = i2 & 32;
                    if (i8 != 0) {
                    }
                    function14 = function12;
                    if ((i2 & 64) != 0) {
                    }
                    function42 = function4;
                    if ((i4 & 599187) == 599186) {
                    }
                    final Function1<? super S, ? extends Object> function17222 = function14;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                topStart = alignment;
                i7 = i2 & 16;
                if (i7 == 0) {
                }
                str2 = str;
                i8 = i2 & 32;
                if (i8 != 0) {
                }
                function14 = function12;
                if ((i2 & 64) != 0) {
                }
                function42 = function4;
                if ((i4 & 599187) == 599186) {
                }
                final Function1<? super S, ? extends Object> function172222 = function14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function13 = function1;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            topStart = alignment;
            i7 = i2 & 16;
            if (i7 == 0) {
            }
            str2 = str;
            i8 = i2 & 32;
            if (i8 != 0) {
            }
            function14 = function12;
            if ((i2 & 64) != 0) {
            }
            function42 = function4;
            if ((i4 & 599187) == 599186) {
            }
            final Function1<? super S, ? extends Object> function1722222 = function14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function13 = function1;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        topStart = alignment;
        i7 = i2 & 16;
        if (i7 == 0) {
        }
        str2 = str;
        i8 = i2 & 32;
        if (i8 != 0) {
        }
        function14 = function12;
        if ((i2 & 64) != 0) {
        }
        function42 = function4;
        if ((i4 & 599187) == 599186) {
        }
        final Function1<? super S, ? extends Object> function17222222 = function14;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @NotNull
    public static final SizeTransform SizeTransform(boolean z, @NotNull Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z, function2);
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt.SizeTransform.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m15213invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                }

                @NotNull
                /* JADX INFO: renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m15213invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m21130boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    @NotNull
    public static final ContentTransform togetherWith(@NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    @ExperimentalAnimationApi
    @NotNull
    public static final ContentTransform with(@NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x023a A[LOOP:2: B:153:0x0238->B:154:0x023a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(@NotNull final Transition<S> transition, @Nullable Modifier modifier, @Nullable Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, @Nullable Alignment alignment, @Nullable Function1<? super S, ? extends Object> function12, @NotNull final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        int i6;
        Alignment topStart;
        int i7;
        Function1<? super S, ? extends Object> function14;
        Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function15;
        LayoutDirection layoutDirection;
        boolean z;
        Object objRememberedValue;
        final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl;
        boolean z2;
        Object objRememberedValue2;
        SnapshotStateList snapshotStateList;
        boolean z3;
        Object objRememberedValue3;
        MutableScatterMap mutableScatterMap;
        int size;
        int i8;
        SnapshotStateList snapshotStateList2;
        MutableScatterMap mutableScatterMap2;
        boolean zChanged;
        ContentTransform contentTransformRememberedValue;
        Object objRememberedValue4;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int size2;
        int i9;
        final Modifier modifier3;
        Iterator<T> it;
        int i10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Transition<S> transition2 = transition;
        Composer composerStartRestartGroup = composer.startRestartGroup(-114689412);
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(transition2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 2;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function13 = function1;
                    i4 |= composerStartRestartGroup.changedInstance(function13) ? 256 : 128;
                }
                i6 = i2 & 4;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        topStart = alignment;
                        i4 |= composerStartRestartGroup.changed(topStart) ? 2048 : 1024;
                    }
                    i7 = i2 & 8;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            function14 = function12;
                            i4 |= composerStartRestartGroup.changedInstance(function14) ? 16384 : 8192;
                        }
                        if ((i2 & 16) == 0) {
                            if ((i & 196608) == 0) {
                                function42 = function4;
                                i4 |= composerStartRestartGroup.changedInstance(function42) ? 131072 : 65536;
                            }
                            if ((74899 & i4) != 74898 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                function15 = function13;
                            } else {
                                Modifier modifier4 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                                function15 = i5 == 0 ? new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.4
                                    @Override // kotlin.jvm.functions.Function1
                                    @NotNull
                                    public final ContentTransform invoke(@NotNull AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m15249scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                    }
                                } : function13;
                                if (i6 != 0) {
                                    topStart = Alignment.INSTANCE.getTopStart();
                                }
                                if (i7 != 0) {
                                    function14 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final S invoke(S s) {
                                            return s;
                                        }
                                    };
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-114689412, i4, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:713)");
                                }
                                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                int i12 = i4 & 14;
                                z = i12 != 4;
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition2, topStart, layoutDirection);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                                z2 = i12 != 4;
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition2.getCurrentState());
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                                z3 = i12 != 4;
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                mutableScatterMap = (MutableScatterMap) objRememberedValue3;
                                if (!snapshotStateList.contains(transition2.getCurrentState())) {
                                    snapshotStateList.clear();
                                    snapshotStateList.add(transition2.getCurrentState());
                                }
                                if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                                    if (snapshotStateList.size() != 1 || !Intrinsics.areEqual(snapshotStateList.get(0), transition2.getCurrentState())) {
                                        snapshotStateList.clear();
                                        snapshotStateList.add(transition2.getCurrentState());
                                    }
                                    if (mutableScatterMap.get_size() != 1 || mutableScatterMap.containsKey(transition2.getCurrentState())) {
                                        mutableScatterMap.clear();
                                    }
                                    animatedContentTransitionScopeImpl.setContentAlignment(topStart);
                                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                                }
                                if (!Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState()) && !snapshotStateList.contains(transition2.getTargetState())) {
                                    it = snapshotStateList.iterator();
                                    i10 = 0;
                                    while (true) {
                                        if (it.hasNext()) {
                                            i10 = -1;
                                            break;
                                        } else if (Intrinsics.areEqual(function14.invoke((Object) it.next()), function14.invoke(transition2.getTargetState()))) {
                                            break;
                                        } else {
                                            i10++;
                                        }
                                    }
                                    if (i10 != -1) {
                                        snapshotStateList.add(transition2.getTargetState());
                                    } else {
                                        snapshotStateList.set(i10, transition2.getTargetState());
                                    }
                                }
                                if (!mutableScatterMap.containsKey(transition2.getTargetState()) && mutableScatterMap.containsKey(transition2.getCurrentState())) {
                                    composerStartRestartGroup.startReplaceGroup(915535767);
                                    composerStartRestartGroup.endReplaceGroup();
                                    snapshotStateList2 = snapshotStateList;
                                    mutableScatterMap2 = mutableScatterMap;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(912931457);
                                    mutableScatterMap.clear();
                                    size = snapshotStateList.size();
                                    i8 = 0;
                                    while (i8 < size) {
                                        MutableScatterMap mutableScatterMap3 = mutableScatterMap;
                                        final T t = snapshotStateList.get(i8);
                                        final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function43 = function42;
                                        final SnapshotStateList snapshotStateList3 = snapshotStateList;
                                        mutableScatterMap3.set(t, ComposableLambdaKt.rememberComposableLambda(885640742, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
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

                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                             */
                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer2, int i13) {
                                                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(885640742, i13, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:757)");
                                                }
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function16 = function15;
                                                Object obj = animatedContentTransitionScopeImpl;
                                                ContentTransform contentTransformRememberedValue2 = composer2.rememberedValue();
                                                Composer.Companion companion = Composer.INSTANCE;
                                                if (contentTransformRememberedValue2 == companion.getEmpty()) {
                                                    contentTransformRememberedValue2 = function16.invoke(obj);
                                                    composer2.updateRememberedValue(contentTransformRememberedValue2);
                                                }
                                                final ContentTransform contentTransform = (ContentTransform) contentTransformRememberedValue2;
                                                boolean zChanged2 = composer2.changed(Intrinsics.areEqual(transition2.getSegment().getTargetState(), t));
                                                Transition<S> transition3 = transition2;
                                                S s = t;
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function17 = function15;
                                                Object obj2 = animatedContentTransitionScopeImpl;
                                                Object objRememberedValue5 = composer2.rememberedValue();
                                                if (zChanged2 || objRememberedValue5 == companion.getEmpty()) {
                                                    objRememberedValue5 = Intrinsics.areEqual(transition3.getSegment().getTargetState(), s) ? ExitTransition.INSTANCE.getNone() : function17.invoke(obj2).getInitialContentExit();
                                                    composer2.updateRememberedValue(objRememberedValue5);
                                                }
                                                final ExitTransition exitTransition = (ExitTransition) objRememberedValue5;
                                                S s2 = t;
                                                Transition<S> transition4 = transition2;
                                                Object objRememberedValue6 = composer2.rememberedValue();
                                                if (objRememberedValue6 == companion.getEmpty()) {
                                                    objRememberedValue6 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(s2, transition4.getTargetState()));
                                                    composer2.updateRememberedValue(objRememberedValue6);
                                                }
                                                AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) objRememberedValue6;
                                                EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                boolean zChangedInstance = composer2.changedInstance(contentTransform);
                                                Object objRememberedValue7 = composer2.rememberedValue();
                                                if (zChangedInstance || objRememberedValue7 == companion.getEmpty()) {
                                                    objRememberedValue7 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                                            return m15212invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                                        }

                                                        @NotNull
                                                        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                                        public final MeasureResult m15212invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
                                                            final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
                                                            int width = placeableMo19855measureBRTryo0.getWidth();
                                                            int height = placeableMo19855measureBRTryo0.getHeight();
                                                            final ContentTransform contentTransform2 = contentTransform;
                                                            return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                    invoke2(placementScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                                                    placementScope.place(placeableMo19855measureBRTryo0, 0, 0, contentTransform2.getTargetContentZIndex());
                                                                }
                                                            }, 4, null);
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(objRememberedValue7);
                                                }
                                                Modifier modifierLayout = LayoutModifierKt.layout(companion2, (Function3) objRememberedValue7);
                                                childData.setTarget(Intrinsics.areEqual(t, transition2.getTargetState()));
                                                Modifier modifierThen = modifierLayout.then(childData);
                                                Transition<S> transition5 = transition2;
                                                boolean zChangedInstance2 = composer2.changedInstance(t);
                                                final S s3 = t;
                                                Object objRememberedValue8 = composer2.rememberedValue();
                                                if (zChangedInstance2 || objRememberedValue8 == companion.getEmpty()) {
                                                    objRememberedValue8 = new Function1<S, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$3$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        @NotNull
                                                        public final Boolean invoke(S s4) {
                                                            return Boolean.valueOf(Intrinsics.areEqual(s4, s3));
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(objRememberedValue8);
                                                }
                                                Function1 function18 = (Function1) objRememberedValue8;
                                                boolean zChanged3 = composer2.changed(exitTransition);
                                                Object objRememberedValue9 = composer2.rememberedValue();
                                                if (zChanged3 || objRememberedValue9 == companion.getEmpty()) {
                                                    objRememberedValue9 = new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        @NotNull
                                                        public final Boolean invoke(@NotNull EnterExitState enterExitState, @NotNull EnterExitState enterExitState2) {
                                                            EnterExitState enterExitState3 = EnterExitState.PostExit;
                                                            return Boolean.valueOf(enterExitState == enterExitState3 && enterExitState2 == enterExitState3 && !exitTransition.getData().getHold());
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(objRememberedValue9);
                                                }
                                                Function2 function2 = (Function2) objRememberedValue9;
                                                final SnapshotStateList<S> snapshotStateList4 = snapshotStateList3;
                                                final S s4 = t;
                                                final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                                                final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function44 = function43;
                                                AnimatedVisibilityKt.AnimatedEnterExitImpl(transition5, function18, modifierThen, targetContentEnter, exitTransition, function2, null, ComposableLambdaKt.rememberComposableLambda(-616195562, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                                     */
                                                    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
                                                        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v10 boolean
                                                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
                                                        */
                                                    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @androidx.compose.runtime.Composable
                                                    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.animation.AnimatedVisibilityScope r6, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r7, int r8) {
                                                        /*
                                                            r5 = this;
                                                            r0 = r8 & 6
                                                            if (r0 != 0) goto L17
                                                            r0 = r8 & 8
                                                            if (r0 != 0) goto Ld
                                                            boolean r0 = r7.changed(r6)
                                                            goto L11
                                                        Ld:
                                                            boolean r0 = r7.changedInstance(r6)
                                                        L11:
                                                            if (r0 == 0) goto L15
                                                            r0 = 4
                                                            goto L16
                                                        L15:
                                                            r0 = 2
                                                        L16:
                                                            r8 = r8 | r0
                                                        L17:
                                                            r0 = r8 & 19
                                                            r1 = 18
                                                            if (r0 != r1) goto L28
                                                            boolean r0 = r7.getSkipping()
                                                            if (r0 != 0) goto L24
                                                            goto L28
                                                        L24:
                                                            r7.skipToGroupEnd()
                                                            return
                                                        L28:
                                                            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                            if (r0 == 0) goto L37
                                                            r0 = -1
                                                            java.lang.String r1 = "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:793)"
                                                            r2 = -616195562(0xffffffffdb459a16, float:-5.561999E16)
                                                            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r0, r1)
                                                        L37:
                                                            androidx.compose.runtime.snapshots.SnapshotStateList<S> r0 = r1
                                                            boolean r0 = r7.changed(r0)
                                                            S r1 = r2
                                                            boolean r1 = r7.changedInstance(r1)
                                                            r0 = r0 | r1
                                                            androidx.compose.animation.AnimatedContentTransitionScopeImpl<S> r1 = r3
                                                            boolean r1 = r7.changedInstance(r1)
                                                            r0 = r0 | r1
                                                            androidx.compose.runtime.snapshots.SnapshotStateList<S> r1 = r1
                                                            S r2 = r2
                                                            androidx.compose.animation.AnimatedContentTransitionScopeImpl<S> r3 = r3
                                                            java.lang.Object r4 = r7.rememberedValue()
                                                            if (r0 != 0) goto L5f
                                                            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
                                                            java.lang.Object r0 = r0.getEmpty()
                                                            if (r4 != r0) goto L67
                                                        L5f:
                                                            androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1 r4 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1
                                                            r4.<init>()
                                                            r7.updateRememberedValue(r4)
                                                        L67:
                                                            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                                                            r8 = r8 & 14
                                                            androidx.compose.runtime.EffectsKt.DisposableEffect(r6, r4, r7, r8)
                                                            androidx.compose.animation.AnimatedContentTransitionScopeImpl<S> r8 = r3
                                                            androidx.collection.MutableScatterMap r8 = r8.getTargetSizeMap$animation_release()
                                                            S r0 = r2
                                                            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.animation.AnimatedVisibilityScopeImpl"
                                                            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
                                                            r1 = r6
                                                            androidx.compose.animation.AnimatedVisibilityScopeImpl r1 = (androidx.compose.animation.AnimatedVisibilityScopeImpl) r1
                                                            androidx.compose.runtime.MutableState r1 = r1.getTargetSize$animation_release()
                                                            r8.set(r0, r1)
                                                            java.lang.Object r8 = r7.rememberedValue()
                                                            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
                                                            java.lang.Object r0 = r0.getEmpty()
                                                            if (r8 != r0) goto L99
                                                            androidx.compose.animation.AnimatedContentScopeImpl r8 = new androidx.compose.animation.AnimatedContentScopeImpl
                                                            r8.<init>(r6)
                                                            r7.updateRememberedValue(r8)
                                                        L99:
                                                            androidx.compose.animation.AnimatedContentScopeImpl r8 = (androidx.compose.animation.AnimatedContentScopeImpl) r8
                                                            kotlin.jvm.functions.Function4<androidx.compose.animation.AnimatedContentScope, S, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r4
                                                            S r0 = r2
                                                            r1 = 0
                                                            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                                                            r6.invoke(r8, r0, r7, r1)
                                                            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                            if (r6 == 0) goto Lb0
                                                            androidx.compose.runtime.ComposerKt.traceEventEnd()
                                                        Lb0:
                                                            return
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.C06295.invoke(androidx.compose.animation.AnimatedVisibilityScope, androidx.compose.runtime.Composer, int):void");
                                                    }
                                                }, composer2, 54), composer2, 12582912, 64);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54));
                                        i8++;
                                        transition2 = transition;
                                        function42 = function4;
                                        mutableScatterMap = mutableScatterMap3;
                                        snapshotStateList = snapshotStateList3;
                                    }
                                    snapshotStateList2 = snapshotStateList;
                                    mutableScatterMap2 = mutableScatterMap;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                zChanged = composerStartRestartGroup.changed(transition.getSegment()) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                                contentTransformRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || contentTransformRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    contentTransformRememberedValue = function15.invoke(animatedContentTransitionScopeImpl);
                                    composerStartRestartGroup.updateRememberedValue(contentTransformRememberedValue);
                                }
                                Modifier modifierThen = modifier4.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) contentTransformRememberedValue, composerStartRestartGroup, 0));
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) objRememberedValue4;
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                if (composerStartRestartGroup.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (!composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Updater.m18025setimpl(composerM18018constructorimpl, animatedContentMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                                }
                                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                composerStartRestartGroup.startReplaceGroup(-1491001814);
                                size2 = snapshotStateList2.size();
                                for (i9 = 0; i9 < size2; i9++) {
                                    C0009i c0009i = (Object) snapshotStateList2.get(i9);
                                    composerStartRestartGroup.startMovableGroup(1908315325, function14.invoke(c0009i));
                                    Function2 function2 = (Function2) mutableScatterMap2.get(c0009i);
                                    if (function2 == null) {
                                        composerStartRestartGroup.startReplaceGroup(-971711888);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1908317105);
                                        function2.invoke(composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    composerStartRestartGroup.endMovableGroup();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                            }
                            final Alignment alignment2 = topStart;
                            final Function1<? super S, ? extends Object> function16 = function14;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.9
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

                                    public final void invoke(@Nullable Composer composer2, int i13) {
                                        AnimatedContentKt.AnimatedContent(transition, modifier3, function15, alignment2, function16, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 196608;
                        function42 = function4;
                        if ((74899 & i4) != 74898) {
                            if (i11 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            int i122 = i4 & 14;
                            if (i122 != 4) {
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z) {
                                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition2, topStart, layoutDirection);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                                if (i122 != 4) {
                                }
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!z2) {
                                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition2.getCurrentState());
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                                    if (i122 != 4) {
                                    }
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!z3) {
                                        objRememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        mutableScatterMap = (MutableScatterMap) objRememberedValue3;
                                        if (!snapshotStateList.contains(transition2.getCurrentState())) {
                                        }
                                        if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                                        }
                                        if (!Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                                            it = snapshotStateList.iterator();
                                            i10 = 0;
                                            while (true) {
                                                if (it.hasNext()) {
                                                }
                                                i10++;
                                            }
                                            if (i10 != -1) {
                                            }
                                        }
                                        if (!mutableScatterMap.containsKey(transition2.getTargetState())) {
                                            composerStartRestartGroup.startReplaceGroup(912931457);
                                            mutableScatterMap.clear();
                                            size = snapshotStateList.size();
                                            i8 = 0;
                                            while (i8 < size) {
                                            }
                                            snapshotStateList2 = snapshotStateList;
                                            mutableScatterMap2 = mutableScatterMap;
                                            composerStartRestartGroup.endReplaceGroup();
                                            zChanged = composerStartRestartGroup.changed(transition.getSegment()) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                                            contentTransformRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (!zChanged) {
                                                contentTransformRememberedValue = function15.invoke(animatedContentTransitionScopeImpl);
                                                composerStartRestartGroup.updateRememberedValue(contentTransformRememberedValue);
                                                Modifier modifierThen2 = modifier4.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) contentTransformRememberedValue, composerStartRestartGroup, 0));
                                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                }
                                                AnimatedContentMeasurePolicy animatedContentMeasurePolicy2 = (AnimatedContentMeasurePolicy) objRememberedValue4;
                                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
                                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                                if (composerStartRestartGroup.getApplier() == null) {
                                                }
                                                composerStartRestartGroup.startReusableNode();
                                                if (!composerStartRestartGroup.getInserting()) {
                                                }
                                                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                                Updater.m18025setimpl(composerM18018constructorimpl, animatedContentMeasurePolicy2, companion2.getSetMeasurePolicy());
                                                Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                                                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                                if (!composerM18018constructorimpl.getInserting()) {
                                                    AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                                                    composerStartRestartGroup.startReplaceGroup(-1491001814);
                                                    size2 = snapshotStateList2.size();
                                                    while (i9 < size2) {
                                                    }
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    composerStartRestartGroup.endNode();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    modifier3 = modifier4;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        final Alignment alignment22 = topStart;
                        final Function1<? super S, ? extends Object> function162 = function14;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    function14 = function12;
                    if ((i2 & 16) == 0) {
                    }
                    function42 = function4;
                    if ((74899 & i4) != 74898) {
                    }
                    final Alignment alignment222 = topStart;
                    final Function1<? super S, ? extends Object> function1622 = function14;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                topStart = alignment;
                i7 = i2 & 8;
                if (i7 == 0) {
                }
                function14 = function12;
                if ((i2 & 16) == 0) {
                }
                function42 = function4;
                if ((74899 & i4) != 74898) {
                }
                final Alignment alignment2222 = topStart;
                final Function1<? super S, ? extends Object> function16222 = function14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function13 = function1;
            i6 = i2 & 4;
            if (i6 != 0) {
            }
            topStart = alignment;
            i7 = i2 & 8;
            if (i7 == 0) {
            }
            function14 = function12;
            if ((i2 & 16) == 0) {
            }
            function42 = function4;
            if ((74899 & i4) != 74898) {
            }
            final Alignment alignment22222 = topStart;
            final Function1<? super S, ? extends Object> function162222 = function14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 2;
        if (i5 == 0) {
        }
        function13 = function1;
        i6 = i2 & 4;
        if (i6 != 0) {
        }
        topStart = alignment;
        i7 = i2 & 8;
        if (i7 == 0) {
        }
        function14 = function12;
        if ((i2 & 16) == 0) {
        }
        function42 = function4;
        if ((74899 & i4) != 74898) {
        }
        final Alignment alignment222222 = topStart;
        final Function1<? super S, ? extends Object> function1622222 = function14;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
