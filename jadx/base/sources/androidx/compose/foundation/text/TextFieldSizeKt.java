package androidx.compose.foundation.text;

import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutModifierKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.TextStyleKt;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002"}, m13886d2 = {"textFieldMinSize", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "foundation_release", "typeface", ""}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextFieldSizeKt {
    @NotNull
    public static final Modifier textFieldMinSize(@NotNull Modifier modifier, @NotNull final TextStyle textStyle) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize.1
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
                composer.startReplaceGroup(1582736677);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1582736677, i, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
                }
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                boolean zChanged = composer.changed(textStyle) | composer.changed(layoutDirection);
                TextStyle textStyle2 = textStyle;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = TextStyleKt.resolveDefaults(textStyle2, layoutDirection);
                    composer.updateRememberedValue(objRememberedValue);
                }
                TextStyle textStyle3 = (TextStyle) objRememberedValue;
                boolean zChanged2 = composer.changed(resolver) | composer.changed(textStyle3);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    FontFamily fontFamily = textStyle3.getFontFamily();
                    FontWeight fontWeight = textStyle3.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.INSTANCE.getNormal();
                    }
                    FontStyle fontStyleM20488getFontStyle4Lr2A7w = textStyle3.m20488getFontStyle4Lr2A7w();
                    int iM20568unboximpl = fontStyleM20488getFontStyle4Lr2A7w != null ? fontStyleM20488getFontStyle4Lr2A7w.m20568unboximpl() : FontStyle.INSTANCE.m20572getNormal_LCdwA();
                    FontSynthesis fontSynthesisM20489getFontSynthesisZQGJjVo = textStyle3.m20489getFontSynthesisZQGJjVo();
                    objRememberedValue2 = resolver.mo20540resolveDPcqOEQ(fontFamily, fontWeight, iM20568unboximpl, fontSynthesisM20489getFontSynthesisZQGJjVo != null ? fontSynthesisM20489getFontSynthesisZQGJjVo.getValue() : FontSynthesis.INSTANCE.m20582getAllGVVA2EU());
                    composer.updateRememberedValue(objRememberedValue2);
                }
                State state = (State) objRememberedValue2;
                TextStyle textStyle4 = textStyle;
                Object objRememberedValue3 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new TextFieldSize(layoutDirection, density, resolver, textStyle4, state.getValue());
                    composer.updateRememberedValue(objRememberedValue3);
                }
                final TextFieldSize textFieldSize = (TextFieldSize) objRememberedValue3;
                textFieldSize.update(layoutDirection, density, resolver, textStyle3, state.getValue());
                Modifier.Companion companion2 = Modifier.INSTANCE;
                boolean zChangedInstance = composer.changedInstance(textFieldSize);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                            return m16259invoke3p2s80s(measureScope, measurable, constraints.getValue());
                        }

                        @NotNull
                        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m16259invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
                            long minSize = textFieldSize.getMinSize();
                            final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j, RangesKt.coerceIn(IntSize.m21138getWidthimpl(minSize), Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j)), 0, RangesKt.coerceIn(IntSize.m21137getHeightimpl(minSize), Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j)), 0, 10, null));
                            return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1.1
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
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                Modifier modifierLayout = LayoutModifierKt.layout(companion2, (Function3) objRememberedValue4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierLayout;
            }
        }, 1, null);
    }
}
