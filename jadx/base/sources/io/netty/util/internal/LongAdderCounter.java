package io.netty.util.internal;

import java.util.concurrent.atomic.LongAdder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class LongAdderCounter extends LongAdder implements LongCounter {
    @Override // io.netty.util.internal.LongCounter
    public long value() {
        return longValue();
    }
}
