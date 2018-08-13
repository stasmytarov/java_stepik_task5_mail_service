package name.mytarov;

public class Thief implements MailService {

    private final int minprice;
    private int sum;


    public Thief (int minprice) {
        this.minprice = minprice;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage thiefmail = (MailPackage) mail;
            Package m = thiefmail.getContent();
            if (m.getPrice() >= minprice){
                sum += m.getPrice();
                return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + m.getContent(), 0));
            }
        }
        return mail;
    }

    public int getStolenValue() {
        return sum;
    }
}

