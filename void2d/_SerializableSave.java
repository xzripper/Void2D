// _SerializableSave.java - Part of Void2D.

package void2d;

import java.io.Serializable;
import java.util.HashMap;

class _SerializableSave implements Serializable {
    public HashMap<String, Object> dataToSave;

    public transient String saveFile;

    public _SerializableSave(HashMap<String, Object> _dataToSave, String _saveFile) {
        dataToSave = _dataToSave;

        saveFile = _saveFile;
    }
}
