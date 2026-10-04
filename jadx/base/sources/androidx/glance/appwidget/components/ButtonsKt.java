package androidx.glance.appwidget.components;

import android.os.Build;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.ButtonColors;
import androidx.glance.ButtonDefaults;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.action.LambdaActionKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.C2902R;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextKt;
import androidx.glance.text.TextStyle;
import androidx.glance.unit.ColorProvider;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001ac\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0012\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014\u001ac\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u001c\u001aQ\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001d\u001aQ\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010!\u001a[\u0010\"\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010%\u001aa\u0010&\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010'\u001aO\u0010&\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010(\u001aa\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0012\u001aO\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010*\u001a\u00020\f2\b\b\u0001\u0010+\u001a\u00020\u001bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0002¨\u0006,"}, m13886d2 = {"isAtLeastApi31", "", "()Z", "CircleIconButton", "", "imageProvider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/glance/GlanceModifier;", "enabled", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "contentColor", "key", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;ZLandroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Landroidx/glance/action/Action;", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZLandroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "FilledButton", "text", "icon", "colors", "Landroidx/glance/ButtonColors;", "maxLines", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;ZLandroidx/glance/ImageProvider;Landroidx/glance/ButtonColors;ILjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZLandroidx/glance/ImageProvider;Landroidx/glance/ButtonColors;ILandroidx/compose/runtime/Composer;II)V", "M3IconButton", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/appwidget/components/IconButtonShape;", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/components/IconButtonShape;Landroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZLandroidx/compose/runtime/Composer;I)V", "M3TextButton", "backgroundResource", "backgroundTint", "(Ljava/lang/String;Landroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZLandroidx/glance/ImageProvider;Landroidx/glance/unit/ColorProvider;ILandroidx/glance/unit/ColorProvider;ILandroidx/compose/runtime/Composer;II)V", "OutlineButton", "(Ljava/lang/String;Landroidx/glance/unit/ColorProvider;Lkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;ZLandroidx/glance/ImageProvider;ILjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/glance/unit/ColorProvider;Landroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZLandroidx/glance/ImageProvider;ILandroidx/compose/runtime/Composer;II)V", "SquareIconButton", "maybeRoundCorners", "radius", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nButtons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buttons.kt\nandroidx/glance/appwidget/components/ButtonsKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,470:1\n154#2:471\n154#2:472\n154#2:473\n*S KotlinDebug\n*F\n+ 1 Buttons.kt\nandroidx/glance/appwidget/components/ButtonsKt\n*L\n416#1:471\n417#1:472\n429#1:473\n*E\n"})
public final class ButtonsKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircleIconButton(@NotNull final ImageProvider imageProvider, @Nullable final String str, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable String str2, @Nullable Composer composer, final int i, final int i2) {
        final ColorProvider background;
        int i4;
        final ColorProvider onSurface;
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2055835675);
        GlanceModifier glanceModifier2 = (i2 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        final boolean z2 = (i2 & 16) != 0 ? true : z;
        if ((i2 & 32) != 0) {
            i4 = i & (-458753);
            background = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getBackground();
        } else {
            background = colorProvider;
            i4 = i;
        }
        if ((i2 & 64) != 0) {
            i4 &= -3670017;
            onSurface = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface();
        } else {
            onSurface = colorProvider2;
        }
        final String str3 = (i2 & 128) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2055835675, i4, -1, "androidx.glance.appwidget.components.CircleIconButton (Buttons.kt:298)");
        }
        CircleIconButton(imageProvider, str, LambdaActionKt.action(str3, onClick, composerStartRestartGroup, ((i4 >> 21) & 14) | ((i4 >> 3) & 112), 0), glanceModifier2, z2, background, onSurface, composerStartRestartGroup, (i4 & 112) | 2359816 | (i4 & 7168) | (57344 & i4), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.CircleIconButton.1
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
                    ButtonsKt.CircleIconButton(imageProvider, str, onClick, glanceModifier3, z2, background, onSurface, str3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledButton(@NotNull final String text, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ImageProvider imageProvider, @Nullable ButtonColors buttonColors, int i, @Nullable String str, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        boolean z2;
        int i7;
        ButtonColors buttonColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        String str2;
        int i13;
        boolean z3;
        ImageProvider imageProvider2;
        int i14;
        GlanceModifier glanceModifier3;
        int i15;
        String str3;
        Composer composer2;
        final int i16;
        final String str4;
        final ImageProvider imageProvider3;
        final boolean z4;
        final GlanceModifier glanceModifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2020625259);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i17 = i4 & 4;
        if (i17 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                glanceModifier2 = glanceModifier;
                i5 |= composerStartRestartGroup.changed(glanceModifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 8192;
                }
                if ((i2 & 458752) == 0) {
                    if ((i4 & 32) == 0) {
                        buttonColors2 = buttonColors;
                        int i18 = composerStartRestartGroup.changed(buttonColors2) ? 131072 : 65536;
                        i5 |= i18;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i5 |= i18;
                } else {
                    buttonColors2 = buttonColors;
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                    i5 |= 1572864;
                    i9 = 458752;
                    i10 = i;
                } else {
                    i9 = 458752;
                    i10 = i;
                    if ((i2 & 3670016) == 0) {
                        i5 |= composerStartRestartGroup.changed(i10) ? 1048576 : 524288;
                    }
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                    i13 = i5 | 12582912;
                    i12 = i17;
                    str2 = str;
                } else {
                    if ((i2 & 29360128) == 0) {
                        i12 = i17;
                        str2 = str;
                        i5 |= composerStartRestartGroup.changed(str2) ? 8388608 : 4194304;
                    } else {
                        i12 = i17;
                        str2 = str;
                    }
                    i13 = i5;
                }
                if (i7 == 16 && (i13 & 23967451) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    i16 = i10;
                    imageProvider3 = imageProvider;
                    str4 = str2;
                    glanceModifier4 = glanceModifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        GlanceModifier glanceModifier5 = i12 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                        if (i6 != 0) {
                            z2 = true;
                        }
                        ImageProvider imageProvider4 = i7 == 0 ? null : imageProvider;
                        if ((i4 & 32) != 0) {
                            i13 &= -458753;
                            buttonColors2 = ButtonDefaults.INSTANCE.buttonColors(null, null, composerStartRestartGroup, ButtonDefaults.$stable << 6, 3);
                        }
                        if (i8 != 0) {
                            i10 = Integer.MAX_VALUE;
                        }
                        z3 = z2;
                        imageProvider2 = imageProvider4;
                        i14 = i10;
                        glanceModifier3 = glanceModifier5;
                        if (i11 == 0) {
                            i15 = i13;
                            str3 = null;
                        } else {
                            i15 = i13;
                            str3 = str;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i4 & 32) != 0) {
                            i13 &= -458753;
                        }
                        imageProvider2 = imageProvider;
                        glanceModifier3 = glanceModifier2;
                        i14 = i10;
                        i15 = i13;
                        str3 = str2;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2020625259, i15, -1, "androidx.glance.appwidget.components.FilledButton (Buttons.kt:79)");
                    }
                    FilledButton(text, LambdaActionKt.action(str3, onClick, composerStartRestartGroup, ((i15 >> 21) & 14) | (i15 & 112), 0), glanceModifier3, z3, imageProvider2, buttonColors2, i14, composerStartRestartGroup, (i15 & 14) | 32832 | (i15 & 896) | (i15 & 7168) | (ButtonColors.$stable << 15) | (i15 & i9) | (i15 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    i16 = i14;
                    str4 = str3;
                    imageProvider3 = imageProvider2;
                    z4 = z3;
                    glanceModifier4 = glanceModifier3;
                }
                final ButtonColors buttonColors3 = buttonColors2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.FilledButton.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i19) {
                            ButtonsKt.FilledButton(text, onClick, glanceModifier4, z4, imageProvider3, buttonColors3, i16, str4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                        }
                    });
                    return;
                }
                return;
            }
            i5 |= 3072;
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            if ((i2 & 458752) == 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            if (i7 == 16) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i12 == 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if ((i4 & 32) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    z3 = z2;
                    imageProvider2 = imageProvider4;
                    i14 = i10;
                    glanceModifier3 = glanceModifier5;
                    if (i11 == 0) {
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    FilledButton(text, LambdaActionKt.action(str3, onClick, composerStartRestartGroup, ((i15 >> 21) & 14) | (i15 & 112), 0), glanceModifier3, z3, imageProvider2, buttonColors2, i14, composerStartRestartGroup, (i15 & 14) | 32832 | (i15 & 896) | (i15 & 7168) | (ButtonColors.$stable << 15) | (i15 & i9) | (i15 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = composerStartRestartGroup;
                    i16 = i14;
                    str4 = str3;
                    imageProvider3 = imageProvider2;
                    z4 = z3;
                    glanceModifier4 = glanceModifier3;
                }
            }
            final ButtonColors buttonColors32 = buttonColors2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 != 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        if ((i2 & 458752) == 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        if (i7 == 16) {
        }
        final ButtonColors buttonColors322 = buttonColors2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void M3IconButton(final ImageProvider imageProvider, final String str, final ColorProvider colorProvider, final ColorProvider colorProvider2, final IconButtonShape iconButtonShape, final Action action, final GlanceModifier glanceModifier, final boolean z, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(104489556);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(104489556, i, -1, "androidx.glance.appwidget.components.M3IconButton (Buttons.kt:375)");
        }
        BoxKt.Box(AppWidgetModifiersKt.enabled(ActionKt.clickable(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, iconButtonShape.m21337getDefaultSizeD9Ej5fM()).then(glanceModifier).then(colorProvider2 == null ? GlanceModifier.INSTANCE : BackgroundKt.m21252backgroundPLcKuY0$default(GlanceModifier.INSTANCE, ImageKt.ImageProvider(iconButtonShape.getShape()), 0, ColorFilter.INSTANCE.tint(colorProvider2), 2, null)), action, iconButtonShape.getRipple()), z).then(maybeRoundCorners(iconButtonShape.getCornerRadius())), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 841743538, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.M3IconButton.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(841743538, i2, -1, "androidx.glance.appwidget.components.M3IconButton.<anonymous> (Buttons.kt:394)");
                }
                ImageKt.m21259ImageGCr5PR4(imageProvider, str, SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(24)), 0, ColorFilter.INSTANCE.tint(colorProvider), composer2, (ColorFilter.$stable << 12) | 8, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.M3IconButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ButtonsKt.M3IconButton(imageProvider, str, colorProvider, colorProvider2, iconButtonShape, action, glanceModifier, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void M3TextButton(final String str, final Action action, final GlanceModifier glanceModifier, boolean z, final ImageProvider imageProvider, final ColorProvider colorProvider, @DrawableRes final int i, final ColorProvider colorProvider2, final int i2, Composer composer, int i4, final int i5) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1704543196);
        final boolean z2 = (i5 & 8) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            i6 = i4;
            ComposerKt.traceEventStart(1704543196, i6, -1, "androidx.glance.appwidget.components.M3TextButton (Buttons.kt:414)");
        } else {
            i6 = i4;
        }
        final float fM20968constructorimpl = C2256Dp.m20968constructorimpl(18);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(imageProvider != null ? 24 : 16);
        final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -127672093, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt$M3TextButton$Text$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer2, int i7) {
                if ((i7 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-127672093, i7, -1, "androidx.glance.appwidget.components.M3TextButton.<anonymous> (Buttons.kt:419)");
                }
                TextKt.Text(str, (GlanceModifier) null, new TextStyle(colorProvider, TextUnit.m21151boximpl(TextUnitKt.getSp(14)), FontWeight.m21989boximpl(FontWeight.INSTANCE.m21997getMediumWjrlUT0()), null, null, null, null, 0, false, null, null, 0, null, null, 0, 32760, null), i2, 0.0f, composer2, 0, 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        float f = 10;
        BoxKt.Box(ActionKt.clickable(AppWidgetModifiersKt.enabled(BackgroundKt.m21252backgroundPLcKuY0$default(PaddingKt.m21499paddingqDBjuR0(glanceModifier, C2256Dp.m20968constructorimpl(16), C2256Dp.m20968constructorimpl(f), fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f)), ImageKt.ImageProvider(i), 0, ColorFilter.INSTANCE.tint(colorProvider2), 2, null), z2), action, isAtLeastApi31() ? 0 : C2902R.drawable.glance_component_m3_button_ripple).then(maybeRoundCorners(C2902R.dimen.glance_component_button_corners)), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 180493370, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.M3TextButton.1
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

            @Composable
            public final void invoke(@Nullable Composer composer2, int i7) {
                if ((i7 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180493370, i7, -1, "androidx.glance.appwidget.components.M3TextButton.<anonymous> (Buttons.kt:442)");
                }
                if (imageProvider != null) {
                    composer2.startReplaceableGroup(-1408887603);
                    int iM21453getCenterVerticallymnfRV0w = Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w();
                    final ColorProvider colorProvider3 = colorProvider;
                    final float f4 = fM20968constructorimpl;
                    final ImageProvider imageProvider2 = imageProvider;
                    final Function2<Composer, Integer, Unit> function2 = composableLambda;
                    RowKt.m21502RowlMAjyxE(null, 0, iM21453getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer2, 279032795, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.M3TextButton.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i8) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(279032795, i8, -1, "androidx.glance.appwidget.components.M3TextButton.<anonymous>.<anonymous> (Buttons.kt:444)");
                            }
                            ColorFilter colorFilterTint = ColorFilter.INSTANCE.tint(colorProvider3);
                            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                            ImageKt.m21259ImageGCr5PR4(imageProvider2, null, SizeModifiersKt.m21506size3ABfNKs(companion, f4), 0, colorFilterTint, composer3, (ColorFilter.$stable << 12) | 56, 8);
                            SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(companion, C2256Dp.m20968constructorimpl(8)), composer3, 0, 0);
                            if (AbstractC1038a.m1196A(composer3, 6, function2)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 3);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1408887110);
                    BoxKt.Box(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, fM20968constructorimpl), null, ComposableSingletons$ButtonsKt.INSTANCE.m21335getLambda1$glance_appwidget_release(), composer2, 384, 2);
                    AbstractC1038a.m1198C(composer2, 6, composableLambda);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i7 = i6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.M3TextButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    ButtonsKt.M3TextButton(str, action, glanceModifier, z2, imageProvider, colorProvider, i, colorProvider2, i2, composer2, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), i5);
                }
            });
        }
    }

    @Composable
    public static final void OutlineButton(@NotNull final String text, @NotNull final ColorProvider contentColor, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ImageProvider imageProvider, int i, @Nullable String str, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1460647101);
        GlanceModifier glanceModifier2 = (i4 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        final boolean z2 = (i4 & 16) != 0 ? true : z;
        final ImageProvider imageProvider2 = (i4 & 32) != 0 ? null : imageProvider;
        final int i5 = (i4 & 64) != 0 ? Integer.MAX_VALUE : i;
        final String str2 = (i4 & 128) != 0 ? null : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1460647101, i2, -1, "androidx.glance.appwidget.components.OutlineButton (Buttons.kt:150)");
        }
        OutlineButton(text, contentColor, LambdaActionKt.action(str2, onClick, composerStartRestartGroup, ((i2 >> 21) & 14) | ((i2 >> 3) & 112), 0), glanceModifier2, z2, imageProvider2, i5, composerStartRestartGroup, (i2 & 14) | 262720 | (i2 & 7168) | (57344 & i2) | (3670016 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.OutlineButton.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    ButtonsKt.OutlineButton(text, contentColor, onClick, glanceModifier3, z2, imageProvider2, i5, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void SquareIconButton(@NotNull final ImageProvider imageProvider, @Nullable final String str, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable String str2, @Nullable Composer composer, final int i, final int i2) {
        final ColorProvider primary;
        int i4;
        final ColorProvider onPrimary;
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1937776952);
        GlanceModifier glanceModifier2 = (i2 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        final boolean z2 = (i2 & 16) != 0 ? true : z;
        if ((i2 & 32) != 0) {
            i4 = i & (-458753);
            primary = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getPrimary();
        } else {
            primary = colorProvider;
            i4 = i;
        }
        if ((i2 & 64) != 0) {
            i4 &= -3670017;
            onPrimary = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnPrimary();
        } else {
            onPrimary = colorProvider2;
        }
        final String str3 = (i2 & 128) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937776952, i4, -1, "androidx.glance.appwidget.components.SquareIconButton (Buttons.kt:226)");
        }
        SquareIconButton(imageProvider, str, LambdaActionKt.action(str3, onClick, composerStartRestartGroup, ((i4 >> 21) & 14) | ((i4 >> 3) & 112), 0), glanceModifier2, z2, primary, onPrimary, composerStartRestartGroup, (i4 & 112) | 2359816 | (i4 & 7168) | (57344 & i4), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.SquareIconButton.1
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
                    ButtonsKt.SquareIconButton(imageProvider, str, onClick, glanceModifier3, z2, primary, onPrimary, str3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isAtLeastApi31() {
        return Build.VERSION.SDK_INT >= 31;
    }

    private static final GlanceModifier maybeRoundCorners(@DimenRes int i) {
        return isAtLeastApi31() ? CornerRadiusKt.cornerRadius(GlanceModifier.INSTANCE, i) : GlanceModifier.INSTANCE;
    }

    @Composable
    public static final void OutlineButton(@NotNull final String text, @NotNull final ColorProvider contentColor, @NotNull final Action onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ImageProvider imageProvider, int i, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1295123710);
        GlanceModifier glanceModifier2 = (i4 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        boolean z2 = (i4 & 16) != 0 ? true : z;
        final ImageProvider imageProvider2 = (i4 & 32) != 0 ? null : imageProvider;
        final int i5 = (i4 & 64) != 0 ? Integer.MAX_VALUE : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1295123710, i2, -1, "androidx.glance.appwidget.components.OutlineButton (Buttons.kt:182)");
        }
        int i6 = i2 >> 3;
        M3TextButton(text, onClick, glanceModifier2, z2, imageProvider2, contentColor, C2902R.drawable.glance_component_btn_outline, contentColor, i5, composerStartRestartGroup, (i2 & 14) | 17072192 | (i6 & 896) | (i6 & 7168) | ((i2 << 6) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.OutlineButton.2
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
                    ButtonsKt.OutlineButton(text, contentColor, onClick, glanceModifier3, z3, imageProvider2, i5, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircleIconButton(@NotNull final ImageProvider imageProvider, @Nullable final String str, @NotNull final Action onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable Composer composer, final int i, final int i2) {
        ColorProvider background;
        int i4;
        int i5;
        ColorProvider onSurface;
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(583948960);
        GlanceModifier glanceModifier2 = (i2 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        boolean z2 = (i2 & 16) != 0 ? true : z;
        if ((i2 & 32) != 0) {
            i4 = i & (-458753);
            background = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getBackground();
        } else {
            background = colorProvider;
            i4 = i;
        }
        if ((i2 & 64) != 0) {
            int i6 = i4 & (-3670017);
            onSurface = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface();
            i5 = i6;
        } else {
            i5 = i4;
            onSurface = colorProvider2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(583948960, i5, -1, "androidx.glance.appwidget.components.CircleIconButton (Buttons.kt:332)");
        }
        int i7 = (i5 & 112) | 291336;
        int i8 = i5 << 9;
        M3IconButton(imageProvider, str, onSurface, background, IconButtonShape.Circle, onClick, glanceModifier2, z2, composerStartRestartGroup, i7 | (3670016 & i8) | (i8 & 29360128));
        final boolean z3 = z2;
        final ColorProvider colorProvider3 = onSurface;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final ColorProvider colorProvider4 = background;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.CircleIconButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i9) {
                    ButtonsKt.CircleIconButton(imageProvider, str, onClick, glanceModifier3, z3, colorProvider4, colorProvider3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void SquareIconButton(@NotNull final ImageProvider imageProvider, @Nullable final String str, @NotNull final Action onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable Composer composer, final int i, final int i2) {
        ColorProvider primary;
        int i4;
        int i5;
        ColorProvider onPrimary;
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1007880115);
        GlanceModifier glanceModifier2 = (i2 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        boolean z2 = (i2 & 16) != 0 ? true : z;
        if ((i2 & 32) != 0) {
            i4 = i & (-458753);
            primary = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getPrimary();
        } else {
            primary = colorProvider;
            i4 = i;
        }
        if ((i2 & 64) != 0) {
            int i6 = i4 & (-3670017);
            onPrimary = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnPrimary();
            i5 = i6;
        } else {
            i5 = i4;
            onPrimary = colorProvider2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1007880115, i5, -1, "androidx.glance.appwidget.components.SquareIconButton (Buttons.kt:258)");
        }
        int i7 = (i5 & 112) | 291336;
        int i8 = i5 << 9;
        M3IconButton(imageProvider, str, onPrimary, primary, IconButtonShape.Square, onClick, glanceModifier2, z2, composerStartRestartGroup, i7 | (3670016 & i8) | (i8 & 29360128));
        final boolean z3 = z2;
        final ColorProvider colorProvider3 = onPrimary;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final ColorProvider colorProvider4 = primary;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.SquareIconButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i9) {
                    ButtonsKt.SquareIconButton(imageProvider, str, onClick, glanceModifier3, z3, colorProvider4, colorProvider3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void FilledButton(@NotNull final String text, @NotNull final Action onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable ImageProvider imageProvider, @Nullable ButtonColors buttonColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        ButtonColors buttonColors2;
        int i5;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-326511592);
        GlanceModifier glanceModifier2 = (i4 & 4) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        boolean z2 = (i4 & 8) != 0 ? true : z;
        ImageProvider imageProvider2 = (i4 & 16) != 0 ? null : imageProvider;
        if ((i4 & 32) != 0) {
            i5 = i2 & (-458753);
            buttonColors2 = ButtonDefaults.INSTANCE.buttonColors(null, null, composerStartRestartGroup, ButtonDefaults.$stable << 6, 3);
        } else {
            buttonColors2 = buttonColors;
            i5 = i2;
        }
        int i6 = (i4 & 64) != 0 ? Integer.MAX_VALUE : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-326511592, i5, -1, "androidx.glance.appwidget.components.FilledButton (Buttons.kt:111)");
        }
        final boolean z3 = z2;
        final GlanceModifier glanceModifier3 = glanceModifier2;
        final int i7 = i6;
        final ImageProvider imageProvider3 = imageProvider2;
        M3TextButton(text, onClick, glanceModifier3, z3, imageProvider3, buttonColors2.getContentColor(), C2902R.drawable.glance_component_btn_filled, buttonColors2.getBackgroundColor(), i7, composerStartRestartGroup, (i5 & 14) | 17072192 | (i5 & 896) | (i5 & 7168) | ((i5 << 6) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ButtonColors buttonColors3 = buttonColors2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ButtonsKt.FilledButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    ButtonsKt.FilledButton(text, onClick, glanceModifier3, z3, imageProvider3, buttonColors3, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
