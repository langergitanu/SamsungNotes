package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import java.util.List;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.StyleDeclarationInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.BraceContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.RootToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class StyleEvaluator {
    private final SessionContext sessionContext;

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.internal.StyleEvaluator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144921 {
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType;

        static {
            int[] iArr = new int[TokenType.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType = iArr;
            try {
                iArr[TokenType.COMMAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.ENVIRONMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.BRACE_CONTAINER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.TEXT_MODE_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.VERBATIM_MODE_TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.LR_MODE_NEW_PARAGRAPH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.MATH_NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.MATH_CHARACTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.TAB_CHARACTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[TokenType.NEW_PARAGRAPH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public StyleEvaluator(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    private ComputedStyle mergeStyle(ComputedStyle computedStyle, StyleDeclarationInterpretation styleDeclarationInterpretation) {
        ComputedStyle.FontFamily fontFamily = styleDeclarationInterpretation.getFontFamily();
        ComputedStyle.FontSize fontSize = styleDeclarationInterpretation.getFontSize();
        if (fontFamily == null) {
            fontFamily = computedStyle.getFontFamily();
        }
        if (fontSize == null) {
            fontSize = computedStyle.getFontSize();
        }
        return new ComputedStyle(computedStyle, fontFamily, fontSize);
    }

    private ComputedStyle newStyleScope(ComputedStyle computedStyle) {
        if (computedStyle != null) {
            return new ComputedStyle(computedStyle, computedStyle.getFontFamily(), computedStyle.getFontSize());
        }
        throw new SnuggleLogicException("currentStyle should not be null");
    }

    private void visitCommand(CommandToken commandToken, ComputedStyle computedStyle) {
        ArgumentContainerToken optionalArgument = commandToken.getOptionalArgument();
        if (optionalArgument != null) {
            visitContainerContent(optionalArgument, computedStyle);
        }
        ArgumentContainerToken[] arguments = commandToken.getArguments();
        if (arguments != null) {
            for (ArgumentContainerToken argumentContainerToken : arguments) {
                visitContainerContent(argumentContainerToken, computedStyle);
            }
        }
        ArgumentContainerToken combinerTarget = commandToken.getCombinerTarget();
        if (combinerTarget != null) {
            visitContainerContent(combinerTarget, computedStyle);
        }
    }

    private void visitContainerContent(ArgumentContainerToken argumentContainerToken, ComputedStyle computedStyle) {
        argumentContainerToken.setComputedStyle(computedStyle);
        visitSiblings(argumentContainerToken.getContents(), computedStyle);
    }

    private void visitEnvironment(EnvironmentToken environmentToken, ComputedStyle computedStyle) {
        ArgumentContainerToken optionalArgument = environmentToken.getOptionalArgument();
        if (optionalArgument != null) {
            visitContainerContent(optionalArgument, computedStyle);
        }
        ArgumentContainerToken[] arguments = environmentToken.getArguments();
        if (arguments != null) {
            for (ArgumentContainerToken argumentContainerToken : arguments) {
                visitContainerContent(argumentContainerToken, computedStyle);
            }
        }
        LaTeXMode contentMode = environmentToken.getEnvironment().getContentMode();
        LaTeXMode laTeXMode = LaTeXMode.MATH;
        if (contentMode == laTeXMode && environmentToken.getLatexMode() != laTeXMode) {
            computedStyle = new ComputedStyle(computedStyle, ComputedStyle.FontFamily.NORMAL, computedStyle.getFontSize());
        }
        visitContainerContent(environmentToken.getContent(), computedStyle);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void visitSiblings(List<FlowToken> list, ComputedStyle computedStyle) {
        int size;
        int i = 0;
        while (i < list.size()) {
            FlowToken flowToken = list.get(i);
            InterpretationType interpretationType = InterpretationType.STYLE_DECLARATION;
            if (flowToken.hasInterpretationType(interpretationType)) {
                ComputedStyle computedStyleMergeStyle = mergeStyle(computedStyle, (StyleDeclarationInterpretation) flowToken.getInterpretation(interpretationType));
                if (flowToken instanceof CommandToken) {
                    CommandToken commandToken = (CommandToken) flowToken;
                    if (commandToken.getCommand().getArgumentCount() == 0) {
                        list.remove(i);
                        computedStyle = computedStyleMergeStyle;
                    } else {
                        ArgumentContainerToken argumentContainerToken = commandToken.getArguments()[0];
                        visitContainerContent(argumentContainerToken, computedStyleMergeStyle);
                        list.remove(i);
                        list.addAll(i, argumentContainerToken.getContents());
                        size = argumentContainerToken.getContents().size();
                    }
                } else {
                    if (!(flowToken instanceof EnvironmentToken)) {
                        throw new SnuggleLogicException("Unexpected logic branch");
                    }
                    ArgumentContainerToken content = ((EnvironmentToken) flowToken).getContent();
                    visitContainerContent(content, computedStyleMergeStyle);
                    list.remove(i);
                    list.addAll(i, content.getContents());
                    size = content.getContents().size();
                }
                i += size;
            } else {
                flowToken.setComputedStyle(computedStyle);
                switch (C144921.$SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[flowToken.getType().ordinal()]) {
                    case 1:
                        visitCommand((CommandToken) flowToken, computedStyle);
                        i++;
                        break;
                    case 2:
                        visitEnvironment((EnvironmentToken) flowToken, computedStyle);
                        i++;
                        break;
                    case 3:
                        visitSiblings(((BraceContainerToken) flowToken).getContents(), newStyleScope(computedStyle));
                        i++;
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        i++;
                        break;
                    default:
                        throw new SnuggleLogicException("Unhandled/unexpected TokenType " + flowToken.getType());
                }
            }
        }
    }

    public void evaluateStyles(RootToken rootToken) {
        ComputedStyle computedStyle = ComputedStyle.DEFAULT_STYLE;
        rootToken.setComputedStyle(computedStyle);
        visitSiblings(rootToken.getContents(), computedStyle);
    }
}
