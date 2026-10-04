package androidx.compose.material3;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.window.AndroidDialog_androidKt;
import androidx.compose.p109ui.window.DialogProperties;
import androidx.compose.p109ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aâ\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ButtonsMainAxisSpacing", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", StringLookupFactory.KEY_PROPERTIES, "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AndroidAlertDialog_androidKt {
    private static final float ButtonsMainAxisSpacing = C2256Dp.m20968constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = C2256Dp.m20968constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:105:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0335 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16986AlertDialogOix01E0(@NotNull final Function0<Unit> onDismissRequest, @NotNull final Function2<? super Composer, ? super Integer, Unit> confirmButton, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Shape shape, long j, long j2, long j3, long j5, float f, @Nullable DialogProperties dialogProperties, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Shape shape2;
        int i10;
        int i11;
        long containerColor;
        long iconContentColor;
        long titleContentColor;
        long textContentColor;
        DialogProperties dialogProperties2;
        final float f4;
        int i12;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Shape shape3;
        int i13;
        final long j6;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final long j7;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final long j8;
        Composer composer3;
        final long j9;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        final float f5;
        final long j10;
        final Shape shape4;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2081346864);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(onDismissRequest) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(confirmButton) ? 32 : 16;
        }
        int i14 = i4 & 4;
        if (i14 != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            int i15 = 1024;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    function25 = function2;
                    i5 |= composerStartRestartGroup.changed(function25) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                    function26 = function22;
                } else {
                    function26 = function22;
                    if ((i & 57344) == 0) {
                        i5 |= composerStartRestartGroup.changed(function26) ? 16384 : 8192;
                    }
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= 196608;
                    function27 = function23;
                } else {
                    function27 = function23;
                    if ((i & 458752) == 0) {
                        i5 |= composerStartRestartGroup.changed(function27) ? 131072 : 65536;
                    }
                }
                i9 = i4 & 64;
                if (i9 != 0) {
                    i5 |= 1572864;
                    function28 = function24;
                } else {
                    function28 = function24;
                    if ((i & 3670016) == 0) {
                        i5 |= composerStartRestartGroup.changed(function28) ? 1048576 : 524288;
                    }
                }
                if ((i & 29360128) == 0) {
                    if ((i4 & 128) == 0) {
                        shape2 = shape;
                        int i16 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                        i5 |= i16;
                    } else {
                        shape2 = shape;
                    }
                    i5 |= i16;
                } else {
                    shape2 = shape;
                }
                if ((i & 234881024) == 0) {
                    i5 |= ((i4 & 256) == 0 && composerStartRestartGroup.changed(j)) ? 67108864 : 33554432;
                }
                if ((i & 1879048192) == 0) {
                    i5 |= ((i4 & 512) == 0 && composerStartRestartGroup.changed(j2)) ? 536870912 : 268435456;
                }
                if ((i2 & 14) == 0) {
                    i10 = i2 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(j3)) ? 4 : 2);
                } else {
                    i10 = i2;
                }
                if ((i2 & 112) == 0) {
                    i10 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changed(j5)) ? 32 : 16;
                }
                i11 = i4 & 4096;
                if (i11 == 0) {
                    if ((i2 & 896) == 0) {
                        i10 |= composerStartRestartGroup.changed(f) ? 256 : 128;
                    }
                    if ((i2 & 7168) == 0) {
                        if ((i4 & 8192) == 0 && composerStartRestartGroup.changed(dialogProperties)) {
                            i15 = 2048;
                        }
                        i10 |= i15;
                    }
                    if ((i5 & 1533916891) != 306783378 && (i10 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        f5 = f;
                        dialogProperties3 = dialogProperties;
                        composer3 = composerStartRestartGroup;
                        function216 = function25;
                        function215 = function26;
                        function214 = function27;
                        function213 = function28;
                        shape4 = shape2;
                        modifier3 = modifier2;
                        j10 = j;
                        j7 = j2;
                        j6 = j3;
                        j9 = j5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                function25 = null;
                            }
                            if (i7 != 0) {
                                function26 = null;
                            }
                            if (i8 != 0) {
                                function27 = null;
                            }
                            if (i9 != 0) {
                                function28 = null;
                            }
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i4 & 256) == 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i5 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i4 & 512) == 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i5 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i4 & 1024) == 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i10 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i4 & 2048) == 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i10 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            } else {
                                textContentColor = j5;
                            }
                            float fM16983getTonalElevationD9Ej5fM = i11 == 0 ? AlertDialogDefaults.INSTANCE.m16983getTonalElevationD9Ej5fM() : f;
                            if ((i4 & 8192) == 0) {
                                i10 &= -7169;
                                f4 = fM16983getTonalElevationD9Ej5fM;
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                                f4 = fM16983getTonalElevationD9Ej5fM;
                            }
                            i12 = i5;
                            function29 = function26;
                            function210 = function27;
                            shape3 = shape2;
                            i13 = i10;
                            j6 = titleContentColor;
                            long j11 = iconContentColor;
                            composer2 = composerStartRestartGroup;
                            function211 = function28;
                            j7 = j11;
                            function212 = function25;
                            j8 = containerColor;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                            }
                            if ((i4 & 256) != 0) {
                                i5 &= -234881025;
                            }
                            if ((i4 & 512) != 0) {
                                i5 &= -1879048193;
                            }
                            if ((i4 & 1024) != 0) {
                                i10 &= -15;
                            }
                            if ((i4 & 2048) != 0) {
                                i10 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            if ((i4 & 8192) != 0) {
                                i10 &= -7169;
                            }
                            textContentColor = j5;
                            f4 = f;
                            dialogProperties2 = dialogProperties;
                            composer2 = composerStartRestartGroup;
                            i12 = i5;
                            function212 = function25;
                            function29 = function26;
                            function210 = function27;
                            function211 = function28;
                            shape3 = shape2;
                            i13 = i10;
                            j8 = j;
                            j7 = j2;
                            j6 = j3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i12, i13, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:73)");
                        }
                        final int i17 = i13;
                        final int i18 = i12;
                        final Modifier modifier4 = modifier2;
                        composer3 = composer2;
                        j9 = textContentColor;
                        AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties2, ComposableLambdaKt.composableLambda(composer3, -1218806937, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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
                            public final void invoke(@Nullable Composer composer4, int i19) {
                                if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1218806937, i19, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:92)");
                                }
                                final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17310getDialogadMyvUU(), composer4, 6);
                                final Function2<Composer, Integer, Unit> function217 = function212;
                                final int i20 = i18;
                                final Function2<Composer, Integer, Unit> function218 = confirmButton;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 2094788745, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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
                                            ComposerKt.traceEventStart(2094788745, i21, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:95)");
                                        }
                                        float f6 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                        float f7 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                        final Function2<Composer, Integer, Unit> function219 = function217;
                                        final int i22 = i20;
                                        final Function2<Composer, Integer, Unit> function220 = function218;
                                        AlertDialogKt.m16985AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer5, -1243689536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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
                                                    ComposerKt.traceEventStart(-1243689536, i23, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                }
                                                Function2<Composer, Integer, Unit> function221 = function219;
                                                composer6.startReplaceableGroup(-1969500760);
                                                if (function221 != null) {
                                                    function221.invoke(composer6, Integer.valueOf((i22 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer6.endReplaceableGroup();
                                                if (AbstractC1038a.m1196A(composer6, (i22 >> 3) & 14, function220)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 438);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                Modifier modifier5 = modifier4;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                composer4.startReplaceableGroup(1157296644);
                                boolean zChanged = composer4.changed(strM17317getStringNWtq28);
                                Object objRememberedValue = composer4.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1$2$1
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
                                            SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq28);
                                        }
                                    };
                                    composer4.updateRememberedValue(objRememberedValue);
                                }
                                composer4.endReplaceableGroup();
                                Modifier modifierThen = modifier5.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null));
                                Function2<Composer, Integer, Unit> function219 = function29;
                                Function2<Composer, Integer, Unit> function220 = function210;
                                Function2<Composer, Integer, Unit> function221 = function211;
                                Shape shape5 = shape3;
                                long j12 = j8;
                                float f6 = f4;
                                long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6);
                                long j13 = j7;
                                long j14 = j6;
                                long j15 = j9;
                                int i21 = i18;
                                int i22 = ((i21 >> 6) & 7168) | ((i21 >> 6) & 896) | 6 | ((i21 >> 6) & 57344) | ((i21 >> 6) & 458752) | ((i21 >> 6) & 3670016);
                                int i23 = i17;
                                AlertDialogKt.m16984AlertDialogContent4hvqGtA(composableLambda, modifierThen, function219, function220, function221, shape5, j12, f6, color, j13, j14, j15, composer4, i22 | ((i23 << 15) & 29360128) | (i21 & 1879048192), i23 & 126, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (i18 & 14) | 384 | ((i17 >> 6) & 112), 0);
                        DialogProperties dialogProperties4 = dialogProperties2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        dialogProperties3 = dialogProperties4;
                        f5 = f4;
                        j10 = j8;
                        shape4 = shape3;
                        function213 = function211;
                        function214 = function210;
                        function215 = function29;
                        function216 = function212;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$2
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

                        public final void invoke(@Nullable Composer composer4, int i19) {
                            AndroidAlertDialog_androidKt.m16986AlertDialogOix01E0(onDismissRequest, confirmButton, modifier3, function216, function215, function214, function213, shape4, j10, j7, j6, j9, f5, dialogProperties3, composer4, i | 1, i2, i4);
                        }
                    });
                    return;
                }
                i10 |= 384;
                if ((i2 & 7168) == 0) {
                }
                if ((i5 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i4 & 128) != 0) {
                        }
                        if ((i4 & 256) == 0) {
                        }
                        if ((i4 & 512) == 0) {
                        }
                        if ((i4 & 1024) == 0) {
                        }
                        if ((i4 & 2048) == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if ((i4 & 8192) == 0) {
                        }
                        i12 = i5;
                        function29 = function26;
                        function210 = function27;
                        shape3 = shape2;
                        i13 = i10;
                        j6 = titleContentColor;
                        long j112 = iconContentColor;
                        composer2 = composerStartRestartGroup;
                        function211 = function28;
                        j7 = j112;
                        function212 = function25;
                        j8 = containerColor;
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final int i172 = i13;
                        final int i182 = i12;
                        final Modifier modifier42 = modifier2;
                        composer3 = composer2;
                        j9 = textContentColor;
                        AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties2, ComposableLambdaKt.composableLambda(composer3, -1218806937, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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
                            public final void invoke(@Nullable Composer composer4, int i19) {
                                if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1218806937, i19, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:92)");
                                }
                                final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17310getDialogadMyvUU(), composer4, 6);
                                final Function2<? super Composer, ? super Integer, Unit> function217 = function212;
                                final int i20 = i182;
                                final Function2<? super Composer, ? super Integer, Unit> function218 = confirmButton;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 2094788745, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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
                                            ComposerKt.traceEventStart(2094788745, i21, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:95)");
                                        }
                                        float f6 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                        float f7 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                        final Function2<? super Composer, ? super Integer, Unit> function219 = function217;
                                        final int i22 = i20;
                                        final Function2<? super Composer, ? super Integer, Unit> function220 = function218;
                                        AlertDialogKt.m16985AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer5, -1243689536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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
                                                    ComposerKt.traceEventStart(-1243689536, i23, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                }
                                                Function2<Composer, Integer, Unit> function221 = function219;
                                                composer6.startReplaceableGroup(-1969500760);
                                                if (function221 != null) {
                                                    function221.invoke(composer6, Integer.valueOf((i22 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer6.endReplaceableGroup();
                                                if (AbstractC1038a.m1196A(composer6, (i22 >> 3) & 14, function220)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 438);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                Modifier modifier5 = modifier42;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                composer4.startReplaceableGroup(1157296644);
                                boolean zChanged = composer4.changed(strM17317getStringNWtq28);
                                Object objRememberedValue = composer4.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1$2$1
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
                                            SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq28);
                                        }
                                    };
                                    composer4.updateRememberedValue(objRememberedValue);
                                }
                                composer4.endReplaceableGroup();
                                Modifier modifierThen = modifier5.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null));
                                Function2<Composer, Integer, Unit> function219 = function29;
                                Function2<Composer, Integer, Unit> function220 = function210;
                                Function2<Composer, Integer, Unit> function221 = function211;
                                Shape shape5 = shape3;
                                long j12 = j8;
                                float f6 = f4;
                                long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6);
                                long j13 = j7;
                                long j14 = j6;
                                long j15 = j9;
                                int i21 = i182;
                                int i22 = ((i21 >> 6) & 7168) | ((i21 >> 6) & 896) | 6 | ((i21 >> 6) & 57344) | ((i21 >> 6) & 458752) | ((i21 >> 6) & 3670016);
                                int i23 = i172;
                                AlertDialogKt.m16984AlertDialogContent4hvqGtA(composableLambda, modifierThen, function219, function220, function221, shape5, j12, f6, color, j13, j14, j15, composer4, i22 | ((i23 << 15) & 29360128) | (i21 & 1879048192), i23 & 126, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (i182 & 14) | 384 | ((i172 >> 6) & 112), 0);
                        DialogProperties dialogProperties42 = dialogProperties2;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        dialogProperties3 = dialogProperties42;
                        f5 = f4;
                        j10 = j8;
                        shape4 = shape3;
                        function213 = function211;
                        function214 = function210;
                        function215 = function29;
                        function216 = function212;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function25 = function2;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            i8 = i4 & 32;
            if (i8 != 0) {
            }
            i9 = i4 & 64;
            if (i9 != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            if ((i2 & 14) == 0) {
            }
            if ((i2 & 112) == 0) {
            }
            i11 = i4 & 4096;
            if (i11 == 0) {
            }
            if ((i2 & 7168) == 0) {
            }
            if ((i5 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        int i152 = 1024;
        if (i6 == 0) {
        }
        function25 = function2;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        i8 = i4 & 32;
        if (i8 != 0) {
        }
        i9 = i4 & 64;
        if (i9 != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        if ((i2 & 14) == 0) {
        }
        if ((i2 & 112) == 0) {
        }
        i11 = i4 & 4096;
        if (i11 == 0) {
        }
        if ((i2 & 7168) == 0) {
        }
        if ((i5 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
