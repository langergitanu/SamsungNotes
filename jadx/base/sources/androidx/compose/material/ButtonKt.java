package androidx.compose.material;

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
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, m13886d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0311 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable ButtonElevation buttonElevation, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ButtonColors buttonColors, @Nullable PaddingValues paddingValues, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        ButtonElevation buttonElevation2;
        Shape shape2;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        final PaddingValues contentPadding;
        int i10;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        int i11;
        ButtonElevation buttonElevationM16627elevationR_JCAzs;
        int i12;
        Shape small;
        ButtonColors buttonColorsM16626buttonColorsro_MJ88;
        BorderStroke borderStroke3;
        ButtonElevation buttonElevation3;
        ButtonColors buttonColors2;
        boolean z3;
        final int i13;
        final Shape shape3;
        final BorderStroke borderStroke4;
        final ButtonElevation buttonElevation4;
        final ButtonColors buttonColors3;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2116133464);
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
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 2048 : 1024;
                    }
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            buttonElevation2 = buttonElevation;
                            int i15 = composerStartRestartGroup.changed(buttonElevation2) ? 16384 : 8192;
                            i4 |= i15;
                        } else {
                            buttonElevation2 = buttonElevation;
                        }
                        i4 |= i15;
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i16 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i4 |= i16;
                        } else {
                            shape2 = shape;
                        }
                        i4 |= i16;
                    } else {
                        shape2 = shape;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 3670016) == 0) {
                            i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 29360128) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(buttonColors)) ? 8388608 : 4194304;
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        if ((i & 234881024) == 0) {
                            i9 = i8;
                            contentPadding = paddingValues;
                            i4 |= composerStartRestartGroup.changed(contentPadding) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) != 0) {
                            i4 |= DriveFile.MODE_READ_WRITE;
                        } else if ((1879048192 & i) == 0) {
                            i4 |= composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                        }
                        i10 = i4;
                        if ((1533916891 & i10) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            borderStroke4 = borderStroke2;
                            paddingValues2 = contentPadding;
                            modifier4 = modifier2;
                            z4 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            buttonElevation4 = buttonElevation2;
                            shape3 = shape2;
                            buttonColors3 = buttonColors;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier5 = i14 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i5 == 0 ? true : z2;
                                if (i6 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) == 0) {
                                    modifier3 = modifier5;
                                    i11 = i9;
                                    buttonElevationM16627elevationR_JCAzs = ButtonDefaults.INSTANCE.m16627elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 196608, 31);
                                    i12 = i10 & (-57345);
                                } else {
                                    modifier3 = modifier5;
                                    i11 = i9;
                                    buttonElevationM16627elevationR_JCAzs = buttonElevation2;
                                    i12 = i10;
                                }
                                if ((i2 & 32) == 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i12 &= -458753;
                                } else {
                                    small = shape2;
                                }
                                if (i7 != 0) {
                                    borderStroke2 = null;
                                }
                                if ((i2 & 128) == 0) {
                                    buttonColorsM16626buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m16626buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i12 &= -29360129;
                                } else {
                                    buttonColorsM16626buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i11 == 0) {
                                    borderStroke3 = borderStroke2;
                                    buttonElevation3 = buttonElevationM16627elevationR_JCAzs;
                                    buttonColors2 = buttonColorsM16626buttonColorsro_MJ88;
                                    i13 = i12;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    shape2 = small;
                                    z3 = z5;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    modifier2 = modifier3;
                                } else {
                                    borderStroke3 = borderStroke2;
                                    buttonElevation3 = buttonElevationM16627elevationR_JCAzs;
                                    shape2 = small;
                                    buttonColors2 = buttonColorsM16626buttonColorsro_MJ88;
                                    z3 = z5;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    modifier2 = modifier3;
                                    i13 = i12;
                                    contentPadding = paddingValues;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                int i17 = (i2 & 16) != 0 ? i10 & (-57345) : i10;
                                if ((i2 & 32) != 0) {
                                    i17 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i17 &= -29360129;
                                }
                                i13 = i17;
                                z3 = z2;
                                buttonColors2 = buttonColors;
                                borderStroke3 = borderStroke2;
                                buttonElevation3 = buttonElevation2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:90)");
                            }
                            int i18 = i13 >> 6;
                            int i19 = (i18 & 14) | ((i13 >> 18) & 112);
                            final State<Color> stateContentColor = buttonColors2.contentColor(z3, composerStartRestartGroup, i19);
                            long jM18535unboximpl = buttonColors2.backgroundColor(z3, composerStartRestartGroup, i19).getValue().m18535unboximpl();
                            long jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(m16636Button$lambda1(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            State<C2256Dp> stateElevation = buttonElevation3 != null ? buttonElevation3.elevation(z3, mutableInteractionSource2, composerStartRestartGroup, i18 & Event.CAPS_LOCK) : null;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                            Shape shape4 = shape2;
                            Modifier modifier6 = modifier2;
                            PaddingValues paddingValues3 = contentPadding;
                            ButtonElevation buttonElevation5 = buttonElevation3;
                            ButtonColors buttonColors4 = buttonColors2;
                            SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier6, z3, shape4, jM18535unboximpl, jM18524copywmQWz5c$default, borderStroke3, stateElevation == null ? stateElevation.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0), mutableInteractionSource5, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i20) {
                                    if ((i20 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(7524271, i20, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:113)");
                                    }
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(ButtonKt.m16636Button$lambda1(stateContentColor))))};
                                    final PaddingValues paddingValues4 = contentPadding;
                                    final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                    final int i21 = i13;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
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

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer3, int i22) {
                                            if ((i22 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:114)");
                                            }
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                                            final PaddingValues paddingValues5 = paddingValues4;
                                            final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                            final int i23 = i21;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer3, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
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

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer4, int i24) {
                                                    if ((i24 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-630330208, i24, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:117)");
                                                    }
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m15883defaultMinSizeVpY3zN4(companion, buttonDefaults.m16632getMinWidthD9Ej5fM(), buttonDefaults.m16631getMinHeightD9Ej5fM()), paddingValues5);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    int i25 = ((i23 >> 18) & 7168) | 432;
                                                    composer4.startReplaceableGroup(693286680);
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                                    Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (composer4.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    composer4.disableReusing();
                                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                    composer4.startReplaceableGroup(-678309503);
                                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, Integer.valueOf(((i25 >> 6) & 112) | 6));
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer3, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, (i13 & 14) | DriveFile.MODE_READ_WRITE | (i13 & 112) | (i13 & 896) | (i18 & 7168) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape3 = shape4;
                            borderStroke4 = borderStroke3;
                            buttonElevation4 = buttonElevation5;
                            buttonColors3 = buttonColors4;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource4 = mutableInteractionSource5;
                            z4 = z3;
                            modifier4 = modifier6;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                            public final void invoke(@Nullable Composer composer2, int i20) {
                                ButtonKt.Button(onClick, modifier4, z4, mutableInteractionSource4, buttonElevation4, shape3, borderStroke4, buttonColors3, paddingValues2, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 100663296;
                    i9 = i8;
                    contentPadding = paddingValues;
                    if ((i2 & 512) != 0) {
                    }
                    i10 = i4;
                    if ((1533916891 & i10) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                            if (i11 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i182 = i13 >> 6;
                            int i192 = (i182 & 14) | ((i13 >> 18) & 112);
                            final State<Color> stateContentColor2 = buttonColors2.contentColor(z3, composerStartRestartGroup, i192);
                            long jM18535unboximpl2 = buttonColors2.backgroundColor(z3, composerStartRestartGroup, i192).getValue().m18535unboximpl();
                            long jM18524copywmQWz5c$default2 = Color.m18524copywmQWz5c$default(m16636Button$lambda1(stateContentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            if (buttonElevation3 != null) {
                            }
                            MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource2;
                            Shape shape42 = shape2;
                            Modifier modifier62 = modifier2;
                            PaddingValues paddingValues32 = contentPadding;
                            ButtonElevation buttonElevation52 = buttonElevation3;
                            ButtonColors buttonColors42 = buttonColors2;
                            SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier62, z3, shape42, jM18535unboximpl2, jM18524copywmQWz5c$default2, borderStroke3, stateElevation == null ? stateElevation.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0), mutableInteractionSource52, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i20) {
                                    if ((i20 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(7524271, i20, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:113)");
                                    }
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(ButtonKt.m16636Button$lambda1(stateContentColor2))))};
                                    final PaddingValues paddingValues4 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i21 = i13;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
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

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer3, int i22) {
                                            if ((i22 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:114)");
                                            }
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                                            final PaddingValues paddingValues5 = paddingValues4;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                            final int i23 = i21;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer3, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
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

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer4, int i24) {
                                                    if ((i24 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-630330208, i24, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:117)");
                                                    }
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m15883defaultMinSizeVpY3zN4(companion, buttonDefaults.m16632getMinWidthD9Ej5fM(), buttonDefaults.m16631getMinHeightD9Ej5fM()), paddingValues5);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    int i25 = ((i23 >> 18) & 7168) | 432;
                                                    composer4.startReplaceableGroup(693286680);
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                                    Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (composer4.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    composer4.disableReusing();
                                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                    composer4.startReplaceableGroup(-678309503);
                                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, Integer.valueOf(((i25 >> 6) & 112) | 6));
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer3, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, (i13 & 14) | DriveFile.MODE_READ_WRITE | (i13 & 112) | (i13 & 896) | (i182 & 7168) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape3 = shape42;
                            borderStroke4 = borderStroke3;
                            buttonElevation4 = buttonElevation52;
                            buttonColors3 = buttonColors42;
                            paddingValues2 = paddingValues32;
                            mutableInteractionSource4 = mutableInteractionSource52;
                            z4 = z3;
                            modifier4 = modifier62;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                contentPadding = paddingValues;
                if ((i2 & 512) != 0) {
                }
                i10 = i4;
                if ((1533916891 & i10) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            contentPadding = paddingValues;
            if ((i2 & 512) != 0) {
            }
            i10 = i4;
            if ((1533916891 & i10) == 306783378) {
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
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        contentPadding = paddingValues;
        if ((i2 & 512) != 0) {
        }
        i10 = i4;
        if ((1533916891 & i10) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Button$lambda-1, reason: not valid java name */
    public static final long m16636Button$lambda1(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OutlinedButton(@NotNull Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable ButtonElevation buttonElevation, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ButtonColors buttonColors, @Nullable PaddingValues paddingValues, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-1776134358);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
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
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke outlinedBorder = (i2 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6) : borderStroke;
        ButtonColors buttonColorsM16634outlinedButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m16634outlinedButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues contentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1776134358, i, -1, "androidx.compose.material.OutlinedButton (Button.kt:164)");
        }
        Button(onClick, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, outlinedBorder, buttonColorsM16634outlinedButtonColorsRGew2ao, contentPadding, content, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TextButton(@NotNull Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable ButtonElevation buttonElevation, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ButtonColors buttonColors, @Nullable PaddingValues paddingValues, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(288797557);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
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
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        ButtonColors buttonColorsM16635textButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m16635textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues textButtonContentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288797557, i, -1, "androidx.compose.material.TextButton (Button.kt:218)");
        }
        Button(onClick, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, borderStroke2, buttonColorsM16635textButtonColorsRGew2ao, textButtonContentPadding, content, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
