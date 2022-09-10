// SafeConfig.java - Part of Void2D.

package void2d;

import java.io.IOException;
import java.util.HashMap;

/**
 * <h1>Safe configs creation.</h1>
 * Create safe configs easily.<br><br>
 * There is no big differences between SafeConfig and SafeSave.<br>
 * Use this class for better reading in code.
 */
public class SafeConfig {
    protected SafeSave _save;

    /**
     * Config data.
     */
    public HashMap<String, Object> cfgData;

    /**
     * Config file.
     */
    public String cfgFile;

    /**
     * Initialize safe config.
     *
     * @param _cfgData Config data.
     * @param _cfgFile Config file.
     */
    public SafeConfig(HashMap<String, Object> _cfgData, String _cfgFile) {
        _save = new SafeSave(_cfgData, _cfgFile);

        cfgData = _cfgData;

        cfgFile = _cfgFile;
    }

    /**
     * Save config.
     */
    public void saveConfig() throws IOException {
        _save.saveData();
    }

    /**
     * Load config.
     *
     * @param _cfgFile Config file.
     */
    public static HashMap<String, Object> loadConfig(String _cfgFile) throws IOException, ClassNotFoundException {
        return SafeSave.loadData(_cfgFile);
    }

    /**
     * Get is data failed to load.
     *
     * @param out Result (output from <code>SafeConfig.loadConfig</code>).
     */
    public static boolean failedToLoad(HashMap<String, Object> out) {
        return out == null;
    }

    /**
     * Update config data.
     *
     * @param newCfgData New config data.
     */
    public void updateConfigData(HashMap<String, Object> newCfgData) {
        _save = new SafeSave(newCfgData, cfgFile);

        cfgData = newCfgData;
    }

    /**
     * Update config file.
     *
     * @param newCfgFile New config file.
     */
    public void updateConfigFile(String newCfgFile) {
        _save = new SafeSave(cfgData, newCfgFile);

        cfgFile = newCfgFile;
    }
}
