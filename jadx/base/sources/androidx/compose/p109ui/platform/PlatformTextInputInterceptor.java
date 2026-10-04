package androidx.compose.p109ui.platform;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "", "interceptStartInputMethod", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "nextHandler", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Landroidx/compose/ui/platform/PlatformTextInputSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface PlatformTextInputInterceptor {
    @Nullable
    Object interceptStartInputMethod(@NotNull PlatformTextInputMethodRequest platformTextInputMethodRequest, @NotNull PlatformTextInputSession platformTextInputSession, @NotNull Continuation<?> continuation);
}
