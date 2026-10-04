package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, m13886d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0319 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0108  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable ButtonColors buttonColors, @Nullable ButtonElevation buttonElevation, @Nullable BorderStroke borderStroke, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        PaddingValues contentPadding;
        int i8;
        int i9;
        MutableInteractionSource mutableInteractionSource2;
        int i10;
        Composer composer2;
        int i11;
        int i12;
        ButtonColors buttonColorsM17006buttonColorsro_MJ88;
        ButtonElevation buttonElevationM17007buttonElevationR_JCAzs;
        PaddingValues paddingValues2;
        ButtonColors buttonColors3;
        boolean z3;
        Shape shape3;
        BorderStroke borderStroke3;
        int i13;
        ButtonElevation buttonElevation2;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer3;
        final Shape shape4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final PaddingValues paddingValues3;
        final ButtonColors buttonColors4;
        final ButtonElevation buttonElevation3;
        final boolean z4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(650121315);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i15 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i4 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i15;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        int i16 = composerStartRestartGroup.changed(buttonColors2) ? 16384 : 8192;
                        i4 |= i16;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i4 |= i16;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((458752 & i) == 0) {
                    i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(buttonElevation)) ? 131072 : 65536;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        contentPadding = paddingValues;
                    } else {
                        contentPadding = paddingValues;
                        if ((i & 29360128) == 0) {
                            i4 |= composerStartRestartGroup.changed(contentPadding) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i & 234881024) == 0) {
                            i9 = i8;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) == 0) {
                            if ((i & 1879048192) == 0) {
                                i10 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                            }
                            if ((1533916891 & i4) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i14 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i4 &= -7169;
                                        shape2 = ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    }
                                    if ((i2 & 16) == 0) {
                                        composer2 = composerStartRestartGroup;
                                        i11 = i7;
                                        i12 = i9;
                                        buttonColorsM17006buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m17006buttonColorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                        i4 &= -57345;
                                    } else {
                                        composer2 = composerStartRestartGroup;
                                        i11 = i7;
                                        i12 = i9;
                                        buttonColorsM17006buttonColorsro_MJ88 = buttonColors2;
                                    }
                                    if ((i2 & 32) == 0) {
                                        Composer composer4 = composer2;
                                        buttonElevationM17007buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m17007buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer4, 196608, 31);
                                        composerStartRestartGroup = composer4;
                                        i4 &= -458753;
                                    } else {
                                        composerStartRestartGroup = composer2;
                                        buttonElevationM17007buttonElevationR_JCAzs = buttonElevation;
                                    }
                                    BorderStroke borderStroke5 = i6 == 0 ? null : borderStroke;
                                    if (i11 != 0) {
                                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    }
                                    if (i12 == 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        ButtonElevation buttonElevation4 = buttonElevationM17007buttonElevationR_JCAzs;
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                        buttonColors3 = buttonColorsM17006buttonColorsro_MJ88;
                                        i13 = i4;
                                        buttonElevation2 = buttonElevation4;
                                        paddingValues2 = contentPadding;
                                        z3 = z2;
                                        shape3 = shape2;
                                        borderStroke3 = borderStroke5;
                                    } else {
                                        paddingValues2 = contentPadding;
                                        buttonColors3 = buttonColorsM17006buttonColorsro_MJ88;
                                        z3 = z2;
                                        shape3 = shape2;
                                        borderStroke3 = borderStroke5;
                                        i13 = i4;
                                        buttonElevation2 = buttonElevationM17007buttonElevationR_JCAzs;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i4 &= -458753;
                                    }
                                    paddingValues2 = contentPadding;
                                    i13 = i4;
                                    z3 = z2;
                                    shape3 = shape2;
                                    buttonColors3 = buttonColors2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    borderStroke3 = borderStroke2;
                                    buttonElevation2 = buttonElevation;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(650121315, i13, -1, "androidx.compose.material3.Button (Button.kt:116)");
                                }
                                int i17 = (i13 >> 6) & 14;
                                int i18 = i13 >> 9;
                                int i19 = (i18 & 112) | i17;
                                long jM18535unboximpl = buttonColors3.containerColor$material3_release(z3, composerStartRestartGroup, i19).getValue().m18535unboximpl();
                                final long jM18535unboximpl2 = buttonColors3.contentColor$material3_release(z3, composerStartRestartGroup, i19).getValue().m18535unboximpl();
                                composerStartRestartGroup.startReplaceableGroup(823570087);
                                State<C2256Dp> stateShadowElevation$material3_release = buttonElevation2 != null ? null : buttonElevation2.shadowElevation$material3_release(z3, mutableInteractionSource3, composerStartRestartGroup, (i18 & 896) | ((i13 >> 21) & 112) | i17);
                                composerStartRestartGroup.endReplaceableGroup();
                                float fM20982unboximpl = stateShadowElevation$material3_release == null ? stateShadowElevation$material3_release.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0);
                                composerStartRestartGroup.startReplaceableGroup(823570182);
                                State<C2256Dp> state = buttonElevation2 != null ? buttonElevation2.tonalElevation$material3_release(z3, mutableInteractionSource3, composerStartRestartGroup, i17 | ((i13 >> 21) & 112) | (i18 & 896)) : null;
                                composerStartRestartGroup.endReplaceableGroup();
                                float fM20982unboximpl2 = state == null ? state.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0);
                                final PaddingValues paddingValues4 = paddingValues2;
                                final int i20 = i13;
                                Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer5, int i21) {
                                        if ((i21 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(956488494, i21, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:143)");
                                        }
                                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM18535unboximpl2))};
                                        final PaddingValues paddingValues5 = paddingValues4;
                                        final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                        final int i22 = i20;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer5, 1582292974, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer6, int i23) {
                                                if ((i23 & 11) == 2 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1582292974, i23, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:144)");
                                                }
                                                TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer6, 6).getLabelLarge();
                                                final PaddingValues paddingValues6 = paddingValues5;
                                                final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                                final int i24 = i22;
                                                TextKt.ProvideTextStyle(labelLarge, ComposableLambdaKt.composableLambda(composer6, -2136309793, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                        invoke(composer7, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer7, int i25) {
                                                        if ((i25 & 11) == 2 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2136309793, i25, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:145)");
                                                        }
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m15883defaultMinSizeVpY3zN4(companion, buttonDefaults.m17015getMinWidthD9Ej5fM(), buttonDefaults.m17014getMinHeightD9Ej5fM()), paddingValues6);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                        int i26 = ((i24 >> 18) & 7168) | 432;
                                                        composer7.startReplaceableGroup(693286680);
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer7, 54);
                                                        Density density = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (composer7.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer7.startReusableNode();
                                                        if (composer7.getInserting()) {
                                                            composer7.createNode(constructor);
                                                        } else {
                                                            composer7.useNode();
                                                        }
                                                        composer7.disableReusing();
                                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer7);
                                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer7, composer7), composer7, 2058660585);
                                                        composer7.startReplaceableGroup(-678309503);
                                                        function33.invoke(RowScopeInstance.INSTANCE, composer7, Integer.valueOf(((i26 >> 6) & 112) | 6));
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endNode();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer6, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                };
                                ButtonColors buttonColors5 = buttonColors3;
                                float f = fM20982unboximpl;
                                Modifier modifier4 = modifier2;
                                ButtonElevation buttonElevation5 = buttonElevation2;
                                SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier4, z3, shape3, jM18535unboximpl, jM18535unboximpl2, fM20982unboximpl2, f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 956488494, true, function2), composerStartRestartGroup, (i20 & 8190) | ((i20 << 6) & 234881024) | ((i20 << 3) & 1879048192), 6, 0);
                                composer3 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                paddingValues3 = paddingValues4;
                                buttonColors4 = buttonColors5;
                                buttonElevation3 = buttonElevation5;
                                z4 = z3;
                                modifier3 = modifier4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                boolean z5 = z2;
                                paddingValues3 = contentPadding;
                                z4 = z5;
                                modifier3 = modifier2;
                                shape4 = shape2;
                                buttonColors4 = buttonColors2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                composer3 = composerStartRestartGroup;
                                borderStroke4 = borderStroke2;
                                buttonElevation3 = buttonElevation;
                            }
                            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer5, int i21) {
                                    ButtonKt.Button(onClick, modifier3, z4, shape4, buttonColors4, buttonElevation3, borderStroke4, paddingValues3, mutableInteractionSource4, content, composer5, i | 1, i2);
                                }
                            });
                            return;
                        }
                        i10 = DriveFile.MODE_READ_WRITE;
                        i4 |= i10;
                        if ((1533916891 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if ((i2 & 8) != 0) {
                                }
                                if ((i2 & 16) == 0) {
                                }
                                if ((i2 & 32) == 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 == 0) {
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i172 = (i13 >> 6) & 14;
                                int i182 = i13 >> 9;
                                int i192 = (i182 & 112) | i172;
                                long jM18535unboximpl3 = buttonColors3.containerColor$material3_release(z3, composerStartRestartGroup, i192).getValue().m18535unboximpl();
                                final long jM18535unboximpl22 = buttonColors3.contentColor$material3_release(z3, composerStartRestartGroup, i192).getValue().m18535unboximpl();
                                composerStartRestartGroup.startReplaceableGroup(823570087);
                                if (buttonElevation2 != null) {
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                if (stateShadowElevation$material3_release == null) {
                                }
                                composerStartRestartGroup.startReplaceableGroup(823570182);
                                if (buttonElevation2 != null) {
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                if (state == null) {
                                }
                                final PaddingValues paddingValues42 = paddingValues2;
                                final int i202 = i13;
                                Function2<Composer, Integer, Unit> function22 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer5, int i21) {
                                        if ((i21 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(956488494, i21, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:143)");
                                        }
                                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM18535unboximpl22))};
                                        final PaddingValues paddingValues5 = paddingValues42;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                        final int i22 = i202;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer5, 1582292974, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer6, int i23) {
                                                if ((i23 & 11) == 2 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1582292974, i23, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:144)");
                                                }
                                                TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer6, 6).getLabelLarge();
                                                final PaddingValues paddingValues6 = paddingValues5;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                                final int i24 = i22;
                                                TextKt.ProvideTextStyle(labelLarge, ComposableLambdaKt.composableLambda(composer6, -2136309793, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                        invoke(composer7, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer7, int i25) {
                                                        if ((i25 & 11) == 2 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2136309793, i25, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:145)");
                                                        }
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m15883defaultMinSizeVpY3zN4(companion, buttonDefaults.m17015getMinWidthD9Ej5fM(), buttonDefaults.m17014getMinHeightD9Ej5fM()), paddingValues6);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                        int i26 = ((i24 >> 18) & 7168) | 432;
                                                        composer7.startReplaceableGroup(693286680);
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer7, 54);
                                                        Density density = (Density) AbstractC1038a.m1211l(composer7, -1323940314);
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (composer7.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer7.startReusableNode();
                                                        if (composer7.getInserting()) {
                                                            composer7.createNode(constructor);
                                                        } else {
                                                            composer7.useNode();
                                                        }
                                                        composer7.disableReusing();
                                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer7);
                                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer7, composer7), composer7, 2058660585);
                                                        composer7.startReplaceableGroup(-678309503);
                                                        function33.invoke(RowScopeInstance.INSTANCE, composer7, Integer.valueOf(((i26 >> 6) & 112) | 6));
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endNode();
                                                        composer7.endReplaceableGroup();
                                                        composer7.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer6, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                };
                                ButtonColors buttonColors52 = buttonColors3;
                                float f4 = fM20982unboximpl;
                                Modifier modifier42 = modifier2;
                                ButtonElevation buttonElevation52 = buttonElevation2;
                                SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier42, z3, shape3, jM18535unboximpl3, jM18535unboximpl22, fM20982unboximpl2, f4, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 956488494, true, function22), composerStartRestartGroup, (i202 & 8190) | ((i202 << 6) & 234881024) | ((i202 << 3) & 1879048192), 6, 0);
                                composer3 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                paddingValues3 = paddingValues42;
                                buttonColors4 = buttonColors52;
                                buttonElevation3 = buttonElevation52;
                                z4 = z3;
                                modifier3 = modifier42;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i9 = i8;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 512) == 0) {
                    }
                    i4 |= i10;
                    if ((1533916891 & i4) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                borderStroke2 = borderStroke;
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 512) == 0) {
                }
                i4 |= i10;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            borderStroke2 = borderStroke;
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 512) == 0) {
            }
            i4 |= i10;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        if ((458752 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        borderStroke2 = borderStroke;
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 512) == 0) {
        }
        i4 |= i10;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0263 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable ButtonColors buttonColors, @Nullable ButtonElevation buttonElevation, @Nullable BorderStroke borderStroke, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape elevatedShape;
        ButtonColors buttonColorsM17008elevatedButtonColorsro_MJ88;
        ButtonElevation buttonElevationM17009elevatedButtonElevationR_JCAzs;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        BorderStroke borderStroke3;
        int i11;
        boolean z3;
        Shape shape2;
        ButtonElevation buttonElevation2;
        PaddingValues paddingValues2;
        Modifier modifier3;
        ButtonColors buttonColors2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer3;
        final MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues3;
        final BorderStroke borderStroke4;
        final ButtonElevation buttonElevation3;
        final ButtonColors buttonColors3;
        final Shape shape3;
        final boolean z4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1466887385);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        elevatedShape = shape;
                        int i13 = composerStartRestartGroup.changed(elevatedShape) ? 2048 : 1024;
                        i4 |= i13;
                    } else {
                        elevatedShape = shape;
                    }
                    i4 |= i13;
                } else {
                    elevatedShape = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColorsM17008elevatedButtonColorsro_MJ88 = buttonColors;
                        int i14 = composerStartRestartGroup.changed(buttonColorsM17008elevatedButtonColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i14;
                    } else {
                        buttonColorsM17008elevatedButtonColorsro_MJ88 = buttonColors;
                    }
                    i4 |= i14;
                } else {
                    buttonColorsM17008elevatedButtonColorsro_MJ88 = buttonColors;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevationM17009elevatedButtonElevationR_JCAzs = buttonElevation;
                        int i15 = composerStartRestartGroup.changed(buttonElevationM17009elevatedButtonElevationR_JCAzs) ? 131072 : 65536;
                        i4 |= i15;
                    } else {
                        buttonElevationM17009elevatedButtonElevationR_JCAzs = buttonElevation;
                    }
                    i4 |= i15;
                } else {
                    buttonElevationM17009elevatedButtonElevationR_JCAzs = buttonElevation;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i4 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        i9 = i8;
                    } else {
                        i9 = i8;
                        if ((i & 234881024) == 0) {
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            i10 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                        }
                        if ((1533916891 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier2;
                            z4 = z2;
                            shape3 = elevatedShape;
                            buttonColors3 = buttonColorsM17008elevatedButtonColorsro_MJ88;
                            composer3 = composerStartRestartGroup;
                            buttonElevation3 = buttonElevationM17009elevatedButtonElevationR_JCAzs;
                            borderStroke4 = borderStroke2;
                            paddingValues3 = paddingValues;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                    elevatedShape = ButtonDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    i4 &= -57345;
                                    buttonColorsM17008elevatedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m17008elevatedButtonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if ((i2 & 32) == 0) {
                                    composerStartRestartGroup = composer2;
                                    buttonElevationM17009elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m17009elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 196608, 31);
                                    i4 = (-458753) & i4;
                                } else {
                                    composerStartRestartGroup = composer2;
                                }
                                BorderStroke borderStroke5 = i6 == 0 ? null : borderStroke;
                                PaddingValues contentPadding = i7 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i9 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    boolean z5 = z2;
                                    borderStroke3 = borderStroke5;
                                    i11 = i4;
                                    z3 = z5;
                                    Shape shape4 = elevatedShape;
                                    paddingValues2 = contentPadding;
                                    modifier3 = modifier2;
                                    buttonColors2 = buttonColorsM17008elevatedButtonColorsro_MJ88;
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    shape2 = shape4;
                                    buttonElevation2 = buttonElevationM17009elevatedButtonElevationR_JCAzs;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1466887385, i11, -1, "androidx.compose.material3.ElevatedButton (Button.kt:207)");
                                    }
                                    Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i11, 0);
                                    composer3 = composerStartRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    paddingValues3 = paddingValues2;
                                    borderStroke4 = borderStroke3;
                                    buttonElevation3 = buttonElevation2;
                                    buttonColors3 = buttonColors2;
                                    shape3 = shape2;
                                    z4 = z3;
                                    modifier4 = modifier3;
                                } else {
                                    boolean z6 = z2;
                                    borderStroke3 = borderStroke5;
                                    i11 = i4;
                                    z3 = z6;
                                    shape2 = elevatedShape;
                                    buttonElevation2 = buttonElevationM17009elevatedButtonElevationR_JCAzs;
                                    paddingValues2 = contentPadding;
                                    modifier3 = modifier2;
                                    buttonColors2 = buttonColorsM17008elevatedButtonColorsro_MJ88;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                i11 = i4;
                                modifier3 = modifier2;
                                z3 = z2;
                                shape2 = elevatedShape;
                                buttonColors2 = buttonColorsM17008elevatedButtonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM17009elevatedButtonElevationR_JCAzs;
                                borderStroke3 = borderStroke2;
                                paddingValues2 = paddingValues;
                            }
                            mutableInteractionSource2 = mutableInteractionSource;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i11, 0);
                            composer3 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            paddingValues3 = paddingValues2;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation2;
                            buttonColors3 = buttonColors2;
                            shape3 = shape2;
                            z4 = z3;
                            modifier4 = modifier3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.ElevatedButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer4, int i16) {
                                ButtonKt.ElevatedButton(onClick, modifier4, z4, shape3, buttonColors3, buttonElevation3, borderStroke4, paddingValues3, mutableInteractionSource3, content, composer4, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i10 = DriveFile.MODE_READ_WRITE;
                    i4 |= i10;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i9 == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                borderStroke2 = borderStroke;
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                i4 |= i10;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            borderStroke2 = borderStroke;
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            i4 |= i10;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        if ((458752 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        borderStroke2 = borderStroke;
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        i4 |= i10;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0263 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable ButtonColors buttonColors, @Nullable ButtonElevation buttonElevation, @Nullable BorderStroke borderStroke, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape filledTonalShape;
        ButtonColors buttonColorsM17010filledTonalButtonColorsro_MJ88;
        ButtonElevation buttonElevationM17011filledTonalButtonElevationR_JCAzs;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        BorderStroke borderStroke3;
        int i11;
        boolean z3;
        Shape shape2;
        ButtonElevation buttonElevation2;
        PaddingValues paddingValues2;
        Modifier modifier3;
        ButtonColors buttonColors2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer3;
        final MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues3;
        final BorderStroke borderStroke4;
        final ButtonElevation buttonElevation3;
        final ButtonColors buttonColors3;
        final Shape shape3;
        final boolean z4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1717924381);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        filledTonalShape = shape;
                        int i13 = composerStartRestartGroup.changed(filledTonalShape) ? 2048 : 1024;
                        i4 |= i13;
                    } else {
                        filledTonalShape = shape;
                    }
                    i4 |= i13;
                } else {
                    filledTonalShape = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColorsM17010filledTonalButtonColorsro_MJ88 = buttonColors;
                        int i14 = composerStartRestartGroup.changed(buttonColorsM17010filledTonalButtonColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i14;
                    } else {
                        buttonColorsM17010filledTonalButtonColorsro_MJ88 = buttonColors;
                    }
                    i4 |= i14;
                } else {
                    buttonColorsM17010filledTonalButtonColorsro_MJ88 = buttonColors;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevationM17011filledTonalButtonElevationR_JCAzs = buttonElevation;
                        int i15 = composerStartRestartGroup.changed(buttonElevationM17011filledTonalButtonElevationR_JCAzs) ? 131072 : 65536;
                        i4 |= i15;
                    } else {
                        buttonElevationM17011filledTonalButtonElevationR_JCAzs = buttonElevation;
                    }
                    i4 |= i15;
                } else {
                    buttonElevationM17011filledTonalButtonElevationR_JCAzs = buttonElevation;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i4 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        i9 = i8;
                    } else {
                        i9 = i8;
                        if ((i & 234881024) == 0) {
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            i10 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                        }
                        if ((1533916891 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier2;
                            z4 = z2;
                            shape3 = filledTonalShape;
                            buttonColors3 = buttonColorsM17010filledTonalButtonColorsro_MJ88;
                            composer3 = composerStartRestartGroup;
                            buttonElevation3 = buttonElevationM17011filledTonalButtonElevationR_JCAzs;
                            borderStroke4 = borderStroke2;
                            paddingValues3 = paddingValues;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                    filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    i4 &= -57345;
                                    buttonColorsM17010filledTonalButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m17010filledTonalButtonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if ((i2 & 32) == 0) {
                                    composerStartRestartGroup = composer2;
                                    buttonElevationM17011filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m17011filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 196608, 31);
                                    i4 = (-458753) & i4;
                                } else {
                                    composerStartRestartGroup = composer2;
                                }
                                BorderStroke borderStroke5 = i6 == 0 ? null : borderStroke;
                                PaddingValues contentPadding = i7 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i9 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    boolean z5 = z2;
                                    borderStroke3 = borderStroke5;
                                    i11 = i4;
                                    z3 = z5;
                                    Shape shape4 = filledTonalShape;
                                    paddingValues2 = contentPadding;
                                    modifier3 = modifier2;
                                    buttonColors2 = buttonColorsM17010filledTonalButtonColorsro_MJ88;
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    shape2 = shape4;
                                    buttonElevation2 = buttonElevationM17011filledTonalButtonElevationR_JCAzs;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1717924381, i11, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:277)");
                                    }
                                    Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i11, 0);
                                    composer3 = composerStartRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    paddingValues3 = paddingValues2;
                                    borderStroke4 = borderStroke3;
                                    buttonElevation3 = buttonElevation2;
                                    buttonColors3 = buttonColors2;
                                    shape3 = shape2;
                                    z4 = z3;
                                    modifier4 = modifier3;
                                } else {
                                    boolean z6 = z2;
                                    borderStroke3 = borderStroke5;
                                    i11 = i4;
                                    z3 = z6;
                                    shape2 = filledTonalShape;
                                    buttonElevation2 = buttonElevationM17011filledTonalButtonElevationR_JCAzs;
                                    paddingValues2 = contentPadding;
                                    modifier3 = modifier2;
                                    buttonColors2 = buttonColorsM17010filledTonalButtonColorsro_MJ88;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                i11 = i4;
                                modifier3 = modifier2;
                                z3 = z2;
                                shape2 = filledTonalShape;
                                buttonColors2 = buttonColorsM17010filledTonalButtonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM17011filledTonalButtonElevationR_JCAzs;
                                borderStroke3 = borderStroke2;
                                paddingValues2 = paddingValues;
                            }
                            mutableInteractionSource2 = mutableInteractionSource;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i11, 0);
                            composer3 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            paddingValues3 = paddingValues2;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation2;
                            buttonColors3 = buttonColors2;
                            shape3 = shape2;
                            z4 = z3;
                            modifier4 = modifier3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.FilledTonalButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer4, int i16) {
                                ButtonKt.FilledTonalButton(onClick, modifier4, z4, shape3, buttonColors3, buttonElevation3, borderStroke4, paddingValues3, mutableInteractionSource3, content, composer4, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i10 = DriveFile.MODE_READ_WRITE;
                    i4 |= i10;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i9 == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                borderStroke2 = borderStroke;
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                i4 |= i10;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            borderStroke2 = borderStroke;
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            i4 |= i10;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        if ((458752 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        borderStroke2 = borderStroke;
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        i4 |= i10;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0247 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable ButtonColors buttonColors, @Nullable ButtonElevation buttonElevation, @Nullable BorderStroke borderStroke, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape outlinedShape;
        ButtonColors buttonColorsM17016outlinedButtonColorsro_MJ88;
        int i6;
        ButtonElevation buttonElevation2;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        BorderStroke outlinedButtonBorder;
        BorderStroke borderStroke3;
        int i11;
        boolean z3;
        Shape shape2;
        ButtonElevation buttonElevation3;
        PaddingValues paddingValues2;
        Modifier modifier3;
        ButtonColors buttonColors2;
        MutableInteractionSource mutableInteractionSource2;
        final MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues3;
        final BorderStroke borderStroke4;
        final ButtonElevation buttonElevation4;
        final ButtonColors buttonColors3;
        final Shape shape3;
        final boolean z4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1694808287);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        outlinedShape = shape;
                        int i13 = composerStartRestartGroup.changed(outlinedShape) ? 2048 : 1024;
                        i4 |= i13;
                    } else {
                        outlinedShape = shape;
                    }
                    i4 |= i13;
                } else {
                    outlinedShape = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColorsM17016outlinedButtonColorsro_MJ88 = buttonColors;
                        int i14 = composerStartRestartGroup.changed(buttonColorsM17016outlinedButtonColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i14;
                    } else {
                        buttonColorsM17016outlinedButtonColorsro_MJ88 = buttonColors;
                    }
                    i4 |= i14;
                } else {
                    buttonColorsM17016outlinedButtonColorsro_MJ88 = buttonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        buttonElevation2 = buttonElevation;
                        i4 |= composerStartRestartGroup.changed(buttonElevation2) ? 131072 : 65536;
                    }
                    if ((3670016 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            borderStroke2 = borderStroke;
                            int i15 = composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                            i4 |= i15;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        i4 |= i15;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i4 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        i9 = i8;
                    } else {
                        i9 = i8;
                        if ((i & 234881024) == 0) {
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            i10 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                        }
                        if ((1533916891 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier2;
                            z4 = z2;
                            shape3 = outlinedShape;
                            buttonColors3 = buttonColorsM17016outlinedButtonColorsro_MJ88;
                            buttonElevation4 = buttonElevation2;
                            borderStroke4 = borderStroke2;
                            paddingValues3 = paddingValues;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                    outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                    buttonColorsM17016outlinedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m17016outlinedButtonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                }
                                if (i6 != 0) {
                                    buttonElevation2 = null;
                                }
                                if ((i2 & 64) == 0) {
                                    outlinedButtonBorder = ButtonDefaults.INSTANCE.getOutlinedButtonBorder(composerStartRestartGroup, 6);
                                    i4 = (-3670017) & i4;
                                } else {
                                    outlinedButtonBorder = borderStroke;
                                }
                                PaddingValues contentPadding = i7 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i9 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    boolean z5 = z2;
                                    borderStroke3 = outlinedButtonBorder;
                                    i11 = i4;
                                    z3 = z5;
                                    Shape shape4 = outlinedShape;
                                    paddingValues2 = contentPadding;
                                    modifier3 = modifier2;
                                    buttonColors2 = buttonColorsM17016outlinedButtonColorsro_MJ88;
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    shape2 = shape4;
                                    buttonElevation3 = buttonElevation2;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1694808287, i11, -1, "androidx.compose.material3.OutlinedButton (Button.kt:346)");
                                    }
                                    Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i11, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    paddingValues3 = paddingValues2;
                                    borderStroke4 = borderStroke3;
                                    buttonElevation4 = buttonElevation3;
                                    buttonColors3 = buttonColors2;
                                    shape3 = shape2;
                                    z4 = z3;
                                    modifier4 = modifier3;
                                } else {
                                    boolean z6 = z2;
                                    borderStroke3 = outlinedButtonBorder;
                                    i11 = i4;
                                    z3 = z6;
                                    shape2 = outlinedShape;
                                    buttonElevation3 = buttonElevation2;
                                    paddingValues2 = contentPadding;
                                    modifier3 = modifier2;
                                    buttonColors2 = buttonColorsM17016outlinedButtonColorsro_MJ88;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                i11 = i4;
                                modifier3 = modifier2;
                                z3 = z2;
                                shape2 = outlinedShape;
                                buttonColors2 = buttonColorsM17016outlinedButtonColorsro_MJ88;
                                buttonElevation3 = buttonElevation2;
                                borderStroke3 = borderStroke2;
                                paddingValues2 = paddingValues;
                            }
                            mutableInteractionSource2 = mutableInteractionSource;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i11, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            paddingValues3 = paddingValues2;
                            borderStroke4 = borderStroke3;
                            buttonElevation4 = buttonElevation3;
                            buttonColors3 = buttonColors2;
                            shape3 = shape2;
                            z4 = z3;
                            modifier4 = modifier3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.OutlinedButton.2
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

                            public final void invoke(@Nullable Composer composer2, int i16) {
                                ButtonKt.OutlinedButton(onClick, modifier4, z4, shape3, buttonColors3, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i10 = DriveFile.MODE_READ_WRITE;
                    i4 |= i10;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 64) == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i9 == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                if ((3670016 & i) != 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                i4 |= i10;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            buttonElevation2 = buttonElevation;
            if ((3670016 & i) != 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            i4 |= i10;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        buttonElevation2 = buttonElevation;
        if ((3670016 & i) != 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        i4 |= i10;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0234 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable ButtonColors buttonColors, @Nullable ButtonElevation buttonElevation, @Nullable BorderStroke borderStroke, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape textShape;
        ButtonColors buttonColorsM17017textButtonColorsro_MJ88;
        int i6;
        ButtonElevation buttonElevation2;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        int i10;
        int i11;
        BorderStroke borderStroke3;
        int i12;
        boolean z3;
        Shape shape2;
        ButtonElevation buttonElevation3;
        PaddingValues paddingValues2;
        Modifier modifier3;
        ButtonColors buttonColors2;
        MutableInteractionSource mutableInteractionSource2;
        final MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues3;
        final BorderStroke borderStroke4;
        final ButtonElevation buttonElevation4;
        final ButtonColors buttonColors3;
        final Shape shape3;
        final boolean z4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2106428362);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        textShape = shape;
                        int i14 = composerStartRestartGroup.changed(textShape) ? 2048 : 1024;
                        i4 |= i14;
                    } else {
                        textShape = shape;
                    }
                    i4 |= i14;
                } else {
                    textShape = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColorsM17017textButtonColorsro_MJ88 = buttonColors;
                        int i15 = composerStartRestartGroup.changed(buttonColorsM17017textButtonColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i15;
                    } else {
                        buttonColorsM17017textButtonColorsro_MJ88 = buttonColors;
                    }
                    i4 |= i15;
                } else {
                    buttonColorsM17017textButtonColorsro_MJ88 = buttonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        buttonElevation2 = buttonElevation;
                        i4 |= composerStartRestartGroup.changed(buttonElevation2) ? 131072 : 65536;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else {
                        if ((3670016 & i) == 0) {
                            borderStroke2 = borderStroke;
                            i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            i4 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                        }
                        i9 = i2 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                            i10 = i9;
                        } else {
                            i10 = i9;
                            if ((i & 234881024) == 0) {
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            }
                        }
                        if ((i2 & 512) == 0) {
                            if ((1879048192 & i) == 0) {
                                i11 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                            }
                            if ((1533916891 & i4) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i13 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i4 &= -7169;
                                        textShape = ButtonDefaults.INSTANCE.getTextShape(composerStartRestartGroup, 6);
                                    }
                                    if ((i2 & 16) != 0) {
                                        buttonColorsM17017textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m17017textButtonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                        i4 = (-57345) & i4;
                                    }
                                    if (i6 != 0) {
                                        buttonElevation2 = null;
                                    }
                                    BorderStroke borderStroke5 = i7 == 0 ? borderStroke : null;
                                    PaddingValues textButtonContentPadding = i8 == 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
                                    if (i10 == 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        boolean z5 = z2;
                                        borderStroke3 = borderStroke5;
                                        i12 = i4;
                                        z3 = z5;
                                        Shape shape4 = textShape;
                                        paddingValues2 = textButtonContentPadding;
                                        modifier3 = modifier2;
                                        buttonColors2 = buttonColorsM17017textButtonColorsro_MJ88;
                                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                        shape2 = shape4;
                                        buttonElevation3 = buttonElevation2;
                                        composerStartRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2106428362, i12, -1, "androidx.compose.material3.TextButton (Button.kt:417)");
                                        }
                                        Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i12, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        paddingValues3 = paddingValues2;
                                        borderStroke4 = borderStroke3;
                                        buttonElevation4 = buttonElevation3;
                                        buttonColors3 = buttonColors2;
                                        shape3 = shape2;
                                        z4 = z3;
                                        modifier4 = modifier3;
                                    } else {
                                        boolean z6 = z2;
                                        borderStroke3 = borderStroke5;
                                        i12 = i4;
                                        z3 = z6;
                                        shape2 = textShape;
                                        buttonElevation3 = buttonElevation2;
                                        paddingValues2 = textButtonContentPadding;
                                        modifier3 = modifier2;
                                        buttonColors2 = buttonColorsM17017textButtonColorsro_MJ88;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    i12 = i4;
                                    modifier3 = modifier2;
                                    z3 = z2;
                                    shape2 = textShape;
                                    buttonColors2 = buttonColorsM17017textButtonColorsro_MJ88;
                                    buttonElevation3 = buttonElevation2;
                                    borderStroke3 = borderStroke2;
                                    paddingValues2 = paddingValues;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Button(onClick, modifier3, z3, shape2, buttonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, content, composerStartRestartGroup, 2147483646 & i12, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                mutableInteractionSource3 = mutableInteractionSource2;
                                paddingValues3 = paddingValues2;
                                borderStroke4 = borderStroke3;
                                buttonElevation4 = buttonElevation3;
                                buttonColors3 = buttonColors2;
                                shape3 = shape2;
                                z4 = z3;
                                modifier4 = modifier3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier4 = modifier2;
                                z4 = z2;
                                shape3 = textShape;
                                buttonColors3 = buttonColorsM17017textButtonColorsro_MJ88;
                                buttonElevation4 = buttonElevation2;
                                borderStroke4 = borderStroke2;
                                paddingValues3 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.TextButton.2
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

                                public final void invoke(@Nullable Composer composer2, int i16) {
                                    ButtonKt.TextButton(onClick, modifier4, z4, shape3, buttonColors3, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, content, composer2, i | 1, i2);
                                }
                            });
                            return;
                        }
                        i11 = DriveFile.MODE_READ_WRITE;
                        i4 |= i11;
                        if ((1533916891 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if ((i2 & 8) != 0) {
                                }
                                if ((i2 & 16) != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i10 == 0) {
                                }
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i2 & 256;
                    if (i9 != 0) {
                    }
                    if ((i2 & 512) == 0) {
                    }
                    i4 |= i11;
                    if ((1533916891 & i4) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                borderStroke2 = borderStroke;
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                i9 = i2 & 256;
                if (i9 != 0) {
                }
                if ((i2 & 512) == 0) {
                }
                i4 |= i11;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            buttonElevation2 = buttonElevation;
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            borderStroke2 = borderStroke;
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            i9 = i2 & 256;
            if (i9 != 0) {
            }
            if ((i2 & 512) == 0) {
            }
            i4 |= i11;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        buttonElevation2 = buttonElevation;
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        borderStroke2 = borderStroke;
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        i9 = i2 & 256;
        if (i9 != 0) {
        }
        if ((i2 & 512) == 0) {
        }
        i4 |= i11;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
