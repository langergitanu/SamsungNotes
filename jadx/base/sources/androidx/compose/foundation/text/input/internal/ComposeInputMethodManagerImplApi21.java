package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi21;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImpl;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "sendKeyEvent", "", "event", "Landroid/view/KeyEvent;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposeInputMethodManager.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeInputMethodManager.android.kt\nandroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi21\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n1#2:218\n*E\n"})
class ComposeInputMethodManagerImplApi21 extends ComposeInputMethodManagerImpl {

    @Nullable
    private BaseInputConnection baseInputConnection;

    public ComposeInputMethodManagerImplApi21(@NotNull View view) {
        super(view);
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManager
    public void sendKeyEvent(@NotNull KeyEvent event) {
        BaseInputConnection baseInputConnection = this.baseInputConnection;
        if (baseInputConnection == null) {
            baseInputConnection = new BaseInputConnection(getView(), false);
            this.baseInputConnection = baseInputConnection;
        }
        baseInputConnection.sendKeyEvent(event);
    }
}
