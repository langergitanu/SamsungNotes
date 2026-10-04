package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class FastLz {
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int CHECKSUM_OFFSET = 4;
    private static final int HASH_LOG = 13;
    private static final int HASH_MASK = 8191;
    private static final int HASH_SIZE = 8192;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final int LEVEL_AUTO = 0;
    static final int MAGIC_NUMBER = 4607066;
    static final int MAX_CHUNK_LENGTH = 65535;
    private static final int MAX_COPY = 32;
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int MAX_LEN = 264;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int OPTIONS_OFFSET = 3;

    private FastLz() {
    }

    public static int calculateOutputBufferLength(int i) {
        return Math.max((int) (((double) i) * 1.06d), 66);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int compress(ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2, int i4, int i5) {
        int i6;
        long j;
        int i7;
        boolean z;
        int i8;
        long j2;
        boolean z2;
        int i9;
        int i10;
        int i11;
        char c;
        int i12 = 2;
        boolean z3 = true;
        int i13 = i5 == 0 ? i2 < 65536 ? 1 : 2 : i5;
        int i14 = i2 - 2;
        int i15 = i2 - 12;
        int[] iArr = new int[8192];
        if (i2 < 4) {
            if (i2 == 0) {
                return 0;
            }
            byteBuf2.setByte(i4, (byte) (i2 - 1));
            int i16 = i2 - 1;
            int i17 = 1;
            for (int i18 = 0; i18 <= i16; i18++) {
                byteBuf2.setByte(i17 + i4, byteBuf.getByte(i + i18));
                i17++;
            }
            return i2 + 1;
        }
        for (int i19 = 0; i19 < 8192; i19++) {
            iArr[i19] = 0;
        }
        byteBuf2.setByte(i4, 31);
        byteBuf2.setByte(i4 + 1, byteBuf.getByte(i));
        byteBuf2.setByte(i4 + 2, byteBuf.getByte(i + 1));
        int i20 = 2;
        int i21 = 2;
        int i22 = 3;
        while (i20 < i15) {
            if (i13 == i12) {
                int i23 = i + i20;
                int i24 = i23 - 1;
                if (byteBuf.getByte(i23) == byteBuf.getByte(i24) && readU16(byteBuf, i24) == readU16(byteBuf, i23 + 1)) {
                    i6 = i20 + 3;
                    i7 = i20 + 2;
                    z = z3;
                    j = 1;
                } else {
                    i6 = i20;
                    j = 0;
                    i7 = 0;
                    z = false;
                }
            }
            if (!z) {
                int i25 = i + i6;
                int iHashFunction = hashFunction(byteBuf, i25);
                int i26 = iArr[iHashFunction];
                int i27 = i6;
                long j3 = i20 - i26;
                iArr[iHashFunction] = i20;
                if (j3 == 0 || (i13 != 1 ? j3 >= 73725 : j3 >= 8191)) {
                    i10 = i22 + 1;
                    i11 = i20 + 1;
                    byteBuf2.setByte(i4 + i22, byteBuf.getByte(i + i20));
                    i21++;
                    if (i21 == 32) {
                        i22 += 2;
                        c = 31;
                        byteBuf2.setByte(i10 + i4, 31);
                        i20 = i11;
                        i12 = 2;
                        z3 = true;
                        i21 = 0;
                    } else {
                        i22 = i10;
                        i20 = i11;
                        i12 = 2;
                        z3 = true;
                    }
                } else {
                    int i28 = i26 + 1;
                    int i29 = i27 + 1;
                    if (byteBuf.getByte(i + i26) == byteBuf.getByte(i25)) {
                        int i30 = i26 + 2;
                        byte b = byteBuf.getByte(i + i28);
                        int i31 = i27 + 2;
                        if (b == byteBuf.getByte(i + i29)) {
                            i7 = i26 + 3;
                            int i32 = i27 + 3;
                            if (byteBuf.getByte(i + i30) == byteBuf.getByte(i + i31)) {
                                if (i13 != 2 || j3 < 8191) {
                                    j = j3;
                                } else {
                                    int i33 = i27 + 4;
                                    byte b5 = byteBuf.getByte(i + i32);
                                    int i34 = i26 + 4;
                                    if (b5 == byteBuf.getByte(i + i7)) {
                                        i7 = i26 + 5;
                                        if (byteBuf.getByte(i + i33) == byteBuf.getByte(i + i34)) {
                                            i8 = 5;
                                            j = j3;
                                            int i35 = i8 + i20;
                                            j2 = j - 1;
                                            if (j2 != 0) {
                                                byte b6 = byteBuf.getByte((i + i35) - 1);
                                                while (i35 < i14) {
                                                    int i36 = i7 + 1;
                                                    if (byteBuf.getByte(i + i7) != b6) {
                                                        break;
                                                    }
                                                    i35++;
                                                    i7 = i36;
                                                }
                                            } else {
                                                int i37 = 0;
                                                while (true) {
                                                    if (i37 >= 8) {
                                                        z2 = false;
                                                        break;
                                                    }
                                                    int i38 = i7 + 1;
                                                    int i39 = i35 + 1;
                                                    if (byteBuf.getByte(i + i7) != byteBuf.getByte(i + i35)) {
                                                        i7 = i38;
                                                        i35 = i39;
                                                        z2 = true;
                                                        break;
                                                    }
                                                    i37++;
                                                    i7 = i38;
                                                    i35 = i39;
                                                }
                                                if (!z2) {
                                                    while (true) {
                                                        if (i35 >= i14) {
                                                            break;
                                                        }
                                                        int i40 = i7 + 1;
                                                        int i41 = i35 + 1;
                                                        if (byteBuf.getByte(i + i7) != byteBuf.getByte(i + i35)) {
                                                            i35 = i41;
                                                            break;
                                                        }
                                                        i7 = i40;
                                                        i35 = i41;
                                                    }
                                                }
                                            }
                                            if (i21 == 0) {
                                                byteBuf2.setByte(((i4 + i22) - i21) - 1, (byte) (i21 - 1));
                                            } else {
                                                i22--;
                                            }
                                            int i42 = i35 - 3;
                                            int i43 = i42 - i20;
                                            int i44 = 7;
                                            if (i13 == 2) {
                                                if (i43 > 262) {
                                                    while (i43 > 262) {
                                                        int i45 = i22;
                                                        byteBuf2.setByte(i4 + i22, (byte) ((j2 >>> 8) + 224));
                                                        byteBuf2.setByte(i22 + 1 + i4, -3);
                                                        byteBuf2.setByte(i4 + i45 + 2, (byte) (j2 & 255));
                                                        i43 -= 262;
                                                        i22 = i45 + 3;
                                                        i44 = 7;
                                                    }
                                                }
                                                if (i43 < i44) {
                                                    int i46 = i22 + 1;
                                                    byteBuf2.setByte(i4 + i22, (byte) (((long) (i43 << 5)) + (j2 >>> 8)));
                                                    i9 = i22 + 2;
                                                    byteBuf2.setByte(i46 + i4, (byte) (j2 & 255));
                                                } else {
                                                    byteBuf2.setByte(i4 + i22, (byte) ((j2 >>> 8) + 224));
                                                    int i47 = i22 + 2;
                                                    byteBuf2.setByte(i22 + 1 + i4, (byte) (i43 - 7));
                                                    i9 = i22 + 3;
                                                    byteBuf2.setByte(i4 + i47, (byte) (j2 & 255));
                                                }
                                            } else if (j2 < 8191) {
                                                if (i43 < 7) {
                                                    int i48 = i22 + 1;
                                                    byteBuf2.setByte(i4 + i22, (byte) (((long) (i43 << 5)) + (j2 >>> 8)));
                                                    i9 = i22 + 2;
                                                    byteBuf2.setByte(i4 + i48, (byte) (j2 & 255));
                                                } else {
                                                    int i49 = i22 + 1;
                                                    byteBuf2.setByte(i4 + i22, (byte) ((j2 >>> 8) + 224));
                                                    int i50 = i43 - 7;
                                                    while (i50 >= 255) {
                                                        byteBuf2.setByte(i49 + i4, -1);
                                                        i50 -= 255;
                                                        i49++;
                                                    }
                                                    byteBuf2.setByte(i4 + i49, (byte) i50);
                                                    i9 = i49 + 2;
                                                    byteBuf2.setByte(i4 + i49 + 1, (byte) (j2 & 255));
                                                }
                                            } else if (i43 < 7) {
                                                long j5 = j - 8192;
                                                byteBuf2.setByte(i4 + i22, (byte) ((i43 << 5) + 31));
                                                byteBuf2.setByte(i22 + 1 + i4, -1);
                                                int i51 = i22 + 3;
                                                byteBuf2.setByte(i22 + 2 + i4, (byte) (j5 >>> 8));
                                                i9 = i22 + 4;
                                                byteBuf2.setByte(i51 + i4, (byte) (j5 & 255));
                                            } else {
                                                long j6 = j - 8192;
                                                int i52 = i22 + 1;
                                                byteBuf2.setByte(i4 + i22, -1);
                                                int i53 = i43 - 7;
                                                while (i53 >= 255) {
                                                    byteBuf2.setByte(i52 + i4, -1);
                                                    i53 -= 255;
                                                    i52++;
                                                }
                                                byteBuf2.setByte(i4 + i52, (byte) i53);
                                                byteBuf2.setByte(i52 + 1 + i4, -1);
                                                byteBuf2.setByte(i52 + 2 + i4, (byte) (j6 >>> 8));
                                                i9 = i52 + 4;
                                                byteBuf2.setByte(i4 + i52 + 3, (byte) (j6 & 255));
                                            }
                                            int i54 = i35 - 2;
                                            iArr[hashFunction(byteBuf, i + i42)] = i42;
                                            i20 = i35 - 1;
                                            iArr[hashFunction(byteBuf, i + i54)] = i54;
                                            byteBuf2.setByte(i4 + i9, 31);
                                            i22 = i9 + 1;
                                            i12 = 2;
                                            z3 = true;
                                            i21 = 0;
                                        }
                                    }
                                    i10 = i22 + 1;
                                    i11 = i20 + 1;
                                    byteBuf2.setByte(i4 + i22, byteBuf.getByte(i + i20));
                                    i21++;
                                    if (i21 == 32) {
                                        i22 += 2;
                                        c = 31;
                                        byteBuf2.setByte(i10 + i4, 31);
                                        i20 = i11;
                                        i12 = 2;
                                        z3 = true;
                                        i21 = 0;
                                    } else {
                                        i22 = i10;
                                        i20 = i11;
                                        i12 = 2;
                                        z3 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i8 = 3;
            int i352 = i8 + i20;
            j2 = j - 1;
            if (j2 != 0) {
            }
            if (i21 == 0) {
            }
            int i422 = i352 - 3;
            int i432 = i422 - i20;
            int i442 = 7;
            if (i13 == 2) {
            }
            int i542 = i352 - 2;
            iArr[hashFunction(byteBuf, i + i422)] = i422;
            i20 = i352 - 1;
            iArr[hashFunction(byteBuf, i + i542)] = i542;
            byteBuf2.setByte(i4 + i9, 31);
            i22 = i9 + 1;
            i12 = 2;
            z3 = true;
            i21 = 0;
        }
        int i55 = i2 - 1;
        while (i20 <= i55) {
            int i56 = i22 + 1;
            int i57 = i20 + 1;
            byteBuf2.setByte(i4 + i22, byteBuf.getByte(i + i20));
            i21++;
            if (i21 == 32) {
                i22 += 2;
                byteBuf2.setByte(i56 + i4, 31);
                i20 = i57;
                i21 = 0;
            } else {
                i22 = i56;
                i20 = i57;
            }
        }
        if (i21 != 0) {
            byteBuf2.setByte(((i4 + i22) - i21) - 1, (byte) (i21 - 1));
        } else {
            i22--;
        }
        if (i13 == 2) {
            byteBuf2.setByte(i4, byteBuf2.getByte(i4) | 32);
        }
        return i22;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int decompress(ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2, int i4, int i5) {
        int i6;
        boolean z;
        long j;
        int unsignedByte;
        int i7;
        char c = 5;
        boolean z2 = true;
        int i8 = (byteBuf.getByte(i) >> 5) + 1;
        if (i8 != 1 && i8 != 2) {
            throw new DecompressionException(String.format("invalid level: %d (expected: %d or %d)", Integer.valueOf(i8), 1, 2));
        }
        long unsignedByte2 = byteBuf.getByte(i) & 31;
        int i9 = 1;
        boolean z3 = true;
        int i10 = 0;
        while (true) {
            long j2 = unsignedByte2 >> c;
            long j3 = (31 & unsignedByte2) << 8;
            if (unsignedByte2 >= 32) {
                long unsignedByte3 = j2 - 1;
                long j5 = i10;
                int i11 = i10;
                int i12 = (int) (j5 - j3);
                if (unsignedByte3 != 6) {
                    j = unsignedByte2;
                    if (i8 == 1) {
                        i7 = i9 + 1;
                        unsignedByte = i12 - byteBuf.getUnsignedByte(i + i9);
                    } else {
                        int i13 = i9 + 1;
                        short unsignedByte4 = byteBuf.getUnsignedByte(i + i9);
                        unsignedByte = i12 - unsignedByte4;
                        if (unsignedByte4 == 255 && j3 == 7936) {
                            unsignedByte = (int) ((j5 - (((long) (byteBuf.getUnsignedByte(i + i13) << 8)) + ((long) byteBuf.getUnsignedByte(i + (i9 + 2))))) - 8191);
                            i7 = i9 + 3;
                        } else {
                            i7 = i13;
                        }
                    }
                    if (j5 + unsignedByte3 + 3 > i5 || unsignedByte - 1 < 0) {
                        return 0;
                    }
                    if (i7 >= i2) {
                        unsignedByte2 = byteBuf.getUnsignedByte(i + i7);
                        i7++;
                    } else {
                        z3 = false;
                        unsignedByte2 = j;
                    }
                    if (unsignedByte != i11) {
                        z = true;
                        byte b = byteBuf2.getByte((i4 + unsignedByte) - 1);
                        byteBuf2.setByte(i4 + i11, b);
                        byteBuf2.setByte(i4 + i11 + 1, b);
                        i10 = i11 + 3;
                        byteBuf2.setByte(i4 + i11 + 2, b);
                        while (unsignedByte3 != 0) {
                            byteBuf2.setByte(i4 + i10, b);
                            unsignedByte3--;
                            i10++;
                        }
                        i6 = i8;
                    } else {
                        z = true;
                        byteBuf2.setByte(i4 + i11, byteBuf2.getByte(i4 + (unsignedByte - 1)));
                        int i14 = unsignedByte + 1;
                        i6 = i8;
                        byteBuf2.setByte(i4 + i11 + 1, byteBuf2.getByte(i4 + unsignedByte));
                        int i15 = i11 + 3;
                        int i16 = unsignedByte + 2;
                        byteBuf2.setByte(i4 + i11 + 2, byteBuf2.getByte(i4 + i14));
                        while (unsignedByte3 != 0) {
                            byteBuf2.setByte(i4 + i15, byteBuf2.getByte(i4 + i16));
                            unsignedByte3--;
                            i15++;
                            i16++;
                        }
                        i10 = i15;
                    }
                    i9 = i7;
                } else if (i8 == 1) {
                    unsignedByte3 += (long) byteBuf.getUnsignedByte(i + i9);
                    i9++;
                    j = unsignedByte2;
                    if (i8 == 1) {
                    }
                    if (j5 + unsignedByte3 + 3 > i5) {
                        return 0;
                    }
                    if (i7 >= i2) {
                    }
                    if (unsignedByte != i11) {
                    }
                    i9 = i7;
                } else {
                    while (true) {
                        short unsignedByte5 = byteBuf.getUnsignedByte(i + i9);
                        j = unsignedByte2;
                        unsignedByte3 += (long) unsignedByte5;
                        i9++;
                        if (unsignedByte5 != 255) {
                            break;
                        }
                        unsignedByte2 = j;
                    }
                    if (i8 == 1) {
                    }
                    if (j5 + unsignedByte3 + 3 > i5) {
                    }
                }
            } else {
                i6 = i8;
                z = z2;
                long j6 = unsignedByte2;
                int i17 = i10;
                long j7 = j6 + 1;
                if (((long) i17) + j7 > i5 || ((long) i9) + j7 > i2) {
                    return 0;
                }
                i10 = i17 + 1;
                int i18 = i9 + 1;
                byteBuf2.setByte(i4 + i17, byteBuf.getByte(i + i9));
                unsignedByte2 = j6;
                while (unsignedByte2 != 0) {
                    byteBuf2.setByte(i4 + i10, byteBuf.getByte(i + i18));
                    unsignedByte2--;
                    i10++;
                    i18++;
                }
                boolean z4 = i18 < i2 ? z : false;
                if (z4) {
                    unsignedByte2 = byteBuf.getUnsignedByte(i + i18);
                    i9 = i18 + 1;
                } else {
                    i9 = i18;
                }
                z3 = z4;
            }
            if (!z3) {
                return i10;
            }
            i8 = i6;
            z2 = z;
            c = 5;
        }
    }

    private static int hashFunction(ByteBuf byteBuf, int i) {
        int u16 = readU16(byteBuf, i);
        return ((readU16(byteBuf, i + 1) ^ (u16 >> 3)) ^ u16) & 8191;
    }

    private static int readU16(ByteBuf byteBuf, int i) {
        int i2 = i + 1;
        if (i2 >= byteBuf.readableBytes()) {
            return byteBuf.getUnsignedByte(i);
        }
        return byteBuf.getUnsignedByte(i) | (byteBuf.getUnsignedByte(i2) << 8);
    }
}
