package androidx.compose.material3;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bð\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 Jµ\u0002\u0010|\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016R4\u0010\u0010\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R4\u0010\u0019\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b*\u0010'\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R4\u0010\u001b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R4\u0010\u0018\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R4\u0010\u0017\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R4\u0010\u0011\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b9\u0010'\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R4\u0010\u001a\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R4\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b?\u0010'\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bB\u0010'\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bE\u0010'\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R4\u0010\t\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bH\u0010'\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bK\u0010'\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%R4\u0010\u0013\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bN\u0010'\u001a\u0004\bL\u0010#\"\u0004\bM\u0010%R4\u0010\u0015\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bQ\u0010'\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R4\u0010\r\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bT\u0010'\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R4\u0010\u000f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bW\u0010'\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R4\u0010\u001d\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bZ\u0010'\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R4\u0010\u001e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b]\u0010'\u001a\u0004\b[\u0010#\"\u0004\b\\\u0010%R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b`\u0010'\u001a\u0004\b^\u0010#\"\u0004\b_\u0010%R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bc\u0010'\u001a\u0004\ba\u0010#\"\u0004\bb\u0010%R4\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bf\u0010'\u001a\u0004\bd\u0010#\"\u0004\be\u0010%R4\u0010\b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bi\u0010'\u001a\u0004\bg\u0010#\"\u0004\bh\u0010%R4\u0010\n\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bl\u0010'\u001a\u0004\bj\u0010#\"\u0004\bk\u0010%R4\u0010\u0012\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bo\u0010'\u001a\u0004\bm\u0010#\"\u0004\bn\u0010%R4\u0010\u0016\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\br\u0010'\u001a\u0004\bp\u0010#\"\u0004\bq\u0010%R4\u0010\u0014\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bu\u0010'\u001a\u0004\bs\u0010#\"\u0004\bt\u0010%R4\u0010\f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bx\u0010'\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b{\u0010'\u001a\u0004\by\u0010#\"\u0004\bz\u0010%\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0081\u0001"}, m13886d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material3_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material3_release", "error$delegate", "getErrorContainer-0d7_KjU", "setErrorContainer-8_81llA$material3_release", "errorContainer$delegate", "getInverseOnSurface-0d7_KjU", "setInverseOnSurface-8_81llA$material3_release", "inverseOnSurface$delegate", "getInversePrimary-0d7_KjU", "setInversePrimary-8_81llA$material3_release", "inversePrimary$delegate", "getInverseSurface-0d7_KjU", "setInverseSurface-8_81llA$material3_release", "inverseSurface$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material3_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material3_release", "onError$delegate", "getOnErrorContainer-0d7_KjU", "setOnErrorContainer-8_81llA$material3_release", "onErrorContainer$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material3_release", "onPrimary$delegate", "getOnPrimaryContainer-0d7_KjU", "setOnPrimaryContainer-8_81llA$material3_release", "onPrimaryContainer$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material3_release", "onSecondary$delegate", "getOnSecondaryContainer-0d7_KjU", "setOnSecondaryContainer-8_81llA$material3_release", "onSecondaryContainer$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material3_release", "onSurface$delegate", "getOnSurfaceVariant-0d7_KjU", "setOnSurfaceVariant-8_81llA$material3_release", "onSurfaceVariant$delegate", "getOnTertiary-0d7_KjU", "setOnTertiary-8_81llA$material3_release", "onTertiary$delegate", "getOnTertiaryContainer-0d7_KjU", "setOnTertiaryContainer-8_81llA$material3_release", "onTertiaryContainer$delegate", "getOutline-0d7_KjU", "setOutline-8_81llA$material3_release", "outline$delegate", "getOutlineVariant-0d7_KjU", "setOutlineVariant-8_81llA$material3_release", "outlineVariant$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material3_release", "primary$delegate", "getPrimaryContainer-0d7_KjU", "setPrimaryContainer-8_81llA$material3_release", "primaryContainer$delegate", "getScrim-0d7_KjU", "setScrim-8_81llA$material3_release", "scrim$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material3_release", "secondary$delegate", "getSecondaryContainer-0d7_KjU", "setSecondaryContainer-8_81llA$material3_release", "secondaryContainer$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material3_release", "surface$delegate", "getSurfaceTint-0d7_KjU", "setSurfaceTint-8_81llA$material3_release", "surfaceTint$delegate", "getSurfaceVariant-0d7_KjU", "setSurfaceVariant-8_81llA$material3_release", "surfaceVariant$delegate", "getTertiary-0d7_KjU", "setTertiary-8_81llA$material3_release", "tertiary$delegate", "getTertiaryContainer-0d7_KjU", "setTertiaryContainer-8_81llA$material3_release", "tertiaryContainer$delegate", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ColorScheme {

    /* JADX INFO: renamed from: background$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState background;

    /* JADX INFO: renamed from: error$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState error;

    /* JADX INFO: renamed from: errorContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState errorContainer;

    /* JADX INFO: renamed from: inverseOnSurface$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState inverseOnSurface;

    /* JADX INFO: renamed from: inversePrimary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState inversePrimary;

    /* JADX INFO: renamed from: inverseSurface$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState inverseSurface;

    /* JADX INFO: renamed from: onBackground$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onBackground;

    /* JADX INFO: renamed from: onError$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onError;

    /* JADX INFO: renamed from: onErrorContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onErrorContainer;

    /* JADX INFO: renamed from: onPrimary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onPrimary;

    /* JADX INFO: renamed from: onPrimaryContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onPrimaryContainer;

    /* JADX INFO: renamed from: onSecondary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onSecondary;

    /* JADX INFO: renamed from: onSecondaryContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onSecondaryContainer;

    /* JADX INFO: renamed from: onSurface$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onSurface;

    /* JADX INFO: renamed from: onSurfaceVariant$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onSurfaceVariant;

    /* JADX INFO: renamed from: onTertiary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onTertiary;

    /* JADX INFO: renamed from: onTertiaryContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onTertiaryContainer;

    /* JADX INFO: renamed from: outline$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState outline;

    /* JADX INFO: renamed from: outlineVariant$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState outlineVariant;

    /* JADX INFO: renamed from: primary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState primary;

    /* JADX INFO: renamed from: primaryContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState primaryContainer;

    /* JADX INFO: renamed from: scrim$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState scrim;

    /* JADX INFO: renamed from: secondary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState secondary;

    /* JADX INFO: renamed from: secondaryContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState secondaryContainer;

    /* JADX INFO: renamed from: surface$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState surface;

    /* JADX INFO: renamed from: surfaceTint$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState surfaceTint;

    /* JADX INFO: renamed from: surfaceVariant$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState surfaceVariant;

    /* JADX INFO: renamed from: tertiary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState tertiary;

    /* JADX INFO: renamed from: tertiaryContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState tertiaryContainer;

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-G1PFc-w, reason: not valid java name */
    public final ColorScheme m17037copyG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m17038getBackground0d7_KjU() {
        return ((Color) this.background.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m17039getError0d7_KjU() {
        return ((Color) this.error.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m17040getErrorContainer0d7_KjU() {
        return ((Color) this.errorContainer.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name */
    public final long m17041getInverseOnSurface0d7_KjU() {
        return ((Color) this.inverseOnSurface.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m17042getInversePrimary0d7_KjU() {
        return ((Color) this.inversePrimary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getInverseSurface-0d7_KjU, reason: not valid java name */
    public final long m17043getInverseSurface0d7_KjU() {
        return ((Color) this.inverseSurface.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m17044getOnBackground0d7_KjU() {
        return ((Color) this.onBackground.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m17045getOnError0d7_KjU() {
        return ((Color) this.onError.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m17046getOnErrorContainer0d7_KjU() {
        return ((Color) this.onErrorContainer.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m17047getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m17048getOnPrimaryContainer0d7_KjU() {
        return ((Color) this.onPrimaryContainer.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m17049getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m17050getOnSecondaryContainer0d7_KjU() {
        return ((Color) this.onSecondaryContainer.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m17051getOnSurface0d7_KjU() {
        return ((Color) this.onSurface.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m17052getOnSurfaceVariant0d7_KjU() {
        return ((Color) this.onSurfaceVariant.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m17053getOnTertiary0d7_KjU() {
        return ((Color) this.onTertiary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m17054getOnTertiaryContainer0d7_KjU() {
        return ((Color) this.onTertiaryContainer.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOutline-0d7_KjU, reason: not valid java name */
    public final long m17055getOutline0d7_KjU() {
        return ((Color) this.outline.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name */
    public final long m17056getOutlineVariant0d7_KjU() {
        return ((Color) this.outlineVariant.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m17057getPrimary0d7_KjU() {
        return ((Color) this.primary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m17058getPrimaryContainer0d7_KjU() {
        return ((Color) this.primaryContainer.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getScrim-0d7_KjU, reason: not valid java name */
    public final long m17059getScrim0d7_KjU() {
        return ((Color) this.scrim.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m17060getSecondary0d7_KjU() {
        return ((Color) this.secondary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m17061getSecondaryContainer0d7_KjU() {
        return ((Color) this.secondaryContainer.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m17062getSurface0d7_KjU() {
        return ((Color) this.surface.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name */
    public final long m17063getSurfaceTint0d7_KjU() {
        return ((Color) this.surfaceTint.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m17064getSurfaceVariant0d7_KjU() {
        return ((Color) this.surfaceVariant.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m17065getTertiary0d7_KjU() {
        return ((Color) this.tertiary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m17066getTertiaryContainer0d7_KjU() {
        return ((Color) this.tertiaryContainer.getValue()).m18535unboximpl();
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m17067setBackground8_81llA$material3_release(long j) {
        this.background.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setError-8_81llA$material3_release, reason: not valid java name */
    public final void m17068setError8_81llA$material3_release(long j) {
        this.error.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17069setErrorContainer8_81llA$material3_release(long j) {
        this.errorContainer.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setInverseOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m17070setInverseOnSurface8_81llA$material3_release(long j) {
        this.inverseOnSurface.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setInversePrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m17071setInversePrimary8_81llA$material3_release(long j) {
        this.inversePrimary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setInverseSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m17072setInverseSurface8_81llA$material3_release(long j) {
        this.inverseSurface.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m17073setOnBackground8_81llA$material3_release(long j) {
        this.onBackground.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material3_release, reason: not valid java name */
    public final void m17074setOnError8_81llA$material3_release(long j) {
        this.onError.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17075setOnErrorContainer8_81llA$material3_release(long j) {
        this.onErrorContainer.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m17076setOnPrimary8_81llA$material3_release(long j) {
        this.onPrimary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17077setOnPrimaryContainer8_81llA$material3_release(long j) {
        this.onPrimaryContainer.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m17078setOnSecondary8_81llA$material3_release(long j) {
        this.onSecondary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17079setOnSecondaryContainer8_81llA$material3_release(long j) {
        this.onSecondaryContainer.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m17080setOnSurface8_81llA$material3_release(long j) {
        this.onSurface.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m17081setOnSurfaceVariant8_81llA$material3_release(long j) {
        this.onSurfaceVariant.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m17082setOnTertiary8_81llA$material3_release(long j) {
        this.onTertiary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17083setOnTertiaryContainer8_81llA$material3_release(long j) {
        this.onTertiaryContainer.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOutline-8_81llA$material3_release, reason: not valid java name */
    public final void m17084setOutline8_81llA$material3_release(long j) {
        this.outline.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOutlineVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m17085setOutlineVariant8_81llA$material3_release(long j) {
        this.outlineVariant.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m17086setPrimary8_81llA$material3_release(long j) {
        this.primary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17087setPrimaryContainer8_81llA$material3_release(long j) {
        this.primaryContainer.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setScrim-8_81llA$material3_release, reason: not valid java name */
    public final void m17088setScrim8_81llA$material3_release(long j) {
        this.scrim.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m17089setSecondary8_81llA$material3_release(long j) {
        this.secondary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17090setSecondaryContainer8_81llA$material3_release(long j) {
        this.secondaryContainer.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m17091setSurface8_81llA$material3_release(long j) {
        this.surface.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSurfaceTint-8_81llA$material3_release, reason: not valid java name */
    public final void m17092setSurfaceTint8_81llA$material3_release(long j) {
        this.surfaceTint.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m17093setSurfaceVariant8_81llA$material3_release(long j) {
        this.surfaceVariant.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m17094setTertiary8_81llA$material3_release(long j) {
        this.tertiary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m17095setTertiaryContainer8_81llA$material3_release(long j) {
        this.tertiaryContainer.setValue(Color.m18515boximpl(j));
    }

    @NotNull
    public String toString() {
        return "ColorScheme(primary=" + ((Object) Color.m18533toStringimpl(m17057getPrimary0d7_KjU())) + "onPrimary=" + ((Object) Color.m18533toStringimpl(m17047getOnPrimary0d7_KjU())) + "primaryContainer=" + ((Object) Color.m18533toStringimpl(m17058getPrimaryContainer0d7_KjU())) + "onPrimaryContainer=" + ((Object) Color.m18533toStringimpl(m17048getOnPrimaryContainer0d7_KjU())) + "inversePrimary=" + ((Object) Color.m18533toStringimpl(m17042getInversePrimary0d7_KjU())) + "secondary=" + ((Object) Color.m18533toStringimpl(m17060getSecondary0d7_KjU())) + "onSecondary=" + ((Object) Color.m18533toStringimpl(m17049getOnSecondary0d7_KjU())) + "secondaryContainer=" + ((Object) Color.m18533toStringimpl(m17061getSecondaryContainer0d7_KjU())) + "onSecondaryContainer=" + ((Object) Color.m18533toStringimpl(m17050getOnSecondaryContainer0d7_KjU())) + "tertiary=" + ((Object) Color.m18533toStringimpl(m17065getTertiary0d7_KjU())) + "onTertiary=" + ((Object) Color.m18533toStringimpl(m17053getOnTertiary0d7_KjU())) + "tertiaryContainer=" + ((Object) Color.m18533toStringimpl(m17066getTertiaryContainer0d7_KjU())) + "onTertiaryContainer=" + ((Object) Color.m18533toStringimpl(m17054getOnTertiaryContainer0d7_KjU())) + "background=" + ((Object) Color.m18533toStringimpl(m17038getBackground0d7_KjU())) + "onBackground=" + ((Object) Color.m18533toStringimpl(m17044getOnBackground0d7_KjU())) + "surface=" + ((Object) Color.m18533toStringimpl(m17062getSurface0d7_KjU())) + "onSurface=" + ((Object) Color.m18533toStringimpl(m17051getOnSurface0d7_KjU())) + "surfaceVariant=" + ((Object) Color.m18533toStringimpl(m17064getSurfaceVariant0d7_KjU())) + "onSurfaceVariant=" + ((Object) Color.m18533toStringimpl(m17052getOnSurfaceVariant0d7_KjU())) + "surfaceTint=" + ((Object) Color.m18533toStringimpl(m17063getSurfaceTint0d7_KjU())) + "inverseSurface=" + ((Object) Color.m18533toStringimpl(m17043getInverseSurface0d7_KjU())) + "inverseOnSurface=" + ((Object) Color.m18533toStringimpl(m17041getInverseOnSurface0d7_KjU())) + "error=" + ((Object) Color.m18533toStringimpl(m17039getError0d7_KjU())) + "onError=" + ((Object) Color.m18533toStringimpl(m17045getOnError0d7_KjU())) + "errorContainer=" + ((Object) Color.m18533toStringimpl(m17040getErrorContainer0d7_KjU())) + "onErrorContainer=" + ((Object) Color.m18533toStringimpl(m17046getOnErrorContainer0d7_KjU())) + "outline=" + ((Object) Color.m18533toStringimpl(m17055getOutline0d7_KjU())) + "outlineVariant=" + ((Object) Color.m18533toStringimpl(m17056getOutlineVariant0d7_KjU())) + "scrim=" + ((Object) Color.m18533toStringimpl(m17059getScrim0d7_KjU())) + PropertyUtils.MAPPED_DELIM2;
    }

    private ColorScheme(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimaryContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.inversePrimary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondaryContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiaryContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiaryContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j14), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j15), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j16), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j17), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j18), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceVariant = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j19), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurfaceVariant = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j20), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceTint = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j21), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseSurface = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j22), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseOnSurface = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j23), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j24), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j25), SnapshotStateKt.structuralEqualityPolicy());
        this.errorContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j26), SnapshotStateKt.structuralEqualityPolicy());
        this.onErrorContainer = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j27), SnapshotStateKt.structuralEqualityPolicy());
        this.outline = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j28), SnapshotStateKt.structuralEqualityPolicy());
        this.outlineVariant = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j29), SnapshotStateKt.structuralEqualityPolicy());
        this.scrim = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j30), SnapshotStateKt.structuralEqualityPolicy());
    }
}
