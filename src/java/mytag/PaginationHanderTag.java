/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author LongLD
 */
public class PaginationHanderTag extends SimpleTagSupport {

    private String uri;
    private int offset;
    private long totalRecord;
    private int maxResult;
    private String previous;
    private String next;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
     JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
             // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            
            out.write("<nav>");
            out.write("<ul class=\"pagination\"");
            if (offset < maxResult) {
                out.write(constructLink(1, previous, "disabled", true));
            } else {
                out.write(constructLink(offset - maxResult, previous, null, false));
            }
            for (int itr = 0; itr < totalRecord; itr += maxResult) {
                if (offset == itr) {
                    out.write(constructLink((itr / maxResult + 1) - 1 * maxResult, String.valueOf(itr /maxResult + 1), "active", true));
                } else {
                        out.write(constructLink(itr / maxResult * maxResult, String.valueOf(itr / 8 + 1),null, false));
                }
            }
            if (offset + maxResult >= totalRecord) {
                out.write(constructLink(offset + maxResult, next, "disabled", true));
            } else {
                out.write(constructLink(offset + maxResult, next, null, false));
            }
            out.write("</ul>");
            out.write("</nav>");
            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in PaginationHanderTag tag", ex);
        }
    }
    
    private String constructLink(int page, String text, String className, boolean disabled) {
        StringBuilder link = new StringBuilder("<li");
        if (className != null) {
            link.append(" class=\"");
            link.append(className);
            link.append("\"");
        }
        if (disabled) {
            link.append(">").append("<a href=\"#\">" + text + "</a></li>");
        } else {
            link.append(">").append("<a href=\"" + uri + "?offset=" + page + "\">" +text + "</a></li>");
        }
        return link.toString();
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
}
