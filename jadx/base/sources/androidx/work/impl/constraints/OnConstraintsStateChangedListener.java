package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "", "onConstraintsStateChanged", "", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "state", "Landroidx/work/impl/constraints/ConstraintsState;", "work-runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface OnConstraintsStateChangedListener {
    void onConstraintsStateChanged(@NotNull WorkSpec workSpec, @NotNull ConstraintsState state);
}
