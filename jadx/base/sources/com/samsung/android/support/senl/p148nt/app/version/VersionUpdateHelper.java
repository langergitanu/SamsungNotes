package com.samsung.android.support.senl.p148nt.app.version;

import com.samsung.android.support.senl.p148nt.app.version.history.VersionUpdate;
import com.samsung.android.support.senl.p148nt.app.version.manage.VersionUpdateManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VersionUpdateHelper {
    private IVersionUpdate mIVersionUpdate;
    private final VersionUpdateManager mVersionUpdateManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IVersionUpdate {
        boolean onEnd();

        boolean onStart();
    }

    public VersionUpdateHelper(VersionUpdateManager versionUpdateManager) {
        this.mVersionUpdateManager = versionUpdateManager;
    }

    public List<VersionUpdate> findUpgrades(int i, int i2) {
        return this.mVersionUpdateManager.findUpgrades(i, i2);
    }

    public boolean onUpgrade(int i, int i2) {
        if (i >= i2) {
            throw new IllegalArgumentException("newVersion is less than oldVersion");
        }
        IVersionUpdate iVersionUpdate = this.mIVersionUpdate;
        if (iVersionUpdate != null) {
            iVersionUpdate.onStart();
        }
        Iterator<VersionUpdate> it = findUpgrades(i, i2).iterator();
        while (it.hasNext()) {
            it.next().onUpgrade();
        }
        IVersionUpdate iVersionUpdate2 = this.mIVersionUpdate;
        if (iVersionUpdate2 == null) {
            return true;
        }
        iVersionUpdate2.onEnd();
        return true;
    }

    public void setIVersionUpdate(IVersionUpdate iVersionUpdate) {
        this.mIVersionUpdate = iVersionUpdate;
    }
}
