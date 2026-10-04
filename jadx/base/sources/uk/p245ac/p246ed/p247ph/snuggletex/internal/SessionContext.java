package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import java.util.List;
import java.util.Map;
import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.SessionConfiguration;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface SessionContext {
    BuiltinCommand getBuiltinCommandByTeXName(String str);

    BuiltinEnvironment getBuiltinEnvironmentByTeXName(String str);

    SessionConfiguration getConfiguration();

    List<InputError> getErrors();

    MathCharacter getMathCharacter(int i);

    StylesheetManager getStylesheetManager();

    Map<String, UserDefinedCommand> getUserCommandMap();

    Map<String, UserDefinedEnvironment> getUserEnvironmentMap();

    void registerError(InputError inputError);
}
