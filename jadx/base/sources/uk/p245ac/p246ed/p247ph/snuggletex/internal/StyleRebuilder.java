package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import java.util.ArrayList;
import java.util.List;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.BraceContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.RootToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class StyleRebuilder {
    private final SessionContext sessionContext;

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.internal.StyleRebuilder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144931 {
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

    public StyleRebuilder(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    private EnvironmentToken createStyleEnvironmentToken(FlowToken flowToken, List<FlowToken> list) {
        return createStyleEnvironmentToken(flowToken, ArgumentContainerToken.createFromContiguousTokens(flowToken, flowToken.getLatexMode(), list, flowToken.getComputedStyle()));
    }

    private void visitArgumentContainer(FlowToken flowToken, ArgumentContainerToken argumentContainerToken, ComputedStyle computedStyle) {
        List<FlowToken> contents = argumentContainerToken.getContents();
        if (flowToken.hasInterpretationType(InterpretationType.STYLE_SENTINEL)) {
            visitSiblings(contents, computedStyle);
        } else {
            visitSiblings(contents, argumentContainerToken.getComputedStyle());
        }
    }

    private void visitCommand(CommandToken commandToken, ComputedStyle computedStyle) {
        ArgumentContainerToken optionalArgument = commandToken.getOptionalArgument();
        if (optionalArgument != null) {
            visitArgumentContainer(commandToken, optionalArgument, computedStyle);
        }
        ArgumentContainerToken[] arguments = commandToken.getArguments();
        if (arguments != null) {
            for (ArgumentContainerToken argumentContainerToken : arguments) {
                visitArgumentContainer(commandToken, argumentContainerToken, computedStyle);
            }
        }
    }

    private void visitEnvironment(EnvironmentToken environmentToken, ComputedStyle computedStyle) {
        ArgumentContainerToken optionalArgument = environmentToken.getOptionalArgument();
        if (optionalArgument != null) {
            visitArgumentContainer(environmentToken, optionalArgument, computedStyle);
        }
        ArgumentContainerToken[] arguments = environmentToken.getArguments();
        if (arguments != null) {
            for (ArgumentContainerToken argumentContainerToken : arguments) {
                visitArgumentContainer(environmentToken, argumentContainerToken, computedStyle);
            }
        }
        visitArgumentContainer(environmentToken, environmentToken.getContent(), computedStyle);
    }

    private void visitSiblings(List<FlowToken> list, ComputedStyle computedStyle) {
        ComputedStyle computedStyle2 = computedStyle;
        for (int i = 0; i < list.size(); i++) {
            FlowToken flowTokenCreateStyleEnvironmentToken = list.get(i);
            if (flowTokenCreateStyleEnvironmentToken.hasInterpretationType(InterpretationType.STYLE_SENTINEL)) {
                visitToken(flowTokenCreateStyleEnvironmentToken, computedStyle);
            } else {
                if (!flowTokenCreateStyleEnvironmentToken.getComputedStyle().isEquivalentTo(computedStyle2)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(flowTokenCreateStyleEnvironmentToken);
                    int i2 = i + 1;
                    int i4 = i2;
                    while (i4 < list.size()) {
                        FlowToken flowToken = list.get(i4);
                        if (flowToken.hasInterpretationType(InterpretationType.STYLE_SENTINEL) || !flowTokenCreateStyleEnvironmentToken.getComputedStyle().isEquivalentTo(flowToken.getComputedStyle())) {
                            break;
                        }
                        arrayList.add(flowToken);
                        i4++;
                    }
                    flowTokenCreateStyleEnvironmentToken = createStyleEnvironmentToken(flowTokenCreateStyleEnvironmentToken, arrayList);
                    list.set(i, flowTokenCreateStyleEnvironmentToken);
                    list.subList(i2, i4).clear();
                }
                computedStyle2 = flowTokenCreateStyleEnvironmentToken.getComputedStyle();
                visitToken(flowTokenCreateStyleEnvironmentToken, computedStyle2);
            }
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).trimToSize();
        }
    }

    private void visitToken(FlowToken flowToken, ComputedStyle computedStyle) {
        switch (C144931.$SwitchMap$uk$ac$ed$ph$snuggletex$tokens$TokenType[flowToken.getType().ordinal()]) {
            case 1:
                visitCommand((CommandToken) flowToken, computedStyle);
                return;
            case 2:
                visitEnvironment((EnvironmentToken) flowToken, computedStyle);
                return;
            case 3:
                visitSiblings(((BraceContainerToken) flowToken).getContents(), computedStyle);
                return;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return;
            default:
                throw new SnuggleLogicException("Unhandled/unexpected TokenType " + flowToken.getType());
        }
    }

    public void rebuildStyles(RootToken rootToken) {
        visitSiblings(rootToken.getContents(), rootToken.getComputedStyle());
    }

    private EnvironmentToken createStyleEnvironmentToken(FlowToken flowToken, ArgumentContainerToken argumentContainerToken) {
        EnvironmentToken environmentToken = new EnvironmentToken(flowToken.getSlice(), flowToken.getLatexMode(), CorePackageDefinitions.ENV_STYLE, argumentContainerToken);
        environmentToken.setComputedStyle(argumentContainerToken.getComputedStyle());
        return environmentToken;
    }
}
