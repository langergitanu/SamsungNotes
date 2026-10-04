package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.Token;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class HSpaceHandler implements CommandHandler {
    public String convertLaTeXSize(DOMBuilder dOMBuilder, Element element, Token token) {
        float f;
        CharSequence charSequenceExtract = token.getSlice().extract();
        Matcher matcher = Pattern.compile("\\s*(-?[\\d\\.]+)\\s*(\\w+)\\s*").matcher(charSequenceExtract);
        if (!matcher.matches()) {
            dOMBuilder.appendOrThrowError(element, token, CoreErrorCode.TDEUN0, charSequenceExtract);
            return null;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        try {
            float f4 = Float.parseFloat(strGroup);
            if (!strGroup2.equals(LangPackConfigConstants.LANGUAGE_CODE_PT) && !strGroup2.equals("in") && !strGroup2.equals("cm") && !strGroup2.equals("mm") && !strGroup2.equals("em") && !strGroup2.equals("ex")) {
                if (strGroup2.equals("pc")) {
                    f4 *= 12.0f;
                } else if (strGroup2.equals("bp")) {
                    f4 /= 72.0f;
                    strGroup2 = "in";
                } else {
                    if (strGroup2.equals("dd")) {
                        f4 *= 1238.0f;
                        f = 1157.0f;
                    } else {
                        if (!strGroup2.equals("sp")) {
                            dOMBuilder.appendOrThrowError(element, token, CoreErrorCode.TDEUN2, strGroup2, charSequenceExtract);
                            return null;
                        }
                        f = 65536.0f;
                    }
                    f4 /= f;
                }
                strGroup2 = LangPackConfigConstants.LANGUAGE_CODE_PT;
            }
            return Float.valueOf(f4) + strGroup2;
        } catch (NumberFormatException unused) {
            dOMBuilder.appendOrThrowError(element, token, CoreErrorCode.TDEUN1, strGroup, charSequenceExtract);
            return null;
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        String strConvertLaTeXSize = convertLaTeXSize(dOMBuilder, element, commandToken.getArguments()[0]);
        if (strConvertLaTeXSize == null) {
            return;
        }
        if (commandToken.getLatexMode() == LaTeXMode.MATH) {
            dOMBuilder.appendMathMLElement(element, "mspace").setAttribute("width", strConvertLaTeXSize);
            return;
        }
        Element elementAppendXHTMLElement = dOMBuilder.appendXHTMLElement(element, "span");
        elementAppendXHTMLElement.setAttribute("style", "margin-left:" + strConvertLaTeXSize + ";font-size:0");
        dOMBuilder.appendTextNode(elementAppendXHTMLElement, UnicodeUtils.NBSP, false);
    }
}
