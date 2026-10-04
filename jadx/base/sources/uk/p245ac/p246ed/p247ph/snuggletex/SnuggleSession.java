package uk.p245ac.p246ed.p247ph.snuggletex;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuildingController;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.LaTeXTokeniser;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.SnuggleInputReader;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.SnuggleParseException;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.StyleEvaluator;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.StyleRebuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.TokenFixer;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.WebPageBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.RootToken;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.SerializationOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnuggleSession implements SessionContext {
    private final SessionConfiguration configuration;
    final DOMOutputOptions defaultDOMOutputOptions;
    final XMLStringOutputOptions defaultXMLStringOutputOptions;
    private final SnuggleEngine engine;
    private final List<InputError> errors;
    private final SnugglePackage[] packages;
    private final List<FlowToken> parsedTokens;
    private final StyleEvaluator styleEvaluator;
    private final StyleRebuilder styleRebuilder;
    private final TokenFixer tokenFixer;
    private final LaTeXTokeniser tokeniser;
    private final Map<String, UserDefinedCommand> userCommandMap;
    private final Map<String, UserDefinedEnvironment> userEnvironmentMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum EndOutputAction {
        CLOSE,
        FLUSH,
        DO_NOTHING
    }

    public SnuggleSession(SnuggleEngine snuggleEngine, SessionConfiguration sessionConfiguration) {
        this.engine = snuggleEngine;
        this.packages = (SnugglePackage[]) snuggleEngine.getPackages().toArray(new SnugglePackage[snuggleEngine.getPackages().size()]);
        this.configuration = (SessionConfiguration) sessionConfiguration.clone();
        this.defaultDOMOutputOptions = (DOMOutputOptions) snuggleEngine.getDefaultDOMOutputOptions().clone();
        this.defaultXMLStringOutputOptions = (XMLStringOutputOptions) snuggleEngine.getDefaultXMLStringOutputOptions().clone();
        this.tokeniser = new LaTeXTokeniser(this);
        this.styleEvaluator = new StyleEvaluator(this);
        this.tokenFixer = new TokenFixer(this);
        this.styleRebuilder = new StyleRebuilder(this);
        this.errors = new ArrayList();
        this.userCommandMap = new HashMap();
        this.userEnvironmentMap = new HashMap();
        this.parsedTokens = new ArrayList();
    }

    public boolean buildDOMSubtree(Element element, DOMOutputOptions dOMOutputOptions) {
        ConstraintUtilities.ensureNotNull(element, "targetRoot");
        ConstraintUtilities.ensureNotNull(dOMOutputOptions, "options");
        try {
            new DOMBuildingController(this, dOMOutputOptions).buildDOMSubtree(element, this.parsedTokens);
            return true;
        } catch (SnuggleParseException unused) {
            return false;
        }
    }

    public Document buildWebPage(WebPageOutputOptions webPageOutputOptions) {
        ConstraintUtilities.ensureNotNull(webPageOutputOptions, "options");
        try {
            return new WebPageBuilder(this, webPageOutputOptions).buildWebPage(this.parsedTokens);
        } catch (SnuggleParseException unused) {
            return null;
        }
    }

    public String buildWebPageString(WebPageOutputOptions webPageOutputOptions) {
        ConstraintUtilities.ensureNotNull(webPageOutputOptions, "options");
        try {
            return new WebPageBuilder(this, webPageOutputOptions).buildWebPageString(this.parsedTokens);
        } catch (SnuggleParseException unused) {
            return null;
        }
    }

    public String buildXMLString() {
        return buildXMLString(this.defaultXMLStringOutputOptions);
    }

    public SnuggleSnapshot createSnapshot() {
        return new SnuggleSnapshot(this.engine, this.packages, (SessionConfiguration) this.configuration.clone(), (DOMOutputOptions) this.defaultDOMOutputOptions.clone(), (XMLStringOutputOptions) this.defaultXMLStringOutputOptions.clone(), new ArrayList(this.errors), new HashMap(this.userCommandMap), new HashMap(this.userEnvironmentMap), new ArrayList(this.parsedTokens));
    }

    @Deprecated
    public Document createWebPage(WebPageOutputOptions webPageOutputOptions) {
        return buildWebPage(webPageOutputOptions);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public BuiltinCommand getBuiltinCommandByTeXName(String str) {
        ConstraintUtilities.ensureNotNull(str, "texName");
        BuiltinCommand builtinCommandByTeXName = null;
        for (SnugglePackage snugglePackage : this.packages) {
            builtinCommandByTeXName = snugglePackage.getBuiltinCommandByTeXName(str);
            if (builtinCommandByTeXName != null) {
                return builtinCommandByTeXName;
            }
        }
        return builtinCommandByTeXName;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public BuiltinEnvironment getBuiltinEnvironmentByTeXName(String str) {
        ConstraintUtilities.ensureNotNull(str, "texName");
        BuiltinEnvironment builtinEnvironmentByTeXName = null;
        for (SnugglePackage snugglePackage : this.packages) {
            builtinEnvironmentByTeXName = snugglePackage.getBuiltinEnvironmentByTeXName(str);
            if (builtinEnvironmentByTeXName != null) {
                return builtinEnvironmentByTeXName;
            }
        }
        return builtinEnvironmentByTeXName;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public SessionConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public List<InputError> getErrors() {
        return this.errors;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public MathCharacter getMathCharacter(int i) {
        MathCharacter mathCharacter = null;
        for (SnugglePackage snugglePackage : this.packages) {
            mathCharacter = snugglePackage.getMathCharacter(i);
            if (mathCharacter != null) {
                return mathCharacter;
            }
        }
        return mathCharacter;
    }

    public List<FlowToken> getParsedTokens() {
        return this.parsedTokens;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public StylesheetManager getStylesheetManager() {
        return this.engine.getStylesheetManager();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public Map<String, UserDefinedCommand> getUserCommandMap() {
        return this.userCommandMap;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public Map<String, UserDefinedEnvironment> getUserEnvironmentMap() {
        return this.userEnvironmentMap;
    }

    public boolean parseInput(SnuggleInput snuggleInput) {
        ConstraintUtilities.ensureNotNull(snuggleInput, "snuggleInput");
        try {
            RootToken rootToken = this.tokeniser.tokenise(new SnuggleInputReader(this, snuggleInput));
            this.styleEvaluator.evaluateStyles(rootToken);
            this.tokenFixer.fixTokenTree(rootToken);
            this.styleRebuilder.rebuildStyles(rootToken);
            this.parsedTokens.addAll(rootToken.getContents());
            return true;
        } catch (SnuggleParseException unused) {
            return false;
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.internal.SessionContext
    public void registerError(InputError inputError) throws SnuggleParseException {
        ConstraintUtilities.ensureNotNull(inputError, "InputError");
        this.errors.add(inputError);
        if (this.configuration.isFailingFast()) {
            throw new SnuggleParseException(inputError);
        }
    }

    public void reset() {
        this.errors.clear();
        this.userCommandMap.clear();
        this.userEnvironmentMap.clear();
        this.parsedTokens.clear();
        this.tokeniser.reset();
    }

    public void setWebPageContentType(WebPageOutputOptions webPageOutputOptions, Object obj) {
        ConstraintUtilities.ensureNotNull(webPageOutputOptions, "options");
        ConstraintUtilities.ensureNotNull(obj, "contentTypeSettable");
        new WebPageBuilder(this, webPageOutputOptions).setWebPageContentType(obj);
    }

    public boolean writeWebPage(WebPageOutputOptions webPageOutputOptions, OutputStream outputStream) {
        return writeWebPage(webPageOutputOptions, null, outputStream, EndOutputAction.CLOSE);
    }

    public String buildXMLString(XMLStringOutputOptions xMLStringOutputOptions) {
        ConstraintUtilities.ensureNotNull(xMLStringOutputOptions, "XMLStringOutputOptions");
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        Element elementCreateElement = documentNewDocument.createElement("root");
        documentNewDocument.appendChild(elementCreateElement);
        if (buildDOMSubtree(elementCreateElement, xMLStringOutputOptions)) {
            return XMLUtilities.serializeNodeChildren(getStylesheetManager(), elementCreateElement, xMLStringOutputOptions);
        }
        return null;
    }

    public boolean writeWebPage(WebPageOutputOptions webPageOutputOptions, OutputStream outputStream, EndOutputAction endOutputAction) {
        return writeWebPage(webPageOutputOptions, null, outputStream, endOutputAction);
    }

    public boolean writeWebPage(WebPageOutputOptions webPageOutputOptions, Object obj, OutputStream outputStream) {
        return writeWebPage(webPageOutputOptions, obj, outputStream, EndOutputAction.CLOSE);
    }

    public boolean buildDOMSubtree(Element element) {
        return buildDOMSubtree(element, this.defaultDOMOutputOptions);
    }

    public boolean writeWebPage(WebPageOutputOptions webPageOutputOptions, Object obj, OutputStream outputStream, EndOutputAction endOutputAction) {
        ConstraintUtilities.ensureNotNull(webPageOutputOptions, "options");
        ConstraintUtilities.ensureNotNull(outputStream, "outputStream");
        ConstraintUtilities.ensureNotNull(endOutputAction, "endOutputAction");
        try {
            new WebPageBuilder(this, webPageOutputOptions).writeWebPage(this.parsedTokens, obj, outputStream, endOutputAction);
            return true;
        } catch (SnuggleParseException unused) {
            return false;
        }
    }

    public NodeList buildDOMSubtree() {
        return buildDOMSubtree(this.defaultDOMOutputOptions);
    }

    public NodeList buildDOMSubtree(DOMOutputOptions dOMOutputOptions) {
        ConstraintUtilities.ensureNotNull(dOMOutputOptions, "DOMOutputOptions");
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        Element elementCreateElementNS = documentNewDocument.createElementNS(SnuggleConstants.SNUGGLETEX_NAMESPACE, "root");
        documentNewDocument.appendChild(elementCreateElementNS);
        if (buildDOMSubtree(elementCreateElementNS, dOMOutputOptions)) {
            return elementCreateElementNS.getChildNodes();
        }
        return null;
    }

    @Deprecated
    public String buildXMLString(boolean z) {
        return buildXMLString(this.defaultDOMOutputOptions, z);
    }

    @Deprecated
    public String buildXMLString(DOMOutputOptions dOMOutputOptions) {
        return buildXMLString(dOMOutputOptions, false);
    }

    @Deprecated
    public String buildXMLString(DOMOutputOptions dOMOutputOptions, boolean z) {
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        Element elementCreateElement = documentNewDocument.createElement("root");
        documentNewDocument.appendChild(elementCreateElement);
        if (!buildDOMSubtree(elementCreateElement, dOMOutputOptions)) {
            return null;
        }
        SerializationOptions serializationOptions = new SerializationOptions();
        serializationOptions.setEncoding("UTF-8");
        serializationOptions.setIndenting(z);
        return XMLUtilities.serializeNodeChildren(getStylesheetManager(), elementCreateElement, serializationOptions);
    }

    public SnuggleSession(SnuggleSnapshot snuggleSnapshot) {
        this.engine = snuggleSnapshot.engine;
        this.packages = snuggleSnapshot.packages;
        this.configuration = snuggleSnapshot.configuration;
        this.defaultDOMOutputOptions = snuggleSnapshot.defaultDOMOutputOptions;
        this.defaultXMLStringOutputOptions = snuggleSnapshot.defaultXMLStringOutputOptions;
        this.tokeniser = new LaTeXTokeniser(this);
        this.styleEvaluator = new StyleEvaluator(this);
        this.tokenFixer = new TokenFixer(this);
        this.styleRebuilder = new StyleRebuilder(this);
        this.errors = new ArrayList(snuggleSnapshot.errors);
        this.userCommandMap = new HashMap(snuggleSnapshot.userCommandMap);
        this.userEnvironmentMap = new HashMap(snuggleSnapshot.userEnvironmentMap);
        this.parsedTokens = new ArrayList(snuggleSnapshot.parsedTokens);
    }
}
