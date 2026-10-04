package androidx.glance.oneui.template.layout.compose.combine;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceTheme;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.component.compose.ImageButtonKt;
import androidx.glance.oneui.template.component.compose.ImageKt;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m13886d2 = {"TinyLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TinyPrimaryButtonContent", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTinyLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TinyLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/TinyLayoutKt\n+ 2 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 8 Row.kt\nandroidx/compose/foundation/layout/RowKt\n*L\n1#1,202:1\n68#2,5:203\n73#2:234\n77#2:239\n68#2,5:242\n73#2:273\n77#2:278\n75#3:208\n76#3,11:210\n89#3:238\n75#3:247\n76#3,11:249\n89#3:277\n75#3:281\n76#3,11:283\n75#3:313\n76#3,11:315\n89#3:343\n89#3:348\n75#3:352\n76#3,11:354\n75#3:384\n76#3,11:386\n89#3:414\n75#3:421\n76#3,11:423\n89#3:451\n89#3:456\n76#4:209\n74#4:240\n76#4:248\n76#4:282\n76#4:314\n76#4:353\n76#4:385\n76#4:422\n460#5,13:221\n473#5,3:235\n460#5,13:260\n473#5,3:274\n460#5,13:294\n460#5,13:326\n473#5,3:340\n473#5,3:345\n460#5,13:365\n460#5,13:397\n473#5,3:411\n460#5,13:434\n473#5,3:448\n473#5,3:453\n88#6:241\n78#7,2:279\n80#7:307\n84#7:349\n78#7,2:350\n80#7:378\n84#7:457\n76#8,5:308\n81#8:339\n85#8:344\n76#8,5:379\n81#8:410\n85#8:415\n76#8,5:416\n81#8:447\n85#8:452\n*S KotlinDebug\n*F\n+ 1 TinyLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/TinyLayoutKt\n*L\n39#1:203,5\n39#1:234\n39#1:239\n85#1:242,5\n85#1:273\n85#1:278\n39#1:208\n39#1:210,11\n39#1:238\n85#1:247\n85#1:249,11\n85#1:277\n95#1:281\n95#1:283,11\n110#1:313\n110#1:315,11\n110#1:343\n95#1:348\n128#1:352\n128#1:354,11\n140#1:384\n140#1:386,11\n140#1:414\n153#1:421\n153#1:423,11\n153#1:451\n128#1:456\n39#1:209\n180#1:240\n85#1:248\n95#1:282\n110#1:314\n128#1:353\n140#1:385\n153#1:422\n39#1:221,13\n39#1:235,3\n85#1:260,13\n85#1:274,3\n95#1:294,13\n110#1:326,13\n110#1:340,3\n95#1:345,3\n128#1:365,13\n140#1:397,13\n140#1:411,3\n153#1:434,13\n153#1:448,3\n128#1:453,3\n180#1:241\n95#1:279,2\n95#1:307\n95#1:349\n128#1:350,2\n128#1:378\n128#1:457\n110#1:308,5\n110#1:339\n110#1:344\n140#1:379,5\n140#1:410\n140#1:415\n153#1:416,5\n153#1:447\n153#1:452\n*E\n"})
public final class TinyLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void TinyLayout(@NotNull final Modifier modifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1687446331);
        final Function2<? super Composer, ? super Integer, Unit> function22 = (i2 & 8) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687446331, i, -1, "androidx.glance.oneui.template.layout.compose.combine.TinyLayout (TinyLayout.kt:37)");
        }
        Alignment center = Alignment.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        if (function22 != null) {
            composerStartRestartGroup.startReplaceableGroup(2053194792);
            AbstractC1038a.m1198C(composerStartRestartGroup, (i >> 9) & 14, function22);
        } else if (primaryContentData != null) {
            composerStartRestartGroup.startReplaceableGroup(2053194863);
            TinyPrimaryButtonContent(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), primaryContentData, secondaryContentData, composerStartRestartGroup, 582, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(2053195067);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.TinyLayoutKt.TinyLayout.2
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
                    TinyLayoutKt.TinyLayout(modifier, primaryContentData, secondaryContentData, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TinyPrimaryButtonContent(final Modifier modifier, final PrimaryContentData primaryContentData, SecondaryContentData secondaryContentData, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1392877886);
        SecondaryContentData secondaryContentData2 = (i2 & 4) != 0 ? null : secondaryContentData;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1392877886, i, -1, "androidx.glance.oneui.template.layout.compose.combine.TinyPrimaryButtonContent (TinyLayout.kt:56)");
        }
        if (secondaryContentData2 != null) {
            composerStartRestartGroup.startReplaceableGroup(1558521460);
            TinyPrimaryButtonContent$TinyButtonContent(modifier, primaryContentData, secondaryContentData2, composerStartRestartGroup, (i & 14) | Units.MASTER_DPI);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (primaryContentData.getImage() != null) {
            composerStartRestartGroup.startReplaceableGroup(1558521656);
            float fM20968constructorimpl = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) * 0.75f) * 0.2f);
            if (primaryContentData.getImage() instanceof ImageButtonData) {
                composerStartRestartGroup.startReplaceableGroup(1558521772);
                Modifier modifierM15854padding3ABfNKs = PaddingKt.m15854padding3ABfNKs(modifier, fM20968constructorimpl);
                composerStartRestartGroup.startReplaceableGroup(1558521923);
                ImageButtonData imageButtonData = (ImageButtonData) primaryContentData.getImage();
                if (imageButtonData.getBackgroundColor() == null) {
                    imageButtonData.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                ImageButtonKt.ComposeImageButton(imageButtonData, modifierM15854padding3ABfNKs, composerStartRestartGroup, 8, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1558522142);
                ImageKt.ComposeImage(primaryContentData.getImage(), PaddingKt.m15854padding3ABfNKs(modifier, fM20968constructorimpl), null, true, composerStartRestartGroup, 3080, 4);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else if (primaryContentData.getProgressIndicator() != null) {
            composerStartRestartGroup.startReplaceableGroup(1558522386);
            ProgressIndicatorKt.ComposeCircularProgressIndicator(modifier, primaryContentData.getProgressIndicator(), 0, null, composerStartRestartGroup, (i & 14) | 64, 12);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1558522493);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final SecondaryContentData secondaryContentData3 = secondaryContentData2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.TinyLayoutKt.TinyPrimaryButtonContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    TinyLayoutKt.TinyPrimaryButtonContent(modifier, primaryContentData, secondaryContentData3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void TinyPrimaryButtonContent$TinyButtonContent(Modifier modifier, PrimaryContentData primaryContentData, SecondaryContentData secondaryContentData, Composer composer, int i) {
        List<TypedTextData> listEmptyList;
        ComposeUiNode.Companion companion;
        boolean z;
        Alignment.Vertical vertical;
        float f;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-40805336);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-40805336, i, -1, "androidx.glance.oneui.template.layout.compose.combine.TinyPrimaryButtonContent.TinyButtonContent (TinyLayout.kt:63)");
        }
        TypedTextListData textList = secondaryContentData.getTextList();
        if (textList == null || (listEmptyList = textList.getItems()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        int size = listEmptyList.size();
        float f4 = size != 0 ? size != 1 ? 0.25f : 0.42f : 0.75f;
        if (size == 0) {
            float f5 = f4;
            composer2.startReplaceableGroup(1211799732);
            if (primaryContentData.getImage() != null) {
                Alignment center = Alignment.INSTANCE.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
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
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ImageKt.ComposeImage(primaryContentData.getImage(), ComposeModifierUtilsKt.m21957paddingLwRUR8o(ComposeModifierUtilsKt.m21959sizeLwRUR8o(Modifier.INSTANCE, f5, 0, composer2, 6, 2), f5 / 5, 0, composer, 0, 2), null, true, composer, 3080, 4);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            Unit unit2 = Unit.INSTANCE;
        } else if (size == 1) {
            float f6 = f4;
            composer2.startReplaceableGroup(1211800154);
            TypedTextData typedTextData = listEmptyList.get(0);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion3.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical center2 = arrangement.getCenter();
            composer2.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, composer2, 54);
            Density density2 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ImageData image = primaryContentData.getImage();
            composer2.startReplaceableGroup(954368143);
            if (image == null) {
                companion = companion4;
            } else {
                companion = companion4;
                ImageKt.ComposeImage(primaryContentData.getImage(), ComposeModifierUtilsKt.m21959sizeLwRUR8o(Modifier.INSTANCE, f6, 0, composer2, 6, 2), null, true, composer, 3080, 4);
                composer2 = composer;
                Unit unit3 = Unit.INSTANCE;
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(954368397);
            if (TextType.m21684equalsimpl0(typedTextData.getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow())) {
                z = false;
            } else {
                z = false;
                SpacerKt.Spacer(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.06f, composer2, 54), composer2, 0);
            }
            composer2.endReplaceableGroup();
            Modifier.Companion companion5 = Modifier.INSTANCE;
            Modifier modifierM21956padding6PoWaU8 = ComposeModifierUtilsKt.m21956padding6PoWaU8(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, null), null, z, 3, null), 0.1f, 0.0f, 0.0f, 0.0f, composer, 438, 12);
            Arrangement.HorizontalOrVertical center3 = arrangement.getCenter();
            composer.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center3, companion3.getTop(), composer, 6);
            composer.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM21956padding6PoWaU8);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl3, measurePolicyRowMeasurePolicy, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl3, viewConfiguration3, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            CombineLayoutKt.m21825ComposeCombineText57gRyVA(SizeKt.wrapContentSize$default(companion5, null, false, 3, null), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4(), typedTextData, typedTextData.getTextType(), 0, null, 0.0f, 0.0f, composer, 6, 240);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Unit unit4 = Unit.INSTANCE;
        } else if (size != 2) {
            composer2.startReplaceableGroup(1211803252);
            composer2.endReplaceableGroup();
            Unit unit5 = Unit.INSTANCE;
        } else {
            composer2.startReplaceableGroup(1211801467);
            TypedTextData typedTextData2 = listEmptyList.get(0);
            TypedTextData typedTextData3 = listEmptyList.get(1);
            Alignment.Companion companion6 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally2 = companion6.getCenterHorizontally();
            Arrangement arrangement2 = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical center4 = arrangement2.getCenter();
            composer2.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center4, centerHorizontally2, composer2, 54);
            Density density4 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
            LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor4 = companion7.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifier);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion7, composerM18018constructorimpl4, measurePolicyColumnMeasurePolicy2, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion7, composerM18018constructorimpl4, viewConfiguration4, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ImageData image2 = primaryContentData.getImage();
            composer2.startReplaceableGroup(954369497);
            if (image2 == null) {
                vertical = null;
                f = 0.0f;
            } else {
                vertical = null;
                f = 0.0f;
                ImageKt.ComposeImage(primaryContentData.getImage(), ComposeModifierUtilsKt.m21959sizeLwRUR8o(Modifier.INSTANCE, f4, 0, composer2, 6, 2), null, true, composer, 3080, 4);
                Unit unit6 = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            Modifier.Companion companion8 = Modifier.INSTANCE;
            Modifier modifierM21956padding6PoWaU82 = ComposeModifierUtilsKt.m21956padding6PoWaU8(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion8, f, 1, vertical), vertical, false, 3, vertical), 0.08f, 0.0f, 0.0f, 0.0f, composer, 438, 12);
            Arrangement.HorizontalOrVertical center5 = arrangement2.getCenter();
            composer.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center5, companion6.getTop(), composer, 6);
            composer.startReplaceableGroup(-1323940314);
            Density density5 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection5 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor5 = companion7.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM21956padding6PoWaU82);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion7, composerM18018constructorimpl5, measurePolicyRowMeasurePolicy2, composerM18018constructorimpl5, density5));
            function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion7, composerM18018constructorimpl5, viewConfiguration5, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            AppWidgetSize.Companion companion9 = AppWidgetSize.INSTANCE;
            Alignment.Vertical vertical2 = vertical;
            androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt.m21861CombineText57gRyVA(null, companion9.m21571getTinyrx25Pp4(), typedTextData2, typedTextData2.getTextType(), 0, null, 0.0f, 0.0f, composer, 0, 241);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Modifier modifierM21956padding6PoWaU83 = ComposeModifierUtilsKt.m21956padding6PoWaU8(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion8, f, 1, vertical2), vertical2, false, 3, vertical2), TextType.m21684equalsimpl0(typedTextData3.getTextType(), TextType.INSTANCE.m21693getLabelgxbDmow()) ? 0.2f : 0.08f, 0.0f, 0.0f, 0.0f, composer, 390, 12);
            Arrangement.HorizontalOrVertical center6 = arrangement2.getCenter();
            composer.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(center6, companion6.getTop(), composer, 6);
            composer.startReplaceableGroup(-1323940314);
            Density density6 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection6 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor6 = companion7.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierM21956padding6PoWaU83);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion7, composerM18018constructorimpl6, measurePolicyRowMeasurePolicy3, composerM18018constructorimpl6, density6));
            function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion7, composerM18018constructorimpl6, viewConfiguration6, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            androidx.glance.oneui.template.layout.glance.combine.CombineLayoutKt.m21861CombineText57gRyVA(null, companion9.m21571getTinyrx25Pp4(), typedTextData3, typedTextData3.getTextType(), 0, null, 0.0f, 0.0f, composer, 0, 241);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Unit unit7 = Unit.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
