package uk.p245ac.p246ed.p247ph.snuggletex.samples;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.ccil.cowan.tagsoup.XMLWriter;
import p001A.AbstractC0000a;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleEngine;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleInput;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleRuntimeException;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleSession;
import uk.p245ac.p246ed.p247ph.snuggletex.WebPageOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.WebPageOutputOptionsTemplates;
import uk.p245ac.p246ed.p247ph.snuggletex.XMLStringOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.IOUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MessageFormatter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class CommandLineRunner {
    private final String[] args;
    private final List<String> inputFiles = new ArrayList();
    private WebPageOutputOptions snuggleOptions = null;
    private boolean requestedWebOutput = false;
    private boolean isQuiet = false;

    public CommandLineRunner(String[] strArr) {
        this.args = strArr;
    }

    public static void main(String[] strArr) {
        System.exit(new CommandLineRunner(strArr).execute());
    }

    private boolean parseBoolean(String str, String str2) {
        if ("true".equals(str2) || "on".equals(str2) || "1".equals(str2)) {
            return true;
        }
        if ("false".equals(str2) || "off".equals(str2) || "0".equals(str2)) {
            return false;
        }
        throw new IllegalArgumentException(AbstractC0541b.m774p("Expected option ", str, " to have value true, false, on, off, 1 or 0, but got ", str2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a6, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parseCommandLineArguments() {
        int i;
        WebPageOutputOptions.WebPageType webPageTypeValueOf = null;
        int i2 = 0;
        while (true) {
            String[] strArr = this.args;
            if (i2 < strArr.length) {
                String str = strArr[i2];
                String str2 = i2 < strArr.length - 1 ? strArr[i2 + 1] : null;
                if ("-web".equals(str)) {
                    if (str2 == null) {
                        throw new IllegalArgumentException("No value provided for -web option");
                    }
                    try {
                        webPageTypeValueOf = WebPageOutputOptions.WebPageType.valueOf(str2);
                        this.requestedWebOutput = true;
                        i2++;
                    } catch (IllegalArgumentException unused) {
                        StringBuilder sbM15l = AbstractC0000a.m15l("Unknown web page type ", str2, ". Legal values are");
                        sbM15l.append(Arrays.asList(WebPageOutputOptions.WebPageType.values()));
                        throw new IllegalArgumentException(sbM15l.toString());
                    }
                }
                i2++;
            } else {
                this.snuggleOptions = this.requestedWebOutput ? WebPageOutputOptionsTemplates.createWebPageOptions(webPageTypeValueOf) : new WebPageOutputOptions();
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.args;
                    if (i4 >= strArr2.length) {
                        return true;
                    }
                    String str3 = strArr2[i4];
                    String str4 = i4 < strArr2.length - 1 ? strArr2[i4 + 1] : null;
                    if (CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR.equals(str3)) {
                        this.inputFiles.add(str3);
                    } else {
                        if ("-?".equals(str3) || "-h".equals(str3) || "-help".equals(str3)) {
                            break;
                        }
                        if ("-web".equals(str3)) {
                            i4++;
                        } else if ("-quiet".equals(str3)) {
                            this.isQuiet = true;
                        } else if (!str3.startsWith(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                            this.inputFiles.add(str3);
                        } else {
                            if (str4 == null) {
                                throw new IllegalArgumentException(AbstractC0541b.m773o("No value provided for ", str3, " option"));
                            }
                            String strSubstring = str3.substring(1);
                            if (XMLWriter.INDENT.equals(strSubstring)) {
                                try {
                                    i = Integer.parseInt(str4);
                                } catch (NumberFormatException unused2) {
                                    i = 0;
                                }
                                boolean z = i < 0;
                                if (z) {
                                    throw new IllegalArgumentException("Indent amount must be a non-negative integer");
                                }
                                if (i == 0) {
                                    this.snuggleOptions.setIndenting(false);
                                } else {
                                    this.snuggleOptions.setIndenting(true);
                                    this.snuggleOptions.setIndent(i);
                                }
                            } else if (Contract.ERRORS.equals(strSubstring)) {
                                try {
                                    this.snuggleOptions.setErrorOutputOptions(DOMOutputOptions.ErrorOutputOptions.valueOf(str4));
                                } catch (IllegalArgumentException unused3) {
                                    StringBuilder sbM15l2 = AbstractC0000a.m15l("Unknown errors option ", str4, ". Legal values are ");
                                    sbM15l2.append(Arrays.asList(DOMOutputOptions.ErrorOutputOptions.values()));
                                    throw new IllegalArgumentException(sbM15l2.toString());
                                }
                            } else if ("inlinecss".equals(strSubstring)) {
                                this.snuggleOptions.setInliningCSS(parseBoolean(strSubstring, str4));
                            } else if ("xhtmlprefix".equals(strSubstring)) {
                                if (str4.length() > 0) {
                                    this.snuggleOptions.setXHTMLPrefix(str4);
                                    this.snuggleOptions.setPrefixingXHTML(true);
                                } else {
                                    this.snuggleOptions.setPrefixingXHTML(false);
                                }
                            } else if ("mathmlprefix".equals(strSubstring)) {
                                if (str4.length() > 0) {
                                    this.snuggleOptions.setMathMLPrefix(str4);
                                    this.snuggleOptions.setPrefixingMathML(true);
                                } else {
                                    this.snuggleOptions.setPrefixingMathML(false);
                                }
                            } else if ("snugglexmlprefix".equals(strSubstring)) {
                                if (str4.length() > 0) {
                                    this.snuggleOptions.setSnuggleXMLPrefix(str4);
                                    this.snuggleOptions.setPrefixingSnuggleXML(true);
                                } else {
                                    this.snuggleOptions.setPrefixingSnuggleXML(false);
                                }
                            } else if ("annotatemathml".equals(strSubstring)) {
                                this.snuggleOptions.setAddingMathSourceAnnotations(parseBoolean(strSubstring, str4));
                            } else if ("mathvariantmapping".equals(strSubstring)) {
                                this.snuggleOptions.setMathVariantMapping(parseBoolean(strSubstring, str4));
                            } else if (HeaderParameterNames.ENCRYPTION_ALGORITHM.equals(strSubstring)) {
                                this.snuggleOptions.setEncoding(str4);
                            } else if ("xmldecl".equals(strSubstring)) {
                                this.snuggleOptions.setIncludingXMLDeclaration(parseBoolean(strSubstring, str4));
                            } else if ("entities".equals(strSubstring)) {
                                this.snuggleOptions.setUsingNamedEntities(parseBoolean(strSubstring, str4));
                            } else if ("dtpublic".equals(strSubstring)) {
                                this.snuggleOptions.setDoctypePublic(str4);
                            } else if ("dtsystem".equals(strSubstring)) {
                                this.snuggleOptions.setDoctypeSystem(str4);
                            } else if ("ctype".equals(strSubstring)) {
                                this.snuggleOptions.setContentType(str4);
                            } else if ("lang".equals(strSubstring)) {
                                this.snuggleOptions.setLang(str4);
                            } else if ("title".equals(strSubstring)) {
                                this.snuggleOptions.setTitle(str4);
                            } else if ("head".equals(strSubstring)) {
                                this.snuggleOptions.setAddingTitleHeading(parseBoolean(strSubstring, str4));
                            } else if ("style".equals(strSubstring)) {
                                this.snuggleOptions.setIncludingStyleElement(parseBoolean(strSubstring, str4));
                            } else if ("css".equals(strSubstring)) {
                                this.snuggleOptions.addCSSStylesheetURLs(str4);
                            } else {
                                if (!"clientxsl".equals(strSubstring)) {
                                    throw new IllegalArgumentException("Unknown option ".concat(str3));
                                }
                                this.snuggleOptions.addClientSideXSLTStylesheetURLs(str4);
                            }
                            i4++;
                        }
                    }
                    i4++;
                }
            }
        }
    }

    private void showHelp() {
        System.out.println("For help and usage, use the -? option");
    }

    private void showUsage() {
        try {
            IOUtilities.transfer(getClass().getClassLoader().getResourceAsStream("uk/ac/ed/ph/snuggletex/command-line-usage.txt"), System.out);
        } catch (IOException e) {
            throw new SnuggleRuntimeException("Unexpected Exception printing out usage info", e);
        }
    }

    public int execute() {
        if (this.args.length == 0) {
            showHelp();
            return 1;
        }
        try {
            if (!parseCommandLineArguments()) {
                showUsage();
                return 1;
            }
            if (this.inputFiles.isEmpty()) {
                System.err.println("No input files specified");
                showHelp();
                return 1;
            }
            SnuggleSession snuggleSessionCreateSession = new SnuggleEngine().createSession();
            try {
                for (String str : this.inputFiles) {
                    snuggleSessionCreateSession.parseInput(str.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? new SnuggleInput(System.in) : new SnuggleInput(new File(str)));
                }
                if (this.requestedWebOutput) {
                    snuggleSessionCreateSession.writeWebPage(this.snuggleOptions, System.out, SnuggleSession.EndOutputAction.FLUSH);
                } else {
                    System.out.println(snuggleSessionCreateSession.buildXMLString((XMLStringOutputOptions) this.snuggleOptions));
                }
                System.out.println();
            } catch (IOException e) {
                System.err.println("Got IOException running SnuggleTeX: " + e.getMessage());
            }
            if (this.isQuiet) {
                return 0;
            }
            Iterator<InputError> it = snuggleSessionCreateSession.getErrors().iterator();
            while (it.hasNext()) {
                System.err.println(MessageFormatter.formatErrorAsString(it.next()));
            }
            return 0;
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
            showHelp();
            return 1;
        }
    }
}
