package com.vladsch.flexmark.formatter;

import java.util.Set;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NodeFormatter {
    default char getBlockQuoteLikePrefixChar() {
        return (char) 0;
    }

    @Nullable
    Set<Class<?>> getNodeClasses();

    @Nullable
    Set<NodeFormattingHandler<?>> getNodeFormattingHandlers();
}
