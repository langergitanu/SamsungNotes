package androidx.compose.runtime.changelist;

import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, m13886d2 = {"Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "", "()V", "toDebugString", "", "linePrefix", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class OperationsDebugStringFormattable {
    public static final int $stable = 0;

    public static /* synthetic */ String toDebugString$default(OperationsDebugStringFormattable operationsDebugStringFormattable, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toDebugString");
        }
        if ((i & 1) != 0) {
            str = Constant.WHITE_SPACE_FOR_LINK_ICON;
        }
        return operationsDebugStringFormattable.toDebugString(str);
    }

    @NotNull
    public abstract String toDebugString(@NotNull String linePrefix);
}
