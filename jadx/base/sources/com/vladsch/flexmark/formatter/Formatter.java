package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.formatter.internal.CoreNodeFormatter;
import com.vladsch.flexmark.formatter.internal.FormatControlProcessor;
import com.vladsch.flexmark.formatter.internal.MergeContextImpl;
import com.vladsch.flexmark.formatter.internal.MergeLinkResolver;
import com.vladsch.flexmark.formatter.internal.TranslationHandlerImpl;
import com.vladsch.flexmark.html.AttributeProviderFactory;
import com.vladsch.flexmark.html.LinkResolver;
import com.vladsch.flexmark.html.LinkResolverFactory;
import com.vladsch.flexmark.html.renderer.HeaderIdGenerator;
import com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory;
import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
import com.vladsch.flexmark.html.renderer.HtmlIdGeneratorFactory;
import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.html.renderer.LinkStatus;
import com.vladsch.flexmark.html.renderer.LinkType;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.IRender;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeCollectingVisitor;
import com.vladsch.flexmark.util.builder.BuilderBase;
import com.vladsch.flexmark.util.collection.SubClassingBag;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.data.NotNullValueSupplier;
import com.vladsch.flexmark.util.data.NullableDataKey;
import com.vladsch.flexmark.util.data.ScopedDataSet;
import com.vladsch.flexmark.util.data.SharedDataKeys;
import com.vladsch.flexmark.util.dependency.DependencyResolver;
import com.vladsch.flexmark.util.format.CharWidthProvider;
import com.vladsch.flexmark.util.format.NodeContext;
import com.vladsch.flexmark.util.format.TableFormatOptions;
import com.vladsch.flexmark.util.format.TrackedOffset;
import com.vladsch.flexmark.util.format.TrackedOffsetList;
import com.vladsch.flexmark.util.format.TrackedOffsetUtils;
import com.vladsch.flexmark.util.format.options.BlockQuoteMarker;
import com.vladsch.flexmark.util.format.options.CodeFenceMarker;
import com.vladsch.flexmark.util.format.options.DiscretionaryText;
import com.vladsch.flexmark.util.format.options.ElementAlignment;
import com.vladsch.flexmark.util.format.options.ElementPlacement;
import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
import com.vladsch.flexmark.util.format.options.EqualizeTrailingMarker;
import com.vladsch.flexmark.util.format.options.HeadingStyle;
import com.vladsch.flexmark.util.format.options.ListBulletMarker;
import com.vladsch.flexmark.util.format.options.ListNumberedMarker;
import com.vladsch.flexmark.util.format.options.ListSpacing;
import com.vladsch.flexmark.util.format.options.TableCaptionHandling;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Extension;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Formatter implements IRender {
    public static final DataKey<Boolean> APPEND_TRANSFERRED_REFERENCES;
    public static final DataKey<Boolean> APPLY_SPECIAL_LEAD_IN_HANDLERS;
    public static final DataKey<Map<String, String>> ATTRIBUTE_UNIQUIFICATION_ID_MAP;

    @Deprecated
    public static final DataKey<EqualizeTrailingMarker> ATX_HEADER_TRAILING_MARKER;
    public static final DataKey<EqualizeTrailingMarker> ATX_HEADING_TRAILING_MARKER;
    public static final DataKey<Boolean> BLOCK_QUOTE_BLANK_LINES;
    public static final DataKey<BlockQuoteMarker> BLOCK_QUOTE_MARKERS;
    public static final DataKey<Boolean> DEFAULT_LINK_RESOLVER;
    public static final DataKey<CharSequence> DOCUMENT_FIRST_PREFIX;
    public static final DataKey<CharSequence> DOCUMENT_PREFIX;
    public static final DataKey<String> DOC_RELATIVE_URL;
    public static final DataKey<String> DOC_ROOT_URL;
    public static final DataKey<Boolean> ESCAPE_NUMBERED_LEAD_IN;
    public static final DataKey<Boolean> ESCAPE_SPECIAL_CHARS;
    public static final DataKey<Integer> FENCED_CODE_MARKER_LENGTH;
    public static final DataKey<CodeFenceMarker> FENCED_CODE_MARKER_TYPE;
    public static final DataKey<Boolean> FENCED_CODE_MATCH_CLOSING_MARKER;
    public static final DataKey<Boolean> FENCED_CODE_MINIMIZE_INDENT;
    public static final DataKey<Boolean> FENCED_CODE_SPACE_BEFORE_INFO;
    public static final DataKey<ParserEmulationProfile> FORMATTER_EMULATION_PROFILE;
    public static final DataKey<String> FORMATTER_OFF_TAG;
    public static final DataKey<String> FORMATTER_ON_TAG;
    public static final DataKey<Boolean> FORMATTER_TAGS_ACCEPT_REGEXP;
    public static final DataKey<Boolean> FORMATTER_TAGS_ENABLED;
    public static final DataKey<CharWidthProvider> FORMAT_CHAR_WIDTH_PROVIDER;

    @Deprecated
    public static final DataKey<TableCaptionHandling> FORMAT_TABLE_CAPTION;

    @Deprecated
    public static final DataKey<DiscretionaryText> FORMAT_TABLE_CAPTION_SPACES;

    @Deprecated
    public static final DataKey<String> FORMAT_TABLE_INDENT_PREFIX;
    public static final DataKey<Boolean> GENERATE_HEADER_ID;
    public static final DataKey<HeadingStyle> HEADING_STYLE;
    public static final DataKey<Boolean> INDENTED_CODE_MINIMIZE_INDENT;
    public static final DataKey<Boolean> KEEP_EXPLICIT_LINKS_AT_START;
    public static final DataKey<Boolean> KEEP_HARD_LINE_BREAKS;
    public static final DataKey<Boolean> KEEP_IMAGE_LINKS_AT_START;
    public static final DataKey<Boolean> KEEP_SOFT_LINE_BREAKS;
    public static final NullableDataKey<Pattern> LINK_MARKER_COMMENT_PATTERN;
    public static final DataKey<Boolean> LISTS_ITEM_CONTENT_AFTER_SUFFIX;
    public static final DataKey<Boolean> LIST_ADD_BLANK_LINE_BEFORE;
    public static final DataKey<ElementAlignment> LIST_ALIGN_NUMERIC;
    public static final DataKey<ListBulletMarker> LIST_BULLET_MARKER;
    public static final DataKey<ListNumberedMarker> LIST_NUMBERED_MARKER;
    public static final DataKey<Boolean> LIST_REMOVE_EMPTY_ITEMS;
    public static final DataKey<Boolean> LIST_RENUMBER_ITEMS;
    public static final DataKey<Boolean> LIST_RESET_FIRST_ITEM_NUMBER;
    public static final DataKey<ListSpacing> LIST_SPACING;
    public static final DataKey<Integer> MAX_BLANK_LINES;
    public static final DataKey<Integer> MAX_TRAILING_BLANK_LINES;
    public static final Iterable<Node> NULL_ITERABLE;
    private static final Iterator<Node> NULL_ITERATOR;
    public static final DataKey<Boolean> OPTIMIZED_INLINE_RENDERING;
    public static final DataKey<ElementPlacement> REFERENCE_PLACEMENT;
    public static final DataKey<ElementPlacementSort> REFERENCE_SORT;
    public static final DataKey<Boolean> RESTORE_TRACKED_SPACES;
    public static final DataKey<Integer> RIGHT_MARGIN;

    @Deprecated
    public static final DataKey<Boolean> SETEXT_HEADER_EQUALIZE_MARKER;
    public static final DataKey<Boolean> SETEXT_HEADING_EQUALIZE_MARKER;
    public static final DataKey<DiscretionaryText> SPACE_AFTER_ATX_MARKER;
    public static final NullableDataKey<String> THEMATIC_BREAK;
    public static final DataKey<List<TrackedOffset>> TRACKED_OFFSETS;
    public static final DataKey<BasedSequence> TRACKED_SEQUENCE;
    public static final DataKey<String> TRANSLATION_AUTOLINK_PREFIX;
    public static final DataKey<String> TRANSLATION_EXCLUDE_PATTERN;
    public static final DataKey<String> TRANSLATION_HTML_BLOCK_PREFIX;
    public static final DataKey<String> TRANSLATION_HTML_BLOCK_TAG_PATTERN;
    public static final DataKey<String> TRANSLATION_HTML_INLINE_PREFIX;
    public static final DataKey<String> TRANSLATION_HTML_INLINE_TAG_PATTERN;
    public static final DataKey<String> TRANSLATION_ID_FORMAT;
    public static final DataKey<Boolean> UNESCAPE_SPECIAL_CHARS;
    public static final DataKey<Map<String, String>> UNIQUIFICATION_MAP;
    final HeaderIdGeneratorFactory idGeneratorFactory;
    final List<LinkResolverFactory> linkResolverFactories;
    final List<NodeFormatterFactory> nodeFormatterFactories;
    private final DataHolder options;
    public static final Document[] EMPTY_DOCUMENTS = new Document[0];
    public static final DataKey<Integer> FORMAT_FLAGS = new DataKey<>("FORMAT_FLAGS", Integer.valueOf(LineAppendable.F_TRIM_LEADING_WHITESPACE | LineAppendable.F_TRIM_LEADING_EOL));

    @Deprecated
    public static final int FORMAT_CONVERT_TABS = LineAppendable.F_CONVERT_TABS;

    @Deprecated
    public static final int FORMAT_COLLAPSE_WHITESPACE = LineAppendable.F_COLLAPSE_WHITESPACE;

    @Deprecated
    public static final int FORMAT_SUPPRESS_TRAILING_WHITESPACE = LineAppendable.F_TRIM_TRAILING_WHITESPACE;

    @Deprecated
    public static final int FORMAT_ALL_OPTIONS = LineAppendable.F_FORMAT_ALL;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder extends BuilderBase<Builder> {
        List<AttributeProviderFactory> attributeProviderFactories;
        HeaderIdGeneratorFactory htmlIdGeneratorFactory;
        List<LinkResolverFactory> linkResolverFactories;
        List<NodeFormatterFactory> nodeFormatterFactories;

        public Builder() {
            this.attributeProviderFactories = new ArrayList();
            this.nodeFormatterFactories = new ArrayList();
            this.linkResolverFactories = new ArrayList();
            this.htmlIdGeneratorFactory = null;
        }

        @NotNull
        public Builder htmlIdGeneratorFactory(@NotNull HeaderIdGeneratorFactory headerIdGeneratorFactory) {
            if (this.htmlIdGeneratorFactory != null) {
                throw new IllegalStateException("custom header id factory is already set to ".concat(headerIdGeneratorFactory.getClass().getName()));
            }
            this.htmlIdGeneratorFactory = headerIdGeneratorFactory;
            addExtensionApiPoint(headerIdGeneratorFactory);
            return this;
        }

        @NotNull
        public Builder linkResolverFactory(@NotNull LinkResolverFactory linkResolverFactory) {
            this.linkResolverFactories.add(linkResolverFactory);
            addExtensionApiPoint(linkResolverFactory);
            return this;
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        public boolean loadExtension(@NotNull Extension extension) {
            if (!(extension instanceof FormatterExtension)) {
                return false;
            }
            ((FormatterExtension) extension).extend(this);
            return true;
        }

        public Builder nodeFormatterFactory(NodeFormatterFactory nodeFormatterFactory) {
            this.nodeFormatterFactories.add(nodeFormatterFactory);
            return this;
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        public void preloadExtension(@NotNull Extension extension) {
            if (extension instanceof FormatterExtension) {
                ((FormatterExtension) extension).rendererOptions(this);
            }
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        public void removeApiPoint(@NotNull Object obj) {
            if (obj instanceof AttributeProviderFactory) {
                this.attributeProviderFactories.remove(obj);
                return;
            }
            if (obj instanceof NodeFormatterFactory) {
                this.nodeFormatterFactories.remove(obj);
            } else if (obj instanceof LinkResolverFactory) {
                this.linkResolverFactories.remove(obj);
            } else {
                if (!(obj instanceof HeaderIdGeneratorFactory)) {
                    throw new IllegalStateException("Unknown data point type: ".concat(obj.getClass().getName()));
                }
                this.htmlIdGeneratorFactory = null;
            }
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        @NotNull
        public Formatter build() {
            return new Formatter(this);
        }

        public Builder(DataHolder dataHolder) {
            super(dataHolder);
            this.attributeProviderFactories = new ArrayList();
            this.nodeFormatterFactories = new ArrayList();
            this.linkResolverFactories = new ArrayList();
            this.htmlIdGeneratorFactory = null;
            loadExtensions();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FormatterExtension extends Extension {
        void extend(Builder builder);

        void rendererOptions(MutableDataHolder mutableDataHolder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MainNodeFormatter extends NodeFormatterSubContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final BasedSequence blockQuoteLikeChars;
        private final CharPredicate blockQuoteLikePredicate;
        private final SubClassingBag<Node> collectedNodes;

        @Nullable
        private FormatControlProcessor controlProcessor;
        private final Document document;
        private final ExplicitAttributeIdProvider explicitAttributeIdProvider;
        final FormatterOptions formatterOptions;
        private final HtmlIdGenerator idGenerator;

        @NotNull
        private final Boolean isFormatControlEnabled;
        private final LinkResolver[] linkResolvers;
        private final DataHolder options;
        private FormattingPhase phase;
        private final List<PhasedNodeFormatter> phasedFormatters;
        private final Map<Class<?>, List<NodeFormattingHandler<?>>> renderers;
        private final Set<FormattingPhase> renderingPhases;
        private final HashMap<LinkType, HashMap<String, ResolvedLink>> resolvedLinkMap;
        final boolean restoreTrackedSpaces;
        final TrackedOffsetList trackedOffsets;
        final BasedSequence trackedSequence;
        final TranslationHandler translationHandler;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class SubNodeFormatter extends NodeFormatterSubContext implements NodeFormatterContext {
            private final FormatterOptions myFormatterOptions;
            private final MainNodeFormatter myMainNodeRenderer;
            private final DataHolder myOptions;

            public SubNodeFormatter(MainNodeFormatter mainNodeFormatter, MarkdownWriter markdownWriter, @Nullable DataHolder dataHolder) {
                super(markdownWriter);
                this.myMainNodeRenderer = mainNodeFormatter;
                DataHolder options = (dataHolder == null || dataHolder == mainNodeFormatter.getOptions()) ? mainNodeFormatter.getOptions() : new ScopedDataSet(mainNodeFormatter.getOptions(), dataHolder);
                this.myOptions = options;
                this.myFormatterOptions = new FormatterOptions(options);
            }

            @Override // com.vladsch.flexmark.formatter.ExplicitAttributeIdProvider
            public void addExplicitId(@NotNull Node node, @Nullable String str, @NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter) {
                this.myMainNodeRenderer.addExplicitId(node, str, nodeFormatterContext, markdownWriter);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public void customPlaceholderFormat(@NotNull TranslationPlaceholderGenerator translationPlaceholderGenerator, @NotNull TranslatingSpanRender translatingSpanRender) {
                this.myMainNodeRenderer.customPlaceholderFormat(translationPlaceholderGenerator, translatingSpanRender);
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            public void delegateRender() {
                this.myMainNodeRenderer.delegateRender(this);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public String encodeUrl(@NotNull CharSequence charSequence) {
                return this.myMainNodeRenderer.encodeUrl(charSequence);
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public BasedSequence getBlockQuoteLikePrefixChars() {
                return this.myMainNodeRenderer.getBlockQuoteLikePrefixChars();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public CharPredicate getBlockQuoteLikePrefixPredicate() {
                return this.myMainNodeRenderer.getBlockQuoteLikePrefixPredicate();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
            @NotNull
            public Document getDocument() {
                return this.myMainNodeRenderer.getDocument();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public FormatterOptions getFormatterOptions() {
                return this.myFormatterOptions;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public FormattingPhase getFormattingPhase() {
                return this.myMainNodeRenderer.getFormattingPhase();
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public HtmlIdGenerator getIdGenerator() {
                return this.myMainNodeRenderer.getIdGenerator();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterSubContext, com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public MarkdownWriter getMarkdown() {
                return this.markdown;
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public MergeContext getMergeContext() {
                return this.myMainNodeRenderer.getMergeContext();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.util.format.NodeContext, com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
            @NotNull
            public DataHolder getOptions() {
                return this.myOptions;
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            @NotNull
            public RenderPurpose getRenderPurpose() {
                return this.myMainNodeRenderer.getRenderPurpose();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public TrackedOffsetList getTrackedOffsets() {
                return TrackedOffsetList.EMPTY_LIST;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public BasedSequence getTrackedSequence() {
                return this.myMainNodeRenderer.getTrackedSequence();
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            @NotNull
            public MutableDataHolder getTranslationStore() {
                return this.myMainNodeRenderer.getTranslationStore();
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public boolean isPostProcessingNonTranslating() {
                return this.myMainNodeRenderer.isPostProcessingNonTranslating();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            public boolean isRestoreTrackedSpaces() {
                return false;
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public boolean isTransformingText() {
                return this.myMainNodeRenderer.isTransformingText();
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public final Iterable<? extends Node> nodesOfType(@NotNull Class<?>[] clsArr) {
                return this.myMainNodeRenderer.nodesOfType(clsArr);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public void nonTranslatingSpan(@NotNull TranslatingSpanRender translatingSpanRender) {
                this.myMainNodeRenderer.nonTranslatingSpan(translatingSpanRender);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public void postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Runnable runnable) {
                this.myMainNodeRenderer.postProcessNonTranslating(function, runnable);
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.html.renderer.LinkResolverContext
            public void render(@NotNull Node node) {
                this.myMainNodeRenderer.renderNode(node, this);
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.html.renderer.LinkResolverContext
            public void renderChildren(@NotNull Node node) {
                this.myMainNodeRenderer.renderChildrenNode(node, this);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, Boolean bool) {
                return this.myMainNodeRenderer.resolveLink(this, linkType, charSequence, (Attributes) null);
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public final Iterable<? extends Node> reversedNodesOfType(@NotNull Class<?>[] clsArr) {
                return this.myMainNodeRenderer.reversedNodesOfType(clsArr);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            @NotNull
            public CharSequence transformAnchorRef(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
                return this.myMainNodeRenderer.transformAnchorRef(charSequence, charSequence2);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            @NotNull
            public CharSequence transformNonTranslating(CharSequence charSequence, @NotNull CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
                return this.myMainNodeRenderer.transformNonTranslating(charSequence, charSequence2, charSequence3, charSequence4);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            @NotNull
            public CharSequence transformTranslating(CharSequence charSequence, @NotNull CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
                return this.myMainNodeRenderer.transformTranslating(charSequence, charSequence2, charSequence3, charSequence4);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public void translatingRefTargetSpan(@Nullable Node node, @NotNull TranslatingSpanRender translatingSpanRender) {
                this.myMainNodeRenderer.translatingRefTargetSpan(node, translatingSpanRender);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            public void translatingSpan(@NotNull TranslatingSpanRender translatingSpanRender) {
                this.myMainNodeRenderer.translatingSpan(translatingSpanRender);
            }

            @Override // com.vladsch.flexmark.util.format.NodeContext, com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public Node getCurrentNode() {
                return this.renderingNode;
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public final Iterable<? extends Node> nodesOfType(@NotNull Collection<Class<?>> collection) {
                return this.myMainNodeRenderer.nodesOfType(collection);
            }

            @Override // com.vladsch.flexmark.formatter.TranslationContext
            @NotNull
            public <T> T postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Supplier<T> supplier) {
                return (T) this.myMainNodeRenderer.postProcessNonTranslating(function, supplier);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, Attributes attributes, Boolean bool) {
                return this.myMainNodeRenderer.resolveLink(this, linkType, charSequence, attributes);
            }

            @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
            @NotNull
            public final Iterable<? extends Node> reversedNodesOfType(@NotNull Collection<Class<?>> collection) {
                return this.myMainNodeRenderer.reversedNodesOfType(collection);
            }

            @Override // com.vladsch.flexmark.util.format.NodeContext
            @NotNull
            public /* bridge */ /* synthetic */ NodeContext getSubContext(@Nullable DataHolder dataHolder, @NotNull ISequenceBuilder iSequenceBuilder) {
                return getSubContext(dataHolder, (ISequenceBuilder<?, ?>) iSequenceBuilder);
            }

            @Override // com.vladsch.flexmark.util.format.NodeContext
            @NotNull
            public NodeFormatterContext getSubContext() {
                return getSubContext((DataHolder) null, this.markdown.getBuilder());
            }

            @Override // com.vladsch.flexmark.util.format.NodeContext
            @NotNull
            public NodeFormatterContext getSubContext(@Nullable DataHolder dataHolder) {
                return getSubContext(dataHolder, this.markdown.getBuilder());
            }

            @Override // com.vladsch.flexmark.util.format.NodeContext
            @NotNull
            public NodeFormatterContext getSubContext(@Nullable DataHolder dataHolder, @NotNull ISequenceBuilder<?, ?> iSequenceBuilder) {
                MarkdownWriter markdownWriter = new MarkdownWriter(iSequenceBuilder, this.markdown.getOptions());
                markdownWriter.setContext(this);
                return MainNodeFormatter.this.new SubNodeFormatter(this.myMainNodeRenderer, markdownWriter, (dataHolder == null || dataHolder == this.myOptions) ? this.myOptions : new ScopedDataSet(this.myOptions, dataHolder));
            }
        }

        public MainNodeFormatter(DataHolder dataHolder, MarkdownWriter markdownWriter, Document document, TranslationHandler translationHandler) {
            HtmlIdGenerator htmlIdGeneratorCreate;
            super(markdownWriter);
            this.resolvedLinkMap = new HashMap<>();
            this.translationHandler = translationHandler;
            ScopedDataSet scopedDataSet = new ScopedDataSet(document, dataHolder);
            this.options = scopedDataSet;
            this.formatterOptions = new FormatterOptions(scopedDataSet);
            this.document = document;
            this.renderers = new HashMap(32);
            this.renderingPhases = new HashSet(FormattingPhase.values().length);
            HashSet hashSet = new HashSet(100);
            Boolean bool = Formatter.DEFAULT_LINK_RESOLVER.get(scopedDataSet);
            this.linkResolvers = new LinkResolver[(bool.booleanValue() ? 1 : 0) + Formatter.this.linkResolverFactories.size()];
            this.isFormatControlEnabled = Formatter.FORMATTER_TAGS_ENABLED.get(scopedDataSet);
            for (int i = 0; i < Formatter.this.linkResolverFactories.size(); i++) {
                this.linkResolvers[i] = Formatter.this.linkResolverFactories.get(i).apply((LinkResolverBasicContext) this);
            }
            if (bool.booleanValue()) {
                this.linkResolvers[Formatter.this.linkResolverFactories.size()] = new MergeLinkResolver.Factory().apply((LinkResolverBasicContext) this);
            }
            markdownWriter.setContext(this);
            List<NodeFormatterFactory> list = Formatter.this.nodeFormatterFactories;
            this.phasedFormatters = new ArrayList(list.size());
            StringBuilder sb = new StringBuilder();
            ExplicitAttributeIdProvider explicitAttributeIdProvider = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                NodeFormatter nodeFormatterCreate = list.get(size).create(this.options);
                explicitAttributeIdProvider = nodeFormatterCreate instanceof ExplicitAttributeIdProvider ? (ExplicitAttributeIdProvider) nodeFormatterCreate : explicitAttributeIdProvider;
                char blockQuoteLikePrefixChar = nodeFormatterCreate.getBlockQuoteLikePrefixChar();
                if (blockQuoteLikePrefixChar != 0) {
                    sb.append(blockQuoteLikePrefixChar);
                }
                Set<NodeFormattingHandler<?>> nodeFormattingHandlers = nodeFormatterCreate.getNodeFormattingHandlers();
                if (nodeFormattingHandlers != null) {
                    for (NodeFormattingHandler<?> nodeFormattingHandler : nodeFormattingHandlers) {
                        this.renderers.computeIfAbsent(nodeFormattingHandler.getNodeType(), new C11812f(0)).add(0, nodeFormattingHandler);
                    }
                    Set<Class<?>> nodeClasses = nodeFormatterCreate.getNodeClasses();
                    if (nodeClasses != null) {
                        hashSet.addAll(nodeClasses);
                    }
                    if (nodeFormatterCreate instanceof PhasedNodeFormatter) {
                        PhasedNodeFormatter phasedNodeFormatter = (PhasedNodeFormatter) nodeFormatterCreate;
                        Set<FormattingPhase> formattingPhases = phasedNodeFormatter.getFormattingPhases();
                        if (formattingPhases == null) {
                            throw new IllegalStateException("PhasedNodeFormatter with null Phases");
                        }
                        if (formattingPhases.isEmpty()) {
                            throw new IllegalStateException("PhasedNodeFormatter with empty Phases");
                        }
                        this.renderingPhases.addAll(formattingPhases);
                        this.phasedFormatters.add(phasedNodeFormatter);
                    } else {
                        continue;
                    }
                }
            }
            this.restoreTrackedSpaces = Formatter.RESTORE_TRACKED_SPACES.get(this.options).booleanValue();
            BasedSequence chars = Formatter.TRACKED_SEQUENCE.get(this.options);
            List<TrackedOffset> list2 = Formatter.TRACKED_OFFSETS.get(this.options);
            chars = chars.isEmpty() ? document.getChars() : chars;
            this.trackedSequence = chars;
            this.trackedOffsets = list2.isEmpty() ? TrackedOffsetList.EMPTY_LIST : TrackedOffsetList.create(chars, list2);
            String string = sb.toString();
            this.blockQuoteLikeChars = BasedSequence.m13437of(string);
            this.blockQuoteLikePredicate = CharPredicate.anyOf(string);
            if (Formatter.GENERATE_HEADER_ID.get(this.options).booleanValue()) {
                HeaderIdGeneratorFactory headerIdGeneratorFactory = Formatter.this.idGeneratorFactory;
                htmlIdGeneratorCreate = headerIdGeneratorFactory != null ? headerIdGeneratorFactory.create(this) : new HeaderIdGenerator.Factory().create((LinkResolverContext) this);
            } else {
                htmlIdGeneratorCreate = null;
            }
            this.idGenerator = htmlIdGeneratorCreate;
            if (htmlIdGeneratorCreate != null) {
                htmlIdGeneratorCreate.generateIds(document);
            }
            this.explicitAttributeIdProvider = explicitAttributeIdProvider;
            if (hashSet.isEmpty()) {
                this.collectedNodes = null;
                return;
            }
            NodeCollectingVisitor nodeCollectingVisitor = new NodeCollectingVisitor(hashSet);
            nodeCollectingVisitor.collect(document);
            this.collectedNodes = nodeCollectingVisitor.getSubClassingBag();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$new$0(Class cls) {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HashMap lambda$resolveLink$1(LinkType linkType) {
            return new HashMap();
        }

        @Override // com.vladsch.flexmark.formatter.ExplicitAttributeIdProvider
        public void addExplicitId(@NotNull Node node, @Nullable String str, @NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter) {
            ExplicitAttributeIdProvider explicitAttributeIdProvider;
            if (str == null || (explicitAttributeIdProvider = this.explicitAttributeIdProvider) == null) {
                return;
            }
            explicitAttributeIdProvider.addExplicitId(node, str, nodeFormatterContext, markdownWriter);
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public void customPlaceholderFormat(@NotNull TranslationPlaceholderGenerator translationPlaceholderGenerator, @NotNull TranslatingSpanRender translatingSpanRender) {
            TranslationHandler translationHandler = this.translationHandler;
            if (translationHandler != null) {
                translationHandler.customPlaceholderFormat(translationPlaceholderGenerator, translatingSpanRender);
            } else {
                translatingSpanRender.render(this, this.markdown);
            }
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        public void delegateRender() {
            delegateRender(this);
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
        @NotNull
        public String encodeUrl(@NotNull CharSequence charSequence) {
            return String.valueOf(charSequence);
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public BasedSequence getBlockQuoteLikePrefixChars() {
            return this.blockQuoteLikeChars;
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public CharPredicate getBlockQuoteLikePrefixPredicate() {
            return this.blockQuoteLikePredicate;
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
        @NotNull
        public Document getDocument() {
            return this.document;
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public FormatterOptions getFormatterOptions() {
            return this.formatterOptions;
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public FormattingPhase getFormattingPhase() {
            return this.phase;
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public HtmlIdGenerator getIdGenerator() {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler == null ? this.idGenerator : translationHandler.getIdGenerator();
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public MergeContext getMergeContext() {
            TranslationHandler translationHandler = this.translationHandler;
            if (translationHandler == null) {
                return null;
            }
            return translationHandler.getMergeContext();
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.util.format.NodeContext, com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
        @NotNull
        public DataHolder getOptions() {
            return this.options;
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        @NotNull
        public RenderPurpose getRenderPurpose() {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler == null ? RenderPurpose.FORMAT : translationHandler.getRenderPurpose();
        }

        public NodeFormatterContext getSubContextRaw(@Nullable DataHolder dataHolder, @NotNull ISequenceBuilder<?, ?> iSequenceBuilder) {
            MarkdownWriter markdownWriter = new MarkdownWriter(iSequenceBuilder, getMarkdown().getOptions());
            markdownWriter.setContext(this);
            return new SubNodeFormatter(this, markdownWriter, dataHolder);
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public TrackedOffsetList getTrackedOffsets() {
            return this.trackedOffsets;
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public BasedSequence getTrackedSequence() {
            return this.trackedSequence;
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        @NotNull
        public MutableDataHolder getTranslationStore() {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler != null ? translationHandler.getTranslationStore() : this.document;
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public boolean isPostProcessingNonTranslating() {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler != null && translationHandler.isPostProcessingNonTranslating();
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        public boolean isRestoreTrackedSpaces() {
            return this.restoreTrackedSpaces;
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public boolean isTransformingText() {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler != null && translationHandler.isTransformingText();
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public final Iterable<? extends Node> nodesOfType(@NotNull Class<?>[] clsArr) {
            SubClassingBag<Node> subClassingBag = this.collectedNodes;
            return subClassingBag == null ? Formatter.NULL_ITERABLE : subClassingBag.itemsOfType(Node.class, clsArr);
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public void nonTranslatingSpan(@NotNull TranslatingSpanRender translatingSpanRender) {
            TranslationHandler translationHandler = this.translationHandler;
            if (translationHandler != null) {
                translationHandler.nonTranslatingSpan(translatingSpanRender);
            } else {
                translatingSpanRender.render(this, this.markdown);
            }
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public void postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Runnable runnable) {
            TranslationHandler translationHandler = this.translationHandler;
            if (translationHandler != null) {
                translationHandler.postProcessNonTranslating(function, runnable);
            } else {
                runnable.run();
            }
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.html.renderer.LinkResolverContext
        public void render(@NotNull Node node) {
            renderNode(node, this);
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext, com.vladsch.flexmark.html.renderer.LinkResolverContext
        public void renderChildren(@NotNull Node node) {
            renderChildrenNode(node, this);
        }

        public void renderChildrenNode(Node node, NodeFormatterSubContext nodeFormatterSubContext) {
            Node firstChild = node.getFirstChild();
            while (firstChild != null) {
                Node next = firstChild.getNext();
                renderNode(firstChild, nodeFormatterSubContext);
                firstChild = next;
            }
        }

        public void renderNode(Node node, NodeFormatterSubContext nodeFormatterSubContext) {
            if (!(node instanceof Document)) {
                if (this.isFormatControlEnabled.booleanValue()) {
                    FormatControlProcessor formatControlProcessor = this.controlProcessor;
                    if (formatControlProcessor == null) {
                        FormatControlProcessor formatControlProcessor2 = new FormatControlProcessor(this.document, this.options);
                        this.controlProcessor = formatControlProcessor2;
                        formatControlProcessor2.initializeFrom(node);
                    } else {
                        formatControlProcessor.processFormatControl(node);
                    }
                }
                if (this.isFormatControlEnabled.booleanValue() && this.controlProcessor.isFormattingOff()) {
                    if (node instanceof BlankLine) {
                        nodeFormatterSubContext.markdown.blankLine();
                        return;
                    } else {
                        nodeFormatterSubContext.markdown.append((CharSequence) node.getChars());
                        return;
                    }
                }
                List<NodeFormattingHandler<?>> list = this.renderers.get(node.getClass());
                if (list == null) {
                    list = this.renderers.get(Node.class);
                }
                if (list == null) {
                    throw new IllegalStateException("Core Node Formatter should implement generic Node renderer");
                }
                List<NodeFormattingHandler<?>> list2 = nodeFormatterSubContext.rendererList;
                int i = nodeFormatterSubContext.rendererIndex;
                Node node2 = nodeFormatterSubContext.renderingNode;
                nodeFormatterSubContext.rendererList = list;
                nodeFormatterSubContext.rendererIndex = 0;
                nodeFormatterSubContext.renderingNode = node;
                list.get(0).render(node, nodeFormatterSubContext, nodeFormatterSubContext.markdown);
                nodeFormatterSubContext.renderingNode = node2;
                nodeFormatterSubContext.rendererList = list2;
                nodeFormatterSubContext.rendererIndex = i;
                return;
            }
            TranslationHandler translationHandler = this.translationHandler;
            if (translationHandler != null) {
                translationHandler.beginRendering((Document) node, nodeFormatterSubContext, nodeFormatterSubContext.markdown);
            }
            for (FormattingPhase formattingPhase : FormattingPhase.values()) {
                FormattingPhase formattingPhase2 = FormattingPhase.DOCUMENT;
                if (formattingPhase == formattingPhase2 || this.renderingPhases.contains(formattingPhase)) {
                    this.phase = formattingPhase;
                    if (formattingPhase == formattingPhase2) {
                        Document document = (Document) node;
                        nodeFormatterSubContext.markdown.pushPrefix().setPrefix(Formatter.DOCUMENT_FIRST_PREFIX.get(document), false).setPrefix(Formatter.DOCUMENT_PREFIX.get(document), true);
                        List<NodeFormattingHandler<?>> list3 = this.renderers.get(node.getClass());
                        if (list3 != null) {
                            nodeFormatterSubContext.rendererList = list3;
                            nodeFormatterSubContext.rendererIndex = 0;
                            nodeFormatterSubContext.renderingNode = node;
                            list3.get(0).render(node, nodeFormatterSubContext, nodeFormatterSubContext.markdown);
                            nodeFormatterSubContext.renderingNode = null;
                            nodeFormatterSubContext.rendererList = null;
                            nodeFormatterSubContext.rendererIndex = -1;
                        }
                        nodeFormatterSubContext.markdown.popPrefix();
                    } else {
                        for (PhasedNodeFormatter phasedNodeFormatter : this.phasedFormatters) {
                            if (phasedNodeFormatter.getFormattingPhases().contains(formattingPhase)) {
                                nodeFormatterSubContext.renderingNode = node;
                                phasedNodeFormatter.renderDocument(nodeFormatterSubContext, nodeFormatterSubContext.markdown, (Document) node, formattingPhase);
                                nodeFormatterSubContext.renderingNode = null;
                            }
                        }
                    }
                }
            }
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
        @NotNull
        public ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, Attributes attributes, Boolean bool) {
            return resolveLink(this, linkType, charSequence, attributes);
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public final Iterable<? extends Node> reversedNodesOfType(@NotNull Class<?>[] clsArr) {
            SubClassingBag<Node> subClassingBag = this.collectedNodes;
            return subClassingBag == null ? Formatter.NULL_ITERABLE : subClassingBag.reversedItemsOfType(Node.class, clsArr);
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        @NotNull
        public CharSequence transformAnchorRef(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler == null ? charSequence2 : translationHandler.transformAnchorRef(charSequence, charSequence2);
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        @NotNull
        public CharSequence transformNonTranslating(CharSequence charSequence, @NotNull CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler == null ? charSequence2 : translationHandler.transformNonTranslating(charSequence, charSequence2, charSequence3, charSequence4);
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        @NotNull
        public CharSequence transformTranslating(CharSequence charSequence, @NotNull CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler == null ? charSequence2 : translationHandler.transformTranslating(charSequence, charSequence2, charSequence3, charSequence4);
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public void translatingRefTargetSpan(@Nullable Node node, @NotNull TranslatingSpanRender translatingSpanRender) {
            TranslationHandler translationHandler = this.translationHandler;
            if (translationHandler != null) {
                translationHandler.translatingRefTargetSpan(node, translatingSpanRender);
            } else {
                translatingSpanRender.render(this, this.markdown);
            }
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        public void translatingSpan(@NotNull TranslatingSpanRender translatingSpanRender) {
            TranslationHandler translationHandler = this.translationHandler;
            if (translationHandler != null) {
                translationHandler.translatingSpan(translatingSpanRender);
            } else {
                translatingSpanRender.render(this, this.markdown);
            }
        }

        public void delegateRender(NodeFormatterSubContext nodeFormatterSubContext) {
            Node node;
            int i;
            List<NodeFormattingHandler<?>> list;
            if (nodeFormatterSubContext.getFormattingPhase() != FormattingPhase.DOCUMENT) {
                throw new IllegalStateException("Delegate rendering only supported in document rendering phase");
            }
            List<NodeFormattingHandler<?>> list2 = nodeFormatterSubContext.rendererList;
            if (list2 == null || (node = nodeFormatterSubContext.renderingNode) == null) {
                throw new IllegalStateException("Delegate rendering can only be called from node render handler");
            }
            int i2 = nodeFormatterSubContext.rendererIndex;
            int i4 = i2 + 1;
            if (i4 < list2.size()) {
                i = i4;
                list = list2;
            } else {
                if (node instanceof Document) {
                    return;
                }
                list = this.renderers.get(Node.class);
                if (list == null) {
                    throw new IllegalStateException("Core Node Formatter should implement generic Node renderer");
                }
                if (list2 == list) {
                    throw new IllegalStateException("Core Node Formatter should not delegate generic Node renderer");
                }
                i = 0;
            }
            nodeFormatterSubContext.rendererList = list;
            nodeFormatterSubContext.rendererIndex = i;
            list.get(i).render(node, nodeFormatterSubContext, nodeFormatterSubContext.markdown);
            nodeFormatterSubContext.rendererIndex = i2;
            nodeFormatterSubContext.rendererList = list2;
        }

        @Override // com.vladsch.flexmark.util.format.NodeContext, com.vladsch.flexmark.html.renderer.LinkResolverContext
        @NotNull
        public Node getCurrentNode() {
            return this.renderingNode;
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public final Iterable<? extends Node> nodesOfType(@NotNull Collection<Class<?>> collection) {
            SubClassingBag<Node> subClassingBag = this.collectedNodes;
            return subClassingBag == null ? Formatter.NULL_ITERABLE : subClassingBag.itemsOfType(Node.class, collection);
        }

        public ResolvedLink resolveLink(NodeFormatterSubContext nodeFormatterSubContext, LinkType linkType, CharSequence charSequence, Attributes attributes) {
            HashMap<String, ResolvedLink> mapComputeIfAbsent = this.resolvedLinkMap.computeIfAbsent(linkType, new C11812f(1));
            String strValueOf = String.valueOf(charSequence);
            ResolvedLink resolvedLink = mapComputeIfAbsent.get(strValueOf);
            if (resolvedLink == null) {
                resolvedLink = new ResolvedLink(linkType, strValueOf, attributes);
                if (!strValueOf.isEmpty()) {
                    Node node = nodeFormatterSubContext.renderingNode;
                    for (LinkResolver linkResolver : this.linkResolvers) {
                        resolvedLink = linkResolver.resolveLink(node, this, resolvedLink);
                        if (resolvedLink.getStatus() != LinkStatus.UNKNOWN) {
                            break;
                        }
                    }
                }
                mapComputeIfAbsent.put(strValueOf, resolvedLink);
            }
            return resolvedLink;
        }

        @Override // com.vladsch.flexmark.formatter.NodeFormatterContext
        @NotNull
        public final Iterable<? extends Node> reversedNodesOfType(@NotNull Collection<Class<?>> collection) {
            SubClassingBag<Node> subClassingBag = this.collectedNodes;
            return subClassingBag == null ? Formatter.NULL_ITERABLE : subClassingBag.reversedItemsOfType(Node.class, collection);
        }

        @Override // com.vladsch.flexmark.util.format.NodeContext
        @NotNull
        public /* bridge */ /* synthetic */ NodeContext getSubContext(@Nullable DataHolder dataHolder, @NotNull ISequenceBuilder iSequenceBuilder) {
            return getSubContext(dataHolder, (ISequenceBuilder<?, ?>) iSequenceBuilder);
        }

        @Override // com.vladsch.flexmark.formatter.TranslationContext
        @NotNull
        public <T> T postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Supplier<T> supplier) {
            TranslationHandler translationHandler = this.translationHandler;
            return translationHandler != null ? (T) translationHandler.postProcessNonTranslating(function, supplier) : supplier.get();
        }

        @Override // com.vladsch.flexmark.util.format.NodeContext
        @NotNull
        public NodeFormatterContext getSubContext() {
            return getSubContextRaw(null, this.markdown.getBuilder());
        }

        @Override // com.vladsch.flexmark.util.format.NodeContext
        @NotNull
        public NodeFormatterContext getSubContext(@Nullable DataHolder dataHolder) {
            return getSubContextRaw(dataHolder, this.markdown.getBuilder());
        }

        @Override // com.vladsch.flexmark.util.format.NodeContext
        @NotNull
        public NodeFormatterContext getSubContext(@Nullable DataHolder dataHolder, @NotNull ISequenceBuilder<?, ?> iSequenceBuilder) {
            return getSubContextRaw(dataHolder, iSequenceBuilder);
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        GENERATE_HEADER_ID = new DataKey<>("GENERATE_HEADER_ID", bool);
        MAX_BLANK_LINES = SharedDataKeys.FORMATTER_MAX_BLANK_LINES;
        MAX_TRAILING_BLANK_LINES = SharedDataKeys.FORMATTER_MAX_TRAILING_BLANK_LINES;
        RIGHT_MARGIN = new DataKey<>("RIGHT_MARGIN", 0);
        APPLY_SPECIAL_LEAD_IN_HANDLERS = SharedDataKeys.APPLY_SPECIAL_LEAD_IN_HANDLERS;
        ESCAPE_SPECIAL_CHARS = SharedDataKeys.ESCAPE_SPECIAL_CHARS;
        ESCAPE_NUMBERED_LEAD_IN = SharedDataKeys.ESCAPE_NUMBERED_LEAD_IN;
        UNESCAPE_SPECIAL_CHARS = SharedDataKeys.UNESCAPE_SPECIAL_CHARS;
        SPACE_AFTER_ATX_MARKER = new DataKey<>("SPACE_AFTER_ATX_MARKER", DiscretionaryText.ADD);
        Boolean bool2 = Boolean.TRUE;
        DataKey<Boolean> dataKey = new DataKey<>("SETEXT_HEADING_EQUALIZE_MARKER", bool2);
        SETEXT_HEADING_EQUALIZE_MARKER = dataKey;
        DataKey<EqualizeTrailingMarker> dataKey2 = new DataKey<>("ATX_HEADING_TRAILING_MARKER", EqualizeTrailingMarker.AS_IS);
        ATX_HEADING_TRAILING_MARKER = dataKey2;
        HEADING_STYLE = new DataKey<>("HEADING_STYLE", HeadingStyle.AS_IS);
        THEMATIC_BREAK = new NullableDataKey<>("THEMATIC_BREAK");
        BLOCK_QUOTE_BLANK_LINES = SharedDataKeys.BLOCK_QUOTE_BLANK_LINES;
        BLOCK_QUOTE_MARKERS = new DataKey<>("BLOCK_QUOTE_MARKERS", BlockQuoteMarker.ADD_COMPACT_WITH_SPACE);
        INDENTED_CODE_MINIMIZE_INDENT = new DataKey<>("INDENTED_CODE_MINIMIZE_INDENT", bool2);
        FENCED_CODE_MINIMIZE_INDENT = new DataKey<>("FENCED_CODE_MINIMIZE_INDENT", bool2);
        FENCED_CODE_MATCH_CLOSING_MARKER = new DataKey<>("FENCED_CODE_MATCH_CLOSING_MARKER", bool2);
        FENCED_CODE_SPACE_BEFORE_INFO = new DataKey<>("FENCED_CODE_SPACE_BEFORE_INFO", bool);
        FENCED_CODE_MARKER_LENGTH = new DataKey<>("FENCED_CODE_MARKER_LENGTH", 3);
        FENCED_CODE_MARKER_TYPE = new DataKey<>("FENCED_CODE_MARKER_TYPE", CodeFenceMarker.ANY);
        LIST_ADD_BLANK_LINE_BEFORE = new DataKey<>("LIST_ADD_BLANK_LINE_BEFORE", bool);
        LIST_RENUMBER_ITEMS = new DataKey<>("LIST_RENUMBER_ITEMS", bool2);
        LIST_REMOVE_EMPTY_ITEMS = new DataKey<>("LIST_REMOVE_EMPTY_ITEMS", bool);
        LIST_ALIGN_NUMERIC = new DataKey<>("LIST_ALIGN_NUMERIC", ElementAlignment.NONE);
        LIST_RESET_FIRST_ITEM_NUMBER = new DataKey<>("LIST_RESET_FIRST_ITEM_NUMBER", bool);
        LIST_BULLET_MARKER = new DataKey<>("LIST_BULLET_MARKER", ListBulletMarker.ANY);
        LIST_NUMBERED_MARKER = new DataKey<>("LIST_NUMBERED_MARKER", ListNumberedMarker.ANY);
        LIST_SPACING = new DataKey<>("LIST_SPACING", ListSpacing.AS_IS);
        LISTS_ITEM_CONTENT_AFTER_SUFFIX = new DataKey<>("LISTS_ITEM_CONTENT_AFTER_SUFFIX", bool);
        REFERENCE_PLACEMENT = new DataKey<>("REFERENCE_PLACEMENT", ElementPlacement.AS_IS);
        REFERENCE_SORT = new DataKey<>("REFERENCE_SORT", ElementPlacementSort.AS_IS);
        KEEP_IMAGE_LINKS_AT_START = new DataKey<>("KEEP_IMAGE_LINKS_AT_START", bool);
        KEEP_EXPLICIT_LINKS_AT_START = new DataKey<>("KEEP_EXPLICIT_LINKS_AT_START", bool);
        OPTIMIZED_INLINE_RENDERING = new DataKey<>("OPTIMIZED_INLINE_RENDERING", bool);
        FORMAT_CHAR_WIDTH_PROVIDER = TableFormatOptions.FORMAT_CHAR_WIDTH_PROVIDER;
        KEEP_HARD_LINE_BREAKS = new DataKey<>("KEEP_HARD_LINE_BREAKS", bool2);
        KEEP_SOFT_LINE_BREAKS = new DataKey<>("KEEP_SOFT_LINE_BREAKS", bool2);
        FORMATTER_ON_TAG = new DataKey<>("FORMATTER_ON_TAG", "@formatter:on");
        FORMATTER_OFF_TAG = new DataKey<>("FORMATTER_OFF_TAG", "@formatter:off");
        FORMATTER_TAGS_ENABLED = new DataKey<>("FORMATTER_TAGS_ENABLED", bool);
        FORMATTER_TAGS_ACCEPT_REGEXP = new DataKey<>("FORMATTER_TAGS_ACCEPT_REGEXP", bool);
        LINK_MARKER_COMMENT_PATTERN = new NullableDataKey<>("FORMATTER_TAGS_ACCEPT_REGEXP", (Object) null);
        APPEND_TRANSFERRED_REFERENCES = new DataKey<>("APPEND_TRANSFERRED_REFERENCES", bool);
        TRANSLATION_ID_FORMAT = new DataKey<>("TRANSLATION_ID_FORMAT", "_%d_");
        TRANSLATION_HTML_BLOCK_PREFIX = new DataKey<>("TRANSLATION_HTML_BLOCK_PREFIX", "__");
        TRANSLATION_HTML_INLINE_PREFIX = new DataKey<>("TRANSLATION_HTML_INLINE_PREFIX", "_");
        TRANSLATION_AUTOLINK_PREFIX = new DataKey<>("TRANSLATION_AUTOLINK_PREFIX", "___");
        TRANSLATION_EXCLUDE_PATTERN = new DataKey<>("TRANSLATION_EXCLUDE_PATTERN", "^[^\\p{IsAlphabetic}]*$");
        TRANSLATION_HTML_BLOCK_TAG_PATTERN = Parser.TRANSLATION_HTML_BLOCK_TAG_PATTERN;
        TRANSLATION_HTML_INLINE_TAG_PATTERN = Parser.TRANSLATION_HTML_INLINE_TAG_PATTERN;
        DOC_RELATIVE_URL = new DataKey<>("DOC_RELATIVE_URL", "");
        DOC_ROOT_URL = new DataKey<>("DOC_ROOT_URL", "");
        DEFAULT_LINK_RESOLVER = new DataKey<>("DEFAULT_LINK_RESOLVER", bool);
        FORMATTER_EMULATION_PROFILE = new DataKey<>("FORMATTER_EMULATION_PROFILE", (DataKey) Parser.PARSER_EMULATION_PROFILE);
        TRACKED_OFFSETS = new DataKey<>("TRACKED_OFFSETS", Collections.EMPTY_LIST);
        BasedSequence basedSequence = BasedSequence.NULL;
        TRACKED_SEQUENCE = new DataKey<>("TRACKED_SEQUENCE", basedSequence);
        RESTORE_TRACKED_SPACES = new DataKey<>("RESTORE_END_SPACES", bool);
        DOCUMENT_FIRST_PREFIX = new DataKey<>("DOCUMENT_FIRST_PREFIX", basedSequence);
        DOCUMENT_PREFIX = new DataKey<>("DOCUMENT_PREFIX", basedSequence);
        SETEXT_HEADER_EQUALIZE_MARKER = dataKey;
        ATX_HEADER_TRAILING_MARKER = dataKey2;
        FORMAT_TABLE_CAPTION = TableFormatOptions.FORMAT_TABLE_CAPTION;
        FORMAT_TABLE_CAPTION_SPACES = TableFormatOptions.FORMAT_TABLE_CAPTION_SPACES;
        FORMAT_TABLE_INDENT_PREFIX = TableFormatOptions.FORMAT_TABLE_INDENT_PREFIX;
        UNIQUIFICATION_MAP = new DataKey<>("REFERENCES_UNIQUIFICATION_MAP", (NotNullValueSupplier) new C11807a());
        ATTRIBUTE_UNIQUIFICATION_ID_MAP = new DataKey<>("ATTRIBUTE_UNIQUIFICATION_ID_MAP", (NotNullValueSupplier) new C11807a());
        NULL_ITERATOR = new Iterator<Node>() { // from class: com.vladsch.flexmark.formatter.Formatter.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Node next() {
                return null;
            }

            @Override // java.util.Iterator
            public void remove() {
            }
        };
        NULL_ITERABLE = new C11808b();
    }

    public Formatter(Builder builder) {
        this.options = builder.toImmutable();
        HeaderIdGeneratorFactory headerIdGeneratorFactory = builder.htmlIdGeneratorFactory;
        this.idGeneratorFactory = headerIdGeneratorFactory == null ? new HeaderIdGenerator.Factory() : headerIdGeneratorFactory;
        this.linkResolverFactories = DependencyResolver.resolveFlatDependencies(builder.linkResolverFactories, null, null);
        this.nodeFormatterFactories = calculateNodeFormatterFactories(builder.nodeFormatterFactories);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static List<NodeFormatterFactory> calculateNodeFormatterFactories(List<NodeFormatterFactory> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(new CoreNodeFormatter.Factory());
        return DependencyResolver.resolveFlatDependencies(arrayList, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeRender$0(MutableDataSet mutableDataSet, int i, List[] listArr, TranslationContext translationContext, Document document, int i2) {
        TranslationHandler translationHandler = (TranslationHandler) translationContext;
        translationHandler.setRenderPurpose(RenderPurpose.TRANSLATION_SPANS);
        new MainNodeFormatter(mutableDataSet, new MarkdownWriter(i), document, translationHandler).render(document);
        listArr[i2] = translationHandler.getTranslatingTexts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$mergeRender$1(List[] listArr, MutableDataSet mutableDataSet, int i, int i2, int i4, Document[] documentArr, TranslationContext translationContext, Document document, int i5) {
        TranslationHandler translationHandler = (TranslationHandler) translationContext;
        translationHandler.setRenderPurpose(RenderPurpose.TRANSLATED_SPANS);
        translationHandler.setTranslatedTexts(listArr[i5]);
        MainNodeFormatter mainNodeFormatter = new MainNodeFormatter(mutableDataSet, new MarkdownWriter(i), document, translationHandler);
        mainNodeFormatter.render(document);
        StringBuilder sb = new StringBuilder();
        mainNodeFormatter.flushTo(sb, i2, i4);
        documentArr[i5] = Parser.builder(mutableDataSet).build().parse(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeRender$2(int i, MutableDataSet mutableDataSet, Appendable appendable, int i2, int i4, TranslationContext translationContext, Document document, int i5) {
        TranslationHandler translationHandler = (TranslationHandler) translationContext;
        translationHandler.setRenderPurpose(RenderPurpose.TRANSLATED);
        MarkdownWriter markdownWriter = new MarkdownWriter(i);
        MainNodeFormatter mainNodeFormatter = new MainNodeFormatter(mutableDataSet, markdownWriter, document, translationHandler);
        mainNodeFormatter.render(document);
        markdownWriter.blankLine();
        mainNodeFormatter.flushTo(appendable, i2, i4);
    }

    @Override // com.vladsch.flexmark.util.ast.IRender
    @NotNull
    public DataHolder getOptions() {
        return this.options;
    }

    public TranslationHandler getTranslationHandler(TranslationHandlerFactory translationHandlerFactory, HtmlIdGeneratorFactory htmlIdGeneratorFactory) {
        return translationHandlerFactory.create(this.options, htmlIdGeneratorFactory);
    }

    public void mergeRender(Document[] documentArr, Appendable appendable) {
        mergeRender(documentArr, appendable, MAX_TRAILING_BLANK_LINES.get(this.options).intValue());
    }

    @Override // com.vladsch.flexmark.util.ast.IRender
    public void render(@NotNull Node node, @NotNull Appendable appendable) {
        render(node, appendable, MAX_TRAILING_BLANK_LINES.get(this.options).intValue());
    }

    public void translationRender(Node node, Appendable appendable, TranslationHandler translationHandler, RenderPurpose renderPurpose) {
        translationRender(node, appendable, MAX_TRAILING_BLANK_LINES.get(this.options).intValue(), translationHandler, renderPurpose);
    }

    public static Builder builder(DataHolder dataHolder) {
        return new Builder(dataHolder);
    }

    public TranslationHandler getTranslationHandler(HtmlIdGeneratorFactory htmlIdGeneratorFactory) {
        return new TranslationHandlerImpl(this.options, htmlIdGeneratorFactory);
    }

    public void mergeRender(List<Document> list, Appendable appendable) {
        mergeRender((Document[]) list.toArray(EMPTY_DOCUMENTS), appendable);
    }

    public void render(@NotNull Node node, @NotNull Appendable appendable, int i) {
        MarkdownWriter markdownWriter = new MarkdownWriter(appendable, FORMAT_FLAGS.get(this.options).intValue());
        MainNodeFormatter mainNodeFormatter = new MainNodeFormatter(this.options, markdownWriter, node.getDocument(), null);
        mainNodeFormatter.render(node);
        markdownWriter.appendToSilently(appendable, MAX_BLANK_LINES.get(this.options).intValue(), i);
        BasedSequence chars = node.getDocument().getChars();
        if (appendable instanceof SequenceBuilder) {
            BasedSequence chars2 = node.getDocument().getChars();
            BasedSequence basedSequence = mainNodeFormatter.trackedSequence;
            if (chars2 != basedSequence) {
                chars = ((SequenceBuilder) appendable).toSequence(basedSequence);
            }
        }
        TrackedOffsetUtils.resolveTrackedOffsets(chars, markdownWriter, mainNodeFormatter.trackedOffsets.getUnresolvedOffsets(), i, SharedDataKeys.RUNNING_TESTS.get(this.options).booleanValue());
    }

    public String translationRender(Node node, TranslationHandler translationHandler, RenderPurpose renderPurpose) {
        StringBuilder sb = new StringBuilder();
        translationRender(node, sb, translationHandler, renderPurpose);
        return sb.toString();
    }

    public TranslationHandler getTranslationHandler() {
        return new TranslationHandlerImpl(this.options, this.idGeneratorFactory);
    }

    public String mergeRender(Document[] documentArr, int i) {
        StringBuilder sb = new StringBuilder();
        mergeRender(documentArr, sb, i);
        return sb.toString();
    }

    public void translationRender(Node node, Appendable appendable, int i, TranslationHandler translationHandler, RenderPurpose renderPurpose) {
        translationHandler.setRenderPurpose(renderPurpose);
        MainNodeFormatter mainNodeFormatter = new MainNodeFormatter(this.options, new MarkdownWriter(FORMAT_FLAGS.get(this.options).intValue() & (~LineAppendable.F_TRIM_LEADING_WHITESPACE)), node.getDocument(), translationHandler);
        mainNodeFormatter.render(node);
        mainNodeFormatter.flushTo(appendable, MAX_BLANK_LINES.get(this.options).intValue(), i);
    }

    public String mergeRender(List<Document> list, int i) {
        return mergeRender((Document[]) list.toArray(EMPTY_DOCUMENTS), i);
    }

    public void mergeRender(List<Document> list, Appendable appendable, int i) {
        mergeRender((Document[]) list.toArray(EMPTY_DOCUMENTS), appendable, i);
    }

    public void mergeRender(Document[] documentArr, final Appendable appendable, final int i) {
        final MutableDataSet mutableDataSet = new MutableDataSet(this.options);
        mutableDataSet.set(Parser.HTML_FOR_TRANSLATOR, Boolean.TRUE);
        TranslationHandler[] translationHandlerArr = new TranslationHandler[documentArr.length];
        final List[] listArr = new List[documentArr.length];
        int length = documentArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            HtmlIdGeneratorFactory factory = this.idGeneratorFactory;
            if (factory == null) {
                factory = new HeaderIdGenerator.Factory();
            }
            translationHandlerArr[i2] = getTranslationHandler(factory);
        }
        MergeContextImpl mergeContextImpl = new MergeContextImpl(documentArr, translationHandlerArr);
        final int iIntValue = FORMAT_FLAGS.get(this.options).intValue();
        final int iIntValue2 = MAX_BLANK_LINES.get(this.options).intValue();
        mergeContextImpl.forEachPrecedingDocument(null, new MergeContextConsumer() { // from class: com.vladsch.flexmark.formatter.c
            @Override // com.vladsch.flexmark.formatter.MergeContextConsumer
            public final void accept(TranslationContext translationContext, Document document, int i4) {
                this.f8322a.lambda$mergeRender$0(mutableDataSet, iIntValue, listArr, translationContext, document, i4);
            }
        });
        final Document[] documentArr2 = new Document[documentArr.length];
        mergeContextImpl.forEachPrecedingDocument(null, new MergeContextConsumer() { // from class: com.vladsch.flexmark.formatter.d
            @Override // com.vladsch.flexmark.formatter.MergeContextConsumer
            public final void accept(TranslationContext translationContext, Document document, int i4) {
                this.f8326a.lambda$mergeRender$1(listArr, mutableDataSet, iIntValue, iIntValue2, i, documentArr2, translationContext, document, i4);
            }
        });
        mergeContextImpl.setDocuments(documentArr2);
        mergeContextImpl.forEachPrecedingDocument(null, new MergeContextConsumer() { // from class: com.vladsch.flexmark.formatter.e
            @Override // com.vladsch.flexmark.formatter.MergeContextConsumer
            public final void accept(TranslationContext translationContext, Document document, int i4) {
                this.f8333a.lambda$mergeRender$2(iIntValue, mutableDataSet, appendable, iIntValue2, i, translationContext, document, i4);
            }
        });
    }

    @Override // com.vladsch.flexmark.util.ast.IRender
    @NotNull
    public String render(@NotNull Node node) {
        StringBuilder sb = new StringBuilder();
        render(node, sb);
        return sb.toString();
    }
}
