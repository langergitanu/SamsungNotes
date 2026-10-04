package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TypedBuffer {
    public static Buffer decorate(Buffer buffer, Class cls) {
        return new PredicatedBuffer(buffer, InstanceofPredicate.getInstance(cls));
    }
}
