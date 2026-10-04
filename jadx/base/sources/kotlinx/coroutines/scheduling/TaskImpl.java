package kotlinx.coroutines.scheduling;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.DebugStringsKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u00060\tj\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0002\u001a\u00060\u0004j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0011"}, m13886d2 = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "<init>", "(Ljava/lang/Runnable;JZ)V", "Ljava/lang/Runnable;", "run", "", "toString", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
final class TaskImpl extends Task {

    @JvmField
    @NotNull
    public final Runnable block;

    public TaskImpl(@NotNull Runnable runnable, long j, boolean z) {
        super(j, z);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.block.run();
    }

    @NotNull
    public String toString() {
        return "Task[" + DebugStringsKt.getClassSimpleName(this.block) + '@' + DebugStringsKt.getHexAddress(this.block) + SQLKeyword.COMMA + this.submissionTime + SQLKeyword.COMMA + TasksKt.taskContextString(this.taskContext) + PropertyUtils.INDEXED_DELIM2;
    }
}
