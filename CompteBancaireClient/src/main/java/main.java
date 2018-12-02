
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import compteBancaire.CompteBancaireRemote;

public class main {

	public static void main(String[] args) throws NamingException, InterruptedException {
		String jndiName = "compteBancaire/CompteBancaire!compteBancaire.CompteBancaireRemote";
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
		//props.setProperty(Context.URL_PKG_PREFIXES, "jboss.naming.client.ejb.context");
		props.setProperty(Context.PROVIDER_URL,"http-remoting://127.0.0.1:8383");		
		Context context = new InitialContext(props);
		
		CompteBancaireRemote proxy = (CompteBancaireRemote) context.lookup(jndiName);
		System.out.println(proxy.versement("Henda Ouni", 50));
		System.out.println(proxy.retrait("Henda Ouni", 10));
		System.out.println(proxy.versement("Henda Ouni", 30));
		System.out.println(proxy.retrait("Henda Ouni", 20));
		
	}

}
