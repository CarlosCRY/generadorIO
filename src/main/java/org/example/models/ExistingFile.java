package org.example.models;

import java.util.Objects;

public class ExistingFile {
    private String name;
    private String route;

    public ExistingFile(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExistingFile existingFile = (ExistingFile) o;
        return Objects.equals(name, existingFile.name) && Objects.equals(route, existingFile.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, route);
    }

    @Override
    public String toString() {
        return "Generator{" +
                "name='" + name + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
