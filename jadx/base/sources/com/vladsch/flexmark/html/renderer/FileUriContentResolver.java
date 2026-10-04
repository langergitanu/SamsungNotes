package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.html.UriContentResolver;
import com.vladsch.flexmark.html.UriContentResolverFactory;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.dependency.LastDependent;
import com.vladsch.flexmark.util.misc.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FileUriContentResolver implements UriContentResolver {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements UriContentResolverFactory {
        @Override // com.vladsch.flexmark.html.UriContentResolverFactory, com.vladsch.flexmark.util.dependency.Dependent
        public boolean affectsGlobalScope() {
            return false;
        }

        @Override // com.vladsch.flexmark.html.UriContentResolverFactory, com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getAfterDependents() {
            return Collections.singleton(LastDependent.class);
        }

        @Override // com.vladsch.flexmark.html.UriContentResolverFactory, com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.UriContentResolverFactory, java.util.function.Function
        @NotNull
        public UriContentResolver apply(@NotNull LinkResolverBasicContext linkResolverBasicContext) {
            return new FileUriContentResolver(linkResolverBasicContext);
        }
    }

    public FileUriContentResolver(LinkResolverBasicContext linkResolverBasicContext) {
    }

    @Override // com.vladsch.flexmark.html.UriContentResolver
    @NotNull
    public ResolvedContent resolveContent(@NotNull Node node, @NotNull LinkResolverBasicContext linkResolverBasicContext, @NotNull ResolvedContent resolvedContent) {
        ResolvedLink resolvedLink = resolvedContent.getResolvedLink();
        LinkStatus status = resolvedLink.getStatus();
        LinkStatus linkStatus = LinkStatus.VALID;
        if (status == linkStatus) {
            String url = resolvedLink.getUrl();
            if (url.startsWith("file:/")) {
                File file = new File(url.substring(url.startsWith("file://") ? 7 : File.separatorChar == '\\' ? 6 : 5));
                if (file.isFile() && file.exists()) {
                    try {
                        return resolvedContent.withContent(FileUtil.getFileContentBytesWithExceptions(file)).withStatus(linkStatus);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return resolvedContent;
    }
}
