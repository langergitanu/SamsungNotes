package org.apache.commons.beanutils.converters;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import opennlp.tools.parser.Parse;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public abstract class AbstractArrayConverter implements Converter {
    public static final Object NO_DEFAULT = new Object();
    protected static String[] strings = new String[0];
    protected Object defaultValue;
    protected boolean useDefault;

    public AbstractArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    @Override // org.apache.commons.beanutils.Converter
    public abstract Object convert(Class cls, Object obj);

    public List<String> parseElements(String str) {
        int iNextToken;
        Objects.requireNonNull(str, "svalue");
        String strTrim = str.trim();
        if (strTrim.startsWith(Parse.BRACKET_LCB) && strTrim.endsWith("}")) {
            strTrim = AbstractC2322a.m1614d(1, 1, strTrim);
        }
        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(strTrim));
            streamTokenizer.whitespaceChars(44, 44);
            streamTokenizer.ordinaryChars(48, 57);
            streamTokenizer.ordinaryChars(46, 46);
            streamTokenizer.ordinaryChars(45, 45);
            streamTokenizer.wordChars(48, 57);
            streamTokenizer.wordChars(46, 46);
            streamTokenizer.wordChars(45, 45);
            ArrayList arrayList = new ArrayList();
            while (true) {
                iNextToken = streamTokenizer.nextToken();
                if (iNextToken != -3 && iNextToken <= 0) {
                    break;
                }
                arrayList.add(streamTokenizer.sval);
            }
            if (iNextToken == -1) {
                return arrayList;
            }
            throw new ConversionException("Encountered token of type " + iNextToken);
        } catch (IOException e) {
            throw new ConversionException(e);
        }
    }

    public AbstractArrayConverter(Object obj) {
        this.useDefault = true;
        if (obj == NO_DEFAULT) {
            this.useDefault = false;
        } else {
            this.defaultValue = obj;
            this.useDefault = true;
        }
    }
}
