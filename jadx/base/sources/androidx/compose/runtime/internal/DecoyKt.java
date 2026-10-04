package androidx.compose.runtime.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.ComposeCompilerApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m13886d2 = {"illegalDecoyCallException", "", "fName", "", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DecoyKt {
    @ComposeCompilerApi
    @NotNull
    public static final Void illegalDecoyCallException(@NotNull String str) {
        throw new IllegalStateException(AbstractC0541b.m773o("Function ", str, " should have been replaced by compiler."));
    }
}
