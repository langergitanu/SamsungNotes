package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import androidx.arch.core.util.Function;
import com.samsung.android.app.notes.sync.network.InterfaceC6846k;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.collector.common.mining.AbsMiningExtractor;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.WorkerInfoContract;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ObjectRecognitionCollector;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskGroup;
import com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerSortBarHolder;
import com.samsung.scsp.common.PreferenceItem;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.pam.kps.lite.KpsGetPolicyJobImpl;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.TranslatingSpanRender;
import com.vladsch.flexmark.formatter.internal.CoreNodeFormatter;
import com.vladsch.flexmark.util.ast.Node;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.dictionary.serializer.Entry;
import opennlp.tools.dictionary.serializer.EntryInserter;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.ngram.NGramModel;
import opennlp.tools.postag.POSDictionary;
import opennlp.tools.postag.POSTaggerFactory;
import opennlp.tools.tokenize.DetokenizationDictionary;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.featuregen.FeatureGeneratorResourceProvider;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.function.ToBooleanBiFunction;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.reflect.Typed;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p007B0.C0023f;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11253j implements Function, DownloadBitmap.ICheckerToImageFile, OnCompleteListener, WorkerInfoContract, ConvertTaskGroup.IGroupStatusCallback, PopupMenu.OnMenuItemClickListener, FaultBarrier.ThrowableSupplier, FaultBarrier.ThrowableRunnable, TranslatingSpanRender, EventListener.Factory, EntryInserter, FeatureGeneratorResourceProvider, Functions.FailableSupplier, ToBooleanBiFunction, Typed, InterfaceC6846k {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7382a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7383b;

    public /* synthetic */ C11253j(Object obj, int i) {
        this.f7382a = i;
        this.f7383b = obj;
    }

    @Override // com.samsung.android.app.notes.sync.network.InterfaceC6846k
    /* JADX INFO: renamed from: a */
    public void mo264a(int i) {
        C0023f c0023f = (C0023f) this.f7383b;
        AbstractC0000a.m17n(i, "onResponse - LOCK_SETTINGS_BACKUP_FILE_NAME = ", "SyncOldNote$SyncServerPassword");
        if (i == 0) {
            C0012a c0012a = (C0012a) c0023f.f127c;
            if (c0012a.f79t) {
                return;
            }
            c0012a.f79t = true;
        }
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public Object mo22196apply(Object obj) {
        switch (this.f7382a) {
            case 0:
                return ((NotesTagDao) this.f7383b).lambda$deleteByUuid$0((List) obj);
            case 1:
                return ((StickyStrokeDao) this.f7383b).lambda$deleteByUuid$0((List) obj);
            case 2:
                return ((StickyTextDao) this.f7383b).lambda$deleteByUuid$0((List) obj);
            case 3:
                return ((SttContentDao) this.f7383b).lambda$deleteByUuids$0((List) obj);
            case 4:
                return ((SuggestedCoverDao) this.f7383b).lambda$deleteByUuids$0((List) obj);
            default:
                return ((SyncFolderInfoDao) this.f7383b).getUuidsInChunk((List) obj);
        }
    }

    @Override // org.apache.commons.lang3.function.ToBooleanBiFunction
    public boolean applyAsBoolean(Object obj, Object obj2) {
        return ((Strings) this.f7383b).contains((CharSequence) obj, (CharSequence) obj2);
    }

    @Override // com.samsung.android.support.senl.nt.model.base.utils.image.DownloadBitmap.ICheckerToImageFile
    public void checkImageWithFile(File file) {
        ((Content.Image) this.f7383b).lambda$download$1(file);
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        return EventListener.lambda$factory$0((EventListener) this.f7383b, call);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f7382a) {
            case 11:
                return ((PreferenceItem) this.f7383b).lambda$get$6();
            case 12:
            default:
                return ((Functions.FailableCallable) this.f7383b).call();
            case 13:
                return KpsGetPolicyJobImpl.lambda$getMaxAge$3((List) this.f7383b);
        }
    }

    @Override // opennlp.tools.util.featuregen.FeatureGeneratorResourceProvider
    public Object getResource(String str) {
        switch (this.f7382a) {
            case 18:
                return ((TokenNameFinderFactory) this.f7383b).lambda$createFeatureGenerators$0(str);
            default:
                return ((POSTaggerFactory) this.f7383b).lambda$createFeatureGenerators$0(str);
        }
    }

    @Override // org.apache.commons.lang3.reflect.Typed
    public Type getType() {
        return TypeUtils.lambda$wrap$4((Type) this.f7383b);
    }

    @Override // opennlp.tools.dictionary.serializer.EntryInserter
    public void insert(Entry entry) throws InvalidFormatException {
        switch (this.f7382a) {
            case 17:
                ((Dictionary) this.f7383b).lambda$new$0(entry);
                break;
            case 18:
            default:
                ((DetokenizationDictionary) this.f7383b).lambda$init$0(entry);
                break;
            case 19:
                ((NGramModel) this.f7383b).lambda$new$0(entry);
                break;
            case 20:
                POSDictionary.lambda$create$0((POSDictionary) this.f7383b, entry);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.WorkerInfoContract
    public boolean isCanceled() {
        return ((ObjectRecognitionCollector) this.f7383b).isCanceled();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((AbsMiningExtractor) this.f7383b).lambda$getOnCompleteListener$0(task);
    }

    @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskGroup.IGroupStatusCallback
    public void onEnd(int i) {
        ((ConvertTaskManager) this.f7383b).lambda$new$0(i);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return AudioPickerSortBarHolder.showSortTypeDialog$lambda$0((AudioPickerSortBarHolder) this.f7383b, menuItem);
    }

    @Override // com.vladsch.flexmark.formatter.TranslatingSpanRender
    public void render(NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        switch (this.f7382a) {
            case 14:
                nodeFormatterContext.renderChildren((Node) this.f7383b);
                break;
            default:
                CoreNodeFormatter.lambda$render$3((HtmlEntity) this.f7383b, nodeFormatterContext, markdownWriter);
                break;
        }
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        ((File) this.f7383b).delete();
    }
}
