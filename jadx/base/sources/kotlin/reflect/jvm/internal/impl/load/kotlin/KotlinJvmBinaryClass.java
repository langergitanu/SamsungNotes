package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface KotlinJvmBinaryClass {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AnnotationArgumentVisitor {
        void visit(@Nullable Name name, @Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId);

        @Nullable
        AnnotationArrayArgumentVisitor visitArray(@Nullable Name name);

        void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(@Nullable Name name, @NotNull ClassId classId, @NotNull Name name2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AnnotationArrayArgumentVisitor {
        void visit(@Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId);

        void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(@NotNull ClassId classId, @NotNull Name name);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement);

        void visitEnd();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MemberVisitor {
        @Nullable
        AnnotationVisitor visitField(@NotNull Name name, @NotNull String str, @Nullable Object obj);

        @Nullable
        MethodAnnotationVisitor visitMethod(@NotNull Name name, @NotNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitParameterAnnotation(int i, @NotNull ClassId classId, @NotNull SourceElement sourceElement);
    }

    @NotNull
    KotlinClassHeader getClassHeader();

    @NotNull
    ClassId getClassId();

    @NotNull
    String getLocation();

    void loadClassAnnotations(@NotNull AnnotationVisitor annotationVisitor, @Nullable byte[] bArr);

    void visitMembers(@NotNull MemberVisitor memberVisitor, @Nullable byte[] bArr);
}
