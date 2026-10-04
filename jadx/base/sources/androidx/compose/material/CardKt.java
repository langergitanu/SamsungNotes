package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, m13886d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Card-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CardKt {
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Card function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Card(onClick, modifier, enabled, shape, backgroundColor, contentColor, border, elevation, interactionSource, content)", imports = {}))
    @Composable
    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: Card-9VG74zQ, reason: not valid java name */
    public static final void m16638Card9VG74zQ(@NotNull Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z, @Nullable String str, @Nullable Role role, @NotNull Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, int i, int i2, int i4) {
        MutableInteractionSource mutableInteractionSource2;
        String str2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(1353606722);
        Modifier modifier2 = (i4 & 2) != 0 ? Modifier.INSTANCE : modifier;
        Shape medium = (i4 & 4) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM16680getSurface0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j;
        long jM16694contentColorForek8zF_U = (i4 & 16) != 0 ? ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composer, (i >> 9) & 14) : j2;
        BorderStroke borderStroke2 = (i4 & 32) != 0 ? null : borderStroke;
        float fM20968constructorimpl = (i4 & 64) != 0 ? C2256Dp.m20968constructorimpl(1) : f;
        if ((i4 & 128) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        Indication indication2 = (i4 & 256) != 0 ? (Indication) composer.consume(IndicationKt.getLocalIndication()) : indication;
        MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        boolean z2 = (i4 & 512) != 0 ? true : z;
        String str3 = (i4 & 1024) != 0 ? null : str;
        Role role2 = (i4 & 2048) != 0 ? null : role;
        if (ComposerKt.isTraceInProgress()) {
            str2 = str3;
            ComposerKt.traceEventStart(1353606722, i, i2, "androidx.compose.material.Card (Card.kt:179)");
        } else {
            str2 = str3;
        }
        SurfaceKt.m16871Surface9VG74zQ(onClick, modifier2, medium, jM16680getSurface0d7_KjU, jM16694contentColorForek8zF_U, borderStroke2, fM20968constructorimpl, mutableInteractionSource3, indication2, z2, str2, role2, content, composer, i & 2147483646, i2 & Event.CAPS_LOCK, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Card-F-jzlyU, reason: not valid java name */
    public static final void m16639CardFjzlyU(@Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @NotNull Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(1956755640);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Shape medium = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM16680getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j;
        long jM16694contentColorForek8zF_U = (i2 & 8) != 0 ? ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composer, (i >> 6) & 14) : j2;
        BorderStroke borderStroke2 = (i2 & 16) != 0 ? null : borderStroke;
        float fM20968constructorimpl = (i2 & 32) != 0 ? C2256Dp.m20968constructorimpl(1) : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1956755640, i, -1, "androidx.compose.material.Card (Card.kt:58)");
        }
        SurfaceKt.m16872SurfaceFjzlyU(modifier, medium, jM16680getSurface0d7_KjU, jM16694contentColorForek8zF_U, borderStroke2, fM20968constructorimpl, content, composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Card-LPr_se0, reason: not valid java name */
    public static final void m16640CardLPr_se0(@NotNull Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(778538979);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        Shape medium = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM16680getSurface0d7_KjU = (i2 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j;
        long jM16694contentColorForek8zF_U = (i2 & 32) != 0 ? ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composer, (i >> 12) & 14) : j2;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        float fM20968constructorimpl = (i2 & 128) != 0 ? C2256Dp.m20968constructorimpl(1) : f;
        if ((i2 & 256) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            mutableInteractionSource3 = mutableInteractionSource2;
            ComposerKt.traceEventStart(778538979, i, -1, "androidx.compose.material.Card (Card.kt:107)");
        } else {
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier2, z2, medium, jM16680getSurface0d7_KjU, jM16694contentColorForek8zF_U, borderStroke2, fM20968constructorimpl, mutableInteractionSource3, content, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
