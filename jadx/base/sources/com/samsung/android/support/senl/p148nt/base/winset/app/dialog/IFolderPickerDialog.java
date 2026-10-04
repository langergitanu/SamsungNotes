package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J4\u0010\u000e\u001a\u00020\u00032\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u001c\u001a\u00020\u0003H&¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IFolderPickerDialog;", "", "setAnchorViewId", "", AbsDialogFragment.KEY_ANCHOR_VIEW_ID, "", "parentDialog", "Landroidx/appcompat/app/AlertDialog;", "setFolderSelectedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IFolderPickerDialog$OnFolderSelectedListener;", "setPickerDialogListener", "presenterListener", "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IFolderPickerDialogResult;", "setPickerDialogData", "docUuid", "", NotesConstants.KEY_FOLDER_UUID, NotesConstants.DialogTag.KEY_CHECKED_FOLDER_ROOT_ITEM_UUID_LIST, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkedNotesCount", NotesConstants.DialogTag.KEY_CHECKED_FOLDERS_COUNT, Constants.IntentExtraValue.SHOW, "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "setHighlightFolderUuid", "dismiss", "OnFolderSelectedListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IFolderPickerDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String FOLDER_PICKER_DIALOG = "FolderPickerDialog";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IFolderPickerDialog$Companion;", "", "<init>", "()V", "FOLDER_PICKER_DIALOG", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String FOLDER_PICKER_DIALOG = "FolderPickerDialog";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/IFolderPickerDialog$OnFolderSelectedListener;", "", "onFolderSelected", "", NotesConstants.KEY_FOLDER_UUID, "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnFolderSelectedListener {
        void onFolderSelected(@Nullable String folderUuid);
    }

    void dismiss();

    void setAnchorViewId(int anchorViewId);

    void setAnchorViewId(@Nullable AlertDialog parentDialog, int anchorViewId);

    void setFolderSelectedListener(@Nullable OnFolderSelectedListener listener);

    void setHighlightFolderUuid(@Nullable String folderUuid);

    void setPickerDialogData(@Nullable String docUuid, @Nullable String folderUuid);

    void setPickerDialogData(@NotNull ArrayList<String> checkedFolderRootItemUuidList, int checkedNotesCount, int checkedFolderCount);

    void setPickerDialogListener(@Nullable IFolderPickerDialogResult presenterListener);

    void show(@NotNull FragmentManager manager, @Nullable String tag);
}
