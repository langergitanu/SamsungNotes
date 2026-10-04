package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@TargetClass(className = "io.netty.util.internal.CleanerJava6")
final class CleanerJava6Substitution {

    @RecomputeFieldValue(declClassName = "java.nio.DirectByteBuffer", kind = RecomputeFieldValue.Kind.FieldOffset, name = "cleaner")
    @Alias
    private static long CLEANER_FIELD_OFFSET;

    private CleanerJava6Substitution() {
    }
}
