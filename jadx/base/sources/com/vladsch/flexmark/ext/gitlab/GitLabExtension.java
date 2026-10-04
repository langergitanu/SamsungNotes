package com.vladsch.flexmark.ext.gitlab;

import com.vladsch.flexmark.ext.gitlab.internal.GitLabBlockQuoteParser;
import com.vladsch.flexmark.ext.gitlab.internal.GitLabInlineMathParser;
import com.vladsch.flexmark.ext.gitlab.internal.GitLabInlineParser;
import com.vladsch.flexmark.ext.gitlab.internal.GitLabNodeFormatter;
import com.vladsch.flexmark.ext.gitlab.internal.GitLabNodeRenderer;
import com.vladsch.flexmark.ext.gitlab.internal.GitLabOptions;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, Formatter.FormatterExtension {

    @Deprecated
    public static final DataKey<String> BLOCK_INFO_DELIMITERS;
    public static final DataKey<String> BLOCK_MATH_CLASS;
    public static final DataKey<String> BLOCK_MERMAID_CLASS;
    public static final DataKey<Boolean> BLOCK_QUOTE_PARSER;
    private static final String[] DEFAULT_MATH_LANGUAGES;
    private static final String[] DEFAULT_MERMAID_LANGUAGES;
    public static final DataKey<Boolean> DEL_PARSER;
    public static final DataKey<String> INLINE_MATH_CLASS;
    public static final DataKey<Boolean> INLINE_MATH_PARSER;
    public static final DataKey<Boolean> INS_PARSER;
    public static final DataKey<String[]> MATH_LANGUAGES;
    public static final DataKey<String[]> MERMAID_LANGUAGES;
    public static final DataKey<Boolean> NESTED_BLOCK_QUOTES;
    public static final DataKey<Boolean> RENDER_BLOCK_MATH;
    public static final DataKey<Boolean> RENDER_BLOCK_MERMAID;
    public static final DataKey<Boolean> RENDER_VIDEO_IMAGES;
    public static final DataKey<Boolean> RENDER_VIDEO_LINK;
    public static final DataKey<String> VIDEO_IMAGE_CLASS;
    public static final DataKey<String> VIDEO_IMAGE_EXTENSIONS;
    public static final DataKey<String> VIDEO_IMAGE_LINK_TEXT_FORMAT;

    static {
        String[] strArr = {"math"};
        DEFAULT_MATH_LANGUAGES = strArr;
        String[] strArr2 = {"mermaid"};
        DEFAULT_MERMAID_LANGUAGES = strArr2;
        Boolean bool = Boolean.TRUE;
        INS_PARSER = new DataKey<>("INS_PARSER", bool);
        DEL_PARSER = new DataKey<>("DEL_PARSER", bool);
        BLOCK_QUOTE_PARSER = new DataKey<>("BLOCK_QUOTE_PARSER", bool);
        NESTED_BLOCK_QUOTES = new DataKey<>("NESTED_BLOCK_QUOTES", bool);
        INLINE_MATH_PARSER = new DataKey<>("INLINE_MATH_PARSER", bool);
        RENDER_BLOCK_MATH = new DataKey<>("RENDER_BLOCK_MATH", bool);
        RENDER_BLOCK_MERMAID = new DataKey<>("RENDER_BLOCK_MERMAID", bool);
        RENDER_VIDEO_IMAGES = new DataKey<>("RENDER_VIDEO_IMAGES", bool);
        RENDER_VIDEO_LINK = new DataKey<>("RENDER_VIDEO_LINK", bool);
        MATH_LANGUAGES = new DataKey<>("MATH_LANGUAGES", strArr);
        MERMAID_LANGUAGES = new DataKey<>("MERMAID_LANGUAGES", strArr2);
        INLINE_MATH_CLASS = new DataKey<>("INLINE_MATH_CLASS", "katex");
        BLOCK_MATH_CLASS = new DataKey<>("BLOCK_MATH_CLASS", "katex");
        BLOCK_MERMAID_CLASS = new DataKey<>("BLOCK_MERMAID_CLASS", "mermaid");
        VIDEO_IMAGE_CLASS = new DataKey<>("VIDEO_IMAGE_CLASS", "video-container");
        VIDEO_IMAGE_LINK_TEXT_FORMAT = new DataKey<>("VIDEO_IMAGE_LINK_TEXT_FORMAT", "Download '%s'");
        BLOCK_INFO_DELIMITERS = HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS;
        VIDEO_IMAGE_EXTENSIONS = new DataKey<>("VIDEO_IMAGE_EXTENSIONS", "mp4,m4v,mov,webm,ogv");
    }

    private GitLabExtension() {
    }

    public static GitLabExtension create() {
        return new GitLabExtension();
    }

    @Override // com.vladsch.flexmark.formatter.Formatter.FormatterExtension
    public void extend(Formatter.Builder builder) {
        builder.nodeFormatterFactory(new GitLabNodeFormatter.Factory());
    }

    @Override // com.vladsch.flexmark.parser.Parser.ParserExtension
    public void parserOptions(MutableDataHolder mutableDataHolder) {
    }

    @Override // com.vladsch.flexmark.html.HtmlRenderer.HtmlRendererExtension
    public void rendererOptions(@NotNull MutableDataHolder mutableDataHolder) {
    }

    @Override // com.vladsch.flexmark.parser.Parser.ParserExtension
    public void extend(Parser.Builder builder) {
        GitLabOptions gitLabOptions = new GitLabOptions(builder);
        if (gitLabOptions.blockQuoteParser) {
            builder.customBlockParserFactory(new GitLabBlockQuoteParser.Factory());
        }
        if (gitLabOptions.delParser || gitLabOptions.insParser) {
            builder.customInlineParserExtensionFactory(new GitLabInlineParser.Factory());
        }
        if (gitLabOptions.inlineMathParser) {
            builder.customInlineParserExtensionFactory(new GitLabInlineMathParser.Factory());
        }
    }

    @Override // com.vladsch.flexmark.html.HtmlRenderer.HtmlRendererExtension
    public void extend(@NotNull HtmlRenderer.Builder builder, @NotNull String str) {
        if (builder.isRendererType("HTML")) {
            builder.nodeRendererFactory(new GitLabNodeRenderer.Factory());
        } else {
            builder.isRendererType("JIRA");
        }
    }
}
