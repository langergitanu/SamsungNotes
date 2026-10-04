package org.apache.poi.openxml4j.opc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class PackagePartCollection implements Serializable {
    private static final long serialVersionUID = 2515031135957635517L;
    private HashSet<String> registerPartNameStr = new HashSet<>();
    private final HashMap<PackagePartName, PackagePart> packagePartLookup = new HashMap<>();

    public boolean containsKey(PackagePartName packagePartName) {
        return this.packagePartLookup.containsKey(packagePartName);
    }

    public PackagePart get(PackagePartName packagePartName) {
        return this.packagePartLookup.get(packagePartName);
    }

    public PackagePart put(PackagePartName packagePartName, PackagePart packagePart) {
        String[] strArrSplit = packagePartName.getURI().toASCIIString().split(PackagingURIHelper.FORWARD_SLASH_STRING);
        StringBuilder sb = new StringBuilder();
        for (String str : strArrSplit) {
            if (!str.equals("")) {
                sb.append(PackagingURIHelper.FORWARD_SLASH_CHAR);
            }
            sb.append(str);
            if (this.registerPartNameStr.contains(sb.toString())) {
                throw new InvalidOperationException("You can't add a part with a part name derived from another part ! [M1.11]");
            }
        }
        this.registerPartNameStr.add(packagePartName.getName());
        return this.packagePartLookup.put(packagePartName, packagePart);
    }

    public PackagePart remove(PackagePartName packagePartName) {
        this.registerPartNameStr.remove(packagePartName.getName());
        return this.packagePartLookup.remove(packagePartName);
    }

    public int size() {
        return this.packagePartLookup.size();
    }

    public Collection<PackagePart> sortedValues() {
        ArrayList arrayList = new ArrayList(this.packagePartLookup.values());
        Collections.sort(arrayList);
        return arrayList;
    }
}
