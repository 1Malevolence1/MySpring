package org.example;

public class CoronaDisinfection {


    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    public  Policeman policemen = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room){
        announcer.announce("Начинаентся дизинфекция. Выйдите из комнаты");
        policemen.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("Рескните вернуться туда обратно");
    }

    private void disinfect(Room room){
        System.out.println("Происходит зачистка комнаты");
    }
}
