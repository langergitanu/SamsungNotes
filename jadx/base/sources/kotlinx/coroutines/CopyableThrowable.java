package kotlinx.coroutines;

import java.lang.Throwable;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lkotlinx/coroutines/CopyableThrowable;", "T", "", "", "createCopy", "()Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@ExperimentalCoroutinesApi
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    @Nullable
    T createCopy();
}
