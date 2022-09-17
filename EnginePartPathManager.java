package void2d;

class EnginePartPathManager {
    public static String accessEnginePart(String enginePart) {
        return (EngineInfo.engineVersionInRelease) ? String.format("void2d\\%s", enginePart) : String.format("src\\void2d\\%s", enginePart);
    }

    public static String accessEnginePartWithAbsolutePath(String enginePart) {
        return String.format("%s\\%s", System.getProperty("user.dir"), accessEnginePart(enginePart));
    }
}
