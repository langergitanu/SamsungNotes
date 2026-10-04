package com.vladsch.flexmark.html;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.vladsch.flexmark.formatter.C11807a;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
import com.vladsch.flexmark.html.renderer.HeaderIdGenerator;
import com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory;
import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.html.renderer.LinkStatus;
import com.vladsch.flexmark.html.renderer.LinkType;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.html.renderer.PhasedNodeRenderer;
import com.vladsch.flexmark.html.renderer.RenderingPhase;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.IRender;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.builder.BuilderBase;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.DataSet;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.NotNullValueSupplier;
import com.vladsch.flexmark.util.data.NullableDataKey;
import com.vladsch.flexmark.util.data.ScopedDataSet;
import com.vladsch.flexmark.util.data.SharedDataKeys;
import com.vladsch.flexmark.util.dependency.DependencyResolver;
import com.vladsch.flexmark.util.format.TrackedOffset;
import com.vladsch.flexmark.util.format.TrackedOffsetUtils;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.html.MutableAttributes;
import com.vladsch.flexmark.util.misc.Extension;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.TagRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlRenderer implements IRender {
    public static final DataKey<String> AUTOLINK_WWW_PREFIX;

    @Deprecated
    public static final int COLLAPSE_WHITESPACE;

    @Deprecated
    public static final int CONVERT_TABS;
    public static final DataKey<Boolean> DO_NOT_RENDER_LINKS;
    public static final DataKey<Boolean> EMBEDDED_ATTRIBUTE_PROVIDER;
    public static final DataKey<Boolean> ESCAPE_HTML;
    public static final DataKey<Boolean> ESCAPE_HTML_BLOCKS;
    public static final DataKey<Boolean> ESCAPE_HTML_COMMENT_BLOCKS;
    public static final DataKey<Boolean> ESCAPE_INLINE_HTML;
    public static final DataKey<Boolean> ESCAPE_INLINE_HTML_COMMENTS;
    public static final DataKey<HashMap<String, String>> FENCED_CODE_LANGUAGE_CLASS_MAP;
    public static final DataKey<String> FENCED_CODE_LANGUAGE_CLASS_PREFIX;
    public static final DataKey<String> FENCED_CODE_LANGUAGE_DELIMITERS;
    public static final DataKey<String> FENCED_CODE_NO_LANGUAGE_CLASS;

    @Deprecated
    public static final int FORMAT_ALL;

    @Deprecated
    public static final int FORMAT_ALL_OPTIONS;

    @Deprecated
    public static final int FORMAT_COLLAPSE_WHITESPACE;

    @Deprecated
    public static final int FORMAT_CONVERT_TABS;
    public static final DataKey<Integer> FORMAT_FLAGS;

    @Deprecated
    public static final int FORMAT_SUPPRESS_TRAILING_WHITESPACE;
    public static final DataKey<Boolean> GENERATE_HEADER_ID;
    public static final DataKey<Boolean> HEADER_ID_ADD_EMOJI_SHORTCUT;
    public static final DataKey<Boolean> HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE;
    public static final DataKey<String> HEADER_ID_GENERATOR_NON_DASH_CHARS;
    public static final DataKey<Boolean> HEADER_ID_GENERATOR_NO_DUPED_DASHES;
    public static final DataKey<Boolean> HEADER_ID_GENERATOR_RESOLVE_DUPES;
    public static final DataKey<String> HEADER_ID_GENERATOR_TO_DASH_CHARS;
    public static final DataKey<Boolean> HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES;
    public static final DataKey<Boolean> HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES;
    public static final DataKey<Boolean> HTML_BLOCK_CLOSE_TAG_EOL;
    public static final DataKey<Boolean> HTML_BLOCK_OPEN_TAG_EOL;
    public static final DataKey<Integer> MAX_BLANK_LINES;
    public static final DataKey<Integer> MAX_TRAILING_BLANK_LINES;
    public static final DataKey<Boolean> NO_P_TAGS_USE_BR;
    public static final DataKey<Boolean> OBFUSCATE_EMAIL;
    public static final DataKey<Boolean> OBFUSCATE_EMAIL_RANDOM;

    @Deprecated
    public static final int PASS_THROUGH;
    public static final DataKey<Boolean> RECHECK_UNDEFINED_REFERENCES;
    public static final DataKey<List<Pair<String, String>>> RENDERER_TYPE_EQUIVALENCE;
    public static final DataKey<Boolean> RENDER_HEADER_ID;
    public static final DataKey<String> SOURCE_POSITION_ATTRIBUTE;
    public static final DataKey<Boolean> SOURCE_POSITION_PARAGRAPH_LINES;
    public static final DataKey<Boolean> SOURCE_WRAP_HTML;
    public static final DataKey<Boolean> SOURCE_WRAP_HTML_BLOCKS;
    public static final DataKey<String> SUPPRESSED_LINKS;
    public static final DataKey<Boolean> SUPPRESS_HTML;
    public static final DataKey<Boolean> SUPPRESS_HTML_BLOCKS;
    public static final DataKey<Boolean> SUPPRESS_HTML_COMMENT_BLOCKS;
    public static final DataKey<Boolean> SUPPRESS_INLINE_HTML;
    public static final DataKey<Boolean> SUPPRESS_INLINE_HTML_COMMENTS;

    @Deprecated
    public static final int SUPPRESS_TRAILING_WHITESPACE;
    public static final DataKey<ArrayList<TagRange>> TAG_RANGES;
    public static final DataKey<List<TrackedOffset>> TRACKED_OFFSETS;
    public static final DataKey<String> TYPE;
    public static final DataKey<Boolean> UNESCAPE_HTML_ENTITIES;
    final List<AttributeProviderFactory> attributeProviderFactories;
    final HeaderIdGeneratorFactory htmlIdGeneratorFactory;
    final HtmlRendererOptions htmlOptions;
    final List<LinkResolverFactory> linkResolverFactories;
    final List<DelegatingNodeRendererFactoryWrapper> nodeRendererFactories;
    final DataHolder options;
    public static final DataKey<String> SOFT_BREAK = new DataKey<>("SOFT_BREAK", "\n");
    public static final DataKey<String> HARD_BREAK = new DataKey<>("HARD_BREAK", "<br />\n");
    public static final NullableDataKey<String> STRONG_EMPHASIS_STYLE_HTML_OPEN = new NullableDataKey<>("STRONG_EMPHASIS_STYLE_HTML_OPEN");
    public static final NullableDataKey<String> STRONG_EMPHASIS_STYLE_HTML_CLOSE = new NullableDataKey<>("STRONG_EMPHASIS_STYLE_HTML_CLOSE");
    public static final NullableDataKey<String> EMPHASIS_STYLE_HTML_OPEN = new NullableDataKey<>("EMPHASIS_STYLE_HTML_OPEN");
    public static final NullableDataKey<String> EMPHASIS_STYLE_HTML_CLOSE = new NullableDataKey<>("EMPHASIS_STYLE_HTML_CLOSE");
    public static final NullableDataKey<String> CODE_STYLE_HTML_OPEN = new NullableDataKey<>("CODE_STYLE_HTML_OPEN");
    public static final NullableDataKey<String> CODE_STYLE_HTML_CLOSE = new NullableDataKey<>("CODE_STYLE_HTML_CLOSE");
    public static final NullableDataKey<String> INLINE_CODE_SPLICE_CLASS = new NullableDataKey<>("INLINE_CODE_SPLICE_CLASS");
    public static final DataKey<Boolean> PERCENT_ENCODE_URLS = SharedDataKeys.PERCENT_ENCODE_URLS;
    public static final DataKey<Integer> INDENT_SIZE = SharedDataKeys.INDENT_SIZE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder extends BuilderBase<Builder> implements RendererBuilder {
        Map<Class<?>, AttributeProviderFactory> attributeProviderFactories;
        HeaderIdGeneratorFactory htmlIdGeneratorFactory;
        List<LinkResolverFactory> linkResolverFactories;
        List<NodeRendererFactory> nodeRendererFactories;

        public Builder() {
            this.attributeProviderFactories = new LinkedHashMap();
            this.nodeRendererFactories = new ArrayList();
            this.linkResolverFactories = new ArrayList();
            this.htmlIdGeneratorFactory = null;
        }

        @NotNull
        public Builder escapeHtml(boolean z) {
            set(HtmlRenderer.ESCAPE_HTML, Boolean.valueOf(z));
            return this;
        }

        @NotNull
        public Builder indentSize(int i) {
            set(HtmlRenderer.INDENT_SIZE, Integer.valueOf(i));
            return this;
        }

        public boolean isRendererType(@NotNull String str) {
            return HtmlRenderer.isCompatibleRendererType(this, HtmlRenderer.TYPE.get(this), str);
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        public boolean loadExtension(@NotNull Extension extension) {
            if (extension instanceof HtmlRendererExtension) {
                ((HtmlRendererExtension) extension).extend(this, HtmlRenderer.TYPE.get(this));
                return true;
            }
            if (!(extension instanceof RendererExtension)) {
                return false;
            }
            ((RendererExtension) extension).extend(this, HtmlRenderer.TYPE.get(this));
            return true;
        }

        @NotNull
        public Builder nodeRendererFactory(@NotNull NodeRendererFactory nodeRendererFactory) {
            this.nodeRendererFactories.add(nodeRendererFactory);
            addExtensionApiPoint(nodeRendererFactory);
            return this;
        }

        @NotNull
        public Builder percentEncodeUrls(boolean z) {
            set(HtmlRenderer.PERCENT_ENCODE_URLS, Boolean.valueOf(z));
            return this;
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        public void preloadExtension(@NotNull Extension extension) {
            if (extension instanceof HtmlRendererExtension) {
                ((HtmlRendererExtension) extension).rendererOptions(this);
            } else if (extension instanceof RendererExtension) {
                ((RendererExtension) extension).rendererOptions(this);
            }
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        public void removeApiPoint(@NotNull Object obj) {
            if (obj instanceof AttributeProviderFactory) {
                this.attributeProviderFactories.remove(obj.getClass());
                return;
            }
            if (obj instanceof NodeRendererFactory) {
                this.nodeRendererFactories.remove(obj);
            } else if (obj instanceof LinkResolverFactory) {
                this.linkResolverFactories.remove(obj);
            } else {
                if (!(obj instanceof HeaderIdGeneratorFactory)) {
                    throw new IllegalStateException("Unknown data point type: ".concat(obj.getClass().getName()));
                }
                this.htmlIdGeneratorFactory = null;
            }
        }

        @NotNull
        public Builder softBreak(@NotNull String str) {
            set(HtmlRenderer.SOFT_BREAK, str);
            return this;
        }

        @Override // com.vladsch.flexmark.html.RendererBuilder
        @NotNull
        public Builder attributeProviderFactory(@NotNull AttributeProviderFactory attributeProviderFactory) {
            this.attributeProviderFactories.put(attributeProviderFactory.getClass(), attributeProviderFactory);
            addExtensionApiPoint(attributeProviderFactory);
            return this;
        }

        @Override // com.vladsch.flexmark.util.builder.BuilderBase
        @NotNull
        public HtmlRenderer build() {
            return new HtmlRenderer(this);
        }

        @Override // com.vladsch.flexmark.html.RendererBuilder
        @NotNull
        public Builder contentResolverFactory(@NotNull UriContentResolverFactory uriContentResolverFactory) {
            throw new IllegalStateException("Not implemented");
        }

        @Override // com.vladsch.flexmark.html.RendererBuilder
        @NotNull
        public Builder htmlIdGeneratorFactory(@NotNull HeaderIdGeneratorFactory headerIdGeneratorFactory) {
            if (this.htmlIdGeneratorFactory != null) {
                throw new IllegalStateException("custom header id factory is already set to ".concat(headerIdGeneratorFactory.getClass().getName()));
            }
            this.htmlIdGeneratorFactory = headerIdGeneratorFactory;
            addExtensionApiPoint(headerIdGeneratorFactory);
            return this;
        }

        @Override // com.vladsch.flexmark.html.RendererBuilder
        @NotNull
        public Builder linkResolverFactory(@NotNull LinkResolverFactory linkResolverFactory) {
            this.linkResolverFactories.add(linkResolverFactory);
            addExtensionApiPoint(linkResolverFactory);
            return this;
        }

        public Builder(@Nullable DataHolder dataHolder) {
            super(dataHolder);
            this.attributeProviderFactories = new LinkedHashMap();
            this.nodeRendererFactories = new ArrayList();
            this.linkResolverFactories = new ArrayList();
            this.htmlIdGeneratorFactory = null;
            loadExtensions();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HtmlRendererExtension extends Extension {
        void extend(@NotNull Builder builder, @NotNull String str);

        void rendererOptions(@NotNull MutableDataHolder mutableDataHolder);
    }

    static {
        Boolean bool = Boolean.FALSE;
        DataKey<Boolean> dataKey = new DataKey<>("ESCAPE_HTML", bool);
        ESCAPE_HTML = dataKey;
        DataKey<Boolean> dataKey2 = new DataKey<>("ESCAPE_HTML_BLOCKS", dataKey);
        ESCAPE_HTML_BLOCKS = dataKey2;
        ESCAPE_HTML_COMMENT_BLOCKS = new DataKey<>("ESCAPE_HTML_COMMENT_BLOCKS", (DataKey) dataKey2);
        DataKey<Boolean> dataKey3 = new DataKey<>("ESCAPE_HTML_BLOCKS", dataKey);
        ESCAPE_INLINE_HTML = dataKey3;
        ESCAPE_INLINE_HTML_COMMENTS = new DataKey<>("ESCAPE_INLINE_HTML_COMMENTS", (DataKey) dataKey3);
        DataKey<Boolean> dataKey4 = new DataKey<>("SUPPRESS_HTML", bool);
        SUPPRESS_HTML = dataKey4;
        DataKey<Boolean> dataKey5 = new DataKey<>("SUPPRESS_HTML_BLOCKS", dataKey4);
        SUPPRESS_HTML_BLOCKS = dataKey5;
        SUPPRESS_HTML_COMMENT_BLOCKS = new DataKey<>("SUPPRESS_HTML_COMMENT_BLOCKS", (DataKey) dataKey5);
        DataKey<Boolean> dataKey6 = new DataKey<>("SUPPRESS_INLINE_HTML", dataKey4);
        SUPPRESS_INLINE_HTML = dataKey6;
        SUPPRESS_INLINE_HTML_COMMENTS = new DataKey<>("SUPPRESS_INLINE_HTML_COMMENTS", (DataKey) dataKey6);
        DataKey<Boolean> dataKey7 = new DataKey<>("SOURCE_WRAP_HTML", bool);
        SOURCE_WRAP_HTML = dataKey7;
        SOURCE_WRAP_HTML_BLOCKS = new DataKey<>("SOURCE_WRAP_HTML_BLOCKS", (DataKey) dataKey7);
        HEADER_ID_GENERATOR_RESOLVE_DUPES = SharedDataKeys.HEADER_ID_GENERATOR_RESOLVE_DUPES;
        HEADER_ID_GENERATOR_TO_DASH_CHARS = SharedDataKeys.HEADER_ID_GENERATOR_TO_DASH_CHARS;
        HEADER_ID_GENERATOR_NON_DASH_CHARS = SharedDataKeys.HEADER_ID_GENERATOR_NON_DASH_CHARS;
        HEADER_ID_GENERATOR_NO_DUPED_DASHES = SharedDataKeys.HEADER_ID_GENERATOR_NO_DUPED_DASHES;
        HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE = SharedDataKeys.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE;
        HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES = SharedDataKeys.HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES;
        HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES = SharedDataKeys.HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES;
        HEADER_ID_ADD_EMOJI_SHORTCUT = SharedDataKeys.HEADER_ID_ADD_EMOJI_SHORTCUT;
        RENDER_HEADER_ID = SharedDataKeys.RENDER_HEADER_ID;
        GENERATE_HEADER_ID = SharedDataKeys.GENERATE_HEADER_ID;
        DO_NOT_RENDER_LINKS = SharedDataKeys.DO_NOT_RENDER_LINKS;
        FENCED_CODE_LANGUAGE_CLASS_PREFIX = new DataKey<>("FENCED_CODE_LANGUAGE_CLASS_PREFIX", "language-");
        FENCED_CODE_LANGUAGE_CLASS_MAP = new DataKey<>("FENCED_CODE_LANGUAGE_CLASS_MAP", (NotNullValueSupplier) new C11807a());
        FENCED_CODE_NO_LANGUAGE_CLASS = new DataKey<>("FENCED_CODE_NO_LANGUAGE_CLASS", "");
        FENCED_CODE_LANGUAGE_DELIMITERS = new DataKey<>("FENCED_CODE_LANGUAGE_DELIMITERS", " \t");
        SOURCE_POSITION_ATTRIBUTE = new DataKey<>("SOURCE_POSITION_ATTRIBUTE", "");
        SOURCE_POSITION_PARAGRAPH_LINES = new DataKey<>("SOURCE_POSITION_PARAGRAPH_LINES", bool);
        TYPE = new DataKey<>(CredentialProviderBaseController.TYPE_TAG, "HTML");
        TAG_RANGES = new DataKey<>("TAG_RANGES", (NotNullValueSupplier) new C11822b());
        RECHECK_UNDEFINED_REFERENCES = new DataKey<>("RECHECK_UNDEFINED_REFERENCES", bool);
        OBFUSCATE_EMAIL = new DataKey<>("OBFUSCATE_EMAIL", bool);
        Boolean bool2 = Boolean.TRUE;
        OBFUSCATE_EMAIL_RANDOM = new DataKey<>("OBFUSCATE_EMAIL_RANDOM", bool2);
        HTML_BLOCK_OPEN_TAG_EOL = new DataKey<>("HTML_BLOCK_OPEN_TAG_EOL", bool2);
        HTML_BLOCK_CLOSE_TAG_EOL = new DataKey<>("HTML_BLOCK_CLOSE_TAG_EOL", bool2);
        UNESCAPE_HTML_ENTITIES = new DataKey<>("UNESCAPE_HTML_ENTITIES", bool2);
        AUTOLINK_WWW_PREFIX = new DataKey<>("AUTOLINK_WWW_PREFIX", WebConstants.HTTP_PROTOCOL);
        SUPPRESSED_LINKS = new DataKey<>("SUPPRESSED_LINKS", "javascript:.*");
        NO_P_TAGS_USE_BR = new DataKey<>("NO_P_TAGS_USE_BR", bool);
        EMBEDDED_ATTRIBUTE_PROVIDER = new DataKey<>("EMBEDDED_ATTRIBUTE_PROVIDER", bool2);
        FORMAT_FLAGS = new DataKey<>("RENDERER_FORMAT_FLAGS", Integer.valueOf(LineAppendable.F_TRIM_LEADING_WHITESPACE));
        MAX_TRAILING_BLANK_LINES = SharedDataKeys.RENDERER_MAX_TRAILING_BLANK_LINES;
        MAX_BLANK_LINES = SharedDataKeys.RENDERER_MAX_BLANK_LINES;
        int i = LineAppendable.F_CONVERT_TABS;
        CONVERT_TABS = i;
        int i2 = LineAppendable.F_COLLAPSE_WHITESPACE;
        COLLAPSE_WHITESPACE = i2;
        int i4 = LineAppendable.F_TRIM_TRAILING_WHITESPACE;
        SUPPRESS_TRAILING_WHITESPACE = i4;
        PASS_THROUGH = LineAppendable.F_PASS_THROUGH;
        int i5 = LineAppendable.F_FORMAT_ALL;
        FORMAT_ALL = i5;
        List list = Collections.EMPTY_LIST;
        RENDERER_TYPE_EQUIVALENCE = new DataKey<>("RENDERER_TYPE_EQUIVALENCE", list);
        FORMAT_CONVERT_TABS = i;
        FORMAT_COLLAPSE_WHITESPACE = i2;
        FORMAT_SUPPRESS_TRAILING_WHITESPACE = i4;
        FORMAT_ALL_OPTIONS = i5;
        TRACKED_OFFSETS = new DataKey<>("TRACKED_OFFSETS", list);
    }

    public HtmlRenderer(@NotNull Builder builder) {
        DataSet immutable = builder.toImmutable();
        this.options = immutable;
        this.htmlOptions = new HtmlRendererOptions(immutable);
        this.htmlIdGeneratorFactory = builder.htmlIdGeneratorFactory;
        ArrayList arrayList = new ArrayList(builder.nodeRendererFactories.size());
        for (int size = builder.nodeRendererFactories.size() - 1; size >= 0; size--) {
            arrayList.add(new DelegatingNodeRendererFactoryWrapper(arrayList, builder.nodeRendererFactories.get(size)));
        }
        arrayList.add(new DelegatingNodeRendererFactoryWrapper(arrayList, new CoreNodeRenderer.Factory()));
        this.nodeRendererFactories = DependencyResolver.resolveFlatDependencies(arrayList, null, new C11821a(0));
        Map<Class<?>, AttributeProviderFactory> map = builder.attributeProviderFactories;
        IndependentAttributeProviderFactory independentAttributeProviderFactory = EmbeddedAttributeProvider.Factory;
        boolean zContainsKey = map.containsKey(independentAttributeProviderFactory.getClass());
        ArrayList arrayList2 = new ArrayList(builder.attributeProviderFactories.values());
        if (!zContainsKey && EMBEDDED_ATTRIBUTE_PROVIDER.get(this.options).booleanValue()) {
            arrayList2.add(0, independentAttributeProviderFactory);
        }
        this.attributeProviderFactories = DependencyResolver.resolveFlatDependencies(arrayList2, null, null);
        this.linkResolverFactories = DependencyResolver.resolveFlatDependencies(builder.linkResolverFactories, null, null);
    }

    @NotNull
    public static MutableDataHolder addRenderTypeEquivalence(@NotNull MutableDataHolder mutableDataHolder, @NotNull String str, @NotNull String str2) {
        if (!isCompatibleRendererType(mutableDataHolder, str, str2)) {
            DataKey<List<Pair<String, String>>> dataKey = RENDERER_TYPE_EQUIVALENCE;
            ArrayList arrayList = new ArrayList(dataKey.get(mutableDataHolder));
            arrayList.add(new Pair(str, str2));
            mutableDataHolder.set((DataKey<ArrayList>) dataKey, arrayList);
        }
        return mutableDataHolder;
    }

    @NotNull
    public static Builder builder() {
        return new Builder();
    }

    public static boolean isCompatibleRendererType(@NotNull MutableDataHolder mutableDataHolder, @NotNull String str) {
        return isCompatibleRendererType(mutableDataHolder, TYPE.get(mutableDataHolder), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$new$0(DelegatingNodeRendererFactoryWrapper delegatingNodeRendererFactoryWrapper) {
        return delegatingNodeRendererFactoryWrapper.getFactory().getClass();
    }

    @Override // com.vladsch.flexmark.util.ast.IRender
    @NotNull
    public DataHolder getOptions() {
        return this.options;
    }

    @Override // com.vladsch.flexmark.util.ast.IRender
    public void render(@NotNull Node node, @NotNull Appendable appendable) {
        render(node, appendable, this.htmlOptions.maxTrailingBlankLines);
    }

    @NotNull
    public static Builder builder(@Nullable DataHolder dataHolder) {
        return new Builder(dataHolder);
    }

    public void render(@NotNull Node node, @NotNull Appendable appendable, int i) {
        HtmlRendererOptions htmlRendererOptions = this.htmlOptions;
        HtmlWriter htmlWriter = new HtmlWriter(appendable, htmlRendererOptions.indentSize, htmlRendererOptions.formatFlags, !htmlRendererOptions.htmlBlockOpenTagEol, !htmlRendererOptions.htmlBlockCloseTagEol);
        MainNodeRenderer mainNodeRenderer = new MainNodeRenderer(this.options, htmlWriter, node.getDocument());
        HtmlIdGenerator htmlIdGenerator = mainNodeRenderer.htmlIdGenerator;
        if (htmlIdGenerator != HtmlIdGenerator.NULL && !(node instanceof Document)) {
            htmlIdGenerator.generateIds(node.getDocument());
        }
        mainNodeRenderer.render(node);
        htmlWriter.appendToSilently(appendable, this.htmlOptions.maxBlankLines, i);
        TrackedOffsetUtils.resolveTrackedOffsets(node.getChars(), htmlWriter, TRACKED_OFFSETS.get(mainNodeRenderer.getDocument()), i, SharedDataKeys.RUNNING_TESTS.get(this.options).booleanValue());
        mainNodeRenderer.dispose();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MainNodeRenderer extends NodeRendererSubContext implements NodeRendererContext, Disposable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private AttributeProvider[] attributeProviders;
        private Document document;
        HtmlIdGenerator htmlIdGenerator;
        private LinkResolver[] myLinkResolvers;
        private DataHolder options;
        private RenderingPhase phase;
        private List<PhasedNodeRenderer> phasedRenderers;
        private Map<Class<?>, NodeRenderingHandlerWrapper> renderers;
        private Set<RenderingPhase> renderingPhases;
        private HashMap<LinkType, HashMap<String, ResolvedLink>> resolvedLinkMap;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class SubNodeRenderer extends NodeRendererSubContext implements NodeRendererContext {
            private final MainNodeRenderer myMainNodeRenderer;

            public SubNodeRenderer(MainNodeRenderer mainNodeRenderer, HtmlWriter htmlWriter, boolean z) {
                super(htmlWriter);
                this.myMainNodeRenderer = mainNodeRenderer;
                this.doNotRenderLinksNesting = mainNodeRenderer.getHtmlOptions().doNotRenderLinksInDocument ? 1 : 0;
                if (z) {
                    this.renderingNode = mainNodeRenderer.renderingNode;
                    this.renderingHandlerWrapper = mainNodeRenderer.renderingHandlerWrapper;
                }
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            public void delegateRender() {
                this.myMainNodeRenderer.renderByPreviousHandler(this);
            }

            @Override // com.vladsch.flexmark.html.NodeRendererSubContext, com.vladsch.flexmark.html.renderer.NodeRendererContext
            public void doNotRenderLinks(boolean z) {
                super.doNotRenderLinks(z);
            }

            @Override // com.vladsch.flexmark.html.NodeRendererSubContext, com.vladsch.flexmark.html.renderer.NodeRendererContext
            public void doRenderLinks() {
                super.doRenderLinks();
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public String encodeUrl(@NotNull CharSequence charSequence) {
                return this.myMainNodeRenderer.encodeUrl(charSequence);
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            @NotNull
            public MutableAttributes extendRenderingNodeAttributes(@NotNull AttributablePart attributablePart, Attributes attributes) {
                return this.myMainNodeRenderer.extendRenderingNodeAttributes(attributablePart, attributes);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public Node getCurrentNode() {
                return this.myMainNodeRenderer.getCurrentNode();
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            @NotNull
            public NodeRendererContext getDelegatedSubContext(boolean z) {
                HtmlWriter htmlWriter = new HtmlWriter(this.htmlWriter, z);
                htmlWriter.setContext(this);
                return MainNodeRenderer.this.new SubNodeRenderer(this.myMainNodeRenderer, htmlWriter, true);
            }

            @Override // com.vladsch.flexmark.html.NodeRendererSubContext
            public int getDoNotRenderLinksNesting() {
                return super.getDoNotRenderLinksNesting();
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
            @NotNull
            public Document getDocument() {
                return this.myMainNodeRenderer.getDocument();
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            @NotNull
            public HtmlRendererOptions getHtmlOptions() {
                return this.myMainNodeRenderer.getHtmlOptions();
            }

            @Override // com.vladsch.flexmark.html.NodeRendererSubContext, com.vladsch.flexmark.html.renderer.NodeRendererContext
            @NotNull
            public HtmlWriter getHtmlWriter() {
                return this.htmlWriter;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            public String getNodeId(@NotNull Node node) {
                return this.myMainNodeRenderer.getNodeId(node);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
            @NotNull
            public DataHolder getOptions() {
                return this.myMainNodeRenderer.getOptions();
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            @NotNull
            public RenderingPhase getRenderingPhase() {
                return this.myMainNodeRenderer.getRenderingPhase();
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            @NotNull
            public NodeRendererContext getSubContext(boolean z) {
                HtmlWriter htmlWriter = new HtmlWriter(this.htmlWriter, z);
                htmlWriter.setContext(this);
                return MainNodeRenderer.this.new SubNodeRenderer(this.myMainNodeRenderer, htmlWriter, false);
            }

            @Override // com.vladsch.flexmark.html.NodeRendererSubContext, com.vladsch.flexmark.html.renderer.NodeRendererContext
            public boolean isDoNotRenderLinks() {
                return super.isDoNotRenderLinks();
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            public void render(@NotNull Node node) {
                this.myMainNodeRenderer.renderNode(node, this);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            public void renderChildren(@NotNull Node node) {
                this.myMainNodeRenderer.renderChildrenNode(node, this);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, Boolean bool) {
                return this.myMainNodeRenderer.resolveLink(linkType, charSequence, bool);
            }

            @Override // com.vladsch.flexmark.html.NodeRendererSubContext, com.vladsch.flexmark.html.renderer.NodeRendererContext
            public void doNotRenderLinks() {
                super.doNotRenderLinks();
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
            @NotNull
            public MutableAttributes extendRenderingNodeAttributes(@NotNull Node node, @NotNull AttributablePart attributablePart, Attributes attributes) {
                return this.myMainNodeRenderer.extendRenderingNodeAttributes(node, attributablePart, attributes);
            }

            @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
            @NotNull
            public ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, Attributes attributes, Boolean bool) {
                return this.myMainNodeRenderer.resolveLink(linkType, charSequence, attributes, bool);
            }
        }

        public MainNodeRenderer(DataHolder dataHolder, HtmlWriter htmlWriter, Document document) {
            super(htmlWriter);
            this.resolvedLinkMap = new HashMap<>();
            this.options = new ScopedDataSet(document, dataHolder);
            this.document = document;
            this.renderers = new HashMap(32);
            this.renderingPhases = new HashSet(RenderingPhase.values().length);
            this.phasedRenderers = new ArrayList(HtmlRenderer.this.nodeRendererFactories.size());
            this.myLinkResolvers = new LinkResolver[HtmlRenderer.this.linkResolverFactories.size()];
            HtmlRendererOptions htmlRendererOptions = HtmlRenderer.this.htmlOptions;
            this.doNotRenderLinksNesting = !htmlRendererOptions.doNotRenderLinksInDocument ? 1 : 0;
            HeaderIdGeneratorFactory headerIdGeneratorFactory = HtmlRenderer.this.htmlIdGeneratorFactory;
            this.htmlIdGenerator = headerIdGeneratorFactory != null ? headerIdGeneratorFactory.create(this) : !htmlRendererOptions.generateHeaderIds ? HtmlIdGenerator.NULL : new HeaderIdGenerator.Factory().create((LinkResolverContext) this);
            htmlWriter.setContext(this);
            for (int size = HtmlRenderer.this.nodeRendererFactories.size() - 1; size >= 0; size--) {
                NodeRenderer nodeRendererApply = HtmlRenderer.this.nodeRendererFactories.get(size).apply(getOptions());
                for (NodeRenderingHandler<?> nodeRenderingHandler : nodeRendererApply.getNodeRenderingHandlers()) {
                    this.renderers.put(nodeRenderingHandler.getNodeType(), new NodeRenderingHandlerWrapper(nodeRenderingHandler, this.renderers.get(nodeRenderingHandler.getNodeType())));
                }
                if (nodeRendererApply instanceof PhasedNodeRenderer) {
                    PhasedNodeRenderer phasedNodeRenderer = (PhasedNodeRenderer) nodeRendererApply;
                    this.renderingPhases.addAll(phasedNodeRenderer.getRenderingPhases());
                    this.phasedRenderers.add(phasedNodeRenderer);
                }
            }
            for (int i = 0; i < HtmlRenderer.this.linkResolverFactories.size(); i++) {
                this.myLinkResolvers[i] = HtmlRenderer.this.linkResolverFactories.get(i).apply((LinkResolverBasicContext) this);
            }
            this.attributeProviders = new AttributeProvider[HtmlRenderer.this.attributeProviderFactories.size()];
            for (int i2 = 0; i2 < HtmlRenderer.this.attributeProviderFactories.size(); i2++) {
                this.attributeProviders[i2] = HtmlRenderer.this.attributeProviderFactories.get(i2).apply((LinkResolverContext) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HashMap lambda$resolveLink$0(LinkType linkType) {
            return new HashMap();
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        public void delegateRender() {
            renderByPreviousHandler(this);
        }

        @Override // com.vladsch.flexmark.html.Disposable
        public void dispose() {
            this.document = null;
            this.renderers = null;
            this.phasedRenderers = null;
            for (LinkResolver linkResolver : this.myLinkResolvers) {
                if (linkResolver instanceof Disposable) {
                    ((Disposable) linkResolver).dispose();
                }
            }
            this.myLinkResolvers = null;
            this.renderingPhases = null;
            this.options = null;
            HtmlIdGenerator htmlIdGenerator = this.htmlIdGenerator;
            if (htmlIdGenerator instanceof Disposable) {
                ((Disposable) htmlIdGenerator).dispose();
            }
            this.htmlIdGenerator = null;
            this.resolvedLinkMap = null;
            for (AttributeProvider attributeProvider : this.attributeProviders) {
                if (attributeProvider instanceof Disposable) {
                    ((Disposable) attributeProvider).dispose();
                }
            }
            this.attributeProviders = null;
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
        @NotNull
        public String encodeUrl(@NotNull CharSequence charSequence) {
            return HtmlRenderer.this.htmlOptions.percentEncodeUrls ? Escaping.percentEncodeUrl(charSequence) : String.valueOf(charSequence);
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        @NotNull
        public MutableAttributes extendRenderingNodeAttributes(@NotNull AttributablePart attributablePart, Attributes attributes) {
            MutableAttributes mutable = attributes != null ? attributes.toMutable() : new MutableAttributes();
            for (AttributeProvider attributeProvider : this.attributeProviders) {
                attributeProvider.setAttributes(this.renderingNode, attributablePart, mutable);
            }
            return mutable;
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
        @NotNull
        public Node getCurrentNode() {
            return this.renderingNode;
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        @NotNull
        public NodeRendererContext getDelegatedSubContext(boolean z) {
            HtmlWriter htmlWriter = new HtmlWriter(getHtmlWriter(), z);
            htmlWriter.setContext(this);
            return new SubNodeRenderer(this, htmlWriter, true);
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
        @NotNull
        public Document getDocument() {
            return this.document;
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        @NotNull
        public HtmlRendererOptions getHtmlOptions() {
            return HtmlRenderer.this.htmlOptions;
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        public String getNodeId(@NotNull Node node) {
            String id = this.htmlIdGenerator.getId(node);
            if (HtmlRenderer.this.attributeProviderFactories.size() == 0) {
                return id;
            }
            MutableAttributes mutableAttributes = new MutableAttributes();
            if (id != null) {
                mutableAttributes.replaceValue("id", id);
            }
            for (AttributeProvider attributeProvider : this.attributeProviders) {
                attributeProvider.setAttributes(this.renderingNode, AttributablePart.f8349ID, mutableAttributes);
            }
            return mutableAttributes.getValue("id");
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
        @NotNull
        public DataHolder getOptions() {
            return this.options;
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        @NotNull
        public RenderingPhase getRenderingPhase() {
            return this.phase;
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        @NotNull
        public NodeRendererContext getSubContext(boolean z) {
            HtmlWriter htmlWriter = new HtmlWriter(getHtmlWriter(), z);
            htmlWriter.setContext(this);
            return new SubNodeRenderer(this, htmlWriter, false);
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
        public void render(@NotNull Node node) {
            renderNode(node, this);
        }

        public void renderByPreviousHandler(NodeRendererSubContext nodeRendererSubContext) {
            Node node = nodeRendererSubContext.renderingNode;
            if (node == null) {
                throw new IllegalStateException("renderingByPreviousHandler called outside node rendering code");
            }
            NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper = nodeRendererSubContext.renderingHandlerWrapper;
            NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper2 = nodeRenderingHandlerWrapper.myPreviousRenderingHandler;
            if (nodeRenderingHandlerWrapper2 != null) {
                int i = nodeRendererSubContext.doNotRenderLinksNesting;
                try {
                    nodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper2;
                    nodeRenderingHandlerWrapper2.myRenderingHandler.render(node, nodeRendererSubContext, nodeRendererSubContext.htmlWriter);
                } finally {
                    nodeRendererSubContext.renderingNode = node;
                    nodeRendererSubContext.doNotRenderLinksNesting = i;
                    nodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper;
                }
            }
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
        public void renderChildren(@NotNull Node node) {
            renderChildrenNode(node, this);
        }

        public void renderChildrenNode(Node node, NodeRendererSubContext nodeRendererSubContext) {
            Node firstChild = node.getFirstChild();
            while (firstChild != null) {
                Node next = firstChild.getNext();
                renderNode(firstChild, nodeRendererSubContext);
                firstChild = next;
            }
        }

        public void renderNode(Node node, NodeRendererSubContext nodeRendererSubContext) {
            NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper;
            if (!(node instanceof Document)) {
                NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper2 = this.renderers.get(node.getClass());
                if (nodeRenderingHandlerWrapper2 != null) {
                    Node node2 = this.renderingNode;
                    int i = nodeRendererSubContext.doNotRenderLinksNesting;
                    NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper3 = nodeRendererSubContext.renderingHandlerWrapper;
                    try {
                        nodeRendererSubContext.renderingNode = node;
                        nodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper2;
                        nodeRenderingHandlerWrapper2.myRenderingHandler.render(node, nodeRendererSubContext, nodeRendererSubContext.htmlWriter);
                        return;
                    } finally {
                        nodeRendererSubContext.renderingNode = node2;
                        nodeRendererSubContext.doNotRenderLinksNesting = i;
                        nodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper3;
                    }
                }
                return;
            }
            int doNotRenderLinksNesting = nodeRendererSubContext.getDoNotRenderLinksNesting();
            boolean z = getHtmlOptions().doNotRenderLinksInDocument;
            this.htmlIdGenerator.generateIds(this.document);
            for (RenderingPhase renderingPhase : RenderingPhase.values()) {
                if (renderingPhase == RenderingPhase.BODY || this.renderingPhases.contains(renderingPhase)) {
                    this.phase = renderingPhase;
                    Iterator<PhasedNodeRenderer> it = this.phasedRenderers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PhasedNodeRenderer next = it.next();
                        Set<RenderingPhase> renderingPhases = next.getRenderingPhases();
                        Objects.requireNonNull(renderingPhases);
                        if (renderingPhases.contains(renderingPhase)) {
                            nodeRendererSubContext.doNotRenderLinksNesting = z ? 1 : 0;
                            nodeRendererSubContext.renderingNode = node;
                            next.renderDocument(nodeRendererSubContext, nodeRendererSubContext.htmlWriter, (Document) node, renderingPhase);
                            nodeRendererSubContext.renderingNode = null;
                            nodeRendererSubContext.doNotRenderLinksNesting = doNotRenderLinksNesting;
                        }
                    }
                    if (getRenderingPhase() == RenderingPhase.BODY && (nodeRenderingHandlerWrapper = this.renderers.get(node.getClass())) != null) {
                        nodeRendererSubContext.doNotRenderLinksNesting = z ? 1 : 0;
                        NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper4 = nodeRendererSubContext.renderingHandlerWrapper;
                        try {
                            nodeRendererSubContext.renderingNode = node;
                            nodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper;
                            nodeRenderingHandlerWrapper.myRenderingHandler.render(node, nodeRendererSubContext, nodeRendererSubContext.htmlWriter);
                        } finally {
                            nodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper4;
                            nodeRendererSubContext.renderingNode = null;
                            nodeRendererSubContext.doNotRenderLinksNesting = doNotRenderLinksNesting;
                        }
                    }
                }
            }
        }

        @Override // com.vladsch.flexmark.html.renderer.LinkResolverContext
        @NotNull
        public ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, Attributes attributes, Boolean bool) {
            HashMap<String, ResolvedLink> mapComputeIfAbsent = this.resolvedLinkMap.computeIfAbsent(linkType, new C11821a(1));
            String strValueOf = String.valueOf(charSequence);
            ResolvedLink resolvedLink = mapComputeIfAbsent.get(strValueOf);
            if (resolvedLink == null) {
                resolvedLink = new ResolvedLink(linkType, strValueOf, attributes);
                if (!strValueOf.isEmpty()) {
                    Node currentNode = getCurrentNode();
                    for (LinkResolver linkResolver : this.myLinkResolvers) {
                        resolvedLink = linkResolver.resolveLink(currentNode, this, resolvedLink);
                        if (resolvedLink.getStatus() != LinkStatus.UNKNOWN) {
                            break;
                        }
                    }
                    if ((bool == null && HtmlRenderer.this.htmlOptions.percentEncodeUrls) || (bool != null && bool.booleanValue())) {
                        resolvedLink = resolvedLink.withUrl(Escaping.percentEncodeUrl(resolvedLink.getUrl()));
                    }
                }
                mapComputeIfAbsent.put(strValueOf, resolvedLink);
            }
            return resolvedLink;
        }

        @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
        @NotNull
        public MutableAttributes extendRenderingNodeAttributes(@NotNull Node node, @NotNull AttributablePart attributablePart, Attributes attributes) {
            MutableAttributes mutable = attributes != null ? attributes.toMutable() : new MutableAttributes();
            for (AttributeProvider attributeProvider : this.attributeProviders) {
                attributeProvider.setAttributes(node, attributablePart, mutable);
            }
            return mutable;
        }
    }

    public static boolean isCompatibleRendererType(@NotNull MutableDataHolder mutableDataHolder, @NotNull String str, @NotNull String str2) {
        if (str.equals(str2)) {
            return true;
        }
        for (Pair<String, String> pair : RENDERER_TYPE_EQUIVALENCE.get(mutableDataHolder)) {
            if (str.equals(pair.getFirst()) && str2.equals(pair.getSecond())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.ast.IRender
    @NotNull
    public String render(@NotNull Node node) {
        StringBuilder sb = new StringBuilder();
        render(node, sb);
        return sb.toString();
    }
}
