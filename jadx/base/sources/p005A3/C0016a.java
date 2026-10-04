package p005A3;

import androidx.appsearch.app.AppSearchSchema;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.text.android.LayoutIntrinsics_androidKt;
import com.samsung.android.app.notes.sync.importing.core.types.MemoLocalSync;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.ConflictPage;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.object.CompareSPenObjectTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeFormatter;
import com.vladsch.flexmark.parser.internal.PostProcessorManager;
import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
import java.io.File;
import java.util.Comparator;
import java.util.Map;
import kotlin.Pair;
import okhttp3.CipherSuite;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;

/* JADX INFO: renamed from: A3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0016a implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f90a;

    public /* synthetic */ C0016a(int i) {
        this.f90a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f90a) {
            case 0:
                return CompareSPenObjectTextBox.compareTextSpan$lambda$2((SpenTextSpanBase) obj, (SpenTextSpanBase) obj2);
            case 1:
                return CompareSPenObjectTextBox.getSpans$lambda$0((CompareSPenObjectTextBox.SpanTextNode) obj, (CompareSPenObjectTextBox.SpanTextNode) obj2);
            case 2:
                return CompareSPenObjectTextBox.splitText$lambda$3((Integer) obj, (Integer) obj2);
            case 3:
                return CompareSPenObjectTextBox.getParagraph$lambda$1((CompareSPenObjectTextBox.Paragraph) obj, (CompareSPenObjectTextBox.Paragraph) obj2);
            case 4:
                return AppSearchSchema.lambda$appendAppSearchSchemaString$0((AppSearchSchema.PropertyConfig) obj, (AppSearchSchema.PropertyConfig) obj2);
            case 5:
                return LayoutNode.ZComparator$lambda$41((LayoutNode) obj, (LayoutNode) obj2);
            case 6:
                return LayoutIntrinsics_androidKt.minIntrinsicWidth$lambda$0((Pair) obj, (Pair) obj2);
            case 7:
                return ((Double) obj).compareTo((Double) obj2);
            case 8:
                return MemoLocalSync.lambda$getImportItems$0((ImportItem) obj, (ImportItem) obj2);
            case 9:
                return ComposerCacheFileUtil.lambda$trimPdfWriterDir$1((File) obj, (File) obj2);
            case 10:
                return PwFileManager.lambda$sortDescByTime$2((PwFileManager.CacheInfo) obj, (PwFileManager.CacheInfo) obj2);
            case 11:
                return SpenWNoteObjectHelper.lambda$getSortedObjectList$0((SpenObjectBase) obj, (SpenObjectBase) obj2);
            case 12:
                return SpenWNoteObjectHelper.lambda$getSortedBodyObjects$1((SpenObjectBase) obj, (SpenObjectBase) obj2);
            case 13:
                return OfficeView.exportContinuousPage$lambda$5$lambda$4((SpenObjectBase) obj, (SpenObjectBase) obj2);
            case 14:
                return OfficeView.sortObjectSpan$lambda$2((SpenObjectSpan) obj, (SpenObjectSpan) obj2);
            case 15:
                return TaskListNodeFormatter.lambda$renderList$0((ListItem) obj, (ListItem) obj2);
            case 16:
                return PostProcessorManager.lambda$prioritizePostProcessors$0((Map.Entry) obj, (Map.Entry) obj2);
            case 17:
                return ((SegmentedSequenceStats.StatsEntry) obj).compareTo((SegmentedSequenceStats.StatsEntry) obj2);
            case 18:
                return AiDrawingUtil.getPageOfObject$lambda$0((android.util.Pair) obj, (android.util.Pair) obj2);
            case 19:
                return CipherSuite.lambda$static$0((String) obj, (String) obj2);
            case 20:
                return ((String) obj).compareTo((String) obj2);
            case 21:
                return LanguageDetectorME.lambda$predict$0((Language) obj, (Language) obj2);
            default:
                return ConflictPage._init_$lambda$0((ConflictPage.RectContainer) obj, (ConflictPage.RectContainer) obj2);
        }
    }
}
