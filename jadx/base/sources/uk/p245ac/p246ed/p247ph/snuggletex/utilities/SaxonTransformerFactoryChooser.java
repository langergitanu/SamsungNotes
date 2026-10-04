package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import javax.xml.transform.TransformerFactory;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleRuntimeException;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SaxonTransformerFactoryChooser implements TransformerFactoryChooser {
    private static final SaxonTransformerFactoryChooser singletonInstance = new SaxonTransformerFactoryChooser();

    public static SaxonTransformerFactoryChooser getInstance() {
        return singletonInstance;
    }

    public TransformerFactory getSaxonTransformerFactory() {
        try {
            return XMLUtilities.createSaxonTransformerFactory();
        } catch (SnuggleRuntimeException e) {
            throw new SnuggleRuntimeException("SaxonTransformerFactoryChooser could not instantiate the TransformerFactoryImpl provided by Saxon", e);
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.utilities.TransformerFactoryChooser
    public TransformerFactory getSuitableXSLT10TransformerFactory() {
        return getSaxonTransformerFactory();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.utilities.TransformerFactoryChooser
    public TransformerFactory getSuitableXSLT20TransformerFactory() {
        return getSaxonTransformerFactory();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.utilities.TransformerFactoryChooser
    public boolean isXSLT20SupportAvailable() {
        return true;
    }
}
