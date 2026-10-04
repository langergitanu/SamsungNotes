package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.dependency.Dependent;
import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface CustomBlockParserFactory extends Function<DataHolder, BlockParserFactory>, Dependent {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    @NotNull
    BlockParserFactory apply(@NotNull DataHolder dataHolder);

    @Nullable
    default SpecialLeadInHandler getLeadInHandler(@NotNull DataHolder dataHolder) {
        return null;
    }
}
