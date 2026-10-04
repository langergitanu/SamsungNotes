package androidx.glance.session;

import androidx.annotation.RestrictTo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\"\u0013\u0010\u0000\u001a\u00020\u00018G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"GlanceSessionManager", "Landroidx/glance/session/SessionManager;", "getGlanceSessionManager", "()Landroidx/glance/session/SessionManager;", SearchConstants.TargetContents.TAG, "", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SessionManagerKt {

    @NotNull
    private static final SessionManager GlanceSessionManager = new SessionManagerImpl(SessionWorker.class);

    @NotNull
    private static final String TAG = "GWT:SessionManager";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final SessionManager getGlanceSessionManager() {
        return GlanceSessionManager;
    }
}
