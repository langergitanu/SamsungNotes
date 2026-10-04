package com.vladsch.flexmark.ext.gitlab.internal;

import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSetter;
import com.vladsch.flexmark.util.misc.CharPredicate;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabOptions implements MutableDataSetter {

    @Deprecated
    public final CharPredicate blockInfoDelimiterSet;

    @Deprecated
    public final String blockInfoDelimiters;
    public final String blockMathClass;
    public final String blockMermaidClass;
    public final boolean blockQuoteParser;
    public final boolean delParser;
    public final String inlineMathClass;
    public final boolean inlineMathParser;
    public final boolean insParser;
    public final String[] mathLanguages;
    public final String[] mermaidLanguages;
    public final boolean nestedBlockQuotes;
    public final boolean renderBlockMath;
    public final boolean renderBlockMermaid;
    public final boolean renderVideoImages;
    public final boolean renderVideoLink;
    public final String videoImageClass;
    public final HashSet<String> videoImageExtensionSet;
    public final String videoImageExtensions;
    public final String videoImageLinkTextFormat;

    public GitLabOptions(DataHolder dataHolder) {
        this.insParser = GitLabExtension.INS_PARSER.get(dataHolder).booleanValue();
        this.delParser = GitLabExtension.DEL_PARSER.get(dataHolder).booleanValue();
        this.inlineMathParser = GitLabExtension.INLINE_MATH_PARSER.get(dataHolder).booleanValue();
        this.blockQuoteParser = GitLabExtension.BLOCK_QUOTE_PARSER.get(dataHolder).booleanValue();
        this.nestedBlockQuotes = GitLabExtension.NESTED_BLOCK_QUOTES.get(dataHolder).booleanValue();
        this.inlineMathClass = GitLabExtension.INLINE_MATH_CLASS.get(dataHolder);
        this.renderBlockMath = GitLabExtension.RENDER_BLOCK_MATH.get(dataHolder).booleanValue();
        this.renderBlockMermaid = GitLabExtension.RENDER_BLOCK_MERMAID.get(dataHolder).booleanValue();
        this.renderVideoImages = GitLabExtension.RENDER_VIDEO_IMAGES.get(dataHolder).booleanValue();
        this.renderVideoLink = GitLabExtension.RENDER_VIDEO_LINK.get(dataHolder).booleanValue();
        this.blockMathClass = GitLabExtension.BLOCK_MATH_CLASS.get(dataHolder);
        this.blockMermaidClass = GitLabExtension.BLOCK_MERMAID_CLASS.get(dataHolder);
        String str = HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS.get(dataHolder);
        this.blockInfoDelimiters = str;
        this.blockInfoDelimiterSet = CharPredicate.anyOf(str);
        this.mathLanguages = GitLabExtension.MATH_LANGUAGES.get(dataHolder);
        this.mermaidLanguages = GitLabExtension.MERMAID_LANGUAGES.get(dataHolder);
        this.videoImageClass = GitLabExtension.VIDEO_IMAGE_CLASS.get(dataHolder);
        this.videoImageLinkTextFormat = GitLabExtension.VIDEO_IMAGE_LINK_TEXT_FORMAT.get(dataHolder);
        String str2 = GitLabExtension.VIDEO_IMAGE_EXTENSIONS.get(dataHolder);
        this.videoImageExtensions = str2;
        this.videoImageExtensionSet = new HashSet<>();
        for (String str3 : str2.split(",")) {
            String strTrim = str3.trim();
            if (!strTrim.isEmpty()) {
                this.videoImageExtensionSet.add(strTrim);
            }
        }
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    public MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder) {
        mutableDataHolder.set(GitLabExtension.INS_PARSER, Boolean.valueOf(this.insParser));
        mutableDataHolder.set(GitLabExtension.DEL_PARSER, Boolean.valueOf(this.delParser));
        mutableDataHolder.set(GitLabExtension.INLINE_MATH_PARSER, Boolean.valueOf(this.inlineMathParser));
        mutableDataHolder.set(GitLabExtension.BLOCK_QUOTE_PARSER, Boolean.valueOf(this.blockQuoteParser));
        mutableDataHolder.set(GitLabExtension.NESTED_BLOCK_QUOTES, Boolean.valueOf(this.nestedBlockQuotes));
        mutableDataHolder.set(GitLabExtension.INLINE_MATH_CLASS, this.inlineMathClass);
        mutableDataHolder.set(GitLabExtension.RENDER_BLOCK_MATH, Boolean.valueOf(this.renderBlockMath));
        mutableDataHolder.set(GitLabExtension.RENDER_BLOCK_MERMAID, Boolean.valueOf(this.renderBlockMermaid));
        mutableDataHolder.set(GitLabExtension.RENDER_VIDEO_IMAGES, Boolean.valueOf(this.renderVideoImages));
        mutableDataHolder.set(GitLabExtension.RENDER_VIDEO_LINK, Boolean.valueOf(this.renderVideoLink));
        mutableDataHolder.set(GitLabExtension.BLOCK_MATH_CLASS, this.blockMathClass);
        mutableDataHolder.set(GitLabExtension.BLOCK_MERMAID_CLASS, this.blockMermaidClass);
        mutableDataHolder.set(HtmlRenderer.FENCED_CODE_LANGUAGE_DELIMITERS, this.blockInfoDelimiters);
        mutableDataHolder.set(GitLabExtension.VIDEO_IMAGE_CLASS, this.videoImageClass);
        mutableDataHolder.set(GitLabExtension.VIDEO_IMAGE_LINK_TEXT_FORMAT, this.videoImageLinkTextFormat);
        mutableDataHolder.set(GitLabExtension.VIDEO_IMAGE_EXTENSIONS, this.videoImageExtensions);
        return mutableDataHolder;
    }
}
