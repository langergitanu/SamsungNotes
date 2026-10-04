package p012C1;

import android.app.Activity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.model.view.BasicViewPagerAppBarView;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager;
import com.samsung.android.mcf.continuity.impl.ContinuityAdapterImpl;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout;
import com.samsung.android.support.senl.p148nt.app.ftu.composer.base.adapter.ComposerFTUPagerAdapter;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.VerifyPasswordPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.guide.AiDrawingGuidePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewRecognizedHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTT;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view.CoverAILayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.tab.TemplateTabView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordMenuContainer;
import com.samsung.android.support.senl.p148nt.composer.main.cover.CoverCreator;
import com.samsung.android.support.senl.p148nt.model.folder.FolderWriteResolver;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.yubico.yubikit.android.p170ui.OtpKeyListener;

/* JADX INFO: renamed from: C1.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0050f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f209a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f210b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f211c;

    public /* synthetic */ RunnableC0050f(int i, Object obj, int i2) {
        this.f209a = i2;
        this.f210b = i;
        this.f211c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f209a) {
            case 0:
                SyncProgressListener syncProgressListener = (SyncProgressListener) this.f211c;
                try {
                    syncProgressListener.onEnded(this.f210b);
                } catch (Exception e) {
                    Debugger.m8609e("SyncNote", "notifyDownSyncResult() : currentListener = " + syncProgressListener + ", e =" + e);
                    return;
                }
                break;
            case 1:
                RestoreTask.showToast$lambda$1((RestoreTask) this.f211c, this.f210b);
                break;
            case 2:
                ((ResourcesCompat.FontCallback) this.f211c).lambda$callbackFailAsync$1(this.f210b);
                break;
            case 3:
                ((ContinuityAdapterImpl) this.f211c).lambda$initialize$0(this.f210b);
                break;
            case 4:
                ((ContinuitySessionMessageManager.SendMessageCallback) this.f211c).onResult(this.f210b);
                break;
            case 5:
                ((ContinuitySession) this.f211c).lambda$handleSessionStatusChanged$8(this.f210b);
                break;
            case 6:
                ((ContinuitySession.C71941) this.f211c).lambda$onSessionStatusChanged$0(this.f210b);
                break;
            case 7:
                ((ContinuitySessionManager.SessionStatusListener) this.f211c).onSessionStatusChanged(this.f210b);
                break;
            case 8:
                BasicViewPagerAppBarView.moveNextAndRemove$lambda$11$lambda$10((BasicViewPagerAppBarView) this.f211c, this.f210b);
                break;
            case 9:
                ((SideSheetBehavior) this.f211c).lambda$setState$0(this.f210b);
                break;
            case 10:
                SpenFavoritePenLayout.moveToPosition$lambda$9((SpenFavoritePenLayout) this.f211c, this.f210b);
                break;
            case 11:
                ComposerFTUPagerAdapter.onPageSelected$lambda$0((ComposerFTUPagerAdapter) this.f211c, this.f210b);
                break;
            case 12:
                VerifyPasswordPresenter.C81091.onTick$lambda$1((VerifyPasswordPresenter) this.f211c, this.f210b);
                break;
            case 13:
                ((DocOpenTriggerActivity) this.f211c).lambda$showToast$2(this.f210b);
                break;
            case 14:
                NotificationUtils.checkedNotificationPermissions$lambda$0(this.f210b, (Fragment) this.f211c);
                break;
            case 15:
                NotificationUtils.checkedNotificationPermissions$lambda$1(this.f210b, (Activity) this.f211c);
                break;
            case 16:
                BaseWidgetSettingView.updateRoundCornerViewHeight$lambda$8((RoundCornerOverlayView) this.f211c, this.f210b);
                break;
            case 17:
                ((AiDrawingGuidePresenter) this.f211c).lambda$show$0(this.f210b);
                break;
            case 18:
                ((AiMenuResultView) this.f211c).lambda$movePage$0(this.f210b);
                break;
            case 19:
                ((AiMenuResultViewRecognizedHw) this.f211c).lambda$setEditModeState$7(this.f210b);
                break;
            case 20:
                ((AiMenuResultViewSTT) this.f211c).lambda$updateTranslateMode$20(this.f210b);
                break;
            case 21:
                CoverAILayout.setDisclaimerVisibility$lambda$4((CoverAILayout) this.f211c, this.f210b);
                break;
            case 22:
                VoiceRecordMenuContainer.onSTTItemStateButtonClick$lambda$3((VoiceRecordMenuContainer) this.f211c, this.f210b);
                break;
            case 23:
                ((CoverCreator) this.f211c).lambda$setProgressView$9(this.f210b);
                break;
            case 24:
                ((FolderWriteResolver) this.f211c).lambda$initializePredefined$0(this.f210b);
                break;
            case 25:
                AiSTTListView.notifyItemChanged$lambda$2((AiSTTListView) this.f211c, this.f210b);
                break;
            case 26:
                ((OtpKeyListener) this.f211c).lambda$onKeyEvent$0(this.f210b);
                break;
            default:
                TemplateTabView.scrollToPosition$lambda$1((TemplateTabView) this.f211c, this.f210b);
                break;
        }
    }

    public /* synthetic */ RunnableC0050f(Object obj, int i, int i2) {
        this.f209a = i2;
        this.f211c = obj;
        this.f210b = i;
    }
}
