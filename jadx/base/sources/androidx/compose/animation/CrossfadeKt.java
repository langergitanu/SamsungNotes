package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\u0010\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002X\u008a\u0084\u0002"}, m13886d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", OdmDosApiContract.Parameter.CONTENT_KEY, "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release", "alpha"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCrossfade.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Crossfade.kt\nandroidx/compose/animation/CrossfadeKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 6 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 7 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 8 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 9 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,146:1\n1225#2,3:147\n1228#2,3:151\n1225#2,6:154\n1225#2,6:160\n1#3:150\n350#4,7:166\n33#5,6:173\n33#5,6:215\n71#6:179\n68#6,6:180\n74#6:214\n78#6:224\n79#7,6:186\n86#7,4:201\n90#7,2:211\n94#7:223\n368#8,9:192\n377#8:213\n378#8,2:221\n4034#9,6:205\n*S KotlinDebug\n*F\n+ 1 Crossfade.kt\nandroidx/compose/animation/CrossfadeKt\n*L\n105#1:147,3\n105#1:151,3\n106#1:154,6\n111#1:160,6\n117#1:166,7\n126#1:173,6\n139#1:215,6\n138#1:179\n138#1:180,6\n138#1:214\n138#1:224\n138#1:186,6\n138#1:201,4\n138#1:211,2\n138#1:223\n138#1:192,9\n138#1:213\n138#1:221,2\n138#1:205,6\n*E\n"})
public final class CrossfadeKt {
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(final T t, @Nullable Modifier modifier, @Nullable FiniteAnimationSpec<Float> finiteAnimationSpec, @Nullable String str, @NotNull final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        FiniteAnimationSpec<Float> finiteAnimationSpec2;
        int i6;
        String str2;
        Function3<? super T, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier3;
        final FiniteAnimationSpec<Float> finiteAnimationSpec3;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-310686752);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(t) : composerStartRestartGroup.changedInstance(t) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
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
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    i4 |= composerStartRestartGroup.changedInstance(finiteAnimationSpec2) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 == 0) {
                    if ((i & 3072) == 0) {
                        str2 = str;
                        i4 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
                    }
                    if ((i2 & 16) == 0) {
                        i4 |= 24576;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i & 24576) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function32) ? 16384 : 8192;
                        }
                    }
                    if ((i4 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        Modifier modifier4 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = i5 == 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec2;
                        String str4 = i6 == 0 ? "Crossfade" : str2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-310686752, i4, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                        }
                        Modifier modifier5 = modifier4;
                        FiniteAnimationSpec<Float> finiteAnimationSpec4 = finiteAnimationSpecTween$default;
                        Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 6) & 112), 0), modifier5, finiteAnimationSpec4, (Function1) null, function32, composerStartRestartGroup, i4 & 58352, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        finiteAnimationSpec3 = finiteAnimationSpec4;
                        str3 = str4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        finiteAnimationSpec3 = finiteAnimationSpec2;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
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

                            public final void invoke(@Nullable Composer composer2, int i8) {
                                CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 3072;
                str2 = str;
                if ((i2 & 16) == 0) {
                }
                if ((i4 & 9363) == 9362) {
                    if (i7 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier modifier52 = modifier4;
                    FiniteAnimationSpec<Float> finiteAnimationSpec42 = finiteAnimationSpecTween$default;
                    Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 6) & 112), 0), modifier52, finiteAnimationSpec42, (Function1) null, function32, composerStartRestartGroup, i4 & 58352, 4);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier52;
                    finiteAnimationSpec3 = finiteAnimationSpec42;
                    str3 = str4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            finiteAnimationSpec2 = finiteAnimationSpec;
            i6 = i2 & 8;
            if (i6 == 0) {
            }
            str2 = str;
            if ((i2 & 16) == 0) {
            }
            if ((i4 & 9363) == 9362) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        finiteAnimationSpec2 = finiteAnimationSpec;
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        str2 = str;
        if ((i2 & 16) == 0) {
        }
        if ((i4 & 9363) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    @Composable
    public static final /* synthetic */ void Crossfade(final Object obj, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function3 function3, Composer composer, final int i, final int i2) {
        int i4;
        final Function3 function32;
        final Modifier modifier2;
        final FiniteAnimationSpec finiteAnimationSpec2;
        Composer composerStartRestartGroup = composer.startRestartGroup(523603005);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(obj) : composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(finiteAnimationSpec) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function32 = function3;
            finiteAnimationSpec2 = finiteAnimationSpec;
            modifier2 = modifier;
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i6 != 0) {
                finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            }
            FiniteAnimationSpec finiteAnimationSpec3 = finiteAnimationSpec;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, i4, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:71)");
            }
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(obj, (String) null, composerStartRestartGroup, i4 & 14, 2), modifier3, (FiniteAnimationSpec<Float>) finiteAnimationSpec3, (Function1) null, function3, composerStartRestartGroup, (i4 & 1008) | ((i4 << 3) & 57344), 4);
            function32 = function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            finiteAnimationSpec2 = finiteAnimationSpec3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    CrossfadeKt.Crossfade(obj, modifier2, finiteAnimationSpec2, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015a  */
    @Composable
    @ExperimentalAnimationApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(@NotNull final Transition<T> transition, @Nullable Modifier modifier, @Nullable FiniteAnimationSpec<Float> finiteAnimationSpec, @Nullable Function1<? super T, ? extends Object> function1, @NotNull final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        FiniteAnimationSpec<Float> finiteAnimationSpec2;
        int i6;
        Function1<? super T, ? extends Object> function12;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        MutableScatterMap mutableScatterMap;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2 function2M1177w;
        int size;
        int i7;
        final FiniteAnimationSpec<Float> finiteAnimationSpec3;
        final Function1<? super T, ? extends Object> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(679005231);
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 1;
        if (i8 != 0) {
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
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    i4 |= composerStartRestartGroup.changedInstance(finiteAnimationSpec2) ? 256 : 128;
                }
                i6 = i2 & 4;
                if (i6 == 0) {
                    if ((i & 3072) == 0) {
                        function12 = function1;
                        i4 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    if ((i2 & 8) == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    }
                    if ((i4 & 9363) != 9362 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        finiteAnimationSpec3 = finiteAnimationSpec2;
                        function13 = function12;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = i5 == 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec2;
                        Function1<? super T, ? extends Object> function14 = i6 == 0 ? new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.3
                            @Override // kotlin.jvm.functions.Function1
                            public final T invoke(T t) {
                                return t;
                            }
                        } : function12;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(679005231, i4, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:103)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        Object obj = objRememberedValue;
                        if (objRememberedValue == companion.getEmpty()) {
                            SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                            snapshotStateListMutableStateListOf.add(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf);
                            obj = snapshotStateListMutableStateListOf;
                        }
                        SnapshotStateList snapshotStateList = (SnapshotStateList) obj;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                        if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                            composerStartRestartGroup.startReplaceGroup(860660313);
                            if (snapshotStateList.size() == 1 && Intrinsics.areEqual(snapshotStateList.get(0), transition.getTargetState())) {
                                composerStartRestartGroup.startReplaceGroup(860984945);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(860794667);
                                boolean z = (i4 & 14) == 4;
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (z || objRememberedValue3 == companion.getEmpty()) {
                                    objRememberedValue3 = new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function1
                                        @NotNull
                                        public final Boolean invoke(T t) {
                                            return Boolean.valueOf(!Intrinsics.areEqual(t, transition.getTargetState()));
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                CollectionsKt__MutableCollectionsKt.removeAll((List) snapshotStateList, (Function1) objRememberedValue3);
                                mutableScatterMap.clear();
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(860990897);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (mutableScatterMap.contains(transition.getTargetState())) {
                            composerStartRestartGroup.startReplaceGroup(861052122);
                            Iterator<T> it = snapshotStateList.iterator();
                            int i9 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i9 = -1;
                                    break;
                                } else if (Intrinsics.areEqual(function14.invoke(it.next()), function14.invoke(transition.getTargetState()))) {
                                    break;
                                } else {
                                    i9++;
                                }
                            }
                            if (i9 == -1) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i9, transition.getTargetState());
                            }
                            mutableScatterMap.clear();
                            int size2 = snapshotStateList.size();
                            for (int i10 = 0; i10 < size2; i10++) {
                                T t = snapshotStateList.get(i10);
                                mutableScatterMap.set(t, ComposableLambdaKt.rememberComposableLambda(-1426421288, true, new CrossfadeKt$Crossfade$5$1(transition, finiteAnimationSpecTween$default, t, function3), composerStartRestartGroup, 54));
                            }
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(861812273);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                        function2M1177w = AbstractC0622a.m1177w(companion2, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                        if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                        }
                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceGroup(-187482432);
                        size = snapshotStateList.size();
                        for (i7 = 0; i7 < size; i7++) {
                            T t2 = snapshotStateList.get(i7);
                            composerStartRestartGroup.startMovableGroup(-1081873445, function14.invoke(t2));
                            Function2 function2 = (Function2) mutableScatterMap.get(t2);
                            if (function2 == null) {
                                composerStartRestartGroup.startReplaceGroup(821713034);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1081871785);
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
                        finiteAnimationSpec3 = finiteAnimationSpecTween$default;
                        function13 = function14;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
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

                            public final void invoke(@Nullable Composer composer2, int i11) {
                                CrossfadeKt.Crossfade(transition, modifier3, finiteAnimationSpec3, function13, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 3072;
                function12 = function1;
                if ((i2 & 8) == 0) {
                }
                if ((i4 & 9363) != 9362) {
                    if (i8 != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    Object obj2 = objRememberedValue;
                    if (objRememberedValue == companion.getEmpty()) {
                    }
                    SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                    }
                    mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                    if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    }
                    if (mutableScatterMap.contains(transition.getTargetState())) {
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (!composerStartRestartGroup.getInserting()) {
                    }
                    composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                    function2M1177w = AbstractC0622a.m1177w(companion22, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap2);
                    if (!composerM18018constructorimpl.getInserting()) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion22.getSetModifier());
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceGroup(-187482432);
                        size = snapshotStateList2.size();
                        while (i7 < size) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        finiteAnimationSpec3 = finiteAnimationSpecTween$default;
                        function13 = function14;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            finiteAnimationSpec2 = finiteAnimationSpec;
            i6 = i2 & 4;
            if (i6 == 0) {
            }
            function12 = function1;
            if ((i2 & 8) == 0) {
            }
            if ((i4 & 9363) != 9362) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 2;
        if (i5 == 0) {
        }
        finiteAnimationSpec2 = finiteAnimationSpec;
        i6 = i2 & 4;
        if (i6 == 0) {
        }
        function12 = function1;
        if ((i2 & 8) == 0) {
        }
        if ((i4 & 9363) != 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
