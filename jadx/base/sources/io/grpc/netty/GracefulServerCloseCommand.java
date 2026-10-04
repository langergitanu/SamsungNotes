package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.netty.WriteQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class GracefulServerCloseCommand extends WriteQueue.AbstractQueuedCommand {
    private final String goAwayDebugString;
    private final long graceTime;
    private final TimeUnit graceTimeUnit;

    public GracefulServerCloseCommand(String str) {
        this(str, -1L, null);
    }

    public String getGoAwayDebugString() {
        return this.goAwayDebugString;
    }

    public long getGraceTime() {
        return this.graceTime;
    }

    public TimeUnit getGraceTimeUnit() {
        return this.graceTimeUnit;
    }

    public GracefulServerCloseCommand(String str, long j, TimeUnit timeUnit) {
        this.goAwayDebugString = (String) Preconditions.checkNotNull(str, "goAwayDebugString");
        this.graceTime = j;
        this.graceTimeUnit = timeUnit;
    }
}
