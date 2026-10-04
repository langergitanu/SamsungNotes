package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import p001A.AbstractC0000a;
import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathBracketInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathNumberInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.BraceContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ErrorToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.RootToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.SimpleToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.Token;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class TokenFixer {
    private final SessionContext sessionContext;

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.internal.TokenFixer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144941 {
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode;

        /* JADX INFO: renamed from: $SwitchMap$uk$ac$ed$ph$snuggletex$semantics$MathBracketInterpretation$BracketType */
        static final /* synthetic */ int[] f10299x26cf049a;
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType;

        static {
            int[] iArr = new int[MathBracketInterpretation.BracketType.values().length];
            f10299x26cf049a = iArr;
            try {
                iArr[MathBracketInterpretation.BracketType.OPENER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10299x26cf049a[MathBracketInterpretation.BracketType.OPENER_OR_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10299x26cf049a[MathBracketInterpretation.BracketType.CLOSER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[TokenType.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType = iArr2;
            try {
                iArr2[TokenType.ARGUMENT_CONTAINER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.COMMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.ENVIRONMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.BRACE_CONTAINER.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.TEXT_MODE_TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.VERBATIM_MODE_TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.LR_MODE_NEW_PARAGRAPH.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.MATH_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.MATH_CHARACTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.TAB_CHARACTER.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.NEW_PARAGRAPH.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[LaTeXMode.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode = iArr3;
            try {
                iArr3[LaTeXMode.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[LaTeXMode.LR.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[LaTeXMode.MATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[LaTeXMode.VERBATIM.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public TokenFixer(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    private CommandToken buildGroupedCommandToken(Token token, BuiltinCommand builtinCommand, List<? extends FlowToken> list, ComputedStyle computedStyle) {
        ArgumentContainerToken argumentContainerTokenCreateEmptyContainer = list.isEmpty() ? ArgumentContainerToken.createEmptyContainer(token, token.getLatexMode(), computedStyle) : ArgumentContainerToken.createFromContiguousTokens(token, list.get(0).getLatexMode(), list, computedStyle);
        CommandToken commandToken = new CommandToken(argumentContainerTokenCreateEmptyContainer.getSlice(), argumentContainerTokenCreateEmptyContainer.getLatexMode(), builtinCommand, null, new ArgumentContainerToken[]{argumentContainerTokenCreateEmptyContainer});
        commandToken.setComputedStyle(computedStyle);
        list.clear();
        return commandToken;
    }

    private ErrorToken createError(FlowToken flowToken, CoreErrorCode coreErrorCode, Object... objArr) {
        InputError inputError = new InputError(coreErrorCode, flowToken.getSlice(), objArr);
        this.sessionContext.registerError(inputError);
        ErrorToken errorToken = new ErrorToken(inputError, flowToken.getLatexMode());
        errorToken.setComputedStyle(flowToken.getComputedStyle());
        return errorToken;
    }

    private void fencePairedParentheses(Token token, List<FlowToken> list) {
        CommandToken commandToken;
        for (int i = 0; i < list.size(); i++) {
            FlowToken flowToken = list.get(i);
            if (flowToken.isCommand(CorePackageDefinitions.CMD_RIGHT)) {
                replaceToken(list, i, createError(flowToken, CoreErrorCode.TFEM03, new Object[0]));
            } else if (flowToken.isCommand(CorePackageDefinitions.CMD_LEFT)) {
                ArrayList arrayList = new ArrayList();
                CommandToken commandToken2 = (CommandToken) flowToken;
                int i2 = i + 1;
                int i4 = 1;
                while (true) {
                    if (i2 >= list.size()) {
                        i2 = -1;
                        commandToken = null;
                        break;
                    }
                    FlowToken flowToken2 = list.get(i2);
                    if (!flowToken2.isCommand(CorePackageDefinitions.CMD_LEFT)) {
                        if (flowToken2.isCommand(CorePackageDefinitions.CMD_RIGHT) && i4 - 1 == 0) {
                            commandToken = (CommandToken) flowToken2;
                            break;
                        }
                    } else {
                        i4++;
                    }
                    arrayList.add(flowToken2);
                    i2++;
                }
                if (commandToken == null) {
                    replaceTokens(list, i, list.size(), createError(flowToken, CoreErrorCode.TFEM04, new Object[0]));
                    return;
                } else {
                    FrozenSlice frozenSliceRightOuterSpan = commandToken2.getSlice().rightOuterSpan(commandToken.getSlice());
                    LaTeXMode laTeXMode = LaTeXMode.MATH;
                    replaceTokens(list, i, i2 + 1, new EnvironmentToken(frozenSliceRightOuterSpan, laTeXMode, CorePackageDefinitions.ENV_BRACKETED, null, new ArgumentContainerToken[]{ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode, commandToken2.getCombinerTarget().getContents(), commandToken2.getComputedStyle()), ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode, commandToken.getCombinerTarget().getContents(), commandToken.getComputedStyle())}, ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode, arrayList, commandToken2.getComputedStyle())));
                }
            } else {
                continue;
            }
        }
    }

    private void fixLeadingNegativeNumber(List<FlowToken> list) {
        if (list.size() < 2) {
            return;
        }
        FlowToken flowToken = list.get(0);
        FlowToken flowToken2 = list.get(1);
        if (flowToken.getMathCharacterCodePoint() == 45) {
            InterpretationType interpretationType = InterpretationType.MATH_NUMBER;
            if (flowToken2.hasInterpretationType(interpretationType)) {
                replaceTokens(list, 0, 2, new SimpleToken(flowToken.getSlice().rightOuterSpan(flowToken2.getSlice()), TokenType.MATH_NUMBER, flowToken.getLatexMode(), (TextFlowContext) null, new MathNumberInterpretation(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + ((Object) ((MathNumberInterpretation) flowToken2.getInterpretation(interpretationType)).getNumber()))));
            }
        }
    }

    private void fixListEnvironmentContent(EnvironmentToken environmentToken) {
        List<FlowToken> contents = environmentToken.getContent().getContents();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = contents.size();
        CommandToken commandToken = null;
        for (int i = 0; i < size; i++) {
            FlowToken flowToken = contents.get(i);
            if (flowToken.isCommand(CorePackageDefinitions.CMD_ITEM)) {
                if (commandToken != null) {
                    arrayList2.add(buildGroupedCommandToken(environmentToken, CorePackageDefinitions.CMD_LIST_ITEM, arrayList, commandToken.getComputedStyle()));
                }
                commandToken = (CommandToken) flowToken;
            } else if (commandToken != null) {
                arrayList.add(flowToken);
            } else if ((flowToken.getType() != TokenType.TEXT_MODE_TEXT || !flowToken.getSlice().isWhitespace()) && flowToken.getType() != TokenType.NEW_PARAGRAPH) {
                arrayList2.add(createError(flowToken, CoreErrorCode.TFEL00, new Object[0]));
            }
        }
        if (commandToken != null) {
            arrayList2.add(buildGroupedCommandToken(environmentToken, CorePackageDefinitions.CMD_LIST_ITEM, arrayList, commandToken.getComputedStyle()));
        }
        contents.clear();
        contents.addAll(arrayList2);
    }

    private void fixOverInstances(Token token, List<FlowToken> list) {
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            FlowToken flowToken = list.get(i2);
            if (flowToken.isCommand(CorePackageDefinitions.CMD_OVER)) {
                if (i != -1) {
                    list.clear();
                    list.add(createError(flowToken, CoreErrorCode.TFEM00, new Object[0]));
                    return;
                }
                i = i2;
            }
        }
        if (i != -1) {
            ArrayList arrayList = new ArrayList(list.subList(0, i));
            ArrayList arrayList2 = new ArrayList(list.subList(i + 1, list.size()));
            ComputedStyle computedStyle = list.get(0).getComputedStyle();
            FrozenSlice slice = token.getSlice();
            LaTeXMode laTeXMode = LaTeXMode.MATH;
            replaceTokens(list, 0, list.size(), new CommandToken(slice, laTeXMode, CorePackageDefinitions.CMD_FRAC, null, new ArgumentContainerToken[]{ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode, arrayList, computedStyle), ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode, arrayList2, computedStyle)}));
        }
    }

    private void fixPrimes(List<FlowToken> list) {
        int i = 0;
        while (i < list.size() - 1) {
            int i2 = i + 1;
            FlowToken flowToken = list.get(i2);
            if (flowToken.getMathCharacterCodePoint() == 39) {
                FlowToken flowToken2 = list.get(i);
                FrozenSlice frozenSliceRightOuterSpan = flowToken2.getSlice().rightOuterSpan(flowToken.getSlice());
                LaTeXMode laTeXMode = LaTeXMode.MATH;
                replaceTokens(list, i, i + 2, new CommandToken(frozenSliceRightOuterSpan, laTeXMode, CorePackageDefinitions.CMD_MSUP_OR_MOVER, null, new ArgumentContainerToken[]{ArgumentContainerToken.createFromSingleToken(laTeXMode, flowToken2), ArgumentContainerToken.createFromSingleToken(laTeXMode, flowToken)}));
            }
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void fixSubscriptAndSuperscripts(Token token, List<FlowToken> list) {
        int i;
        FlowToken flowToken;
        ArgumentContainerToken argumentContainerTokenCreateFromSingleToken;
        int i2;
        ArgumentContainerToken argumentContainerTokenCreateFromSingleToken2;
        FlowToken flowToken2;
        int i4;
        int i5 = 0;
        int i6 = 0;
        while (i6 < list.size()) {
            int size = list.size();
            FlowToken flowToken3 = list.get(i6);
            int mathCharacterCodePoint = flowToken3.getMathCharacterCodePoint();
            int i7 = mathCharacterCodePoint == 94 ? 1 : i5;
            if (i7 == 0 && mathCharacterCodePoint != 95) {
                i2 = i6;
                i4 = i5;
            } else if (i6 == size - 1) {
                replaceToken(list, i6, createError(flowToken3, CoreErrorCode.TFEM01, new Object[i5]));
                i2 = i6;
                i4 = i5;
            } else {
                if (i6 == 0) {
                    flowToken = flowToken3;
                    argumentContainerTokenCreateFromSingleToken = ArgumentContainerToken.createEmptyContainer(token, LaTeXMode.MATH, list.get(i5).getComputedStyle());
                    i = i6;
                } else {
                    i = i6 - 1;
                    flowToken = list.get(i);
                    argumentContainerTokenCreateFromSingleToken = ArgumentContainerToken.createFromSingleToken(LaTeXMode.MATH, flowToken);
                }
                FlowToken flowToken4 = list.get(i6 + 1);
                LaTeXMode laTeXMode = LaTeXMode.MATH;
                ArgumentContainerToken argumentContainerTokenCreateFromSingleToken3 = ArgumentContainerToken.createFromSingleToken(laTeXMode, flowToken4);
                int i8 = i6 + 2;
                if (i8 < size) {
                    i2 = i6;
                    int mathCharacterCodePoint2 = list.get(i8).getMathCharacterCodePoint();
                    if (mathCharacterCodePoint2 == 95 || mathCharacterCodePoint2 == 94) {
                        int i9 = i2 + 3;
                        if (i9 >= size) {
                            replaceTokens(list, i, i9, createError(flowToken3, CoreErrorCode.TFEM01, new Object[0]));
                            i4 = 0;
                        } else {
                            FlowToken flowToken5 = list.get(i9);
                            argumentContainerTokenCreateFromSingleToken2 = ArgumentContainerToken.createFromSingleToken(laTeXMode, flowToken5);
                            if ((mathCharacterCodePoint == 94 && mathCharacterCodePoint2 == 94) || (mathCharacterCodePoint == 95 && mathCharacterCodePoint2 == 95)) {
                                i4 = 0;
                                replaceTokens(list, i, i9, createError(flowToken3, CoreErrorCode.TFEM02, new Object[0]));
                            } else {
                                i4 = 0;
                                flowToken2 = flowToken5;
                            }
                        }
                    }
                    if (flowToken2 == null) {
                        FrozenSlice frozenSliceRightOuterSpan = flowToken.getSlice().rightOuterSpan(flowToken2.getSlice());
                        ArgumentContainerToken argumentContainerToken = argumentContainerTokenCreateFromSingleToken2;
                        BuiltinCommand builtinCommand = CorePackageDefinitions.CMD_MSUBSUP_OR_MUNDEROVER;
                        ArgumentContainerToken argumentContainerToken2 = i7 != 0 ? argumentContainerToken : argumentContainerTokenCreateFromSingleToken3;
                        if (i7 == 0) {
                            argumentContainerTokenCreateFromSingleToken3 = argumentContainerToken;
                        }
                        replaceTokens(list, i, i2 + 4, new CommandToken(frozenSliceRightOuterSpan, laTeXMode, builtinCommand, null, new ArgumentContainerToken[]{argumentContainerTokenCreateFromSingleToken, argumentContainerToken2, argumentContainerTokenCreateFromSingleToken3}));
                    } else {
                        replaceTokens(list, i, i8, new CommandToken(flowToken.getSlice().rightOuterSpan(flowToken4.getSlice()), laTeXMode, i7 != 0 ? CorePackageDefinitions.CMD_MSUP_OR_MOVER : CorePackageDefinitions.CMD_MSUB_OR_MUNDER, null, new ArgumentContainerToken[]{argumentContainerTokenCreateFromSingleToken, argumentContainerTokenCreateFromSingleToken3}));
                    }
                } else {
                    i2 = i6;
                }
                i4 = 0;
                flowToken2 = null;
                argumentContainerTokenCreateFromSingleToken2 = null;
                if (flowToken2 == null) {
                }
            }
            int i10 = i4;
            i6 = i2 + 1;
            i5 = i10;
        }
    }

    private void fixTabularEnvironmentContent(EnvironmentToken environmentToken) {
        List list;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        List<FlowToken> contents = environmentToken.getContent().getContents();
        if (contents.size() <= 0 || ((FlowToken) AbstractC0000a.m10g(contents, 1)).isCommand(CorePackageDefinitions.CMD_CHAR_BACKSLASH)) {
            list = contents;
        } else {
            ArrayList arrayList4 = new ArrayList(contents);
            arrayList4.add(null);
            list = arrayList4;
        }
        int size = list.size();
        ComputedStyle computedStyle = null;
        FlowToken flowToken = null;
        int i = 0;
        while (i < size) {
            FlowToken flowToken2 = (FlowToken) list.get(i);
            if (computedStyle == null) {
                computedStyle = flowToken2 != null ? flowToken2.getComputedStyle() : i > 0 ? ((FlowToken) list.get(0)).getComputedStyle() : environmentToken.getComputedStyle();
            }
            if (flowToken2 == null || flowToken2.isCommand(CorePackageDefinitions.CMD_CHAR_BACKSLASH)) {
                if (flowToken2 == null && flowToken != null && flowToken.isCommand(CorePackageDefinitions.CMD_HLINE)) {
                    break;
                }
                arrayList2.add(buildGroupedCommandToken(environmentToken, CorePackageDefinitions.CMD_TABLE_COLUMN, arrayList3, computedStyle));
                arrayList.add(buildGroupedCommandToken(environmentToken, CorePackageDefinitions.CMD_TABLE_ROW, arrayList2, ((CommandToken) arrayList2.get(0)).getComputedStyle()));
            } else if (flowToken2.getType() == TokenType.TEXT_MODE_TEXT && flowToken2.getSlice().isWhitespace()) {
                i++;
            } else if (flowToken2.getType() == TokenType.TAB_CHARACTER) {
                arrayList2.add(buildGroupedCommandToken(environmentToken, CorePackageDefinitions.CMD_TABLE_COLUMN, arrayList3, computedStyle));
                computedStyle = null;
            } else if (flowToken2.isCommand(CorePackageDefinitions.CMD_HLINE)) {
                if (!arrayList3.isEmpty()) {
                    arrayList.add(createError((FlowToken) arrayList3.get(0), CoreErrorCode.TFETB0, new Object[0]));
                    arrayList3.clear();
                } else if (!arrayList2.isEmpty()) {
                    arrayList.add(createError((FlowToken) arrayList2.get(0), CoreErrorCode.TFETB0, new Object[0]));
                    arrayList2.clear();
                }
                arrayList.add(flowToken2);
            } else {
                arrayList3.add(flowToken2);
            }
            flowToken = flowToken2;
            i++;
        }
        contents.clear();
        contents.addAll(arrayList);
    }

    private void flattenBraceContainers(List<FlowToken> list) {
        int i = 0;
        while (i < list.size()) {
            FlowToken flowToken = list.get(i);
            if (flowToken.getType() == TokenType.BRACE_CONTAINER) {
                List<FlowToken> contents = ((BraceContainerToken) flowToken).getContents();
                list.remove(i);
                list.addAll(i, contents);
            } else {
                i++;
            }
        }
    }

    private void inferParagraphs(List<FlowToken> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<FlowToken> arrayList2 = new ArrayList();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            FlowToken flowToken = list.get(i2);
            if (flowToken.getType() == TokenType.NEW_PARAGRAPH || flowToken.isCommand(CorePackageDefinitions.CMD_PAR)) {
                if (!arrayList.isEmpty()) {
                    arrayList2.add(buildGroupedCommandToken(flowToken, CorePackageDefinitions.CMD_PARAGRAPH, arrayList, ((FlowToken) arrayList.get(0)).getComputedStyle()));
                    i++;
                }
            } else if (flowToken.getTextFlowContext() == TextFlowContext.START_NEW_XHTML_BLOCK) {
                if (!arrayList.isEmpty()) {
                    arrayList2.add(buildGroupedCommandToken(list.get(0), CorePackageDefinitions.CMD_PARAGRAPH, arrayList, ((FlowToken) arrayList.get(0)).getComputedStyle()));
                    i++;
                }
                arrayList2.add(flowToken);
            } else {
                if (flowToken.getTextFlowContext() == TextFlowContext.IGNORE && arrayList.isEmpty()) {
                    arrayList2.add(flowToken);
                } else {
                    arrayList.add(flowToken);
                }
            }
            z = true;
        }
        if (z) {
            if (!arrayList.isEmpty()) {
                arrayList2.add(buildGroupedCommandToken(list.get(0), CorePackageDefinitions.CMD_PARAGRAPH, arrayList, ((FlowToken) arrayList.get(0)).getComputedStyle()));
                i++;
            }
            list.clear();
            if (i > 1) {
                list.addAll(arrayList2);
                return;
            }
            for (FlowToken flowToken2 : arrayList2) {
                if (flowToken2.isCommand(CorePackageDefinitions.CMD_PARAGRAPH)) {
                    list.addAll(((CommandToken) flowToken2).getArguments()[0].getContents());
                } else {
                    list.add(flowToken2);
                }
            }
        }
    }

    private void inferParenthesisFences(Token token, List<FlowToken> list) {
        FlowToken flowToken;
        int i = 0;
        while (i < list.size()) {
            FlowToken flowToken2 = list.get(i);
            InterpretationType interpretationType = InterpretationType.MATH_BRACKET;
            if (flowToken2.hasInterpretationType(interpretationType)) {
                MathBracketInterpretation mathBracketInterpretation = (MathBracketInterpretation) flowToken2.getInterpretation(interpretationType);
                if (mathBracketInterpretation.isPairingInferencePossible()) {
                    MathBracketInterpretation.BracketType bracketType = mathBracketInterpretation.getBracketType();
                    if (bracketType == MathBracketInterpretation.BracketType.CLOSER) {
                        FrozenSlice frozenSliceRightOuterSpan = list.get(0).getSlice().rightOuterSpan(flowToken2.getSlice());
                        ArrayList arrayList = new ArrayList(list.subList(0, i));
                        LaTeXMode laTeXMode = LaTeXMode.MATH;
                        replaceTokens(list, 0, i + 1, new EnvironmentToken(frozenSliceRightOuterSpan, laTeXMode, CorePackageDefinitions.ENV_BRACKETED, null, new ArgumentContainerToken[]{ArgumentContainerToken.createEmptyContainer(token, laTeXMode, list.get(0).getComputedStyle()), ArgumentContainerToken.createFromSingleToken(laTeXMode, flowToken2)}, ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode, arrayList, list.get(0).getComputedStyle())));
                        i = 0;
                    } else if (bracketType != MathBracketInterpretation.BracketType.OPENER_OR_CLOSER) {
                        ArrayList arrayList2 = new ArrayList();
                        Stack stack = new Stack();
                        stack.add(mathBracketInterpretation);
                        int i2 = i + 1;
                        while (true) {
                            if (i2 >= list.size()) {
                                flowToken = null;
                                i2 = -1;
                                break;
                            }
                            flowToken = list.get(i2);
                            InterpretationType interpretationType2 = InterpretationType.MATH_BRACKET;
                            if (flowToken.hasInterpretationType(interpretationType2)) {
                                MathBracketInterpretation mathBracketInterpretation2 = (MathBracketInterpretation) flowToken.getInterpretation(interpretationType2);
                                int i4 = C144941.f10299x26cf049a[mathBracketInterpretation2.getBracketType().ordinal()];
                                if (i4 == 1) {
                                    stack.add(mathBracketInterpretation2);
                                } else if (i4 != 3) {
                                    continue;
                                } else {
                                    stack.pop();
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                            arrayList2.add(flowToken);
                            i2++;
                        }
                        if (flowToken != null) {
                            FrozenSlice frozenSliceRightOuterSpan2 = flowToken2.getSlice().rightOuterSpan(flowToken.getSlice());
                            LaTeXMode laTeXMode2 = LaTeXMode.MATH;
                            replaceTokens(list, i, i2 + 1, new EnvironmentToken(frozenSliceRightOuterSpan2, laTeXMode2, CorePackageDefinitions.ENV_BRACKETED, null, new ArgumentContainerToken[]{ArgumentContainerToken.createFromSingleToken(laTeXMode2, flowToken2), ArgumentContainerToken.createFromSingleToken(laTeXMode2, flowToken)}, ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode2, arrayList2, flowToken2.getComputedStyle())));
                        } else {
                            FrozenSlice frozenSliceRightOuterSpan3 = flowToken2.getSlice().rightOuterSpan(((FlowToken) AbstractC0000a.m10g(list, 1)).getSlice());
                            LaTeXMode laTeXMode3 = LaTeXMode.MATH;
                            replaceTokens(list, i, list.size(), new EnvironmentToken(frozenSliceRightOuterSpan3, laTeXMode3, CorePackageDefinitions.ENV_BRACKETED, null, new ArgumentContainerToken[]{ArgumentContainerToken.createFromSingleToken(laTeXMode3, flowToken2), ArgumentContainerToken.createEmptyContainer(token, laTeXMode3, flowToken2.getComputedStyle())}, ArgumentContainerToken.createFromContiguousTokens(token, laTeXMode3, arrayList2, flowToken2.getComputedStyle())));
                        }
                    }
                }
            }
            i++;
        }
    }

    private void replaceToken(List<FlowToken> list, int i, FlowToken flowToken) {
        flowToken.setComputedStyle(list.get(i).getComputedStyle());
        list.set(i, flowToken);
    }

    private void replaceTokens(List<FlowToken> list, int i, int i2, FlowToken flowToken) {
        replaceToken(list, i, flowToken);
        int i4 = i + 1;
        if (i2 > i4) {
            list.subList(i4, i2).clear();
        }
    }

    private void stripBlocks(List<FlowToken> list) {
        for (int i = 0; i < list.size(); i++) {
            FlowToken flowToken = list.get(i);
            if (flowToken.getType() == TokenType.NEW_PARAGRAPH || flowToken.isCommand(CorePackageDefinitions.CMD_PAR)) {
                replaceToken(list, i, new SimpleToken(flowToken.getSlice(), TokenType.LR_MODE_NEW_PARAGRAPH, LaTeXMode.LR, TextFlowContext.ALLOW_INLINE, new Interpretation[0]));
            } else if (flowToken.getType() != TokenType.ERROR && flowToken.getTextFlowContext() == TextFlowContext.START_NEW_XHTML_BLOCK) {
                replaceToken(list, i, createError(flowToken, CoreErrorCode.TFEG00, flowToken.getSlice().extract().toString()));
            }
        }
    }

    private void stripRedundantWhitespaceTokens(List<FlowToken> list) {
        int i = 0;
        while (i < list.size()) {
            FlowToken flowToken = list.get(i);
            if (flowToken.getType() == TokenType.TEXT_MODE_TEXT) {
                boolean z = true;
                if ((i == 0 || i == list.size() - 1) && flowToken.getSlice().isWhitespace()) {
                    list.remove(i);
                } else {
                    boolean z2 = i == 0 || list.get(i + (-1)).getTextFlowContext() == TextFlowContext.START_NEW_XHTML_BLOCK;
                    if (i != list.size() - 1 && list.get(i + 1).getTextFlowContext() != TextFlowContext.START_NEW_XHTML_BLOCK) {
                        z = false;
                    }
                    if (z2 && z && flowToken.getSlice().isWhitespace()) {
                        list.remove(i);
                    }
                }
            }
            i++;
        }
    }

    private void visitChildren(List<FlowToken> list) {
        Iterator<FlowToken> it = list.iterator();
        while (it.hasNext()) {
            visitToken(it.next());
        }
    }

    private void visitCommand(CommandToken commandToken) {
        ArgumentContainerToken optionalArgument = commandToken.getOptionalArgument();
        if (optionalArgument != null) {
            visitContainerContent(optionalArgument);
        }
        ArgumentContainerToken[] arguments = commandToken.getArguments();
        if (arguments != null) {
            for (ArgumentContainerToken argumentContainerToken : arguments) {
                visitContainerContent(argumentContainerToken);
            }
        }
    }

    private void visitContainerContent(ArgumentContainerToken argumentContainerToken) {
        visitSiblings(argumentContainerToken, argumentContainerToken.getContents());
    }

    private void visitEnvironment(EnvironmentToken environmentToken) {
        BuiltinEnvironment environment = environmentToken.getEnvironment();
        if (environment.hasInterpretation(InterpretationType.LIST)) {
            fixListEnvironmentContent(environmentToken);
        } else if (environment.hasInterpretation(InterpretationType.TABULAR)) {
            fixTabularEnvironmentContent(environmentToken);
        }
        if (environment != CorePackageDefinitions.ENV_BRACKETED) {
            ArgumentContainerToken optionalArgument = environmentToken.getOptionalArgument();
            if (optionalArgument != null) {
                visitContainerContent(optionalArgument);
            }
            ArgumentContainerToken[] arguments = environmentToken.getArguments();
            if (arguments != null) {
                for (ArgumentContainerToken argumentContainerToken : arguments) {
                    visitContainerContent(argumentContainerToken);
                }
            }
        }
        visitContainerContent(environmentToken.getContent());
    }

    private void visitSiblings(Token token, List<FlowToken> list) {
        while (list.size() == 1 && list.get(0).getType() == TokenType.BRACE_CONTAINER) {
            List<FlowToken> contents = ((BraceContainerToken) list.get(0)).getContents();
            list.clear();
            list.addAll(contents);
        }
        int i = C144941.$SwitchMap$uk$ac$ed$ph$snuggletex$definitions$LaTeXMode[token.getLatexMode().ordinal()];
        if (i == 1) {
            visitSiblingsParagraphMode(list);
            return;
        }
        if (i == 2) {
            visitSiblingsLRMode(list);
            return;
        }
        if (i == 3) {
            visitSiblingsMathMode(token, list);
        } else {
            if (i == 4) {
                return;
            }
            throw new SnuggleLogicException("Unhandled mode " + token.getLatexMode());
        }
    }

    private void visitSiblingsLRMode(List<FlowToken> list) {
        flattenBraceContainers(list);
        stripBlocks(list);
        visitChildren(list);
    }

    private void visitSiblingsMathMode(Token token, List<FlowToken> list) {
        BuiltinCommand command;
        if (list.isEmpty()) {
            return;
        }
        FlowToken flowToken = list.get(0);
        if (flowToken.getType() != TokenType.COMMAND || ((command = ((CommandToken) flowToken).getCommand()) != CorePackageDefinitions.CMD_TABLE_ROW && command != CorePackageDefinitions.CMD_TABLE_COLUMN)) {
            fixLeadingNegativeNumber(list);
            fencePairedParentheses(token, list);
            fixOverInstances(token, list);
            inferParenthesisFences(token, list);
            fixSubscriptAndSuperscripts(token, list);
            fixPrimes(list);
        }
        visitChildren(list);
    }

    private void visitSiblingsParagraphMode(List<FlowToken> list) {
        flattenBraceContainers(list);
        stripRedundantWhitespaceTokens(list);
        inferParagraphs(list);
        visitChildren(list);
    }

    private void visitToken(Token token) {
        switch (C144941.$SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[token.getType().ordinal()]) {
            case 1:
                visitContainerContent((ArgumentContainerToken) token);
                return;
            case 2:
                visitCommand((CommandToken) token);
                return;
            case 3:
                visitEnvironment((EnvironmentToken) token);
                return;
            case 4:
                BraceContainerToken braceContainerToken = (BraceContainerToken) token;
                visitSiblings(braceContainerToken, braceContainerToken.getContents());
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return;
            case 12:
                throw new SnuggleLogicException("Unfixed " + token.getType() + " token: " + token);
            default:
                throw new SnuggleLogicException("Unhandled/unexpected TokenType " + token.getType());
        }
    }

    public void fixTokenTree(RootToken rootToken) {
        visitSiblings(rootToken, rootToken.getContents());
    }
}
