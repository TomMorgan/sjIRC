import javax.swing.*;
import java.awt.*;


public class Channel {
	String channelName;
	final JTextArea channelTextArea=new JTextArea();
	JScrollPane channelTextAreaScrollPane=new JScrollPane(channelTextArea);
	DefaultListModel nameListModel=new DefaultListModel();
	final JList nameList=new JList(nameListModel);
    JScrollPane nameListScrollPane=new JScrollPane(nameList);
	JPanel channelPanel=new JPanel();
	boolean isChannel=false;
	public Channel() {
		channelTextArea.setFont(new Font("MonoSpaced", Font.BOLD, 12));
		channelTextArea.setLineWrap(true);
		channelTextArea.setWrapStyleWord(true);
		channelTextArea.setEditable(false);
		channelPanel.setLayout(new BorderLayout());
		channelPanel.add(channelTextAreaScrollPane, BorderLayout.CENTER);
		channelPanel.add(nameListScrollPane, BorderLayout.EAST);
		nameListScrollPane.setPreferredSize(new Dimension(150,500));
		
	}
	
	public void setChannelName(String n) {
		channelName=n;
	}
	
	public String getChannelName() {
		return(channelName);
	
	}
	
	public void addTextInTextArea(String n) {
		channelTextArea.append(n);
		channelTextArea.setCaretPosition(channelTextArea.getDocument().getLength());
	}
	
	public void fillNameList(String[] nameListArray, int spaceCount) {
		for (int i=0; i < (spaceCount + 1); i++) {
			nameListModel.addElement(nameListArray[i]);
		}
		
	}
	
	public void nameListRemoveAllElements() {
		nameListModel.removeAllElements();
	}
	
	public void addToNameList(String s) {
		nameListModel.addElement(s);
	}
	
	public JPanel getChannelPanel() {
		return(channelPanel);
	}
	
	public int nameListHandlePart(String name, String selfName) {
		int index;
		
		index=nameListModel.indexOf(name);
		if (index == -1) {
			index=nameListModel.indexOf("@" + name);
			if (index == -1) {
				index=nameListModel.indexOf("+" + name);
			}
		}
		
		nameListModel.removeElementAt(index);
		
		if (name.equals(selfName)==true) {
			nameListModel.clear();
			return(-1);
		}
		return(0);
	}
	
	public int getNameListIndexOf(String s) {
		return(nameListModel.indexOf(s));
	}
	
	public void setNameListElementAt(String s, int i) {
		nameListModel.setElementAt(s, i);
	}
	
	public String getNameListElementAt(int i) {
		return ((String) nameListModel.getElementAt(i));
	}
	public void nameListRemoveElementAt(int i) {
		nameListModel.removeElementAt(i);
	}
	
	public void setIsChannel(boolean b) {
		isChannel=b;
	}

	public boolean getIsChannel() {
		return(isChannel);
	}

}
