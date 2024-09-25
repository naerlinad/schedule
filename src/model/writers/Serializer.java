package model.writers;

import java.io.*;

public class Serializer implements Writer {
    private String path;

    public Serializer() {
        path = readConfig();
    }

    @Override
    public void write(Serializable obj) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
        outputStream.writeObject(obj);
        outputStream.close();
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj = inputStream.readObject();
        inputStream.close();
        return obj;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
        writeConfig(path);
    }

    private void writeConfig (String path) {
        try (FileWriter fileWriter = new FileWriter("src/model/writers/serializerConfig.txt")) {
            fileWriter.write(path);
            fileWriter.flush();
        } catch (Exception _) {

        }
    }

    private String readConfig() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/model/writers/serializerConfig.txt"))) {
            String path = reader.readLine();
            if (path.isEmpty()) return "schedule.save";
            return path;
        } catch (Exception e) {
            String path = "schedule.save";
            writeConfig(path);
            return path;
        }
    }

    public String getPath() {
        return path;
    }
}
