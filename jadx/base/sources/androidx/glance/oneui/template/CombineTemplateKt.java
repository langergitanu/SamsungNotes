package androidx.glance.oneui.template;

import android.os.Build;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.layout.Alignment;
import androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt;
import androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineTemplateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ac\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\u0005\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, m13886d2 = {"CombineTemplate", "", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "tertiaryContent", "tertiaryContentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "CombineTemplate-vBhK2Fw", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;ILandroidx/compose/runtime/Composer;II)V", "data", "Landroidx/glance/oneui/template/CombineData;", "CombineTemplate-hlbQeY0", "(Landroidx/glance/oneui/template/CombineData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;ILandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCombineTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombineTemplate.kt\nandroidx/glance/oneui/template/CombineTemplateKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,184:1\n74#2:185\n74#2:186\n*S KotlinDebug\n*F\n+ 1 CombineTemplate.kt\nandroidx/glance/oneui/template/CombineTemplateKt\n*L\n19#1:185\n62#1:186\n*E\n"})
public final class CombineTemplateKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: CombineTemplate-hlbQeY0, reason: not valid java name */
    public static final void m21658CombineTemplatehlbQeY0(@NotNull final CombineData data, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, int i, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, int i2, @Nullable Composer composer, int i4, final int i5) {
        int i6;
        int iM21429getBottommnfRV0w;
        int i7;
        int i8;
        int iM21432getEndPGIyAqw;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i9;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(259863948);
        Function2<? super Composer, ? super Integer, Unit> function25 = (i5 & 2) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = (i5 & 4) != 0 ? null : function22;
        if ((i5 & 8) != 0) {
            iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
            i6 = i4;
            i7 = i6 & (-7169);
        } else {
            i6 = i4;
            iM21429getBottommnfRV0w = i;
            i7 = i6;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = (i5 & 16) == 0 ? function23 : null;
        if ((i5 & 32) != 0) {
            i8 = i7 & (-458753);
            iM21432getEndPGIyAqw = Alignment.INSTANCE.m21432getEndPGIyAqw();
        } else {
            i8 = i7;
            iM21432getEndPGIyAqw = i2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(259863948, i8, -1, "androidx.glance.oneui.template.CombineTemplate (CombineTemplate.kt:17)");
        }
        boolean zAreEqual = Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance());
        boolean z = Build.VERSION.SDK_INT < 36;
        if (zAreEqual) {
            composerStartRestartGroup.startReplaceableGroup(-1142582058);
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(-1142582022);
                Function2<? super Composer, ? super Integer, Unit> function28 = function25;
                int i10 = iM21429getBottommnfRV0w;
                Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                Function2<? super Composer, ? super Integer, Unit> function210 = function27;
                LegacyCombineTemplateKt.m21871Legacy70PreviewCombineTemplatehlbQeY0(data, function28, function29, i10, function210, iM21432getEndPGIyAqw, composerStartRestartGroup, (i8 & 458752) | (i8 & 112) | 8 | (i8 & 896) | (i8 & 7168) | (i8 & 57344), 0);
                function25 = function28;
                iM21429getBottommnfRV0w = i10;
                function26 = function29;
                i9 = iM21432getEndPGIyAqw;
                function24 = function210;
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                int i11 = iM21432getEndPGIyAqw;
                function24 = function27;
                i9 = i11;
                composerStartRestartGroup.startReplaceableGroup(-1142581765);
                int i12 = i8 << 6;
                CombineLayoutKt.m21862GlanceCombineLayoutVekbxm4(data, iM21429getBottommnfRV0w, i9, function25, function26, function24, composerStartRestartGroup, ((i8 >> 6) & 112) | 8 | ((i8 >> 9) & 896) | (i12 & 7168) | (i12 & 57344) | ((i8 << 3) & 458752), 0);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            int i13 = iM21432getEndPGIyAqw;
            function24 = function27;
            i9 = i13;
            composerStartRestartGroup.startReplaceableGroup(-1142581389);
            int i14 = i8 << 6;
            androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt.m21823ComposeCombineLayoutVekbxm4(data, iM21429getBottommnfRV0w, i9, function25, function26, function24, composerStartRestartGroup, ((i8 >> 6) & 112) | 8 | ((i8 >> 9) & 896) | (i14 & 7168) | (i14 & 57344) | ((i8 << 3) & 458752), 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i15 = i9;
            final Function2<? super Composer, ? super Integer, Unit> function211 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
            final int i16 = i6;
            final int i17 = iM21429getBottommnfRV0w;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.CombineTemplateKt$CombineTemplate$1
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

                public final void invoke(@Nullable Composer composer2, int i18) {
                    CombineTemplateKt.m21658CombineTemplatehlbQeY0(data, function211, function212, i17, function24, i15, composer2, RecomposeScopeImplKt.updateChangedFlags(i16 | 1), i5);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: CombineTemplate-vBhK2Fw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21659CombineTemplatevBhK2Fw(@NotNull final Function2<? super Composer, ? super Integer, Unit> primaryContent, @NotNull final Function2<? super Composer, ? super Integer, Unit> secondaryContent, int i, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, int i2, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        int iM21429getBottommnfRV0w;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i8;
        int iM21432getEndPGIyAqw;
        int i9;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final int i10;
        Composer composer2;
        final int i11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(primaryContent, "primaryContent");
        Intrinsics.checkNotNullParameter(secondaryContent, "secondaryContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1262454897);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(primaryContent) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i4 & 112) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(secondaryContent) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            if ((i5 & 4) == 0) {
                iM21429getBottommnfRV0w = i;
                int i12 = composerStartRestartGroup.changed(iM21429getBottommnfRV0w) ? 256 : 128;
                i6 |= i12;
            } else {
                iM21429getBottommnfRV0w = i;
            }
            i6 |= i12;
        } else {
            iM21429getBottommnfRV0w = i;
        }
        int i13 = i5 & 8;
        if (i13 == 0) {
            if ((i4 & 7168) == 0) {
                function22 = function2;
                i6 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
            }
            if ((i4 & 57344) != 0) {
                if ((i5 & 16) == 0) {
                    i7 = i2;
                    int i14 = composerStartRestartGroup.changed(i7) ? 16384 : 8192;
                    i6 |= i14;
                } else {
                    i7 = i2;
                }
                i6 |= i14;
            } else {
                i7 = i2;
            }
            if ((46811 & i6) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i4 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i5 & 4) != 0) {
                        iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
                        i6 &= -897;
                    }
                    function23 = i13 == 0 ? null : function22;
                    if ((i5 & 16) == 0) {
                        i8 = i6 & (-57345);
                        iM21432getEndPGIyAqw = Alignment.INSTANCE.m21432getEndPGIyAqw();
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1262454897, i8, -1, "androidx.glance.oneui.template.CombineTemplate (CombineTemplate.kt:60)");
                    }
                    if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                        composerStartRestartGroup.startReplaceableGroup(-1142580682);
                        int i15 = i8 << 6;
                        i9 = iM21429getBottommnfRV0w;
                        function24 = function23;
                        CombineLayoutKt.m21863GlanceCombineLayoutwXoZbBE(i9, iM21432getEndPGIyAqw, primaryContent, secondaryContent, function24, composerStartRestartGroup, ((i8 >> 6) & 14) | ((i8 >> 9) & 112) | (i15 & 896) | (i15 & 7168) | ((i8 << 3) & 57344), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        i9 = iM21429getBottommnfRV0w;
                        function24 = function23;
                        composerStartRestartGroup.startReplaceableGroup(-1142580474);
                        int i16 = i8 << 6;
                        androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt.m21824ComposeCombineLayoutwXoZbBE(i9, iM21432getEndPGIyAqw, primaryContent, secondaryContent, function24, composerStartRestartGroup, ((i8 >> 6) & 14) | ((i8 >> 9) & 112) | (i16 & 896) | (i16 & 7168) | ((i8 << 3) & 57344), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i10 = i9;
                    composer2 = composerStartRestartGroup;
                    i11 = iM21432getEndPGIyAqw;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i5 & 4) != 0) {
                        i6 &= -897;
                    }
                    if ((i5 & 16) != 0) {
                        i6 &= -57345;
                    }
                    function23 = function22;
                }
                i8 = i6;
                iM21432getEndPGIyAqw = i7;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                i10 = i9;
                composer2 = composerStartRestartGroup;
                i11 = iM21432getEndPGIyAqw;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i10 = iM21429getBottommnfRV0w;
                composer2 = composerStartRestartGroup;
                function24 = function22;
                i11 = i7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.CombineTemplateKt$CombineTemplate$2
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

                    public final void invoke(@Nullable Composer composer3, int i17) {
                        CombineTemplateKt.m21659CombineTemplatevBhK2Fw(primaryContent, secondaryContent, i10, function24, i11, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
                return;
            }
            return;
        }
        i6 |= 3072;
        function22 = function2;
        if ((i4 & 57344) != 0) {
        }
        if ((46811 & i6) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
                if ((i5 & 4) != 0) {
                }
                if (i13 == 0) {
                }
                if ((i5 & 16) == 0) {
                    i8 = i6;
                    iM21432getEndPGIyAqw = i7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                i10 = i9;
                composer2 = composerStartRestartGroup;
                i11 = iM21432getEndPGIyAqw;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
