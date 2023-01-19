public interface IFile {
    void write(String data);

    String read();
}

public class DataDecorator implements IFile {
    protected IFile decorator;

    public DataDecorator(IFile decorator) {
        this.decorator = decorator;
    }

    @Override
    public void write(String data) {
        System.out.println("Write " + data);
    }

    @Override
    public String read() {
        return "Read";
    }
}
public class Demo {
    public static void main(String[] args){
        DataDecorator data = new XMLReader(new YAL(new Folder(new TXT())));
        data.write("decoratedData");
        System.out.println();
        data.read();
    }
}
public class Folder extends DataDecorator {

    public Folder(IFile decorator) {
        super(decorator);
    }

    @Override
    public void write(String data) {
        super.write(data);
        System.out.println("Write " + data + " to folder");
    }

    @Override
    public String read() {
        super.read();
        return "Read folder";
    }
}

public class TXT implements IFile {
    @Override
    public void write(String data) {
        System.out.println("Write " + data + " to file txt");
    }

    @Override
    public String read() {
        return "Read file txt";
    }
}
public class XMLReader extends DataDecorator {

    public XMLReader(IFile decoratedReader) {
        super(decoratedReader);
    }

    @Override
    public void write(String data) {
        super.write(data);
        System.out.println("Write " + data + " to file xml");
    }

    @Override
    public String read() {
        super.read();
        return "Read file xml";
    }
}
public class YAL extends DataDecorator {

    public YAL(IFile decorator) {

        super(decorator);
    }

    @Override
    public void write(String data) {
        super.write(data);
        System.out.println("Write " + data + " to file yal");
    }

    @Override
    public String read() {
        super.read();
        return "Read file yal";
    }
}


