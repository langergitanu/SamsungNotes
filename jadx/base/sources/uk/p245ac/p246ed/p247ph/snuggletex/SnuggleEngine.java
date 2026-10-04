package uk.p245ac.p246ed.p247ph.snuggletex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.DefaultTransformerFactoryChooser;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.SimpleStylesheetCache;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetCache;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetManager;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.TransformerFactoryChooser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnuggleEngine {
    private DOMOutputOptions defaultDOMOutputOptions;
    private SessionConfiguration defaultSessionConfiguration;
    private XMLStringOutputOptions defaultXMLStringOutputOptions;
    private final List<SnugglePackage> packages;
    private final StylesheetManager stylesheetManager;

    public SnuggleEngine() {
        this(DefaultTransformerFactoryChooser.getInstance(), new SimpleStylesheetCache());
    }

    public void addPackage(SnugglePackage snugglePackage) {
        ConstraintUtilities.ensureNotNull(snugglePackage, "snugglePackage");
        this.packages.add(snugglePackage);
    }

    public SnuggleSession createSession() {
        return createSession(this.defaultSessionConfiguration);
    }

    public SnuggleSimpleMathRunner createSimpleMathRunner() {
        return new SnuggleSimpleMathRunner(createSession());
    }

    public BuiltinCommand getBuiltinCommandByTeXName(String str) {
        ConstraintUtilities.ensureNotNull(str, "texName");
        Iterator<SnugglePackage> it = this.packages.iterator();
        BuiltinCommand builtinCommandByTeXName = null;
        while (it.hasNext() && (builtinCommandByTeXName = it.next().getBuiltinCommandByTeXName(str)) == null) {
        }
        return builtinCommandByTeXName;
    }

    public BuiltinEnvironment getBuiltinEnvironmentByTeXName(String str) {
        ConstraintUtilities.ensureNotNull(str, "texName");
        Iterator<SnugglePackage> it = this.packages.iterator();
        BuiltinEnvironment builtinEnvironmentByTeXName = null;
        while (it.hasNext() && (builtinEnvironmentByTeXName = it.next().getBuiltinEnvironmentByTeXName(str)) == null) {
        }
        return builtinEnvironmentByTeXName;
    }

    @Deprecated
    public DOMOutputOptions getDefaultDOMOptions() {
        return this.defaultDOMOutputOptions;
    }

    public DOMOutputOptions getDefaultDOMOutputOptions() {
        return this.defaultDOMOutputOptions;
    }

    public SessionConfiguration getDefaultSessionConfiguration() {
        return this.defaultSessionConfiguration;
    }

    public XMLStringOutputOptions getDefaultXMLStringOutputOptions() {
        return this.defaultXMLStringOutputOptions;
    }

    public List<SnugglePackage> getPackages() {
        return this.packages;
    }

    public StylesheetManager getStylesheetManager() {
        return this.stylesheetManager;
    }

    @Deprecated
    public void setDefaultDOMOptions(DOMOutputOptions dOMOutputOptions) {
        ConstraintUtilities.ensureNotNull(dOMOutputOptions, "defaultDOMOptions");
        this.defaultDOMOutputOptions = dOMOutputOptions;
    }

    public void setDefaultDOMOutputOptions(DOMOutputOptions dOMOutputOptions) {
        ConstraintUtilities.ensureNotNull(dOMOutputOptions, "defaultDOMOutputOptions");
        this.defaultDOMOutputOptions = dOMOutputOptions;
    }

    public void setDefaultSessionConfiguration(SessionConfiguration sessionConfiguration) {
        ConstraintUtilities.ensureNotNull(sessionConfiguration, "defaultSessionConfiguration");
        this.defaultSessionConfiguration = sessionConfiguration;
    }

    public void setDefaultXMLStringOutputOptions(XMLStringOutputOptions xMLStringOutputOptions) {
        ConstraintUtilities.ensureNotNull(xMLStringOutputOptions, "defaultXMLOutputOptions");
        this.defaultXMLStringOutputOptions = xMLStringOutputOptions;
    }

    public SnuggleEngine(StylesheetCache stylesheetCache) {
        this(DefaultTransformerFactoryChooser.getInstance(), stylesheetCache);
    }

    public SnuggleSession createSession(SessionConfiguration sessionConfiguration) {
        ConstraintUtilities.ensureNotNull(sessionConfiguration, "sessionConfiguration");
        return new SnuggleSession(this, sessionConfiguration);
    }

    public SnuggleSimpleMathRunner createSimpleMathRunner(SessionConfiguration sessionConfiguration) {
        return new SnuggleSimpleMathRunner(createSession(sessionConfiguration));
    }

    public SnuggleEngine(TransformerFactoryChooser transformerFactoryChooser, StylesheetCache stylesheetCache) {
        this(new StylesheetManager(transformerFactoryChooser, stylesheetCache));
    }

    public SnuggleEngine(StylesheetManager stylesheetManager) {
        List<SnugglePackage> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        this.packages = listSynchronizedList;
        this.defaultSessionConfiguration = new SessionConfiguration();
        this.defaultDOMOutputOptions = new DOMOutputOptions();
        this.defaultXMLStringOutputOptions = new XMLStringOutputOptions();
        this.stylesheetManager = stylesheetManager;
        listSynchronizedList.add(CorePackageDefinitions.getPackage());
    }
}
