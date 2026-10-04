package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.GUIDManager;
import com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager;
import com.samsung.android.support.senl.p148nt.app.addons.stub.StubUtil;
import com.samsung.android.support.senl.p148nt.app.addons.stub.dialog.InstallFailDialog;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.dialog.BtnProgressDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.AppUpdateUtil;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 P2\u00020\u0001:\u0002OPB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0010¢\u0006\u0004\b\u0006\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010 J\u0012\u0010'\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010 J\u001c\u0010'\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010 2\u0006\u0010)\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020\n2\u0006\u0010(\u001a\u00020 H\u0002J\u0012\u0010.\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010 H\u0002J\u001a\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010 2\b\u00100\u001a\u0004\u0018\u00010 J\u000e\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020\u0017J\u0012\u00106\u001a\u00020\u00172\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020+H\u0002J\u0018\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\nH\u0016J\u0006\u0010A\u001a\u00020\u0017J\b\u0010B\u001a\u00020\u0017H\u0016J\u0006\u0010C\u001a\u00020\u0017J\u0006\u0010D\u001a\u00020\u0017J\"\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020+2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u0014\u0010!\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u0014\u00101\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001bR\u0011\u00105\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b5\u0010\u001bR$\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bG\u0010\u001b\"\u0004\bH\u0010I¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsStubManager;", "Lcom/samsung/android/support/senl/nt/app/addons/stub/IStubManager;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "stubPresenter", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsStubManager$IStubPresenter;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/samsung/android/support/senl/nt/app/addons/AddonsStubManager$IStubPresenter;)V", "()V", "mIsAvailableUpdate", "", "mPresenter", "mActivity", "mGUIDManager", "Lcom/samsung/android/support/senl/nt/app/account/GUIDManager;", "addonsInstallDialogListener", "Lcom/samsung/android/support/senl/nt/app/common/dialog/BtnProgressDialogFragment$IAddonsInstallDialog;", "recommendConvertDialogListener", "updateSamsungNotesDialogListener", "Lcom/samsung/android/support/senl/nt/app/common/dialog/AppUpdateDialogFragment$AppUpdateDialogListener;", "mFailDialogListener", "Lcom/samsung/android/support/senl/nt/app/addons/stub/dialog/InstallFailDialog$IAddonsInstallFailDialog;", "release", "", "onStubUpdateTaskFinished", "needOpenSelectedNote", "isNeedAddonsUpdate", "()Z", "isSupportedAddonsUpdate", "isSupportedAddonsUpdateOs", "isSupportedAddonsVersion", "getSupportedAddonsVersion", "", "isNeedSamsungNotesUpdate", "isInstallableAddons", "isAddonExist", "parseNotesVersion", "Lcom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat$Version;", "notesVersionName", "parseVersion", "versionName", "needRevision", "reviseMajorVersion", "", "majorVersion", "isAvailableVersion", "isUpdatableVersion", "curVersionName", "targetVersionName", "isRequiredMandatoryUpdate", "installAddons", "isNeedInstall", "convertNote", "isDataNetworkNotAvailable", "onViewChangeRestoreInstanceState", "savedInstanceState", "Landroid/os/Bundle;", "onViewChangeSaveInstanceState", "outState", "onRestoreDialogListener", "setErrorMessage", "error", "showAddonsInstallDialog", "isUpdate", "isProgressOn", "showInstallFailDialog", "showSamsungNotesUpdateDialog", "showRecommendConvertDialog", "removeAddonsInstallDialog", "isAvailableUpdate", "availableUpdate", "getAvailableUpdate", "setAvailableUpdate", "(Z)V", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "IStubPresenter", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAddonsStubManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddonsStubManager.kt\ncom/samsung/android/support/senl/nt/app/addons/AddonsStubManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,517:1\n739#2,9:518\n37#3:527\n36#3,3:528\n1#4:531\n*S KotlinDebug\n*F\n+ 1 AddonsStubManager.kt\ncom/samsung/android/support/senl/nt/app/addons/AddonsStubManager\n*L\n172#1:518,9\n172#1:527\n172#1:528,3\n*E\n"})
public final class AddonsStubManager implements IStubManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_ERROR = 1;
    private static final int INSTALL_ERROR = 2;
    private static final int NETWORK_ERROR = 0;

    @NotNull
    private static final String TAG = "AddonsStubManager";

    @Nullable
    private FragmentActivity mActivity;

    @Nullable
    private GUIDManager mGUIDManager;
    private boolean mIsAvailableUpdate;

    @Nullable
    private IStubPresenter mPresenter;

    @NotNull
    private final BtnProgressDialogFragment.IAddonsInstallDialog addonsInstallDialogListener = new BtnProgressDialogFragment.IAddonsInstallDialog() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsStubManager$addonsInstallDialogListener$1
        @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
        public void onBackPressed() {
            this.this$0.onStubUpdateTaskFinished(false);
        }

        @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
        public void onCancel(String dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "dialogType");
            if (Intrinsics.areEqual(BtnProgressDialogFragment.INSTALL_ADDONS_DIALOG, dialogType)) {
                this.this$0.showRecommendConvertDialog();
            } else {
                AddonsStubManager addonsStubManager = this.this$0;
                addonsStubManager.onStubUpdateTaskFinished(addonsStubManager.isRequiredMandatoryUpdate());
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
        public void onConfirm(String dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "dialogType");
            this.this$0.installAddons(Intrinsics.areEqual(BtnProgressDialogFragment.INSTALL_ADDONS_DIALOG, dialogType));
        }
    };

    @NotNull
    private final BtnProgressDialogFragment.IAddonsInstallDialog recommendConvertDialogListener = new BtnProgressDialogFragment.IAddonsInstallDialog() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsStubManager$recommendConvertDialogListener$1
        @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
        public void onBackPressed() {
            this.this$0.onStubUpdateTaskFinished(false);
        }

        @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
        public void onCancel(String dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "dialogType");
            this.this$0.onStubUpdateTaskFinished(false);
        }

        @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
        public void onConfirm(String dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "dialogType");
            this.this$0.convertNote();
        }
    };

    @NotNull
    private final AppUpdateDialogFragment.AppUpdateDialogListener updateSamsungNotesDialogListener = new AppUpdateDialogFragment.AppUpdateDialogListener() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsStubManager$updateSamsungNotesDialogListener$1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            if (-1 == which) {
                UpdateManager.getInstance().goToGalaxyAppStore();
            }
            this.this$0.onStubUpdateTaskFinished(false);
        }
    };

    @NotNull
    private final InstallFailDialog.IAddonsInstallFailDialog mFailDialogListener = new InstallFailDialog.IAddonsInstallFailDialog() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsStubManager$mFailDialogListener$1
        @Override // com.samsung.android.support.senl.nt.app.addons.stub.dialog.InstallFailDialog.IAddonsInstallFailDialog
        public void onDismiss() {
            this.this$0.onStubUpdateTaskFinished(false);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsStubManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "NETWORK_ERROR", "", "DEFAULT_ERROR", "INSTALL_ERROR", "serverAddonsVersionName", "getServerAddonsVersionName", "()Ljava/lang/String;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String getServerAddonsVersionName() {
            return SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getString(NotesConstants.KEY_ADDONS_VERSION_NAME, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsStubManager$IStubPresenter;", "", "onStubUpdateTaskFinished", "", "needOpenSelectedNote", "", "convertNote", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IStubPresenter {
        void convertNote();

        void onStubUpdateTaskFinished(boolean needOpenSelectedNote);
    }

    public AddonsStubManager(@Nullable FragmentActivity fragmentActivity, @Nullable IStubPresenter iStubPresenter) {
        this.mActivity = fragmentActivity;
        this.mPresenter = iStubPresenter;
    }

    private final boolean getAvailableUpdate() {
        return SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getBoolean(NotesConstants.KEY_ADDONS_AVAILABLE_UPDATE, false);
    }

    private final String getSupportedAddonsVersion() {
        return Build.VERSION.SDK_INT >= 31 ? "2.1.00.7" : StubUtil.getVersionName();
    }

    private final boolean isAvailableVersion(String versionName) {
        PackageManagerCompat.Version version = parseVersion(versionName);
        PackageManagerCompat.Version version2 = parseVersion(PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(BaseUtils.getApplicationContext()));
        if (version == null || version2 == null || version.getMajor() > version2.getMajor()) {
            return false;
        }
        if (version.getMajor() < version2.getMajor()) {
            return true;
        }
        if (version.getMinor() > version2.getMinor()) {
            AbstractC6670b.m4736A(version.getMinor(), "addOnsMinorVersion false", TAG);
            return false;
        }
        if (version.getMinor() < version2.getMinor() || version.getPatch() <= version2.getPatch()) {
            return true;
        }
        AbstractC6670b.m4736A(version.getPatch(), "addOnsPatchVersion false", TAG);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRequiredMandatoryUpdate() {
        int versionIntCode;
        if (Build.VERSION.SDK_INT < 31 || (versionIntCode = StubUtil.getVersionIntCode()) <= 0 || versionIntCode >= 210007000) {
            return false;
        }
        return isUpdatableVersion("2.1.00.6", INSTANCE.getServerAddonsVersionName());
    }

    private final boolean isSupportedAddonsUpdateOs() {
        return Build.VERSION.SDK_INT <= 34;
    }

    private final boolean isSupportedAddonsVersion() {
        return Intrinsics.areEqual(StubUtil.getVersionName(), getSupportedAddonsVersion()) || isUpdatableVersion(getSupportedAddonsVersion(), StubUtil.getVersionName());
    }

    private final boolean isUpdatableVersion(String versionName) {
        String versionName2 = StubUtil.getVersionName();
        if (!TextUtils.isEmpty(versionName2)) {
            return isUpdatableVersion(versionName2, versionName);
        }
        MainLogger.m7254d(TAG, "curAddOnsVersionName isEmpty");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStubUpdateTaskFinished(boolean needOpenSelectedNote) {
        setAvailableUpdate(false);
        removeAddonsInstallDialog();
        IStubPresenter iStubPresenter = this.mPresenter;
        if (iStubPresenter != null) {
            iStubPresenter.onStubUpdateTaskFinished(needOpenSelectedNote);
        }
    }

    private final int reviseMajorVersion(int majorVersion) {
        if (majorVersion == 1 || majorVersion == 2) {
            return 4;
        }
        return majorVersion + 2;
    }

    private final void setAvailableUpdate(boolean z) {
        this.mIsAvailableUpdate = z;
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putBoolean(NotesConstants.KEY_ADDONS_AVAILABLE_UPDATE, this.mIsAvailableUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setErrorMessage(int error) {
        if (error != 0) {
            if (error != 2) {
                showInstallFailDialog();
                return;
            } else {
                showSamsungNotesUpdateDialog();
                return;
            }
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        Context applicationContext2 = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext2);
        String string = applicationContext2.getString(C8003R.string.network_fail_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ToastHandler.show(applicationContext, string, 0);
        onStubUpdateTaskFinished(false);
    }

    public final void convertNote() {
        MainLogger.m7258i(TAG, "convertNote");
        removeAddonsInstallDialog();
        IStubPresenter iStubPresenter = this.mPresenter;
        if (iStubPresenter != null) {
            iStubPresenter.convertNote();
        }
    }

    public final void installAddons(boolean isNeedInstall) {
        MainLogger.m7258i(TAG, "installAddons isNeedInstall " + isNeedInstall);
        if (isDataNetworkNotAvailable()) {
            setErrorMessage(0);
            return;
        }
        if (this.mActivity != null) {
            if (!AppUpdateUtil.isQaServerEnabled()) {
                FragmentActivity fragmentActivity = this.mActivity;
                Intrinsics.checkNotNull(fragmentActivity);
                StubUtil.callGalaxyAppsClientAppUsingDeepLink(fragmentActivity);
                onStubUpdateTaskFinished(false);
                return;
            }
            if (this.mGUIDManager == null) {
                this.mGUIDManager = new GUIDManager();
            }
            GUIDManager gUIDManager = this.mGUIDManager;
            if (gUIDManager != null) {
                gUIDManager.requestGUID(this.mActivity, new GUIDManager.OnRequestGUIDListener() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsStubManager.installAddons.1
                    @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                    public void onFail() {
                        MainLogger.m7258i(AddonsStubManager.TAG, "requestGUID onFail# ");
                        AddonsStubManager.this.setErrorMessage(1);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                    public void onSuccess(String guid) {
                        Intrinsics.checkNotNullParameter(guid, "guid");
                        MainLogger.m7258i(AddonsStubManager.TAG, "requestGUID onSuccess# guid " + guid);
                        FragmentActivity fragmentActivity2 = AddonsStubManager.this.mActivity;
                        Intrinsics.checkNotNull(fragmentActivity2);
                        StubUtil.callGalaxyAppsClientAppUsingDeepLink(fragmentActivity2);
                        AddonsStubManager.this.onStubUpdateTaskFinished(false);
                    }
                });
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isAddonExist() {
        return StubUtil.isAddonExist(this.mActivity);
    }

    public final boolean isDataNetworkNotAvailable() {
        return (AppUpdateUtil.isDataNetworkConnected(BaseUtils.getApplicationContext()) || AppUpdateUtil.isWifiNetworkConnected(BaseUtils.getApplicationContext())) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isInstallableAddons() {
        String serverAddonsVersionName = INSTANCE.getServerAddonsVersionName();
        if (serverAddonsVersionName == null || isAvailableVersion(serverAddonsVersionName)) {
            MainLogger.m7258i(TAG, "isInstallableAddons# " + serverAddonsVersionName + " version is available.");
            return true;
        }
        MainLogger.m7258i(TAG, "isInstallableAddons# " + serverAddonsVersionName + " version is not available.");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isNeedAddonsUpdate() {
        AbstractC6670b.m4739D("isNeedAddonsUpdate# isAvailableUpdate : ", TAG, this.mIsAvailableUpdate);
        if (isRequiredMandatoryUpdate()) {
            String serverAddonsVersionName = INSTANCE.getServerAddonsVersionName();
            if (!TextUtils.isEmpty(serverAddonsVersionName) && isUpdatableVersion(serverAddonsVersionName)) {
                return true;
            }
        }
        return this.mIsAvailableUpdate;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isNeedSamsungNotesUpdate() {
        if (isAddonExist() && isAvailableVersion(StubUtil.getVersionName())) {
            MainLogger.m7258i(TAG, "isNeedSamsungNotesUpdate# false");
            return false;
        }
        MainLogger.m7258i(TAG, "isNeedSamsungNotesUpdate# true");
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isSupportedAddonsUpdate() {
        return isSupportedAddonsUpdateOs() && isSupportedAddonsVersion();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        GUIDManager gUIDManager = this.mGUIDManager;
        if (gUIDManager != null) {
            gUIDManager.onActivityResult(this.mActivity, requestCode, resultCode, data);
        }
        this.mIsAvailableUpdate = getAvailableUpdate();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onRestoreDialogListener() {
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        FragmentManager supportFragmentManager3;
        FragmentManager supportFragmentManager4;
        FragmentManager supportFragmentManager5;
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        FragmentActivity fragmentActivity = this.mActivity;
        Fragment fragmentFindFragmentByTag = null;
        DialogFragment dialogFragment = (DialogFragment) ((fragmentActivity == null || (supportFragmentManager5 = fragmentActivity.getSupportFragmentManager()) == null) ? null : supportFragmentManager5.findFragmentByTag(BtnProgressDialogFragment.UPDATE_ADDONS_DIALOG));
        if (dialogFragment != null) {
            ((BtnProgressDialogFragment) dialogFragment).setContract(this.addonsInstallDialogListener);
            return;
        }
        FragmentActivity fragmentActivity2 = this.mActivity;
        DialogFragment dialogFragment2 = (DialogFragment) ((fragmentActivity2 == null || (supportFragmentManager4 = fragmentActivity2.getSupportFragmentManager()) == null) ? null : supportFragmentManager4.findFragmentByTag(BtnProgressDialogFragment.RECOMMEND_CONVERT_DIALOG));
        if (dialogFragment2 != null) {
            ((BtnProgressDialogFragment) dialogFragment2).setContract(this.recommendConvertDialogListener);
            return;
        }
        FragmentActivity fragmentActivity3 = this.mActivity;
        DialogFragment dialogFragment3 = (DialogFragment) ((fragmentActivity3 == null || (supportFragmentManager3 = fragmentActivity3.getSupportFragmentManager()) == null) ? null : supportFragmentManager3.findFragmentByTag(AppUpdateDialogFragment.FOR_ADDONS));
        if (dialogFragment3 != null) {
            if (StubUtil.isAddonExist(BaseUtils.getApplicationContext())) {
                dialogFragment3.dismissAllowingStateLoss();
                return;
            } else {
                ((AppUpdateDialogFragment) dialogFragment3).setDialogListener(this.updateSamsungNotesDialogListener);
                return;
            }
        }
        FragmentActivity fragmentActivity4 = this.mActivity;
        DialogFragment dialogFragment4 = (DialogFragment) ((fragmentActivity4 == null || (supportFragmentManager2 = fragmentActivity4.getSupportFragmentManager()) == null) ? null : supportFragmentManager2.findFragmentByTag(BtnProgressDialogFragment.INSTALL_ADDONS_DIALOG));
        if (dialogFragment4 != null) {
            if (StubUtil.isAddonExist(BaseUtils.getApplicationContext())) {
                dialogFragment4.dismissAllowingStateLoss();
                return;
            } else {
                ((BtnProgressDialogFragment) dialogFragment4).setContract(this.addonsInstallDialogListener);
                return;
            }
        }
        FragmentActivity fragmentActivity5 = this.mActivity;
        if (fragmentActivity5 != null && (supportFragmentManager = fragmentActivity5.getSupportFragmentManager()) != null) {
            fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(NotesConstants.DialogTag.INSTALL_FAIL_ADDONS_DIALOG);
        }
        DialogFragment dialogFragment5 = (DialogFragment) fragmentFindFragmentByTag;
        if (dialogFragment5 != null) {
            ((InstallFailDialog) dialogFragment5).setContract(this.mFailDialogListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onViewChangeRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        String string;
        if (savedInstanceState == null || (string = savedInstanceState.getString(NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE)) == null) {
            return;
        }
        boolean zIsAddonExist = StubUtil.isAddonExist(BaseUtils.getApplicationContext());
        if (!zIsAddonExist && Intrinsics.areEqual(BtnProgressDialogFragment.INSTALL_ADDONS_DIALOG, string)) {
            showAddonsInstallDialog(false, savedInstanceState.getBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON));
            return;
        }
        if (!zIsAddonExist && Intrinsics.areEqual(BtnProgressDialogFragment.UPDATE_ADDONS_DIALOG, string)) {
            showAddonsInstallDialog(true, savedInstanceState.getBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON));
            return;
        }
        if (Intrinsics.areEqual(BtnProgressDialogFragment.RECOMMEND_CONVERT_DIALOG, string)) {
            showRecommendConvertDialog();
        } else if (Intrinsics.areEqual(NotesConstants.DialogTag.INSTALL_FAIL_ADDONS_DIALOG, string)) {
            showInstallFailDialog();
        } else if (Intrinsics.areEqual(AppUpdateDialogFragment.FOR_ADDONS, string)) {
            showSamsungNotesUpdateDialog();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onViewChangeSaveInstanceState(@Nullable Bundle outState) {
        FragmentManager supportFragmentManager;
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        String[] strArr = {BtnProgressDialogFragment.INSTALL_ADDONS_DIALOG, BtnProgressDialogFragment.UPDATE_ADDONS_DIALOG, BtnProgressDialogFragment.RECOMMEND_CONVERT_DIALOG, NotesConstants.DialogTag.INSTALL_FAIL_ADDONS_DIALOG, AppUpdateDialogFragment.FOR_ADDONS};
        for (int i = 0; i < 5; i++) {
            String str = strArr[i];
            FragmentActivity fragmentActivity = this.mActivity;
            DialogFragment dialogFragment = (DialogFragment) ((fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag(str));
            if (dialogFragment != null) {
                if (outState != null) {
                    outState.putString(NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, str);
                }
                if (outState != null) {
                    dialogFragment.onSaveInstanceState(outState);
                }
                dialogFragment.dismiss();
                return;
            }
        }
    }

    @Nullable
    public final PackageManagerCompat.Version parseNotesVersion(@Nullable String notesVersionName) {
        return parseVersion(notesVersionName, false);
    }

    @Nullable
    public final PackageManagerCompat.Version parseVersion(@Nullable String versionName) {
        return parseVersion(versionName, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void release() {
        this.mActivity = null;
    }

    public final void removeAddonsInstallDialog() {
        FragmentManager supportFragmentManager;
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            MainLogger.m7258i(TAG, "removeAddonsInstallDialog - fail");
            return;
        }
        String[] strArr = {BtnProgressDialogFragment.INSTALL_ADDONS_DIALOG, BtnProgressDialogFragment.UPDATE_ADDONS_DIALOG, BtnProgressDialogFragment.RECOMMEND_CONVERT_DIALOG, AppUpdateDialogFragment.FOR_ADDONS};
        for (int i = 0; i < 4; i++) {
            try {
                String str = strArr[i];
                FragmentActivity fragmentActivity = this.mActivity;
                DialogFragment dialogFragment = (DialogFragment) ((fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag(str));
                if (dialogFragment != null) {
                    dialogFragment.dismissAllowingStateLoss();
                    return;
                }
            } catch (IllegalStateException e) {
                AbstractC8014b.m7209k("removeAddonsInstallDialog - IllegalStateException ", e.getMessage(), TAG);
                return;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void showAddonsInstallDialog(boolean isUpdate, boolean isProgressOn) {
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        AbstractC6670b.m4739D("showAddonsInstallDialog# isUpdate : ", TAG, isUpdate);
        String str = isUpdate ? BtnProgressDialogFragment.UPDATE_ADDONS_DIALOG : BtnProgressDialogFragment.INSTALL_ADDONS_DIALOG;
        BtnProgressDialogFragment btnProgressDialogFragment = new BtnProgressDialogFragment(str, isProgressOn);
        btnProgressDialogFragment.setContract(this.addonsInstallDialogListener);
        FragmentActivity fragmentActivity = this.mActivity;
        btnProgressDialogFragment.showAllowingStateLoss(fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null, str);
    }

    public final void showInstallFailDialog() {
        String string;
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        removeAddonsInstallDialog();
        MainLogger.m7258i(TAG, "need to show INSTALL_ERROR dialog");
        int i = CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.samsung_notes_add_on_jp : C8003R.string.samsung_notes_add_on;
        Context applicationContext = BaseUtils.getApplicationContext();
        String string2 = applicationContext != null ? applicationContext.getString(C8003R.string.install_fail_error_title) : null;
        Context applicationContext2 = BaseUtils.getApplicationContext();
        if (applicationContext2 != null) {
            int i2 = C8003R.string.install_fail_error_message;
            Context applicationContext3 = BaseUtils.getApplicationContext();
            string = applicationContext2.getString(i2, applicationContext3 != null ? applicationContext3.getString(i) : null);
        } else {
            string = null;
        }
        InstallFailDialog installFailDialog = new InstallFailDialog(string2, string);
        try {
            installFailDialog.setContract(this.mFailDialogListener);
            FragmentActivity fragmentActivity = this.mActivity;
            installFailDialog.showAllowingStateLoss(fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null, NotesConstants.DialogTag.INSTALL_FAIL_ADDONS_DIALOG);
        } catch (IllegalStateException e) {
            MainLogger.m7258i(TAG, "showInstallFailDialog - IllegalStateException " + e);
        }
    }

    public final void showRecommendConvertDialog() {
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        removeAddonsInstallDialog();
        MainLogger.m7258i(TAG, "showRecommendConvertDialog");
        BtnProgressDialogFragment btnProgressDialogFragment = new BtnProgressDialogFragment(BtnProgressDialogFragment.RECOMMEND_CONVERT_DIALOG, false);
        btnProgressDialogFragment.setContract(this.recommendConvertDialogListener);
        FragmentActivity fragmentActivity = this.mActivity;
        btnProgressDialogFragment.showAllowingStateLoss(fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null, BtnProgressDialogFragment.RECOMMEND_CONVERT_DIALOG);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void showSamsungNotesUpdateDialog() {
        if (CommonUtils.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        removeAddonsInstallDialog();
        MainLogger.m7258i(TAG, "showSamsungNotesUpdateDialog");
        AppUpdateDialogFragment appUpdateDialogFragment = new AppUpdateDialogFragment();
        appUpdateDialogFragment.setDialogListener(this.updateSamsungNotesDialogListener);
        FragmentActivity fragmentActivity = this.mActivity;
        appUpdateDialogFragment.showAllowingStateLoss(fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null, AppUpdateDialogFragment.FOR_ADDONS);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final PackageManagerCompat.Version parseVersion(String versionName, boolean needRevision) {
        String[] strArr;
        Integer intOrNull;
        List listM13999t;
        List listEmptyList;
        if (versionName == null || (listM13999t = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, versionName)) == null) {
            strArr = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
                strArr = (String[]) listEmptyList.toArray(new String[0]);
            }
        }
        if (strArr != null && strArr.length >= 4 && (intOrNull = StringsKt.toIntOrNull(strArr[0])) != null && intOrNull.intValue() >= 0 && intOrNull.intValue() <= Integer.MAX_VALUE) {
            try {
                return new PackageManagerCompat.Version(needRevision ? reviseMajorVersion(intOrNull.intValue()) : Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]), Integer.parseInt(strArr[3]));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean isUpdatableVersion(@Nullable String curVersionName, @Nullable String targetVersionName) {
        if (!TextUtils.isEmpty(curVersionName) && !TextUtils.isEmpty(targetVersionName)) {
            PackageManagerCompat.Version version = parseVersion(curVersionName);
            PackageManagerCompat.Version version2 = parseVersion(targetVersionName);
            if (version == null || version2 == null || version2.getMajor() < version.getMajor()) {
                return false;
            }
            if (version2.getMajor() > version.getMajor()) {
                return true;
            }
            if (version2.getMinor() < version.getMinor()) {
                return false;
            }
            if (version2.getMinor() > version.getMinor()) {
                return true;
            }
            if (version2.getPatch() < version.getPatch()) {
                return false;
            }
            return version2.getPatch() > version.getPatch() || version2.getRevision() > version.getRevision();
        }
        MainLogger.m7254d(TAG, "version name is Empty");
        return false;
    }

    public AddonsStubManager() {
    }
}
