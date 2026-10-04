package org.brotli.dec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Decode {
    private static final int CODE_LENGTH_CODES = 18;
    private static final int CODE_LENGTH_REPEAT_CODE = 16;
    private static final int DEFAULT_CODE_LENGTH = 8;
    private static final int DISTANCE_CONTEXT_BITS = 2;
    private static final int HUFFMAN_TABLE_BITS = 8;
    private static final int HUFFMAN_TABLE_MASK = 255;
    private static final int LITERAL_CONTEXT_BITS = 6;
    private static final int NUM_BLOCK_LENGTH_CODES = 26;
    private static final int NUM_DISTANCE_SHORT_CODES = 16;
    private static final int NUM_INSERT_AND_COPY_CODES = 704;
    private static final int NUM_LITERAL_CODES = 256;
    private static final int[] CODE_LENGTH_CODE_ORDER = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] DISTANCE_SHORT_CODE_INDEX_OFFSET = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] DISTANCE_SHORT_CODE_VALUE_OFFSET = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] FIXED_TABLE = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    private static void copyUncompressedData(State state) {
        BitReader bitReader = state.f10185br;
        byte[] bArr = state.ringBuffer;
        int i = state.metaBlockLength;
        if (i <= 0) {
            BitReader.reload(bitReader);
            state.runningState = 1;
            return;
        }
        int iMin = Math.min(state.ringBufferSize - state.pos, i);
        BitReader.copyBytes(bitReader, bArr, state.pos, iMin);
        state.metaBlockLength -= iMin;
        int i2 = state.pos + iMin;
        state.pos = i2;
        int i4 = state.ringBufferSize;
        if (i2 != i4) {
            BitReader.reload(bitReader);
            state.runningState = 1;
        } else {
            state.nextRunningState = 5;
            state.bytesToWrite = i4;
            state.bytesWritten = 0;
            state.runningState = 12;
        }
    }

    private static void decodeBlockTypeAndLength(State state, int i) {
        BitReader bitReader = state.f10185br;
        int[] iArr = state.blockTypeRb;
        int i2 = i * 2;
        BitReader.fillBitWindow(bitReader);
        int i4 = i * 1080;
        int symbol = readSymbol(state.blockTypeTrees, i4, bitReader);
        state.blockLength[i] = readBlockLength(state.blockLenTrees, i4, bitReader);
        int i5 = symbol == 1 ? iArr[i2 + 1] + 1 : symbol == 0 ? iArr[i2] : symbol - 2;
        int i6 = state.numBlockTypes[i];
        if (i5 >= i6) {
            i5 -= i6;
        }
        int i7 = i2 + 1;
        iArr[i2] = iArr[i7];
        iArr[i7] = i5;
    }

    private static void decodeCommandBlockSwitch(State state) {
        decodeBlockTypeAndLength(state, 1);
        state.treeCommandOffset = state.hGroup1.trees[state.blockTypeRb[3]];
    }

    private static int decodeContextMap(int i, byte[] bArr, BitReader bitReader) {
        BitReader.readMoreInput(bitReader);
        int iDecodeVarLenUnsignedByte = decodeVarLenUnsignedByte(bitReader) + 1;
        if (iDecodeVarLenUnsignedByte == 1) {
            Utils.fillWithZeroes(bArr, 0, i);
            return iDecodeVarLenUnsignedByte;
        }
        int bits = BitReader.readBits(bitReader, 1) == 1 ? BitReader.readBits(bitReader, 4) + 1 : 0;
        int[] iArr = new int[1080];
        readHuffmanCode(iDecodeVarLenUnsignedByte + bits, iArr, 0, bitReader);
        int i2 = 0;
        while (i2 < i) {
            BitReader.readMoreInput(bitReader);
            BitReader.fillBitWindow(bitReader);
            int symbol = readSymbol(iArr, 0, bitReader);
            if (symbol == 0) {
                bArr[i2] = 0;
            } else if (symbol <= bits) {
                for (int bits2 = (1 << symbol) + BitReader.readBits(bitReader, symbol); bits2 != 0; bits2--) {
                    if (i2 >= i) {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                    bArr[i2] = 0;
                    i2++;
                }
            } else {
                bArr[i2] = (byte) (symbol - bits);
            }
            i2++;
        }
        if (BitReader.readBits(bitReader, 1) == 1) {
            inverseMoveToFrontTransform(bArr, i);
        }
        return iDecodeVarLenUnsignedByte;
    }

    private static void decodeDistanceBlockSwitch(State state) {
        decodeBlockTypeAndLength(state, 2);
        state.distContextMapSlice = state.blockTypeRb[5] << 2;
    }

    private static void decodeLiteralBlockSwitch(State state) {
        decodeBlockTypeAndLength(state, 0);
        int i = state.blockTypeRb[1];
        int i2 = i << 6;
        state.contextMapSlice = i2;
        int i4 = state.contextMap[i2] & 255;
        state.literalTreeIndex = i4;
        state.literalTree = state.hGroup0.trees[i4];
        byte b = state.contextModes[i];
        int[] iArr = Context.LOOKUP_OFFSETS;
        state.contextLookupOffset1 = iArr[b];
        state.contextLookupOffset2 = iArr[b + 1];
    }

    private static void decodeMetaBlockLength(BitReader bitReader, State state) {
        boolean z = BitReader.readBits(bitReader, 1) == 1;
        state.inputEnd = z;
        state.metaBlockLength = 0;
        state.isUncompressed = false;
        state.isMetadata = false;
        if (!z || BitReader.readBits(bitReader, 1) == 0) {
            int bits = BitReader.readBits(bitReader, 2) + 4;
            if (bits == 7) {
                state.isMetadata = true;
                if (BitReader.readBits(bitReader, 1) != 0) {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
                int bits2 = BitReader.readBits(bitReader, 2);
                if (bits2 == 0) {
                    return;
                }
                for (int i = 0; i < bits2; i++) {
                    int bits3 = BitReader.readBits(bitReader, 8);
                    if (bits3 == 0 && i + 1 == bits2 && bits2 > 1) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    state.metaBlockLength = (bits3 << (i * 8)) | state.metaBlockLength;
                }
            } else {
                for (int i2 = 0; i2 < bits; i2++) {
                    int bits4 = BitReader.readBits(bitReader, 4);
                    if (bits4 == 0 && i2 + 1 == bits && bits > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    state.metaBlockLength = (bits4 << (i2 * 4)) | state.metaBlockLength;
                }
            }
            state.metaBlockLength++;
            if (state.inputEnd) {
                return;
            }
            state.isUncompressed = BitReader.readBits(bitReader, 1) == 1;
        }
    }

    private static int decodeVarLenUnsignedByte(BitReader bitReader) {
        if (BitReader.readBits(bitReader, 1) == 0) {
            return 0;
        }
        int bits = BitReader.readBits(bitReader, 3);
        if (bits == 0) {
            return 1;
        }
        return BitReader.readBits(bitReader, bits) + (1 << bits);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a2, code lost:
    
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0331 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0331 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0137 A[LOOP:4: B:50:0x0137->B:176:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void decompress(State state) {
        int i;
        char c;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = state.runningState;
        if (i9 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i9 == 11) {
            throw new IllegalStateException("Can't decompress after close");
        }
        BitReader bitReader = state.f10185br;
        int i10 = 1;
        int i11 = state.ringBufferSize - 1;
        byte[] bArr = state.ringBuffer;
        while (true) {
            int i12 = state.runningState;
            if (i12 == 10) {
                boolean z = i10;
                if (i12 == 10) {
                    if (state.metaBlockLength < 0) {
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    BitReader.jumpToByteBoundary(bitReader);
                    BitReader.checkHealth(state.f10185br, z);
                    return;
                }
                return;
            }
            if (i12 != 12) {
                char c2 = 2;
                int i13 = 0;
                switch (i12) {
                    case 1:
                        i = i10;
                        if (state.metaBlockLength < 0) {
                            throw new BrotliRuntimeException("Invalid metablock length");
                        }
                        readMetablockInfo(state);
                        i11 = state.ringBufferSize - 1;
                        bArr = state.ringBuffer;
                        break;
                        break;
                    case 2:
                        readMetablockHuffmanCodesAndContextMaps(state);
                        state.runningState = 3;
                        if (state.metaBlockLength > 0) {
                            state.runningState = i10;
                            i = i10;
                        } else {
                            BitReader.readMoreInput(bitReader);
                            if (state.blockLength[i10] == 0) {
                                decodeCommandBlockSwitch(state);
                            }
                            int[] iArr = state.blockLength;
                            iArr[i10] = iArr[i10] - i10;
                            BitReader.fillBitWindow(bitReader);
                            int symbol = readSymbol(state.hGroup1.codes, state.treeCommandOffset, bitReader);
                            int i14 = symbol >>> 6;
                            state.distanceCode = 0;
                            if (i14 >= 2) {
                                i14 -= 2;
                                state.distanceCode = -1;
                            }
                            int i15 = Prefix.INSERT_RANGE_LUT[i14] + ((symbol >>> 3) & 7);
                            int i16 = Prefix.COPY_RANGE_LUT[i14] + (symbol & 7);
                            state.insertLength = Prefix.INSERT_LENGTH_OFFSET[i15] + BitReader.readBits(bitReader, Prefix.INSERT_LENGTH_N_BITS[i15]);
                            state.copyLength = Prefix.COPY_LENGTH_OFFSET[i16] + BitReader.readBits(bitReader, Prefix.COPY_LENGTH_N_BITS[i16]);
                            state.f10186j = 0;
                            state.runningState = 6;
                            if (state.trivialLiteralContext) {
                                int i17 = state.pos;
                                int i18 = bArr[(i17 - 1) & i11] & 255;
                                int i19 = bArr[(i17 - 2) & i11] & 255;
                                while (true) {
                                    c = c2;
                                    if (state.f10186j < state.insertLength) {
                                        BitReader.readMoreInput(bitReader);
                                        if (state.blockLength[0] == 0) {
                                            decodeLiteralBlockSwitch(state);
                                        }
                                        byte[] bArr2 = state.contextMap;
                                        int i20 = state.contextMapSlice;
                                        int[] iArr2 = Context.LOOKUP;
                                        i = i10;
                                        int i21 = bArr2[i20 + (iArr2[state.contextLookupOffset1 + i18] | iArr2[state.contextLookupOffset2 + i19])] & 255;
                                        state.blockLength[0] = r5[0] - 1;
                                        BitReader.fillBitWindow(bitReader);
                                        HuffmanTreeGroup huffmanTreeGroup = state.hGroup0;
                                        int symbol2 = readSymbol(huffmanTreeGroup.codes, huffmanTreeGroup.trees[i21], bitReader);
                                        int i22 = state.pos;
                                        bArr[i22] = (byte) symbol2;
                                        state.f10186j++;
                                        state.pos = i22 + 1;
                                        if (i22 == i11) {
                                            state.nextRunningState = 6;
                                            state.bytesToWrite = state.ringBufferSize;
                                            state.bytesWritten = 0;
                                            state.runningState = 12;
                                        } else {
                                            i19 = i18;
                                            c2 = c;
                                            i18 = symbol2;
                                            i10 = i;
                                        }
                                    } else {
                                        i = i10;
                                    }
                                }
                            } else {
                                while (true) {
                                    if (state.f10186j < state.insertLength) {
                                        BitReader.readMoreInput(bitReader);
                                        if (state.blockLength[0] == 0) {
                                            decodeLiteralBlockSwitch(state);
                                        }
                                        int[] iArr3 = state.blockLength;
                                        iArr3[0] = iArr3[0] - i10;
                                        BitReader.fillBitWindow(bitReader);
                                        bArr[state.pos] = (byte) readSymbol(state.hGroup0.codes, state.literalTree, bitReader);
                                        state.f10186j += i10;
                                        int i23 = state.pos;
                                        state.pos = i23 + 1;
                                        if (i23 == i11) {
                                            state.nextRunningState = 6;
                                            state.bytesToWrite = state.ringBufferSize;
                                            state.bytesWritten = 0;
                                            state.runningState = 12;
                                        }
                                    }
                                }
                                i = i10;
                                c = 2;
                            }
                            if (state.runningState == 6) {
                                continue;
                            } else {
                                int i24 = state.metaBlockLength - state.insertLength;
                                state.metaBlockLength = i24;
                                if (i24 <= 0) {
                                    state.runningState = 3;
                                } else {
                                    if (state.distanceCode < 0) {
                                        BitReader.readMoreInput(bitReader);
                                        if (state.blockLength[c] == 0) {
                                            decodeDistanceBlockSwitch(state);
                                        }
                                        state.blockLength[c] = r3[c] - 1;
                                        BitReader.fillBitWindow(bitReader);
                                        HuffmanTreeGroup huffmanTreeGroup2 = state.hGroup2;
                                        int[] iArr4 = huffmanTreeGroup2.codes;
                                        int[] iArr5 = huffmanTreeGroup2.trees;
                                        byte[] bArr3 = state.distContextMap;
                                        int i25 = state.distContextMapSlice;
                                        int i26 = state.copyLength;
                                        int symbol3 = readSymbol(iArr4, iArr5[bArr3[i25 + (i26 > 4 ? 3 : i26 - 2)] & 255], bitReader);
                                        state.distanceCode = symbol3;
                                        int i27 = state.numDirectDistanceCodes;
                                        if (symbol3 >= i27) {
                                            int i28 = symbol3 - i27;
                                            int i29 = state.distancePostfixMask & i28;
                                            int i30 = i28 >>> state.distancePostfixBits;
                                            state.distanceCode = i30;
                                            int i31 = (i30 >>> 1) + 1;
                                            state.distanceCode = i27 + i29 + ((((((i30 & 1) + 2) << i31) - 4) + BitReader.readBits(bitReader, i31)) << state.distancePostfixBits);
                                        }
                                    }
                                    int iTranslateShortCodes = translateShortCodes(state.distanceCode, state.distRb, state.distRbIdx);
                                    state.distance = iTranslateShortCodes;
                                    if (iTranslateShortCodes < 0) {
                                        throw new BrotliRuntimeException("Negative distance");
                                    }
                                    int i32 = state.maxDistance;
                                    int i33 = state.maxBackwardDistance;
                                    if (i32 == i33 || (i2 = state.pos) >= i33) {
                                        state.maxDistance = i33;
                                    } else {
                                        state.maxDistance = i2;
                                    }
                                    state.copyDst = state.pos;
                                    if (iTranslateShortCodes > state.maxDistance) {
                                        state.runningState = 9;
                                    } else {
                                        if (state.distanceCode > 0) {
                                            int[] iArr6 = state.distRb;
                                            int i34 = state.distRbIdx;
                                            iArr6[i34 & 3] = iTranslateShortCodes;
                                            state.distRbIdx = i34 + 1;
                                        }
                                        if (state.copyLength > state.metaBlockLength) {
                                            throw new BrotliRuntimeException("Invalid backward reference");
                                        }
                                        state.f10186j = 0;
                                        state.runningState = 7;
                                        int i35 = state.pos;
                                        i4 = (i35 - state.distance) & i11;
                                        i5 = state.copyLength - state.f10186j;
                                        if (i4 + i5 < i11 || i35 + i5 >= i11) {
                                            do {
                                                i6 = state.f10186j;
                                                if (i6 >= state.copyLength) {
                                                    i7 = state.pos;
                                                    bArr[i7] = bArr[(i7 - state.distance) & i11];
                                                    state.metaBlockLength--;
                                                    state.f10186j = i6 + 1;
                                                    state.pos = i7 + 1;
                                                }
                                            } while (i7 != i11);
                                            i8 = 7;
                                            state.nextRunningState = 7;
                                            state.bytesToWrite = state.ringBufferSize;
                                            state.bytesWritten = 0;
                                            state.runningState = 12;
                                            if (state.runningState == i8) {
                                                state.runningState = 3;
                                            }
                                        } else {
                                            while (i13 < i5) {
                                                bArr[i35] = bArr[i4];
                                                i13++;
                                                i35++;
                                                i4++;
                                            }
                                            state.f10186j += i5;
                                            state.metaBlockLength -= i5;
                                            state.pos += i5;
                                        }
                                        i8 = 7;
                                        if (state.runningState == i8) {
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        if (state.metaBlockLength > 0) {
                        }
                        break;
                    case 4:
                        while (state.metaBlockLength > 0) {
                            BitReader.readMoreInput(bitReader);
                            BitReader.readBits(bitReader, 8);
                            state.metaBlockLength -= i10;
                        }
                        state.runningState = i10;
                        i = i10;
                        break;
                    case 5:
                        copyUncompressedData(state);
                        i = i10;
                        break;
                    case 6:
                        if (state.trivialLiteralContext) {
                        }
                        if (state.runningState == 6) {
                        }
                        break;
                    case 7:
                        i = i10;
                        int i352 = state.pos;
                        i4 = (i352 - state.distance) & i11;
                        i5 = state.copyLength - state.f10186j;
                        if (i4 + i5 < i11) {
                            do {
                                i6 = state.f10186j;
                                if (i6 >= state.copyLength) {
                                }
                            } while (i7 != i11);
                            i8 = 7;
                            state.nextRunningState = 7;
                            state.bytesToWrite = state.ringBufferSize;
                            state.bytesWritten = 0;
                            state.runningState = 12;
                            if (state.runningState == i8) {
                            }
                        }
                        break;
                    case 8:
                        int i36 = state.ringBufferSize;
                        System.arraycopy(bArr, i36, bArr, 0, state.copyDst - i36);
                        state.runningState = 3;
                        i = i10;
                        break;
                    case 9:
                        int i37 = state.copyLength;
                        if (i37 >= 4 && i37 <= 24) {
                            int i38 = Dictionary.OFFSETS_BY_LENGTH[i37];
                            int i39 = (state.distance - state.maxDistance) - i10;
                            int i40 = Dictionary.SIZE_BITS_BY_LENGTH[i37];
                            int i41 = ((i10 << i40) - i10) & i39;
                            int i42 = i39 >>> i40;
                            int i43 = (i41 * i37) + i38;
                            Transform[] transformArr = Transform.TRANSFORMS;
                            if (i42 >= transformArr.length) {
                                throw new BrotliRuntimeException("Invalid backward reference");
                            }
                            int iTransformDictionaryWord = Transform.transformDictionaryWord(bArr, state.copyDst, Dictionary.getData(), i43, state.copyLength, transformArr[i42]);
                            int i44 = state.copyDst + iTransformDictionaryWord;
                            state.copyDst = i44;
                            state.pos += iTransformDictionaryWord;
                            state.metaBlockLength -= iTransformDictionaryWord;
                            int i45 = state.ringBufferSize;
                            if (i44 >= i45) {
                                state.nextRunningState = 8;
                                state.bytesToWrite = i45;
                                state.bytesWritten = 0;
                                state.runningState = 12;
                            } else {
                                state.runningState = 3;
                            }
                            i = i10;
                        }
                        break;
                    default:
                        throw new BrotliRuntimeException("Unexpected state " + state.runningState);
                }
            } else {
                i = i10;
                if (!writeRingBuffer(state)) {
                    return;
                }
                int i46 = state.pos;
                int i47 = state.maxBackwardDistance;
                if (i46 >= i47) {
                    state.maxDistance = i47;
                }
                state.pos = i46 & i11;
                state.runningState = state.nextRunningState;
            }
            i10 = i;
        }
    }

    private static void inverseMoveToFrontTransform(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = bArr[i4] & 255;
            bArr[i4] = (byte) iArr[i5];
            if (i5 != 0) {
                moveToFront(iArr, i5);
            }
        }
    }

    private static void maybeReallocateRingBuffer(State state) {
        int i;
        int i2 = state.maxRingBufferSize;
        long j = i2;
        long j2 = state.expectedTotalSize;
        if (j > j2) {
            while (true) {
                int i4 = i2 >> 1;
                if (i4 <= ((int) j2) + state.customDictionary.length) {
                    break;
                } else {
                    i2 = i4;
                }
            }
            if (!state.inputEnd && i2 < 16384 && state.maxRingBufferSize >= 16384) {
                i2 = 16384;
            }
        }
        int i5 = state.ringBufferSize;
        if (i2 <= i5) {
            return;
        }
        byte[] bArr = new byte[i2 + 37];
        byte[] bArr2 = state.ringBuffer;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 0, i5);
        } else {
            byte[] bArr3 = state.customDictionary;
            if (bArr3.length != 0) {
                int length = bArr3.length;
                int i6 = state.maxBackwardDistance;
                if (length > i6) {
                    i = length - i6;
                } else {
                    i6 = length;
                    i = 0;
                }
                System.arraycopy(bArr3, i, bArr, 0, i6);
                state.pos = i6;
                state.bytesToIgnore = i6;
            }
        }
        state.ringBuffer = bArr;
        state.ringBufferSize = i2;
    }

    private static void moveToFront(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    private static int readBlockLength(int[] iArr, int i, BitReader bitReader) {
        BitReader.fillBitWindow(bitReader);
        int symbol = readSymbol(iArr, i, bitReader);
        return Prefix.BLOCK_LENGTH_OFFSET[symbol] + BitReader.readBits(bitReader, Prefix.BLOCK_LENGTH_N_BITS[symbol]);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void readHuffmanCode(int i, int[] iArr, int i2, BitReader bitReader) {
        int i4;
        int i5;
        int i6;
        BitReader.readMoreInput(bitReader);
        int[] iArr2 = new int[i];
        int bits = BitReader.readBits(bitReader, 2);
        boolean z = true;
        if (bits == 1) {
            int i7 = i - 1;
            int[] iArr3 = new int[4];
            int bits2 = BitReader.readBits(bitReader, 2) + 1;
            int i8 = 0;
            while (i7 != 0) {
                i7 >>= 1;
                i8++;
            }
            for (int i9 = 0; i9 < bits2; i9++) {
                int bits3 = BitReader.readBits(bitReader, i8) % i;
                iArr3[i9] = bits3;
                iArr2[bits3] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (bits2 != 1) {
                if (bits2 == 2) {
                    int i10 = iArr3[0];
                    int i11 = iArr3[1];
                    z = i10 != i11;
                    iArr2[i11] = 1;
                } else if (bits2 != 3) {
                    int i12 = iArr3[0];
                    int i13 = iArr3[1];
                    boolean z2 = (i12 == i13 || i12 == (i5 = iArr3[2]) || i12 == (i6 = iArr3[3]) || i13 == i5 || i13 == i6 || i5 == i6) ? false : true;
                    if (BitReader.readBits(bitReader, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z = z2;
                } else {
                    int i14 = iArr3[0];
                    int i15 = iArr3[1];
                    if (i14 != i15 && i14 != (i4 = iArr3[2]) && i15 != i4) {
                        z = true;
                    }
                }
            }
            if (z) {
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            Huffman.buildHuffmanTable(iArr, i2, 8, iArr2, i);
            return;
        }
        int[] iArr4 = new int[18];
        int i16 = 0;
        int i17 = 32;
        while (bits < 18 && i17 > 0) {
            int i18 = CODE_LENGTH_CODE_ORDER[bits];
            BitReader.fillBitWindow(bitReader);
            long j = bitReader.accumulator;
            int i19 = bitReader.bitOffset;
            int i20 = FIXED_TABLE[((int) (j >>> i19)) & 15];
            bitReader.bitOffset = i19 + (i20 >> 16);
            int i21 = i20 & 65535;
            iArr4[i18] = i21;
            if (i21 != 0) {
                i17 -= 32 >> i21;
                i16++;
            }
            bits++;
        }
        z = i16 == 1 || i17 == 0;
        readHuffmanCodeLengths(iArr4, i, iArr2, bitReader);
        z = z;
        if (z) {
        }
    }

    private static void readHuffmanCodeLengths(int[] iArr, int i, int[] iArr2, BitReader bitReader) {
        int[] iArr3 = new int[32];
        Huffman.buildHuffmanTable(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i4 = 32768;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i && i4 > 0) {
            BitReader.readMoreInput(bitReader);
            BitReader.fillBitWindow(bitReader);
            long j = bitReader.accumulator;
            int i8 = bitReader.bitOffset;
            int i9 = iArr3[((int) (j >>> i8)) & 31];
            bitReader.bitOffset = i8 + (i9 >> 16);
            int i10 = i9 & 65535;
            if (i10 < 16) {
                int i11 = i5 + 1;
                iArr2[i5] = i10;
                if (i10 != 0) {
                    i4 -= 32768 >> i10;
                    i5 = i11;
                    i2 = i10;
                } else {
                    i5 = i11;
                }
                i7 = 0;
            } else {
                int i12 = i10 - 14;
                int i13 = i10 == 16 ? i2 : 0;
                if (i6 != i13) {
                    i7 = 0;
                    i6 = i13;
                }
                int bits = BitReader.readBits(bitReader, i12) + 3 + (i7 > 0 ? (i7 - 2) << i12 : i7);
                int i14 = bits - i7;
                if (i5 + i14 > i) {
                    throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                }
                int i15 = 0;
                while (i15 < i14) {
                    iArr2[i5] = i6;
                    i15++;
                    i5++;
                }
                if (i6 != 0) {
                    i4 -= i14 << (15 - i6);
                }
                i7 = bits;
            }
        }
        if (i4 != 0) {
            throw new BrotliRuntimeException("Unused space");
        }
        Utils.fillWithZeroes(iArr2, i5, i - i5);
    }

    private static void readMetablockHuffmanCodesAndContextMaps(State state) {
        int i;
        int[] iArr;
        BitReader bitReader = state.f10185br;
        for (int i2 = 0; i2 < 3; i2++) {
            state.numBlockTypes[i2] = decodeVarLenUnsignedByte(bitReader) + 1;
            state.blockLength[i2] = 268435456;
            int i4 = state.numBlockTypes[i2];
            if (i4 > 1) {
                int i5 = i2 * 1080;
                readHuffmanCode(i4 + 2, state.blockTypeTrees, i5, bitReader);
                readHuffmanCode(26, state.blockLenTrees, i5, bitReader);
                state.blockLength[i2] = readBlockLength(state.blockLenTrees, i5, bitReader);
            }
        }
        BitReader.readMoreInput(bitReader);
        state.distancePostfixBits = BitReader.readBits(bitReader, 2);
        int bits = BitReader.readBits(bitReader, 4);
        int i6 = state.distancePostfixBits;
        int i7 = (bits << i6) + 16;
        state.numDirectDistanceCodes = i7;
        state.distancePostfixMask = (1 << i6) - 1;
        int i8 = i7 + (48 << i6);
        state.contextModes = new byte[state.numBlockTypes[0]];
        int i9 = 0;
        while (true) {
            i = state.numBlockTypes[0];
            if (i9 >= i) {
                break;
            }
            int iMin = Math.min(i9 + 96, i);
            while (i9 < iMin) {
                state.contextModes[i9] = (byte) (BitReader.readBits(bitReader, 2) << 1);
                i9++;
            }
            BitReader.readMoreInput(bitReader);
        }
        byte[] bArr = new byte[i << 6];
        state.contextMap = bArr;
        int iDecodeContextMap = decodeContextMap(i << 6, bArr, bitReader);
        state.trivialLiteralContext = true;
        int i10 = 0;
        while (true) {
            iArr = state.numBlockTypes;
            if (i10 >= (iArr[0] << 6)) {
                break;
            }
            if (state.contextMap[i10] != (i10 >> 6)) {
                state.trivialLiteralContext = false;
                break;
            }
            i10++;
        }
        int i11 = iArr[2];
        byte[] bArr2 = new byte[i11 << 2];
        state.distContextMap = bArr2;
        int iDecodeContextMap2 = decodeContextMap(i11 << 2, bArr2, bitReader);
        HuffmanTreeGroup.init(state.hGroup0, 256, iDecodeContextMap);
        HuffmanTreeGroup.init(state.hGroup1, NUM_INSERT_AND_COPY_CODES, state.numBlockTypes[1]);
        HuffmanTreeGroup.init(state.hGroup2, i8, iDecodeContextMap2);
        HuffmanTreeGroup.decode(state.hGroup0, bitReader);
        HuffmanTreeGroup.decode(state.hGroup1, bitReader);
        HuffmanTreeGroup.decode(state.hGroup2, bitReader);
        state.contextMapSlice = 0;
        state.distContextMapSlice = 0;
        int[] iArr2 = Context.LOOKUP_OFFSETS;
        byte b = state.contextModes[0];
        state.contextLookupOffset1 = iArr2[b];
        state.contextLookupOffset2 = iArr2[b + 1];
        state.literalTreeIndex = 0;
        state.literalTree = state.hGroup0.trees[0];
        state.treeCommandOffset = state.hGroup1.trees[0];
        int[] iArr3 = state.blockTypeRb;
        iArr3[4] = 1;
        iArr3[2] = 1;
        iArr3[0] = 1;
        iArr3[5] = 0;
        iArr3[3] = 0;
        iArr3[1] = 0;
    }

    private static void readMetablockInfo(State state) {
        BitReader bitReader = state.f10185br;
        if (state.inputEnd) {
            state.nextRunningState = 10;
            state.bytesToWrite = state.pos;
            state.bytesWritten = 0;
            state.runningState = 12;
            return;
        }
        HuffmanTreeGroup huffmanTreeGroup = state.hGroup0;
        huffmanTreeGroup.codes = null;
        huffmanTreeGroup.trees = null;
        HuffmanTreeGroup huffmanTreeGroup2 = state.hGroup1;
        huffmanTreeGroup2.codes = null;
        huffmanTreeGroup2.trees = null;
        HuffmanTreeGroup huffmanTreeGroup3 = state.hGroup2;
        huffmanTreeGroup3.codes = null;
        huffmanTreeGroup3.trees = null;
        BitReader.readMoreInput(bitReader);
        decodeMetaBlockLength(bitReader, state);
        if (state.metaBlockLength != 0 || state.isMetadata) {
            if (state.isUncompressed || state.isMetadata) {
                BitReader.jumpToByteBoundary(bitReader);
                state.runningState = state.isMetadata ? 4 : 5;
            } else {
                state.runningState = 2;
            }
            if (state.isMetadata) {
                return;
            }
            state.expectedTotalSize += (long) state.metaBlockLength;
            if (state.ringBufferSize < state.maxRingBufferSize) {
                maybeReallocateRingBuffer(state);
            }
        }
    }

    private static int readSymbol(int[] iArr, int i, BitReader bitReader) {
        long j = bitReader.accumulator;
        int i2 = bitReader.bitOffset;
        int i4 = (int) (j >>> i2);
        int i5 = i + (i4 & 255);
        int i6 = iArr[i5];
        int i7 = i6 >> 16;
        int i8 = i6 & 65535;
        if (i7 <= 8) {
            bitReader.bitOffset = i2 + i7;
            return i8;
        }
        int i9 = iArr[i5 + i8 + ((i4 & ((1 << i7) - 1)) >>> 8)];
        bitReader.bitOffset = (i9 >> 16) + 8 + i2;
        return i9 & 65535;
    }

    public static void setCustomDictionary(State state, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        state.customDictionary = bArr;
    }

    private static int translateShortCodes(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(i2 + DISTANCE_SHORT_CODE_INDEX_OFFSET[i]) & 3] + DISTANCE_SHORT_CODE_VALUE_OFFSET[i] : i - 15;
    }

    private static boolean writeRingBuffer(State state) {
        int i = state.bytesToIgnore;
        if (i != 0) {
            state.bytesWritten += i;
            state.bytesToIgnore = 0;
        }
        int iMin = Math.min(state.outputLength - state.outputUsed, state.bytesToWrite - state.bytesWritten);
        if (iMin != 0) {
            System.arraycopy(state.ringBuffer, state.bytesWritten, state.output, state.outputOffset + state.outputUsed, iMin);
            state.outputUsed += iMin;
            state.bytesWritten += iMin;
        }
        return state.outputUsed < state.outputLength;
    }
}
