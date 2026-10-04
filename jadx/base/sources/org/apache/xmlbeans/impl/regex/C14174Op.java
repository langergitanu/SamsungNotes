package org.apache.xmlbeans.impl.regex;

import java.util.Vector;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class C14174Op {
    static final int ANCHOR = 5;
    static final int BACKREFERENCE = 16;
    static final int CAPTURE = 15;
    static final int CHAR = 1;
    static final int CLOSURE = 7;
    static final int CONDITION = 26;
    static final boolean COUNT = false;
    static final int DOT = 0;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIER = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    static final int NONGREEDYCLOSURE = 8;
    static final int NONGREEDYQUESTION = 10;
    static final int NRANGE = 4;
    static final int QUESTION = 9;
    static final int RANGE = 3;
    static final int STRING = 6;
    static final int UNION = 11;
    static int nofinstances;
    C14174Op next = null;
    int type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op$CharOp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CharOp extends C14174Op {
        int charData;

        public CharOp(int i, int i2) {
            super(i);
            this.charData = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public int getData() {
            return this.charData;
        }
    }

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op$ChildOp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ChildOp extends C14174Op {
        C14174Op child;

        public ChildOp(int i) {
            super(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public C14174Op getChild() {
            return this.child;
        }

        public void setChild(C14174Op c14174Op) {
            this.child = c14174Op;
        }
    }

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op$ConditionOp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ConditionOp extends C14174Op {
        C14174Op condition;

        /* JADX INFO: renamed from: no */
        C14174Op f10172no;
        int refNumber;
        C14174Op yes;

        public ConditionOp(int i, int i2, C14174Op c14174Op, C14174Op c14174Op2, C14174Op c14174Op3) {
            super(i);
            this.refNumber = i2;
            this.condition = c14174Op;
            this.yes = c14174Op2;
            this.f10172no = c14174Op3;
        }
    }

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op$ModifierOp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ModifierOp extends ChildOp {

        /* JADX INFO: renamed from: v1 */
        int f10173v1;

        /* JADX INFO: renamed from: v2 */
        int f10174v2;

        public ModifierOp(int i, int i2, int i4) {
            super(i);
            this.f10173v1 = i2;
            this.f10174v2 = i4;
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public int getData() {
            return this.f10173v1;
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public int getData2() {
            return this.f10174v2;
        }
    }

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op$RangeOp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RangeOp extends C14174Op {
        Token tok;

        public RangeOp(int i, Token token) {
            super(i);
            this.tok = token;
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public RangeToken getToken() {
            return (RangeToken) this.tok;
        }
    }

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op$StringOp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StringOp extends C14174Op {
        String string;

        public StringOp(int i, String str) {
            super(i);
            this.string = str;
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public String getString() {
            return this.string;
        }
    }

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.regex.Op$UnionOp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnionOp extends C14174Op {
        Vector branches;

        public UnionOp(int i, int i2) {
            super(i);
            this.branches = new Vector(i2);
        }

        public void addElement(C14174Op c14174Op) {
            this.branches.addElement(c14174Op);
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public C14174Op elementAt(int i) {
            return (C14174Op) this.branches.elementAt(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.C14174Op
        public int size() {
            return this.branches.size();
        }
    }

    public C14174Op(int i) {
        this.type = i;
    }

    public static CharOp createAnchor(int i) {
        return new CharOp(5, i);
    }

    public static CharOp createBackReference(int i) {
        return new CharOp(16, i);
    }

    public static CharOp createCapture(int i, C14174Op c14174Op) {
        CharOp charOp = new CharOp(15, i);
        charOp.next = c14174Op;
        return charOp;
    }

    public static CharOp createChar(int i) {
        return new CharOp(1, i);
    }

    public static ChildOp createClosure(int i) {
        return new ModifierOp(7, i, -1);
    }

    public static ConditionOp createCondition(C14174Op c14174Op, int i, C14174Op c14174Op2, C14174Op c14174Op3, C14174Op c14174Op4) {
        ConditionOp conditionOp = new ConditionOp(26, i, c14174Op2, c14174Op3, c14174Op4);
        conditionOp.next = c14174Op;
        return conditionOp;
    }

    public static C14174Op createDot() {
        return new C14174Op(0);
    }

    public static ChildOp createIndependent(C14174Op c14174Op, C14174Op c14174Op2) {
        ChildOp childOp = new ChildOp(24);
        childOp.setChild(c14174Op2);
        childOp.next = c14174Op;
        return childOp;
    }

    public static ChildOp createLook(int i, C14174Op c14174Op, C14174Op c14174Op2) {
        ChildOp childOp = new ChildOp(i);
        childOp.setChild(c14174Op2);
        childOp.next = c14174Op;
        return childOp;
    }

    public static ModifierOp createModifier(C14174Op c14174Op, C14174Op c14174Op2, int i, int i2) {
        ModifierOp modifierOp = new ModifierOp(25, i, i2);
        modifierOp.setChild(c14174Op2);
        modifierOp.next = c14174Op;
        return modifierOp;
    }

    public static ChildOp createNonGreedyClosure() {
        return new ChildOp(8);
    }

    public static ChildOp createQuestion(boolean z) {
        return new ChildOp(z ? 10 : 9);
    }

    public static RangeOp createRange(Token token) {
        return new RangeOp(3, token);
    }

    public static StringOp createString(String str) {
        return new StringOp(6, str);
    }

    public static UnionOp createUnion(int i) {
        return new UnionOp(11, i);
    }

    public C14174Op elementAt(int i) {
        StringBuffer stringBuffer = new StringBuffer("Internal Error: type=");
        stringBuffer.append(this.type);
        throw new RuntimeException(stringBuffer.toString());
    }

    public C14174Op getChild() {
        StringBuffer stringBuffer = new StringBuffer("Internal Error: type=");
        stringBuffer.append(this.type);
        throw new RuntimeException(stringBuffer.toString());
    }

    public int getData() {
        StringBuffer stringBuffer = new StringBuffer("Internal Error: type=");
        stringBuffer.append(this.type);
        throw new RuntimeException(stringBuffer.toString());
    }

    public int getData2() {
        StringBuffer stringBuffer = new StringBuffer("Internal Error: type=");
        stringBuffer.append(this.type);
        throw new RuntimeException(stringBuffer.toString());
    }

    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("Internal Error: type=");
        stringBuffer.append(this.type);
        throw new RuntimeException(stringBuffer.toString());
    }

    public RangeToken getToken() {
        StringBuffer stringBuffer = new StringBuffer("Internal Error: type=");
        stringBuffer.append(this.type);
        throw new RuntimeException(stringBuffer.toString());
    }

    public int size() {
        return 0;
    }
}
