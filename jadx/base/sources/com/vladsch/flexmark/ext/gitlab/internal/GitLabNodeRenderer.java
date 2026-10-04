package com.vladsch.flexmark.ext.gitlab.internal;

import androidx.work.impl.RunnableC4054d;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Constants;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.ast.ImageRef;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.ast.util.ReferenceRepository;
import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
import com.vladsch.flexmark.ext.gitlab.GitLabDel;
import com.vladsch.flexmark.ext.gitlab.GitLabInlineMath;
import com.vladsch.flexmark.ext.gitlab.GitLabIns;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html.HtmlRendererOptions;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
import com.vladsch.flexmark.html.renderer.LinkStatus;
import com.vladsch.flexmark.html.renderer.LinkType;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.html.Attribute;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabNodeRenderer implements NodeRenderer {
    public static final AttributablePart VIDEO = new AttributablePart("VIDEO");
    public static final AttributablePart VIDEO_LINK = new AttributablePart("VIDEO_LINK");
    private final boolean codeContentBlock;
    final GitLabOptions options;
    private final boolean recheckUndefinedReferences;
    private final ReferenceRepository referenceRepository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeRendererFactory {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.renderer.NodeRendererFactory, java.util.function.Function
        @NotNull
        public NodeRenderer apply(@NotNull DataHolder dataHolder) {
            return new GitLabNodeRenderer(dataHolder);
        }
    }

    public GitLabNodeRenderer(DataHolder dataHolder) {
        this.options = new GitLabOptions(dataHolder);
        this.codeContentBlock = Parser.FENCED_CODE_CONTENT_BLOCK.get(dataHolder).booleanValue();
        this.referenceRepository = Parser.REFERENCES.get(dataHolder);
        this.recheckUndefinedReferences = HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(dataHolder).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderVideoImage$3(HtmlWriter htmlWriter, Node node, String str, String str2) {
        htmlWriter.srcPos(node.getChars()).attr("src", (CharSequence) str).attr((CharSequence) "width", (CharSequence) StickyMemoSAConstants.EVENT_MOVE_STICKY_NOTE).attr((CharSequence) "controls", (CharSequence) "true").withAttr(VIDEO).tag((CharSequence) ComposerSAConstants.DETAIL_VIDEO).tag((CharSequence) "/video").line();
        if (this.options.renderVideoLink) {
            htmlWriter.tag("p").attr((CharSequence) "href", (CharSequence) str).attr((CharSequence) "target", (CharSequence) "_blank").attr((CharSequence) Constants.VALUE_LOG_TYPE_REL, (CharSequence) "noopener noreferrer").attr((CharSequence) "title", (CharSequence) String.format(this.options.videoImageLinkTextFormat, str2)).withAttr(VIDEO_LINK).tag((CharSequence) "a").text((CharSequence) str2).tag((CharSequence) "/a").tag((CharSequence) "/p").line();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(GitLabIns gitLabIns, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().tag("ins", false, false, (Runnable) new RunnableC10960a(nodeRendererContext, gitLabIns, 6));
    }

    private boolean renderVideoImage(Node node, String str, String str2, Attributes attributes, HtmlWriter htmlWriter) {
        int iIndexOf = str.indexOf(63);
        String strSubstring = iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
        int iLastIndexOf = strSubstring.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            if (this.options.videoImageExtensionSet.contains(strSubstring.substring(iLastIndexOf + 1))) {
                htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) this.options.videoImageClass).attr(attributes).withAttr().tagLineIndent((CharSequence) "div", (Runnable) new RunnableC4054d(this, htmlWriter, node, str, str2));
                return true;
            }
        }
        return false;
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderer
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet hashSet = new HashSet();
        final int i = 1;
        hashSet.add(new NodeRenderingHandler(GitLabIns.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.gitlab.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ GitLabNodeRenderer f8306b;

            {
                this.f8306b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i) {
                    case 0:
                        this.f8306b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8306b.render((GitLabIns) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8306b.render((GitLabDel) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8306b.render((GitLabInlineMath) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8306b.render((GitLabBlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8306b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8306b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }));
        final int i2 = 2;
        hashSet.add(new NodeRenderingHandler(GitLabDel.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.gitlab.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ GitLabNodeRenderer f8306b;

            {
                this.f8306b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i2) {
                    case 0:
                        this.f8306b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8306b.render((GitLabIns) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8306b.render((GitLabDel) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8306b.render((GitLabInlineMath) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8306b.render((GitLabBlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8306b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8306b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }));
        final int i4 = 3;
        hashSet.add(new NodeRenderingHandler(GitLabInlineMath.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.gitlab.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ GitLabNodeRenderer f8306b;

            {
                this.f8306b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i4) {
                    case 0:
                        this.f8306b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8306b.render((GitLabIns) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8306b.render((GitLabDel) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8306b.render((GitLabInlineMath) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8306b.render((GitLabBlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8306b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8306b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }));
        final int i5 = 4;
        hashSet.add(new NodeRenderingHandler(GitLabBlockQuote.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.gitlab.internal.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ GitLabNodeRenderer f8306b;

            {
                this.f8306b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i5) {
                    case 0:
                        this.f8306b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                        break;
                    case 1:
                        this.f8306b.render((GitLabIns) node, nodeRendererContext, htmlWriter);
                        break;
                    case 2:
                        this.f8306b.render((GitLabDel) node, nodeRendererContext, htmlWriter);
                        break;
                    case 3:
                        this.f8306b.render((GitLabInlineMath) node, nodeRendererContext, htmlWriter);
                        break;
                    case 4:
                        this.f8306b.render((GitLabBlockQuote) node, nodeRendererContext, htmlWriter);
                        break;
                    case 5:
                        this.f8306b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f8306b.render((Image) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }));
        GitLabOptions gitLabOptions = this.options;
        if (gitLabOptions.renderBlockMath || gitLabOptions.renderBlockMermaid) {
            final int i6 = 5;
            hashSet.add(new NodeRenderingHandler(FencedCodeBlock.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.gitlab.internal.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ GitLabNodeRenderer f8306b;

                {
                    this.f8306b = this;
                }

                @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
                public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                    switch (i6) {
                        case 0:
                            this.f8306b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                            break;
                        case 1:
                            this.f8306b.render((GitLabIns) node, nodeRendererContext, htmlWriter);
                            break;
                        case 2:
                            this.f8306b.render((GitLabDel) node, nodeRendererContext, htmlWriter);
                            break;
                        case 3:
                            this.f8306b.render((GitLabInlineMath) node, nodeRendererContext, htmlWriter);
                            break;
                        case 4:
                            this.f8306b.render((GitLabBlockQuote) node, nodeRendererContext, htmlWriter);
                            break;
                        case 5:
                            this.f8306b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                            break;
                        default:
                            this.f8306b.render((Image) node, nodeRendererContext, htmlWriter);
                            break;
                    }
                }
            }));
        }
        if (this.options.renderVideoImages) {
            final int i7 = 6;
            hashSet.add(new NodeRenderingHandler(Image.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.gitlab.internal.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ GitLabNodeRenderer f8306b;

                {
                    this.f8306b = this;
                }

                @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
                public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                    switch (i7) {
                        case 0:
                            this.f8306b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                            break;
                        case 1:
                            this.f8306b.render((GitLabIns) node, nodeRendererContext, htmlWriter);
                            break;
                        case 2:
                            this.f8306b.render((GitLabDel) node, nodeRendererContext, htmlWriter);
                            break;
                        case 3:
                            this.f8306b.render((GitLabInlineMath) node, nodeRendererContext, htmlWriter);
                            break;
                        case 4:
                            this.f8306b.render((GitLabBlockQuote) node, nodeRendererContext, htmlWriter);
                            break;
                        case 5:
                            this.f8306b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                            break;
                        default:
                            this.f8306b.render((Image) node, nodeRendererContext, htmlWriter);
                            break;
                    }
                }
            }));
            final int i8 = 0;
            hashSet.add(new NodeRenderingHandler(ImageRef.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: com.vladsch.flexmark.ext.gitlab.internal.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ GitLabNodeRenderer f8306b;

                {
                    this.f8306b = this;
                }

                @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
                public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                    switch (i8) {
                        case 0:
                            this.f8306b.render((ImageRef) node, nodeRendererContext, htmlWriter);
                            break;
                        case 1:
                            this.f8306b.render((GitLabIns) node, nodeRendererContext, htmlWriter);
                            break;
                        case 2:
                            this.f8306b.render((GitLabDel) node, nodeRendererContext, htmlWriter);
                            break;
                        case 3:
                            this.f8306b.render((GitLabInlineMath) node, nodeRendererContext, htmlWriter);
                            break;
                        case 4:
                            this.f8306b.render((GitLabBlockQuote) node, nodeRendererContext, htmlWriter);
                            break;
                        case 5:
                            this.f8306b.render((FencedCodeBlock) node, nodeRendererContext, htmlWriter);
                            break;
                        default:
                            this.f8306b.render((Image) node, nodeRendererContext, htmlWriter);
                            break;
                    }
                }
            }));
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(GitLabDel gitLabDel, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().tag("del", false, false, (Runnable) new RunnableC10960a(nodeRendererContext, gitLabDel, 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(GitLabInlineMath gitLabInlineMath, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().attr(Attribute.CLASS_ATTR, (CharSequence) this.options.inlineMathClass).withAttr().tag((CharSequence) "span");
        htmlWriter.text((CharSequence) gitLabInlineMath.getText());
        htmlWriter.tag("/span");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(GitLabBlockQuote gitLabBlockQuote, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.withAttr().tagLineIndent("blockquote", (Runnable) new RunnableC10960a(nodeRendererContext, gitLabBlockQuote, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(FencedCodeBlock fencedCodeBlock, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        HtmlRendererOptions htmlOptions = nodeRendererContext.getHtmlOptions();
        BasedSequence infoDelimitedByAny = fencedCodeBlock.getInfoDelimitedByAny(htmlOptions.languageDelimiterSet);
        GitLabOptions gitLabOptions = this.options;
        if (gitLabOptions.renderBlockMath && infoDelimitedByAny.isIn(gitLabOptions.mathLanguages)) {
            htmlWriter.line();
            htmlWriter.srcPosWithTrailingEOL(fencedCodeBlock.getChars()).attr(Attribute.CLASS_ATTR, (CharSequence) this.options.blockMathClass).withAttr().tag((CharSequence) "div").line().openPre();
            if (this.codeContentBlock) {
                nodeRendererContext.renderChildren(fencedCodeBlock);
            } else {
                htmlWriter.text((CharSequence) fencedCodeBlock.getContentChars().normalizeEOL());
            }
            htmlWriter.closePre().tag((CharSequence) "/div");
            htmlWriter.lineIf(htmlOptions.htmlBlockCloseTagEol);
            return;
        }
        GitLabOptions gitLabOptions2 = this.options;
        if (gitLabOptions2.renderBlockMermaid && infoDelimitedByAny.isIn(gitLabOptions2.mermaidLanguages)) {
            htmlWriter.line();
            htmlWriter.srcPosWithTrailingEOL(fencedCodeBlock.getChars()).attr(Attribute.CLASS_ATTR, (CharSequence) this.options.blockMermaidClass).withAttr().tag((CharSequence) "div").line().openPre();
            if (this.codeContentBlock) {
                nodeRendererContext.renderChildren(fencedCodeBlock);
            } else {
                htmlWriter.text((CharSequence) fencedCodeBlock.getContentChars().normalizeEOL());
            }
            htmlWriter.closePre().tag((CharSequence) "/div");
            htmlWriter.lineIf(htmlOptions.htmlBlockCloseTagEol);
            return;
        }
        nodeRendererContext.delegateRender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Image image, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        if (nodeRendererContext.isDoNotRenderLinks() || CoreNodeRenderer.isSuppressedLinkPrefix(image.getUrl(), nodeRendererContext)) {
            return;
        }
        String strCollectAndGetText = new TextCollectingVisitor().collectAndGetText(image);
        ResolvedLink resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.IMAGE, image.getUrl().unescape(), null, null);
        String url = resolvedLinkResolveLink.getUrl();
        if (image.getUrlContent().isEmpty()) {
            if (renderVideoImage(image, url, strCollectAndGetText, nodeRendererContext.extendRenderingNodeAttributes(image, AttributablePart.NODE, resolvedLinkResolveLink.getNonNullAttributes()), htmlWriter)) {
                return;
            }
        }
        nodeRendererContext.delegateRender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(ImageRef imageRef, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        ResolvedLink resolvedLinkResolveLink;
        boolean zIsSuppressedLinkPrefix;
        if (!imageRef.isDefined() && this.recheckUndefinedReferences && imageRef.getReferenceNode(this.referenceRepository) != null) {
            imageRef.setDefined(true);
        }
        if (imageRef.isDefined()) {
            Reference referenceNode = imageRef.getReferenceNode(this.referenceRepository);
            String strUnescape = referenceNode.getUrl().unescape();
            zIsSuppressedLinkPrefix = CoreNodeRenderer.isSuppressedLinkPrefix(strUnescape, nodeRendererContext);
            resolvedLinkResolveLink = nodeRendererContext.resolveLink(LinkType.IMAGE, strUnescape, null, null);
            if (referenceNode.getTitle().isNotNull()) {
                resolvedLinkResolveLink = resolvedLinkResolveLink.withTitle(referenceNode.getTitle().unescape());
            }
        } else {
            ResolvedLink resolvedLinkResolveLink2 = nodeRendererContext.resolveLink(LinkType.IMAGE_REF, this.referenceRepository.normalizeKey(imageRef.getReference()), null, null);
            resolvedLinkResolveLink = resolvedLinkResolveLink2.getStatus() != LinkStatus.UNKNOWN ? resolvedLinkResolveLink2 : null;
            zIsSuppressedLinkPrefix = false;
        }
        if (resolvedLinkResolveLink != null && !nodeRendererContext.isDoNotRenderLinks() && !zIsSuppressedLinkPrefix) {
            if (renderVideoImage(imageRef, resolvedLinkResolveLink.getUrl(), new TextCollectingVisitor().collectAndGetText(imageRef), resolvedLinkResolveLink.getNonNullAttributes(), htmlWriter)) {
                return;
            }
        }
        nodeRendererContext.delegateRender();
    }
}
