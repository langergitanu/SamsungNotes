package com.samsung.android.support.senl.p148nt.app.main.folder.view.dialog;

import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.DialogContract;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DialogCreator implements DialogContract {
    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.presenter.DialogContract
    public IFolderPickerDialog createFolderPickerDialog(Map<String, NotesFolder> map, boolean z, IFolderPickerDialogResult iFolderPickerDialogResult) {
        FolderPickerDialog folderPickerDialog = new FolderPickerDialog(map, z);
        folderPickerDialog.setPickerDialogListener(iFolderPickerDialogResult);
        return folderPickerDialog;
    }
}
