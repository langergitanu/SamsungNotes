package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import android.content.Context;
import android.widget.ImageView;
import androidx.core.util.Supplier;
import androidx.preference.Preference;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NumberedBadgeShadowBuilder;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.WaitForDownloadHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectFindUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.EmptyHandoffManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPhotoEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiDrawingManager;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionPlugInContract;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ObjectRecognitionCollector;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDewarper;
import com.samsung.android.vexfwk.sdk.docscan.VexFwkDocRefiner;
import com.samsung.android.vexfwk.sdk.imageeffect.VexFwkImageEffectProcessor;
import com.samsung.android.vexfwk.sdk.imagetagger.VexFwkImageTagger;
import com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator;
import com.samsung.android.vexfwk.sdk.winedetector.VexFwkWineDetector;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.Scsp;
import com.vladsch.flexmark.formatter.TranslationPlaceholderGenerator;
import com.vladsch.flexmark.formatter.internal.CoreNodeFormatter;
import com.vladsch.flexmark.util.misc.TemplateUtil;
import com.vladsch.flexmark.util.options.MessageProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Authenticator;
import okhttp3.Dns;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.apache.commons.lang3.function.FailableDoubleFunction;
import org.apache.commons.lang3.function.FailableDoubleToIntFunction;
import org.apache.commons.lang3.function.FailableDoubleToLongFunction;
import org.apache.commons.lang3.function.FailableIntFunction;
import org.apache.commons.lang3.function.FailableIntToDoubleFunction;
import org.apache.commons.lang3.function.FailableIntToFloatFunction;
import org.apache.commons.lang3.function.FailableIntToLongFunction;
import org.apache.commons.lang3.function.FailableLongFunction;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8416h implements OnCompleteListener, NumberedBadgeShadowBuilder.ShadowBuilderContract, Preference.OnPreferenceChangeListener, ActionMenuController.Contract, DeleteCoeditNoteUseCase.ResultCallback, HandoffManager.IComposerPresenter, DownloadBitmap.ICheckerToImageFile, ObjectFindUtil.Finder, TextRecognitionPlugInContract, Supplier, FaultBarrier.ThrowableSupplier, FaultBarrier.ThrowableRunnable, TranslationPlaceholderGenerator, TemplateUtil.Resolver, MessageProvider, Authenticator, Dns, FailableDoubleFunction, FailableDoubleToIntFunction, FailableDoubleToLongFunction, FailableIntFunction, FailableIntToDoubleFunction, FailableIntToFloatFunction, FailableIntToLongFunction, FailableLongFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6195a;

    public /* synthetic */ C8416h(int i) {
        this.f6195a = i;
    }

    @Override // org.apache.commons.lang3.function.FailableDoubleFunction
    public Object apply(double d) {
        return FailableDoubleFunction.lambda$static$0(d);
    }

    @Override // org.apache.commons.lang3.function.FailableIntToDoubleFunction
    public double applyAsDouble(int i) {
        return FailableIntToDoubleFunction.lambda$static$0(i);
    }

    @Override // org.apache.commons.lang3.function.FailableIntToFloatFunction
    public float applyAsFloat(int i) {
        return FailableIntToFloatFunction.lambda$static$0(i);
    }

    @Override // org.apache.commons.lang3.function.FailableDoubleToIntFunction
    public int applyAsInt(double d) {
        return FailableDoubleToIntFunction.lambda$static$0(d);
    }

    @Override // org.apache.commons.lang3.function.FailableDoubleToLongFunction
    public int applyAsLong(double d) {
        return FailableDoubleToLongFunction.lambda$static$0(d);
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        return Authenticator.lambda$static$0(route, response);
    }

    @Override // com.samsung.android.support.senl.nt.model.base.utils.image.DownloadBitmap.ICheckerToImageFile
    public void checkImageWithFile(File file) {
        AiDrawingManager.lambda$onActivityResult$9(file);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectFindUtil.Finder
    public boolean find(String str, SpenObjectBase spenObjectBase) {
        return ContextMenuPhotoEditor.lambda$getFindSourceImageObject$0(str, spenObjectBase);
    }

    @Override // androidx.core.util.Supplier
    public Object get() {
        switch (this.f6195a) {
            case 9:
                return VexFwkDocDewarper.dewarpDocumentImpl$lambda$9$lambda$4$lambda$3$lambda$2();
            case 10:
                return VexFwkDocRefiner.Companion.capabilities$lambda$1$lambda$0();
            case 11:
                return VexFwkImageEffectProcessor.Companion.getSupportedFilters$lambda$1$lambda$0();
            case 12:
                return VexFwkImageTagger.detectImageTagsImpl$lambda$7$lambda$4$lambda$3$lambda$2$lambda$1();
            case 13:
                return VexFwkImageTranslator.isAvailableSize$lambda$41$lambda$39();
            case 14:
                return VexFwkWineDetector.detectWineImpl$lambda$6$lambda$3$lambda$2$lambda$1();
            default:
                return SContext.lambda$new$0();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.Contract
    public int getModeIndex() {
        return ImportView.initLayout$lambda$2();
    }

    @Override // com.vladsch.flexmark.formatter.TranslationPlaceholderGenerator
    public String getPlaceholder(int i) {
        return CoreNodeFormatter.lambda$static$2(i);
    }

    @Override // okhttp3.Dns
    public List lookup(String str) {
        return Dns.lambda$static$0(str);
    }

    @Override // com.vladsch.flexmark.util.options.MessageProvider
    public String message(String str, String str2, Object[] objArr) {
        return MessageProvider.lambda$static$0(str, str2, objArr);
    }

    @Override // com.google.android.play.core.tasks.OnCompleteListener
    public void onComplete(Task task) {
        NotesPresenter.lambda$requestInAppReview$7(task);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        return SettingsSyncToMicrosoftPrefFragment.initLayout$lambda$3(preference, obj);
    }

    @Override // com.samsung.android.support.senl.nt.model.domain.coedit.DeleteCoeditNoteUseCase.ResultCallback
    public void onResult(int i) {
        WaitForDownloadHandler.lambda$finishRequestDownloadInternal$0(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionPlugInContract
    public ArrayList parseHyperText(Context context, String str) {
        return ObjectRecognitionCollector.lambda$collect$0(context, str);
    }

    @Override // com.vladsch.flexmark.util.misc.TemplateUtil.Resolver
    public String resolve(String[] strArr) {
        return TemplateUtil.lambda$static$0(strArr);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        Scsp.lambda$signOut$0();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.NumberedBadgeShadowBuilder.ShadowBuilderContract
    public void setImageView(ImageView imageView) {
        imageView.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.IComposerPresenter
    public void updatedLastPenInfo() {
        EmptyHandoffManager.lambda$new$0();
    }

    @Override // org.apache.commons.lang3.function.FailableIntFunction
    public Object apply(int i) {
        return FailableIntFunction.lambda$static$0(i);
    }

    @Override // org.apache.commons.lang3.function.FailableIntToLongFunction
    public long applyAsLong(int i) {
        return FailableIntToLongFunction.lambda$static$0(i);
    }

    @Override // org.apache.commons.lang3.function.FailableLongFunction
    public Object apply(long j) {
        return FailableLongFunction.lambda$static$0(j);
    }
}
