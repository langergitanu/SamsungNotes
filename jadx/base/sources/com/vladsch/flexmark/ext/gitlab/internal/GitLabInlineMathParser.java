package com.vladsch.flexmark.ext.gitlab.internal;

import com.vladsch.flexmark.ext.gitlab.GitLabInlineMath;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.InlineParserExtension;
import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
import com.vladsch.flexmark.parser.LightInlineParser;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabInlineMathParser implements InlineParserExtension {
    Pattern MATH_PATTERN = Pattern.compile("\\$`((?:.|\n)*?)`\\$");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements InlineParserExtensionFactory {
        @Override // com.vladsch.flexmark.util.dependency.Dependent
        public boolean affectsGlobalScope() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getAfterDependents() {
            return null;
        }

        @Override // com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return null;
        }

        @Override // com.vladsch.flexmark.parser.InlineParserExtensionFactory
        @NotNull
        public CharSequence getCharacters() {
            return "$";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.InlineParserExtensionFactory, java.util.function.Function
        @NotNull
        public InlineParserExtension apply(@NotNull LightInlineParser lightInlineParser) {
            return new GitLabInlineMathParser(lightInlineParser);
        }
    }

    public GitLabInlineMathParser(LightInlineParser lightInlineParser) {
    }

    @Override // com.vladsch.flexmark.parser.InlineParserExtension
    public void finalizeBlock(@NotNull InlineParser inlineParser) {
    }

    @Override // com.vladsch.flexmark.parser.InlineParserExtension
    public void finalizeDocument(@NotNull InlineParser inlineParser) {
    }

    @Override // com.vladsch.flexmark.parser.InlineParserExtension
    public boolean parse(@NotNull LightInlineParser lightInlineParser) {
        if (lightInlineParser.peek(1) != '`') {
            return false;
        }
        BasedSequence input = lightInlineParser.getInput();
        Matcher matcher = lightInlineParser.matcher(this.MATH_PATTERN);
        if (matcher == null) {
            return false;
        }
        lightInlineParser.flushTextNode();
        BasedSequence basedSequenceSubSequence = input.subSequence(matcher.start(), matcher.start(1));
        BasedSequence basedSequenceSubSequence2 = input.subSequence(matcher.end(1), matcher.end());
        lightInlineParser.getBlock().appendChild(new GitLabInlineMath(basedSequenceSubSequence, basedSequenceSubSequence.baseSubSequence(basedSequenceSubSequence.getEndOffset(), basedSequenceSubSequence2.getStartOffset()), basedSequenceSubSequence2));
        return true;
    }
}
