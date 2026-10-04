package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.util.ast.Document;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface PhasedNodeRenderer extends NodeRenderer {
    @Nullable
    Set<RenderingPhase> getRenderingPhases();

    void renderDocument(@NotNull NodeRendererContext nodeRendererContext, @NotNull HtmlWriter htmlWriter, @NotNull Document document, @NotNull RenderingPhase renderingPhase);
}
