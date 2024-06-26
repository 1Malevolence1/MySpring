package org.example;

public class CoronaDisinfection {


    @InjectByType
    private Announcer announcer;
    @InjectByType
    public  Policeman policemen;

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
