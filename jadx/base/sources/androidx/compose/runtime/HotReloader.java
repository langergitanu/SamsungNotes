package androidx.compose.runtime;

import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/compose/runtime/HotReloader;", "", "()V", "Companion", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class HotReloader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0002J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0001H\u0001¢\u0006\u0002\b\u0013¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/runtime/HotReloader$Companion;", "", "()V", "clearErrors", "", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndCompose", ResponseType.TOKEN, "saveStateAndDispose", "context", "simulateHotReload", "simulateHotReload$runtime_release", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void loadStateAndCompose(Object token) {
            Recomposer.INSTANCE.loadStateAndComposeForHotReload$runtime_release(token);
        }

        private final Object saveStateAndDispose(Object context) {
            return Recomposer.INSTANCE.saveStateAndDisposeForHotReload$runtime_release();
        }

        @TestOnly
        public final void clearErrors$runtime_release() {
            Recomposer.INSTANCE.clearErrors$runtime_release();
        }

        @TestOnly
        @NotNull
        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            return Recomposer.INSTANCE.getCurrentErrors$runtime_release();
        }

        @TestOnly
        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer.INSTANCE.invalidateGroupsWithKey$runtime_release(key);
        }

        @TestOnly
        public final void simulateHotReload$runtime_release(@NotNull Object context) {
            loadStateAndCompose(saveStateAndDispose(context));
        }

        private Companion() {
        }
    }
}
