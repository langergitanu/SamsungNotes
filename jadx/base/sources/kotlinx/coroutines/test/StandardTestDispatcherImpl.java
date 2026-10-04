package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0010j\u0002`\u000fH\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lkotlinx/coroutines/test/StandardTestDispatcherImpl;", "Lkotlinx/coroutines/test/TestDispatcher;", "scheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "name", "", "<init>", "(Lkotlinx/coroutines/test/TestCoroutineScheduler;Ljava/lang/String;)V", "getScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "toString", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
final class StandardTestDispatcherImpl extends TestDispatcher {

    @Nullable
    private final String name;

    @NotNull
    private final TestCoroutineScheduler scheduler;

    /* JADX WARN: Multi-variable type inference failed */
    public StandardTestDispatcherImpl() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dispatch$lambda$0(Runnable runnable) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo23763dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        getScheduler().registerEvent$kotlinx_coroutines_test(this, 0L, block, context, new C13484a(0));
    }

    @Override // kotlinx.coroutines.test.TestDispatcher
    @NotNull
    public TestCoroutineScheduler getScheduler() {
        return this.scheduler;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    /* JADX INFO: renamed from: toString */
    public String getName() {
        StringBuilder sb = new StringBuilder();
        String str = this.name;
        if (str == null) {
            str = "StandardTestDispatcher";
        }
        sb.append(str);
        sb.append("[scheduler=");
        sb.append(getScheduler());
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    public /* synthetic */ StandardTestDispatcherImpl(TestCoroutineScheduler testCoroutineScheduler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new TestCoroutineScheduler() : testCoroutineScheduler, (i & 2) != 0 ? null : str);
    }

    public StandardTestDispatcherImpl(@NotNull TestCoroutineScheduler testCoroutineScheduler, @Nullable String str) {
        this.scheduler = testCoroutineScheduler;
        this.name = str;
    }
}
