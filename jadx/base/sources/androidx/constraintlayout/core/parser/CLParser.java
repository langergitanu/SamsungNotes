package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class CLParser {
    static boolean DEBUG = false;
    private boolean hasComment = false;
    private int lineNumber;
    private String mContent;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLParser$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C22971 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = iArr;
            try {
                iArr[TYPE.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i, TYPE type, boolean z, char[] cArr) {
        CLElement cLElementAllocate;
        if (DEBUG) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (C22971.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[type.ordinal()]) {
            case 1:
                cLElementAllocate = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                cLElementAllocate = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                cLElementAllocate = CLString.allocate(cArr);
                break;
            case 4:
                cLElementAllocate = CLNumber.allocate(cArr);
                break;
            case 5:
                cLElementAllocate = CLKey.allocate(cArr);
                break;
            case 6:
                cLElementAllocate = CLToken.allocate(cArr);
                break;
            default:
                cLElementAllocate = null;
                break;
        }
        if (cLElementAllocate == null) {
            return null;
        }
        cLElementAllocate.setLine(this.lineNumber);
        if (z) {
            cLElementAllocate.setStart(i);
        }
        if (cLElement instanceof CLContainer) {
            cLElementAllocate.setContainer((CLContainer) cLElement);
        }
        return cLElementAllocate;
    }

    private CLElement getNextJsonElement(int i, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
            if (c == '\"' || c == '\'') {
                return cLElement instanceof CLObject ? createElement(cLElement, i, TYPE.KEY, true, cArr) : createElement(cLElement, i, TYPE.STRING, true, cArr);
            }
            if (c == '[') {
                return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
            }
            if (c != ']') {
                if (c == '{') {
                    return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
                }
                if (c != '}') {
                    switch (c) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return createElement(cLElement, i, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            break;
                        case '/':
                            int i2 = i + 1;
                            if (i2 >= cArr.length || cArr[i2] != '/') {
                                return cLElement;
                            }
                            this.hasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i, TYPE.KEY, true, cArr);
                            }
                            CLElement cLElementCreateElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) cLElementCreateElement;
                            if (cLToken.validate(c, i)) {
                                return cLElementCreateElement;
                            }
                            throw new CLParsingException("incorrect token <" + c + "> at line " + this.lineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd(i - 1);
            CLElement container = cLElement.getContainer();
            container.setEnd(i);
            return container;
        }
        return cLElement;
    }

    public static CLObject parse(String str) {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        int i;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i2 = 1;
        this.lineNumber = 1;
        boolean z = false;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            }
            char c = charArray[i4];
            if (c == '{') {
                break;
            }
            if (c == '\n') {
                this.lineNumber++;
            }
            i4++;
        }
        if (i4 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectAllocate = CLObject.allocate(charArray);
        cLObjectAllocate.setLine(this.lineNumber);
        cLObjectAllocate.setStart(i4);
        int i5 = i4 + 1;
        CLElement container = cLObjectAllocate;
        while (i5 < length) {
            char c2 = charArray[i5];
            if (c2 == '\n') {
                this.lineNumber += i2;
            }
            if (this.hasComment) {
                if (c2 == '\n') {
                    this.hasComment = z;
                } else {
                    i = i2;
                    i5++;
                    i2 = i;
                    z = false;
                }
            }
            if (container == null) {
                break;
            }
            if (container.isDone()) {
                container = getNextJsonElement(i5, c2, container, charArray);
            } else if (container instanceof CLObject) {
                if (c2 == '}') {
                    container.setEnd(i5 - 1);
                } else {
                    container = getNextJsonElement(i5, c2, container, charArray);
                }
            } else if (!(container instanceof CLArray)) {
                boolean z2 = container instanceof CLString;
                if (z2) {
                    long j = container.start;
                    if (charArray[(int) j] == c2) {
                        container.setStart(j + 1);
                        container.setEnd(i5 - 1);
                    }
                } else {
                    if (container instanceof CLToken) {
                        CLToken cLToken = (CLToken) container;
                        i = i2;
                        if (!cLToken.validate(c2, i5)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                        }
                    } else {
                        i = i2;
                    }
                    if ((container instanceof CLKey) || z2) {
                        long j2 = container.start;
                        char c4 = charArray[(int) j2];
                        if ((c4 == '\'' || c4 == '\"') && c4 == c2) {
                            container.setStart(j2 + 1);
                            container.setEnd(i5 - 1);
                        }
                    }
                    if (!container.isDone() && (c2 == '}' || c2 == ']' || c2 == ',' || c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n' || c2 == ':')) {
                        long j3 = i5 - 1;
                        container.setEnd(j3);
                        if (c2 == '}' || c2 == ']') {
                            container = container.getContainer();
                            container.setEnd(j3);
                            if (container instanceof CLKey) {
                                container = container.getContainer();
                                container.setEnd(j3);
                            }
                        }
                    }
                    if (!container.isDone() && (!(container instanceof CLKey) || ((CLKey) container).mElements.size() > 0)) {
                        container = container.getContainer();
                    }
                    i5++;
                    i2 = i;
                    z = false;
                }
            } else if (c2 == ']') {
                container.setEnd(i5 - 1);
            } else {
                container = getNextJsonElement(i5, c2, container, charArray);
            }
            i = i2;
            if (!container.isDone()) {
            }
            i5++;
            i2 = i;
            z = false;
        }
        while (container != null && !container.isDone()) {
            if (container instanceof CLString) {
                container.setStart(((int) container.start) + 1);
            }
            container.setEnd(length - 1);
            container = container.getContainer();
        }
        if (DEBUG) {
            System.out.println("Root: " + cLObjectAllocate.toJSON());
        }
        return cLObjectAllocate;
    }
}
