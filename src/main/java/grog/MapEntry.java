package grog;

public class MapEntry {

    private final Object key;
    private final Object value;

	public MapEntry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

    public Object key() { return key; }

    public Object value() { return value; }
    
}
