package p035H2;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.sdk.composer.view.deltaZoom.SpenNoteDeltaZoom;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView;
import com.samsung.android.support.senl.docscan.detect.view.CameraMenu;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteExpiredNotesTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchModeView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.generate.AiDrawingRequestPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.SolveMathPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordSimpleMenu;
import com.samsung.android.support.senl.p148nt.composer.main.cover.CoverCreator;
import com.samsung.android.support.senl.p148nt.model.collector.ReadyStateCollectExecutor;
import java.io.InputStream;
import p048L.AbstractC0165c;
import p048L.RunnableC0164b;
import p207n1.C13541h;

/* JADX INFO: renamed from: H2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC0116a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f367a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f368b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f369c;

    public /* synthetic */ RunnableC0116a(int i, Object obj, boolean z) {
        this.f367a = i;
        this.f369c = obj;
        this.f368b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f367a) {
            case 0:
                CameraMenu.setFlashModeActivated$lambda$0((CameraMenu) this.f369c, this.f368b);
                break;
            case 1:
                AbstractC0165c abstractC0165c = (AbstractC0165c) ((RunnableC0164b) this.f369c).f505c;
                abstractC0165c.f506f = C13541h.m14287e().m14291d();
                try {
                    if (this.f368b) {
                        abstractC0165c.m420b();
                    } else {
                        abstractC0165c.m421c();
                    }
                } catch (InterruptedException unused) {
                    abstractC0165c.mo424f();
                    return;
                } catch (Exception e) {
                    abstractC0165c.mo425g(3, e.toString());
                    return;
                }
                break;
            case 2:
                DeleteExpiredNotesTask.execute$lambda$0((DeleteExpiredNotesTask) this.f369c, this.f368b);
                break;
            case 3:
                ((NestedScrollView) this.f369c).lambda$seslSetFadingEdgeEnabled$1(this.f368b);
                break;
            case 4:
                ((RecyclerView) this.f369c).lambda$seslSetFadingEdgeEnabled$1(this.f368b);
                break;
            case 5:
                LottieCompositionFactory.lambda$fromJsonInputStream$7(this.f368b, (InputStream) this.f369c);
                break;
            case 6:
                PopupNoteService.startPopupNoteActivity$lambda$0((PopupNoteService) this.f369c, this.f368b);
                break;
            case 7:
                SpenFavoritePenMiniAdapter.MiniAddViewHolder.setVisibility$lambda$0((SpenFavoritePenMiniAdapter.MiniAddViewHolder) this.f369c, this.f368b);
                break;
            case 8:
                BaseFragmentView.enableRotation$lambda$1((BaseFragmentView) this.f369c, this.f368b);
                break;
            case 9:
                ((AbsPasswordView) this.f369c).lambda$ignoreInputEvent$3(this.f368b);
                break;
            case 10:
                ((SearchModeView) this.f369c).lambda$setSearchViewAnimation$1(this.f368b);
                break;
            case 11:
                ((SettingsSyncToMicrosoftPrefFragment) this.f369c).updateSyncNow(this.f368b);
                break;
            case 12:
                SettingsSyncWithSamsungAccountPrefFragment.updateSyncLayout$lambda$20((SettingsSyncWithSamsungAccountPrefFragment) this.f369c, this.f368b);
                break;
            case 13:
                ((ComposerViewPresenter) this.f369c).lambda$releaseView$4(this.f368b);
                break;
            case 14:
                ((AiDrawingRequestPresenter) this.f369c).lambda$show$0(this.f368b);
                break;
            case 15:
                ((SolveMathPresenter) this.f369c).lambda$updateRecognitionResultContentVisibility$3(this.f368b);
                break;
            case 16:
                ((VoiceRecordSimpleMenu) this.f369c).show(this.f368b);
                break;
            case 17:
                ((CoverCreator) this.f369c).lambda$setAvailableAutoCover$10(this.f368b);
                break;
            case 18:
                ((ReadyStateCollectExecutor) this.f369c).lambda$execute$0(this.f368b);
                break;
            default:
                SpenNoteDeltaZoom.onMovementLockedChanged$lambda$0((SpenNoteDeltaZoom) this.f369c, this.f368b);
                break;
        }
    }

    public /* synthetic */ RunnableC0116a(boolean z, InputStream inputStream) {
        this.f367a = 5;
        this.f368b = z;
        this.f369c = inputStream;
    }
}
