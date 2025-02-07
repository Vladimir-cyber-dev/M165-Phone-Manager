package M165_controllers;

public class SecondMain {
    private final Smartphone smartphone;

    public SecondMain() {
        this.smartphone = new Smartphone();
    }

    public void start() {
        System.out.println("\n█▀█▀█ ▀█ █▀▀ █▀▀  █▀█ █▄▄ ▄▄▄ ▄▄▄ ▄▄░  █▀▀ █▄▄ ▄▄▄ ▄▄▄\n" +
                "█░█░█ ░█ ███ ▄▄▀  █▀▀ █░█ █▄█ █░█ ██▄  ▄▄█ █░█ █▄█ █▄█\n" +
                "░░░░░ ░░ ░░░ ░░░  ░░░ ░░░ ░░░ ░░░ ░░░  ░░░ ░░░ ░░░ █░░");
        System.out.println("Von Vladimir Zivanovic");
        smartphone.manageSmartphones();


    }
}
