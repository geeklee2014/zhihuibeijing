package com.siyuan.zhbj.domain;

import java.util.ArrayList;

public class NewsBean
{
	@Override
	public String toString()
	{
		return "NewsBean [retcode=" + retcode + ", data=" + data + ", extend="
				+ extend + "]";
	}

	public int retcode;
	public ArrayList<NewsData> data;
	public ArrayList<String> extend;

	public class NewsData
	{
		public String id;
		public String title;
		public String type;
		public String url;

		@Override
		public String toString()
		{
			return "NewsData [id=" + id + ", title=" + title + ", type=" + type
					+ ", url=" + url + ", children=" + children + "]";
		}

		public ArrayList<NewsTabData> children;

		public class NewsTabData
		{
			public String id;
			public String title;
			public String type;
			@Override
			public String toString()
			{
				return "NewsTabData [id=" + id + ", title=" + title + ", type="
						+ type + ", url=" + url + "]";
			}
			public String url;

		}
	}

}
