package com.adobe.internal.xmp.utils;

import com.adobe.internal.xmp.impl.Utils;
import com.adobe.internal.xmp.options.SerializeOptions;
import com.microsoft.identity.client.internal.MsalUtils;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Stack;
import org.apache.poi.javax.xml.XMLConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMLStreamWriterImpl {
    private static final String DEFAULTNS = "";
    private int baseIndent;
    private boolean charIndent;
    private boolean emptyElement;
    private boolean escapeWhitespaces;
    private int indentLevel;
    private char[] indentStr;
    private boolean namespaceLF;
    private char[] newLineStr;
    private boolean preventNextLF;
    private boolean preventWhitespace;
    private Stack qNameStack;
    private final HashSet registeredPrefixes;
    private boolean startElementOpened;
    private Writer writer;

    public XMLStreamWriterImpl(Writer writer, SerializeOptions serializeOptions) {
        this(writer);
        this.newLineStr = serializeOptions.getNewline().toCharArray();
        this.indentStr = serializeOptions.getIndent().toCharArray();
        this.baseIndent = serializeOptions.getBaseIndent();
    }

    private void closeStartElement() throws IOException {
        if (this.startElementOpened) {
            if (this.emptyElement) {
                this.qNameStack.pop();
                write("/>");
                this.emptyElement = false;
                this.indentLevel--;
            } else {
                write(">");
            }
            this.startElementOpened = false;
            this.indentLevel++;
        }
    }

    private boolean needToWriteNamespace(String str) {
        if (this.registeredPrefixes.contains(str)) {
            return false;
        }
        this.registeredPrefixes.add(str);
        return true;
    }

    private void write(String str) throws IOException {
        this.writer.write(str);
    }

    private void writeCharactersInternal(char[] cArr, int i, int i2, boolean z) throws IOException {
        this.indentLevel++;
        this.writer.write(Utils.escapeXML(new String(cArr, i, i2), z, this.escapeWhitespaces));
        this.indentLevel--;
    }

    private void writeCloseElement() throws IOException {
        this.indentLevel--;
        String str = (String) this.qNameStack.pop();
        writeNewLine();
        write("</");
        write(str);
        write(">");
        this.preventWhitespace = false;
    }

    private void writeNewLine() throws IOException {
        if (!this.preventNextLF && !this.preventWhitespace) {
            write(this.newLineStr);
        }
        if (!this.preventWhitespace) {
            for (int i = this.baseIndent + this.indentLevel; i > 0; i--) {
                this.writer.write(this.indentStr);
            }
        }
        this.preventNextLF = false;
    }

    public void close() throws IOException {
        flush();
        this.writer.close();
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public void setEscapeWhitespaces(boolean z) {
        this.escapeWhitespaces = z;
    }

    public void writeAttribute(String str, String str2) throws IOException {
        if (!this.startElementOpened) {
            throw new IOException("A start element must be written before an attribute");
        }
        write(" ");
        write(str);
        write("=\"");
        writeCharactersInternal(str2.toCharArray(), 0, str2.length(), true);
        write("\"");
    }

    public void writeCData(String str) throws IOException {
        closeStartElement();
        write("<![CDATA[");
        if (str != null) {
            write(str);
        }
        write("]]>");
    }

    public void writeCharacters(String str) throws IOException {
        writeCharacters(str.toCharArray(), 0, str.length());
    }

    public void writeComment(String str) throws IOException {
        closeStartElement();
        write("<!--");
        if (str != null) {
            write(str);
        }
        write("-->");
    }

    public void writeDTD(String str) throws IOException {
        writeNewLine();
        write(str);
    }

    public void writeDefaultNamespace(String str) throws IOException {
        if (!this.startElementOpened) {
            throw new IOException("A start element must be written before the default namespace");
        }
        if (needToWriteNamespace("")) {
            write(" xmlns");
            write("=\"");
            write(str);
            write("\"");
        }
    }

    public void writeEmptyElement(String str) throws IOException {
        writeStartElement(str);
        this.emptyElement = true;
    }

    public void writeEndDocument() throws IOException {
        while (!this.qNameStack.isEmpty()) {
            writeEndElement();
        }
    }

    public void writeEndElement() throws IOException {
        if (!this.startElementOpened) {
            writeCloseElement();
            return;
        }
        this.qNameStack.pop();
        write("/>");
        this.startElementOpened = false;
        if (this.emptyElement) {
            writeCloseElement();
            this.emptyElement = false;
        }
    }

    public void writeEntityRef(String str) throws IOException {
        closeStartElement();
        write(MsalUtils.QUERY_STRING_DELIMITER);
        write(str);
        write(";");
    }

    public void writeNamespace(String str, String str2) throws IOException {
        if (!this.startElementOpened) {
            throw new IOException("A start element must be written before a namespace");
        }
        if (str == null || "".equals(str) || XMLConstants.XMLNS_ATTRIBUTE.equals(str)) {
            writeDefaultNamespace(str2);
            return;
        }
        if (needToWriteNamespace(str)) {
            if (this.namespaceLF) {
                this.indentLevel++;
                writeNewLine();
                this.indentLevel--;
            } else {
                write(' ');
            }
            write("xmlns:");
            write(str);
            write("=\"");
            write(str2);
            write("\"");
        }
    }

    public void writeProcessingInstruction(String str) throws IOException {
        closeStartElement();
        writeProcessingInstruction(str, null);
    }

    public void writeStartDocument() throws IOException {
        writeNewLine();
        write("<?xml version='1.0' encoding='utf-8'?>");
    }

    public void writeStartElement(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("The element name may not be null");
        }
        closeStartElement();
        writeNewLine();
        write("<");
        write(str);
        this.startElementOpened = true;
        this.qNameStack.push(str);
    }

    private void write(char c) throws IOException {
        this.writer.write(c);
    }

    public void writeCharacters(char[] cArr, int i, int i2) throws IOException {
        boolean z = this.startElementOpened;
        closeStartElement();
        if (z) {
            if (this.charIndent) {
                writeNewLine();
            } else {
                this.preventWhitespace = true;
            }
        }
        writeCharactersInternal(cArr, i, i2, false);
    }

    private void write(char[] cArr) throws IOException {
        this.writer.write(cArr);
    }

    public void writeProcessingInstruction(String str, String str2) throws IOException {
        closeStartElement();
        writeNewLine();
        write("<?");
        if (str != null) {
            write(str);
        }
        if (str2 != null) {
            write(' ');
            write(str2);
        }
        write("?>");
    }

    public void writeStartDocument(String str) throws IOException {
        writeNewLine();
        write("<?xml version='");
        write(str);
        write("'?>");
    }

    public XMLStreamWriterImpl(Writer writer) {
        this.startElementOpened = false;
        this.emptyElement = false;
        this.qNameStack = new Stack();
        this.newLineStr = new char[]{'\r'};
        this.baseIndent = 0;
        this.indentStr = new char[]{' ', ' '};
        this.indentLevel = 0;
        this.charIndent = false;
        this.namespaceLF = true;
        this.preventWhitespace = false;
        this.preventNextLF = true;
        this.registeredPrefixes = new HashSet();
        this.escapeWhitespaces = true;
        this.writer = writer;
    }

    public void writeStartDocument(String str, String str2) throws IOException {
        writeNewLine();
        write("<?xml version='");
        write(str2);
        write("' encoding='");
        write(str);
        write("'?>");
    }
}
