package kotlinx.coroutines.test;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0002j\u0002`\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Lkotlinx/coroutines/test/UncaughtExceptionsBeforeTest;", "Lkotlin/IllegalStateException;", "Ljava/lang/IllegalStateException;", "<init>", "()V", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UncaughtExceptionsBeforeTest extends IllegalStateException {
    public UncaughtExceptionsBeforeTest() {
        super("There were uncaught exceptions before the test started. Please avoid this, as such exceptions are also reported in a platform-dependent manner so that they are not lost.");
    }
}
