package org.apache.commons.text.lookup;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractPathFencedLookup extends AbstractStringLookup {
    protected final List<Path> fences;

    public AbstractPathFencedLookup(Path... pathArr) {
        this.fences = pathArr != null ? (List) Arrays.stream(pathArr).map(new C13960e(1)).collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }

    public Path getPath(String str) {
        Path path = Paths.get(str, new String[0]);
        if (this.fences.isEmpty()) {
            return path;
        }
        final Path absolutePath = path.normalize().toAbsolutePath();
        Stream<Path> stream = this.fences.stream();
        Objects.requireNonNull(absolutePath);
        if (stream.filter(new Predicate() { // from class: org.apache.commons.text.lookup.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return absolutePath.startsWith((Path) obj);
            }
        }).findFirst().isPresent()) {
            return path;
        }
        throw IllegalArgumentExceptions.format("[%s] -> [%s] not in %s", str, absolutePath, this.fences);
    }
}
