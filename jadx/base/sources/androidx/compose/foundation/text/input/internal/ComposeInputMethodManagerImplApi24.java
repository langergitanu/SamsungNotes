package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0013\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi24;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi21;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "sendKeyEvent", "", "event", "Landroid/view/KeyEvent;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
class ComposeInputMethodManagerImplApi24 extends ComposeInputMethodManagerImplApi21 {
    public ComposeInputMethodManagerImplApi24(@NotNull View view) {
        super(view);
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManagerImplApi21, androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void sendKeyEvent(@NotNull KeyEvent event) {
        requireImm().dispatchKeyEventFromInputMethod(getView(), event);
    }
}
