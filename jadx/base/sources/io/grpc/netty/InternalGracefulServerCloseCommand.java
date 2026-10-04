package io.grpc.netty;

import io.grpc.Internal;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalGracefulServerCloseCommand {
    private InternalGracefulServerCloseCommand() {
    }

    public static Object create(String str) {
        return new GracefulServerCloseCommand(str);
    }

    public static Object create(String str, long j, TimeUnit timeUnit) {
        return new GracefulServerCloseCommand(str, j, timeUnit);
    }
}
