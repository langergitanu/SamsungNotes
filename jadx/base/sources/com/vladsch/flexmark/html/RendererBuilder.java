package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory;
import com.vladsch.flexmark.util.data.DataHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface RendererBuilder extends DataHolder {
    @NotNull
    RendererBuilder attributeProviderFactory(@NotNull AttributeProviderFactory attributeProviderFactory);

    @NotNull
    RendererBuilder contentResolverFactory(@NotNull UriContentResolverFactory uriContentResolverFactory);

    @NotNull
    RendererBuilder htmlIdGeneratorFactory(@NotNull HeaderIdGeneratorFactory headerIdGeneratorFactory);

    @NotNull
    RendererBuilder linkResolverFactory(@NotNull LinkResolverFactory linkResolverFactory);
}
