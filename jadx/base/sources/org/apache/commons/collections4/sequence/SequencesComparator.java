package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SequencesComparator<T> {
    private final Equator<? super T> equator;
    private final List<T> sequence1;
    private final List<T> sequence2;
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

    public SequencesComparator(List<T> list, List<T> list2) {
        this(list, list2, DefaultEquator.defaultEquator());
    }

    private void buildScript(int i, int i2, int i4, int i5, EditScript<T> editScript) {
        Snake middleSnake = getMiddleSnake(i, i2, i4, i5);
        if (middleSnake != null && ((middleSnake.getStart() != i2 || middleSnake.getDiag() != i2 - i5) && (middleSnake.getEnd() != i || middleSnake.getDiag() != i - i4))) {
            buildScript(i, middleSnake.getStart(), i4, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(this.sequence1.get(start)));
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
            if (i6 < i2 && i7 < i5 && this.equator.equate(this.sequence1.get(i6), this.sequence2.get(i7))) {
                editScript.append(new KeepCommand<>(this.sequence1.get(i6)));
                i6++;
            } else if (i2 - i > i5 - i4) {
                editScript.append(new DeleteCommand<>(this.sequence1.get(i6)));
                i6++;
            } else {
                editScript.append(new InsertCommand<>(this.sequence2.get(i7)));
            }
            i7++;
        }
    }

    private Snake buildSnake(int i, int i2, int i4, int i5) {
        int i6 = i;
        while (true) {
            int i7 = i6 - i2;
            if (i7 >= i5 || i6 >= i4 || !this.equator.equate(this.sequence1.get(i6), this.sequence2.get(i7))) {
                break;
            }
            i6++;
        }
        return new Snake(i, i6, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0120, code lost:
    
        r5 = r5 + 1;
        r1 = r17;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Snake getMiddleSnake(int i, int i2, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i;
        int i9 = i2 - i8;
        int i10 = i5 - i4;
        if (i9 == 0 || i10 == 0) {
            return null;
        }
        int i11 = i9 - i10;
        int i12 = i10 + i9;
        if (i12 % 2 != 0) {
            i12++;
        }
        int i13 = i12 / 2;
        int i14 = i13 + 1;
        this.vDown[i14] = i8;
        this.vUp[i14] = i2 + 1;
        int i15 = 0;
        while (i15 <= i13) {
            int i16 = -i15;
            for (int i17 = i16; i17 <= i15; i17 += 2) {
                int i18 = i17 + i13;
                if (i17 == i16) {
                    int[] iArr = this.vDown;
                    iArr[i18] = iArr[i18 + 1];
                } else {
                    if (i17 != i15) {
                        int[] iArr2 = this.vDown;
                        if (iArr2[i18 - 1] < iArr2[i18 + 1]) {
                        }
                    }
                    int[] iArr3 = this.vDown;
                    iArr3[i18] = iArr3[i18 - 1] + 1;
                }
                int i19 = this.vDown[i18];
                for (int i20 = ((i19 - i8) + i4) - i17; i19 < i2 && i20 < i5 && this.equator.equate(this.sequence1.get(i19), this.sequence2.get(i20)); i20++) {
                    i19++;
                    this.vDown[i18] = i19;
                }
                if (i11 % 2 != 0 && i11 - i15 <= i17 && i17 <= i11 + i15 && (i7 = this.vUp[i18 - i11]) <= this.vDown[i18]) {
                    return buildSnake(i7, (i17 + i8) - i4, i2, i5);
                }
            }
            int i21 = i11 - i15;
            int i22 = i21;
            while (true) {
                int i23 = i11 + i15;
                if (i22 <= i23) {
                    int i24 = (i22 + i13) - i11;
                    if (i22 == i21) {
                        this.vUp[i24] = r11[i24 + 1] - 1;
                    } else {
                        if (i22 != i23) {
                            int[] iArr4 = this.vUp;
                            if (iArr4[i24 + 1] <= iArr4[i24 - 1]) {
                            }
                        }
                        int[] iArr5 = this.vUp;
                        iArr5[i24] = iArr5[i24 - 1];
                    }
                    int i25 = this.vUp[i24] - 1;
                    int i26 = ((i25 - i8) + i4) - i22;
                    while (i25 >= i8 && i26 >= i4 && this.equator.equate(this.sequence1.get(i25), this.sequence2.get(i26))) {
                        this.vUp[i24] = i25;
                        i26--;
                        i8 = i;
                        i25--;
                    }
                    if (i11 % 2 == 0 && i16 <= i22 && i22 <= i15 && (i6 = this.vUp[i24]) <= this.vDown[i24 + i11]) {
                        return buildSnake(i6, (i22 + i) - i4, i2, i5);
                    }
                    i22 += 2;
                    i8 = i;
                }
            }
        }
        throw new IllegalStateException("Internal Error");
    }

    public EditScript<T> getScript() {
        EditScript<T> editScript = new EditScript<>();
        buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), editScript);
        return editScript;
    }

    public SequencesComparator(List<T> list, List<T> list2, Equator<? super T> equator) {
        this.sequence1 = list;
        this.sequence2 = list2;
        this.equator = equator;
        int size = list2.size() + list.size() + 2;
        this.vDown = new int[size];
        this.vUp = new int[size];
    }
}
