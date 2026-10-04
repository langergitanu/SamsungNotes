package org.junit.runners.model;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class InvalidTestClassError extends InitializationError {
    private static final long serialVersionUID = 1;
    private final String message;

    public InvalidTestClassError(Class<?> cls, List<Throwable> list) {
        super(list);
        this.message = createMessage(cls, list);
    }

    private static String createMessage(Class<?> cls, List<Throwable> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid test class '" + cls.getName() + "':");
        Iterator<Throwable> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            sb.append("\n  " + i + ". " + it.next().getMessage());
            i++;
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
