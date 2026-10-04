package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.content.Intent;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common.ImportFolderConstants;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common.utils.ImportFolderUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 +2\u00020\u0001:\u0002*+B\u001d\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\tJ\u0018\u0010\u001f\u001a\u00020\t2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H&J\b\u0010#\u001a\u00020\tH&J\b\u0010$\u001a\u00020\tH&J\b\u0010%\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010&\u001a\u0004\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode;", "", "mPresenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "mModeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", "onCreate", "", "onResume", "onDestroy", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "removeSelectedItem", "rootFolderRes", "getRootFolderRes", "()I", "noNoteTextRes", "getNoNoteTextRes", "actionBarTitleRes", "getActionBarTitleRes", "isLocalNotePickerNeeds", "()Z", "appNameRes", "getAppNameRes", "startImport", "importFolderInfos", "", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "requestImportList", "unregisterImportListRequest", "setValidateFolderPath", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ImportFolderMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @Nullable
    public final Contract mModeContract;

    @JvmField
    @Nullable
    public final ImportFolderPresenterContract mPresenterContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Companion;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode;", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "googleAccountName", "", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "modeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "getImportFolderMode", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[DocTypeConstants.values().length];
                try {
                    iArr[DocTypeConstants.SDOC.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DocTypeConstants.SNOTE_LOCAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DocTypeConstants.SNOTE_SCLOUD.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DocTypeConstants.SNOTE_GOOGLEDRIVE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DocTypeConstants.SDOCX_SCLOUD.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[ImportFolderConstants.SnotePickerType.values().length];
                try {
                    iArr2[ImportFolderConstants.SnotePickerType.MY_FILES.ordinal()] = 1;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[ImportFolderConstants.SnotePickerType.RESTRICTED_LOCAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ImportFolderMode getImportFolderMode(ImportFolderPresenterContract presenterContract, Contract modeContract) {
            int i = WhenMappings.$EnumSwitchMapping$1[ImportFolderUtils.getSnotePickerType().ordinal()];
            return i != 1 ? i != 2 ? new ImportSNoteLocalMode(presenterContract, modeContract) : new ImportSNotePickerLocalMode(presenterContract, modeContract) : new ImportSNoteMyFilesMode(presenterContract, modeContract);
        }

        @Nullable
        public final ImportFolderMode create(@Nullable DocTypeConstants importType, @Nullable String googleAccountName, @Nullable ImportFolderPresenterContract presenterContract, @Nullable Contract modeContract) {
            int i = importType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[importType.ordinal()];
            if (i == 1) {
                return new ImportSDocMode(presenterContract, modeContract);
            }
            if (i == 2) {
                return getImportFolderMode(presenterContract, modeContract);
            }
            if (i == 3) {
                return new ImportSNoteSCloudMode(presenterContract, modeContract);
            }
            if (i == 4) {
                return new ImportSNoteGoogleDriveMode(presenterContract, modeContract, googleAccountName);
            }
            if (i != 5) {
                return null;
            }
            return new ImportSDocxServerMode(presenterContract, modeContract);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "", "addFileData", "", "fileData", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "getBaseDisplayDirectory", "", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "storageType", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void addFileData(@NotNull ImportFolderInfo fileData);

        @Nullable
        String getBaseDisplayDirectory(@Nullable DocTypeConstants importType, int storageType);
    }

    public ImportFolderMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable Contract contract) {
        this.mPresenterContract = importFolderPresenterContract;
        this.mModeContract = contract;
    }

    public final int getActionBarTitleRes() {
        return C8003R.string.settings_import_data_title;
    }

    public abstract int getAppNameRes();

    @Nullable
    public abstract DocTypeConstants getImportType();

    public int getNoNoteTextRes() {
        return C8003R.string.settings_import_no_data_on_device;
    }

    public int getRootFolderRes() {
        return C8003R.string.import_rootname_this_device;
    }

    public boolean isLocalNotePickerNeeds() {
        return true;
    }

    public boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        return false;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public final void removeSelectedItem() {
    }

    public abstract void requestImportList();

    public void setValidateFolderPath() {
    }

    public abstract void startImport(@Nullable List<ImportFolderInfo> importFolderInfos);

    public abstract void unregisterImportListRequest();
}
