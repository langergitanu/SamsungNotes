package androidx.compose.p109ui.text.input;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(25)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0013\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi25;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi24;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function1;)V", "commitContent", "", "p0", "Landroid/view/inputmethod/InputContentInfo;", "p1", "", "p2", "Landroid/os/Bundle;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
class NullableInputConnectionWrapperApi25 extends NullableInputConnectionWrapperApi24 {
    public NullableInputConnectionWrapperApi25(@NotNull InputConnection inputConnection, @NotNull Function1<? super NullableInputConnectionWrapper, Unit> function1) {
        super(inputConnection, function1);
    }

    @Override // androidx.compose.p109ui.text.input.NullableInputConnectionWrapperApi21, android.view.inputmethod.InputConnection
    public final boolean commitContent(@NotNull InputContentInfo p0, int p1, @Nullable Bundle p2) {
        InputConnection delegate = getDelegate();
        if (delegate != null) {
            return delegate.commitContent(p0, p1, p2);
        }
        return false;
    }
}
