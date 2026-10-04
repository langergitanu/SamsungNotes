package androidx.compose.foundation.text.input.internal;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(25)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/Api25CommitContentImpl;", "", "()V", "commitContent", "", "inputConnection", "Landroid/view/inputmethod/InputConnection;", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "", "opts", "Landroid/os/Bundle;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class Api25CommitContentImpl {

    @NotNull
    public static final Api25CommitContentImpl INSTANCE = new Api25CommitContentImpl();

    private Api25CommitContentImpl() {
    }

    @DoNotInline
    public final boolean commitContent(@NotNull InputConnection inputConnection, @NotNull InputContentInfo inputContentInfo, int flags, @Nullable Bundle opts) {
        return inputConnection.commitContent(inputContentInfo, flags, opts);
    }
}
