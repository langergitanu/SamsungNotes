package androidx.compose.foundation.text.modifiers;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.ColorProducer;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.Placeholder;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015\u0012\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\t\u0010 \u001a\u00020\u0004HÂ\u0003J\u001f\u0010!\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÂ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u001bHÂ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u001dHÂ\u0003J\t\u0010$\u001a\u00020\u0006HÂ\u0003J\t\u0010%\u001a\u00020\bHÂ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÂ\u0003J\u0016\u0010'\u001a\u00020\u000eHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\t\u0010*\u001a\u00020\u0010HÂ\u0003J\t\u0010+\u001a\u00020\u0012HÂ\u0003J\t\u0010,\u001a\u00020\u0012HÂ\u0003J\u0017\u0010-\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015HÂ\u0003JÁ\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u00152\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100J\b\u00101\u001a\u00020\u0002H\u0016J\u0013\u00102\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u000104H\u0096\u0002J\b\u00105\u001a\u00020\u0012H\u0016J\t\u00106\u001a\u000207HÖ\u0001J\u0010\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\u0002H\u0016J\f\u0010:\u001a\u00020\f*\u00020;H\u0016R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u000eX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u001c\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<"}, m13886d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component5-gIe3tQ8", "()I", "component6", "component7", "component8", "component9", "copy", "copy-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "create", "equals", "other", "", "hashCode", "toString", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class SelectableTextAnnotatedStringElement extends ModifierNodeElement<SelectableTextAnnotatedStringNode> {
    public static final int $stable = 0;

    @Nullable
    private final ColorProducer color;

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;

    @Nullable
    private final Function1<List<Rect>, Unit> onPlaceholderLayout;

    @Nullable
    private final Function1<TextLayoutResult, Unit> onTextLayout;
    private final int overflow;

    @Nullable
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    @Nullable
    private final SelectionController selectionController;
    private final boolean softWrap;

    @NotNull
    private final TextStyle style;

    @NotNull
    private final AnnotatedString text;

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i4, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i4, list, function12, selectionController, colorProducer);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final AnnotatedString getText() {
        return this.text;
    }

    private final Function1<List<Rect>, Unit> component10() {
        return this.onPlaceholderLayout;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    private final SelectionController getSelectionController() {
        return this.selectionController;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    private final ColorProducer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final TextStyle getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    private final Function1<TextLayoutResult, Unit> component4() {
        return this.onTextLayout;
    }

    /* JADX INFO: renamed from: component5-gIe3tQ8, reason: not valid java name and from getter */
    private final int getOverflow() {
        return this.overflow;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final boolean getSoftWrap() {
        return this.softWrap;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final int getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final int getMinLines() {
        return this.minLines;
    }

    private final List<AnnotatedString.Range<Placeholder>> component9() {
        return this.placeholders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-VhcvRP8$default, reason: not valid java name */
    public static /* synthetic */ SelectableTextAnnotatedStringElement m16486copyVhcvRP8$default(SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement, AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i4, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            annotatedString = selectableTextAnnotatedStringElement.text;
        }
        if ((i5 & 2) != 0) {
            textStyle = selectableTextAnnotatedStringElement.style;
        }
        if ((i5 & 4) != 0) {
            resolver = selectableTextAnnotatedStringElement.fontFamilyResolver;
        }
        if ((i5 & 8) != 0) {
            function1 = selectableTextAnnotatedStringElement.onTextLayout;
        }
        if ((i5 & 16) != 0) {
            i = selectableTextAnnotatedStringElement.overflow;
        }
        if ((i5 & 32) != 0) {
            z = selectableTextAnnotatedStringElement.softWrap;
        }
        if ((i5 & 64) != 0) {
            i2 = selectableTextAnnotatedStringElement.maxLines;
        }
        if ((i5 & 128) != 0) {
            i4 = selectableTextAnnotatedStringElement.minLines;
        }
        if ((i5 & 256) != 0) {
            list = selectableTextAnnotatedStringElement.placeholders;
        }
        if ((i5 & 512) != 0) {
            function12 = selectableTextAnnotatedStringElement.onPlaceholderLayout;
        }
        if ((i5 & 1024) != 0) {
            selectionController = selectableTextAnnotatedStringElement.selectionController;
        }
        if ((i5 & 2048) != 0) {
            colorProducer = selectableTextAnnotatedStringElement.color;
        }
        SelectionController selectionController2 = selectionController;
        ColorProducer colorProducer2 = colorProducer;
        List list2 = list;
        Function1 function13 = function12;
        int i6 = i2;
        int i7 = i4;
        int i8 = i;
        boolean z2 = z;
        return selectableTextAnnotatedStringElement.m16487copyVhcvRP8(annotatedString, textStyle, resolver, function1, i8, z2, i6, i7, list2, function13, selectionController2, colorProducer2);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-VhcvRP8, reason: not valid java name */
    public final SelectableTextAnnotatedStringElement m16487copyVhcvRP8(@NotNull AnnotatedString text, @NotNull TextStyle style, @NotNull FontFamily.Resolver fontFamilyResolver, @Nullable Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, @Nullable List<AnnotatedString.Range<Placeholder>> placeholders, @Nullable Function1<? super List<Rect>, Unit> onPlaceholderLayout, @Nullable SelectionController selectionController, @Nullable ColorProducer color) {
        return new SelectableTextAnnotatedStringElement(text, style, fontFamilyResolver, onTextLayout, overflow, softWrap, maxLines, minLines, placeholders, onPlaceholderLayout, selectionController, color, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) other;
        return Intrinsics.areEqual(this.color, selectableTextAnnotatedStringElement.color) && Intrinsics.areEqual(this.text, selectableTextAnnotatedStringElement.text) && Intrinsics.areEqual(this.style, selectableTextAnnotatedStringElement.style) && Intrinsics.areEqual(this.placeholders, selectableTextAnnotatedStringElement.placeholders) && Intrinsics.areEqual(this.fontFamilyResolver, selectableTextAnnotatedStringElement.fontFamilyResolver) && this.onTextLayout == selectableTextAnnotatedStringElement.onTextLayout && TextOverflow.m20899equalsimpl0(this.overflow, selectableTextAnnotatedStringElement.overflow) && this.softWrap == selectableTextAnnotatedStringElement.softWrap && this.maxLines == selectableTextAnnotatedStringElement.maxLines && this.minLines == selectableTextAnnotatedStringElement.minLines && this.onPlaceholderLayout == selectableTextAnnotatedStringElement.onPlaceholderLayout && Intrinsics.areEqual(this.selectionController, selectableTextAnnotatedStringElement.selectionController);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = (this.fontFamilyResolver.hashCode() + AbstractC1038a.m1201b(this.text.hashCode() * 31, 31, this.style)) * 31;
        Function1<TextLayoutResult, Unit> function1 = this.onTextLayout;
        int iM1160f = (((AbstractC0622a.m1160f(this.softWrap, (TextOverflow.m20900hashCodeimpl(this.overflow) + ((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31)) * 31, 31) + this.maxLines) * 31) + this.minLines) * 31;
        List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
        int iHashCode2 = (iM1160f + (list != null ? list.hashCode() : 0)) * 31;
        Function1<List<Rect>, Unit> function12 = this.onPlaceholderLayout;
        int iHashCode3 = (iHashCode2 + (function12 != null ? function12.hashCode() : 0)) * 31;
        SelectionController selectionController = this.selectionController;
        int iHashCode4 = (iHashCode3 + (selectionController != null ? selectionController.hashCode() : 0)) * 31;
        ColorProducer colorProducer = this.color;
        return iHashCode4 + (colorProducer != null ? colorProducer.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SelectableTextAnnotatedStringElement(text=" + ((Object) this.text) + ", style=" + this.style + ", fontFamilyResolver=" + this.fontFamilyResolver + ", onTextLayout=" + this.onTextLayout + ", overflow=" + ((Object) TextOverflow.m20901toStringimpl(this.overflow)) + ", softWrap=" + this.softWrap + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", placeholders=" + this.placeholders + ", onPlaceholderLayout=" + this.onPlaceholderLayout + ", selectionController=" + this.selectionController + ", color=" + this.color + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i4, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i5 & 8) != 0 ? null : function1, (i5 & 16) != 0 ? TextOverflow.INSTANCE.m20906getClipgIe3tQ8() : i, (i5 & 32) != 0 ? true : z, (i5 & 64) != 0 ? Integer.MAX_VALUE : i2, (i5 & 128) != 0 ? 1 : i4, (i5 & 256) != 0 ? null : list, (i5 & 512) != 0 ? null : function12, (i5 & 1024) != 0 ? null : selectionController, (i5 & 2048) != 0 ? null : colorProducer, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public SelectableTextAnnotatedStringNode getNode() {
        return new SelectableTextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, null, 4096, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull SelectableTextAnnotatedStringNode node) {
        node.m16488updateL09Iy8E(this.text, this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i4, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.onTextLayout = function1;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i4;
        this.placeholders = list;
        this.onPlaceholderLayout = function12;
        this.selectionController = selectionController;
        this.color = colorProducer;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
    }
}
