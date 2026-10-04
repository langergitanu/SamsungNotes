package uk.p245ac.p246ed.p247ph.snuggletex;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import uk.p245ac.p246ed.p247ph.snuggletex.WebPageOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.W3CConstants;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public final class WebPageOutputOptionsTemplates {

    @Deprecated
    public static final String DEFAULT_CONTENT_TYPE = "application/xhtml+xml";

    @Deprecated
    public static final String DEFAULT_LANG = "en";

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.WebPageOutputOptionsTemplates$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144851 {

        /* JADX INFO: renamed from: $SwitchMap$uk$ac$ed$ph$snuggletex$WebPageOutputOptions$WebPageType */
        static final /* synthetic */ int[] f10285x5a9661e8;

        static {
            int[] iArr = new int[WebPageOutputOptions.WebPageType.values().length];
            f10285x5a9661e8 = iArr;
            try {
                iArr[WebPageOutputOptions.WebPageType.MOZILLA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10285x5a9661e8[WebPageOutputOptions.WebPageType.CROSS_BROWSER_XHTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10285x5a9661e8[WebPageOutputOptions.WebPageType.MATHPLAYER_HTML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10285x5a9661e8[WebPageOutputOptions.WebPageType.PROCESSED_HTML.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10285x5a9661e8[WebPageOutputOptions.WebPageType.UNIVERSAL_STYLESHEET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10285x5a9661e8[WebPageOutputOptions.WebPageType.CLIENT_SIDE_XSLT_STYLESHEET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Deprecated
    public static WebPageOutputOptions createWebPageOptions(WebPageOutputOptions.WebPageType webPageType) {
        ConstraintUtilities.ensureNotNull(webPageType, "webPageType");
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        switch (C144851.f10285x5a9661e8[webPageType.ordinal()]) {
            case 1:
                webPageOutputOptions.setSerializationMethod(SerializationMethod.XHTML);
                webPageOutputOptions.setContentType("application/xhtml+xml");
                return webPageOutputOptions;
            case 2:
                webPageOutputOptions.setSerializationMethod(SerializationMethod.XHTML);
                webPageOutputOptions.setIncludingXMLDeclaration(true);
                webPageOutputOptions.setDoctypePublic(W3CConstants.XHTML_11_MATHML_20_PUBLIC_IDENTIFIER);
                webPageOutputOptions.setDoctypeSystem(W3CConstants.XHTML_11_MATHML_20_SYSTEM_IDENTIFIER);
                webPageOutputOptions.setNoCharsetInContentTypeHeader(true);
                return webPageOutputOptions;
            case 3:
                webPageOutputOptions.setSerializationMethod(SerializationMethod.HTML);
                webPageOutputOptions.setContentType(Constants.MIME_HTML);
                webPageOutputOptions.setPrefixingMathML(true);
                return webPageOutputOptions;
            case 4:
                webPageOutputOptions.setSerializationMethod(SerializationMethod.HTML);
                webPageOutputOptions.setContentType(Constants.MIME_HTML);
                return webPageOutputOptions;
            case 5:
                webPageOutputOptions.setSerializationMethod(SerializationMethod.XML);
                webPageOutputOptions.setIncludingXMLDeclaration(true);
                return webPageOutputOptions;
            case 6:
                webPageOutputOptions.setSerializationMethod(SerializationMethod.XML);
                return webPageOutputOptions;
            default:
                throw new SnuggleRuntimeException("Unexpected switch case " + webPageType);
        }
    }
}
