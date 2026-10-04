package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.p109ui.input.key.KeyEventType;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import androidx.compose.p109ui.input.key.Key_androidKt;
import androidx.compose.p109ui.node.DelegatableNode;
import androidx.compose.p109ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\r\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0010H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0018\u0010\u000b\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0011"}, m13886d2 = {"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "isClick", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "isPress", "isPress-ZmokQxo", "isComposeRootInScrollableContainer", "Landroidx/compose/ui/node/DelegatableNode;", "isInScrollableViewGroup", "Landroid/view/View;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m15454isClickZmokQxo(@NotNull KeyEvent keyEvent) {
        return KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m19582getKeyUpCS__XNY()) && m15455isEnterZmokQxo(keyEvent);
    }

    public static final boolean isComposeRootInScrollableContainer(@NotNull DelegatableNode delegatableNode) {
        return isInScrollableViewGroup(DelegatableNode_androidKt.requireView(delegatableNode));
    }

    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m15455isEnterZmokQxo(KeyEvent keyEvent) {
        int iM19591getNativeKeyCodeYVgTNJs = Key_androidKt.m19591getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m19584getKeyZmokQxo(keyEvent));
        return iM19591getNativeKeyCodeYVgTNJs == 23 || iM19591getNativeKeyCodeYVgTNJs == 66 || iM19591getNativeKeyCodeYVgTNJs == 160;
    }

    private static final boolean isInScrollableViewGroup(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }

    /* JADX INFO: renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m15456isPressZmokQxo(@NotNull KeyEvent keyEvent) {
        return KeyEventType.m19577equalsimpl0(KeyEvent_androidKt.m19585getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m19581getKeyDownCS__XNY()) && m15455isEnterZmokQxo(keyEvent);
    }
}
