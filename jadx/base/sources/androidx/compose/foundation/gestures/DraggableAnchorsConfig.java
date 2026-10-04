package androidx.compose.foundation.gestures;

import androidx.collection.MutableObjectFloatMap;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t*\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0002\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "T", "", "()V", "anchors", "Landroidx/collection/MutableObjectFloatMap;", "getAnchors$foundation_release", "()Landroidx/collection/MutableObjectFloatMap;", VPathDataCmd.ArcTo, "", "position", "", "(Ljava/lang/Object;F)V", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DraggableAnchorsConfig<T> {
    public static final int $stable = 8;

    @NotNull
    private final MutableObjectFloatMap<T> anchors = new MutableObjectFloatMap<>(0, 1, null);

    /* JADX INFO: renamed from: at */
    public final void m1195at(T t, float f) {
        this.anchors.set(t, f);
    }

    @NotNull
    public final MutableObjectFloatMap<T> getAnchors$foundation_release() {
        return this.anchors;
    }
}
