package androidx.compose.material3;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a©\u0001\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a8\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "MaxWidth", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "MinWidth", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AlertDialogKt {

    @NotNull
    private static final PaddingValues DialogPadding;

    @NotNull
    private static final PaddingValues IconPadding;

    @NotNull
    private static final PaddingValues TextPadding;

    @NotNull
    private static final PaddingValues TitlePadding;
    private static final float MinWidth = C2256Dp.m20968constructorimpl(280);
    private static final float MaxWidth = C2256Dp.m20968constructorimpl(560);

    static {
        float f = 24;
        DialogPadding = PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(f));
        float f4 = 16;
        IconPadding = PaddingKt.m15851PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(f4), 7, null);
        TitlePadding = PaddingKt.m15851PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(f4), 7, null);
        TextPadding = PaddingKt.m15851PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(f), 7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x020a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0108  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16984AlertDialogContent4hvqGtA(@NotNull final Function2<? super Composer, ? super Integer, Unit> buttons, @Nullable Modifier modifier, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, @NotNull final Shape shape, final long j, final float f, final long j2, final long j3, final long j5, final long j6, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        long j7;
        int i6;
        long j8;
        int i7;
        int i8;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Composer composerStartRestartGroup = composer.startRestartGroup(1522575799);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(buttons) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        int i10 = i4 & 2;
        if (i10 != 0) {
            i5 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i4 & 4) == 0) {
                i5 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function24 = function2;
                    i5 |= composerStartRestartGroup.changed(function24) ? 256 : 128;
                }
                if ((i4 & 8) != 0) {
                    i5 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        function25 = function22;
                        i5 |= composerStartRestartGroup.changed(function25) ? 2048 : 1024;
                    }
                    if ((i4 & 16) == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i & 57344) == 0) {
                            function26 = function23;
                            i5 |= composerStartRestartGroup.changed(function26) ? 16384 : 8192;
                        }
                        if ((i4 & 32) == 0) {
                            i9 = (i & 458752) == 0 ? composerStartRestartGroup.changed(shape) ? 131072 : 65536 : 196608;
                            if ((i4 & 64) == 0) {
                                i5 |= 1572864;
                            } else if ((i & 3670016) == 0) {
                                i5 |= composerStartRestartGroup.changed(j) ? 1048576 : 524288;
                            }
                            if ((i4 & 128) == 0) {
                                i5 |= 12582912;
                            } else {
                                if ((i & 29360128) == 0) {
                                    i5 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                                }
                                if ((i4 & 256) != 0) {
                                    i5 |= 100663296;
                                    j7 = j2;
                                } else {
                                    j7 = j2;
                                    if ((i & 234881024) == 0) {
                                        i5 |= composerStartRestartGroup.changed(j7) ? 67108864 : 33554432;
                                    }
                                }
                                if ((i4 & 512) == 0) {
                                    if ((i & 1879048192) == 0) {
                                        i6 = i5 | (composerStartRestartGroup.changed(j3) ? 536870912 : 268435456);
                                    }
                                    if ((i4 & 1024) == 0) {
                                        i7 = i2 | 6;
                                        j8 = j5;
                                    } else {
                                        j8 = j5;
                                        if ((i2 & 14) == 0) {
                                            i7 = i2 | (composerStartRestartGroup.changed(j8) ? 4 : 2);
                                        } else {
                                            i7 = i2;
                                        }
                                    }
                                    int i11 = i7;
                                    if ((i4 & 2048) == 0) {
                                        i8 = i11 | 48;
                                    } else if ((i2 & 112) == 0) {
                                        i8 = i11 | (composerStartRestartGroup.changed(j6) ? 32 : 16);
                                    } else {
                                        i8 = i11;
                                    }
                                    if ((1533916891 & i6) != 306783378 && (i8 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        composer2 = composerStartRestartGroup;
                                        modifier3 = modifier2;
                                    } else {
                                        Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1522575799, i6, i8, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:38)");
                                        }
                                        composer2 = composerStartRestartGroup;
                                        final int i12 = i6;
                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
                                        final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
                                        final long j9 = j8;
                                        final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                                        final long j10 = j7;
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
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
                                                    ComposerKt.traceEventStart(-2126308228, i13, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
                                                }
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m15903sizeInqDBjuR0$default(companion, AlertDialogKt.MinWidth, 0.0f, AlertDialogKt.MaxWidth, 0.0f, 10, null), AlertDialogKt.DialogPadding);
                                                final Function2<Composer, Integer, Unit> function210 = function27;
                                                final Function2<Composer, Integer, Unit> function211 = function28;
                                                final Function2<Composer, Integer, Unit> function212 = function29;
                                                long j11 = j3;
                                                final int i14 = i12;
                                                long j12 = j9;
                                                long j13 = j6;
                                                long j14 = j10;
                                                final Function2<Composer, Integer, Unit> function213 = buttons;
                                                composer3.startReplaceableGroup(-483455358);
                                                Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, top, composer3, 0, -1323940314);
                                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
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
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-1163856341);
                                                final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                composer3.startReplaceableGroup(-1370717838);
                                                composer3.startReplaceableGroup(76440864);
                                                if (function210 != null) {
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j11))}, ComposableLambdaKt.composableLambda(composer3, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
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
                                                                ComposerKt.traceEventStart(934657765, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                                            }
                                                            ColumnScope columnScope = columnScopeInstance;
                                                            Modifier modifierPadding2 = PaddingKt.padding(Modifier.INSTANCE, AlertDialogKt.IconPadding);
                                                            Alignment.Companion companion4 = Alignment.INSTANCE;
                                                            Modifier modifierAlign = columnScope.align(modifierPadding2, companion4.getCenterHorizontally());
                                                            Function2<Composer, Integer, Unit> function214 = function210;
                                                            int i16 = i14;
                                                            composer4.startReplaceableGroup(733328855);
                                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion4, false, composer4, 0, -1323940314);
                                                            Density density2 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                            LayoutDirection layoutDirection2 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                            Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                                            if (composer4.getApplier() == null) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer4.startReusableNode();
                                                            if (composer4.getInserting()) {
                                                                composer4.createNode(constructor2);
                                                            } else {
                                                                composer4.useNode();
                                                            }
                                                            composer4.disableReusing();
                                                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                                            AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composer4, composer4), composer4, 2058660585);
                                                            composer4.startReplaceableGroup(-2137368960);
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            composer4.startReplaceableGroup(-1552328981);
                                                            if (AbstractC1038a.m1199D(composer4, (i16 >> 6) & 14, function214)) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }), composer3, 56);
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                composer3.startReplaceableGroup(76441259);
                                                if (function211 != null) {
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j12))}, ComposableLambdaKt.composableLambda(composer3, 1845262876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
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
                                                                ComposerKt.traceEventStart(1845262876, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
                                                            }
                                                            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer4, 6), DialogTokens.INSTANCE.getHeadlineFont());
                                                            final ColumnScope columnScope = columnScopeInstance;
                                                            final Function2<Composer, Integer, Unit> function214 = function210;
                                                            final Function2<Composer, Integer, Unit> function215 = function211;
                                                            final int i16 = i14;
                                                            TextKt.ProvideTextStyle(textStyleFromToken, ComposableLambdaKt.composableLambda(composer4, 483464909, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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
                                                                public final void invoke(@Nullable Composer composer5, int i17) {
                                                                    if ((i17 & 11) == 2 && composer5.getSkipping()) {
                                                                        composer5.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(483464909, i17, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                                                    }
                                                                    Modifier modifierAlign = columnScope.align(PaddingKt.padding(Modifier.INSTANCE, AlertDialogKt.TitlePadding), function214 == null ? Alignment.INSTANCE.getStart() : Alignment.INSTANCE.getCenterHorizontally());
                                                                    Function2<Composer, Integer, Unit> function216 = function215;
                                                                    int i18 = i16;
                                                                    composer5.startReplaceableGroup(733328855);
                                                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer5, 0, -1323940314);
                                                                    Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                    Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                                                    if (composer5.getApplier() == null) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor2);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    composer5.disableReusing();
                                                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                                                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 2058660585);
                                                                    composer5.startReplaceableGroup(-2137368960);
                                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                    composer5.startReplaceableGroup(1708709843);
                                                                    if (AbstractC1038a.m1199D(composer5, (i18 >> 9) & 14, function216)) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }), composer4, 48);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }), composer3, 56);
                                                    Unit unit2 = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                composer3.startReplaceableGroup(76442209);
                                                if (function212 != null) {
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j13))}, ComposableLambdaKt.composableLambda(composer3, 613970333, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
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
                                                                ComposerKt.traceEventStart(613970333, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:96)");
                                                            }
                                                            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer4, 6), DialogTokens.INSTANCE.getSupportingTextFont());
                                                            final ColumnScope columnScope = columnScopeInstance;
                                                            final Function2<Composer, Integer, Unit> function214 = function212;
                                                            final int i16 = i14;
                                                            TextKt.ProvideTextStyle(textStyleFromToken, ComposableLambdaKt.composableLambda(composer4, -747827634, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1.1
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
                                                                public final void invoke(@Nullable Composer composer5, int i17) {
                                                                    if ((i17 & 11) == 2 && composer5.getSkipping()) {
                                                                        composer5.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-747827634, i17, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:99)");
                                                                    }
                                                                    ColumnScope columnScope2 = columnScope;
                                                                    Modifier modifierPadding2 = PaddingKt.padding(columnScope2.weight(Modifier.INSTANCE, 1.0f, false), AlertDialogKt.TextPadding);
                                                                    Alignment.Companion companion4 = Alignment.INSTANCE;
                                                                    Modifier modifierAlign = columnScope2.align(modifierPadding2, companion4.getStart());
                                                                    Function2<Composer, Integer, Unit> function215 = function214;
                                                                    int i18 = i16;
                                                                    composer5.startReplaceableGroup(733328855);
                                                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion4, false, composer5, 0, -1323940314);
                                                                    Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                                    Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                                                    if (composer5.getApplier() == null) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor2);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    composer5.disableReusing();
                                                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                                                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 2058660585);
                                                                    composer5.startReplaceableGroup(-2137368960);
                                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                    composer5.startReplaceableGroup(477417300);
                                                                    if (AbstractC1038a.m1199D(composer5, (i18 >> 12) & 14, function215)) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }), composer4, 48);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }), composer3, 56);
                                                    Unit unit3 = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                Modifier modifierAlign = columnScopeInstance.align(companion, companion2.getEnd());
                                                composer3.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer3, 0, -1323940314);
                                                Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                                LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                                if (composer3.getApplier() == null) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor2);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-2137368960);
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer3.startReplaceableGroup(1902704376);
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j14))}, ComposableLambdaKt.composableLambda(composer3, -433542216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$4$1
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
                                                            ComposerKt.traceEventStart(-433542216, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:112)");
                                                        }
                                                        TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer4, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer4, (i14 << 3) & 112);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 56);
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
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
                                        int i13 = i12 >> 12;
                                        Modifier modifier5 = modifier4;
                                        SurfaceKt.m17325SurfaceT9BRK9s(modifier5, shape, j, 0L, f, 0.0f, null, composableLambda, composer2, ((i12 >> 3) & 14) | 12582912 | (i13 & 112) | (i13 & 896) | ((i12 >> 9) & 57344), 104);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier5;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                        return;
                                    }
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
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

                                        public final void invoke(@Nullable Composer composer3, int i14) {
                                            AlertDialogKt.m16984AlertDialogContent4hvqGtA(buttons, modifier3, function2, function22, function23, shape, j, f, j2, j3, j5, j6, composer3, i | 1, i2, i4);
                                        }
                                    });
                                    return;
                                }
                                i5 |= DriveFile.MODE_READ_WRITE;
                                i6 = i5;
                                if ((i4 & 1024) == 0) {
                                }
                                int i112 = i7;
                                if ((i4 & 2048) == 0) {
                                }
                                if ((1533916891 & i6) != 306783378) {
                                    if (i10 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composer2 = composerStartRestartGroup;
                                    final int i122 = i6;
                                    final Function2<? super Composer, ? super Integer, Unit> function272 = function24;
                                    final Function2<? super Composer, ? super Integer, Unit> function282 = function25;
                                    final long j92 = j8;
                                    final Function2<? super Composer, ? super Integer, Unit> function292 = function26;
                                    final long j102 = j7;
                                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
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
                                                ComposerKt.traceEventStart(-2126308228, i132, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m15903sizeInqDBjuR0$default(companion, AlertDialogKt.MinWidth, 0.0f, AlertDialogKt.MaxWidth, 0.0f, 10, null), AlertDialogKt.DialogPadding);
                                            final Function2<? super Composer, ? super Integer, Unit> function210 = function272;
                                            final Function2<? super Composer, ? super Integer, Unit> function211 = function282;
                                            final Function2<? super Composer, ? super Integer, Unit> function212 = function292;
                                            long j11 = j3;
                                            final int i14 = i122;
                                            long j12 = j92;
                                            long j13 = j6;
                                            long j14 = j102;
                                            final Function2<? super Composer, ? super Integer, Unit> function213 = buttons;
                                            composer3.startReplaceableGroup(-483455358);
                                            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                                            Alignment.Companion companion2 = Alignment.INSTANCE;
                                            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, top, composer3, 0, -1323940314);
                                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-1163856341);
                                            final ColumnScope columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            composer3.startReplaceableGroup(-1370717838);
                                            composer3.startReplaceableGroup(76440864);
                                            if (function210 != null) {
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j11))}, ComposableLambdaKt.composableLambda(composer3, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
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
                                                            ComposerKt.traceEventStart(934657765, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                                        }
                                                        ColumnScope columnScope = columnScopeInstance;
                                                        Modifier modifierPadding2 = PaddingKt.padding(Modifier.INSTANCE, AlertDialogKt.IconPadding);
                                                        Alignment.Companion companion4 = Alignment.INSTANCE;
                                                        Modifier modifierAlign = columnScope.align(modifierPadding2, companion4.getCenterHorizontally());
                                                        Function2<Composer, Integer, Unit> function214 = function210;
                                                        int i16 = i14;
                                                        composer4.startReplaceableGroup(733328855);
                                                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion4, false, composer4, 0, -1323940314);
                                                        Density density2 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                        LayoutDirection layoutDirection2 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                                        if (composer4.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor2);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        composer4.disableReusing();
                                                        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                                        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                                        AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composer4, composer4), composer4, 2058660585);
                                                        composer4.startReplaceableGroup(-2137368960);
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer4.startReplaceableGroup(-1552328981);
                                                        if (AbstractC1038a.m1199D(composer4, (i16 >> 6) & 14, function214)) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 56);
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            composer3.startReplaceableGroup(76441259);
                                            if (function211 != null) {
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j12))}, ComposableLambdaKt.composableLambda(composer3, 1845262876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
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
                                                            ComposerKt.traceEventStart(1845262876, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
                                                        }
                                                        TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer4, 6), DialogTokens.INSTANCE.getHeadlineFont());
                                                        final ColumnScope columnScope = columnScopeInstance;
                                                        final Function2<? super Composer, ? super Integer, Unit> function214 = function210;
                                                        final Function2<? super Composer, ? super Integer, Unit> function215 = function211;
                                                        final int i16 = i14;
                                                        TextKt.ProvideTextStyle(textStyleFromToken, ComposableLambdaKt.composableLambda(composer4, 483464909, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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
                                                            public final void invoke(@Nullable Composer composer5, int i17) {
                                                                if ((i17 & 11) == 2 && composer5.getSkipping()) {
                                                                    composer5.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(483464909, i17, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                                                }
                                                                Modifier modifierAlign = columnScope.align(PaddingKt.padding(Modifier.INSTANCE, AlertDialogKt.TitlePadding), function214 == null ? Alignment.INSTANCE.getStart() : Alignment.INSTANCE.getCenterHorizontally());
                                                                Function2<Composer, Integer, Unit> function216 = function215;
                                                                int i18 = i16;
                                                                composer5.startReplaceableGroup(733328855);
                                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer5, 0, -1323940314);
                                                                Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                                LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                                                if (composer5.getApplier() == null) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor2);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                composer5.disableReusing();
                                                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                                                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 2058660585);
                                                                composer5.startReplaceableGroup(-2137368960);
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                composer5.startReplaceableGroup(1708709843);
                                                                if (AbstractC1038a.m1199D(composer5, (i18 >> 9) & 14, function216)) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }), composer4, 48);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 56);
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            composer3.startReplaceableGroup(76442209);
                                            if (function212 != null) {
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j13))}, ComposableLambdaKt.composableLambda(composer3, 613970333, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
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
                                                            ComposerKt.traceEventStart(613970333, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:96)");
                                                        }
                                                        TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer4, 6), DialogTokens.INSTANCE.getSupportingTextFont());
                                                        final ColumnScope columnScope = columnScopeInstance;
                                                        final Function2<? super Composer, ? super Integer, Unit> function214 = function212;
                                                        final int i16 = i14;
                                                        TextKt.ProvideTextStyle(textStyleFromToken, ComposableLambdaKt.composableLambda(composer4, -747827634, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1.1
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
                                                            public final void invoke(@Nullable Composer composer5, int i17) {
                                                                if ((i17 & 11) == 2 && composer5.getSkipping()) {
                                                                    composer5.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-747827634, i17, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:99)");
                                                                }
                                                                ColumnScope columnScope2 = columnScope;
                                                                Modifier modifierPadding2 = PaddingKt.padding(columnScope2.weight(Modifier.INSTANCE, 1.0f, false), AlertDialogKt.TextPadding);
                                                                Alignment.Companion companion4 = Alignment.INSTANCE;
                                                                Modifier modifierAlign = columnScope2.align(modifierPadding2, companion4.getStart());
                                                                Function2<Composer, Integer, Unit> function215 = function214;
                                                                int i18 = i16;
                                                                composer5.startReplaceableGroup(733328855);
                                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion4, false, composer5, 0, -1323940314);
                                                                Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                                                LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                                Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                                                if (composer5.getApplier() == null) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor2);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                composer5.disableReusing();
                                                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                                                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 2058660585);
                                                                composer5.startReplaceableGroup(-2137368960);
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                composer5.startReplaceableGroup(477417300);
                                                                if (AbstractC1038a.m1199D(composer5, (i18 >> 12) & 14, function215)) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }), composer4, 48);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 56);
                                                Unit unit3 = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            Modifier modifierAlign = columnScopeInstance.align(companion, companion2.getEnd());
                                            composer3.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer3, 0, -1323940314);
                                            Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
                                            if (composer3.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer3.startReplaceableGroup(1902704376);
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j14))}, ComposableLambdaKt.composableLambda(composer3, -433542216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$4$1
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
                                                        ComposerKt.traceEventStart(-433542216, i15, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:112)");
                                                    }
                                                    TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer4, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer4, (i14 << 3) & 112);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
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
                                    int i132 = i122 >> 12;
                                    Modifier modifier52 = modifier4;
                                    SurfaceKt.m17325SurfaceT9BRK9s(modifier52, shape, j, 0L, f, 0.0f, null, composableLambda2, composer2, ((i122 >> 3) & 14) | 12582912 | (i132 & 112) | (i132 & 896) | ((i122 >> 9) & 57344), 104);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    modifier3 = modifier52;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                }
                            }
                            if ((i4 & 256) != 0) {
                            }
                            if ((i4 & 512) == 0) {
                            }
                            i6 = i5;
                            if ((i4 & 1024) == 0) {
                            }
                            int i1122 = i7;
                            if ((i4 & 2048) == 0) {
                            }
                            if ((1533916891 & i6) != 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i5 |= i9;
                        if ((i4 & 64) == 0) {
                        }
                        if ((i4 & 128) == 0) {
                        }
                        if ((i4 & 256) != 0) {
                        }
                        if ((i4 & 512) == 0) {
                        }
                        i6 = i5;
                        if ((i4 & 1024) == 0) {
                        }
                        int i11222 = i7;
                        if ((i4 & 2048) == 0) {
                        }
                        if ((1533916891 & i6) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    function26 = function23;
                    if ((i4 & 32) == 0) {
                    }
                    i5 |= i9;
                    if ((i4 & 64) == 0) {
                    }
                    if ((i4 & 128) == 0) {
                    }
                    if ((i4 & 256) != 0) {
                    }
                    if ((i4 & 512) == 0) {
                    }
                    i6 = i5;
                    if ((i4 & 1024) == 0) {
                    }
                    int i112222 = i7;
                    if ((i4 & 2048) == 0) {
                    }
                    if ((1533916891 & i6) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function25 = function22;
                if ((i4 & 16) == 0) {
                }
                function26 = function23;
                if ((i4 & 32) == 0) {
                }
                i5 |= i9;
                if ((i4 & 64) == 0) {
                }
                if ((i4 & 128) == 0) {
                }
                if ((i4 & 256) != 0) {
                }
                if ((i4 & 512) == 0) {
                }
                i6 = i5;
                if ((i4 & 1024) == 0) {
                }
                int i1122222 = i7;
                if ((i4 & 2048) == 0) {
                }
                if ((1533916891 & i6) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function24 = function2;
            if ((i4 & 8) != 0) {
            }
            function25 = function22;
            if ((i4 & 16) == 0) {
            }
            function26 = function23;
            if ((i4 & 32) == 0) {
            }
            i5 |= i9;
            if ((i4 & 64) == 0) {
            }
            if ((i4 & 128) == 0) {
            }
            if ((i4 & 256) != 0) {
            }
            if ((i4 & 512) == 0) {
            }
            i6 = i5;
            if ((i4 & 1024) == 0) {
            }
            int i11222222 = i7;
            if ((i4 & 2048) == 0) {
            }
            if ((1533916891 & i6) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i4 & 4) == 0) {
        }
        function24 = function2;
        if ((i4 & 8) != 0) {
        }
        function25 = function22;
        if ((i4 & 16) == 0) {
        }
        function26 = function23;
        if ((i4 & 32) == 0) {
        }
        i5 |= i9;
        if ((i4 & 64) == 0) {
        }
        if ((i4 & 128) == 0) {
        }
        if ((i4 & 256) != 0) {
        }
        if ((i4 & 512) == 0) {
        }
        i6 = i5;
        if ((i4 & 1024) == 0) {
        }
        int i112222222 = i7;
        if ((i4 & 2048) == 0) {
        }
        if ((1533916891 & i6) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m16985AlertDialogFlowRowixp7dh8(final float f, final float f4, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(586821353);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(f4) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:127)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1
                private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f5, long j, Placeable placeable) {
                    if (list.isEmpty()) {
                        return true;
                    }
                    return placeable.getWidth() + (measureScope.mo15540roundToPx0680j_4(f5) + intRef.element) <= Constraints.m20921getMaxWidthimpl(j);
                }

                private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f5, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
                    List<List<Placeable>> list5 = list;
                    if (!list5.isEmpty()) {
                        intRef.element = measureScope.mo15540roundToPx0680j_4(f5) + intRef.element;
                    }
                    list5.add(CollectionsKt.toList(list2));
                    list3.add(Integer.valueOf(intRef2.element));
                    list4.add(Integer.valueOf(intRef.element));
                    intRef.element += intRef2.element;
                    intRef3.element = Math.max(intRef3.element, intRef4.element);
                    list2.clear();
                    intRef4.element = 0;
                    intRef2.element = 0;
                }

                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    Ref.IntRef intRef;
                    Ref.IntRef intRef2;
                    Ref.IntRef intRef3;
                    MeasureScope Layout = measureScope;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = arrayList3;
                    final ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = arrayList4;
                    Ref.IntRef intRef4 = new Ref.IntRef();
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    ArrayList arrayList8 = new ArrayList();
                    Ref.IntRef intRef6 = new Ref.IntRef();
                    Ref.IntRef intRef7 = new Ref.IntRef();
                    Iterator<? extends Measurable> it = measurables.iterator();
                    while (it.hasNext()) {
                        Placeable placeableMo19855measureBRTryo0 = it.next().mo19855measureBRTryo0(j);
                        ArrayList arrayList9 = arrayList8;
                        arrayList8 = arrayList9;
                        if (measure_3p2s80s$canAddToCurrentSequence(arrayList9, intRef6, Layout, f, j, placeableMo19855measureBRTryo0)) {
                            Layout = measureScope;
                            arrayList = arrayList5;
                            arrayList2 = arrayList7;
                            intRef = intRef7;
                            intRef2 = intRef6;
                            intRef3 = intRef5;
                        } else {
                            Layout = measureScope;
                            arrayList = arrayList5;
                            arrayList2 = arrayList7;
                            intRef = intRef7;
                            intRef2 = intRef6;
                            intRef3 = intRef5;
                            measure_3p2s80s$startNewSequence(arrayList, intRef3, Layout, f4, arrayList8, arrayList2, intRef, arrayList6, intRef4, intRef2);
                        }
                        if (!arrayList8.isEmpty()) {
                            intRef2.element = Layout.mo15540roundToPx0680j_4(f) + intRef2.element;
                        }
                        arrayList8.add(placeableMo19855measureBRTryo0);
                        intRef2.element = placeableMo19855measureBRTryo0.getWidth() + intRef2.element;
                        intRef.element = Math.max(intRef.element, placeableMo19855measureBRTryo0.getHeight());
                        intRef5 = intRef3;
                        arrayList7 = arrayList2;
                        intRef7 = intRef;
                        intRef6 = intRef2;
                        arrayList5 = arrayList;
                    }
                    final ArrayList arrayList10 = arrayList5;
                    ArrayList arrayList11 = arrayList7;
                    Ref.IntRef intRef8 = intRef7;
                    Ref.IntRef intRef9 = intRef6;
                    Ref.IntRef intRef10 = intRef5;
                    if (!arrayList8.isEmpty()) {
                        measure_3p2s80s$startNewSequence(arrayList10, intRef10, Layout, f4, arrayList8, arrayList11, intRef8, arrayList6, intRef4, intRef9);
                    }
                    final int iMax = Math.max(intRef4.element, Constraints.m20923getMinWidthimpl(j));
                    int iMax2 = Math.max(intRef10.element, Constraints.m20922getMinHeightimpl(j));
                    final float f5 = f;
                    return MeasureScope.layout$default(measureScope, iMax, iMax2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope layout = placementScope;
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            List<List<Placeable>> list = arrayList10;
                            MeasureScope measureScope2 = measureScope;
                            float f6 = f5;
                            int i4 = iMax;
                            List<Integer> list2 = arrayList6;
                            int i5 = 0;
                            for (Object obj : list) {
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                List list3 = (List) obj;
                                int size = list3.size();
                                int[] iArr = new int[size];
                                int i7 = 0;
                                while (i7 < size) {
                                    iArr[i7] = ((Placeable) list3.get(i7)).getWidth() + (i7 < CollectionsKt.getLastIndex(list3) ? measureScope2.mo15540roundToPx0680j_4(f6) : 0);
                                    i7++;
                                }
                                Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
                                int[] iArr2 = new int[size];
                                for (int i8 = 0; i8 < size; i8++) {
                                    iArr2[i8] = 0;
                                }
                                bottom.arrange(measureScope2, i4, iArr, iArr2);
                                int i9 = 0;
                                for (Object obj2 : list3) {
                                    int i10 = i9 + 1;
                                    if (i9 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    Placeable.PlacementScope.place$default(layout, (Placeable) obj2, iArr2[i9], list2.get(i5).intValue(), 0.0f, 4, null);
                                    layout = placementScope;
                                    i9 = i10;
                                    iArr2 = iArr2;
                                }
                                layout = placementScope;
                                i5 = i6;
                            }
                        }
                    }, 4, null);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.INSTANCE;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
            int i4 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
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
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion2.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
            content.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$2
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

            public final void invoke(@Nullable Composer composer2, int i5) {
                AlertDialogKt.m16985AlertDialogFlowRowixp7dh8(f, f4, content, composer2, i | 1);
            }
        });
    }
}
