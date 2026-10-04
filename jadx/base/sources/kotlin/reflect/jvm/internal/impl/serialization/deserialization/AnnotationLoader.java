package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface AnnotationLoader<A> {
    @NotNull
    A loadAnnotation(@NotNull ProtoBuf.Annotation annotation, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadCallableAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> loadClassAnnotations(@NotNull ProtoContainer.Class r12);

    @NotNull
    List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.EnumEntry enumEntry);

    @NotNull
    List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property);

    @NotNull
    List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property);

    @NotNull
    List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type type, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadValueParameterAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i, @NotNull ProtoBuf.ValueParameter valueParameter);
}
