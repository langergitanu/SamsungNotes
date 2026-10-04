package androidx.compose.material;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.window.AndroidDialog_androidKt;
import androidx.compose.p109ui.window.DialogProperties;
import androidx.compose.p109ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u00ad\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, m13886d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", StringLookupFactory.KEY_PROPERTIES, "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0282 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16581AlertDialog6oU6zVQ(@NotNull final Function0<Unit> onDismissRequest, @NotNull final Function2<? super Composer, ? super Integer, Unit> confirmButton, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Shape shape, long j, long j2, @Nullable DialogProperties dialogProperties, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i9;
        Shape shape2;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape medium;
        long jM16680getSurface0d7_KjU;
        long jM16694contentColorForek8zF_U;
        Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        long j3;
        long j5;
        final int i10;
        Function2<? super Composer, ? super Integer, Unit> function29;
        DialogProperties dialogProperties2;
        Modifier modifier4;
        final DialogProperties dialogProperties3;
        Composer composer2;
        final long j6;
        final long j7;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Modifier modifier5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-606536823);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onDismissRequest) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(confirmButton) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    function24 = function2;
                    i4 |= composerStartRestartGroup.changed(function24) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 == 0) {
                    if ((i & 57344) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changed(function25) ? 16384 : 8192;
                    }
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                        i8 = 57344;
                        function26 = function23;
                    } else {
                        i8 = 57344;
                        function26 = function23;
                        if ((i & 458752) == 0) {
                            i4 |= composerStartRestartGroup.changed(function26) ? 131072 : 65536;
                        }
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i9 = 458752;
                            shape2 = shape;
                            int i12 = composerStartRestartGroup.changed(shape2) ? 1048576 : 524288;
                            i4 |= i12;
                        } else {
                            i9 = 458752;
                            shape2 = shape;
                        }
                        i4 |= i12;
                    } else {
                        i9 = 458752;
                        shape2 = shape;
                    }
                    if ((i & 29360128) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j)) ? 8388608 : 4194304;
                    }
                    if ((i & 234881024) == 0) {
                        i4 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j2)) ? 67108864 : 33554432;
                    }
                    if ((i & 1879048192) == 0) {
                        i4 |= ((i2 & 512) == 0 && composerStartRestartGroup.changed(dialogProperties)) ? 536870912 : 268435456;
                    }
                    if ((1533916891 & i4) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier6 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                function24 = null;
                            }
                            if (i6 != 0) {
                                function25 = null;
                            }
                            function27 = i7 == 0 ? function26 : null;
                            if ((i2 & 64) == 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i4 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) == 0) {
                                jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                i4 &= -29360129;
                            } else {
                                jM16680getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) == 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 21) & 14);
                                i4 = (-234881025) & i4;
                            } else {
                                jM16694contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 512) == 0) {
                                modifier3 = modifier6;
                                function28 = function24;
                                j3 = jM16680getSurface0d7_KjU;
                                j5 = jM16694contentColorForek8zF_U;
                                i10 = i4 & (-1879048193);
                                function29 = function25;
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    modifier4 = modifier3;
                                } else {
                                    modifier4 = modifier3;
                                    ComposerKt.traceEventStart(-606536823, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                                }
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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
                                    public final void invoke(@Nullable Composer composer3, int i13) {
                                        if ((i13 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1849673151, i13, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:77)");
                                        }
                                        float f = 8;
                                        Modifier modifierM15855paddingVpY3zN4 = PaddingKt.m15855paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(2));
                                        final Function2<Composer, Integer, Unit> function213 = function28;
                                        final int i14 = i10;
                                        final Function2<Composer, Integer, Unit> function214 = confirmButton;
                                        composer3.startReplaceableGroup(733328855);
                                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer3, 0, -1323940314);
                                        Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15855paddingVpY3zN4);
                                        if (composer3.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                        composer3.startReplaceableGroup(-2137368960);
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer3.startReplaceableGroup(-434861445);
                                        AlertDialogKt.m16580AlertDialogFlowRowixp7dh8(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(12), ComposableLambdaKt.composableLambda(composer3, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                            public final void invoke(@Nullable Composer composer4, int i15) {
                                                if ((i15 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1789213604, i15, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:83)");
                                                }
                                                Function2<Composer, Integer, Unit> function215 = function213;
                                                composer4.startReplaceableGroup(-1046483318);
                                                if (function215 != null) {
                                                    function215.invoke(composer4, Integer.valueOf((i14 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer4.endReplaceableGroup();
                                                if (AbstractC1038a.m1196A(composer4, (i14 >> 3) & 14, function214)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer3, 438);
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                int i13 = (i10 & 14) | 48 | (i10 & 896);
                                int i14 = i10 >> 3;
                                int i15 = (i14 & 234881024) | i13 | (i14 & 7168) | (i14 & i8) | (i14 & i9) | (i14 & 3670016) | (i14 & 29360128);
                                Modifier modifier7 = modifier4;
                                Function2<? super Composer, ? super Integer, Unit> function213 = function28;
                                m16582AlertDialogwqdebIU(onDismissRequest, composableLambda, modifier7, function29, function27, medium, j3, j5, dialogProperties2, composerStartRestartGroup, i15, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                dialogProperties3 = dialogProperties2;
                                composer2 = composerStartRestartGroup;
                                j6 = j5;
                                j7 = j3;
                                function210 = function27;
                                shape3 = medium;
                                function211 = function213;
                                function212 = function29;
                                modifier5 = modifier7;
                            } else {
                                modifier3 = modifier6;
                                function28 = function24;
                                j3 = jM16680getSurface0d7_KjU;
                                j5 = jM16694contentColorForek8zF_U;
                                i10 = i4;
                                function29 = function25;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i4 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i4 &= -1879048193;
                            }
                            i10 = i4;
                            modifier3 = modifier2;
                            function28 = function24;
                            function27 = function26;
                            function29 = function25;
                            medium = shape2;
                            j3 = j;
                            j5 = j2;
                        }
                        dialogProperties2 = dialogProperties;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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
                            public final void invoke(@Nullable Composer composer3, int i132) {
                                if ((i132 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1849673151, i132, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:77)");
                                }
                                float f = 8;
                                Modifier modifierM15855paddingVpY3zN4 = PaddingKt.m15855paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function2132 = function28;
                                final int i142 = i10;
                                final Function2<? super Composer, ? super Integer, Unit> function214 = confirmButton;
                                composer3.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer3, 0, -1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15855paddingVpY3zN4);
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                composer3.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(-434861445);
                                AlertDialogKt.m16580AlertDialogFlowRowixp7dh8(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(12), ComposableLambdaKt.composableLambda(composer3, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                    public final void invoke(@Nullable Composer composer4, int i152) {
                                        if ((i152 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1789213604, i152, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:83)");
                                        }
                                        Function2<Composer, Integer, Unit> function215 = function2132;
                                        composer4.startReplaceableGroup(-1046483318);
                                        if (function215 != null) {
                                            function215.invoke(composer4, Integer.valueOf((i142 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer4.endReplaceableGroup();
                                        if (AbstractC1038a.m1196A(composer4, (i142 >> 3) & 14, function214)) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 438);
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i132 = (i10 & 14) | 48 | (i10 & 896);
                        int i142 = i10 >> 3;
                        int i152 = (i142 & 234881024) | i132 | (i142 & 7168) | (i142 & i8) | (i142 & i9) | (i142 & 3670016) | (i142 & 29360128);
                        Modifier modifier72 = modifier4;
                        Function2<? super Composer, ? super Integer, Unit> function2132 = function28;
                        m16582AlertDialogwqdebIU(onDismissRequest, composableLambda2, modifier72, function29, function27, medium, j3, j5, dialogProperties2, composerStartRestartGroup, i152, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        dialogProperties3 = dialogProperties2;
                        composer2 = composerStartRestartGroup;
                        j6 = j5;
                        j7 = j3;
                        function210 = function27;
                        shape3 = medium;
                        function211 = function2132;
                        function212 = function29;
                        modifier5 = modifier72;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        dialogProperties3 = dialogProperties;
                        modifier5 = modifier2;
                        function211 = function24;
                        function210 = function26;
                        function212 = function25;
                        composer2 = composerStartRestartGroup;
                        shape3 = shape2;
                        j7 = j;
                        j6 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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

                        public final void invoke(@Nullable Composer composer3, int i16) {
                            AndroidAlertDialog_androidKt.m16581AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier5, function211, function212, function210, shape3, j7, j6, dialogProperties3, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 24576;
                function25 = function22;
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) == 0) {
                }
                if ((i & 234881024) == 0) {
                }
                if ((i & 1879048192) == 0) {
                }
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if ((i2 & 256) == 0) {
                        }
                        if ((i2 & 512) == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function24 = function2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function25 = function22;
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function24 = function2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function25 = function22;
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0231 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16582AlertDialogwqdebIU(@NotNull final Function0<Unit> onDismissRequest, @NotNull final Function2<? super Composer, ? super Integer, Unit> buttons, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Shape shape, long j, long j2, @Nullable DialogProperties dialogProperties, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape medium;
        long jM16680getSurface0d7_KjU;
        int i7;
        DialogProperties dialogProperties2;
        long jM16694contentColorForek8zF_U;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape2;
        DialogProperties dialogProperties3;
        final int i8;
        final long j3;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final long j5;
        Composer composer2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Shape shape3;
        final long j6;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer composerStartRestartGroup = composer.startRestartGroup(1035523925);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onDismissRequest) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(buttons) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    function23 = function2;
                    i4 |= composerStartRestartGroup.changed(function23) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 == 0) {
                    if ((57344 & i) == 0) {
                        function24 = function22;
                        i4 |= composerStartRestartGroup.changed(function24) ? 16384 : 8192;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            medium = shape;
                            int i10 = composerStartRestartGroup.changed(medium) ? 131072 : 65536;
                            i4 |= i10;
                        } else {
                            medium = shape;
                        }
                        i4 |= i10;
                    } else {
                        medium = shape;
                    }
                    if ((3670016 & i) != 0) {
                        jM16680getSurface0d7_KjU = j;
                        i7 = i4 | (((i2 & 64) == 0 && composerStartRestartGroup.changed(jM16680getSurface0d7_KjU)) ? 1048576 : 524288);
                    } else {
                        jM16680getSurface0d7_KjU = j;
                        i7 = i4;
                    }
                    if ((i & 29360128) == 0) {
                        i7 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    }
                    if ((i & 234881024) != 0) {
                        if ((i2 & 256) == 0) {
                            dialogProperties2 = dialogProperties;
                            int i11 = composerStartRestartGroup.changed(dialogProperties2) ? 67108864 : 33554432;
                            i7 |= i11;
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        i7 |= i11;
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    if ((i7 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function23 = null;
                            }
                            if (i6 != 0) {
                                function24 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i7 &= -458753;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 64) != 0) {
                                jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                i7 &= -3670017;
                            }
                            if ((i2 & 128) == 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i7 >> 18) & 14);
                                i7 &= -29360129;
                            } else {
                                jM16694contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) == 0) {
                                dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                                i7 &= -234881025;
                                function25 = function23;
                                shape2 = medium;
                            } else {
                                function25 = function23;
                                shape2 = medium;
                                dialogProperties3 = dialogProperties2;
                            }
                            i8 = i7;
                            j3 = jM16680getSurface0d7_KjU;
                            modifier3 = modifier2;
                            function26 = function24;
                            j5 = jM16694contentColorForek8zF_U;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i7 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i7 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i7 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i7 &= -234881025;
                            }
                            function25 = function23;
                            shape2 = medium;
                            dialogProperties3 = dialogProperties2;
                            i8 = i7;
                            j3 = jM16680getSurface0d7_KjU;
                            modifier3 = modifier2;
                            function26 = function24;
                            j5 = j2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i8, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        DialogProperties dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                            public final void invoke(@Nullable Composer composer3, int i12) {
                                if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1787418772, i12, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:139)");
                                }
                                Function2<Composer, Integer, Unit> function29 = buttons;
                                Modifier modifier5 = modifier3;
                                Function2<Composer, Integer, Unit> function210 = function25;
                                Function2<Composer, Integer, Unit> function211 = function26;
                                Shape shape4 = shape2;
                                long j8 = j3;
                                long j9 = j5;
                                int i13 = i8;
                                AlertDialogKt.m16579AlertDialogContentWMdw5o4(function29, modifier5, function210, function211, shape4, j8, j9, composer3, ((i13 >> 3) & 14) | ((i13 >> 3) & 112) | ((i13 >> 3) & 896) | ((i13 >> 3) & 7168) | ((i13 >> 3) & 57344) | ((i13 >> 3) & 458752) | ((i13 >> 3) & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                        dialogProperties2 = dialogProperties4;
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        function27 = function25;
                        function28 = function26;
                        shape3 = shape2;
                        j6 = j3;
                        j7 = j5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function27 = function23;
                        j6 = jM16680getSurface0d7_KjU;
                        modifier4 = modifier2;
                        function28 = function24;
                        shape3 = medium;
                        composer2 = composerStartRestartGroup;
                        j7 = j2;
                    }
                    final DialogProperties dialogProperties5 = dialogProperties2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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

                        public final void invoke(@Nullable Composer composer3, int i12) {
                            AndroidAlertDialog_androidKt.m16582AlertDialogwqdebIU(onDismissRequest, buttons, modifier4, function27, function28, shape3, j6, j7, dialogProperties5, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 24576;
                function24 = function22;
                if ((458752 & i) != 0) {
                }
                if ((3670016 & i) != 0) {
                }
                if ((i & 29360128) == 0) {
                }
                if ((i & 234881024) != 0) {
                }
                if ((i7 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if ((i2 & 64) != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if ((i2 & 256) == 0) {
                        }
                        i8 = i7;
                        j3 = jM16680getSurface0d7_KjU;
                        modifier3 = modifier2;
                        function26 = function24;
                        j5 = jM16694contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        DialogProperties dialogProperties42 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties42, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                            public final void invoke(@Nullable Composer composer3, int i12) {
                                if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1787418772, i12, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:139)");
                                }
                                Function2<Composer, Integer, Unit> function29 = buttons;
                                Modifier modifier5 = modifier3;
                                Function2<Composer, Integer, Unit> function210 = function25;
                                Function2<Composer, Integer, Unit> function211 = function26;
                                Shape shape4 = shape2;
                                long j8 = j3;
                                long j9 = j5;
                                int i13 = i8;
                                AlertDialogKt.m16579AlertDialogContentWMdw5o4(function29, modifier5, function210, function211, shape4, j8, j9, composer3, ((i13 >> 3) & 14) | ((i13 >> 3) & 112) | ((i13 >> 3) & 896) | ((i13 >> 3) & 7168) | ((i13 >> 3) & 57344) | ((i13 >> 3) & 458752) | ((i13 >> 3) & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                        dialogProperties2 = dialogProperties42;
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        function27 = function25;
                        function28 = function26;
                        shape3 = shape2;
                        j6 = j3;
                        j7 = j5;
                    }
                }
                final DialogProperties dialogProperties52 = dialogProperties2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function23 = function2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function24 = function22;
            if ((458752 & i) != 0) {
            }
            if ((3670016 & i) != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) != 0) {
            }
            if ((i7 & 191739611) == 38347922) {
            }
            final DialogProperties dialogProperties522 = dialogProperties2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function23 = function2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function24 = function22;
        if ((458752 & i) != 0) {
        }
        if ((3670016 & i) != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) != 0) {
        }
        if ((i7 & 191739611) == 38347922) {
        }
        final DialogProperties dialogProperties5222 = dialogProperties2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
