package com.vladsch.flexmark.html.renderer;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.net.MailTo;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.scsp.common.Header;
import com.vladsch.flexmark.ast.AutoLink;
import com.vladsch.flexmark.ast.BlockQuote;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.BulletListItem;
import com.vladsch.flexmark.ast.Code;
import com.vladsch.flexmark.ast.CodeBlock;
import com.vladsch.flexmark.ast.Emphasis;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.HardLineBreak;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.HtmlBlock;
import com.vladsch.flexmark.ast.HtmlBlockBase;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.ast.HtmlInline;
import com.vladsch.flexmark.ast.HtmlInlineBase;
import com.vladsch.flexmark.ast.HtmlInlineComment;
import com.vladsch.flexmark.ast.HtmlInnerBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.ast.ImageRef;
import com.vladsch.flexmark.ast.IndentedCodeBlock;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.LinkRef;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.MailLink;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.OrderedListItem;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.ParagraphItemContainer;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.ast.StrongEmphasis;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.TextBase;
import com.vladsch.flexmark.ast.ThematicBreak;
import com.vladsch.flexmark.ast.util.LineCollectingVisitor;
import com.vladsch.flexmark.ast.util.ReferenceRepository;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html.HtmlRendererOptions;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NonRenderingInline;
import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.html.Attribute;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.Range;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;
import p001A.AbstractC0000a;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CoreNodeRenderer implements NodeRenderer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean codeContentBlock;
    private final boolean codeSoftLineBreaks;
    private final ListOptions listOptions;
    private final boolean obfuscateEmail;
    private final boolean obfuscateEmailRandom;
    private final boolean recheckUndefinedReferences;
    private final ReferenceRepository referenceRepository;
    public static final AttributablePart LOOSE_LIST_ITEM = new AttributablePart("LOOSE_LIST_ITEM");
    public static final AttributablePart TIGHT_LIST_ITEM = new AttributablePart("TIGHT_LIST_ITEM");
    public static final AttributablePart PARAGRAPH_LINE = new AttributablePart("PARAGRAPH_LINE");
    public static final AttributablePart CODE_CONTENT = new AttributablePart("FENCED_CODE_CONTENT");
    private List<Range> myLines = null;
    private List<Integer> myEOLs = null;
    private int myNextLine = 0;
    private int nextLineStartOffset = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeRendererFactory {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.renderer.NodeRendererFactory, java.util.function.Function
        @NotNull
        public NodeRenderer apply(@NotNull DataHolder dataHolder) {
            return new CoreNodeRenderer(dataHolder);
        }
    }

    public CoreNodeRenderer(DataHolder dataHolder) {
        this.referenceRepository = Parser.REFERENCES.get(dataHolder);
        this.recheckUndefinedReferences = HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(dataHolder).booleanValue();
        this.listOptions = ListOptions.get(dataHolder);
        this.obfuscateEmail = HtmlRenderer.OBFUSCATE_EMAIL.get(dataHolder).booleanValue();
        this.obfuscateEmailRandom = HtmlRenderer.OBFUSCATE_EMAIL_RANDOM.get(dataHolder).booleanValue();
        this.codeContentBlock = Parser.FENCED_CODE_CONTENT_BLOCK.get(dataHolder).booleanValue();
        this.codeSoftLineBreaks = Parser.CODE_SOFT_LINE_BREAKS.get(dataHolder).booleanValue();
    }

    public static boolean isSuppressedLinkPrefix(CharSequence charSequence, NodeRendererContext nodeRendererContext) {
        Pattern pattern = nodeRendererContext.getHtmlOptions().suppressedLinks;
        if (pattern != null) {
            return pattern.matcher(charSequence).matches();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$render$0(HtmlWriter htmlWriter, Heading heading, NodeRendererContext nodeRendererContext) {
        htmlWriter.srcPos(heading.getText()).withAttr().tag("span");
        nodeRendererContext.renderChildren(heading);
        htmlWriter.tag("/span");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$renderListItem$5(HtmlWriter htmlWriter, ListItem listItem, NodeRendererContext nodeRendererContext) {
        htmlWriter.text((CharSequence) listItem.getMarkerSuffix().unescape());
        nodeRendererContext.renderChildren(listItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$renderListItem$6(HtmlWriter htmlWriter, ListItem listItem, NodeRendererContext nodeRendererContext) {
        htmlWriter.text((CharSequence) listItem.getMarkerSuffix().unescape());
        nodeRendererContext.renderChildren(listItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderLooseParagraph$8(Paragraph paragraph, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderTextBlockParagraphLines(paragraph, nodeRendererContext, htmlWriter, false);
    }

    private void outputNextLineBreakSpan(Node node, HtmlWriter htmlWriter, boolean z) {
        Range range = this.myLines.get(this.myNextLine);
        int iIntValue = this.myEOLs.get(this.myNextLine).intValue();
        this.myNextLine++;
        BasedSequence basedSequenceBaseSubSequence = node.baseSubSequence(this.nextLineStartOffset, range.getEnd() - iIntValue);
        CharPredicate charPredicate = CharPredicate.SPACE_TAB;
        int iCountTrailing = basedSequenceBaseSubSequence.countTrailing(charPredicate);
        if (!z && iCountTrailing > 0) {
            iCountTrailing--;
        }
        htmlWriter.srcPos(this.nextLineStartOffset, range.getEnd() - (iIntValue + iCountTrailing)).withAttr(PARAGRAPH_LINE).tag("span");
        int end = range.getEnd();
        this.nextLineStartOffset = end;
        this.nextLineStartOffset = node.baseSubSequence(end, node.getChars().getBaseSequence().length()).countLeading(charPredicate) + end;
    }

    private void outputSourceLineSpan(Node node, Node node2, Node node3, HtmlWriter htmlWriter) {
        int startOffset = node2.getStartOffset();
        Range range = this.myLines.get(this.myNextLine);
        int iIntValue = this.myEOLs.get(this.myNextLine).intValue();
        int endOffset = node3.getEndOffset();
        if (range.getEnd() <= endOffset) {
            int end = range.getEnd() - iIntValue;
            BasedSequence basedSequenceBaseSubSequence = node.baseSubSequence(startOffset, end);
            CharPredicate charPredicate = CharPredicate.SPACE_TAB;
            endOffset = end - basedSequenceBaseSubSequence.countTrailing(charPredicate);
            this.myNextLine++;
            int end2 = range.getEnd();
            this.nextLineStartOffset = end2;
            this.nextLineStartOffset = node.baseSubSequence(end2, node.getEndOffset()).countLeading(charPredicate) + end2;
        }
        if (range.getStart() > startOffset) {
            startOffset = range.getStart();
        }
        htmlWriter.srcPos(startOffset, endOffset).withAttr(PARAGRAPH_LINE).tag("span");
    }

    private void renderChildrenSourceLineWrapped(Node node, BasedSequence basedSequence, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (!nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines || basedSequence.indexOfAny(CharPredicate.ANY_EOL) < 0) {
            nodeRendererContext.renderChildren(node);
            return;
        }
        int i = this.myNextLine;
        if (i > 0) {
            this.myNextLine = i - 1;
        }
        outputSourceLineSpan(node, node, node, htmlWriter);
        nodeRendererContext.renderChildren(node);
        htmlWriter.tag("/span");
    }

    public static void renderHtmlBlock(HtmlBlockBase htmlBlockBase, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter, boolean z, boolean z2, boolean z3) {
        if (z) {
            return;
        }
        boolean z4 = htmlBlockBase instanceof HtmlBlock;
        if (z4) {
            htmlWriter.line();
        }
        String strNormalizeEOL = (z4 ? htmlBlockBase.getContentChars() : htmlBlockBase.getChars()).normalizeEOL();
        if (z3) {
            strNormalizeEOL = strNormalizeEOL.trim();
        }
        if (!z2) {
            htmlWriter.rawPre((CharSequence) strNormalizeEOL);
        } else if (z4) {
            if (strNormalizeEOL.length() > 0 && AbstractC0000a.m4a(1, strNormalizeEOL) == '\n') {
                strNormalizeEOL = AbstractC2322a.m1614d(1, 0, strNormalizeEOL);
            }
            htmlWriter.raw("<p>").text((CharSequence) strNormalizeEOL).raw((CharSequence) "</p>");
        } else {
            htmlWriter.text((CharSequence) strNormalizeEOL);
        }
        if (z4) {
            htmlWriter.lineIf(nodeRendererContext.getHtmlOptions().htmlBlockCloseTagEol);
        }
    }

    public static void renderInlineHtml(HtmlInlineBase htmlInlineBase, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter, boolean z, boolean z2) {
        if (z) {
            return;
        }
        if (z2) {
            htmlWriter.text((CharSequence) htmlInlineBase.getChars().normalizeEOL());
        } else {
            htmlWriter.rawPre((CharSequence) htmlInlineBase.getChars().normalizeEOL());
        }
    }

    private boolean renderLineBreak(String str, String str2, Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        List<Range> list = this.myLines;
        if (list == null || this.myNextLine >= list.size()) {
            return false;
        }
        List<String> openTagsAfterLast = htmlWriter.getOpenTagsAfterLast("span");
        int size = openTagsAfterLast.size();
        boolean z = size == 0 || str2 == null || !str2.equalsIgnoreCase(openTagsAfterLast.get(size + (-1)));
        if (!z && !htmlWriter.isPendingSpace()) {
            htmlWriter.raw(" ");
        }
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                break;
            }
            htmlWriter.closeTag((CharSequence) openTagsAfterLast.get(i));
            size = i;
        }
        htmlWriter.tag("/span");
        if (z) {
            htmlWriter.raw((CharSequence) str);
        }
        outputNextLineBreakSpan(node, htmlWriter, z);
        for (String str3 : openTagsAfterLast) {
            if (z || nodeRendererContext.getHtmlOptions().inlineCodeSpliceClass == null || nodeRendererContext.getHtmlOptions().inlineCodeSpliceClass.isEmpty()) {
                htmlWriter.tag((CharSequence) str3);
            } else {
                htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) nodeRendererContext.getHtmlOptions().inlineCodeSpliceClass).withAttr().tag((CharSequence) str3);
            }
        }
        return true;
    }

    private void renderListItem(final ListItem listItem, final NodeRendererContext nodeRendererContext, final HtmlWriter htmlWriter) {
        if (this.listOptions.isTightListItem(listItem)) {
            final int i = 0;
            htmlWriter.srcPosWithEOL(listItem.getChars()).withAttr(TIGHT_LIST_ITEM).withCondIndent().tagLine((CharSequence) "li", new Runnable() { // from class: com.vladsch.flexmark.html.renderer.b
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            CoreNodeRenderer.lambda$renderListItem$5(htmlWriter, listItem, nodeRendererContext);
                            break;
                        default:
                            CoreNodeRenderer.lambda$renderListItem$6(htmlWriter, listItem, nodeRendererContext);
                            break;
                    }
                }
            });
        } else {
            final int i2 = 1;
            htmlWriter.srcPosWithEOL(listItem.getChars()).withAttr(LOOSE_LIST_ITEM).withCondIndent().tagLine((CharSequence) "li", new Runnable() { // from class: com.vladsch.flexmark.html.renderer.b
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            CoreNodeRenderer.lambda$renderListItem$5(htmlWriter, listItem, nodeRendererContext);
                            break;
                        default:
                            CoreNodeRenderer.lambda$renderListItem$6(htmlWriter, listItem, nodeRendererContext);
                            break;
                    }
                }
            });
        }
    }

    private void renderLooseParagraph(Paragraph paragraph, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (!nodeRendererContext.getHtmlOptions().noPTagsUseBr) {
            htmlWriter.srcPosWithEOL(paragraph.getChars()).withAttr().tagLine("p", (Runnable) new RunnableC0218a(24, this, paragraph, nodeRendererContext, htmlWriter));
        } else {
            renderTextBlockParagraphLines(paragraph, nodeRendererContext, htmlWriter, false);
            htmlWriter.tagVoid(Header.f8126BR).tagVoid((CharSequence) Header.f8126BR).line();
        }
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderer
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        final int i = 29;
        final int i2 = 7;
        final int i4 = 18;
        final int i5 = 22;
        final int i6 = 23;
        final int i7 = 24;
        final int i8 = 25;
        final int i9 = 26;
        final int i10 = 27;
        final int i11 = 28;
        final int i12 = 0;
        final int i13 = 1;
        final int i14 = 2;
        final int i15 = 0;
        final int i16 = 1;
        final int i17 = 2;
        final int i18 = 3;
        final int i19 = 4;
        final int i20 = 5;
        final int i21 = 6;
        final int i22 = 8;
        final int i23 = 9;
        final int i24 = 10;
        final int i25 = 11;
        final int i26 = 12;
        final int i27 = 13;
        final int i28 = 14;
        final int i29 = 15;
        final int i30 = 16;
        final int i31 = 17;
        final int i32 = 19;
        final int i33 = 20;
        final int i34 = 21;
        return new HashSet(Arrays.asList(new NodeRenderingHandler(AutoLink.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(BlockQuote.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i2) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(BulletList.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i4) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Code.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i5) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(CodeBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i6) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Document.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i7) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Emphasis.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i8) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(FencedCodeBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i9) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HardLineBreak.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i10) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Heading.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i11) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HtmlBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8357b;

            {
                this.f8357b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i12) {
                    case 0:
                        this.f8357b.render((HtmlBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8357b.render((HtmlCommentBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8357b.render((HtmlInnerBlock) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HtmlCommentBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8357b;

            {
                this.f8357b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i13) {
                    case 0:
                        this.f8357b.render((HtmlBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8357b.render((HtmlCommentBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8357b.render((HtmlInnerBlock) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HtmlInnerBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8357b;

            {
                this.f8357b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i14) {
                    case 0:
                        this.f8357b.render((HtmlBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8357b.render((HtmlCommentBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8357b.render((HtmlInnerBlock) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HtmlInnerBlockComment.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i15) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HtmlEntity.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i16) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HtmlInline.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i17) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(HtmlInlineComment.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i18) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Image.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i19) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(ImageRef.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i20) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(IndentedCodeBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i21) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Link.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i22) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(LinkRef.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i23) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(BulletListItem.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i24) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(OrderedListItem.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i25) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(MailLink.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i26) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(OrderedList.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i27) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Paragraph.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i28) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Reference.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i29) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(SoftLineBreak.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i30) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(StrongEmphasis.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i31) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(Text.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i32) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(TextBase.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i33) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }), new NodeRenderingHandler(ThematicBreak.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.html.renderer.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CoreNodeRenderer f8351b;

            {
                this.f8351b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i34) {
                    case 0:
                        this.f8351b.render((HtmlInnerBlockComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8351b.render((HtmlEntity) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8351b.render((HtmlInline) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8351b.render((HtmlInlineComment) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8351b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8351b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 6:
                        this.f8351b.render((IndentedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 7:
                        this.f8351b.render((BlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 8:
                        this.f8351b.render((Link) node, nodeRendererContext, htmlWriter);
                        break;
                    case 9:
                        this.f8351b.render((LinkRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 10:
                        this.f8351b.render((BulletListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 11:
                        this.f8351b.render((OrderedListItem) node, nodeRendererContext, htmlWriter);
                        break;
                    case 12:
                        this.f8351b.render((MailLink) node, nodeRendererContext, htmlWriter);
                        break;
                    case 13:
                        this.f8351b.render((OrderedList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 14:
                        this.f8351b.render((Paragraph) node, nodeRendererContext, htmlWriter);
                        break;
                    case 15:
                        this.f8351b.render((Reference) node, nodeRendererContext, htmlWriter);
                        break;
                    case 16:
                        this.f8351b.render((SoftLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 17:
                        this.f8351b.render((StrongEmphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 18:
                        this.f8351b.render((BulletList) node, nodeRendererContext, htmlWriter);
                        break;
                    case 19:
                        this.f8351b.render((Text) node, nodeRendererContext, htmlWriter);
                        break;
                    case 20:
                        this.f8351b.render((TextBase) node, nodeRendererContext, htmlWriter);
                        break;
                    case 21:
                        this.f8351b.render((ThematicBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 22:
                        this.f8351b.render((Code) node, nodeRendererContext, htmlWriter);
                        break;
                    case 23:
                        this.f8351b.render((CodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 24:
                        this.f8351b.render((Document) node, nodeRendererContext, htmlWriter);
                        break;
                    case 25:
                        this.f8351b.render((Emphasis) node, nodeRendererContext, htmlWriter);
                        break;
                    case 26:
                        this.f8351b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    case 27:
                        this.f8351b.render((HardLineBreak) node, nodeRendererContext, htmlWriter);
                        break;
                    case 28:
                        this.f8351b.render((Heading) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8351b.render((AutoLink) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        })));
    }

    public void render(Reference reference, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
    }

    public void renderTextBlockParagraphLines(Paragraph paragraph, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter, boolean z) {
        if (!nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines || !paragraph.hasChildren()) {
            if (z) {
                htmlWriter.withAttr().tag("span", false, false, (Runnable) new RunnableC10960a(nodeRendererContext, paragraph, 15));
                return;
            } else {
                nodeRendererContext.renderChildren(paragraph);
                return;
            }
        }
        LineCollectingVisitor lineCollectingVisitor = new LineCollectingVisitor();
        this.myLines = lineCollectingVisitor.collectAndGetRanges(paragraph);
        this.myEOLs = lineCollectingVisitor.getEOLs();
        this.myNextLine = 0;
        if (paragraph.getFirstChild() != null) {
            outputSourceLineSpan(paragraph, paragraph.getFirstChild(), paragraph, htmlWriter);
        }
        nodeRendererContext.renderChildren(paragraph);
        htmlWriter.tag("/span");
    }

    public void render(Document document, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        nodeRendererContext.renderChildren(document);
    }

    public void render(Heading heading, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        String nodeId;
        if (nodeRendererContext.getHtmlOptions().renderHeaderId && (nodeId = nodeRendererContext.getNodeId(heading)) != null && nodeId.length() > 0) {
            htmlWriter.attr("id", (CharSequence) nodeId);
        }
        if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
            htmlWriter.srcPos(heading.getChars()).withAttr().tagLine((CharSequence) AbstractC0000a.m11h(heading.getLevel(), "h"), (Runnable) new RunnableC8928b(htmlWriter, 24, heading, nodeRendererContext));
        } else {
            htmlWriter.srcPos(heading.getText()).withAttr().tagLine((CharSequence) AbstractC0000a.m11h(heading.getLevel(), "h"), (Runnable) new RunnableC10960a(nodeRendererContext, heading, 19));
        }
    }

    public void render(BlockQuote blockQuote, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().tagLineIndent("blockquote", (Runnable) new RunnableC10960a(nodeRendererContext, blockQuote, 18));
    }

    public void render(FencedCodeBlock fencedCodeBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.line();
        htmlWriter.srcPosWithTrailingEOL(fencedCodeBlock.getChars()).withAttr().tag("pre").openPre();
        BasedSequence info = fencedCodeBlock.getInfo();
        HtmlRendererOptions htmlOptions = nodeRendererContext.getHtmlOptions();
        if (info.isNotNull() && !info.isBlank()) {
            String strUnescape = fencedCodeBlock.getInfoDelimitedByAny(htmlOptions.languageDelimiterSet).unescape();
            htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) htmlOptions.languageClassMap.getOrDefault(strUnescape, htmlOptions.languageClassPrefix + strUnescape));
        } else {
            String strTrim = htmlOptions.noLanguageClass.trim();
            if (!strTrim.isEmpty()) {
                htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) strTrim);
            }
        }
        htmlWriter.srcPosWithEOL(fencedCodeBlock.getContentChars()).withAttr(CODE_CONTENT).tag("code");
        if (this.codeContentBlock) {
            nodeRendererContext.renderChildren(fencedCodeBlock);
        } else {
            htmlWriter.text(fencedCodeBlock.getContentChars().normalizeEOL());
        }
        htmlWriter.tag("/code");
        ((HtmlWriter) htmlWriter.tag("/pre")).closePre();
        htmlWriter.lineIf(htmlOptions.htmlBlockCloseTagEol);
    }

    public void render(ThematicBreak thematicBreak, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.srcPos(thematicBreak.getChars()).withAttr().tagVoidLine("hr");
    }

    public void render(IndentedCodeBlock indentedCodeBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.line();
        htmlWriter.srcPosWithEOL(indentedCodeBlock.getChars()).withAttr().tag("pre").openPre();
        String strTrim = nodeRendererContext.getHtmlOptions().noLanguageClass.trim();
        if (!strTrim.isEmpty()) {
            htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) strTrim);
        }
        htmlWriter.srcPosWithEOL(indentedCodeBlock.getContentChars()).withAttr(CODE_CONTENT).tag("code");
        if (this.codeContentBlock) {
            nodeRendererContext.renderChildren(indentedCodeBlock);
        } else {
            htmlWriter.text(indentedCodeBlock.getContentChars().trimTailBlankLines().normalizeEndWithEOL());
        }
        htmlWriter.tag("/code");
        ((HtmlWriter) htmlWriter.tag("/pre")).closePre();
        htmlWriter.lineIf(nodeRendererContext.getHtmlOptions().htmlBlockCloseTagEol);
    }

    public void render(CodeBlock codeBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (codeBlock.getParent() instanceof IndentedCodeBlock) {
            htmlWriter.text((CharSequence) codeBlock.getContentChars().trimTailBlankLines().normalizeEndWithEOL());
        } else {
            htmlWriter.text((CharSequence) codeBlock.getContentChars().normalizeEOL());
        }
    }

    public void render(BulletList bulletList, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().tagIndent("ul", (Runnable) new RunnableC10960a(nodeRendererContext, bulletList, 17));
    }

    public void render(OrderedList orderedList, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        int startNumber = orderedList.getStartNumber();
        if (this.listOptions.isOrderedListManualStart() && startNumber != 1) {
            htmlWriter.attr("start", (CharSequence) String.valueOf(startNumber));
        }
        htmlWriter.withAttr().tagIndent("ol", (Runnable) new RunnableC10960a(nodeRendererContext, orderedList, 14));
    }

    public void render(BulletListItem bulletListItem, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderListItem(bulletListItem, nodeRendererContext, htmlWriter);
    }

    public void render(OrderedListItem orderedListItem, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderListItem(orderedListItem, nodeRendererContext, htmlWriter);
    }

    public void render(Paragraph paragraph, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (paragraph.getFirstChildAnyNot(NonRenderingInline.class) != null) {
            if ((paragraph.getParent() instanceof ParagraphItemContainer) && ((ParagraphItemContainer) paragraph.getParent()).isParagraphWrappingDisabled(paragraph, this.listOptions, nodeRendererContext.getOptions())) {
                renderTextBlockParagraphLines(paragraph, nodeRendererContext, htmlWriter, false);
            } else {
                renderLooseParagraph(paragraph, nodeRendererContext, htmlWriter);
            }
        }
    }

    public void render(SoftLineBreak softLineBreak, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        HtmlWriter htmlWriter2;
        String str = nodeRendererContext.getHtmlOptions().softBreak;
        if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
            htmlWriter2 = htmlWriter;
            if (renderLineBreak(str, (str.equals("\n") || str.equals("\r\n") || str.equals(StringUtils.f9761CR)) ? "code" : null, softLineBreak, nodeRendererContext, htmlWriter2)) {
                return;
            }
        } else {
            htmlWriter2 = htmlWriter;
        }
        htmlWriter2.raw((CharSequence) str);
    }

    public void render(HardLineBreak hardLineBreak, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        NodeRendererContext nodeRendererContext2;
        HtmlWriter htmlWriter2;
        if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
            nodeRendererContext2 = nodeRendererContext;
            htmlWriter2 = htmlWriter;
            if (renderLineBreak(nodeRendererContext.getHtmlOptions().hardBreak, null, hardLineBreak, nodeRendererContext2, htmlWriter2)) {
                return;
            }
        } else {
            nodeRendererContext2 = nodeRendererContext;
            htmlWriter2 = htmlWriter;
        }
        htmlWriter2.raw((CharSequence) nodeRendererContext2.getHtmlOptions().hardBreak);
    }

    public void render(Emphasis emphasis, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        HtmlRendererOptions htmlOptions = nodeRendererContext.getHtmlOptions();
        String str = htmlOptions.emphasisStyleHtmlOpen;
        if (str != null && htmlOptions.emphasisStyleHtmlClose != null) {
            htmlWriter.raw((CharSequence) str);
            nodeRendererContext.renderChildren(emphasis);
            htmlWriter.raw((CharSequence) htmlOptions.emphasisStyleHtmlClose);
        } else {
            if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
                htmlWriter.withAttr().tag("em");
            } else {
                htmlWriter.srcPos(emphasis.getText()).withAttr().tag("em");
            }
            nodeRendererContext.renderChildren(emphasis);
            htmlWriter.tag("/em");
        }
    }

    public void render(StrongEmphasis strongEmphasis, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        HtmlRendererOptions htmlOptions = nodeRendererContext.getHtmlOptions();
        String str = htmlOptions.strongEmphasisStyleHtmlOpen;
        if (str != null && htmlOptions.strongEmphasisStyleHtmlClose != null) {
            htmlWriter.raw((CharSequence) str);
            nodeRendererContext.renderChildren(strongEmphasis);
            htmlWriter.raw((CharSequence) htmlOptions.strongEmphasisStyleHtmlClose);
        } else {
            if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
                htmlWriter.withAttr().tag("strong");
            } else {
                htmlWriter.srcPos(strongEmphasis.getText()).withAttr().tag("strong");
            }
            nodeRendererContext.renderChildren(strongEmphasis);
            htmlWriter.tag("/strong");
        }
    }

    public void render(Text text, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.text((CharSequence) Escaping.normalizeEOL(text.getChars().unescape()));
    }

    public void render(TextBase textBase, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        nodeRendererContext.renderChildren(textBase);
    }

    public void render(Code code, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        HtmlRendererOptions htmlOptions = nodeRendererContext.getHtmlOptions();
        String str = htmlOptions.codeStyleHtmlOpen;
        if (str != null && htmlOptions.codeStyleHtmlClose != null) {
            htmlWriter.raw((CharSequence) str);
            if (this.codeSoftLineBreaks && !htmlOptions.isSoftBreakAllSpaces) {
                ReversiblePeekingIterator<Node> it = code.getChildren().iterator();
                while (it.hasNext()) {
                    Node next = it.next();
                    if (next instanceof Text) {
                        htmlWriter.text((CharSequence) Escaping.collapseWhitespace((CharSequence) next.getChars(), true));
                    } else {
                        nodeRendererContext.render(next);
                    }
                }
            } else {
                htmlWriter.text((CharSequence) Escaping.collapseWhitespace((CharSequence) code.getText(), true));
            }
            htmlWriter.raw((CharSequence) htmlOptions.codeStyleHtmlClose);
            return;
        }
        if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
            htmlWriter.withAttr().tag("code");
        } else {
            htmlWriter.srcPos(code.getText()).withAttr().tag("code");
        }
        if (this.codeSoftLineBreaks && !htmlOptions.isSoftBreakAllSpaces) {
            ReversiblePeekingIterator<Node> it2 = code.getChildren().iterator();
            while (it2.hasNext()) {
                Node next2 = it2.next();
                if (next2 instanceof Text) {
                    htmlWriter.text((CharSequence) Escaping.collapseWhitespace((CharSequence) next2.getChars(), true));
                } else {
                    nodeRendererContext.render(next2);
                }
            }
        } else {
            htmlWriter.text((CharSequence) Escaping.collapseWhitespace((CharSequence) code.getText(), true));
        }
        htmlWriter.tag("/code");
    }

    public void render(HtmlBlock htmlBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        HtmlWriter htmlWriter2;
        htmlWriter.line();
        HtmlRendererOptions htmlOptions = nodeRendererContext.getHtmlOptions();
        if (htmlOptions.sourceWrapHtmlBlocks) {
            htmlWriter.srcPos(htmlBlock.getChars()).withAttr(AttributablePart.NODE_POSITION).tag("div").indent().line();
        }
        if (htmlBlock.hasChildren()) {
            nodeRendererContext.renderChildren(htmlBlock);
            htmlWriter2 = htmlWriter;
        } else {
            htmlWriter2 = htmlWriter;
            renderHtmlBlock(htmlBlock, nodeRendererContext, htmlWriter2, htmlOptions.suppressHtmlBlocks, htmlOptions.escapeHtmlBlocks, false);
        }
        if (htmlOptions.sourceWrapHtmlBlocks) {
            htmlWriter2.unIndent().tag((CharSequence) "/div");
        }
        htmlWriter2.lineIf(htmlOptions.htmlBlockCloseTagEol);
    }

    public void render(HtmlCommentBlock htmlCommentBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderHtmlBlock(htmlCommentBlock, nodeRendererContext, htmlWriter, nodeRendererContext.getHtmlOptions().suppressHtmlCommentBlocks, nodeRendererContext.getHtmlOptions().escapeHtmlCommentBlocks, false);
    }

    public void render(HtmlInnerBlock htmlInnerBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderHtmlBlock(htmlInnerBlock, nodeRendererContext, htmlWriter, nodeRendererContext.getHtmlOptions().suppressHtmlBlocks, nodeRendererContext.getHtmlOptions().escapeHtmlBlocks, false);
    }

    public void render(HtmlInnerBlockComment htmlInnerBlockComment, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderHtmlBlock(htmlInnerBlockComment, nodeRendererContext, htmlWriter, nodeRendererContext.getHtmlOptions().suppressHtmlCommentBlocks, nodeRendererContext.getHtmlOptions().escapeHtmlCommentBlocks, false);
    }

    public void render(HtmlInline htmlInline, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderInlineHtml(htmlInline, nodeRendererContext, htmlWriter, nodeRendererContext.getHtmlOptions().suppressInlineHtml, nodeRendererContext.getHtmlOptions().escapeInlineHtml);
    }

    public void render(HtmlInlineComment htmlInlineComment, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        renderInlineHtml(htmlInlineComment, nodeRendererContext, htmlWriter, nodeRendererContext.getHtmlOptions().suppressInlineHtmlComments, nodeRendererContext.getHtmlOptions().escapeInlineHtmlComments);
    }

    public void render(HtmlEntity htmlEntity, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (nodeRendererContext.getHtmlOptions().unescapeHtmlEntities) {
            htmlWriter.text((CharSequence) htmlEntity.getChars().unescape());
        } else {
            htmlWriter.raw((CharSequence) htmlEntity.getChars().unescapeNoEntities());
        }
    }

    public void render(AutoLink autoLink, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        String url;
        String string = autoLink.getText().toString();
        if (!nodeRendererContext.isDoNotRenderLinks() && !isSuppressedLinkPrefix(autoLink.getUrl(), nodeRendererContext)) {
            ResolvedLink resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.LINK, string, null);
            HtmlWriter htmlWriterSrcPos = htmlWriter.srcPos(autoLink.getText());
            if (resolvedLinkResolveLink.getUrl().startsWith("www.")) {
                url = AbstractC0541b.m756B(nodeRendererContext.getHtmlOptions().autolinkWwwPrefix, resolvedLinkResolveLink.getUrl());
            } else {
                url = resolvedLinkResolveLink.getUrl();
            }
            htmlWriterSrcPos.attr("href", (CharSequence) url).withAttr(resolvedLinkResolveLink).tag((CharSequence) "a", false, false, (Runnable) new RunnableC10960a(htmlWriter, string, 16));
            return;
        }
        htmlWriter.text((CharSequence) string);
    }

    public void render(MailLink mailLink, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        String strUnescape = mailLink.getText().unescape();
        if (!nodeRendererContext.isDoNotRenderLinks() && !isSuppressedLinkPrefix(mailLink.getUrl(), nodeRendererContext)) {
            ResolvedLink resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.LINK, strUnescape, null);
            if (this.obfuscateEmail) {
                htmlWriter.srcPos(mailLink.getText()).attr("href", (CharSequence) Escaping.obfuscate(AbstractC0541b.m772n(MailTo.MAILTO_SCHEME, resolvedLinkResolveLink.getUrl()), this.obfuscateEmailRandom)).withAttr(resolvedLinkResolveLink).tag((CharSequence) "a").raw((CharSequence) Escaping.obfuscate(strUnescape, true)).tag((CharSequence) "/a");
                return;
            } else {
                String url = resolvedLinkResolveLink.getUrl();
                htmlWriter.srcPos(mailLink.getText()).attr("href", (CharSequence) (MailTo.MAILTO_SCHEME + url)).withAttr(resolvedLinkResolveLink).tag((CharSequence) "a").text((CharSequence) strUnescape).tag((CharSequence) "/a");
                return;
            }
        }
        htmlWriter.text((CharSequence) strUnescape);
    }

    public void render(Image image, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (nodeRendererContext.isDoNotRenderLinks() || isSuppressedLinkPrefix(image.getUrl(), nodeRendererContext)) {
            return;
        }
        String strCollectAndGetText = new TextCollectingVisitor().collectAndGetText(image);
        ResolvedLink resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.IMAGE, image.getUrl().unescape(), null, null);
        String url = resolvedLinkResolveLink.getUrl();
        if (!image.getUrlContent().isEmpty()) {
            url = AbstractC0541b.m756B(url, Escaping.percentEncodeUrl(image.getUrlContent()).replace(Marker.ANY_NON_NULL_MARKER, "%2B").replace("%3D", MarketingConstants.REFERRER_DELIMITER_U003D).replace("%26", "&amp;"));
        }
        htmlWriter.attr("src", (CharSequence) url);
        htmlWriter.attr("alt", (CharSequence) strCollectAndGetText);
        if (image.getTitle().isNotNull()) {
            resolvedLinkResolveLink = resolvedLinkResolveLink.withTitle(image.getTitle().unescape());
        }
        htmlWriter.attr(resolvedLinkResolveLink.getNonNullAttributes());
        htmlWriter.srcPos(image.getChars()).withAttr(resolvedLinkResolveLink).tagVoid("img");
    }

    public void render(Link link, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (!nodeRendererContext.isDoNotRenderLinks() && !isSuppressedLinkPrefix(link.getUrl(), nodeRendererContext)) {
            ResolvedLink resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.LINK, link.getUrl().unescape(), null, null);
            htmlWriter.attr("href", (CharSequence) resolvedLinkResolveLink.getUrl());
            if (link.getTitle().isNotNull()) {
                resolvedLinkResolveLink = resolvedLinkResolveLink.withTitle(link.getTitle().unescape());
            }
            htmlWriter.attr(resolvedLinkResolveLink.getNonNullAttributes());
            htmlWriter.srcPos(link.getChars()).withAttr(resolvedLinkResolveLink).tag("a");
            renderChildrenSourceLineWrapped(link, link.getText(), nodeRendererContext, htmlWriter);
            htmlWriter.tag("/a");
            return;
        }
        nodeRendererContext.renderChildren(link);
    }

    public void render(ImageRef imageRef, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        Reference referenceNode;
        boolean zIsSuppressedLinkPrefix;
        if (!imageRef.isDefined() && this.recheckUndefinedReferences && imageRef.getReferenceNode(this.referenceRepository) != null) {
            imageRef.setDefined(true);
        }
        ResolvedLink resolvedLinkResolveLink = null;
        if (imageRef.isDefined()) {
            referenceNode = imageRef.getReferenceNode(this.referenceRepository);
            String strUnescape = referenceNode.getUrl().unescape();
            zIsSuppressedLinkPrefix = isSuppressedLinkPrefix(strUnescape, nodeRendererContext);
            resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.IMAGE, strUnescape, null, null);
            if (referenceNode.getTitle().isNotNull()) {
                resolvedLinkResolveLink = resolvedLinkResolveLink.withTitle(referenceNode.getTitle().unescape());
            }
        } else {
            ResolvedLink resolvedLinkResolveLink2 = nodeRendererContext.resolveLink(LinkType.IMAGE_REF, this.referenceRepository.normalizeKey(imageRef.getReference()), null, null);
            if (resolvedLinkResolveLink2.getStatus() == LinkStatus.UNKNOWN || resolvedLinkResolveLink2.getUrl().isEmpty()) {
                referenceNode = null;
            } else {
                resolvedLinkResolveLink = resolvedLinkResolveLink2;
                referenceNode = null;
            }
            zIsSuppressedLinkPrefix = false;
        }
        if (resolvedLinkResolveLink == null) {
            htmlWriter.text((CharSequence) imageRef.getChars().unescape());
            return;
        }
        if (nodeRendererContext.isDoNotRenderLinks() || zIsSuppressedLinkPrefix) {
            return;
        }
        String strCollectAndGetText = new TextCollectingVisitor().collectAndGetText(imageRef);
        Attributes nonNullAttributes = resolvedLinkResolveLink.getNonNullAttributes();
        htmlWriter.attr("src", (CharSequence) resolvedLinkResolveLink.getUrl());
        htmlWriter.attr("alt", (CharSequence) strCollectAndGetText);
        if (referenceNode != null) {
            nonNullAttributes = nodeRendererContext.extendRenderingNodeAttributes(referenceNode, AttributablePart.NODE, nonNullAttributes);
        }
        htmlWriter.attr(nonNullAttributes);
        htmlWriter.srcPos(imageRef.getChars()).withAttr(resolvedLinkResolveLink).tagVoid("img");
    }

    public void render(LinkRef linkRef, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        Reference referenceNode;
        boolean zIsSuppressedLinkPrefix;
        if (!linkRef.isDefined() && this.recheckUndefinedReferences && linkRef.getReferenceNode(this.referenceRepository) != null) {
            linkRef.setDefined(true);
        }
        ResolvedLink resolvedLinkResolveLink = null;
        if (linkRef.isDefined()) {
            referenceNode = linkRef.getReferenceNode(this.referenceRepository);
            String strUnescape = referenceNode.getUrl().unescape();
            zIsSuppressedLinkPrefix = isSuppressedLinkPrefix(strUnescape, nodeRendererContext);
            resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.LINK, strUnescape, null, null);
            if (referenceNode.getTitle().isNotNull()) {
                resolvedLinkResolveLink = resolvedLinkResolveLink.withTitle(referenceNode.getTitle().unescape());
            }
        } else {
            ResolvedLink resolvedLinkResolveLink2 = nodeRendererContext.resolveLink(LinkType.LINK_REF, linkRef.getReference().unescape(), null, null);
            if (resolvedLinkResolveLink2.getStatus() == LinkStatus.UNKNOWN || resolvedLinkResolveLink2.getUrl().isEmpty()) {
                referenceNode = null;
            } else {
                resolvedLinkResolveLink = resolvedLinkResolveLink2;
                referenceNode = null;
            }
            zIsSuppressedLinkPrefix = false;
        }
        if (resolvedLinkResolveLink == null) {
            if (!linkRef.hasChildren()) {
                htmlWriter.text((CharSequence) linkRef.getChars().unescape());
                return;
            }
            htmlWriter.text((CharSequence) linkRef.getChars().prefixOf(linkRef.getChildChars()).unescape());
            renderChildrenSourceLineWrapped(linkRef, linkRef.getText(), nodeRendererContext, htmlWriter);
            htmlWriter.text((CharSequence) linkRef.getChars().suffixOf(linkRef.getChildChars()).unescape());
            return;
        }
        if (!nodeRendererContext.isDoNotRenderLinks() && !zIsSuppressedLinkPrefix) {
            Attributes nonNullAttributes = resolvedLinkResolveLink.getNonNullAttributes();
            htmlWriter.attr("href", (CharSequence) resolvedLinkResolveLink.getUrl());
            if (referenceNode != null) {
                nonNullAttributes = nodeRendererContext.extendRenderingNodeAttributes(referenceNode, AttributablePart.NODE, nonNullAttributes);
            }
            htmlWriter.attr(nonNullAttributes);
            htmlWriter.srcPos(linkRef.getChars()).withAttr(resolvedLinkResolveLink).tag("a");
            renderChildrenSourceLineWrapped(linkRef, linkRef.getText(), nodeRendererContext, htmlWriter);
            htmlWriter.tag("/a");
            return;
        }
        nodeRendererContext.renderChildren(linkRef);
    }
}
