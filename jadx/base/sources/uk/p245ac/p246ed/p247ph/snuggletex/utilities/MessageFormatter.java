package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.util.html.Attribute;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.ErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.ErrorGroup;
import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleConstants;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleRuntimeException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.Globals;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.SnuggleInputReader;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.WorkingDocument;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MessageFormatter {
    public static final PropertyResourceBundle GENERAL_MESSAGE_BUNDLE;
    private static final int TRUNCATE_LENGTH = 20;

    static {
        try {
            GENERAL_MESSAGE_BUNDLE = (PropertyResourceBundle) ResourceBundle.getBundle(Globals.GENERAL_MESSAGES_PROPERTIES_BASENAME);
        } catch (MissingResourceException e) {
            throw new SnuggleRuntimeException(e);
        }
    }

    public static void appendErrorAsString(StringBuffer stringBuffer, InputError inputError) {
        new MessageFormat(GENERAL_MESSAGE_BUNDLE.getString("error_as_string")).format(new Object[]{formatErrorCodeName(inputError.getErrorCode()), getErrorMessage(inputError)}, stringBuffer, (FieldPosition) null);
        FrozenSlice slice = inputError.getSlice();
        if (slice != null) {
            appendSliceContext(stringBuffer, slice);
        }
    }

    private static void appendFrame(StringBuffer stringBuffer, WorkingDocument.CharacterSource characterSource, int i) {
        WorkingDocument.SourceContext sourceContext = characterSource.context;
        if (sourceContext instanceof SnuggleInputReader) {
            SnuggleInputReader snuggleInputReader = (SnuggleInputReader) sourceContext;
            int[] lineAndColumn = snuggleInputReader.getLineAndColumn(i);
            appendNewlineIfRequired(stringBuffer);
            new MessageFormat(GENERAL_MESSAGE_BUNDLE.getString("input_context")).format(new Object[]{Integer.valueOf(lineAndColumn[0]), Integer.valueOf(lineAndColumn[1]), snuggleInputReader.getInput().getIdentifier()}, stringBuffer, (FieldPosition) null);
        } else {
            if (!(sourceContext instanceof WorkingDocument.SubstitutionContext)) {
                throw new SnuggleLogicException("Unexpected SourceContext ".concat(sourceContext.getClass().getName()));
            }
            appendNewlineIfRequired(stringBuffer);
            new MessageFormat(GENERAL_MESSAGE_BUNDLE.getString("subs_context")).format(new Object[]{Integer.valueOf(i), formatText(characterSource.substitutedText), formatText(((WorkingDocument.SubstitutionContext) sourceContext).replacement)}, stringBuffer, (FieldPosition) null);
        }
        WorkingDocument.CharacterSource characterSource2 = characterSource.substitutedSource;
        if (characterSource2 != null) {
            appendFrame(stringBuffer, characterSource2, characterSource.substitutionOffset);
        }
    }

    private static void appendNewlineIfRequired(StringBuffer stringBuffer) {
        if (stringBuffer.length() > 0) {
            stringBuffer.append('\n');
        }
    }

    public static void appendSliceContext(StringBuffer stringBuffer, FrozenSlice frozenSlice) {
        WorkingDocument document = frozenSlice.getDocument();
        WorkingDocument.IndexResolution indexResolutionResolveIndex = document.resolveIndex(frozenSlice.startIndex, false);
        if (indexResolutionResolveIndex == null) {
            indexResolutionResolveIndex = document.resolveIndex(frozenSlice.startIndex, true);
        }
        if (indexResolutionResolveIndex != null) {
            appendFrame(stringBuffer, indexResolutionResolveIndex.slice.resolvedComponent, indexResolutionResolveIndex.indexInComponent);
        } else {
            throw new SnuggleLogicException("Could not resolve component containing error slice starting at " + frozenSlice.startIndex);
        }
    }

    public static String formatErrorAsString(InputError inputError) {
        StringBuffer stringBuffer = new StringBuffer();
        appendErrorAsString(stringBuffer, inputError);
        return stringBuffer.toString();
    }

    public static Element formatErrorAsXHTML(Document document, InputError inputError) {
        Element elementCreateElementNS = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        elementCreateElementNS.setAttribute(Attribute.CLASS_ATTR, "error");
        Element elementCreateElementNS2 = document.createElementNS("http://www.w3.org/1999/xhtml", ApplicationProtocolNames.HTTP_2);
        elementCreateElementNS2.appendChild(document.createTextNode("SnuggleTeX Error (" + formatErrorCodeName(inputError.getErrorCode()) + ")"));
        Element elementCreateElementNS3 = document.createElementNS("http://www.w3.org/1999/xhtml", "pre");
        StringBuffer stringBuffer = new StringBuffer(getErrorMessage(inputError));
        FrozenSlice slice = inputError.getSlice();
        if (slice != null) {
            appendSliceContext(stringBuffer, slice);
        }
        elementCreateElementNS3.appendChild(document.createTextNode(stringBuffer.toString()));
        elementCreateElementNS.appendChild(elementCreateElementNS2);
        elementCreateElementNS.appendChild(elementCreateElementNS3);
        return elementCreateElementNS;
    }

    public static Element formatErrorAsXML(Document document, InputError inputError, boolean z) {
        return formatErrorAsXML(document, null, inputError, z);
    }

    public static String formatErrorCodeName(ErrorCode errorCode) {
        String name = errorCode.getErrorGroup().getPackage().getName();
        String name2 = errorCode.getName();
        return CorePackageDefinitions.CORE_PACKAGE_NAME.equals(name) ? name2 : AbstractC0541b.m757C(name, "/", name2);
    }

    public static String formatErrorGroup(ErrorGroup errorGroup) {
        ResourceBundle errorMessageBundle = errorGroup.getPackage().getErrorMessageBundle();
        if (errorMessageBundle != null) {
            return MessageFormat.format(errorMessageBundle.getString(errorGroup.toString()), ObjectUtilities.EMPTY_OBJECT_ARRAY);
        }
        return "Error " + errorGroup.getName();
    }

    private static String formatText(CharSequence charSequence) {
        String strReplaceAll = charSequence.toString().replaceAll("\\s", " ");
        if (strReplaceAll.length() <= 20) {
            return strReplaceAll;
        }
        return strReplaceAll.substring(0, 20) + "...";
    }

    public static String getErrorMessage(InputError inputError) {
        return getErrorMessage(inputError.getErrorCode(), inputError.getArguments());
    }

    public static Element formatErrorAsXML(Document document, DOMOutputOptions dOMOutputOptions, InputError inputError, boolean z) {
        String str = "error";
        if (dOMOutputOptions != null && dOMOutputOptions.isPrefixingSnuggleXML()) {
            str = dOMOutputOptions.getSnuggleXMLPrefix() + ":error";
        }
        Element elementCreateElementNS = document.createElementNS(SnuggleConstants.SNUGGLETEX_NAMESPACE, str);
        elementCreateElementNS.setAttribute("code", inputError.getErrorCode().getName());
        elementCreateElementNS.setAttribute("package", inputError.getErrorCode().getErrorGroup().getPackage().getName());
        if (z) {
            StringBuffer stringBuffer = new StringBuffer(getErrorMessage(inputError));
            FrozenSlice slice = inputError.getSlice();
            if (slice != null) {
                appendSliceContext(stringBuffer, slice);
            }
            elementCreateElementNS.appendChild(document.createTextNode(stringBuffer.toString()));
        }
        return elementCreateElementNS;
    }

    public static String getErrorMessage(ErrorCode errorCode, Object... objArr) {
        ResourceBundle errorMessageBundle = errorCode.getErrorGroup().getPackage().getErrorMessageBundle();
        if (errorMessageBundle != null) {
            return MessageFormat.format(errorMessageBundle.getString(errorCode.toString()), objArr);
        }
        return "Error " + formatErrorCodeName(errorCode) + ": " + Arrays.toString(objArr);
    }
}
