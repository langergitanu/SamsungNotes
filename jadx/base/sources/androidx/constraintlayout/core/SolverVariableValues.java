package androidx.constraintlayout.core;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.f1211id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i4 = iArr2[i2];
        if (i4 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i5 = iArr[i4];
                if (i5 == -1) {
                    break;
                } else {
                    i4 = i5;
                }
            }
            iArr[i4] = i;
        }
        this.nextKeys[i] = -1;
    }

    private void addVariable(int i, SolverVariable solverVariable, float f) {
        this.variables[i] = solverVariable.f1211id;
        this.values[i] = f;
        this.previous[i] = -1;
        this.next[i] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i = 0; i < this.HASH_SIZE; i++) {
            if (this.keys[i] != -1) {
                String string = hashCode() + " hash [" + i + "] => ";
                int i2 = this.keys[i];
                boolean z = false;
                while (!z) {
                    StringBuilder sbM781w = AbstractC0541b.m781w(string, " ");
                    sbM781w.append(this.variables[i2]);
                    string = sbM781w.toString();
                    int i4 = this.nextKeys[i2];
                    if (i4 != -1) {
                        i2 = i4;
                    } else {
                        z = true;
                    }
                }
                System.out.println(string);
            }
        }
    }

    private int findEmptySlot() {
        for (int i = 0; i < this.SIZE; i++) {
            if (this.variables[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i);
        this.values = Arrays.copyOf(this.values, i);
        this.previous = Arrays.copyOf(this.previous, i);
        this.next = Arrays.copyOf(this.next, i);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i);
        for (int i2 = this.SIZE; i2 < i; i2++) {
            this.variables[i2] = -1;
            this.nextKeys[i2] = -1;
        }
        this.SIZE = i;
    }

    private void insertVariable(int i, SolverVariable solverVariable, float f) {
        int iFindEmptySlot = findEmptySlot();
        addVariable(iFindEmptySlot, solverVariable, f);
        if (i != -1) {
            this.previous[iFindEmptySlot] = i;
            int[] iArr = this.next;
            iArr[iFindEmptySlot] = iArr[i];
            iArr[i] = iFindEmptySlot;
        } else {
            this.previous[iFindEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[iFindEmptySlot] = this.head;
                this.head = iFindEmptySlot;
            } else {
                this.next[iFindEmptySlot] = -1;
            }
        }
        int i2 = this.next[iFindEmptySlot];
        if (i2 != -1) {
            this.previous[i2] = iFindEmptySlot;
        }
        addToHashMap(solverVariable, iFindEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i;
        int i2 = solverVariable.f1211id;
        int i4 = i2 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            return;
        }
        if (this.variables[i5] == i2) {
            int[] iArr3 = this.nextKeys;
            iArr2[i4] = iArr3[i5];
            iArr3[i5] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i = iArr[i5];
            if (i == -1 || this.variables[i] == i2) {
                break;
            } else {
                i5 = i;
            }
        }
        if (i == -1 || this.variables[i] != i2) {
            return;
        }
        iArr[i5] = iArr[i];
        iArr[i] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z) {
        float f4 = epsilon;
        if (f <= (-f4) || f >= f4) {
            int iIndexOf = indexOf(solverVariable);
            if (iIndexOf == -1) {
                put(solverVariable, f);
                return;
            }
            float[] fArr = this.values;
            float f5 = fArr[iIndexOf] + f;
            fArr[iIndexOf] = f5;
            float f6 = epsilon;
            if (f5 <= (-f6) || f5 >= f6) {
                return;
            }
            fArr[iIndexOf] = 0.0f;
            remove(solverVariable, z);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i4 = 0; i4 < this.SIZE; i4++) {
            this.variables[i4] = -1;
            this.nextKeys[i4] = -1;
        }
        for (int i5 = 0; i5 < this.HASH_SIZE; i5++) {
            this.keys[i5] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.mCount;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i2) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        int i = this.mCount;
        int i2 = this.head;
        for (int i4 = 0; i4 < i; i4++) {
            float[] fArr = this.values;
            fArr[i2] = fArr[i2] / f;
            i2 = this.next[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            return this.values[iIndexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        int i2 = this.mCount;
        if (i2 == 0) {
            return null;
        }
        int i4 = this.head;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i5 == i && i4 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i4]];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i2 = this.mCount;
        int i4 = this.head;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i5 == i) {
                return this.values[i4];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i = solverVariable.f1211id;
            int i2 = this.keys[i % this.HASH_SIZE];
            if (i2 == -1) {
                return -1;
            }
            if (this.variables[i2] == i) {
                return i2;
            }
            do {
                i2 = this.nextKeys[i2];
                if (i2 == -1) {
                    break;
                }
            } while (this.variables[i2] != i);
            if (i2 != -1 && this.variables[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.mCount;
        int i2 = this.head;
        for (int i4 = 0; i4 < i; i4++) {
            float[] fArr = this.values;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.next[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f) {
        float f4 = epsilon;
        if (f > (-f4) && f < f4) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            this.values[iIndexOf] = f;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i = this.mCount;
        int i2 = this.head;
        int i4 = -1;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = this.variables[i2];
            int i7 = solverVariable.f1211id;
            if (i6 == i7) {
                this.values[i2] = f;
                return;
            }
            if (i6 < i7) {
                i4 = i2;
            }
            i2 = this.next[i2];
            if (i2 == -1) {
                break;
            }
        }
        insertVariable(i4, solverVariable, f);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f = this.values[iIndexOf];
        if (this.head == iIndexOf) {
            this.head = this.next[iIndexOf];
        }
        this.variables[iIndexOf] = -1;
        int[] iArr = this.previous;
        int i = iArr[iIndexOf];
        if (i != -1) {
            int[] iArr2 = this.next;
            iArr2[i] = iArr2[iIndexOf];
        }
        int i2 = this.next[iIndexOf];
        if (i2 != -1) {
            iArr[i2] = iArr[iIndexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String strM756B;
        String strM756B2;
        String strM756B3 = hashCode() + " { ";
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                String str = strM756B3 + variable + " = " + getVariableValue(i2) + " ";
                int iIndexOf = indexOf(variable);
                String strM756B4 = AbstractC0541b.m756B(str, "[p: ");
                if (this.previous[iIndexOf] != -1) {
                    StringBuilder sbM1324q = AbstractC1974b.m1324q(strM756B4);
                    sbM1324q.append(this.mCache.mIndexedVariables[this.variables[this.previous[iIndexOf]]]);
                    strM756B = sbM1324q.toString();
                } else {
                    strM756B = AbstractC0541b.m756B(strM756B4, "none");
                }
                String strM756B5 = AbstractC0541b.m756B(strM756B, ", n: ");
                if (this.next[iIndexOf] != -1) {
                    StringBuilder sbM1324q2 = AbstractC1974b.m1324q(strM756B5);
                    sbM1324q2.append(this.mCache.mIndexedVariables[this.variables[this.next[iIndexOf]]]);
                    strM756B2 = sbM1324q2.toString();
                } else {
                    strM756B2 = AbstractC0541b.m756B(strM756B5, "none");
                }
                strM756B3 = AbstractC0541b.m756B(strM756B2, "]");
            }
        }
        return AbstractC0541b.m756B(strM756B3, " }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i = 0;
        int i2 = 0;
        while (i < currentSize) {
            int i4 = solverVariableValues.variables[i2];
            if (i4 != -1) {
                add(this.mCache.mIndexedVariables[i4], solverVariableValues.values[i2] * f, z);
                i++;
            }
            i2++;
        }
        return f;
    }
}
