package p066P2;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.Processor;
import androidx.work.impl.model.WorkGenerationalId;
import com.samsung.android.sdk.pen.view.gesture.detector.SpenHoldMotionDetector;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.TipCardAdapter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiDrawingManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrectionStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.Initializer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverTemplatePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.TaskDownloadPdfTemplate;

/* JADX INFO: renamed from: P2.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC0202d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f626a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f627b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f628c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f629d;

    public /* synthetic */ RunnableC0202d(Object obj, Object obj2, boolean z, int i) {
        this.f626a = i;
        this.f628c = obj;
        this.f629d = obj2;
        this.f627b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f626a) {
            case 0:
                ((TipCardAdapter) this.f628c).lambda$clearTipCard$3(this.f627b, (Runnable) this.f629d);
                break;
            case 1:
                ((Processor) this.f628c).lambda$runOnExecuted$2((WorkGenerationalId) this.f629d, this.f627b);
                break;
            case 2:
                ((NotesSearchView) this.f628c).lambda$postQuery$5((CharSequence) this.f629d, this.f627b);
                break;
            case 3:
                HolderAnimation.decorateLockThumbnailAnimation$lambda$7(this.f627b, (View) this.f628c, (ImageView) this.f629d);
                break;
            case 4:
                SettingsNotesAssistPrefFragment.initNotesAssistSwitch$lambda$9$lambda$7(this.f627b, (CompoundButton) this.f628c, (SettingsNotesAssistPrefFragment) this.f629d);
                break;
            case 5:
                SettingsSyncWithSamsungAccountPrefFragment.C87751.onEnd$lambda$1((SettingsSyncWithSamsungAccountPrefFragment) this.f628c, (SettingsSyncWithSamsungAccountPrefFragment.C87751) this.f629d, this.f627b);
                break;
            case 6:
                ((Initializer) this.f628c).restoreMenu((Bundle) this.f629d, this.f627b);
                break;
            case 7:
                ((AiDrawingManager) this.f628c).lambda$showPopup$3((String) this.f629d, this.f627b);
                break;
            case 8:
                ((SpellingCorrectionStreaming) this.f628c).lambda$initStreamingChar$1((String) this.f629d, this.f627b);
                break;
            case 9:
                StickyMemoManager.openStickyMemo$lambda$11((StickyMemoView) this.f628c, this.f627b, (StickyMemoManager) this.f629d);
                break;
            case 10:
                CoverTemplatePresenter.updateSpanCount$lambda$2((CoverTemplatePresenter) this.f628c, (RecyclerView) this.f629d, this.f627b);
                break;
            case 11:
                ((TaskDownloadPdfTemplate) this.f628c).lambda$runNotifyCallback$0(this.f627b, (TaskDownloadPdfTemplate.ResultValues) this.f629d);
                break;
            default:
                SpenHoldMotionDetector.schedule$lambda$0(this.f627b, (SpenHoldMotionDetector) this.f628c, (MotionEvent) this.f629d);
                break;
        }
    }

    public /* synthetic */ RunnableC0202d(Object obj, boolean z, Object obj2, int i) {
        this.f626a = i;
        this.f628c = obj;
        this.f627b = z;
        this.f629d = obj2;
    }

    public /* synthetic */ RunnableC0202d(boolean z, Object obj, Object obj2, int i) {
        this.f626a = i;
        this.f627b = z;
        this.f628c = obj;
        this.f629d = obj2;
    }
}
