package androidx.compose.foundation.text;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.MultiParagraph;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m13886d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onHover", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-03UYbkw", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "containsWithinBounds", "Landroidx/compose/ui/text/MultiParagraph;", "positionOffset", "Landroidx/compose/ui/geometry/Offset;", "containsWithinBounds-Uv8p0NA", "(Landroidx/compose/ui/text/MultiParagraph;J)Z", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nClickableText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClickableText.kt\nandroidx/compose/foundation/text/ClickableTextKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 4 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 5 Offset.kt\nandroidx/compose/ui/geometry/Offset\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,203:1\n1225#2,6:204\n1225#2,6:210\n1225#2,6:216\n1225#2,6:222\n1225#2,3:233\n1228#2,3:239\n1225#2,6:243\n1225#2,6:249\n481#3:228\n480#3,4:229\n484#3,2:236\n488#3:242\n480#4:238\n70#5:255\n73#5:256\n1#6:257\n*S KotlinDebug\n*F\n+ 1 ClickableText.kt\nandroidx/compose/foundation/text/ClickableTextKt\n*L\n85#1:204,6\n86#1:210,6\n101#1:216,6\n164#1:222,6\n165#1:233,3\n165#1:239,3\n172#1:243,6\n194#1:249,6\n165#1:228\n165#1:229,4\n165#1:236,2\n165#1:242\n165#1:238\n-1#1:255\n202#1:256\n*E\n"})
public final class ClickableTextKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation")
    @Composable
    @ExperimentalFoundationApi
    /* JADX INFO: renamed from: ClickableText-03UYbkw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16153ClickableText03UYbkw(@NotNull final AnnotatedString annotatedString, @NotNull final Function1<? super Integer, Unit> function1, @Nullable Modifier modifier, @Nullable TextStyle textStyle, boolean z, int i, int i2, @Nullable Function1<? super TextLayoutResult, Unit> function12, @NotNull final Function1<? super Integer, Unit> function13, @Nullable Composer composer, final int i4, final int i5) {
        AnnotatedString annotatedString2;
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        boolean z2;
        int i9;
        final int i10;
        int i11;
        int i12;
        int i13;
        final Function1<? super TextLayoutResult, Unit> function14;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        CoroutineScope coroutineScope;
        boolean zChangedInstance;
        Object objRememberedValue3;
        Function1<? super Integer, Unit> function15;
        boolean z3;
        Object objRememberedValue4;
        Composer composer2;
        final Function1<? super TextLayoutResult, Unit> function16;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final boolean z4;
        final int i14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1020774372);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i4 & 6) == 0) {
                i6 = (composerStartRestartGroup.changed(annotatedString2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i15 = i5 & 4;
        if (i15 != 0) {
            i6 |= 384;
        } else {
            if ((i4 & 384) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i4 & 3072) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                if (i8 == 0) {
                    if ((i4 & 24576) == 0) {
                        z2 = z;
                        i6 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= 196608;
                        i10 = i;
                    } else {
                        i10 = i;
                        if ((i4 & 196608) == 0) {
                            i6 |= composerStartRestartGroup.changed(i10) ? 131072 : 65536;
                        }
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                        i6 |= 1572864;
                        i12 = i2;
                    } else {
                        i12 = i2;
                        if ((i4 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(i12) ? 1048576 : 524288;
                        }
                    }
                    i13 = i5 & 128;
                    if (i13 == 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                    }
                    if ((i5 & 256) == 0) {
                        i6 |= 100663296;
                    } else if ((i4 & 100663296) == 0) {
                        i6 |= composerStartRestartGroup.changedInstance(function13) ? 67108864 : 33554432;
                    }
                    if ((i6 & 38347923) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        int iM20906getClipgIe3tQ8 = i9 == 0 ? TextOverflow.INSTANCE.m20906getClipgIe3tQ8() : i10;
                        if (i11 != 0) {
                            i12 = Integer.MAX_VALUE;
                        }
                        function14 = i13 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$4
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        } : function12;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020774372, i6, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:162)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                        }
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        int i16 = i6;
                        zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i6 & 112) != 32) | ((i16 & 234881024) != 67108864);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new ClickableTextKt$ClickableText$pointerInputModifier$1$1(coroutineScope, function1, mutableState, function13, null);
                            function15 = function1;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            function15 = function1;
                        }
                        Modifier modifierThen = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, function13, function15, (Function2) objRememberedValue3));
                        z3 = (i16 & 29360128) != 8388608;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z3 || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                    mutableState.setValue(textLayoutResult);
                                    function14.invoke(textLayoutResult);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        int i17 = i16 >> 3;
                        composer2 = composerStartRestartGroup;
                        int i18 = i12;
                        TextStyle textStyle4 = textStyle2;
                        boolean z5 = z2;
                        BasicTextKt.m16147BasicTextRWo7tUw(annotatedString2, modifierThen, textStyle4, (Function1) objRememberedValue4, iM20906getClipgIe3tQ8, z5, i18, 0, null, null, composer2, (i16 & 14) | (i17 & 896) | (i17 & 57344) | (458752 & (i16 << 3)) | (i16 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function16 = function14;
                        modifier3 = modifier2;
                        textStyle3 = textStyle4;
                        i10 = iM20906getClipgIe3tQ8;
                        z4 = z5;
                        i14 = i18;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function16 = function12;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        z4 = z2;
                        i14 = i12;
                        textStyle3 = textStyle2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$6
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

                            public final void invoke(@Nullable Composer composer3, int i19) {
                                ClickableTextKt.m16153ClickableText03UYbkw(annotatedString, function1, modifier3, textStyle3, z4, i10, i14, function16, function13, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                i6 |= 24576;
                z2 = z;
                i9 = i5 & 32;
                if (i9 == 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i13 = i5 & 128;
                if (i13 == 0) {
                }
                if ((i5 & 256) == 0) {
                }
                if ((i6 & 38347923) == 38347922) {
                    if (i15 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                    }
                    mutableState = (MutableState) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                    }
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    int i162 = i6;
                    zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i6 & 112) != 32) | ((i162 & 234881024) != 67108864);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue3 = new ClickableTextKt$ClickableText$pointerInputModifier$1$1(coroutineScope, function1, mutableState, function13, null);
                        function15 = function1;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        Modifier modifierThen2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22, function13, function15, (Function2) objRememberedValue3));
                        if ((i162 & 29360128) != 8388608) {
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue4 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                    mutableState.setValue(textLayoutResult);
                                    function14.invoke(textLayoutResult);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            int i172 = i162 >> 3;
                            composer2 = composerStartRestartGroup;
                            int i182 = i12;
                            TextStyle textStyle42 = textStyle2;
                            boolean z52 = z2;
                            BasicTextKt.m16147BasicTextRWo7tUw(annotatedString2, modifierThen2, textStyle42, (Function1) objRememberedValue4, iM20906getClipgIe3tQ8, z52, i182, 0, null, null, composer2, (i162 & 14) | (i172 & 896) | (i172 & 57344) | (458752 & (i162 << 3)) | (i162 & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function16 = function14;
                            modifier3 = modifier2;
                            textStyle3 = textStyle42;
                            i10 = iM20906getClipgIe3tQ8;
                            z4 = z52;
                            i14 = i182;
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 16;
            if (i8 == 0) {
            }
            z2 = z;
            i9 = i5 & 32;
            if (i9 == 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i13 = i5 & 128;
            if (i13 == 0) {
            }
            if ((i5 & 256) == 0) {
            }
            if ((i6 & 38347923) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 16;
        if (i8 == 0) {
        }
        z2 = z;
        i9 = i5 & 32;
        if (i9 == 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i13 = i5 & 128;
        if (i13 == 0) {
        }
        if ((i5 & 256) == 0) {
        }
        if ((i6 & 38347923) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation")
    @Composable
    /* JADX INFO: renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16154ClickableText4YKlhWE(@NotNull final AnnotatedString annotatedString, @Nullable Modifier modifier, @Nullable TextStyle textStyle, boolean z, int i, int i2, @Nullable Function1<? super TextLayoutResult, Unit> function1, @NotNull final Function1<? super Integer, Unit> function12, @Nullable Composer composer, final int i4, final int i5) {
        AnnotatedString annotatedString2;
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        boolean z2;
        int i9;
        int iM20906getClipgIe3tQ8;
        int i10;
        int i11;
        final Function1<? super TextLayoutResult, Unit> function13;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        boolean z3;
        Object objRememberedValue2;
        boolean z4;
        Object objRememberedValue3;
        Composer composer2;
        final Function1<? super TextLayoutResult, Unit> function14;
        final TextStyle textStyle3;
        final boolean z5;
        final int i12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-246609449);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i4 & 6) == 0) {
                i6 = (composerStartRestartGroup.changed(annotatedString2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        int i13 = i5 & 2;
        if (i13 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        z2 = z;
                        i6 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 != 0) {
                        if ((i4 & 24576) == 0) {
                            iM20906getClipgIe3tQ8 = i;
                            i6 |= composerStartRestartGroup.changed(iM20906getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i6 |= composerStartRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                        }
                        if ((i5 & 128) != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                        }
                        if ((i6 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i12 = i2;
                            composer2 = composerStartRestartGroup;
                            textStyle3 = textStyle2;
                            z5 = z2;
                            function14 = function1;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                textStyle2 = TextStyle.INSTANCE.getDefault();
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                iM20906getClipgIe3tQ8 = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
                            }
                            int i14 = i10 == 0 ? Integer.MAX_VALUE : i2;
                            function13 = i11 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            } : function1;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i6, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:83)");
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            int i15 = i6;
                            z3 = (i6 & 29360128) != 8388608;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z3 || objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function12, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            Modifier modifierThen = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2));
                            z4 = (i15 & 3670016) == 1048576;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z4 || objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                        mutableState.setValue(textLayoutResult);
                                        function13.invoke(textLayoutResult);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composer2 = composerStartRestartGroup;
                            int i16 = i14;
                            boolean z6 = z2;
                            TextStyle textStyle4 = textStyle2;
                            BasicTextKt.m16147BasicTextRWo7tUw(annotatedString2, modifierThen, textStyle4, (Function1) objRememberedValue3, iM20906getClipgIe3tQ8, z6, i16, 0, null, null, composer2, (i15 & 58254) | (458752 & (i15 << 6)) | ((i15 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function14 = function13;
                            textStyle3 = textStyle4;
                            z5 = z6;
                            i12 = i16;
                        }
                        final Modifier modifier3 = modifier2;
                        final int i17 = iM20906getClipgIe3tQ8;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
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

                                public final void invoke(@Nullable Composer composer3, int i18) {
                                    ClickableTextKt.m16154ClickableText4YKlhWE(annotatedString, modifier3, textStyle3, z5, i17, i12, function14, function12, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= 24576;
                    iM20906getClipgIe3tQ8 = i;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    if ((i5 & 128) != 0) {
                    }
                    if ((i6 & 4793491) == 4793490) {
                        if (i13 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                        }
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion22 = Modifier.INSTANCE;
                        int i152 = i6;
                        if ((i6 & 29360128) != 8388608) {
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function12, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            Modifier modifierThen2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2));
                            if ((i152 & 3670016) == 1048576) {
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z4) {
                                objRememberedValue3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                        mutableState.setValue(textLayoutResult);
                                        function13.invoke(textLayoutResult);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                composer2 = composerStartRestartGroup;
                                int i162 = i14;
                                boolean z62 = z2;
                                TextStyle textStyle42 = textStyle2;
                                BasicTextKt.m16147BasicTextRWo7tUw(annotatedString2, modifierThen2, textStyle42, (Function1) objRememberedValue3, iM20906getClipgIe3tQ8, z62, i162, 0, null, null, composer2, (i152 & 58254) | (458752 & (i152 << 6)) | ((i152 << 3) & 3670016), 896);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function14 = function13;
                                textStyle3 = textStyle42;
                                z5 = z62;
                                i12 = i162;
                            }
                        }
                    }
                    final Modifier modifier32 = modifier2;
                    final int i172 = iM20906getClipgIe3tQ8;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z2 = z;
                i9 = i5 & 16;
                if (i9 != 0) {
                }
                iM20906getClipgIe3tQ8 = i;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                if ((i5 & 128) != 0) {
                }
                if ((i6 & 4793491) == 4793490) {
                }
                final Modifier modifier322 = modifier2;
                final int i1722 = iM20906getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            z2 = z;
            i9 = i5 & 16;
            if (i9 != 0) {
            }
            iM20906getClipgIe3tQ8 = i;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            if ((i5 & 128) != 0) {
            }
            if ((i6 & 4793491) == 4793490) {
            }
            final Modifier modifier3222 = modifier2;
            final int i17222 = iM20906getClipgIe3tQ8;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        z2 = z;
        i9 = i5 & 16;
        if (i9 != 0) {
        }
        iM20906getClipgIe3tQ8 = i;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        if ((i5 & 128) != 0) {
        }
        if ((i6 & 4793491) == 4793490) {
        }
        final Modifier modifier32222 = modifier2;
        final int i172222 = iM20906getClipgIe3tQ8;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> mutableState, long j) {
        MultiParagraph multiParagraph;
        TextLayoutResult value = mutableState.getValue();
        if (value != null && (multiParagraph = value.getMultiParagraph()) != null) {
            if (!m16155containsWithinBoundsUv8p0NA(multiParagraph, j)) {
                multiParagraph = null;
            }
            if (multiParagraph != null) {
                return Integer.valueOf(multiParagraph.m20322getOffsetForPositionk4lQ0M(j));
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: containsWithinBounds-Uv8p0NA, reason: not valid java name */
    private static final boolean m16155containsWithinBoundsUv8p0NA(MultiParagraph multiParagraph, long j) {
        float fM18284getXimpl = Offset.m18284getXimpl(j);
        float fM18285getYimpl = Offset.m18285getYimpl(j);
        return fM18284getXimpl > 0.0f && fM18285getYimpl >= 0.0f && fM18284getXimpl <= multiParagraph.getWidth() && fM18285getYimpl <= multiParagraph.getHeight();
    }
}
