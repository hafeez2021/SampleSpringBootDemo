package implementation;

import contracts.Brake;
import contracts.Pad;
import contracts.Persistence;

public class BrakeBrembo implements Brake {

    private final Pad pad;
    private final Persistence persistence;

    public BrakeBrembo(Pad pad, Persistence persistence)
    {

        this.pad = pad;
        this.persistence = persistence;
    }
    public String get() {
        return "Brembo " + "with Pad:" +pad.get() + " From Persistence:" + persistence.get();
    }
}
