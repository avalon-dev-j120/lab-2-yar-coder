package ru.avalon.java.j20.labs.tasks;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.models.*;
import static ru.avalon.java.j20.labs.models.Country.valueOf;


/*
 * Задание №6
 *
 * <p>Тема: "Потоковый ввод-вывод. Получение объекта на
 * основании прочитанных данных".
 */
public class Task6 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException, ParseException {
        File input = new File("assets/countries.txt");
        Collection<Country> countries = read(input);
        System.out.println("end of task6");
        /*
         * TODO(Студент): Выполнить задание №6
         *
         * 1. Реализовать метод read.
         *
         * 2. При реализации следует пользоваться классами:
         *    BufferedReader и Country.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /*
     * Выполняет чтение коллекции объектов типа {@link Country}
     * из указанного файла.
     *
     * <p>Выполняет чтение файла построчно. Преобразование
     * из текста в объект выполняется с использованием
     * метода {@code valueOf} класса {@link Country}.
     *
     * @param file файл
     * @return коллекция объектов типа {@link Country}
     * @throws IOException в случае ошибки ввода-вывода.
     */
    private Collection<Country> read(File file) throws IOException, ParseException {
        try (InputStream istream = new FileInputStream(file);
             Reader reader = new InputStreamReader(istream); 
            BufferedReader inputReader = new BufferedReader(reader)) {
            Collection<Country> buffer = new LinkedList<>();
            String line;
            while ((line = inputReader.readLine()) != null) {
                buffer.add(valueOf(line));
            }
            return new ArrayList<>(buffer);
        }
    }
}
