package implementation;


import contracts.Engine;

public class EngineToyota implements Engine {
    private final String engineModel;
    private final int engineVersion;

    public EngineToyota(String engineModel, int engineVersion) {
        this.engineModel = engineModel;
        this.engineVersion = engineVersion;
    }

    public String get()
    {
        return "ToyotaEngine:" + engineModel + " " +engineVersion ;
    }
}
