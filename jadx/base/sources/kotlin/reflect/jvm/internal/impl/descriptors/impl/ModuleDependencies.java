package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ModuleDependencies {
    @NotNull
    List<ModuleDescriptorImpl> getAllDependencies();

    @NotNull
    List<ModuleDescriptorImpl> getDirectExpectedByDependencies();

    @NotNull
    Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible();
}
