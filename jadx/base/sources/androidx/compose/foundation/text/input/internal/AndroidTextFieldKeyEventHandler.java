package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.p109ui.focus.FocusDirection;
import androidx.compose.p109ui.focus.FocusManager;
import androidx.compose.p109ui.input.key.KeyEventType;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import androidx.compose.p109ui.platform.SoftwareKeyboardController;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "()V", "onKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-6ptp14s", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 0;

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* JADX INFO: renamed from: onKeyEvent-6ptp14s, reason: not valid java name */
    public boolean mo16306onKeyEvent6ptp14s(@NotNull KeyEvent event, @NotNull TransformedTextFieldState textFieldState, @NotNull TextLayoutState textLayoutState, @NotNull TextFieldSelectionState textFieldSelectionState, boolean editable, boolean singleLine, @NotNull Function0<Unit> onSubmit) {
        if (KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(event), KeyEventType.INSTANCE.m19581getKeyDownCS__XNY()) && event.isFromSource(257) && !TextFieldKeyEventHandler_androidKt.m16374isFromSoftKeyboardZmokQxo(event)) {
            textFieldSelectionState.setInTouchMode(false);
        }
        return super.mo16306onKeyEvent6ptp14s(event, textFieldState, textLayoutState, textFieldSelectionState, editable, singleLine, onSubmit);
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* JADX INFO: renamed from: onPreKeyEvent-MyFupTE, reason: not valid java name */
    public boolean mo16307onPreKeyEventMyFupTE(@NotNull KeyEvent event, @NotNull TransformedTextFieldState textFieldState, @NotNull TextFieldSelectionState textFieldSelectionState, @NotNull FocusManager focusManager, @NotNull SoftwareKeyboardController keyboardController) {
        if (super.mo16307onPreKeyEventMyFupTE(event, textFieldState, textFieldSelectionState, focusManager, keyboardController)) {
            return true;
        }
        InputDevice device = event.getDevice();
        if (device == null || !device.supportsSource(InputDeviceCompat.SOURCE_DPAD) || device.isVirtual() || !KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(event), KeyEventType.INSTANCE.m19581getKeyDownCS__XNY()) || event.getSource() == 257) {
            return false;
        }
        if (TextFieldKeyEventHandler_androidKt.m16375isKeyCodeYhN2O0w(event, 19)) {
            return focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18209getUpdhqQ8s());
        }
        if (TextFieldKeyEventHandler_androidKt.m16375isKeyCodeYhN2O0w(event, 20)) {
            return focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18202getDowndhqQ8s());
        }
        if (TextFieldKeyEventHandler_androidKt.m16375isKeyCodeYhN2O0w(event, 21)) {
            return focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18205getLeftdhqQ8s());
        }
        if (TextFieldKeyEventHandler_androidKt.m16375isKeyCodeYhN2O0w(event, 22)) {
            return focusManager.mo18211moveFocus3ESFkO8(FocusDirection.INSTANCE.m18208getRightdhqQ8s());
        }
        if (!TextFieldKeyEventHandler_androidKt.m16375isKeyCodeYhN2O0w(event, 23)) {
            return false;
        }
        keyboardController.show();
        return true;
    }
}
