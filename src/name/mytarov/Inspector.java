package name.mytarov;

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage inspectormail = (MailPackage) mail;
            Package m3 = inspectormail.getContent();
            if (m3.getContent().contains("weapons") || m3.getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            }
            if (m3.getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;

    }
}
