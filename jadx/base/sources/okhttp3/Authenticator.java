package okhttp3;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Authenticator {
    public static final Authenticator NONE = new C8416h(20);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Request lambda$static$0(Route route, Response response) {
        return null;
    }

    @Nullable
    Request authenticate(@Nullable Route route, Response response);
}
