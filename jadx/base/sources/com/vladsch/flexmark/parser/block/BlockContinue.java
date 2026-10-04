package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.parser.internal.BlockContinueImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockContinue {
    public static BlockContinue atColumn(int i) {
        return new BlockContinueImpl(-1, i, false);
    }

    public static BlockContinue atIndex(int i) {
        return new BlockContinueImpl(i, -1, false);
    }

    public static BlockContinue finished() {
        return new BlockContinueImpl(-1, -1, true);
    }

    public static BlockContinue none() {
        return null;
    }
}
