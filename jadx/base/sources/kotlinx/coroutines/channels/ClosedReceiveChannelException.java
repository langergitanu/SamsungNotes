package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0002j\u0002`\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lkotlinx/coroutines/channels/ClosedReceiveChannelException;", "Lkotlin/NoSuchElementException;", "Ljava/util/NoSuchElementException;", "message", "", "<init>", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ClosedReceiveChannelException extends NoSuchElementException {
    public ClosedReceiveChannelException(@Nullable String str) {
        super(str);
    }
}
