package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SourceElement {
    public static final SourceElement NO_SOURCE = new SourceElement() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.1
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1.getContainingFile must not return null");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        @NotNull
        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            if (sourceFile == null) {
                $$$reportNull$$$0(0);
            }
            return sourceFile;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    };

    @NotNull
    SourceFile getContainingFile();
}
