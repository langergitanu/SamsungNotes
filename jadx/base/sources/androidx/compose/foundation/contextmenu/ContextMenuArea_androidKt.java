package androidx.compose.foundation.contextmenu;

import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010\f\u001ac\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0011H\u0001¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"ContextMenu", "", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuArea", "enabled", "", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContextMenuArea.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextMenuArea.android.kt\nandroidx/compose/foundation/contextmenu/ContextMenuArea_androidKt\n+ 2 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n+ 6 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,79:1\n71#2:80\n68#2,6:81\n74#2:115\n78#2:119\n79#3,6:87\n86#3,4:102\n90#3,2:112\n94#3:118\n368#4,9:93\n377#4:114\n378#4,2:116\n4034#5,6:106\n1225#6,6:120\n*S KotlinDebug\n*F\n+ 1 ContextMenuArea.android.kt\nandroidx/compose/foundation/contextmenu/ContextMenuArea_androidKt\n*L\n47#1:80\n47#1:81,6\n47#1:115\n47#1:119\n47#1:87,6\n47#1:102,4\n47#1:112,2\n47#1:118\n47#1:93,9\n47#1:114\n47#1:116,2\n47#1:106,6\n68#1:120,6\n*E\n"})
public final class ContextMenuArea_androidKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @VisibleForTesting
    public static final void ContextMenu(@NotNull final ContextMenuState contextMenuState, @NotNull final Function0<Unit> function0, @Nullable Modifier modifier, @NotNull final Function1<? super ContextMenuScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final Modifier modifier2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(645832757);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(contextMenuState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            composer2 = composerStartRestartGroup;
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(645832757, i4, -1, "androidx.compose.foundation.contextmenu.ContextMenu (ContextMenuArea.android.kt:63)");
            }
            ContextMenuState.Status status = contextMenuState.getStatus();
            if (!(status instanceof ContextMenuState.Status.Open)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt.ContextMenu.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i6) {
                            ContextMenuArea_androidKt.ContextMenu(contextMenuState, function0, modifier2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            boolean zChanged = composerStartRestartGroup.changed(status);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ContextMenuPopupPositionProvider(IntOffsetKt.m21112roundk4lQ0M(((ContextMenuState.Status.Open) status).getOffset()), null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composer2 = composerStartRestartGroup;
            ContextMenuUi_androidKt.ContextMenuPopup((ContextMenuPopupPositionProvider) objRememberedValue, function0, modifier2, function1, composer2, i4 & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt.ContextMenu.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i6) {
                    ContextMenuArea_androidKt.ContextMenu(contextMenuState, function0, modifier2, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0161  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuArea(@NotNull final ContextMenuState contextMenuState, @NotNull final Function0<Unit> function0, @NotNull final Function1<? super ContextMenuScope, Unit> function1, @Nullable Modifier modifier, boolean z, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Function0<Unit> function02;
        Function1<? super ContextMenuScope, Unit> function12;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2 function2M1177w;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-84584070);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(contextMenuState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function12 = function1;
                    i4 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        modifier2 = modifier;
                        i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 != 0) {
                        if ((i & 24576) == 0) {
                            z2 = z;
                            i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                        }
                        if ((i2 & 32) != 0) {
                            i4 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
                        }
                        if ((74899 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                        } else {
                            if (i5 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-84584070, i4, -1, "androidx.compose.foundation.contextmenu.ContextMenuArea (ContextMenuArea.android.kt:44)");
                            }
                            Modifier modifierContextMenuGestures = !z2 ? ContextMenuGestures_androidKt.contextMenuGestures(modifier2, contextMenuState) : modifier2;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierContextMenuGestures);
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            if (composerStartRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.useNode();
                            } else {
                                composerStartRestartGroup.createNode(constructor);
                            }
                            composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                            function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                            if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                            }
                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 15) & 14));
                            ContextMenu(contextMenuState, function02, null, function12, composerStartRestartGroup, (i4 & 126) | ((i4 << 3) & 7168), 4);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        final boolean z3 = z2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt.ContextMenuArea.2
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
                                    ContextMenuArea_androidKt.ContextMenuArea(contextMenuState, function0, function1, modifier3, z3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 24576;
                    z2 = z;
                    if ((i2 & 32) != 0) {
                    }
                    if ((74899 & i4) == 74898) {
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (!z2) {
                        }
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierContextMenuGestures);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        if (composerStartRestartGroup.getApplier() == null) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                        function2M1177w = AbstractC0622a.m1177w(companion2, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap2);
                        if (!composerM18018constructorimpl.getInserting()) {
                            AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 15) & 14));
                            ContextMenu(contextMenuState, function02, null, function12, composerStartRestartGroup, (i4 & 126) | ((i4 << 3) & 7168), 4);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                    }
                    final boolean z32 = z2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                modifier2 = modifier;
                i6 = i2 & 16;
                if (i6 != 0) {
                }
                z2 = z;
                if ((i2 & 32) != 0) {
                }
                if ((74899 & i4) == 74898) {
                }
                final boolean z322 = z2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function12 = function1;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z2 = z;
            if ((i2 & 32) != 0) {
            }
            if ((74899 & i4) == 74898) {
            }
            final boolean z3222 = z2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function02 = function0;
        if ((i2 & 4) == 0) {
        }
        function12 = function1;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z2 = z;
        if ((i2 & 32) != 0) {
        }
        if ((74899 & i4) == 74898) {
        }
        final boolean z32222 = z2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
