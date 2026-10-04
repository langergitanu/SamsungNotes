package androidx.work;

import androidx.annotation.RestrictTo;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/work/InputMergerFactory;", "", "()V", "createInputMerger", "Landroidx/work/InputMerger;", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "", "createInputMergerWithDefaultFallback", "work-runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class InputMergerFactory {
    @Nullable
    public abstract InputMerger createInputMerger(@NotNull String className);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final InputMerger createInputMergerWithDefaultFallback(@NotNull String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        InputMerger inputMergerCreateInputMerger = createInputMerger(className);
        return inputMergerCreateInputMerger == null ? InputMergerKt.fromClassName(className) : inputMergerCreateInputMerger;
    }
}
