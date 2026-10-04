package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B=\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\tJ9\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JC\u0010\r\u001a\u00020\u000028\b\u0002\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0016RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/foundation/text/input/InputTransformationByValue;", "Landroidx/compose/foundation/text/input/InputTransformation;", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "(Lkotlin/jvm/functions/Function2;)V", "getTransformation", "()Lkotlin/jvm/functions/Function2;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class InputTransformationByValue implements InputTransformation {

    @NotNull
    private final Function2<CharSequence, CharSequence, CharSequence> transformation;

    /* JADX WARN: Multi-variable type inference failed */
    public InputTransformationByValue(@NotNull Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> function2) {
        this.transformation = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputTransformationByValue copy$default(InputTransformationByValue inputTransformationByValue, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = inputTransformationByValue.transformation;
        }
        return inputTransformationByValue.copy(function2);
    }

    @NotNull
    public final Function2<CharSequence, CharSequence, CharSequence> component1() {
        return this.transformation;
    }

    @NotNull
    public final InputTransformationByValue copy(@NotNull Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> transformation) {
        return new InputTransformationByValue(transformation);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InputTransformationByValue) && Intrinsics.areEqual(this.transformation, ((InputTransformationByValue) other).transformation);
    }

    @NotNull
    public final Function2<CharSequence, CharSequence, CharSequence> getTransformation() {
        return this.transformation;
    }

    public int hashCode() {
        return this.transformation.hashCode();
    }

    @NotNull
    public String toString() {
        return "InputTransformation.byValue(transformation=" + this.transformation + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(@NotNull TextFieldBuffer textFieldBuffer) {
        TextFieldCharSequence textFieldCharSequenceM16273toTextFieldCharSequenceudt6zUU$foundation_release$default = TextFieldBuffer.m16273toTextFieldCharSequenceudt6zUU$foundation_release$default(textFieldBuffer, 0L, null, 3, null);
        CharSequence charSequenceInvoke = this.transformation.invoke(textFieldBuffer.getOriginalValue(), textFieldCharSequenceM16273toTextFieldCharSequenceudt6zUU$foundation_release$default);
        if (charSequenceInvoke == textFieldCharSequenceM16273toTextFieldCharSequenceudt6zUU$foundation_release$default) {
            return;
        }
        if (charSequenceInvoke == textFieldBuffer.getOriginalValue()) {
            textFieldBuffer.revertAllChanges();
        } else {
            textFieldBuffer.setTextIfChanged$foundation_release(charSequenceInvoke);
        }
    }
}
