package com.vladsch.flexmark.formatter.internal;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.ast.AutoLink;
import com.vladsch.flexmark.ast.BlockQuote;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.BulletListItem;
import com.vladsch.flexmark.ast.Code;
import com.vladsch.flexmark.ast.DelimitedLinkNode;
import com.vladsch.flexmark.ast.Emphasis;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.HardLineBreak;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.HtmlBlock;
import com.vladsch.flexmark.ast.HtmlBlockBase;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.ast.HtmlInline;
import com.vladsch.flexmark.ast.HtmlInlineComment;
import com.vladsch.flexmark.ast.HtmlInnerBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.ast.ImageRef;
import com.vladsch.flexmark.ast.IndentedCodeBlock;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.LinkRef;
import com.vladsch.flexmark.ast.ListBlock;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.MailLink;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.OrderedListItem;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.ParagraphContainer;
import com.vladsch.flexmark.ast.ParagraphItemContainer;
import com.vladsch.flexmark.ast.RefNode;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.ast.StrongEmphasis;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.TextBase;
import com.vladsch.flexmark.ast.ThematicBreak;
import com.vladsch.flexmark.ast.util.ReferenceRepository;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.formatter.FormatterOptions;
import com.vladsch.flexmark.formatter.FormatterUtils;
import com.vladsch.flexmark.formatter.FormattingPhase;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.NodeFormatter;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.NodeFormatterFactory;
import com.vladsch.flexmark.formatter.NodeFormattingHandler;
import com.vladsch.flexmark.formatter.NodeRepositoryFormatter;
import com.vladsch.flexmark.formatter.RenderPurpose;
import com.vladsch.flexmark.formatter.TranslatingSpanRender;
import com.vladsch.flexmark.formatter.TranslationPlaceholderGenerator;
import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
import com.vladsch.flexmark.html.renderer.LinkType;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeRepository;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.NotNullValueSupplier;
import com.vladsch.flexmark.util.format.options.CodeFenceMarker;
import com.vladsch.flexmark.util.format.options.DiscretionaryText;
import com.vladsch.flexmark.util.format.options.ElementPlacement;
import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
import com.vladsch.flexmark.util.format.options.EqualizeTrailingMarker;
import com.vladsch.flexmark.util.format.options.HeadingStyle;
import com.vladsch.flexmark.util.format.options.ListSpacing;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.RepeatedSequence;
import com.vladsch.flexmark.util.sequence.mappers.SpaceMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p070Q1.RunnableC0218a;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CoreNodeFormatter extends NodeRepositoryFormatter<ReferenceRepository, Reference, RefNode> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map<String, String> attributeUniquificationIdMap;
    private int blankLines;
    final FormatterOptions formatterOptions;
    private final ListOptions listOptions;
    private final String myHtmlBlockPrefix;
    private final String myHtmlInlinePrefix;
    private final String myTranslationAutolinkPrefix;
    MutableDataHolder myTranslationStore;

    @Deprecated
    public static final DataKey<Map<String, String>> UNIQUIFICATION_MAP = Formatter.UNIQUIFICATION_MAP;

    @Deprecated
    public static final DataKey<Map<String, String>> ATTRIBUTE_UNIQUIFICATION_ID_MAP = Formatter.ATTRIBUTE_UNIQUIFICATION_ID_MAP;
    static final TranslationPlaceholderGenerator htmlEntityPlaceholderGenerator = new C8416h(17);
    public static final DataKey<Boolean> UNWRAPPED_AUTO_LINKS = new DataKey<>("UNWRAPPED_AUTO_LINKS", Boolean.FALSE);
    public static final DataKey<HashSet<String>> UNWRAPPED_AUTO_LINKS_MAP = new DataKey<>("UNWRAPPED_AUTO_LINKS_MAP", (NotNullValueSupplier) new C11818c());

    /* JADX INFO: renamed from: com.vladsch.flexmark.formatter.internal.CoreNodeFormatter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118141 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$CodeFenceMarker */
        static final /* synthetic */ int[] f8340x75d7d7;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$EqualizeTrailingMarker */
        static final /* synthetic */ int[] f8341x997b66dd;

        static {
            int[] iArr = new int[RenderPurpose.values().length];
            $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose = iArr;
            try {
                iArr[RenderPurpose.TRANSLATION_SPANS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED_SPANS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[CodeFenceMarker.values().length];
            f8340x75d7d7 = iArr2;
            try {
                iArr2[CodeFenceMarker.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8340x75d7d7[CodeFenceMarker.BACK_TICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8340x75d7d7[CodeFenceMarker.TILDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[EqualizeTrailingMarker.values().length];
            f8341x997b66dd = iArr3;
            try {
                iArr3[EqualizeTrailingMarker.EQUALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8341x997b66dd[EqualizeTrailingMarker.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8341x997b66dd[EqualizeTrailingMarker.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8341x997b66dd[EqualizeTrailingMarker.AS_IS.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeFormatterFactory {
        @Override // com.vladsch.flexmark.formatter.NodeFormatterFactory
        @NotNull
        public NodeFormatter create(@NotNull DataHolder dataHolder) {
            return new CoreNodeFormatter(dataHolder);
        }
    }

    public CoreNodeFormatter(DataHolder dataHolder) {
        super(dataHolder, null, Formatter.UNIQUIFICATION_MAP);
        FormatterOptions formatterOptions = new FormatterOptions(dataHolder);
        this.formatterOptions = formatterOptions;
        this.listOptions = ListOptions.get(dataHolder);
        this.blankLines = 0;
        this.myHtmlBlockPrefix = AbstractC0541b.m772n("<", formatterOptions.translationHtmlBlockPrefix);
        this.myHtmlInlinePrefix = formatterOptions.translationHtmlInlinePrefix;
        this.myTranslationAutolinkPrefix = formatterOptions.translationAutolinkPrefix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$render$3(HtmlEntity htmlEntity, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.appendNonTranslating(htmlEntity.getChars());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence lambda$renderAutoLink$4(String str) {
        UNWRAPPED_AUTO_LINKS_MAP.get(this.myTranslationStore).add(str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$renderAutoLink$5(MarkdownWriter markdownWriter, String str, DelimitedLinkNode delimitedLinkNode, String str2) {
        markdownWriter.append("<");
        markdownWriter.appendNonTranslating(str, delimitedLinkNode.getText(), str2);
        markdownWriter.append(">");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$2(int i) {
        Locale locale = Locale.US;
        return AbstractC0541b.m767i(i, "&#", ";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        BasedSequence chars = node.getChars();
        if (!(node instanceof Block)) {
            if (this.formatterOptions.keepSoftLineBreaks) {
                markdownWriter.append((CharSequence) chars);
                return;
            } else {
                markdownWriter.append(FormatterUtils.stripSoftLineBreak(chars, " "));
                return;
            }
        }
        BasedSequence contentChars = ((Block) node).getContentChars();
        if (chars.isNotNull()) {
            BasedSequence basedSequencePrefixOf = chars.prefixOf(contentChars);
            if (!basedSequencePrefixOf.isEmpty()) {
                markdownWriter.append((CharSequence) basedSequencePrefixOf);
            }
        }
        nodeFormatterContext.renderChildren(node);
        if (chars.isNotNull()) {
            BasedSequence basedSequenceSuffixOf = chars.suffixOf(contentChars);
            if (basedSequenceSuffixOf.isEmpty()) {
                return;
            }
            markdownWriter.append((CharSequence) basedSequenceSuffixOf);
        }
    }

    private void renderAutoLink(DelimitedLinkNode delimitedLinkNode, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter, String str, String str2) {
        if (!nodeFormatterContext.isTransformingText()) {
            markdownWriter.append((CharSequence) delimitedLinkNode.getChars());
            return;
        }
        int i = C118141.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[nodeFormatterContext.getRenderPurpose().ordinal()];
        if (i == 1) {
            if (delimitedLinkNode.getOpeningMarker().isNull()) {
                this.myTranslationStore.set(UNWRAPPED_AUTO_LINKS, Boolean.TRUE);
                nodeFormatterContext.postProcessNonTranslating(new C0332a(this, 9), new RunnableC0218a(markdownWriter, str, delimitedLinkNode, str2, 23));
                return;
            } else {
                markdownWriter.append("<");
                markdownWriter.appendNonTranslating(str, delimitedLinkNode.getText(), str2);
                markdownWriter.append(">");
                return;
            }
        }
        if (i == 2) {
            markdownWriter.append("<");
            markdownWriter.appendNonTranslating(str, delimitedLinkNode.getText(), str2);
            markdownWriter.append(">");
        } else {
            if (i != 3) {
                markdownWriter.append((CharSequence) delimitedLinkNode.getChars());
                return;
            }
            if (UNWRAPPED_AUTO_LINKS.get(this.myTranslationStore).booleanValue() && UNWRAPPED_AUTO_LINKS_MAP.get(this.myTranslationStore).contains(delimitedLinkNode.getText().toString())) {
                markdownWriter.appendNonTranslating(str, delimitedLinkNode.getText(), str2);
                return;
            }
            markdownWriter.append("<");
            markdownWriter.appendNonTranslating(str, delimitedLinkNode.getText(), str2);
            markdownWriter.append(">");
        }
    }

    public void appendReference(CharSequence charSequence, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (!nodeFormatterContext.isTransformingText() || nodeFormatterContext.getRenderPurpose() != RenderPurpose.TRANSLATED || nodeFormatterContext.getMergeContext() == null) {
            markdownWriter.appendTranslating(charSequence);
        } else {
            String strValueOf = String.valueOf(nodeFormatterContext.transformTranslating(null, charSequence, null, null));
            markdownWriter.append((CharSequence) this.referenceUniqificationMap.getOrDefault(strValueOf, strValueOf));
        }
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    public char getBlockQuoteLikePrefixChar() {
        return '>';
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<Class<?>> getNodeClasses() {
        if (this.formatterOptions.referencePlacement.isNoChange() || !this.formatterOptions.referenceSort.isUnused()) {
            return null;
        }
        return new HashSet(Arrays.asList(RefNode.class));
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
        final int i = 10;
        final int i2 = 2;
        final int i4 = 14;
        final int i5 = 19;
        final int i6 = 20;
        final int i7 = 22;
        final int i8 = 23;
        final int i9 = 24;
        final int i10 = 25;
        final int i11 = 26;
        final int i12 = 21;
        final int i13 = 27;
        final int i14 = 28;
        final int i15 = 29;
        final int i16 = 0;
        final int i17 = 1;
        final int i18 = 2;
        final int i19 = 3;
        final int i20 = 0;
        final int i21 = 1;
        final int i22 = 3;
        final int i23 = 4;
        final int i24 = 5;
        final int i25 = 6;
        final int i26 = 7;
        final int i27 = 8;
        final int i28 = 9;
        final int i29 = 11;
        final int i30 = 12;
        final int i31 = 13;
        final int i32 = 15;
        final int i33 = 16;
        final int i34 = 17;
        final int i35 = 18;
        return new HashSet(Arrays.asList(new NodeFormattingHandler(Node.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(AutoLink.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i2) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(BlankLine.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i4) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(BlockQuote.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i5) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Code.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i6) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Document.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i7) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Emphasis.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i8) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(FencedCodeBlock.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i9) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HardLineBreak.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i10) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Heading.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i11) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HtmlBlock.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i12) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HtmlCommentBlock.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i13) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HtmlInnerBlock.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i14) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HtmlInnerBlockComment.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i15) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HtmlEntity.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8347b;

            {
                this.f8347b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i16) {
                    case 0:
                        this.f8347b.render((HtmlEntity) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8347b.render((HtmlInline) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8347b.render((HtmlInlineComment) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8347b.render((Image) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HtmlInline.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8347b;

            {
                this.f8347b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i17) {
                    case 0:
                        this.f8347b.render((HtmlEntity) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8347b.render((HtmlInline) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8347b.render((HtmlInlineComment) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8347b.render((Image) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(HtmlInlineComment.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8347b;

            {
                this.f8347b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i18) {
                    case 0:
                        this.f8347b.render((HtmlEntity) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8347b.render((HtmlInline) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8347b.render((HtmlInlineComment) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8347b.render((Image) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Image.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8347b;

            {
                this.f8347b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i19) {
                    case 0:
                        this.f8347b.render((HtmlEntity) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8347b.render((HtmlInline) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8347b.render((HtmlInlineComment) node, nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8347b.render((Image) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(ImageRef.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i20) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(IndentedCodeBlock.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i21) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Link.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i22) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(LinkRef.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i23) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(BulletList.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i24) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(OrderedList.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i25) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(BulletListItem.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i26) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(OrderedListItem.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i27) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(MailLink.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i28) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Paragraph.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i29) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Reference.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i30) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(SoftLineBreak.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i31) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(StrongEmphasis.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i32) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(Text.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i33) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(TextBase.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i34) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        }), new NodeFormattingHandler(ThematicBreak.class, new NodeFormattingHandler.CustomNodeFormatter(this) { // from class: com.vladsch.flexmark.formatter.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeFormatter f8343b;

            {
                this.f8343b = this;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
            public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
                switch (i35) {
                    case 0:
                        this.f8343b.render((ImageRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 1:
                        this.f8343b.render((IndentedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 2:
                        this.f8343b.render((AutoLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 3:
                        this.f8343b.render((Link) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 4:
                        this.f8343b.render((LinkRef) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 5:
                        this.f8343b.render((BulletList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 6:
                        this.f8343b.render((OrderedList) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 7:
                        this.f8343b.render((BulletListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 8:
                        this.f8343b.render((OrderedListItem) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 9:
                        this.f8343b.render((MailLink) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 10:
                        this.f8343b.render(node, nodeFormatterContext, markdownWriter);
                        break;
                    case 11:
                        this.f8343b.render((Paragraph) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 12:
                        this.f8343b.render((Reference) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 13:
                        this.f8343b.render((SoftLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 14:
                        this.f8343b.render((BlankLine) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 15:
                        this.f8343b.render((StrongEmphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 16:
                        this.f8343b.render((Text) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 17:
                        this.f8343b.render((TextBase) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 18:
                        this.f8343b.render((ThematicBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 19:
                        this.f8343b.render((BlockQuote) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 20:
                        this.f8343b.render((Code) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 21:
                        this.f8343b.render((HtmlBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 22:
                        this.f8343b.render((Document) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 23:
                        this.f8343b.render((Emphasis) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 24:
                        this.f8343b.render((FencedCodeBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 25:
                        this.f8343b.render((HardLineBreak) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 26:
                        this.f8343b.render((Heading) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 27:
                        this.f8343b.render((HtmlCommentBlock) node, nodeFormatterContext, markdownWriter);
                        break;
                    case 28:
                        this.f8343b.render((HtmlBlockBase) ((HtmlInnerBlock) node), nodeFormatterContext, markdownWriter);
                        break;
                    default:
                        this.f8343b.render((HtmlInnerBlockComment) node, nodeFormatterContext, markdownWriter);
                        break;
                }
            }
        })));
    }

    @Override // com.vladsch.flexmark.formatter.NodeRepositoryFormatter
    public ElementPlacement getReferencePlacement() {
        return this.formatterOptions.referencePlacement;
    }

    @Override // com.vladsch.flexmark.formatter.NodeRepositoryFormatter
    public ElementPlacementSort getReferenceSort() {
        return this.formatterOptions.referenceSort;
    }

    @Override // com.vladsch.flexmark.formatter.NodeRepositoryFormatter, com.vladsch.flexmark.formatter.PhasedNodeFormatter
    public void renderDocument(@NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter, @NotNull Document document, @NotNull FormattingPhase formattingPhase) {
        super.renderDocument(nodeFormatterContext, markdownWriter, document, formattingPhase);
        this.attributeUniquificationIdMap = Formatter.ATTRIBUTE_UNIQUIFICATION_ID_MAP.get(nodeFormatterContext.getTranslationStore());
        if (formattingPhase == FormattingPhase.DOCUMENT_BOTTOM && this.formatterOptions.appendTransferredReferences) {
            ArrayList<DataKeyBase> arrayList = new ArrayList();
            for (DataKeyBase<?> dataKeyBase : document.getAll().keySet()) {
                if (dataKeyBase.get(document) instanceof NodeRepository) {
                    arrayList.add(dataKeyBase);
                }
            }
            arrayList.sort(Comparator.comparing(new C11419a(6)));
            boolean z = true;
            for (DataKeyBase dataKeyBase2 : arrayList) {
                if (dataKeyBase2.get(document) instanceof NodeRepository) {
                    for (Object obj : ((NodeRepository) dataKeyBase2.get(document)).getReferencedElements(document)) {
                        if (obj instanceof Node) {
                            Node node = (Node) obj;
                            if (node.getDocument() != document) {
                                if (z) {
                                    markdownWriter.blankLine();
                                    z = false;
                                }
                                nodeFormatterContext.render(node);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.vladsch.flexmark.formatter.NodeRepositoryFormatter
    public ReferenceRepository getRepository(DataHolder dataHolder) {
        return Parser.REFERENCES.get(dataHolder);
    }

    @Override // com.vladsch.flexmark.formatter.NodeRepositoryFormatter
    public void lambda$renderReferenceBlockUnique$1(Reference reference, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (!nodeFormatterContext.isTransformingText()) {
            markdownWriter.append((CharSequence) reference.getChars()).line();
            Node next = reference.getNext();
            if ((next instanceof HtmlCommentBlock) || (next instanceof HtmlInnerBlockComment)) {
                BasedSequence basedSequenceMidSequence = next.getChars().trim().midSequence(4, -3);
                Pattern pattern = this.formatterOptions.linkMarkerCommentPattern;
                if (pattern != null && pattern.matcher(basedSequenceMidSequence).matches()) {
                    markdownWriter.append("<!--").append((CharSequence) String.valueOf(basedSequenceMidSequence)).append((CharSequence) "-->");
                }
            }
            markdownWriter.line();
            return;
        }
        markdownWriter.append((CharSequence) reference.getOpeningMarker());
        appendReference(reference.getReference(), nodeFormatterContext, markdownWriter);
        markdownWriter.append((CharSequence) reference.getClosingMarker());
        markdownWriter.append(' ');
        markdownWriter.append((CharSequence) reference.getUrlOpeningMarker());
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
            ResolvedLink resolvedLinkResolveLink = nodeFormatterContext.resolveLink(LinkType.LINK, reference.getUrl(), Boolean.FALSE);
            markdownWriter.appendNonTranslating(resolvedLinkResolveLink.getPageRef());
            if (resolvedLinkResolveLink.getAnchorRef() != null) {
                markdownWriter.append(ContentUtils.HASH_SYMBOL);
                CharSequence charSequenceTransformAnchorRef = nodeFormatterContext.transformAnchorRef(resolvedLinkResolveLink.getPageRef(), resolvedLinkResolveLink.getAnchorRef());
                if (this.attributeUniquificationIdMap == null || !resolvedLinkResolveLink.getPageRef().isEmpty() || !nodeFormatterContext.isTransformingText() || nodeFormatterContext.getMergeContext() == null) {
                    markdownWriter.append(charSequenceTransformAnchorRef);
                } else {
                    String strValueOf = String.valueOf(charSequenceTransformAnchorRef);
                    markdownWriter.append((CharSequence) this.attributeUniquificationIdMap.getOrDefault(strValueOf, strValueOf));
                }
                markdownWriter.append(charSequenceTransformAnchorRef);
            }
        } else {
            markdownWriter.appendNonTranslating(reference.getPageRef());
            markdownWriter.append((CharSequence) reference.getAnchorMarker());
            if (reference.getAnchorRef().isNotNull()) {
                markdownWriter.append(nodeFormatterContext.transformAnchorRef(reference.getPageRef(), reference.getAnchorRef()));
            }
        }
        if (reference.getTitleOpeningMarker().isNotNull()) {
            markdownWriter.append(' ');
            markdownWriter.append((CharSequence) reference.getTitleOpeningMarker());
            if (reference.getTitle().isNotNull()) {
                markdownWriter.appendTranslating(reference.getTitle());
            }
            markdownWriter.append((CharSequence) reference.getTitleClosingMarker());
        }
        markdownWriter.append((CharSequence) reference.getUrlClosingMarker()).line();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(BlankLine blankLine, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (FormatterUtils.LIST_ITEM_SPACING.get(nodeFormatterContext.getDocument()) != null || markdownWriter.offsetWithPending() <= 0) {
            return;
        }
        if (blankLine.getPrevious() != null && !(blankLine.getPrevious() instanceof BlankLine)) {
            this.blankLines = 0;
        }
        int i = this.blankLines + 1;
        this.blankLines = i;
        if (i <= this.formatterOptions.maxBlankLines) {
            markdownWriter.blankLine(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Document document, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        this.myTranslationStore = nodeFormatterContext.getTranslationStore();
        nodeFormatterContext.renderChildren(document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void render(final Heading heading, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        HtmlIdGenerator idGenerator;
        markdownWriter.blankLine();
        HeadingStyle headingStyle = this.formatterOptions.headingStyle;
        boolean z = false;
        if (!nodeFormatterContext.isTransformingText() && !headingStyle.isNoChange(heading.isSetextHeading(), heading.getLevel())) {
            if (headingStyle.isSetext()) {
                nodeFormatterContext.renderChildren(heading);
                markdownWriter.line();
                char c = heading.getLevel() == 1 ? '=' : '-';
                FormatterOptions formatterOptions = this.formatterOptions;
                if (formatterOptions.setextHeadingEqualizeMarker) {
                    markdownWriter.append(c, Utils.minLimit(markdownWriter.getLineInfo(markdownWriter.getLineCountWithPending() - 1).textLength, this.formatterOptions.minSetextMarkerLength));
                } else {
                    markdownWriter.append(RepeatedSequence.repeatOf(c, formatterOptions.minSetextMarkerLength));
                }
            } else {
                CharSequence charSequenceRepeatOf = RepeatedSequence.repeatOf('#', heading.getLevel());
                markdownWriter.append(charSequenceRepeatOf);
                DiscretionaryText discretionaryText = this.formatterOptions.spaceAfterAtxMarker;
                if (discretionaryText == DiscretionaryText.ADD || (discretionaryText == DiscretionaryText.AS_IS && !Parser.HEADING_NO_ATX_SPACE.get(nodeFormatterContext.getOptions()).booleanValue())) {
                    z = true;
                }
                if (z) {
                    markdownWriter.append(' ');
                }
                nodeFormatterContext.renderChildren(heading);
                int i = C118141.f8341x997b66dd[this.formatterOptions.atxHeadingTrailingMarker.ordinal()];
                if (i == 1 || i == 2) {
                    if (z) {
                        markdownWriter.append(' ');
                    }
                    markdownWriter.append(charSequenceRepeatOf);
                }
            }
        } else if (heading.isAtxHeading()) {
            markdownWriter.append((CharSequence) heading.getOpeningMarker());
            DiscretionaryText discretionaryText2 = this.formatterOptions.spaceAfterAtxMarker;
            if (discretionaryText2 == DiscretionaryText.ADD || (discretionaryText2 == DiscretionaryText.AS_IS && heading.getOpeningMarker().getEndOffset() < heading.getText().getStartOffset())) {
                z = true;
            }
            if (z) {
                markdownWriter.append(' ');
            }
            final int i2 = 0;
            nodeFormatterContext.translatingRefTargetSpan(heading, new TranslatingSpanRender() { // from class: com.vladsch.flexmark.formatter.internal.b
                @Override // com.vladsch.flexmark.formatter.TranslatingSpanRender
                public final void render(NodeFormatterContext nodeFormatterContext2, MarkdownWriter markdownWriter2) {
                    switch (i2) {
                        case 0:
                            nodeFormatterContext2.renderChildren(heading);
                            break;
                        default:
                            nodeFormatterContext2.renderChildren(heading);
                            break;
                    }
                }
            });
            int i4 = C118141.f8341x997b66dd[this.formatterOptions.atxHeadingTrailingMarker.ordinal()];
            if (i4 == 1) {
                if (!heading.getClosingMarker().isNull()) {
                }
                idGenerator = nodeFormatterContext.getIdGenerator();
                if (idGenerator != null) {
                }
            } else {
                if (i4 != 2) {
                    if (i4 != 3 && heading.getClosingMarker().isNotNull()) {
                        if (z) {
                            markdownWriter.append(' ');
                        }
                        markdownWriter.append((CharSequence) heading.getClosingMarker());
                    }
                } else {
                    if (z) {
                        markdownWriter.append(' ');
                    }
                    markdownWriter.append((CharSequence) heading.getOpeningMarker());
                }
                idGenerator = nodeFormatterContext.getIdGenerator();
                if (idGenerator != null) {
                    nodeFormatterContext.addExplicitId(heading, idGenerator.getId(heading), nodeFormatterContext, markdownWriter);
                }
            }
        } else {
            final int i5 = 1;
            nodeFormatterContext.translatingRefTargetSpan(heading, new TranslatingSpanRender() { // from class: com.vladsch.flexmark.formatter.internal.b
                @Override // com.vladsch.flexmark.formatter.TranslatingSpanRender
                public final void render(NodeFormatterContext nodeFormatterContext2, MarkdownWriter markdownWriter2) {
                    switch (i5) {
                        case 0:
                            nodeFormatterContext2.renderChildren(heading);
                            break;
                        default:
                            nodeFormatterContext2.renderChildren(heading);
                            break;
                    }
                }
            });
            HtmlIdGenerator idGenerator2 = nodeFormatterContext.getIdGenerator();
            if (idGenerator2 != null) {
                nodeFormatterContext.addExplicitId(heading, idGenerator2.getId(heading), nodeFormatterContext, markdownWriter);
            }
            markdownWriter.line();
            if (this.formatterOptions.setextHeadingEqualizeMarker) {
                markdownWriter.append(heading.getClosingMarker().charAt(0), Utils.minLimit(markdownWriter.getLineInfo(markdownWriter.getLineCountWithPending() - 1).textLength, this.formatterOptions.minSetextMarkerLength));
            } else {
                markdownWriter.append((CharSequence) heading.getClosingMarker());
            }
        }
        markdownWriter.tailBlankLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(BlockQuote blockQuote, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        FormatterUtils.renderBlockQuoteLike(blockQuote, nodeFormatterContext, markdownWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(ThematicBreak thematicBreak, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.blankLine();
        String str = this.formatterOptions.thematicBreak;
        if (str != null) {
            markdownWriter.append((CharSequence) str);
        } else {
            markdownWriter.append((CharSequence) thematicBreak.getChars());
        }
        markdownWriter.tailBlankLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void render(FencedCodeBlock fencedCodeBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        int i;
        markdownWriter.blankLine();
        BasedSequence openingMarker = fencedCodeBlock.getOpeningMarker();
        BasedSequence closingMarker = fencedCodeBlock.getClosingMarker();
        int i2 = 0;
        char cCharAt = openingMarker.charAt(0);
        char cCharAt2 = closingMarker.length() > 0 ? closingMarker.charAt(0) : (char) 0;
        int length = openingMarker.length();
        int length2 = closingMarker.length();
        int i4 = C118141.f8340x75d7d7[this.formatterOptions.fencedCodeMarkerType.ordinal()];
        if (i4 != 2) {
            cCharAt = i4 == 3 ? '~' : '`';
            i = this.formatterOptions.fencedCodeMarkerLength;
            if (length < i) {
                length = i;
            }
            if (length2 < i) {
                length2 = i;
            }
            CharSequence charSequenceRepeatOf = RepeatedSequence.repeatOf(String.valueOf(cCharAt), length);
            CharSequence charSequenceRepeatOf2 = (!this.formatterOptions.fencedCodeMatchClosingMarker || cCharAt2 == 0) ? charSequenceRepeatOf : RepeatedSequence.repeatOf(String.valueOf(cCharAt2), length2);
            markdownWriter.append(charSequenceRepeatOf);
            if (this.formatterOptions.fencedCodeSpaceBeforeInfo) {
                markdownWriter.append(' ');
            }
            markdownWriter.appendNonTranslating(fencedCodeBlock.getInfo());
            markdownWriter.line();
            markdownWriter.openPreFormatted(true);
            if (!nodeFormatterContext.isTransformingText()) {
                markdownWriter.appendNonTranslating(fencedCodeBlock.getContentChars());
            } else if (this.formatterOptions.fencedCodeMinimizeIndent) {
                List<BasedSequence> contentLines = fencedCodeBlock.getContentLines();
                int[] iArr = new int[contentLines.size()];
                Iterator<BasedSequence> it = contentLines.iterator();
                int iMin = Integer.MAX_VALUE;
                int i5 = 0;
                while (it.hasNext()) {
                    int iCountLeadingColumns = it.next().countLeadingColumns(0, CharPredicate.SPACE_TAB);
                    iArr[i5] = iCountLeadingColumns;
                    iMin = Utils.min(iMin, iCountLeadingColumns);
                    i5++;
                }
                if (iMin > 0) {
                    for (BasedSequence basedSequence : contentLines) {
                        int i6 = iArr[i2];
                        if (i6 > iMin) {
                            markdownWriter.append(' ', i6 - iMin);
                        }
                        markdownWriter.append((CharSequence) basedSequence.trimStart());
                        i2++;
                    }
                } else {
                    markdownWriter.append((CharSequence) fencedCodeBlock.getContentChars());
                }
            } else {
                markdownWriter.append((CharSequence) fencedCodeBlock.getContentChars());
            }
            markdownWriter.closePreFormatted();
            markdownWriter.line().append(charSequenceRepeatOf2).line();
            if ((fencedCodeBlock.getParent() instanceof ListItem) || !FormatterUtils.isLastOfItem(fencedCodeBlock) || FormatterUtils.LIST_ITEM_SPACING.get(nodeFormatterContext.getDocument()) == ListSpacing.LOOSE) {
                markdownWriter.tailBlankLine();
            }
            return;
        }
        cCharAt2 = cCharAt;
        i = this.formatterOptions.fencedCodeMarkerLength;
        if (length < i) {
        }
        if (length2 < i) {
        }
        CharSequence charSequenceRepeatOf3 = RepeatedSequence.repeatOf(String.valueOf(cCharAt), length);
        if (this.formatterOptions.fencedCodeMatchClosingMarker) {
        }
        markdownWriter.append(charSequenceRepeatOf3);
        if (this.formatterOptions.fencedCodeSpaceBeforeInfo) {
        }
        markdownWriter.appendNonTranslating(fencedCodeBlock.getInfo());
        markdownWriter.line();
        markdownWriter.openPreFormatted(true);
        if (!nodeFormatterContext.isTransformingText()) {
        }
        markdownWriter.closePreFormatted();
        markdownWriter.line().append(charSequenceRepeatOf2).line();
        if (fencedCodeBlock.getParent() instanceof ListItem) {
        }
        markdownWriter.tailBlankLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(IndentedCodeBlock indentedCodeBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.blankLine();
        if (nodeFormatterContext.isTransformingText()) {
            BasedSequence contentChars = indentedCodeBlock.getContentChars();
            String actualAdditionalPrefix = FormatterUtils.getActualAdditionalPrefix(contentChars, markdownWriter);
            if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED) {
                contentChars = contentChars.trimStart();
            }
            markdownWriter.pushPrefix().addPrefix((CharSequence) actualAdditionalPrefix);
            markdownWriter.openPreFormatted(true);
            markdownWriter.appendNonTranslating(Utils.suffixWith(contentChars.toString(), '\n'));
        } else {
            String string = RepeatedSequence.repeatOf(" ", this.listOptions.getCodeIndent()).toString();
            if (this.formatterOptions.emulationProfile == ParserEmulationProfile.GITHUB_DOC && (indentedCodeBlock.getParent() instanceof ListItem)) {
                string = RepeatedSequence.repeatOf(" ", Utils.minLimit(7 - ((ListItem) indentedCodeBlock.getParent()).getOpeningMarker().length(), 4)).toString();
            }
            markdownWriter.pushPrefix().addPrefix((CharSequence) string);
            markdownWriter.openPreFormatted(true);
            if (this.formatterOptions.indentedCodeMinimizeIndent) {
                List<BasedSequence> contentLines = indentedCodeBlock.getContentLines();
                int[] iArr = new int[contentLines.size()];
                Iterator<BasedSequence> it = contentLines.iterator();
                int i = 0;
                int iMin = Integer.MAX_VALUE;
                int i2 = 0;
                while (it.hasNext()) {
                    int iCountLeadingColumns = it.next().countLeadingColumns(0, CharPredicate.SPACE_TAB);
                    iArr[i2] = iCountLeadingColumns;
                    iMin = Utils.min(iMin, iCountLeadingColumns);
                    i2++;
                }
                if (iMin > 0) {
                    for (BasedSequence basedSequence : contentLines) {
                        int i4 = iArr[i];
                        if (i4 > iMin) {
                            markdownWriter.append(' ', i4 - iMin);
                        }
                        markdownWriter.append((CharSequence) basedSequence.trimStart());
                        i++;
                    }
                } else {
                    markdownWriter.append((CharSequence) indentedCodeBlock.getContentChars());
                }
            } else {
                markdownWriter.append((CharSequence) indentedCodeBlock.getContentChars());
            }
        }
        markdownWriter.closePreFormatted();
        markdownWriter.popPrefix(true);
        markdownWriter.tailBlankLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(BulletList bulletList, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        FormatterUtils.renderList(bulletList, nodeFormatterContext, markdownWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(OrderedList orderedList, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        FormatterUtils.renderList(orderedList, nodeFormatterContext, markdownWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(BulletListItem bulletListItem, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        FormatterUtils.renderListItem(bulletListItem, nodeFormatterContext, markdownWriter, this.listOptions, bulletListItem.getMarkerSuffix(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(OrderedListItem orderedListItem, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        FormatterUtils.renderListItem(orderedListItem, nodeFormatterContext, markdownWriter, this.listOptions, orderedListItem.getMarkerSuffix(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Emphasis emphasis, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.append((CharSequence) emphasis.getOpeningMarker());
        nodeFormatterContext.renderChildren(emphasis);
        markdownWriter.append((CharSequence) emphasis.getOpeningMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(StrongEmphasis strongEmphasis, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.append((CharSequence) strongEmphasis.getOpeningMarker());
        nodeFormatterContext.renderChildren(strongEmphasis);
        markdownWriter.append((CharSequence) strongEmphasis.getOpeningMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Paragraph paragraph, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (nodeFormatterContext.isTransformingText()) {
            FormatterUtils.renderTextBlockParagraphLines(paragraph, nodeFormatterContext, markdownWriter);
            if (paragraph.isTrailingBlankLine()) {
                markdownWriter.tailBlankLine();
                return;
            }
            return;
        }
        if (!(paragraph.getParent() instanceof ParagraphItemContainer)) {
            if (paragraph.getParent() instanceof ParagraphContainer) {
                boolean zIsParagraphStartWrappingDisabled = ((ParagraphContainer) paragraph.getParent()).isParagraphStartWrappingDisabled(paragraph);
                boolean zIsParagraphEndWrappingDisabled = ((ParagraphContainer) paragraph.getParent()).isParagraphEndWrappingDisabled(paragraph);
                if (!zIsParagraphStartWrappingDisabled && !zIsParagraphEndWrappingDisabled) {
                    FormatterUtils.renderLooseParagraph(paragraph, nodeFormatterContext, markdownWriter);
                    return;
                }
                if (!zIsParagraphStartWrappingDisabled) {
                    markdownWriter.blankLine();
                }
                FormatterUtils.renderTextBlockParagraphLines(paragraph, nodeFormatterContext, markdownWriter);
                if (zIsParagraphEndWrappingDisabled) {
                    return;
                }
                markdownWriter.tailBlankLine();
                return;
            }
            if (!paragraph.isTrailingBlankLine() && (paragraph.getNext() == null || (paragraph.getNext() instanceof ListBlock))) {
                FormatterUtils.renderTextBlockParagraphLines(paragraph, nodeFormatterContext, markdownWriter);
                return;
            } else {
                FormatterUtils.renderLooseParagraph(paragraph, nodeFormatterContext, markdownWriter);
                return;
            }
        }
        if (((ParagraphItemContainer) paragraph.getParent()).isItemParagraph(paragraph)) {
            if (this.formatterOptions.blankLinesInAst) {
                FormatterUtils.renderLooseItemParagraph(paragraph, nodeFormatterContext, markdownWriter);
                return;
            }
            ListSpacing listSpacing = FormatterUtils.LIST_ITEM_SPACING.get(nodeFormatterContext.getDocument());
            if (listSpacing == ListSpacing.TIGHT) {
                FormatterUtils.renderTextBlockParagraphLines(paragraph, nodeFormatterContext, markdownWriter);
                return;
            }
            if (listSpacing == ListSpacing.LOOSE) {
                if (paragraph.getParent().getNextAnyNot(BlankLine.class) == null) {
                    FormatterUtils.renderTextBlockParagraphLines(paragraph, nodeFormatterContext, markdownWriter);
                    return;
                } else {
                    FormatterUtils.renderLooseItemParagraph(paragraph, nodeFormatterContext, markdownWriter);
                    return;
                }
            }
            if (!((ParagraphItemContainer) paragraph.getParent()).isParagraphWrappingDisabled(paragraph, this.listOptions, nodeFormatterContext.getOptions())) {
                FormatterUtils.renderLooseItemParagraph(paragraph, nodeFormatterContext, markdownWriter);
                return;
            } else {
                FormatterUtils.renderTextBlockParagraphLines(paragraph, nodeFormatterContext, markdownWriter);
                return;
            }
        }
        FormatterUtils.renderLooseParagraph(paragraph, nodeFormatterContext, markdownWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(SoftLineBreak softLineBreak, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        FormatterOptions formatterOptions = this.formatterOptions;
        if (!formatterOptions.keepSoftLineBreaks && formatterOptions.rightMargin <= 0) {
            if (markdownWriter.isPendingSpace()) {
                return;
            }
            markdownWriter.append(' ');
            return;
        }
        markdownWriter.append((CharSequence) softLineBreak.getChars());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HardLineBreak hardLineBreak, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (this.formatterOptions.keepHardLineBreaks) {
            if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
                markdownWriter.append((CharSequence) hardLineBreak.getChars());
                return;
            } else {
                markdownWriter.append((CharSequence) hardLineBreak.getChars());
                return;
            }
        }
        if (markdownWriter.isPendingSpace()) {
            return;
        }
        markdownWriter.append(' ');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HtmlEntity htmlEntity, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.FORMAT) {
            markdownWriter.append((CharSequence) htmlEntity.getChars());
        } else {
            nodeFormatterContext.customPlaceholderFormat(htmlEntityPlaceholderGenerator, new C11253j(htmlEntity, 15));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Text text, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (this.formatterOptions.keepSoftLineBreaks) {
            markdownWriter.append((CharSequence) text.getChars());
        } else {
            markdownWriter.append(FormatterUtils.stripSoftLineBreak(text.getChars(), " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TextBase textBase, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        nodeFormatterContext.renderChildren(textBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void render(Code code, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.append((CharSequence) code.getOpeningMarker());
        if (!nodeFormatterContext.isTransformingText()) {
            FormatterOptions formatterOptions = this.formatterOptions;
            if (formatterOptions.rightMargin != 0) {
                if (formatterOptions.keepSoftLineBreaks) {
                    markdownWriter.append((CharSequence) code.getText());
                } else {
                    markdownWriter.append(FormatterUtils.stripSoftLineBreak(code.getText(), " "));
                }
            } else if (this.formatterOptions.keepSoftLineBreaks) {
                markdownWriter.appendNonTranslating(code.getText());
            } else {
                markdownWriter.appendNonTranslating(FormatterUtils.stripSoftLineBreak(code.getText(), " "));
            }
        }
        markdownWriter.append((CharSequence) code.getClosingMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HtmlBlock htmlBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (htmlBlock.hasChildren()) {
            nodeFormatterContext.renderChildren(htmlBlock);
            return;
        }
        markdownWriter.blankLine();
        render((HtmlBlockBase) htmlBlock, nodeFormatterContext, markdownWriter);
        markdownWriter.tailBlankLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HtmlCommentBlock htmlCommentBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        Pattern pattern;
        BasedSequence basedSequenceMidSequence = htmlCommentBlock.getChars().trim().midSequence(4, -3);
        CharSequence charSequence = BasedSequence.EOL;
        if (!nodeFormatterContext.isTransformingText() && (pattern = this.formatterOptions.linkMarkerCommentPattern) != null && pattern.matcher(basedSequenceMidSequence).matches()) {
            if (htmlCommentBlock.getPrevious() instanceof Reference) {
                return;
            }
            ((MarkdownWriter) markdownWriter.append("<!--")).append((CharSequence) String.valueOf(basedSequenceMidSequence.toMapped(SpaceMapper.toNonBreakSpace))).append((CharSequence) "-->");
            return;
        }
        markdownWriter.appendTranslating("<!--", basedSequenceMidSequence, "-->", charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HtmlBlockBase htmlBlockBase, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        int i = C118141.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[nodeFormatterContext.getRenderPurpose().ordinal()];
        if (i == 1 || i == 2) {
            markdownWriter.appendNonTranslating(this.myHtmlBlockPrefix, htmlBlockBase.getChars().trimEOL(), ">", htmlBlockBase.getChars().trimmedEOL());
            return;
        }
        if (i != 3) {
            markdownWriter.openPreFormatted(true);
            if (htmlBlockBase.getSpanningChars().equals(htmlBlockBase.getChars())) {
                Iterator<BasedSequence> it = htmlBlockBase.getContentLines().iterator();
                while (it.hasNext()) {
                    markdownWriter.append((CharSequence) it.next());
                }
            } else {
                markdownWriter.append((CharSequence) htmlBlockBase.getChars());
            }
            markdownWriter.line().closePreFormatted();
            return;
        }
        markdownWriter.openPreFormatted(true);
        markdownWriter.appendNonTranslating(htmlBlockBase.getChars());
        markdownWriter.closePreFormatted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HtmlInnerBlockComment htmlInnerBlockComment, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        Pattern pattern;
        BasedSequence basedSequenceMidSequence = htmlInnerBlockComment.getChars().trim().midSequence(4, -3);
        if (!nodeFormatterContext.isTransformingText() && (pattern = this.formatterOptions.linkMarkerCommentPattern) != null && pattern.matcher(basedSequenceMidSequence).matches()) {
            if (htmlInnerBlockComment.getPrevious() instanceof Reference) {
                return;
            }
            ((MarkdownWriter) markdownWriter.append("<!--")).append((CharSequence) String.valueOf(basedSequenceMidSequence.toMapped(SpaceMapper.toNonBreakSpace))).append((CharSequence) "-->");
            return;
        }
        markdownWriter.appendTranslating("<!--", basedSequenceMidSequence, "-->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HtmlInline htmlInline, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        int i = C118141.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[nodeFormatterContext.getRenderPurpose().ordinal()];
        if (i == 1 || i == 2) {
            markdownWriter.appendNonTranslating(AbstractC0541b.m756B(htmlInline.getChars().startsWith("</") ? "</" : "<", this.myHtmlInlinePrefix), htmlInline.getChars(), ">");
        } else if (i != 3) {
            markdownWriter.append((CharSequence) htmlInline.getChars());
        } else {
            markdownWriter.appendNonTranslating(htmlInline.getChars());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(HtmlInlineComment htmlInlineComment, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        Pattern pattern;
        BasedSequence basedSequenceMidSequence = htmlInlineComment.getChars().trim().midSequence(4, -3);
        if (!nodeFormatterContext.isTransformingText() && (pattern = this.formatterOptions.linkMarkerCommentPattern) != null && pattern.matcher(basedSequenceMidSequence).matches()) {
            ((MarkdownWriter) markdownWriter.append("<!--")).append((CharSequence) String.valueOf(basedSequenceMidSequence.toMapped(SpaceMapper.toNonBreakSpace))).append((CharSequence) "-->");
        } else {
            markdownWriter.appendTranslating("<!--", basedSequenceMidSequence, "-->");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Reference reference, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        renderReference(reference, nodeFormatterContext, markdownWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(AutoLink autoLink, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        renderAutoLink(autoLink, nodeFormatterContext, markdownWriter, this.myTranslationAutolinkPrefix, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(MailLink mailLink, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        renderAutoLink(mailLink, nodeFormatterContext, markdownWriter, this.myTranslationAutolinkPrefix, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void render(Image image, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (!nodeFormatterContext.isTransformingText()) {
            FormatterOptions formatterOptions = this.formatterOptions;
            if (formatterOptions.rightMargin > 0 && formatterOptions.keepImageLinksAtStart) {
                markdownWriter.append((char) 8232);
            } else {
                markdownWriter.lineIf(this.formatterOptions.keepImageLinksAtStart);
            }
        }
        if (this.formatterOptions.optimizedInlineRendering && !nodeFormatterContext.isTransformingText()) {
            markdownWriter.append((CharSequence) image.getChars());
            return;
        }
        markdownWriter.append((CharSequence) image.getTextOpeningMarker());
        if (nodeFormatterContext.isTransformingText() && image.getFirstChildAny(HtmlInline.class) == null) {
            markdownWriter.appendTranslating(image.getText());
        } else if (this.formatterOptions.rightMargin > 0) {
            markdownWriter.append((CharSequence) image.getText().toMapped(SpaceMapper.toNonBreakSpace));
        } else {
            nodeFormatterContext.renderChildren(image);
        }
        markdownWriter.append((CharSequence) image.getTextClosingMarker());
        markdownWriter.append((CharSequence) image.getLinkOpeningMarker());
        markdownWriter.append((CharSequence) image.getUrlOpeningMarker());
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
            markdownWriter.appendNonTranslating(nodeFormatterContext.resolveLink(LinkType.LINK, image.getUrl(), Boolean.FALSE).getPageRef());
        } else {
            markdownWriter.append((CharSequence) image.getUrlOpeningMarker());
            markdownWriter.appendNonTranslating(image.getPageRef());
        }
        markdownWriter.append((CharSequence) image.getUrlClosingMarker());
        if (!image.getUrlContent().isEmpty()) {
            markdownWriter.openPreFormatted(true);
            markdownWriter.pushOptions().preserveSpaces();
            if (!nodeFormatterContext.isTransformingText() && this.formatterOptions.rightMargin > 0) {
                BasedSequence urlContent = image.getUrlContent();
                int length = urlContent.length();
                markdownWriter.append('\n');
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    char cCharAt = urlContent.charAt(i);
                    if (cCharAt == '\n' || cCharAt == '\r') {
                        markdownWriter.append(urlContent.subSequence(i, i + 1));
                        z = true;
                    } else if (cCharAt != ' ') {
                        if (z) {
                            markdownWriter.append((char) 8232);
                            z = false;
                        }
                        markdownWriter.append(urlContent.subSequence(i, i + 1));
                    } else {
                        if (z) {
                            markdownWriter.append((char) 8232);
                            z = false;
                        }
                        markdownWriter.append((char) 160);
                    }
                }
            } else {
                markdownWriter.append((CharSequence) image.getUrlContent());
            }
            markdownWriter.popOptions();
            markdownWriter.closePreFormatted();
            markdownWriter.append((char) 8232);
        }
        if (image.getTitleOpeningMarker().isNotNull()) {
            markdownWriter.append(' ');
            markdownWriter.append((CharSequence) image.getTitleOpeningMarker());
            if (image.getTitle().isNotNull()) {
                markdownWriter.appendTranslating(image.getTitle());
            }
            markdownWriter.append((CharSequence) image.getTitleClosingMarker());
        }
        markdownWriter.append((CharSequence) image.getLinkClosingMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void render(Link link, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (!nodeFormatterContext.isTransformingText()) {
            FormatterOptions formatterOptions = this.formatterOptions;
            if (formatterOptions.rightMargin > 0 && formatterOptions.keepExplicitLinksAtStart) {
                markdownWriter.append((char) 8232);
            } else {
                markdownWriter.lineIf(this.formatterOptions.keepExplicitLinksAtStart);
            }
        }
        if (this.formatterOptions.optimizedInlineRendering && !nodeFormatterContext.isTransformingText()) {
            markdownWriter.append((CharSequence) link.getChars());
            return;
        }
        markdownWriter.append((CharSequence) link.getTextOpeningMarker());
        if (nodeFormatterContext.isTransformingText() && link.getFirstChildAny(HtmlInline.class) == null) {
            markdownWriter.appendTranslating(link.getText());
        } else if (this.formatterOptions.rightMargin > 0) {
            markdownWriter.append((CharSequence) link.getText().toMapped(SpaceMapper.toNonBreakSpace));
        } else {
            nodeFormatterContext.renderChildren(link);
        }
        markdownWriter.append((CharSequence) link.getTextClosingMarker());
        markdownWriter.append((CharSequence) link.getLinkOpeningMarker());
        markdownWriter.append((CharSequence) link.getUrlOpeningMarker());
        if (nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATION_SPANS) {
            ResolvedLink resolvedLinkResolveLink = nodeFormatterContext.resolveLink(LinkType.LINK, link.getUrl(), Boolean.FALSE);
            markdownWriter.appendNonTranslating(resolvedLinkResolveLink.getPageRef());
            if (resolvedLinkResolveLink.getAnchorRef() != null) {
                markdownWriter.append(ContentUtils.HASH_SYMBOL);
                markdownWriter.append(nodeFormatterContext.transformAnchorRef(resolvedLinkResolveLink.getPageRef(), resolvedLinkResolveLink.getAnchorRef()));
            }
        } else {
            CharSequence charSequenceTransformNonTranslating = nodeFormatterContext.transformNonTranslating(null, link.getPageRef(), null, null);
            markdownWriter.append(charSequenceTransformNonTranslating);
            markdownWriter.append((CharSequence) link.getAnchorMarker());
            if (link.getAnchorRef().isNotNull()) {
                CharSequence charSequenceTransformAnchorRef = nodeFormatterContext.transformAnchorRef(link.getPageRef(), link.getAnchorRef());
                if (this.attributeUniquificationIdMap != null && nodeFormatterContext.getRenderPurpose() == RenderPurpose.TRANSLATED && nodeFormatterContext.getMergeContext() != null) {
                    String strValueOf = String.valueOf(charSequenceTransformAnchorRef);
                    if (charSequenceTransformNonTranslating.length() == 0) {
                        strValueOf = this.attributeUniquificationIdMap.getOrDefault(strValueOf, strValueOf);
                    }
                    markdownWriter.append((CharSequence) strValueOf);
                } else {
                    markdownWriter.append(charSequenceTransformAnchorRef);
                }
            }
        }
        markdownWriter.append((CharSequence) link.getUrlClosingMarker());
        if (link.getTitleOpeningMarker().isNotNull()) {
            markdownWriter.append(' ');
            markdownWriter.append((CharSequence) link.getTitleOpeningMarker());
            if (link.getTitle().isNotNull()) {
                markdownWriter.appendTranslating(link.getTitle());
            }
            markdownWriter.append((CharSequence) link.getTitleClosingMarker());
        }
        markdownWriter.append((CharSequence) link.getLinkClosingMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(ImageRef imageRef, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (this.formatterOptions.optimizedInlineRendering && !nodeFormatterContext.isTransformingText()) {
            markdownWriter.append((CharSequence) imageRef.getChars());
            return;
        }
        if (!nodeFormatterContext.isTransformingText() && this.formatterOptions.rightMargin != 0) {
            if (imageRef.isReferenceTextCombined()) {
                markdownWriter.append((CharSequence) imageRef.getReferenceOpeningMarker());
                if (imageRef.isOrDescendantOfType(Paragraph.class)) {
                    markdownWriter.append((CharSequence) imageRef.getReference().toMapped(SpaceMapper.toNonBreakSpace));
                } else {
                    markdownWriter.append((CharSequence) imageRef.getReference());
                }
                markdownWriter.append((CharSequence) imageRef.getReferenceClosingMarker());
                markdownWriter.append((CharSequence) imageRef.getTextOpeningMarker());
                markdownWriter.append((CharSequence) imageRef.getTextClosingMarker());
                return;
            }
            markdownWriter.append((CharSequence) imageRef.getTextOpeningMarker());
            nodeFormatterContext.renderChildren(imageRef);
            markdownWriter.append((CharSequence) imageRef.getTextClosingMarker());
            markdownWriter.append((CharSequence) imageRef.getReferenceOpeningMarker());
            markdownWriter.append((CharSequence) imageRef.getReference());
            markdownWriter.append((CharSequence) imageRef.getReferenceClosingMarker());
            return;
        }
        if (imageRef.isReferenceTextCombined()) {
            markdownWriter.append((CharSequence) imageRef.getReferenceOpeningMarker());
            markdownWriter.appendTranslating(imageRef.getReference());
            markdownWriter.append((CharSequence) imageRef.getReferenceClosingMarker());
            markdownWriter.append((CharSequence) imageRef.getTextOpeningMarker());
            markdownWriter.append((CharSequence) imageRef.getTextClosingMarker());
            return;
        }
        markdownWriter.append((CharSequence) imageRef.getTextOpeningMarker());
        appendReference(imageRef.getText(), nodeFormatterContext, markdownWriter);
        markdownWriter.append((CharSequence) imageRef.getTextClosingMarker());
        markdownWriter.append((CharSequence) imageRef.getReferenceOpeningMarker());
        markdownWriter.appendTranslating(imageRef.getReference());
        markdownWriter.append((CharSequence) imageRef.getReferenceClosingMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(LinkRef linkRef, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (this.formatterOptions.optimizedInlineRendering && !nodeFormatterContext.isTransformingText()) {
            markdownWriter.append((CharSequence) linkRef.getChars());
            return;
        }
        if (!nodeFormatterContext.isTransformingText() && this.formatterOptions.rightMargin != 0) {
            if (linkRef.isReferenceTextCombined()) {
                markdownWriter.append((CharSequence) linkRef.getReferenceOpeningMarker());
                if (linkRef.isOrDescendantOfType(Paragraph.class)) {
                    markdownWriter.append((CharSequence) linkRef.getReference().toMapped(SpaceMapper.toNonBreakSpace));
                } else {
                    markdownWriter.append((CharSequence) linkRef.getReference());
                }
                markdownWriter.append((CharSequence) linkRef.getReferenceClosingMarker());
                markdownWriter.append((CharSequence) linkRef.getTextOpeningMarker());
                markdownWriter.append((CharSequence) linkRef.getTextClosingMarker());
                return;
            }
            markdownWriter.append((CharSequence) linkRef.getTextOpeningMarker());
            nodeFormatterContext.renderChildren(linkRef);
            markdownWriter.append((CharSequence) linkRef.getTextClosingMarker());
            markdownWriter.append((CharSequence) linkRef.getReferenceOpeningMarker());
            markdownWriter.append((CharSequence) linkRef.getReference());
            markdownWriter.append((CharSequence) linkRef.getReferenceClosingMarker());
            return;
        }
        if (linkRef.isReferenceTextCombined()) {
            markdownWriter.append((CharSequence) linkRef.getReferenceOpeningMarker());
            FormatterUtils.appendWhiteSpaceBetween(markdownWriter, linkRef.getReferenceOpeningMarker(), linkRef.getReference(), true, false, false);
            appendReference(linkRef.getReference(), nodeFormatterContext, markdownWriter);
            markdownWriter.append((CharSequence) linkRef.getReferenceClosingMarker());
            markdownWriter.append((CharSequence) linkRef.getTextOpeningMarker());
            markdownWriter.append((CharSequence) linkRef.getTextClosingMarker());
            return;
        }
        markdownWriter.append((CharSequence) linkRef.getTextOpeningMarker());
        if (nodeFormatterContext.isTransformingText() && linkRef.getFirstChildAny(HtmlInline.class) == null) {
            appendReference(linkRef.getText(), nodeFormatterContext, markdownWriter);
        } else {
            nodeFormatterContext.renderChildren(linkRef);
        }
        markdownWriter.append((CharSequence) linkRef.getTextClosingMarker());
        markdownWriter.append((CharSequence) linkRef.getReferenceOpeningMarker());
        FormatterUtils.appendWhiteSpaceBetween(markdownWriter, linkRef.getReferenceOpeningMarker(), linkRef.getReference(), true, false, false);
        markdownWriter.appendTranslating(linkRef.getReference());
        markdownWriter.append((CharSequence) linkRef.getReferenceClosingMarker());
    }
}
