package org.homework.geninterface;
import java.io.IOException;

public interface CodeGeneratorInterface {
    void generateToDirectory(String pathToDirectory, String className) throws IOException;
}
