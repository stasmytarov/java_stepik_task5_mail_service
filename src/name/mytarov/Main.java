package name.mytarov;
import java.util.logging.*;

public class Main {
    public static  final Logger logger = Logger.getLogger("org.stepic.java.logging.MailMessage");
    public static  int minprice = 100;

    public static void main(String[] args) {
        Spy spy = new Spy(logger);
    Thief thief = new Thief(minprice);
    Inspector inspector = new Inspector();
    InputHelper helper = new InputHelper();
    MailService [] service = {spy, thief, inspector};
    UntrustworthyMailWorker untrustworthyMailWorker = new UntrustworthyMailWorker(service);

    RealMailService realMailService = UntrustworthyMailWorker.getRealMailService();

    String from = helper.getUserInput("Введите имя отправителя:");
        String to = helper.getUserInput("Введите имя получателя:");
        String mailtype = helper.getUserInput("Это посылка или сообщение?");

        if (mailtype.contains("Сообщение")) {
            String message = helper.getUserInput("Введите текст сообщения:");
            untrustworthyMailWorker.processMail(new MailMessage(from, to, message));

        }
        if (mailtype.contains("Посылка")) {
            String content = helper.getUserInput("Введите текст, сообщающий о содержании посылки:");
            String strprice = helper.getUserInput("Введите стоимость посылки:");
            int price = Integer.parseInt(strprice);
            untrustworthyMailWorker.processMail(new MailPackage(from, to, new Package(content, price)));
        }
        System.out.println("Ваше письмо отправлено!");

    }
}
