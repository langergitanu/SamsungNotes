package opennlp.tools.util.eval;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.Collection;
import java.util.NoSuchElementException;
import opennlp.tools.util.CollectionObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CrossValidationPartitioner<E> {
    private TrainingSampleStream<E> lastTrainingSampleStream;
    private final int numberOfPartitions;
    private final ObjectStream<E> sampleStream;
    private int testIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TestSampleStream<E> implements ObjectStream<E> {
        private int index;
        private boolean isPoisoned;
        private final int numberOfPartitions;
        private final ObjectStream<E> sampleStream;
        private final int testIndex;

        public /* synthetic */ TestSampleStream(ObjectStream objectStream, int i, int i2, int i4) {
            this(objectStream, i, i2);
        }

        @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
        public void close() {
            this.sampleStream.close();
            this.isPoisoned = true;
        }

        public void poison() {
            this.isPoisoned = true;
        }

        @Override // opennlp.tools.util.ObjectStream
        public E read() {
            if (this.isPoisoned) {
                throw new IllegalStateException();
            }
            while (true) {
                int i = this.index;
                if (i % this.numberOfPartitions == this.testIndex) {
                    this.index = i + 1;
                    return this.sampleStream.read();
                }
                this.sampleStream.read();
                this.index++;
            }
        }

        @Override // opennlp.tools.util.ObjectStream
        public void reset() {
            throw new UnsupportedOperationException();
        }

        private TestSampleStream(ObjectStream<E> objectStream, int i, int i2) {
            this.numberOfPartitions = i;
            this.sampleStream = objectStream;
            this.testIndex = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TrainingSampleStream<E> implements ObjectStream<E> {
        private int index;
        private boolean isPoisoned;
        private final int numberOfPartitions;
        private final ObjectStream<E> sampleStream;
        private final int testIndex;
        private TestSampleStream<E> testSampleStream;

        public TrainingSampleStream(ObjectStream<E> objectStream, int i, int i2) {
            this.numberOfPartitions = i;
            this.sampleStream = objectStream;
            this.testIndex = i2;
        }

        @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
        public void close() {
            this.sampleStream.close();
            poison();
        }

        public ObjectStream<E> getTestSampleStream() {
            if (this.isPoisoned) {
                throw new IllegalStateException();
            }
            if (this.testSampleStream == null) {
                this.sampleStream.reset();
                this.testSampleStream = new TestSampleStream<>(this.sampleStream, this.numberOfPartitions, this.testIndex, 0);
            }
            return this.testSampleStream;
        }

        public void poison() {
            this.isPoisoned = true;
            TestSampleStream<E> testSampleStream = this.testSampleStream;
            if (testSampleStream != null) {
                testSampleStream.poison();
            }
        }

        @Override // opennlp.tools.util.ObjectStream
        public E read() {
            if (this.testSampleStream != null || this.isPoisoned) {
                throw new IllegalStateException();
            }
            if (this.index % this.numberOfPartitions == this.testIndex) {
                this.sampleStream.read();
                this.index++;
            }
            this.index++;
            return this.sampleStream.read();
        }

        @Override // opennlp.tools.util.ObjectStream
        public void reset() {
            if (this.testSampleStream != null || this.isPoisoned) {
                throw new IllegalStateException();
            }
            this.index = 0;
            this.sampleStream.reset();
        }
    }

    public CrossValidationPartitioner(ObjectStream<E> objectStream, int i) {
        this.sampleStream = objectStream;
        this.numberOfPartitions = i;
    }

    public boolean hasNext() {
        return this.testIndex < this.numberOfPartitions;
    }

    public TrainingSampleStream<E> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        TrainingSampleStream<E> trainingSampleStream = this.lastTrainingSampleStream;
        if (trainingSampleStream != null) {
            trainingSampleStream.poison();
        }
        this.sampleStream.reset();
        TrainingSampleStream<E> trainingSampleStream2 = new TrainingSampleStream<>(this.sampleStream, this.numberOfPartitions, this.testIndex);
        this.testIndex++;
        this.lastTrainingSampleStream = trainingSampleStream2;
        return trainingSampleStream2;
    }

    public String toString() {
        return AbstractC1038a.m1214o(this.testIndex + 1, this.numberOfPartitions, "At partition", " of ");
    }

    public CrossValidationPartitioner(Collection<E> collection, int i) {
        this(new CollectionObjectStream(collection), i);
    }
}
