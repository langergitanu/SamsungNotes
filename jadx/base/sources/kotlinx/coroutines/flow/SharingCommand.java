package kotlinx.coroutines.flow;

import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "<init>", "(Ljava/lang/String;I)V", CoeditGrpcMethod.Caller.START, CoeditGrpcMethod.Caller.STOP, "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SharingCommand {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SharingCommand[] $VALUES;
    public static final SharingCommand START = new SharingCommand(CoeditGrpcMethod.Caller.START, 0);
    public static final SharingCommand STOP = new SharingCommand(CoeditGrpcMethod.Caller.STOP, 1);
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);

    private static final /* synthetic */ SharingCommand[] $values() {
        return new SharingCommand[]{START, STOP, STOP_AND_RESET_REPLAY_CACHE};
    }

    static {
        SharingCommand[] sharingCommandArr$values = $values();
        $VALUES = sharingCommandArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sharingCommandArr$values);
    }

    private SharingCommand(String str, int i) {
    }

    @NotNull
    public static EnumEntries<SharingCommand> getEntries() {
        return $ENTRIES;
    }

    public static SharingCommand valueOf(String str) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, str);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) $VALUES.clone();
    }
}
