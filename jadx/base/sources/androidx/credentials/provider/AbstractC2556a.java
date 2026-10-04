package androidx.credentials.provider;

import android.app.slice.SliceSpec;
import android.text.PrecomputedText;
import android.view.DisplayCutout;

/* JADX INFO: renamed from: androidx.credentials.provider.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2556a {
    /* JADX INFO: renamed from: b */
    public static /* synthetic */ SliceSpec m2026b() {
        return new SliceSpec("AuthenticationAction", 0);
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ DisplayCutout m2032h(Object obj) {
        return (DisplayCutout) obj;
    }

    /* JADX INFO: renamed from: u */
    public static /* bridge */ /* synthetic */ boolean m2045u(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }

    /* JADX INFO: renamed from: v */
    public static /* bridge */ /* synthetic */ boolean m2046v(Object obj) {
        return obj instanceof DisplayCutout;
    }

    /* JADX INFO: renamed from: y */
    public static /* synthetic */ SliceSpec m2049y() {
        return new SliceSpec("RemoteEntry", 1);
    }
}
