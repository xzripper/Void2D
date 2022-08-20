// SafeSave.java - Part of Void2D.

package void2d;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

import java.util.HashMap;

class SerializableSave {
    public _SerializableSave save;

    public String saveFile;

    public SerializableSave(HashMap<String, Object> _dataToSave, String _saveFile) {
        save = new _SerializableSave(_dataToSave, _saveFile);

        saveFile = _saveFile;
    }

    public void save() throws IOException {
        FileOutputStream _saveFileOutput = new FileOutputStream(saveFile);
        ObjectOutputStream _saveFileObjectOutput = new ObjectOutputStream(_saveFileOutput);

        _saveFileObjectOutput.writeObject(save);

        _saveFileObjectOutput.flush();
        _saveFileObjectOutput.close();
    }

    public _SerializableSave load() throws IOException, ClassNotFoundException {
        FileInputStream _saveFileInput = new FileInputStream(saveFile);
        ObjectInputStream _saveFileObjectInput = new ObjectInputStream(_saveFileInput);

        _SerializableSave loadedSave = (_SerializableSave) _saveFileObjectInput.readObject();

        _saveFileObjectInput.close();

        return loadedSave;
    }
}

/**
 * <h1>Safe game progress saves.</h1>
 * Save game progress in file safely.
 */
public class SafeSave {
    protected SerializableSave serializableSave;

    public HashMap<String, Object> dataToSave;

    public String saveFile;

    /**
     * Initialize new save.
     *
     * @param _dataToSave Data that need to save.
     * @param _saveFile Save file where will be saved data.
     */
    public SafeSave(HashMap<String, Object> _dataToSave, String _saveFile) {
        serializableSave = new SerializableSave(_dataToSave, _saveFile);

        dataToSave = _dataToSave;

        saveFile = _saveFile;
    }

    /**
     * Save data.<br>
     * Creates new file if save file doesn't exist.
     */
    public void saveData() throws IOException {
        serializableSave.save();
    }

    /**
     * Load saved data.<br>
     * If save file is not found, function will return null.<br>
     * It means that data failed to load.<br>
     * You always can check, is data failed to load via <code>SafeSave.failedToLoad</code>.
     *
     * @param saveFile Load from this file.
     */
    public static HashMap<String, Object> loadData(String saveFile) throws IOException, ClassNotFoundException {
        try {
            return new SerializableSave(null, saveFile).load().dataToSave;
        } catch(FileNotFoundException error) {
            return null;
        }
    }

    /**
     * Get is data failed to load.
     *
     * @param out Result (output from <code>SafeSave.loadData</code>).
     */
    public static boolean failedToLoad(HashMap<String, Object> out) {
        return out == null;
    }

    /**
     * Update data to save.
     *
     * @param newDataToSave Updated data to save.
     */
    public void updateDataToSave(HashMap<String, Object> newDataToSave) {
        serializableSave = new SerializableSave(newDataToSave, saveFile);

        dataToSave = newDataToSave;
    }

    /**
     * Update save file.
     *
     * @param newSaveFile New save file where will be saved data.
     */
    public void updateSaveFile(String newSaveFile) {
        serializableSave = new SerializableSave(dataToSave, newSaveFile);

        saveFile = newSaveFile;
    }
}
