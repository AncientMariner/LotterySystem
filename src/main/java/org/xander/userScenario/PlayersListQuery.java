package org.xander.userScenario;

import java.util.List;

public class PlayersListQuery<T> {
    List<T> enities;

    public List<T> getEnities() {
        return enities;
    }

    public void setEnities(List<T> enities) {
        this.enities = enities;
    }
}
