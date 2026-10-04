package opennlp.tools.tokenize;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import opennlp.tools.dictionary.serializer.Attributes;
import opennlp.tools.dictionary.serializer.DictionaryEntryPersistor;
import opennlp.tools.dictionary.serializer.Entry;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DetokenizationDictionary {
    private final Map<String, Operation> operationTable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Operation {
        MOVE_RIGHT,
        MOVE_LEFT,
        MOVE_BOTH,
        RIGHT_LEFT_MATCHING;

        public static Operation parse(String str) {
            if (str == null) {
                return null;
            }
            Operation operation = MOVE_RIGHT;
            if (operation.toString().equals(str)) {
                return operation;
            }
            Operation operation2 = MOVE_LEFT;
            if (operation2.toString().equals(str)) {
                return operation2;
            }
            Operation operation3 = MOVE_BOTH;
            if (operation3.toString().equals(str)) {
                return operation3;
            }
            Operation operation4 = RIGHT_LEFT_MATCHING;
            if (operation4.toString().equals(str)) {
                return operation4;
            }
            return null;
        }
    }

    public DetokenizationDictionary(String[] strArr, Operation[] operationArr) {
        this.operationTable = new HashMap();
        if (strArr.length != operationArr.length) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(strArr.length, operationArr.length, "tokens and ops must have the same length: tokens=", ", operations=", "!"));
        }
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            Operation operation = operationArr[i];
            if (str == null) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i, "token at index ", " must not be null!"));
            }
            if (operation == null) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i, "operation at index ", " must not be null!"));
            }
            this.operationTable.put(str, operation);
        }
    }

    private void init(InputStream inputStream) {
        DictionaryEntryPersistor.create(inputStream, new C11253j(this, 22));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(Entry entry) throws InvalidFormatException {
        String value = entry.attributes().getValue("operation");
        StringList stringList = entry.tokens();
        if (stringList.size() != 1) {
            throw new InvalidFormatException("Each entry must have exactly one token! " + stringList);
        }
        Operation operation = Operation.parse(value);
        if (operation == null) {
            throw new InvalidFormatException(AbstractC0541b.m772n("Unknown operation type: ", value));
        }
        this.operationTable.put(stringList.getToken(0), operation);
    }

    public Operation getOperation(String str) {
        return this.operationTable.get(str);
    }

    public void serialize(OutputStream outputStream) {
        DictionaryEntryPersistor.serialize(outputStream, new Iterator<Entry>() { // from class: opennlp.tools.tokenize.DetokenizationDictionary.1
            final Iterator<String> iterator;

            {
                this.iterator = DetokenizationDictionary.this.operationTable.keySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public Entry next() {
                String next = this.iterator.next();
                Attributes attributes = new Attributes();
                attributes.setValue("operation", DetokenizationDictionary.this.getOperation(next).toString());
                return new Entry(new StringList(next), attributes);
            }
        }, false);
    }

    public DetokenizationDictionary(InputStream inputStream) {
        this.operationTable = new HashMap();
        init(inputStream);
    }

    public DetokenizationDictionary(File file) throws IOException {
        this.operationTable = new HashMap();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            init(bufferedInputStream);
            bufferedInputStream.close();
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public DetokenizationDictionary(Path path) {
        this(path.toFile());
    }
}
