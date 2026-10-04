package p079T;

import android.app.Activity;
import android.view.View;
import androidx.arch.core.util.Function;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.foundation.text.TextRangeLayoutMeasureResult;
import androidx.compose.foundation.text.TextRangeLayoutMeasureScope;
import androidx.compose.foundation.text.TextRangeScopeMeasurePolicy;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.picker.app.SeslDatePickerDialog;
import androidx.picker.widget.SeslDatePicker;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import androidx.work.PeriodicWorkRequest;
import androidx.work.multiprocess.IWorkManagerImpl;
import androidx.work.multiprocess.IWorkManagerImplCallback;
import androidx.work.multiprocess.RemoteDispatcher;
import androidx.work.multiprocess.RemoteWorkManagerClient;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.app.notes.popupnote.PopupNoteService$startPopupNoteActivity$callback$1;
import com.samsung.android.sdk.handwriting.resources.HwrLanguageManager;
import com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface;
import com.samsung.android.sdk.pen.recogengine.SpenHwrResourceManager;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.VerifyWithMultiAccountStrategy;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyMultiAccountDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SwitchPreference;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsAutoTranscribePrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistOnDeviceFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateTextController;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.STTGuideTip;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesConvertedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyTextDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.recognition.NotesStrokeRepository;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.api.AbstractApiControl;
import com.samsung.scsp.framework.core.decorator.AbstractDecorator;
import com.vladsch.flexmark.ext.tables.TableCell;
import com.vladsch.flexmark.ext.tables.internal.TableNodeFormatter;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.MergeContextConsumer;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.NodeRepositoryFormatter;
import com.vladsch.flexmark.formatter.TranslatingSpanRender;
import com.vladsch.flexmark.formatter.TranslationContext;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.NodeRepository;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: T.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0287e implements DeleteCoeditNoteUseCase.ResultCallback, TextRangeScopeMeasurePolicy, RemoteDispatcher, Function, SynchronizationGuard.CriticalSection, androidx.core.util.Function, LanguageManagerInterface.OnUpdateListener, HwrLanguageManager.OnUpdateListener, VerifyMultiAccountDialogFragment.ResultListener, OnCompleteListener, Preference.OnPreferenceChangeListener, OnApplyWindowInsetsListener, NoteManager.InvertBackgroundColorListener, SeslDatePickerDialog.OnDateSetListener, SmartTipPopup.OnDismissListener, DocumentFileManager.IOAction, FaultBarrier.ThrowableRunnable, TranslatingSpanRender, MergeContextConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f746a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f747b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f748c;

    public /* synthetic */ C0287e(Object obj, Object obj2, int i) {
        this.f746a = i;
        this.f747b = obj;
        this.f748c = obj2;
    }

    @Override // com.vladsch.flexmark.formatter.MergeContextConsumer
    public void accept(TranslationContext translationContext, Document document, int i) {
        ((NodeRepositoryFormatter) this.f747b).lambda$uniquifyIds$3((NodeRepository) this.f748c, translationContext, document, i);
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public Object mo22196apply(Object obj) {
        switch (this.f746a) {
            case 3:
                return ((NotesStrokeRepository) this.f747b).lambda$deleteByUuidAndPageIds$0((String) this.f748c, (List) obj);
            case 6:
                return Boolean.valueOf(PopupNoteService.startPopupNoteActivity$lambda$1((PopupNoteService) this.f747b, (PopupNoteService$startPopupNoteActivity$callback$1) this.f748c, (ComposerManager.ComposerInfo) obj));
            case 19:
                return ((MainListDocumentDataDao) this.f747b).lambda$getEntities$0((String) this.f748c, (List) obj);
            case 20:
                return ((NotesConvertedDocumentDao) this.f747b).lambda$hasConvertedOldNote$0((AtomicBoolean) this.f748c, (List) obj);
            case 21:
                return ((NotesOldDocumentDao) this.f747b).lambda$includeOldNotes$0((AtomicBoolean) this.f748c, (List) obj);
            case 22:
                return ((StickyNoteDao) this.f747b).lambda$deleteByUuidAndPageIds$1((String) this.f748c, (List) obj);
            case 23:
                return ((StickyStrokeDao) this.f747b).lambda$deleteByUuidAndPageIds$1((String) this.f748c, (List) obj);
            default:
                return ((StickyTextDao) this.f747b).lambda$deleteByUuidAndPageIds$1((String) this.f748c, (List) obj);
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.f746a) {
            case 4:
                return ((Uploader) this.f747b).lambda$logAndUpdateState$5((Iterable) this.f748c);
            default:
                return ((Uploader) this.f747b).lambda$logAndUpdateState$7((HashMap) this.f748c);
        }
    }

    @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
    public TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        return TextLinkScope.textRange$lambda$3((TextLinkScope) this.f747b, (AnnotatedString.Range) this.f748c, textRangeLayoutMeasureScope);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        switch (this.f746a) {
            case 14:
                return WindowInsetsManager.registerApplyListener$lambda$4$lambda$3((WindowInsetsManager) this.f747b, (View) this.f748c, view, windowInsetsCompat);
            default:
                return NoteStyleActivity.applyWindowInsetsToContainer$lambda$9$lambda$8((NoteStyleActivity) this.f747b, (View) this.f748c, view, windowInsetsCompat);
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.interfaces.LanguageManagerInterface.OnUpdateListener, com.samsung.android.sdk.handwriting.resources.HwrLanguageManager.OnUpdateListener
    public void onComplete(int i) {
        switch (this.f746a) {
            case 7:
                ((HwrLanguageManager) this.f747b).lambda$update$0((HwrLanguageManager.OnUpdateListener) this.f748c, i);
                break;
            default:
                SpenHwrResourceManager.updateHwrResource$lambda$0((SpenHwrResourceManager) this.f747b, (String) this.f748c, i);
                break;
        }
    }

    @Override // androidx.picker.app.SeslDatePickerDialog.OnDateSetListener
    public void onDateSet(SeslDatePicker seslDatePicker, int i, int i2, int i4) {
        DynamicTemplateTextController.showDatePicker$lambda$0((Ref.ObjectRef) this.f747b, (DynamicTemplateTextController) this.f748c, seslDatePicker, i, i2, i4);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
    public void onDismissed() {
        STTGuideTip.showGuideTip$lambda$0((STTGuideTip) this.f747b, (View) this.f748c);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.InvertBackgroundColorListener
    public void onInvertBackgroundColorChanged(boolean z) {
        StickyMemoManager.init$lambda$3((StickyMemoManager) this.f747b, (ComposerViewPresenter) this.f748c, z);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        switch (this.f746a) {
            case 11:
                return SettingsAutoTranscribePrefFragment.initAutoTranscribeSwitch$lambda$4((SwitchPreference) this.f747b, (SettingsAutoTranscribePrefFragment) this.f748c, preference, obj);
            case 12:
                return SettingsNotesAssistOnDeviceFragment.initNotesAssistSwitch$lambda$5((SwitchPreferenceCompat) this.f747b, (SettingsNotesAssistOnDeviceFragment) this.f748c, preference, obj);
            default:
                return SettingsNotesAssistPrefFragment.initNotesAssistSwitch$lambda$10((SwitchPreference) this.f747b, (SettingsNotesAssistPrefFragment) this.f748c, preference, obj);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiAccountDialogFragment.ResultListener
    public void onResult(boolean z) {
        VerifyWithMultiAccountStrategy.verifyOtherAccount$lambda$0((Activity) this.f747b, (VerifyWithMultiAccountStrategy) this.f748c, z);
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public Object operate() {
        return DocumentFileManager.lambda$copy$15((String) this.f747b, (String) this.f748c);
    }

    @Override // com.vladsch.flexmark.formatter.TranslatingSpanRender
    public void render(NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        TableNodeFormatter.lambda$render$0((TableCell) this.f747b, (String[]) this.f748c, nodeFormatterContext, markdownWriter);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() throws NoSuchMethodException {
        switch (this.f746a) {
            case 26:
                ((AbstractApiControl) this.f747b).lambda$new$1((Class) this.f748c);
                break;
            default:
                ((AbstractDecorator) this.f747b).lambda$new$2((Class) this.f748c);
                break;
        }
    }

    @Override // androidx.work.multiprocess.RemoteDispatcher
    public void execute(Object obj, IWorkManagerImplCallback iWorkManagerImplCallback) {
        RemoteWorkManagerClient.lambda$enqueueUniquePeriodicWork$0((PeriodicWorkRequest) this.f747b, (String) this.f748c, (IWorkManagerImpl) obj, iWorkManagerImplCallback);
    }

    @Override // com.google.android.play.core.tasks.OnCompleteListener
    public void onComplete(Task task) {
        NotesPresenter.lambda$requestInAppReview$8((WeakReference) this.f747b, (ReviewManager) this.f748c, task);
    }

    @Override // com.samsung.android.support.senl.nt.model.domain.coedit.DeleteCoeditNoteUseCase.ResultCallback
    public void onResult(int i) {
        ShareSyncEntry shareSyncEntry = (ShareSyncEntry) this.f747b;
        ArrayList arrayList = (ArrayList) this.f748c;
        Debugger.m8607d("Coedit$SesCoeditUtil", "deleteItems, onResult, uuid: " + shareSyncEntry.getUuid() + ", result: " + i);
        if (i == 300) {
            arrayList.add(shareSyncEntry.getUuid());
        }
    }
}
