package uk.p245ac.p246ed.p247ph.snuggletex;

import java.util.List;
import java.util.Map;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnuggleSnapshot {
    final SessionConfiguration configuration;
    final DOMOutputOptions defaultDOMOutputOptions;
    final XMLStringOutputOptions defaultXMLStringOutputOptions;
    final SnuggleEngine engine;
    final List<InputError> errors;
    final SnugglePackage[] packages;
    final List<FlowToken> parsedTokens;
    final Map<String, UserDefinedCommand> userCommandMap;
    final Map<String, UserDefinedEnvironment> userEnvironmentMap;

    public SnuggleSnapshot(SnuggleEngine snuggleEngine, SnugglePackage[] snugglePackageArr, SessionConfiguration sessionConfiguration, DOMOutputOptions dOMOutputOptions, XMLStringOutputOptions xMLStringOutputOptions, List<InputError> list, Map<String, UserDefinedCommand> map, Map<String, UserDefinedEnvironment> map2, List<FlowToken> list2) {
        this.engine = snuggleEngine;
        this.packages = snugglePackageArr;
        this.configuration = sessionConfiguration;
        this.defaultDOMOutputOptions = dOMOutputOptions;
        this.defaultXMLStringOutputOptions = xMLStringOutputOptions;
        this.errors = list;
        this.userCommandMap = map;
        this.userEnvironmentMap = map2;
        this.parsedTokens = list2;
    }

    public SnuggleSession createSession() {
        return new SnuggleSession(this);
    }
}
