package opennlp.tools.p217ml.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Sequence<T> {
    private final Event[] events;
    private final T source;

    public Sequence(Event[] eventArr, T t) {
        this.events = eventArr;
        this.source = t;
    }

    public Event[] getEvents() {
        return this.events;
    }

    public T getSource() {
        return this.source;
    }
}
