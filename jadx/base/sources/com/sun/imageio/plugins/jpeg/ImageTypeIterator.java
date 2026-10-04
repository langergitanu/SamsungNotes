package com.sun.imageio.plugins.jpeg;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class ImageTypeIterator implements Iterator<ImageTypeSpecifier> {
    private Iterator<ImageTypeProducer> producers;
    private ImageTypeSpecifier theNext = null;

    public ImageTypeIterator(Iterator<ImageTypeProducer> it) {
        this.producers = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.theNext != null) {
            return true;
        }
        if (!this.producers.hasNext()) {
            return false;
        }
        do {
            ImageTypeSpecifier type = this.producers.next().getType();
            this.theNext = type;
            if (type != null) {
                break;
            }
        } while (this.producers.hasNext());
        return this.theNext != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.producers.remove();
    }

    @Override // java.util.Iterator
    public ImageTypeSpecifier next() {
        if (this.theNext == null && !hasNext()) {
            throw new NoSuchElementException();
        }
        ImageTypeSpecifier imageTypeSpecifier = this.theNext;
        this.theNext = null;
        return imageTypeSpecifier;
    }
}
