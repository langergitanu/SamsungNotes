package com.samsung.android.support.senl.p148nt.model.collector.common;

import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.scsp.error.ErrorSupplier;
import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.odm.dos.common.OdmDosTargetHeader;
import com.vladsch.flexmark.ast.LinkRefDerived;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.internal.InlineParserImpl;
import com.vladsch.flexmark.parser.internal.PostProcessorManager;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeClassifierVisitor;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.dependency.Dependent;
import com.vladsch.flexmark.util.dependency.DependentItemMap;
import com.vladsch.flexmark.util.format.TrackedOffset;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
import io.opentelemetry.api.common.AttributeKey;
import java.io.File;
import java.util.BitSet;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.function.Function;
import opennlp.tools.formats.conllu.ConlluStream;
import opennlp.tools.formats.conllu.ConlluWordLine;
import opennlp.tools.formats.irishsentencebank.IrishSentenceBankDocument;
import opennlp.tools.formats.leipzig.LeipzigLanguageSampleStream;
import org.apache.commons.lang3.concurrent.UncheckedFuture;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.collector.common.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C11419a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7695a;

    public /* synthetic */ C11419a(int i) {
        this.f7695a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7695a) {
            case 0:
                return ((NotesStrokeSearchEntity) obj).getFilePath();
            case 1:
                return CollectResolver.lambda$setActionLinkData$0((String) obj);
            case 2:
                return FolderManager.lambda$addReservedFolderName$0((String) obj);
            case 3:
                return ErrorSupplier.lambda$static$0((Throwable) obj);
            case 4:
                return OdmDosTargetHeader.lambda$static$0((ApiContext) obj);
            case 5:
                return Parsing.lambda$getCachedPattern$0((String) obj);
            case 6:
                return ((DataKeyBase) obj).getName();
            case 7:
                return InlineParserImpl.lambda$calculateInlineParserExtensions$2((Character) obj);
            case 8:
                return InlineParserImpl.lambda$parseCloseBracket$0((LinkRefDerived) obj);
            case 9:
                return InlineParserImpl.lambda$parseCloseBracket$1((LinkRefDerived) obj);
            case 10:
                return PostProcessorManager.prioritizePostProcessors((DependentItemMap) obj);
            case 11:
                return NodeClassifierVisitor.lambda$new$0((BitSet) obj);
            case 12:
                return ((Node) obj).getClass();
            case 13:
                return ((Dependent) obj).getClass();
            case 14:
                return Integer.valueOf(((TrackedOffset) obj).getOffset());
            case 15:
                return SequenceUtils.toVisibleWhitespaceString((CharSequence) obj);
            case 16:
                return SegmentedSequenceStats.lambda$addStats$0((SegmentedSequenceStats.StatsEntry) obj);
            case 17:
                return ((MainListDocumentData) obj).getUuid();
            case 18:
                return ((AttributeKey) obj).getKey();
            case 19:
                return ((String) obj).trim();
            case 20:
                return ((ConlluWordLine) obj).getLemma();
            case 21:
                return ConlluStream.lambda$mergeAnnotation$2((ConlluWordLine) obj);
            case 22:
                return ConlluStream.lambda$mergeAnnotation$4((ConlluWordLine) obj);
            case 23:
                return ((ConlluWordLine) obj).getFeats();
            case 24:
                return IrishSentenceBankDocument.lambda$parse$0((Integer) obj);
            case 25:
                return LeipzigLanguageSampleStream.lambda$new$1((File) obj);
            case 26:
                return ((String) obj).toString();
            case 27:
                return obj.toString();
            case 28:
                return Objects.toString(obj);
            default:
                return UncheckedFuture.m14734on((Future) obj);
        }
    }
}
