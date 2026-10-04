package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeRepository;
import com.vladsch.flexmark.util.ast.ReferenceNode;
import com.vladsch.flexmark.util.ast.ReferencingNode;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.DataSet;
import com.vladsch.flexmark.util.format.options.ElementPlacement;
import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p070Q1.RunnableC0218a;
import p079T.C0287e;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class NodeRepositoryFormatter<R extends NodeRepository<B>, B extends Node & ReferenceNode<R, B, N>, N extends Node & ReferencingNode<R, B>> implements PhasedNodeFormatter {
    public static final HashSet<FormattingPhase> FORMATTING_PHASES = new HashSet<>(Arrays.asList(FormattingPhase.COLLECT, FormattingPhase.DOCUMENT_TOP, FormattingPhase.DOCUMENT_BOTTOM));
    protected final B lastReference;
    protected final Comparator<B> myComparator;
    private final DataKey<Map<String, String>> myReferenceMapKey;
    private final DataKey<Map<String, String>> myReferenceUniqificationMapKey;
    protected boolean recheckUndefinedReferences;
    protected final List<B> referenceList;
    protected final R referenceRepository;
    private Map<String, String> referenceTranslationMap;
    protected Map<String, String> referenceUniqificationMap;
    protected boolean repositoryNodesDone;
    protected final HashSet<Node> unusedReferences;

    /* JADX INFO: renamed from: com.vladsch.flexmark.formatter.NodeRepositoryFormatter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118061 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$formatter$FormattingPhase;
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$ElementPlacement */
        static final /* synthetic */ int[] f8320xf8d69a30;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$ElementPlacementSort */
        static final /* synthetic */ int[] f8321x1ac56bee;

        static {
            int[] iArr = new int[ElementPlacement.values().length];
            f8320xf8d69a30 = iArr;
            try {
                iArr[ElementPlacement.AS_IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8320xf8d69a30[ElementPlacement.GROUP_WITH_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8320xf8d69a30[ElementPlacement.GROUP_WITH_LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ElementPlacementSort.values().length];
            f8321x1ac56bee = iArr2;
            try {
                iArr2[ElementPlacementSort.AS_IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8321x1ac56bee[ElementPlacementSort.SORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8321x1ac56bee[ElementPlacementSort.SORT_UNUSED_LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8321x1ac56bee[ElementPlacementSort.SORT_DELETE_UNUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8321x1ac56bee[ElementPlacementSort.DELETE_UNUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[FormattingPhase.values().length];
            $SwitchMap$com$vladsch$flexmark$formatter$FormattingPhase = iArr3;
            try {
                iArr3[FormattingPhase.COLLECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$FormattingPhase[FormattingPhase.DOCUMENT_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$FormattingPhase[FormattingPhase.DOCUMENT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[RenderPurpose.values().length];
            $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose = iArr4;
            try {
                iArr4[RenderPurpose.TRANSLATION_SPANS.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED_SPANS.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public NodeRepositoryFormatter(DataHolder dataHolder, DataKey<Map<String, String>> dataKey, DataKey<Map<String, String>> dataKey2) {
        this.myReferenceMapKey = dataKey;
        this.myReferenceUniqificationMapKey = dataKey2;
        R r = (R) getRepository(dataHolder);
        this.referenceRepository = r;
        List<B> listValues = r.values();
        this.referenceList = listValues;
        this.lastReference = listValues.isEmpty() ? null : (B) ((Node) AbstractC0000a.m10g(listValues, 1));
        this.unusedReferences = new HashSet<>();
        this.recheckUndefinedReferences = HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(dataHolder).booleanValue();
        this.repositoryNodesDone = false;
        this.myComparator = new C11813g();
    }

    private void formatReferences(NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        ArrayList<Node> arrayList = new ArrayList(this.referenceList);
        ElementPlacementSort referenceSort = getReferenceSort();
        int i = C118061.f8321x1ac56bee[referenceSort.ordinal()];
        if (i != 1) {
            if (i == 2) {
                arrayList.sort(getReferenceComparator());
            } else {
                if (i != 3 && i != 4 && i != 5) {
                    throw new IllegalStateException("Unexpected value: " + referenceSort);
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Node node : arrayList) {
                    if (!this.unusedReferences.contains(node)) {
                        arrayList2.add(node);
                    } else if (!referenceSort.isDeleteUnused()) {
                        arrayList3.add(node);
                    }
                }
                if (referenceSort.isSort()) {
                    arrayList2.sort(getReferenceComparator());
                    if (!referenceSort.isDeleteUnused()) {
                        arrayList3.sort(getReferenceComparator());
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                if (!referenceSort.isDeleteUnused()) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
        markdownWriter.blankLine();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            renderReferenceBlockUnique((Node) it.next(), nodeFormatterContext, markdownWriter);
        }
        markdownWriter.blankLine();
        this.repositoryNodesDone = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$2(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence lambda$renderReferenceBlockUnique$0(String str) {
        Map<String, String> map = this.referenceUniqificationMap;
        return map != null ? map.getOrDefault(str, str) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uniquifyIds$3(NodeRepository nodeRepository, TranslationContext translationContext, Document document, int i) {
        NodeRepository.transferReferences(nodeRepository, getRepository(document), true, this.myReferenceUniqificationMapKey.get(translationContext.getTranslationStore()));
    }

    private void renderReferenceBlockUnique(B b, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED) {
            nodeFormatterContext.postProcessNonTranslating(new C0332a(this, 8), new RunnableC0218a(22, this, b, nodeFormatterContext, markdownWriter));
        } else {
            lambda$renderReferenceBlockUnique$1(b, nodeFormatterContext, markdownWriter);
        }
    }

    @Override // com.vladsch.flexmark.formatter.PhasedNodeFormatter
    @Nullable
    public Set<FormattingPhase> getFormattingPhases() {
        return FORMATTING_PHASES;
    }

    public Comparator<B> getReferenceComparator() {
        return this.myComparator;
    }

    public abstract ElementPlacement getReferencePlacement();

    public abstract ElementPlacementSort getReferenceSort();

    public abstract R getRepository(DataHolder dataHolder);

    public ElementPlacement getTranslationReferencePlacement(NodeFormatterContext nodeFormatterContext) {
        return nodeFormatterContext.isTransformingText() ? ElementPlacement.AS_IS : getReferencePlacement();
    }

    public boolean makeReferencesUnique() {
        return true;
    }

    public String modifyTransformedReference(String str, NodeFormatterContext nodeFormatterContext) {
        return str;
    }

    @Override // com.vladsch.flexmark.formatter.PhasedNodeFormatter
    public void renderDocument(@NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter, @NotNull Document document, @NotNull FormattingPhase formattingPhase) {
        Node node;
        if (nodeFormatterContext.isTransformingText() && this.myReferenceMapKey != null) {
            if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
                nodeFormatterContext.getTranslationStore().set((DataKey<HashMap>) this.myReferenceMapKey, new HashMap());
            }
            this.referenceTranslationMap = this.myReferenceMapKey.get(nodeFormatterContext.getTranslationStore());
        }
        int i = C118061.$SwitchMap$com$vladsch$flexmark$formatter$FormattingPhase[formattingPhase.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (getTranslationReferencePlacement(nodeFormatterContext) == ElementPlacement.DOCUMENT_TOP) {
                    formatReferences(nodeFormatterContext, markdownWriter);
                    return;
                }
                return;
            } else {
                if (i == 3 && getTranslationReferencePlacement(nodeFormatterContext) == ElementPlacement.DOCUMENT_BOTTOM) {
                    formatReferences(nodeFormatterContext, markdownWriter);
                    return;
                }
                return;
            }
        }
        this.referenceUniqificationMap = null;
        if (nodeFormatterContext.isTransformingText() && this.myReferenceUniqificationMapKey != null && makeReferencesUnique()) {
            if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS && nodeFormatterContext.getMergeContext() != null) {
                uniquifyIds(nodeFormatterContext, markdownWriter, document);
            }
            this.referenceUniqificationMap = this.myReferenceUniqificationMapKey.get(nodeFormatterContext.getTranslationStore());
        }
        if (getTranslationReferencePlacement(nodeFormatterContext).isChange() && getReferenceSort().isUnused()) {
            this.unusedReferences.addAll(this.referenceList);
            Set<Class<?>> nodeClasses = getNodeClasses();
            if (nodeClasses != null) {
                for (Node node2 : nodeFormatterContext.nodesOfType(nodeClasses)) {
                    B b = this.lastReference;
                    Object referencingNode = b == null ? null : ((ReferenceNode) b).getReferencingNode(node2);
                    if (referencingNode != null && (node = (Node) ((ReferencingNode) referencingNode).getReferenceNode(this.referenceRepository)) != null) {
                        this.unusedReferences.remove(node);
                    }
                }
            }
        }
    }

    public void renderReference(B b, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (this.repositoryNodesDone) {
            return;
        }
        int i = C118061.f8320xf8d69a30[getTranslationReferencePlacement(nodeFormatterContext).ordinal()];
        if (i == 1) {
            renderReferenceBlockUnique(b, nodeFormatterContext, markdownWriter);
            if (b.getNext() == null || b.getNext().getClass() != b.getClass()) {
                markdownWriter.blankLine();
                return;
            }
            return;
        }
        if (i == 2) {
            formatReferences(nodeFormatterContext, markdownWriter);
        } else if (i == 3 && b == this.lastReference) {
            formatReferences(nodeFormatterContext, markdownWriter);
        }
    }

    /* JADX INFO: renamed from: renderReferenceBlock, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$renderReferenceBlockUnique$1(B b, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter);

    public String transformReferenceId(String str, NodeFormatterContext nodeFormatterContext) {
        String string;
        Map<String, String> map;
        if (!nodeFormatterContext.isTransformingText()) {
            return str;
        }
        int i = C118061.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[nodeFormatterContext.getRenderPurpose().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                return str;
            }
            String string2 = nodeFormatterContext.transformNonTranslating(null, modifyTransformedReference(str, nodeFormatterContext), null, null).toString();
            return (nodeFormatterContext.isPostProcessingNonTranslating() || (map = this.referenceUniqificationMap) == null || !map.containsKey(string2)) ? string2 : this.referenceUniqificationMap.get(string2);
        }
        Map<String, String> map2 = this.referenceTranslationMap;
        if (map2 == null) {
            string = nodeFormatterContext.transformNonTranslating(null, str, null, null).toString();
        } else if (map2.containsKey(str)) {
            string = this.referenceTranslationMap.get(str);
        } else {
            String string3 = nodeFormatterContext.transformNonTranslating(null, str, null, null).toString();
            this.referenceTranslationMap.put(str, string3);
            string = string3;
        }
        return modifyTransformedReference(string, nodeFormatterContext);
    }

    public void uniquifyIds(NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter, Document document) {
        NodeRepository repository = getRepository(new DataSet());
        HashMap map = new HashMap();
        nodeFormatterContext.getMergeContext().forEachPrecedingDocument(document, new C0287e(this, repository, 29));
        Iterator it = getRepository(document).entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            int i = 0;
            String str2 = str;
            while (repository.containsKey(str2)) {
                i++;
                str2 = String.format("%s%d", str, Integer.valueOf(i));
            }
            if (i > 0) {
                map.put(str, str2);
            }
        }
        if (map.isEmpty()) {
            return;
        }
        nodeFormatterContext.getTranslationStore().set((DataKey<HashMap>) this.myReferenceUniqificationMapKey, map);
    }
}
