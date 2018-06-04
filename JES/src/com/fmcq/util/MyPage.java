package com.fmcq.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义的分页标签
 * @category 分页标签 创建时间：2015-1-28 7:00
 */
public class MyPage extends TagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4399345295789493556L;
	private String url = null;
    private int pageIndex;
    private int pageMax;
    private int count;//总记录数量    

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }

    public int getPageMax() {
        return this.pageMax;
    }


    @Override
    public int doStartTag() throws JspException {
        StringBuffer str = new StringBuffer();
        if (pageIndex == 1) {
            str.append("<ul class=\"page\"><li><span>共"+count+"条记录</span></li><li><span>首页</span></li><li><span>上一页</span></li>");
        } else {
            str.append("<ul class=\"page\"><li><span>共"+count+"条记录</span></li><li><a href='" + url + "page=1'>首页</a></li>"
                    + "<li><a href='" + url + "page=" + (pageIndex - 1) + "'>上一页</a></li>");
        }
        if (pageIndex / 6 < 1.0 || pageMax < 10) {
            for (int i = 1; i <= 9; i++) {
                if (i <= pageMax) {
                    if (pageIndex != i) {
                        str.append("<li><a href='" + url + "page=" + i + "'>[" + i + "]</a></li>");
                    } else {
                        str.append("<li class=\"active\"><span>[" + i + "]</span></li>");
                    }
                }
            }
        } else if (pageIndex / 6 >= 1.0 && pageMax >= 10) {
            int fri = 0;
            int max = 0;
            if (pageMax - pageIndex > 4) {
                fri = pageIndex - 4;
                max = pageIndex + 4;
            } else {
                fri = pageMax - 8;
                max = pageMax;
            }
            for (int i = fri; i <= max; i++) {
                if (i <= pageMax) {
                    if (pageIndex != i) {
                        str.append("<li><a href='" + url + "page=" + i + "'>[" + i + "]</a></li>");
                    } else {
                        str.append("<li class=\"active\"><span>[" + i + "]</span></li>");
                    }
                }
            }
        }
        if (pageIndex == pageMax || pageMax < 2) {
            str.append("<li><span>下一页</span></li><li><span>尾页</span></li>");
        } else {
            str.append("<li><a href='" + url + "page=" + (pageIndex + 1) + "'>下一页</a></li>"
                    + "<li><a href='" + url + "page=" + pageMax + "'>尾页</a></li>");
        }
        str.append("<li><lable>跳转至：<select onchange=\"location='"+url+"page='+this.value;\">");
        for(int i=1;i<=pageMax;i++){
        	str.append("<option value='"+i+"' "+(i==pageIndex?"selected":"")+">第"+i+"页</option>");
        }
        str.append("</select></lable></li></ul>");
        try {
            if (str.length()>0) {
                pageContext.getOut().write(new String(str));
            }
        } catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}