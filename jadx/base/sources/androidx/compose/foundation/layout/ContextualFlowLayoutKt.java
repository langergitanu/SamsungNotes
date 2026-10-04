package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.SubcomposeLayoutKt;
import androidx.compose.p109ui.layout.SubcomposeMeasureScope;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r21\u0010\u000e\u001a-\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0084\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u001921\u0010\u000e\u001a-\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u001b\u001a¥\u0001\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0002\b\u00140$2;\u0010&\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010)\u001a¥\u0001\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0002\b\u00140$2;\u0010&\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010+¨\u0006,"}, m13886d2 = {"ContextualFlowColumn", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualColumnMeasureHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualRowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContextualFlowLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextualFlowLayout.kt\nandroidx/compose/foundation/layout/ContextualFlowLayoutKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,562:1\n1225#2,6:563\n1225#2,6:569\n1225#2,6:575\n1225#2,6:581\n1225#2,6:587\n1225#2,6:593\n*S KotlinDebug\n*F\n+ 1 ContextualFlowLayout.kt\nandroidx/compose/foundation/layout/ContextualFlowLayoutKt\n*L\n75#1:563,6\n78#1:569,6\n150#1:575,6\n153#1:581,6\n344#1:587,6\n384#1:593,6\n*E\n"})
public final class ContextualFlowLayoutKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011b  */
    @Composable
    @ExperimentalLayoutApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowColumn(final int i, @Nullable Modifier modifier, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, int i2, int i4, @Nullable ContextualFlowColumnOverflow contextualFlowColumnOverflow, @NotNull final Function4<? super ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Arrangement.Vertical top;
        int i9;
        Arrangement.Horizontal start;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        ContextualFlowColumnOverflow clip;
        boolean z;
        Object objRememberedValue;
        boolean z2;
        final ContextualFlowColumnOverflow contextualFlowColumnOverflow2;
        final Arrangement.Vertical vertical2;
        final int i15;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-588476895);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i16 = i6 & 2;
        if (i16 != 0) {
            i7 |= 48;
        } else {
            if ((i5 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i5 & 384) == 0) {
                    top = vertical;
                    i7 |= composerStartRestartGroup.changed(top) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i5 & 3072) == 0) {
                        start = horizontal;
                        i7 |= composerStartRestartGroup.changed(start) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 != 0) {
                        if ((i5 & 24576) == 0) {
                            i11 = i2;
                            i7 |= composerStartRestartGroup.changed(i11) ? 16384 : 8192;
                        }
                        i12 = i6 & 32;
                        if (i12 != 0) {
                            i7 |= 196608;
                        } else if ((i5 & 196608) == 0) {
                            i7 |= composerStartRestartGroup.changed(i4) ? 131072 : 65536;
                        }
                        i13 = i6 & 64;
                        if (i13 != 0) {
                            i7 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changed(contextualFlowColumnOverflow) ? 1048576 : 524288;
                        }
                        if ((i6 & 128) != 0) {
                            i7 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
                        }
                        if ((4793491 & i7) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i15 = i4;
                            composer2 = composerStartRestartGroup;
                            vertical2 = top;
                            i14 = i11;
                            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            }
                            if (i9 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            i14 = i10 == 0 ? Integer.MAX_VALUE : i11;
                            int i17 = i12 == 0 ? Integer.MAX_VALUE : i4;
                            clip = i13 == 0 ? ContextualFlowColumnOverflow.INSTANCE.getClip() : contextualFlowColumnOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-588476895, i7, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                            }
                            int i18 = 3670016 & i7;
                            z = i18 != 1048576;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            z2 = i18 != 1048576;
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                int i19 = i7 >> 6;
                                Arrangement.Vertical vertical3 = top;
                                Composer composer3 = composerStartRestartGroup;
                                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(vertical3, start, i14, i17, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer4, Integer num2) {
                                        invoke(num.intValue(), flowLineInfo, composer4, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(int i20, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer4, int i21) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(302435318, i21, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                        }
                                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex(), flowLineInfo.getPositionInLine(), flowLineInfo.getMaxCrossAxisSize(), flowLineInfo.getMaxMainAxisSize(), null), Integer.valueOf(i20), composer4, Integer.valueOf((i21 << 3) & 112));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7168) | (i19 & 14) | 12582912 | (i19 & 112) | (i19 & 896) | ((i7 << 15) & 458752)), composer3, (i7 >> 3) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                contextualFlowColumnOverflow2 = clip;
                                vertical2 = vertical3;
                                i15 = i17;
                                composer2 = composer3;
                            }
                        }
                        final Arrangement.Horizontal horizontal2 = start;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final int i20 = i14;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
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

                                public final void invoke(@Nullable Composer composer4, int i21) {
                                    ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal2, i20, i15, contextualFlowColumnOverflow2, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i7 |= 24576;
                    i11 = i2;
                    i12 = i6 & 32;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 64;
                    if (i13 != 0) {
                    }
                    if ((i6 & 128) != 0) {
                    }
                    if ((4793491 & i7) == 4793490) {
                        if (i16 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i182 = 3670016 & i7;
                        if (i182 != 1048576) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            FlowLayoutOverflowState flowLayoutOverflowState2 = (FlowLayoutOverflowState) objRememberedValue;
                            if (i182 != 1048576) {
                            }
                            Object objRememberedValue22 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                            }
                        }
                    }
                    final Arrangement.Horizontal horizontal22 = start;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                start = horizontal;
                i10 = i6 & 16;
                if (i10 != 0) {
                }
                i11 = i2;
                i12 = i6 & 32;
                if (i12 != 0) {
                }
                i13 = i6 & 64;
                if (i13 != 0) {
                }
                if ((i6 & 128) != 0) {
                }
                if ((4793491 & i7) == 4793490) {
                }
                final Arrangement.Horizontal horizontal222 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            top = vertical;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            start = horizontal;
            i10 = i6 & 16;
            if (i10 != 0) {
            }
            i11 = i2;
            i12 = i6 & 32;
            if (i12 != 0) {
            }
            i13 = i6 & 64;
            if (i13 != 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if ((4793491 & i7) == 4793490) {
            }
            final Arrangement.Horizontal horizontal2222 = start;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        top = vertical;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        start = horizontal;
        i10 = i6 & 16;
        if (i10 != 0) {
        }
        i11 = i2;
        i12 = i6 & 32;
        if (i12 != 0) {
        }
        i13 = i6 & 64;
        if (i13 != 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if ((4793491 & i7) == 4793490) {
        }
        final Arrangement.Horizontal horizontal22222 = start;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011b  */
    @Composable
    @ExperimentalLayoutApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowRow(final int i, @Nullable Modifier modifier, @Nullable Arrangement.Horizontal horizontal, @Nullable Arrangement.Vertical vertical, int i2, int i4, @Nullable ContextualFlowRowOverflow contextualFlowRowOverflow, @NotNull final Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Arrangement.Horizontal start;
        int i9;
        Arrangement.Vertical top;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        ContextualFlowRowOverflow clip;
        boolean z;
        Object objRememberedValue;
        boolean z2;
        final ContextualFlowRowOverflow contextualFlowRowOverflow2;
        final Arrangement.Horizontal horizontal2;
        final int i15;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-341770689);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i16 = i6 & 2;
        if (i16 != 0) {
            i7 |= 48;
        } else {
            if ((i5 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i5 & 384) == 0) {
                    start = horizontal;
                    i7 |= composerStartRestartGroup.changed(start) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i5 & 3072) == 0) {
                        top = vertical;
                        i7 |= composerStartRestartGroup.changed(top) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 != 0) {
                        if ((i5 & 24576) == 0) {
                            i11 = i2;
                            i7 |= composerStartRestartGroup.changed(i11) ? 16384 : 8192;
                        }
                        i12 = i6 & 32;
                        if (i12 != 0) {
                            i7 |= 196608;
                        } else if ((i5 & 196608) == 0) {
                            i7 |= composerStartRestartGroup.changed(i4) ? 131072 : 65536;
                        }
                        i13 = i6 & 64;
                        if (i13 != 0) {
                            i7 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changed(contextualFlowRowOverflow) ? 1048576 : 524288;
                        }
                        if ((i6 & 128) != 0) {
                            i7 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
                        }
                        if ((4793491 & i7) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i15 = i4;
                            composer2 = composerStartRestartGroup;
                            horizontal2 = start;
                            i14 = i11;
                            contextualFlowRowOverflow2 = contextualFlowRowOverflow;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if (i9 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            }
                            i14 = i10 == 0 ? Integer.MAX_VALUE : i11;
                            int i17 = i12 == 0 ? Integer.MAX_VALUE : i4;
                            clip = i13 == 0 ? ContextualFlowRowOverflow.INSTANCE.getClip() : contextualFlowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-341770689, i7, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                            }
                            int i18 = 3670016 & i7;
                            z = i18 != 1048576;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            z2 = i18 != 1048576;
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                int i19 = i7 >> 6;
                                Arrangement.Horizontal horizontal3 = start;
                                Composer composer3 = composerStartRestartGroup;
                                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(horizontal3, top, i14, i17, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer4, Integer num2) {
                                        invoke(num.intValue(), flowLineInfo, composer4, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(int i20, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer4, int i21) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-8464804, i21, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                        }
                                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex(), flowLineInfo.getPositionInLine(), flowLineInfo.getMaxMainAxisSize(), flowLineInfo.getMaxCrossAxisSize(), null), Integer.valueOf(i20), composer4, Integer.valueOf((i21 << 3) & 112));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7168) | (i19 & 14) | 12582912 | (i19 & 112) | (i19 & 896) | ((i7 << 15) & 458752)), composer3, (i7 >> 3) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                contextualFlowRowOverflow2 = clip;
                                horizontal2 = horizontal3;
                                i15 = i17;
                                composer2 = composer3;
                            }
                        }
                        final Arrangement.Vertical vertical2 = top;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final int i20 = i14;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
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

                                public final void invoke(@Nullable Composer composer4, int i21) {
                                    ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical2, i20, i15, contextualFlowRowOverflow2, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i7 |= 24576;
                    i11 = i2;
                    i12 = i6 & 32;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 64;
                    if (i13 != 0) {
                    }
                    if ((i6 & 128) != 0) {
                    }
                    if ((4793491 & i7) == 4793490) {
                        if (i16 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i182 = 3670016 & i7;
                        if (i182 != 1048576) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            FlowLayoutOverflowState flowLayoutOverflowState2 = (FlowLayoutOverflowState) objRememberedValue;
                            if (i182 != 1048576) {
                            }
                            Object objRememberedValue22 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                            }
                        }
                    }
                    final Arrangement.Vertical vertical22 = top;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                top = vertical;
                i10 = i6 & 16;
                if (i10 != 0) {
                }
                i11 = i2;
                i12 = i6 & 32;
                if (i12 != 0) {
                }
                i13 = i6 & 64;
                if (i13 != 0) {
                }
                if ((i6 & 128) != 0) {
                }
                if ((4793491 & i7) == 4793490) {
                }
                final Arrangement.Vertical vertical222 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            start = horizontal;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            top = vertical;
            i10 = i6 & 16;
            if (i10 != 0) {
            }
            i11 = i2;
            i12 = i6 & 32;
            if (i12 != 0) {
            }
            i13 = i6 & 64;
            if (i13 != 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if ((4793491 & i7) == 4793490) {
            }
            final Arrangement.Vertical vertical2222 = top;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        start = horizontal;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        top = vertical;
        i10 = i6 & 16;
        if (i10 != 0) {
        }
        i11 = i2;
        i12 = i6 & 32;
        if (i12 != 0) {
        }
        i13 = i6 & 64;
        if (i13 != 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if ((4793491 & i7) == 4793490) {
        }
        final Arrangement.Vertical vertical22222 = top;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    @Composable
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(@NotNull Arrangement.Vertical vertical, @NotNull Arrangement.Horizontal horizontal, int i, int i2, @NotNull FlowLayoutOverflowState flowLayoutOverflowState, int i4, @NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @NotNull Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i5) {
        boolean z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009762916, i5, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:382)");
        }
        boolean zChanged = ((((i5 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.changed(i)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(i2)) || (i5 & 3072) == 2048) | composer.changed(flowLayoutOverflowState) | ((((458752 & i5) ^ 196608) > 131072 && composer.changed(i4)) || (i5 & 196608) == 131072);
        if (((29360128 & i5) ^ 12582912) <= 8388608 || !composer.changed(function4)) {
            z = (i5 & 12582912) == 8388608;
        }
        boolean z2 = zChanged | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new FlowMeasureLazyPolicy(false, horizontal, vertical, vertical.getSpacing(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_START(), horizontal.getSpacing(), i4, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    @Composable
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(@NotNull Arrangement.Horizontal horizontal, @NotNull Arrangement.Vertical vertical, int i, int i2, @NotNull FlowLayoutOverflowState flowLayoutOverflowState, int i4, @NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @NotNull Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i5) {
        boolean z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43351224, i5, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:342)");
        }
        boolean zChanged = ((((i5 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.changed(i)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(i2)) || (i5 & 3072) == 2048) | composer.changed(flowLayoutOverflowState) | ((((458752 & i5) ^ 196608) > 131072 && composer.changed(i4)) || (i5 & 196608) == 131072);
        if (((29360128 & i5) ^ 12582912) <= 8388608 || !composer.changed(function4)) {
            z = (i5 & 12582912) == 8388608;
        }
        boolean z2 = zChanged | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new FlowMeasureLazyPolicy(true, horizontal, vertical, horizontal.getSpacing(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_TOP(), vertical.getSpacing(), i4, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return function2;
    }
}
