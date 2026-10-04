package androidx.compose.foundation.text.input.internal;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.VisibleForTesting;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"0\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m13886d2 = {"DEBUG_CLASS", "", "inputMethodManagerFactory", "Lkotlin/Function1;", "Landroid/view/View;", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "getInputMethodManagerFactory$annotations", "()V", "getInputMethodManagerFactory", "()Lkotlin/jvm/functions/Function1;", "setInputMethodManagerFactory", "(Lkotlin/jvm/functions/Function1;)V", "createLegacyPlatformTextInputServiceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LegacyPlatformTextInputServiceAdapter_androidKt {

    @NotNull
    private static final String DEBUG_CLASS = "AndroidLegacyPlatformTextInputServiceAdapter";

    @NotNull
    private static Function1<? super View, ? extends InputMethodManager> inputMethodManagerFactory = C1307xe9f87565.INSTANCE;

    @NotNull
    public static final LegacyPlatformTextInputServiceAdapter createLegacyPlatformTextInputServiceAdapter() {
        return new AndroidLegacyPlatformTextInputServiceAdapter();
    }

    @NotNull
    public static final Function1<View, InputMethodManager> getInputMethodManagerFactory() {
        return inputMethodManagerFactory;
    }

    public static final void setInputMethodManagerFactory(@NotNull Function1<? super View, ? extends InputMethodManager> function1) {
        inputMethodManagerFactory = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getInputMethodManagerFactory$annotations() {
    }
}
