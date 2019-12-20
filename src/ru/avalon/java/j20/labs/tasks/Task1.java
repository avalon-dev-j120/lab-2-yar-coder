package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.*;
import java.io.IOException;

/*
 * Задание №1
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в двоичном режиме".
 */
public class Task1 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        System.out.println("Выполняется задача №1");
        File input = new File("assets/countries.txt");
        File output = new File("countries_binary_mode_output.txt");
        String text = read(input);
        write(output, text);

        System.out.println(text);
        
        /*
         * TODO(Студент): Выполнить задание №1
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    InputStream и FileInputStream.
         *
         *    Для сохранениня прочитанных данных следует пользоваться
         *    классом ByteArrayOutputStream.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    OutputStream и FileOutputStream.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /*
     * Выполняет чтение указанного файла в двоичном режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        InputStream istream = null;
        ByteArrayOutputStream ostream = null;
        try {
            istream = new FileInputStream(file);
            ostream = new ByteArrayOutputStream(16);
            byte[] buffer = new byte[16];
            int len;
            while ((len = istream.read(buffer)) != -1) {
                ostream.write(buffer, 0, len);
            }
            byte[] result = ostream.toByteArray();
            return new String(result);
        } finally {
            if (istream !=null) {
                istream.close();
            }
             if (ostream !=null) {
                ostream.close();
            }
        }
    }

    /*
     * Выполняет запись текстоых данных в файл в двоичном
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    
    private void write(File file, String text) throws IOException {
        OutputStream ostream = new FileOutputStream(file);
        byte[] byteArray = text.getBytes();
        ostream.write(byteArray);
        ostream.close();
        
    } 
}
