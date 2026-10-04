package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import android.util.Pair;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00182\u00020\u0001:\u0003\u0016\u0017\u0018J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IDetailsDialog;", "", "setDetailsDialogData", "", "docUuid", "", "docPath", NotesConstants.KEY_FOLDER_UUID, "title", ExternalDataConstants.Column.COVER_SUMMARY, "modifiedTime", "", "setIsFolderSelectedEnable", "isFolderSelectedEnable", "", "setDetailsDialogListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IDetailsDialog$OnDetailsDialogListener;", Constants.IntentExtraValue.SHOW, "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "OnDetailsDialogListener", FolderConstants.PREF_FOLDER_INFO, "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IDetailsDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String DETAILS_DIALOG = "DetailsDialog";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IDetailsDialog$Companion;", "", "<init>", "()V", "DETAILS_DIALOG", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String DETAILS_DIALOG = "DetailsDialog";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IDetailsDialog$FolderInfo;", "", NotesConstants.KEY_FOLDER_UUID, "", "folderDisplayName", "parentFolderUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFolderUuid", "()Ljava/lang/String;", "getFolderDisplayName", "getParentFolderUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class FolderInfo {

        @NotNull
        private final String folderDisplayName;

        @NotNull
        private final String folderUuid;

        @Nullable
        private final String parentFolderUuid;

        public FolderInfo(@NotNull String folderUuid, @NotNull String folderDisplayName, @Nullable String str) {
            Intrinsics.checkNotNullParameter(folderUuid, "folderUuid");
            Intrinsics.checkNotNullParameter(folderDisplayName, "folderDisplayName");
            this.folderUuid = folderUuid;
            this.folderDisplayName = folderDisplayName;
            this.parentFolderUuid = str;
        }

        public static /* synthetic */ FolderInfo copy$default(FolderInfo folderInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = folderInfo.folderUuid;
            }
            if ((i & 2) != 0) {
                str2 = folderInfo.folderDisplayName;
            }
            if ((i & 4) != 0) {
                str3 = folderInfo.parentFolderUuid;
            }
            return folderInfo.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFolderUuid() {
            return this.folderUuid;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFolderDisplayName() {
            return this.folderDisplayName;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getParentFolderUuid() {
            return this.parentFolderUuid;
        }

        @NotNull
        public final FolderInfo copy(@NotNull String folderUuid, @NotNull String folderDisplayName, @Nullable String parentFolderUuid) {
            Intrinsics.checkNotNullParameter(folderUuid, "folderUuid");
            Intrinsics.checkNotNullParameter(folderDisplayName, "folderDisplayName");
            return new FolderInfo(folderUuid, folderDisplayName, parentFolderUuid);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FolderInfo)) {
                return false;
            }
            FolderInfo folderInfo = (FolderInfo) other;
            return Intrinsics.areEqual(this.folderUuid, folderInfo.folderUuid) && Intrinsics.areEqual(this.folderDisplayName, folderInfo.folderDisplayName) && Intrinsics.areEqual(this.parentFolderUuid, folderInfo.parentFolderUuid);
        }

        @NotNull
        public final String getFolderDisplayName() {
            return this.folderDisplayName;
        }

        @NotNull
        public final String getFolderUuid() {
            return this.folderUuid;
        }

        @Nullable
        public final String getParentFolderUuid() {
            return this.parentFolderUuid;
        }

        public int hashCode() {
            int iM1202c = AbstractC1038a.m1202c(this.folderUuid.hashCode() * 31, 31, this.folderDisplayName);
            String str = this.parentFolderUuid;
            return iM1202c + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return AbstractC0622a.m1170p(this.parentFolderUuid, ")", AbstractC0000a.m16m("FolderInfo(folderUuid=", this.folderUuid, ", folderDisplayName=", this.folderDisplayName, ", parentFolderUuid="));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IDetailsDialog$OnDetailsDialogListener;", "", "onFolderSelected", "", NotesConstants.KEY_FOLDER_UUID, "", "getBodyTextCount", "Landroid/util/Pair;", "", "docPath", "getFolderInfo", "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IDetailsDialog$FolderInfo;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnDetailsDialogListener {
        @Nullable
        Pair<Integer, Integer> getBodyTextCount(@NotNull String docPath);

        @Nullable
        FolderInfo getFolderInfo(@NotNull String folderUuid);

        void onFolderSelected(@NotNull String folderUuid);
    }

    void setDetailsDialogData(@NotNull String docUuid, @NotNull String docPath, @NotNull String folderUuid, @NotNull String title, @NotNull String coverSummary, long modifiedTime);

    void setDetailsDialogListener(@Nullable OnDetailsDialogListener listener);

    void setIsFolderSelectedEnable(boolean isFolderSelectedEnable);

    void show(@NotNull FragmentManager manager, @Nullable String tag);
}
