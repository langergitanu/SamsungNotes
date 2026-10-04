package com.vladsch.flexmark.ext.gitlab.internal;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ext.gitlab.GitLabDel;
import com.vladsch.flexmark.ext.gitlab.GitLabInline;
import com.vladsch.flexmark.ext.gitlab.GitLabIns;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.InlineParserExtension;
import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
import com.vladsch.flexmark.parser.LightInlineParser;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabInlineParser implements InlineParserExtension {
    private final List<GitLabInline> openInlines = new ArrayList();
    private final GitLabOptions options;

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
            return "{[-+";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.parser.InlineParserExtensionFactory, java.util.function.Function
        @NotNull
        public InlineParserExtension apply(@NotNull LightInlineParser lightInlineParser) {
            return new GitLabInlineParser(lightInlineParser);
        }
    }

    public GitLabInlineParser(LightInlineParser lightInlineParser) {
        this.options = new GitLabOptions(lightInlineParser.getDocument());
    }

    @Override // com.vladsch.flexmark.parser.InlineParserExtension
    public void finalizeBlock(@NotNull InlineParser inlineParser) {
        int size = this.openInlines.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                this.openInlines.clear();
                return;
            }
            GitLabInline gitLabInline = this.openInlines.get(i);
            gitLabInline.insertBefore(new Text(gitLabInline.getChars()));
            gitLabInline.unlink();
            size = i;
        }
    }

    @Override // com.vladsch.flexmark.parser.InlineParserExtension
    public void finalizeDocument(@NotNull InlineParser inlineParser) {
    }

    @Override // com.vladsch.flexmark.parser.InlineParserExtension
    public boolean parse(@NotNull LightInlineParser lightInlineParser) {
        char cPeek = lightInlineParser.peek();
        char cPeek2 = lightInlineParser.peek(1);
        if (cPeek == '{' || cPeek == '[') {
            GitLabOptions gitLabOptions = this.options;
            if ((gitLabOptions.insParser && cPeek2 == '+') || (gitLabOptions.delParser && cPeek2 == '-')) {
                BasedSequence basedSequenceSubSequence = lightInlineParser.getInput().subSequence(lightInlineParser.getIndex());
                GitLabInline gitLabIns = cPeek2 == '+' ? new GitLabIns(basedSequenceSubSequence.subSequence(0, 2)) : new GitLabDel(basedSequenceSubSequence.subSequence(0, 2));
                lightInlineParser.flushTextNode();
                lightInlineParser.getBlock().appendChild(gitLabIns);
                this.openInlines.add(gitLabIns);
                lightInlineParser.setIndex(lightInlineParser.getIndex() + 2);
                return true;
            }
        }
        GitLabOptions gitLabOptions2 = this.options;
        if (((gitLabOptions2.insParser && cPeek == '+') || (gitLabOptions2.delParser && cPeek == '-')) && (cPeek2 == ']' || cPeek2 == '}')) {
            BasedSequence basedSequenceSubSequence2 = lightInlineParser.getInput().subSequence(lightInlineParser.getIndex());
            BasedSequence basedSequenceM13437of = BasedSequence.m13437of(cPeek2 == ']' ? cPeek == '+' ? "[+" : "[-" : cPeek == '+' ? "{+" : "{-");
            int size = this.openInlines.size();
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    break;
                }
                GitLabInline gitLabInline = this.openInlines.get(i);
                BasedSequence chars = gitLabInline.getChars();
                if (chars.equals(basedSequenceM13437of)) {
                    lightInlineParser.setIndex(lightInlineParser.getIndex() + 2);
                    BasedSequence basedSequenceSubSequence3 = basedSequenceSubSequence2.subSequence(0, 2);
                    gitLabInline.setOpeningMarker(chars);
                    gitLabInline.setClosingMarker(basedSequenceSubSequence3);
                    gitLabInline.setText(chars.baseSubSequence(chars.getEndOffset(), basedSequenceSubSequence3.getStartOffset()));
                    lightInlineParser.flushTextNode();
                    lightInlineParser.moveNodes(gitLabInline, lightInlineParser.getBlock().getLastChild());
                    if (i == 0) {
                        this.openInlines.clear();
                    } else {
                        List<GitLabInline> list = this.openInlines;
                        list.subList(i, list.size()).clear();
                    }
                    return true;
                }
                size = i;
            }
        }
        return false;
    }
}
