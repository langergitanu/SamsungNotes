package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p109ui.input.key.Key;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"platformDefaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getPlatformDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class KeyMapping_androidKt {

    @NotNull
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        @Nullable
        /* JADX INFO: renamed from: map-ZmokQxo */
        public KeyCommand mo16169mapZmokQxo(@NotNull KeyEvent event) {
            KeyCommand keyCommand = null;
            if (KeyEvent_androidKt.m19590isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m19587isAltPressedZmokQxo(event)) {
                long jM19584getKeyZmokQxo = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                MappedKeys mappedKeys = MappedKeys.INSTANCE;
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16208getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16209getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16210getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16207getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyEvent_androidKt.m19587isAltPressedZmokQxo(event)) {
                long jM19584getKeyZmokQxo2 = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16208getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16209getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16210getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16207getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo16169mapZmokQxo(event) : keyCommand;
        }
    };

    @NotNull
    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
