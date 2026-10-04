package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ServiceDescriptor {
    private final Collection<MethodDescriptor<?, ?>> methods;
    private final String name;
    private final Object schemaDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private List<MethodDescriptor<?, ?>> methods;
        private String name;
        private Object schemaDescriptor;

        /* JADX INFO: Access modifiers changed from: private */
        public Builder addAllMethods(Collection<MethodDescriptor<?, ?>> collection) {
            this.methods.addAll(collection);
            return this;
        }

        public Builder addMethod(MethodDescriptor<?, ?> methodDescriptor) {
            this.methods.add((MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, "method"));
            return this;
        }

        public ServiceDescriptor build() {
            return new ServiceDescriptor(this);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2666")
        public Builder setName(String str) {
            this.name = (String) Preconditions.checkNotNull(str, "name");
            return this;
        }

        public Builder setSchemaDescriptor(@Nullable Object obj) {
            this.schemaDescriptor = obj;
            return this;
        }

        private Builder(String str) {
            this.methods = new ArrayList();
            setName(str);
        }
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static void validateMethodNames(String str, Collection<MethodDescriptor<?, ?>> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (MethodDescriptor<?, ?> methodDescriptor : collection) {
            Preconditions.checkNotNull(methodDescriptor, "method");
            String serviceName = methodDescriptor.getServiceName();
            Preconditions.checkArgument(str.equals(serviceName), "service names %s != %s", serviceName, str);
            Preconditions.checkArgument(hashSet.add(methodDescriptor.getFullMethodName()), "duplicate name %s", methodDescriptor.getFullMethodName());
        }
    }

    public Collection<MethodDescriptor<?, ?>> getMethods() {
        return this.methods;
    }

    public String getName() {
        return this.name;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    @Nullable
    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.name).add("schemaDescriptor", this.schemaDescriptor).add("methods", this.methods).omitNullValues().toString();
    }

    public ServiceDescriptor(String str, MethodDescriptor<?, ?>... methodDescriptorArr) {
        this(str, Arrays.asList(methodDescriptorArr));
    }

    public ServiceDescriptor(String str, Collection<MethodDescriptor<?, ?>> collection) {
        this(newBuilder(str).addAllMethods((Collection) Preconditions.checkNotNull(collection, "methods")));
    }

    private ServiceDescriptor(Builder builder) {
        String str = builder.name;
        this.name = str;
        validateMethodNames(str, builder.methods);
        this.methods = Collections.unmodifiableList(new ArrayList(builder.methods));
        this.schemaDescriptor = builder.schemaDescriptor;
    }
}
