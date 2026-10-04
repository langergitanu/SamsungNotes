package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.p109ui.text.StringKt;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.p109ui.text.input.KeyboardCapitalization;
import androidx.compose.p109ui.text.input.PlatformImeOptions;
import androidx.compose.p109ui.text.intl.Locale;
import androidx.compose.p109ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/foundation/text/input/AllCapsTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "(Landroidx/compose/ui/text/intl/Locale;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInputTransformation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputTransformation.kt\nandroidx/compose/foundation/text/input/AllCapsTransformation\n+ 2 TextFieldBuffer.kt\nandroidx/compose/foundation/text/input/TextFieldBufferKt\n*L\n1#1,254:1\n465#2,7:255\n*S KotlinDebug\n*F\n+ 1 InputTransformation.kt\nandroidx/compose/foundation/text/input/AllCapsTransformation\n*L\n217#1:255,7\n*E\n"})
final /* data */ class AllCapsTransformation implements InputTransformation {

    @NotNull
    private final KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m20665getCharactersIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 126, (DefaultConstructorMarker) null);

    @NotNull
    private final Locale locale;

    public AllCapsTransformation(@NotNull Locale locale) {
        this.locale = locale;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Locale getLocale() {
        return this.locale;
    }

    public static /* synthetic */ AllCapsTransformation copy$default(AllCapsTransformation allCapsTransformation, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = allCapsTransformation.locale;
        }
        return allCapsTransformation.copy(locale);
    }

    @NotNull
    public final AllCapsTransformation copy(@NotNull Locale locale) {
        return new AllCapsTransformation(locale);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AllCapsTransformation) && Intrinsics.areEqual(this.locale, ((AllCapsTransformation) other).locale);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    @NotNull
    public KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public int hashCode() {
        return this.locale.hashCode();
    }

    @NotNull
    public String toString() {
        return "InputTransformation.allCaps(locale=" + this.locale + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(@NotNull TextFieldBuffer textFieldBuffer) {
        TextFieldBuffer.ChangeList changes = textFieldBuffer.getChanges();
        for (int i = 0; i < changes.getChangeCount(); i++) {
            long jMo16279getRangejx7JFs = changes.mo16279getRangejx7JFs(i);
            changes.mo16278getOriginalRangejx7JFs(i);
            if (!TextRange.m20450getCollapsedimpl(jMo16279getRangejx7JFs)) {
                textFieldBuffer.replace(TextRange.m20454getMinimpl(jMo16279getRangejx7JFs), TextRange.m20453getMaximpl(jMo16279getRangejx7JFs), StringKt.toUpperCase(TextRangeKt.m20463substringFDrldGo(textFieldBuffer.asCharSequence(), jMo16279getRangejx7JFs), this.locale));
            }
        }
    }
}
