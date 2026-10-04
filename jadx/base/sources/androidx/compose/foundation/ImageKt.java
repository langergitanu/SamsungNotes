package androidx.compose.foundation;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.draw.PainterModifierKt;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.FilterQuality;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.painter.BitmapPainter;
import androidx.compose.p109ui.graphics.painter.BitmapPainterKt;
import androidx.compose.p109ui.graphics.painter.Painter;
import androidx.compose.p109ui.graphics.vector.ImageVector;
import androidx.compose.p109ui.graphics.vector.VectorPainter;
import androidx.compose.p109ui.graphics.vector.VectorPainterKt;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Image.kt\nandroidx/compose/foundation/ImageKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,268:1\n1225#2,6:269\n1225#2,6:275\n125#3,6:281\n132#3,5:296\n137#3:307\n139#3:310\n289#4,9:287\n298#4,2:308\n4034#5,6:301\n*S KotlinDebug\n*F\n+ 1 Image.kt\nandroidx/compose/foundation/ImageKt\n*L\n154#1:269,6\n246#1:275,6\n256#1:281,6\n256#1:296,5\n256#1:307\n256#1:310\n256#1:287,9\n256#1:308,2\n256#1:301,6\n*E\n"})
public final class ImageKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    @Composable
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        if ((i2 & 4) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Modifier modifier2 = modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f4 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i, -1, "androidx.compose.foundation.Image (Image.kt:95)");
        }
        m15465Image5hnEew(imageBitmap, str, modifier2, center, fit, f4, colorFilter2, FilterQuality.INSTANCE.m18625getLowfv9h1I(), composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Image-5h-nEew, reason: not valid java name */
    public static final void m15465Image5hnEew(@NotNull ImageBitmap imageBitmap, @Nullable String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f, @Nullable ColorFilter colorFilter, int i, @Nullable Composer composer, int i2, int i4) {
        Modifier modifier2 = (i4 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i4 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f4 = (i4 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 64) != 0 ? null : colorFilter;
        int iM19079getDefaultFilterQualityfv9h1I = (i4 & 128) != 0 ? DrawScope.INSTANCE.m19079getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, i2, -1, "androidx.compose.foundation.Image (Image.kt:152)");
        }
        boolean zChanged = composer.changed(imageBitmap);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BitmapPainterKt.m19199BitmapPainterQZhYCtY$default(imageBitmap, 0L, 0L, iM19079getDefaultFilterQualityfv9h1I, 6, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        Image((BitmapPainter) objRememberedValue, str, modifier2, center, fit, f4, colorFilter2, composer, i2 & 4194288, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Image(@NotNull ImageVector imageVector, @Nullable String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f, @Nullable ColorFilter colorFilter, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 4) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Modifier modifier2 = modifier;
        if ((i2 & 8) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        Alignment alignment2 = alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f4 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i, -1, "androidx.compose.foundation.Image (Image.kt:197)");
        }
        Image(VectorPainterKt.rememberVectorPainter(imageVector, composer, i & 14), str, modifier2, alignment2, fit, f4, colorFilter2, composer, VectorPainter.$stable | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (3670016 & i), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Image(@NotNull final Painter painter, @Nullable final String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f, @Nullable ColorFilter colorFilter, @Nullable Composer composer, final int i, final int i2) {
        Painter painter2;
        int i4;
        Modifier modifier2;
        int i5;
        Alignment center;
        int i6;
        ContentScale fit;
        int i7;
        float f4;
        int i8;
        ColorFilter colorFilter2;
        Modifier modifierSemantics$default;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Alignment alignment2;
        final ContentScale contentScale2;
        final ColorFilter colorFilter3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1142754848);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            painter2 = painter;
        } else {
            painter2 = painter;
            if ((i & 6) == 0) {
                i4 = (composerStartRestartGroup.changedInstance(painter2) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    center = alignment;
                    i4 |= composerStartRestartGroup.changed(center) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        fit = contentScale;
                        i4 |= composerStartRestartGroup.changed(fit) ? 16384 : 8192;
                    }
                    i7 = i2 & 32;
                    if (i7 != 0) {
                        if ((196608 & i) == 0) {
                            f4 = f;
                            i4 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
                        }
                        i8 = i2 & 64;
                        if (i8 != 0) {
                            i4 |= 1572864;
                            colorFilter2 = colorFilter;
                        } else {
                            colorFilter2 = colorFilter;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changed(colorFilter2) ? 1048576 : 524288;
                            }
                        }
                        if ((i4 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            colorFilter3 = colorFilter2;
                            alignment2 = center;
                            contentScale2 = fit;
                        } else {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i6 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i7 != 0) {
                                f4 = 1.0f;
                            }
                            ColorFilter colorFilter4 = i8 == 0 ? null : colorFilter2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1142754848, i4, -1, "androidx.compose.foundation.Image (Image.kt:243)");
                            }
                            if (str == null) {
                                composerStartRestartGroup.startReplaceGroup(1040258775);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                boolean z = (i4 & 112) == 32;
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$semantics$1$1
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
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                                            SemanticsPropertiesKt.m20285setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m20269getImageo7Vup1c());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1040398089);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierSemantics$default = Modifier.INSTANCE;
                            }
                            ContentScale contentScale3 = fit;
                            Alignment alignment3 = center;
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifierSemantics$default)), painter2, false, alignment3, contentScale3, f4, colorFilter4, 2, null);
                            C08101 c08101 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt.Image.1
                                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                                @NotNull
                                /* JADX INFO: renamed from: measure-3p2s80s */
                                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                                    return MeasureScope.layout$default(measureScope, Constraints.m20923getMinWidthimpl(j), Constraints.m20922getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt.Image.1.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }
                                    }, 4, null);
                                }
                            };
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
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
                            Updater.m18025setimpl(composerM18018constructorimpl, c08101, companion2.getSetMeasurePolicy());
                            Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            alignment2 = alignment3;
                            contentScale2 = contentScale3;
                            colorFilter3 = colorFilter4;
                        }
                        final Modifier modifier3 = modifier2;
                        final float f5 = f4;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.ImageKt.Image.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer2, int i10) {
                                    ImageKt.Image(painter, str, modifier3, alignment2, contentScale2, f5, colorFilter3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 196608;
                    f4 = f;
                    i8 = i2 & 64;
                    if (i8 != 0) {
                    }
                    if ((i4 & 599187) == 599186) {
                        if (i9 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (str == null) {
                        }
                        ContentScale contentScale32 = fit;
                        Alignment alignment32 = center;
                        Modifier modifierPaint$default2 = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifierSemantics$default)), painter2, false, alignment32, contentScale32, f4, colorFilter4, 2, null);
                        C08101 c081012 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt.Image.1
                            @Override // androidx.compose.p109ui.layout.MeasurePolicy
                            @NotNull
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                                return MeasureScope.layout$default(measureScope, Constraints.m20923getMinWidthimpl(j), Constraints.m20922getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt.Image.1.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }
                                }, 4, null);
                            }
                        };
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default2);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                        if (composerStartRestartGroup.getApplier() == null) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (!composerStartRestartGroup.getInserting()) {
                        }
                        composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Updater.m18025setimpl(composerM18018constructorimpl, c081012, companion22.getSetMeasurePolicy());
                        Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion22.getSetModifier());
                        setCompositeKeyHash = companion22.getSetCompositeKeyHash();
                        if (!composerM18018constructorimpl.getInserting()) {
                            AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            alignment2 = alignment32;
                            contentScale2 = contentScale32;
                            colorFilter3 = colorFilter4;
                        }
                    }
                    final Modifier modifier32 = modifier2;
                    final float f52 = f4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                fit = contentScale;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                f4 = f;
                i8 = i2 & 64;
                if (i8 != 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                final Modifier modifier322 = modifier2;
                final float f522 = f4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            center = alignment;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            fit = contentScale;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            f4 = f;
            i8 = i2 & 64;
            if (i8 != 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            final Modifier modifier3222 = modifier2;
            final float f5222 = f4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        center = alignment;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        fit = contentScale;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        f4 = f;
        i8 = i2 & 64;
        if (i8 != 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        final Modifier modifier32222 = modifier2;
        final float f52222 = f4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
