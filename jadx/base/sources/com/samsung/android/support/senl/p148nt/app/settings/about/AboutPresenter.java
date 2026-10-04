package com.samsung.android.support.senl.p148nt.app.settings.about;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.app.updater.connector.IMarketConnector;
import com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\u0010J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010'\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\r2\u0006\u0010'\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010 \u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b!\u0010\u0016¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/about/AboutPresenter;", "Lcom/samsung/android/support/senl/nt/app/updater/connector/INewVersionCheckResetListener;", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/about/AboutPresenter$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/about/AboutPresenter$Contract;)V", SearchConstants.TargetContents.TAG, "", "mState", "", "mMarketConnector", "Lcom/samsung/android/support/senl/nt/app/updater/connector/IMarketConnector;", "setMarketConnector", "", "marketConnector", "isRetryState", "", "()Z", "isUpdateState", "newState", "state", "getState", "()I", "setState", "(I)V", "appName", "getAppName", "getVersionText", "context", "Landroid/content/Context;", "updateText", "getUpdateText", "updateNoticeText", "getUpdateNoticeText", "moveToMarket", "releaseMarketConnector", "checkNewVersion", "isSkipVersionCheck", "getResult", "marketVersionCode", "finishedAsNoNetwork", "finishedAsNewVersionOnMarket", "finishedAsLatestVersionInstalled", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AboutPresenter implements INewVersionCheckResetListener {
    public static final int STATE_LATEST = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_RETRY = 3;
    public static final int STATE_UPDATE = 2;

    @NotNull
    private final String TAG;

    @NotNull
    private final Contract mContract;

    @Nullable
    private IMarketConnector mMarketConnector;
    private int mState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/about/AboutPresenter$Contract;", "", "startProgress", "", "stopProgress", "stateChanged", "newState", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void startProgress();

        void stateChanged(int newState);

        void stopProgress();
    }

    public AboutPresenter(@NotNull Contract mContract) {
        Intrinsics.checkNotNullParameter(mContract, "mContract");
        this.mContract = mContract;
        this.TAG = "ST$AboutPresenter";
    }

    private final void finishedAsLatestVersionInstalled(int marketVersionCode) {
        MainLogger.m7258i(this.TAG, "versionCheckFinished# It is latest version.");
        UpdateManager.getInstance().setHasBadge(false);
        UpdateManager.getInstance().resetNeedToCheck();
        UpdateManager.getInstance().setHasTipCard(marketVersionCode);
        setState(1);
    }

    private final void finishedAsNewVersionOnMarket(int marketVersionCode) {
        MainLogger.m7258i(this.TAG, "versionCheckFinished# new version exist on market");
        if (UpdateManager.getInstance().getPrefCloseTipCardVersion() < marketVersionCode) {
            UpdateManager.getInstance().setHasTipCard(-1);
        }
        if (UpdateManager.getInstance().getPrefUserCheckedVersion() < marketVersionCode) {
            UpdateManager.getInstance().setHasBadge(true);
            UpdateManager.getInstance().setPrefUserCheckedVersion(marketVersionCode);
        }
        UpdateManager.getInstance().resetNeedToCheck();
        setState(2);
    }

    private final void finishedAsNoNetwork() {
        MainLogger.m7258i(this.TAG, "versionCheckFinished# no network.");
        setState(3);
    }

    public final void checkNewVersion() {
        if (isSkipVersionCheck()) {
            MainLogger.m7258i(this.TAG, "checkNewVersion# - Skip new version check");
            return;
        }
        if (this.mMarketConnector == null) {
            MainLogger.m7258i(this.TAG, "checkNewVersion# MarketConnector is null");
            return;
        }
        MainLogger.m7258i(this.TAG, "checkNewVersion#");
        this.mContract.startProgress();
        IMarketConnector iMarketConnector = this.mMarketConnector;
        if (iMarketConnector != null) {
            iMarketConnector.checkNewVersionOnMarket(this);
        }
    }

    public final int getAppName() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.notes;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener
    public void getResult(int marketVersionCode) {
        this.mContract.stopProgress();
        IMarketConnector iMarketConnector = this.mMarketConnector;
        if (iMarketConnector != null) {
            iMarketConnector.setLastCheckedMarketVersionCode(marketVersionCode);
        }
        if (marketVersionCode == 3) {
            finishedAsNoNetwork();
        } else if (UpdateManager.getInstance().getCurrentVersionCode() < marketVersionCode) {
            finishedAsNewVersionOnMarket(marketVersionCode);
        } else {
            finishedAsLatestVersionInstalled(marketVersionCode);
        }
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    public final int getUpdateNoticeText() {
        int i = this.mState;
        if (i == 1) {
            return C8003R.string.latest_version_installed;
        }
        if (i == 2) {
            return C8003R.string.new_version_is_available;
        }
        if (i != 3) {
            return 0;
        }
        return C8003R.string.network_connect_is_not_stable;
    }

    public final int getUpdateText() {
        int i = this.mState;
        if (i == 2) {
            return C8003R.string.string_update;
        }
        if (i != 3) {
            return 0;
        }
        return C8003R.string.retry;
    }

    @NotNull
    public final String getVersionText(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C8003R.string.version_info, PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(context));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final boolean isRetryState() {
        return this.mState == 3;
    }

    public final boolean isSkipVersionCheck() {
        return PackageManagerCompat.INSTANCE.getInstance().isKMemoPackage(BaseUtils.getApplicationContext()) || DeviceInfo.isOtherCorpDevice() || !UpdateManager.getInstance().isGalaxyAppStorePackageExist() || SystemPropertiesCompat.INSTANCE.getInstance().isNationalDisasterNet();
    }

    public final boolean isUpdateState() {
        return this.mState == 2;
    }

    public final void moveToMarket() {
        IMarketConnector iMarketConnector = this.mMarketConnector;
        if (iMarketConnector != null) {
            iMarketConnector.moveToMarket();
        }
    }

    public final void releaseMarketConnector() {
        IMarketConnector iMarketConnector = this.mMarketConnector;
        if (iMarketConnector != null) {
            Intrinsics.checkNotNull(iMarketConnector);
            iMarketConnector.setListener(null);
            this.mMarketConnector = null;
        }
    }

    public final void setMarketConnector(@Nullable IMarketConnector marketConnector) {
        this.mMarketConnector = marketConnector;
    }

    public final void setState(int i) {
        if (this.mState == i) {
            return;
        }
        AbstractC8014b.m7201c(i, "setState# stateChangedTo: ", this.TAG);
        this.mState = i;
        this.mContract.stateChanged(i);
    }
}
