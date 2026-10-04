package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
public /* synthetic */ class TestBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1 extends FunctionReferenceImpl implements Function1<String, Duration> {
    public TestBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1(Object obj) {
        super(1, obj, Duration.Companion.class, "parse", "parse-UwyO8pc(Ljava/lang/String;)J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Duration invoke(String str) {
        return Duration.m23552boximpl(m23788invoke5sfh64U(str));
    }

    /* JADX INFO: renamed from: invoke-5sfh64U, reason: not valid java name */
    public final long m23788invoke5sfh64U(String str) {
        return ((Duration.Companion) this.receiver).m23646parseUwyO8pc(str);
    }
}
