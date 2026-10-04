package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DescriptorBasedDeprecationInfo extends DeprecationInfo {
    public boolean getForcePropagationToOverrides() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo
    public boolean getPropagatesToOverrides() {
        return getForcePropagationToOverrides();
    }
}
