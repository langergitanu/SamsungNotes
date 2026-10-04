package com.vladsch.flexmark.formatter.internal;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.html.LinkResolver;
import com.vladsch.flexmark.html.LinkResolverFactory;
import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.LinkStatus;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.misc.Utils;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MergeLinkResolver implements LinkResolver {
    private final String docRelativeURL;
    private final String docRootURL;
    private final String[] relativeParts;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements LinkResolverFactory {
        @Override // com.vladsch.flexmark.html.LinkResolverFactory, com.vladsch.flexmark.util.dependency.Dependent
        public boolean affectsGlobalScope() {
            return false;
        }

        @Override // com.vladsch.flexmark.html.LinkResolverFactory, com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getAfterDependents() {
            return null;
        }

        @Override // com.vladsch.flexmark.html.LinkResolverFactory, com.vladsch.flexmark.util.dependency.Dependent
        @Nullable
        public Set<Class<?>> getBeforeDependents() {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.LinkResolverFactory, java.util.function.Function
        @NotNull
        public LinkResolver apply(@NotNull LinkResolverBasicContext linkResolverBasicContext) {
            return new MergeLinkResolver(linkResolverBasicContext);
        }
    }

    public MergeLinkResolver(LinkResolverBasicContext linkResolverBasicContext) {
        String str = Formatter.DOC_RELATIVE_URL.get(linkResolverBasicContext.getOptions());
        String str2 = Formatter.DOC_ROOT_URL.get(linkResolverBasicContext.getOptions());
        this.docRelativeURL = str;
        this.docRootURL = str2;
        this.relativeParts = Utils.removePrefix(str, '/').split("/");
    }

    @Override // com.vladsch.flexmark.html.LinkResolver
    @NotNull
    public ResolvedLink resolveLink(@NotNull Node node, @NotNull LinkResolverBasicContext linkResolverBasicContext, @NotNull ResolvedLink resolvedLink) {
        String strSubstring;
        if ((node instanceof Image) || (node instanceof Link) || (node instanceof Reference)) {
            String url = resolvedLink.getUrl();
            if (this.docRelativeURL.isEmpty() && this.docRootURL.isEmpty()) {
                return resolvedLink.withStatus(LinkStatus.VALID).withUrl(url);
            }
            if (url.startsWith(WebConstants.HTTP_PROTOCOL) || url.startsWith("https://") || url.startsWith("ftp://") || url.startsWith("sftp://")) {
                return resolvedLink.withStatus(LinkStatus.VALID).withUrl(url);
            }
            if (url.startsWith("file:/")) {
                return resolvedLink.withStatus(LinkStatus.VALID).withUrl(url);
            }
            if (url.startsWith("/")) {
                String str = this.docRootURL;
                if (str != null && !str.isEmpty()) {
                    return resolvedLink.withStatus(LinkStatus.VALID).withUrl(AbstractC0541b.m757C(this.docRootURL.startsWith("/") ? "" : "/", this.docRootURL, url));
                }
            } else if (!url.matches("^(?:[a-z]+:|#|\\?)")) {
                int iIndexOf = url.indexOf(35);
                if (iIndexOf == 0) {
                    return resolvedLink.withStatus(LinkStatus.VALID);
                }
                int i = 0;
                if (iIndexOf > 0) {
                    strSubstring = url.substring(iIndexOf);
                    url = url.substring(0, iIndexOf);
                } else if (url.contains(MsalUtils.QUERY_STRING_SYMBOL)) {
                    int iIndexOf2 = url.indexOf(MsalUtils.QUERY_STRING_SYMBOL);
                    strSubstring = url.substring(iIndexOf2);
                    url = url.substring(0, iIndexOf2);
                } else {
                    strSubstring = "";
                }
                String[] strArrSplit = url.split("/");
                int length = this.relativeParts.length;
                StringBuilder sb = new StringBuilder();
                String str2 = "";
                for (String str3 : strArrSplit) {
                    if (!str3.equals(Extension.DOT)) {
                        if (!str3.equals("..")) {
                            sb.append(str2);
                            sb.append(str3);
                            str2 = "/";
                        } else {
                            if (length == 0) {
                                return resolvedLink;
                            }
                            length--;
                        }
                    }
                }
                String str4 = this.docRelativeURL.startsWith("/") ? "/" : "";
                StringBuilder sb2 = new StringBuilder();
                while (i < length) {
                    sb2.append(str4);
                    sb2.append(this.relativeParts[i]);
                    i++;
                    str4 = "/";
                }
                sb2.append('/');
                sb2.append((CharSequence) sb);
                sb2.append(strSubstring);
                return resolvedLink.withStatus(LinkStatus.VALID).withUrl(sb2.toString());
            }
        }
        return resolvedLink;
    }
}
