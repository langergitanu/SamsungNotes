package opennlp.tools.formats.muc;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.google.android.gms.stats.CodePackage;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import opennlp.tools.formats.muc.SgmlParser;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MucNameContentHandler extends SgmlParser.ContentHandler {
    private static final String ENTITY_ELEMENT_NAME = "ENAMEX";
    private static final Set<String> EXPECTED_TYPES;
    private static final Set<String> NAME_ELEMENT_NAMES;
    private static final String NUM_ELEMENT_NAME = "NUMEX";
    private static final String TIME_ELEMENT_NAME = "TIMEX";
    private final List<NameSample> storedSamples;
    private final Tokenizer tokenizer;
    private boolean isInsideContentElement = false;
    private final List<String> text = new ArrayList();
    private boolean isClearAdaptiveData = false;
    private final Stack<Span> incompleteNames = new Stack<>();
    private final List<Span> names = new ArrayList();

    static {
        Object[] objArr = {"PERSON", "ORGANIZATION", CodePackage.LOCATION, TextConst.DATE_TIME_UNIT_DATE, TextConst.DATE_TIME_UNIT_TIME, "MONEY", "PERCENT"};
        HashSet hashSet = new HashSet(7);
        for (int i = 0; i < 7; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "duplicate element: "));
            }
        }
        EXPECTED_TYPES = Collections.unmodifiableSet(hashSet);
        Object[] objArr2 = {ENTITY_ELEMENT_NAME, TIME_ELEMENT_NAME, NUM_ELEMENT_NAME};
        HashSet hashSet2 = new HashSet(3);
        for (int i2 = 0; i2 < 3; i2++) {
            Object obj2 = objArr2[i2];
            Objects.requireNonNull(obj2);
            if (!hashSet2.add(obj2)) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(obj2, "duplicate element: "));
            }
        }
        NAME_ELEMENT_NAMES = Collections.unmodifiableSet(hashSet2);
    }

    public MucNameContentHandler(Tokenizer tokenizer, List<NameSample> list) {
        this.tokenizer = tokenizer;
        this.storedSamples = list;
    }

    @Override // opennlp.tools.formats.muc.SgmlParser.ContentHandler
    public void characters(CharSequence charSequence) {
        if (this.isInsideContentElement) {
            this.text.addAll(Arrays.asList(this.tokenizer.tokenize(charSequence.toString())));
        }
    }

    @Override // opennlp.tools.formats.muc.SgmlParser.ContentHandler
    public void endElement(String str) {
        if (NAME_ELEMENT_NAMES.contains(str)) {
            Span spanPop = this.incompleteNames.pop();
            this.names.add(new Span(spanPop.getStart(), this.text.size(), spanPop.getType()));
        }
        if (MucElementNames.CONTENT_ELEMENTS.contains(str)) {
            this.storedSamples.add(new NameSample((String[]) this.text.toArray(new String[0]), (Span[]) this.names.toArray(new Span[0]), this.isClearAdaptiveData));
            if (this.isClearAdaptiveData) {
                this.isClearAdaptiveData = false;
            }
            this.text.clear();
            this.names.clear();
            this.isInsideContentElement = false;
        }
    }

    @Override // opennlp.tools.formats.muc.SgmlParser.ContentHandler
    public void startElement(String str, Map<String, String> map) throws InvalidFormatException {
        if (Bixby2Constants.SLOT_VALUE_SHARE_AS_DOC.equals(str)) {
            this.isClearAdaptiveData = true;
        }
        if (MucElementNames.CONTENT_ELEMENTS.contains(str)) {
            this.isInsideContentElement = true;
        }
        if (NAME_ELEMENT_NAMES.contains(str)) {
            String str2 = map.get(CredentialProviderBaseController.TYPE_TAG);
            Set<String> set = EXPECTED_TYPES;
            if (set.contains(str2)) {
                this.incompleteNames.add(new Span(this.text.size(), this.text.size(), str2.toLowerCase(Locale.ENGLISH)));
                return;
            }
            throw new InvalidFormatException("Unknown timex, numex or namex type: " + str2 + ", expected one of " + set);
        }
    }
}
