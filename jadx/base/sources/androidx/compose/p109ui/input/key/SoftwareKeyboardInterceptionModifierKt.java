package androidx.compose.p109ui.input.key;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007\u001a \u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¨\u0006\u0006"}, m13886d2 = {"onInterceptKeyBeforeSoftKeyboard", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreInterceptKeyBeforeSoftKeyboard", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SoftwareKeyboardInterceptionModifierKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier onInterceptKeyBeforeSoftKeyboard(@NotNull Modifier modifier, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new SoftKeyboardInterceptionElement(function1, null));
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier onPreInterceptKeyBeforeSoftKeyboard(@NotNull Modifier modifier, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new SoftKeyboardInterceptionElement(null, function1));
    }
}
