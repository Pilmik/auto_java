package org.homework.generator;

import org.homework.fileutils.FileUtils;
import org.homework.geninterface.CodeGeneratorInterface;

import java.io.IOException;

public class CodeGenerator implements CodeGeneratorInterface {
    public static void main(String[] args) {
        CodeGenerator generator = new CodeGenerator();

        String directoryPath = "generated";
        String className = "GreetingClass";

        if (args.length >= 2) {
            directoryPath = args[0].trim();
            className = args[1].trim();
        } else if (args.length == 1) {
            directoryPath = args[0].trim();
        }

        try {
            generator.generateToDirectory(directoryPath, className);
            System.out.println("Generated " + className + ".java in '" + (directoryPath.isEmpty() ? "current" : directoryPath) + "' directory");
        } catch (IOException e) {
            System.err.println("Error generating file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    @Override
    public void generateToDirectory(String pathToDirectory, String className) throws IOException {
        if (className == null || className.isEmpty() || !className.matches("^[A-Z][A-Za-z0-9]*$")) {
            throw new IllegalArgumentException("Invalid class name: " + className);
        }

        String content = """
            public class %s {
                public void greet() {
                    System.out.println("Hello from %s!");
                }
            }
            """.formatted(className, className);

        FileUtils.writeToFile(pathToDirectory, className + ".java", content);
    }
}