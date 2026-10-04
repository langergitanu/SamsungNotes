package androidx.compose.foundation.text.input;

import androidx.compose.p109ui.text.intl.Locale;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001aD\u0010\u0004\u001a\u00020\u0001*\u00020\u000126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¨\u0006\u0010"}, m13886d2 = {"allCaps", "Landroidx/compose/foundation/text/input/InputTransformation;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "byValue", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "maxLength", "", "then", "next", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class InputTransformationKt {
    @Stable
    @NotNull
    public static final InputTransformation allCaps(@NotNull InputTransformation inputTransformation, @NotNull Locale locale) {
        return then(inputTransformation, new AllCapsTransformation(locale));
    }

    @Stable
    @NotNull
    public static final InputTransformation byValue(@NotNull InputTransformation inputTransformation, @NotNull Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> function2) {
        return then(inputTransformation, new InputTransformationByValue(function2));
    }

    @Stable
    @NotNull
    public static final InputTransformation maxLength(@NotNull InputTransformation inputTransformation, int i) {
        return then(inputTransformation, new MaxLengthFilter(i));
    }

    @Stable
    @NotNull
    public static final InputTransformation then(@NotNull InputTransformation inputTransformation, @NotNull InputTransformation inputTransformation2) {
        return new FilterChain(inputTransformation, inputTransformation2);
    }
}
