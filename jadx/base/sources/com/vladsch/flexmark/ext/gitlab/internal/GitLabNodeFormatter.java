package com.vladsch.flexmark.ext.gitlab.internal;

import com.vladsch.flexmark.ext.gfm.tasklist.internal.C11788a;
import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.NodeFormatter;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.NodeFormatterFactory;
import com.vladsch.flexmark.formatter.NodeFormattingHandler;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabNodeFormatter implements NodeFormatter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeFormatterFactory {
        @Override // com.vladsch.flexmark.formatter.NodeFormatterFactory
        @NotNull
        public NodeFormatter create(@NotNull DataHolder dataHolder) {
            return new GitLabNodeFormatter(dataHolder);
        }
    }

    public GitLabNodeFormatter(DataHolder dataHolder) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(GitLabBlockQuote gitLabBlockQuote, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.append(">>>").line();
        nodeFormatterContext.renderChildren(gitLabBlockQuote);
        markdownWriter.append(">>>").line();
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<Class<?>> getNodeClasses() {
        return new HashSet(Collections.singletonList(GitLabBlockQuote.class));
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
        return new HashSet(Collections.singletonList(new NodeFormattingHandler(GitLabBlockQuote.class, new C11788a(this, 3))));
    }
}
