package androidx.glance.oneui.template.preview;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\"\"\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"LatestSessionStates", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/glance/oneui/template/preview/PreviewGlanceState;", "getLatestSessionStates", "()Ljava/util/concurrent/ConcurrentHashMap;", SearchConstants.TargetContents.TAG, "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PreviewSessionManagerKt {

    @NotNull
    private static final ConcurrentHashMap<String, PreviewGlanceState> LatestSessionStates = new ConcurrentHashMap<>();

    @NotNull
    private static final String TAG = "GWT:PreviewSessionManager";

    @NotNull
    public static final ConcurrentHashMap<String, PreviewGlanceState> getLatestSessionStates() {
        return LatestSessionStates;
    }
}
