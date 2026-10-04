package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.control.SpenControlObjectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.ExtraDataHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExecuteOtherActivityController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskOpenWebCard;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ControlObjectListenerImpl extends SpenControlObjectListener {
    private static final String TAG = Logger.createTag("ControlObjectListenerImpl");
    private final DragAndDropController mDragAndDropController;
    private DragAndDropInfo mDragAndDropInfo;
    private ExecuteOtherActivityController mExecuteOtherActivityController;
    private ObjectManager mObjectManager;
    protected ListenerImplContract.IPresenter mPresenter;
    private TaskController mTaskController;
    private TextManager mTextManager;
    private boolean mIsReleased = false;
    private final BridgeListenerList<SpenControlObjectListener> mBridgeListeners = new BridgeListenerList<>();

    public ControlObjectListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager, DragAndDropController dragAndDropController) {
        this.mPresenter = iPresenter;
        this.mObjectManager = iPresenter.getObjectManager();
        this.mTextManager = iPresenter.getTextManager();
        this.mExecuteOtherActivityController = controllerManager.getExecuteOtherActivityController();
        this.mDragAndDropController = dragAndDropController;
        this.mTaskController = controllerManager.getTaskController();
    }

    private boolean canSelectInputForm(SpenObjectBase spenObjectBase) {
        return spenObjectBase.isPdfDummyObject();
    }

    private boolean canSelectItemByAction(SpenObjectBase spenObjectBase, int i, int i2) {
        if (!ObjectTypeUtil.isMathType(spenObjectBase.getType())) {
            return false;
        }
        if (i == 2 || i == 3) {
            return i2 == 2 || i2 == 8;
        }
        return false;
    }

    private boolean canSelectItemByFinger(int i) {
        return i == 1 && !isOnFingerDrawing();
    }

    private boolean canSelectItemByTool(int i) {
        return (i == 2 || i == 3) && this.mPresenter.getComposerModel().getModeManager().getMode() == Mode.Text;
    }

    private Intent createLinkIntent(SpenObjectLink spenObjectLink) {
        String packageName = spenObjectLink.getPackageName();
        String action = spenObjectLink.getAction();
        Intent intent = new Intent();
        intent.setPackage(packageName);
        try {
            JSONObject jSONObject = new JSONObject(action);
            intent.setAction(jSONObject.getString("key_action"));
            String strOptString = jSONObject.optString(ExtraDataHelper.KEY_MIME_TYPE);
            if (TextUtils.isEmpty(strOptString)) {
                intent.addFlags(268435456);
                intent.setData(Uri.parse(jSONObject.optString(ExtraDataHelper.KEY_URI)));
            } else if (strOptString.equals(Constants.MIME_IMAGE)) {
                Uri uriFromExtFilePath = Uri.parse(jSONObject.optString(ExtraDataHelper.KEY_URI));
                if (!UriFileUtils.isContentSecMedia(uriFromExtFilePath)) {
                    uriFromExtFilePath = UriFileUtils.getUriFromExtFilePath(this.mPresenter.getActivity(), spenObjectLink.getOption());
                }
                intent.setDataAndType(uriFromExtFilePath, strOptString);
            }
            new ExtraDataHelper().setExtraToIntent(intent, jSONObject);
            Logger.m11003i(TAG, intent.toString());
            return intent;
        } catch (JSONException e) {
            Logger.m11000e(TAG, "createLinkIntent# " + e.getMessage());
            return null;
        }
    }

    private boolean deselect(SpenObjectBase spenObjectBase) {
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.size() != 1 || !selectedObjectList.get(0).getId().equals(spenObjectBase.getId())) {
            return false;
        }
        this.mObjectManager.clearSelectObject();
        return true;
    }

    private boolean isOnFingerDrawing() {
        return this.mPresenter.getComposerModel().getModeManager().getMode() == Mode.Writing && !this.mPresenter.getWritingToolManager().isSpenOnlyMode();
    }

    private boolean isSelectTableObject(SpenObjectBase spenObjectBase) {
        List<SpenObjectBase> selectedObjectList;
        if (spenObjectBase.getType() != 2 || (selectedObjectList = this.mObjectManager.getSelectedObjectList()) == null || selectedObjectList.size() != 1 || selectedObjectList.get(0).getType() != 22) {
            return false;
        }
        SpenObjectTable spenObjectTable = (SpenObjectTable) selectedObjectList.get(0);
        if (spenObjectTable.getSelectedCellPositions() == null) {
            selectCells(spenObjectTable, spenObjectBase);
        }
        this.mPresenter.getTableAndCellPresenter().showCalculateRemoveMenu(spenObjectTable);
        return true;
    }

    private void loggingSAEvent(int i) {
        if (i == 3) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CONTENTS_CLICK, "a");
            return;
        }
        if (i == 7) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CONTENTS_CLICK, "f");
            return;
        }
        if (i == 10) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CONTENTS_CLICK, "c");
            return;
        }
        if (i == 22) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CONTENTS_CLICK, "e");
        } else if (i == 13) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CONTENTS_CLICK, "d");
        } else {
            if (i != 14) {
                return;
            }
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CONTENTS_CLICK, "b");
        }
    }

    private void onClickedCopyCodeBlock(SpenObjectCodeBlock spenObjectCodeBlock) {
        this.mObjectManager.clearSelectObject();
        ObjectSpanHelper objectSpanHelper = new ObjectSpanHelper(this.mObjectManager.getNote());
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{spenObjectCodeBlock}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        int[] iArrFindObjectSpanCursorPosition = objectSpanHelper.findObjectSpanCursorPosition(Collections.unmodifiableList(arrayList));
        TaskCopy.InputValues inputValues = new TaskCopy.InputValues(this.mPresenter.getActivity(), this.mObjectManager, this.mTextManager.getTextBox(), iArrFindObjectSpanCursorPosition[0], iArrFindObjectSpanCursorPosition[1]);
        this.mTaskController.execute(new TaskCopy(), inputValues, new Task.Callback<TaskCopy.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskCopy.ResultValues resultValues) {
                resultValues.showErrorToast();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskCopy.ResultValues resultValues) {
                ControlObjectListenerImpl.this.mObjectManager.clearSelectObject();
            }
        }, false);
    }

    private void onClickedLinkCard(SpenObjectLink spenObjectLink) {
        Logger.m10999d(TAG, "onClickedLinkCard# " + spenObjectLink.getAction());
        IntentUtil.startActivity(this.mPresenter.getActivity(), createLinkIntent(spenObjectLink));
    }

    private void selectCells(SpenObjectTable spenObjectTable, SpenObjectBase spenObjectBase) {
        int rowsCount = spenObjectTable.getRowsCount();
        int columnsCount = spenObjectTable.getColumnsCount();
        for (int i = rowsCount - 1; i >= 0; i--) {
            for (int i2 = 0; i2 < columnsCount; i2++) {
                if (spenObjectBase.getId().equals(spenObjectTable.getContentObject(i, i2).getId())) {
                    ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>();
                    arrayList.add(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
                    spenObjectTable.selectCells(arrayList);
                    return;
                }
            }
        }
    }

    private boolean selectTextBox(SpenObjectBase spenObjectBase) {
        if (spenObjectBase.getType() != 2 || !this.mPresenter.getComposerModel().getModeManager().isEditMode()) {
            return false;
        }
        this.mObjectManager.selectObject(spenObjectBase);
        this.mTextManager.setFocusedTextBox((SpenObjectTextBox) spenObjectBase);
        this.mObjectManager.getSelectedObjectManager().setFocus(true);
        return true;
    }

    private boolean showMoreMenu(SpenObjectBase spenObjectBase, RectF rectF, boolean z, boolean z2) {
        if (spenObjectBase == null) {
            Logger.m11000e(getTAG(), "showMoreMenu# object is null");
            return false;
        }
        Logger.m10999d(getTAG(), "showMoreMenu# " + spenObjectBase.getType());
        if (this.mIsReleased) {
            return false;
        }
        this.mPresenter.getTableAndCellPresenter().showMoreMenu(spenObjectBase, rectF, z, z2);
        this.mPresenter.getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                ControlObjectListenerImpl.this.mPresenter.setContextMenu(false);
            }
        }, 10L);
        return true;
    }

    public void addListener(SpenControlObjectListener spenControlObjectListener) {
        this.mBridgeListeners.addBridgeListener(spenControlObjectListener);
    }

    public boolean canDeselectObject(int i) {
        if (i == 3 || i == 10 || i == 13 || i == 17) {
            return true;
        }
        return i == 2 && this.mPresenter.getComposerModel().getModeManager().isMode(Mode.View);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeBrush(SpenObjectBase spenObjectBase, String str) {
        boolean z = false;
        if (!this.mPresenter.getComposerModel().isEditable()) {
            Logger.m11003i(getTAG(), "executeBrush# not editable");
            return false;
        }
        if (!spenObjectBase.isAllContentFileAvailable()) {
            Logger.m11003i(getTAG(), "executeBrush# file not available");
            return false;
        }
        if (spenObjectBase.getLockState()) {
            Logger.m11003i(getTAG(), "executeBrush# locked");
            return false;
        }
        if (!this.mPresenter.getComposerModel().getModeManager().isMode(Mode.View)) {
            if (this.mPresenter.getComposerModel().getModeManager().isEditMode()) {
            }
            if (z) {
                this.mObjectManager.setClickedObject(spenObjectBase);
                SpenObjectPainting spenObjectPainting = (SpenObjectPainting) spenObjectBase;
                this.mPresenter.requestReadyForSave();
                this.mExecuteOtherActivityController.executeBrush(spenObjectPainting.getId(), spenObjectPainting.getAttachedFile(), spenObjectPainting.getThumbnailPath());
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_BRUSH_TYPE);
            }
            return z;
        }
        this.mPresenter.getComposerModel().getModeManager().setMode(Mode.Writing, str, true);
        z = true;
        if (z) {
        }
        return z;
    }

    public String getTAG() {
        return TAG;
    }

    public void onClickedWebCard(SpenObjectWeb spenObjectWeb) {
        this.mTaskController.execute(new TaskOpenWebCard(), new TaskOpenWebCard.InputValues(this.mPresenter.getActivity(), spenObjectWeb, this.mPresenter.getComposerModel().getDocState().getUuid()), new Task.Callback<TaskOpenWebCard.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskOpenWebCard.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskOpenWebCard.ResultValues resultValues) {
                IntentUtil.startActivity(ControlObjectListenerImpl.this.mPresenter.getActivity(), resultValues.getIntent());
            }
        }, false);
        if (TextUtils.isEmpty(spenObjectWeb.getAttachedHTMLFile())) {
            ComposerSA.insertLog(this.mPresenter.getComposerModel().getModeManager().isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_VIEW_WEBCARD);
        } else {
            ComposerSA.insertLog(this.mPresenter.getComposerModel().getModeManager().isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_VIEW_SCRAPBOOK);
        }
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onItemButtonClicked(SpenObjectBase spenObjectBase) {
        Logger.m10999d(getTAG(), "onItemButtonClicked# " + spenObjectBase.getType());
        if (this.mIsReleased) {
            return false;
        }
        Iterator<SpenControlObjectListener> it = this.mBridgeListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onItemButtonClicked(spenObjectBase)) {
                return true;
            }
        }
        if (spenObjectBase.getType() == 14) {
            return executeBrush(spenObjectBase, "onItemButtonClicked");
        }
        if (spenObjectBase.getType() == 13 && (spenObjectBase instanceof SpenObjectWeb)) {
            onClickedWebCard((SpenObjectWeb) spenObjectBase);
            return true;
        }
        if (spenObjectBase.getType() == 17 && (spenObjectBase instanceof SpenObjectLink)) {
            onClickedLinkCard((SpenObjectLink) spenObjectBase);
            return true;
        }
        if (!(spenObjectBase instanceof SpenObjectCodeBlock)) {
            return false;
        }
        onClickedCopyCodeBlock((SpenObjectCodeBlock) spenObjectBase);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onItemClicked(int i, SpenObjectBase spenObjectBase) {
        int type = spenObjectBase.getType();
        AbstractC8014b.m7216r(i, type, "onItemClicked# toolType = ", " / objectType = ", getTAG());
        if (this.mIsReleased) {
            return false;
        }
        if (type == 19) {
            this.mPresenter.getDialogPresenterManager().showUnavailableContentDialog();
            return true;
        }
        if (!canSelectItemByFinger(i) && !canSelectItemByTool(i) && !canSelectInputForm(spenObjectBase) && !canSelectItemByAction(spenObjectBase, i, this.mPresenter.getWritingToolManager().getToolTypeAction(i))) {
            return false;
        }
        Iterator<SpenControlObjectListener> it = this.mBridgeListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onItemClicked(i, spenObjectBase)) {
                return true;
            }
        }
        if (selectTextBox(spenObjectBase)) {
            return true;
        }
        this.mObjectManager.selectObject(spenObjectBase);
        if (spenObjectBase.getType() == 22) {
            this.mObjectManager.getSelectedObjectManager().setFocus(true);
            this.mPresenter.disableTableUnsupportedMenu();
        }
        loggingSAEvent(type);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onItemLongClicked(int i, SpenObjectBase spenObjectBase) {
        Iterator<SpenControlObjectListener> it = this.mBridgeListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onItemLongClicked(i, spenObjectBase)) {
                return true;
            }
        }
        AbstractC8014b.m7216r(i, spenObjectBase.getType(), "onItemLongClicked# tooltype = ", " / objectType = ", getTAG());
        this.mObjectManager.selectObject(spenObjectBase);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onItemShowContextAllCellsMenu(SpenObjectBase spenObjectBase, @NonNull RectF rectF) {
        return showMoreMenu(spenObjectBase, rectF, true, true);
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onItemShowContextColumnMenu(SpenObjectBase spenObjectBase, @NonNull RectF rectF) {
        return showMoreMenu(spenObjectBase, rectF, false, false);
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onItemShowContextRowMenu(SpenObjectBase spenObjectBase, @NonNull RectF rectF) {
        return showMoreMenu(spenObjectBase, rectF, false, true);
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onSelectedItemClicked(SpenObjectBase spenObjectBase) {
        if (this.mIsReleased || this.mTaskController.isRunning()) {
            return false;
        }
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(tag);
        Iterator<SpenControlObjectListener> it = this.mBridgeListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onSelectedItemClicked(spenObjectBase)) {
                return true;
            }
        }
        int type = spenObjectBase.getType();
        AbstractC0000a.m3D(type, "onSelectedItemClicked# ", getTAG());
        return type == 14 ? executeBrush(spenObjectBase, "onSelectedItemClicked") : canDeselectObject(type) ? deselect(spenObjectBase) : isSelectTableObject(spenObjectBase);
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onSelectedItemLongClicked(SpenObjectBase spenObjectBase) {
        Logger.m10999d(getTAG(), "onSelectedItemLongClicked# " + spenObjectBase.getType());
        if (this.mIsReleased) {
            return false;
        }
        if (this.mObjectManager.getSelectedObjectList() == null || this.mObjectManager.getSelectedObjectList().size() <= 0) {
            Logger.m11000e(getTAG(), "onSelectedItemLongClicked# SelectedObjectList is empty");
            return false;
        }
        Iterator<SpenControlObjectListener> it = this.mBridgeListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onSelectedItemLongClicked(spenObjectBase)) {
                return true;
            }
        }
        if (ObjectTypeUtil.isTextType(spenObjectBase.getType()) && this.mObjectManager.isFocusedTextBox()) {
            if (!(spenObjectBase instanceof SpenObjectShape)) {
                return false;
            }
            int[] cursor = this.mObjectManager.getTextManager().getCursor((SpenObjectShape) spenObjectBase);
            if (cursor[0] == cursor[1]) {
                Logger.m11000e(getTAG(), "onSelectedItemLongClicked# The text is not selected.");
                return false;
            }
        } else if (ObjectTypeUtil.isTableType(spenObjectBase.getType())) {
            SpenObjectTable spenObjectTable = (SpenObjectTable) spenObjectBase;
            ArrayList<Pair<Integer, Integer>> selectedCellPositions = spenObjectTable.getSelectedCellPositions();
            if (selectedCellPositions == null || selectedCellPositions.isEmpty()) {
                Logger.m11000e(getTAG(), "onSelectedItemLongClicked# The table is not selected.");
                return false;
            }
            if (selectedCellPositions.size() > 1) {
                Logger.m11000e(getTAG(), "onSelectedItemLongClicked# Two or more cells selected");
                return false;
            }
            Pair<Integer, Integer> pair = selectedCellPositions.get(0);
            int[] cursor2 = TextUtil.getCursor(spenObjectTable.getContentObject(pair.getFirst().intValue(), pair.getSecond().intValue()));
            if (cursor2[0] == cursor2[1]) {
                Logger.m11000e(getTAG(), "onSelectedItemLongClicked# The cell text is not selected. [" + pair.getFirst() + SQLKeyword.COMMA + pair.getSecond() + "]");
                return false;
            }
        } else if (ObjectTypeUtil.hasMathType(this.mObjectManager.getSelectedObjectList())) {
            Logger.m10999d(TAG, "onSelectedItemLongClicked# has math type");
            return false;
        }
        return this.mDragAndDropController.executeDragAndDrop(this.mDragAndDropInfo);
    }

    public void release() {
        this.mPresenter = null;
        this.mObjectManager = null;
        this.mTextManager = null;
        this.mExecuteOtherActivityController = null;
        this.mTaskController = null;
        this.mDragAndDropController.release();
        this.mIsReleased = true;
    }

    public void removeListener(SpenControlObjectListener spenControlObjectListener) {
        BridgeListenerList<SpenControlObjectListener> bridgeListenerList = this.mBridgeListeners;
        if (bridgeListenerList == null) {
            return;
        }
        bridgeListenerList.removeBridgeListener(spenControlObjectListener);
    }

    public void setDragAndDropInfo(DragAndDropInfo dragAndDropInfo) {
        this.mDragAndDropInfo = dragAndDropInfo;
    }
}
