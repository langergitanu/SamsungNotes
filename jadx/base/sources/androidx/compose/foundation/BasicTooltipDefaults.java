package androidx.compose.foundation;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Landroidx/compose/foundation/BasicTooltipDefaults;", "", "()V", "GlobalMutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "getGlobalMutatorMutex", "()Landroidx/compose/foundation/MutatorMutex;", "TooltipDuration", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BasicTooltipDefaults {
    public static final int $stable = 0;
    public static final long TooltipDuration = 1500;

    @NotNull
    public static final BasicTooltipDefaults INSTANCE = new BasicTooltipDefaults();

    @NotNull
    private static final MutatorMutex GlobalMutatorMutex = new MutatorMutex();

    private BasicTooltipDefaults() {
    }

    @NotNull
    public final MutatorMutex getGlobalMutatorMutex() {
        return GlobalMutatorMutex;
    }
}
