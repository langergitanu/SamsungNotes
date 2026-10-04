package kotlinx.coroutines;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\b¨\u0006\u0016"}, m13886d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "<init>", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Main", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Unconfined", "getUnconfined$annotations", "getUnconfined", "IO", "getIO$annotations", "getIO", "shutdown", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Dispatchers {

    @NotNull
    public static final Dispatchers INSTANCE = new Dispatchers();

    @NotNull
    private static final CoroutineDispatcher Default = DefaultScheduler.INSTANCE;

    @NotNull
    private static final CoroutineDispatcher Unconfined = Unconfined.INSTANCE;

    private Dispatchers() {
    }

    @NotNull
    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    @NotNull
    public static final CoroutineDispatcher getIO() {
        return DefaultIoScheduler.INSTANCE;
    }

    @NotNull
    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @NotNull
    public static final CoroutineDispatcher getUnconfined() {
        return Unconfined;
    }

    @DelicateCoroutinesApi
    public final void shutdown() {
        DefaultExecutor.INSTANCE.shutdown();
        DefaultScheduler.INSTANCE.shutdown$kotlinx_coroutines_core();
    }

    @JvmStatic
    public static /* synthetic */ void getDefault$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getIO$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMain$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getUnconfined$annotations() {
    }
}
