package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.sec.android.diagmonagent.dma.aperf.utils.aPerfUtil;
import com.vladsch.flexmark.util.html.Attribute;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import kotlin.text.Typography;
import org.apache.commons.lang3.SystemProperties;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.ErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.LinkResolver;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleConstants;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathVariantMap;
import uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ArrayListStack;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.StringUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathFunctionInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathIdentifierInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathNumberInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathOperatorInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.BraceContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ErrorToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.SimpleToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.Token;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.CSSUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MessageFormatter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class DOMBuilder {
    private final Element buildRootElement;
    private final Document document;
    private final DOMOutputOptions options;
    private final SessionContext sessionContext;
    private final String lineSeparator = System.getProperty(SystemProperties.LINE_SEPARATOR);
    private final MathContentBuilderCallback defaultMathContentBuilderCallback = new MathContentBuilderCallback() { // from class: uk.ac.ed.ph.snuggletex.internal.DOMBuilder.1
        @Override // uk.ac.ed.ph.snuggletex.internal.DOMBuilder.MathContentBuilderCallback
        public void buildMathElementContent(Element element, ArgumentContainerToken argumentContainerToken, boolean z) {
            if (z) {
                DOMBuilder.this.handleMathTokensAsSingleElement(element, argumentContainerToken);
            } else {
                DOMBuilder.this.handleTokens(element, argumentContainerToken, false);
            }
        }
    };
    private final VariableManager variableManager = new VariableManager();
    private Properties currentInlineCSSProperties = null;
    private OutputContext currentOutputContext = null;
    private Element currentMathOwnerElement = null;
    private final ArrayListStack<MathVariantMap> mathVariantMapStack = new ArrayListStack<>();
    private final ArrayListStack<ComputedStyle> textStyleStack = new ArrayListStack<>();

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.internal.DOMBuilder$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144892 {

        /* JADX INFO: renamed from: $SwitchMap$uk$ac$ed$ph$snuggletex$DOMOutputOptions$ErrorOutputOptions */
        static final /* synthetic */ int[] f10297xa0832589;

        /* JADX INFO: renamed from: $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$MathCharacter$MathCharacterType */
        static final /* synthetic */ int[] f10298x2ba649df;
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType;

        static {
            int[] iArr = new int[DOMOutputOptions.ErrorOutputOptions.values().length];
            f10297xa0832589 = iArr;
            try {
                iArr[DOMOutputOptions.ErrorOutputOptions.NO_OUTPUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10297xa0832589[DOMOutputOptions.ErrorOutputOptions.XML_FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10297xa0832589[DOMOutputOptions.ErrorOutputOptions.XML_SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10297xa0832589[DOMOutputOptions.ErrorOutputOptions.XHTML.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MathCharacter.MathCharacterType.values().length];
            f10298x2ba649df = iArr2;
            try {
                iArr2[MathCharacter.MathCharacterType.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.ORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.BIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.OP.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.PUNCT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.REL.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.FENCE.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.OPEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.NUMERIC.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10298x2ba649df[MathCharacter.MathCharacterType.ACCENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[TokenType.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType = iArr3;
            try {
                iArr3[TokenType.COMMAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.ENVIRONMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.BRACE_CONTAINER.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.TEXT_MODE_TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.VERBATIM_MODE_TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.LR_MODE_NEW_PARAGRAPH.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.MATH_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.MATH_CHARACTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.TAB_CHARACTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused25) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MathContentBuilderCallback {
        void buildMathElementContent(Element element, ArgumentContainerToken argumentContainerToken, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum OutputContext {
        XHTML,
        MATHML_BLOCK,
        MATHML_INLINE
    }

    public DOMBuilder(SessionContext sessionContext, Element element, DOMOutputOptions dOMOutputOptions) {
        this.buildRootElement = element;
        this.document = element.getOwnerDocument();
        this.sessionContext = sessionContext;
        this.options = dOMOutputOptions;
    }

    private void buildStringValue(StringBuilder sb, NodeList nodeList) {
        int length = nodeList.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeItem = nodeList.item(i);
            if (nodeItem.getNodeType() == 3) {
                sb.append(nodeItem.getNodeValue());
            } else if (nodeItem.getNodeType() == 1) {
                buildStringValue(sb, nodeItem.getChildNodes());
            }
        }
    }

    private Properties getCurrentInlineCSSProperties() {
        if (this.currentInlineCSSProperties == null) {
            this.currentInlineCSSProperties = CSSUtilities.readInlineCSSProperties(this.options);
        }
        return this.currentInlineCSSProperties;
    }

    public Element appendErrorElement(Element element, ErrorToken errorToken) {
        DOMOutputOptions.ErrorOutputOptions errorOutputOptions = this.options.getErrorOutputOptions();
        int i = C144892.f10297xa0832589[errorOutputOptions.ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 4) {
                    throw new SnuggleLogicException("Unexpected switch case " + errorOutputOptions);
                }
                if (isBuildingMathMLIsland()) {
                    appendMathMLTextElement(appendMathMLElement(element, "merror"), "mtext", errorToken.getError().getErrorCode().toString(), false);
                }
                findNearestXHTMLAncestorOrSelf(element).appendChild(MessageFormatter.formatErrorAsXHTML(this.document, errorToken.getError()));
                return element;
            }
            element.appendChild(MessageFormatter.formatErrorAsXML(this.document, this.options, errorToken.getError(), errorOutputOptions == DOMOutputOptions.ErrorOutputOptions.XML_FULL));
        }
        return element;
    }

    public void appendMathCharacter(Element element, MathCharacter mathCharacter) {
        String str = new String(Character.toChars(mathCharacter.getCodePoint()));
        switch (C144892.f10298x2ba649df[mathCharacter.getType().ordinal()]) {
            case 1:
            case 2:
                appendMathMLIdentifierElement(element, str);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                appendMathMLOperatorElement(element, str);
                return;
            case 10:
                appendMathMLNumberElement(element, str);
                return;
            case 11:
                throw new SnuggleLogicException("No handling for ACCENT coded yet!");
            default:
                throw new SnuggleLogicException("Unexpected switch case " + mathCharacter.getType());
        }
    }

    public Element appendMathMLElement(Element element, String str) {
        if (this.options.isPrefixingMathML()) {
            str = this.options.getMathMLPrefix() + ":" + str;
        }
        Element elementCreateElementNS = this.document.createElementNS("http://www.w3.org/1998/Math/MathML", str);
        element.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }

    public Element appendMathMLIdentifierElement(Element element, String str) {
        String mathVariantName;
        char accentedChar;
        if (str.length() != 1 || this.mathVariantMapStack.isEmpty()) {
            mathVariantName = null;
        } else {
            MathVariantMap mathVariantMapPeek = this.mathVariantMapStack.peek();
            mathVariantName = mathVariantMapPeek.getMathVariantName();
            if (this.options.isMathVariantMapping() && (accentedChar = mathVariantMapPeek.getAccentedChar(str.charAt(0))) != 0) {
                str = Character.toString(accentedChar);
            }
        }
        Element elementAppendMathMLTextElement = appendMathMLTextElement(element, "mi", str, true);
        if (mathVariantName != null) {
            elementAppendMathMLTextElement.setAttribute("mathvariant", mathVariantName);
        }
        return elementAppendMathMLTextElement;
    }

    public Element appendMathMLNumberElement(Element element, String str) {
        return appendMathMLTextElement(element, "mn", str, true);
    }

    public Element appendMathMLOperatorElement(Element element, String str) {
        return appendMathMLTextElement(element, "mo", str, true);
    }

    public Element appendMathMLSpace(Element element, String str) {
        Element elementAppendMathMLElement = appendMathMLElement(element, "mspace");
        elementAppendMathMLElement.setAttribute("width", str);
        return elementAppendMathMLElement;
    }

    public Element appendMathMLTextElement(Element element, String str, String str2, boolean z) {
        Element elementAppendMathMLElement = appendMathMLElement(element, str);
        appendTextNode(elementAppendMathMLElement, str2, z);
        return elementAppendMathMLElement;
    }

    public Element appendOrThrowError(Element element, Token token, ErrorCode errorCode, Object... objArr) {
        InputError inputError = new InputError(errorCode, token.getSlice(), objArr);
        this.sessionContext.registerError(inputError);
        return appendErrorElement(element, new ErrorToken(inputError, token.getLatexMode()));
    }

    public void appendSimpleMathElement(Element element, Token token) {
        EnumMap<InterpretationType, Interpretation> interpretationMap = token.getInterpretationMap();
        if (interpretationMap.containsKey(InterpretationType.MATH_CHARACTER)) {
            appendMathCharacter(element, token.getMathCharacter());
            return;
        }
        InterpretationType interpretationType = InterpretationType.MATH_IDENTIFIER;
        if (interpretationMap.containsKey(interpretationType)) {
            appendMathMLIdentifierElement(element, ((MathIdentifierInterpretation) interpretationMap.get(interpretationType)).getName());
            return;
        }
        InterpretationType interpretationType2 = InterpretationType.MATH_NUMBER;
        if (interpretationMap.containsKey(interpretationType2)) {
            appendMathMLNumberElement(element, ((MathNumberInterpretation) interpretationMap.get(interpretationType2)).getNumber().toString());
            return;
        }
        InterpretationType interpretationType3 = InterpretationType.MATH_OPERATOR;
        if (interpretationMap.containsKey(interpretationType3)) {
            appendMathMLOperatorElement(element, ((MathOperatorInterpretation) interpretationMap.get(interpretationType3)).getMathMLOperatorContent());
            return;
        }
        InterpretationType interpretationType4 = InterpretationType.MATH_FUNCTION;
        if (interpretationMap.containsKey(interpretationType4)) {
            appendMathMLIdentifierElement(element, ((MathFunctionInterpretation) interpretationMap.get(interpretationType4)).getName());
        } else {
            throw new SnuggleLogicException("Unexpected logic branch based on InterpretationMap, which was: " + interpretationMap);
        }
    }

    public Element appendSnuggleElement(Element element, String str) {
        if (this.options.isPrefixingSnuggleXML()) {
            str = this.options.getSnuggleXMLPrefix() + ":" + str;
        }
        Element elementCreateElementNS = this.document.createElementNS(SnuggleConstants.SNUGGLETEX_NAMESPACE, str);
        element.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }

    public Node appendTextNode(Element element, String str, boolean z) {
        if (z) {
            str = str.trim();
        }
        String strReplace = str.replace(this.lineSeparator, "\n");
        Node lastChild = element.getLastChild();
        if (lastChild == null || lastChild.getNodeType() != 3) {
            Text textCreateTextNode = this.document.createTextNode(strReplace);
            element.appendChild(textCreateTextNode);
            return textCreateTextNode;
        }
        lastChild.setNodeValue(lastChild.getNodeValue() + strReplace);
        return lastChild;
    }

    public Element appendXHTMLElement(Element element, String str) {
        if (this.options.isPrefixingXHTML()) {
            str = this.options.getXHTMLPrefix() + ":" + str;
        }
        Element elementCreateElementNS = this.document.createElementNS("http://www.w3.org/1999/xhtml", str);
        element.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }

    public Element appendXHTMLTextElement(Element element, String str, String str2, boolean z) {
        Element elementAppendXHTMLElement = appendXHTMLElement(element, str);
        appendTextNode(elementAppendXHTMLElement, str2, z);
        return elementAppendXHTMLElement;
    }

    public void applyCSSStyle(Element element, String... strArr) {
        if (!this.options.isInliningCSS()) {
            element.setAttribute(Attribute.CLASS_ATTR, StringUtilities.join(strArr, " "));
            return;
        }
        Properties currentInlineCSSProperties = getCurrentInlineCSSProperties();
        StringBuilder sb = new StringBuilder();
        boolean zEndsWith = false;
        for (String str : strArr) {
            String property = currentInlineCSSProperties.getProperty(element.getLocalName() + Extension.DOT + str);
            if (property == null) {
                property = currentInlineCSSProperties.getProperty(Extension.DOT + str);
            }
            if (zEndsWith) {
                sb.append("; ");
            }
            String strTrim = property.trim();
            sb.append(strTrim);
            zEndsWith = strTrim.endsWith(";");
        }
        if (sb.length() > 0) {
            element.setAttribute("style", sb.toString());
        }
    }

    public void buildDOMSubtree(List<FlowToken> list) {
        this.mathVariantMapStack.clear();
        this.textStyleStack.clear();
        this.currentOutputContext = OutputContext.XHTML;
        this.textStyleStack.push(ComputedStyle.DEFAULT_STYLE);
        handleTokens(this.buildRootElement, list, true);
        this.textStyleStack.pop();
        this.currentOutputContext = null;
        if (!this.mathVariantMapStack.isEmpty()) {
            throw new SnuggleLogicException("mathVariantMapStack was non-empty at end of DOM building process");
        }
        if (!this.textStyleStack.isEmpty()) {
            throw new SnuggleLogicException("textStyleStack was non-empty at end of DOM building process");
        }
    }

    public void buildMathElement(Element element, Token token, ArgumentContainerToken argumentContainerToken, boolean z) {
        buildMathElement(element, token, argumentContainerToken, z, this.defaultMathContentBuilderCallback);
    }

    public ComputedStyle closeStyle() {
        return this.textStyleStack.pop();
    }

    public NodeList extractNodeListValue(ArgumentContainerToken argumentContainerToken) {
        Element elementCreateElement = this.document.createElement(aPerfUtil.DUMMY_SUB_OP_NAME);
        handleTokens(elementCreateElement, argumentContainerToken, true);
        return elementCreateElement.getChildNodes();
    }

    public String extractStringValue(ArgumentContainerToken argumentContainerToken) {
        StringBuilder sb = new StringBuilder();
        buildStringValue(sb, extractNodeListValue(argumentContainerToken));
        return sb.toString();
    }

    public Element findNearestXHTMLAncestorOrSelf(Element element) {
        return this.currentOutputContext == OutputContext.XHTML ? element : this.currentMathOwnerElement;
    }

    public Document getDocument() {
        return this.document;
    }

    public ArrayListStack<MathVariantMap> getMathVariantMapStack() {
        return this.mathVariantMapStack;
    }

    public DOMOutputOptions getOptions() {
        return this.options;
    }

    public OutputContext getOutputContext() {
        return this.currentOutputContext;
    }

    public SessionContext getSessionContext() {
        return this.sessionContext;
    }

    public VariableManager getVariableManager() {
        return this.variableManager;
    }

    public void handleMathTokensAsSingleElement(Element element, ArgumentContainerToken argumentContainerToken) {
        handleMathTokensAsSingleElement(element, argumentContainerToken.getContents());
    }

    public void handleTextToken(Element element, SimpleToken simpleToken) {
        int i;
        CharSequence charSequenceExtract = simpleToken.getSlice().extract();
        StringBuilder sb = new StringBuilder();
        int length = charSequenceExtract.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequenceExtract.charAt(i2);
            if (cCharAt == '\'') {
                i = i2 + 1;
                if (i >= length || charSequenceExtract.charAt(i) != '\'') {
                    sb.append(Typography.rightSingleQuote);
                } else {
                    sb.append(Typography.rightDoubleQuote);
                    i2 = i;
                }
            } else if (cCharAt == '-') {
                i = i2 + 1;
                if (i >= length || charSequenceExtract.charAt(i) != '-') {
                    sb.append('-');
                } else {
                    i2 += 2;
                    if (i2 >= length || charSequenceExtract.charAt(i2) != '-') {
                        sb.append(Typography.ndash);
                        i2 = i;
                    } else {
                        sb.append(Typography.mdash);
                    }
                }
            } else if (cCharAt == '<') {
                sb.append((char) 161);
            } else if (cCharAt == '>') {
                sb.append((char) 191);
            } else if (cCharAt == '`') {
                i = i2 + 1;
                if (i >= length || charSequenceExtract.charAt(i) != '`') {
                    sb.append(Typography.leftSingleQuote);
                } else {
                    sb.append(Typography.leftDoubleQuote);
                    i2 = i;
                }
            } else if (cCharAt == '|') {
                sb.append(Typography.mdash);
            } else if (cCharAt != '~') {
                sb.append(cCharAt);
            } else {
                sb.append((char) 160);
            }
            i2++;
        }
        String string = sb.toString();
        if (!isBuildingMathMLIsland()) {
            appendTextNode(element, string, false);
            return;
        }
        String strTrim = string.trim();
        if (strTrim.length() == 0) {
            appendMathMLSpace(element, "1ex");
            return;
        }
        if (Character.isWhitespace(string.charAt(0))) {
            appendMathMLSpace(element, "1ex");
        }
        appendMathMLTextElement(element, "mtext", strTrim, false);
        if (Character.isWhitespace(string.charAt(string.length() - 1))) {
            appendMathMLSpace(element, "1ex");
        }
    }

    public void handleToken(Element element, FlowToken flowToken) {
        switch (C144892.$SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[flowToken.getType().ordinal()]) {
            case 1:
                CommandToken commandToken = (CommandToken) flowToken;
                CommandHandler dOMBuildingHandler = commandToken.getCommand().getDOMBuildingHandler();
                if (dOMBuildingHandler != null) {
                    dOMBuildingHandler.handleCommand(this, element, commandToken);
                    return;
                } else {
                    throw new SnuggleLogicException("No builder registered for Command " + commandToken.getCommand());
                }
            case 2:
                EnvironmentToken environmentToken = (EnvironmentToken) flowToken;
                EnvironmentHandler dOMBuildingHandler2 = environmentToken.getEnvironment().getDOMBuildingHandler();
                if (dOMBuildingHandler2 != null) {
                    dOMBuildingHandler2.handleEnvironment(this, element, environmentToken);
                    return;
                } else {
                    throw new SnuggleLogicException("No builder registered for Environment " + environmentToken.getEnvironment());
                }
            case 3:
                BraceContainerToken braceContainerToken = (BraceContainerToken) flowToken;
                if (!isBuildingMathMLIsland()) {
                    throw new SnuggleLogicException("BraceContainerTokens should not be present outside Math islands");
                }
                handleTokens(appendMathMLElement(element, "mrow"), braceContainerToken.getContents(), true);
                return;
            case 4:
                appendErrorElement(element, (ErrorToken) flowToken);
                return;
            case 5:
                handleTextToken(element, (SimpleToken) flowToken);
                return;
            case 6:
                appendTextNode(element, flowToken.getSlice().extract().toString(), false);
                return;
            case 7:
                if (isBuildingMathMLIsland()) {
                    appendMathMLSpace(element, "1ex");
                    return;
                } else {
                    appendTextNode(element, " ", false);
                    return;
                }
            case 8:
            case 9:
                if (isBuildingMathMLIsland()) {
                    appendSimpleMathElement(element, flowToken);
                    return;
                } else {
                    throw new SnuggleLogicException("Math Mode token found but outputContext is currently " + this.currentOutputContext);
                }
            case 10:
                appendOrThrowError(element, flowToken, CoreErrorCode.TDEG00, new Object[0]);
                return;
            default:
                throw new SnuggleLogicException("Unhandled switch case " + flowToken.getType());
        }
    }

    public void handleTokens(Element element, ArgumentContainerToken argumentContainerToken, boolean z) {
        handleTokens(element, argumentContainerToken.getContents(), z);
    }

    public boolean isBuildingMathMLIsland() {
        OutputContext outputContext = getOutputContext();
        return outputContext == OutputContext.MATHML_BLOCK || outputContext == OutputContext.MATHML_INLINE;
    }

    public boolean isParentElement(Element element, String str, String... strArr) {
        if (!str.equals(element.getNamespaceURI())) {
            return false;
        }
        if (strArr.length == 0) {
            return true;
        }
        String localName = element.getLocalName();
        for (String str2 : strArr) {
            if (localName.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public Element openStyle(Element element, ComputedStyle computedStyle, boolean z, boolean z2) {
        if (isBuildingMathMLIsland()) {
            String targetMathMLMathVariantName = computedStyle.getFontFamily().getTargetMathMLMathVariantName();
            if (targetMathMLMathVariantName == null || z2) {
                element = appendMathMLElement(element, "mrow");
            } else {
                element = appendMathMLElement(element, "mstyle");
                element.setAttribute("mathvariant", targetMathMLMathVariantName);
            }
        } else {
            ComputedStyle computedStylePeek = this.textStyleStack.peek();
            ComputedStyle.FontSize fontSize = computedStyle.getFontSize();
            if (fontSize != computedStylePeek.getFontSize()) {
                element = appendXHTMLElement(element, z ? "div" : "span");
                applyCSSStyle(element, fontSize.getTargetCSSClassName());
            }
            ComputedStyle.FontFamily fontFamily = computedStyle.getFontFamily();
            if (fontFamily != computedStylePeek.getFontFamily()) {
                String targetBlockXHTMLElementName = z ? fontFamily.getTargetBlockXHTMLElementName() : fontFamily.getTargetInlineXHTMLElementName();
                String targetBlockCSSClassName = z ? fontFamily.getTargetBlockCSSClassName() : fontFamily.getTargetInlineCSSClassName();
                element = appendXHTMLElement(element, targetBlockXHTMLElementName);
                if (targetBlockCSSClassName != null) {
                    applyCSSStyle(element, targetBlockCSSClassName);
                }
            }
        }
        this.textStyleStack.push(computedStyle);
        return element;
    }

    public URI resolveLink(Element element, Token token, String str) {
        URI uriValidateURI = validateURI(element, token, str);
        if (uriValidateURI == null) {
            return null;
        }
        LinkResolver linkResolver = this.options.getLinkResolver();
        return linkResolver != null ? linkResolver.mapLink(uriValidateURI, token.getSlice().getDocument().getInput().getURI()) : uriValidateURI;
    }

    public void setOutputContext(Element element, OutputContext outputContext) {
        this.currentOutputContext = outputContext;
        if (outputContext == OutputContext.MATHML_BLOCK || outputContext == OutputContext.MATHML_INLINE) {
            this.currentMathOwnerElement = element;
        }
    }

    public URI validateURI(Element element, Token token, String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            appendOrThrowError(element, token, CoreErrorCode.TDEX04, str);
            return null;
        }
    }

    public String validateXMLId(Element element, Token token, String str) {
        String strValidateXMLName = validateXMLName(element, token, str);
        if (strValidateXMLName == null || this.document.getElementById(strValidateXMLName) == null) {
            return strValidateXMLName;
        }
        appendOrThrowError(element, token, CoreErrorCode.TDEX05, str);
        return null;
    }

    public String validateXMLName(Element element, Token token, String str) {
        if (XMLUtilities.isXMLName(str)) {
            return str;
        }
        appendOrThrowError(element, token, CoreErrorCode.TDEX03, str);
        return null;
    }

    public void buildMathElement(Element element, Token token, ArgumentContainerToken argumentContainerToken, boolean z, MathContentBuilderCallback mathContentBuilderCallback) {
        Element elementAppendMathMLElement;
        setOutputContext(element, z ? OutputContext.MATHML_BLOCK : OutputContext.MATHML_INLINE);
        Element elementAppendMathMLElement2 = appendMathMLElement(element, "math");
        if (z) {
            elementAppendMathMLElement2.setAttribute("display", "block");
        }
        if (this.options.isAddingMathSourceAnnotations()) {
            Element elementAppendMathMLElement3 = appendMathMLElement(elementAppendMathMLElement2, "semantics");
            if (this.options.isApplyingFirefox3SemanticsWorkaround() && z) {
                elementAppendMathMLElement = appendMathMLElement(elementAppendMathMLElement3, "mstyle");
                elementAppendMathMLElement.setAttribute("displaystyle", "true");
            } else {
                elementAppendMathMLElement = elementAppendMathMLElement3;
            }
            mathContentBuilderCallback.buildMathElementContent(elementAppendMathMLElement, argumentContainerToken, true);
            appendMathMLTextElement(elementAppendMathMLElement3, MathMLUtilities.ANNOTATION_LOCAL_NAME, token.getSlice().extract().toString(), true).setAttribute(XMLWriter.ENCODING, "SnuggleTeX");
        } else {
            mathContentBuilderCallback.buildMathElementContent(elementAppendMathMLElement2, argumentContainerToken, false);
        }
        setOutputContext(element, OutputContext.XHTML);
    }

    public void handleMathTokensAsSingleElement(Element element, List<FlowToken> list) {
        Element elementAppendMathMLElement = appendMathMLElement(element, "mrow");
        handleTokens(elementAppendMathMLElement, list, true);
        NodeList childNodes = elementAppendMathMLElement.getChildNodes();
        if (childNodes.getLength() == 1) {
            Node nodeItem = childNodes.item(0);
            element.removeChild(elementAppendMathMLElement);
            element.appendChild(nodeItem);
        }
    }

    public void handleTokens(Element element, List<FlowToken> list, boolean z) {
        NodeList childNodes;
        int length;
        int length2;
        int length3 = element.getChildNodes().getLength();
        Iterator<FlowToken> it = list.iterator();
        while (it.hasNext()) {
            handleToken(element, it.next());
        }
        if (!z || (length2 = (length = (childNodes = element.getChildNodes()).getLength()) - length3) <= 0) {
            return;
        }
        int i = length - length2;
        int i2 = length - 1;
        Node nodeItem = childNodes.item(i);
        if (nodeItem.getNodeType() == 3) {
            nodeItem.setNodeValue(nodeItem.getNodeValue().replaceFirst("^\\s+", ""));
        }
        Node nodeItem2 = childNodes.item(i2);
        if (nodeItem2.getNodeType() == 3) {
            nodeItem2.setNodeValue(nodeItem2.getNodeValue().replaceFirst("\\s+$", ""));
        }
    }
}
