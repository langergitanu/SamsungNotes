package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.popupmenu;

import android.content.Context;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.AnchorViewUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderUtils;
import java.util.Collections;
import p079T.AbstractC0291i;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PopupMenuFactory {
    private static final String TAG = "PopupMenuFactory";

    private static boolean checkCanNotDelete(Context context, MainListDocumentData mainListDocumentData, boolean z) {
        C0283a.m562d().getClass();
        String strM561c = C0283a.m561c();
        if (strM561c == null) {
            return true;
        }
        if (TextUtils.isEmpty(mainListDocumentData.getMdeItemId())) {
            return false;
        }
        if (AbstractC0291i.m569f(mainListDocumentData.getUuid())) {
            return true;
        }
        return (!strM561c.equals(SesCoeditShareReadResolver.getInstance().getCoeditNoteCreatorId(context, mainListDocumentData.getMdeSpaceId(), mainListDocumentData.getMdeItemId())) || z) && !SesCoeditGroupReadResolver.getInstance().isGroupLeaderByMemberId(mainListDocumentData.getMdeGroupId(), strM561c);
    }

    public static PopupMenu create(View view, MenuInflater menuInflater, NotesPresenter notesPresenter, CommonHolderInfo commonHolderInfo) {
        if (view == null) {
            return null;
        }
        int modeIndex = notesPresenter.getStateInfo().getModeIndex();
        View anchorView = getAnchorView(view, commonHolderInfo);
        return FeatureUtils.isOldMode(modeIndex) ? createOldNotePopupMenu(anchorView, menuInflater, notesPresenter, commonHolderInfo) : FeatureUtils.isRecyclebinMode(modeIndex) ? createRecycleBinNotePopupMenu(anchorView, menuInflater, notesPresenter, commonHolderInfo) : FeatureUtils.isGcsSpaceMode(modeIndex) ? createSpaceNotePopupMenu(anchorView, menuInflater, notesPresenter, commonHolderInfo) : (FeatureUtils.isCoeditMode(modeIndex) || FeatureUtils.isCoeditSpaceMode(modeIndex)) ? createCoeditNotePopupMenu(anchorView, menuInflater, notesPresenter, commonHolderInfo, false) : FeatureUtils.isCoeditSearchMode(modeIndex) ? createCoeditNotePopupMenu(anchorView, menuInflater, notesPresenter, commonHolderInfo, true) : createBasePopupMenu(anchorView, menuInflater, notesPresenter, commonHolderInfo);
    }

    @Nullable
    private static PopupMenu createBasePopupMenu(View view, MenuInflater menuInflater, @NonNull NotesPresenter notesPresenter, @NonNull CommonHolderInfo commonHolderInfo) {
        String uuid = commonHolderInfo.getUuid();
        MainListDocumentData noteData = notesPresenter.getDocumentMap().getNoteData(uuid);
        NotesFolder folderData = notesPresenter.getDocumentMap().getFolderData(uuid);
        if (noteData == null && folderData == null) {
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, 8388611);
        if (noteData == null) {
            if (FolderUtils.isStaticFolder(folderData.getUuid())) {
                return null;
            }
            menuInflater.inflate(C8003R.menu.folderlist_popup_menu, popupMenu.getMenu());
            return popupMenu;
        }
        if (notesPresenter.hasGenUuidNote(Collections.singletonList(uuid))) {
            menuInflater.inflate(C8003R.menu.noteslist_popup_menu_for_gen, popupMenu.getMenu());
            Menu menu = popupMenu.getMenu();
            if (noteData.getIsLock() == 0) {
                menu.removeItem(C8003R.id.unlock);
            } else {
                menu.removeItem(C8003R.id.lock);
            }
        } else if (LockUtils.isLockedOtherDocType(noteData.getIsLock())) {
            menuInflater.inflate(C8003R.menu.noteslist_old_popup_menu, popupMenu.getMenu());
            popupMenu.getMenu().removeItem(C8003R.id.share);
            popupMenu.getMenu().removeItem(C8003R.id.convert);
        } else if (LockUtils.isLockedSdocType(noteData.getIsLock())) {
            menuInflater.inflate(C8003R.menu.noteslist_old_popup_menu, popupMenu.getMenu());
            popupMenu.getMenu().removeItem(C8003R.id.share);
        } else if (noteData.isSDoc()) {
            menuInflater.inflate(C8003R.menu.noteslist_old_popup_menu, popupMenu.getMenu());
        } else {
            menuInflater.inflate(C8003R.menu.noteslist_popup_menu, popupMenu.getMenu());
            Menu menu2 = popupMenu.getMenu();
            if (noteData.getIsLock() == 0) {
                menu2.removeItem(C8003R.id.unlock);
            } else {
                menu2.removeItem(C8003R.id.lock);
                menu2.removeItem(C8003R.id.duplicate);
            }
            String menuName = SecureFolderUtils.getMenuName(view.getContext());
            if (menuName.isEmpty()) {
                menu2.removeItem(C8003R.id.secure_folder);
            } else {
                menu2.findItem(C8003R.id.secure_folder).setTitle(menuName);
            }
            if (!Features.isSupportAiFunction() || noteData.getIsLock() != 0 || !notesPresenter.getCoverHelper().isActiveCover(noteData)) {
                menu2.removeItem(C8003R.id.action_edit_cover);
            }
        }
        if (noteData.getIsFavorite() == 1) {
            popupMenu.getMenu().removeItem(C8003R.id.action_add_to_favorites);
            return popupMenu;
        }
        popupMenu.getMenu().removeItem(C8003R.id.action_remove_from_favorites);
        return popupMenu;
    }

    @Nullable
    private static PopupMenu createCoeditNotePopupMenu(View view, MenuInflater menuInflater, @NonNull NotesPresenter notesPresenter, @NonNull CommonHolderInfo commonHolderInfo, boolean z) {
        String uuid = commonHolderInfo.getUuid();
        CoeditMainListEntry coeditNoteData = notesPresenter.getDocumentMap().getCoeditNoteData(uuid);
        MainListDocumentData noteData = z ? notesPresenter.getDocumentMap().getNoteData(uuid) : coeditNoteData != null ? coeditNoteData.getMainListDocumentData() : null;
        if (noteData == null) {
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, 8388611);
        boolean z2 = coeditNoteData != null && coeditNoteData.getType() == 2;
        menuInflater.inflate(z2 ? C8003R.menu.notelist_coedit_edit_menu_fake_note : C8003R.menu.notelist_coedit_edit_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        boolean standAlone = SesCoeditShareReadResolver.getInstance().getStandAlone(noteData.getMdeSpaceId());
        if (checkCanNotDelete(view.getContext(), noteData, standAlone)) {
            if (standAlone) {
                menu.findItem(C8003R.id.action_leave_shared_note).setVisible(true);
                menu.removeItem(C8003R.id.action_delete);
            } else if (z2) {
                menu.findItem(C8003R.id.action_delete).setEnabled(false);
            } else {
                menu.removeItem(C8003R.id.action_delete);
            }
        }
        if (!z2) {
            menu.removeItem(C8003R.id.action_switch_to_notebook);
        }
        return popupMenu;
    }

    @Nullable
    private static PopupMenu createOldNotePopupMenu(View view, MenuInflater menuInflater, @NonNull NotesPresenter notesPresenter, @NonNull CommonHolderInfo commonHolderInfo) {
        MainListDocumentData noteData = notesPresenter.getDocumentMap().getNoteData(commonHolderInfo.getUuid());
        if (noteData == null) {
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, 8388611);
        menuInflater.inflate(C8003R.menu.noteslist_popup_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        menu.removeItem(C8003R.id.move);
        menu.removeItem(C8003R.id.lock);
        menu.removeItem(C8003R.id.unlock);
        menu.removeItem(C8003R.id.save);
        menu.removeItem(C8003R.id.duplicate);
        menu.removeItem(C8003R.id.secure_folder);
        menu.removeItem(C8003R.id.action_edit_cover);
        if (noteData.getIsLock() != 0) {
            menu.removeItem(C8003R.id.share);
        }
        if (noteData.getIsFavorite() == 1) {
            menu.removeItem(C8003R.id.action_add_to_favorites);
            return popupMenu;
        }
        menu.removeItem(C8003R.id.action_remove_from_favorites);
        return popupMenu;
    }

    @Nullable
    private static PopupMenu createRecycleBinNotePopupMenu(View view, MenuInflater menuInflater, @NonNull NotesPresenter notesPresenter, @NonNull CommonHolderInfo commonHolderInfo) {
        String uuid = commonHolderInfo.getUuid();
        MainListDocumentData noteData = notesPresenter.getDocumentMap().getNoteData(uuid);
        NotesFolder folderData = notesPresenter.getDocumentMap().getFolderData(uuid);
        if (noteData == null && folderData == null) {
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, 8388611);
        menuInflater.inflate(C8003R.menu.notelist_recyclebin_edit, popupMenu.getMenu());
        return popupMenu;
    }

    @Nullable
    private static PopupMenu createSpaceNotePopupMenu(View view, MenuInflater menuInflater, @NonNull NotesPresenter notesPresenter, @NonNull CommonHolderInfo commonHolderInfo) {
        MainListDocumentData noteData = notesPresenter.getDocumentMap().getNoteData(commonHolderInfo.getUuid());
        if (noteData == null) {
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, 8388611);
        menuInflater.inflate(C8003R.menu.gcs_spacelist_edit, popupMenu.getMenu());
        C0283a.m562d().getClass();
        String strM561c = C0283a.m561c();
        if (strM561c != null && !strM561c.equals(noteData.getMdeOwnerId())) {
            popupMenu.getMenu().removeItem(C8003R.id.action_delete);
        }
        return popupMenu;
    }

    @NonNull
    private static View getAnchorView(View view, @NonNull CommonHolderInfo commonHolderInfo) {
        float[] touchPos = commonHolderInfo.getTouchPos();
        View anchorView = AnchorViewUtils.getAnchorView((ViewGroup) view, (ViewGroup) commonHolderInfo.getRootCardView(), touchPos[0], touchPos[1]);
        MainLogger.m7254d(TAG, "getAnchorView " + commonHolderInfo.getUuid() + " has anchorView x# " + touchPos[0] + " y# " + touchPos[1]);
        return anchorView;
    }
}
