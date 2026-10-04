package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.listener.ContextAwarenessListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.quicknote.common.QuickNotePresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.MediaCollectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ObjectRecognitionCollectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.PdfSearchCollectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.TextSearchCollectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectListener;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.MediaCollectListenerManager;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ObjectRecognitionCollectListenerManager;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.PdfSearchCollectListenerManager;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.TextSearchCollectListenerManager;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessListenerManager;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.ContextAwarenessFeature;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalListenerManager implements QuickNotePresenterContract.IExternalListenerManager {
    private static final String TAG = "ExternalListenerManager";
    private final ComposerLifeState mComposerLifeState;
    private final ComposerModel mComposerModel;
    private ContextAwarenessListenerImpl mContextAwarenessListener;
    private MediaCollectListenerImpl mMediaCollectListener;
    private final MenuPresenterManager mMenuPresenterManager;
    private ObjectRecognitionCollectListenerImpl mObjectRecognitionCollectListener;
    private PdfSearchCollectListenerImpl mPdfSearchCollectListener;
    private SpenInsertDetector mSpenInsertDetector;
    private TextSearchCollectListenerImpl mTextSearchCollectListener;

    public ExternalListenerManager(BaseSubManager baseSubManager) {
        this.mComposerLifeState = baseSubManager.getComposerLifeState();
        this.mComposerModel = baseSubManager.getComposerModel();
        this.mMenuPresenterManager = baseSubManager.getMenuPresenterManager();
        createSpenInsertDetector();
        createFoldStateListener();
    }

    private void addCollectListener(Activity activity) {
        Logger.m10999d(TAG, "addCollectListener#");
        if (this.mObjectRecognitionCollectListener == null) {
            this.mObjectRecognitionCollectListener = new ObjectRecognitionCollectListenerImpl();
        }
        this.mObjectRecognitionCollectListener.init(activity, this.mComposerModel);
        ObjectRecognitionCollectListenerManager.getInstance().addListener((ICollectListener) this.mObjectRecognitionCollectListener);
        if (this.mTextSearchCollectListener == null) {
            this.mTextSearchCollectListener = new TextSearchCollectListenerImpl();
        }
        this.mTextSearchCollectListener.init(activity, this.mComposerModel);
        TextSearchCollectListenerManager.getInstance().addListener((ICollectListener) this.mTextSearchCollectListener);
        if (this.mPdfSearchCollectListener == null) {
            this.mPdfSearchCollectListener = new PdfSearchCollectListenerImpl();
        }
        this.mPdfSearchCollectListener.init(activity, this.mComposerModel);
        PdfSearchCollectListenerManager.getInstance().addListener((ICollectListener) this.mPdfSearchCollectListener);
        if (this.mMediaCollectListener == null) {
            this.mMediaCollectListener = new MediaCollectListenerImpl();
        }
        this.mMediaCollectListener.init(activity, this.mComposerModel);
        MediaCollectListenerManager.getInstance().addListener((ICollectListener) this.mMediaCollectListener);
    }

    private void addContextAwarenessListener(Activity activity) {
        if (this.mContextAwarenessListener == null) {
            this.mContextAwarenessListener = new ContextAwarenessListenerImpl();
        }
        this.mContextAwarenessListener.init(activity);
        ContextAwarenessListenerManager.getInstance().addListener(activity.hashCode(), this.mContextAwarenessListener);
    }

    private void createFoldStateListener() {
        if (FoldStateCompat.getInstance().getFoldType() != 2) {
            return;
        }
        FoldStateCompat.getInstance().getFoldState(new FoldStateCompat.FolderStateCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ExternalListenerManager.2
            @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FolderStateCallback
            public void onFailed() {
                ExternalListenerManager.this.mComposerModel.getComposerState().setFoldState(0);
            }

            @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FolderStateCallback
            public void onSuccess(int i) {
                AbstractC0000a.m3D(i, "createFoldStateListener# foldState : ", ExternalListenerManager.TAG);
                ExternalListenerManager.this.mComposerModel.getComposerState().setFoldState(i);
            }
        });
    }

    private void createSpenInsertDetector() {
        if (!DeviceUtils.isSpenModel() || DeviceUtils.isTabletModel()) {
            return;
        }
        this.mSpenInsertDetector = new SpenInsertDetector(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ExternalListenerManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (ExternalListenerManager.this.mComposerLifeState.isInitLayoutFinished() && ExternalListenerManager.this.mComposerModel != null && ExternalListenerManager.this.mComposerModel.getModeManager().getMode() == Mode.Text) {
                    if (ExternalListenerManager.this.mMenuPresenterManager != null) {
                        ExternalListenerManager.this.mMenuPresenterManager.getRtToolbarPresenter().hideAll();
                    }
                    ExternalListenerManager.this.mComposerModel.getModeManager().setMode(Mode.Writing, "penInsert", true);
                }
            }
        });
    }

    private void removeCollectListener() {
        Logger.m10999d(TAG, "removeCollectListener#");
        ObjectRecognitionCollectListenerImpl objectRecognitionCollectListenerImpl = this.mObjectRecognitionCollectListener;
        if (objectRecognitionCollectListenerImpl != null) {
            objectRecognitionCollectListenerImpl.release();
            ObjectRecognitionCollectListenerManager.getInstance().removeListener((ICollectListener) this.mObjectRecognitionCollectListener);
        }
        TextSearchCollectListenerImpl textSearchCollectListenerImpl = this.mTextSearchCollectListener;
        if (textSearchCollectListenerImpl != null) {
            textSearchCollectListenerImpl.release();
            TextSearchCollectListenerManager.getInstance().removeListener((ICollectListener) this.mTextSearchCollectListener);
        }
        PdfSearchCollectListenerImpl pdfSearchCollectListenerImpl = this.mPdfSearchCollectListener;
        if (pdfSearchCollectListenerImpl != null) {
            pdfSearchCollectListenerImpl.release();
            PdfSearchCollectListenerManager.getInstance().removeListener((ICollectListener) this.mPdfSearchCollectListener);
        }
        MediaCollectListenerImpl mediaCollectListenerImpl = this.mMediaCollectListener;
        if (mediaCollectListenerImpl != null) {
            mediaCollectListenerImpl.release();
            MediaCollectListenerManager.getInstance().removeListener((ICollectListener) this.mMediaCollectListener);
        }
    }

    private void removeContextAwarenessListener(Activity activity) {
        ContextAwarenessListenerImpl contextAwarenessListenerImpl = this.mContextAwarenessListener;
        if (contextAwarenessListenerImpl != null) {
            contextAwarenessListenerImpl.release();
            ContextAwarenessListenerManager.getInstance().removeListener(activity.hashCode());
        }
    }

    public MediaCollectListenerImpl getMediaCollectListener() {
        return this.mMediaCollectListener;
    }

    public ObjectRecognitionCollectListenerImpl getObjectRecognitionCollectListener() {
        return this.mObjectRecognitionCollectListener;
    }

    public PdfSearchCollectListenerImpl getPdfSearchCollectListener() {
        return this.mPdfSearchCollectListener;
    }

    public TextSearchCollectListenerImpl getTextSearchCollectListener() {
        return this.mTextSearchCollectListener;
    }

    public void onActivityCreated(Activity activity) {
        if (ContextAwarenessFeature.isContextAwarenessEnabled()) {
            addContextAwarenessListener(activity);
        }
    }

    public void onDestroy(Activity activity) {
        removeContextAwarenessListener(activity);
    }

    public void onDetachView(Activity activity) {
        removeCollectListener();
        removeContextAwarenessListener(activity);
    }

    public void onPause(Activity activity) {
        SpenInsertDetector spenInsertDetector = this.mSpenInsertDetector;
        if (spenInsertDetector != null) {
            spenInsertDetector.unregisterSpenInsertReceiver(activity);
        }
    }

    public void onPostComposerViewInitialized(Activity activity) {
        addCollectListener(activity);
    }

    public void onResume(Activity activity) {
        SpenInsertDetector spenInsertDetector = this.mSpenInsertDetector;
        if (spenInsertDetector != null) {
            spenInsertDetector.registerSpenInsertReceiver(activity);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.common.QuickNotePresenterContract.IExternalListenerManager
    public ContextAwarenessListenerImpl getContextAwarenessListener() {
        return this.mContextAwarenessListener;
    }
}
