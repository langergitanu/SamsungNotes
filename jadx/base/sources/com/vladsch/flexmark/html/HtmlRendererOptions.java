package com.vladsch.flexmark.html;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Utils;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlRendererOptions {

    @NotNull
    public final String autolinkWwwPrefix;

    @Nullable
    public final String codeStyleHtmlClose;

    @Nullable
    public final String codeStyleHtmlOpen;
    public final boolean doNotRenderLinksInDocument;

    @Nullable
    public final String emphasisStyleHtmlClose;

    @Nullable
    public final String emphasisStyleHtmlOpen;
    public final boolean escapeHtmlBlocks;
    public final boolean escapeHtmlCommentBlocks;
    public final boolean escapeInlineHtml;
    public final boolean escapeInlineHtmlComments;
    public final int formatFlags;
    public final boolean generateHeaderIds;

    @NotNull
    public final String hardBreak;
    public final boolean htmlBlockCloseTagEol;
    public final boolean htmlBlockOpenTagEol;
    public final int indentSize;

    @Nullable
    public final String inlineCodeSpliceClass;
    public final boolean isSoftBreakAllSpaces;

    @NotNull
    public final HashMap<String, String> languageClassMap;

    @NotNull
    public final String languageClassPrefix;
    public final CharPredicate languageDelimiterSet;

    @NotNull
    public final String languageDelimiters;
    public final int maxBlankLines;
    public final int maxTrailingBlankLines;

    @NotNull
    public final String noLanguageClass;
    public final boolean noPTagsUseBr;
    public final boolean percentEncodeUrls;
    public final boolean renderHeaderId;

    @NotNull
    public final String softBreak;

    @NotNull
    public final String sourcePositionAttribute;
    public final boolean sourcePositionParagraphLines;
    public final boolean sourceWrapHtmlBlocks;

    @Nullable
    public final String strongEmphasisStyleHtmlClose;

    @Nullable
    public final String strongEmphasisStyleHtmlOpen;
    public final boolean suppressHtmlBlocks;
    public final boolean suppressHtmlCommentBlocks;
    public final boolean suppressInlineHtml;
    public final boolean suppressInlineHtmlComments;

    @Nullable
    public final Pattern suppressedLinks;
    public final boolean unescapeHtmlEntities;

    public HtmlRendererOptions(DataHolder dataHolder) {
        String str = HtmlRenderer.SOFT_BREAK.get(dataHolder);
        this.softBreak = str;
        this.isSoftBreakAllSpaces = Utils.isWhiteSpaceNoEOL(str);
        this.hardBreak = HtmlRenderer.HARD_BREAK.get(dataHolder);
        this.strongEmphasisStyleHtmlOpen = HtmlRenderer.STRONG_EMPHASIS_STYLE_HTML_OPEN.get(dataHolder);
        this.strongEmphasisStyleHtmlClose = HtmlRenderer.STRONG_EMPHASIS_STYLE_HTML_CLOSE.get(dataHolder);
        this.emphasisStyleHtmlOpen = HtmlRenderer.EMPHASIS_STYLE_HTML_OPEN.get(dataHolder);
        this.emphasisStyleHtmlClose = HtmlRenderer.EMPHASIS_STYLE_HTML_CLOSE.get(dataHolder);
        this.codeStyleHtmlOpen = HtmlRenderer.CODE_STYLE_HTML_OPEN.get(dataHolder);
        this.codeStyleHtmlClose = HtmlRenderer.CODE_STYLE_HTML_CLOSE.get(dataHolder);
        this.escapeHtmlBlocks = HtmlRenderer.ESCAPE_HTML_BLOCKS.get(dataHolder).booleanValue();
        this.escapeHtmlCommentBlocks = HtmlRenderer.ESCAPE_HTML_COMMENT_BLOCKS.get(dataHolder).booleanValue();
        this.escapeInlineHtml = HtmlRenderer.ESCAPE_INLINE_HTML.get(dataHolder).booleanValue();
        this.escapeInlineHtmlComments = HtmlRenderer.ESCAPE_INLINE_HTML_COMMENTS.get(dataHolder).booleanValue();
        this.percentEncodeUrls = HtmlRenderer.PERCENT_ENCODE_URLS.get(dataHolder).booleanValue();
        this.indentSize = HtmlRenderer.INDENT_SIZE.get(dataHolder).intValue();
        this.suppressHtmlBlocks = HtmlRenderer.SUPPRESS_HTML_BLOCKS.get(dataHolder).booleanValue();
        this.suppressHtmlCommentBlocks = HtmlRenderer.SUPPRESS_HTML_COMMENT_BLOCKS.get(dataHolder).booleanValue();
        this.suppressInlineHtml = HtmlRenderer.SUPPRESS_INLINE_HTML.get(dataHolder).booleanValue();
        this.suppressInlineHtmlComments = HtmlRenderer.SUPPRESS_INLINE_HTML_COMMENTS.get(dataHolder).booleanValue();
        this.doNotRenderLinksInDocument = HtmlRenderer.DO_NOT_RENDER_LINKS.get(dataHolder).booleanValue();
        this.renderHeaderId = HtmlRenderer.RENDER_HEADER_ID.get(dataHolder).booleanValue();
        this.generateHeaderIds = HtmlRenderer.GENERATE_HEADER_ID.get(dataHolder).booleanValue();
        this.languageClassPrefix = HtmlRenderer.FENCED_CODE_LANGUAGE_CLASS_PREFIX.get(dataHolder);
        this.languageClassMap = HtmlRenderer.FENCED_CODE_LANGUAGE_CLASS_MAP.get(dataHolder);
        String str2 = HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS.get(dataHolder);
        this.languageDelimiters = str2;
        this.languageDelimiterSet = CharPredicate.anyOf(str2);
        this.noLanguageClass = HtmlRenderer.FENCED_CODE_NO_LANGUAGE_CLASS.get(dataHolder);
        String str3 = HtmlRenderer.SOURCE_POSITION_ATTRIBUTE.get(dataHolder);
        this.sourcePositionAttribute = str3;
        boolean z = false;
        this.sourcePositionParagraphLines = !str3.isEmpty() && HtmlRenderer.SOURCE_POSITION_PARAGRAPH_LINES.get(dataHolder).booleanValue();
        if (!str3.isEmpty() && HtmlRenderer.SOURCE_WRAP_HTML_BLOCKS.get(dataHolder).booleanValue()) {
            z = true;
        }
        this.sourceWrapHtmlBlocks = z;
        this.formatFlags = HtmlRenderer.FORMAT_FLAGS.get(dataHolder).intValue();
        this.maxTrailingBlankLines = HtmlRenderer.MAX_TRAILING_BLANK_LINES.get(dataHolder).intValue();
        this.maxBlankLines = HtmlRenderer.MAX_BLANK_LINES.get(dataHolder).intValue();
        this.htmlBlockOpenTagEol = HtmlRenderer.HTML_BLOCK_OPEN_TAG_EOL.get(dataHolder).booleanValue();
        this.htmlBlockCloseTagEol = HtmlRenderer.HTML_BLOCK_CLOSE_TAG_EOL.get(dataHolder).booleanValue();
        this.unescapeHtmlEntities = HtmlRenderer.UNESCAPE_HTML_ENTITIES.get(dataHolder).booleanValue();
        this.noPTagsUseBr = HtmlRenderer.NO_P_TAGS_USE_BR.get(dataHolder).booleanValue();
        this.inlineCodeSpliceClass = HtmlRenderer.INLINE_CODE_SPLICE_CLASS.get(dataHolder);
        this.autolinkWwwPrefix = HtmlRenderer.AUTOLINK_WWW_PREFIX.get(dataHolder);
        String str4 = HtmlRenderer.SUPPRESSED_LINKS.get(dataHolder);
        this.suppressedLinks = str4.isEmpty() ? null : Pattern.compile(str4);
    }
}
