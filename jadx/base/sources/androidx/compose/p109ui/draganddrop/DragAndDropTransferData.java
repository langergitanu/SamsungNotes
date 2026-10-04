package androidx.compose.p109ui.draganddrop;

import android.content.ClipData;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "", "clipData", "Landroid/content/ClipData;", "localState", "flags", "", "(Landroid/content/ClipData;Ljava/lang/Object;I)V", "getClipData", "()Landroid/content/ClipData;", "getFlags", "()I", "getLocalState", "()Ljava/lang/Object;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DragAndDropTransferData {
    public static final int $stable = 8;

    @NotNull
    private final ClipData clipData;
    private final int flags;

    @Nullable
    private final Object localState;

    public DragAndDropTransferData(@NotNull ClipData clipData, @Nullable Object obj, int i) {
        this.clipData = clipData;
        this.localState = obj;
        this.flags = i;
    }

    @NotNull
    public final ClipData getClipData() {
        return this.clipData;
    }

    public final int getFlags() {
        return this.flags;
    }

    @Nullable
    public final Object getLocalState() {
        return this.localState;
    }

    public /* synthetic */ DragAndDropTransferData(ClipData clipData, Object obj, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(clipData, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? 0 : i);
    }
}
