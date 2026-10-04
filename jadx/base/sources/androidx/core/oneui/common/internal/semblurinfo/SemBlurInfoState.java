package androidx.core.oneui.common.internal.semblurinfo;

import android.view.View;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH'R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, m13886d2 = {"Landroidx/core/oneui/common/internal/semblurinfo/SemBlurInfoState;", "", "blurMode", "", "(I)V", "getBlurMode", "()I", "applyBlurInfo", "", "view", "Landroid/view/View;", "clearBlurInfo", "", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SemBlurInfoState {
    private final int blurMode;

    public SemBlurInfoState(int i) {
        this.blurMode = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public abstract boolean applyBlurInfo(@NotNull View view);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public abstract void clearBlurInfo(@NotNull View view);

    public int getBlurMode() {
        return this.blurMode;
    }
}
