package org.apache.commons.lang3;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.arch.Processor;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArchUtils {
    private static final Map<String, Processor> ARCH_TO_PROCESSOR = new HashMap();

    static {
        init();
    }

    @Deprecated
    public ArchUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addProcessor(String str, Processor processor) {
        Map<String, Processor> map = ARCH_TO_PROCESSOR;
        if (map.containsKey(str)) {
            throw new IllegalStateException(AbstractC0541b.m773o("Key ", str, " already exists in processor map"));
        }
        map.put(str, processor);
    }

    private static void addProcessors(Processor processor, String... strArr) {
        org.apache.commons.lang3.stream.Streams.m14874of(strArr).forEach(new C4191n(processor, 25));
    }

    public static Processor getProcessor() {
        return getProcessor(SystemProperties.getOsArch());
    }

    private static void init() {
        init_X86_32Bit();
        init_X86_64Bit();
        init_IA64_32Bit();
        init_IA64_64Bit();
        init_PPC_32Bit();
        init_PPC_64Bit();
        init_Aarch_64Bit();
        init_RISCV_32Bit();
        init_RISCV_64Bit();
    }

    private static void init_Aarch_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64), "aarch64");
    }

    private static void init_IA64_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64), "ia64_32", "ia64n");
    }

    private static void init_IA64_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64), "ia64", "ia64w");
    }

    private static void init_PPC_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.PPC), "ppc", "power", "powerpc", "power_pc", "power_rs");
    }

    private static void init_PPC_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.PPC), "ppc64", "power64", "powerpc64", "power_pc64", "power_rs64");
    }

    private static void init_RISCV_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.RISC_V), "riscv32");
    }

    private static void init_RISCV_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V), "riscv64");
    }

    private static void init_X86_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.X86), "x86", "i386", "i486", "i586", "i686", "pentium");
    }

    private static void init_X86_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.X86), "x86_64", "amd64", "em64t", "universal");
    }

    public static Processor getProcessor(String str) {
        return ARCH_TO_PROCESSOR.get(str);
    }
}
