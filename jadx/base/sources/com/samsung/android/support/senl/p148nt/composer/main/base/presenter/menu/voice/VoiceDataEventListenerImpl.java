package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice;

import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$VoiceDataEventListener;", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mVoiceListPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordListPresenter;", "mSTTPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/STTPresenterImpl;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordListPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/STTPresenterImpl;)V", "mVoiceDataEventAction", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl$IVoiceDataEventAction;", "setCoedit", "", "isCoedit", "", "onVoiceDataChanged", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "spenVoiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "changeType", "", "IVoiceDataEventAction", "VoiceDataEventAction", "CoeditVoiceDataEventAction", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceDataEventListenerImpl implements SpenWNote.VoiceDataEventListener {

    @NotNull
    private static final String TAG;

    @Nullable
    private final STTPresenterImpl mSTTPresenter;

    @NotNull
    private IVoiceDataEventAction mVoiceDataEventAction;

    @NotNull
    private final VoiceRecordListPresenter mVoiceListPresenter;

    @NotNull
    private final VoiceModel mVoiceModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl$CoeditVoiceDataEventAction;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl$IVoiceDataEventAction;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl;)V", "addVoiceData", "", "spenVoiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class CoeditVoiceDataEventAction implements IVoiceDataEventAction {
        public CoeditVoiceDataEventAction() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceDataEventListenerImpl.IVoiceDataEventAction
        public void addVoiceData(@Nullable SpenVoiceData spenVoiceData) {
            VoiceDataEventListenerImpl.this.mVoiceModel.addVoiceData(spenVoiceData);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl$IVoiceDataEventAction;", "", "addVoiceData", "", "spenVoiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IVoiceDataEventAction {
        void addVoiceData(@Nullable SpenVoiceData spenVoiceData);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl$VoiceDataEventAction;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl$IVoiceDataEventAction;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl;)V", "addVoiceData", "", "spenVoiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class VoiceDataEventAction implements IVoiceDataEventAction {
        public VoiceDataEventAction() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceDataEventListenerImpl.IVoiceDataEventAction
        public void addVoiceData(@Nullable SpenVoiceData spenVoiceData) {
            VoiceDataEventListenerImpl.this.mVoiceModel.addVoiceData(spenVoiceData);
            VoiceRecordListPresenter voiceRecordListPresenter = VoiceDataEventListenerImpl.this.mVoiceListPresenter;
            Intrinsics.checkNotNull(spenVoiceData);
            voiceRecordListPresenter.add(spenVoiceData);
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceDataEventListenerImpl");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceDataEventListenerImpl(@NotNull VoiceModel mVoiceModel, @NotNull VoiceRecordListPresenter mVoiceListPresenter, @Nullable STTPresenterImpl sTTPresenterImpl) {
        Intrinsics.checkNotNullParameter(mVoiceModel, "mVoiceModel");
        Intrinsics.checkNotNullParameter(mVoiceListPresenter, "mVoiceListPresenter");
        this.mVoiceModel = mVoiceModel;
        this.mVoiceListPresenter = mVoiceListPresenter;
        this.mSTTPresenter = sTTPresenterImpl;
        this.mVoiceDataEventAction = new VoiceDataEventAction();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.VoiceDataEventListener
    public void onVoiceDataChanged(@NotNull SpenWNote spenWNote, @NotNull SpenVoiceData spenVoiceData, int changeType) {
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        String str = TAG;
        StringBuilder sb = new StringBuilder("onVoiceDataChanged. ");
        sb.append(spenWNote);
        sb.append(SQLKeyword.COMMA);
        sb.append(spenVoiceData);
        sb.append(SQLKeyword.COMMA);
        AbstractC8014b.m7221w(sb, str, changeType);
        int voiceDataIndex = this.mVoiceModel.getVoiceDataIndex(spenVoiceData);
        if (changeType != 0) {
            if (changeType == 1 && voiceDataIndex >= 0) {
                this.mVoiceModel.stopPlaying();
                this.mVoiceModel.removeVoiceData(spenVoiceData);
                this.mVoiceListPresenter.remove(voiceDataIndex);
            }
        } else if (voiceDataIndex < 0) {
            this.mVoiceDataEventAction.addVoiceData(spenVoiceData);
        }
        if (this.mVoiceModel.getViewState().isVisibleState()) {
            if (this.mVoiceModel.getVoiceDataListSize() == 0) {
                this.mVoiceModel.setViewStateType(VoiceViewState.Type.HIDE);
                this.mVoiceModel.clearSelectedVoiceList();
                this.mVoiceModel.setRecordingTime(0);
                this.mVoiceListPresenter.updateVoiceMenu();
            } else if (this.mVoiceModel.getRecordingTime() == 0) {
                VoiceModel voiceModel = this.mVoiceModel;
                voiceModel.setRecordingTime(voiceModel.getAllRecordTime() / 1000);
            }
        }
        if (FeatureInfo.isSupportSTTFunction()) {
            STTPresenterImpl sTTPresenterImpl = this.mSTTPresenter;
            Intrinsics.checkNotNull(sTTPresenterImpl);
            int mItemIndexToShow = sTTPresenterImpl.getMItemIndexToShow();
            if (mItemIndexToShow >= this.mVoiceModel.getVoiceDataList().size()) {
                mItemIndexToShow = this.mVoiceModel.getVoiceDataList().size() - 1;
            }
            this.mSTTPresenter.setIndexItemToShow(mItemIndexToShow);
            this.mSTTPresenter.resetSTTViewToDefault();
            this.mSTTPresenter.showTabletVoiceList();
            if (!this.mSTTPresenter.getVoiceDataController().isHaveSTTData(mItemIndexToShow) && !this.mSTTPresenter.isItemSTTConverting(mItemIndexToShow)) {
                this.mSTTPresenter.showHelpView(mItemIndexToShow);
            }
            this.mSTTPresenter.onVoiceDataChanged(spenVoiceData, changeType);
        }
    }

    public final void setCoedit(boolean isCoedit) {
        this.mVoiceDataEventAction = isCoedit ? new CoeditVoiceDataEventAction() : new VoiceDataEventAction();
    }
}
