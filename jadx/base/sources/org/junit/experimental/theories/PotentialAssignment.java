package org.junit.experimental.theories;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class PotentialAssignment {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CouldNotGenerateValueException extends Exception {
        private static final long serialVersionUID = 1;

        public CouldNotGenerateValueException() {
        }

        public CouldNotGenerateValueException(Throwable th) {
            super(th);
        }
    }

    public static PotentialAssignment forValue(final String str, final Object obj) {
        return new PotentialAssignment() { // from class: org.junit.experimental.theories.PotentialAssignment.1
            @Override // org.junit.experimental.theories.PotentialAssignment
            public String getDescription() {
                String strM775q;
                Object obj2 = obj;
                if (obj2 == null) {
                    strM775q = "null";
                } else {
                    try {
                        strM775q = String.format("\"%s\"", obj2);
                    } catch (Throwable th) {
                        strM775q = AbstractC0541b.m775q("[toString() threw ", th.getClass().getSimpleName(), ": ", th.getMessage(), "]");
                    }
                }
                return AbstractC2821a.m2221l(strM775q, " <from ", str, ">");
            }

            @Override // org.junit.experimental.theories.PotentialAssignment
            public Object getValue() {
                return obj;
            }

            public String toString() {
                return String.format("[%s]", obj);
            }
        };
    }

    public abstract String getDescription();

    public abstract Object getValue();
}
