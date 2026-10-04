package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import androidx.compose.runtime.AbstractC1974b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ErrorToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class TabularHandler implements CommandHandler, EnvironmentHandler {
    public static int[] computeTableDimensions(ArgumentContainerToken argumentContainerToken) {
        int i = 0;
        int i2 = 0;
        for (FlowToken flowToken : argumentContainerToken) {
            if (!flowToken.isCommand(CorePackageDefinitions.CMD_HLINE) && flowToken.getType() != TokenType.ERROR) {
                if (!flowToken.isCommand(CorePackageDefinitions.CMD_TABLE_ROW)) {
                    throw new SnuggleLogicException("Did not expect to find token " + flowToken + " within a top-level table content");
                }
                i++;
                int i4 = 0;
                for (FlowToken flowToken2 : ((CommandToken) flowToken).getArguments()[0]) {
                    if (!flowToken2.isCommand(CorePackageDefinitions.CMD_TABLE_COLUMN)) {
                        throw new SnuggleLogicException("Did not expect to find token " + flowToken2 + " within a table row");
                    }
                    i4++;
                }
                if (i4 > i2) {
                    i2 = i4;
                }
            }
        }
        return new int[]{i, i2};
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        dOMBuilder.appendOrThrowError(element, commandToken, CoreErrorCode.TDETB3, commandToken.getCommand().getTeXName());
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        int i;
        ArrayList arrayList;
        int i2;
        int i4;
        ArrayList arrayList2;
        int i5;
        int i6 = 1;
        int i7 = computeTableDimensions(environmentToken.getContent())[1];
        ArrayList arrayList3 = new ArrayList();
        int i8 = 0;
        ArgumentContainerToken argumentContainerToken = environmentToken.getArguments()[0];
        CharSequence charSequenceExtract = environmentToken.getArguments()[0].getSlice().extract();
        boolean z = false;
        String str = null;
        for (int i9 = 0; i9 < charSequenceExtract.length(); i9++) {
            char cCharAt = charSequenceExtract.charAt(i9);
            if (!Character.isWhitespace(cCharAt)) {
                if (cCharAt == 'c') {
                    str = "align-center";
                } else if (cCharAt == 'l') {
                    str = "align-left";
                } else if (cCharAt == 'r') {
                    str = "align-right";
                } else if (cCharAt != '|') {
                    dOMBuilder.appendOrThrowError(element, argumentContainerToken, CoreErrorCode.TDETB1, String.valueOf(cCharAt));
                } else {
                    z = true;
                }
                if (str != null) {
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.add(str);
                    if (z) {
                        arrayList4.add("left-border");
                    }
                    arrayList3.add(arrayList4);
                    z = false;
                    str = null;
                }
            }
        }
        if (arrayList3.isEmpty()) {
            dOMBuilder.appendOrThrowError(element, argumentContainerToken, CoreErrorCode.TDETB2, new Object[0]);
            return;
        }
        if (z) {
            ((List) AbstractC1974b.m1313f(1, arrayList3)).add("right-border");
        }
        if (arrayList3.size() < i7) {
            dOMBuilder.appendOrThrowError(element, argumentContainerToken, CoreErrorCode.TDETB0, Integer.valueOf(arrayList3.size()), Integer.valueOf(i7));
        }
        Element elementAppendXHTMLElement = dOMBuilder.appendXHTMLElement(element, "table");
        dOMBuilder.applyCSSStyle(elementAppendXHTMLElement, "tabular");
        Element elementAppendXHTMLElement2 = dOMBuilder.appendXHTMLElement(elementAppendXHTMLElement, "tbody");
        ArrayList arrayList5 = new ArrayList(3);
        List<FlowToken> contents = environmentToken.getContent().getContents();
        int i10 = 0;
        int i11 = 0;
        while (i10 < contents.size()) {
            FlowToken flowToken = contents.get(i10);
            if (flowToken.isCommand(CorePackageDefinitions.CMD_HLINE)) {
                i = i7;
                i11 = i6;
                arrayList = arrayList3;
                i2 = i8;
                i4 = i11;
            } else if (flowToken.isCommand(CorePackageDefinitions.CMD_TABLE_ROW)) {
                int i12 = i10 + 1;
                int i13 = i8;
                i2 = i13;
                while (true) {
                    if (i12 >= contents.size()) {
                        break;
                    }
                    if (!contents.get(i12).isCommand(CorePackageDefinitions.CMD_HLINE)) {
                        i13 = i2;
                        break;
                    } else {
                        i12++;
                        i13 = i6;
                    }
                }
                List<FlowToken> contents2 = ((CommandToken) flowToken).getArguments()[i2].getContents();
                Element elementAppendXHTMLElement3 = dOMBuilder.appendXHTMLElement(elementAppendXHTMLElement2, "tr");
                int size = contents2.size();
                int i14 = i2;
                while (i14 < i7) {
                    Element elementAppendXHTMLElement4 = dOMBuilder.appendXHTMLElement(elementAppendXHTMLElement3, "td");
                    arrayList5.clear();
                    arrayList5.add("tabular");
                    int i15 = i7;
                    if (i14 < arrayList3.size()) {
                        arrayList5.addAll((Collection) arrayList3.get(i14));
                    }
                    if (i11 != 0) {
                        arrayList5.add("top-border");
                    }
                    if (i13 != 0) {
                        arrayList5.add("bottom-border");
                    }
                    dOMBuilder.applyCSSStyle(elementAppendXHTMLElement4, (String[]) arrayList5.toArray(new String[arrayList5.size()]));
                    if (i14 < size) {
                        arrayList2 = arrayList3;
                        i5 = 1;
                        dOMBuilder.handleTokens(elementAppendXHTMLElement4, ((CommandToken) contents2.get(i14)).getArguments()[i2].getContents(), true);
                    } else {
                        arrayList2 = arrayList3;
                        i5 = 1;
                    }
                    i14++;
                    i6 = i5;
                    i7 = i15;
                    arrayList3 = arrayList2;
                }
                i = i7;
                arrayList = arrayList3;
                i4 = i6;
                if (i13 != 0) {
                    return;
                } else {
                    i11 = i2;
                }
            } else {
                i = i7;
                arrayList = arrayList3;
                i2 = i8;
                i4 = i6;
                if (flowToken.getType() != TokenType.ERROR) {
                    throw new SnuggleLogicException("Expected table contents to be \\hline or table rows");
                }
                dOMBuilder.appendErrorElement(dOMBuilder.appendXHTMLElement(dOMBuilder.appendXHTMLElement(elementAppendXHTMLElement2, "tr"), "td"), (ErrorToken) flowToken);
            }
            i10++;
            i6 = i4;
            i8 = i2;
            i7 = i;
            arrayList3 = arrayList;
        }
    }
}
