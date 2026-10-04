package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TestBuildersKt__TestBuildersKt$handleTimeout$activeChildren$1 implements Function1<Job, Boolean> {
    public static final TestBuildersKt__TestBuildersKt$handleTimeout$activeChildren$1 INSTANCE = new TestBuildersKt__TestBuildersKt$handleTimeout$activeChildren$1();

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Job job) {
        return Boolean.valueOf(job.isActive());
    }
}
