package name.mytarov;

public class UntrustworthyMailWorker implements MailService {

    private final MailService [] service;
    private static final RealMailService realMailService = new RealMailService();



    public UntrustworthyMailWorker(MailService [] service) {
        this.service = service;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for ( MailService mailService : service ) {
            mail = mailService.processMail(mail);
        }
        mail = realMailService.processMail(mail);
        return mail;
    }

    public static RealMailService getRealMailService() {
        return realMailService;

    }
}