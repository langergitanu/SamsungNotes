package androidx.compose.p109ui.text;

import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/text/CacheTextLayoutInput;", "", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "(Landroidx/compose/ui/text/TextLayoutInput;)V", "getTextLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "equals", "", "other", "hashCode", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CacheTextLayoutInput {
    public static final int $stable = 0;

    @NotNull
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(@NotNull TextLayoutInput textLayoutInput) {
        this.textLayoutInput = textLayoutInput;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        CacheTextLayoutInput cacheTextLayoutInput = (CacheTextLayoutInput) other;
        return Intrinsics.areEqual(textLayoutInput.getText(), cacheTextLayoutInput.textLayoutInput.getText()) && textLayoutInput.getStyle().hasSameLayoutAffectingAttributes(cacheTextLayoutInput.textLayoutInput.getStyle()) && Intrinsics.areEqual(textLayoutInput.getPlaceholders(), cacheTextLayoutInput.textLayoutInput.getPlaceholders()) && textLayoutInput.getMaxLines() == cacheTextLayoutInput.textLayoutInput.getMaxLines() && textLayoutInput.getSoftWrap() == cacheTextLayoutInput.textLayoutInput.getSoftWrap() && TextOverflow.m20899equalsimpl0(textLayoutInput.getOverflow(), cacheTextLayoutInput.textLayoutInput.getOverflow()) && Intrinsics.areEqual(textLayoutInput.getDensity(), cacheTextLayoutInput.textLayoutInput.getDensity()) && textLayoutInput.getLayoutDirection() == cacheTextLayoutInput.textLayoutInput.getLayoutDirection() && textLayoutInput.getFontFamilyResolver() == cacheTextLayoutInput.textLayoutInput.getFontFamilyResolver() && Constraints.m20921getMaxWidthimpl(textLayoutInput.getConstraints()) == Constraints.m20921getMaxWidthimpl(cacheTextLayoutInput.textLayoutInput.getConstraints()) && Constraints.m20920getMaxHeightimpl(textLayoutInput.getConstraints()) == Constraints.m20920getMaxHeightimpl(cacheTextLayoutInput.textLayoutInput.getConstraints());
    }

    @NotNull
    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        return Integer.hashCode(Constraints.m20920getMaxHeightimpl(textLayoutInput.getConstraints())) + ((Integer.hashCode(Constraints.m20921getMaxWidthimpl(textLayoutInput.getConstraints())) + ((textLayoutInput.getFontFamilyResolver().hashCode() + ((textLayoutInput.getLayoutDirection().hashCode() + ((textLayoutInput.getDensity().hashCode() + ((TextOverflow.m20900hashCodeimpl(textLayoutInput.getOverflow()) + ((Boolean.hashCode(textLayoutInput.getSoftWrap()) + ((textLayoutInput.getMaxLines() + ((textLayoutInput.getPlaceholders().hashCode() + ((textLayoutInput.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release() + (textLayoutInput.getText().hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }
}
