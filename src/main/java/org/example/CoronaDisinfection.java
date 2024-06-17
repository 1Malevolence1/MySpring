package org.example;

public class CoronaDisinfection {


    public void start(Room room){
        // todo сообщить всем пресудствующим что нужно покинуть комнату
        // todo разогнать всех кто не вышел из комнаты
        disinfect(room);
        // todo сообщить все что они могу вернуться в комнату
    }

    private void disinfect(Room room){
        System.out.println("Происходит зачистка комнаты");
    }
}
