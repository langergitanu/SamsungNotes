package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusDirection;
import androidx.compose.p109ui.focus.FocusManager;
import androidx.compose.p109ui.input.key.KeyEvent;
import androidx.compose.p109ui.input.key.KeyEventType;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import androidx.compose.p109ui.input.key.KeyInputModifierKt;
import androidx.compose.p109ui.input.key.Key_androidKt;
import androidx.compose.p109ui.platform.SoftwareKeyboardController;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, m13886d2 = {"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "isKeyCode", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextFieldFocusModifier_androidKt {
    @NotNull
    public static final Modifier interceptDPadAndMoveFocus(@NotNull Modifier modifier, @NotNull final LegacyTextFieldState legacyTextFieldState, @NotNull final FocusManager focusManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m16245invokeZmokQxo(keyEvent.m19573unboximpl());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m16245invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                InputDevice device = keyEvent.getDevice();
                boolean zMo18211moveFocus3ESFkO8 = false;
                if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m19581getKeyDownCS__XNY()) && keyEvent.getSource() != 257) {
                    if (TextFieldFocusModifier_androidKt.m16244isKeyCodeYhN2O0w(keyEvent, 19)) {
                        zMo18211moveFocus3ESFkO8 = focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18209getUpdhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m16244isKeyCodeYhN2O0w(keyEvent, 20)) {
                        zMo18211moveFocus3ESFkO8 = focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18202getDowndhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m16244isKeyCodeYhN2O0w(keyEvent, 21)) {
                        zMo18211moveFocus3ESFkO8 = focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18205getLeftdhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m16244isKeyCodeYhN2O0w(keyEvent, 22)) {
                        zMo18211moveFocus3ESFkO8 = focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18208getRightdhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m16244isKeyCodeYhN2O0w(keyEvent, 23)) {
                        SoftwareKeyboardController keyboardController = legacyTextFieldState.getKeyboardController();
                        if (keyboardController != null) {
                            keyboardController.show();
                        }
                        zMo18211moveFocus3ESFkO8 = true;
                    }
                }
                return Boolean.valueOf(zMo18211moveFocus3ESFkO8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m16244isKeyCodeYhN2O0w(android.view.KeyEvent keyEvent, int i) {
        return Key_androidKt.m19591getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m19584getKeyZmokQxo(keyEvent)) == i;
    }
}
