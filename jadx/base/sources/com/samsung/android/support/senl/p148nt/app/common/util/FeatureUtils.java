package com.samsung.android.support.senl.p148nt.app.common.util;

import android.os.Build;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FeatureUtils {
    public static boolean canDeleteFolderPathLayout(int i, String str) {
        return isSearchMode(i) || isMDEMode(i) || isHashTagMode(i) || isPreDefinedFolderUuid(str);
    }

    public static boolean canShowSOMRecognizedCard(int i, String str) {
        return isSOMFolder(i, str) && isSOMFeatureSupported();
    }

    public static boolean canShowSyncProgressBar(int i, String str) {
        return needToShowSyncProgressBar(i, str) || 2 == i;
    }

    public static int getFolderSpanHolderType(int i) {
        switch (i) {
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 4;
            case 7:
                return 8;
            case 8:
                return 16;
            case 9:
                return 32;
            case 10:
            case 13:
            default:
                return 1024;
            case 11:
                return 64;
            case 12:
                return 256;
            case 14:
                return 512;
        }
    }

    public static int getHolderType(int i) {
        switch (i) {
            case 0:
                return 32768;
            case 1:
                return 16384;
            case 2:
                return 262144;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return 4096;
            case 9:
                return 65536;
            case 10:
                return 524288;
            case 11:
                return 2097152;
            case 12:
                return 4194304;
            case 13:
                return 16777216;
            case 14:
                return 33554432;
            default:
                return -1;
        }
    }

    public static int[] getTopHolderInfoMapOrder() {
        return new int[]{13, 14, 0, 10, 1, 2, 11};
    }

    public static int getUpdateDataIndex(int i) {
        if (isOldMode(i)) {
            return 1;
        }
        if (isRecyclebinMode(i)) {
            return 2;
        }
        if (isSearchMode(i)) {
            return 3;
        }
        if (isGcsSpaceMode(i)) {
            return 4;
        }
        if (isCoeditMode(i)) {
            return 5;
        }
        if (isCoeditSpaceMode(i)) {
            return 6;
        }
        if (isHashTagMode(i)) {
            return 7;
        }
        return (i == 24 || i == 23) ? 8 : 0;
    }

    public static int getViewMode(int i) {
        int viewMode = ContentUtils.getViewMode();
        return (!isSearchMode(i) || viewMode == 6 || viewMode == 3) ? viewMode : ModelFeature.getFeature().needNoThumbnailSimpleList() ? 6 : 3;
    }

    public static boolean isCoeditFilterType(String str) {
        return FolderConstants.Coedit.UUID.equals(str);
    }

    public static boolean isCoeditMode(int i) {
        return i == 12 || i == 13;
    }

    public static boolean isCoeditSearchMode(int i) {
        return i == 16 || i == 17;
    }

    public static boolean isCoeditSpaceMode(int i) {
        return i == 14 || i == 15;
    }

    public static boolean isCoverFilterVisible(int i) {
        return i == 3 || i == 4 || i == 9 || i == 26;
    }

    public static boolean isCreateNewNoteEnabled(int i, String str) {
        boolean zIsCreateNewNoteEnabledFolder = isCreateNewNoteEnabledFolder(str);
        return i == 7 || (i == -1 && zIsCreateNewNoteEnabledFolder) || ((i == 1 && zIsCreateNewNoteEnabledFolder) || i == 10 || i == 12 || i == 14 || i == 25);
    }

    public static boolean isCreateNewNoteEnabledFolder(String str) {
        return (str == null || str.equals("favorite:///") || str.equals("lock:///") || str.equals("recentlyImported:///") || str.equals(FolderConstants.OldNotes.UUID) || str.equals("tag:///") || str.equals(FolderConstants.RecycleBin.UUID)) ? false : true;
    }

    public static boolean isDrawerInvisibleMode(int i) {
        if (i == -1 || i == 7 || i == 8 || i == 9) {
            return true;
        }
        switch (i) {
            case 25:
            case 26:
            case 27:
            case 28:
                return true;
            default:
                return false;
        }
    }

    public static boolean isEditMode(int i) {
        return i == 2 || i == 4 || i == 6 || i == 9 || i == 11 || i == 8 || i == 25 || i == 28 || i == 26 || i == 19 || i == 22 || i == 13 || i == 15 || i == 17;
    }

    public static boolean isEnabledDeltaDA() {
        return Build.VERSION.SDK_INT <= 34 && SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel();
    }

    public static boolean isExecuteType(int i) {
        return isPickMode(i) || 20 == i;
    }

    public static boolean isFilterFolderType(String str) {
        return "favorite:///".equals(str) || "lock:///".equals(str) || "recentlyImported:///".equals(str) || FolderConstants.OldNotes.UUID.equals(str) || FolderConstants.SharedNotes.UUID.equals(str);
    }

    public static boolean isGcsSpaceMode(int i) {
        return i == 10 || i == 11;
    }

    public static boolean isHashTagMode(int i) {
        return i == 18 || i == 19 || i == 20;
    }

    public static boolean isMDEMode(int i) {
        return isGcsSpaceMode(i) || isCoeditMode(i) || isCoeditSpaceMode(i) || isCoeditSearchMode(i);
    }

    public static boolean isMainListRequestCode(int i, int i2) {
        return i == i2 || i == (32768 | i2) || i == (i2 | 16384) || i == (i2 | 49152);
    }

    public static boolean isNeedAddFolder(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    public static boolean isNeedFolderCount(int i) {
        return i == 1009 || i == 0 || i == 3;
    }

    public static boolean isNeedFooter(int i, String str) {
        boolean zIsCreateNewNoteEnabledFolder = isCreateNewNoteEnabledFolder(str);
        return i == 7 || i == 27 || (i == -1 && zIsCreateNewNoteEnabledFolder) || (((i == 1 || i == 2) && zIsCreateNewNoteEnabledFolder) || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 25 || i == 28 || i == 3 || i == 4 || i == 16 || i == 17 || i == 26);
    }

    public static boolean isNotSupportCheckingSubHeader(long j) {
        return j == -16 || j == -30 || j == -31;
    }

    public static boolean isNotUsingNotesListFragment(int i) {
        return i == 23 || i == 24;
    }

    public static boolean isNoteListHandoffSupported(int i) {
        return i == 1;
    }

    public static boolean isOldMode(int i) {
        return i == 21 || i == 22;
    }

    public static boolean isPickEditMode(int i) {
        return i == 8 || i == 25 || i == 28 || i == 26 || i == 9;
    }

    public static boolean isPickEditSearchMode(int i) {
        return i == 9;
    }

    public static boolean isPickEditSearchWidgetMode(int i) {
        return i == 26;
    }

    public static boolean isPickEditWidgetMode(int i) {
        return i == 25 || i == 28 || i == 26;
    }

    public static boolean isPickMode(int i) {
        return i == 7 || i == 27 || i == 8 || i == 25 || i == 28 || i == 26 || i == 9;
    }

    public static boolean isPreDefinedFolderUuid(String str) {
        return FolderConstants.AllNotes.UUID.equals(str) || "lock:///".equals(str) || "favorite:///".equals(str) || "recentlyImported:///".equals(str) || FolderConstants.RecycleBin.UUID.equals(str) || FolderConstants.SharedNotes.UUID.equals(str) || FolderConstants.Coedit.UUID.equals(str) || FolderConstants.OldNotes.UUID.equals(str);
    }

    public static boolean isRecentSearchVisible(int i) {
        return i == 3 || i == 4 || i == 16 || i == 17;
    }

    public static boolean isRecentTagVisible(int i, int i2) {
        return (i == 3 || i == 4) && !isPickMode(i2);
    }

    public static boolean isRecyclebinMode(int i) {
        return i == 5 || i == 6;
    }

    public static boolean isSOMFeatureSupported() {
        return Features.isSupportAiFunction() && RecognitionUtil.isSupported(BaseUtils.getContext()) && DeviceUtils.isSpenModel();
    }

    public static boolean isSOMFolder(int i, String str) {
        return (i == 1 || i == 2) && FolderConstants.ScreenOffMemo.UUID.equals(str);
    }

    public static boolean isSearchEditMode(int i) {
        return i == 4 || i == 17;
    }

    public static boolean isSearchMode(int i) {
        return i == 3 || i == 4 || i == 9 || i == 26 || i == 16 || i == 17;
    }

    public static boolean isSinglePickSelectMode(int i, int i2, int i4) {
        return (i == 7 || i == 27 || i == 3) && (i2 == 1 || i2 == 9 || i4 == 13 || i4 == 7 || i4 == 27);
    }

    public static boolean isSubFolderExist(int i, String str) {
        if (isHashTagMode(i) || isSearchMode(i) || isMDEMode(i) || isOldMode(i)) {
            return false;
        }
        return (!isPreDefinedFolderUuid(str) || FolderConstants.RecycleBin.UUID.equals(str)) && !FolderConstants.ScreenOffMemo.UUID.equals(str);
    }

    public static boolean needToHideDisplayData(int i, MainListDocumentData mainListDocumentData) {
        if (i != 1) {
            if (i != 2) {
                if (i != 6) {
                    if (i != 13) {
                        if (i != 14) {
                            switch (i) {
                            }
                            return false;
                        }
                    }
                }
                if (!LockUtils.isLockedOtherDocType(mainListDocumentData.getIsLock())) {
                    if (!needToHideSharedNoteDisplayData(mainListDocumentData.getUuid(), mainListDocumentData.getPageMode(), mainListDocumentData.getFormatVersion(), mainListDocumentData.isCoverEnabled(), mainListDocumentData.getFilePath(), mainListDocumentData.isSDoc(), mainListDocumentData.getHasSticky() > 0)) {
                        return false;
                    }
                }
                return true;
            }
            return mainListDocumentData.isSDoc() || !LockUtils.isUnLockedDocType(mainListDocumentData.getIsLock());
        }
        return mainListDocumentData.isSDoc();
    }

    public static boolean needToHideSharedNoteDisplayData(String str, int i, int i2, boolean z, String str2, boolean z2, boolean z3) {
        return z || z2 || z3 || i != 2 || i2 > 4000 || (i2 == 0 && SpenWNoteFile.getFormatVersion(str2) > 4000) || UUIDUtils.isGenUuid(str) || UUIDUtils.isDynamicTemplateUuid(str) || SpenWNoteFile.getOrientation(str2) == SpenWNote.Orientation.LANDSCAPE_NEW;
    }

    public static boolean needToShowSSMProgressBar(int i, String str) {
        if (FolderConstants.AllNotes.UUID.equals(str) || FolderConstants.MyFolders.UUID.equals(str)) {
            return 1 == i || 2 == i;
        }
        return false;
    }

    public static boolean needToShowSyncProgressBar(int i, String str) {
        if (FolderConstants.RecycleBin.UUID.equals(str) || FolderConstants.OldNotes.UUID.equals(str) || FolderConstants.Coedit.UUID.equals(str)) {
            return false;
        }
        return 1 == i || 2 == i;
    }
}
