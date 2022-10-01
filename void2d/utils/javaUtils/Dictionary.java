// Dictionary.java - Part of Void2D.

package void2d.utils.javaUtils;

import java.util.ArrayList;

/**
 * Dictionary util.
 */
public class Dictionary {
    protected ArrayList<Object> keys = new ArrayList<>();
    protected ArrayList<Object> values = new ArrayList<>();

    /**
     * Initialize new dictionary.
     */
    public Dictionary() {}

    /**
     * Append dictionary.
     *
     * @param key Key.
     * @param value Value.
     */
    public <KeyType, ValueType> void add(KeyType key, ValueType value) {
        keys.add(key);
        values.add(value);
    }

    /**
     * Remove element from dictionary by key.
     *
     * @param key Key.
     */
    public <KeyType> void remove(KeyType key) {
        if(!keys.contains(key)) { return; }

        int keyIndex = keys.indexOf(key);

        keys.remove(keyIndex);
        values.remove(keyIndex);
    }

    /**
     * Remove element from dictionary by index.
     *
     * @param index Index.
     */
    public void remove(int index) {
        if(index < 0 || index > size()) { return; }

        keys.remove(index);
        values.remove(index);
    }

    /**
     * Get value by key.
     *
     * @param key Key.
     */
    public <KeyType> Object get(KeyType key) {
        if(!keys.contains(key)) {
            return null;
        }

        int keyIndex = keys.indexOf(key);

        return values.get(keyIndex);
    }

    /**
     * Get value by index.
     *
     * @param index Index.
     */
    public Object get(int index) {
        return values.get(index);
    }

    /**
     * Clear dictionary.
     */
    public void clear() {
        keys.clear();
        values.clear();
    }

    /**
     * Is dictionary contains a key.
     *
     * @param key Key.
     */
    public <KeyType> boolean containsKey(KeyType key) {
        return keys.contains(key);
    }

    /**
     * Is dictionary contains a value.
     *
     * @param value Value.
     */
    public <ValueType> boolean containsValue(ValueType value) {
        return values.contains(value);
    }

    /**
     * Get keys.
     */
    public Object[] getKeys() {
        return keys.toArray(new Object[0]);
    }

    /**
     * Get values.
     */
    public Object[] getValues() {
        return values.toArray(new Object[0]);
    }

    /**
     * Get dictionary size.
     */
    public int size() {
        return keys.size();
    }

    /**
     * Get dictionary as string.
     */
    public String asString() {
        StringBuilder res = new StringBuilder();

        res.append("(");

        for(int keyIndex=0; keyIndex < size(); keyIndex++) {
            if(keyIndex >= size() - 1) {
                res.append(String.format("%s: %s", getKeys()[keyIndex], get(keyIndex)));
            } else {
                res.append(String.format("%s: %s, ", getKeys()[keyIndex], get(keyIndex)));
            }
        }

        res.append(");");

        return res.toString();
    }
}
