package androidx.compose.foundation.text.input.internal;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00126\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0018\u001a\u00020\bHÂ\u0003J\t\u0010\u0019\u001a\u00020\nHÂ\u0003J9\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014HÂ\u0003Jk\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n28\b\u0002\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014HÆ\u0001J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0002H\u0016J\f\u0010&\u001a\u00020\u0013*\u00020'H\u0016R>\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;)V", "component1", "component2", "component3", "component4", "component5", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class TextFieldTextLayoutModifier extends ModifierNodeElement<TextFieldTextLayoutModifierNode> {
    public static final int $stable = 0;

    @Nullable
    private final Function2<Density, Function0<TextLayoutResult>, Unit> onTextLayout;
    private final boolean singleLine;

    @NotNull
    private final TransformedTextFieldState textFieldState;

    @NotNull
    private final TextLayoutState textLayoutState;

    @NotNull
    private final TextStyle textStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldTextLayoutModifier(@NotNull TextLayoutState textLayoutState, @NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextStyle textStyle, boolean z, @Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.textLayoutState = textLayoutState;
        this.textFieldState = transformedTextFieldState;
        this.textStyle = textStyle;
        this.singleLine = z;
        this.onTextLayout = function2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final TextStyle getTextStyle() {
        return this.textStyle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final boolean getSingleLine() {
        return this.singleLine;
    }

    private final Function2<Density, Function0<TextLayoutResult>, Unit> component5() {
        return this.onTextLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextFieldTextLayoutModifier copy$default(TextFieldTextLayoutModifier textFieldTextLayoutModifier, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            textLayoutState = textFieldTextLayoutModifier.textLayoutState;
        }
        if ((i & 2) != 0) {
            transformedTextFieldState = textFieldTextLayoutModifier.textFieldState;
        }
        if ((i & 4) != 0) {
            textStyle = textFieldTextLayoutModifier.textStyle;
        }
        if ((i & 8) != 0) {
            z = textFieldTextLayoutModifier.singleLine;
        }
        if ((i & 16) != 0) {
            function2 = textFieldTextLayoutModifier.onTextLayout;
        }
        Function2 function22 = function2;
        TextStyle textStyle2 = textStyle;
        return textFieldTextLayoutModifier.copy(textLayoutState, transformedTextFieldState, textStyle2, z, function22);
    }

    @NotNull
    public final TextFieldTextLayoutModifier copy(@NotNull TextLayoutState textLayoutState, @NotNull TransformedTextFieldState textFieldState, @NotNull TextStyle textStyle, boolean singleLine, @Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout) {
        return new TextFieldTextLayoutModifier(textLayoutState, textFieldState, textStyle, singleLine, onTextLayout);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldTextLayoutModifier)) {
            return false;
        }
        TextFieldTextLayoutModifier textFieldTextLayoutModifier = (TextFieldTextLayoutModifier) other;
        return Intrinsics.areEqual(this.textLayoutState, textFieldTextLayoutModifier.textLayoutState) && Intrinsics.areEqual(this.textFieldState, textFieldTextLayoutModifier.textFieldState) && Intrinsics.areEqual(this.textStyle, textFieldTextLayoutModifier.textStyle) && this.singleLine == textFieldTextLayoutModifier.singleLine && Intrinsics.areEqual(this.onTextLayout, textFieldTextLayoutModifier.onTextLayout);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        int iM1160f = AbstractC0622a.m1160f(this.singleLine, AbstractC1038a.m1201b((this.textFieldState.hashCode() + (this.textLayoutState.hashCode() * 31)) * 31, 31, this.textStyle), 31);
        Function2<Density, Function0<TextLayoutResult>, Unit> function2 = this.onTextLayout;
        return iM1160f + (function2 == null ? 0 : function2.hashCode());
    }

    @NotNull
    public String toString() {
        return "TextFieldTextLayoutModifier(textLayoutState=" + this.textLayoutState + ", textFieldState=" + this.textFieldState + ", textStyle=" + this.textStyle + ", singleLine=" + this.singleLine + ", onTextLayout=" + this.onTextLayout + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public TextFieldTextLayoutModifierNode getNode() {
        return new TextFieldTextLayoutModifierNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull TextFieldTextLayoutModifierNode node) {
        node.updateNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
    }
}
