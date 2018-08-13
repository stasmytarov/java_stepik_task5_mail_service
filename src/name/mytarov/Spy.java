package name.mytarov;
import java.util.logging.*;



public class Spy implements MailService {
    private final Logger logger;
    public static final String AUSTIN_POWERS = "Austin Powers";

    public Spy(final Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        String message;
        String from;
        String to;
        if (mail instanceof MailMessage) {
            MailMessage spymail = (MailMessage) mail;
            from = mail.getFrom();
            to = mail.getTo();
            if (mail.getFrom().equals(AUSTIN_POWERS)  || mail.getTo().equals(AUSTIN_POWERS)) {
                message = spymail.getMessage();
                logger.log(Level.WARNING,"Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{from,to,message});
            } else { logger.log(Level.INFO,"Usual correspondence: from {0} to {1}", new Object[] {from,to});
            }
        }
        return mail;
    }

}

