package com.samsung.android.support.senl.p148nt.base.common.access.folder;

import android.content.res.Resources;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/folder/FolderAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "FOLDER_LIST_CLASS", "Ljava/lang/Class;", "FOLDER_PICKER_DIALOG_CLASS", "getFolderListClass", "setFolderListClass", "", "executor", "getFolderPickerDialogClass", "setFolderPickerDialogClass", "sContract", "Lcom/samsung/android/support/senl/nt/base/common/access/folder/FolderAccessHandler$FolderAccessContract;", "getSContract", "()Lcom/samsung/android/support/senl/nt/base/common/access/folder/FolderAccessHandler$FolderAccessContract;", "setSContract", "(Lcom/samsung/android/support/senl/nt/base/common/access/folder/FolderAccessHandler$FolderAccessContract;)V", "setContract", "contract", "getContract", "FolderAccessContract", "FolderColorResourceInjector", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FolderAccessHandler {

    @Nullable
    private static Class<?> FOLDER_LIST_CLASS = null;

    @Nullable
    private static Class<?> FOLDER_PICKER_DIALOG_CLASS = null;

    @NotNull
    public static final FolderAccessHandler INSTANCE = new FolderAccessHandler();

    @NotNull
    private static final String TAG = "FolderAccessHandler";

    @Nullable
    private static FolderAccessContract sContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/folder/FolderAccessHandler$FolderAccessContract;", "", "getResourceInjector", "Lcom/samsung/android/support/senl/nt/base/common/access/folder/FolderAccessHandler$FolderColorResourceInjector;", "resources", "Landroid/content/res/Resources;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface FolderAccessContract {
        @Nullable
        FolderColorResourceInjector getResourceInjector(@NotNull Resources resources);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/folder/FolderAccessHandler$FolderColorResourceInjector;", "", "oldScreenOffMemoColor", "", "getOldScreenOffMemoColor", "()I", "oldUncategorizedColor", "getOldUncategorizedColor", "oldFolderColorArray", "", "getOldFolderColorArray", "()[I", "defaultFolderColor", "getDefaultFolderColor", "folderColorArray", "getFolderColorArray", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface FolderColorResourceInjector {
        int getDefaultFolderColor();

        @Nullable
        int[] getFolderColorArray();

        @Nullable
        int[] getOldFolderColorArray();

        int getOldScreenOffMemoColor();

        int getOldUncategorizedColor();
    }

    private FolderAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final FolderAccessContract getContract() {
        return sContract;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getFolderListClass() {
        return FOLDER_LIST_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getFolderPickerDialogClass() {
        return FOLDER_PICKER_DIALOG_CLASS;
    }

    @JvmStatic
    public static final void setContract(@Nullable FolderAccessContract contract) {
        sContract = contract;
    }

    @JvmStatic
    public static final void setFolderListClass(@Nullable Class<?> executor) {
        if (FOLDER_LIST_CLASS != null) {
            Logger.m8698e(TAG, "setFolderListClass, twice access! only first trial is accepted");
        } else {
            FOLDER_LIST_CLASS = executor;
            Logger.m8697d(TAG, "setFolderListClass.");
        }
    }

    @JvmStatic
    public static final void setFolderPickerDialogClass(@Nullable Class<?> executor) {
        if (FOLDER_PICKER_DIALOG_CLASS != null) {
            Logger.m8698e(TAG, "setFolderPickerDialogClass, twice access! only first trial is accepted");
        } else {
            FOLDER_PICKER_DIALOG_CLASS = executor;
            Logger.m8697d(TAG, "setFolderPickerDialogClass.");
        }
    }

    @Nullable
    public final FolderAccessContract getSContract() {
        return sContract;
    }

    public final void setSContract(@Nullable FolderAccessContract folderAccessContract) {
        sContract = folderAccessContract;
    }
}
