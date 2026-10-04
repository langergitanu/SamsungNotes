package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;
import uk.p245ac.p246ed.p247ph.snuggletex.ErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.NumberMatcher;
import uk.p245ac.p246ed.p247ph.snuggletex.SimpleNumberMatcher;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.Command;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandType;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedCommandOrEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.UserDefinedEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ArrayListStack;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathNumberInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.BraceContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ErrorToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.MathCharacterToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.RootToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.SimpleToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class LaTeXTokeniser {
    private static final String UDE_POST_BEGIN = "\u0000";
    public static final Set<String> reservedCommands = new HashSet(Arrays.asList("begin", "end", "(", ")", "[", "]", "newcommand", "renewcommand", "newenvironment", "renewenvironment"));
    private ModeState currentModeState;
    private final NumberMatcher numberMatcher;
    private int position;
    private final SessionContext sessionContext;
    private int startTokenIndex;
    private WorkingDocument workingDocument;
    private final ArrayListStack<ModeState> modeStack = new ArrayListStack<>();
    private final ArrayListStack<String> openEnvironmentStack = new ArrayListStack<>();

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.internal.LaTeXTokeniser$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144901 {
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$CommandType;
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode;

        static {
            int[] iArr = new int[CommandType.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$CommandType = iArr;
            try {
                iArr[CommandType.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$CommandType[CommandType.COMBINER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$CommandType[CommandType.COMPLEX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LaTeXMode.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode = iArr2;
            try {
                iArr2[LaTeXMode.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[LaTeXMode.LR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[LaTeXMode.MATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[LaTeXMode.VERBATIM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ArgumentDefinitionResult {
        public String optionalArgument;
        public int requiredArgumentCount;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuiltinCommandOrEnvironmentArgumentSearchResult {
        public ArgumentContainerToken optionalArgument;
        public ArgumentContainerToken[] requiredArguments;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ModeState {
        public LaTeXMode latexMode;
        public final int startPosition;
        public final Terminator terminator;
        public final TokenisationMode tokenisationMode;
        public final List<FlowToken> tokens = new ArrayList();
        public boolean foundTerminator = false;

        public ModeState(TokenisationMode tokenisationMode, LaTeXMode laTeXMode, int i, Terminator terminator) {
            this.tokenisationMode = tokenisationMode;
            this.latexMode = laTeXMode;
            this.startPosition = i;
            this.terminator = terminator;
        }

        public int computeLastTokenEndIndex() {
            return this.tokens.isEmpty() ? this.startPosition : ((FlowToken) AbstractC0000a.m10g(this.tokens, 1)).getSlice().endIndex;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PatternTerminator implements Terminator {
        private final Pattern terminatorPattern;

        public PatternTerminator(Pattern pattern) {
            this.terminatorPattern = pattern;
        }

        @Override // uk.ac.ed.ph.snuggletex.internal.LaTeXTokeniser.Terminator
        public int matchesAt(WorkingDocument workingDocument, int i) {
            Matcher matcher = this.terminatorPattern.matcher(workingDocument.extract());
            if (matcher.find(i) && matcher.start() == i) {
                return matcher.end();
            }
            return -1;
        }

        @Override // uk.ac.ed.ph.snuggletex.internal.LaTeXTokeniser.Terminator
        public int nextMatchFrom(WorkingDocument workingDocument, int i) {
            Matcher matcher = this.terminatorPattern.matcher(workingDocument.extract());
            if (matcher.find(i)) {
                return matcher.start();
            }
            return -1;
        }

        public String toString() {
            return "(pattern) " + this.terminatorPattern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StringTerminator implements Terminator {
        private final String terminatorString;

        public StringTerminator(String str) {
            this.terminatorString = str;
        }

        @Override // uk.ac.ed.ph.snuggletex.internal.LaTeXTokeniser.Terminator
        public int matchesAt(WorkingDocument workingDocument, int i) {
            if (workingDocument.matchesAt(i, this.terminatorString)) {
                return this.terminatorString.length() + i;
            }
            return -1;
        }

        @Override // uk.ac.ed.ph.snuggletex.internal.LaTeXTokeniser.Terminator
        public int nextMatchFrom(WorkingDocument workingDocument, int i) {
            return workingDocument.indexOf(i, this.terminatorString);
        }

        public String toString() {
            return this.terminatorString;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Terminator {
        int matchesAt(WorkingDocument workingDocument, int i);

        int nextMatchFrom(WorkingDocument workingDocument, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TokenisationMode {
        TOP_LEVEL,
        BRACE,
        MATH,
        BUILTIN_COMMAND_ARGUMENT,
        BUILTIN_ENVIRONMENT_CONTENT
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UserDefinedCommandOrEnvironmentArgumentSearchResult {
        public CharSequence optionalArgument;
        public CharSequence[] requiredArguments;
    }

    public LaTeXTokeniser(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
        NumberMatcher numberMatcher = sessionContext.getConfiguration().getNumberMatcher();
        this.numberMatcher = numberMatcher == null ? new SimpleNumberMatcher() : numberMatcher;
    }

    private String advanceOverBracesAndEnvironmentName() {
        skipOverCommentsAndWhitespace();
        if (this.workingDocument.charAt(this.position) != 123) {
            return null;
        }
        int i = this.position + 1;
        this.position = i;
        String commandOrEnvironmentName = readCommandOrEnvironmentName(i);
        int length = commandOrEnvironmentName.length() + this.position;
        this.position = length;
        if (this.workingDocument.charAt(length) != 125) {
            return null;
        }
        this.position++;
        return commandOrEnvironmentName;
    }

    private ErrorToken advanceOverBuiltinCommandOrEnvironmentArguments(CommandOrEnvironment commandOrEnvironment, BuiltinCommandOrEnvironmentArgumentSearchResult builtinCommandOrEnvironmentArgumentSearchResult) {
        ArgumentContainerToken argumentContainerToken;
        int i;
        if (commandOrEnvironment.getArgumentCount() == 0 && !commandOrEnvironment.isAllowingOptionalArgument()) {
            builtinCommandOrEnvironmentArgumentSearchResult.optionalArgument = null;
            builtinCommandOrEnvironmentArgumentSearchResult.requiredArguments = ArgumentContainerToken.EMPTY_ARRAY;
            return null;
        }
        skipOverCommentsAndWhitespace();
        int i2 = 0;
        if (commandOrEnvironment.isAllowingOptionalArgument()) {
            LaTeXMode argumentMode = commandOrEnvironment.getArgumentMode(0);
            if (argumentMode == null) {
                argumentMode = this.currentModeState.latexMode;
            }
            if (this.workingDocument.charAt(this.position) == 91) {
                int i4 = this.position + 1;
                this.position = i4;
                ModeState modeState = tokeniseInNewState(TokenisationMode.BUILTIN_COMMAND_ARGUMENT, new StringTerminator("]"), argumentMode);
                argumentContainerToken = new ArgumentContainerToken(this.workingDocument.freezeSlice(i4, modeState.foundTerminator ? this.position - 1 : this.position), argumentMode, modeState.tokens);
            } else {
                argumentContainerToken = null;
            }
            i = 1;
        } else {
            argumentContainerToken = null;
            i = 0;
        }
        int argumentCount = commandOrEnvironment.getArgumentCount();
        ArgumentContainerToken[] argumentContainerTokenArr = new ArgumentContainerToken[argumentCount];
        FrozenSlice[] frozenSliceArr = new FrozenSlice[argumentCount];
        while (i2 < argumentCount) {
            skipOverCommentsAndWhitespace();
            int i5 = i + 1;
            LaTeXMode argumentMode2 = commandOrEnvironment.getArgumentMode(i);
            if (argumentMode2 == null) {
                argumentMode2 = this.currentModeState.latexMode;
            }
            int iCharAt = this.workingDocument.charAt(this.position);
            if (iCharAt == 123) {
                int i6 = this.position + 1;
                this.position = i6;
                ModeState modeState2 = tokeniseInNewState(TokenisationMode.BUILTIN_COMMAND_ARGUMENT, new StringTerminator("}"), argumentMode2);
                FrozenSlice frozenSliceFreezeSlice = this.workingDocument.freezeSlice(i6, modeState2.foundTerminator ? this.position - 1 : this.position);
                frozenSliceArr[i2] = frozenSliceFreezeSlice;
                argumentContainerTokenArr[i2] = new ArgumentContainerToken(frozenSliceFreezeSlice, argumentMode2, modeState2.tokens);
            } else {
                if (iCharAt == -1 || i2 != 0 || argumentCount != 1 || argumentContainerToken != null || !(commandOrEnvironment instanceof Command)) {
                    return createError(commandOrEnvironment instanceof Command ? CoreErrorCode.TTEC02 : CoreErrorCode.TTEE06, this.startTokenIndex, this.position, commandOrEnvironment.getTeXName(), Integer.valueOf(i2 + 1));
                }
                ModeState modeState3 = this.currentModeState;
                LaTeXMode laTeXMode = modeState3.latexMode;
                modeState3.latexMode = argumentMode2;
                FlowToken nextToken = readNextToken();
                this.currentModeState.latexMode = laTeXMode;
                if (nextToken == null) {
                    return createError(CoreErrorCode.TTEC02, this.startTokenIndex, this.position, commandOrEnvironment.getTeXName(), 1);
                }
                ArgumentContainerToken argumentContainerTokenCreateFromSingleToken = ArgumentContainerToken.createFromSingleToken(argumentMode2, nextToken);
                argumentContainerTokenArr[i2] = argumentContainerTokenCreateFromSingleToken;
                frozenSliceArr[i2] = argumentContainerTokenCreateFromSingleToken.getSlice();
            }
            i2++;
            i = i5;
        }
        builtinCommandOrEnvironmentArgumentSearchResult.optionalArgument = argumentContainerToken;
        builtinCommandOrEnvironmentArgumentSearchResult.requiredArguments = argumentContainerTokenArr;
        return null;
    }

    private ErrorToken advanceOverUserDefinedCommandOrEnvironmentArgumentDefinition(String str, ArgumentDefinitionResult argumentDefinitionResult) {
        String string;
        skipOverCommentsAndWhitespace();
        int i = 0;
        if (this.workingDocument.charAt(this.position) == 91) {
            int i2 = this.position;
            int i4 = i2 + 1;
            int iFindEndSquareBrackets = findEndSquareBrackets(i2);
            if (iFindEndSquareBrackets == -1) {
                return createError(CoreErrorCode.TTEUC9, this.startTokenIndex, this.workingDocument.length(), new Object[0]);
            }
            this.position = iFindEndSquareBrackets + 1;
            String strTrim = this.workingDocument.extract(i4, iFindEndSquareBrackets).toString().trim();
            try {
                int i5 = Integer.parseInt(strTrim);
                if (i5 < 1 || i5 > 9) {
                    return createError(CoreErrorCode.TTEUC7, this.startTokenIndex, this.position, str, strTrim);
                }
                skipOverCommentsAndWhitespace();
                if (this.workingDocument.charAt(this.position) == 91) {
                    i5--;
                    int iFindEndSquareBrackets2 = findEndSquareBrackets(this.position);
                    if (iFindEndSquareBrackets2 == -1) {
                        return createError(CoreErrorCode.TTEUC9, this.startTokenIndex, this.workingDocument.length(), new Object[0]);
                    }
                    string = this.workingDocument.extract(this.position + 1, iFindEndSquareBrackets2).toString();
                    this.position = iFindEndSquareBrackets2 + 1;
                } else {
                    string = null;
                }
                i = i5;
            } catch (NumberFormatException unused) {
                return createError(CoreErrorCode.TTEUC7, this.startTokenIndex, this.position, str, strTrim);
            }
        } else {
            string = null;
        }
        skipOverCommentsAndWhitespace();
        argumentDefinitionResult.optionalArgument = string;
        argumentDefinitionResult.requiredArgumentCount = i;
        return null;
    }

    private ErrorToken advanceOverUserDefinedCommandOrEnvironmentArguments(CommandOrEnvironment commandOrEnvironment, UserDefinedCommandOrEnvironmentArgumentSearchResult userDefinedCommandOrEnvironmentArgumentSearchResult) {
        CharSequence charSequenceExtract;
        if (commandOrEnvironment.getArgumentCount() == 0 && !commandOrEnvironment.isAllowingOptionalArgument()) {
            userDefinedCommandOrEnvironmentArgumentSearchResult.optionalArgument = null;
            userDefinedCommandOrEnvironmentArgumentSearchResult.requiredArguments = new CharSequence[0];
            return null;
        }
        skipOverCommentsAndWhitespace();
        if (commandOrEnvironment.isAllowingOptionalArgument() && this.workingDocument.charAt(this.position) == 91) {
            int i = this.position;
            int iFindEndSquareBrackets = findEndSquareBrackets(i);
            if (iFindEndSquareBrackets == -1) {
                return createError(CoreErrorCode.TTEG00, this.startTokenIndex, this.workingDocument.length(), Character.valueOf(PropertyUtils.INDEXED_DELIM2));
            }
            charSequenceExtract = this.workingDocument.extract(i + 1, iFindEndSquareBrackets);
            this.position = iFindEndSquareBrackets + 1;
        } else {
            charSequenceExtract = null;
        }
        int argumentCount = commandOrEnvironment.getArgumentCount();
        CharSequence[] charSequenceArr = new CharSequence[argumentCount];
        for (int i2 = 0; i2 < argumentCount; i2++) {
            skipOverCommentsAndWhitespace();
            int iCharAt = this.workingDocument.charAt(this.position);
            if (iCharAt == 123) {
                int i4 = this.position;
                int iFindEndCurlyBrackets = findEndCurlyBrackets(i4);
                if (iFindEndCurlyBrackets == -1) {
                    return createError(CoreErrorCode.TTEG00, this.startTokenIndex, this.workingDocument.length(), '}');
                }
                charSequenceArr[i2] = this.workingDocument.extract(i4 + 1, iFindEndCurlyBrackets);
                this.position = iFindEndCurlyBrackets + 1;
            } else {
                if (iCharAt == -1 || i2 != 0 || argumentCount != 1 || userDefinedCommandOrEnvironmentArgumentSearchResult.optionalArgument != null) {
                    return createError(commandOrEnvironment instanceof Command ? CoreErrorCode.TTEC02 : CoreErrorCode.TTEE06, this.startTokenIndex, this.position, commandOrEnvironment.getTeXName(), Integer.valueOf(i2 + 1));
                }
                FlowToken nextToken = readNextToken();
                if (nextToken == null) {
                    return createError(CoreErrorCode.TTEC02, this.startTokenIndex, this.position, commandOrEnvironment.getTeXName(), 1);
                }
                charSequenceArr[i2] = nextToken.getSlice().extract();
                this.workingDocument.unfreeze(this.startTokenIndex);
            }
        }
        userDefinedCommandOrEnvironmentArgumentSearchResult.optionalArgument = charSequenceExtract;
        userDefinedCommandOrEnvironmentArgumentSearchResult.requiredArguments = charSequenceArr;
        return null;
    }

    private ErrorToken checkDefinitionArguments(FrozenSlice frozenSlice, String str, ArgumentDefinitionResult argumentDefinitionResult, ErrorCode errorCode) {
        int i;
        if (argumentDefinitionResult != null) {
            i = argumentDefinitionResult.requiredArgumentCount + (argumentDefinitionResult.optionalArgument != null ? 1 : 0);
        } else {
            i = 0;
        }
        WorkingDocument document = frozenSlice.getDocument();
        int i2 = frozenSlice.startIndex;
        boolean z = false;
        boolean z2 = false;
        while (i2 < frozenSlice.endIndex) {
            int iCharAt = document.charAt(i2);
            if (!z2 && iCharAt == 92) {
                z2 = true;
            } else if (z2) {
                z2 = false;
            } else if (iCharAt == 35) {
                z = true;
            } else if (!z) {
                continue;
            } else {
                if (i == 0 || iCharAt < 49 || iCharAt > i + 48) {
                    return createError(errorCode, i2 - 1, i2, str, Character.valueOf((char) iCharAt), Integer.valueOf(i));
                }
                z = false;
            }
            i2++;
        }
        if (z) {
            return createError(errorCode, i2 - 1, i2, str, null, Integer.valueOf(i));
        }
        return null;
    }

    private ErrorToken createError(ErrorCode errorCode, int i, int i2, Object... objArr) {
        InputError inputError = new InputError(errorCode, this.workingDocument.freezeSlice(i, i2), objArr);
        this.sessionContext.registerError(inputError);
        ModeState modeState = this.currentModeState;
        return new ErrorToken(inputError, modeState != null ? modeState.latexMode : LaTeXMode.PARAGRAPH);
    }

    private int findEndCurlyBrackets(int i) {
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.workingDocument.length()) {
            int iCharAt = this.workingDocument.charAt(i);
            if (!z && iCharAt == 92) {
                z = true;
            } else if (z) {
                z = false;
            } else if (z2) {
                if (iCharAt == 10) {
                    z2 = false;
                }
            } else if (iCharAt == 37) {
                z2 = true;
            } else if (iCharAt == 123) {
                i2++;
            } else if (iCharAt == 125 && i2 - 1 == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int findEndSquareBrackets(int i) {
        boolean z = false;
        boolean z2 = false;
        while (i < this.workingDocument.length()) {
            int iCharAt = this.workingDocument.charAt(i);
            if (z) {
                if (iCharAt == 10) {
                    z = false;
                }
            } else {
                if (iCharAt == 93) {
                    return i;
                }
                if (z2) {
                    z2 = false;
                } else if (iCharAt == 92) {
                    z2 = true;
                } else if (iCharAt == 123) {
                    i = findEndCurlyBrackets(i);
                } else if (iCharAt == 37) {
                    z = true;
                }
            }
            i++;
        }
        return -1;
    }

    private FlowToken finishBeginBuiltinEnvironment(BuiltinEnvironment builtinEnvironment) {
        ArgumentContainerToken argumentContainerToken;
        this.openEnvironmentStack.push(builtinEnvironment.getTeXName());
        int i = this.startTokenIndex;
        LaTeXMode laTeXMode = this.currentModeState.latexMode;
        ErrorToken errorTokenCreateError = !builtinEnvironment.getAllowedModes().contains(this.currentModeState.latexMode) ? createError(CoreErrorCode.TTEE03, this.startTokenIndex, this.position, builtinEnvironment.getTeXName(), laTeXMode) : null;
        BuiltinCommandOrEnvironmentArgumentSearchResult builtinCommandOrEnvironmentArgumentSearchResult = new BuiltinCommandOrEnvironmentArgumentSearchResult();
        ErrorToken errorTokenAdvanceOverBuiltinCommandOrEnvironmentArguments = advanceOverBuiltinCommandOrEnvironmentArguments(builtinEnvironment, builtinCommandOrEnvironmentArgumentSearchResult);
        if (errorTokenAdvanceOverBuiltinCommandOrEnvironmentArguments != null && errorTokenCreateError == null) {
            errorTokenCreateError = errorTokenAdvanceOverBuiltinCommandOrEnvironmentArguments;
        }
        LaTeXMode contentMode = builtinEnvironment.getContentMode();
        if (contentMode == null) {
            contentMode = this.currentModeState.latexMode;
        }
        LaTeXMode laTeXMode2 = LaTeXMode.VERBATIM;
        if (contentMode == laTeXMode2) {
            int i2 = this.position;
            ModeState modeState = tokeniseInNewState(TokenisationMode.BUILTIN_ENVIRONMENT_CONTENT, new PatternTerminator(Pattern.compile("\\\\end\\s*\\{" + builtinEnvironment.getTeXName() + "\\}\\s*")), laTeXMode2);
            argumentContainerToken = new ArgumentContainerToken(this.workingDocument.freezeSlice(i2, modeState.computeLastTokenEndIndex()), contentMode, modeState.tokens);
            this.openEnvironmentStack.pop();
        } else {
            skipOverCommentsAndWhitespace();
            int i4 = this.position;
            ModeState modeState2 = tokeniseInNewState(TokenisationMode.BUILTIN_ENVIRONMENT_CONTENT, null, contentMode);
            argumentContainerToken = new ArgumentContainerToken(this.workingDocument.freezeSlice(i4, modeState2.computeLastTokenEndIndex()), contentMode, modeState2.tokens);
        }
        ArgumentContainerToken argumentContainerToken2 = argumentContainerToken;
        if (errorTokenCreateError == null) {
            return new EnvironmentToken(this.workingDocument.freezeSlice(i, this.position), laTeXMode, builtinEnvironment, builtinCommandOrEnvironmentArgumentSearchResult.optionalArgument, builtinCommandOrEnvironmentArgumentSearchResult.requiredArguments, argumentContainerToken2);
        }
        this.sessionContext.getErrors().remove(errorTokenCreateError.getError());
        return createError(errorTokenCreateError.getError().getErrorCode(), this.startTokenIndex, this.position, errorTokenCreateError.getError().getArguments());
    }

    private FlowToken finishBeginEnvironment() {
        String strAdvanceOverBracesAndEnvironmentName = advanceOverBracesAndEnvironmentName();
        if (strAdvanceOverBracesAndEnvironmentName == null) {
            return createError(CoreErrorCode.TTEE01, this.startTokenIndex, this.position, new Object[0]);
        }
        UserDefinedEnvironment userDefinedEnvironment = this.sessionContext.getUserEnvironmentMap().get(strAdvanceOverBracesAndEnvironmentName);
        if (userDefinedEnvironment != null) {
            return finishBeginUserDefinedEnvironment(userDefinedEnvironment);
        }
        BuiltinEnvironment builtinEnvironmentByTeXName = this.sessionContext.getBuiltinEnvironmentByTeXName(strAdvanceOverBracesAndEnvironmentName);
        return builtinEnvironmentByTeXName != null ? finishBeginBuiltinEnvironment(builtinEnvironmentByTeXName) : createError(CoreErrorCode.TTEE02, this.startTokenIndex, this.position, strAdvanceOverBracesAndEnvironmentName);
    }

    private FlowToken finishBeginUserDefinedEnvironment(UserDefinedEnvironment userDefinedEnvironment) {
        UserDefinedCommandOrEnvironmentArgumentSearchResult userDefinedCommandOrEnvironmentArgumentSearchResult = new UserDefinedCommandOrEnvironmentArgumentSearchResult();
        ErrorToken errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArguments = advanceOverUserDefinedCommandOrEnvironmentArguments(userDefinedEnvironment, userDefinedCommandOrEnvironmentArgumentSearchResult);
        if (errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArguments != null) {
            return errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArguments;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(substituteArguments(userDefinedEnvironment.getBeginDefinitionSlice(), userDefinedEnvironment, userDefinedCommandOrEnvironmentArgumentSearchResult), "\\\u0000{");
        sbM781w.append(userDefinedEnvironment.getTeXName());
        sbM781w.append("}");
        ErrorToken errorTokenMakeSubstitutionAndRewind = makeSubstitutionAndRewind(this.startTokenIndex, this.position, sbM781w.toString());
        return errorTokenMakeSubstitutionAndRewind != null ? errorTokenMakeSubstitutionAndRewind : readNextToken();
    }

    private FlowToken finishBuiltinCommand(BuiltinCommand builtinCommand) {
        if (!builtinCommand.getAllowedModes().contains(this.currentModeState.latexMode)) {
            return createError(CoreErrorCode.TTEC01, this.startTokenIndex, this.position, builtinCommand.getTeXName(), this.currentModeState.latexMode);
        }
        if (builtinCommand == CorePackageDefinitions.CMD_NEWCOMMAND || builtinCommand == CorePackageDefinitions.CMD_RENEWCOMMAND) {
            return finishCommandDefinition(builtinCommand);
        }
        if (builtinCommand == CorePackageDefinitions.CMD_NEWENVIRONMENT || builtinCommand == CorePackageDefinitions.CMD_RENEWENVIRONMENT) {
            return finishEnvironmentDefinition(builtinCommand);
        }
        int i = C144901.$SwitchMap$uk$ac$ed$ph$snuggletex$definitions$CommandType[builtinCommand.getType().ordinal()];
        if (i == 1) {
            return finishSimpleCommand(builtinCommand);
        }
        if (i == 2) {
            return finishCombiningCommand(builtinCommand);
        }
        if (i == 3) {
            return finishComplexCommand(builtinCommand);
        }
        throw new SnuggleLogicException("Unexpected switch case " + builtinCommand.getType());
    }

    private FlowToken finishCombiningCommand(BuiltinCommand builtinCommand) {
        skipOverCommentsAndWhitespace();
        int i = this.position;
        int i2 = this.startTokenIndex;
        FlowToken nextToken = readNextToken();
        if (nextToken == null) {
            return createError(CoreErrorCode.TTEC03, this.startTokenIndex, i, builtinCommand.getTeXName());
        }
        if (!builtinCommand.getCombinerTargetMatcher().isAllowed(nextToken)) {
            return createError(CoreErrorCode.TTEC04, this.startTokenIndex, nextToken.getSlice().endIndex, builtinCommand.getTeXName());
        }
        FrozenSlice frozenSliceFreezeSlice = this.workingDocument.freezeSlice(i2, nextToken.getSlice().endIndex);
        LaTeXMode laTeXMode = this.currentModeState.latexMode;
        return new CommandToken(frozenSliceFreezeSlice, laTeXMode, builtinCommand, ArgumentContainerToken.createFromSingleToken(laTeXMode, nextToken));
    }

    private FlowToken finishCommand(String str) {
        UserDefinedCommand userDefinedCommand = this.sessionContext.getUserCommandMap().get(str);
        if (userDefinedCommand != null) {
            return finishUserDefinedCommand(userDefinedCommand);
        }
        BuiltinCommand builtinCommandByTeXName = this.sessionContext.getBuiltinCommandByTeXName(str);
        return builtinCommandByTeXName != null ? finishBuiltinCommand(builtinCommandByTeXName) : createError(CoreErrorCode.TTEC00, this.startTokenIndex, this.position, str);
    }

    private FlowToken finishCommandDefinition(BuiltinCommand builtinCommand) {
        boolean z;
        skipOverCommentsAndWhitespace();
        int iCharAt = this.workingDocument.charAt(this.position);
        if (iCharAt == -1) {
            return createError(CoreErrorCode.TTEUC0, this.startTokenIndex, this.position, new Object[0]);
        }
        if (iCharAt == 123) {
            this.position++;
            skipOverCommentsAndWhitespace();
            z = true;
        } else {
            z = false;
        }
        if (this.workingDocument.charAt(this.position) != 92) {
            return createError(CoreErrorCode.TTEUC1, this.startTokenIndex, this.position, new Object[0]);
        }
        int i = this.position + 1;
        this.position = i;
        String commandOrEnvironmentName = readCommandOrEnvironmentName(i);
        if (commandOrEnvironmentName == null) {
            return createError(CoreErrorCode.TTEUC0, this.startTokenIndex, this.position, new Object[0]);
        }
        if (reservedCommands.contains(commandOrEnvironmentName)) {
            return createError(CoreErrorCode.TTEUC8, this.startTokenIndex, commandOrEnvironmentName.length() + this.position, commandOrEnvironmentName);
        }
        this.position = commandOrEnvironmentName.length() + this.position;
        if (z) {
            skipOverCommentsAndWhitespace();
            if (this.workingDocument.charAt(this.position) != 125) {
                return createError(CoreErrorCode.TTEUC6, this.startTokenIndex, this.position, new Object[0]);
            }
            this.position++;
        }
        ArgumentDefinitionResult argumentDefinitionResult = new ArgumentDefinitionResult();
        ErrorToken errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArgumentDefinition = advanceOverUserDefinedCommandOrEnvironmentArgumentDefinition(commandOrEnvironmentName, argumentDefinitionResult);
        if (errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArgumentDefinition != null) {
            return errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArgumentDefinition;
        }
        if (this.workingDocument.charAt(this.position) != 123) {
            return createError(CoreErrorCode.TTEUC3, this.startTokenIndex, this.position, commandOrEnvironmentName);
        }
        int i2 = this.position;
        int iFindEndCurlyBrackets = findEndCurlyBrackets(i2);
        if (iFindEndCurlyBrackets == -1) {
            return createError(CoreErrorCode.TTEUC2, this.startTokenIndex, this.workingDocument.length(), new Object[0]);
        }
        this.position = iFindEndCurlyBrackets + 1;
        skipOverCommentsAndWhitespace();
        FrozenSlice frozenSliceFreezeSlice = this.workingDocument.freezeSlice(i2 + 1, iFindEndCurlyBrackets);
        ErrorToken errorTokenCheckDefinitionArguments = checkDefinitionArguments(frozenSliceFreezeSlice, commandOrEnvironmentName, argumentDefinitionResult, CoreErrorCode.TTEUCA);
        if (errorTokenCheckDefinitionArguments != null) {
            return errorTokenCheckDefinitionArguments;
        }
        UserDefinedCommand userDefinedCommand = new UserDefinedCommand(commandOrEnvironmentName, argumentDefinitionResult.optionalArgument, argumentDefinitionResult.requiredArgumentCount, frozenSliceFreezeSlice);
        Map<String, UserDefinedCommand> userCommandMap = this.sessionContext.getUserCommandMap();
        boolean z2 = builtinCommand == CorePackageDefinitions.CMD_RENEWCOMMAND;
        boolean z3 = userCommandMap.containsKey(commandOrEnvironmentName) || this.sessionContext.getBuiltinCommandByTeXName(commandOrEnvironmentName) != null;
        if (z2 && !z3) {
            return createError(CoreErrorCode.TTEUC4, this.startTokenIndex, this.position, commandOrEnvironmentName);
        }
        if (!z2 && z3) {
            return createError(CoreErrorCode.TTEUC5, this.startTokenIndex, this.position, commandOrEnvironmentName);
        }
        userCommandMap.put(commandOrEnvironmentName, userDefinedCommand);
        return new CommandToken(this.workingDocument.freezeSlice(this.startTokenIndex, this.position), this.currentModeState.latexMode, builtinCommand);
    }

    private FlowToken finishComplexCommand(BuiltinCommand builtinCommand) {
        int i = this.startTokenIndex;
        BuiltinCommandOrEnvironmentArgumentSearchResult builtinCommandOrEnvironmentArgumentSearchResult = new BuiltinCommandOrEnvironmentArgumentSearchResult();
        ErrorToken errorTokenAdvanceOverBuiltinCommandOrEnvironmentArguments = advanceOverBuiltinCommandOrEnvironmentArguments(builtinCommand, builtinCommandOrEnvironmentArgumentSearchResult);
        return errorTokenAdvanceOverBuiltinCommandOrEnvironmentArguments != null ? errorTokenAdvanceOverBuiltinCommandOrEnvironmentArguments : new CommandToken(this.workingDocument.freezeSlice(i, this.position), this.currentModeState.latexMode, builtinCommand, builtinCommandOrEnvironmentArgumentSearchResult.optionalArgument, builtinCommandOrEnvironmentArgumentSearchResult.requiredArguments);
    }

    private FlowToken finishEndEnvironment() {
        String strAdvanceOverBracesAndEnvironmentName = advanceOverBracesAndEnvironmentName();
        if (strAdvanceOverBracesAndEnvironmentName == null) {
            return createError(CoreErrorCode.TTEE01, this.startTokenIndex, this.position, new Object[0]);
        }
        String strPeek = this.openEnvironmentStack.isEmpty() ? null : this.openEnvironmentStack.peek();
        if (strPeek == null) {
            return createError(CoreErrorCode.TTEE05, this.startTokenIndex, this.position, new Object[0]);
        }
        if (!strAdvanceOverBracesAndEnvironmentName.equals(strPeek)) {
            return createError(CoreErrorCode.TTEE00, this.startTokenIndex, this.position, strAdvanceOverBracesAndEnvironmentName, strPeek);
        }
        this.openEnvironmentStack.pop();
        UserDefinedEnvironment userDefinedEnvironment = this.sessionContext.getUserEnvironmentMap().get(strAdvanceOverBracesAndEnvironmentName);
        if (userDefinedEnvironment != null) {
            return finishEndUserDefinedEnvironment(userDefinedEnvironment);
        }
        if (this.sessionContext.getBuiltinEnvironmentByTeXName(strAdvanceOverBracesAndEnvironmentName) != null) {
            return null;
        }
        return createError(CoreErrorCode.TTEE02, this.startTokenIndex, this.position, strAdvanceOverBracesAndEnvironmentName);
    }

    private FlowToken finishEndUserDefinedEnvironment(UserDefinedEnvironment userDefinedEnvironment) {
        ErrorToken errorTokenMakeSubstitutionAndRewind = makeSubstitutionAndRewind(this.startTokenIndex, this.position, userDefinedEnvironment.getEndDefinitionSlice().extract());
        return errorTokenMakeSubstitutionAndRewind == null ? readNextToken() : errorTokenMakeSubstitutionAndRewind;
    }

    private FlowToken finishEnvironmentDefinition(BuiltinCommand builtinCommand) {
        skipOverCommentsAndWhitespace();
        String strAdvanceOverBracesAndEnvironmentName = advanceOverBracesAndEnvironmentName();
        if (strAdvanceOverBracesAndEnvironmentName == null) {
            return createError(CoreErrorCode.TTEUE0, this.startTokenIndex, this.position, new Object[0]);
        }
        if (reservedCommands.contains(strAdvanceOverBracesAndEnvironmentName)) {
            return createError(CoreErrorCode.TTEUC8, this.startTokenIndex, strAdvanceOverBracesAndEnvironmentName.length() + this.position + 2, strAdvanceOverBracesAndEnvironmentName);
        }
        skipOverCommentsAndWhitespace();
        ArgumentDefinitionResult argumentDefinitionResult = new ArgumentDefinitionResult();
        ErrorToken errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArgumentDefinition = advanceOverUserDefinedCommandOrEnvironmentArgumentDefinition(strAdvanceOverBracesAndEnvironmentName, argumentDefinitionResult);
        if (errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArgumentDefinition != null) {
            return errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArgumentDefinition;
        }
        FrozenSlice[] frozenSliceArr = new FrozenSlice[2];
        int i = 0;
        while (i < 2) {
            if (this.workingDocument.charAt(this.position) != 123) {
                return createError(CoreErrorCode.TTEUE1, this.startTokenIndex, this.position, i == 0 ? "begin" : "end", strAdvanceOverBracesAndEnvironmentName);
            }
            int i2 = this.position;
            int iFindEndCurlyBrackets = findEndCurlyBrackets(i2);
            this.position = iFindEndCurlyBrackets + 1;
            skipOverCommentsAndWhitespace();
            frozenSliceArr[i] = this.workingDocument.freezeSlice(i2 + 1, iFindEndCurlyBrackets);
            i++;
        }
        ErrorToken errorTokenCheckDefinitionArguments = checkDefinitionArguments(frozenSliceArr[0], strAdvanceOverBracesAndEnvironmentName, argumentDefinitionResult, CoreErrorCode.TTEUE5);
        if (errorTokenCheckDefinitionArguments == null) {
            errorTokenCheckDefinitionArguments = checkDefinitionArguments(frozenSliceArr[1], strAdvanceOverBracesAndEnvironmentName, null, CoreErrorCode.TTEUE6);
        }
        if (errorTokenCheckDefinitionArguments != null) {
            return errorTokenCheckDefinitionArguments;
        }
        UserDefinedEnvironment userDefinedEnvironment = new UserDefinedEnvironment(strAdvanceOverBracesAndEnvironmentName, argumentDefinitionResult.optionalArgument, argumentDefinitionResult.requiredArgumentCount, frozenSliceArr[0], frozenSliceArr[1]);
        Map<String, UserDefinedEnvironment> userEnvironmentMap = this.sessionContext.getUserEnvironmentMap();
        boolean z = builtinCommand == CorePackageDefinitions.CMD_RENEWENVIRONMENT;
        boolean z2 = userEnvironmentMap.containsKey(strAdvanceOverBracesAndEnvironmentName) || this.sessionContext.getBuiltinEnvironmentByTeXName(strAdvanceOverBracesAndEnvironmentName) != null;
        if (z && !z2) {
            return createError(CoreErrorCode.TTEUE2, this.startTokenIndex, this.position, strAdvanceOverBracesAndEnvironmentName);
        }
        if (!z && z2) {
            return createError(CoreErrorCode.TTEUE3, this.startTokenIndex, this.position, strAdvanceOverBracesAndEnvironmentName);
        }
        userEnvironmentMap.put(strAdvanceOverBracesAndEnvironmentName, userDefinedEnvironment);
        return new CommandToken(this.workingDocument.freezeSlice(this.startTokenIndex, this.position), this.currentModeState.latexMode, builtinCommand);
    }

    private FlowToken finishSimpleCommand(BuiltinCommand builtinCommand) {
        char cCharAt;
        String teXName = builtinCommand.getTeXName();
        if (teXName.length() != 1 || (((cCharAt = teXName.charAt(0)) >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
            skipOverTrailingWhitespace();
        }
        return new CommandToken(this.workingDocument.freezeSlice(this.startTokenIndex, this.position), this.currentModeState.latexMode, builtinCommand);
    }

    private FlowToken finishUserDefinedCommand(UserDefinedCommand userDefinedCommand) {
        UserDefinedCommandOrEnvironmentArgumentSearchResult userDefinedCommandOrEnvironmentArgumentSearchResult = new UserDefinedCommandOrEnvironmentArgumentSearchResult();
        ErrorToken errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArguments = advanceOverUserDefinedCommandOrEnvironmentArguments(userDefinedCommand, userDefinedCommandOrEnvironmentArgumentSearchResult);
        if (errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArguments != null) {
            return errorTokenAdvanceOverUserDefinedCommandOrEnvironmentArguments;
        }
        ErrorToken errorTokenMakeSubstitutionAndRewind = makeSubstitutionAndRewind(this.startTokenIndex, this.position, substituteArguments(userDefinedCommand.getDefinitionSlice(), userDefinedCommand, userDefinedCommandOrEnvironmentArgumentSearchResult));
        return errorTokenMakeSubstitutionAndRewind == null ? readNextToken() : errorTokenMakeSubstitutionAndRewind;
    }

    private FlowToken finishVerbToken(BuiltinCommand builtinCommand) {
        int i;
        int i2 = this.position;
        int iCharAt = this.workingDocument.charAt(i2);
        if (iCharAt == -1) {
            return createError(CoreErrorCode.TTEV00, this.startTokenIndex, i2, new Object[0]);
        }
        if (Character.isWhitespace(iCharAt)) {
            return createError(CoreErrorCode.TTEV00, this.startTokenIndex, i2 + 1, new Object[0]);
        }
        this.position++;
        List<FlowToken> list = tokeniseInNewState(TokenisationMode.BUILTIN_COMMAND_ARGUMENT, new StringTerminator(Character.toString((char) iCharAt)), LaTeXMode.VERBATIM).tokens;
        SimpleToken simpleToken = null;
        int i4 = 0;
        for (FlowToken flowToken : list) {
            if (flowToken.getType() == TokenType.VERBATIM_MODE_TEXT && simpleToken == null) {
                simpleToken = (SimpleToken) flowToken;
            } else {
                if (flowToken.getType() != TokenType.ERROR) {
                    throw new SnuggleLogicException("Unexpected token when examining \\verb content: " + flowToken);
                }
                if (((ErrorToken) flowToken).getError().getErrorCode() != CoreErrorCode.TTEG00) {
                    throw new SnuggleLogicException("Unexpected error when parsing \\verb content: " + flowToken);
                }
                i4 = 1;
            }
        }
        if (simpleToken == null) {
            throw new SnuggleLogicException("\\verb had no proper content token");
        }
        FrozenSlice slice = simpleToken.getSlice();
        int iIndexOf = this.workingDocument.indexOf(slice.startIndex, '\n');
        return (iIndexOf == -1 || iIndexOf >= (i = slice.endIndex)) ? new CommandToken(this.workingDocument.freezeSlice(this.startTokenIndex, this.position), this.currentModeState.latexMode, builtinCommand, null, new ArgumentContainerToken[]{new ArgumentContainerToken(slice, LaTeXMode.VERBATIM, list)}) : createError(CoreErrorCode.TTEV01, this.startTokenIndex, i + (i4 ^ 1), new Object[0]);
    }

    private FlowToken handleUserDefinedEnvironmentControl() {
        String strAdvanceOverBracesAndEnvironmentName = advanceOverBracesAndEnvironmentName();
        if (strAdvanceOverBracesAndEnvironmentName == null) {
            throw new SnuggleLogicException("Expected to find {envName}");
        }
        if (this.sessionContext.getUserEnvironmentMap().get(strAdvanceOverBracesAndEnvironmentName) == null) {
            throw new SnuggleLogicException("Environment is not user-defined");
        }
        this.openEnvironmentStack.push(strAdvanceOverBracesAndEnvironmentName);
        ErrorToken errorTokenMakeSubstitutionAndRewind = makeSubstitutionAndRewind(this.startTokenIndex, this.position, "");
        return errorTokenMakeSubstitutionAndRewind == null ? readNextToken() : errorTokenMakeSubstitutionAndRewind;
    }

    private ErrorToken makeSubstitutionAndRewind(int i, int i2, CharSequence charSequence) {
        int expansionLimit = this.sessionContext.getConfiguration().getExpansionLimit();
        if (expansionLimit > 0 && this.workingDocument.getSubstitutionDepth(i) >= expansionLimit) {
            return createError(CoreErrorCode.TTEU00, i, i2, Integer.valueOf(expansionLimit));
        }
        this.workingDocument.substitute(i, i2, charSequence);
        this.position = i;
        return null;
    }

    private BraceContainerToken readBraceRegion() {
        int i = this.position;
        LaTeXMode laTeXMode = this.currentModeState.latexMode;
        this.position = i + 1;
        return new BraceContainerToken(this.workingDocument.freezeSlice(i, this.position), laTeXMode, tokeniseInNewState(TokenisationMode.BRACE, new StringTerminator("}"), this.currentModeState.latexMode).tokens);
    }

    private String readCommandOrEnvironmentName(int i) {
        int iCharAt;
        int iCharAt2 = this.workingDocument.charAt(i);
        if (iCharAt2 == -1) {
            return null;
        }
        if ((iCharAt2 < 97 || iCharAt2 > 122) && (iCharAt2 < 65 || iCharAt2 > 90)) {
            return Character.toString((char) iCharAt2);
        }
        int i2 = i + 1;
        while (true) {
            iCharAt = this.workingDocument.charAt(i2);
            if ((iCharAt < 97 || iCharAt > 122) && (iCharAt < 65 || iCharAt > 90)) {
                break;
            }
            i2++;
        }
        if (iCharAt == 42) {
            i2++;
        }
        return this.workingDocument.extract(i, i2).toString();
    }

    private FlowToken readCommandOrEnvironmentOrVerb() {
        String commandOrEnvironmentName = readCommandOrEnvironmentName(this.position + 1);
        if (commandOrEnvironmentName == null) {
            throw new SnuggleLogicException("Expected caller to have picked the commandName==null case up");
        }
        this.position = AbstractC2821a.m2212c(1, this.position, commandOrEnvironmentName);
        int i = 0;
        while (true) {
            if (i >= commandOrEnvironmentName.length()) {
                commandOrEnvironmentName = " ";
                break;
            }
            if (!Character.isWhitespace(commandOrEnvironmentName.charAt(i))) {
                break;
            }
            i++;
        }
        if (commandOrEnvironmentName.equals("begin")) {
            return finishBeginEnvironment();
        }
        if (commandOrEnvironmentName.equals("end")) {
            return finishEndEnvironment();
        }
        if (commandOrEnvironmentName.equals("\u0000")) {
            return handleUserDefinedEnvironmentControl();
        }
        BuiltinCommand builtinCommand = CorePackageDefinitions.CMD_VERB;
        if (commandOrEnvironmentName.equals(builtinCommand.getTeXName())) {
            return finishVerbToken(builtinCommand);
        }
        BuiltinCommand builtinCommand2 = CorePackageDefinitions.CMD_VERBSTAR;
        return commandOrEnvironmentName.equals(builtinCommand2.getTeXName()) ? finishVerbToken(builtinCommand2) : finishCommand(commandOrEnvironmentName);
    }

    private FlowToken readDollarMath() {
        int i = this.position;
        LaTeXMode laTeXMode = this.currentModeState.latexMode;
        boolean zMatchesAt = this.workingDocument.matchesAt(i, "$$");
        String str = zMatchesAt ? "$$" : "$";
        int length = str.length() + this.position;
        this.position = length;
        TokenisationMode tokenisationMode = TokenisationMode.BUILTIN_ENVIRONMENT_CONTENT;
        StringTerminator stringTerminator = new StringTerminator(str);
        LaTeXMode laTeXMode2 = LaTeXMode.MATH;
        ModeState modeState = tokeniseInNewState(tokenisationMode, stringTerminator, laTeXMode2);
        int length2 = modeState.foundTerminator ? this.position - str.length() : this.position;
        if (!str.equals("$") || this.workingDocument.charAt(this.position) != 36) {
            return new EnvironmentToken(this.workingDocument.freezeSlice(i, this.position), laTeXMode, zMatchesAt ? CorePackageDefinitions.ENV_DISPLAYMATH : CorePackageDefinitions.ENV_MATH, new ArgumentContainerToken(this.workingDocument.freezeSlice(length, length2), laTeXMode2, modeState.tokens));
        }
        CoreErrorCode coreErrorCode = CoreErrorCode.TTEM01;
        int i2 = this.position;
        return createError(coreErrorCode, i2, i2 + 1, new Object[0]);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private FlowToken readNextMathNumberOrSymbol() {
        SimpleToken simpleTokenTryReadMathNumber = tryReadMathNumber();
        if (simpleTokenTryReadMathNumber != null) {
            return simpleTokenTryReadMathNumber;
        }
        char cCharAt = (char) this.workingDocument.charAt(this.position);
        boolean zIsHighSurrogate = Character.isHighSurrogate(cCharAt);
        int i = 1;
        int codePoint = cCharAt;
        if (zIsHighSurrogate) {
            i = 2;
            codePoint = Character.toCodePoint(cCharAt, (char) this.workingDocument.charAt(this.position + 1));
        }
        WorkingDocument workingDocument = this.workingDocument;
        int i2 = this.position;
        FrozenSlice frozenSliceFreezeSlice = workingDocument.freezeSlice(i2, i + i2);
        MathCharacter mathCharacter = this.sessionContext.getMathCharacter(codePoint);
        if (mathCharacter == null) {
            mathCharacter = new MathCharacter(codePoint, null, MathCharacter.MathCharacterType.ALPHA);
        }
        return new MathCharacterToken(frozenSliceFreezeSlice, mathCharacter);
    }

    private SimpleToken readNextSimpleTextParaMode() {
        int iCharAt;
        Terminator terminator;
        int i = this.position;
        int i2 = 0;
        while (i < this.workingDocument.length()) {
            int iCharAt2 = this.workingDocument.charAt(i);
            if (iCharAt2 == 10) {
                i2++;
            } else if (!Character.isWhitespace(iCharAt2)) {
                break;
            }
            i++;
        }
        if (i2 >= 2) {
            return new SimpleToken(this.workingDocument.freezeSlice(this.position, i), TokenType.NEW_PARAGRAPH, this.currentModeState.latexMode, TextFlowContext.ALLOW_INLINE, new Interpretation[0]);
        }
        int i4 = this.position;
        int i5 = 0;
        int i6 = -1;
        while (i4 < this.workingDocument.length() && (iCharAt = this.workingDocument.charAt(i4)) != 92 && iCharAt != 36 && iCharAt != 123 && iCharAt != 37 && iCharAt != 38 && iCharAt != 35 && iCharAt != 94 && iCharAt != 95 && ((terminator = this.currentModeState.terminator) == null || terminator.matchesAt(this.workingDocument, i4) == -1)) {
            if (Character.isWhitespace(iCharAt)) {
                if (i6 == -1) {
                    i6 = i4;
                }
                if (iCharAt == 10 && (i5 = i5 + 1) == 2) {
                    break;
                }
            } else {
                i5 = 0;
                i6 = -1;
            }
            i4++;
        }
        return i5 == 2 ? new SimpleToken(this.workingDocument.freezeSlice(this.position, i6), TokenType.TEXT_MODE_TEXT, this.currentModeState.latexMode, TextFlowContext.ALLOW_INLINE, new Interpretation[0]) : new SimpleToken(this.workingDocument.freezeSlice(this.position, i4), TokenType.TEXT_MODE_TEXT, this.currentModeState.latexMode, TextFlowContext.ALLOW_INLINE, new Interpretation[0]);
    }

    private FlowToken readNextToken() {
        FlowToken nextTokenTextMode;
        int iMatchesAt;
        LaTeXMode laTeXMode = this.currentModeState.latexMode;
        if (laTeXMode == LaTeXMode.MATH) {
            skipOverCommentsAndWhitespace();
        } else if (laTeXMode != LaTeXMode.VERBATIM) {
            skipOverComments();
        }
        Terminator terminator = this.currentModeState.terminator;
        if (terminator != null && (iMatchesAt = terminator.matchesAt(this.workingDocument, this.position)) != -1) {
            this.position = iMatchesAt;
            this.currentModeState.foundTerminator = true;
            return null;
        }
        if (this.position == this.workingDocument.length()) {
            return null;
        }
        this.startTokenIndex = this.position;
        int i = C144901.$SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[this.currentModeState.latexMode.ordinal()];
        if (i == 1 || i == 2) {
            nextTokenTextMode = readNextTokenTextMode();
        } else if (i == 3) {
            nextTokenTextMode = readNextTokenMathMode();
        } else {
            if (i != 4) {
                throw new SnuggleLogicException("Unexpected switch case " + this.currentModeState.latexMode);
            }
            nextTokenTextMode = readNextTokenVerbatimMode();
        }
        if (nextTokenTextMode != null) {
            this.position = nextTokenTextMode.getSlice().endIndex;
        }
        return nextTokenTextMode;
    }

    private FlowToken readNextTokenMathMode() {
        int iCharAt = this.workingDocument.charAt(this.position);
        if (iCharAt == -1) {
            return null;
        }
        if (iCharAt == 92) {
            return readSlashToken();
        }
        if (iCharAt == 123) {
            return readBraceRegion();
        }
        switch (iCharAt) {
            case 35:
                CoreErrorCode coreErrorCode = CoreErrorCode.TTEG04;
                int i = this.position;
                return createError(coreErrorCode, i, i + 1, new Object[0]);
            case 36:
                CoreErrorCode coreErrorCode2 = CoreErrorCode.TTEM04;
                int i2 = this.position;
                return createError(coreErrorCode2, i2, i2 + 1, new Object[0]);
            case 37:
                throw new SnuggleLogicException("Comment should be have been skipped before getting here!");
            case 38:
                WorkingDocument workingDocument = this.workingDocument;
                int i4 = this.position;
                return new SimpleToken(workingDocument.freezeSlice(i4, i4 + 1), TokenType.TAB_CHARACTER, this.currentModeState.latexMode, (TextFlowContext) null, new Interpretation[0]);
            default:
                return readNextMathNumberOrSymbol();
        }
    }

    private FlowToken readNextTokenTextMode() {
        int iCharAt = this.workingDocument.charAt(this.position);
        if (iCharAt == -1) {
            return null;
        }
        if (iCharAt == 92) {
            return readSlashToken();
        }
        if (iCharAt == 123) {
            return readBraceRegion();
        }
        if (iCharAt == 94 || iCharAt == 95) {
            CoreErrorCode coreErrorCode = CoreErrorCode.TTEM03;
            int i = this.position;
            return createError(coreErrorCode, i, i + 1, new Object[0]);
        }
        switch (iCharAt) {
            case 35:
                CoreErrorCode coreErrorCode2 = CoreErrorCode.TTEG04;
                int i2 = this.position;
                return createError(coreErrorCode2, i2, i2 + 1, new Object[0]);
            case 36:
                return readDollarMath();
            case 37:
                throw new SnuggleLogicException("Comment should be have been skipped before getting here!");
            case 38:
                WorkingDocument workingDocument = this.workingDocument;
                int i4 = this.position;
                return new SimpleToken(workingDocument.freezeSlice(i4, i4 + 1), TokenType.TAB_CHARACTER, this.currentModeState.latexMode, (TextFlowContext) null, new Interpretation[0]);
            default:
                return readNextSimpleTextParaMode();
        }
    }

    private FlowToken readNextTokenVerbatimMode() {
        Terminator terminator = this.currentModeState.terminator;
        if (terminator == null) {
            throw new SnuggleLogicException("No terminator specified for VERBATIM Mode");
        }
        int iNextMatchFrom = terminator.nextMatchFrom(this.workingDocument, this.startTokenIndex);
        if (iNextMatchFrom == -1) {
            iNextMatchFrom = this.workingDocument.length();
        }
        return new SimpleToken(this.workingDocument.freezeSlice(this.startTokenIndex, iNextMatchFrom), TokenType.VERBATIM_MODE_TEXT, LaTeXMode.VERBATIM, (TextFlowContext) null, new Interpretation[0]);
    }

    private FlowToken readSlashToken() {
        int i = this.position + 1;
        int iCharAt = this.workingDocument.charAt(i);
        if (iCharAt == -1) {
            return createError(CoreErrorCode.TTEG01, this.position, i, this.currentModeState.latexMode);
        }
        if (iCharAt != 40 && iCharAt != 91) {
            if (iCharAt != 41 && iCharAt != 93) {
                return readCommandOrEnvironmentOrVerb();
            }
            CoreErrorCode coreErrorCode = CoreErrorCode.TTEG03;
            int i2 = this.position;
            return createError(coreErrorCode, i2, i2 + 2, this.workingDocument.freezeSlice(i2, i2 + 2).extract());
        }
        LaTeXMode laTeXMode = this.currentModeState.latexMode;
        LaTeXMode laTeXMode2 = LaTeXMode.MATH;
        if (laTeXMode == laTeXMode2) {
            return createError(CoreErrorCode.TTEM00, this.position, i, new Object[0]);
        }
        int i4 = this.position;
        int i5 = i4 + 2;
        this.position = i5;
        String str = iCharAt == 40 ? "\\)" : "\\]";
        ModeState modeState = tokeniseInNewState(TokenisationMode.BUILTIN_ENVIRONMENT_CONTENT, new StringTerminator(str), laTeXMode2);
        if (!modeState.foundTerminator) {
            modeState.tokens.add(0, createError(CoreErrorCode.TTEM02, i4, this.position, "\\" + Character.valueOf((char) iCharAt), str));
        }
        return new EnvironmentToken(this.workingDocument.freezeSlice(i4, this.position), this.currentModeState.latexMode, iCharAt == 40 ? CorePackageDefinitions.ENV_MATH : CorePackageDefinitions.ENV_DISPLAYMATH, new ArgumentContainerToken(this.workingDocument.freezeSlice(i5, modeState.computeLastTokenEndIndex()), laTeXMode2, modeState.tokens));
    }

    private void skipOverComment() {
        int iCharAt;
        if (this.workingDocument.charAt(this.position) != 37) {
            return;
        }
        int i = this.position;
        do {
            i++;
            if (i >= this.workingDocument.length()) {
                break;
            }
        } while (this.workingDocument.charAt(i) != 10);
        if (this.workingDocument.charAt(i) == 10) {
            int i2 = i + 1;
            while (true) {
                if (i2 >= this.workingDocument.length() || (iCharAt = this.workingDocument.charAt(i2)) == 10) {
                    break;
                }
                if (!Character.isWhitespace(iCharAt)) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        this.position = i;
    }

    private void skipOverComments() {
        while (this.position < this.workingDocument.length() && this.workingDocument.charAt(this.position) == 37) {
            skipOverComment();
        }
    }

    private void skipOverCommentsAndWhitespace() {
        while (this.position < this.workingDocument.length()) {
            int iCharAt = this.workingDocument.charAt(this.position);
            if (iCharAt == 37) {
                skipOverComment();
            } else if (!Character.isWhitespace(iCharAt)) {
                return;
            } else {
                this.position++;
            }
        }
    }

    private void skipOverTrailingWhitespace() {
        while (this.position < this.workingDocument.length()) {
            int iCharAt = this.workingDocument.charAt(this.position);
            if (!Character.isWhitespace(iCharAt) || iCharAt == 10) {
                return;
            } else {
                this.position++;
            }
        }
    }

    private String substituteArguments(FrozenSlice frozenSlice, UserDefinedCommandOrEnvironment userDefinedCommandOrEnvironment, UserDefinedCommandOrEnvironmentArgumentSearchResult userDefinedCommandOrEnvironmentArgumentSearchResult) {
        StringBuilder sb = new StringBuilder();
        WorkingDocument document = frozenSlice.getDocument();
        boolean z = false;
        boolean z2 = false;
        for (int i = frozenSlice.startIndex; i < frozenSlice.endIndex; i++) {
            char cCharAt = (char) document.charAt(i);
            if (!z && cCharAt == '\\') {
                sb.append(cCharAt);
                z = true;
            } else if (z) {
                sb.append(cCharAt);
                z = false;
            } else if (cCharAt == '#') {
                z2 = true;
            } else if (z2) {
                int i2 = cCharAt - '0';
                if (userDefinedCommandOrEnvironment.isAllowingOptionalArgument()) {
                    i2 = cCharAt - '1';
                }
                if (i2 > 0) {
                    sb.append(userDefinedCommandOrEnvironmentArgumentSearchResult.requiredArguments[i2 - 1]);
                } else {
                    CharSequence optionalArgument = userDefinedCommandOrEnvironmentArgumentSearchResult.optionalArgument;
                    if (optionalArgument == null) {
                        optionalArgument = userDefinedCommandOrEnvironment.getOptionalArgument();
                    }
                    sb.append(optionalArgument);
                }
                z2 = false;
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private ModeState tokeniseInNewState(TokenisationMode tokenisationMode, Terminator terminator, LaTeXMode laTeXMode) {
        ModeState modeState = new ModeState(tokenisationMode, laTeXMode, this.position, terminator);
        this.currentModeState = modeState;
        this.modeStack.push(modeState);
        while (true) {
            FlowToken nextToken = readNextToken();
            if (nextToken == null) {
                break;
            }
            this.currentModeState.tokens.add(nextToken);
        }
        ModeState modeState2 = this.currentModeState;
        LaTeXMode laTeXMode2 = modeState2.latexMode;
        LaTeXMode laTeXMode3 = LaTeXMode.VERBATIM;
        if (laTeXMode2 == laTeXMode3 && modeState2.tokens.isEmpty()) {
            WorkingDocument workingDocument = this.workingDocument;
            int i = this.currentModeState.startPosition;
            this.currentModeState.tokens.add(new SimpleToken(workingDocument.freezeSlice(i, i), TokenType.VERBATIM_MODE_TEXT, laTeXMode3, (TextFlowContext) null, new Interpretation[0]));
        }
        if (terminator != null) {
            ModeState modeState3 = this.currentModeState;
            if (!modeState3.foundTerminator) {
                List<FlowToken> list = modeState3.tokens;
                CoreErrorCode coreErrorCode = CoreErrorCode.TTEG00;
                int i2 = this.position;
                list.add(createError(coreErrorCode, i2, i2, terminator));
            }
        }
        ModeState modeState4 = this.currentModeState;
        this.modeStack.pop();
        this.currentModeState = this.modeStack.isEmpty() ? null : this.modeStack.peek();
        return modeState4;
    }

    private SimpleToken tryReadMathNumber() {
        int numberEnd = this.numberMatcher.getNumberEnd(this.workingDocument, this.position);
        if (numberEnd == -1) {
            return null;
        }
        FrozenSlice frozenSliceFreezeSlice = this.workingDocument.freezeSlice(this.position, numberEnd);
        return new SimpleToken(frozenSliceFreezeSlice, TokenType.MATH_NUMBER, LaTeXMode.MATH, (TextFlowContext) null, new MathNumberInterpretation(frozenSliceFreezeSlice.extract()));
    }

    public void reset() {
        this.workingDocument = null;
        this.position = 0;
        this.startTokenIndex = -1;
        this.modeStack.clear();
        this.currentModeState = null;
        this.openEnvironmentStack.clear();
    }

    public RootToken tokenise(SnuggleInputReader snuggleInputReader) {
        reset();
        this.workingDocument = snuggleInputReader.createWorkingDocument();
        try {
            ModeState modeState = tokeniseInNewState(TokenisationMode.TOP_LEVEL, null, LaTeXMode.PARAGRAPH);
            while (!this.openEnvironmentStack.isEmpty()) {
                List<FlowToken> list = modeState.tokens;
                CoreErrorCode coreErrorCode = CoreErrorCode.TTEE04;
                int i = this.position;
                list.add(createError(coreErrorCode, i, i, this.openEnvironmentStack.pop()));
            }
            RootToken rootToken = new RootToken(this.workingDocument, modeState.tokens);
            reset();
            return rootToken;
        } catch (Throwable th) {
            reset();
            throw th;
        }
    }
}
