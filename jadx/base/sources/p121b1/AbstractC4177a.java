package p121b1;

import android.content.ComponentName;
import android.content.Context;
import com.samsung.android.app.notes.sync.migration.provider.BnRDocumentProvider;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: b1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC4177a {

    /* JADX INFO: renamed from: a */
    public static final String f1755a = "SS$".concat("BnRDocumentProviderSwitcher");

    /* JADX INFO: renamed from: a */
    public static void m2482a(Context context) {
        AbstractC0299q.m643n(f1755a, "disableBnRDocumentProvider");
        PackageManagerCompat.INSTANCE.getInstance().setComponentEnabledSetting(context, new ComponentName(context, (Class<?>) BnRDocumentProvider.class), 0, 1);
    }
}
