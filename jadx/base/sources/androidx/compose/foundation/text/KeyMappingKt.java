package androidx.compose.foundation.text;

import androidx.compose.p109ui.input.key.Key;
import androidx.compose.p109ui.input.key.KeyEvent;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\t"}, m13886d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class KeyMappingKt {

    @NotNull
    private static final KeyMapping defaultKeyMapping;

    static {
        final KeyMapping keyMappingCommonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m19588isCtrlPressedZmokQxo(((KeyEvent) obj).m19573unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            @Nullable
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo16169mapZmokQxo(@NotNull android.view.KeyEvent event) {
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m19590isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m19588isCtrlPressedZmokQxo(event)) {
                    long jM19584getKeyZmokQxo = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16208getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16209getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16210getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16207getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m19588isCtrlPressedZmokQxo(event)) {
                    long jM19584getKeyZmokQxo2 = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16208getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16209getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16210getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16207getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16212getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16206getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16202getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16201getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m19590isShiftPressedZmokQxo(event)) {
                    long jM19584getKeyZmokQxo3 = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16215getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16214getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    }
                } else if (KeyEvent_androidKt.m19587isAltPressedZmokQxo(event)) {
                    long jM19584getKeyZmokQxo4 = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                    MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo4, mappedKeys4.m16202getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo4, mappedKeys4.m16206getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? keyMappingCommonKeyMapping.mo16169mapZmokQxo(event) : keyCommand;
            }
        };
    }

    @NotNull
    public static final KeyMapping commonKeyMapping(@NotNull final Function1<? super KeyEvent, Boolean> function1) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt.commonKeyMapping.1
            @Override // androidx.compose.foundation.text.KeyMapping
            @Nullable
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo16169mapZmokQxo(@NotNull android.view.KeyEvent event) {
                if (function1.invoke(KeyEvent.m19567boximpl(event)).booleanValue() && KeyEvent_androidKt.m19590isShiftPressedZmokQxo(event)) {
                    if (Key.m19276equalsimpl0(KeyEvent_androidKt.m19584getKeyZmokQxo(event), MappedKeys.INSTANCE.m16223getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (function1.invoke(KeyEvent.m19567boximpl(event)).booleanValue()) {
                    long jM19584getKeyZmokQxo = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16203getCEK5gGoQ()) ? true : Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16213getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16220getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16221getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16200getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16222getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo, mappedKeys.m16223getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m19588isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m19590isShiftPressedZmokQxo(event)) {
                    long jM19584getKeyZmokQxo2 = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16208getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16209getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16210getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16207getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16217getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16216getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16215getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16214getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo2, mappedKeys2.m16213getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long jM19584getKeyZmokQxo3 = KeyEvent_androidKt.m19584getKeyZmokQxo(event);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16208getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16209getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16210getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16207getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16217getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16216getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16215getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16214getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16211getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16202getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16206getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16218getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16205getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16204getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m19276equalsimpl0(jM19584getKeyZmokQxo3, mappedKeys3.m16219getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    @NotNull
    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }
}
