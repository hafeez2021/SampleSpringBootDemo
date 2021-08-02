package implementation;

import contracts.Engine;

public class EngineHonda implements Engine {
    private final String engineModel;
    private final int engineVersion;

    public EngineHonda(String engineModel, int engineVersion) {
        this.engineModel = engineModel;
        this.engineVersion = engineVersion;
    }

    public String get()
    {
        return "HondaEngine:" + engineModel + " " +engineVersion;
    }
}
