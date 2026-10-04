package com.samsung.android.support.senl.addons.base.binding.binder;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0010\u001a\u00020\u000bH&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "", "bind", "", "unbind", "setValues", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "setExecuteType", "executeType", "", "getViewKey", "getViewModelId", "", "getBindId", "getExecuteType", "EmptyBinding", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBinding {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int EXECUTE_IMMEDIATE = 0;
    public static final int EXECUTE_VSYNC = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding$Companion;", "", "<init>", "()V", "EXECUTE_IMMEDIATE", "", "EXECUTE_VSYNC", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int EXECUTE_IMMEDIATE = 0;
        public static final int EXECUTE_VSYNC = 1;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding$EmptyBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "<init>", "()V", "setValues", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "setExecuteType", "executeType", "", "unbind", "getViewKey", "getViewModelId", "", "getBindId", "getExecuteType", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class EmptyBinding implements IBinding {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        public void bind() {
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        @NotNull
        /* JADX INFO: renamed from: getBindId */
        public String getMBindId() {
            return "";
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        /* JADX INFO: renamed from: getExecuteType */
        public int getMExecuteType() {
            return 0;
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        /* JADX INFO: renamed from: getViewKey */
        public int getMViewKey() {
            return -1;
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        @NotNull
        /* JADX INFO: renamed from: getViewModelId */
        public String getMViewModelId() {
            return "";
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        public void setExecuteType(int executeType) {
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        public void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder) {
            Intrinsics.checkNotNullParameter(bind, "bind");
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
        public void unbind() {
        }
    }

    void bind();

    @Nullable
    /* JADX INFO: renamed from: getBindId */
    String getMBindId();

    /* JADX INFO: renamed from: getExecuteType */
    int getMExecuteType();

    /* JADX INFO: renamed from: getViewKey */
    int getMViewKey();

    @Nullable
    /* JADX INFO: renamed from: getViewModelId */
    String getMViewModelId();

    void setExecuteType(int executeType);

    void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder);

    void unbind();
}
