package org.apache.commons.collections4.properties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SortedPropertiesFactory extends AbstractPropertiesFactory<SortedProperties> {
    public static final SortedPropertiesFactory INSTANCE = new SortedPropertiesFactory();

    private SortedPropertiesFactory() {
    }

    @Override // org.apache.commons.collections4.properties.AbstractPropertiesFactory
    public SortedProperties createProperties() {
        return new SortedProperties();
    }
}
