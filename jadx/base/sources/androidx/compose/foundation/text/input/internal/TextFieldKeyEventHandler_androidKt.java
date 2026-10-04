package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import androidx.compose.p109ui.input.key.Key_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m13886d2 = {"isFromSoftKeyboard", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isFromSoftKeyboard-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "createTextFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "isKeyCode", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextFieldKeyEventHandler_androidKt {
    @NotNull
    public static final TextFieldKeyEventHandler createTextFieldKeyEventHandler() {
        return new AndroidTextFieldKeyEventHandler();
    }

    /* JADX INFO: renamed from: isFromSoftKeyboard-ZmokQxo, reason: not valid java name */
    public static final boolean m16374isFromSoftKeyboardZmokQxo(@NotNull KeyEvent keyEvent) {
        return (keyEvent.getFlags() & 2) == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m16375isKeyCodeYhN2O0w(KeyEvent keyEvent, int i) {
        return Key_androidKt.m19591getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m19584getKeyZmokQxo(keyEvent)) == i;
    }
}
