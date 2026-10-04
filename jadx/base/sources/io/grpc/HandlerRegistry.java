package io.grpc;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ThreadSafe
public abstract class HandlerRegistry {
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getServices() {
        return Collections.EMPTY_LIST;
    }

    @Nullable
    public final ServerMethodDefinition<?, ?> lookupMethod(String str) {
        return lookupMethod(str, null);
    }

    @Nullable
    public abstract ServerMethodDefinition<?, ?> lookupMethod(String str, @Nullable String str2);
}
