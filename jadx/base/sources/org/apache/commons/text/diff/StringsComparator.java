package org.apache.commons.text.diff;

import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringsComparator {
    private final String left;
    private final String right;
    private final int[] vDown;
    private final int[] vUp;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Snake {
        private final int diag;
        private final int end;
        private final int start;

        public Snake(int i, int i2, int i4) {
            this.start = i;
            this.end = i2;
            this.diag = i4;
        }

        public int getDiag() {
            return this.diag;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }
    }

    public StringsComparator(String str, String str2) {
        this.left = str;
        this.right = str2;
        int iM2212c = AbstractC2821a.m2212c(str.length(), 2, str2);
        this.vDown = new int[iM2212c];
        this.vUp = new int[iM2212c];
    }

    private void buildScript(int i, int i2, int i4, int i5, EditScript<Character> editScript) {
        Snake middleSnake = getMiddleSnake(i, i2, i4, i5);
        if (middleSnake != null && ((middleSnake.getStart() != i2 || middleSnake.getDiag() != i2 - i5) && (middleSnake.getEnd() != i || middleSnake.getDiag() != i - i4))) {
            buildScript(i, middleSnake.getStart(), i4, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(start))));
            }
            buildScript(middleSnake.getEnd(), i2, middleSnake.getEnd() - middleSnake.getDiag(), i5, editScript);
            return;
        }
        int i6 = i;
        int i7 = i4;
        while (true) {
            if (i6 >= i2 && i7 >= i5) {
                return;
            }
            if (i6 < i2 && i7 < i5 && this.left.charAt(i6) == this.right.charAt(i7)) {
                editScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(i6))));
                i6++;
            } else if (i2 - i > i5 - i4) {
                editScript.append(new DeleteCommand<>(Character.valueOf(this.left.charAt(i6))));
                i6++;
            } else {
                editScript.append(new InsertCommand<>(Character.valueOf(this.right.charAt(i7))));
            }
            i7++;
        }
    }

    private Snake buildSnake(int i, int i2, int i4, int i5) {
        int i6 = i;
        while (true) {
            int i7 = i6 - i2;
            if (i7 >= i5 || i6 >= i4 || this.left.charAt(i6) != this.right.charAt(i7)) {
                break;
            }
            i6++;
        }
        return new Snake(i, i6, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0105, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Snake getMiddleSnake(int i, int i2, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i2 - i;
        int i9 = i5 - i4;
        if (i8 == 0 || i9 == 0) {
            return null;
        }
        int i10 = i8 - i9;
        int i11 = i9 + i8;
        if (i11 % 2 != 0) {
            i11++;
        }
        int i12 = i11 / 2;
        int i13 = i12 + 1;
        this.vDown[i13] = i;
        this.vUp[i13] = i2 + 1;
        int i14 = 0;
        while (i14 <= i12) {
            int i15 = -i14;
            for (int i16 = i15; i16 <= i14; i16 += 2) {
                int i17 = i16 + i12;
                if (i16 == i15) {
                    int[] iArr = this.vDown;
                    iArr[i17] = iArr[i17 + 1];
                } else {
                    if (i16 != i14) {
                        int[] iArr2 = this.vDown;
                        if (iArr2[i17 - 1] < iArr2[i17 + 1]) {
                        }
                    }
                    int[] iArr3 = this.vDown;
                    iArr3[i17] = iArr3[i17 - 1] + 1;
                }
                int i18 = this.vDown[i17];
                for (int i19 = ((i18 - i) + i4) - i16; i18 < i2 && i19 < i5 && this.left.charAt(i18) == this.right.charAt(i19); i19++) {
                    i18++;
                    this.vDown[i17] = i18;
                }
                if (i10 % 2 != 0 && i10 - i14 <= i16 && i16 <= i10 + i14 && (i7 = this.vUp[i17 - i10]) <= this.vDown[i17]) {
                    return buildSnake(i7, (i16 + i) - i4, i2, i5);
                }
            }
            int i20 = i10 - i14;
            int i21 = i20;
            while (true) {
                int i22 = i10 + i14;
                if (i21 <= i22) {
                    int i23 = (i21 + i12) - i10;
                    if (i21 == i20) {
                        this.vUp[i23] = r6[i23 + 1] - 1;
                    } else {
                        if (i21 != i22) {
                            int[] iArr4 = this.vUp;
                            if (iArr4[i23 + 1] <= iArr4[i23 - 1]) {
                            }
                        }
                        int[] iArr5 = this.vUp;
                        iArr5[i23] = iArr5[i23 - 1];
                    }
                    int i24 = this.vUp[i23] - 1;
                    int i25 = ((i24 - i) + i4) - i21;
                    while (i24 >= i && i25 >= i4 && this.left.charAt(i24) == this.right.charAt(i25)) {
                        this.vUp[i23] = i24;
                        i25--;
                        i24--;
                    }
                    if (i10 % 2 == 0 && i15 <= i21 && i21 <= i14 && (i6 = this.vUp[i23]) <= this.vDown[i23 + i10]) {
                        return buildSnake(i6, (i21 + i) - i4, i2, i5);
                    }
                    i21 += 2;
                }
            }
        }
        throw new IllegalStateException("Internal Error");
    }

    public EditScript<Character> getScript() {
        EditScript<Character> editScript = new EditScript<>();
        buildScript(0, this.left.length(), 0, this.right.length(), editScript);
        return editScript;
    }
}
