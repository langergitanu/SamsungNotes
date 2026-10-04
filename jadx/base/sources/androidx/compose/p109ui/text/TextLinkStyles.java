package androidx.compose.p109ui.text;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/TextLinkStyles;", "", "style", "Landroidx/compose/ui/text/SpanStyle;", "focusedStyle", "hoveredStyle", "pressedStyle", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;)V", "getFocusedStyle", "()Landroidx/compose/ui/text/SpanStyle;", "getHoveredStyle", "getPressedStyle", "getStyle", "equals", "", "other", "hashCode", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextLinkStyles {
    public static final int $stable = 0;

    @Nullable
    private final SpanStyle focusedStyle;

    @Nullable
    private final SpanStyle hoveredStyle;

    @Nullable
    private final SpanStyle pressedStyle;

    @Nullable
    private final SpanStyle style;

    public TextLinkStyles() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TextLinkStyles)) {
            return false;
        }
        TextLinkStyles textLinkStyles = (TextLinkStyles) other;
        return Intrinsics.areEqual(this.style, textLinkStyles.style) && Intrinsics.areEqual(this.focusedStyle, textLinkStyles.focusedStyle) && Intrinsics.areEqual(this.hoveredStyle, textLinkStyles.hoveredStyle) && Intrinsics.areEqual(this.pressedStyle, textLinkStyles.pressedStyle);
    }

    @Nullable
    public final SpanStyle getFocusedStyle() {
        return this.focusedStyle;
    }

    @Nullable
    public final SpanStyle getHoveredStyle() {
        return this.hoveredStyle;
    }

    @Nullable
    public final SpanStyle getPressedStyle() {
        return this.pressedStyle;
    }

    @Nullable
    public final SpanStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        SpanStyle spanStyle = this.style;
        int iHashCode = (spanStyle != null ? spanStyle.hashCode() : 0) * 31;
        SpanStyle spanStyle2 = this.focusedStyle;
        int iHashCode2 = (iHashCode + (spanStyle2 != null ? spanStyle2.hashCode() : 0)) * 31;
        SpanStyle spanStyle3 = this.hoveredStyle;
        int iHashCode3 = (iHashCode2 + (spanStyle3 != null ? spanStyle3.hashCode() : 0)) * 31;
        SpanStyle spanStyle4 = this.pressedStyle;
        return iHashCode3 + (spanStyle4 != null ? spanStyle4.hashCode() : 0);
    }

    public TextLinkStyles(@Nullable SpanStyle spanStyle, @Nullable SpanStyle spanStyle2, @Nullable SpanStyle spanStyle3, @Nullable SpanStyle spanStyle4) {
        this.style = spanStyle;
        this.focusedStyle = spanStyle2;
        this.hoveredStyle = spanStyle3;
        this.pressedStyle = spanStyle4;
    }

    public /* synthetic */ TextLinkStyles(SpanStyle spanStyle, SpanStyle spanStyle2, SpanStyle spanStyle3, SpanStyle spanStyle4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : spanStyle, (i & 2) != 0 ? null : spanStyle2, (i & 4) != 0 ? null : spanStyle3, (i & 8) != 0 ? null : spanStyle4);
    }
}
