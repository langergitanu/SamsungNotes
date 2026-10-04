package uk.p245ac.p246ed.p247ph.snuggletex;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnuggleInput {
    private String encoding;
    private final File file;
    private String identifier;
    private final InputStream inputStream;
    private final Reader reader;
    private final String string;
    private String stringRepresentation;
    private final InputType type;
    private URI uri;

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.SnuggleInput$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144781 {
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType;

        static {
            int[] iArr = new int[InputType.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType = iArr;
            try {
                iArr[InputType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[InputType.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[InputType.INPUT_STREAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[InputType.READER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum InputType {
        STRING,
        FILE,
        INPUT_STREAM,
        READER
    }

    public SnuggleInput(String str) {
        this(str, AbstractC0541b.m773o("\"", str, "\""));
    }

    private String buildStringRepresentation() {
        return AbstractC0622a.m1170p(this.identifier, ")", new StringBuilder("SnuggleInput("));
    }

    public String getEncoding() {
        return this.encoding;
    }

    public File getFile() {
        return this.file;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public Reader getReader() {
        return this.reader;
    }

    public String getString() {
        return this.string;
    }

    public InputType getType() {
        return this.type;
    }

    public URI getURI() {
        return this.uri;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setURI(URI uri) {
        this.uri = uri;
    }

    public String toString() {
        if (this.stringRepresentation == null) {
            this.stringRepresentation = buildStringRepresentation();
        }
        return this.stringRepresentation;
    }

    public SnuggleInput(String str, String str2) {
        this(InputType.STRING, str, null, null, null, str2, null);
    }

    public SnuggleInput(File file) {
        this(file, file.getPath());
    }

    public SnuggleInput(File file, String str) {
        this(InputType.FILE, null, file, null, null, str, null);
    }

    public SnuggleInput(File file, String str, String str2) {
        this(InputType.FILE, null, file, null, null, str, str2);
    }

    public SnuggleInput(InputStream inputStream) {
        this(inputStream, "[Stream input @" + inputStream.hashCode() + "]");
    }

    public SnuggleInput(InputStream inputStream, String str) {
        this(InputType.INPUT_STREAM, null, null, inputStream, null, str, null);
    }

    public SnuggleInput(InputStream inputStream, String str, String str2) {
        this(InputType.INPUT_STREAM, null, null, inputStream, null, str, str2);
    }

    public SnuggleInput(Reader reader) {
        this(reader, "[Reader input @" + reader.hashCode() + "]");
    }

    public SnuggleInput(Reader reader, String str) {
        this(InputType.READER, null, null, null, reader, str, null);
    }

    private SnuggleInput(InputType inputType, String str, File file, InputStream inputStream, Reader reader, String str2, String str3) {
        ConstraintUtilities.ensureNotNull(str2, "identifier");
        int i = C144781.$SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[inputType.ordinal()];
        if (i == 1) {
            ConstraintUtilities.ensureNotNull(str, "string");
        } else if (i == 2) {
            ConstraintUtilities.ensureNotNull(file, "file");
        } else if (i == 3) {
            ConstraintUtilities.ensureNotNull(inputStream, "inputStream");
        } else if (i == 4) {
            ConstraintUtilities.ensureNotNull(reader, "reader");
        } else {
            throw new SnuggleLogicException("Unexpected switch case " + inputType);
        }
        this.type = inputType;
        this.string = str;
        this.file = file;
        this.inputStream = inputStream;
        this.reader = reader;
        this.identifier = str2;
        this.encoding = str3;
    }
}
