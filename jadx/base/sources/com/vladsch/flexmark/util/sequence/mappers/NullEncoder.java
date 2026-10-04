package com.vladsch.flexmark.util.sequence.mappers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NullEncoder {
    public static final CharMapper encodeNull = new EncodeNull();
    public static final CharMapper decodeNull = new DecodeNull();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DecodeNull implements CharMapper {
        @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
        public char map(char c) {
            if (c == 65533) {
                return (char) 0;
            }
            return c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EncodeNull implements CharMapper {
        @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
        public char map(char c) {
            if (c == 0) {
                return (char) 65533;
            }
            return c;
        }
    }
}
