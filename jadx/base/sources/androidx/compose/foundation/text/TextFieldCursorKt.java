package androidx.compose.foundation.text;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.WindowInfo;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.input.OffsetMapping;
import androidx.compose.p109ui.text.input.TextFieldValue;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "getDefaultCursorThickness", "()F", TokenizerME.NO_SPLIT, "cursorAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextFieldCursor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextFieldCursor.kt\nandroidx/compose/foundation/text/TextFieldCursorKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,102:1\n149#2:103\n*S KotlinDebug\n*F\n+ 1 TextFieldCursor.kt\nandroidx/compose/foundation/text/TextFieldCursorKt\n*L\n96#1:103\n*E\n"})
public final class TextFieldCursorKt {

    @NotNull
    private static final AnimationSpec<Float> cursorAnimationSpec = AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursorAnimationSpec$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
            invoke2(keyframesSpecConfig);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
            keyframesSpecConfig.setDurationMillis(1000);
            Float fValueOf = Float.valueOf(1.0f);
            keyframesSpecConfig.mo1191at(fValueOf, 0);
            keyframesSpecConfig.mo1191at(fValueOf, 499);
            Float fValueOf2 = Float.valueOf(0.0f);
            keyframesSpecConfig.mo1191at(fValueOf2, 500);
            keyframesSpecConfig.mo1191at(fValueOf2, 999);
        }
    }), null, 0, 6, null);
    private static final float DefaultCursorThickness = C2256Dp.m20968constructorimpl(2);

    @NotNull
    public static final Modifier cursor(@NotNull Modifier modifier, @NotNull final LegacyTextFieldState legacyTextFieldState, @NotNull final TextFieldValue textFieldValue, @NotNull final OffsetMapping offsetMapping, @NotNull final Brush brush, boolean z) {
        return z ? ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt.cursor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Modifier modifierDrawWithContent;
                composer.startReplaceGroup(-84507373);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-84507373, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:45)");
                }
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new CursorAnimationState();
                    composer.updateRememberedValue(objRememberedValue);
                }
                final CursorAnimationState cursorAnimationState = (CursorAnimationState) objRememberedValue;
                Brush brush2 = brush;
                boolean z2 = ((brush2 instanceof SolidColor) && ((SolidColor) brush2).getValue() == 16) ? false : true;
                if (((WindowInfo) composer.consume(CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused() && legacyTextFieldState.getHasFocus() && TextRange.m20450getCollapsedimpl(textFieldValue.getSelection()) && z2) {
                    composer.startReplaceGroup(808320157);
                    AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
                    TextRange textRangeM20444boximpl = TextRange.m20444boximpl(textFieldValue.getSelection());
                    boolean zChangedInstance = composer.changedInstance(cursorAnimationState);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new TextFieldCursorKt$cursor$1$1$1(cursorAnimationState, null);
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    EffectsKt.LaunchedEffect(annotatedString, textRangeM20444boximpl, (Function2) objRememberedValue2, composer, 0);
                    boolean zChangedInstance2 = composer.changedInstance(cursorAnimationState) | composer.changedInstance(offsetMapping) | composer.changed(textFieldValue) | composer.changedInstance(legacyTextFieldState) | composer.changed(brush);
                    final OffsetMapping offsetMapping2 = offsetMapping;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                    final Brush brush3 = brush;
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                invoke2(contentDrawScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull ContentDrawScope contentDrawScope) {
                                Rect rect;
                                TextLayoutResult value;
                                contentDrawScope.drawContent();
                                float cursorAlpha = cursorAnimationState.getCursorAlpha();
                                if (cursorAlpha == 0.0f) {
                                    return;
                                }
                                int iOriginalToTransformed = offsetMapping2.originalToTransformed(TextRange.m20456getStartimpl(textFieldValue2.getSelection()));
                                TextLayoutResultProxy layoutResult = legacyTextFieldState2.getLayoutResult();
                                if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(iOriginalToTransformed)) == null) {
                                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                                }
                                float fMo15546toPx0680j_4 = contentDrawScope.mo15546toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                                float f = fMo15546toPx0680j_4 / 2;
                                float fCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(rect.getLeft() + f, Size.m18353getWidthimpl(contentDrawScope.mo19076getSizeNHjbRc()) - f), f);
                                DrawScope.m19061drawLine1RTmtNc$default(contentDrawScope, brush3, OffsetKt.Offset(fCoerceAtLeast, rect.getTop()), OffsetKt.Offset(fCoerceAtLeast, rect.getBottom()), fMo15546toPx0680j_4, 0, null, cursorAlpha, null, 0, 432, null);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    modifierDrawWithContent = DrawModifierKt.drawWithContent(modifier2, (Function1) objRememberedValue3);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(809534830);
                    composer.endReplaceGroup();
                    modifierDrawWithContent = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierDrawWithContent;
            }
        }, 1, null) : modifier;
    }

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }
}
