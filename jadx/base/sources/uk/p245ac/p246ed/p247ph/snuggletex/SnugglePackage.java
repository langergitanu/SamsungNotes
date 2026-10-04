package uk.p245ac.p246ed.p247ph.snuggletex;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CombinerTargetMatcher;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandType;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.Globals;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.InterpretableSimpleMathHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.StringUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathBigLimitOwnerInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathBracketInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathFunctionInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathNegatableInterpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnugglePackage {
    public static final InterpretableSimpleMathHandler interpretableSimpleMathBuilder = new InterpretableSimpleMathHandler();
    private final ConcurrentHashMap<String, BuiltinCommand> builtinCommandMap;
    private final ConcurrentHashMap<String, BuiltinEnvironment> builtinEnvironmentMap;
    private final List<ErrorGroup> errorGroupList;
    private final ConcurrentHashMap<ErrorGroup, List<ErrorCode>> errorGroupMap;
    private ResourceBundle errorMessageBundle;
    private final ConcurrentHashMap<Integer, MathCharacter> mathCharacterMap;
    private final String name;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LineHandler {
        void handleLine(String str);
    }

    public SnugglePackage(String str) {
        ConstraintUtilities.ensureNotNull(str, "name");
        this.name = str;
        this.builtinCommandMap = new ConcurrentHashMap<>();
        this.builtinEnvironmentMap = new ConcurrentHashMap<>();
        this.mathCharacterMap = new ConcurrentHashMap<>();
        this.errorGroupList = Collections.synchronizedList(new ArrayList());
        this.errorGroupMap = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MathCharacter ensureBuiltinMathCharacterCommand(String str, String str2) {
        BuiltinCommand builtinCommandByTeXName = getBuiltinCommandByTeXName(str);
        MathCharacter mathCharacter = builtinCommandByTeXName != null ? builtinCommandByTeXName.getMathCharacter() : null;
        if (builtinCommandByTeXName == null || mathCharacter == null) {
            throw new SnuggleRuntimeException(AbstractC0541b.m756B(str2, " must be a previously-defined math character input command"));
        }
        return mathCharacter;
    }

    public static boolean isInputableTeXName(String str) {
        return (str == null || (str.charAt(0) == '<' && str.length() > 3 && str.endsWith(">"))) ? false : true;
    }

    public static EnumMap<InterpretationType, Interpretation> makeInterpretationMap(Interpretation interpretation) {
        if (interpretation == null) {
            return null;
        }
        EnumMap<InterpretationType, Interpretation> enumMap = new EnumMap<>(InterpretationType.class);
        enumMap.put(interpretation.getType(), interpretation);
        return enumMap;
    }

    private void readResourceData(String str, LineHandler lineHandler) {
        InputStream resourceAsStream = Globals.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new SnuggleRuntimeException(AbstractC0541b.m772n("Could not load ClassPath resource at  ", str));
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "US-ASCII"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                } else if (!line.startsWith(ContentUtils.HASH_SYMBOL)) {
                    lineHandler.handleLine(line.replaceFirst("\\s+#.+$", ""));
                }
            }
        } catch (Exception e) {
            throw new SnuggleRuntimeException(AbstractC0541b.m772n("Got Exception while reading and parsing math character definitions from resource ", str), e);
        }
    }

    public BuiltinCommand addCombinerCommand(String str, EnumSet<LaTeXMode> enumSet, CombinerTargetMatcher combinerTargetMatcher, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.COMBINER, false, 0, enumSet, null, null, commandHandler, textFlowContext, combinerTargetMatcher));
    }

    public BuiltinCommand addCommand(BuiltinCommand builtinCommand) {
        if (isInputableTeXName(builtinCommand.getTeXName())) {
            this.builtinCommandMap.put(builtinCommand.getTeXName(), builtinCommand);
        }
        return builtinCommand;
    }

    public void addCommandInterpretation(String str, Interpretation interpretation) {
        BuiltinCommand builtinCommandByTeXName = getBuiltinCommandByTeXName(str);
        if (builtinCommandByTeXName == null) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("No command defined with name ", str));
        }
        builtinCommandByTeXName.getInterpretationMap().put(interpretation.getType(), interpretation);
    }

    public BuiltinCommand addComplexCommand(String str, boolean z, int i, EnumSet<LaTeXMode> enumSet, LaTeXMode[] laTeXModeArr, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.COMPLEX, z, i, enumSet, laTeXModeArr, null, commandHandler, textFlowContext, null));
    }

    public BuiltinCommand addComplexCommandOneArg(String str, boolean z, EnumSet<LaTeXMode> enumSet, LaTeXMode laTeXMode, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.COMPLEX, z, 1, enumSet, new LaTeXMode[]{laTeXMode}, null, commandHandler, textFlowContext, null));
    }

    public BuiltinCommand addComplexCommandSameArgMode(String str, boolean z, int i, EnumSet<LaTeXMode> enumSet, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.COMPLEX, z, i, enumSet, null, null, commandHandler, textFlowContext, null));
    }

    public BuiltinEnvironment addEnvironment(String str, EnumSet<LaTeXMode> enumSet, LaTeXMode laTeXMode, Interpretation interpretation, EnvironmentHandler environmentHandler, TextFlowContext textFlowContext) {
        return addEnvironment(new BuiltinEnvironment(str, false, 0, enumSet, laTeXMode, makeInterpretationMap(interpretation), environmentHandler, textFlowContext));
    }

    public void addErrorCode(ErrorCode errorCode) {
        ConstraintUtilities.ensureNotNull(errorCode, "errorCode");
        ErrorGroup errorGroup = errorCode.getErrorGroup();
        ConstraintUtilities.ensureNotNull(errorGroup, "errorCode.errorGroup");
        List<ErrorCode> listSynchronizedList = this.errorGroupMap.get(errorGroup);
        if (listSynchronizedList == null) {
            listSynchronizedList = Collections.synchronizedList(new ArrayList());
            this.errorGroupList.add(errorGroup);
            this.errorGroupMap.put(errorGroup, listSynchronizedList);
        }
        listSynchronizedList.add(errorCode);
    }

    public void addErrorCodes(ErrorCode... errorCodeArr) {
        for (ErrorCode errorCode : errorCodeArr) {
            addErrorCode(errorCode);
        }
    }

    public BuiltinCommand addMathCharacterCommand(MathCharacter mathCharacter) {
        return addMathCharacterCommandAlias(mathCharacter.getInputCommandName(), mathCharacter);
    }

    public BuiltinCommand addMathCharacterCommandAlias(String str, MathCharacter mathCharacter) {
        return addCommand(new BuiltinCommand(str, CommandType.SIMPLE, false, 0, Globals.MATH_MODE_ONLY, null, mathCharacter.getInterpretationMap(), interpretableSimpleMathBuilder, null, null));
    }

    public BuiltinCommand addSimpleCommand(String str, EnumSet<LaTeXMode> enumSet, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.SIMPLE, false, 0, enumSet, null, null, commandHandler, textFlowContext, null));
    }

    public BuiltinCommand addSimpleMathCommand(String str, MathInterpretation... mathInterpretationArr) {
        return addSimpleMathCommand(str, mathInterpretationArr, interpretableSimpleMathBuilder);
    }

    public BuiltinCommand getBuiltinCommandByTeXName(String str) {
        return this.builtinCommandMap.get(str);
    }

    public Map<String, BuiltinCommand> getBuiltinCommandMap() {
        return Collections.unmodifiableMap(this.builtinCommandMap);
    }

    public BuiltinEnvironment getBuiltinEnvironmentByTeXName(String str) {
        return this.builtinEnvironmentMap.get(str);
    }

    public Map<String, BuiltinEnvironment> getBuiltinEnvironmentMap() {
        return Collections.unmodifiableMap(this.builtinEnvironmentMap);
    }

    public List<ErrorCode> getErrorCodes(ErrorGroup errorGroup) {
        List<ErrorCode> list = this.errorGroupMap.get(errorGroup);
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    public List<ErrorGroup> getErrorGroups() {
        return Collections.unmodifiableList(this.errorGroupList);
    }

    public ResourceBundle getErrorMessageBundle() {
        return this.errorMessageBundle;
    }

    public MathCharacter getMathCharacter(int i) {
        return this.mathCharacterMap.get(Integer.valueOf(i));
    }

    public Map<Integer, MathCharacter> getMathCharacterMap() {
        return Collections.unmodifiableMap(this.mathCharacterMap);
    }

    public String getName() {
        return this.name;
    }

    public void loadMathCharacterAliases(String str) {
        readResourceData(str, new LineHandler() { // from class: uk.ac.ed.ph.snuggletex.SnugglePackage.5
            @Override // uk.ac.ed.ph.snuggletex.SnugglePackage.LineHandler
            public void handleLine(String str2) {
                String[] strArrSplit = str2.replaceFirst("\\s+#.+$", "").split("->");
                SnugglePackage.this.addMathCharacterCommandAlias(strArrSplit[0], SnugglePackage.this.ensureBuiltinMathCharacterCommand(strArrSplit[1], "Target command for alias"));
            }
        });
    }

    public void loadMathCharacterBigLimitTargets(String str) {
        final MathBigLimitOwnerInterpretation mathBigLimitOwnerInterpretation = new MathBigLimitOwnerInterpretation();
        readResourceData(str, new LineHandler() { // from class: uk.ac.ed.ph.snuggletex.SnugglePackage.6
            @Override // uk.ac.ed.ph.snuggletex.SnugglePackage.LineHandler
            public void handleLine(String str2) {
                SnugglePackage.this.ensureBuiltinMathCharacterCommand(str2, "Target command for big limit owner").addInterpretation(mathBigLimitOwnerInterpretation);
            }
        });
    }

    public void loadMathCharacterBrackets(String str) {
        readResourceData(str, new LineHandler() { // from class: uk.ac.ed.ph.snuggletex.SnugglePackage.4
            @Override // uk.ac.ed.ph.snuggletex.SnugglePackage.LineHandler
            public void handleLine(String str2) {
                String[] strArrSplit = str2.split(":");
                String str3 = strArrSplit[0];
                String str4 = strArrSplit[1];
                SnugglePackage.this.ensureBuiltinMathCharacterCommand(str3, "Bracket input command").addInterpretation(new MathBracketInterpretation(SnugglePackage.this.ensureBuiltinMathCharacterCommand(str4, "Fence target"), MathBracketInterpretation.BracketType.valueOf(strArrSplit[2]), "INFER".equals(strArrSplit[3])));
            }
        });
    }

    public void loadMathCharacterDefinitions(String str) {
        readResourceData(str, new LineHandler() { // from class: uk.ac.ed.ph.snuggletex.SnugglePackage.2
            @Override // uk.ac.ed.ph.snuggletex.SnugglePackage.LineHandler
            public void handleLine(String str2) {
                String[] strArrSplit = str2.split(":");
                int i = Integer.parseInt(strArrSplit[0], 16);
                String strNullIfEmpty = StringUtilities.nullIfEmpty(strArrSplit[1]);
                MathCharacter mathCharacter = new MathCharacter(i, strNullIfEmpty, MathCharacter.MathCharacterType.valueOf(strArrSplit[2]));
                SnugglePackage.this.mathCharacterMap.put(Integer.valueOf(i), mathCharacter);
                if (strNullIfEmpty != null) {
                    SnugglePackage.this.addMathCharacterCommand(mathCharacter);
                }
            }
        });
    }

    public void loadMathCharacterNegations(String str) {
        readResourceData(str, new LineHandler() { // from class: uk.ac.ed.ph.snuggletex.SnugglePackage.3
            @Override // uk.ac.ed.ph.snuggletex.SnugglePackage.LineHandler
            public void handleLine(String str2) {
                String strConcat;
                int iIndexOf = str2.indexOf("->");
                if (iIndexOf != -1) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    strConcat = str2.substring(iIndexOf + 2);
                    str2 = strSubstring;
                } else {
                    strConcat = "n".concat(str2);
                }
                SnugglePackage.this.ensureBuiltinMathCharacterCommand(str2, "Source command for negation").addInterpretation(new MathNegatableInterpretation(SnugglePackage.this.ensureBuiltinMathCharacterCommand(strConcat, "Target command for negation")));
            }
        });
    }

    public void loadMathFunctionDefinitions(String str) {
        readResourceData(str, new LineHandler() { // from class: uk.ac.ed.ph.snuggletex.SnugglePackage.1
            @Override // uk.ac.ed.ph.snuggletex.SnugglePackage.LineHandler
            public void handleLine(String str2) {
                String strSubstring;
                int iIndexOf = str2.indexOf("->");
                if (iIndexOf != -1) {
                    String strSubstring2 = str2.substring(0, iIndexOf);
                    strSubstring = str2.substring(iIndexOf + 2);
                    str2 = strSubstring2;
                } else {
                    strSubstring = str2;
                }
                SnugglePackage.this.addSimpleMathCommand(str2, new MathFunctionInterpretation(strSubstring));
            }
        });
    }

    public void setErrorMessageBundle(ResourceBundle resourceBundle) {
        this.errorMessageBundle = resourceBundle;
    }

    public BuiltinCommand addComplexCommandOneArg(String str, boolean z, EnumSet<LaTeXMode> enumSet, LaTeXMode laTeXMode, Interpretation interpretation, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.COMPLEX, z, 1, enumSet, new LaTeXMode[]{laTeXMode}, makeInterpretationMap(interpretation), commandHandler, textFlowContext, null));
    }

    public BuiltinCommand addComplexCommandSameArgMode(String str, boolean z, int i, EnumSet<LaTeXMode> enumSet, Interpretation interpretation, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.COMPLEX, z, i, enumSet, null, makeInterpretationMap(interpretation), commandHandler, textFlowContext, null));
    }

    public BuiltinCommand addSimpleCommand(String str, EnumSet<LaTeXMode> enumSet, Interpretation[] interpretationArr, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.SIMPLE, false, 0, enumSet, null, makeInterpretationMap(interpretationArr), commandHandler, textFlowContext, null));
    }

    public BuiltinCommand addSimpleMathCommand(String str, MathInterpretation mathInterpretation, CommandHandler commandHandler) {
        return addCommand(new BuiltinCommand(str, CommandType.SIMPLE, false, 0, Globals.MATH_MODE_ONLY, null, makeInterpretationMap(mathInterpretation), commandHandler, null, null));
    }

    public static EnumMap<InterpretationType, Interpretation> makeInterpretationMap(Interpretation... interpretationArr) {
        if (interpretationArr.length == 0) {
            return null;
        }
        EnumMap<InterpretationType, Interpretation> enumMap = new EnumMap<>(InterpretationType.class);
        for (Interpretation interpretation : interpretationArr) {
            enumMap.put(interpretation.getType(), interpretation);
        }
        return enumMap;
    }

    public BuiltinEnvironment addEnvironment(String str, EnumSet<LaTeXMode> enumSet, LaTeXMode laTeXMode, Interpretation[] interpretationArr, EnvironmentHandler environmentHandler, TextFlowContext textFlowContext) {
        return addEnvironment(new BuiltinEnvironment(str, false, 0, enumSet, laTeXMode, makeInterpretationMap(interpretationArr), environmentHandler, textFlowContext));
    }

    public BuiltinCommand addSimpleCommand(String str, EnumSet<LaTeXMode> enumSet, Interpretation interpretation, CommandHandler commandHandler, TextFlowContext textFlowContext) {
        return addCommand(new BuiltinCommand(str, CommandType.SIMPLE, false, 0, enumSet, null, makeInterpretationMap(interpretation), commandHandler, textFlowContext, null));
    }

    public BuiltinCommand addSimpleMathCommand(String str, MathInterpretation[] mathInterpretationArr, CommandHandler commandHandler) {
        return addCommand(new BuiltinCommand(str, CommandType.SIMPLE, false, 0, Globals.MATH_MODE_ONLY, null, makeInterpretationMap(mathInterpretationArr), commandHandler, null, null));
    }

    public BuiltinEnvironment addEnvironment(String str, boolean z, int i, EnumSet<LaTeXMode> enumSet, LaTeXMode laTeXMode, Interpretation interpretation, EnvironmentHandler environmentHandler, TextFlowContext textFlowContext) {
        return addEnvironment(new BuiltinEnvironment(str, z, i, enumSet, laTeXMode, makeInterpretationMap(interpretation), environmentHandler, textFlowContext));
    }

    public BuiltinEnvironment addEnvironment(String str, boolean z, int i, EnumSet<LaTeXMode> enumSet, LaTeXMode laTeXMode, Interpretation[] interpretationArr, EnvironmentHandler environmentHandler, TextFlowContext textFlowContext) {
        return addEnvironment(new BuiltinEnvironment(str, z, i, enumSet, laTeXMode, makeInterpretationMap(interpretationArr), environmentHandler, textFlowContext));
    }

    public BuiltinEnvironment addEnvironment(BuiltinEnvironment builtinEnvironment) {
        if (isInputableTeXName(builtinEnvironment.getTeXName())) {
            this.builtinEnvironmentMap.put(builtinEnvironment.getTeXName(), builtinEnvironment);
        }
        return builtinEnvironment;
    }
}
