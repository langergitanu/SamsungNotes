package kotlin.annotation;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m13886d2 = {"Lkotlin/annotation/AnnotationTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", CredentialProviderBaseController.TYPE_TAG, "EXPRESSION", "FILE", "TYPEALIAS", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AnnotationTarget {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnnotationTarget[] $VALUES;
    public static final AnnotationTarget CLASS = new AnnotationTarget("CLASS", 0);
    public static final AnnotationTarget ANNOTATION_CLASS = new AnnotationTarget("ANNOTATION_CLASS", 1);
    public static final AnnotationTarget TYPE_PARAMETER = new AnnotationTarget("TYPE_PARAMETER", 2);
    public static final AnnotationTarget PROPERTY = new AnnotationTarget("PROPERTY", 3);
    public static final AnnotationTarget FIELD = new AnnotationTarget("FIELD", 4);
    public static final AnnotationTarget LOCAL_VARIABLE = new AnnotationTarget("LOCAL_VARIABLE", 5);
    public static final AnnotationTarget VALUE_PARAMETER = new AnnotationTarget("VALUE_PARAMETER", 6);
    public static final AnnotationTarget CONSTRUCTOR = new AnnotationTarget("CONSTRUCTOR", 7);
    public static final AnnotationTarget FUNCTION = new AnnotationTarget("FUNCTION", 8);
    public static final AnnotationTarget PROPERTY_GETTER = new AnnotationTarget("PROPERTY_GETTER", 9);
    public static final AnnotationTarget PROPERTY_SETTER = new AnnotationTarget("PROPERTY_SETTER", 10);
    public static final AnnotationTarget TYPE = new AnnotationTarget(CredentialProviderBaseController.TYPE_TAG, 11);
    public static final AnnotationTarget EXPRESSION = new AnnotationTarget("EXPRESSION", 12);
    public static final AnnotationTarget FILE = new AnnotationTarget("FILE", 13);

    @SinceKotlin(version = "1.1")
    public static final AnnotationTarget TYPEALIAS = new AnnotationTarget("TYPEALIAS", 14);

    private static final /* synthetic */ AnnotationTarget[] $values() {
        return new AnnotationTarget[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS};
    }

    static {
        AnnotationTarget[] annotationTargetArr$values = $values();
        $VALUES = annotationTargetArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(annotationTargetArr$values);
    }

    private AnnotationTarget(String str, int i) {
    }

    @NotNull
    public static EnumEntries<AnnotationTarget> getEntries() {
        return $ENTRIES;
    }

    public static AnnotationTarget valueOf(String str) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, str);
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[]) $VALUES.clone();
    }
}
