package androidx.compose.foundation.text.input;

import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0016J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/foundation/text/input/MaxLengthFilter;", "Landroidx/compose/foundation/text/input/InputTransformation;", "maxLength", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInputTransformation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputTransformation.kt\nandroidx/compose/foundation/text/input/MaxLengthFilter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,254:1\n1#2:255\n*E\n"})
final /* data */ class MaxLengthFilter implements InputTransformation {
    private final int maxLength;

    public MaxLengthFilter(int i) {
        this.maxLength = i;
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "maxLength must be at least zero, was ").toString());
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getMaxLength() {
        return this.maxLength;
    }

    public static /* synthetic */ MaxLengthFilter copy$default(MaxLengthFilter maxLengthFilter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = maxLengthFilter.maxLength;
        }
        return maxLengthFilter.copy(i);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setMaxTextLength(semanticsPropertyReceiver, this.maxLength);
    }

    @NotNull
    public final MaxLengthFilter copy(int maxLength) {
        return new MaxLengthFilter(maxLength);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MaxLengthFilter) && this.maxLength == ((MaxLengthFilter) other).maxLength;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxLength);
    }

    @NotNull
    public String toString() {
        return AbstractC0000a.m13j(new StringBuilder("InputTransformation.maxLength("), this.maxLength, PropertyUtils.MAPPED_DELIM2);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(@NotNull TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.getLength() > this.maxLength) {
            textFieldBuffer.revertAllChanges();
        }
    }
}
