package example.com.dataitems;

import java.util.ArrayList;
import java.util.List;

import example.com.cloud.R;

public class ChatMessage
{
	private int icon;
	private String name;
	private String content;
	private String createDate;
	private boolean isComMeg;

	public final static int RECIEVE_MSG = 0;
	public final static int SEND_MSG = 1;

	public ChatMessage(int icon, String name, String content, String createDate, boolean isComMeg)
	{
		this.icon = icon;
		this.name = name;
		this.content = content;
		this.createDate = createDate;
		this.isComMeg = isComMeg;
	}

	public boolean isComMeg()
	{
		return isComMeg;
	}

	public void setComMeg(boolean isComMeg)
	{
		this.isComMeg = isComMeg;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getIcon()
	{
		return icon;
	}

	public void setIcon(int icon)
	{
		this.icon = icon;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	@Override
	public String toString()
	{
		return "ChatMessage [icon=" + icon + ", name=" + name + ", content="
				+ content + ", createDate=" + createDate +", isComing = "+ isComMeg()+ "]";
	}

	public static List<ChatMessage> MOCK_DATAS = new ArrayList<>();

	static {
		ChatMessage msg = null;
		msg = new ChatMessage(R.drawable.common_google_signin_btn_icon_dark, "xiaohei", "where are you ",
				null, false);
		MOCK_DATAS.add(msg);
		MOCK_DATAS.add(msg);
	}


}
