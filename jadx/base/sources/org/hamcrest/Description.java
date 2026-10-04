package org.hamcrest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Description {
    public static final Description NONE = new NullDescription();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NullDescription implements Description {
        @Override // org.hamcrest.Description
        public <T> Description appendValueList(String str, String str2, String str3, Iterable<T> iterable) {
            return this;
        }

        public String toString() {
            return "";
        }

        @Override // org.hamcrest.Description
        public <T> Description appendValueList(String str, String str2, String str3, T... tArr) {
            return this;
        }

        @Override // org.hamcrest.Description
        public Description appendDescriptionOf(SelfDescribing selfDescribing) {
            return this;
        }

        @Override // org.hamcrest.Description
        public Description appendText(String str) {
            return this;
        }

        @Override // org.hamcrest.Description
        public Description appendValue(Object obj) {
            return this;
        }

        @Override // org.hamcrest.Description
        public Description appendList(String str, String str2, String str3, Iterable<? extends SelfDescribing> iterable) {
            return this;
        }
    }

    Description appendDescriptionOf(SelfDescribing selfDescribing);

    Description appendList(String str, String str2, String str3, Iterable<? extends SelfDescribing> iterable);

    Description appendText(String str);

    Description appendValue(Object obj);

    <T> Description appendValueList(String str, String str2, String str3, Iterable<T> iterable);

    <T> Description appendValueList(String str, String str2, String str3, T... tArr);
}
