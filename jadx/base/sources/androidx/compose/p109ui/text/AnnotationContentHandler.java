package androidx.compose.p109ui.text;

import android.text.Editable;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0096\u0001J&\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010\u0014\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J)\u0010\u0019\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001J)\u0010\u001a\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J0\u0010\u001f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016J)\u0010!\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Landroidx/compose/ui/text/AnnotationContentHandler;", "Lorg/xml/sax/ContentHandler;", "contentHandler", "output", "Landroid/text/Editable;", "(Lorg/xml/sax/ContentHandler;Landroid/text/Editable;)V", "characters", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "p2", "endDocument", "endElement", "uri", "", "localName", "qName", "endPrefixMapping", "handleAnnotationEnd", "handleAnnotationStart", NativeAuthConstants.GrantType.ATTRIBUTES, "Lorg/xml/sax/Attributes;", "ignorableWhitespace", "processingInstruction", "setDocumentLocator", "Lorg/xml/sax/Locator;", "skippedEntity", "startDocument", "startElement", "atts", "startPrefixMapping", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHtml.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Html.android.kt\nandroidx/compose/ui/text/AnnotationContentHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,292:1\n1#2:293\n3792#3:294\n4307#3,2:295\n33#4,6:297\n*S KotlinDebug\n*F\n+ 1 Html.android.kt\nandroidx/compose/ui/text/AnnotationContentHandler\n*L\n265#1:294\n265#1:295,2\n266#1:297,6\n*E\n"})
final class AnnotationContentHandler implements ContentHandler {

    @NotNull
    private final ContentHandler contentHandler;

    @NotNull
    private final Editable output;

    public AnnotationContentHandler(@NotNull ContentHandler contentHandler, @NotNull Editable editable) {
        this.contentHandler = contentHandler;
        this.output = editable;
    }

    private final void handleAnnotationEnd() {
        Editable editable = this.output;
        Object[] spans = editable.getSpans(0, editable.length(), AnnotationSpan.class);
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            if (this.output.getSpanFlags((AnnotationSpan) obj) == 17) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AnnotationSpan annotationSpan = (AnnotationSpan) arrayList.get(i);
            int spanStart = this.output.getSpanStart(annotationSpan);
            int length = this.output.length();
            this.output.removeSpan(annotationSpan);
            if (spanStart != length) {
                this.output.setSpan(annotationSpan, spanStart, length, 33);
            }
        }
    }

    private final void handleAnnotationStart(Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            String localName = attributes.getLocalName(i);
            if (localName == null) {
                localName = "";
            }
            String value = attributes.getValue(i);
            String str = value != null ? value : "";
            if (localName.length() > 0 && str.length() > 0) {
                int length2 = this.output.length();
                this.output.setSpan(new AnnotationSpan(localName, str), length2, length2, 17);
            }
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] p0, int p1, int p2) throws SAXException {
        this.contentHandler.characters(p0, p1, p2);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        this.contentHandler.endDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(@Nullable String uri, @Nullable String localName, @Nullable String qName) throws SAXException {
        if (Intrinsics.areEqual(localName, MathMLUtilities.ANNOTATION_LOCAL_NAME)) {
            handleAnnotationEnd();
        } else {
            this.contentHandler.endElement(uri, localName, qName);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String p0) throws SAXException {
        this.contentHandler.endPrefixMapping(p0);
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] p0, int p1, int p2) throws SAXException {
        this.contentHandler.ignorableWhitespace(p0, p1, p2);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String p0, String p1) throws SAXException {
        this.contentHandler.processingInstruction(p0, p1);
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator p0) {
        this.contentHandler.setDocumentLocator(p0);
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String p0) throws SAXException {
        this.contentHandler.skippedEntity(p0);
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.contentHandler.startDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(@Nullable String uri, @Nullable String localName, @Nullable String qName, @Nullable Attributes atts) throws SAXException {
        if (!Intrinsics.areEqual(localName, MathMLUtilities.ANNOTATION_LOCAL_NAME)) {
            this.contentHandler.startElement(uri, localName, qName, atts);
        } else if (atts != null) {
            handleAnnotationStart(atts);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String p0, String p1) throws SAXException {
        this.contentHandler.startPrefixMapping(p0, p1);
    }
}
