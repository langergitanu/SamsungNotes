package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandOffData;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffSendManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.CvPageSettingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HandoffHandler extends Handler implements DocPageInfo.PositionObserver {
    private static final int DELAY_SEND_HANDOFF_DATA = 200;
    public static final int DELAY_SEND_HANDOFF_DATA_OBJECT_UPDATE = 1000;
    public static final int MSG_SEND = 1;
    private static final String TAG = Logger.createTag("HandoffHandler");
    private ComposerModel mComposerModel;
    private final Contract mContract;
    private CvPageSettingController mCvPageSettingController;
    private ObjectManager mObjectManager;
    private PageManager mPageManager;
    private int mScreenWidth;
    private TextManager mTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean isDisabled();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DialogManager {
        void hideSyncWaitingProgressDialog();
    }

    public HandoffHandler(@NonNull Looper looper, Contract contract) {
        super(looper);
        this.mContract = contract;
    }

    private boolean isNeededToWaitSync() {
        return this.mComposerModel.getVoiceModel().isRecordingVoiceState() || this.mComposerModel.isChangedDocState();
    }

    private boolean isNotAvailableToSendHandoffData() {
        return this.mComposerModel.getDocState() == null || !this.mComposerModel.isEditable();
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        AbstractC8014b.m7221w(new StringBuilder("handleMessage# "), TAG, message.what);
        if (message.what == 1) {
            sendHandoffData();
        }
    }

    public void init(ComposerModel composerModel, PageManager pageManager, ObjectManager objectManager, TextManager textManager, CvPageSettingController cvPageSettingController, int i) {
        this.mComposerModel = composerModel;
        this.mPageManager = pageManager;
        this.mObjectManager = objectManager;
        this.mTextManager = textManager;
        this.mScreenWidth = i;
        pageManager.getDocPageInfo().setPositionObserver(this);
        this.mCvPageSettingController = cvPageSettingController;
    }

    public boolean isDisabled() {
        return this.mContract.isDisabled();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.DocPageInfo.PositionObserver
    public void onPositionChanged(float f, float f4, float f5) {
        sendHandoffDataMsg();
    }

    public void release() {
        removeCallbacksAndMessages(null);
    }

    public void sendHandoffData() {
        List<SpenObjectBase> selectedObjectList;
        if (isDisabled() || isNotAvailableToSendHandoffData()) {
            return;
        }
        if (this.mComposerModel.isEmpty()) {
            removeMessages(1);
            CoHandoffSendManager.getInstance().disable(this.mComposerModel.getDocState().getUuid());
            return;
        }
        if (hasMessages(1)) {
            return;
        }
        CoHandOffData coHandOffData = new CoHandOffData();
        PagePanInfo pagePan = this.mPageManager.getDocPageInfo().getPagePan();
        int currentPageIndex = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
        float contentPanY = 0.0f;
        if (pagePan != null) {
            coHandOffData.putDouble(CoHandoffConstant.ARG_CURR_X_POSITION_ON_PAGE, pagePan.getPan().x);
            coHandOffData.putDouble(CoHandoffConstant.ARG_CURR_Y_POSITION_ON_PAGE, pagePan.getPan().y);
            coHandOffData.putDouble(CoHandoffConstant.ARG_CURR_ZOOM, this.mPageManager.getDocPageInfo().getZoomRatio());
            currentPageIndex = pagePan.getPageIndex();
            if (this.mCvPageSettingController.getPageLayoutState().isVertical()) {
                contentPanY = pagePan.getContentPanY();
            }
        }
        coHandOffData.putInt(CoHandoffConstant.ARG_CURR_PAGE_INDEX, currentPageIndex);
        coHandOffData.putDouble(CoHandoffConstant.ARG_CURR_Y_POSITION, contentPanY);
        coHandOffData.putInt(CoHandoffConstant.ARG_SCREEN_WIDTH, this.mScreenWidth);
        coHandOffData.putLong(CoHandoffConstant.ARG_SERVER_TIME_STAMP, this.mComposerModel.getNotesDocEntityManager().getServerTimeStamp() + (isNeededToWaitSync() ? 1L : 0L));
        Mode mode = this.mComposerModel.getModeManager().getMode();
        if (mode == Mode.Search) {
            mode = Mode.View;
        } else if (mode == Mode.ReadOnly) {
            mode = this.mComposerModel.getModeManager().getPrevMode();
        }
        coHandOffData.putString(CoHandoffConstant.ARG_CURR_MODE, mode.toString());
        if (this.mComposerModel.getModeManager().isMode(Mode.Text) && this.mObjectManager.isSelectedBodyText() && (selectedObjectList = this.mObjectManager.getSelectedObjectList()) != null && !selectedObjectList.isEmpty()) {
            coHandOffData.putInt(CoHandoffConstant.ARG_CURR_CURSOR, this.mTextManager.getCursor((SpenObjectShape) selectedObjectList.get(0))[1]);
        }
        CoHandoffSendManager.getInstance().send(this.mComposerModel.getDocState().getUuid(), coHandOffData);
        Logger.m10999d(TAG, "sendHandoffData# " + coHandOffData.getJsonObject());
    }

    public void sendHandoffDataMsg() {
        sendHandoffDataMsg(200);
    }

    public void sendHandoffDataMsg(int i) {
        if (isDisabled() || isNotAvailableToSendHandoffData()) {
            return;
        }
        removeMessages(1);
        sendEmptyMessageDelayed(1, i);
    }

    public void init() {
        this.mPageManager.getDocPageInfo().setPositionObserver(this);
    }
}
