package ro.edu.ubb.servlet;

/*import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.edu.ubb.service.UserService;

/**
 * Servlet for forgotten password.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
/*public class ForgotPdServlet extends HttpServlet{

	/**
	 * 
	 */
	/*private static final long serialVersionUID = -663150891209934794L;
	private UserService userService = new UserService();
	private static String USER_NAME="orsolya97nemet";
	private static String PDUSER="";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		String from=USER_NAME;
		String pass=PDUSER;
		String[] to= {req.getParameter("email")};
		String subject="Forgot password";
		byte[] pdUserBytes=new byte[7];
		new Random().nextBytes(pdUserBytes);
		String newPdUser=new String(pdUserBytes, Charset.forName("UTF-8"));
		String body="Please login using the following password: "+newPdUser+" and after you are logged in CHANGE the given password. Thank you!		Administrator of UBB Room Booking ";
		try {
			sendMail(from,pass,to,subject,body);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		dispatch("login.jsp",req,res);
	}
	
	private static void sendMail(String from, String pass, String[] to, String subject, String body) throws ServletException, AddressException, MessagingException {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses
		for( int i = 0; i < to.length; i++ ) {
		    toAddress[i] = new InternetAddress(to[i]);
		}
		
		for( int i = 0; i < toAddress.length; i++) {
		    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);
		Transport transport = session.getTransport("smtp");
		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
    }

	public void dispatch(String jsp, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		if (jsp != null) {
			RequestDispatcher rd = req.getRequestDispatcher(jsp);
			rd.forward(req, res);
		}
	}
}*/
