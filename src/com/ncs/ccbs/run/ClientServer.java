package com.ncs.ccbs.run;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import vn.meg.bossservice.vnp.CallWebService;
import com.ncs.ccbs.util.ErrorUtil;
import org.apache.log4j.Logger;
/**
 * Title : Class Test <br/>
 * Description : <br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 10:26:10 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class ClientServer extends JFrame {
	private static final long	serialVersionUID	=1L;
	JTextField	              tfInputMessage;
	JTextArea	                taContent;
	Socket	                  socket;
	DataInputStream	          dataInputStream;
	DataOutputStream	        dataOutputStream;
	public static Logger	    logger	         =Logger
	                                               .getLogger(ClientServer.class);
	static public String	    rs	             ="";
	public ClientServer() {
		super("MyClient");
		Container con=getContentPane();
		tfInputMessage=new JTextField(20);
		// Gửi dữ liệu
		tfInputMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String input=ae.getActionCommand();
					taContent.append("Client send : "+input+"\n");
					// Gửi dữ liệu
					rs=CallWebService.send(input);
					tfInputMessage.setText(null);
					taContent.append("Server send :"+rs+"\n");
				} catch(Exception e) {
					logger.error("Client Error : "
					    +ErrorUtil.stackTrace2String(e));
				}
			}
		});
		taContent=new JTextArea();
		taContent.setEditable(false);
		con.add(tfInputMessage,"North");
		con.add(new JScrollPane(taContent),"Center");
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String args[]) {
		new ClientServer();
	}
}
