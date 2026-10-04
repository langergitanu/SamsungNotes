package opennlp.tools.entitylinker;

import java.util.Objects;
import opennlp.tools.util.ext.ExtensionLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EntityLinkerFactory {
    public static synchronized EntityLinker<?> getLinker(String str, EntityLinkerProperties entityLinkerProperties) {
        EntityLinker<?> entityLinker;
        if (str == null || entityLinkerProperties == null) {
            throw new IllegalArgumentException("Null argument in entityLinkerFactory");
        }
        String property = entityLinkerProperties.getProperty("linker.".concat(str), "");
        if (property == null || property.isEmpty()) {
            throw new IllegalArgumentException("linker." + str + "  property must be set!");
        }
        entityLinker = (EntityLinker) ExtensionLoader.instantiateExtension(EntityLinker.class, property);
        entityLinker.init(entityLinkerProperties);
        return entityLinker;
    }

    public static synchronized EntityLinker<?> getLinker(EntityLinkerProperties entityLinkerProperties) {
        EntityLinker<?> entityLinker;
        Objects.requireNonNull(entityLinkerProperties, "properties argument must not be null");
        String property = entityLinkerProperties.getProperty("linker", "");
        if (property != null && !property.isEmpty()) {
            entityLinker = (EntityLinker) ExtensionLoader.instantiateExtension(EntityLinker.class, property);
            entityLinker.init(entityLinkerProperties);
        } else {
            throw new IllegalArgumentException("\"linker\" property must be set!");
        }
        return entityLinker;
    }
}
