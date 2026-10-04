package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.parser.internal.BlockStartImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BlockStart {
    public static BlockStart none() {
        return null;
    }

    /* JADX INFO: renamed from: of */
    public static BlockStart m13315of(BlockParser... blockParserArr) {
        return new BlockStartImpl(blockParserArr);
    }

    public abstract BlockStart atColumn(int i);

    public abstract BlockStart atIndex(int i);

    public abstract BlockStart replaceActiveBlockParser();
}
