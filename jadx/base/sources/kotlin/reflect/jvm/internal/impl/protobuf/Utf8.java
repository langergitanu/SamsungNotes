package kotlin.reflect.jvm.internal.impl.protobuf;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Utf8 {
    private static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r7[r8] > (-65)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
    
        if (r7[r8] > (-65)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
    
        if (r7[r6] > (-65)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i4) {
        byte b;
        int i5;
        int i6;
        if (i != 0) {
            if (i2 >= i4) {
                return i;
            }
            byte b5 = (byte) i;
            if (b5 < -32) {
                if (b5 >= -62) {
                    i6 = i2 + 1;
                }
                return -1;
            }
            if (b5 < -16) {
                byte b6 = (byte) (~(i >> 8));
                if (b6 == 0) {
                    int i7 = i2 + 1;
                    byte b7 = bArr[i2];
                    if (i7 >= i4) {
                        return incompleteStateFor(b5, b7);
                    }
                    i2 = i7;
                    b6 = b7;
                }
                if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                    i6 = i2 + 1;
                }
                return -1;
            }
            byte b8 = (byte) (~(i >> 8));
            if (b8 == 0) {
                i5 = i2 + 1;
                b8 = bArr[i2];
                if (i5 >= i4) {
                    return incompleteStateFor(b5, b8);
                }
                b = 0;
            } else {
                b = (byte) (i >> 16);
                i5 = i2;
            }
            if (b == 0) {
                int i8 = i5 + 1;
                byte b9 = bArr[i5];
                if (i8 >= i4) {
                    return incompleteStateFor(b5, b8, b9);
                }
                b = b9;
                i5 = i8;
            }
            if (b8 <= -65) {
                if ((((b8 + SprAttributeBase.TYPE_SHADOW) + (b5 << 28)) >> 30) == 0 && b <= -65) {
                    i2 = i5 + 1;
                }
            }
            return -1;
            i2 = i6;
        }
        return partialIsValidUtf8(bArr, i2, i4);
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i4 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                if (b < -32) {
                    if (i4 >= i2) {
                        return b;
                    }
                    if (b >= -62) {
                        i += 2;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b < -16) {
                    if (i4 >= i2 - 1) {
                        return incompleteStateFor(bArr, i4, i2);
                    }
                    int i5 = i + 2;
                    byte b5 = bArr[i4];
                    if (b5 <= -65 && ((b != -32 || b5 >= -96) && (b != -19 || b5 < -96))) {
                        i += 3;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                }
                if (i4 >= i2 - 2) {
                    return incompleteStateFor(bArr, i4, i2);
                }
                int i6 = i + 2;
                byte b6 = bArr[i4];
                if (b6 <= -65) {
                    if ((((b6 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0) {
                        int i7 = i + 3;
                        if (bArr[i6] <= -65) {
                            i += 4;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i = i4;
        }
        return 0;
    }

    private static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return partialIsValidUtf8(bArr, i, i2) == 0;
    }

    private static int incompleteStateFor(int i, int i2, int i4) {
        if (i > -12 || i2 > -65 || i4 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i4 << 16);
    }

    private static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i4 = i2 - i;
        if (i4 == 0) {
            return incompleteStateFor(b);
        }
        if (i4 == 1) {
            return incompleteStateFor(b, bArr[i]);
        }
        if (i4 == 2) {
            return incompleteStateFor(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i, i2);
    }
}
