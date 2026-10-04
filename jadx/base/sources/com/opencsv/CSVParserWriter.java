package com.opencsv;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CSVParserWriter extends AbstractCSVWriter {
    protected final ICSVParser parser;

    public CSVParserWriter(Writer writer, ICSVParser iCSVParser, String str) {
        super(writer, str);
        this.parser = iCSVParser;
    }

    @Override // com.opencsv.AbstractCSVWriter
    public void writeNext(String[] strArr, boolean z, Appendable appendable) throws IOException {
        this.parser.parseToLine(strArr, z, appendable);
        appendable.append(getLineEnd());
        getWriter().write(appendable.toString());
    }
}
