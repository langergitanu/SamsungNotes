package androidx.glance.oneui.common.sizepolicy.foldable;

import androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/foldable/FoldablePolicy;", "Landroidx/glance/oneui/common/sizepolicy/SizeRatioPolicy;", "()V", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class FoldablePolicy extends SizeRatioPolicy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int EASY_MODE_STATE_KEY = 1;
    private static final int ORIENTATION_STATE_KEY = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/foldable/FoldablePolicy$Companion;", "", "()V", "EASY_MODE_STATE_KEY", "", "ORIENTATION_STATE_KEY", "makeStateKey", "isPortrait", "", "isEasyMode", "makeStateKey$glance_oneui_common_release", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int makeStateKey$glance_oneui_common_release(boolean isPortrait, boolean isEasyMode) {
            int i = !isPortrait ? 1 : 0;
            return isEasyMode ? i | 2 : i;
        }

        private Companion() {
        }
    }
}
