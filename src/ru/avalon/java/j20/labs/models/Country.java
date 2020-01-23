package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.Objects;

/*
 * Модель представления о стране.
 */
public class Country {
    /*
     * Код страны.
     */
    private final String code;
    /*
     * Название страны.
     */
    private final String name;

    /*
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /*
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /*
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */
public int hashCode () {
        return Objects.hash(code,name);
    }
    
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj instanceof Country) {
        Country obj2 = (Country) obj;
        return this.code.equals(obj2.code) && this.name.equals(obj2.name);
                }
        return false;
    }
    /*
     * Возвращает экземпляр страны созданный из переданного
     * текста в формате 'Код:Название'.
     *
     * @param text тектс в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка
     * имеет неверный формат.
     */
    public static Country valueOf(String text) throws ParseException {
        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */
        
        char[] array = text.toCharArray();
        char[] codeArray = new char[2];
        char[] nameArray = new char[array.length-3];
        codeArray[0] = array[0];
        codeArray[1] = array[1];
        for (int i = 3; i <= array.length-1; i++) {
            nameArray[i-3] = array[i];
        }
        return new Country (codeArray.toString(), nameArray.toString());
    }
}
