package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.input.pointer.PointerIcon;
import androidx.compose.p109ui.input.pointer.PointerIconKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.UriHandler;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.LinkAnnotation;
import androidx.compose.p109ui.text.LinkInteractionListener;
import androidx.compose.p109ui.text.SpanStyle;
import androidx.compose.p109ui.text.TextLayoutInput;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextLinkStyles;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.p109ui.unit.IntRectKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u001e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001fJ>\u0010 \u001a\u00020\t2\u0016\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\"\"\u0004\u0018\u00010\u00012\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010$J\r\u0010%\u001a\u00020\u0003H\u0000¢\u0006\u0002\b&J0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0018\u00010(j\u0004\u0018\u0001`*2\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020)0(j\u0002`*2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0002J\u001c\u0010/\u001a\u0004\u0018\u0001002\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020)0(j\u0002`*H\u0002J\u001c\u00101\u001a\u0004\u0018\u0001022\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020)0(j\u0002`*H\u0002J\u001e\u00103\u001a\u000204*\u0002042\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020)0(j\u0002`*H\u0002J\u001a\u00105\u001a\u0004\u0018\u000106*\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000106H\u0002J\u001e\u00108\u001a\u000204*\u0002042\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020)0(j\u0002`*H\u0002R%\u0010\u0005\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0004R/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00069"}, m13886d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "getInitialText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "text", "getText$foundation_release", "setText$foundation_release", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "StyleAnnotation", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "applyAnnotators", "applyAnnotators$foundation_release", "calculateVisibleLinkRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/foundation/text/LinkRange;", "link", "handleLink", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "clipLink", "Landroidx/compose/ui/Modifier;", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "textRange", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextLinkScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextLinkScope.kt\nandroidx/compose/foundation/text/TextLinkScope\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 4 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 5 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 6 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedStringKt\n*L\n1#1,350:1\n33#2,6:351\n33#2,4:361\n38#2:395\n33#2,6:397\n81#3:357\n107#3,2:358\n77#4:360\n1225#5,6:365\n1225#5,6:371\n1225#5,6:377\n1225#5,6:383\n1225#5,6:389\n1225#5,6:403\n1242#6:396\n*S KotlinDebug\n*F\n+ 1 TextLinkScope.kt\nandroidx/compose/foundation/text/TextLinkScope\n*L\n75#1:351,6\n205#1:361,4\n205#1:395\n289#1:397,6\n69#1:357\n69#1:358,2\n202#1:360\n207#1:365,6\n219#1:371,6\n224#1:377,6\n225#1:383,6\n237#1:389,6\n300#1:403,6\n286#1:396\n*E\n"})
public final class TextLinkScope {
    public static final int $stable = 8;

    @NotNull
    private final SnapshotStateList<Function1<TextAnnotatorScope, Unit>> annotators;

    @NotNull
    private final AnnotatedString initialText;

    @NotNull
    private AnnotatedString text;

    /* JADX INFO: renamed from: textLayoutResult$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState textLayoutResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public TextLinkScope(@NotNull AnnotatedString annotatedString) {
        SpanStyle style;
        this.initialText = annotatedString;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(annotatedString);
        List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
        int size = linkAnnotations.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<LinkAnnotation> range = linkAnnotations.get(i);
            TextLinkStyles styles = range.getItem().getStyles();
            if (styles != null && (style = styles.getStyle()) != null) {
                builder.addStyle(style, range.getStart(), range.getEnd());
            }
        }
        this.text = builder.toAnnotatedString();
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public final void StyleAnnotation(final Object[] objArr, final Function1<? super TextAnnotatorScope, Unit> function1, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2083052099);
        int i2 = (i & 48) == 0 ? (composerStartRestartGroup.changedInstance(function1) ? 32 : 16) | i : i;
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        composerStartRestartGroup.startMovableGroup(-416630839, Integer.valueOf(objArr.length));
        for (Object obj : objArr) {
            i2 |= composerStartRestartGroup.changedInstance(obj) ? 4 : 0;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i2 & 14) == 0) {
            i2 |= 2;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2083052099, i2, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:298)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(function1);
            spreadBuilder.addSpread(objArr);
            Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            boolean zChangedInstance = ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(this);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                        this.this$0.annotators.add(function1);
                        final TextLinkScope textLinkScope = this.this$0;
                        final Function1<TextAnnotatorScope, Unit> function12 = function1;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                textLinkScope.annotators.remove(function12);
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(array, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope.StyleAnnotation.2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    TextLinkScope textLinkScope = TextLinkScope.this;
                    Object[] objArr2 = objArr;
                    textLinkScope.StyleAnnotation(Arrays.copyOf(objArr2, objArr2.length), function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private final AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange(AnnotatedString.Range<LinkAnnotation> link, TextLayoutResult textLayoutResult) {
        int lineEnd$default = TextLayoutResult.getLineEnd$default(textLayoutResult, textLayoutResult.getLineCount() - 1, false, 2, null);
        if (link.getStart() < lineEnd$default) {
            return AnnotatedString.Range.copy$default(link, null, 0, Math.min(link.getEnd(), lineEnd$default), null, 11, null);
        }
        return null;
    }

    private final Modifier clipLink(Modifier modifier, final AnnotatedString.Range<LinkAnnotation> range) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope.clipLink.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
                Shape shapeShapeForRange = TextLinkScope.this.shapeForRange(range);
                if (shapeShapeForRange != null) {
                    graphicsLayerScope.setShape(shapeShapeForRange);
                    graphicsLayerScope.setClip(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        LinkInteractionListener linkInteractionListener;
        Unit unit;
        if (!(link instanceof LinkAnnotation.Url)) {
            if (!(link instanceof LinkAnnotation.Clickable) || (linkInteractionListener = link.getLinkInteractionListener()) == null) {
                return;
            }
            linkInteractionListener.onClick(link);
            return;
        }
        LinkInteractionListener linkInteractionListener2 = link.getLinkInteractionListener();
        if (linkInteractionListener2 != null) {
            linkInteractionListener2.onClick(link);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            try {
                uriHandler.openUri(((LinkAnnotation.Url) link).getUrl());
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpanStyle mergeOrUse(SpanStyle spanStyle, SpanStyle spanStyle2) {
        SpanStyle spanStyleMerge;
        return (spanStyle == null || (spanStyleMerge = spanStyle.merge(spanStyle2)) == null) ? spanStyle2 : spanStyleMerge;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> link) {
        Path pathForRange = null;
        if (!getShouldMeasureLinks().invoke().booleanValue()) {
            return null;
        }
        TextLayoutResult textLayoutResult = getTextLayoutResult();
        if (textLayoutResult != null) {
            AnnotatedString.Range<LinkAnnotation> rangeCalculateVisibleLinkRange = calculateVisibleLinkRange(link, textLayoutResult);
            if (rangeCalculateVisibleLinkRange == null) {
                return null;
            }
            pathForRange = textLayoutResult.getPathForRange(rangeCalculateVisibleLinkRange.getStart(), rangeCalculateVisibleLinkRange.getEnd());
            Rect boundingBox = textLayoutResult.getBoundingBox(rangeCalculateVisibleLinkRange.getStart());
            pathForRange.mo18420translatek4lQ0M(Offset.m18293unaryMinusF1C5BW0(OffsetKt.Offset(textLayoutResult.getLineForOffset(rangeCalculateVisibleLinkRange.getStart()) == textLayoutResult.getLineForOffset(rangeCalculateVisibleLinkRange.getEnd() + (-1)) ? Math.min(textLayoutResult.getBoundingBox(rangeCalculateVisibleLinkRange.getEnd() - 1).getLeft(), boundingBox.getLeft()) : 0.0f, boundingBox.getTop())));
        }
        return pathForRange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> link) {
        final Path pathPathForRangeInRangeCoordinates = pathForRangeInRangeCoordinates(link);
        if (pathPathForRangeInRangeCoordinates != null) {
            return new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
                @Override // androidx.compose.p109ui.graphics.Shape
                @NotNull
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo15457createOutlinePq9zytI(long size, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
                    return new Outline.Generic(pathPathForRangeInRangeCoordinates);
                }
            };
        }
        return null;
    }

    private final Modifier textRange(Modifier modifier, AnnotatedString.Range<LinkAnnotation> range) {
        return modifier.then(new TextRangeLayoutModifier(new C0287e(this, range, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult textRange$lambda$3(TextLinkScope textLinkScope, AnnotatedString.Range range, TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        if (textLayoutResult == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$layoutResult$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ IntOffset invoke() {
                    return IntOffset.m21087boximpl(m16270invokenOccac());
                }

                /* JADX INFO: renamed from: invoke-nOcc-ac, reason: not valid java name */
                public final long m16270invokenOccac() {
                    return IntOffset.INSTANCE.m21106getZeronOccac();
                }
            });
        }
        AnnotatedString.Range<LinkAnnotation> rangeCalculateVisibleLinkRange = textLinkScope.calculateVisibleLinkRange(range, textLayoutResult);
        if (rangeCalculateVisibleLinkRange == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$updatedRange$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ IntOffset invoke() {
                    return IntOffset.m21087boximpl(m16271invokenOccac());
                }

                /* JADX INFO: renamed from: invoke-nOcc-ac, reason: not valid java name */
                public final long m16271invokenOccac() {
                    return IntOffset.INSTANCE.m21106getZeronOccac();
                }
            });
        }
        final IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(textLayoutResult.getPathForRange(rangeCalculateVisibleLinkRange.getStart(), rangeCalculateVisibleLinkRange.getEnd()).getBounds());
        return textRangeLayoutMeasureScope.layout(intRectRoundToIntRect.getWidth(), intRectRoundToIntRect.getHeight(), new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ IntOffset invoke() {
                return IntOffset.m21087boximpl(m16269invokenOccac());
            }

            /* JADX INFO: renamed from: invoke-nOcc-ac, reason: not valid java name */
            public final long m16269invokenOccac() {
                return intRectRoundToIntRect.m21124getTopLeftnOccac();
            }
        });
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void LinksComposables(@Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1154651354);
        int i4 = 2;
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154651354, i2, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:200)");
            }
            final UriHandler uriHandler = (UriHandler) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
            AnnotatedString annotatedString = this.text;
            List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
            int size = linkAnnotations.size();
            int i5 = 0;
            while (i5 < size) {
                final AnnotatedString.Range<LinkAnnotation> range = linkAnnotations.get(i5);
                if (range.getStart() != range.getEnd()) {
                    composerStartRestartGroup.startReplaceGroup(1385536272);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(textRange(clipLink(Modifier.INSTANCE, range), range), mutableInteractionSource, false, i4, null), PointerIcon.INSTANCE.getHand(), false, i4, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.invisibleToUser(semanticsPropertyReceiver);
                        }
                    }, 1, null);
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(range) | composerStartRestartGroup.changedInstance(uriHandler);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                this.this$0.handleLink(range.getItem(), uriHandler);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    BoxKt.Box(ClickableKt.m15444combinedClickableXVZzFYc$default(modifierSemantics$default, mutableInteractionSource, null, false, null, null, null, null, null, (Function0) objRememberedValue2, 252, null), composerStartRestartGroup, 0);
                    if (TextLinkScopeKt.isNullOrEmpty(range.getItem().getStyles())) {
                        composerStartRestartGroup.startReplaceGroup(1388165134);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1386296950);
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new LinkStateInteractionSourceObserver();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = (LinkStateInteractionSourceObserver) objRememberedValue3;
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new TextLinkScope$LinksComposables$1$3$1(linkStateInteractionSourceObserver, mutableInteractionSource, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composerStartRestartGroup, 6);
                        Boolean boolValueOf = Boolean.valueOf(linkStateInteractionSourceObserver.isHovered());
                        Boolean boolValueOf2 = Boolean.valueOf(linkStateInteractionSourceObserver.isFocused());
                        Boolean boolValueOf3 = Boolean.valueOf(linkStateInteractionSourceObserver.isPressed());
                        TextLinkStyles styles = range.getItem().getStyles();
                        SpanStyle style = styles != null ? styles.getStyle() : null;
                        TextLinkStyles styles2 = range.getItem().getStyles();
                        SpanStyle focusedStyle = styles2 != null ? styles2.getFocusedStyle() : null;
                        TextLinkStyles styles3 = range.getItem().getStyles();
                        SpanStyle hoveredStyle = styles3 != null ? styles3.getHoveredStyle() : null;
                        TextLinkStyles styles4 = range.getItem().getStyles();
                        Object[] objArr = {boolValueOf, boolValueOf2, boolValueOf3, style, focusedStyle, hoveredStyle, styles4 != null ? styles4.getPressedStyle() : null};
                        boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(range);
                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new Function1<TextAnnotatorScope, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatorScope textAnnotatorScope) {
                                    invoke2(textAnnotatorScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextAnnotatorScope textAnnotatorScope) {
                                    TextLinkStyles styles5;
                                    TextLinkStyles styles6;
                                    TextLinkStyles styles7;
                                    TextLinkScope textLinkScope = this.this$0;
                                    TextLinkStyles styles8 = range.getItem().getStyles();
                                    SpanStyle pressedStyle = null;
                                    SpanStyle spanStyleMergeOrUse = textLinkScope.mergeOrUse(textLinkScope.mergeOrUse(styles8 != null ? styles8.getStyle() : null, (!linkStateInteractionSourceObserver.isFocused() || (styles7 = range.getItem().getStyles()) == null) ? null : styles7.getFocusedStyle()), (!linkStateInteractionSourceObserver.isHovered() || (styles6 = range.getItem().getStyles()) == null) ? null : styles6.getHoveredStyle());
                                    if (linkStateInteractionSourceObserver.isPressed() && (styles5 = range.getItem().getStyles()) != null) {
                                        pressedStyle = styles5.getPressedStyle();
                                    }
                                    SpanStyle spanStyleMergeOrUse2 = textLinkScope.mergeOrUse(spanStyleMergeOrUse, pressedStyle);
                                    if (spanStyleMergeOrUse2 != null) {
                                        AnnotatedString.Range<LinkAnnotation> range2 = range;
                                        textAnnotatorScope.replaceStyle(spanStyleMergeOrUse2, range2.getStart(), range2.getEnd());
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        StyleAnnotation(objArr, (Function1) objRememberedValue5, composerStartRestartGroup, (i2 << 6) & 896);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1388179022);
                    composerStartRestartGroup.endReplaceGroup();
                }
                i5++;
                i4 = 2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope.LinksComposables.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    TextLinkScope.this.LinksComposables(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @NotNull
    public final AnnotatedString applyAnnotators$foundation_release() {
        AnnotatedString annotatedString;
        if (this.annotators.isEmpty()) {
            annotatedString = this.text;
        } else {
            int i = 0;
            AnnotatedString.Builder builder = new AnnotatedString.Builder(i, 1, null);
            builder.append(this.initialText);
            TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(builder);
            SnapshotStateList<Function1<TextAnnotatorScope, Unit>> snapshotStateList = this.annotators;
            int size = snapshotStateList.size();
            while (i < size) {
                snapshotStateList.get(i).invoke(textAnnotatorScope);
                i++;
            }
            annotatedString = builder.toAnnotatedString();
        }
        this.text = annotatedString;
        return annotatedString;
    }

    @NotNull
    /* JADX INFO: renamed from: getInitialText$foundation_release, reason: from getter */
    public final AnnotatedString getInitialText() {
        return this.initialText;
    }

    @NotNull
    public final Function0<Boolean> getShouldMeasureLinks() {
        return new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextLinkScope$shouldMeasureLinks$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                TextLayoutInput layoutInput;
                AnnotatedString text = this.this$0.getText();
                TextLayoutResult textLayoutResult = this.this$0.getTextLayoutResult();
                return Boolean.valueOf(Intrinsics.areEqual(text, (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : layoutInput.getText()));
            }
        };
    }

    @NotNull
    /* JADX INFO: renamed from: getText$foundation_release, reason: from getter */
    public final AnnotatedString getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final TextLayoutResult getTextLayoutResult() {
        return (TextLayoutResult) this.textLayoutResult.getValue();
    }

    public final void setText$foundation_release(@NotNull AnnotatedString annotatedString) {
        this.text = annotatedString;
    }

    public final void setTextLayoutResult(@Nullable TextLayoutResult textLayoutResult) {
        this.textLayoutResult.setValue(textLayoutResult);
    }
}
