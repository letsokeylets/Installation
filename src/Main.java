import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        //Создание основаных директорий src, res, savegames, temp
        str.append(addDir(new File("C://Games//src")));
        str.append(addDir(new File("C://Games//res")));
        str.append(addDir(new File("C://Games//savegames")));
        str.append(addDir(new File("C://Games//temp")));
        //Добавление дирректорий main и test
        str.append(addDir(new File("C://Games//src//main")));
        str.append(addDir(new File("C://Games//src//test")));
        //Добавление основных файлов: Main.java, Utils.java
        str.append(addFile(new File("C://Games//src//main//Main.java")));
        str.append(addFile(new File("C://Games//src//main//Utils.java")));
        //Добавление в каталог res директории: drawables, vectors, icons
        str.append(addDir(new File("C://Games//res//drawables")));
        str.append(addDir(new File("C://Games//res//vectors")));
        str.append(addDir(new File("C://Games//res//icons")));
        //Создание temp.txt
        str.append(addFile(new File("C://Games//temp//temp.txt")));
        //Произведём запись логов в файл temp.txt
        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt")) {
            writer.write(str.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(str);
    }

    //Метод для создания дирректорий
    private static String addDir(File file) {
        String str;
        str = "В каталог " + file.getParent();
        if (file.mkdir()) return str + " добавлена дирректория: " + file.getName() + "\n";
        else return str + " добавление дирректории: " + file.getName() + " - невозможно" + "\n";
    }

    //Метод для создания файлов
    private static String addFile(File file) {
        String str;
        str = "В каталог " + file.getParent();
        try {
            if (file.createNewFile())
                str = str + " добавлен файл " + file.getName() + "\n";
            else str = str + " добавление файла " + file.getName() + " невозможно" + "\n";
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str;
    }
}
