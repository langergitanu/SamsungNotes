package androidx.compose.foundation.text.modifiers;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorProducer;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.layout.AlignmentLineKt;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.DrawModifierNode;
import androidx.compose.p109ui.node.DrawModifierNodeKt;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.node.LayoutModifierNodeKt;
import androidx.compose.p109ui.node.SemanticsModifierNode;
import androidx.compose.p109ui.node.SemanticsModifierNodeKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.Paragraph;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.style.Hyphens;
import androidx.compose.p109ui.text.style.LineBreak;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDirection;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LBQ\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010&\u001a\u00020'H\u0002J\u001e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eJ\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u0006H\u0002J\u0018\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\bJ@\u00103\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b4\u00105J\u000e\u00106\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\f\u00107\u001a\u00020'*\u000208H\u0016J\f\u00109\u001a\u00020'*\u00020:H\u0016J\u001c\u0010;\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0010H\u0016J\u001c\u0010@\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0010H\u0016J&\u0010B\u001a\u00020C*\u00020D2\u0006\u0010=\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u001c\u0010J\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0010H\u0016J\u001c\u0010K\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0010H\u0016R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u000e\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, m13886d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textSubstitution", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "clearSubstitution", "", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "density", "Landroidx/compose/ui/unit/Density;", "invalidateForTranslate", "setSubstitution", "updatedText", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-HuAbxIM", "(Landroidx/compose/ui/text/TextStyle;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "TextSubstitutionValue", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextStringSimpleNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextStringSimpleNode.kt\nandroidx/compose/foundation/text/modifiers/TextStringSimpleNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n+ 5 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n*L\n1#1,470:1\n1#2:471\n26#3:472\n26#3:473\n256#4:474\n696#5:475\n696#5:476\n*S KotlinDebug\n*F\n+ 1 TextStringSimpleNode.kt\nandroidx/compose/foundation/text/modifiers/TextStringSimpleNode\n*L\n362#1:472\n363#1:473\n422#1:474\n447#1:475\n449#1:476\n*E\n"})
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;

    @Nullable
    private ParagraphLayoutCache _layoutCache;

    @Nullable
    private Map<AlignmentLine, Integer> baselineCache;

    @NotNull
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;

    @Nullable
    private ColorProducer overrideColor;

    @Nullable
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;

    @NotNull
    private TextStyle style;

    @NotNull
    private String text;

    @Nullable
    private TextSubstitutionValue textSubstitution;

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i4, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i4, colorProducer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearSubstitution() {
        this.textSubstitution = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
        }
        ParagraphLayoutCache paragraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(paragraphLayoutCache);
        return paragraphLayoutCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics(this);
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setSubstitution(String updatedText) {
        Unit unit;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            TextSubstitutionValue textSubstitutionValue2 = new TextSubstitutionValue(this.text, updatedText, false, null, 12, null);
            ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
            paragraphLayoutCache.setDensity$foundation_release(getLayoutCache().getDensity());
            textSubstitutionValue2.setLayoutCache(paragraphLayoutCache);
            this.textSubstitution = textSubstitutionValue2;
            return true;
        }
        if (Intrinsics.areEqual(updatedText, textSubstitutionValue.getSubstitution())) {
            return false;
        }
        textSubstitutionValue.setSubstitution(updatedText);
        ParagraphLayoutCache layoutCache = textSubstitutionValue.getLayoutCache();
        if (layoutCache != null) {
            layoutCache.m16484updateL6sJoHM(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit != null;
    }

    @Override // androidx.compose.p109ui.node.SemanticsModifierNode
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Function1 function1 = this.semanticsTextLayoutResult;
        if (function1 == null) {
            function1 = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.applySemantics.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull List<TextLayoutResult> list) {
                    ParagraphLayoutCache layoutCache = TextStringSimpleNode.this.getLayoutCache();
                    TextStyle textStyle = TextStringSimpleNode.this.style;
                    ColorProducer colorProducer = TextStringSimpleNode.this.overrideColor;
                    TextLayoutResult textLayoutResultSlowCreateTextLayoutResultOrNull = layoutCache.slowCreateTextLayoutResultOrNull(textStyle.m20501mergedA7vx0o((16777214 & 1) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : colorProducer != null ? colorProducer.m18606invoke0d7_KjU() : Color.INSTANCE.m18561getUnspecified0d7_KjU(), (16777214 & 2) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : 0L, (16777214 & 4) != 0 ? null : null, (16777214 & 8) != 0 ? null : null, (16777214 & 16) != 0 ? null : null, (16777214 & 32) != 0 ? null : null, (16777214 & 64) != 0 ? null : null, (16777214 & 128) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : 0L, (16777214 & 256) != 0 ? null : null, (16777214 & 512) != 0 ? null : null, (16777214 & 1024) != 0 ? null : null, (16777214 & 2048) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : 0L, (16777214 & 4096) != 0 ? null : null, (16777214 & 8192) != 0 ? null : null, (16777214 & 16384) != 0 ? null : null, (16777214 & 32768) != 0 ? TextAlign.INSTANCE.m20863getUnspecifiede0LSkKk() : 0, (16777214 & 65536) != 0 ? TextDirection.INSTANCE.m20876getUnspecifieds_7Xco() : 0, (16777214 & 131072) != 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : 0L, (16777214 & 262144) != 0 ? null : null, (16777214 & 524288) != 0 ? null : null, (16777214 & 1048576) != 0 ? LineBreak.INSTANCE.m20790getUnspecifiedrAG3T2k() : 0, (16777214 & 2097152) != 0 ? Hyphens.INSTANCE.m20769getUnspecifiedvmbZdU8() : 0, (16777214 & 4194304) != 0 ? null : null, (16777214 & 8388608) != 0 ? null : null));
                    if (textLayoutResultSlowCreateTextLayoutResultOrNull != null) {
                        list.add(textLayoutResultSlowCreateTextLayoutResultOrNull);
                    } else {
                        textLayoutResultSlowCreateTextLayoutResultOrNull = null;
                    }
                    return Boolean.valueOf(textLayoutResultSlowCreateTextLayoutResultOrNull != null);
                }
            };
            this.semanticsTextLayoutResult = function1;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(this.text, null, null, 6, null));
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null) {
            SemanticsPropertiesKt.setShowingTextSubstitution(semanticsPropertyReceiver, textSubstitutionValue.isShowingSubstitution());
            SemanticsPropertiesKt.setTextSubstitution(semanticsPropertyReceiver, new AnnotatedString(textSubstitutionValue.getSubstitution(), null, null, 6, null));
        }
        SemanticsPropertiesKt.setTextSubstitution$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.applySemantics.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull AnnotatedString annotatedString) {
                TextStringSimpleNode.this.setSubstitution(annotatedString.getText());
                TextStringSimpleNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.showTextSubstitution$default(semanticsPropertyReceiver, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.applySemantics.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            @NotNull
            public final Boolean invoke(boolean z) {
                if (TextStringSimpleNode.this.textSubstitution == null) {
                    return Boolean.FALSE;
                }
                TextSubstitutionValue textSubstitutionValue2 = TextStringSimpleNode.this.textSubstitution;
                if (textSubstitutionValue2 != null) {
                    textSubstitutionValue2.setShowingSubstitution(z);
                }
                TextStringSimpleNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.clearTextSubstitution$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.applySemantics.4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                TextStringSimpleNode.this.clearSubstitution();
                TextStringSimpleNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, function1, 1, null);
    }

    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged) {
        if (textChanged || layoutChanged) {
            getLayoutCache().m16484updateL6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
        }
        if (getIsAttached()) {
            if (textChanged || (drawChanged && this.semanticsTextLayoutResult != null)) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            if (textChanged || layoutChanged) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }
            if (drawChanged) {
                DrawModifierNodeKt.invalidateDraw(this);
            }
        }
    }

    @Override // androidx.compose.p109ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        if (getIsAttached()) {
            ParagraphLayoutCache layoutCache = getLayoutCache(contentDrawScope);
            Paragraph paragraph = layoutCache.getParagraph();
            if (paragraph == null) {
                throw new IllegalArgumentException(("no paragraph (layoutCache=" + this._layoutCache + ", textSubstitution=" + this.textSubstitution + PropertyUtils.MAPPED_DELIM2).toString());
            }
            Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
            boolean didOverflow = layoutCache.getDidOverflow();
            if (didOverflow) {
                float fM21138getWidthimpl = IntSize.m21138getWidthimpl(layoutCache.getLayoutSize());
                float fM21137getHeightimpl = IntSize.m21137getHeightimpl(layoutCache.getLayoutSize());
                canvas.save();
                Canvas.m18497clipRectN_I0leg$default(canvas, 0.0f, 0.0f, fM21138getWidthimpl, fM21137getHeightimpl, 0, 16, null);
            }
            try {
                TextDecoration textDecoration = this.style.getTextDecoration();
                if (textDecoration == null) {
                    textDecoration = TextDecoration.INSTANCE.getNone();
                }
                TextDecoration textDecoration2 = textDecoration;
                Shadow shadow = this.style.getShadow();
                if (shadow == null) {
                    shadow = Shadow.INSTANCE.getNone();
                }
                Shadow shadow2 = shadow;
                DrawStyle drawStyle = this.style.getDrawStyle();
                if (drawStyle == null) {
                    drawStyle = Fill.INSTANCE;
                }
                DrawStyle drawStyle2 = drawStyle;
                Brush brush = this.style.getBrush();
                if (brush != null) {
                    Paragraph.m20331painthn5TExg$default(paragraph, canvas, brush, this.style.getAlpha(), shadow2, textDecoration2, drawStyle2, 0, 64, null);
                } else {
                    ColorProducer colorProducer = this.overrideColor;
                    long jM18606invoke0d7_KjU = colorProducer != null ? colorProducer.m18606invoke0d7_KjU() : Color.INSTANCE.m18561getUnspecified0d7_KjU();
                    if (jM18606invoke0d7_KjU == 16) {
                        jM18606invoke0d7_KjU = this.style.m20486getColor0d7_KjU() != 16 ? this.style.m20486getColor0d7_KjU() : Color.INSTANCE.m18551getBlack0d7_KjU();
                    }
                    Paragraph.m20329paintLG529CI$default(paragraph, canvas, jM18606invoke0d7_KjU, shadow2, textDecoration2, drawStyle2, 0, 32, null);
                }
                if (didOverflow) {
                    canvas.restore();
                }
            } catch (Throwable th) {
                if (didOverflow) {
                    canvas.restore();
                }
                throw th;
            }
        }
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).maxIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        ParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
        boolean zM16482layoutWithConstraintsK40F9xA = layoutCache.m16482layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
        layoutCache.getObserveFontChanges$foundation_release();
        Paragraph paragraph = layoutCache.getParagraph();
        Intrinsics.checkNotNull(paragraph);
        long layoutSize = layoutCache.getLayoutSize();
        if (zM16482layoutWithConstraintsK40F9xA) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Map<AlignmentLine, Integer> linkedHashMap = this.baselineCache;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>(2);
            }
            linkedHashMap.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(paragraph.getFirstBaseline())));
            linkedHashMap.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(paragraph.getLastBaseline())));
            this.baselineCache = linkedHashMap;
        }
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.INSTANCE.m20930fitPrioritizingWidthZbe2FdA(IntSize.m21138getWidthimpl(layoutSize), IntSize.m21138getWidthimpl(layoutSize), IntSize.m21137getHeightimpl(layoutSize), IntSize.m21137getHeightimpl(layoutSize)));
        int iM21138getWidthimpl = IntSize.m21138getWidthimpl(layoutSize);
        int iM21137getHeightimpl = IntSize.m21137getHeightimpl(layoutSize);
        Map<AlignmentLine, Integer> map = this.baselineCache;
        Intrinsics.checkNotNull(map);
        return measureScope.layout(iM21138getWidthimpl, iM21137getHeightimpl, map, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$measure$1
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        });
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).minIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public final boolean updateDraw(@Nullable ColorProducer color, @NotNull TextStyle style) {
        boolean zAreEqual = Intrinsics.areEqual(color, this.overrideColor);
        this.overrideColor = color;
        return (zAreEqual && style.hasSameDrawAffectingAttributes(this.style)) ? false : true;
    }

    /* JADX INFO: renamed from: updateLayoutRelatedArgs-HuAbxIM, reason: not valid java name */
    public final boolean m16491updateLayoutRelatedArgsHuAbxIM(@NotNull TextStyle style, int minLines, int maxLines, boolean softWrap, @NotNull FontFamily.Resolver fontFamilyResolver, int overflow) {
        boolean z = !this.style.hasSameLayoutAffectingAttributes(style);
        this.style = style;
        if (this.minLines != minLines) {
            this.minLines = minLines;
            z = true;
        }
        if (this.maxLines != maxLines) {
            this.maxLines = maxLines;
            z = true;
        }
        if (this.softWrap != softWrap) {
            this.softWrap = softWrap;
            z = true;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            z = true;
        }
        if (TextOverflow.m20899equalsimpl0(this.overflow, overflow)) {
            return z;
        }
        this.overflow = overflow;
        return true;
    }

    public final boolean updateText(@NotNull String text) {
        if (Intrinsics.areEqual(this.text, text)) {
            return false;
        }
        this.text = text;
        clearSubstitution();
        return true;
    }

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i4, ColorProducer colorProducer, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, (i5 & 8) != 0 ? TextOverflow.INSTANCE.m20906getClipgIe3tQ8() : i, (i5 & 16) != 0 ? true : z, (i5 & 32) != 0 ? Integer.MAX_VALUE : i2, (i5 & 64) != 0 ? 1 : i4, (i5 & 128) != 0 ? null : colorProducer, null);
    }

    private TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i4, ColorProducer colorProducer) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i4;
        this.overrideColor = colorProducer;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, m13886d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "", ShareApi.ORIGINAL_SIZE_IMAGE, "", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "getOriginal", "()Ljava/lang/String;", "getSubstitution", "setSubstitution", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;

        @Nullable
        private ParagraphLayoutCache layoutCache;

        @NotNull
        private final String original;

        @NotNull
        private String substitution;

        public TextSubstitutionValue(@NotNull String str, @NotNull String str2, boolean z, @Nullable ParagraphLayoutCache paragraphLayoutCache) {
            this.original = str;
            this.substitution = str2;
            this.isShowingSubstitution = z;
            this.layoutCache = paragraphLayoutCache;
        }

        public static /* synthetic */ TextSubstitutionValue copy$default(TextSubstitutionValue textSubstitutionValue, String str, String str2, boolean z, ParagraphLayoutCache paragraphLayoutCache, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textSubstitutionValue.original;
            }
            if ((i & 2) != 0) {
                str2 = textSubstitutionValue.substitution;
            }
            if ((i & 4) != 0) {
                z = textSubstitutionValue.isShowingSubstitution;
            }
            if ((i & 8) != 0) {
                paragraphLayoutCache = textSubstitutionValue.layoutCache;
            }
            return textSubstitutionValue.copy(str, str2, z, paragraphLayoutCache);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getOriginal() {
            return this.original;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSubstitution() {
            return this.substitution;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        @NotNull
        public final TextSubstitutionValue copy(@NotNull String original, @NotNull String substitution, boolean isShowingSubstitution, @Nullable ParagraphLayoutCache layoutCache) {
            return new TextSubstitutionValue(original, substitution, isShowingSubstitution, layoutCache);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) other;
            return Intrinsics.areEqual(this.original, textSubstitutionValue.original) && Intrinsics.areEqual(this.substitution, textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && Intrinsics.areEqual(this.layoutCache, textSubstitutionValue.layoutCache);
        }

        @Nullable
        public final ParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        @NotNull
        public final String getOriginal() {
            return this.original;
        }

        @NotNull
        public final String getSubstitution() {
            return this.substitution;
        }

        public int hashCode() {
            int iM1160f = AbstractC0622a.m1160f(this.isShowingSubstitution, AbstractC1038a.m1202c(this.original.hashCode() * 31, 31, this.substitution), 31);
            ParagraphLayoutCache paragraphLayoutCache = this.layoutCache;
            return iM1160f + (paragraphLayoutCache == null ? 0 : paragraphLayoutCache.hashCode());
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(@Nullable ParagraphLayoutCache paragraphLayoutCache) {
            this.layoutCache = paragraphLayoutCache;
        }

        public final void setShowingSubstitution(boolean z) {
            this.isShowingSubstitution = z;
        }

        public final void setSubstitution(@NotNull String str) {
            this.substitution = str;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("TextSubstitution(layoutCache=");
            sb.append(this.layoutCache);
            sb.append(", isShowingSubstitution=");
            return AbstractC0622a.m1172r(sb, this.isShowingSubstitution, PropertyUtils.MAPPED_DELIM2);
        }

        public /* synthetic */ TextSubstitutionValue(String str, String str2, boolean z, ParagraphLayoutCache paragraphLayoutCache, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : paragraphLayoutCache);
        }
    }

    private final ParagraphLayoutCache getLayoutCache(Density density) {
        ParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null && textSubstitutionValue.isShowingSubstitution() && (layoutCache = textSubstitutionValue.getLayoutCache()) != null) {
            layoutCache.setDensity$foundation_release(density);
            return layoutCache;
        }
        ParagraphLayoutCache layoutCache2 = getLayoutCache();
        layoutCache2.setDensity$foundation_release(density);
        return layoutCache2;
    }

    private static /* synthetic */ void getBaselineCache$annotations() {
    }
}
