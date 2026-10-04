package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.PainterModifierKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.painter.BitmapPainter;
import androidx.compose.p109ui.graphics.painter.Painter;
import androidx.compose.p109ui.graphics.vector.ImageVector;
import androidx.compose.p109ui.graphics.vector.VectorPainter;
import androidx.compose.p109ui.graphics.vector.VectorPainterKt;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, m13886d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class IconKt {

    @NotNull
    private static final Modifier DefaultIconSizeModifier = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, IconButtonTokens.INSTANCE.m17711getIconSizeD9Ej5fM());

    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fa  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17198Iconww6aTOc(@NotNull final ImageVector imageVector, @Nullable final String str, @Nullable Modifier modifier, long j, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        String str2;
        final Modifier modifier2;
        final long j2;
        Modifier modifier3;
        long jM18535unboximpl;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(imageVector, "imageVector");
        Composer composerStartRestartGroup = composer.startRestartGroup(-126890956);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    j2 = j;
                    int i6 = composerStartRestartGroup.changed(j2) ? 2048 : 1024;
                    i4 |= i6;
                } else {
                    j2 = j;
                }
                i4 |= i6;
            } else {
                j2 = j;
            }
            if ((i4 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 8) == 0) {
                        i4 &= -7169;
                        modifier3 = modifier4;
                        jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-126890956, i4, -1, "androidx.compose.material3.Icon (Icon.kt:55)");
                        }
                        m17197Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i4 & 14), str2, modifier3, jM18535unboximpl, composerStartRestartGroup, VectorPainter.$stable | (i4 & 112) | (i4 & 896) | (i4 & 7168), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j2 = jM18535unboximpl;
                    } else {
                        modifier3 = modifier4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i4 &= -7169;
                    }
                    modifier3 = modifier2;
                }
                jM18535unboximpl = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                m17197Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i4 & 14), str2, modifier3, jM18535unboximpl, composerStartRestartGroup, VectorPainter.$stable | (i4 & 112) | (i4 & 896) | (i4 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                j2 = jM18535unboximpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$1
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
                    IconKt.m17198Iconww6aTOc(imageVector, str, modifier2, j2, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i & 7168) != 0) {
        }
        if ((i4 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        return modifier.then((Size.m18349equalsimpl0(painter.getIntrinsicSize(), Size.INSTANCE.m18361getUnspecifiedNHjbRc()) || m17199isInfiniteuvyYCjk(painter.getIntrinsicSize())) ? DefaultIconSizeModifier : Modifier.INSTANCE);
    }

    /* JADX INFO: renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m17199isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Size.m18353getWidthimpl(j)) && Float.isInfinite(Size.m18350getHeightimpl(j));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m17196Iconww6aTOc(@NotNull final ImageBitmap bitmap, @Nullable final String str, @Nullable Modifier modifier, long j, @Nullable Composer composer, int i, final int i2) {
        int i4;
        long jM18535unboximpl;
        int i5;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1092052280);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i2 & 8) != 0) {
            i4 = i;
            jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
            i5 = i4 & (-7169);
        } else {
            i4 = i;
            jM18535unboximpl = j;
            i5 = i4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1092052280, i5, -1, "androidx.compose.material3.Icon (Icon.kt:85)");
        }
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(bitmap);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            BitmapPainter bitmapPainter = new BitmapPainter(bitmap, 0L, 0L, 6, null);
            composerStartRestartGroup.updateRememberedValue(bitmapPainter);
            objRememberedValue = bitmapPainter;
        }
        composerStartRestartGroup.endReplaceableGroup();
        final Modifier modifier3 = modifier2;
        final long j2 = jM18535unboximpl;
        m17197Iconww6aTOc((BitmapPainter) objRememberedValue, str, modifier3, j2, composerStartRestartGroup, (i5 & 112) | 8 | (i5 & 896) | (i5 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final int i6 = i4;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$2
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
                IconKt.m17196Iconww6aTOc(bitmap, str, modifier3, j2, composer2, i6 | 1, i2);
            }
        });
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m17197Iconww6aTOc(@NotNull final Painter painter, @Nullable final String str, @Nullable Modifier modifier, long j, @Nullable Composer composer, int i, final int i2) {
        int i4;
        long jM18535unboximpl;
        int i5;
        Modifier modifierSemantics$default;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2142239481);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i2 & 8) != 0) {
            i4 = i;
            i5 = i4 & (-7169);
            jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
        } else {
            i4 = i;
            jM18535unboximpl = j;
            i5 = i4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2142239481, i5, -1, "androidx.compose.material3.Icon (Icon.kt:116)");
        }
        ColorFilter colorFilterM18566tintxETnrds$default = Color.m18526equalsimpl0(jM18535unboximpl, Color.INSTANCE.m18561getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m18566tintxETnrds$default(ColorFilter.INSTANCE, jM18535unboximpl, 0, 2, null);
        composerStartRestartGroup.startReplaceableGroup(69355216);
        if (str != null) {
            Modifier.Companion companion = Modifier.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(str);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$semantics$1$1
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
                        SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20269getImageo7Vup1c());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
        } else {
            modifierSemantics$default = Modifier.INSTANCE;
        }
        composerStartRestartGroup.endReplaceableGroup();
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier2), painter), painter, false, null, ContentScale.INSTANCE.getFit(), 0.0f, colorFilterM18566tintxETnrds$default, 22, null).then(modifierSemantics$default), composerStartRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final int i6 = i4;
        final long j2 = jM18535unboximpl;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$3
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
                IconKt.m17197Iconww6aTOc(painter, str, modifier3, j2, composer2, i6 | 1, i2);
            }
        });
    }
}
