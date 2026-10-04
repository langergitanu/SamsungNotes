package androidx.compose.p109ui.platform;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R \u0010\u0005\u001a\u00020\u00068WX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/platform/WindowInfo;", "", "isWindowFocused", "", "()Z", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A$annotations", "()V", "getKeyboardModifiers-k7X9c1A", "()I", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface WindowInfo {
    @ExperimentalComposeUiApi
    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name */
    default int mo20246getKeyboardModifiersk7X9c1A() {
        return WindowInfoImpl.INSTANCE.getGlobalKeyboardModifiers$ui_release().getValue().getPackedValue();
    }

    boolean isWindowFocused();

    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A$annotations, reason: not valid java name */
    static /* synthetic */ void m20245getKeyboardModifiersk7X9c1A$annotations() {
    }
}
