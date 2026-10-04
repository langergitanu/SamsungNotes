package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p109ui.input.key.KeyEventType;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, m13886d2 = {"showCharacterPalette", "", "cancelsTextSelection", "", "Landroidx/compose/ui/input/key/KeyEvent;", "cancelsTextSelection-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class KeyEventHelpers_androidKt {
    /* JADX INFO: renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m16168cancelsTextSelectionZmokQxo(@NotNull KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 4 && KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m19582getKeyUpCS__XNY());
    }

    public static final void showCharacterPalette() {
    }
}
