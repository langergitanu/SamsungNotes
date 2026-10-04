package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectResult;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsCollectListenerImpl extends Observable implements ICollectListener {
    private static final int NONE = -1;
    private static final String TAG = Logger.createTag("AbsCollectListenerImpl");
    protected Activity mActivity;
    protected ComposerModel mComposerModel;
    protected int mHashCode = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidDoc() {
        ComposerModel composerModel = this.mComposerModel;
        return (composerModel == null || composerModel.getDocState() == null || this.mComposerModel.getDocState().getDoc() == null || ((SpenWordDocument) this.mComposerModel.getDocState().getDoc()).isClosed()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener
    public SpenWNote getOpenedDoc(CollectInfo collectInfo) {
        if (CommonUtil.isAvailableActivity(this.mActivity) && isValidDoc() && collectInfo.getUuid().equals(this.mComposerModel.getDocState().getUuid())) {
            return this.mComposerModel.getDoc();
        }
        return null;
    }

    public void init(@NonNull Activity activity, ComposerModel composerModel) {
        this.mActivity = activity;
        this.mHashCode = activity.hashCode();
        this.mComposerModel = composerModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener
    public void onCollectCanceled(CollectInfo collectInfo, ICollectResult iCollectResult) {
        String str = TAG;
        Logger.m10999d(str, "onCollectCanceled# " + this.mHashCode + " " + collectInfo.getUuid());
        if (getOpenedDoc(collectInfo) != null) {
            Logger.m10999d(str, "onCollectCanceled# " + getClass().getSimpleName() + ", activity/uuid : " + this.mHashCode + "/" + collectInfo.getUuid());
            setChanged();
            notifyObservers(iCollectResult);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener
    public void onCollectFailed(CollectInfo collectInfo, ICollectResult iCollectResult) {
        String str = TAG;
        Logger.m10999d(str, "onCollectFailed# " + this.mHashCode + " " + collectInfo.getUuid());
        if (getOpenedDoc(collectInfo) != null) {
            Logger.m10999d(str, "onCollectFailed# " + getClass().getSimpleName() + ", activity/uuid : " + this.mHashCode + "/" + collectInfo.getUuid());
            setChanged();
            notifyObservers(iCollectResult);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener
    public void onCollectFinished(CollectInfo collectInfo, ICollectResult iCollectResult) {
        if (getOpenedDoc(collectInfo) != null) {
            Logger.m10999d(TAG, "onCollectFinished# " + getClass().getSimpleName() + ", activity/uuid : " + this.mHashCode + "/" + collectInfo.getUuid());
            setChanged();
            notifyObservers(iCollectResult);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener
    public void onCollectStarted(CollectInfo collectInfo) {
        Logger.m10999d(TAG, "onCollectStarted# " + getClass().getSimpleName() + ", activity/uuid : " + this.mHashCode + "/" + collectInfo.getUuid());
    }

    public void release() {
        this.mActivity = null;
        this.mHashCode = -1;
        this.mComposerModel = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener
    public void setStrokeRecognitionData(final Map<String, ArrayList<SpenWPage.StrokeRecognitionData>> map, final List<String> list, final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.service.AbsCollectListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (CommonUtil.isAvailableActivity(AbsCollectListenerImpl.this.mActivity) && AbsCollectListenerImpl.this.isValidDoc()) {
                    if (AbsCollectListenerImpl.this.mComposerModel.getComposerSaveModel().isReloadingWorkingState()) {
                        Logger.m10999d(AbsCollectListenerImpl.TAG, "setStrokeRecognitionData# WorkingState.RELOADING");
                        return;
                    }
                    SearchModel searchData = AbsCollectListenerImpl.this.mComposerModel.getSearchData();
                    if (searchData == null || !searchData.isSearching()) {
                        AbsCollectListenerImpl.this.mComposerModel.getComposerSpenDocModel().setStrokeRecognitionData(map, list, z);
                    } else {
                        Logger.m10999d(AbsCollectListenerImpl.TAG, "setStrokeRecognitionData# isSearching true");
                    }
                }
            }
        });
    }
}
